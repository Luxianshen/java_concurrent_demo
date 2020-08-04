import java.util.concurrent.atomic.AtomicInteger;

public class VolatiteDemo {


    /**
     * volatite 轻量级的同步机制
     *  1、可见性
     *  2、不保证原子性
     *  3、禁止指令重排（因为线程的调用顺序不定，存在获取数据的差异，没有数据依赖的数据，会造成不同的结果。）
     *
     *  解决方法
     *   synchronized 笨重
     *   AtomicInteger sun.misc包 unsafe类 native方法 直接操作cpu 保证原子性
     *
     */
    public static void main(String[] args) {

        Test test = new Test();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    test.addSafe();
                }
            },Thread.currentThread().getName()).start();
        }
        while (Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.println(test.a);
        System.out.println(test.atomicInteger);

    }
}

class Test{

    volatile int a = 0;

    AtomicInteger atomicInteger = new AtomicInteger();

    public void add(){
        a++;
    }

    public void addSafe(){
        atomicInteger.getAndIncrement();
    }
}

/**
 * 单例模式下的不安全 因为指令重排 获取到的可能是个只分配了地址的对象
 */

class InstanceDemo{

    static  InstanceDemo instanceDemo = null;

    public static InstanceDemo getInstance(){
        if(instanceDemo ==null){
            synchronized (InstanceDemo.class){
                if(instanceDemo ==null){
                    return new InstanceDemo();
                }
            }
        }
        return instanceDemo;
    }

    public static void main(String[] args) {
        InstanceDemo instanceDemo = getInstance();
        System.out.println(instanceDemo);
    }
}
