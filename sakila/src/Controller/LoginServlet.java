package Controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import Vo.Staff;
import Vo.Stats;

import service.StaffService;
import service.StatsService;

@WebServlet({"/","/LoginServlet"})
public class LoginServlet extends HttpServlet {

	private StatsService statsService;
	private StaffService staffService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException { // loginForm
		System.out.println("ss");
		// Login - email , password
		// 세션넣고 if 문(return) -> 객체
		HttpSession session = request.getSession();
		if (session.getAttribute("loginStaff") != null) {
			response.sendRedirect(request.getContextPath() + "/auth/IndexServlet");
			return;
		}
		System.out.println("ss");

		// 오늘의 값
		statsService = new StatsService();
		Stats stats = statsService.getStats();
		request.setAttribute("stats", stats);
		System.out.println("ss");

		// total 생성
		statsService = new StatsService();
		int totalCount = statsService.gettotalCount();
		request.setAttribute("totalCount", totalCount);

		request.getRequestDispatcher("/WEB-INF/views/Login.jsp").forward(request, response); //포워딩
	}

	// 로그인 액션
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException { // loginAction
		

		System.out.println("Debug: LoginServlet doPost 실행");
		String email = request.getParameter("email");
		System.out.println(email+"성공");
		String password = request.getParameter("password");
		System.out.println(password+"성공");
		
		staffService = new StaffService();
		Staff staff = new Staff(); // 파라메터로 받아온 request -> email password
		
		staff.setEmail(email);
		staff.setPassword(password);
		
		
		Staff returnStaff = staffService.getStaffBYKey(staff);
		
		
		if ( returnStaff!= null) { // 로그인 성공 ----- 세션 담고 포워딩
			
			HttpSession session = request.getSession();
			session.setAttribute("loginStaff", returnStaff); //로그인 상태인지 아닌지 판단하기 위해
			request.getRequestDispatcher(request.getContextPath()+"/auth/IndexServlet");
			return;
		} 
			response.sendRedirect(request.getContextPath() + "/LogoutServlet");
		}
	}

