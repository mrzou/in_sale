package class_project.zou;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserSignupDao {
	public void signupUser(User user){
		try{
			Session session = GetDelSession.getThreadLocalSession();
			Transaction transaction = session.beginTransaction();
			session.save(user);
			transaction.commit();
		}finally{
			GetDelSession.closeSession();
		}
	}
}
