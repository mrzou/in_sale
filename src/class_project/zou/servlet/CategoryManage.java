package class_project.zou.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import class_project.zou.dao.ManageCategoryDao;
import class_project.zou.javabean.Category;

public class CategoryManage implements ServletRequestAware {
	
	private HttpServletRequest request;
	private HttpSession session;
	private HttpServletResponse response;
	
	private Category category;
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
		this.session = request.getSession();
		this.response = ServletActionContext.getResponse();
	}
	
	public void addCategory() throws IOException{
		System.out.println("execute addCategory");
		int userId = (Integer) session.getAttribute("user_id");
		ManageCategoryDao manageCate = new ManageCategoryDao();
		int i = manageCate.addCategoryDao(userId, category);
		PrintWriter out = response.getWriter();
		if(i<0){
			out.print("error");
		}else{
			out.print("success");
		}
	}
	public void categoryIndex() throws IOException{
		System.out.println("execute indexCategory");
		int userId = (Integer) session.getAttribute("user_id");
		ManageCategoryDao manageCate = new ManageCategoryDao();
		@SuppressWarnings("unchecked")
		String categoryJson = manageCate.categoryIndex(userId);
		PrintWriter out = response.getWriter();
		if(categoryJson==null){
			out.print("null");
		}else{
			out.write(categoryJson);
			out.flush();  
	        out.close();
		}
	}
	public void modifyCategory() throws IOException{
		
	}
	public void deleteCategory() throws IOException{
		System.out.println("execute modifyCategory");
		int userId = Integer.valueOf(request.getParameter("id"));
		ManageCategoryDao manageCate = new ManageCategoryDao();
		PrintWriter out = response.getWriter();
		try{
			manageCate.categoryDelete(userId);
			out.print("success");
		}catch(Exception e){
			out.print("error");
		}
	}
}
