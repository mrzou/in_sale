package class_project.zou.servlet;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import class_project.zou.User;
import class_project.zou.UserSignupDao;

public class SignupUser implements ServletRequestAware {
	private User user;
	private HttpServletRequest request;
	private HttpSession session;
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
		session = request.getSession();
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public String execute() {
		String checkCode_1 = (String) session.getAttribute("checkCode");
		String checkCode_2 = request.getParameter("check_code");
		System.out.println(checkCode_1+checkCode_2);
		if(checkCode_1.equals(checkCode_2)){
			UserSignupDao userDao = new UserSignupDao();
			userDao.signupUser(user);
			return "home";
		}else{
			return "home";
		}
	}
	
}
