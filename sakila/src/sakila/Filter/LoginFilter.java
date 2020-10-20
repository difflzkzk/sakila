package sakila.Filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter("/auth/*") // 로 시작하는걸 가로챔  (2번 작동함)
public class LoginFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {  //로그인 폴더가있는 위치만 올려주면 됨  ->로그인 -> /auth
		System.out.println("LoginFilter 실행 :session 검사");
		HttpSession session = ((HttpServletRequest)request).getSession(); //자식으로 형변환 시킴    --> 세션 객체를 받아온다
		if(session.getAttribute("loginStaff")== null) {
			System.out.println("로그인 후 접근");
		((HttpServletResponse)response).sendRedirect(request.getServletContext().getContextPath()+"/LoginServlet");
			return;
		}
		chain.doFilter(request, response);
	}

	public LoginFilter() {};
	public void destroy() {};
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
