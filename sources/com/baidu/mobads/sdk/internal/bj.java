package com.baidu.mobads.sdk.internal;

import android.util.Log;

/* loaded from: classes.dex */
public class bj {
    public static final String a = "logger";
    public static final int b = 2;

    /* renamed from: c  reason: collision with root package name */
    public static final int f1500c = 3;

    /* renamed from: d  reason: collision with root package name */
    public static final int f1501d = 4;

    /* renamed from: e  reason: collision with root package name */
    public static final int f1502e = 5;

    /* renamed from: f  reason: collision with root package name */
    public static final int f1503f = 6;

    /* renamed from: g  reason: collision with root package name */
    public static final int f1504g = 7;

    /* renamed from: h  reason: collision with root package name */
    public static final int f1505h = -1;

    /* renamed from: i  reason: collision with root package name */
    private static volatile bj f1506i;

    private bj() {
    }

    public static bj a() {
        if (f1506i == null) {
            synchronized (bj.class) {
                if (f1506i == null) {
                    f1506i = new bj();
                }
            }
        }
        return f1506i;
    }

    private String e(Object[] objArr) {
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            sb.append(obj);
            sb.append(' ');
        }
        return sb.toString();
    }

    public int b(String str) {
        if (a(5)) {
            try {
                return Log.w(a, str);
            } catch (Exception unused) {
                return -1;
            }
        }
        return -1;
    }

    public int c(Object... objArr) {
        if (a(6)) {
            return c(e(objArr));
        }
        return -1;
    }

    public int d(String str) {
        return b(a, str);
    }

    public int d(Object... objArr) {
        if (a(4)) {
            return d(e(objArr));
        }
        return -1;
    }

    public int b(Object... objArr) {
        if (a(5)) {
            return b(e(objArr));
        }
        return -1;
    }

    public int c(String str) {
        if (a(6)) {
            try {
                return Log.e(a, str);
            } catch (Exception unused) {
                return -1;
            }
        }
        return -1;
    }

    public int d(String str, Throwable th) {
        if (a(4)) {
            try {
                return Log.i(a, str, th);
            } catch (Exception unused) {
                return -1;
            }
        }
        return -1;
    }

    public int b(String str, Throwable th) {
        if (a(5)) {
            try {
                return Log.w(a, str, th);
            } catch (Exception unused) {
                return -1;
            }
        }
        return -1;
    }

    public int c(Throwable th) {
        return c("", th);
    }

    public int c(String str, Throwable th) {
        if (a(6)) {
            try {
                return Log.e(a, str, th);
            } catch (Exception unused) {
                return -1;
            }
        }
        return -1;
    }

    public boolean a(String str, int i2) {
        return i2 >= cb.f1556c;
    }

    public int b(Throwable th) {
        return b("", th);
    }

    public boolean a(int i2) {
        return a(a, i2);
    }

    public int b(String str, String str2) {
        if (a(4)) {
            try {
                return Log.i(str, str2);
            } catch (Exception unused) {
                return -1;
            }
        }
        return -1;
    }

    public int a(Object... objArr) {
        if (a(3)) {
            return a(e(objArr));
        }
        return -1;
    }

    public int a(String str) {
        return a(a, str);
    }

    public int a(String str, String str2) {
        if (a(3)) {
            try {
                return Log.d(str, str2);
            } catch (Exception unused) {
                return -1;
            }
        }
        return -1;
    }

    public int a(Throwable th) {
        return a("", th);
    }

    public int a(String str, Throwable th) {
        if (a(3)) {
            try {
                return Log.d(a, str, th);
            } catch (Exception unused) {
                return -1;
            }
        }
        return -1;
    }
}
