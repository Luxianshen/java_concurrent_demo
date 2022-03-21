package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Lujs
 * @desc deal
 * @date 2021/9/8 11:14 上午
 */
public class leetcode3 {


    //https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
    public static void main(String[] args) {
        String s1 = "abcabcbb";
        String s2 = "bbbbbbb";
        String s3 = "pwwkew";
        String s4 = "ckilbkd";
        String s5 = "aab";
        String s6 = "dvdf";
        String s7 = "qrsvbspk";

        System.out.println(lengthOfLongestSubstring(s1));
        System.out.println(lengthOfLongestSubstring(s2));
        System.out.println(lengthOfLongestSubstring(s3));
        System.out.println(lengthOfLongestSubstring(s4));
        System.out.println(lengthOfLongestSubstring(s5));
        System.out.println(lengthOfLongestSubstring(s6));
        System.out.println(lengthOfLongestSubstring(s7));
    }


    public static int lengthOfLongestSubstring(String s) {

        if (s.length() == 1) return 1;
        byte[] bytes = s.getBytes();
        Map<Byte, Integer> map = new HashMap<>();

        int fast = 0;
        int last = 0;
        int length = 0;

        for (int i = 0; i < bytes.length; i++) {
            fast = i;
            if (map.containsKey(bytes[i])) {
                length = Math.max(fast - last, length);
                int now = map.get(bytes[i]) + 1;
                for (int j = last; j < now; j++) {
                    map.remove(bytes[j]);
                }
                last = now;
            }
            map.put(bytes[i], i);
        }

        return Math.max(length, map.size());

    }

}
