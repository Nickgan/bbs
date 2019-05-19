import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * Created by gan on 2019/5/19 10:01.
 */
public class FutureTaskAndCallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("计算线程正在努力的计算结果....");
                TimeUnit.SECONDS.sleep(6);
                return 100;
            }
        };


        FutureTask<Integer> futureTask = new FutureTask<Integer>(callable);
        Thread thread = new Thread(futureTask);
        thread.start();

        System.out.println("main线程干点别的任务...");

        Integer result = futureTask.get();
        System.out.println("从计算线程拿到的结果为: " + result);

    }
}
