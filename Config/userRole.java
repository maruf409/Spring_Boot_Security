package Spring.Security.Config;

import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import com.google.common.collect.Sets;

public enum userRole {

	STUDENT(Sets.newHashSet()),

	ADMIN(Sets.newHashSet(userPermission.COURSE_READ, userPermission.COURSE_WRITE, userPermission.STUDENT_READ,
			userPermission.STUDENT_WRITE)),

	SUBADMIN(Sets.newHashSet(userPermission.COURSE_READ, userPermission.STUDENT_READ));

	private final Set<userPermission> permission;

	private userRole(Set<userPermission> permission) {
		this.permission = permission;
	}

	public Set<userPermission> getPermission() {
		return permission;
	}

	public Set<SimpleGrantedAuthority> grantedAuthorities() {
		Set<SimpleGrantedAuthority> authorities = getPermission().stream()
				.map(permission -> new SimpleGrantedAuthority(permission.name())).collect(Collectors.toSet());
		authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
		return authorities;

	}

}
