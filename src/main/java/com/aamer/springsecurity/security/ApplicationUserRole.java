package com.aamer.springsecurity.security;

import com.google.common.collect.Sets;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum ApplicationUserRole {
    // No permission assigned
    STUDENT(Sets.newHashSet()),

    // Role based authentication example. ADMIN has course, student (read and write permissions)
    ADMIN(Sets.newHashSet(ApplicationUserPermissions.COURSE_READ,
                          ApplicationUserPermissions.COURSE_WRITE,
                          ApplicationUserPermissions.STUDENT_READ,
                          ApplicationUserPermissions.STUDENT_WRITE)),

    // Permission based authentication example (ADMINTRAINEE does not have a write permission)
    ADMINTRAINEE(Sets.newHashSet(ApplicationUserPermissions.COURSE_READ,
            ApplicationUserPermissions.STUDENT_READ));


    private final Set<ApplicationUserPermissions> permissions;

    ApplicationUserRole(Set<ApplicationUserPermissions> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermissions> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> grantedAuthorities(){
       Set<SimpleGrantedAuthority> permissions = getPermissions()
                                                .stream()
                                                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                                                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_"+this.name()));
        return permissions;
    }
}
