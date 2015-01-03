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
import class_project.zou.javabean.User;

public class ManageCategoryDao {
	public int addCategoryDao(int userId, Category category){
		int i;
		try{
			Session session = GetDelSession.getThreadLocalSession();
			Transaction transaction = session.beginTransaction();
			NewUser user = (NewUser) session.load(NewUser.class, userId);
			user.getCategory().add(category);
			i = (Integer) session.save(user);
			transaction.commit();
		}finally{
			GetDelSession.closeSession();
		}
		return i;
	}

	public String categoryIndex(int userId) {
		// TODO Auto-generated method stub
		Session session = GetDelSession.getThreadLocalSession();
		System.out.println(userId);
		NewUser user = (NewUser) session.load(NewUser.class, userId);
		if(user.getCategory()==null){
			return null;
		}
		Set<Category> allCategory = (Set<Category>) user.getCategory();
		return convertListToPageJson(allCategory);
	}
	public String convertListToPageJson(Set<Category> list){
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = null;
        for (Category obj : list) {
            jsonObject = new JSONObject();
            jsonObject.put("id", obj.getId());
            jsonObject.put("content", obj.getContent());
            jsonArray.add(jsonObject);
        }
        // 转换数据格式
        String json = jsonArray.toString();
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

	public void categoryDelete(int userId) {
		// TODO Auto-generated method stub
		int i;
		try{
			Session session = GetDelSession.getThreadLocalSession();
			Transaction transaction = session.beginTransaction();
			Category category = (Category) session.get(Category.class, userId);
			session.delete(category);
			transaction.commit();
		}finally{
			GetDelSession.closeSession();
		}
	}

	public String userIndex() {
		// TODO Auto-generated method stub
		Query exitUser;
		Session session = GetDelSession.getThreadLocalSession();
		String queryString = "FROM NewUser";
		exitUser = session.createQuery(queryString);
		@SuppressWarnings("unchecked")
		List<NewUser> allUser = exitUser.list();
		return convertToJson(allUser);
	}
	public String convertToJson(List<NewUser> allUser){
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = null;
        for (NewUser obj : allUser) {
            jsonObject = new JSONObject();
            jsonObject.put("id", obj.getId());
            jsonObject.put("name", obj.getName());
            jsonObject.put("email", obj.getEmail());
            jsonArray.add(jsonObject);
        }
        // 转换数据格式
        String json = jsonArray.toString();
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

	public void userDelete(int userId) {
		// TODO Auto-generated method stub
		int i;
		try{
			System.out.println("delete User");
			Session session = GetDelSession.getThreadLocalSession();
			Transaction transaction = session.beginTransaction();
			NewUser user = (NewUser) session.get(NewUser.class, userId);
			session.delete(user);
			transaction.commit();
		}finally{
			GetDelSession.closeSession();
		}
	}

	public String blogIndex(int userId) {
		Session session = GetDelSession.getThreadLocalSession();
		System.out.println(userId);
		NewUser user = (NewUser) session.load(NewUser.class, userId);
		if(user.getCategory()==null){
			return null;
		}
		Set<Blog> allBlog = (Set<Blog>) user.getBlog();
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
        // 转换数据格式
        String json = jsonArray.toString();
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
		// TODO Auto-generated method stub
		int i;
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

	public Blog showBlog(int blogId) {
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
		return blog;
	}
}
