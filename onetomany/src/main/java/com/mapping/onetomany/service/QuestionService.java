package com.mapping.onetomany.service;


import com.mapping.onetomany.entity.Question;
import com.mapping.onetomany.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public Question saveQuestion(Question question) {
        return questionRepository.save(question);

    }

    public Optional<Question> getQuestion(int id) {
        return questionRepository.findById(id);
    }
}
