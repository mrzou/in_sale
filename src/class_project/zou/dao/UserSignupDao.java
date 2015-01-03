package class_project.zou.dao;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import class_project.zou.javabean.GetDelSession;
import class_project.zou.javabean.NewUser;
import class_project.zou.javabean.User;

public class UserSignupDao {
	public int signupUser(User user){
		int i;
		try{
			Session session = GetDelSession.getThreadLocalSession();
			Transaction transaction = session.beginTransaction();
			i = (Integer) session.save(user);
			transaction.commit();
		}finally{
			GetDelSession.closeSession();
		}
		return i; 
	}
	public int ifExistUser(String column, String userName){
		Query exitUser;
		Session session = GetDelSession.getThreadLocalSession();
		String queryString = "FROM NewUser user where user."+column+"=?";
		exitUser = session.createQuery(queryString);
		@SuppressWarnings("unchecked")
		List<NewUser> user = exitUser.setParameter(0, userName).list();
		System.out.println(user.size());
		return user.size();
	}
	public static String updateUserSignup(int id){
		NewUser user;
		try{
			Session session = GetDelSession.getThreadLocalSession();
			Transaction transaction = session.beginTransaction();
			user = (NewUser) session.get(NewUser.class, id);
			user.setValidate(1);
			session.update(user);
			transaction.commit();
		}finally{
			GetDelSession.closeSession();
		}
		return user.getName(); 
	}
	public static NewUser checkLoginUser(String type, String value){
		Query exitUser;
		NewUser backUser;
		Session session = GetDelSession.getThreadLocalSession();
		String queryString = "FROM NewUser user where user."+type+"=?";
		exitUser = session.createQuery(queryString);
		@SuppressWarnings("unchecked")
		List<NewUser> allUser = exitUser.setParameter(0, value).list();
		if(allUser.size()==0){
			return null;
		}else{
			backUser = allUser.get(0);
			return backUser;
		}
	}
	public NewUser getCurrentUser(Integer user_id) {
		// TODO Auto-generated method stub
		NewUser user;
		try{
			Session session = GetDelSession.getThreadLocalSession();
			Transaction transaction = session.beginTransaction();
			user = (NewUser) session.get(NewUser.class, user_id);
			transaction.commit();
		}finally{
			GetDelSession.closeSession();
		}
		return user;
	}
	public static void updateUserPassword(int user_id, String password) {
		// TODO Auto-generated method stub
		User user;
		try{
			Session session = GetDelSession.getThreadLocalSession();
			Transaction transaction = session.beginTransaction();
			user = (User) session.get(User.class, user_id);
			user.setPassword(password);
			session.update(user);
			transaction.commit();
		}finally{
			GetDelSession.closeSession();
		}
	}
	
}
