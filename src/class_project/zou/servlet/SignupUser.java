package class_project.zou.servlet;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import class_project.zou.User;

public class SignupUser implements ServletRequestAware {
	private User user;

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		
	}
	public String execute() {
		
		return "home";
	}
}
