package class_project.zou.servlet;

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
		NewUser newUser = UserSignupDao.checkLoginUser(user.getEmail());
		System.out.println(user.getPassword()+" "+newUser.getPassword());
		if(user.getPassword().equals(newUser.getPassword())){
			if(newUser.getValidate()==0){
				return "mailNotConfirm";
			}else{
				rememberUser(String.valueOf(newUser.getId()));
				session.setAttribute("userId", newUser.getId());
				return "home";
			}
		}else{
			return "failLogin";
		}
	}
	public void rememberUser(String userId){
		Cookie cook = new Cookie("userId", userId);
		cook.setMaxAge(59);
		response.addCookie(cook);
	}
}
