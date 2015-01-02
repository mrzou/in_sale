package class_project.zou.javabean;

public class Category {
	private int id;
	private String content;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public boolean equals(Object obj) {
	      if (obj == null) return false;
	      if (!this.getClass().equals(obj.getClass())) return false;

	      Category obj2 = (Category)obj;
	      if((this.id == obj2.getId()) && (this.content.equals(obj2.getContent())))
	      {
	         return true;
	      }
	      return false;
	   }
	   public int hashCode() {
	      int tmp = 0;
	      tmp = ( id + content ).hashCode();
	      return tmp;
	   }
}
