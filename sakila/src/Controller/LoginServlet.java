package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Vo.Stats;
import service.StatsService;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	private StatsService statsService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  //loginForm
		// Login - email , password
		HttpSession session = request.getSession();  // 사용자 값이 세션됨 
		if(session.getAttribute("loginStaff")!=null) { // loginStaff라는
			response.sendRedirect(request.getContextPath()+"/auth/IndexServlet"); //로그인이 되었을때 index로 보내준다 
			return; //로그인시 끝
		}
		
		statsService = new StatsService(); 
		Stats stats = statsService.getStats(); //Map<String,Object>map=statsService.getStats();
		request.setAttribute("stats", stats); //("stats",(Stats)(map.get("stats"))); -->
		
		int totalCount = statsService.totalCount();
		request.setAttribute("totalCount",totalCount);
		
		request.getRequestDispatcher("/WEB-INF/views/Login.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  //loginAcion
		
	}

}
   