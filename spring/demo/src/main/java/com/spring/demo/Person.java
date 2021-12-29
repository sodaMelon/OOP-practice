package com.spring.demo;

import lombok.*;

@Setter @Getter @AllArgsConstructor @NoArgsConstructor @ToString
public class Person { //bean 생성 참조 예제
    private String name;
    private int age;
    private String hobby;

    public Person(String name, int age) { 
        this.name = name;
        this.age = age;
    }
}
