package com.javanine.finalProject.repository;

import com.javanine.finalProject.dto.UserDTO;
import com.javanine.finalProject.model.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    @Query("select new com.javanine.finalProject.dto.UserDTO(u.id, u.email, u.password) from User u where u.id = :id")
    UserDTO findInId(@Param("id") Long id);

    @Query("select new com.javanine.finalProject.dto.UserDTO(u.id, u.email, u.password) from User u where u.email = :email")
    UserDTO findInEmail(@Param("email") String email);

    @Query("select new com.javanine.finalProject.dto.UserDTO(u.id, u.email, u.password) from User u")
    List<UserDTO> findAllDto(Pageable pageable);

    User findByEmail(String email);
}
