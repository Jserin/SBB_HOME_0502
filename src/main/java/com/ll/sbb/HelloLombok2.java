package com.ll.sbb;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
// ㄴ final 붙은 속성을 필요로 하는 생성자가 자동으로 생성됨
@Getter
public class HelloLombok2 {

    private final String hello;
    private final int lombok;
    // ㄴ final이 없는 속성은 생성자에 포함 안됨

    public static void main(String[] args) {
        HelloLombok2 helloLombok2 = new HelloLombok2("헬로", 5);
        System.out.println(helloLombok2.getHello());
        System.out.println(helloLombok2.getLombok());

    }
}
