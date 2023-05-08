package com.ll.sbb.Question;

// 리포지토리를 통해 테이블에 데이터를 저장하거나 조회할 수 있음

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    // ㄴ <Question, Integer> 엔티티의 타입과 해당 엔티티의 pk 속성 타입 지정해야함
    Question findBySubject(String subject);
    // ㄴ 제목으로 데이터 찾기
    Question findBySubjectAndContent(String subject, String content);
    // ㄴ 제목과 내용으로 데이터 찾기
    List<Question> findBySubjectLike(String subject);

}