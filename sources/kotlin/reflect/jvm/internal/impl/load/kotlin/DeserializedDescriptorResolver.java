package kotlin.reflect.jvm.internal.impl.load.kotlin;

import h.a2.c1;
import h.a2.d1;
import h.k2.v.f0;
import h.k2.v.u;
import h.p2.b0.g.t.c.b0;
import h.p2.b0.g.t.e.b.c;
import h.p2.b0.g.t.e.b.m;
import h.p2.b0.g.t.e.b.o;
import h.p2.b0.g.t.f.a0.f.e;
import h.p2.b0.g.t.f.a0.f.f;
import h.p2.b0.g.t.l.b.g;
import h.p2.b0.g.t.l.b.n;
import java.util.Objects;
import java.util.Set;
import k.e.a.d;
import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerAbiStability;

/* loaded from: classes3.dex */
public final class DeserializedDescriptorResolver {
    @d
    public static final a b = new a(null);
    @d

    /* renamed from: c  reason: collision with root package name */
    private static final Set<KotlinClassHeader.Kind> f16568c = c1.f(KotlinClassHeader.Kind.CLASS);
    @d

    /* renamed from: d  reason: collision with root package name */
    private static final Set<KotlinClassHeader.Kind> f16569d = d1.u(KotlinClassHeader.Kind.FILE_FACADE, KotlinClassHeader.Kind.MULTIFILE_CLASS_PART);
    @d

    /* renamed from: e  reason: collision with root package name */
    private static final e f16570e = new e(1, 1, 2);
    @d

    /* renamed from: f  reason: collision with root package name */
    private static final e f16571f = new e(1, 1, 11);
    @d

    /* renamed from: g  reason: collision with root package name */
    private static final e f16572g = new e(1, 1, 13);
    public g a;

    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @d
        public final e a() {
            return DeserializedDescriptorResolver.f16572g;
        }
    }

    private final DeserializedContainerAbiStability d(m mVar) {
        return e().g().d() ? DeserializedContainerAbiStability.STABLE : mVar.c().j() ? DeserializedContainerAbiStability.FIR_UNSTABLE : mVar.c().k() ? DeserializedContainerAbiStability.IR_UNSTABLE : DeserializedContainerAbiStability.STABLE;
    }

    private final n<e> f(m mVar) {
        if (g() || mVar.c().d().h()) {
            return null;
        }
        return new n<>(mVar.c().d(), e.f15360i, mVar.getLocation(), mVar.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean g() {
        return e().g().e();
    }

    private final boolean h(m mVar) {
        return !e().g().b() && mVar.c().i() && f0.g(mVar.c().d(), f16571f);
    }

    private final boolean i(m mVar) {
        return (e().g().f() && (mVar.c().i() || f0.g(mVar.c().d(), f16570e))) || h(mVar);
    }

    private final String[] k(m mVar, Set<? extends KotlinClassHeader.Kind> set) {
        KotlinClassHeader c2 = mVar.c();
        String[] a2 = c2.a();
        if (a2 == null) {
            a2 = c2.b();
        }
        if (a2 != null && set.contains(c2.c())) {
            return a2;
        }
        return null;
    }

    @k.e.a.e
    public final MemberScope c(@d b0 b0Var, @d m mVar) {
        String[] g2;
        Pair<f, ProtoBuf.Package> pair;
        String[] k2 = k(mVar, f16569d);
        if (k2 == null || (g2 = mVar.c().g()) == null) {
            return null;
        }
        try {
            try {
                h.p2.b0.g.t.f.a0.f.g gVar = h.p2.b0.g.t.f.a0.f.g.a;
                pair = h.p2.b0.g.t.f.a0.f.g.m(k2, g2);
            } catch (InvalidProtocolBufferException e2) {
                throw new IllegalStateException(f0.C("Could not read data from ", mVar.getLocation()), e2);
            }
        } catch (Throwable th) {
            if (g() || mVar.c().d().h()) {
                throw th;
            }
            pair = null;
        }
        if (pair == null) {
            return null;
        }
        f component1 = pair.component1();
        ProtoBuf.Package component2 = pair.component2();
        return new h.p2.b0.g.t.l.b.x.f(b0Var, component2, component1, mVar.c().d(), new h.p2.b0.g.t.e.b.g(mVar, component2, component1, f(mVar), i(mVar), d(mVar)), e(), DeserializedDescriptorResolver$createKotlinPackagePartScope$2.INSTANCE);
    }

    @d
    public final g e() {
        g gVar = this.a;
        Objects.requireNonNull(gVar);
        return gVar;
    }

    @k.e.a.e
    public final h.p2.b0.g.t.l.b.d j(@d m mVar) {
        String[] g2;
        Pair<f, ProtoBuf.Class> pair;
        String[] k2 = k(mVar, f16568c);
        if (k2 == null || (g2 = mVar.c().g()) == null) {
            return null;
        }
        try {
            try {
                h.p2.b0.g.t.f.a0.f.g gVar = h.p2.b0.g.t.f.a0.f.g.a;
                pair = h.p2.b0.g.t.f.a0.f.g.i(k2, g2);
            } catch (InvalidProtocolBufferException e2) {
                throw new IllegalStateException(f0.C("Could not read data from ", mVar.getLocation()), e2);
            }
        } catch (Throwable th) {
            if (g() || mVar.c().d().h()) {
                throw th;
            }
            pair = null;
        }
        if (pair == null) {
            return null;
        }
        return new h.p2.b0.g.t.l.b.d(pair.component1(), pair.component2(), mVar.c().d(), new o(mVar, f(mVar), i(mVar), d(mVar)));
    }

    @k.e.a.e
    public final h.p2.b0.g.t.c.d l(@d m mVar) {
        h.p2.b0.g.t.l.b.d j2 = j(mVar);
        if (j2 == null) {
            return null;
        }
        return e().f().d(mVar.b(), j2);
    }

    public final void m(@d c cVar) {
        n(cVar.a());
    }

    public final void n(@d g gVar) {
        this.a = gVar;
    }
}
