package com.javarush.task.task15.task1522;

/**
 * Created by Admin on 08.02.2017.
 */
public final class Moon implements Planet {
    private Moon() {}
    private static Moon instance;
    public static Moon getInstance() {
        if(instance == null) {
            instance = new Moon();
        }
        return instance;
    }
}
