package class_project.zou.interceptor;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginSignupIntercepter extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("interceptor");
		HttpServletRequest request = (HttpServletRequest) invocation.getInvocationContext().get(ServletActionContext.HTTP_REQUEST);
		//HttpSession session = request.getSession();
		Cookie[] cookie = request.getCookies();
		String userId = null;
		if(cookie != null){
			for(int i=0; i<cookie.length; i++){
				if(cookie[i].getName().equals("userId")){
					userId = cookie[i].getValue();
				}
			}
		}
		if(userId != null){
			
		}
		return null;
	}

}
