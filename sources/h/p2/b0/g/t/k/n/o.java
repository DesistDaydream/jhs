package h.p2.b0.g.t.k.n;

import h.k2.v.f0;
import h.p2.b0.g.t.b.g;
import h.p2.b0.g.t.c.t0;
import h.p2.b0.g.t.n.a0;
import h.p2.b0.g.t.n.s0;
import h.p2.b0.g.t.n.u0;
import h.p2.b0.g.t.n.z;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* loaded from: classes3.dex */
public final class o extends g<b> {
    @k.e.a.d
    public static final a b = new a(null);

    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(h.k2.v.u uVar) {
            this();
        }

        @k.e.a.e
        public final g<?> a(@k.e.a.d z zVar) {
            if (a0.a(zVar)) {
                return null;
            }
            z zVar2 = zVar;
            int i2 = 0;
            while (h.p2.b0.g.t.b.f.b0(zVar2)) {
                zVar2 = ((s0) CollectionsKt___CollectionsKt.U4(zVar2.H0())).getType();
                i2++;
            }
            h.p2.b0.g.t.c.f c2 = zVar2.I0().c();
            if (c2 instanceof h.p2.b0.g.t.c.d) {
                h.p2.b0.g.t.g.b h2 = DescriptorUtilsKt.h(c2);
                return h2 == null ? new o(new b.a(zVar)) : new o(h2, i2);
            } else if (c2 instanceof t0) {
                return new o(h.p2.b0.g.t.g.b.m(g.a.b.l()), 0);
            } else {
                return null;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class b {

        /* loaded from: classes3.dex */
        public static final class a extends b {
            @k.e.a.d
            private final z a;

            public a(@k.e.a.d z zVar) {
                super(null);
                this.a = zVar;
            }

            public boolean equals(@k.e.a.e Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof a) && f0.g(this.a, ((a) obj).a);
            }

            @k.e.a.d
            public final z getType() {
                return this.a;
            }

            public int hashCode() {
                return this.a.hashCode();
            }

            @k.e.a.d
            public String toString() {
                return "LocalClass(type=" + this.a + ')';
            }
        }

        /* renamed from: h.p2.b0.g.t.k.n.o$b$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0463b extends b {
            @k.e.a.d
            private final f a;

            public C0463b(@k.e.a.d f fVar) {
                super(null);
                this.a = fVar;
            }

            public final int a() {
                return this.a.c();
            }

            @k.e.a.d
            public final h.p2.b0.g.t.g.b b() {
                return this.a.d();
            }

            @k.e.a.d
            public final f c() {
                return this.a;
            }

            public boolean equals(@k.e.a.e Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof C0463b) && f0.g(this.a, ((C0463b) obj).a);
            }

            public int hashCode() {
                return this.a.hashCode();
            }

            @k.e.a.d
            public String toString() {
                return "NormalClass(value=" + this.a + ')';
            }
        }

        private b() {
        }

        public /* synthetic */ b(h.k2.v.u uVar) {
            this();
        }
    }

    public o(@k.e.a.d b bVar) {
        super(bVar);
    }

    @k.e.a.d
    public final z b(@k.e.a.d h.p2.b0.g.t.c.z zVar) {
        b a2 = a();
        if (a2 instanceof b.a) {
            return ((b.a) a()).getType();
        }
        if (a2 instanceof b.C0463b) {
            f c2 = ((b.C0463b) a()).c();
            h.p2.b0.g.t.g.b a3 = c2.a();
            int b2 = c2.b();
            h.p2.b0.g.t.c.d a4 = FindClassInModuleKt.a(zVar, a3);
            if (a4 == null) {
                return h.p2.b0.g.t.n.s.j("Unresolved type: " + a3 + " (arrayDimensions=" + b2 + ')');
            }
            z s = TypeUtilsKt.s(a4.r());
            for (int i2 = 0; i2 < b2; i2++) {
                s = zVar.k().l(Variance.INVARIANT, s);
            }
            return s;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // h.p2.b0.g.t.k.n.g
    @k.e.a.d
    public z getType(@k.e.a.d h.p2.b0.g.t.c.z zVar) {
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.a;
        return KotlinTypeFactory.g(h.p2.b0.g.t.c.b1.e.w0.b(), zVar.k().E(), h.a2.t.k(new u0(b(zVar))));
    }

    public o(@k.e.a.d f fVar) {
        this(new b.C0463b(fVar));
    }

    public o(@k.e.a.d h.p2.b0.g.t.g.b bVar, int i2) {
        this(new f(bVar, i2));
    }
}
