package com.javarush.test.level15.lesson12.home05;

/**
 * Created by Admin on 12.02.2017.
 */
public class SubSolution extends Solution {
    private SubSolution(String s) {}
    private SubSolution(String s, String st) {}
    private SubSolution(String s, String st, String str) {}

    public SubSolution(int n) {super(n);}
    public SubSolution(int n, int nt) {super(n, nt);}
    public SubSolution(int n, int nt, int ntt) {super(n, nt, ntt);}

    protected SubSolution(char ch) {super(ch);}
    protected SubSolution(char ch, char c) {super(ch, c);}
    protected SubSolution(char ch, char ar, char far) {super(ch, ar, far);}

    SubSolution() {}
    SubSolution(long l) {super(l);}
    SubSolution(long l, long ll) {super(l, ll);}
}
