package tools.log;

import com.google.common.base.Throwables;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

/**
 * Created by yaoguang on 2021/2/20 09:41.
 * Description:
 *
 * @author <a href="mailto:chenxiaohui@cai-inc.com"/>
 */
@Slf4j
public class LogUtils {
    public static final int DEBUG = 0;
    public static final int INFO = 1;
    public static final int WARN = 2;
    public static final int ERROR = 3;

    public static void errorLog(String desc, Exception e, Object... params) {
        baseLog(ERROR, addPrefix(desc) + " error: " + Throwables.getStackTraceAsString(e), params);
    }

    public static void errorLog(String desc, Object... params) {
        baseLog(ERROR, addPrefix(desc), params);
    }

    public static void warnLog(String desc, Object... params) {
        baseLog(WARN, addPrefix(desc), params);
    }

    public static void infoLog(String desc, Object... params) {
        baseLog(INFO, addPrefix(desc), params);
    }

    private static String addPrefix(String desc) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
        return StringUtils.substringAfterLast(stackTraceElement.getClassName(), ".") + "." + stackTraceElement.getMethodName() + " " + desc;
    }

    private static void baseLog(int level, String desc, Object... params) {
        if (params.length == 0) {
            log(level, desc, params);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(desc);
        sb.append(" ");
        for (Object param : params) {
            sb.append(" param:{} ");
        }
        log(level, sb.toString(), params);
    }

    private static void log(int level, String desc, Object... params) {
        if (level == DEBUG) {
            log.debug(desc, params);
            return;
        }
        if (level == INFO) {
            log.info(desc, params);
            return;
        }
        if (level == WARN) {
            log.warn(desc, params);
            return;
        }
        if (level == ERROR) {
            log.error(desc, params);
            return;
        }
    }
}
