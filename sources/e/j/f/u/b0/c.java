package e.j.f.u.b0;

import e.j.f.l;

/* loaded from: classes2.dex */
public final class c {
    private final int a;
    private final int[] b;

    /* renamed from: c  reason: collision with root package name */
    private final l[] f11582c;

    public c(int i2, int[] iArr, int i3, int i4, int i5) {
        this.a = i2;
        this.b = iArr;
        float f2 = i5;
        this.f11582c = new l[]{new l(i3, f2), new l(i4, f2)};
    }

    public l[] a() {
        return this.f11582c;
    }

    public int[] b() {
        return this.b;
    }

    public int c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof c) && this.a == ((c) obj).a;
    }

    public int hashCode() {
        return this.a;
    }
}
