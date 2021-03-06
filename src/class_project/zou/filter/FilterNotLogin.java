package class_project.zou.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class FilterNotLogin
 */
@WebFilter("/FilterNotLogin")
public class FilterNotLogin implements Filter {

    /**
     * Default constructor. 
     */
    public FilterNotLogin() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest newRequest=(HttpServletRequest)request;
		HttpServletResponse newResponse=(HttpServletResponse)response;
		HttpSession session = newRequest.getSession();
		Cookie[] cook = newRequest.getCookies();
		String userId = null;
		userId = session.getAttribute("userId")==null? "":String.valueOf(session.getAttribute("userId"));
		System.out.println("execute filter"+userId);
		if(cook!=null && userId.equals("")){
			for(int i=0;i<cook.length;i++){
				if(cook[i].getName().equals("userId")){
					userId = cook[i].getValue();
					session.setAttribute("userId", userId);
				}
				if(cook[i].getName().equals("user_id")){
					session.setAttribute("user_id", cook[i].getValue());
				}
			}
		}
		if(userId==""){
			if (request instanceof HttpServletRequest) {
				 String queryString = newRequest.getQueryString();
				 System.out.println(queryString);
			}
			System.out.println("run to login");
			request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
		}
		if(newRequest.getRequestURI().equals("/class_project/navFolder/manageUser.jsp") && !userId.equals("admin")){
			newResponse.setCharacterEncoding("utf-8");
			newResponse.sendRedirect("/class_project/jsp/error.jsp?message=withoutPermit");
		}
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
