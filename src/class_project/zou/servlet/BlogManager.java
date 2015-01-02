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
	
	public void addBlog() throws IOException{
		System.out.println("execute addBlog");
		int userId = (Integer) session.getAttribute("user_id");
		ManageBlogDao manageblog = new ManageBlogDao();
		int i = manageblog.addBlog(userId, blog);
		PrintWriter out = response.getWriter();
		if(i<0){
			out.print("error");
		}else{
			out.print("success");
		}
	}
}
