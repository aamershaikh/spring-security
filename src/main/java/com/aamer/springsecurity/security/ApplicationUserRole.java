package com.aamer.springsecurity.security;

import com.google.common.collect.Sets;

import java.util.Set;

public enum ApplicationUserRole {
    // No permission assigned
    STUDENT(Sets.newHashSet()),

    // permission from ApplicationUserPermission given to admin
    ADMIN(Sets.newHashSet(ApplicationUserPermissions.COURSE_READ,
                          ApplicationUserPermissions.COURSE_WRITE,
                          ApplicationUserPermissions.STUDENT_READ,
                          ApplicationUserPermissions.STUDENT_WRITE));

    private final Set<ApplicationUserPermissions> permissions;

    ApplicationUserRole(Set<ApplicationUserPermissions> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermissions> getPermissions() {
        return permissions;
    }
}
