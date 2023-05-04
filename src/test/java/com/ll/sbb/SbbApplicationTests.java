package com.ll.sbb;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.ll.sbb.answer.Answer;
import com.ll.sbb.answer.AnswerRepository;
import com.ll.sbb.question.Question;
import com.ll.sbb.question.QuestionRepository;
import org.junit.jupiter.api.Test;
// ㄴ JUnit : 테스트코드를 작성하고 실행하기 위해 사용하는 자바의 테스트 프레임워크
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
class SbbApplicationTests {

    @Autowired
    // ㄴ 스프링의 DI(Dependency Injection 스프링이 객체를 대신 생성해서 주입)
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Test
    void testJpa() {

        // question
		 //q1 q2 객체를 생성하고 테이블에 저장하는 메소드
		Question q1 = new Question();
		q1.setSubject("sbb가 무엇인가요?");
		q1.setContent("sbb에 대해서 알고 싶습니다.");
		q1.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q1);  // 첫번째 질문 저장

		Question q2 = new Question();
		q2.setSubject("스프링부트 모델 질문입니다.");
		q2.setContent("id는 자동으로 생성되나요?");
		q2.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q2);  // 두번째 질문 저장


		/* 테이블의 데이터를 조회하고 일치하는지 테스트
		List<Question> all = this.questionRepository.findAll();
		// ㄴ findAll 모든 데이터 조회
		assertEquals(2, all.size());
		// (기대값, 실제값) 값이 동일하면 테스트 성공

		Question q = all.get(0);
		assertEquals("sbb가 무엇인가요?", q.getSubject());
		// ㄴ 첫번째 데이터 제목이 일치하면 테스트 성공
		 */

		/* id로 데이터 조회
		Optional<Question> oq = this.questionRepository.findById(1);
		//ㄴ id값으로 데이터를 조회. 리턴 타입이 Optional이므로 null이 아닌지 확인 후 get으로 객체값을 얻어야함
		// Optional null값을 허용.
		if(oq.isPresent()) {
			Question q = oq.get();
			assertEquals("sbb가 무엇인가요?", q.getSubject());
		}
		 */

		/* 제목으로 데이터 조회
		Question q = this.questionRepository.findBySubject("sbb가 무엇인가요?");
		assertEquals(1, q.getId());
		 */

		/* 제목과 내용으로 데이터 조회
		Question q = this.questionRepository.findBySubjectAndContent(
				"sbb가 무엇인가요?", "sbb에 대해서 알고 싶습니다.");
		assertEquals(1, q.getId());
		 */

		/* 제목에 특정 문자열이 포함되어 있는 데이터 조회
		List<Question> qList = this.questionRepository.findBySubjectLike("sbb%");
		// ㄴ sbb% sbb로 시작하는 문자열
		Question q = qList.get(0);
		assertEquals("sbb가 무엇인가요?", q.getSubject());
		 */

		/* 데이터 수정하기
		Optional<Question> oq = this.questionRepository.findById(1);
		assertTrue(oq.isPresent());
		// ㄴ 값이 true 인지 테스트
		Question q = oq.get();
		q.setSubject("수정된 제목");
		this.questionRepository.save(q);
		 */

		/* 데이터 삭제하기
		assertEquals(2, this.questionRepository.count());
		// ㄴ count()는 해당 리포지터리의 총 데이터건수를 리턴
		Optional<Question> oq = this.questionRepository.findById(1);
		assertTrue(oq.isPresent());
		Question q = oq.get();
		this.questionRepository.delete(q);
		assertEquals(1, this.questionRepository.count());
		// ㄴ 삭제 후에 데이터 건수가 1개 인지 테스트
		 */
    }
}