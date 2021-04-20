package basic;

import java.util.concurrent.CompletableFuture;
import static java.lang.Thread.sleep;

/**
 * @desc：TODO
 * @date：2021/3/30 9:22 上午
 * @author：Lujs
 */
public class CompletableFutureDemo {

    public static void main(String[] args) {
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> {
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "a";
        }).exceptionally(e->"0");
        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> "b");

        //汇聚关系
        CompletableFuture<String> f3 = f1.thenCombine(f2, (a, tf) -> a + tf);
        System.out.println(f3.join());

        //or关系 会存结果 要先注解f3
        CompletableFuture<String> f4 = f1.applyToEither(f2, s -> s);
        System.out.println(f4.join());

        //and关系
        CompletableFuture<String> f5 = CompletableFuture.supplyAsync(() -> "hello").
                thenApply(a->a+"2ee").thenApply(String::toUpperCase);

        System.out.println(f5.join());

    }
}
