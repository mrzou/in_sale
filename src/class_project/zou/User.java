package class_project.zou;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class User {
	private int id;
	private String name;
	private String password;
	private Boolean validate = false;
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
	/**
	 * @return the validate
	 */
	public Boolean getValidate() {
		return validate;
	}
	/**
	 * @param validate the validate to set
	 */
	public void setValidate(Boolean validate) {
		this.validate = validate;
	}
}
