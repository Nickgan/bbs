import com.exchange.bbs.entity.bbslog.BbsLog;
import com.exchange.bbs.enums.BbsLogType;
import com.exchange.bbs.log.LogApplication;
import com.exchange.bbs.log.repository.BbsLogRepository;
import com.exchange.bbs.log.service.BbsLogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gan
 * @date 2018/11/28 10:44 AM
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LogApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LogServiceTest {

    @Autowired
    private BbsLogService bbsLogService;
    @Autowired
    private BbsLogRepository bbsLogRepository;

    @Test
    public void saveTest() {
        int i = 1;
        List<BbsLog> list = new ArrayList<>(50000);
        while (true) {
            BbsLog bbsLog = new BbsLog();
            bbsLog.setIp("192.168.1." + i);
            bbsLog.setOperation("操作" + i);
            bbsLog.setDescription("bruce" + i);
            bbsLog.setUsername("bruce" + i);
            if (i % 2 == 0) {
                bbsLog.setBbsLogType(BbsLogType.Exception);
            }
            bbsLog.setUserId(i + "");

            list.add(bbsLog);
            if (list.size() == 50000) {
                bbsLogRepository.saveAll(list);
                list = new ArrayList<>(50000);
            }

            System.out.println("===============>" + (++i));
        }
    }

}
