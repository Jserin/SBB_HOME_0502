package com.ll.sbb;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // HelloController 클래스가 컨트롤러의 기능을 수행함
public class HelloController {
    int num;
    @GetMapping("/hello") // (/hello) URL과 hello 메서드를 매핑
    @ResponseBody // hello 메서드의 응답 결과가 문자열 그 자체임을 나타냄
    public String hello() {
        return "우왕";
    }

    @RequestMapping("/plus")
    @ResponseBody
    // /plus?a=1&b=2 접속하면 3 출력
    public int showPlus(int a, int b) {
        return a + b;
    }

    @RequestMapping("/minus")
    @ResponseBody
    // /plus?a=1&b=2 접속하면 3 출력
    public int showMinus(int a, int b) {
        return a - b;
    }

    @RequestMapping("/increase")
    @ResponseBody
    // /plus?a=1&b=2 접속하면 3 출력
    public int showincrease() {
        return num++;
    }

    // 개선된 switch문
    @RequestMapping("/mbti/{name}")
    @ResponseBody
    public String showMBTI(@PathVariable String name) {
        return switch (name) {
            case "홍길동" -> {
                char j = 'J';
                yield "INF" + j;
            }
            case "홍길순", "아무개" -> "ENFP";
            // ㄴ 여러 변수 같은 출력
            case "임꺽정" -> "ENFJ";
            case "반장" -> "ESTJ";
            default -> "몰?루";
        };
    }
    // PathVariable 경로변수
}
