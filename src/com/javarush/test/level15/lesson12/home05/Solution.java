package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {
    private Solution(String s) {}
    private Solution(String s, String st) {}
    private Solution(String s, String st, String str) {}

    public Solution(int n) {}
    public Solution(int n, int nt) {}
    public Solution(int n, int nt, int ntt) {}

    protected Solution(char ch) {}
    protected Solution(char ch, char c) {}
    protected Solution(char ch, char ar, char far) {}

    Solution(){}
    Solution(long l){}
    Solution(long l, long ll) {}
}

