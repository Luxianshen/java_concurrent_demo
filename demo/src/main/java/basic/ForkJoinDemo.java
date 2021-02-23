package basic;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;


/**
 * @Description:
 * @Author lujs
 * @Date 2020/8/6 16:44
 */
public class ForkJoinDemo {

    /**
     * 数据量不大的话 forkjoin的实际效率不如foreach 主要在于线程维护的开销
     */
    public static void main(String[] args) {
        long[] a = new long[1000001];
        for (int i = 0; i < 1000001; i++) {
            a[i] = i;
        }
        System.out.println(System.currentTimeMillis());
//        Long result = 0L;
//        for (long b:a) {
//            result += b;
//        }
        ForkJoinTask<Long> task = new SumTotal(a,1,a.length);
        Long result = ForkJoinPool.commonPool().invoke(task);
        System.out.println(result);
        System.out.println(System.currentTimeMillis());
    }


}


class SumTotal extends RecursiveTask<Long> {

    private static final int THRESHOLD = 100000;
    private long[] array;
    private int start;
    private int end;

    SumTotal(long[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {

        if (end - start <= THRESHOLD) {
            // 如果任务足够小,直接计算:
            long sum = 0;
            for (int i = start; i < end; i++) {
                sum += this.array[i];
            }
            return sum;
        }

        int middle = (end + start) / 2;
        System.out.println(String.format("split %d~%d ==> %d~%d, %d~%d", start, end, start, middle, middle, end));
        SumTotal sumTotal = new SumTotal(this.array, start, middle);
        SumTotal sumTotal2 = new SumTotal(this.array, middle, end);
        invokeAll(sumTotal, sumTotal2);
        Long subresult1 = sumTotal.join();
        Long subresult2 = sumTotal2.join();
        Long result = subresult1 + subresult2;
        System.out.println("result = " + subresult1 + " + " + subresult2 + " ==> " + result);
        return result;
    }

}