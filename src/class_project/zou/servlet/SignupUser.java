package class_project.zou.servlet;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import class_project.zou.User;
import class_project.zou.UserSignupDao;

public class SignupUser implements ServletRequestAware {
	private User user;
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public String execute() {
		int userId;
		UserSignupDao userDao = new UserSignupDao();
		userId = userDao.signupUser(user);
		sendEmailToConfirm(user);
		return "home";
	}
	private void sendEmailToConfirm(User user) {
		// TODO Auto-generated method stub
		
	}
	
}
