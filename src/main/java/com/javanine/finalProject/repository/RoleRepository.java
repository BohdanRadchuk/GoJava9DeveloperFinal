package com.javanine.finalProject.repository;

import com.javanine.finalProject.dto.RoleDTO;
import com.javanine.finalProject.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
    Role findByRoleName(String roleName);

    @Query("select new com.javanine.finalProject.dto.RoleDTO(r.id, r.roleName) from Role r where r.id = :id")
    RoleDTO findDto(@Param("id") Long id);
}
