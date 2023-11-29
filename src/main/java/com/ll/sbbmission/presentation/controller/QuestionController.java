package com.ll.sbbmission.presentation.controller;


import com.ll.sbbmission.application.service.QuestionService;
import com.ll.sbbmission.domain.entity.Question;
import com.ll.sbbmission.domain.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@RequiredArgsConstructor
@Controller
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/question/list")
    //@ResponseBody
    public String list(Model model) {
        List<Question>questionList = this.questionService.getList();
        model.addAttribute("questionList",questionList);
        return "question_list";
    }

}
