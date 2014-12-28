package class_project.zou.servlet;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import class_project.zou.javabean.Blog;

public class BlogManager implements ServletRequestAware{
	private Blog blog;

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		
	}
	public String addBlog(){
		return "blogList";
	}
}
