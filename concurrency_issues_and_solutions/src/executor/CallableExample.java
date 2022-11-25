package executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableExample implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        System.out.println("Thread "+Thread.currentThread().getName() + " Doing some task");
        return Thread.currentThread().getName();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        List<Future<String>> list = new ArrayList<>();
        Callable<String> callable = new CallableExample();
        for (int i = 0; i < 50; i++) {
            Future<String> future = executor.submit(callable);
            list.add(future);
        }
        for (Future<String> future : list) {
            System.out.println(" The result is : "+future.get());
        }
        executor.shutdown();
    }
}
