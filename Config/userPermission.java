package Spring.Security.Config;

@SuppressWarnings("all")
public enum userPermission {

	STUDENT_READ("student:read"),
	STUDENT_WRITE("student:write"),
	COURSE_READ("course:read"),
	COURSE_WRITE("course:write");

	private final String permission;

	private userPermission(String permission) {
		this.permission = permission;
	}

	public String getPermission() {
		return permission;
	}

}
