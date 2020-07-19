import java.util.concurrent.locks.ReentrantLock;

public class Lock {

    /**
     * 公平锁/非公平锁/可重入锁（递归锁）/自旋锁/读锁/写锁/读写锁
     * ReentrantLock 默认为非公平锁
     *
     */
    public static void main(String[] args) {

        //公平锁 有序排队
        ReentrantLock lock1 = new ReentrantLock(true);
        //非公平锁 允许插队 可能会造成饥饿线程 一直被插队
        ReentrantLock lock2 = new ReentrantLock();
        //可重入锁或递归锁 synchronized 和 ReentrantLock

        //自旋锁 一直递归 直至获得锁 乐观锁 CAS

        //读锁 写锁 读写锁


    }
}
