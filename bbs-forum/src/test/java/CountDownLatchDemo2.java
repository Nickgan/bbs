import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by gan on 2019/5/19 0:05.
 */
public class CountDownLatchDemo2 {

    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(10);
        long start = System.currentTimeMillis();

        for (int i = 0; i < 10; i++) {
            int j = i;
            new Thread(() -> {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName() + "执行完毕....." + j);
                } catch (InterruptedException e) {
                } finally {
                    countDownLatch.countDown();
                }
            }).start();
        }

        System.out.println("主线程等待子线程完成。。。。");
        countDownLatch.await(); //主线程到此进入阻塞状态,等待 countDownLatch.countDown()减为0后才进入就绪->执行
        System.out.println("所有线程执行完毕，一共耗时===================>" + (System.currentTimeMillis() - start));

    }
}
