package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @desc：TODO
 * @date：2021/3/29 11:49 上午
 * @author：Lujs
 */
public class letcode118 {

    public static void main(String[] args) {

        List<List<Integer>> result = generate(3);
        System.out.println("123");
    }

    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>(numRows);

        for (int i = 0; i < numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                temp.add(i);
            }
            result.add(temp);
        }

        return result;
    }
}
