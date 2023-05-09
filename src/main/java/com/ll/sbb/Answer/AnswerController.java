package com.ll.sbb.Answer;

import com.ll.sbb.Question.Question;
import com.ll.sbb.Question.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/answer")
@RequiredArgsConstructor
@Controller
public class AnswerController {
    private final QuestionService questionService;
    private final AnswerService answerService;

    @PostMapping("/create/{id}")
    //ㄴ post요청을 받아들일 경우에 사용 디테일html에 메소드 post로 지정되어있음. get으로 요청하면 오류발생
    public String createAnswer(Model model, @PathVariable("id") Integer id, @RequestParam String content){
                                                                            //ㄴ textarea의 content와 변수명 동일해야함
        Question question = this.questionService.getQuestion(id);
        // ㄴ 서비스에서 질문 찾아옴
        this.answerService.create(question, content);
        return String.format("redirect:/question/detail/%s", id);
    }
}
