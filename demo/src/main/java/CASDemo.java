import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class CASDemo {

    /**
     * CAS compareAndSet 比较和交换值
     * 问题
     * 单一值可改 性能低
     * 并发时，cpu损耗比较大 ，自旋
     * ABA问题  （其他线程太快导致的值被修改为原来的值，解决添加版本号）
     */
    public static void main(String[] args) throws InterruptedException {

        AtomicInteger atomicInteger = new AtomicInteger(0);
        new Thread(() -> {
            if (atomicInteger.compareAndSet(0, 30)) {
                System.out.println("30");
            }
        }, Thread.currentThread().getName() + "我把值改为了30").start();
        Thread.sleep(1);
        new Thread(() -> {
            if (atomicInteger.compareAndSet(0, 20)) {
                System.out.println("20");
            }
        }, Thread.currentThread().getName() + "我把值改为了20").start();

    }

}


    /**
       自旋代码
       public final int getAndAddInt(Object var1, long var2, int var4) {
        int var5;
        do {
            var5 = this.getIntVolatile(var1, var2);
        } while(!this.compareAndSwapInt(var1, var2, var5, var5 + var4));

        return var5;
    }**/


