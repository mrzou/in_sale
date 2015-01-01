package class_project.zou.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import class_project.zou.javabean.Blog;
import class_project.zou.javabean.GetDelSession;

public class ManageBlogDao {
	public int addBlog(Blog blog){
		int i;
		try{
			Session session = GetDelSession.getThreadLocalSession();
			System.out.println(blog.getTitle());
			Transaction transaction = session.beginTransaction();
			i = (Integer) session.save(blog);
			transaction.commit();
		}finally{
			GetDelSession.closeSession();
		}
		return i; 
	}
}
