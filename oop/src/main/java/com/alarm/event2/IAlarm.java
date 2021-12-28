package com.alarm.event2;

public interface IAlarm {
    public void setup();
    public void reset();
    public void loop(int time);
}
