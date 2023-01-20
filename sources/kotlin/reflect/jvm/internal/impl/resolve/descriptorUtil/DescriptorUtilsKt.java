package kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil;

import h.a2.t;
import h.a2.u;
import h.k2.u.l;
import h.p2.b0.g.t.c.b0;
import h.p2.b0.g.t.c.i0;
import h.p2.b0.g.t.c.k;
import h.p2.b0.g.t.c.v0;
import h.p2.b0.g.t.c.z;
import h.p2.b0.g.t.g.f;
import h.p2.b0.g.t.k.n.g;
import h.p2.b0.g.t.n.e1.h;
import h.p2.b0.g.t.n.e1.i;
import h.p2.b0.g.t.n.e1.p;
import h.p2.b0.g.t.p.b;
import h.q2.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import k.e.a.d;
import k.e.a.e;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Ref;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;

/* loaded from: classes3.dex */
public final class DescriptorUtilsKt {
    @d
    private static final f a = f.f("value");

    /* loaded from: classes3.dex */
    public static final class a<N> implements b.d<v0> {
        public static final a<N> a = new a<>();

        @Override // h.p2.b0.g.t.p.b.d
        @d
        /* renamed from: b */
        public final Iterable<v0> a(v0 v0Var) {
            Collection<v0> d2 = v0Var.d();
            ArrayList arrayList = new ArrayList(u.Y(d2, 10));
            for (v0 v0Var2 : d2) {
                arrayList.add(v0Var2.a());
            }
            return arrayList;
        }
    }

    /* loaded from: classes3.dex */
    public static final class b<N> implements b.d<CallableMemberDescriptor> {
        public final /* synthetic */ boolean a;

        public b(boolean z) {
            this.a = z;
        }

        @Override // h.p2.b0.g.t.p.b.d
        @d
        /* renamed from: b */
        public final Iterable<CallableMemberDescriptor> a(CallableMemberDescriptor callableMemberDescriptor) {
            if (this.a) {
                callableMemberDescriptor = callableMemberDescriptor == null ? null : callableMemberDescriptor.a();
            }
            Collection<? extends CallableMemberDescriptor> d2 = callableMemberDescriptor != null ? callableMemberDescriptor.d() : null;
            return d2 == null ? CollectionsKt__CollectionsKt.E() : d2;
        }
    }

    /* loaded from: classes3.dex */
    public static final class c extends b.AbstractC0472b<CallableMemberDescriptor, CallableMemberDescriptor> {
        public final /* synthetic */ Ref.ObjectRef<CallableMemberDescriptor> a;
        public final /* synthetic */ l<CallableMemberDescriptor, Boolean> b;

        /* JADX WARN: Multi-variable type inference failed */
        public c(Ref.ObjectRef<CallableMemberDescriptor> objectRef, l<? super CallableMemberDescriptor, Boolean> lVar) {
            this.a = objectRef;
            this.b = lVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // h.p2.b0.g.t.p.b.AbstractC0472b, h.p2.b0.g.t.p.b.e
        /* renamed from: d */
        public void b(@d CallableMemberDescriptor callableMemberDescriptor) {
            if (this.a.element == null && this.b.invoke(callableMemberDescriptor).booleanValue()) {
                this.a.element = callableMemberDescriptor;
            }
        }

        @Override // h.p2.b0.g.t.p.b.AbstractC0472b, h.p2.b0.g.t.p.b.e
        /* renamed from: e */
        public boolean c(@d CallableMemberDescriptor callableMemberDescriptor) {
            return this.a.element == null;
        }

        @Override // h.p2.b0.g.t.p.b.e
        @e
        /* renamed from: f */
        public CallableMemberDescriptor a() {
            return this.a.element;
        }
    }

    public static final boolean a(@d v0 v0Var) {
        return h.p2.b0.g.t.p.b.e(t.k(v0Var), a.a, DescriptorUtilsKt$declaresOrInheritsDefaultValue$2.INSTANCE).booleanValue();
    }

    @e
    public static final g<?> b(@d h.p2.b0.g.t.c.b1.c cVar) {
        return (g) CollectionsKt___CollectionsKt.r2(cVar.a().values());
    }

    @e
    public static final CallableMemberDescriptor c(@d CallableMemberDescriptor callableMemberDescriptor, boolean z, @d l<? super CallableMemberDescriptor, Boolean> lVar) {
        return (CallableMemberDescriptor) h.p2.b0.g.t.p.b.b(t.k(callableMemberDescriptor), new b(z), new c(new Ref.ObjectRef(), lVar));
    }

    public static /* synthetic */ CallableMemberDescriptor d(CallableMemberDescriptor callableMemberDescriptor, boolean z, l lVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        return c(callableMemberDescriptor, z, lVar);
    }

    @e
    public static final h.p2.b0.g.t.g.c e(@d k kVar) {
        h.p2.b0.g.t.g.d j2 = j(kVar);
        if (!j2.f()) {
            j2 = null;
        }
        if (j2 == null) {
            return null;
        }
        return j2.l();
    }

    @e
    public static final h.p2.b0.g.t.c.d f(@d h.p2.b0.g.t.c.b1.c cVar) {
        h.p2.b0.g.t.c.f c2 = cVar.getType().I0().c();
        if (c2 instanceof h.p2.b0.g.t.c.d) {
            return (h.p2.b0.g.t.c.d) c2;
        }
        return null;
    }

    @d
    public static final h.p2.b0.g.t.b.f g(@d k kVar) {
        return l(kVar).k();
    }

    @e
    public static final h.p2.b0.g.t.g.b h(@e h.p2.b0.g.t.c.f fVar) {
        k b2;
        h.p2.b0.g.t.g.b h2;
        if (fVar == null || (b2 = fVar.b()) == null) {
            return null;
        }
        if (b2 instanceof b0) {
            return new h.p2.b0.g.t.g.b(((b0) b2).e(), fVar.getName());
        }
        if (!(b2 instanceof h.p2.b0.g.t.c.g) || (h2 = h((h.p2.b0.g.t.c.f) b2)) == null) {
            return null;
        }
        return h2.d(fVar.getName());
    }

    @d
    public static final h.p2.b0.g.t.g.c i(@d k kVar) {
        return h.p2.b0.g.t.k.c.n(kVar);
    }

    @d
    public static final h.p2.b0.g.t.g.d j(@d k kVar) {
        return h.p2.b0.g.t.k.c.m(kVar);
    }

    @d
    public static final h k(@d z zVar) {
        p pVar = (p) zVar.D0(i.a());
        h hVar = pVar == null ? null : (h) pVar.a();
        return hVar == null ? h.a.a : hVar;
    }

    @d
    public static final z l(@d k kVar) {
        return h.p2.b0.g.t.k.c.g(kVar);
    }

    @d
    public static final m<k> m(@d k kVar) {
        return SequencesKt___SequencesKt.d0(n(kVar), 1);
    }

    @d
    public static final m<k> n(@d k kVar) {
        return SequencesKt__SequencesKt.o(kVar, DescriptorUtilsKt$parentsWithSelf$1.INSTANCE);
    }

    @d
    public static final CallableMemberDescriptor o(@d CallableMemberDescriptor callableMemberDescriptor) {
        return callableMemberDescriptor instanceof i0 ? ((i0) callableMemberDescriptor).V() : callableMemberDescriptor;
    }

    @e
    public static final h.p2.b0.g.t.c.d p(@d h.p2.b0.g.t.c.d dVar) {
        for (h.p2.b0.g.t.n.z zVar : dVar.r().I0().j()) {
            if (!h.p2.b0.g.t.b.f.a0(zVar)) {
                h.p2.b0.g.t.c.f c2 = zVar.I0().c();
                if (h.p2.b0.g.t.k.c.w(c2)) {
                    Objects.requireNonNull(c2, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    return (h.p2.b0.g.t.c.d) c2;
                }
            }
        }
        return null;
    }

    public static final boolean q(@d z zVar) {
        p pVar = (p) zVar.D0(i.a());
        return (pVar == null ? null : (h) pVar.a()) != null;
    }

    @e
    public static final h.p2.b0.g.t.c.d r(@d z zVar, @d h.p2.b0.g.t.g.c cVar, @d h.p2.b0.g.t.d.b.b bVar) {
        cVar.d();
        h.p2.b0.g.t.c.f f2 = zVar.j0(cVar.e()).q().f(cVar.g(), bVar);
        if (f2 instanceof h.p2.b0.g.t.c.d) {
            return (h.p2.b0.g.t.c.d) f2;
        }
        return null;
    }
}
