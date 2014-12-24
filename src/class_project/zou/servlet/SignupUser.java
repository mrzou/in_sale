package class_project.zou.servlet;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import class_project.zou.javabean.User;
import class_project.zou.dao.UserSignupDao;

public class SignupUser implements ServletRequestAware {
	private User user;
	private HttpServletResponse response;
	private HttpServletRequest request;
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.response = ServletActionContext.getResponse();
		this.request = request;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public String execute() {
		int userId;
		UserSignupDao userDao = new UserSignupDao();
		userId = userDao.signupUser(user);
		sendEmailToConfirm(user);
		return "home";
	}

	public void sendEmailToConfirm(User user) {
		// TODO Auto-generated method stub
		try{
			Properties props=new Properties();
			//传递一个邮件服务器名smtp.163.com
			//mail.smtp.host代表是发信人所在的邮箱服务器名
			props.put("mail.smtp.host", "smtp.163.com");
			props.put("mail.smtp.auth", true);
			//对于发送邮件，只需要保证发送人所在的邮件服务器正确打开就可以了
                            
			//创建一个程序与邮件服务器的通信
			Session mailConnection=Session.getInstance(props,null);
			Message msg=new MimeMessage(mailConnection);
           
			//加密生成一个验证码
			String validateCode = user.validateCode.replace("+", "%2B");
			//设置发送人和接受人
			Address sender=new InternetAddress("15018633076@163.com");
			Address receiver=new InternetAddress(user.getEmail());
                            
			msg.setFrom(sender);
			msg.setRecipient(Message.RecipientType.TO, receiver);
			msg.setSubject("欢迎注册zz_blog");
                            
			//msg.setContent("Hello", "text/plain");
                            
                            
			//下面是模拟发送带附件的邮件
			//新建一个MimeMultipart对象用来存放多个BodyPart对象
			Multipart mtp=new MimeMultipart();
			//------设置信件文本内容------
			//新建一个存放信件内容的BodyPart对象
			BodyPart mdp=new MimeBodyPart();
			//给BodyPart对象设置内容和格式/编码方式
			mdp.setContent("hello","text/html;charset=gb2312");
			String mailContent = "亲爱的"+user.getName()+"用户"
	                + ",您好！感谢您注册zou_blog,请确认您的邮箱帐号为"
	                + user.getEmail()
	                + "请点击下面的链接即可完成激活。\n"
	                + "http://localhost:8080/class_project/confirm_email?id="+user.getId()+"&action="+validateCode+"\n"
	                + "如果链接无法点击，请将它拷贝到浏览器的地址栏中"
	                + "http://localhost:8080/class_project/confirm_email?id="+user.getId()+"&action="+validateCode+"\n\n此为自动发送邮件，请勿直接回复";
			mdp.setText(mailContent);
			//将含有信件内容的BodyPart加入到MimeMultipart对象中
			mtp.addBodyPart(mdp);
			
			//把mtp作为消息对象的内容
			msg.setContent(mtp);
                            
			//先进行存储邮件
			msg.saveChanges();
                            
			Transport trans=mailConnection.getTransport("smtp");
			String username="15018633076@163.com";
			String pw="zou13232670012";
			//邮件服务器名,用户名，密码
			trans.connect("smtp.163.com", username,  pw);
			trans.sendMessage(msg, msg.getAllRecipients());
			trans.close();
		}catch(Exception e){
			e.getStackTrace();
		}
	}
	/*检查名字和邮箱的唯一性*/
	public void validateUniqueName(){
		UserSignupDao userDao = new UserSignupDao();
		int ifExist = userDao.ifExistUser(request.getParameter("type"), request.getParameter("name"));
		try{
			PrintWriter out = response.getWriter();
			if(ifExist>=1 ){
				System.out.println("exist");
				out.print("exist");
			}else{
				System.out.println("notexist");
				out.print("notExit");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/*确认用户注册的邮箱*/
	public String confirmEmail(){
		String validateEmail = request.getParameter("action");
		UserSignupDao userDao = new UserSignupDao();
		int ifExist = userDao.ifExistUser("validateCode", validateEmail);
		if(ifExist<=0){
			return "error";
		}else{
			UserSignupDao.updateUserSignup(Integer.parseInt(request.getParameter("id")));
			return "home";
		}
	}
}
