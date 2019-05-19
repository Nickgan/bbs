import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 * "写写"和“读写”都是互斥
 * “读读”不需要互斥
 * Created by gan on 2019/5/19 16:53.
 */
public class ReadWriteLockDemo {

    private static int number = 0;

    //初始化读写锁
    private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();


    public static void main(String[] args) {


        new Thread(() -> {
            //用100个线程去读
            for (Integer i = 0; i < 100; i++) {
                final int j = i;
                new Thread(() -> {
                    read();
                }, i.toString()).start();

            }

        }).start();

        new Thread(() -> {
            //用100个线程去写
            for (Integer i = 0; i < 100; i++) {
                final int j = i;
                new Thread(() -> {
                    write(j);
                }, i.toString()).start();

            }
        }).start();

    }

    /**
     * 读方法
     */
    public static void read() {
        lock.readLock().lock(); //获取读锁
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "读读读-----" + number);
            }
        } catch (Exception e) {
        } finally {
            lock.readLock().unlock(); //finally块里面释放读锁
        }

    }

    public static void write(int num) {
        lock.writeLock().lock(); //获取写锁
        try {
            number = num;
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "写写写++++++" + number);
            }
        } catch (Exception e) {
        } finally {
            lock.writeLock().unlock();  //finally块里面释放写锁
        }

    }

}
