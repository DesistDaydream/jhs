package com.j256.ormlite.logger;

import com.j256.ormlite.logger.Log;

/* loaded from: classes2.dex */
public class LoggerFactory {
    public static final String LOG_TYPE_SYSTEM_PROPERTY = "com.j256.ormlite.logger.type";
    private static LogType logType;

    /* loaded from: classes2.dex */
    public enum LogType {
        SLF4J("org.slf4j.LoggerFactory", "com.j256.ormlite.logger.Slf4jLoggingLog"),
        ANDROID("android.util.Log", "com.j256.ormlite.android.AndroidLog"),
        COMMONS_LOGGING("org.apache.commons.logging.LogFactory", "com.j256.ormlite.logger.CommonsLoggingLog"),
        LOG4J2("org.apache.logging.log4j.LogManager", "com.j256.ormlite.logger.Log4j2Log"),
        LOG4J("org.apache.log4j.Logger", "com.j256.ormlite.logger.Log4jLog"),
        LOCAL(LocalLog.class.getName(), LocalLog.class.getName()) { // from class: com.j256.ormlite.logger.LoggerFactory.LogType.1
            @Override // com.j256.ormlite.logger.LoggerFactory.LogType
            public Log createLog(String str) {
                return new LocalLog(str);
            }

            @Override // com.j256.ormlite.logger.LoggerFactory.LogType
            public boolean isAvailable() {
                return true;
            }
        },
        JAVA_UTIL("java.util.logging.Logger", "com.j256.ormlite.logger.JavaUtilLog");
        
        private final String detectClassName;
        private final String logClassName;

        private Log createLogFromClassName(String str) throws Exception {
            return (Log) Class.forName(this.logClassName).getConstructor(String.class).newInstance(str);
        }

        public Log createLog(String str) {
            try {
                return createLogFromClassName(str);
            } catch (Exception e2) {
                LocalLog localLog = new LocalLog(str);
                Log.Level level = Log.Level.WARNING;
                localLog.log(level, "Unable to call constructor with single String argument for class " + this.logClassName + ", so had to use local log: " + e2.getMessage());
                return localLog;
            }
        }

        public boolean isAvailable() {
            if (isAvailableTestClass()) {
                try {
                    createLogFromClassName(getClass().getName()).isLevelEnabled(Log.Level.INFO);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
            return false;
        }

        public boolean isAvailableTestClass() {
            try {
                Class.forName(this.detectClassName);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        LogType(String str, String str2) {
            this.detectClassName = str;
            this.logClassName = str2;
        }
    }

    private LoggerFactory() {
    }

    private static LogType findLogType() {
        LogType[] values;
        String property = System.getProperty(LOG_TYPE_SYSTEM_PROPERTY);
        if (property != null) {
            try {
                return LogType.valueOf(property);
            } catch (IllegalArgumentException unused) {
                new LocalLog(LoggerFactory.class.getName()).log(Log.Level.WARNING, "Could not find valid log-type from system property 'com.j256.ormlite.logger.type', value '" + property + "'");
            }
        }
        for (LogType logType2 : LogType.values()) {
            if (logType2.isAvailable()) {
                return logType2;
            }
        }
        return LogType.LOCAL;
    }

    public static Logger getLogger(Class<?> cls) {
        return getLogger(cls.getName());
    }

    public static String getSimpleClassName(String str) {
        String[] split = str.split("\\.");
        return split.length <= 1 ? str : split[split.length - 1];
    }

    public static Logger getLogger(String str) {
        if (logType == null) {
            logType = findLogType();
        }
        return new Logger(logType.createLog(str));
    }
}
