package oom;

import cn.hutool.core.util.RandomUtil;

import java.util.HashMap;

/**
 * @desc：TODO
 * @date：2021/2/21 9:51 下午
 * @author：Lujs
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("start");
        while (true){
            System.out.println(RandomUtil.randomInt(10));
            //Thread.sleep(100);
        }
    }
}
