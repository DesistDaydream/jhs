package e.j.a.c.h0;

/* loaded from: classes2.dex */
public class c {
    public final int a;
    public final int b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f10689c;

    private c(int i2, int i3, boolean z) {
        this.a = i2;
        this.b = i3;
        this.f10689c = z;
    }

    public static c a(int i2, int i3) {
        return new c(i2, i3, true);
    }

    public static c b(int i2, int i3) {
        return new c(i2, i3, false);
    }
}
