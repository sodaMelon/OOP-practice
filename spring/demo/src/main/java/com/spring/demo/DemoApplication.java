package com.spring.demo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.ArrayList;

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
        Person p2 =  (Person) context.getBean("p2");
        System.out.println(p2);
/////////////////////////////////////////////////////////
        /*Car car = new Car("소나타", "빨간색");
        ArrayList<Option> opts = new ArrayList<Option>();
        opts.add(new Option("네비게이션"));
        opts.add(new Option("후방 카메라"));
        opts.add(new Option("AV 시스템"));
        car.setOptions(opts);
        System.out.println(car);*/

/*        Car car1 =(Car) context.getBean("car1");
        System.out.println(car1);

        // Classic DI
        // CarService svr = new CarService(car1); //1. use constructor
        //svr.setCar(car1);// 2. use method */

        System.out.println("---------------------------");
        ICarService svr = (ICarService) context.getBean("svr2"); //3. xml에 실제 구현체 등록 (interface는 안됨!)
        // svr.washing();
        svr.coloring("금색");
        System.out.println(svr);


        context.close();
    }
}
