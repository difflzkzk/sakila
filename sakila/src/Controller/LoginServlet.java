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
		// 占쏙옙占실넣곤옙 if 占쏙옙(return) -> 占쏙옙체
		HttpSession session = request.getSession();
		if (session.getAttribute("loginStaff") != null) {
			response.sendRedirect(request.getContextPath() + "/auth/IndexServlet");
			return;
		}
		System.out.println("ss");

		// 占쏙옙占쏙옙占쏙옙 占쏙옙
		statsService = new StatsService();
		Map<String, Object> map = statsService.getStats();
		request.setAttribute("map",map);
		System.out.println("ss");

		// total 占쏙옙占쏙옙
		statsService = new StatsService();
		int totalCount = statsService.gettotalCount();
		request.setAttribute("totalCount", totalCount);

		request.getRequestDispatcher("/WEB-INF/views/Login.jsp").forward(request, response); //占쏙옙占쏙옙占쏙옙
	}

	// 占싸깍옙占쏙옙 占쌓쇽옙
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException { // loginAction
		

		System.out.println("Debug: LoginServlet doPost 占쏙옙占쏙옙");
		String email = request.getParameter("email");
		System.out.println(email+"占쏙옙占쏙옙");
		String password = request.getParameter("password");
		System.out.println(password+"占쏙옙占쏙옙");
		
		staffService = new StaffService();
		Staff staff = new Staff(); // 占식띰옙占쏙옙庫占� 占쌨아울옙 request -> email password
		
		staff.setEmail(email);
		staff.setPassword(password);
		
		
		Staff returnStaff = staffService.getStaffBYKey(staff);
		
		
		if ( returnStaff!= null) { // 占싸깍옙占쏙옙 占쏙옙占쏙옙 ----- 占쏙옙占쏙옙 占쏙옙占� 占쏙옙占쏙옙占쏙옙
			
			
			HttpSession session = request.getSession();
			session.setAttribute("loginStaff", returnStaff); //占싸깍옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙 占싣댐옙占쏙옙 占실댐옙占싹깍옙 占쏙옙占쏙옙
			
			request.getRequestDispatcher("/WEB-INF/views/auth/index.jsp").forward(request, response);;
			response.sendRedirect(request.getContextPath()+"/auth/IndexServlet");
		} else
			
			response.sendRedirect(request.getContextPath() + "/LoginServlet");
		}
	}

