package com.ll.sbbmission;

import com.ll.sbbmission.Answer.Answer;
import com.ll.sbbmission.Question.Question;
import com.ll.sbbmission.Answer.AnswerRepository;
import com.ll.sbbmission.Question.QuestionRepository;
import com.ll.sbbmission.Question.QuestionService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SbbMissionApplicationTests {

    @Autowired
    private QuestionRepository questionRepository;


    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private QuestionService questionService;

    @Test
    void testJpa() {  // 대량테스트 데이터 생성
        for(int i=1; i<=300; i++) {
            String subject = String.format("데스트 데이터입니다:[%03d]",i);
            String content = "내용 무";
            this.questionService.create(subject,content);
        }
    }
}
