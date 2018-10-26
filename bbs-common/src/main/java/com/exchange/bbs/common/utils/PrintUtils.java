package com.exchange.bbs.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 日志打印记录工具
 *
 * @author lx
 */
public class PrintUtils {
    private static final SimpleDateFormat sdf = new SimpleDateFormat(
            "yyyy年MM月dd HH:mm:ss");
    private static final Logger logger = LoggerFactory.getLogger("printlog");
    public static final String nodeName = PrintUtils.class.getResource("").getPath().contains("node") ? PrintUtils.class.getResource("")
            .getPath().substring(PrintUtils.class.getResource("").getPath().indexOf("node"), PrintUtils.class.getResource("").getPath()
                    .indexOf("node") + 5) : "node-unknow";

    public static void print(Object msg) {
        synchronized (sdf) {
            StackTraceElement[] temp = Thread.currentThread().getStackTrace();
            StackTraceElement method = (StackTraceElement) temp[2];
            for (StackTraceElement stackTraceElement : temp) {
                if (stackTraceElement.getClassName().contains("police")
                        && !stackTraceElement.getClassName().contains("CGLIB")
                        && !stackTraceElement.getMethodName().equals("print")
                        && !stackTraceElement.getMethodName().equals("around")) {
                    method = stackTraceElement;
                    break;
                }
            }
            String msgStr = msg == null ? "" : msg.toString();
            if (msgStr.trim().equals("")) {
                msgStr = "Nothing.";
            }
            msgStr = sdf.format(Calendar.getInstance().getTime())
                    + " "
                    + msgStr
                    + " @来自："
                    + method.getClassName().replaceAll(
                    "cn\\.mugutu\\.wxp\\.", "") + "."
                    + method.getMethodName() + "() line@"
                    + method.getLineNumber();
            logger.info(msgStr);
        }
    }
}
