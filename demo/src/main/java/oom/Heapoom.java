package oom;

import cn.hutool.core.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @desc：堆oom
 * @date：2021/3/12 4:43 下午
 * @author：Lujs
 */
public class Heapoom {

    // 1 2 4 8 6 3 7 10

    static class OOM {

    }

    public static void main(String[] args) throws Exception {

        List<OOM> list = new ArrayList<OOM>();
        while(true){
            list.add(new OOM());
        }

    }
}
