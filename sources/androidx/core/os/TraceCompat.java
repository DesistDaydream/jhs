package androidx.core.os;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import androidx.annotation.NonNull;
import java.lang.reflect.Method;

@Deprecated
/* loaded from: classes.dex */
public final class TraceCompat {
    private static final String TAG = "TraceCompat";
    private static Method sAsyncTraceBeginMethod;
    private static Method sAsyncTraceEndMethod;
    private static Method sIsTagEnabledMethod;
    private static Method sTraceCounterMethod;
    private static long sTraceTagApp;

    static {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 18 || i2 >= 29) {
            return;
        }
        try {
            sTraceTagApp = Trace.class.getField("TRACE_TAG_APP").getLong(null);
            Class cls = Long.TYPE;
            sIsTagEnabledMethod = Trace.class.getMethod("isTagEnabled", cls);
            Class cls2 = Integer.TYPE;
            sAsyncTraceBeginMethod = Trace.class.getMethod("asyncTraceBegin", cls, String.class, cls2);
            sAsyncTraceEndMethod = Trace.class.getMethod("asyncTraceEnd", cls, String.class, cls2);
            sTraceCounterMethod = Trace.class.getMethod("traceCounter", cls, String.class, cls2);
        } catch (Exception e2) {
            Log.i(TAG, "Unable to initialize via reflection.", e2);
        }
    }

    private TraceCompat() {
    }

    public static void beginAsyncSection(@NonNull String str, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 29) {
            Trace.beginAsyncSection(str, i2);
        } else if (i3 >= 18) {
            try {
                sAsyncTraceBeginMethod.invoke(null, Long.valueOf(sTraceTagApp), str, Integer.valueOf(i2));
            } catch (Exception unused) {
                Log.v(TAG, "Unable to invoke asyncTraceBegin() via reflection.");
            }
        }
    }

    public static void beginSection(@NonNull String str) {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.beginSection(str);
        }
    }

    public static void endAsyncSection(@NonNull String str, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 29) {
            Trace.endAsyncSection(str, i2);
        } else if (i3 >= 18) {
            try {
                sAsyncTraceEndMethod.invoke(null, Long.valueOf(sTraceTagApp), str, Integer.valueOf(i2));
            } catch (Exception unused) {
                Log.v(TAG, "Unable to invoke endAsyncSection() via reflection.");
            }
        }
    }

    public static void endSection() {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.endSection();
        }
    }

    public static boolean isEnabled() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            return Trace.isEnabled();
        }
        if (i2 >= 18) {
            try {
                return ((Boolean) sIsTagEnabledMethod.invoke(null, Long.valueOf(sTraceTagApp))).booleanValue();
            } catch (Exception unused) {
                Log.v(TAG, "Unable to invoke isTagEnabled() via reflection.");
            }
        }
        return false;
    }

    public static void setCounter(@NonNull String str, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 29) {
            Trace.setCounter(str, i2);
        } else if (i3 >= 18) {
            try {
                sTraceCounterMethod.invoke(null, Long.valueOf(sTraceTagApp), str, Integer.valueOf(i2));
            } catch (Exception unused) {
                Log.v(TAG, "Unable to invoke traceCounter() via reflection.");
            }
        }
    }
}
