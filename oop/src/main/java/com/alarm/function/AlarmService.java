package com.alarm.function;

public class AlarmService {

    public void setup(){
        System.out.println("알람을 시작합니다.");//초기화
    }
    
    public void reset(){
        System.out.println("재시작합니다..."); //리셋
    }

    public void loop(int time) {
        if (time == 10) {
            System.out.println("10시가 되엇습니다.");
        }
        if (time == 17) {
            System.out.println("17시가 되엇습니다.");
        }
    }
    
    public void run() throws InterruptedException {
        setup();
        while (true) {
            reset();
            for (int time = 0; time < 24; time++) {
                Thread.sleep(100); //0.1초 쉬어감
                loop(time);
            }
        }
    }
}
