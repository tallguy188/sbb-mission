package com.ll.sbbmission.presentation.controller;


import com.ll.sbbmission.application.service.QuestionService;
import com.ll.sbbmission.domain.entity.Question;
import com.ll.sbbmission.domain.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@RequiredArgsConstructor
@RequestMapping("/question")
@Controller
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/list")
    //@ResponseBody
    public String list(Model model) {
        List<Question>questionList = this.questionService.getList();
        model.addAttribute("questionList",questionList);
        return "question_list";
    }

    @GetMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question",question);
        return "question_detail";
    }

}
