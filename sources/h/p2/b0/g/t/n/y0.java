package h.p2.b0.g.t.n;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* loaded from: classes3.dex */
public class y0 {
    public static final f0 a = s.p("DONT_CARE");
    public static final f0 b = s.j("Cannot be inferred");
    @k.e.a.d

    /* renamed from: c */
    public static final f0 f15617c = new a("NO_EXPECTED_TYPE");

    /* renamed from: d */
    public static final f0 f15618d = new a("UNIT_EXPECTED_TYPE");

    /* renamed from: e */
    public static final /* synthetic */ boolean f15619e = false;

    /* loaded from: classes3.dex */
    public static class a extends l {
        private final String b;

        public a(String str) {
            this.b = str;
        }

        /* JADX WARN: Removed duplicated region for block: B:105:0x0036  */
        /* JADX WARN: Removed duplicated region for block: B:108:0x003e  */
        /* JADX WARN: Removed duplicated region for block: B:110:0x0044  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static /* synthetic */ void U0(int r9) {
            /*
                r0 = 4
                r1 = 1
                if (r9 == r1) goto L9
                if (r9 == r0) goto L9
                java.lang.String r2 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
                goto Lb
            L9:
                java.lang.String r2 = "@NotNull method %s.%s must not return null"
            Lb:
                r3 = 3
                r4 = 2
                if (r9 == r1) goto L13
                if (r9 == r0) goto L13
                r5 = 3
                goto L14
            L13:
                r5 = 2
            L14:
                java.lang.Object[] r5 = new java.lang.Object[r5]
                java.lang.String r6 = "kotlin/reflect/jvm/internal/impl/types/TypeUtils$SpecialType"
                r7 = 0
                if (r9 == r1) goto L30
                if (r9 == r4) goto L2b
                if (r9 == r3) goto L26
                if (r9 == r0) goto L30
                java.lang.String r8 = "newAnnotations"
                r5[r7] = r8
                goto L32
            L26:
                java.lang.String r8 = "kotlinTypeRefiner"
                r5[r7] = r8
                goto L32
            L2b:
                java.lang.String r8 = "delegate"
                r5[r7] = r8
                goto L32
            L30:
                r5[r7] = r6
            L32:
                java.lang.String r7 = "refine"
                if (r9 == r1) goto L3e
                if (r9 == r0) goto L3b
                r5[r1] = r6
                goto L42
            L3b:
                r5[r1] = r7
                goto L42
            L3e:
                java.lang.String r6 = "toString"
                r5[r1] = r6
            L42:
                if (r9 == r1) goto L56
                if (r9 == r4) goto L52
                if (r9 == r3) goto L4f
                if (r9 == r0) goto L56
                java.lang.String r3 = "replaceAnnotations"
                r5[r4] = r3
                goto L56
            L4f:
                r5[r4] = r7
                goto L56
            L52:
                java.lang.String r3 = "replaceDelegate"
                r5[r4] = r3
            L56:
                java.lang.String r2 = java.lang.String.format(r2, r5)
                if (r9 == r1) goto L64
                if (r9 == r0) goto L64
                java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
                r9.<init>(r2)
                goto L69
            L64:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                r9.<init>(r2)
            L69:
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: h.p2.b0.g.t.n.y0.a.U0(int):void");
        }

        @Override // h.p2.b0.g.t.n.c1
        @k.e.a.d
        /* renamed from: P0 */
        public f0 M0(boolean z) {
            throw new IllegalStateException(this.b);
        }

        @Override // h.p2.b0.g.t.n.c1
        @k.e.a.d
        /* renamed from: Q0 */
        public f0 O0(@k.e.a.d h.p2.b0.g.t.c.b1.e eVar) {
            if (eVar == null) {
                U0(0);
            }
            throw new IllegalStateException(this.b);
        }

        @Override // h.p2.b0.g.t.n.l
        @k.e.a.d
        public f0 R0() {
            throw new IllegalStateException(this.b);
        }

        @Override // h.p2.b0.g.t.n.l
        @k.e.a.d
        public l T0(@k.e.a.d f0 f0Var) {
            if (f0Var == null) {
                U0(2);
            }
            throw new IllegalStateException(this.b);
        }

        @Override // h.p2.b0.g.t.n.l
        @k.e.a.d
        /* renamed from: V0 */
        public a S0(@k.e.a.d h.p2.b0.g.t.n.e1.h hVar) {
            if (hVar == null) {
                U0(3);
            }
            return this;
        }

        @Override // h.p2.b0.g.t.n.f0
        @k.e.a.d
        public String toString() {
            String str = this.b;
            if (str == null) {
                U0(1);
            }
            return str;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:298:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:320:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:324:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:328:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:349:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:351:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:352:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:353:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:354:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:355:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:356:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:357:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:358:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:359:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:360:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:361:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:362:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:363:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:364:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:365:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:366:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:367:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:368:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:369:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:370:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:371:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:372:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:373:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:374:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:375:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:376:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:377:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:378:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:379:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:380:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:383:0x01c1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:395:0x01da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static /* synthetic */ void a(int r24) {
        /*
            Method dump skipped, instructions count: 776
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: h.p2.b0.g.t.n.y0.a(int):void");
    }

    public static boolean b(@k.e.a.d z zVar) {
        if (zVar == null) {
            a(28);
        }
        if (zVar.J0()) {
            return true;
        }
        return x.b(zVar) && b(x.a(zVar).R0());
    }

    public static boolean c(@k.e.a.e z zVar, @k.e.a.d h.k2.u.l<c1, Boolean> lVar) {
        if (lVar == null) {
            a(43);
        }
        return d(zVar, lVar, null);
    }

    private static boolean d(@k.e.a.e z zVar, @k.e.a.d h.k2.u.l<c1, Boolean> lVar, h.p2.b0.g.t.p.e<z> eVar) {
        if (lVar == null) {
            a(44);
        }
        if (zVar == null) {
            return false;
        }
        c1 L0 = zVar.L0();
        if (v(zVar)) {
            return lVar.invoke(L0).booleanValue();
        }
        if (eVar == null || !eVar.contains(zVar)) {
            if (lVar.invoke(L0).booleanValue()) {
                return true;
            }
            if (eVar == null) {
                eVar = h.p2.b0.g.t.p.e.a();
            }
            eVar.add(zVar);
            u uVar = L0 instanceof u ? (u) L0 : null;
            if (uVar == null || !(d(uVar.Q0(), lVar, eVar) || d(uVar.R0(), lVar, eVar))) {
                if ((L0 instanceof j) && d(((j) L0).U0(), lVar, eVar)) {
                    return true;
                }
                q0 I0 = zVar.I0();
                if (I0 instanceof IntersectionTypeConstructor) {
                    for (z zVar2 : ((IntersectionTypeConstructor) I0).j()) {
                        if (d(zVar2, lVar, eVar)) {
                            return true;
                        }
                    }
                    return false;
                }
                for (s0 s0Var : zVar.H0()) {
                    if (!s0Var.b()) {
                        if (d(s0Var.getType(), lVar, eVar)) {
                            return true;
                        }
                    }
                }
                return false;
            }
            return true;
        }
        return false;
    }

    @k.e.a.e
    public static z e(@k.e.a.d z zVar, @k.e.a.d z zVar2, @k.e.a.d TypeSubstitutor typeSubstitutor) {
        if (zVar == null) {
            a(20);
        }
        if (zVar2 == null) {
            a(21);
        }
        if (typeSubstitutor == null) {
            a(22);
        }
        z p = typeSubstitutor.p(zVar2, Variance.INVARIANT);
        if (p != null) {
            return q(p, zVar.J0());
        }
        return null;
    }

    @k.e.a.e
    public static h.p2.b0.g.t.c.d f(@k.e.a.d z zVar) {
        if (zVar == null) {
            a(30);
        }
        h.p2.b0.g.t.c.f c2 = zVar.I0().c();
        if (c2 instanceof h.p2.b0.g.t.c.d) {
            return (h.p2.b0.g.t.c.d) c2;
        }
        return null;
    }

    @k.e.a.d
    public static List<s0> g(@k.e.a.d List<h.p2.b0.g.t.c.t0> list) {
        if (list == null) {
            a(16);
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (h.p2.b0.g.t.c.t0 t0Var : list) {
            arrayList.add(new u0(t0Var.r()));
        }
        List<s0> I5 = CollectionsKt___CollectionsKt.I5(arrayList);
        if (I5 == null) {
            a(17);
        }
        return I5;
    }

    @k.e.a.d
    public static List<z> h(@k.e.a.d z zVar) {
        if (zVar == null) {
            a(18);
        }
        TypeSubstitutor f2 = TypeSubstitutor.f(zVar);
        Collection<z> j2 = zVar.I0().j();
        ArrayList arrayList = new ArrayList(j2.size());
        for (z zVar2 : j2) {
            z e2 = e(zVar, zVar2, f2);
            if (e2 != null) {
                arrayList.add(e2);
            }
        }
        return arrayList;
    }

    @k.e.a.e
    public static h.p2.b0.g.t.c.t0 i(@k.e.a.d z zVar) {
        if (zVar == null) {
            a(62);
        }
        if (zVar.I0().c() instanceof h.p2.b0.g.t.c.t0) {
            return (h.p2.b0.g.t.c.t0) zVar.I0().c();
        }
        return null;
    }

    public static boolean j(@k.e.a.d z zVar) {
        if (zVar == null) {
            a(29);
        }
        if (zVar.I0().c() instanceof h.p2.b0.g.t.c.d) {
            return false;
        }
        for (z zVar2 : h(zVar)) {
            if (l(zVar2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean k(@k.e.a.e z zVar) {
        return zVar != null && zVar.I0() == a.I0();
    }

    public static boolean l(@k.e.a.d z zVar) {
        if (zVar == null) {
            a(27);
        }
        if (zVar.J0()) {
            return true;
        }
        if (x.b(zVar) && l(x.a(zVar).R0())) {
            return true;
        }
        if (i0.c(zVar)) {
            return false;
        }
        if (m(zVar)) {
            return j(zVar);
        }
        q0 I0 = zVar.I0();
        if (I0 instanceof IntersectionTypeConstructor) {
            for (z zVar2 : I0.j()) {
                if (l(zVar2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean m(@k.e.a.d z zVar) {
        if (zVar == null) {
            a(59);
        }
        return i(zVar) != null || (zVar.I0() instanceof h.p2.b0.g.t.n.e1.n);
    }

    @k.e.a.d
    public static z n(@k.e.a.d z zVar) {
        if (zVar == null) {
            a(2);
        }
        return p(zVar, false);
    }

    @k.e.a.d
    public static z o(@k.e.a.d z zVar) {
        if (zVar == null) {
            a(1);
        }
        return p(zVar, true);
    }

    @k.e.a.d
    public static z p(@k.e.a.d z zVar, boolean z) {
        if (zVar == null) {
            a(3);
        }
        c1 M0 = zVar.L0().M0(z);
        if (M0 == null) {
            a(4);
        }
        return M0;
    }

    @k.e.a.d
    public static z q(@k.e.a.d z zVar, boolean z) {
        if (zVar == null) {
            a(8);
        }
        if (z) {
            return o(zVar);
        }
        if (zVar == null) {
            a(9);
        }
        return zVar;
    }

    @k.e.a.d
    public static f0 r(@k.e.a.d f0 f0Var, boolean z) {
        if (f0Var == null) {
            a(5);
        }
        if (!z) {
            if (f0Var == null) {
                a(7);
            }
            return f0Var;
        }
        f0 P0 = f0Var.P0(true);
        if (P0 == null) {
            a(6);
        }
        return P0;
    }

    @k.e.a.d
    public static s0 s(@k.e.a.d h.p2.b0.g.t.c.t0 t0Var) {
        if (t0Var == null) {
            a(45);
        }
        return new StarProjectionImpl(t0Var);
    }

    @k.e.a.d
    public static f0 t(h.p2.b0.g.t.c.f fVar, MemberScope memberScope, h.k2.u.l<h.p2.b0.g.t.n.e1.h, f0> lVar) {
        if (s.r(fVar)) {
            f0 j2 = s.j("Unsubstituted type for " + fVar);
            if (j2 == null) {
                a(11);
            }
            return j2;
        }
        return u(fVar.j(), memberScope, lVar);
    }

    @k.e.a.d
    public static f0 u(@k.e.a.d q0 q0Var, @k.e.a.d MemberScope memberScope, @k.e.a.d h.k2.u.l<h.p2.b0.g.t.n.e1.h, f0> lVar) {
        if (q0Var == null) {
            a(12);
        }
        if (memberScope == null) {
            a(13);
        }
        if (lVar == null) {
            a(14);
        }
        f0 k2 = KotlinTypeFactory.k(h.p2.b0.g.t.c.b1.e.w0.b(), q0Var, g(q0Var.getParameters()), false, memberScope, lVar);
        if (k2 == null) {
            a(15);
        }
        return k2;
    }

    public static boolean v(@k.e.a.d z zVar) {
        if (zVar == null) {
            a(0);
        }
        return zVar == f15617c || zVar == f15618d;
    }
}
