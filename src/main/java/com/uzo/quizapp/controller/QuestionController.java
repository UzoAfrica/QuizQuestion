package com.uzo.quizapp.controller;

import com.uzo.quizapp.model.Question;
import com.uzo.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @GetMapping("/allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionService.getAllQuestions();
    }
@GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }
    @PostMapping("/questions")
    public Question save(@RequestBody Question question){
        return questionService.saveQuestion(question);
    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestions(@RequestBody Question question){
        return questionService.addQuestion(question);
    }

}
