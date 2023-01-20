package h.p2.b0.g.t.b.k;

import h.a2.t;
import h.k2.v.u;
import h.p2.b0.g.t.c.d1.d0;
import h.p2.b0.g.t.c.o0;
import h.p2.b0.g.t.c.r;
import h.p2.b0.g.t.c.v;
import h.p2.b0.g.t.m.m;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope;

/* loaded from: classes3.dex */
public final class a extends GivenFunctionsMemberScope {
    @k.e.a.d

    /* renamed from: e  reason: collision with root package name */
    public static final C0433a f15060e = new C0433a(null);
    @k.e.a.d

    /* renamed from: f  reason: collision with root package name */
    private static final h.p2.b0.g.t.g.f f15061f = h.p2.b0.g.t.g.f.f("clone");

    /* renamed from: h.p2.b0.g.t.b.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0433a {
        private C0433a() {
        }

        public /* synthetic */ C0433a(u uVar) {
            this();
        }

        @k.e.a.d
        public final h.p2.b0.g.t.g.f a() {
            return a.f15061f;
        }
    }

    public a(@k.e.a.d m mVar, @k.e.a.d h.p2.b0.g.t.c.d dVar) {
        super(mVar, dVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope
    @k.e.a.d
    public List<v> j() {
        d0 h1 = d0.h1(m(), h.p2.b0.g.t.c.b1.e.w0.b(), f15061f, CallableMemberDescriptor.Kind.DECLARATION, o0.a);
        h1.N0(null, m().F0(), CollectionsKt__CollectionsKt.E(), CollectionsKt__CollectionsKt.E(), DescriptorUtilsKt.g(m()).i(), Modality.OPEN, r.f15209c);
        return t.k(h1);
    }
}
