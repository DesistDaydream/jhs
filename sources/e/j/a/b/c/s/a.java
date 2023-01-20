package e.j.a.b.c.s;

import android.util.Log;
import androidx.annotation.Nullable;
import e.j.a.b.c.r.n;
import java.util.Locale;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public class a {
    private final String a;
    private final String b;

    /* renamed from: c  reason: collision with root package name */
    private final n f10443c;

    /* renamed from: d  reason: collision with root package name */
    private final int f10444d;

    /* JADX WARN: Illegal instructions before constructor call */
    @e.j.a.b.c.m.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public a(java.lang.String r7, java.lang.String... r8) {
        /*
            r6 = this;
            int r0 = r8.length
            if (r0 != 0) goto L6
            java.lang.String r8 = ""
            goto L36
        L6:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 91
            r0.append(r1)
            int r1 = r8.length
            r2 = 0
        L12:
            if (r2 >= r1) goto L28
            r3 = r8[r2]
            int r4 = r0.length()
            r5 = 1
            if (r4 <= r5) goto L22
            java.lang.String r4 = ","
            r0.append(r4)
        L22:
            r0.append(r3)
            int r2 = r2 + 1
            goto L12
        L28:
            r8 = 93
            r0.append(r8)
            r8 = 32
            r0.append(r8)
            java.lang.String r8 = r0.toString()
        L36:
            r6.<init>(r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e.j.a.b.c.s.a.<init>(java.lang.String, java.lang.String[]):void");
    }

    private final String d(String str, @Nullable Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str = String.format(Locale.US, str, objArr);
        }
        return this.b.concat(str);
    }

    @e.j.a.b.c.m.a
    public void a(String str, @Nullable Object... objArr) {
        if (f(3)) {
            Log.d(this.a, d(str, objArr));
        }
    }

    @e.j.a.b.c.m.a
    public void b(String str, Throwable th, @Nullable Object... objArr) {
        Log.e(this.a, d(str, objArr), th);
    }

    @e.j.a.b.c.m.a
    public void c(String str, @Nullable Object... objArr) {
        Log.e(this.a, d(str, objArr));
    }

    @e.j.a.b.c.m.a
    public void e(String str, @Nullable Object... objArr) {
        Log.i(this.a, d(str, objArr));
    }

    @e.j.a.b.c.m.a
    public boolean f(int i2) {
        return this.f10444d <= i2;
    }

    @e.j.a.b.c.m.a
    public void g(String str, @Nullable Object... objArr) {
        if (f(2)) {
            Log.v(this.a, d(str, objArr));
        }
    }

    @e.j.a.b.c.m.a
    public void h(String str, @Nullable Object... objArr) {
        Log.w(this.a, d(str, objArr));
    }

    @e.j.a.b.c.m.a
    public void i(String str, Throwable th, @Nullable Object... objArr) {
        Log.wtf(this.a, d(str, objArr), th);
    }

    @e.j.a.b.c.m.a
    public void j(Throwable th) {
        Log.wtf(this.a, th);
    }

    private a(String str, String str2) {
        this.b = str2;
        this.a = str;
        this.f10443c = new n(str);
        int i2 = 2;
        while (7 >= i2 && !Log.isLoggable(this.a, i2)) {
            i2++;
        }
        this.f10444d = i2;
    }
}
