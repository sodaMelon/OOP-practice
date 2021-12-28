package com.alarm.event;

public class AlarmService {

    private Alarm alarm;

    public AlarmService(Alarm alarm) {//생성자 주입
        this.alarm = alarm;
    }

    public void run() throws InterruptedException {
        alarm.setup();
        while (true) {
            alarm.reset();
            for (int time = 0; time < 24; time++) {
                Thread.sleep(100); //0.1초 쉬어감
                alarm.loop(time);
            }
        }
    }
}