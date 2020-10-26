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
		// ���ǳְ� if ��(return) -> ��ü
		HttpSession session = request.getSession();
		if (session.getAttribute("loginStaff") != null) {
			response.sendRedirect(request.getContextPath() + "/auth/IndexServlet");
			return;
		}
		System.out.println("ss");

		// ������ ��
		statsService = new StatsService();
		Map<String, Object> map = statsService.getStats();
		request.setAttribute("map",map);
		System.out.println("ss");

		// total ����
		statsService = new StatsService();
		int totalCount = statsService.gettotalCount();
		request.setAttribute("totalCount", totalCount);

		request.getRequestDispatcher("/WEB-INF/views/Login.jsp").forward(request, response); //������
	}

	// �α��� �׼�
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException { // loginAction
		

		System.out.println("Debug: LoginServlet doPost ����");
		String email = request.getParameter("email");
		System.out.println(email+"����");
		String password = request.getParameter("password");
		System.out.println(password+"����");
		
		staffService = new StaffService();
		Staff staff = new Staff(); // �Ķ���ͷ� �޾ƿ� request -> email password
		
		staff.setEmail(email);
		staff.setPassword(password);
		
		
		Staff returnStaff = staffService.getStaffBYKey(staff);
		
		
		if ( returnStaff!= null) { // �α��� ���� ----- ���� ��� ������
			
			
			HttpSession session = request.getSession();
			session.setAttribute("loginStaff", returnStaff); //�α��� �������� �ƴ��� �Ǵ��ϱ� ����
			
			request.getRequestDispatcher("/WEB-INF/views/auth/index.jsp").forward(request, response);;
			response.sendRedirect(request.getContextPath()+"/auth/IndexServlet");
		} else
			
			response.sendRedirect(request.getContextPath() + "/LoginServlet");
		}
	}

