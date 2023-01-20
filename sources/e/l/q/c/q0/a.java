package e.l.q.c.q0;

import android.graphics.Paint;
import h.k2.v.f0;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class a {
    private final int a;
    private final int b;
    @e

    /* renamed from: c  reason: collision with root package name */
    private final String f14199c;
    @d

    /* renamed from: d  reason: collision with root package name */
    private final Paint f14200d;

    public a(int i2, int i3, @e String str, @d Paint paint) {
        this.a = i2;
        this.b = i3;
        this.f14199c = str;
        this.f14200d = paint;
    }

    public static /* synthetic */ a f(a aVar, int i2, int i3, String str, Paint paint, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = aVar.a;
        }
        if ((i4 & 2) != 0) {
            i3 = aVar.b;
        }
        if ((i4 & 4) != 0) {
            str = aVar.f14199c;
        }
        if ((i4 & 8) != 0) {
            paint = aVar.f14200d;
        }
        return aVar.e(i2, i3, str, paint);
    }

    public final int a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }

    @e
    public final String c() {
        return this.f14199c;
    }

    @d
    public final Paint d() {
        return this.f14200d;
    }

    @d
    public final a e(int i2, int i3, @e String str, @d Paint paint) {
        return new a(i2, i3, str, paint);
    }

    public boolean equals(@e Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return this.a == aVar.a && this.b == aVar.b && f0.g(this.f14199c, aVar.f14199c) && f0.g(this.f14200d, aVar.f14200d);
        }
        return false;
    }

    public final int g() {
        return this.b;
    }

    public final int h() {
        return this.a;
    }

    public int hashCode() {
        int i2 = ((this.a * 31) + this.b) * 31;
        String str = this.f14199c;
        return ((i2 + (str == null ? 0 : str.hashCode())) * 31) + this.f14200d.hashCode();
    }

    @d
    public final Paint i() {
        return this.f14200d;
    }

    @e
    public final String j() {
        return this.f14199c;
    }

    @d
    public String toString() {
        return "LineData(lineWidth=" + this.a + ", lineHeight=" + this.b + ", text=" + ((Object) this.f14199c) + ", paint=" + this.f14200d + ')';
    }
}
