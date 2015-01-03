package class_project.zou.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import class_project.zou.javabean.Blog;
import class_project.zou.javabean.Category;
import class_project.zou.javabean.GetDelSession;
import class_project.zou.javabean.NewUser;

public class ManageBlogDao {
	public int addBlog(int userId, int categoryId, Blog blog){
		int i;
		try{
			System.out.println(categoryId);
			Session session = GetDelSession.getThreadLocalSession();
			Transaction transaction = session.beginTransaction();
			NewUser user = (NewUser) session.load(NewUser.class, userId);
			Category category = (Category) session.load(Category.class, categoryId);
			category.getBlog().add(blog);
			user.getBlog().add(blog);
			i = (Integer) session.save(user);
			i = (Integer) session.save(category);
			transaction.commit();
		}finally{
			GetDelSession.closeSession();
		}
		return i;
	}
}
