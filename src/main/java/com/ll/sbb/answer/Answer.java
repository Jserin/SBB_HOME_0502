package com.ll.sbb.answer;

import java.time.LocalDateTime;

import com.ll.sbb.question.Question;
import com.ll.sbb.user.SiteUser;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Set;
import jakarta.persistence.ManyToMany;

import jakarta.persistence.ManyToOne;
// ㄴ 질문 엔티티와 연결된 속성임을 표시 답변이 many

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

@Getter
@Setter
@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TEXT")
    private String content;

    @CreatedDate
    private LocalDateTime createDate;

    @ManyToOne
    private Question question;
    // ㄴ 질문 엔티티를 참조하기 위해 추가
    @ManyToOne
    private SiteUser author;
    private LocalDateTime modifyDate;

    @ManyToMany
    Set<SiteUser> voter;

}
