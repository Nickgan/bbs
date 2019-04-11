package annotation;

/**
 * Created by gan on 2019/4/10 22:22.
 */
public class FeTest {


    public static void main(String[] args) throws InterruptedException {

        long start = System.currentTimeMillis();
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(1000 * 3);
                System.out.println("包子准备完毕。。。。");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(1000 * 1);
                System.out.println("凉菜准备完毕。。。。");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("==============完毕.....耗时====>" + (System.currentTimeMillis() - start));


    }
}
