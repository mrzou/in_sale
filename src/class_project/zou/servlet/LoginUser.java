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
import class_project.zou.dao.UserSignupDao;
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
	/*异步请求检查邮箱*/
	public void checkValidateEmail(){
		UserSignupDao userDao = new UserSignupDao();
		int ifExist = userDao.ifExistUser("email",request.getParameter("email"));
		try{
			PrintWriter out = response.getWriter();
			if(ifExist>=1 ){
				System.out.println("exist");
				out.print("exist");
			}else{
				System.out.println("unExist");
				out.print("unExist");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/*登陆的请求*/
	public String loginUser(){
		System.out.println(user.getEmail());
		NewUser newUser = UserSignupDao.checkLoginUser(user.getEmail());
		System.out.println(user.getPassword()+" "+newUser.getPassword());
		PrintWriter out = null;
		if(user.getPassword().equals(newUser.getPassword())){
			try {
				System.out.println("execute login");
				out = response.getWriter();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(newUser.getValidate()==0){
				return "mailNotConfirm";
			}else{
				System.out.println(request.getParameter("autoLogin"));
				if(request.getParameter("autoLogin")!=null){
					System.out.println("remember");
					Cookie cook = new Cookie("userId", String.valueOf(newUser.getId()));
					cook.setMaxAge(60*2);
					response.addCookie(cook);
					session.setAttribute("userId", newUser.getName());
				}
				session.setAttribute("userId", newUser.getName());
				out.print(user.getName());
				if(request.getParameter("location")!=""){
					return request.getParameter("location");
				}else{
					return "home";
				}
			}
		}else{
			return "failLogin";
		}
	}
	public void userLogout(){
		System.out.println("delete cookie");
		session.setAttribute("userId", null);
		Cookie cookie = new Cookie("userId", null);
		cookie.setMaxAge(0);
		response.addCookie(cookie);
	}
}
