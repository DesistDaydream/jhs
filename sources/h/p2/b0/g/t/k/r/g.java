package h.p2.b0.g.t.k.r;

import h.a2.y;
import java.util.HashSet;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* loaded from: classes3.dex */
public final class g {
    @k.e.a.e
    public static final Set<h.p2.b0.g.t.g.f> a(@k.e.a.d Iterable<? extends MemberScope> iterable) {
        HashSet hashSet = new HashSet();
        for (MemberScope memberScope : iterable) {
            Set<h.p2.b0.g.t.g.f> e2 = memberScope.e();
            if (e2 == null) {
                return null;
            }
            y.q0(hashSet, e2);
        }
        return hashSet;
    }
}
