package leetCode;

import java.util.*;

/**
 * @desc：coin-change
 * @date：2021/3/19 3:05 下午
 * @author：Lujs
 */
public class letcode322 {

    public static void main(String[] args) {

        int[] a = new int[]{186,419,83,408};
        System.out.println(coinChange(a,6249));

    }

    public static int coinChange(int[] a, int b) {

        List<List<Integer>> lists = new ArrayList<>();
        int result = 0;
        Arrays.sort(a);
        if (a[0] > b) return -1;
        //能算出 不能算出
        //定位b
       /* int start = 0;
        for (int i = a.length - 1; i > 0; i--) {
            if (b >= a[i]) {
                start = i;
                break;
            }
        }*/
        boolean flag = false;

        int remian = 0;
        //最优解4 最差解b/最小 最优接近解 正向余数最小
        //遍历开始位置
        for (int i = a.length-1; i > 0; i--) {
            List<Integer> tempList  = new ArrayList<>();
            int k = i;
            int j = b;
            while (k >= 0) {
                if(j >= a[k]){
                    tempList.add(j / a[k]);
                    j = j % a[k];
                    if (j == 0) {
                        flag = true;
                        break;
                    }
                }else {
                    tempList.add(0);
                }
                if(k-1==0){
                    if(remian > 0 && a[0]-j <0){
                        tempList.add(j);
                        lists.add(tempList);
                        break;
                    }else {
                        remian = j;
                        tempList.add(remian);
                        lists.add(tempList);
                    }
                }
                k--;
            }
            if(flag) break;
        }
        //遍历？？

        return flag ? result : -1;
    }


}
