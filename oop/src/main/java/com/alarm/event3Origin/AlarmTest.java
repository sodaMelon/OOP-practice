package com.alarm.event3Origin;

import java.util.ArrayList;

// 알람 시간별 기능 분할
public class AlarmTest {

    public static void main(String[] args) throws InterruptedException {

        AlarmService service = new AlarmService();

        service.add(10, new IAlarmTime() {
            public void time(int time) {
                System.out.println("10시 입니다.");
            }
        });

        service.add(12, new IAlarmTime() {
            public void time(int time) {
                System.out.println("12시 입니다.");
            }
        });

        service.add(22, new IAlarmTime() {
            public void time(int time) {
                System.out.println("22시 입니다.");
            }
        });

        service.run();




    }
}

interface  IAlarmTime {
    public void time(int time);
}

class  AlarmService {

    private ArrayList<IAlarmTime> list = new ArrayList<IAlarmTime>();
    private ArrayList<Integer> listTime = new ArrayList<Integer>(); //Todo: HashMap으로 리팩토링

    public void add(int time, IAlarmTime alarmTime) {
        list.add(alarmTime);
        listTime.add(time);
    }

    public  void run() throws InterruptedException {



//        IAlarmTime alram = list.get(0);
//
//        alram.time(10);
//        list.get(1).time(10);
//        list.get(2).time(10);

//        System.out.println(listTime.get(0));
//        System.out.println(listTime.get(1));
//        System.out.println(listTime.get(2));


        while ( true) {
            for (int time = 0; time < 24; time++) {
                Thread.sleep(100);

                for(int  i = 0 ;i  < list.size(); i++) {
                    if ( time == listTime.get(i) )
                        list.get(i).time(time);
                }
                /*
                if (i == 10) list.get(0).time(10);
                if (i == 12) list.get(1).time(12);
                if (i == 22) list.get(2).time(22);
                 */
            }
        }


    }

}