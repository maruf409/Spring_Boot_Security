package spring.security.security;

import com.google.common.collect.Sets;

import java.util.HashSet;
import java.util.Set;

public enum userRoles {

    Admin(Sets.newHashSet(userPermission.STUDENT_READ,
            userPermission.STUDENT_WRITE,
            userPermission.COURSE_READ, userPermission.COURSE_WRITE)),
    Student(Sets.newHashSet());

    private final Set<userPermission> userPermissions;

    userRoles(Set<userPermission> userPermissions) {
        this.userPermissions = userPermissions;
    }


    public Set<userPermission> getUserPermissions() {
        return userPermissions;
    }
}
