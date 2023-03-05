package Spring.Security.model;

public class teacher {

	private Integer teacherId;
	private String teacherName;

	public teacher(Integer teacherId, String teacherName) {
		this.teacherId = teacherId;
		this.teacherName = teacherName;
	}

	public Integer getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	@Override
	public String toString() {
		return "teacher{" + "teacherId=" + teacherId + ", teacherName='" + teacherName + '\'' + '}';
	}

}
