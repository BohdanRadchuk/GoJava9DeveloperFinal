package com.javanine.finalProject.repository;

import com.javanine.finalProject.dto.UserDTO;
import com.javanine.finalProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    User findByEmail(String email);

    @Query("select new com.javanine.finalProject.dto.UserDTO(u.id, u.email, u.password) from User u where u.id = :id")
    UserDTO findDto(@Param("id") Long id);
}
