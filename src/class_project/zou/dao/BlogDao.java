package class_project.zou.dao;

import java.util.List;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import class_project.zou.javabean.Blog;
import class_project.zou.javabean.Category;
import class_project.zou.javabean.GetDelSession;
import class_project.zou.javabean.NewUser;

public class BlogDao {
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
			session.save(category);
			i = (Integer) session.save(user);
			System.out.println("blogId  "+i);
			transaction.commit();
		}finally{
			GetDelSession.closeSession();
		}
		return i;
	}
	public String blogIndex(int userId) {
		Session session = GetDelSession.getThreadLocalSession();
		System.out.println(userId);
		NewUser user = (NewUser) session.get(NewUser.class, userId);
		if(user.getCategory()==null){
			return null;
		}
		Set<Blog> allBlog = (Set<Blog>) user.getBlog();
		System.out.println(allBlog.size());
		return BlogConvertToJson(allBlog);
	}
	public String BlogConvertToJson(Set<Blog> allBlog){
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = null;
        for (Blog obj : allBlog) {
            jsonObject = new JSONObject();
            jsonObject.put("id", obj.getId());
            jsonObject.put("title", obj.getTitle());
            jsonObject.put("time", obj.getRecordTime().toString());
            jsonArray.add(jsonObject);
        }
        jsonArray.toString();
        // 拼接字符串
        JSONObject jn = new JSONObject();
        try {
            jn.put("records", jsonArray);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return jn.toString();
	}

	public void blogDelete(int blogId) {
		try{
			Session session = GetDelSession.getThreadLocalSession();
			Transaction transaction = session.beginTransaction();
			Blog blog = (Blog) session.get(Blog.class, blogId);
			session.delete(blog);
			transaction.commit();
		}finally{
			GetDelSession.closeSession();
		}
	}

	public String showBlog(int blogId) {
		// TODO Auto-generated method stub
		Blog blog=null;
		try{
			Session session = GetDelSession.getThreadLocalSession();
			Transaction transaction = session.beginTransaction();
			blog = (Blog) session.get(Blog.class, blogId);
			transaction.commit();
		}finally{
			GetDelSession.closeSession();
		}
		return convertOneBlogToJson(blog);
	}
	private String convertOneBlogToJson(Blog blog) {
		// TODO Auto-generated method stub
        JSONObject jsonObject = null;
        jsonObject = new JSONObject();
        jsonObject.put("title", blog.getTitle());
        jsonObject.put("content", blog.getContent());
        return jsonObject.toString();
	}
	public String blogIndexAll() {
		Query exitBlog;
		Session session = GetDelSession.getThreadLocalSession();
		String queryString = "FROM Blog";
		exitBlog = session.createQuery(queryString);
		@SuppressWarnings("unchecked")
		List<Blog> allBlog = exitBlog.list();
		return convertAllBlogToJson(allBlog);
	}
	private String convertAllBlogToJson(List<Blog> allBlog) {
		// TODO Auto-generated method stub
		JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = null;
        String content = null;
        for (Blog obj : allBlog) {
        	content = (String) (obj.getContent().length()<150? obj.getContent():obj.getContent().subSequence(0, 150));
            jsonObject = new JSONObject();
            jsonObject.put("id", obj.getId());
            jsonObject.put("title", obj.getTitle());
            jsonObject.put("content", content);
            jsonObject.put("time", obj.getRecordTime().toString());
            jsonArray.add(jsonObject);
        }
        jsonArray.toString();
        // 拼接字符串
        JSONObject jn = new JSONObject();
        try {
            jn.put("records", jsonArray);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return jn.toString();
	}
}
