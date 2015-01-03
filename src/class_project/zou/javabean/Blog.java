package class_project.zou.javabean;

import java.sql.Date;

public class Blog {
	private int id;
	private String title;
	private String content;
	private Date recordTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRecordTime() {
		java.util.Date utilDate = new java.util.Date();
	    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		return sqlDate;
	}
	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}
}
