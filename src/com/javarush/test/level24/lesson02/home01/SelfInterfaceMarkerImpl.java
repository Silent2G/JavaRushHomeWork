package com.javarush.test.level24.lesson02.home01;


/**
 * Created by admin on 04.05.2017.
 */
public class SelfInterfaceMarkerImpl implements SelfInterfaceMarker
{
    String name = "Stas";
    int age = 26;
    public SelfInterfaceMarkerImpl() {

    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
}
