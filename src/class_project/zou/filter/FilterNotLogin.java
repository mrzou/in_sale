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
		Cookie[] cook = newRequest.getCookies();
		String userId = null;
		if(cook!=null){
			for(int i=0;i<cook.length;i++){
				if(cook[i].getName().equals("userId")){
					userId = cook[i].getValue();
				}
			}
		}
		if(userId==null){
			if (request instanceof HttpServletRequest) {
				 String queryString = newRequest.getQueryString();
				 System.out.println(queryString);
			}
			request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
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
