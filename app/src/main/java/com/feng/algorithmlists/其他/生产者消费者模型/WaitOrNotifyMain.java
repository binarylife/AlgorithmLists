package com.feng.algorithmlists.其他.生产者消费者模型;

/**
 * Created by fengbei
 * on 20-10-15
 * 通过wait或者notify方式 实现
 */
public class WaitOrNotifyMain {

    private int count = 0;
    private static String Lock = "lock";


    /**
     * 生产者
     */
    class Producer implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                //  模拟生产耗时3s
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                synchronized (Lock) {
                    while (count == 10) {
                        try {
                            Lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count++;
                    System.out.println(Thread.currentThread().getName() + "生产者生产，目前总共有" + count);
                    Lock.notifyAll();
                }
                // 新生产出一个零件

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
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                synchronized (Lock) {
                    while (count == 0) {
                        try {
                            Lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count--;
                    System.out.println(Thread.currentThread().getName() + "消费者消费，目前总共有" + count);
                    Lock.notifyAll();
                }
                // 新生产出一个零件

            }
        }
    }

    public static void main(String[] args) {
        WaitOrNotifyMain waitOrNotifyMain = new WaitOrNotifyMain();
        new Thread(waitOrNotifyMain.new Producer()).start();
        new Thread(waitOrNotifyMain.new Consumer()).start();
//        new Thread(waitOrNotifyMain.new Consumer()).start();
//        new Thread(waitOrNotifyMain.new Producer()).start();
    }

}
