package class_project.zou.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

public class SignupValidate implements ServletRequestAware{
	private HttpServletRequest request;
	private HttpSession session;
	private ServletContext application;
	private HttpServletResponse response;
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
		this.session = request.getSession();
		this.application = request.getServletContext();
		this.response = ServletActionContext.getResponse();
	}
	public void execute(){
		response.setContentType("image/jpeg");
		HttpSession session = request.getSession();
		int width = 60;
		int height = 30;
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		
		String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char[] rands = new char[4];
		for(int i = 0; i<4; i++){
			int rand = (int)(Math.random()*36);
			rands[i] = chars.charAt(rand);
		}
		
		g.setColor(new Color(0xDCDCDC));
		g.fillRect(0, 0, width, height);
		
		for(int i=0; i<120; i++){
			int x = (int)(Math.random()*width);
			int y = (int)(Math.random()*height);
			int red = (int)(Math.random()*255);
			int green = (int)(Math.random()*255);
			int blue = (int)(Math.random()*255);
			g.setColor(new Color(red, green, blue));
			g.drawOval(x, y, 1, 0);
		}
		g.setColor(Color.BLACK);
		g.setFont(new Font(null, Font.ITALIC|Font.BOLD, 18));
		g.drawString(""+rands[0], 1, 17);
		g.drawString(""+rands[1], 16, 15);
		g.drawString(""+rands[2], 31, 18);
		g.drawString(""+rands[3], 46, 16);
		g.dispose();
		try{
			ServletOutputStream sos = response.getOutputStream();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(image, "JPEG", baos);
			byte[] buffer = baos.toByteArray();
			response.setContentLength(buffer.length);
			sos.write(buffer);
			baos.close();
			sos.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		session.setAttribute("checkCode", new String(rands));
	}
	public void getValidateCode(){
		try {
			PrintWriter out = response.getWriter();
			out.print((String)(session.getAttribute("checkCode")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*检查cookie中的用户是否存在*/
	public void checkCookie(){
		String userId = null;
		Cookie[] cook = request.getCookies();
		if(cook!=null){
			for(int i=0;i<cook.length;i++){
				if(cook[i].getName().equals("userId")){
					userId = cook[i].getValue();
				}
			}
		}
		try {
			PrintWriter ifExist = response.getWriter();
			if(userId == null){
				ifExist.print("notExist");
			}else{
				ifExist.print("exist");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
