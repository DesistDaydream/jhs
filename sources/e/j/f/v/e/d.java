package e.j.f.v.e;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;

/* loaded from: classes2.dex */
public final class d {

    /* renamed from: f  reason: collision with root package name */
    private static final int f11693f = -1;
    private final int a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final int f11694c;

    /* renamed from: d  reason: collision with root package name */
    private final int f11695d;

    /* renamed from: e  reason: collision with root package name */
    private int f11696e = -1;

    public d(int i2, int i3, int i4, int i5) {
        this.a = i2;
        this.b = i3;
        this.f11694c = i4;
        this.f11695d = i5;
    }

    public int a() {
        return this.f11694c;
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.f11696e;
    }

    public int d() {
        return this.a;
    }

    public int e() {
        return this.f11695d;
    }

    public int f() {
        return this.b - this.a;
    }

    public boolean g() {
        return h(this.f11696e);
    }

    public boolean h(int i2) {
        return i2 != -1 && this.f11694c == (i2 % 3) * 3;
    }

    public void i(int i2) {
        this.f11696e = i2;
    }

    public void j() {
        this.f11696e = ((this.f11695d / 30) * 3) + (this.f11694c / 3);
    }

    public String toString() {
        return this.f11696e + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + this.f11695d;
    }
}
