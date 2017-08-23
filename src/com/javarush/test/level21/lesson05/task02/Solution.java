package com.javarush.test.level21.lesson05.task02;

import java.util.HashSet;
import java.util.Set;

/* Исправить ошибку
Сравнение объектов Solution не работает должным образом. Найти ошибку и исправить.
Метод main не участвует в тестировании.
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        if(o == null || o.getClass() != this.getClass()) {
            return false;
        }
        // if (!(o instanceof Solution))
        //    return false;
        Solution n = (Solution) o;

        if(first != null) {
             if(!first.equals(n.first)) {
                 return false;
             }
        } else {
            if(n.first != null) {
                return false;
            }
        }

        if(last != null) {
            if(!last.equals(n.last)) {
                return false;
            }
        } else {
            if(n.last != null) {
                return false;
            }
        }
        return true;
    }
    public int hashCode() {
        int result;
        if(first != null) {
            result = first.hashCode();
        } else {
            result = 0;
        }

        if(last != null) {
            result = result + last.hashCode();
        }

        result = result * 33;
        return result;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
    }
}
