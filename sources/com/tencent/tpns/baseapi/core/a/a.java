package com.tencent.tpns.baseapi.core.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;
import com.tencent.tpns.baseapi.base.util.CacheHelper;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.TGlobalHelper;
import com.tencent.tpns.baseapi.base.util.TTask;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public class a {
    private static final Map<String, SharedPreferences> a = new ConcurrentHashMap();

    /* renamed from: com.tencent.tpns.baseapi.core.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0268a {
        private static Handler a;
        private static final Object b = new Object();

        /* renamed from: c  reason: collision with root package name */
        private static final LinkedList<Runnable> f6883c = new LinkedList<>();

        /* renamed from: d  reason: collision with root package name */
        private static boolean f6884d = true;

        /* renamed from: e  reason: collision with root package name */
        private static final Object f6885e = new Object();

        /* renamed from: com.tencent.tpns.baseapi.core.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static class HandlerC0269a extends Handler {
            public HandlerC0269a(Looper looper) {
                super(looper);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    CommonWorkingThread.getInstance().execute(new TTask() { // from class: com.tencent.tpns.baseapi.core.a.a.a.a.1
                        @Override // com.tencent.tpns.baseapi.base.util.TTask
                        public void TRun() {
                            C0268a.c();
                        }
                    });
                }
            }
        }

        private static Handler b() {
            if (a == null) {
                synchronized (b) {
                    if (a == null) {
                        a = new HandlerC0269a(Looper.getMainLooper());
                    }
                }
            }
            return a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void c() {
            LinkedList linkedList;
            try {
                System.currentTimeMillis();
                synchronized (f6885e) {
                    synchronized (b) {
                        LinkedList<Runnable> linkedList2 = f6883c;
                        linkedList = (LinkedList) linkedList2.clone();
                        linkedList2.clear();
                        Handler b2 = b();
                        if (b2 != null) {
                            b2.removeMessages(1);
                        }
                    }
                    if (linkedList.size() > 0) {
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            ((Runnable) it.next()).run();
                        }
                    }
                }
            } catch (Throwable th) {
                TBaseLogger.w("Sp", "sp commit task error, " + th.getMessage());
            }
        }

        public static void a(Runnable runnable, boolean z) {
            try {
                Handler b2 = b();
                if (b2 != null) {
                    synchronized (b) {
                        f6883c.add(runnable);
                        if (z && f6884d) {
                            b2.sendEmptyMessageDelayed(1, 100L);
                        } else {
                            b2.sendEmptyMessage(1);
                        }
                    }
                }
            } catch (Throwable th) {
                TBaseLogger.w("Sp", "sp task add queue failed, " + th.getMessage());
            }
        }
    }

    private static void b(Context context, String str) {
    }

    public static void b(Context context, CacheHelper.Key<?>... keyArr) {
        if (keyArr == null || keyArr.length <= 0) {
            return;
        }
        a(context, false, keyArr);
    }

    private static SharedPreferences c(Context context, String str) {
        Context context2 = TGlobalHelper.getContext(context);
        if (context2 != null) {
            if (Build.VERSION.SDK_INT >= 11) {
                context2.getSharedPreferences(str, 4);
            }
            return context2.getSharedPreferences(str, 0);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static SharedPreferences d(Context context, String str) {
        Context context2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Map<String, SharedPreferences> map = a;
        SharedPreferences sharedPreferences = map.get(str);
        if (sharedPreferences != null || (context2 = TGlobalHelper.getContext(context)) == null) {
            return sharedPreferences;
        }
        SharedPreferences sharedPreferences2 = context2.getSharedPreferences(str, 0);
        map.put(str, sharedPreferences2);
        b(context2, str);
        return sharedPreferences2;
    }

    public static void a(Context context, CacheHelper.Key<?>... keyArr) {
        if (keyArr == null || keyArr.length <= 0) {
            return;
        }
        if (a()) {
            TBaseLogger.d("Sp", "main thread, async sp set");
            a(context, true, keyArr);
            return;
        }
        b(context, keyArr);
    }

    public static <T> T b(Context context, CacheHelper.Key<T> key) {
        T t = (T) a(d(context, key.file), key.name, key.value);
        if (t == null && key.multiProcess) {
            t = (T) a(c(context, key.file), key.name, key.value);
        }
        if (t != null) {
            key.set(t);
            return t;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> void b(SharedPreferences.Editor editor, String str, T t) {
        if (editor != null) {
            if (t == null) {
                editor.remove(str);
            } else if (t instanceof Boolean) {
                editor.putBoolean(str, ((Boolean) t).booleanValue());
            } else if (t instanceof String) {
                editor.putString(str, (String) t);
            } else if (t instanceof Integer) {
                editor.putInt(str, ((Integer) t).intValue());
            } else if (t instanceof Long) {
                editor.putLong(str, ((Long) t).longValue());
            } else if (t instanceof Float) {
                editor.putFloat(str, ((Float) t).floatValue());
            }
        }
    }

    private static boolean a() {
        try {
            return Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId();
        } catch (Throwable th) {
            TBaseLogger.w("Sp", "[isMainThread] failed:" + th.getMessage());
            return true;
        }
    }

    private static void a(final Context context, boolean z, final CacheHelper.Key<?>... keyArr) {
        try {
            TTask tTask = new TTask() { // from class: com.tencent.tpns.baseapi.core.a.a.1
                @Override // com.tencent.tpns.baseapi.base.util.TTask
                public void TRun() {
                    CacheHelper.Key[] keyArr2;
                    SharedPreferences d2;
                    try {
                        HashMap hashMap = new HashMap();
                        for (CacheHelper.Key key : keyArr) {
                            SharedPreferences.Editor editor = (SharedPreferences.Editor) hashMap.get(key.file);
                            if (editor == null && (d2 = a.d(context, key.file)) != null) {
                                editor = d2.edit();
                                hashMap.put(key.file, editor);
                            }
                            a.b(editor, key.name, key.value);
                        }
                        for (String str : hashMap.keySet()) {
                            SharedPreferences.Editor editor2 = (SharedPreferences.Editor) hashMap.get(str);
                            if (editor2 != null && !editor2.commit()) {
                                TBaseLogger.w("Sp", "sp commit failed, sp_file: " + str);
                            }
                        }
                    } catch (Throwable th) {
                        TBaseLogger.w("Sp", "sp commit failed, " + th.getMessage());
                    }
                }
            };
            if (z) {
                C0268a.a(tTask, false);
            } else {
                tTask.run();
            }
        } catch (Throwable unused) {
        }
    }

    public static <T> T a(Context context, CacheHelper.Key<T> key) {
        T t = (T) b(context, key);
        return t != null ? t : key.value;
    }

    private static <T> T a(SharedPreferences sharedPreferences, String str, T t) {
        if (sharedPreferences != null && sharedPreferences.contains(str)) {
            try {
                if (t instanceof Boolean) {
                    return (T) Boolean.valueOf(sharedPreferences.getBoolean(str, ((Boolean) t).booleanValue()));
                }
                if (t instanceof String) {
                    return (T) sharedPreferences.getString(str, (String) t);
                }
                if (t instanceof Integer) {
                    return (T) Integer.valueOf(sharedPreferences.getInt(str, ((Integer) t).intValue()));
                }
                if (t instanceof Long) {
                    return (T) Long.valueOf(sharedPreferences.getLong(str, ((Long) t).longValue()));
                }
                if (t instanceof Float) {
                    return (T) Float.valueOf(sharedPreferences.getFloat(str, ((Float) t).floatValue()));
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }
}
