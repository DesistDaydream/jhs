package bykvm_19do.bykvm_19do.bykvm_19do;

import e.c.b.a;

/* loaded from: classes.dex */
public final class t0 {
    private static int a;
    private static e.c.b.a b;

    static {
        a(2);
        a(new a.C0329a());
    }

    public static void a(int i2) {
        a = i2;
    }

    public static void a(e.c.b.a aVar) {
        b = aVar;
    }

    public static void a(String str, String str2) {
        a(str, str2, null);
    }

    public static void a(String str, String str2, Throwable th) {
        e.c.b.a aVar = b;
        if (aVar == null || a > 2) {
            return;
        }
        aVar.a(str, str2, th);
    }

    public static void b(String str, String str2) {
        b(str, str2, null);
    }

    public static void b(String str, String str2, Throwable th) {
        e.c.b.a aVar = b;
        if (aVar == null || a > 3) {
            return;
        }
        aVar.b(str, str2, th);
    }
}
