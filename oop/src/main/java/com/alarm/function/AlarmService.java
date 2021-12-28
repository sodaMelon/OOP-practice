package com.alarm.function;

public class AlarmService {

    public void run() throws InterruptedException {
        System.out.println("알람을 시작합니다.");
        while (true) {
            System.out.println("재시작합니다...");
            for (int i = 0; i < 24; i++) {
                Thread.sleep(100); //0.1초 쉬어감
                if (i == 10) {
                    System.out.println("10시가 되엇습니다.");
                }
                if (i == 17) {
                    System.out.println("17시가 되엇습니다.");
                }
            }
        }
    }
}
