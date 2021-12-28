package com.account;

import java.util.ArrayList;

public class Log {
    private ArrayList<String> history = new ArrayList<String>();

    public void log(String log) {
        System.out.println("LOG :" + log);
        history.add(log);
    }

    public  void print(){
        for (String log: history) {
            System.out.println(log);
        }
    }
}
