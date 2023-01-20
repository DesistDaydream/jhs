package com.moor.imkf.lib.socket.java_websocket.logger;

import com.moor.imkf.lib.socket.java_websocket.logger.Log;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class Logger {
    private static final String ARG_STRING = "{}";
    private static final int ARG_STRING_LENGTH = 2;
    private static final Object UNKNOWN_ARG = new Object();
    private final Log log;

    public Logger(Log log) {
        this.log = log;
    }

    private void appendArg(StringBuilder sb, Object obj) {
        if (obj == UNKNOWN_ARG) {
            return;
        }
        if (obj == null) {
            sb.append("null");
        } else if (obj.getClass().isArray()) {
            sb.append(Arrays.toString((Object[]) obj));
        } else {
            sb.append(obj);
        }
    }

    private String buildFullMessage(String str, Object obj, Object obj2, Object obj3, Object[] objArr) {
        int i2 = 0;
        StringBuilder sb = null;
        int i3 = 0;
        while (true) {
            int indexOf = str.indexOf(ARG_STRING, i2);
            if (indexOf == -1) {
                break;
            }
            if (sb == null) {
                sb = new StringBuilder(128);
            }
            sb.append((CharSequence) str, i2, indexOf);
            i2 = ARG_STRING_LENGTH + indexOf;
            if (objArr == null) {
                if (i3 == 0) {
                    appendArg(sb, obj);
                } else if (i3 == 1) {
                    appendArg(sb, obj2);
                } else if (i3 == 2) {
                    appendArg(sb, obj3);
                }
            } else if (i3 < objArr.length) {
                appendArg(sb, objArr[i3]);
            }
            i3++;
        }
        if (sb == null) {
            return str;
        }
        sb.append((CharSequence) str, i2, str.length());
        return sb.toString();
    }

    private void innerLog(Log.Level level, Throwable th, String str, Object obj, Object obj2, Object obj3, Object[] objArr) {
        if (this.log.isLevelEnabled(level)) {
            String buildFullMessage = buildFullMessage(str, obj, obj2, obj3, objArr);
            if (th == null) {
                this.log.log(level, buildFullMessage);
            } else {
                this.log.log(level, buildFullMessage, th);
            }
        }
    }

    public void debug(String str) {
        Log.Level level = Log.Level.DEBUG;
        Object obj = UNKNOWN_ARG;
        innerLog(level, null, str, obj, obj, obj, null);
    }

    public void error(String str) {
        Log.Level level = Log.Level.ERROR;
        Object obj = UNKNOWN_ARG;
        innerLog(level, null, str, obj, obj, obj, null);
    }

    public void fatal(String str) {
        Log.Level level = Log.Level.FATAL;
        Object obj = UNKNOWN_ARG;
        innerLog(level, null, str, obj, obj, obj, null);
    }

    public void info(String str) {
        Log.Level level = Log.Level.INFO;
        Object obj = UNKNOWN_ARG;
        innerLog(level, null, str, obj, obj, obj, null);
    }

    public boolean isLevelEnabled(Log.Level level) {
        return this.log.isLevelEnabled(level);
    }

    public void log(Log.Level level, String str) {
        Object obj = UNKNOWN_ARG;
        innerLog(level, null, str, obj, obj, obj, null);
    }

    public void trace(String str) {
        Log.Level level = Log.Level.TRACE;
        Object obj = UNKNOWN_ARG;
        innerLog(level, null, str, obj, obj, obj, null);
    }

    public void warn(String str) {
        Log.Level level = Log.Level.WARNING;
        Object obj = UNKNOWN_ARG;
        innerLog(level, null, str, obj, obj, obj, null);
    }

    public void debug(String str, Object obj) {
        Log.Level level = Log.Level.DEBUG;
        Object obj2 = UNKNOWN_ARG;
        innerLog(level, null, str, obj, obj2, obj2, null);
    }

    public void error(String str, Object obj) {
        Log.Level level = Log.Level.ERROR;
        Object obj2 = UNKNOWN_ARG;
        innerLog(level, null, str, obj, obj2, obj2, null);
    }

    public void fatal(String str, Object obj) {
        Log.Level level = Log.Level.FATAL;
        Object obj2 = UNKNOWN_ARG;
        innerLog(level, null, str, obj, obj2, obj2, null);
    }

    public void info(String str, Object obj) {
        Log.Level level = Log.Level.INFO;
        Object obj2 = UNKNOWN_ARG;
        innerLog(level, null, str, obj, obj2, obj2, null);
    }

    public void log(Log.Level level, String str, Object obj) {
        Object obj2 = UNKNOWN_ARG;
        innerLog(level, null, str, obj, obj2, obj2, null);
    }

    public void trace(String str, Object obj) {
        Log.Level level = Log.Level.TRACE;
        Object obj2 = UNKNOWN_ARG;
        innerLog(level, null, str, obj, obj2, obj2, null);
    }

    public void warn(String str, Object obj) {
        Log.Level level = Log.Level.WARNING;
        Object obj2 = UNKNOWN_ARG;
        innerLog(level, null, str, obj, obj2, obj2, null);
    }

    public void debug(String str, Object obj, Object obj2) {
        innerLog(Log.Level.DEBUG, null, str, obj, obj2, UNKNOWN_ARG, null);
    }

    public void error(String str, Object obj, Object obj2) {
        innerLog(Log.Level.ERROR, null, str, obj, obj2, UNKNOWN_ARG, null);
    }

    public void fatal(String str, Object obj, Object obj2) {
        innerLog(Log.Level.FATAL, null, str, obj, obj2, UNKNOWN_ARG, null);
    }

    public void info(String str, Object obj, Object obj2) {
        innerLog(Log.Level.INFO, null, str, obj, obj2, UNKNOWN_ARG, null);
    }

    public void log(Log.Level level, String str, Object obj, Object obj2) {
        innerLog(level, null, str, obj, obj2, UNKNOWN_ARG, null);
    }

    public void trace(String str, Object obj, Object obj2) {
        innerLog(Log.Level.TRACE, null, str, obj, obj2, UNKNOWN_ARG, null);
    }

    public void warn(String str, Object obj, Object obj2) {
        innerLog(Log.Level.WARNING, null, str, obj, obj2, UNKNOWN_ARG, null);
    }

    public void debug(String str, Object obj, Object obj2, Object obj3) {
        innerLog(Log.Level.DEBUG, null, str, obj, obj2, obj3, null);
    }

    public void error(String str, Object obj, Object obj2, Object obj3) {
        innerLog(Log.Level.ERROR, null, str, obj, obj2, obj3, null);
    }

    public void fatal(String str, Object obj, Object obj2, Object obj3) {
        innerLog(Log.Level.FATAL, null, str, obj, obj2, obj3, null);
    }

    public void info(String str, Object obj, Object obj2, Object obj3) {
        innerLog(Log.Level.INFO, null, str, obj, obj2, obj3, null);
    }

    public void log(Log.Level level, String str, Object obj, Object obj2, Object obj3) {
        innerLog(level, null, str, obj, obj2, obj3, null);
    }

    public void trace(String str, Object obj, Object obj2, Object obj3) {
        innerLog(Log.Level.TRACE, null, str, obj, obj2, obj3, null);
    }

    public void warn(String str, Object obj, Object obj2, Object obj3) {
        innerLog(Log.Level.WARNING, null, str, obj, obj2, obj3, null);
    }

    public void debug(String str, Object[] objArr) {
        Log.Level level = Log.Level.DEBUG;
        Object obj = UNKNOWN_ARG;
        innerLog(level, null, str, obj, obj, obj, objArr);
    }

    public void error(String str, Object[] objArr) {
        Log.Level level = Log.Level.ERROR;
        Object obj = UNKNOWN_ARG;
        innerLog(level, null, str, obj, obj, obj, objArr);
    }

    public void fatal(String str, Object[] objArr) {
        Log.Level level = Log.Level.FATAL;
        Object obj = UNKNOWN_ARG;
        innerLog(level, null, str, obj, obj, obj, objArr);
    }

    public void info(String str, Object[] objArr) {
        Log.Level level = Log.Level.INFO;
        Object obj = UNKNOWN_ARG;
        innerLog(level, null, str, obj, obj, obj, objArr);
    }

    public void log(Log.Level level, String str, Object[] objArr) {
        Object obj = UNKNOWN_ARG;
        innerLog(level, null, str, obj, obj, obj, objArr);
    }

    public void trace(String str, Object[] objArr) {
        Log.Level level = Log.Level.TRACE;
        Object obj = UNKNOWN_ARG;
        innerLog(level, null, str, obj, obj, obj, objArr);
    }

    public void warn(String str, Object[] objArr) {
        Log.Level level = Log.Level.WARNING;
        Object obj = UNKNOWN_ARG;
        innerLog(level, null, str, obj, obj, obj, objArr);
    }

    public void debug(Throwable th, String str) {
        Log.Level level = Log.Level.DEBUG;
        Object obj = UNKNOWN_ARG;
        innerLog(level, th, str, obj, obj, obj, null);
    }

    public void error(Throwable th, String str) {
        Log.Level level = Log.Level.ERROR;
        Object obj = UNKNOWN_ARG;
        innerLog(level, th, str, obj, obj, obj, null);
    }

    public void fatal(Throwable th, String str) {
        Log.Level level = Log.Level.FATAL;
        Object obj = UNKNOWN_ARG;
        innerLog(level, th, str, obj, obj, obj, null);
    }

    public void info(Throwable th, String str) {
        Log.Level level = Log.Level.INFO;
        Object obj = UNKNOWN_ARG;
        innerLog(level, th, str, obj, obj, obj, null);
    }

    public void log(Log.Level level, Throwable th, String str) {
        Object obj = UNKNOWN_ARG;
        innerLog(level, th, str, obj, obj, obj, null);
    }

    public void trace(Throwable th, String str) {
        Log.Level level = Log.Level.TRACE;
        Object obj = UNKNOWN_ARG;
        innerLog(level, th, str, obj, obj, obj, null);
    }

    public void warn(Throwable th, String str) {
        Log.Level level = Log.Level.WARNING;
        Object obj = UNKNOWN_ARG;
        innerLog(level, th, str, obj, obj, obj, null);
    }

    public void debug(Throwable th, String str, Object obj) {
        Log.Level level = Log.Level.DEBUG;
        Object obj2 = UNKNOWN_ARG;
        innerLog(level, th, str, obj, obj2, obj2, null);
    }

    public void error(Throwable th, String str, Object obj) {
        Log.Level level = Log.Level.ERROR;
        Object obj2 = UNKNOWN_ARG;
        innerLog(level, th, str, obj, obj2, obj2, null);
    }

    public void fatal(Throwable th, String str, Object obj) {
        Log.Level level = Log.Level.FATAL;
        Object obj2 = UNKNOWN_ARG;
        innerLog(level, th, str, obj, obj2, obj2, null);
    }

    public void info(Throwable th, String str, Object obj) {
        Log.Level level = Log.Level.INFO;
        Object obj2 = UNKNOWN_ARG;
        innerLog(level, th, str, obj, obj2, obj2, null);
    }

    public void log(Log.Level level, Throwable th, String str, Object obj) {
        Object obj2 = UNKNOWN_ARG;
        innerLog(level, th, str, obj, obj2, obj2, null);
    }

    public void trace(Throwable th, String str, Object obj) {
        Log.Level level = Log.Level.TRACE;
        Object obj2 = UNKNOWN_ARG;
        innerLog(level, th, str, obj, obj2, obj2, null);
    }

    public void warn(Throwable th, String str, Object obj) {
        Log.Level level = Log.Level.WARNING;
        Object obj2 = UNKNOWN_ARG;
        innerLog(level, th, str, obj, obj2, obj2, null);
    }

    public void debug(Throwable th, String str, Object obj, Object obj2) {
        innerLog(Log.Level.DEBUG, th, str, obj, obj2, UNKNOWN_ARG, null);
    }

    public void error(Throwable th, String str, Object obj, Object obj2) {
        innerLog(Log.Level.ERROR, th, str, obj, obj2, UNKNOWN_ARG, null);
    }

    public void fatal(Throwable th, String str, Object obj, Object obj2) {
        innerLog(Log.Level.FATAL, th, str, obj, obj2, UNKNOWN_ARG, null);
    }

    public void info(Throwable th, String str, Object obj, Object obj2) {
        innerLog(Log.Level.INFO, th, str, obj, obj2, UNKNOWN_ARG, null);
    }

    public void log(Log.Level level, Throwable th, String str, Object obj, Object obj2) {
        innerLog(level, th, str, obj, obj2, UNKNOWN_ARG, null);
    }

    public void trace(Throwable th, String str, Object obj, Object obj2) {
        innerLog(Log.Level.TRACE, th, str, obj, obj2, UNKNOWN_ARG, null);
    }

    public void warn(Throwable th, String str, Object obj, Object obj2) {
        innerLog(Log.Level.WARNING, th, str, obj, obj2, UNKNOWN_ARG, null);
    }

    public void debug(Throwable th, String str, Object obj, Object obj2, Object obj3) {
        innerLog(Log.Level.DEBUG, th, str, obj, obj2, obj3, null);
    }

    public void error(Throwable th, String str, Object obj, Object obj2, Object obj3) {
        innerLog(Log.Level.ERROR, th, str, obj, obj2, obj3, null);
    }

    public void fatal(Throwable th, String str, Object obj, Object obj2, Object obj3) {
        innerLog(Log.Level.FATAL, th, str, obj, obj2, obj3, null);
    }

    public void info(Throwable th, String str, Object obj, Object obj2, Object obj3) {
        innerLog(Log.Level.INFO, th, str, obj, obj2, obj3, null);
    }

    public void log(Log.Level level, Throwable th, String str, Object obj, Object obj2, Object obj3) {
        innerLog(level, th, str, obj, obj2, obj3, null);
    }

    public void trace(Throwable th, String str, Object obj, Object obj2, Object obj3) {
        innerLog(Log.Level.TRACE, th, str, obj, obj2, obj3, null);
    }

    public void warn(Throwable th, String str, Object obj, Object obj2, Object obj3) {
        innerLog(Log.Level.WARNING, th, str, obj, obj2, obj3, null);
    }

    public void debug(Throwable th, String str, Object[] objArr) {
        Log.Level level = Log.Level.DEBUG;
        Object obj = UNKNOWN_ARG;
        innerLog(level, th, str, obj, obj, obj, objArr);
    }

    public void error(Throwable th, String str, Object[] objArr) {
        Log.Level level = Log.Level.ERROR;
        Object obj = UNKNOWN_ARG;
        innerLog(level, th, str, obj, obj, obj, objArr);
    }

    public void fatal(Throwable th, String str, Object[] objArr) {
        Log.Level level = Log.Level.FATAL;
        Object obj = UNKNOWN_ARG;
        innerLog(level, th, str, obj, obj, obj, objArr);
    }

    public void info(Throwable th, String str, Object[] objArr) {
        Log.Level level = Log.Level.INFO;
        Object obj = UNKNOWN_ARG;
        innerLog(level, th, str, obj, obj, obj, objArr);
    }

    public void log(Log.Level level, Throwable th, String str, Object[] objArr) {
        Object obj = UNKNOWN_ARG;
        innerLog(level, th, str, obj, obj, obj, objArr);
    }

    public void trace(Throwable th, String str, Object[] objArr) {
        Log.Level level = Log.Level.TRACE;
        Object obj = UNKNOWN_ARG;
        innerLog(level, th, str, obj, obj, obj, objArr);
    }

    public void warn(Throwable th, String str, Object[] objArr) {
        Log.Level level = Log.Level.WARNING;
        Object obj = UNKNOWN_ARG;
        innerLog(level, th, str, obj, obj, obj, objArr);
    }
}
