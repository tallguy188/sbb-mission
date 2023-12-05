package com.ll.sbbmission.Question;


import com.ll.sbbmission.Answer.Answer;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder(toBuilder = true)
@Setter
@Entity  // 엔티티 어노테이션 적용을 해야 JPA가 인식함
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (length = 200)
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)  // mappedBy는 참조엔티티 속성명을 의미
    private List<Answer> answerList;


}
