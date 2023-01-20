package com.moor.imkf.lib.socket.java_websocket.logger;

import com.moor.imkf.lib.socket.java_websocket.logger.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class LocalLog implements Log {
    public static final String LOCAL_LOG_FILE_PROPERTY = " com.moor.imkf.lib.socket.ormlite.logger.file";
    public static final String LOCAL_LOG_LEVEL_PROPERTY = " com.moor.imkf.lib.socket.ormlite.logger.level";
    public static final String LOCAL_LOG_PROPERTIES_FILE = "/ormliteLocalLog.properties";
    private static PrintStream printStream;
    private final String className;
    private final Log.Level level;
    private static final Log.Level DEFAULT_LEVEL = Log.Level.DEBUG;
    private static final ThreadLocal<DateFormat> dateFormatThreadLocal = new ThreadLocal<DateFormat>() { // from class: com.moor.imkf.lib.socket.java_websocket.logger.LocalLog.1
        @Override // java.lang.ThreadLocal
        public DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");
        }
    };
    private static final List<PatternLevel> classLevels = readLevelResourceFile(LocalLog.class.getResourceAsStream("/ormliteLocalLog.properties"));

    /* loaded from: classes2.dex */
    public static class PatternLevel {
        public Log.Level level;
        public Pattern pattern;

        public PatternLevel(Pattern pattern, Log.Level level) {
            this.pattern = pattern;
            this.level = level;
        }
    }

    static {
        openLogFile(System.getProperty(LOCAL_LOG_FILE_PROPERTY));
    }

    public LocalLog(String str) {
        this.className = LoggerFactory.getSimpleClassName(str);
        List<PatternLevel> list = classLevels;
        Log.Level level = null;
        if (list != null) {
            for (PatternLevel patternLevel : list) {
                if (patternLevel.pattern.matcher(str).matches() && (level == null || patternLevel.level.ordinal() < level.ordinal())) {
                    level = patternLevel.level;
                }
            }
        }
        if (level == null) {
            String property = System.getProperty(LOCAL_LOG_LEVEL_PROPERTY);
            if (property == null) {
                level = DEFAULT_LEVEL;
            } else {
                try {
                    level = Log.Level.valueOf(property.toUpperCase());
                } catch (IllegalArgumentException e2) {
                    throw new IllegalArgumentException("Level '" + property + "' was not found", e2);
                }
            }
        }
        this.level = level;
    }

    private static List<PatternLevel> configureClassLevels(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        ArrayList arrayList = new ArrayList();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return arrayList;
            }
            if (readLine.length() != 0 && readLine.charAt(0) != '#') {
                String[] split = readLine.split("=");
                if (split.length != 2) {
                    PrintStream printStream2 = System.err;
                    printStream2.println("Line is not in the format of 'pattern = level': " + readLine);
                } else {
                    try {
                        arrayList.add(new PatternLevel(Pattern.compile(split[0].trim()), Log.Level.valueOf(split[1].trim())));
                    } catch (IllegalArgumentException unused) {
                        PrintStream printStream3 = System.err;
                        printStream3.println("Level '" + split[1] + "' was not found");
                    }
                }
            }
        }
    }

    public static void openLogFile(String str) {
        if (str == null) {
            printStream = System.out;
            return;
        }
        try {
            printStream = new PrintStream(new File(str));
        } catch (FileNotFoundException e2) {
            throw new IllegalArgumentException("Log file " + str + " was not found", e2);
        }
    }

    private void printMessage(Log.Level level, String str, Throwable th) {
        if (isLevelEnabled(level)) {
            StringBuilder sb = new StringBuilder(128);
            sb.append(dateFormatThreadLocal.get().format(new Date()));
            sb.append(" [");
            sb.append(level.name());
            sb.append("] ");
            sb.append(this.className);
            sb.append(' ');
            sb.append(str);
            printStream.println(sb.toString());
            if (th != null) {
                th.printStackTrace(printStream);
            }
        }
    }

    public static List<PatternLevel> readLevelResourceFile(InputStream inputStream) {
        try {
            if (inputStream != null) {
                try {
                    List<PatternLevel> configureClassLevels = configureClassLevels(inputStream);
                    try {
                        inputStream.close();
                        return configureClassLevels;
                    } catch (IOException unused) {
                        return configureClassLevels;
                    }
                } catch (IOException e2) {
                    PrintStream printStream2 = System.err;
                    printStream2.println("IO exception reading the log properties file '/ormliteLocalLog.properties': " + e2);
                    try {
                        inputStream.close();
                    } catch (IOException unused2) {
                    }
                }
            }
            return null;
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (IOException unused3) {
            }
            throw th;
        }
    }

    public void flush() {
        printStream.flush();
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.logger.Log
    public boolean isLevelEnabled(Log.Level level) {
        return this.level.isEnabled(level);
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.logger.Log
    public void log(Log.Level level, String str) {
        printMessage(level, str, null);
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.logger.Log
    public void log(Log.Level level, String str, Throwable th) {
        printMessage(level, str, th);
    }
}
