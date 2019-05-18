
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by ganbo on 2019/4/2.
 */
@Slf4j
public class Other {

    public static void main(String[] args) {


        final CompareAndSwap cas = new CompareAndSwap();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                int expect = cas.get();
                int setValue = (int) (Math.random() * 100);
                boolean setResult = cas.setNewValue(expect, setValue);
                //System.out.println("expectValue===>" + expect + "  setValue===>" + setValue + " setResult===>" + setResult);
            }).start();
        }

    }


}

//模拟java底层cas算法实现AtomicInteger类
class CompareAndSwap {

    private int value;  //具体值

    //获取旧值
    public synchronized int get() {
        return value;
    }


    /**
     * 比较和替换,返回旧值(为了保证原子性,该方法必须加锁)
     *
     * @param expectValue 期望值
     * @param newValue    新值
     * @return 返回旧值
     */
    public synchronized int compareAndSwap(int expectValue, int newValue) {
        int oldValue = get();   //旧值
        if (oldValue == expectValue) {
            value = newValue;
        }
        System.out.println("==============expectValue===>" + expectValue + "  setValue===>" + oldValue + " setResult===>" + ((oldValue == expectValue)));
        return oldValue;
    }

    /**
     * 设置值
     *
     * @param expect
     * @param newValue
     * @return 返回是否成功
     */
    public synchronized boolean setNewValue(int expect, int newValue) {
        boolean b = expect == compareAndSwap(expect, newValue);
        return b;
    }
}

