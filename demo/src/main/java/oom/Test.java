package oom;

import java.util.HashMap;

/**
 * @desc：TODO
 * @date：2021/2/21 9:51 下午
 * @author：Lujs
 */
public class Test {

    public static void main(String[] args) {
        System.out.println("start");
        HashMap<Integer,Integer> map  = new HashMap(4);
        for (int i = 1; i < 10; i++) {
            final int a = i;
            new Thread(()->{
                map.put(0,a);
            }).start();
        }
        System.out.println("end");
    }
}
