package com.javarush.task.task15.task1522;

/**
 * Created by Admin on 08.02.2017.
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
