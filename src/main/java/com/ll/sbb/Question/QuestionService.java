package com.ll.sbb.Question;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;
import com.ll.sbb.DataNotFoundException;

@RequiredArgsConstructor
@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    public List<Question> getList() {
        return this.questionRepository.findAll();
    }

    public Question getQuestion(Integer id){
        Optional<Question> question = this.questionRepository.findById(id);
        // ㄴ findbyid는 기본내장???
        if (question.isPresent()) {
            return question.get();
            // 질문이 존재하면 출력
        } else {
            throw new DataNotFoundException("question not found");
        }
    }
}
