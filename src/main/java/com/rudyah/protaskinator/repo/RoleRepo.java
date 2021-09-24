package com.rudyah.protaskinator.repo;

import com.rudyah.protaskinator.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
