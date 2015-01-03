package class_project.zou.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import class_project.zou.dao.ManageBlogDao;
import class_project.zou.dao.ManageCategoryDao;
import class_project.zou.javabean.Blog;

public class BlogManager implements ServletRequestAware{
	private HttpServletRequest request;
	private HttpSession session;
	private HttpServletResponse response;
	
	private Blog blog;
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
		this.session = request.getSession();
		this.response = ServletActionContext.getResponse();
	}
	public Blog getBlog() {
		return blog;
	}
	public void setBlog(Blog blog) {
		this.blog = blog;
	}
	
	public String addBlog() throws IOException{
		System.out.println("execute addBlog");
		int userId = (Integer) session.getAttribute("user_id");
		int category = Integer.valueOf(request.getParameter("category"));
		ManageBlogDao manageblog = new ManageBlogDao();
		int i = manageblog.addBlog(userId, category, blog);
		PrintWriter out = response.getWriter();
		if(i<0){
			return "error";
		}else{
			return "blogIndex";
		}
	}
	public void blogIndex() throws IOException{
		System.out.println("execute indexuser");
		ManageCategoryDao manageCate = new ManageCategoryDao();
		int userId = (Integer) session.getAttribute("user_id");
		@SuppressWarnings("unchecked")
		String categoryJson = manageCate.blogIndex(userId);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		if(categoryJson==null){
			out.print("null");
		}else{
			out.write(categoryJson);
			out.flush();  
	        out.close();
		}
	}
	public void blogDelete() throws IOException{
		System.out.println("execute deleteBlog");
		int blogId = Integer.valueOf(request.getParameter("id"));
		ManageCategoryDao manageCate = new ManageCategoryDao();
		PrintWriter out = response.getWriter();
		try{
			manageCate.blogDelete(blogId);
			out.print("success");
		}catch(Exception e){
			out.print("error");
		}
	}
	public void showBlog() throws IOException{
		System.out.println("execute showblog");
		int blogId = Integer.valueOf(request.getParameter("id"));
		ManageCategoryDao manageCate = new ManageCategoryDao();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try{
			Blog blog = manageCate.showBlog(blogId);
			System.out.println(blog.getContent());
			out.print(blog.getContent());
		}catch(Exception e){
			out.print("error");
		}
	}
}
