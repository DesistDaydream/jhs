package e.j.a.c.h0;

/* loaded from: classes2.dex */
public class b {
    private static final e.j.a.c.h0.a a = new a();
    private static final e.j.a.c.h0.a b = new C0361b();

    /* renamed from: c  reason: collision with root package name */
    private static final e.j.a.c.h0.a f10687c = new c();

    /* renamed from: d  reason: collision with root package name */
    private static final e.j.a.c.h0.a f10688d = new d();

    /* loaded from: classes2.dex */
    public static class a implements e.j.a.c.h0.a {
        @Override // e.j.a.c.h0.a
        public e.j.a.c.h0.c a(float f2, float f3, float f4, float f5) {
            return e.j.a.c.h0.c.a(255, u.q(0, 255, f3, f4, f2));
        }
    }

    /* renamed from: e.j.a.c.h0.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0361b implements e.j.a.c.h0.a {
        @Override // e.j.a.c.h0.a
        public e.j.a.c.h0.c a(float f2, float f3, float f4, float f5) {
            return e.j.a.c.h0.c.b(u.q(255, 0, f3, f4, f2), 255);
        }
    }

    /* loaded from: classes2.dex */
    public static class c implements e.j.a.c.h0.a {
        @Override // e.j.a.c.h0.a
        public e.j.a.c.h0.c a(float f2, float f3, float f4, float f5) {
            return e.j.a.c.h0.c.b(u.q(255, 0, f3, f4, f2), u.q(0, 255, f3, f4, f2));
        }
    }

    /* loaded from: classes2.dex */
    public static class d implements e.j.a.c.h0.a {
        @Override // e.j.a.c.h0.a
        public e.j.a.c.h0.c a(float f2, float f3, float f4, float f5) {
            float f6 = ((f4 - f3) * f5) + f3;
            return e.j.a.c.h0.c.b(u.q(255, 0, f3, f6, f2), u.q(0, 255, f6, f4, f2));
        }
    }

    private b() {
    }

    public static e.j.a.c.h0.a a(int i2, boolean z) {
        if (i2 == 0) {
            return z ? a : b;
        } else if (i2 == 1) {
            return z ? b : a;
        } else if (i2 != 2) {
            if (i2 == 3) {
                return f10688d;
            }
            throw new IllegalArgumentException("Invalid fade mode: " + i2);
        } else {
            return f10687c;
        }
    }
}
