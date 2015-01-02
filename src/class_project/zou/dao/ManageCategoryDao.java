package class_project.zou.dao;

import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import class_project.zou.javabean.Category;
import class_project.zou.javabean.GetDelSession;
import class_project.zou.javabean.NewUser;

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
}
