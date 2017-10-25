package com.javarush.test.level25.lesson07.home01;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    Thread thread;
    String threadName;


    @Override
    public void run() {
        try {
            while(!thread.isInterrupted()) {
               // Thread.sleep(0);
                System.out.println(threadName);
               // Thread.sleep(0);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
           // e.printStackTrace();
        }
    }

    @Override
    public void start(String threadName)
    {
        this.threadName = threadName;
        thread = new Thread(this);
        thread.start();

    }


    public void stop ()
    {
        thread.interrupt();
    }
}
