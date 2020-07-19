import java.util.concurrent.TimeUnit;

public class DeadLock {

    /**
     * 死锁
     * 抢夺相同的内存地址的值导致的死锁
     */
    public static void main(String[] args) {

        new Thread(new HoldLock("a","b"),"AAA").start();
        new Thread(new HoldLock("b","a"),"BBB").start();
    }

}

class HoldLock implements Runnable{

    private String lockA;
    private String lockB;

    public HoldLock(String lockA,String lockB){
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName()+"我持有A"+lockA);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }synchronized (lockB){
                System.out.println("尝试获取B"+lockB);
            }
        }
    }
}
