package com.ll.sbbmission.application.service;


import com.ll.sbbmission.DataNotFoundException;
import com.ll.sbbmission.domain.entity.Question;
import com.ll.sbbmission.domain.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;

    public List<Question> getList() {
        return this.questionRepository.findAll();
    }

    public Question getQuestion(Integer id) {

        Optional<Question> question = this.questionRepository.findById(id);
        if(question.isPresent()) {
            return question.get();
        }
        else {
            throw new DataNotFoundException("question not found");
        }

    }


}
