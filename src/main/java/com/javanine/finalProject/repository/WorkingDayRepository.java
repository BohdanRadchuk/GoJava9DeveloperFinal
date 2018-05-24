package com.javanine.finalProject.repository;

import com.javanine.finalProject.model.WorkingDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;

@Repository
public interface WorkingDayRepository extends JpaRepository<WorkingDay, Long> {

    @Query("select wd.id from WorkingDay wd where wd.employeeId = :employeeId and date between :startDate and :endDate")
    List<Long> findByEmployee(@Param("employeeId") Long employeeId, @Param("startDate") Date startDate,
                              @Param("endDate") Date endDate);
}
