package com.mapping.onetomany.service;


import com.mapping.onetomany.entity.Answer;
import com.mapping.onetomany.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnswerService {

    @Autowired
    private AnswerRepository answerRepository;


    public Optional<Answer> getAnswer(int id) {
        return answerRepository.findById(id);
    }
}
