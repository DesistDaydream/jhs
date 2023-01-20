package h.p2.b0.g.t.e.a;

import h.k2.v.f0;
import h.t2.u;

/* loaded from: classes3.dex */
public final class o {
    @k.e.a.d
    public static final o a = new o();
    @h.k2.d
    @k.e.a.d
    public static final h.p2.b0.g.t.g.c b = new h.p2.b0.g.t.g.c("kotlin.jvm.JvmField");
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private static final h.p2.b0.g.t.g.b f15243c = h.p2.b0.g.t.g.b.m(new h.p2.b0.g.t.g.c("kotlin.reflect.jvm.internal.ReflectionFactoryImpl"));

    private o() {
    }

    @h.k2.k
    @k.e.a.d
    public static final String a(@k.e.a.d String str) {
        return e(str) ? str : f0.C("get", h.p2.b0.g.t.o.j.a.a(str));
    }

    @h.k2.k
    public static final boolean b(@k.e.a.d String str) {
        return u.u2(str, "get", false, 2, null) || u.u2(str, "is", false, 2, null);
    }

    @h.k2.k
    public static final boolean c(@k.e.a.d String str) {
        return u.u2(str, "set", false, 2, null);
    }

    @h.k2.k
    @k.e.a.d
    public static final String d(@k.e.a.d String str) {
        return f0.C("set", e(str) ? str.substring(2) : h.p2.b0.g.t.o.j.a.a(str));
    }

    @h.k2.k
    public static final boolean e(@k.e.a.d String str) {
        if (u.u2(str, "is", false, 2, null) && str.length() != 2) {
            char charAt = str.charAt(2);
            return f0.t(97, charAt) > 0 || f0.t(charAt, 122) > 0;
        }
        return false;
    }
}
