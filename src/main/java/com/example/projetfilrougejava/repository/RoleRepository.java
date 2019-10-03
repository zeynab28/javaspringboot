package com.example.projetfilrougejava.repository;


import com.example.projetfilrougejava.modele.Role;
import com.example.projetfilrougejava.modele.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}
