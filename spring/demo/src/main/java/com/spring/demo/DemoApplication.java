package com.spring.demo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

        AbstractApplicationContext context =
                new GenericXmlApplicationContext("applicationContext.xml");
        Person p1 =  (Person) context.getBean("p1");
        p1.setName("이순신");
        p1.setAge(50);
        System.out.println(p1);

        Person p1_2 =  (Person) context.getBean("p1");
        System.out.println(p1_2); // p1 = p1_2가 같음.. (이미 생성된 객체 다시 사용)
        if (p1 ==p1_2) System.out.println("동일주소");
        else System.out.println("다른 주소")

        Person p2 =  (Person) context.getBean("p2");
        System.out.println(p2);
    }
}
