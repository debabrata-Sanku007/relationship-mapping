package com.mapping.onetomany.controller;


import com.mapping.onetomany.entity.Answer;
import com.mapping.onetomany.entity.Question;
import com.mapping.onetomany.service.AnswerService;
import com.mapping.onetomany.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/onetomany")
public class OneToOneController {
    @Autowired
    private QuestionService questionService;

    @Autowired
    private AnswerService answerService;

    @PostMapping
    public ResponseEntity<Question> saveQuestion(@RequestBody Question question) {
        Question savedQuestion = questionService.saveQuestion(question);
        return new ResponseEntity<Question>(savedQuestion, HttpStatus.CREATED);
    }

    @GetMapping("/{ans_id}")
    public ResponseEntity<Answer> getAnswer(@PathVariable("ans_id") int id) {
        Optional<Answer> answer = answerService.getAnswer(id);
        if (answer.isPresent()) {
            return new ResponseEntity<>(answer.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping()
    public ResponseEntity<Question> getQuestion(@RequestParam(name = "q_id") int id) {
        Optional<Question> question = questionService.getQuestion(id);
        if (question.isPresent()) {
            return new ResponseEntity<>(question.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
