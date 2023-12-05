package com.ll.sbbmission.Answer;


import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

public class AnswerForm {

    @NotEmpty(message = "내용은 필수입니다.")
    private String content;


    public String getContent() {
        return content;
    }


    public void setContent(String content) {
        this.content = content;
    }
}
