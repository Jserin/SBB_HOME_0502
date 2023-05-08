package com.ll.sbb.Question;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/question") //getmapping의 중복되는 부분
@RequiredArgsConstructor
//ㄴ 롬복제공 final이 붙은 속성을 포함하는 생성자를 자동으로 생성하는 역할
@Controller
public class QuestionController {

    private final QuestionService questionService;
    // ㄴ final 처음 정의된 상태가 변하지 않음을 보장... 테이블이 변하면 안되니까?????

    @GetMapping("/list")
    public String list(Model model) {
        List<Question> questionList = this.questionService.getList();
        // ㄴ 질문서비스에서 목록을 불러와서 저장
        model.addAttribute("questionList", questionList);
        // ㄴ model 객체에 값을 담아서 템플릿에서 값을 사용할 수 있게 함. addattribute(key, value)
        return "question_list";
        // ㄴ 탬플릿 파일을 출력 responsebody 필요없음
    }

    @GetMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "question_detail";
    }
    // ㄴ 변수를 얻을 때에는 pathvariable 사용. getmapping 변수와 이름 동일해야함
}
