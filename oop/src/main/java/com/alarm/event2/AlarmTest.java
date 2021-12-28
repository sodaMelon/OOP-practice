package com.alarm.event2;

public class AlarmTest {

    public static void main(String[] args) throws InterruptedException {
        //AlarmService service = new AlarmService(new Alarm());
        AlarmService service = new AlarmService(new IAlarm() {
            public void setup() {
                System.out.println("test");
            }

            public void reset() {
                System.out.println("test");
            }

            public void loop(int time) {
                System.out.println("test");
            }
        });

        service.run();
    }
}
