import java.util.concurrent.*;

/**
 * @Description:
 * @Author lujs
 * @Date 2020/7/20 16:35
 */
public class FutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Callable<String> callable =()->{
            TimeUnit.SECONDS.sleep(1);
            return "asd";
        };
        FutureTask<String> task = new FutureTask<>(callable);
        new Thread(task).start();
        while (!task.isDone()){
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(task.get());
        System.out.println(System.currentTimeMillis());
        CountPlus countPlus = new CountPlus();
        Future<Integer> future1 = countPlus.countDouble(12);
        Future<Integer> future2 = countPlus.countDouble(15);
        while (!future1.isDone() && !future2.isDone()) {
            System.out.println("还没算完！");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Integer result1 = future1.get();
        Integer result2 = future2.get();
        System.out.println("future result" + result1 + result2);
        future1.cancel(true);
        future2.cancel(true);
        countPlus.executor.shutdown();
        System.out.println(System.currentTimeMillis());
    }
}

class CountPlus {

    public ExecutorService executor = new ThreadPoolExecutor(2, 3, 3L, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

    public Future<Integer> countDouble(Integer a) {
        return executor.submit(() -> a * a);
    }

}

class ABC implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        return 50*50;
    }
}
