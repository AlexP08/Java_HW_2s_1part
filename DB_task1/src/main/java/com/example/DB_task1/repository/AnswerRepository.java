package com.example.DB_task1.repository;

import com.example.DB_task1.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
    List<Object[]> findAllByUserID(Long userID);
}
