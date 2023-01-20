package com.xiaomi.a.a.a;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import com.xiaomi.push.jc;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public abstract class c {
    private static int a = 2;
    private static Context b = null;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f8184c = false;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f8185d = false;

    /* renamed from: e  reason: collision with root package name */
    private static String f8186e = "XMPush-" + Process.myPid();

    /* renamed from: f  reason: collision with root package name */
    private static com.xiaomi.a.a.a.a f8187f = new a();

    /* renamed from: g  reason: collision with root package name */
    private static final HashMap<Integer, Long> f8188g = new HashMap<>();

    /* renamed from: h  reason: collision with root package name */
    private static final HashMap<Integer, String> f8189h = new HashMap<>();

    /* renamed from: i  reason: collision with root package name */
    private static final Integer f8190i = -1;

    /* renamed from: j  reason: collision with root package name */
    private static AtomicInteger f8191j = new AtomicInteger(1);

    /* loaded from: classes3.dex */
    public static class a implements com.xiaomi.a.a.a.a {
        private String a = c.f8186e;

        @Override // com.xiaomi.a.a.a.a
        public void a(String str) {
            Log.v(this.a, str);
        }

        @Override // com.xiaomi.a.a.a.a
        public void a(String str, Throwable th) {
            Log.v(this.a, str, th);
        }
    }

    public static int a() {
        return a;
    }

    public static void a(int i2) {
        if (i2 < 0 || i2 > 5) {
            a(2, "set log level as " + i2);
        }
        a = i2;
    }

    public static void a(int i2, String str) {
        if (i2 >= a) {
            f8187f.a(str);
        }
    }

    public static void a(int i2, String str, Throwable th) {
        if (i2 >= a) {
            f8187f.a(str, th);
        }
    }

    public static void a(int i2, Throwable th) {
        if (i2 >= a) {
            f8187f.a("", th);
        }
    }

    public static void a(Context context) {
        b = context;
        if (jc.a(context)) {
            f8184c = true;
        }
        if (jc.a()) {
            f8185d = true;
        }
    }

    public static void a(com.xiaomi.a.a.a.a aVar) {
        f8187f = aVar;
    }

    public static void a(Integer num) {
        if (a <= 1) {
            HashMap<Integer, Long> hashMap = f8188g;
            if (hashMap.containsKey(num)) {
                long currentTimeMillis = System.currentTimeMillis() - hashMap.remove(num).longValue();
                com.xiaomi.a.a.a.a aVar = f8187f;
                aVar.a(f8189h.remove(num) + " ends in " + currentTimeMillis + " ms");
            }
        }
    }

    public static void a(String str) {
        a(2, g(str));
    }

    public static void a(String str, String str2) {
        a(2, c(str, str2));
    }

    public static void a(String str, Throwable th) {
        a(4, g(str), th);
    }

    public static void a(Throwable th) {
        a(4, th);
    }

    public static String b(String str, String str2) {
        return "[" + str + "] " + str2;
    }

    public static void b(String str) {
        a(0, g(str));
    }

    private static String c() {
        return "[Tid:" + Thread.currentThread().getId() + "] ";
    }

    private static String c(String str, String str2) {
        return c() + b(str, str2);
    }

    public static void c(String str) {
        a(1, g(str));
    }

    public static void d(String str) {
        a(4, g(str));
    }

    public static Integer e(String str) {
        if (a <= 1) {
            Integer valueOf = Integer.valueOf(f8191j.incrementAndGet());
            f8188g.put(valueOf, Long.valueOf(System.currentTimeMillis()));
            f8189h.put(valueOf, str);
            com.xiaomi.a.a.a.a aVar = f8187f;
            aVar.a(str + " starts");
            return valueOf;
        }
        return f8190i;
    }

    public static void f(String str) {
        if (!f8184c) {
            Log.w(f8186e, g(str));
            if (f8185d) {
                return;
            }
        }
        a(str);
    }

    private static String g(String str) {
        return c() + str;
    }
}
