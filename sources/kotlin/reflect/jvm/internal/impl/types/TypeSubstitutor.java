package kotlin.reflect.jvm.internal.impl.types;

import h.k2.u.l;
import h.p2.b0.g.t.b.f;
import h.p2.b0.g.t.b.g;
import h.p2.b0.g.t.c.b1.e;
import h.p2.b0.g.t.c.b1.h;
import h.p2.b0.g.t.c.t0;
import h.p2.b0.g.t.g.c;
import h.p2.b0.g.t.n.a0;
import h.p2.b0.g.t.n.a1;
import h.p2.b0.g.t.n.c1;
import h.p2.b0.g.t.n.e0;
import h.p2.b0.g.t.n.f0;
import h.p2.b0.g.t.n.i;
import h.p2.b0.g.t.n.i0;
import h.p2.b0.g.t.n.o;
import h.p2.b0.g.t.n.p0;
import h.p2.b0.g.t.n.q;
import h.p2.b0.g.t.n.q0;
import h.p2.b0.g.t.n.r0;
import h.p2.b0.g.t.n.s;
import h.p2.b0.g.t.n.s0;
import h.p2.b0.g.t.n.u;
import h.p2.b0.g.t.n.u0;
import h.p2.b0.g.t.n.v0;
import h.p2.b0.g.t.n.w0;
import h.p2.b0.g.t.n.x;
import h.p2.b0.g.t.n.y;
import h.p2.b0.g.t.n.y0;
import h.p2.b0.g.t.n.z;
import h.p2.b0.g.t.n.z0;
import java.util.ArrayList;
import java.util.List;
import k.e.a.d;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.typesApproximation.CapturedTypeApproximationKt;

/* loaded from: classes3.dex */
public class TypeSubstitutor {
    public static final TypeSubstitutor b = g(v0.b);

    /* renamed from: c */
    public static final /* synthetic */ boolean f16873c = false;
    @d
    private final v0 a;

    /* loaded from: classes3.dex */
    public static final class SubstitutionException extends Exception {
        public SubstitutionException(String str) {
            super(str);
        }
    }

    /* loaded from: classes3.dex */
    public enum VarianceConflictType {
        NO_CONFLICT,
        IN_IN_OUT_POSITION,
        OUT_IN_IN_POSITION
    }

    /* loaded from: classes3.dex */
    public static class a implements l<c, Boolean> {
        private static /* synthetic */ void a(int i2) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor$1", "invoke"));
        }

        @Override // h.k2.u.l
        /* renamed from: b */
        public Boolean invoke(@d c cVar) {
            if (cVar == null) {
                a(0);
            }
            return Boolean.valueOf(!cVar.equals(g.a.L));
        }
    }

    /* loaded from: classes3.dex */
    public static /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[VarianceConflictType.values().length];
            a = iArr;
            try {
                iArr[VarianceConflictType.OUT_IN_IN_POSITION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[VarianceConflictType.IN_IN_OUT_POSITION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[VarianceConflictType.NO_CONFLICT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public TypeSubstitutor(@d v0 v0Var) {
        if (v0Var == null) {
            a(7);
        }
        this.a = v0Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:185:0x0021 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x003b A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x00fc A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0107  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static /* synthetic */ void a(int r13) {
        /*
            Method dump skipped, instructions count: 648
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor.a(int):void");
    }

    private static void b(int i2, s0 s0Var, v0 v0Var) {
        if (i2 <= 100) {
            return;
        }
        throw new IllegalStateException("Recursion too deep. Most likely infinite loop while substituting " + o(s0Var) + "; substitution: " + o(v0Var));
    }

    @d
    public static Variance c(@d Variance variance, @d s0 s0Var) {
        if (variance == null) {
            a(34);
        }
        if (s0Var == null) {
            a(35);
        }
        if (s0Var.b()) {
            Variance variance2 = Variance.OUT_VARIANCE;
            if (variance2 == null) {
                a(36);
            }
            return variance2;
        }
        return d(variance, s0Var.c());
    }

    @d
    public static Variance d(@d Variance variance, @d Variance variance2) {
        if (variance == null) {
            a(37);
        }
        if (variance2 == null) {
            a(38);
        }
        Variance variance3 = Variance.INVARIANT;
        if (variance == variance3) {
            if (variance2 == null) {
                a(39);
            }
            return variance2;
        } else if (variance2 == variance3) {
            if (variance == null) {
                a(40);
            }
            return variance;
        } else if (variance == variance2) {
            if (variance2 == null) {
                a(41);
            }
            return variance2;
        } else {
            throw new AssertionError("Variance conflict: type parameter variance '" + variance + "' and projection kind '" + variance2 + "' cannot be combined");
        }
    }

    private static VarianceConflictType e(Variance variance, Variance variance2) {
        Variance variance3 = Variance.IN_VARIANCE;
        if (variance == variance3 && variance2 == Variance.OUT_VARIANCE) {
            return VarianceConflictType.OUT_IN_IN_POSITION;
        }
        if (variance == Variance.OUT_VARIANCE && variance2 == variance3) {
            return VarianceConflictType.IN_IN_OUT_POSITION;
        }
        return VarianceConflictType.NO_CONFLICT;
    }

    @d
    public static TypeSubstitutor f(@d z zVar) {
        if (zVar == null) {
            a(6);
        }
        return g(r0.h(zVar.I0(), zVar.H0()));
    }

    @d
    public static TypeSubstitutor g(@d v0 v0Var) {
        if (v0Var == null) {
            a(0);
        }
        return new TypeSubstitutor(v0Var);
    }

    @d
    public static TypeSubstitutor h(@d v0 v0Var, @d v0 v0Var2) {
        if (v0Var == null) {
            a(3);
        }
        if (v0Var2 == null) {
            a(4);
        }
        return g(o.h(v0Var, v0Var2));
    }

    @d
    private static e i(@d e eVar) {
        if (eVar == null) {
            a(32);
        }
        if (eVar.n(g.a.L)) {
            return new h(eVar, new a());
        }
        if (eVar == null) {
            a(33);
        }
        return eVar;
    }

    @d
    private static s0 l(@d z zVar, @d s0 s0Var, @k.e.a.e t0 t0Var, @d s0 s0Var2) {
        if (zVar == null) {
            a(25);
        }
        if (s0Var == null) {
            a(26);
        }
        if (s0Var2 == null) {
            a(27);
        }
        if (!zVar.getAnnotations().n(g.a.L)) {
            if (s0Var == null) {
                a(28);
            }
            return s0Var;
        }
        q0 I0 = s0Var.getType().I0();
        if (!(I0 instanceof NewCapturedTypeConstructor)) {
            if (s0Var == null) {
                a(29);
            }
            return s0Var;
        }
        s0 b2 = ((NewCapturedTypeConstructor) I0).b();
        Variance c2 = b2.c();
        VarianceConflictType e2 = e(s0Var2.c(), c2);
        VarianceConflictType varianceConflictType = VarianceConflictType.OUT_IN_IN_POSITION;
        if (e2 == varianceConflictType) {
            return new u0(b2.getType());
        }
        if (t0Var == null) {
            if (s0Var == null) {
                a(30);
            }
            return s0Var;
        } else if (e(t0Var.o(), c2) == varianceConflictType) {
            return new u0(b2.getType());
        } else {
            if (s0Var == null) {
                a(31);
            }
            return s0Var;
        }
    }

    private static String o(Object obj) {
        try {
            return obj.toString();
        } catch (Throwable th) {
            if (!h.p2.b0.g.t.p.c.a(th)) {
                return "[Exception while computing toString(): " + th + "]";
            }
            throw th;
        }
    }

    private s0 r(s0 s0Var, int i2) throws SubstitutionException {
        z type = s0Var.getType();
        Variance c2 = s0Var.c();
        if (type.I0().c() instanceof t0) {
            return s0Var;
        }
        f0 b2 = i0.b(type);
        z p = b2 != null ? m().p(b2, Variance.INVARIANT) : null;
        z b3 = w0.b(type, s(type.I0().getParameters(), type.H0(), i2), this.a.d(type.getAnnotations()));
        if ((b3 instanceof f0) && (p instanceof f0)) {
            b3 = i0.j((f0) b3, (f0) p);
        }
        return new u0(c2, b3);
    }

    private List<s0> s(List<t0> list, List<s0> list2, int i2) throws SubstitutionException {
        ArrayList arrayList = new ArrayList(list.size());
        boolean z = false;
        for (int i3 = 0; i3 < list.size(); i3++) {
            t0 t0Var = list.get(i3);
            s0 s0Var = list2.get(i3);
            s0 u = u(s0Var, t0Var, i2 + 1);
            int i4 = b.a[e(t0Var.o(), u.c()).ordinal()];
            if (i4 == 1 || i4 == 2) {
                u = y0.s(t0Var);
            } else if (i4 == 3) {
                Variance o = t0Var.o();
                Variance variance = Variance.INVARIANT;
                if (o != variance && !u.b()) {
                    u = new u0(variance, u.getType());
                }
            }
            if (u != s0Var) {
                z = true;
            }
            arrayList.add(u);
        }
        return !z ? list2 : arrayList;
    }

    @d
    private s0 u(@d s0 s0Var, @k.e.a.e t0 t0Var, int i2) throws SubstitutionException {
        z q;
        if (s0Var == null) {
            a(18);
        }
        b(i2, s0Var, this.a);
        if (s0Var.b()) {
            if (s0Var == null) {
                a(19);
            }
            return s0Var;
        }
        z type = s0Var.getType();
        if (type instanceof z0) {
            z0 z0Var = (z0) type;
            c1 C0 = z0Var.C0();
            z f0 = z0Var.f0();
            s0 u = u(new u0(s0Var.c(), C0), t0Var, i2 + 1);
            z p = p(f0, s0Var.c());
            c1 L0 = u.getType().L0();
            if (p instanceof z0) {
                p = ((z0) p).f0();
            }
            return new u0(u.c(), a1.d(L0, p));
        } else if (q.a(type) || (type.L0() instanceof e0)) {
            if (s0Var == null) {
                a(20);
            }
            return s0Var;
        } else {
            s0 e2 = this.a.e(type);
            s0 l2 = e2 != null ? l(type, e2, t0Var, s0Var) : null;
            Variance c2 = s0Var.c();
            if (l2 == null && x.b(type) && !p0.b(type)) {
                u a2 = x.a(type);
                int i3 = i2 + 1;
                s0 u2 = u(new u0(c2, a2.Q0()), t0Var, i3);
                s0 u3 = u(new u0(c2, a2.R0()), t0Var, i3);
                Variance c3 = u2.c();
                if (u2.getType() == a2.Q0() && u3.getType() == a2.R0()) {
                    if (s0Var == null) {
                        a(21);
                    }
                    return s0Var;
                }
                return new u0(c3, KotlinTypeFactory.d(w0.a(u2.getType()), w0.a(u3.getType())));
            } else if (f.k0(type) || a0.a(type)) {
                if (s0Var == null) {
                    a(22);
                }
                return s0Var;
            } else if (l2 != null) {
                VarianceConflictType e3 = e(c2, l2.c());
                if (!CapturedTypeConstructorKt.d(type)) {
                    int i4 = b.a[e3.ordinal()];
                    if (i4 == 1) {
                        throw new SubstitutionException("Out-projection in in-position");
                    }
                    if (i4 == 2) {
                        return new u0(Variance.OUT_VARIANCE, type.I0().k().I());
                    }
                }
                i a3 = p0.a(type);
                if (l2.b()) {
                    if (l2 == null) {
                        a(23);
                    }
                    return l2;
                }
                if (a3 != null) {
                    q = a3.h0(l2.getType());
                } else {
                    q = y0.q(l2.getType(), type.J0());
                }
                if (!type.getAnnotations().isEmpty()) {
                    q = TypeUtilsKt.q(q, new CompositeAnnotations(q.getAnnotations(), i(this.a.d(type.getAnnotations()))));
                }
                if (e3 == VarianceConflictType.NO_CONFLICT) {
                    c2 = d(c2, l2.c());
                }
                return new u0(c2, q);
            } else {
                s0 r = r(s0Var, i2);
                if (r == null) {
                    a(24);
                }
                return r;
            }
        }
    }

    @d
    public v0 j() {
        v0 v0Var = this.a;
        if (v0Var == null) {
            a(8);
        }
        return v0Var;
    }

    public boolean k() {
        return this.a.f();
    }

    @d
    public TypeSubstitutor m() {
        v0 v0Var = this.a;
        return ((v0Var instanceof y) && v0Var.b()) ? new TypeSubstitutor(new y(((y) this.a).i(), ((y) this.a).h(), false)) : this;
    }

    @d
    public z n(@d z zVar, @d Variance variance) {
        if (zVar == null) {
            a(9);
        }
        if (variance == null) {
            a(10);
        }
        if (k()) {
            if (zVar == null) {
                a(11);
            }
            return zVar;
        }
        try {
            z type = u(new u0(variance, zVar), null, 0).getType();
            if (type == null) {
                a(12);
            }
            return type;
        } catch (SubstitutionException e2) {
            f0 j2 = s.j(e2.getMessage());
            if (j2 == null) {
                a(13);
            }
            return j2;
        }
    }

    @k.e.a.e
    public z p(@d z zVar, @d Variance variance) {
        if (zVar == null) {
            a(14);
        }
        if (variance == null) {
            a(15);
        }
        s0 q = q(new u0(variance, j().g(zVar, variance)));
        if (q == null) {
            return null;
        }
        return q.getType();
    }

    @k.e.a.e
    public s0 q(@d s0 s0Var) {
        if (s0Var == null) {
            a(16);
        }
        s0 t = t(s0Var);
        return (this.a.a() || this.a.b()) ? CapturedTypeApproximationKt.c(t, this.a.b()) : t;
    }

    @k.e.a.e
    public s0 t(@d s0 s0Var) {
        if (s0Var == null) {
            a(17);
        }
        if (k()) {
            return s0Var;
        }
        try {
            return u(s0Var, null, 0);
        } catch (SubstitutionException unused) {
            return null;
        }
    }
}
