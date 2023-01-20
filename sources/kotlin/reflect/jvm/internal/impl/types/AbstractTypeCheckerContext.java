package kotlin.reflect.jvm.internal.impl.types;

import h.k2.v.u;
import h.p2.b0.g.t.n.g1.b;
import h.p2.b0.g.t.n.g1.g;
import h.p2.b0.g.t.n.g1.i;
import h.p2.b0.g.t.n.g1.p;
import java.util.ArrayDeque;
import java.util.Set;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes3.dex */
public abstract class AbstractTypeCheckerContext {
    private int a;
    private boolean b;
    @e

    /* renamed from: c  reason: collision with root package name */
    private ArrayDeque<i> f16866c;
    @e

    /* renamed from: d  reason: collision with root package name */
    private Set<i> f16867d;

    /* loaded from: classes3.dex */
    public enum LowerCapturedTypePolicy {
        CHECK_ONLY_LOWER,
        CHECK_SUBTYPE_AND_LOWER,
        SKIP_LOWER
    }

    /* loaded from: classes3.dex */
    public static abstract class a {

        /* renamed from: kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static abstract class AbstractC0498a extends a {
            public AbstractC0498a() {
                super(null);
            }
        }

        /* loaded from: classes3.dex */
        public static final class b extends a {
            @k.e.a.d
            public static final b a = new b();

            private b() {
                super(null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext.a
            @k.e.a.d
            public i a(@k.e.a.d AbstractTypeCheckerContext abstractTypeCheckerContext, @k.e.a.d g gVar) {
                return abstractTypeCheckerContext.j().j0(gVar);
            }
        }

        /* loaded from: classes3.dex */
        public static final class c extends a {
            @k.e.a.d
            public static final c a = new c();

            private c() {
                super(null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext.a
            public /* bridge */ /* synthetic */ i a(AbstractTypeCheckerContext abstractTypeCheckerContext, g gVar) {
                return (i) b(abstractTypeCheckerContext, gVar);
            }

            @k.e.a.d
            public Void b(@k.e.a.d AbstractTypeCheckerContext abstractTypeCheckerContext, @k.e.a.d g gVar) {
                throw new UnsupportedOperationException("Should not be called");
            }
        }

        /* loaded from: classes3.dex */
        public static final class d extends a {
            @k.e.a.d
            public static final d a = new d();

            private d() {
                super(null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext.a
            @k.e.a.d
            public i a(@k.e.a.d AbstractTypeCheckerContext abstractTypeCheckerContext, @k.e.a.d g gVar) {
                return abstractTypeCheckerContext.j().u(gVar);
            }
        }

        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @k.e.a.d
        public abstract i a(@k.e.a.d AbstractTypeCheckerContext abstractTypeCheckerContext, @k.e.a.d g gVar);
    }

    public static /* synthetic */ Boolean d(AbstractTypeCheckerContext abstractTypeCheckerContext, g gVar, g gVar2, boolean z, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 4) != 0) {
                z = false;
            }
            return abstractTypeCheckerContext.c(gVar, gVar2, z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addSubtypeConstraint");
    }

    @e
    public Boolean c(@d g gVar, @d g gVar2, boolean z) {
        return null;
    }

    public final void e() {
        this.f16866c.clear();
        this.f16867d.clear();
        this.b = false;
    }

    public boolean f(@d g gVar, @d g gVar2) {
        return true;
    }

    @d
    public LowerCapturedTypePolicy g(@d i iVar, @d b bVar) {
        return LowerCapturedTypePolicy.CHECK_SUBTYPE_AND_LOWER;
    }

    @e
    public final ArrayDeque<i> h() {
        return this.f16866c;
    }

    @e
    public final Set<i> i() {
        return this.f16867d;
    }

    @d
    public abstract p j();

    public final void k() {
        this.b = true;
        if (this.f16866c == null) {
            this.f16866c = new ArrayDeque<>(4);
        }
        if (this.f16867d == null) {
            this.f16867d = h.p2.b0.g.t.p.e.f15632c.a();
        }
    }

    public abstract boolean l(@d g gVar);

    @h.k2.g(name = "isAllowedTypeVariableBridge")
    public final boolean m(@d g gVar) {
        return l(gVar);
    }

    public abstract boolean n();

    public abstract boolean o();

    @d
    public g p(@d g gVar) {
        return gVar;
    }

    @d
    public g q(@d g gVar) {
        return gVar;
    }

    @d
    public abstract a r(@d i iVar);
}
