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
	public int ifExistUser(String userName){
		Query exitUser;
		Session session = GetDelSession.getThreadLocalSession();
		String queryString = "FROM User user where user.name=?";
		exitUser = session.createQuery(queryString);
		@SuppressWarnings("unchecked")
		List<User> user = exitUser.setParameter(0, userName).list();
		System.out.println(user.size());
		return user.size();
	}
}
