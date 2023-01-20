package com.tencent.android.tpush.stat.b;

import com.tencent.android.tpush.logging.TLogger;
import com.xiaomi.mipush.sdk.Constants;

/* loaded from: classes3.dex */
public final class c {
    private String a;
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private int f6436c;

    public c() {
        this.a = "default";
        this.b = true;
        this.f6436c = 2;
    }

    private String b() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace == null) {
            return null;
        }
        for (StackTraceElement stackTraceElement : stackTrace) {
            if (!stackTraceElement.isNativeMethod() && !stackTraceElement.getClassName().equals(Thread.class.getName()) && !stackTraceElement.getClassName().equals(c.class.getName())) {
                return "[" + Thread.currentThread().getName() + "(" + Thread.currentThread().getId() + "): " + stackTraceElement.getFileName() + Constants.COLON_SEPARATOR + stackTraceElement.getLineNumber() + "]";
            }
        }
        return null;
    }

    public boolean a() {
        return this.b;
    }

    public void c(Object obj) {
        String str;
        if (this.f6436c <= 5) {
            String b = b();
            if (b == null) {
                str = obj.toString();
            } else {
                str = b + " - " + obj;
            }
            TLogger.w(this.a, str);
        }
    }

    public void d(Object obj) {
        if (a()) {
            c(obj);
        }
    }

    public void e(Object obj) {
        String str;
        if (this.f6436c <= 6) {
            String b = b();
            if (b == null) {
                str = obj.toString();
            } else {
                str = b + " - " + obj;
            }
            TLogger.e(this.a, str);
        }
    }

    public void f(Object obj) {
        if (a()) {
            e(obj);
        }
    }

    public void g(Object obj) {
        String str;
        if (this.f6436c <= 3) {
            String b = b();
            if (b == null) {
                str = obj.toString();
            } else {
                str = b + " - " + obj;
            }
            TLogger.d(this.a, str);
        }
    }

    public void h(Object obj) {
        if (a()) {
            g(obj);
        }
    }

    public void a(boolean z) {
        this.b = z;
    }

    public void a(Object obj) {
        String str;
        if (this.f6436c <= 4) {
            String b = b();
            if (b == null) {
                str = obj.toString();
            } else {
                str = b + " - " + obj;
            }
            TLogger.i(this.a, str);
        }
    }

    public c(String str) {
        this.a = "default";
        this.b = true;
        this.f6436c = 2;
        this.a = str;
    }

    public void a(Throwable th) {
        if (this.f6436c <= 6) {
            TLogger.e(this.a, "", th);
        }
    }

    public void b(Object obj) {
        if (a()) {
            a(obj);
        }
    }

    public void b(Throwable th) {
        if (a()) {
            a(th);
        }
    }
}
