package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @desc：TODO
 * @date：2021/3/26 2:35 下午
 * @author：Lujs
 */
public class letcode48 {


    public static void main(String[] args) {

        String a = "tmmzuxt";
        System.out.println(lengthOfLongestSubstring(a));

    }

    public static int lengthOfLongestSubstring(String s) {

        byte[] a = s.getBytes();
        if (a.length <= 1) return a.length;

        int max = 1;
        int index = 0;
        int end = 1;
        Map<Byte, Integer> map = new HashMap<>();
        map.put(a[0], 0);
        while (index < a.length) {
            if (map.containsKey(a[end])) {
                max = Math.max(max, end - index);
                //连续的时候 直接交换到当前
                if(map.get(a[end]) == end){
                    index = end;
                    end++;
                }
                if(a[index] == a[end]){
                    index++;
                    end++;
                }else {
                    //正常碰撞 前指针后移
                    map.remove(a[index]);
                    index++;
                    if (index >= end) {
                        end++;
                    }
                }
            } else {
                map.put(a[end], end);
                end++;
            }
            if (end == a.length) {
                break;
            }
        }
        return Math.max(max, end - index);
    }

}
