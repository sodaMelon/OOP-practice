package com.alarm.annotaion;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Alarm {
    @Task(time = 10)
    public void task0() {
        System.out.println("^^^^^^^");
    }

    @Task(time = 40)
    @Log
    public void task1() {
        System.out.println("###########");
    }

    @Log
    public void func1() {
        System.out.println("no~~~~");
    }
}

public class AlarmTest {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Alarm alarm = new Alarm();
        //alarm.func1();
        //alarm.task0();
        //System.out.println("------------------");
        Method methods[] = alarm.getClass().getDeclaredMethods();

        for (int i = 0; i < methods.length; i++) {
            System.out.println(methods[i].getName());
        }
        for (Method method : methods) {
            System.out.println(method.getName());

            Task annTask = method.getAnnotation(Task.class);
            //값이 있으면 반환 없으면 null.. 이거 해킹에 쓰지않나...??
            if (annTask == null) System.out.println("x");
            else System.out.println("@Task");

            Log annLog = method.getAnnotation(Log.class);
            if (annLog == null) System.out.println("x");
            else System.out.println("@Log");

            if (annTask != null) {//리플렉션해서 함수 실행해보긔
                System.out.println("Time value" + annTask.time());
                if (annTask.time() == 10) {
                    method.invoke(alarm); //첫번째 파라미터에 이 함수를 소유하고있는 실제 객체,
                 }
            }
        }
    }
}
