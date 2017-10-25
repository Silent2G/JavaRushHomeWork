package com.javarush.test.level25.lesson05.task01;

/* Switch для нитей
Обработайте список нитей в зависимости от состояния:
1. Если нить еще не запущена, то запустите ее.
2. Если нить в ожидании, то прервите ее.
3. Если нить работает, то проверить маркер isInterrupted.
4. Если нить прекратила работу, то выведите в консоль ее приоритет.
Используйте switch.
*/
public class Solution {
    public static void processThreads(Thread... threads) {
        //implement this method - реализуйте этот метод
        for(int i = 0; i < threads.length; i++) {
            switch (threads[i].getState()) {
                case NEW:   //Если нить еще не запущена, то запустите ее.
                    threads[i].start();
                break;
                case WAITING:   //Если нить в ожидании, то прервите ее.
                    threads[i].interrupt();
                break;
                case RUNNABLE: // Если нить работает, то проверить маркер isInterrupted.
                    threads[i].isInterrupted();
                break;
                case TERMINATED: // Если нить прекратила работу, то выведите в консоль ее приоритет.
                    System.out.println(threads[i].getPriority());
                break;
                case BLOCKED:   //Если нить в ожидании, то прервите ее.
                    threads[i].interrupt();
                    break;
                case TIMED_WAITING:   //Если нить в ожидании, то прервите ее.
                    threads[i].interrupt();
                    break;

            }
        }
    }
}
