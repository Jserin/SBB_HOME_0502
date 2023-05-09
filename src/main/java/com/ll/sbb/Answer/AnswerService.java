package com.ll.sbb.Answer;

import com.ll.sbb.Question.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class AnswerService {

    private final AnswerRepository answerRepository;

    public void create(Question question, String content) {
        Answer answer = new Answer();
        answer.setContent(content);
        answer.setCreateDate(LocalDateTime.now());
        answer.setQuestion(question);
        // ㄴ객체에 입력받은 데이터 저장

        this.answerRepository.save(answer);
        // 리포지터리에 대답 객체 저장
    }
}
