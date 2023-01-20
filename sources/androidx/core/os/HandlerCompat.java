package androidx.core.os;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public final class HandlerCompat {
    private static final String TAG = "HandlerCompat";

    @RequiresApi(28)
    /* loaded from: classes.dex */
    public static class Api28Impl {
        private Api28Impl() {
        }

        public static Handler createAsync(Looper looper) {
            return Handler.createAsync(looper);
        }

        public static boolean postDelayed(Handler handler, Runnable runnable, Object obj, long j2) {
            return handler.postDelayed(runnable, obj, j2);
        }

        public static Handler createAsync(Looper looper, Handler.Callback callback) {
            return Handler.createAsync(looper, callback);
        }
    }

    @RequiresApi(29)
    /* loaded from: classes.dex */
    public static class Api29Impl {
        private Api29Impl() {
        }

        public static boolean hasCallbacks(Handler handler, Runnable runnable) {
            return handler.hasCallbacks(runnable);
        }
    }

    private HandlerCompat() {
    }

    @NonNull
    public static Handler createAsync(@NonNull Looper looper) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            return Api28Impl.createAsync(looper);
        }
        if (i2 >= 17) {
            try {
                return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
            } catch (IllegalAccessException e2) {
                e = e2;
                Log.w(TAG, "Unable to invoke Handler(Looper, Callback, boolean) constructor", e);
                return new Handler(looper);
            } catch (InstantiationException e3) {
                e = e3;
                Log.w(TAG, "Unable to invoke Handler(Looper, Callback, boolean) constructor", e);
                return new Handler(looper);
            } catch (NoSuchMethodException e4) {
                e = e4;
                Log.w(TAG, "Unable to invoke Handler(Looper, Callback, boolean) constructor", e);
                return new Handler(looper);
            } catch (InvocationTargetException e5) {
                Throwable cause = e5.getCause();
                if (!(cause instanceof RuntimeException)) {
                    if (cause instanceof Error) {
                        throw ((Error) cause);
                    }
                    throw new RuntimeException(cause);
                }
                throw ((RuntimeException) cause);
            }
        }
        return new Handler(looper);
    }

    @RequiresApi(16)
    public static boolean hasCallbacks(@NonNull Handler handler, @NonNull Runnable runnable) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            return Api29Impl.hasCallbacks(handler, runnable);
        }
        if (i2 >= 16) {
            try {
                return ((Boolean) Handler.class.getMethod("hasCallbacks", Runnable.class).invoke(handler, runnable)).booleanValue();
            } catch (IllegalAccessException e2) {
                e = e2;
            } catch (NoSuchMethodException e3) {
                e = e3;
            } catch (NullPointerException e4) {
                e = e4;
            } catch (InvocationTargetException e5) {
                Throwable cause = e5.getCause();
                if (!(cause instanceof RuntimeException)) {
                    if (cause instanceof Error) {
                        throw ((Error) cause);
                    }
                    throw new RuntimeException(cause);
                }
                throw ((RuntimeException) cause);
            }
        } else {
            e = null;
        }
        throw new UnsupportedOperationException("Failed to call Handler.hasCallbacks(), but there is no safe failure mode for this method. Raising exception.", e);
    }

    public static boolean postDelayed(@NonNull Handler handler, @NonNull Runnable runnable, @Nullable Object obj, long j2) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.postDelayed(handler, runnable, obj, j2);
        }
        Message obtain = Message.obtain(handler, runnable);
        obtain.obj = obj;
        return handler.sendMessageDelayed(obtain, j2);
    }

    @NonNull
    public static Handler createAsync(@NonNull Looper looper, @NonNull Handler.Callback callback) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            return Api28Impl.createAsync(looper, callback);
        }
        if (i2 >= 17) {
            try {
                return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, callback, Boolean.TRUE);
            } catch (IllegalAccessException e2) {
                e = e2;
                Log.w(TAG, "Unable to invoke Handler(Looper, Callback, boolean) constructor", e);
                return new Handler(looper, callback);
            } catch (InstantiationException e3) {
                e = e3;
                Log.w(TAG, "Unable to invoke Handler(Looper, Callback, boolean) constructor", e);
                return new Handler(looper, callback);
            } catch (NoSuchMethodException e4) {
                e = e4;
                Log.w(TAG, "Unable to invoke Handler(Looper, Callback, boolean) constructor", e);
                return new Handler(looper, callback);
            } catch (InvocationTargetException e5) {
                Throwable cause = e5.getCause();
                if (!(cause instanceof RuntimeException)) {
                    if (cause instanceof Error) {
                        throw ((Error) cause);
                    }
                    throw new RuntimeException(cause);
                }
                throw ((RuntimeException) cause);
            }
        }
        return new Handler(looper, callback);
    }
}
