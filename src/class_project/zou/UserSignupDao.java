package class_project.zou;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
		String queryString = "FROM User user where user."+column+"=?";
		exitUser = session.createQuery(queryString);
		@SuppressWarnings("unchecked")
		List<User> user = exitUser.setParameter(0, userName).list();
		return user.size();
	}
	public static void updateUserSignup(int id){
		try{
			Session session = GetDelSession.getThreadLocalSession();
			Transaction transaction = session.beginTransaction();
			User user = (User) session.get(User.class, id);
			user.setValidate(1);
			session.save(user);
			transaction.commit();
		}finally{
			GetDelSession.closeSession();
		}
	}
}
