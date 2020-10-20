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
		HttpSession session = request.getSession();  // ����� ���� ���ǵ� 
		if(session.getAttribute("loginStaff")!=null) { // loginStaff���
			response.sendRedirect(request.getContextPath()+"/auth/IndexServlet"); //�α����� �Ǿ����� index�� �����ش� 
			return; //�α��ν� ��
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
   