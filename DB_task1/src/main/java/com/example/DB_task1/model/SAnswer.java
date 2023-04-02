package com.example.DB_task1.model;

import jakarta.persistence.*;

@Entity(name="student_answer")
public class SAnswer {
    @Id
    @Column(name = "row_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long rowID;
    @Column(name = "test_id")
    private Long testID;
    @Column(name = "user_id")
    private Long userID;
    @Column(name = "answer_id")
    private Long answerID;

    public SAnswer() {
    }

    public SAnswer(Long rowID, Long testID, Long userID, Long answerID) {
        this.rowID = rowID;
        this.testID = testID;
        this.userID = userID;
        this.answerID = answerID;
    }
}