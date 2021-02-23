package basic.Thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Description: 读写锁demo
 * @Author lujs
 * @Date 2020/11/6 15:13
 */
public class ReadWriteLockDemo {

    private static Map<String,Integer> map  = new HashMap<>();

    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private static void get(){
        readWriteLock.readLock();
        System.out.println("开始读取："+Thread.currentThread().getName());
        Integer a = map.get("1");
        System.out.println("结束读取："+Thread.currentThread().getName() + a);
    }

    private static void put(Integer i){
        readWriteLock.writeLock();
        System.out.println("开始写入："+Thread.currentThread().getName());
        map.put("1",i);
        System.out.println("结束写入："+Thread.currentThread().getName());
    }

    public static void main(String[] args) {

        map.put("1",1);
        for (int i = 0; i < 5; i++) {
            final int temp = i;
            new Thread(()->get()).start();
            new Thread(()-> put(temp)).start();
        }

    }

}
