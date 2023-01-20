package h.p2.b0.g.t.e.a;

import h.k2.v.f0;
import h.t2.u;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes3.dex */
public final class r {
    @k.e.a.d
    public static final List<h.p2.b0.g.t.g.f> a(@k.e.a.d h.p2.b0.g.t.g.f fVar) {
        String b = fVar.b();
        o oVar = o.a;
        if (o.b(b)) {
            return CollectionsKt__CollectionsKt.M(b(fVar));
        }
        if (o.c(b)) {
            return f(fVar);
        }
        return c.a.b(fVar);
    }

    @k.e.a.e
    public static final h.p2.b0.g.t.g.f b(@k.e.a.d h.p2.b0.g.t.g.f fVar) {
        h.p2.b0.g.t.g.f e2 = e(fVar, "get", false, null, 12, null);
        return e2 == null ? e(fVar, "is", false, null, 8, null) : e2;
    }

    @k.e.a.e
    public static final h.p2.b0.g.t.g.f c(@k.e.a.d h.p2.b0.g.t.g.f fVar, boolean z) {
        return e(fVar, "set", false, z ? "is" : null, 4, null);
    }

    private static final h.p2.b0.g.t.g.f d(h.p2.b0.g.t.g.f fVar, String str, boolean z, String str2) {
        if (fVar.g()) {
            return null;
        }
        String identifier = fVar.getIdentifier();
        boolean z2 = false;
        if (u.u2(identifier, str, false, 2, null) && identifier.length() != str.length()) {
            char charAt = identifier.charAt(str.length());
            if ('a' <= charAt && charAt <= 'z') {
                z2 = true;
            }
            if (z2) {
                return null;
            }
            if (str2 != null) {
                return h.p2.b0.g.t.g.f.f(f0.C(str2, StringsKt__StringsKt.c4(identifier, str)));
            }
            if (z) {
                String c2 = h.p2.b0.g.t.o.j.a.c(StringsKt__StringsKt.c4(identifier, str), true);
                if (h.p2.b0.g.t.g.f.h(c2)) {
                    return h.p2.b0.g.t.g.f.f(c2);
                }
                return null;
            }
            return fVar;
        }
        return null;
    }

    public static /* synthetic */ h.p2.b0.g.t.g.f e(h.p2.b0.g.t.g.f fVar, String str, boolean z, String str2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = true;
        }
        if ((i2 & 8) != 0) {
            str2 = null;
        }
        return d(fVar, str, z, str2);
    }

    @k.e.a.d
    public static final List<h.p2.b0.g.t.g.f> f(@k.e.a.d h.p2.b0.g.t.g.f fVar) {
        return CollectionsKt__CollectionsKt.N(c(fVar, false), c(fVar, true));
    }
}
