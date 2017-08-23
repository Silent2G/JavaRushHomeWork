package com.javarush.test.level21.lesson08.task03;

import com.sun.org.apache.xpath.internal.SourceTree;

/* Запретить клонирование
Разрешите клонировать класс А
Запретите клонировать класс B
Разрешите клонировать класс C
Метод main не участвует в тестировании.
*/
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        @Override
        protected A clone() throws CloneNotSupportedException
        {
            return (A) super.clone();
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        protected B clone() throws CloneNotSupportedException
        {
            throw new CloneNotSupportedException();
        }
    }

    public static class C extends B {
        public C(int i, int j, String name) {
            super(i, j, name);
        }

        @Override
        protected C clone() throws CloneNotSupportedException
        {
            C result = null;
            if(this.getName() != null) {
                result = new C(this.getI(), this.getJ(),this.getName());
            }

            return result;
        }
    }
    public static void main(String[] args) {
        A a = new A(2,3);
        A aClone = null;
        B b = new B(4,5,"Stas");
        B bClone = null;
        C c = new C(6,7,"Developer");
        C cClone = null;
        try {
            aClone = a.clone();
            bClone = b.clone();
            cClone = c.clone();
        } catch (CloneNotSupportedException e) {
           // e.printStackTrace();
        }
        System.out.println(a);
        System.out.println(aClone);
        System.out.println(aClone.getI());
        System.out.println(aClone.getJ());
        System.out.println("------------------");
        System.out.println(b);
        System.out.println(bClone);
//        System.out.println(bClone.getI());
 //       System.out.println(bClone.getJ());
 //       System.out.println(bClone.getName());
        System.out.println("------------------");
        System.out.println(c);
        System.out.println(cClone);
        System.out.println(cClone.getI());
        System.out.println(cClone.getJ());
        System.out.println(cClone.getName());
    }
}
