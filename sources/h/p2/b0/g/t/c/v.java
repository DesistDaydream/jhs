package h.p2.b0.g.t.c;

import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;

/* loaded from: classes3.dex */
public interface v extends CallableMemberDescriptor {

    /* loaded from: classes3.dex */
    public interface a<D extends v> {
        @k.e.a.d
        a<D> a();

        @k.e.a.d
        a<D> b(@k.e.a.d List<v0> list);

        @k.e.a.e
        D build();

        @k.e.a.d
        a<D> c(@k.e.a.e m0 m0Var);

        @k.e.a.d
        a<D> d();

        @k.e.a.d
        a<D> e(@k.e.a.e m0 m0Var);

        @k.e.a.d
        a<D> f(@k.e.a.d h.p2.b0.g.t.n.v0 v0Var);

        @k.e.a.d
        a<D> g(@k.e.a.d s sVar);

        @k.e.a.d
        a<D> h();

        @k.e.a.d
        a<D> i(@k.e.a.d h.p2.b0.g.t.g.f fVar);

        @k.e.a.d
        a<D> j(@k.e.a.d Modality modality);

        @k.e.a.d
        a<D> k();

        @k.e.a.d
        a<D> l(@k.e.a.d h.p2.b0.g.t.n.z zVar);

        @k.e.a.d
        a<D> m(@k.e.a.e CallableMemberDescriptor callableMemberDescriptor);

        @k.e.a.d
        a<D> n(boolean z);

        @k.e.a.d
        a<D> o(@k.e.a.d List<t0> list);

        @k.e.a.d
        a<D> p(@k.e.a.d k kVar);

        @k.e.a.d
        a<D> q(@k.e.a.d CallableMemberDescriptor.Kind kind);

        @k.e.a.d
        a<D> r(@k.e.a.d h.p2.b0.g.t.c.b1.e eVar);

        @k.e.a.d
        a<D> s();
    }

    boolean B0();

    boolean D();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, h.p2.b0.g.t.c.a, h.p2.b0.g.t.c.k
    @k.e.a.d
    v a();

    @Override // h.p2.b0.g.t.c.l, h.p2.b0.g.t.c.k
    @k.e.a.d
    k b();

    @k.e.a.e
    v c(@k.e.a.d TypeSubstitutor typeSubstitutor);

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, h.p2.b0.g.t.c.a
    @k.e.a.d
    Collection<? extends v> d();

    boolean isInfix();

    boolean isInline();

    boolean isOperator();

    boolean isSuspend();

    @k.e.a.e
    v q0();

    @k.e.a.d
    a<? extends v> x();

    boolean z0();
}
