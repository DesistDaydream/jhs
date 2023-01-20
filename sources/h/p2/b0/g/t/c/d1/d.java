package h.p2.b0.g.t.c.d1;

import com.tencent.android.tpush.common.MessageKey;
import h.p2.b0.g.t.c.o0;
import h.p2.b0.g.t.c.r0;
import h.p2.b0.g.t.c.t0;
import h.p2.b0.g.t.n.q0;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorEquivalenceForOverrides;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.LazyScopeAdapter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.TypeIntersectionScope;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* loaded from: classes3.dex */
public abstract class d extends j implements t0 {

    /* renamed from: e  reason: collision with root package name */
    private final Variance f15093e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f15094f;

    /* renamed from: g  reason: collision with root package name */
    private final int f15095g;

    /* renamed from: h  reason: collision with root package name */
    private final h.p2.b0.g.t.m.h<q0> f15096h;

    /* renamed from: i  reason: collision with root package name */
    private final h.p2.b0.g.t.m.h<h.p2.b0.g.t.n.f0> f15097i;

    /* renamed from: j  reason: collision with root package name */
    private final h.p2.b0.g.t.m.m f15098j;

    /* loaded from: classes3.dex */
    public class a implements h.k2.u.a<q0> {
        public final /* synthetic */ h.p2.b0.g.t.m.m a;
        public final /* synthetic */ r0 b;

        public a(h.p2.b0.g.t.m.m mVar, r0 r0Var) {
            this.a = mVar;
            this.b = r0Var;
        }

        @Override // h.k2.u.a
        /* renamed from: a */
        public q0 invoke() {
            return new c(d.this, this.a, this.b);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements h.k2.u.a<h.p2.b0.g.t.n.f0> {
        public final /* synthetic */ h.p2.b0.g.t.g.f a;

        /* loaded from: classes3.dex */
        public class a implements h.k2.u.a<MemberScope> {
            public a() {
            }

            @Override // h.k2.u.a
            /* renamed from: a */
            public MemberScope invoke() {
                return TypeIntersectionScope.k("Scope for type parameter " + b.this.a.b(), d.this.getUpperBounds());
            }
        }

        public b(h.p2.b0.g.t.g.f fVar) {
            this.a = fVar;
        }

        @Override // h.k2.u.a
        /* renamed from: a */
        public h.p2.b0.g.t.n.f0 invoke() {
            return KotlinTypeFactory.j(h.p2.b0.g.t.c.b1.e.w0.b(), d.this.j(), Collections.emptyList(), false, new LazyScopeAdapter(new a()));
        }
    }

    /* loaded from: classes3.dex */
    public class c extends AbstractTypeConstructor {

        /* renamed from: d  reason: collision with root package name */
        private final r0 f15100d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f15101e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@k.e.a.d d dVar, h.p2.b0.g.t.m.m mVar, r0 r0Var) {
            super(mVar);
            if (mVar == null) {
                u(0);
            }
            this.f15101e = dVar;
            this.f15100d = r0Var;
        }

        private static /* synthetic */ void u(int i2) {
            String str = (i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5 || i2 == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5 || i2 == 8) ? 2 : 3];
            switch (i2) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 8:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor";
                    break;
                case 6:
                    objArr[0] = "type";
                    break;
                case 7:
                    objArr[0] = "supertypes";
                    break;
                case 9:
                    objArr[0] = "classifier";
                    break;
                default:
                    objArr[0] = "storageManager";
                    break;
            }
            if (i2 == 1) {
                objArr[1] = "computeSupertypes";
            } else if (i2 == 2) {
                objArr[1] = "getParameters";
            } else if (i2 == 3) {
                objArr[1] = "getDeclarationDescriptor";
            } else if (i2 == 4) {
                objArr[1] = "getBuiltIns";
            } else if (i2 == 5) {
                objArr[1] = "getSupertypeLoopChecker";
            } else if (i2 != 8) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor";
            } else {
                objArr[1] = "processSupertypesWithoutCycles";
            }
            switch (i2) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 8:
                    break;
                case 6:
                    objArr[2] = "reportSupertypeLoopError";
                    break;
                case 7:
                    objArr[2] = "processSupertypesWithoutCycles";
                    break;
                case 9:
                    objArr[2] = "isSameClassifier";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String format = String.format(str, objArr);
            if (i2 != 1 && i2 != 2 && i2 != 3 && i2 != 4 && i2 != 5 && i2 != 8) {
                throw new IllegalArgumentException(format);
            }
            throw new IllegalStateException(format);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor, h.p2.b0.g.t.n.q0
        @k.e.a.d
        public h.p2.b0.g.t.c.f c() {
            d dVar = this.f15101e;
            if (dVar == null) {
                u(3);
            }
            return dVar;
        }

        @Override // h.p2.b0.g.t.n.q0
        public boolean d() {
            return true;
        }

        @Override // h.p2.b0.g.t.n.q0
        @k.e.a.d
        public List<t0> getParameters() {
            List<t0> emptyList = Collections.emptyList();
            if (emptyList == null) {
                u(2);
            }
            return emptyList;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        @k.e.a.d
        public Collection<h.p2.b0.g.t.n.z> h() {
            List<h.p2.b0.g.t.n.z> H0 = this.f15101e.H0();
            if (H0 == null) {
                u(1);
            }
            return H0;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        @k.e.a.e
        public h.p2.b0.g.t.n.z i() {
            return h.p2.b0.g.t.n.s.j("Cyclic upper bounds");
        }

        @Override // h.p2.b0.g.t.n.q0
        @k.e.a.d
        public h.p2.b0.g.t.b.f k() {
            h.p2.b0.g.t.b.f g2 = DescriptorUtilsKt.g(this.f15101e);
            if (g2 == null) {
                u(4);
            }
            return g2;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        @k.e.a.d
        public r0 n() {
            r0 r0Var = this.f15100d;
            if (r0Var == null) {
                u(5);
            }
            return r0Var;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        public boolean q(@k.e.a.d h.p2.b0.g.t.c.f fVar) {
            if (fVar == null) {
                u(9);
            }
            return (fVar instanceof t0) && DescriptorEquivalenceForOverrides.a.f(this.f15101e, (t0) fVar, true);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        @k.e.a.d
        public List<h.p2.b0.g.t.n.z> r(@k.e.a.d List<h.p2.b0.g.t.n.z> list) {
            if (list == null) {
                u(7);
            }
            List<h.p2.b0.g.t.n.z> C0 = this.f15101e.C0(list);
            if (C0 == null) {
                u(8);
            }
            return C0;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        public void t(@k.e.a.d h.p2.b0.g.t.n.z zVar) {
            if (zVar == null) {
                u(6);
            }
            this.f15101e.G0(zVar);
        }

        public String toString() {
            return this.f15101e.getName().toString();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@k.e.a.d h.p2.b0.g.t.m.m mVar, @k.e.a.d h.p2.b0.g.t.c.k kVar, @k.e.a.d h.p2.b0.g.t.c.b1.e eVar, @k.e.a.d h.p2.b0.g.t.g.f fVar, @k.e.a.d Variance variance, boolean z, int i2, @k.e.a.d o0 o0Var, @k.e.a.d r0 r0Var) {
        super(kVar, eVar, fVar, o0Var);
        if (mVar == null) {
            A(0);
        }
        if (kVar == null) {
            A(1);
        }
        if (eVar == null) {
            A(2);
        }
        if (fVar == null) {
            A(3);
        }
        if (variance == null) {
            A(4);
        }
        if (o0Var == null) {
            A(5);
        }
        if (r0Var == null) {
            A(6);
        }
        this.f15093e = variance;
        this.f15094f = z;
        this.f15095g = i2;
        this.f15096h = mVar.c(new a(mVar, r0Var));
        this.f15097i = mVar.c(new b(fVar));
        this.f15098j = mVar;
    }

    private static /* synthetic */ void A(int i2) {
        String str;
        int i3;
        switch (i2) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 12:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                i3 = 2;
                break;
            case 12:
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
                objArr[0] = "containingDeclaration";
                break;
            case 2:
                objArr[0] = "annotations";
                break;
            case 3:
                objArr[0] = "name";
                break;
            case 4:
                objArr[0] = "variance";
                break;
            case 5:
                objArr[0] = MessageKey.MSG_SOURCE;
                break;
            case 6:
                objArr[0] = "supertypeLoopChecker";
                break;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor";
                break;
            case 12:
                objArr[0] = "bounds";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        switch (i2) {
            case 7:
                objArr[1] = "getVariance";
                break;
            case 8:
                objArr[1] = "getUpperBounds";
                break;
            case 9:
                objArr[1] = "getTypeConstructor";
                break;
            case 10:
                objArr[1] = "getDefaultType";
                break;
            case 11:
                objArr[1] = "getOriginal";
                break;
            case 12:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor";
                break;
            case 13:
                objArr[1] = "processBoundsWithoutCycles";
                break;
            case 14:
                objArr[1] = "getStorageManager";
                break;
        }
        switch (i2) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                break;
            case 12:
                objArr[2] = "processBoundsWithoutCycles";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                throw new IllegalStateException(format);
            case 12:
            default:
                throw new IllegalArgumentException(format);
        }
    }

    @Override // h.p2.b0.g.t.c.k
    public <R, D> R B(h.p2.b0.g.t.c.m<R, D> mVar, D d2) {
        return mVar.m(this, d2);
    }

    @k.e.a.d
    public List<h.p2.b0.g.t.n.z> C0(@k.e.a.d List<h.p2.b0.g.t.n.z> list) {
        if (list == null) {
            A(12);
        }
        if (list == null) {
            A(13);
        }
        return list;
    }

    public abstract void G0(@k.e.a.d h.p2.b0.g.t.n.z zVar);

    @k.e.a.d
    public abstract List<h.p2.b0.g.t.n.z> H0();

    @Override // h.p2.b0.g.t.c.t0
    @k.e.a.d
    public h.p2.b0.g.t.m.m N() {
        h.p2.b0.g.t.m.m mVar = this.f15098j;
        if (mVar == null) {
            A(14);
        }
        return mVar;
    }

    @Override // h.p2.b0.g.t.c.t0
    public boolean S() {
        return false;
    }

    @Override // h.p2.b0.g.t.c.t0
    public int f() {
        return this.f15095g;
    }

    @Override // h.p2.b0.g.t.c.t0
    @k.e.a.d
    public List<h.p2.b0.g.t.n.z> getUpperBounds() {
        List<h.p2.b0.g.t.n.z> j2 = ((c) j()).j();
        if (j2 == null) {
            A(8);
        }
        return j2;
    }

    @Override // h.p2.b0.g.t.c.t0, h.p2.b0.g.t.c.f
    @k.e.a.d
    public final q0 j() {
        q0 invoke = this.f15096h.invoke();
        if (invoke == null) {
            A(9);
        }
        return invoke;
    }

    @Override // h.p2.b0.g.t.c.t0
    public boolean l() {
        return this.f15094f;
    }

    @Override // h.p2.b0.g.t.c.t0
    @k.e.a.d
    public Variance o() {
        Variance variance = this.f15093e;
        if (variance == null) {
            A(7);
        }
        return variance;
    }

    @Override // h.p2.b0.g.t.c.f
    @k.e.a.d
    public h.p2.b0.g.t.n.f0 r() {
        h.p2.b0.g.t.n.f0 invoke = this.f15097i.invoke();
        if (invoke == null) {
            A(10);
        }
        return invoke;
    }

    @Override // h.p2.b0.g.t.c.d1.j
    @k.e.a.d
    /* renamed from: a */
    public t0 h0() {
        t0 t0Var = (t0) super.a();
        if (t0Var == null) {
            A(11);
        }
        return t0Var;
    }
}
