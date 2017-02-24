package com.javarush.test.level08.lesson08.task01;

import java.util.HashSet;
import java.util.Random;


/* 20 слов на букву «Л»
Создать множество строк (Set<String>), занести в него 20 слов на букву «Л».
*/

public class Solution
{
    public static HashSet<String> createSet()
    {
        final Random random = new Random();
        HashSet<String> set = new HashSet<String>();
        for(int i = 0; i < 20; i++) {
            Integer number = random.nextInt();
            String l = "Л";
            set.add(l.concat(number.toString()));

        }
        return set;
    }
 //   public static void main(String[] args) {
 //       for(String s: createSet()) {
 //           System.out.println(s);
 //       }
 //   }
}
