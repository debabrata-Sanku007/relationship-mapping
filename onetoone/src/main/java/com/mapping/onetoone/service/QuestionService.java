package com.mapping.onetoone.service;

import com.mapping.onetoone.entity.Question;
import com.mapping.onetoone.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public Question saveQuestion(Question question) {
        return questionRepository.save(question);


    }

}
