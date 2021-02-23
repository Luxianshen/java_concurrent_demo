package basic.Thread;

import java.util.concurrent.*;

public class ThreadCount {

    /**
     * 线程计数推出
     */
    public static void main1(String[] args) throws InterruptedException {
        //等够数量的线程才能退出
        CountDownLatch countDownLatch = new CountDownLatch(7);

        for (int i = 0; i < 7; i++) {
            new Thread(() -> {
                System.out.println("我是");
                countDownLatch.countDown();
            },"").start();
        }
        countDownLatch.await();
        System.out.println("都结束了");
    }

    public static void main2(String[] args) {
        //集齐
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()-> System.out.println("都结束了"));
        for (int i = 0; i < 7; i++) {
            final int temp = i;
            new Thread(() -> {
                System.out.println("我是"+ temp);
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },"").start();
        }
    }

    public static void main(String[] args) {
        //抢车位
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 7; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println("我抢到了坑位");
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            },String.valueOf(i)).start();
        }
        System.out.println("都结束了");
    }
}
