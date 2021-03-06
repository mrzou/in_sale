package class_project.zou.javabean;

import java.util.Set;

public class NewUser {
	private int id;
	private String name;
	private String email;
	private String password;
	private String validateCode;
	private int validate=0;
	private Set<Category> category;
	private Set<Blog> blog;
	
	public Set<Blog> getBlog() {
		return blog;
	}
	public void setBlog(Set<Blog> blog) {
		this.blog = blog;
	}
	public Set<Category> getCategory() {
		return category;
	}
	public void setCategory(Set<Category> category) {
		this.category = category;
	}
	public int getValidate() {
		return validate;
	}
	public void setValidate(int validate) {
		this.validate = validate;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getValidateCode() {
		return validateCode;
	}
	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}
}
