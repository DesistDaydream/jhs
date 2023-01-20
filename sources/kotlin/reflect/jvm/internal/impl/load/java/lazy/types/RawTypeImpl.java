package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import h.p2.b0.g.t.c.b1.e;
import h.p2.b0.g.t.j.b;
import h.p2.b0.g.t.n.e0;
import h.p2.b0.g.t.n.e1.f;
import h.p2.b0.g.t.n.e1.h;
import h.p2.b0.g.t.n.f0;
import h.p2.b0.g.t.n.s0;
import h.p2.b0.g.t.n.u;
import h.p2.b0.g.t.n.z;
import h.t2.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import k.e.a.d;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes3.dex */
public final class RawTypeImpl extends u implements e0 {
    private RawTypeImpl(f0 f0Var, f0 f0Var2, boolean z) {
        super(f0Var, f0Var2);
        if (z) {
            return;
        }
        f.a.d(f0Var, f0Var2);
    }

    private static final boolean V0(String str, String str2) {
        return h.k2.v.f0.g(str, StringsKt__StringsKt.c4(str2, "out ")) || h.k2.v.f0.g(str2, "*");
    }

    private static final List<String> W0(DescriptorRenderer descriptorRenderer, z zVar) {
        List<s0> H0 = zVar.H0();
        ArrayList arrayList = new ArrayList(h.a2.u.Y(H0, 10));
        for (s0 s0Var : H0) {
            arrayList.add(descriptorRenderer.z(s0Var));
        }
        return arrayList;
    }

    private static final String X0(String str, String str2) {
        if (StringsKt__StringsKt.U2(str, y.f15691d, false, 2, null)) {
            return StringsKt__StringsKt.t5(str, y.f15691d, null, 2, null) + y.f15691d + str2 + y.f15692e + StringsKt__StringsKt.p5(str, y.f15692e, null, 2, null);
        }
        return str;
    }

    @Override // h.p2.b0.g.t.n.u
    @d
    public f0 P0() {
        return Q0();
    }

    @Override // h.p2.b0.g.t.n.u
    @d
    public String S0(@d DescriptorRenderer descriptorRenderer, @d b bVar) {
        String y = descriptorRenderer.y(Q0());
        String y2 = descriptorRenderer.y(R0());
        if (bVar.j()) {
            return "raw (" + y + ".." + y2 + ')';
        } else if (R0().H0().isEmpty()) {
            return descriptorRenderer.v(y, y2, TypeUtilsKt.h(this));
        } else {
            List<String> W0 = W0(descriptorRenderer, Q0());
            List<String> W02 = W0(descriptorRenderer, R0());
            String Z2 = CollectionsKt___CollectionsKt.Z2(W0, ", ", null, null, 0, null, RawTypeImpl$render$newArgs$1.INSTANCE, 30, null);
            List V5 = CollectionsKt___CollectionsKt.V5(W0, W02);
            boolean z = true;
            if (!(V5 instanceof Collection) || !V5.isEmpty()) {
                Iterator it = V5.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Pair pair = (Pair) it.next();
                    if (!V0((String) pair.getFirst(), (String) pair.getSecond())) {
                        z = false;
                        break;
                    }
                }
            }
            if (z) {
                y2 = X0(y2, Z2);
            }
            String X0 = X0(y, Z2);
            return h.k2.v.f0.g(X0, y2) ? X0 : descriptorRenderer.v(X0, y2, TypeUtilsKt.h(this));
        }
    }

    @Override // h.p2.b0.g.t.n.c1
    @d
    /* renamed from: T0 */
    public RawTypeImpl M0(boolean z) {
        return new RawTypeImpl(Q0().P0(z), R0().P0(z));
    }

    @Override // h.p2.b0.g.t.n.c1
    @d
    /* renamed from: U0 */
    public u N0(@d h hVar) {
        return new RawTypeImpl((f0) hVar.g(Q0()), (f0) hVar.g(R0()), true);
    }

    @Override // h.p2.b0.g.t.n.c1
    @d
    /* renamed from: Y0 */
    public RawTypeImpl O0(@d e eVar) {
        return new RawTypeImpl(Q0().Q0(eVar), R0().Q0(eVar));
    }

    @Override // h.p2.b0.g.t.n.u, h.p2.b0.g.t.n.z
    @d
    public MemberScope q() {
        h.p2.b0.g.t.c.f c2 = I0().c();
        h.p2.b0.g.t.c.d dVar = c2 instanceof h.p2.b0.g.t.c.d ? (h.p2.b0.g.t.c.d) c2 : null;
        if (dVar != null) {
            return dVar.o0(RawSubstitution.f16552c);
        }
        throw new IllegalStateException(h.k2.v.f0.C("Incorrect classifier: ", I0().c()).toString());
    }

    public RawTypeImpl(@d f0 f0Var, @d f0 f0Var2) {
        this(f0Var, f0Var2, false);
    }
}
