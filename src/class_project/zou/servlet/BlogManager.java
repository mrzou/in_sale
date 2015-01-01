package class_project.zou.servlet;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import class_project.zou.dao.ManageBlogDao;
import class_project.zou.javabean.Blog;

public class BlogManager implements ServletRequestAware{
	private Blog blog;
	
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		
	}
	public Blog getBlog() {
		return blog;
	}
	public void setBlog(Blog blog) {
		this.blog = blog;
	}
	
	public String addBlog(){
		ManageBlogDao manageBlog = new ManageBlogDao();
		int i = manageBlog.addBlog(blog);
		if(i>=0){
			return "blogList";
		}else{
			return "error";
		}
	}
}
