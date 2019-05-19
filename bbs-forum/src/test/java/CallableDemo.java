import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * Created by gan on 2019/5/19 9:25.
 */
public class CallableDemo implements Callable<Integer> {


    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
            TimeUnit.MILLISECONDS.sleep(80);
            System.out.println("sum==========>" + sum + "  index====>" + i);
        }
        return sum;
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CallableDemo callableDemo = new CallableDemo();
        FutureTask<Integer> futureTask = new FutureTask(callableDemo);
        Thread t = new Thread(futureTask);
        t.start();
        Integer o = futureTask.get();
        System.out.println("==================>" + o);

    }
}
