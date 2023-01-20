package h.p2.b0.g.t.c.d1;

import h.p2.b0.g.t.n.v0;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* loaded from: classes3.dex */
public abstract class r implements h.p2.b0.g.t.c.d {
    @k.e.a.d
    public static final a a = new a(null);

    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(h.k2.v.u uVar) {
            this();
        }

        @k.e.a.d
        public final MemberScope a(@k.e.a.d h.p2.b0.g.t.c.d dVar, @k.e.a.d v0 v0Var, @k.e.a.d h.p2.b0.g.t.n.e1.h hVar) {
            r rVar = dVar instanceof r ? (r) dVar : null;
            return rVar == null ? dVar.o0(v0Var) : rVar.A(v0Var, hVar);
        }

        @k.e.a.d
        public final MemberScope b(@k.e.a.d h.p2.b0.g.t.c.d dVar, @k.e.a.d h.p2.b0.g.t.n.e1.h hVar) {
            r rVar = dVar instanceof r ? (r) dVar : null;
            return rVar == null ? dVar.W() : rVar.f0(hVar);
        }
    }

    @k.e.a.d
    public abstract MemberScope A(@k.e.a.d v0 v0Var, @k.e.a.d h.p2.b0.g.t.n.e1.h hVar);

    @k.e.a.d
    public abstract MemberScope f0(@k.e.a.d h.p2.b0.g.t.n.e1.h hVar);
}
