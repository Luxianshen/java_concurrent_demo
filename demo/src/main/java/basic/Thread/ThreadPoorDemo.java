package basic.Thread;

import java.util.concurrent.*;

public class ThreadPoorDemo {

    /**
     * 线程池相关
     * 7大参数
     *    corePoorSize 核心线程数量
     *    maximumPoorSize 最大大核心线程数
     *    keepAliveTime 线程存活时间
     *    unit 时间单位
     *    workQueue 工作队列
     *              主要使用 1、ArrayBlockingQueue 有限数组队列
     *                      2、LinkedBlockingQueue 有限链表队列 大小21亿 认为无限  结合handle不好 容易导致oom
     *                      3、SynchronousQueue 单一队列 来一个处理一个
     *    ThreadFactory 线程工程名称 主要修改线程名称 方便
     *    handle 队列溢出处理方案
     *             1、AbortPolicy(默认) 直接抛出RejectedExecutionException
     *             2、CallerRunsPolicy 拒绝后，放回原线程
     *             3、DiscardOldestPolicy 把请求放回队列 抛弃时间最久的
     *             4、DiscardPolicy 直接丢弃
     */
    public static void main1(String[] args) {

        /**
         * 线程池参数配置
         *  1、cpu密集型 服务器核心数+1 主要是减少线程上下切换
         *  2、IO密集型  io密集时 线程大部分在等待
         *       a、服务器核心数*2
         *       b、服务器核心数/（1-系数）  系数范围0.8-0.9
         */
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2, 8, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());


        try {
            for (int i = 0; i < 10; i++) {

                threadPoolExecutor.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "执行业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPoolExecutor.shutdown();
        }
        System.out.println("main");
        System.out.println(Runtime.getRuntime().availableProcessors());
    }


    /**
     *
     *  优先级调度系统
     *  分5队列 按优先级排序 优先级最高5队列 1-4队列依次 解决饥饿问题
     *  map list
     *  权重最大的 排序 取线程数 权重= 自身的优先级 *（到达时间+等待时间 允许的最迟返回）
     */
    public static void main(String[] args) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2, 8, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());

        try {
            for (int i = 0; i < 10; i++) {

                threadPoolExecutor.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "执行业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPoolExecutor.shutdown();
        }

        if(threadPoolExecutor.getActiveCount() == threadPoolExecutor.getMaximumPoolSize()){
            //保证下一次执行 后面算权重
            BlockingQueue<Runnable> queue = threadPoolExecutor.getQueue();

        }

    }

}

