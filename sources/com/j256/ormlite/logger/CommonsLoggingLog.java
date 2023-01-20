package com.j256.ormlite.logger;

import com.j256.ormlite.logger.Log;
import org.apache.commons.logging.LogFactory;

/* loaded from: classes2.dex */
public class CommonsLoggingLog implements Log {
    private final org.apache.commons.logging.Log log;

    /* renamed from: com.j256.ormlite.logger.CommonsLoggingLog$1  reason: invalid class name */
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

    public CommonsLoggingLog(String str) {
        this.log = LogFactory.getLog(str);
    }

    @Override // com.j256.ormlite.logger.Log
    public boolean isLevelEnabled(Log.Level level) {
        switch (AnonymousClass1.$SwitchMap$com$j256$ormlite$logger$Log$Level[level.ordinal()]) {
            case 1:
                return this.log.isTraceEnabled();
            case 2:
                return this.log.isDebugEnabled();
            case 3:
                return this.log.isInfoEnabled();
            case 4:
                return this.log.isWarnEnabled();
            case 5:
                return this.log.isErrorEnabled();
            case 6:
                return this.log.isFatalEnabled();
            default:
                return this.log.isInfoEnabled();
        }
    }

    @Override // com.j256.ormlite.logger.Log
    public void log(Log.Level level, String str) {
        switch (AnonymousClass1.$SwitchMap$com$j256$ormlite$logger$Log$Level[level.ordinal()]) {
            case 1:
                this.log.trace(str);
                return;
            case 2:
                this.log.debug(str);
                return;
            case 3:
                this.log.info(str);
                return;
            case 4:
                this.log.warn(str);
                return;
            case 5:
                this.log.error(str);
                return;
            case 6:
                this.log.fatal(str);
                return;
            default:
                this.log.info(str);
                return;
        }
    }

    @Override // com.j256.ormlite.logger.Log
    public void log(Log.Level level, String str, Throwable th) {
        switch (AnonymousClass1.$SwitchMap$com$j256$ormlite$logger$Log$Level[level.ordinal()]) {
            case 1:
                this.log.trace(str, th);
                return;
            case 2:
                this.log.debug(str, th);
                return;
            case 3:
                this.log.info(str, th);
                return;
            case 4:
                this.log.warn(str, th);
                return;
            case 5:
                this.log.error(str, th);
                return;
            case 6:
                this.log.fatal(str, th);
                return;
            default:
                this.log.info(str, th);
                return;
        }
    }
}
