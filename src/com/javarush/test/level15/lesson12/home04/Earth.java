package com.javarush.test.level15.lesson12.home04;

/**
 * Created by Admin on 12.02.2017.
 */
public final class Earth implements Planet {
    private Earth() {}
    private static Earth instance;
    public static Earth getInstance() {
        if(instance == null) {
            instance = new Earth();
        }
        return instance;
    }
}
