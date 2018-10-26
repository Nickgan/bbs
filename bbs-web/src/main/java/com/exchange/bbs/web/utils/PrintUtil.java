package com.exchange.bbs.web.utils;

import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 日志打印记录工具
 *
 * @author lx
 */
public class PrintUtil {
    private static final SimpleDateFormat sdf = new SimpleDateFormat(
            "yyyy年MM月dd HH:mm:ss");
    private static final Logger logger = Logger.getLogger("printlog");

    public static final String nodeName = PrintUtil.class.getResource("").getPath().contains("node") ? PrintUtil.class.getResource("")
            .getPath().substring(PrintUtil.class.getResource("").getPath().indexOf("node"), PrintUtil.class.getResource("").getPath()
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
