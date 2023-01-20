package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import h.a2.u;
import h.k2.u.l;
import h.k2.v.f0;
import h.p2.b0.g.t.c.b1.e;
import h.p2.b0.g.t.c.t0;
import h.p2.b0.g.t.c.v0;
import h.p2.b0.g.t.e.a.k;
import h.p2.b0.g.t.e.a.q;
import h.p2.b0.g.t.e.a.u.f;
import h.p2.b0.g.t.e.a.y.g;
import h.p2.b0.g.t.e.a.y.j;
import h.p2.b0.g.t.e.a.y.n;
import h.p2.b0.g.t.g.c;
import h.p2.b0.g.t.k.n.i;
import h.p2.b0.g.t.n.a0;
import h.p2.b0.g.t.n.s0;
import h.p2.b0.g.t.n.w;
import h.p2.b0.g.t.n.y0;
import h.p2.b0.g.t.n.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import k.e.a.d;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.JavaTypeEnhancementState;
import kotlin.reflect.jvm.internal.impl.utils.ReportLevel;

/* loaded from: classes3.dex */
public final class SignatureEnhancement {
    @d
    private final AnnotationTypeQualifierResolver a;
    @d
    private final JavaTypeEnhancementState b;
    @d

    /* renamed from: c  reason: collision with root package name */
    private final h.p2.b0.g.t.e.a.y.d f16557c;

    /* loaded from: classes3.dex */
    public static class a {
        @d
        private final z a;
        private final boolean b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f16564c;

        public a(@d z zVar, boolean z, boolean z2) {
            this.a = zVar;
            this.b = z;
            this.f16564c = z2;
        }

        public final boolean a() {
            return this.f16564c;
        }

        public final boolean b() {
            return this.b;
        }

        @d
        public final z getType() {
            return this.a;
        }
    }

    public SignatureEnhancement(@d AnnotationTypeQualifierResolver annotationTypeQualifierResolver, @d JavaTypeEnhancementState javaTypeEnhancementState, @d h.p2.b0.g.t.e.a.y.d dVar) {
        this.a = annotationTypeQualifierResolver;
        this.b = javaTypeEnhancementState;
        this.f16557c = dVar;
    }

    private final g c(c cVar, h.p2.b0.g.t.c.b1.c cVar2, boolean z) {
        if (q.l().contains(cVar)) {
            return new g(NullabilityQualifier.NULLABLE, z);
        }
        if (q.k().contains(cVar)) {
            return new g(NullabilityQualifier.NOT_NULL, z);
        }
        if (f0.g(cVar, q.f())) {
            return j(cVar2, z);
        }
        if (f0.g(cVar, q.d()) && this.b.c()) {
            return new g(NullabilityQualifier.NULLABLE, z);
        }
        if (f0.g(cVar, q.c()) && this.b.c()) {
            return new g(NullabilityQualifier.NOT_NULL, z);
        }
        if (f0.g(cVar, q.a())) {
            return new g(NullabilityQualifier.NOT_NULL, true);
        }
        if (f0.g(cVar, q.b())) {
            return new g(NullabilityQualifier.NULLABLE, true);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01ed A[LOOP:2: B:121:0x01e7->B:123:0x01ed, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0193  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final <D extends kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor> D d(D r19, h.p2.b0.g.t.e.a.v.e r20) {
        /*
            Method dump skipped, instructions count: 521
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement.d(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, h.p2.b0.g.t.e.a.v.e):kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor");
    }

    private final g i(h.p2.b0.g.t.c.b1.c cVar, boolean z, boolean z2) {
        c e2 = cVar.e();
        if (e2 == null) {
            return null;
        }
        boolean z3 = (cVar instanceof LazyJavaAnnotationDescriptor) && (((LazyJavaAnnotationDescriptor) cVar).j() || z2) && !z;
        g l2 = l(e2);
        if (l2 == null && (l2 = c(e2, cVar, z3)) == null) {
            return null;
        }
        return (!l2.d() && (cVar instanceof f) && ((f) cVar).d()) ? g.b(l2, null, true, 1, null) : l2;
    }

    private final g j(h.p2.b0.g.t.c.b1.c cVar, boolean z) {
        h.p2.b0.g.t.k.n.g<?> b = DescriptorUtilsKt.b(cVar);
        i iVar = b instanceof i ? (i) b : null;
        if (iVar == null) {
            return new g(NullabilityQualifier.NOT_NULL, z);
        }
        String b2 = iVar.b().b();
        switch (b2.hashCode()) {
            case 73135176:
                if (!b2.equals("MAYBE")) {
                    return null;
                }
                break;
            case 74175084:
                if (!b2.equals("NEVER")) {
                    return null;
                }
                break;
            case 433141802:
                if (b2.equals(GrsBaseInfo.CountryCodeSource.UNKNOWN)) {
                    return new g(NullabilityQualifier.FORCE_FLEXIBILITY, z);
                }
                return null;
            case 1933739535:
                if (b2.equals("ALWAYS")) {
                    return new g(NullabilityQualifier.NOT_NULL, z);
                }
                return null;
            default:
                return null;
        }
        return new g(NullabilityQualifier.NULLABLE, z);
    }

    private final <D extends CallableMemberDescriptor> e k(D d2, h.p2.b0.g.t.e.a.v.e eVar) {
        h.p2.b0.g.t.c.f a2 = h.p2.b0.g.t.c.q.a(d2);
        if (a2 == null) {
            return d2.getAnnotations();
        }
        LazyJavaClassDescriptor lazyJavaClassDescriptor = a2 instanceof LazyJavaClassDescriptor ? (LazyJavaClassDescriptor) a2 : null;
        List<h.p2.b0.g.t.e.a.x.a> M0 = lazyJavaClassDescriptor != null ? lazyJavaClassDescriptor.M0() : null;
        if (M0 == null || M0.isEmpty()) {
            return d2.getAnnotations();
        }
        ArrayList arrayList = new ArrayList(u.Y(M0, 10));
        for (h.p2.b0.g.t.e.a.x.a aVar : M0) {
            arrayList.add(new LazyJavaAnnotationDescriptor(eVar, aVar, true));
        }
        return e.w0.a(CollectionsKt___CollectionsKt.m4(d2.getAnnotations(), arrayList));
    }

    private final g l(c cVar) {
        if (this.b.e() == ReportLevel.IGNORE) {
            return null;
        }
        boolean z = this.b.e() == ReportLevel.WARN;
        if (f0.g(cVar, q.h())) {
            return new g(NullabilityQualifier.NULLABLE, z);
        }
        if (f0.g(cVar, q.i())) {
            return new g(NullabilityQualifier.FORCE_FLEXIBILITY, z);
        }
        return null;
    }

    private final SignatureParts m(CallableMemberDescriptor callableMemberDescriptor, h.p2.b0.g.t.c.b1.a aVar, boolean z, h.p2.b0.g.t.e.a.v.e eVar, AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType, l<? super CallableMemberDescriptor, ? extends z> lVar) {
        z invoke = lVar.invoke(callableMemberDescriptor);
        Collection<? extends CallableMemberDescriptor> d2 = callableMemberDescriptor.d();
        ArrayList arrayList = new ArrayList(u.Y(d2, 10));
        for (CallableMemberDescriptor callableMemberDescriptor2 : d2) {
            arrayList.add(lVar.invoke(callableMemberDescriptor2));
        }
        return new SignatureParts(aVar, invoke, arrayList, z, ContextKt.h(eVar, lVar.invoke(callableMemberDescriptor).getAnnotations()), annotationQualifierApplicabilityType, false, 64, null);
    }

    private final SignatureParts n(CallableMemberDescriptor callableMemberDescriptor, v0 v0Var, h.p2.b0.g.t.e.a.v.e eVar, l<? super CallableMemberDescriptor, ? extends z> lVar) {
        h.p2.b0.g.t.e.a.v.e h2;
        return m(callableMemberDescriptor, v0Var, false, (v0Var == null || (h2 = ContextKt.h(eVar, v0Var.getAnnotations())) == null) ? eVar : h2, AnnotationQualifierApplicabilityType.VALUE_PARAMETER, lVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @d
    public final <D extends CallableMemberDescriptor> Collection<D> e(@d h.p2.b0.g.t.e.a.v.e eVar, @d Collection<? extends D> collection) {
        ArrayList arrayList = new ArrayList(u.Y(collection, 10));
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(d((CallableMemberDescriptor) it.next(), eVar));
        }
        return arrayList;
    }

    @d
    public final z f(@d z zVar, @d h.p2.b0.g.t.e.a.v.e eVar) {
        return SignatureParts.f(new SignatureParts(null, zVar, CollectionsKt__CollectionsKt.E(), false, eVar, AnnotationQualifierApplicabilityType.TYPE_USE, false, 64, null), null, 1, null).getType();
    }

    @d
    public final List<z> g(@d t0 t0Var, @d List<? extends z> list, @d h.p2.b0.g.t.e.a.v.e eVar) {
        ArrayList arrayList = new ArrayList(u.Y(list, 10));
        for (z zVar : list) {
            if (!TypeUtilsKt.b(zVar, SignatureEnhancement$enhanceTypeParameterBounds$1$1.INSTANCE)) {
                zVar = SignatureParts.f(new SignatureParts(t0Var, zVar, CollectionsKt__CollectionsKt.E(), false, eVar, AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS, true), null, 1, null).getType();
            }
            arrayList.add(zVar);
        }
        return arrayList;
    }

    @k.e.a.e
    public final g h(@d h.p2.b0.g.t.c.b1.c cVar, boolean z, boolean z2) {
        g i2;
        g i3 = i(cVar, z, z2);
        if (i3 == null) {
            h.p2.b0.g.t.c.b1.c m2 = this.a.m(cVar);
            if (m2 == null) {
                return null;
            }
            ReportLevel j2 = this.a.j(cVar);
            if (j2.isIgnore() || (i2 = i(m2, z, z2)) == null) {
                return null;
            }
            return g.b(i2, null, j2.isWarning(), 1, null);
        }
        return i3;
    }

    /* loaded from: classes3.dex */
    public final class SignatureParts {
        @k.e.a.e
        private final h.p2.b0.g.t.c.b1.a a;
        @d
        private final z b;
        @d

        /* renamed from: c  reason: collision with root package name */
        private final Collection<z> f16558c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f16559d;
        @d

        /* renamed from: e  reason: collision with root package name */
        private final h.p2.b0.g.t.e.a.v.e f16560e;
        @d

        /* renamed from: f  reason: collision with root package name */
        private final AnnotationQualifierApplicabilityType f16561f;

        /* renamed from: g  reason: collision with root package name */
        private final boolean f16562g;

        /* JADX WARN: Multi-variable type inference failed */
        public SignatureParts(@k.e.a.e h.p2.b0.g.t.c.b1.a aVar, @d z zVar, @d Collection<? extends z> collection, boolean z, @d h.p2.b0.g.t.e.a.v.e eVar, @d AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType, boolean z2) {
            this.a = aVar;
            this.b = zVar;
            this.f16558c = collection;
            this.f16559d = z;
            this.f16560e = eVar;
            this.f16561f = annotationQualifierApplicabilityType;
            this.f16562g = z2;
        }

        private final g a(t0 t0Var) {
            boolean z;
            boolean b;
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5;
            if (t0Var instanceof h.p2.b0.g.t.e.a.v.i.d) {
                h.p2.b0.g.t.e.a.v.i.d dVar = (h.p2.b0.g.t.e.a.v.i.d) t0Var;
                List<z> upperBounds = dVar.getUpperBounds();
                boolean z6 = false;
                boolean z7 = true;
                if (!(upperBounds instanceof Collection) || !upperBounds.isEmpty()) {
                    for (z zVar : upperBounds) {
                        if (!a0.a(zVar)) {
                            z = false;
                            break;
                        }
                    }
                }
                z = true;
                if (!z) {
                    List<z> upperBounds2 = dVar.getUpperBounds();
                    if (!(upperBounds2 instanceof Collection) || !upperBounds2.isEmpty()) {
                        for (z zVar2 : upperBounds2) {
                            b = j.b(zVar2);
                            if (!b) {
                                z2 = false;
                                break;
                            }
                        }
                    }
                    z2 = true;
                    if (z2) {
                        List<z> upperBounds3 = dVar.getUpperBounds();
                        if (!(upperBounds3 instanceof Collection) || !upperBounds3.isEmpty()) {
                            for (z zVar3 : upperBounds3) {
                                if (!(zVar3 instanceof w) || a0.b(((w) zVar3).f0())) {
                                    z3 = false;
                                    continue;
                                } else {
                                    z3 = true;
                                    continue;
                                }
                                if (z3) {
                                    z4 = true;
                                    break;
                                }
                            }
                        }
                        z4 = false;
                        if (z4) {
                            return new g(NullabilityQualifier.NOT_NULL, true);
                        }
                        List<z> upperBounds4 = dVar.getUpperBounds();
                        if (!(upperBounds4 instanceof Collection) || !upperBounds4.isEmpty()) {
                            Iterator<T> it = upperBounds4.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                z zVar4 = (z) it.next();
                                if ((zVar4 instanceof w) && a0.b(((w) zVar4).f0())) {
                                    z5 = true;
                                    continue;
                                } else {
                                    z5 = false;
                                    continue;
                                }
                                if (z5) {
                                    z6 = true;
                                    break;
                                }
                            }
                        }
                        if (z6) {
                            return new g(NullabilityQualifier.NULLABLE, true);
                        }
                        return null;
                    }
                    List<z> upperBounds5 = dVar.getUpperBounds();
                    if (!(upperBounds5 instanceof Collection) || !upperBounds5.isEmpty()) {
                        for (z zVar5 : upperBounds5) {
                            if (!a0.b(zVar5)) {
                                break;
                            }
                        }
                    }
                    z7 = false;
                    return new g(z7 ? NullabilityQualifier.NOT_NULL : NullabilityQualifier.NULLABLE, false, 2, null);
                }
            }
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0063  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0065  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x006f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final h.k2.u.l<java.lang.Integer, h.p2.b0.g.t.e.a.y.e> b() {
            /*
                r17 = this;
                r7 = r17
                java.util.Collection<h.p2.b0.g.t.n.z> r0 = r7.f16558c
                java.util.ArrayList r8 = new java.util.ArrayList
                r1 = 10
                int r1 = h.a2.u.Y(r0, r1)
                r8.<init>(r1)
                java.util.Iterator r0 = r0.iterator()
            L13:
                boolean r1 = r0.hasNext()
                if (r1 == 0) goto L27
                java.lang.Object r1 = r0.next()
                h.p2.b0.g.t.n.z r1 = (h.p2.b0.g.t.n.z) r1
                java.util.List r1 = r7.o(r1)
                r8.add(r1)
                goto L13
            L27:
                h.p2.b0.g.t.n.z r0 = r7.b
                java.util.List r9 = r7.o(r0)
                boolean r0 = r7.f16559d
                r11 = 1
                if (r0 == 0) goto L60
                java.util.Collection<h.p2.b0.g.t.n.z> r0 = r7.f16558c
                boolean r1 = r0 instanceof java.util.Collection
                if (r1 == 0) goto L40
                boolean r1 = r0.isEmpty()
                if (r1 == 0) goto L40
            L3e:
                r0 = 0
                goto L5c
            L40:
                java.util.Iterator r0 = r0.iterator()
            L44:
                boolean r1 = r0.hasNext()
                if (r1 == 0) goto L3e
                java.lang.Object r1 = r0.next()
                h.p2.b0.g.t.n.z r1 = (h.p2.b0.g.t.n.z) r1
                h.p2.b0.g.t.n.e1.f r2 = h.p2.b0.g.t.n.e1.f.a
                h.p2.b0.g.t.n.z r3 = r7.b
                boolean r1 = r2.b(r1, r3)
                r1 = r1 ^ r11
                if (r1 == 0) goto L44
                r0 = 1
            L5c:
                if (r0 == 0) goto L60
                r12 = 1
                goto L61
            L60:
                r12 = 0
            L61:
                if (r12 == 0) goto L65
                r13 = 1
                goto L6a
            L65:
                int r0 = r9.size()
                r13 = r0
            L6a:
                h.p2.b0.g.t.e.a.y.e[] r14 = new h.p2.b0.g.t.e.a.y.e[r13]
                r15 = 0
            L6d:
                if (r15 >= r13) goto Lc0
                if (r15 != 0) goto L73
                r4 = 1
                goto L74
            L73:
                r4 = 0
            L74:
                java.lang.Object r0 = r9.get(r15)
                h.p2.b0.g.t.e.a.y.k r0 = (h.p2.b0.g.t.e.a.y.k) r0
                h.p2.b0.g.t.n.z r1 = r0.a()
                h.p2.b0.g.t.e.a.k r3 = r0.b()
                h.p2.b0.g.t.c.t0 r5 = r0.c()
                boolean r6 = r0.d()
                java.util.ArrayList r2 = new java.util.ArrayList
                r2.<init>()
                java.util.Iterator r0 = r8.iterator()
            L93:
                boolean r16 = r0.hasNext()
                if (r16 == 0) goto Lb5
                java.lang.Object r16 = r0.next()
                r10 = r16
                java.util.List r10 = (java.util.List) r10
                java.lang.Object r10 = kotlin.collections.CollectionsKt___CollectionsKt.J2(r10, r15)
                h.p2.b0.g.t.e.a.y.k r10 = (h.p2.b0.g.t.e.a.y.k) r10
                if (r10 != 0) goto Lab
                r10 = 0
                goto Laf
            Lab:
                h.p2.b0.g.t.n.z r10 = r10.getType()
            Laf:
                if (r10 == 0) goto L93
                r2.add(r10)
                goto L93
            Lb5:
                r0 = r17
                h.p2.b0.g.t.e.a.y.e r0 = r0.d(r1, r2, r3, r4, r5, r6)
                r14[r15] = r0
                int r15 = r15 + 1
                goto L6d
            Lc0:
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$SignatureParts$computeIndexedQualifiersForOverride$1 r0 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$SignatureParts$computeIndexedQualifiersForOverride$1
                r0.<init>(r14)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement.SignatureParts.b():h.k2.u.l");
        }

        private final g c(g gVar, k kVar, t0 t0Var) {
            g e2;
            if (gVar == null) {
                gVar = (kVar == null || (e2 = kVar.e()) == null) ? null : new g(e2.c(), e2.d());
            }
            g a = t0Var != null ? a(t0Var) : null;
            return a == null ? gVar : gVar == null ? a : m(a, gVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:76:0x012e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final h.p2.b0.g.t.e.a.y.e d(h.p2.b0.g.t.n.z r10, java.util.Collection<? extends h.p2.b0.g.t.n.z> r11, h.p2.b0.g.t.e.a.k r12, boolean r13, h.p2.b0.g.t.c.t0 r14, boolean r15) {
            /*
                Method dump skipped, instructions count: 308
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement.SignatureParts.d(h.p2.b0.g.t.n.z, java.util.Collection, h.p2.b0.g.t.e.a.k, boolean, h.p2.b0.g.t.c.t0, boolean):h.p2.b0.g.t.e.a.y.e");
        }

        public static /* synthetic */ a f(SignatureParts signatureParts, n nVar, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                nVar = null;
            }
            return signatureParts.e(nVar);
        }

        private final g g(e eVar, boolean z, boolean z2) {
            SignatureEnhancement signatureEnhancement = SignatureEnhancement.this;
            Iterator<h.p2.b0.g.t.c.b1.c> it = eVar.iterator();
            while (it.hasNext()) {
                g h2 = signatureEnhancement.h(it.next(), z, z2);
                if (h2 != null) {
                    return h2;
                }
            }
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0048  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x004b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final h.p2.b0.g.t.e.a.y.e h(h.p2.b0.g.t.n.z r12) {
            /*
                r11 = this;
                boolean r0 = h.p2.b0.g.t.n.x.b(r12)
                if (r0 == 0) goto L18
                h.p2.b0.g.t.n.u r0 = h.p2.b0.g.t.n.x.a(r12)
                kotlin.Pair r1 = new kotlin.Pair
                h.p2.b0.g.t.n.f0 r2 = r0.Q0()
                h.p2.b0.g.t.n.f0 r0 = r0.R0()
                r1.<init>(r2, r0)
                goto L1d
            L18:
                kotlin.Pair r1 = new kotlin.Pair
                r1.<init>(r12, r12)
            L1d:
                java.lang.Object r0 = r1.component1()
                h.p2.b0.g.t.n.z r0 = (h.p2.b0.g.t.n.z) r0
                java.lang.Object r1 = r1.component2()
                h.p2.b0.g.t.n.z r1 = (h.p2.b0.g.t.n.z) r1
                h.p2.b0.g.t.b.k.d r2 = h.p2.b0.g.t.b.k.d.a
                h.p2.b0.g.t.e.a.y.e r10 = new h.p2.b0.g.t.e.a.y.e
                boolean r3 = r0.J0()
                r4 = 0
                if (r3 == 0) goto L38
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r3 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NULLABLE
            L36:
                r5 = r3
                goto L42
            L38:
                boolean r3 = r1.J0()
                if (r3 != 0) goto L41
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r3 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NOT_NULL
                goto L36
            L41:
                r5 = r4
            L42:
                boolean r0 = r2.f(r0)
                if (r0 == 0) goto L4b
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier r0 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier.READ_ONLY
                goto L55
            L4b:
                boolean r0 = r2.d(r1)
                if (r0 == 0) goto L54
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier r0 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier.MUTABLE
                goto L55
            L54:
                r0 = r4
            L55:
                h.p2.b0.g.t.n.c1 r12 = r12.L0()
                boolean r6 = r12 instanceof h.p2.b0.g.t.e.a.y.f
                r7 = 0
                r8 = 8
                r9 = 0
                r3 = r10
                r4 = r5
                r5 = r0
                r3.<init>(r4, r5, r6, r7, r8, r9)
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement.SignatureParts.h(h.p2.b0.g.t.n.z):h.p2.b0.g.t.e.a.y.e");
        }

        /* JADX WARN: Code restructure failed: missing block: B:41:0x00a6, code lost:
            if ((r13.c() || !kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.n(r11)) != false) goto L33;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x00d8, code lost:
            if (r1.c() == kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NOT_NULL) goto L56;
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x00db, code lost:
            r12 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x00ef, code lost:
            if (h.k2.v.f0.g(r13 == null ? null : java.lang.Boolean.valueOf(r13.d()), r0) != false) goto L56;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final h.p2.b0.g.t.e.a.y.e i(h.p2.b0.g.t.n.z r11, boolean r12, h.p2.b0.g.t.e.a.k r13, h.p2.b0.g.t.c.t0 r14, boolean r15) {
            /*
                Method dump skipped, instructions count: 307
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement.SignatureParts.i(h.p2.b0.g.t.n.z, boolean, h.p2.b0.g.t.e.a.k, h.p2.b0.g.t.c.t0, boolean):h.p2.b0.g.t.e.a.y.e");
        }

        private static final <T> T j(List<c> list, e eVar, T t) {
            boolean z;
            boolean z2 = true;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                for (c cVar : list) {
                    if (eVar.c(cVar) != null) {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                    if (z) {
                        break;
                    }
                }
            }
            z2 = false;
            if (z2) {
                return t;
            }
            return null;
        }

        private static final <T> T k(T t, T t2) {
            if (t == null || t2 == null || f0.g(t, t2)) {
                return t == null ? t2 : t;
            }
            return null;
        }

        private final boolean l() {
            h.p2.b0.g.t.c.b1.a aVar = this.a;
            if (!(aVar instanceof v0)) {
                aVar = null;
            }
            v0 v0Var = (v0) aVar;
            return (v0Var != null ? v0Var.t0() : null) != null;
        }

        private final g m(g gVar, g gVar2) {
            NullabilityQualifier c2 = gVar.c();
            NullabilityQualifier nullabilityQualifier = NullabilityQualifier.FORCE_FLEXIBILITY;
            if (c2 == nullabilityQualifier) {
                return gVar2;
            }
            if (gVar2.c() == nullabilityQualifier) {
                return gVar;
            }
            NullabilityQualifier c3 = gVar.c();
            NullabilityQualifier nullabilityQualifier2 = NullabilityQualifier.NULLABLE;
            if (c3 == nullabilityQualifier2) {
                return gVar2;
            }
            if (gVar2.c() == nullabilityQualifier2) {
                return gVar;
            }
            if (gVar.c() == gVar2.c()) {
                gVar.c();
                NullabilityQualifier nullabilityQualifier3 = NullabilityQualifier.NOT_NULL;
            }
            return new g(NullabilityQualifier.NOT_NULL, false, 2, null);
        }

        private final Pair<g, Boolean> n(z zVar) {
            h.p2.b0.g.t.c.f c2 = zVar.I0().c();
            t0 t0Var = c2 instanceof t0 ? (t0) c2 : null;
            g a = t0Var == null ? null : a(t0Var);
            if (a == null) {
                return new Pair<>(null, Boolean.FALSE);
            }
            NullabilityQualifier nullabilityQualifier = NullabilityQualifier.NOT_NULL;
            return new Pair<>(new g(nullabilityQualifier, a.d()), Boolean.valueOf(a.c() == nullabilityQualifier));
        }

        private final List<h.p2.b0.g.t.e.a.y.k> o(z zVar) {
            ArrayList arrayList = new ArrayList(1);
            p(this, arrayList, zVar, this.f16560e, null);
            return arrayList;
        }

        private static final void p(SignatureParts signatureParts, ArrayList<h.p2.b0.g.t.e.a.y.k> arrayList, z zVar, h.p2.b0.g.t.e.a.v.e eVar, t0 t0Var) {
            AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType;
            k a;
            h.p2.b0.g.t.e.a.v.e h2 = ContextKt.h(eVar, zVar.getAnnotations());
            h.p2.b0.g.t.e.a.n b = h2.b();
            if (b == null) {
                a = null;
            } else {
                if (signatureParts.f16562g) {
                    annotationQualifierApplicabilityType = AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS;
                } else {
                    annotationQualifierApplicabilityType = AnnotationQualifierApplicabilityType.TYPE_USE;
                }
                a = b.a(annotationQualifierApplicabilityType);
            }
            arrayList.add(new h.p2.b0.g.t.e.a.y.k(zVar, a, t0Var, false));
            for (Pair pair : CollectionsKt___CollectionsKt.V5(zVar.H0(), zVar.I0().getParameters())) {
                s0 s0Var = (s0) pair.component1();
                t0 t0Var2 = (t0) pair.component2();
                if (s0Var.b()) {
                    arrayList.add(new h.p2.b0.g.t.e.a.y.k(s0Var.getType(), a, t0Var2, true));
                } else {
                    p(signatureParts, arrayList, s0Var.getType(), h2, t0Var2);
                }
            }
        }

        @d
        public final a e(@k.e.a.e n nVar) {
            l<Integer, h.p2.b0.g.t.e.a.y.e> b = b();
            SignatureEnhancement$SignatureParts$enhance$qualifiersWithPredefined$1$1 signatureEnhancement$SignatureParts$enhance$qualifiersWithPredefined$1$1 = nVar == null ? null : new SignatureEnhancement$SignatureParts$enhance$qualifiersWithPredefined$1$1(nVar, b);
            boolean c2 = y0.c(this.b, SignatureEnhancement$SignatureParts$enhance$containsFunctionN$1.INSTANCE);
            h.p2.b0.g.t.e.a.y.d dVar = SignatureEnhancement.this.f16557c;
            z zVar = this.b;
            if (signatureEnhancement$SignatureParts$enhance$qualifiersWithPredefined$1$1 != null) {
                b = signatureEnhancement$SignatureParts$enhance$qualifiersWithPredefined$1$1;
            }
            z b2 = dVar.b(zVar, b);
            a aVar = b2 != null ? new a(b2, true, c2) : null;
            return aVar == null ? new a(this.b, false, c2) : aVar;
        }

        public /* synthetic */ SignatureParts(h.p2.b0.g.t.c.b1.a aVar, z zVar, Collection collection, boolean z, h.p2.b0.g.t.e.a.v.e eVar, AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType, boolean z2, int i2, h.k2.v.u uVar) {
            this(aVar, zVar, collection, z, eVar, annotationQualifierApplicabilityType, (i2 & 64) != 0 ? false : z2);
        }
    }
}
