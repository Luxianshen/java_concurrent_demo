package basic;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class Collection {

    /**
     * java 常用多线程对象
     * List Set Map
     * 多线程下 不安全的会报ConcurrentModificationException
     * 线程安全对应的方法
     *
     * hashmap的实现
     *     1.7及之前 链表和数组
     *              key转化为hashcode定位桶 数据有序按链表存储
     *     1.8 链表和红黑树
     *
     */
    public static void main(String[] args) {
        //性能低下 jdk1.1
        Vector vector = new Vector();
        List list = Collections.synchronizedList(new ArrayList<>());
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        //set  set的底层实现是hashMap 只用key值 value是一个对象 null
        Set set = Collections.synchronizedSet(new HashSet<>());
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        //map hashMap 1.8后底层使用红黑树现实 涉及相关 二叉树 平衡二叉树 红黑树
        //concurrentHashMap 性能比较好的原因是 使用局部加锁
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();

    }
}
