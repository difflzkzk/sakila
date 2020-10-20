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
			response.sendRedirect(request.getContextPath()+"/auth/IndexServlet"); //보내준다 일로   -> auth 붙이는 이유 구분하기 위해서 -> 로그인이 되어있을때만 들어올수 있게끔
			return;
		}
		
		
		request.getRequestDispatcher("/WEB-INF/views/Login.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  //loginAcion
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
