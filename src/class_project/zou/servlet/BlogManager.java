package class_project.zou.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import class_project.zou.dao.BlogDao;
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
		int category = Integer.valueOf(request.getParameter("category"));
		BlogDao manageblog = new BlogDao();
		System.out.println(blog.getContent());
		int i = manageblog.addBlog(userId, category, blog);
		PrintWriter out = response.getWriter();
		if(i<0){
			out.print("error");
		}else{
			out.print("success");
		}
	}
	public void blogIndexAll() throws IOException{
		System.out.println("execute indexallblog");
		BlogDao blogDao = new BlogDao();
		String categoryJson = blogDao.blogIndexAll();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		if(categoryJson==null){
			out.print("null");
		}else{
			out.write(categoryJson);
		}
	}
	public void blogIndex() throws IOException{
		System.out.println("execute indexuser");
		BlogDao blogDao = new BlogDao();
		int userId = (Integer) session.getAttribute("user_id");
		String categoryJson = blogDao.blogIndex(userId);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		if(categoryJson==null){
			out.print("null");
		}else{
			out.write(categoryJson);
		}
	}
	public void blogDelete() throws IOException{
		System.out.println("execute deleteBlog");
		int blogId = Integer.valueOf(request.getParameter("id"));
		BlogDao blogDao = new BlogDao();
		PrintWriter out = response.getWriter();
		try{
			blogDao.blogDelete(blogId);
			out.print("success");
		}catch(Exception e){
			out.print("error");
		}
	}
	public void showBlog() throws IOException{
		System.out.println("execute showblog");
		int blogId = Integer.valueOf(request.getParameter("id"));
		System.out.println("blogId"+blogId);
		BlogDao blogDao = new BlogDao();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try{
			Blog blog = blogDao.showBlog(blogId);
			out.print(blog.getContent());
		}catch(Exception e){
			out.print(e);
		}
	}
}
