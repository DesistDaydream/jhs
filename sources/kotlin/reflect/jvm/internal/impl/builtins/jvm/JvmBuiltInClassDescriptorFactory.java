package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import h.a2.c1;
import h.a2.d1;
import h.k2.u.l;
import h.k2.v.f0;
import h.k2.v.n0;
import h.k2.v.u;
import h.p2.b0.g.t.b.g;
import h.p2.b0.g.t.c.b0;
import h.p2.b0.g.t.c.c1.b;
import h.p2.b0.g.t.c.k;
import h.p2.b0.g.t.c.z;
import h.p2.b0.g.t.g.c;
import h.p2.b0.g.t.g.f;
import h.p2.b0.g.t.m.h;
import h.p2.b0.g.t.m.m;
import h.p2.n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;

/* loaded from: classes3.dex */
public final class JvmBuiltInClassDescriptorFactory implements b {
    @d

    /* renamed from: g  reason: collision with root package name */
    private static final f f16424g;
    @d

    /* renamed from: h  reason: collision with root package name */
    private static final h.p2.b0.g.t.g.b f16425h;
    @d
    private final z a;
    @d
    private final l<z, k> b;
    @d

    /* renamed from: c  reason: collision with root package name */
    private final h f16426c;

    /* renamed from: e  reason: collision with root package name */
    public static final /* synthetic */ n<Object>[] f16422e = {n0.r(new PropertyReference1Impl(n0.d(JvmBuiltInClassDescriptorFactory.class), "cloneable", "getCloneable()Lorg/jetbrains/kotlin/descriptors/impl/ClassDescriptorImpl;"))};
    @d

    /* renamed from: d  reason: collision with root package name */
    public static final a f16421d = new a(null);
    @d

    /* renamed from: f  reason: collision with root package name */
    private static final c f16423f = g.n;

    /* renamed from: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInClassDescriptorFactory$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends Lambda implements l<z, h.p2.b0.g.t.b.a> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // h.k2.u.l
        @d
        public final h.p2.b0.g.t.b.a invoke(@d z zVar) {
            List<b0> g0 = zVar.j0(JvmBuiltInClassDescriptorFactory.f16423f).g0();
            ArrayList arrayList = new ArrayList();
            for (Object obj : g0) {
                if (obj instanceof h.p2.b0.g.t.b.a) {
                    arrayList.add(obj);
                }
            }
            return (h.p2.b0.g.t.b.a) CollectionsKt___CollectionsKt.o2(arrayList);
        }
    }

    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @d
        public final h.p2.b0.g.t.g.b a() {
            return JvmBuiltInClassDescriptorFactory.f16425h;
        }
    }

    static {
        h.p2.b0.g.t.g.d dVar = g.a.f15037d;
        f16424g = dVar.i();
        f16425h = h.p2.b0.g.t.g.b.m(dVar.l());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public JvmBuiltInClassDescriptorFactory(@d m mVar, @d z zVar, @d l<? super z, ? extends k> lVar) {
        this.a = zVar;
        this.b = lVar;
        this.f16426c = mVar.c(new JvmBuiltInClassDescriptorFactory$cloneable$2(this, mVar));
    }

    private final h.p2.b0.g.t.c.d1.g i() {
        return (h.p2.b0.g.t.c.d1.g) h.p2.b0.g.t.m.l.a(this.f16426c, this, f16422e[0]);
    }

    @Override // h.p2.b0.g.t.c.c1.b
    @d
    public Collection<h.p2.b0.g.t.c.d> a(@d c cVar) {
        return f0.g(cVar, f16423f) ? c1.f(i()) : d1.k();
    }

    @Override // h.p2.b0.g.t.c.c1.b
    public boolean b(@d c cVar, @d f fVar) {
        return f0.g(fVar, f16424g) && f0.g(cVar, f16423f);
    }

    @Override // h.p2.b0.g.t.c.c1.b
    @e
    public h.p2.b0.g.t.c.d c(@d h.p2.b0.g.t.g.b bVar) {
        if (f0.g(bVar, f16425h)) {
            return i();
        }
        return null;
    }

    public /* synthetic */ JvmBuiltInClassDescriptorFactory(m mVar, z zVar, l lVar, int i2, u uVar) {
        this(mVar, zVar, (i2 & 4) != 0 ? AnonymousClass1.INSTANCE : lVar);
    }
}
