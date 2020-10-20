package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Vo.Stats;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  //loginForm
		// Login - email , password
		HttpSession session = request.getSession();
		if(session.getAttribute("loginStaff")!=null) {
			response.sendRedirect(request.getContextPath()+"/auth/IndexServlet"); //�����ش� �Ϸ�   -> auth ���̴� ���� �����ϱ� ���ؼ� -> �α����� �Ǿ��������� ���ü� �ְԲ�
			return;
		}
		
		
		request.getRequestDispatcher("/WEB-INF/views/Login.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  //loginAcion
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
