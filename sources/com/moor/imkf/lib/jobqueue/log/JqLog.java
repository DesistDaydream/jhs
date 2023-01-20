package com.moor.imkf.lib.jobqueue.log;

import com.moor.imkf.lib.utils.MoorLogUtils;

/* loaded from: classes2.dex */
public class JqLog {
    private static CustomLogger customLogger;

    /* loaded from: classes2.dex */
    public static class ErrorLogger implements CustomLogger {
        private static final String TAG = "JobManager";

        @Override // com.moor.imkf.lib.jobqueue.log.CustomLogger
        public void d(String str, Object... objArr) {
        }

        @Override // com.moor.imkf.lib.jobqueue.log.CustomLogger
        public void e(Throwable th, String str, Object... objArr) {
            MoorLogUtils.e(TAG, String.format(str, objArr), th);
        }

        @Override // com.moor.imkf.lib.jobqueue.log.CustomLogger
        public boolean isDebugEnabled() {
            return false;
        }

        @Override // com.moor.imkf.lib.jobqueue.log.CustomLogger
        public void v(String str, Object... objArr) {
        }

        @Override // com.moor.imkf.lib.jobqueue.log.CustomLogger
        public void e(String str, Object... objArr) {
            MoorLogUtils.e(TAG, String.format(str, objArr));
        }
    }

    static {
        clearLogger();
    }

    public static void clearLogger() {
        setCustomLogger(new CustomLogger() { // from class: com.moor.imkf.lib.jobqueue.log.JqLog.1
            @Override // com.moor.imkf.lib.jobqueue.log.CustomLogger
            public void d(String str, Object... objArr) {
            }

            @Override // com.moor.imkf.lib.jobqueue.log.CustomLogger
            public void e(String str, Object... objArr) {
            }

            @Override // com.moor.imkf.lib.jobqueue.log.CustomLogger
            public void e(Throwable th, String str, Object... objArr) {
            }

            @Override // com.moor.imkf.lib.jobqueue.log.CustomLogger
            public boolean isDebugEnabled() {
                return false;
            }

            @Override // com.moor.imkf.lib.jobqueue.log.CustomLogger
            public void v(String str, Object... objArr) {
            }
        });
    }

    public static void d(String str, Object... objArr) {
        customLogger.d(str, objArr);
    }

    public static void e(Throwable th, String str, Object... objArr) {
        customLogger.e(th, str, objArr);
    }

    public static boolean isDebugEnabled() {
        return customLogger.isDebugEnabled();
    }

    public static void setCustomLogger(CustomLogger customLogger2) {
        customLogger = customLogger2;
    }

    public static void v(String str, Object... objArr) {
        customLogger.v(str, objArr);
    }

    public static void e(String str, Object... objArr) {
        customLogger.e(str, objArr);
    }
}
