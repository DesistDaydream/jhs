package com.xiaomi.push;

import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: classes3.dex */
public class w implements v, InvocationHandler {
    private static final String[][] a = {new String[]{"com.bun.supplier.IIdentifierListener", "com.bun.supplier.IdSupplier"}, new String[]{"com.bun.miitmdid.core.IIdentifierListener", "com.bun.miitmdid.supplier.IdSupplier"}};

    /* renamed from: k  reason: collision with root package name */
    private Context f9214k;
    private Class b = null;

    /* renamed from: c  reason: collision with root package name */
    private Class f9206c = null;

    /* renamed from: d  reason: collision with root package name */
    private Method f9207d = null;

    /* renamed from: e  reason: collision with root package name */
    private Method f9208e = null;

    /* renamed from: f  reason: collision with root package name */
    private Method f9209f = null;

    /* renamed from: g  reason: collision with root package name */
    private Method f9210g = null;

    /* renamed from: h  reason: collision with root package name */
    private Method f9211h = null;

    /* renamed from: i  reason: collision with root package name */
    private Method f9212i = null;

    /* renamed from: j  reason: collision with root package name */
    private Method f9213j = null;

    /* renamed from: l  reason: collision with root package name */
    private final Object f9215l = new Object();

    /* renamed from: m  reason: collision with root package name */
    private volatile int f9216m = 0;
    private volatile long n = 0;
    private volatile a o = null;

    /* loaded from: classes3.dex */
    public class a {
        public Boolean a;
        public String b;

        /* renamed from: c  reason: collision with root package name */
        public String f9217c;

        /* renamed from: d  reason: collision with root package name */
        public String f9218d;

        /* renamed from: e  reason: collision with root package name */
        public String f9219e;

        private a() {
            this.a = null;
            this.b = null;
            this.f9217c = null;
            this.f9218d = null;
            this.f9219e = null;
        }

        public boolean a() {
            if (!TextUtils.isEmpty(this.b) || !TextUtils.isEmpty(this.f9217c) || !TextUtils.isEmpty(this.f9218d) || !TextUtils.isEmpty(this.f9219e)) {
                this.a = Boolean.TRUE;
            }
            return this.a != null;
        }
    }

    public w(Context context) {
        this.f9214k = context.getApplicationContext();
        a(context);
        b(context);
    }

    private static Class<?> a(Context context, String str) {
        try {
            return jl.a(context, str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static <T> T a(Method method, Object obj, Object... objArr) {
        if (method != null) {
            try {
                T t = (T) method.invoke(obj, objArr);
                if (t != null) {
                    return t;
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }

    private static Method a(Class<?> cls, String str, Class<?>... clsArr) {
        if (cls != null) {
            try {
                return cls.getMethod(str, clsArr);
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }

    private void a(Context context) {
        Class<?> a2 = a(context, "com.bun.miitmdid.core.MdidSdk");
        Class<?> cls = null;
        Class<?> cls2 = null;
        int i2 = 0;
        while (true) {
            String[][] strArr = a;
            if (i2 >= strArr.length) {
                break;
            }
            String[] strArr2 = strArr[i2];
            Class<?> a3 = a(context, strArr2[0]);
            Class<?> a4 = a(context, strArr2[1]);
            if (a3 != null && a4 != null) {
                b("found class in index " + i2);
                cls2 = a4;
                cls = a3;
                break;
            }
            i2++;
            cls2 = a4;
            cls = a3;
        }
        this.b = a2;
        this.f9207d = a(a2, "InitSdk", Context.class, cls);
        this.f9206c = cls;
        this.f9208e = a(cls2, "getUDID", new Class[0]);
        this.f9209f = a(cls2, "getOAID", new Class[0]);
        this.f9210g = a(cls2, "getVAID", new Class[0]);
        this.f9211h = a(cls2, "getAAID", new Class[0]);
        this.f9212i = a(cls2, "isSupported", new Class[0]);
        this.f9213j = a(cls2, "shutDown", new Class[0]);
    }

    private void a(String str) {
        if (this.o != null) {
            return;
        }
        long j2 = this.n;
        long elapsedRealtime = SystemClock.elapsedRealtime() - Math.abs(j2);
        int i2 = this.f9216m;
        if (elapsedRealtime > 3000 && i2 < 3) {
            synchronized (this.f9215l) {
                if (this.n == j2 && this.f9216m == i2) {
                    b("retry, current count is " + i2);
                    this.f9216m = this.f9216m + 1;
                    b(this.f9214k);
                    j2 = this.n;
                    elapsedRealtime = SystemClock.elapsedRealtime() - Math.abs(j2);
                }
            }
        }
        if (this.o != null || j2 < 0 || elapsedRealtime > 3000 || Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        synchronized (this.f9215l) {
            if (this.o == null) {
                try {
                    b(str + " wait...");
                    this.f9215l.wait(3000L);
                } catch (Exception unused) {
                }
            }
        }
    }

    private static boolean a(Object obj) {
        return (obj instanceof Boolean) || (obj instanceof Character) || (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Float) || (obj instanceof Double);
    }

    private void b(Context context) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j2 = -elapsedRealtime;
        Class cls = this.f9206c;
        if (cls != null) {
            try {
                ClassLoader classLoader = cls.getClassLoader();
                if (classLoader == null) {
                    classLoader = context.getClassLoader();
                }
                a(this.f9207d, this.b.newInstance(), context, Proxy.newProxyInstance(classLoader, new Class[]{this.f9206c}, this));
            } catch (Throwable th) {
                b("call init sdk error:" + th);
            }
            this.n = elapsedRealtime;
        }
        elapsedRealtime = j2;
        this.n = elapsedRealtime;
    }

    private static void b(String str) {
        com.xiaomi.a.a.a.c.a("mdid:" + str);
    }

    private void c() {
        synchronized (this.f9215l) {
            try {
                this.f9215l.notifyAll();
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.xiaomi.push.v
    public boolean a() {
        a("isSupported");
        return this.o != null && Boolean.TRUE.equals(this.o.a);
    }

    @Override // com.xiaomi.push.v
    public String b() {
        a("getOAID");
        if (this.o == null) {
            return null;
        }
        return this.o.f9217c;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        this.n = SystemClock.elapsedRealtime();
        if (objArr != null) {
            a aVar = new a();
            int length = objArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                Object obj2 = objArr[i2];
                if (obj2 != null && !a(obj2)) {
                    aVar.b = (String) a(this.f9208e, obj2, new Object[0]);
                    aVar.f9217c = (String) a(this.f9209f, obj2, new Object[0]);
                    aVar.f9218d = (String) a(this.f9210g, obj2, new Object[0]);
                    aVar.f9219e = (String) a(this.f9211h, obj2, new Object[0]);
                    aVar.a = (Boolean) a(this.f9212i, obj2, new Object[0]);
                    a(this.f9213j, obj2, new Object[0]);
                    if (aVar.a()) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("has get succ, check duplicate:");
                        sb.append(this.o != null);
                        b(sb.toString());
                        synchronized (w.class) {
                            if (this.o == null) {
                                this.o = aVar;
                            }
                        }
                    }
                }
                i2++;
            }
        }
        c();
        return null;
    }
}
