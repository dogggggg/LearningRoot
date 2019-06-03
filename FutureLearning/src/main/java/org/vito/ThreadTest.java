package org.vito;

/**
 * @author Halb
 * @version V1.0
 * @Title: ThreadTest
 * @Package: org.vito
 * @Description: TODO
 * @date 2019/05/25 8:00
 */

public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        MyThread d1 = new MyThread("t1", 2000);
        MyThread d2 = new MyThread("t2", 2000);
        Thread t1 = new Thread(d1);
        Thread t2 = new Thread(d2);

        t1.start();
        t1.join();
        t2.start();

        for (int i = 0; i < 50; i++) {
            System.out.println("Main:-->" + i);
        }
    }
}

class MyThread extends Thread {
    private String threadName;
    private int times;

    public MyThread(String threadName, int times) {
        this.threadName = threadName;
        this.times = times;
    }

    @Override
    public void run() {
        for (int i = 0; i < times; i++) {
            System.out.println(threadName + ":-->" + i);
        }
    }
}
