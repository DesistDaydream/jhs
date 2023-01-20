package com.bytedance.msdk.adapter.util;

import android.os.Looper;
import java.util.IllegalFormatException;

/* loaded from: classes.dex */
public final class Preconditions {
    public static final String EMPTY_ARGUMENTS = "";

    /* loaded from: classes.dex */
    public static final class NoThrow {
        private static volatile boolean a;

        public static boolean checkArgument(boolean z) {
            return Preconditions.h(z, a, "Illegal argument", "");
        }

        public static boolean checkArgument(boolean z, String str) {
            return Preconditions.h(z, a, str, "");
        }

        public static boolean checkArgument(boolean z, String str, Object... objArr) {
            return Preconditions.h(z, a, str, objArr);
        }

        public static boolean checkNotNull(Object obj) {
            return Preconditions.e(obj, a, "Object can not be null.", "");
        }

        public static boolean checkNotNull(Object obj, String str) {
            return Preconditions.e(obj, a, str, "");
        }

        public static boolean checkNotNull(Object obj, String str, Object... objArr) {
            return Preconditions.e(obj, a, str, objArr);
        }

        public static boolean checkState(boolean z) {
            return Preconditions.i(z, a, "Illegal state.", "");
        }

        public static boolean checkState(boolean z, String str) {
            return Preconditions.i(z, a, str, "");
        }

        public static boolean checkState(boolean z, String str, Object... objArr) {
            return Preconditions.i(z, a, str, objArr);
        }

        public static boolean checkUiThread() {
            return Preconditions.f(a, "This method must be called from the UI thread.", "");
        }

        public static boolean checkUiThread(String str) {
            return Preconditions.f(a, str, "");
        }

        public static boolean checkUiThread(String str, Object... objArr) {
            return Preconditions.f(false, str, objArr);
        }

        public static void setStrictMode(boolean z) {
            a = z;
        }
    }

    private Preconditions() {
    }

    private static String a(String str, Object... objArr) {
        String valueOf = String.valueOf(str);
        try {
            return String.format(valueOf, objArr);
        } catch (IllegalFormatException e2) {
            Logger.e("TTMediationSDK_ADAPTER", "MoPub preconditions had a format exception: " + e2.getMessage());
            return valueOf;
        }
    }

    public static void checkArgument(boolean z) {
        h(z, true, "Illegal argument.", "");
    }

    public static void checkArgument(boolean z, String str) {
        h(z, true, str, "");
    }

    public static void checkArgument(boolean z, String str, Object... objArr) {
        h(z, true, str, objArr);
    }

    public static void checkNotNull(Object obj) {
        e(obj, true, "Object can not be null.", "");
    }

    public static void checkNotNull(Object obj, String str) {
        e(obj, true, str, "");
    }

    public static void checkNotNull(Object obj, String str, Object... objArr) {
        e(obj, true, str, objArr);
    }

    public static void checkState(boolean z) {
        i(z, true, "Illegal state.", "");
    }

    public static void checkState(boolean z, String str) {
        i(z, true, str, "");
    }

    public static void checkState(boolean z, String str, Object... objArr) {
        i(z, true, str, objArr);
    }

    public static void checkUiThread() {
        f(true, "This method must be called from the UI thread.", "");
    }

    public static void checkUiThread(String str) {
        f(true, str, "");
    }

    public static void checkUiThread(String str, Object... objArr) {
        f(true, str, objArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean e(Object obj, boolean z, String str, Object... objArr) {
        if (obj != null) {
            return true;
        }
        String a = a(str, objArr);
        if (z) {
            throw new NullPointerException(a);
        }
        Logger.e("TTMediationSDK_ADAPTER", a);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean f(boolean z, String str, Object... objArr) {
        if (Looper.getMainLooper().equals(Looper.myLooper())) {
            return true;
        }
        String a = a(str, objArr);
        if (z) {
            throw new IllegalStateException(a);
        }
        Logger.e("TTMediationSDK_ADAPTER", a);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean h(boolean z, boolean z2, String str, Object... objArr) {
        if (z) {
            return true;
        }
        String a = a(str, objArr);
        if (z2) {
            throw new IllegalArgumentException(a);
        }
        Logger.e("TTMediationSDK_ADAPTER", a);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean i(boolean z, boolean z2, String str, Object... objArr) {
        if (z) {
            return true;
        }
        String a = a(str, objArr);
        if (z2) {
            throw new IllegalStateException(a);
        }
        Logger.e("TTMediationSDK_ADAPTER", a);
        return false;
    }
}
