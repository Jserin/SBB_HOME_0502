package com.ll.sbb;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HelloLombok {

    private String hello;
    private int lombok;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setHello("헬로");
        helloLombok.setLombok(5);

        System.out.println(helloLombok.getHello());
        System.out.println(helloLombok.getLombok());
        // ㄴ getter, setter 메서드를 추가하지 않아도 setHello, getHello 등 사용 가능
    }
}