package com.javanine.finalProject.repository;

import com.javanine.finalProject.dto.EmployeeDTO;
import com.javanine.finalProject.model.Employee;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("select new com.javanine.finalProject.dto.EmployeeDTO(e.id, e.firstName, e.lastName, d.name, p.name, e.hourlyRate, u) " +
            "from Employee e, Department d, Position p, User u where e.departmentId = d.id and e.positionId = p.id and e.userId = u.id and e.id = :id")
    EmployeeDTO findInId(@Param("id") Long id);

    @Query("select new com.javanine.finalProject.dto.EmployeeDTO(e.id, e.firstName, e.lastName, d.name, p.name, e.hourlyRate, u) " +
            "from Employee e, Department d, Position p, User u where e.departmentId = d.id and e.positionId = p.id and e.userId = u.id")
    List<EmployeeDTO> findAllDto(Pageable pageable);
}
