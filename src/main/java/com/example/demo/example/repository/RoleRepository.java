package com.example.demo.example.repository;

import com.example.demo.example.model.Erole;
import com.example.demo.example.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(Erole name);
}
