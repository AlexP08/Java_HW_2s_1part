package com.example.DB_task1.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity(name="answer")
public class Answer {

    @ManyToMany
    @JoinColumn(name = "row_id", referencedColumnName = "answer_id")
    private Set<SAnswer> studentAnswerList;

    public Set<SAnswer> getStudentAnswerList() {
        return studentAnswerList;
    }

    @Id
    @Column(name = "question_id")
    private Long questionId;
    @Column(name = "text")
    private String text;
    @Column(name = "correct")
    private Boolean correct;

    public Answer() {

    }

}