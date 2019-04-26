import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by gan on 2019/4/22 21:51.
 */
public class Other {


    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(10); //创建固定线程数目的线程池
        for (int i = 0; i < 20; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 2; j++) {
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + "=================================>" + j);
                    }
                }
            });
        }

        System.out.println("==============================end=====");
    }
}
