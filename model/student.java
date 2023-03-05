package Spring.Security.model;

public class student {

	private Integer stuId;
	private String stuName;
	private String dept;

	public Integer getStuId() {
		return stuId;
	}

	public void setStuId(Integer stuId) {
		this.stuId = stuId;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "student [stuId=" + stuId + ", stuName=" + stuName + ", dept=" + dept + "]";
	}

	public student(Integer stuId, String stuName, String dept) {
		super();
		this.stuId = stuId;
		this.stuName = stuName;
		this.dept = dept;
	}

}
