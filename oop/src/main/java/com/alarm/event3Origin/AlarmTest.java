package com.alarm.event3Origin;

import java.util.ArrayList;
import java.util.HashMap;

// 알람 시간별 기능 분할
public class AlarmTest {

    public static void main(String[] args) throws InterruptedException {

        AlarmService service = new AlarmService();



        service.add(  new BasicAlarm());
        service.add(  new AdvnacedAlarm());

        service.add(new IAlarmTime() {
            @Override
            public void time(int time) {
                System.out.println("22시 입니다.");
            }

            @Override
            public int value() {
                return 22; //22시에 알림
            }
        });

        service.add(new IAlarmTime() {
            @Override
            public void time(int time) {
                System.out.println("23시 입니다.");
            }

            @Override  //익명클래스 구현 아키텍쳐(안드로이드쪽에서 많이씀) :이경우는 인터페이스
            public int value() {
                return 23; //22시에 알림
            }
        });

        service.run();
    }
}

class BasicAlarm implements IAlarmTime {
    @Override
    public void time(int time) {
        System.out.println("10시입니다");
    }

    @Override
    public int value() {
        return 10; //10시에 실행
    }
}

class AdvnacedAlarm implements IAlarmTime {
    @Override
    public void time(int time) {
        System.out.println("12시입니다");
    }

    @Override
    public int value() {
        return 12; //12시에 실행
    }
}

interface  IAlarmTime {
    public void time(int time);
    public int value();
}

class  AlarmService {

    private ArrayList<IAlarmTime> list = new ArrayList<IAlarmTime>();
    private ArrayList<Integer> listTime = new ArrayList<Integer>();

    //private HashMap<Integer, IAlarmTime>  tasks = new HashMap<Integer, IAlarmTime>();

    public void add(IAlarmTime alarmTime) {
        list.add(alarmTime);
        listTime.add(alarmTime.value());
        //tasks.put(time, alarmTime  );

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
                    if ( time == list.get(i).value() )
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