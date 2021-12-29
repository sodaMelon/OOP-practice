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
        else System.out.println("다른 주소");

        Person p2 =  (Person) context.getBean("p2"); //<-여기 주석처리해도 싱글톤으로 동작하기때문에
        System.out.println(p2); // 객체 생성시점 : container에 의해서 xml이 읽어질때 생성됨..

        //prototype은 런타임 시에 생성

        context.close();//안정적으로 context 닫음 (없으면 강제종료...~)
        //prototype에 의해 생성하게되면 container가 생성한게 아님...-> 자바자체가 생성한거기때문에 GC가 동작할때까지 그대로 있게됨
        //따라서 Person에 정의한 init, destroy는 container가 싱글톤으로 관리할때만 생김
    }
}
