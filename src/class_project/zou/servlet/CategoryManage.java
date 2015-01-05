package class_project.zou.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import class_project.zou.dao.CategoryDao;
import class_project.zou.dao.UserDao;
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
		CategoryDao manageCate = new CategoryDao();
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
		CategoryDao manageCate = new CategoryDao();
		System.out.println(userId);
		@SuppressWarnings("unchecked")
		String categoryJson = manageCate.categoryIndex(userId);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		if(categoryJson==null){
			out.print("null");
		}else{
			out.write(categoryJson);
		}
	}
	public void deleteCategory() throws IOException{
		System.out.println("execute modifyCategory");
		int userId = Integer.valueOf(request.getParameter("id"));
		CategoryDao manageCate = new CategoryDao();
		PrintWriter out = response.getWriter();
		try{
			manageCate.categoryDelete(userId);
			out.print("success");
		}catch(Exception e){
			out.print("error");
		}
	}
	public void userIndex() throws IOException{
		System.out.println("execute indexuser");
		UserDao userDao = new UserDao();
		@SuppressWarnings("unchecked")
		String categoryJson = userDao.userIndex();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		if(categoryJson==null){
			out.print("null");
		}else{
			out.write(categoryJson);
		}
	}
	public void userDelete() throws IOException{
		System.out.println("execute modifyCategory");
		int userId = Integer.valueOf(request.getParameter("id"));
		UserDao userDao = new UserDao();
		PrintWriter out = response.getWriter();
		try{
			userDao.userDelete(userId);
			out.print("success");
		}catch(Exception e){
			out.print("error");
		}
	}
}
