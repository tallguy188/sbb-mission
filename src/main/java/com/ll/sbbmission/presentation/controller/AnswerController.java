package com.ll.sbbmission.presentation.controller;


import com.ll.sbbmission.application.service.AnswerService;
import com.ll.sbbmission.application.service.QuestionService;
import com.ll.sbbmission.domain.entity.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

@RequestMapping("/answer")
@RequiredArgsConstructor
public class AnswerController {

    private final QuestionService questionService;
    private final AnswerService answerService;

    @PostMapping("/create/{id}")
    public String createAnswer(Model model, @PathVariable("id") Integer id, @RequestParam String content) {

        Question question = this.questionService.getQuestion(id);
        this.answerService.create(question,content);
        return String.format("redirect:/question/detail/%s", id);
    }

}
