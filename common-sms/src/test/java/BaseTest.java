import java.util.concurrent.ConcurrentHashMap;

/**
 * test
 *
 * @author gan
 * @date 2018/11/22 2:55 PM
 */
public class BaseTest {

    public static void main(String[] args) {
        ConcurrentHashMap<String, Object> maps = new ConcurrentHashMap<>();
        Object put = maps.put("00001", new Object());
        Object ifAbsent = maps.putIfAbsent("00001", new Object());
        Object ifAbsent2 = maps.putIfAbsent("00002", new Object());

        System.out.println(put + "   :  " + ifAbsent + "  :   " + ifAbsent2);

    }
}
