package h.p2.b0.g.t.b.j;

import h.a2.d1;
import h.p2.b0.g.t.c.b0;
import h.p2.b0.g.t.c.z;
import h.p2.b0.g.t.g.f;
import h.p2.b0.g.t.m.m;
import h.t2.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import k.e.a.e;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes3.dex */
public final class a implements h.p2.b0.g.t.c.c1.b {
    @k.e.a.d
    private final m a;
    @k.e.a.d
    private final z b;

    public a(@k.e.a.d m mVar, @k.e.a.d z zVar) {
        this.a = mVar;
        this.b = zVar;
    }

    @Override // h.p2.b0.g.t.c.c1.b
    @k.e.a.d
    public Collection<h.p2.b0.g.t.c.d> a(@k.e.a.d h.p2.b0.g.t.g.c cVar) {
        return d1.k();
    }

    @Override // h.p2.b0.g.t.c.c1.b
    public boolean b(@k.e.a.d h.p2.b0.g.t.g.c cVar, @k.e.a.d f fVar) {
        String b = fVar.b();
        return (u.u2(b, "Function", false, 2, null) || u.u2(b, "KFunction", false, 2, null) || u.u2(b, "SuspendFunction", false, 2, null) || u.u2(b, "KSuspendFunction", false, 2, null)) && FunctionClassKind.Companion.c(b, cVar) != null;
    }

    @Override // h.p2.b0.g.t.c.c1.b
    @e
    public h.p2.b0.g.t.c.d c(@k.e.a.d h.p2.b0.g.t.g.b bVar) {
        h.p2.b0.g.t.g.c h2;
        FunctionClassKind.a.C0493a c2;
        if (bVar.k() || bVar.l()) {
            return null;
        }
        String b = bVar.i().b();
        if (StringsKt__StringsKt.V2(b, "Function", false, 2, null) && (c2 = FunctionClassKind.Companion.c(b, (h2 = bVar.h()))) != null) {
            FunctionClassKind a = c2.a();
            int b2 = c2.b();
            List<b0> g0 = this.b.j0(h2).g0();
            ArrayList arrayList = new ArrayList();
            for (Object obj : g0) {
                if (obj instanceof h.p2.b0.g.t.b.a) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : arrayList) {
                if (obj2 instanceof h.p2.b0.g.t.b.d) {
                    arrayList2.add(obj2);
                }
            }
            b0 b0Var = (h.p2.b0.g.t.b.d) CollectionsKt___CollectionsKt.t2(arrayList2);
            if (b0Var == null) {
                b0Var = (h.p2.b0.g.t.b.a) CollectionsKt___CollectionsKt.o2(arrayList);
            }
            return new b(this.a, b0Var, a, b2);
        }
        return null;
    }
}
