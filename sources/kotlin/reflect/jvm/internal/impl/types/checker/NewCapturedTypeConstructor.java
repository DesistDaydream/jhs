package kotlin.reflect.jvm.internal.impl.types.checker;

import h.k2.u.a;
import h.k2.v.f0;
import h.k2.v.u;
import h.p2.b0.g.t.c.f;
import h.p2.b0.g.t.c.t0;
import h.p2.b0.g.t.k.m.a.b;
import h.p2.b0.g.t.n.c1;
import h.p2.b0.g.t.n.e1.h;
import h.p2.b0.g.t.n.s0;
import h.w;
import h.z;
import java.util.List;
import java.util.Objects;
import k.e.a.d;
import k.e.a.e;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* loaded from: classes3.dex */
public final class NewCapturedTypeConstructor implements b {
    @d
    private final s0 a;
    @e
    private a<? extends List<? extends c1>> b;
    @e

    /* renamed from: c  reason: collision with root package name */
    private final NewCapturedTypeConstructor f16874c;
    @e

    /* renamed from: d  reason: collision with root package name */
    private final t0 f16875d;
    @d

    /* renamed from: e  reason: collision with root package name */
    private final w f16876e;

    /* renamed from: kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends Lambda implements a<List<? extends c1>> {
        public final /* synthetic */ List<c1> $supertypes;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(List<? extends c1> list) {
            super(0);
            this.$supertypes = list;
        }

        @Override // h.k2.u.a
        @d
        public final List<? extends c1> invoke() {
            return this.$supertypes;
        }
    }

    public NewCapturedTypeConstructor(@d s0 s0Var, @e a<? extends List<? extends c1>> aVar, @e NewCapturedTypeConstructor newCapturedTypeConstructor, @e t0 t0Var) {
        this.a = s0Var;
        this.b = aVar;
        this.f16874c = newCapturedTypeConstructor;
        this.f16875d = t0Var;
        this.f16876e = z.b(LazyThreadSafetyMode.PUBLICATION, new NewCapturedTypeConstructor$_supertypes$2(this));
    }

    private final List<c1> g() {
        return (List) this.f16876e.getValue();
    }

    @Override // h.p2.b0.g.t.k.m.a.b
    @d
    public s0 b() {
        return this.a;
    }

    @Override // h.p2.b0.g.t.n.q0
    @e
    public f c() {
        return null;
    }

    @Override // h.p2.b0.g.t.n.q0
    public boolean d() {
        return false;
    }

    public boolean equals(@e Object obj) {
        if (this == obj) {
            return true;
        }
        if (f0.g(NewCapturedTypeConstructor.class, obj == null ? null : obj.getClass())) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type org.jetbrains.kotlin.types.checker.NewCapturedTypeConstructor");
            NewCapturedTypeConstructor newCapturedTypeConstructor = (NewCapturedTypeConstructor) obj;
            NewCapturedTypeConstructor newCapturedTypeConstructor2 = this.f16874c;
            if (newCapturedTypeConstructor2 == null) {
                newCapturedTypeConstructor2 = this;
            }
            NewCapturedTypeConstructor newCapturedTypeConstructor3 = newCapturedTypeConstructor.f16874c;
            if (newCapturedTypeConstructor3 != null) {
                newCapturedTypeConstructor = newCapturedTypeConstructor3;
            }
            return newCapturedTypeConstructor2 == newCapturedTypeConstructor;
        }
        return false;
    }

    @Override // h.p2.b0.g.t.n.q0
    @d
    /* renamed from: f */
    public List<c1> j() {
        List<c1> g2 = g();
        return g2 == null ? CollectionsKt__CollectionsKt.E() : g2;
    }

    @Override // h.p2.b0.g.t.n.q0
    @d
    public List<t0> getParameters() {
        return CollectionsKt__CollectionsKt.E();
    }

    public final void h(@d List<? extends c1> list) {
        a<? extends List<? extends c1>> aVar = this.b;
        this.b = new NewCapturedTypeConstructor$initializeSupertypes$2(list);
    }

    public int hashCode() {
        NewCapturedTypeConstructor newCapturedTypeConstructor = this.f16874c;
        return newCapturedTypeConstructor == null ? super.hashCode() : newCapturedTypeConstructor.hashCode();
    }

    @Override // h.p2.b0.g.t.n.q0
    @d
    /* renamed from: i */
    public NewCapturedTypeConstructor a(@d h hVar) {
        s0 a = b().a(hVar);
        NewCapturedTypeConstructor$refine$1$1 newCapturedTypeConstructor$refine$1$1 = this.b == null ? null : new NewCapturedTypeConstructor$refine$1$1(this, hVar);
        NewCapturedTypeConstructor newCapturedTypeConstructor = this.f16874c;
        if (newCapturedTypeConstructor == null) {
            newCapturedTypeConstructor = this;
        }
        return new NewCapturedTypeConstructor(a, newCapturedTypeConstructor$refine$1$1, newCapturedTypeConstructor, this.f16875d);
    }

    @Override // h.p2.b0.g.t.n.q0
    @d
    public h.p2.b0.g.t.b.f k() {
        return TypeUtilsKt.h(b().getType());
    }

    @d
    public String toString() {
        return "CapturedType(" + b() + ')';
    }

    public /* synthetic */ NewCapturedTypeConstructor(s0 s0Var, a aVar, NewCapturedTypeConstructor newCapturedTypeConstructor, t0 t0Var, int i2, u uVar) {
        this(s0Var, (i2 & 2) != 0 ? null : aVar, (i2 & 4) != 0 ? null : newCapturedTypeConstructor, (i2 & 8) != 0 ? null : t0Var);
    }

    public /* synthetic */ NewCapturedTypeConstructor(s0 s0Var, List list, NewCapturedTypeConstructor newCapturedTypeConstructor, int i2, u uVar) {
        this(s0Var, list, (i2 & 4) != 0 ? null : newCapturedTypeConstructor);
    }

    public NewCapturedTypeConstructor(@d s0 s0Var, @d List<? extends c1> list, @e NewCapturedTypeConstructor newCapturedTypeConstructor) {
        this(s0Var, new AnonymousClass1(list), newCapturedTypeConstructor, null, 8, null);
    }
}
