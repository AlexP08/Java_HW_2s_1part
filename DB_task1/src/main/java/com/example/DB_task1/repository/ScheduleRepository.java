package com.example.DB_task1.repository;

import com.example.DB_task1.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    List<Schedule> findAllByRowIDAndUserID(Long rowID, Long userID);
}