package class_project.zou;

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
}
