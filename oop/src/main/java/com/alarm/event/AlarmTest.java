package com.alarm.event;

public class AlarmTest {

    public static void main(String[] args) throws InterruptedException {
        AlarmService service = new AlarmService(new Alarm());
        service.run();
    }
}
