package class_project.zou.javabean;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;

import sun.misc.BASE64Encoder;

public class User {
	private int id;
	private String name;
	private String email;
	private String password;
	private Date recordTime;
	private int validate=0;
	public String validateCode;
	
	public Date getRecordTime() {
		java.util.Date utilDate = new java.util.Date();
	    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		return sqlDate;
	}
	public void setRecordTime(Date recordTime) {
		java.util.Date utilDate = new java.util.Date();
	    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		this.recordTime = sqlDate;
	}
	public String getValidateCode() {
		System.out.println(validateCode+"hellolllllllll");
		return this.validateCode==null? md5SetPassword(String.valueOf(Math.random())):this.validateCode;
	}
	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = md5SetPassword(password);
	}
	public int getValidate() {
		return this.validate;
	}
	public void setValidate(int validate) {
		this.validate = validate;
	}
	public String md5SetPassword(String password){
		byte[] oldPassword = password.getBytes();
		MessageDigest messDigest;
		try{
			messDigest = MessageDigest.getInstance("MD5");
			byte[] newBytes = messDigest.digest(oldPassword);
			BASE64Encoder encoder = new BASE64Encoder();
			String newStr = encoder.encode(newBytes);
			return newStr;
		}catch(NoSuchAlgorithmException e){
			return null;
		}
	}
	public static void updateValidate(String userId) {
		// TODO Auto-generated method stub
		
	}
}
