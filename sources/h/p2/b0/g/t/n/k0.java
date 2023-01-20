package h.p2.b0.g.t.n;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* loaded from: classes3.dex */
public final class k0 {

    /* loaded from: classes3.dex */
    public static final class a extends r0 {

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ List<q0> f15587d;

        /* JADX WARN: Multi-variable type inference failed */
        public a(List<? extends q0> list) {
            this.f15587d = list;
        }

        @Override // h.p2.b0.g.t.n.r0
        @k.e.a.e
        public s0 j(@k.e.a.d q0 q0Var) {
            if (this.f15587d.contains(q0Var)) {
                h.p2.b0.g.t.c.f c2 = q0Var.c();
                Objects.requireNonNull(c2, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
                return y0.s((h.p2.b0.g.t.c.t0) c2);
            }
            return null;
        }
    }

    @k.e.a.d
    public static final z a(@k.e.a.d h.p2.b0.g.t.c.t0 t0Var) {
        List<h.p2.b0.g.t.c.t0> parameters = ((h.p2.b0.g.t.c.g) t0Var.b()).j().getParameters();
        ArrayList arrayList = new ArrayList(h.a2.u.Y(parameters, 10));
        for (h.p2.b0.g.t.c.t0 t0Var2 : parameters) {
            arrayList.add(t0Var2.j());
        }
        z p = TypeSubstitutor.g(new a(arrayList)).p((z) CollectionsKt___CollectionsKt.o2(t0Var.getUpperBounds()), Variance.OUT_VARIANCE);
        return p == null ? DescriptorUtilsKt.g(t0Var).y() : p;
    }
}
