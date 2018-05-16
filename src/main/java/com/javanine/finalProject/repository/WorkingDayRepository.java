package com.javanine.finalProject.repository;

import com.javanine.finalProject.model.WorkingDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;

@Repository
public interface WorkingDayRepository extends JpaRepository<WorkingDay, Long>{
    @Query("FROM WorkingDay WHERE employee.id = :employeeId and date between :startDate and :endDate")
    List<WorkingDay> findByEmployee(@Param("employeeId") Long employeeId, @Param("startDate") Date startDate,
                                    @Param("endDate") Date endDate);
}
