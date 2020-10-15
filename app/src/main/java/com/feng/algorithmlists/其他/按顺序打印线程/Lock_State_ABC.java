package com.feng.algorithmlists.其他.按顺序打印线程;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by fengbei
 * on 20-10-14
 * 建立三个线程A、B、C，A线程打印10次字母A，B线程打印10次字母B,C线程打印10次字母C，但是要求三个线程同时运行，并且实现交替打印，即按照ABCABCABC的顺序打印。
 */
public class Lock_State_ABC {

    private static Lock lock = new ReentrantLock();
    private static int state = 0;


    static class ThreadA extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; ) {
                System.out.println("A*****" + i);
                synchronized (Lock_State_ABC.class) {
                    if (state % 3 == 0) {
                        System.out.println("A");
                        state++;
                        i++;
                    }
                }
                System.out.println("A*****88888888" + i);
            }
        }
    }


    static class ThreadB extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; ) {
                System.out.println("B*****" + i);
                synchronized (Lock_State_ABC.class) {
                    if (state % 3 == 1) {
                        System.out.println("B");
                        state++;
                        i++;
                    }
                }
                System.out.println("B*****88888888" + i);
            }
        }
    }


    static class ThreadC extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; ) {
                System.out.println("C*****" + i);
                synchronized (Lock_State_ABC.class) {
                    if (state % 3 == 2) {
                        System.out.println("C");
                        state++;
                        i++;
                    }
                }
                System.out.println("C*****88888888" + i);
            }
        }
    }

    public static void main(String[] args) {
        new ThreadA().start();
        new ThreadB().start();
        new ThreadC().start();
    }
}
