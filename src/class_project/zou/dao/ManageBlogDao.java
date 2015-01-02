package class_project.zou.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import class_project.zou.javabean.Blog;
import class_project.zou.javabean.GetDelSession;
import class_project.zou.javabean.NewUser;

public class ManageBlogDao {
	public int addBlog(int userId, Blog blog){
		int i;
		try{
			Session session = GetDelSession.getThreadLocalSession();
			Transaction transaction = session.beginTransaction();
			NewUser user = (NewUser) session.load(NewUser.class, userId);
			user.getBlog().add(blog);
			i = (Integer) session.save(user);
			transaction.commit();
		}finally{
			GetDelSession.closeSession();
		}
		return i;
	}
}
