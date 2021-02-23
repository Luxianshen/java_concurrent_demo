package basic;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程交替执行
 */
public class ChangeRunThread {

    public static void main(String[] args) {
        Sout s = new Sout();
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                s.sout5();
            }).start();
        }
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                s.sout10();
            }).start();
        }

    }
}

class Sout {

    public int i = 0;
    public ReentrantLock lock1 = new ReentrantLock();
    public Condition c1 = lock1.newCondition();
    public Condition c2 = lock1.newCondition();

    public void sout5() {
        lock1.lock();
        try {
            while (i != 0) {
                c1.await();
            }
            System.out.println("A");
            i++;
            c2.signal();
        } catch (InterruptedException e) {

        } finally {
            lock1.unlock();
        }
    }

    public void sout10() {
        lock1.lock();
        try {
            while (i != 1) {
                c2.await();
            }
            System.out.println("B");
            i--;
            c1.signal();
        } catch (InterruptedException e) {

        } finally {
            lock1.unlock();
        }


    }
}
