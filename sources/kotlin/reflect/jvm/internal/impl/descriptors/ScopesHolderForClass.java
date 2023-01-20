package kotlin.reflect.jvm.internal.impl.descriptors;

import h.k2.u.l;
import h.k2.v.n0;
import h.k2.v.u;
import h.p2.b0.g.t.m.m;
import h.p2.b0.g.t.n.e1.h;
import h.p2.n;
import k.e.a.d;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* loaded from: classes3.dex */
public final class ScopesHolderForClass<T extends MemberScope> {
    @d
    private final h.p2.b0.g.t.c.d a;
    @d
    private final l<h, T> b;
    @d

    /* renamed from: c  reason: collision with root package name */
    private final h f16444c;
    @d

    /* renamed from: d  reason: collision with root package name */
    private final h.p2.b0.g.t.m.h f16445d;

    /* renamed from: f  reason: collision with root package name */
    public static final /* synthetic */ n<Object>[] f16443f = {n0.r(new PropertyReference1Impl(n0.d(ScopesHolderForClass.class), "scopeForOwnerModule", "getScopeForOwnerModule()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;"))};
    @d

    /* renamed from: e  reason: collision with root package name */
    public static final a f16442e = new a(null);

    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @d
        public final <T extends MemberScope> ScopesHolderForClass<T> a(@d h.p2.b0.g.t.c.d dVar, @d m mVar, @d h hVar, @d l<? super h, ? extends T> lVar) {
            return new ScopesHolderForClass<>(dVar, mVar, lVar, hVar, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ScopesHolderForClass(h.p2.b0.g.t.c.d dVar, m mVar, l<? super h, ? extends T> lVar, h hVar) {
        this.a = dVar;
        this.b = lVar;
        this.f16444c = hVar;
        this.f16445d = mVar.c(new ScopesHolderForClass$scopeForOwnerModule$2(this));
    }

    public /* synthetic */ ScopesHolderForClass(h.p2.b0.g.t.c.d dVar, m mVar, l lVar, h hVar, u uVar) {
        this(dVar, mVar, lVar, hVar);
    }

    private final T d() {
        return (T) h.p2.b0.g.t.m.l.a(this.f16445d, this, f16443f[0]);
    }

    @d
    public final T c(@d h hVar) {
        if (hVar.c(DescriptorUtilsKt.l(this.a)) && hVar.d(this.a.j())) {
            return (T) hVar.b(this.a, new ScopesHolderForClass$getScope$1(this, hVar));
        }
        return d();
    }
}
