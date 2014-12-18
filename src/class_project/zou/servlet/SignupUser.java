package class_project.zou.servlet;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import class_project.zou.User;

public class SignupUser implements ServletRequestAware {
	private User user;
	
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public String execute() {
		Configuration configurate = new Configuration();
		configurate.configure();
		
		SessionFactory sessionfact = configurate.buildSessionFactory();
		Session session = sessionfact.openSession();
		
		Transaction transaction = session.beginTransaction();
		transaction.commit();
		return "home";
	}
}
