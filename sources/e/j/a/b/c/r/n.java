package e.j.a.b.c.r;

import android.util.Log;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public final class n {

    /* renamed from: c  reason: collision with root package name */
    private static final int f10434c = 15;

    /* renamed from: d  reason: collision with root package name */
    private static final String f10435d = null;
    private final String a;
    private final String b;

    public n(String str, String str2) {
        a0.l(str, "log tag cannot be null");
        a0.c(str.length() <= 23, "tag \"%s\" is longer than the %d character maximum", str, 23);
        this.a = str;
        if (str2 != null && str2.length() > 0) {
            this.b = str2;
        } else {
            this.b = null;
        }
    }

    private final String r(String str, Object... objArr) {
        String format = String.format(str, objArr);
        String str2 = this.b;
        return str2 == null ? format : str2.concat(format);
    }

    private final String s(String str) {
        String str2 = this.b;
        return str2 == null ? str : str2.concat(str);
    }

    @e.j.a.b.c.m.a
    public final boolean a(int i2) {
        return Log.isLoggable(this.a, i2);
    }

    @e.j.a.b.c.m.a
    public final boolean b() {
        return false;
    }

    @e.j.a.b.c.m.a
    public final void c(String str, String str2) {
        if (a(3)) {
            Log.d(str, s(str2));
        }
    }

    @e.j.a.b.c.m.a
    public final void d(String str, String str2, Throwable th) {
        if (a(3)) {
            Log.d(str, s(str2), th);
        }
    }

    @e.j.a.b.c.m.a
    public final void e(String str, String str2) {
        if (a(6)) {
            Log.e(str, s(str2));
        }
    }

    @e.j.a.b.c.m.a
    public final void f(String str, String str2, Throwable th) {
        if (a(6)) {
            Log.e(str, s(str2), th);
        }
    }

    @e.j.a.b.c.m.a
    public final void g(String str, String str2, Object... objArr) {
        if (a(6)) {
            Log.e(str, r(str2, objArr));
        }
    }

    @e.j.a.b.c.m.a
    public final void h(String str, String str2) {
        if (a(4)) {
            Log.i(str, s(str2));
        }
    }

    @e.j.a.b.c.m.a
    public final void i(String str, String str2, Throwable th) {
        if (a(4)) {
            Log.i(str, s(str2), th);
        }
    }

    @e.j.a.b.c.m.a
    public final void j(String str, String str2) {
        if (b()) {
            String valueOf = String.valueOf(str);
            Log.i(" PII_LOG".length() != 0 ? valueOf.concat(" PII_LOG") : new String(valueOf), s(str2));
        }
    }

    @e.j.a.b.c.m.a
    public final void k(String str, String str2, Throwable th) {
        if (b()) {
            String valueOf = String.valueOf(str);
            Log.i(" PII_LOG".length() != 0 ? valueOf.concat(" PII_LOG") : new String(valueOf), s(str2), th);
        }
    }

    @e.j.a.b.c.m.a
    public final void l(String str, String str2) {
        if (a(2)) {
            Log.v(str, s(str2));
        }
    }

    @e.j.a.b.c.m.a
    public final void m(String str, String str2, Throwable th) {
        if (a(2)) {
            Log.v(str, s(str2), th);
        }
    }

    @e.j.a.b.c.m.a
    public final void n(String str, String str2) {
        if (a(5)) {
            Log.w(str, s(str2));
        }
    }

    @e.j.a.b.c.m.a
    public final void o(String str, String str2, Throwable th) {
        if (a(5)) {
            Log.w(str, s(str2), th);
        }
    }

    @e.j.a.b.c.m.a
    public final void p(String str, String str2, Object... objArr) {
        if (a(5)) {
            Log.w(this.a, r(str2, objArr));
        }
    }

    @e.j.a.b.c.m.a
    public final void q(String str, String str2, Throwable th) {
        if (a(7)) {
            Log.e(str, s(str2), th);
            Log.wtf(str, s(str2), th);
        }
    }

    public n(String str) {
        this(str, null);
    }
}
