package com.alarm.annotaion;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME) // 타입별로 기능이 다름
public @interface Task { //define annotaion
    public int time();
}
