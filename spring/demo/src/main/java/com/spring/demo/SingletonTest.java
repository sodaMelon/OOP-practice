package com.spring.demo;

public class SingletonTest {
    public static void main(String[] args) { //getBean의 원리

        Database db= Database.getInstance(0);
        System.out.println(db);

        Database db2 = Database.getInstance(0); //싱글톤으로 객체 돌려씀
        System.out.println(db2);

        Database db3 = Database.getInstance(1); //prototype으로 새 객체 생성..
        System.out.println(db3);
    }
}

class Database {
    private static Database database= null;

    private Database() {
    }

    public static Database getInstance(int scope) { // scope=1 prototype
        if ( scope == 1 ) {
            database = new Database();
        }
        if ( database == null ) {
            database = new Database();
        }
        return database;
    }
}
