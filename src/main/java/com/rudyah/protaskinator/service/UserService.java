package com.rudyah.protaskinator.service;

import com.rudyah.protaskinator.domain.AppUser;
import com.rudyah.protaskinator.domain.Role;
import org.springframework.data.domain.Page;

public interface UserService {
    AppUser saveUser(AppUser user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    AppUser getUser(String username);
    Page<AppUser> getUsers(int pageNumber, int pageSize);
}
