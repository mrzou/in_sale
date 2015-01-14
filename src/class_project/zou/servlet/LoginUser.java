package class_project.zou.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import class_project.zou.javabean.NewUser;
import class_project.zou.javabean.User;
import class_project.zou.dao.UserDao;
public class LoginUser implements ServletRequestAware{
	private User user;
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	private HttpServletRequest request;
	private HttpServletResponse response;
	private HttpSession session;
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
		this.session = request.getSession();
		this.response = ServletActionContext.getResponse();
	}
	/*登陆的请求*/
	public void winLoginUser() throws IOException{
		NewUser newUser = UserDao.checkLoginUser("email", user.getEmail());
		PrintWriter out = response.getWriter();
		if(user.getPassword().equals(newUser.getPassword())){
			if(newUser.getValidate()==0){
				out.print("mailNotConfrim");
			}else{
				if(request.getParameter("autoLogin").equals("true")){
					Cookie cook1 = new Cookie("userId", String.valueOf(newUser.getName()));
					Cookie cook2 = new Cookie("user_id", String.valueOf(newUser.getId()));
					cook1.setMaxAge(60*60*24);
					cook2.setMaxAge(60*60*24);
					response.addCookie(cook1);
					response.addCookie(cook2);
				}
				session.setAttribute("userId", newUser.getName());
				session.setAttribute("user_id", newUser.getId());
				out.print(request.getParameter("location"));
			}
		}else{
			out.print("error");
		}
	}
	/*用户退出登陆*/
	public void userLogout(){
		session.setAttribute("userId", null);
		session.setAttribute("user_id", null);
		Cookie cookie1 = new Cookie("userId", null);
		Cookie cookie2 = new Cookie("user_id", null);
		cookie1.setMaxAge(0);
		cookie2.setMaxAge(0);
		response.addCookie(cookie1);
		response.addCookie(cookie2);
	}
	/*用户修改密码*/
	public void modifyPassword() throws IOException{
		int user_id = (Integer)(session.getAttribute("user_id"));
		UserDao userDao = new UserDao();
		NewUser newUser = userDao.getCurrentUser(user_id);
		PrintWriter out = response.getWriter();
		if(newUser!=null && newUser.getPassword().equals(user.getPassword())){
			user.setPassword(request.getParameter("new_password"));
			if(user.getPassword().equals(newUser.getPassword())){
				out.print("same");
			}else{
				UserDao.updateUserPassword(user_id, request.getParameter("new_password"));
				out.print("success");
			}
		}else{
			out.print("error");
		}
	}
}
