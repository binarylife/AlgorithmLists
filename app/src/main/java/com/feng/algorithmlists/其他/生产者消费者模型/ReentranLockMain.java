package com.feng.algorithmlists.其他.生产者消费者模型;

import com.feng.algorithmlists.其他.按顺序打印线程.Lock_State_ABC;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import java.util.concurrent.locks.Condition;

/**
 * Created by fengbei
 * on 20-10-15
 * 通过ReentrantLock 实现
 */
public class ReentranLockMain {


    private static int count = 0;

    //  创建2个条件变量 一个为缓冲区非满 一个为缓冲区非空

    //创建一个锁对象
    private Lock lock = new ReentrantLock();
    //创建两个条件变量，一个为缓冲区非满，一个为缓冲区非空
    private final Condition full = lock.newCondition();
    private final Condition empty = lock.newCondition();

    /**
     * 生产者
     */
    class Producer implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                //  模拟生产耗时3s
//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }


                lock.lock();
                try {
                    while (count == 10) {
                        full.await();
                    }
                    count++;
                    System.out.println(Thread.currentThread().getName() + "生产者生产，目前总共有" + count);
                    // 新生产出一个零件
                    empty.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }

        }
    }

    /**
     * 消费者
     */
    class Consumer implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                //  模拟生产耗时3s
//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }


                lock.lock();
                try {
                    while (count == 0) {
                        empty.await();
                    }
                    count--;
                    System.out.println(Thread.currentThread().getName() + "消费者消费，目前总共有" + count);
                    // 新生产出一个零件
                    full.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }

        }
    }



    public static void main(String[] args) {
        ReentranLockMain reentranLockMain = new ReentranLockMain();
        new Thread(reentranLockMain.new Consumer()).start();
        new Thread(reentranLockMain.new Producer()).start();
//        new Thread(waitOrNotifyMain.new Consumer()).start();
//        new Thread(reentranLockMain.new Producer()).start();
    }
}
