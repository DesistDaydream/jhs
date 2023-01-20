package com.j256.ormlite.logger;

import com.j256.ormlite.logger.Log;
import java.util.logging.Level;

/* loaded from: classes2.dex */
public class JavaUtilLog implements Log {
    private final java.util.logging.Logger logger;

    /* renamed from: com.j256.ormlite.logger.JavaUtilLog$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$j256$ormlite$logger$Log$Level;

        static {
            int[] iArr = new int[Log.Level.values().length];
            $SwitchMap$com$j256$ormlite$logger$Log$Level = iArr;
            try {
                iArr[Log.Level.TRACE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$j256$ormlite$logger$Log$Level[Log.Level.DEBUG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$j256$ormlite$logger$Log$Level[Log.Level.INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$j256$ormlite$logger$Log$Level[Log.Level.WARNING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$j256$ormlite$logger$Log$Level[Log.Level.ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$j256$ormlite$logger$Log$Level[Log.Level.FATAL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public JavaUtilLog(String str) {
        this.logger = java.util.logging.Logger.getLogger(str);
    }

    private Level levelToJavaLevel(Log.Level level) {
        switch (AnonymousClass1.$SwitchMap$com$j256$ormlite$logger$Log$Level[level.ordinal()]) {
            case 1:
                return Level.FINER;
            case 2:
                return Level.FINE;
            case 3:
                return Level.INFO;
            case 4:
                return Level.WARNING;
            case 5:
                return Level.SEVERE;
            case 6:
                return Level.SEVERE;
            default:
                return Level.INFO;
        }
    }

    @Override // com.j256.ormlite.logger.Log
    public boolean isLevelEnabled(Log.Level level) {
        return this.logger.isLoggable(levelToJavaLevel(level));
    }

    @Override // com.j256.ormlite.logger.Log
    public void log(Log.Level level, String str) {
        this.logger.log(levelToJavaLevel(level), str);
    }

    @Override // com.j256.ormlite.logger.Log
    public void log(Log.Level level, String str, Throwable th) {
        this.logger.log(levelToJavaLevel(level), str, th);
    }
}
