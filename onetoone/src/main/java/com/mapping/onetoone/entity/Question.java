package com.mapping.onetoone.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

@Entity
@Data
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private int questionId;
    private String question;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ans_id")
    @JsonManagedReference
    private Answer answer;
}
