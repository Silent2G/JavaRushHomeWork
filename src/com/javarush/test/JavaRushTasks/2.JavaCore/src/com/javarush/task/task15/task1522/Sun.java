package com.javarush.task.task15.task1522;

/**
 * Created by Admin on 08.02.2017.
 */
public final class Sun implements Planet {
    private Sun() {}
    private static Sun instance;
    public static Sun getInstance() {
        if(instance == null) {
            instance = new Sun();
        }
        return instance;
    }
}
