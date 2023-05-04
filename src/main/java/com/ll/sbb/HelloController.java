package com.ll.sbb;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // HelloController 클래스가 컨트롤러의 기능을 수행함
public class HelloController {
    @GetMapping("/")
    public String root() {
        return "redirect:/question/list";
    }
}
