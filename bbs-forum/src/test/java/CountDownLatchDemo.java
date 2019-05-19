import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 闭锁测试
 * Created by gan on 2019/5/18 22:47.
 */
public class CountDownLatchDemo {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(3);


        Boss b1 = new Boss(countDownLatch);
        Worker w1 = new Worker(countDownLatch, "小王");
        Worker w2 = new Worker(countDownLatch, "校长");
        Worker w3 = new Worker(countDownLatch, "小李");

        executor.execute(b1);
        executor.execute(w1);
        executor.execute(w2);
        executor.execute(w3);

        executor.shutdown();
    }
}


//工人类
class Worker implements Runnable {

    private CountDownLatch countDownLatch;
    private String name;

    public Worker(CountDownLatch countDownLatch, String name) {
        this.countDownLatch = countDownLatch;
        this.name = name;
    }

    @Override
    public void run() {
        this.work();
        try {
            TimeUnit.SECONDS.sleep(new Random().nextInt(10));
        } catch (InterruptedException e) {
        } finally {
            this.countDownLatch.countDown(); //闭锁计数器减一
        }
    }

    private void work() {
        System.out.println(this.name + "正在干活。");
    }

}


//老板类
class Boss implements Runnable {

    private CountDownLatch countDownLatch;

    public Boss(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println("老板正在等待所有公认干完活....");
        try {
            this.countDownLatch.await();
        } catch (InterruptedException e) {
        }
        System.out.println("工人们都干完活了,老板开始检查了!!!!!!!!!!!!!!");
    }
}
