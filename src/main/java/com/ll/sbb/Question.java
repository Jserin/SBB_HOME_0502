package com.ll.sbb;


import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
// ㄴ 질문이 one

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter //롬복
@Entity  // JPA 가 엔티티로 인식
public class Question {
    @Id // 기본키로 지정, 중복X
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // ㄴ 자동으로 1씩 증가해서 저장
    // ㄴ strategy 고유번호를 생성하는 옵션
    // ㄴ generation어쩌고 해당 컬럼만의 독립적인 시퀀스를 생성하여 번호를 증가시킬 때 사용
    private Integer id;

    @Column(length = 200)
    // ㄴ 컬럼의 세부 설정 length는 컬럼의 길이 설정
    private String subject;

    @Column(columnDefinition = "TEXT")
    // ㄴ 컬럼의 속성 정의 text 는 글자 수를 제한할 수 없는 경우 사용
    private String content;

    private LocalDateTime createDate;

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    // ㄴ mappedBy는 참조 엔티티의 속성명, Answer 엔티티에서 Question 엔티티를 참조한 속성명 question을 mappedBy에 전달
    // ㄴ cascade... = 질문을 삭제하면 그에 달린 답변들도 모두 삭제
    private List<Answer> answerList;
    // ㄴ Answer 엔티티 객체로 구성된 answerList를 속성으로 추가
}