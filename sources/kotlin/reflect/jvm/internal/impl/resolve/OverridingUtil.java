package kotlin.reflect.jvm.internal.impl.resolve;

import com.umeng.analytics.pro.am;
import h.k2.u.l;
import h.k2.u.p;
import h.p2.b0.g.t.c.d1.y;
import h.p2.b0.g.t.c.i0;
import h.p2.b0.g.t.c.j0;
import h.p2.b0.g.t.c.k;
import h.p2.b0.g.t.c.m0;
import h.p2.b0.g.t.c.o;
import h.p2.b0.g.t.c.r;
import h.p2.b0.g.t.c.s;
import h.p2.b0.g.t.c.t0;
import h.p2.b0.g.t.c.v;
import h.p2.b0.g.t.c.v0;
import h.p2.b0.g.t.c.w;
import h.p2.b0.g.t.n.a0;
import h.p2.b0.g.t.n.e1.f;
import h.p2.b0.g.t.n.e1.g;
import h.p2.b0.g.t.n.e1.h;
import h.p2.b0.g.t.n.e1.m;
import h.p2.b0.g.t.n.q0;
import h.p2.b0.g.t.n.x;
import h.p2.b0.g.t.n.z;
import h.t1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.ServiceLoader;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* loaded from: classes3.dex */
public class OverridingUtil {

    /* renamed from: c  reason: collision with root package name */
    private static final List<ExternalOverridabilityCondition> f16770c = CollectionsKt___CollectionsKt.I5(ServiceLoader.load(ExternalOverridabilityCondition.class, ExternalOverridabilityCondition.class.getClassLoader()));

    /* renamed from: d  reason: collision with root package name */
    public static final OverridingUtil f16771d;

    /* renamed from: e  reason: collision with root package name */
    private static final f.a f16772e;

    /* renamed from: f  reason: collision with root package name */
    public static final /* synthetic */ boolean f16773f = false;
    private final h.p2.b0.g.t.n.e1.h a;
    private final f.a b;

    /* loaded from: classes3.dex */
    public static class OverrideCompatibilityInfo {

        /* renamed from: c  reason: collision with root package name */
        private static final OverrideCompatibilityInfo f16774c = new OverrideCompatibilityInfo(Result.OVERRIDABLE, "SUCCESS");
        private final Result a;
        private final String b;

        /* loaded from: classes3.dex */
        public enum Result {
            OVERRIDABLE,
            INCOMPATIBLE,
            CONFLICT
        }

        public OverrideCompatibilityInfo(@k.e.a.d Result result, @k.e.a.d String str) {
            if (result == null) {
                a(3);
            }
            if (str == null) {
                a(4);
            }
            this.a = result;
            this.b = str;
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x0038  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x003b  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0040  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0045  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0049  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x005a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static /* synthetic */ void a(int r10) {
            /*
                r0 = 4
                r1 = 3
                r2 = 2
                r3 = 1
                if (r10 == r3) goto Lf
                if (r10 == r2) goto Lf
                if (r10 == r1) goto Lf
                if (r10 == r0) goto Lf
                java.lang.String r4 = "@NotNull method %s.%s must not return null"
                goto L11
            Lf:
                java.lang.String r4 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
            L11:
                if (r10 == r3) goto L1b
                if (r10 == r2) goto L1b
                if (r10 == r1) goto L1b
                if (r10 == r0) goto L1b
                r5 = 2
                goto L1c
            L1b:
                r5 = 3
            L1c:
                java.lang.Object[] r5 = new java.lang.Object[r5]
                java.lang.String r6 = "success"
                java.lang.String r7 = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverrideCompatibilityInfo"
                r8 = 0
                if (r10 == r3) goto L31
                if (r10 == r2) goto L31
                if (r10 == r1) goto L2e
                if (r10 == r0) goto L31
                r5[r8] = r7
                goto L35
            L2e:
                r5[r8] = r6
                goto L35
            L31:
                java.lang.String r9 = "debugMessage"
                r5[r8] = r9
            L35:
                switch(r10) {
                    case 1: goto L45;
                    case 2: goto L45;
                    case 3: goto L45;
                    case 4: goto L45;
                    case 5: goto L40;
                    case 6: goto L3b;
                    default: goto L38;
                }
            L38:
                r5[r3] = r6
                goto L47
            L3b:
                java.lang.String r6 = "getDebugMessage"
                r5[r3] = r6
                goto L47
            L40:
                java.lang.String r6 = "getResult"
                r5[r3] = r6
                goto L47
            L45:
                r5[r3] = r7
            L47:
                if (r10 == r3) goto L5a
                if (r10 == r2) goto L55
                if (r10 == r1) goto L50
                if (r10 == r0) goto L50
                goto L5e
            L50:
                java.lang.String r6 = "<init>"
                r5[r2] = r6
                goto L5e
            L55:
                java.lang.String r6 = "conflict"
                r5[r2] = r6
                goto L5e
            L5a:
                java.lang.String r6 = "incompatible"
                r5[r2] = r6
            L5e:
                java.lang.String r4 = java.lang.String.format(r4, r5)
                if (r10 == r3) goto L70
                if (r10 == r2) goto L70
                if (r10 == r1) goto L70
                if (r10 == r0) goto L70
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                r10.<init>(r4)
                goto L75
            L70:
                java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
                r10.<init>(r4)
            L75:
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.a(int):void");
        }

        @k.e.a.d
        public static OverrideCompatibilityInfo b(@k.e.a.d String str) {
            if (str == null) {
                a(2);
            }
            return new OverrideCompatibilityInfo(Result.CONFLICT, str);
        }

        @k.e.a.d
        public static OverrideCompatibilityInfo d(@k.e.a.d String str) {
            if (str == null) {
                a(1);
            }
            return new OverrideCompatibilityInfo(Result.INCOMPATIBLE, str);
        }

        @k.e.a.d
        public static OverrideCompatibilityInfo e() {
            OverrideCompatibilityInfo overrideCompatibilityInfo = f16774c;
            if (overrideCompatibilityInfo == null) {
                a(0);
            }
            return overrideCompatibilityInfo;
        }

        @k.e.a.d
        public Result c() {
            Result result = this.a;
            if (result == null) {
                a(5);
            }
            return result;
        }
    }

    /* loaded from: classes3.dex */
    public static class a implements f.a {
        private static /* synthetic */ void b(int i2) {
            Object[] objArr = new Object[3];
            if (i2 != 1) {
                objArr[0] = am.av;
            } else {
                objArr[0] = "b";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$1";
            objArr[2] = "equals";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // h.p2.b0.g.t.n.e1.f.a
        public boolean a(@k.e.a.d q0 q0Var, @k.e.a.d q0 q0Var2) {
            if (q0Var == null) {
                b(0);
            }
            if (q0Var2 == null) {
                b(1);
            }
            return q0Var.equals(q0Var2);
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements p<D, D, Pair<h.p2.b0.g.t.c.a, h.p2.b0.g.t.c.a>> {
        /* JADX WARN: Incorrect types in method signature: (TD;TD;)Lkotlin/Pair<Lh/p2/b0/g/t/c/a;Lh/p2/b0/g/t/c/a;>; */
        @Override // h.k2.u.p
        /* renamed from: a */
        public Pair invoke(h.p2.b0.g.t.c.a aVar, h.p2.b0.g.t.c.a aVar2) {
            return new Pair(aVar, aVar2);
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements l<CallableMemberDescriptor, Boolean> {
        public final /* synthetic */ k a;

        public c(k kVar) {
            this.a = kVar;
        }

        @Override // h.k2.u.l
        /* renamed from: a */
        public Boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
            return Boolean.valueOf(callableMemberDescriptor.b() == this.a);
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements l<CallableMemberDescriptor, h.p2.b0.g.t.c.a> {
        @Override // h.k2.u.l
        /* renamed from: a */
        public CallableMemberDescriptor invoke(CallableMemberDescriptor callableMemberDescriptor) {
            return callableMemberDescriptor;
        }
    }

    /* loaded from: classes3.dex */
    public static class e implements l<CallableMemberDescriptor, Boolean> {
        public final /* synthetic */ h.p2.b0.g.t.c.d a;

        public e(h.p2.b0.g.t.c.d dVar) {
            this.a = dVar;
        }

        @Override // h.k2.u.l
        /* renamed from: a */
        public Boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
            return Boolean.valueOf(!r.g(callableMemberDescriptor.getVisibility()) && r.h(callableMemberDescriptor, this.a));
        }
    }

    /* loaded from: classes3.dex */
    public static class f implements l<CallableMemberDescriptor, h.p2.b0.g.t.c.a> {
        @Override // h.k2.u.l
        /* renamed from: a */
        public h.p2.b0.g.t.c.a invoke(CallableMemberDescriptor callableMemberDescriptor) {
            return callableMemberDescriptor;
        }
    }

    /* loaded from: classes3.dex */
    public static class g implements l<CallableMemberDescriptor, t1> {
        public final /* synthetic */ h.p2.b0.g.t.k.g a;
        public final /* synthetic */ CallableMemberDescriptor b;

        public g(h.p2.b0.g.t.k.g gVar, CallableMemberDescriptor callableMemberDescriptor) {
            this.a = gVar;
            this.b = callableMemberDescriptor;
        }

        @Override // h.k2.u.l
        /* renamed from: a */
        public t1 invoke(CallableMemberDescriptor callableMemberDescriptor) {
            this.a.b(this.b, callableMemberDescriptor);
            return t1.a;
        }
    }

    /* loaded from: classes3.dex */
    public static /* synthetic */ class h {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ int[] f16775c;

        static {
            int[] iArr = new int[Modality.values().length];
            f16775c = iArr;
            try {
                iArr[Modality.FINAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16775c[Modality.SEALED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f16775c[Modality.OPEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f16775c[Modality.ABSTRACT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[OverrideCompatibilityInfo.Result.values().length];
            b = iArr2;
            try {
                iArr2[OverrideCompatibilityInfo.Result.OVERRIDABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[OverrideCompatibilityInfo.Result.CONFLICT.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                b[OverrideCompatibilityInfo.Result.INCOMPATIBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[ExternalOverridabilityCondition.Result.values().length];
            a = iArr3;
            try {
                iArr3[ExternalOverridabilityCondition.Result.OVERRIDABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[ExternalOverridabilityCondition.Result.CONFLICT.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[ExternalOverridabilityCondition.Result.INCOMPATIBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[ExternalOverridabilityCondition.Result.UNKNOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    static {
        a aVar = new a();
        f16772e = aVar;
        f16771d = new OverridingUtil(aVar, h.a.a);
    }

    private OverridingUtil(@k.e.a.d f.a aVar, @k.e.a.d h.p2.b0.g.t.n.e1.h hVar) {
        if (aVar == null) {
            a(4);
        }
        if (hVar == null) {
            a(5);
        }
        this.b = aVar;
        this.a = hVar;
    }

    @k.e.a.d
    public static Set<CallableMemberDescriptor> A(@k.e.a.d CallableMemberDescriptor callableMemberDescriptor) {
        if (callableMemberDescriptor == null) {
            a(13);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        f(callableMemberDescriptor, linkedHashSet);
        return linkedHashSet;
    }

    private static boolean B(@k.e.a.e i0 i0Var, @k.e.a.e i0 i0Var2) {
        if (i0Var == null || i0Var2 == null) {
            return true;
        }
        return I(i0Var, i0Var2);
    }

    public static boolean C(@k.e.a.d h.p2.b0.g.t.c.a aVar, @k.e.a.d h.p2.b0.g.t.c.a aVar2) {
        if (aVar == null) {
            a(67);
        }
        if (aVar2 == null) {
            a(68);
        }
        z returnType = aVar.getReturnType();
        z returnType2 = aVar2.getReturnType();
        if (I(aVar, aVar2)) {
            Pair<m, h.p2.b0.g.t.n.e1.a> l2 = f16771d.l(aVar.getTypeParameters(), aVar2.getTypeParameters());
            if (aVar instanceof v) {
                return H(aVar, returnType, aVar2, returnType2, l2);
            }
            if (aVar instanceof j0) {
                j0 j0Var = (j0) aVar;
                j0 j0Var2 = (j0) aVar2;
                if (B(j0Var.getSetter(), j0Var2.getSetter())) {
                    if (j0Var.O() && j0Var2.O()) {
                        return l2.getFirst().e(l2.getSecond(), returnType.L0(), returnType2.L0());
                    }
                    return (j0Var.O() || !j0Var2.O()) && H(aVar, returnType, aVar2, returnType2, l2);
                }
                return false;
            }
            throw new IllegalArgumentException("Unexpected callable: " + aVar.getClass());
        }
        return false;
    }

    private static boolean D(@k.e.a.d h.p2.b0.g.t.c.a aVar, @k.e.a.d Collection<h.p2.b0.g.t.c.a> collection) {
        if (aVar == null) {
            a(71);
        }
        if (collection == null) {
            a(72);
        }
        for (h.p2.b0.g.t.c.a aVar2 : collection) {
            if (!C(aVar, aVar2)) {
                return false;
            }
        }
        return true;
    }

    private static boolean H(@k.e.a.d h.p2.b0.g.t.c.a aVar, @k.e.a.d z zVar, @k.e.a.d h.p2.b0.g.t.c.a aVar2, @k.e.a.d z zVar2, @k.e.a.d Pair<m, h.p2.b0.g.t.n.e1.a> pair) {
        if (aVar == null) {
            a(73);
        }
        if (zVar == null) {
            a(74);
        }
        if (aVar2 == null) {
            a(75);
        }
        if (zVar2 == null) {
            a(76);
        }
        if (pair == null) {
            a(77);
        }
        return pair.getFirst().g(pair.getSecond(), zVar.L0(), zVar2.L0());
    }

    private static boolean I(@k.e.a.d o oVar, @k.e.a.d o oVar2) {
        if (oVar == null) {
            a(69);
        }
        if (oVar2 == null) {
            a(70);
        }
        Integer d2 = r.d(oVar.getVisibility(), oVar2.getVisibility());
        return d2 == null || d2.intValue() >= 0;
    }

    public static boolean J(@k.e.a.d w wVar, @k.e.a.d w wVar2) {
        if (wVar == null) {
            a(57);
        }
        if (wVar2 == null) {
            a(58);
        }
        return !r.g(wVar2.getVisibility()) && r.h(wVar2, wVar);
    }

    public static <D extends h.p2.b0.g.t.c.a> boolean K(@k.e.a.d D d2, @k.e.a.d D d3, boolean z, boolean z2) {
        if (d2 == null) {
            a(11);
        }
        if (d3 == null) {
            a(12);
        }
        if (d2.equals(d3) || !DescriptorEquivalenceForOverrides.a.d(d2.a(), d3.a(), z, z2)) {
            h.p2.b0.g.t.c.a a2 = d3.a();
            for (h.p2.b0.g.t.c.a aVar : h.p2.b0.g.t.k.c.d(d2)) {
                if (DescriptorEquivalenceForOverrides.a.d(a2, aVar, z, z2)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public static void L(@k.e.a.d CallableMemberDescriptor callableMemberDescriptor, @k.e.a.e l<CallableMemberDescriptor, t1> lVar) {
        s sVar;
        if (callableMemberDescriptor == null) {
            a(107);
        }
        for (CallableMemberDescriptor callableMemberDescriptor2 : callableMemberDescriptor.d()) {
            if (callableMemberDescriptor2.getVisibility() == r.f15213g) {
                L(callableMemberDescriptor2, lVar);
            }
        }
        if (callableMemberDescriptor.getVisibility() != r.f15213g) {
            return;
        }
        s h2 = h(callableMemberDescriptor);
        if (h2 == null) {
            if (lVar != null) {
                lVar.invoke(callableMemberDescriptor);
            }
            sVar = r.f15211e;
        } else {
            sVar = h2;
        }
        if (callableMemberDescriptor instanceof h.p2.b0.g.t.c.d1.z) {
            ((h.p2.b0.g.t.c.d1.z) callableMemberDescriptor).X0(sVar);
            for (i0 i0Var : ((j0) callableMemberDescriptor).z()) {
                L(i0Var, h2 == null ? null : lVar);
            }
        } else if (callableMemberDescriptor instanceof h.p2.b0.g.t.c.d1.o) {
            ((h.p2.b0.g.t.c.d1.o) callableMemberDescriptor).f1(sVar);
        } else {
            y yVar = (y) callableMemberDescriptor;
            yVar.K0(sVar);
            if (sVar != yVar.V().getVisibility()) {
                yVar.I0(false);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @k.e.a.d
    public static <H> H M(@k.e.a.d Collection<H> collection, @k.e.a.d l<H, h.p2.b0.g.t.c.a> lVar) {
        if (collection == null) {
            a(78);
        }
        if (lVar == 0) {
            a(79);
        }
        if (collection.size() == 1) {
            H h2 = (H) CollectionsKt___CollectionsKt.m2(collection);
            if (h2 == null) {
                a(80);
            }
            return h2;
        }
        ArrayList arrayList = new ArrayList(2);
        List k3 = CollectionsKt___CollectionsKt.k3(collection, lVar);
        H h3 = (H) CollectionsKt___CollectionsKt.m2(collection);
        h.p2.b0.g.t.c.a aVar = (h.p2.b0.g.t.c.a) lVar.invoke(h3);
        for (H h4 : collection) {
            h.p2.b0.g.t.c.a aVar2 = (h.p2.b0.g.t.c.a) lVar.invoke(h4);
            if (D(aVar2, k3)) {
                arrayList.add(h4);
            }
            if (C(aVar2, aVar) && !C(aVar, aVar2)) {
                h3 = h4;
            }
        }
        if (arrayList.isEmpty()) {
            if (h3 == null) {
                a(81);
            }
            return h3;
        } else if (arrayList.size() == 1) {
            H h5 = (H) CollectionsKt___CollectionsKt.m2(arrayList);
            if (h5 == null) {
                a(82);
            }
            return h5;
        } else {
            H h6 = null;
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (!x.b(((h.p2.b0.g.t.c.a) lVar.invoke(next)).getReturnType())) {
                    h6 = next;
                    break;
                }
            }
            if (h6 != null) {
                if (h6 == null) {
                    a(83);
                }
                return h6;
            }
            H h7 = (H) CollectionsKt___CollectionsKt.m2(arrayList);
            if (h7 == null) {
                a(84);
            }
            return h7;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x024f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0035 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0058 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0163 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static /* synthetic */ void a(int r24) {
        /*
            Method dump skipped, instructions count: 1316
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.a(int):void");
    }

    private static boolean b(@k.e.a.d Collection<CallableMemberDescriptor> collection) {
        if (collection == null) {
            a(63);
        }
        if (collection.size() < 2) {
            return true;
        }
        return CollectionsKt___CollectionsKt.j1(collection, new c(collection.iterator().next().b()));
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0054, code lost:
        r1.remove();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean c(@k.e.a.d h.p2.b0.g.t.c.t0 r5, @k.e.a.d h.p2.b0.g.t.c.t0 r6, @k.e.a.d kotlin.Pair<h.p2.b0.g.t.n.e1.m, h.p2.b0.g.t.n.e1.a> r7) {
        /*
            r4 = this;
            if (r5 != 0) goto L7
            r0 = 49
            a(r0)
        L7:
            if (r6 != 0) goto Le
            r0 = 50
            a(r0)
        Le:
            if (r7 != 0) goto L15
            r0 = 51
            a(r0)
        L15:
            java.util.List r5 = r5.getUpperBounds()
            java.util.ArrayList r0 = new java.util.ArrayList
            java.util.List r6 = r6.getUpperBounds()
            r0.<init>(r6)
            int r6 = r5.size()
            int r1 = r0.size()
            r2 = 0
            if (r6 == r1) goto L2e
            return r2
        L2e:
            java.util.Iterator r5 = r5.iterator()
        L32:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L59
            java.lang.Object r6 = r5.next()
            h.p2.b0.g.t.n.z r6 = (h.p2.b0.g.t.n.z) r6
            java.util.ListIterator r1 = r0.listIterator()
        L42:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L58
            java.lang.Object r3 = r1.next()
            h.p2.b0.g.t.n.z r3 = (h.p2.b0.g.t.n.z) r3
            boolean r3 = r4.d(r6, r3, r7)
            if (r3 == 0) goto L42
            r1.remove()
            goto L32
        L58:
            return r2
        L59:
            r5 = 1
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.c(h.p2.b0.g.t.c.t0, h.p2.b0.g.t.c.t0, kotlin.Pair):boolean");
    }

    private boolean d(@k.e.a.d z zVar, @k.e.a.d z zVar2, @k.e.a.d Pair<m, h.p2.b0.g.t.n.e1.a> pair) {
        if (zVar == null) {
            a(46);
        }
        if (zVar2 == null) {
            a(47);
        }
        if (pair == null) {
            a(48);
        }
        if (a0.a(zVar) && a0.a(zVar2)) {
            return true;
        }
        return pair.getFirst().e(pair.getSecond(), zVar.L0(), zVar2.L0());
    }

    @k.e.a.e
    private static OverrideCompatibilityInfo e(h.p2.b0.g.t.c.a aVar, h.p2.b0.g.t.c.a aVar2) {
        if ((aVar.Q() == null) != (aVar2.Q() == null)) {
            return OverrideCompatibilityInfo.d("Receiver presence mismatch");
        }
        if (aVar.h().size() != aVar2.h().size()) {
            return OverrideCompatibilityInfo.d("Value parameter number mismatch");
        }
        return null;
    }

    private static void f(@k.e.a.d CallableMemberDescriptor callableMemberDescriptor, @k.e.a.d Set<CallableMemberDescriptor> set) {
        if (callableMemberDescriptor == null) {
            a(15);
        }
        if (set == null) {
            a(16);
        }
        if (callableMemberDescriptor.i().isReal()) {
            set.add(callableMemberDescriptor);
        } else if (!callableMemberDescriptor.d().isEmpty()) {
            for (CallableMemberDescriptor callableMemberDescriptor2 : callableMemberDescriptor.d()) {
                f(callableMemberDescriptor2, set);
            }
        } else {
            throw new IllegalStateException("No overridden descriptors found for (fake override) " + callableMemberDescriptor);
        }
    }

    private static List<z> g(h.p2.b0.g.t.c.a aVar) {
        m0 Q = aVar.Q();
        ArrayList arrayList = new ArrayList();
        if (Q != null) {
            arrayList.add(Q.getType());
        }
        for (v0 v0Var : aVar.h()) {
            arrayList.add(v0Var.getType());
        }
        return arrayList;
    }

    @k.e.a.e
    private static s h(@k.e.a.d CallableMemberDescriptor callableMemberDescriptor) {
        if (callableMemberDescriptor == null) {
            a(108);
        }
        Collection<? extends CallableMemberDescriptor> d2 = callableMemberDescriptor.d();
        s v = v(d2);
        if (v == null) {
            return null;
        }
        if (callableMemberDescriptor.i() == CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
            for (CallableMemberDescriptor callableMemberDescriptor2 : d2) {
                if (callableMemberDescriptor2.t() != Modality.ABSTRACT && !callableMemberDescriptor2.getVisibility().equals(v)) {
                    return null;
                }
            }
            return v;
        }
        return v.f();
    }

    @k.e.a.d
    public static OverridingUtil i(@k.e.a.d h.p2.b0.g.t.n.e1.h hVar, @k.e.a.d f.a aVar) {
        if (hVar == null) {
            a(2);
        }
        if (aVar == null) {
            a(3);
        }
        return new OverridingUtil(aVar, hVar);
    }

    private static void j(@k.e.a.d Collection<CallableMemberDescriptor> collection, @k.e.a.d h.p2.b0.g.t.c.d dVar, @k.e.a.d h.p2.b0.g.t.k.g gVar) {
        if (collection == null) {
            a(85);
        }
        if (dVar == null) {
            a(86);
        }
        if (gVar == null) {
            a(87);
        }
        Collection<CallableMemberDescriptor> u = u(dVar, collection);
        boolean isEmpty = u.isEmpty();
        if (!isEmpty) {
            collection = u;
        }
        CallableMemberDescriptor P = ((CallableMemberDescriptor) M(collection, new d())).P(dVar, o(collection, dVar), isEmpty ? r.f15214h : r.f15213g, CallableMemberDescriptor.Kind.FAKE_OVERRIDE, false);
        gVar.d(P, collection);
        gVar.a(P);
    }

    private static void k(@k.e.a.d h.p2.b0.g.t.c.d dVar, @k.e.a.d Collection<CallableMemberDescriptor> collection, @k.e.a.d h.p2.b0.g.t.k.g gVar) {
        if (dVar == null) {
            a(64);
        }
        if (collection == null) {
            a(65);
        }
        if (gVar == null) {
            a(66);
        }
        if (b(collection)) {
            for (CallableMemberDescriptor callableMemberDescriptor : collection) {
                j(Collections.singleton(callableMemberDescriptor), dVar, gVar);
            }
            return;
        }
        LinkedList linkedList = new LinkedList(collection);
        while (!linkedList.isEmpty()) {
            j(r(h.p2.b0.g.t.k.l.a(linkedList), linkedList, gVar), dVar, gVar);
        }
    }

    @k.e.a.d
    private Pair<m, h.p2.b0.g.t.n.e1.a> l(@k.e.a.d List<t0> list, @k.e.a.d List<t0> list2) {
        if (list == null) {
            a(40);
        }
        if (list2 == null) {
            a(41);
        }
        return new Pair<>(new m(this.a, g.a.a), m(list, list2));
    }

    @k.e.a.d
    private h.p2.b0.g.t.n.e1.a m(@k.e.a.d List<t0> list, @k.e.a.d List<t0> list2) {
        if (list == null) {
            a(42);
        }
        if (list2 == null) {
            a(43);
        }
        if (list.isEmpty()) {
            h.p2.b0.g.t.n.e1.a aVar = (h.p2.b0.g.t.n.e1.a) new h.p2.b0.g.t.k.h(null, this.b, this.a).v0(true, true);
            if (aVar == null) {
                a(44);
            }
            return aVar;
        }
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < list.size(); i2++) {
            hashMap.put(list.get(i2).j(), list2.get(i2).j());
        }
        h.p2.b0.g.t.n.e1.a aVar2 = (h.p2.b0.g.t.n.e1.a) new h.p2.b0.g.t.k.h(hashMap, this.b, this.a).v0(true, true);
        if (aVar2 == null) {
            a(45);
        }
        return aVar2;
    }

    @k.e.a.d
    public static OverridingUtil n(@k.e.a.d h.p2.b0.g.t.n.e1.h hVar) {
        if (hVar == null) {
            a(1);
        }
        return new OverridingUtil(f16772e, hVar);
    }

    @k.e.a.d
    private static Modality o(@k.e.a.d Collection<CallableMemberDescriptor> collection, @k.e.a.d h.p2.b0.g.t.c.d dVar) {
        if (collection == null) {
            a(88);
        }
        if (dVar == null) {
            a(89);
        }
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        for (CallableMemberDescriptor callableMemberDescriptor : collection) {
            int i2 = h.f16775c[callableMemberDescriptor.t().ordinal()];
            if (i2 == 1) {
                Modality modality = Modality.FINAL;
                if (modality == null) {
                    a(90);
                }
                return modality;
            } else if (i2 == 2) {
                throw new IllegalStateException("Member cannot have SEALED modality: " + callableMemberDescriptor);
            } else if (i2 == 3) {
                z2 = true;
            } else if (i2 == 4) {
                z3 = true;
            }
        }
        if (dVar.i0() && dVar.t() != Modality.ABSTRACT && dVar.t() != Modality.SEALED) {
            z = true;
        }
        if (z2 && !z3) {
            Modality modality2 = Modality.OPEN;
            if (modality2 == null) {
                a(91);
            }
            return modality2;
        } else if (!z2 && z3) {
            Modality t = z ? dVar.t() : Modality.ABSTRACT;
            if (t == null) {
                a(92);
            }
            return t;
        } else {
            HashSet hashSet = new HashSet();
            for (CallableMemberDescriptor callableMemberDescriptor2 : collection) {
                hashSet.addAll(A(callableMemberDescriptor2));
            }
            return z(s(hashSet), z, dVar.t());
        }
    }

    private Collection<CallableMemberDescriptor> p(@k.e.a.d CallableMemberDescriptor callableMemberDescriptor, @k.e.a.d Collection<? extends CallableMemberDescriptor> collection, @k.e.a.d h.p2.b0.g.t.c.d dVar, @k.e.a.d h.p2.b0.g.t.k.g gVar) {
        if (callableMemberDescriptor == null) {
            a(59);
        }
        if (collection == null) {
            a(60);
        }
        if (dVar == null) {
            a(61);
        }
        if (gVar == null) {
            a(62);
        }
        ArrayList arrayList = new ArrayList(collection.size());
        h.p2.b0.g.t.p.e a2 = h.p2.b0.g.t.p.e.a();
        for (CallableMemberDescriptor callableMemberDescriptor2 : collection) {
            OverrideCompatibilityInfo.Result c2 = E(callableMemberDescriptor2, callableMemberDescriptor, dVar).c();
            boolean J = J(callableMemberDescriptor, callableMemberDescriptor2);
            int i2 = h.b[c2.ordinal()];
            if (i2 == 1) {
                if (J) {
                    a2.add(callableMemberDescriptor2);
                }
                arrayList.add(callableMemberDescriptor2);
            } else if (i2 == 2) {
                if (J) {
                    gVar.c(callableMemberDescriptor2, callableMemberDescriptor);
                }
                arrayList.add(callableMemberDescriptor2);
            }
        }
        gVar.d(callableMemberDescriptor, a2);
        return arrayList;
    }

    @k.e.a.d
    public static <H> Collection<H> q(@k.e.a.d H h2, @k.e.a.d Collection<H> collection, @k.e.a.d l<H, h.p2.b0.g.t.c.a> lVar, @k.e.a.d l<H, t1> lVar2) {
        if (h2 == null) {
            a(99);
        }
        if (collection == null) {
            a(100);
        }
        if (lVar == null) {
            a(101);
        }
        if (lVar2 == null) {
            a(102);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(h2);
        h.p2.b0.g.t.c.a invoke = lVar.invoke(h2);
        Iterator<H> it = collection.iterator();
        while (it.hasNext()) {
            H next = it.next();
            h.p2.b0.g.t.c.a invoke2 = lVar.invoke(next);
            if (h2 == next) {
                it.remove();
            } else {
                OverrideCompatibilityInfo.Result y = y(invoke, invoke2);
                if (y == OverrideCompatibilityInfo.Result.OVERRIDABLE) {
                    arrayList.add(next);
                    it.remove();
                } else if (y == OverrideCompatibilityInfo.Result.CONFLICT) {
                    lVar2.invoke(next);
                    it.remove();
                }
            }
        }
        return arrayList;
    }

    @k.e.a.d
    private static Collection<CallableMemberDescriptor> r(@k.e.a.d CallableMemberDescriptor callableMemberDescriptor, @k.e.a.d Queue<CallableMemberDescriptor> queue, @k.e.a.d h.p2.b0.g.t.k.g gVar) {
        if (callableMemberDescriptor == null) {
            a(104);
        }
        if (queue == null) {
            a(105);
        }
        if (gVar == null) {
            a(106);
        }
        return q(callableMemberDescriptor, queue, new f(), new g(gVar, callableMemberDescriptor));
    }

    @k.e.a.d
    public static <D extends h.p2.b0.g.t.c.a> Set<D> s(@k.e.a.d Set<D> set) {
        if (set == null) {
            a(6);
        }
        return t(set, !set.isEmpty() && DescriptorUtilsKt.q(DescriptorUtilsKt.l(set.iterator().next())), null, new b());
    }

    @k.e.a.d
    public static <D> Set<D> t(@k.e.a.d Set<D> set, boolean z, @k.e.a.e h.k2.u.a<?> aVar, @k.e.a.d p<? super D, ? super D, Pair<h.p2.b0.g.t.c.a, h.p2.b0.g.t.c.a>> pVar) {
        if (set == null) {
            a(7);
        }
        if (pVar == null) {
            a(8);
        }
        if (set.size() <= 1) {
            if (set == null) {
                a(9);
            }
            return set;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object obj : set) {
            if (aVar != null) {
                aVar.invoke();
            }
            Iterator it = linkedHashSet.iterator();
            while (true) {
                if (it.hasNext()) {
                    Pair<h.p2.b0.g.t.c.a, h.p2.b0.g.t.c.a> invoke = pVar.invoke(obj, (Object) it.next());
                    h.p2.b0.g.t.c.a component1 = invoke.component1();
                    h.p2.b0.g.t.c.a component2 = invoke.component2();
                    if (K(component1, component2, z, true)) {
                        it.remove();
                    } else if (K(component2, component1, z, true)) {
                        break;
                    }
                } else {
                    linkedHashSet.add(obj);
                    break;
                }
            }
        }
        return linkedHashSet;
    }

    @k.e.a.d
    private static Collection<CallableMemberDescriptor> u(@k.e.a.d h.p2.b0.g.t.c.d dVar, @k.e.a.d Collection<CallableMemberDescriptor> collection) {
        if (dVar == null) {
            a(96);
        }
        if (collection == null) {
            a(97);
        }
        List Z1 = CollectionsKt___CollectionsKt.Z1(collection, new e(dVar));
        if (Z1 == null) {
            a(98);
        }
        return Z1;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0045  */
    @k.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static h.p2.b0.g.t.c.s v(@k.e.a.d java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor> r5) {
        /*
            if (r5 != 0) goto L7
            r0 = 109(0x6d, float:1.53E-43)
            a(r0)
        L7:
            boolean r0 = r5.isEmpty()
            if (r0 == 0) goto L10
            h.p2.b0.g.t.c.s r5 = h.p2.b0.g.t.c.r.f15218l
            return r5
        L10:
            java.util.Iterator r0 = r5.iterator()
            r1 = 0
        L15:
            r2 = r1
        L16:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L38
            java.lang.Object r3 = r0.next()
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) r3
            h.p2.b0.g.t.c.s r3 = r3.getVisibility()
            if (r2 != 0) goto L2a
        L28:
            r2 = r3
            goto L16
        L2a:
            java.lang.Integer r4 = h.p2.b0.g.t.c.r.d(r3, r2)
            if (r4 != 0) goto L31
            goto L15
        L31:
            int r4 = r4.intValue()
            if (r4 <= 0) goto L16
            goto L28
        L38:
            if (r2 != 0) goto L3b
            return r1
        L3b:
            java.util.Iterator r5 = r5.iterator()
        L3f:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L5c
            java.lang.Object r0 = r5.next()
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) r0
            h.p2.b0.g.t.c.s r0 = r0.getVisibility()
            java.lang.Integer r0 = h.p2.b0.g.t.c.r.d(r2, r0)
            if (r0 == 0) goto L5b
            int r0 = r0.intValue()
            if (r0 >= 0) goto L3f
        L5b:
            return r1
        L5c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.v(java.util.Collection):h.p2.b0.g.t.c.s");
    }

    @k.e.a.e
    public static OverrideCompatibilityInfo x(@k.e.a.d h.p2.b0.g.t.c.a aVar, @k.e.a.d h.p2.b0.g.t.c.a aVar2) {
        boolean z;
        if (aVar == null) {
            a(38);
        }
        if (aVar2 == null) {
            a(39);
        }
        boolean z2 = aVar instanceof v;
        if ((!z2 || (aVar2 instanceof v)) && (!((z = aVar instanceof j0)) || (aVar2 instanceof j0))) {
            if (!z2 && !z) {
                throw new IllegalArgumentException("This type of CallableDescriptor cannot be checked for overridability: " + aVar);
            } else if (!aVar.getName().equals(aVar2.getName())) {
                return OverrideCompatibilityInfo.d("Name mismatch");
            } else {
                OverrideCompatibilityInfo e2 = e(aVar, aVar2);
                if (e2 != null) {
                    return e2;
                }
                return null;
            }
        }
        return OverrideCompatibilityInfo.d("Member kind mismatch");
    }

    @k.e.a.e
    public static OverrideCompatibilityInfo.Result y(h.p2.b0.g.t.c.a aVar, h.p2.b0.g.t.c.a aVar2) {
        OverridingUtil overridingUtil = f16771d;
        OverrideCompatibilityInfo.Result c2 = overridingUtil.E(aVar2, aVar, null).c();
        OverrideCompatibilityInfo.Result c3 = overridingUtil.E(aVar, aVar2, null).c();
        OverrideCompatibilityInfo.Result result = OverrideCompatibilityInfo.Result.OVERRIDABLE;
        if (c2 == result && c3 == result) {
            return result;
        }
        OverrideCompatibilityInfo.Result result2 = OverrideCompatibilityInfo.Result.CONFLICT;
        return (c2 == result2 || c3 == result2) ? result2 : OverrideCompatibilityInfo.Result.INCOMPATIBLE;
    }

    @k.e.a.d
    private static Modality z(@k.e.a.d Collection<CallableMemberDescriptor> collection, boolean z, @k.e.a.d Modality modality) {
        if (collection == null) {
            a(93);
        }
        if (modality == null) {
            a(94);
        }
        Modality modality2 = Modality.ABSTRACT;
        for (CallableMemberDescriptor callableMemberDescriptor : collection) {
            Modality t = (z && callableMemberDescriptor.t() == Modality.ABSTRACT) ? modality : callableMemberDescriptor.t();
            if (t.compareTo(modality2) < 0) {
                modality2 = t;
            }
        }
        if (modality2 == null) {
            a(95);
        }
        return modality2;
    }

    @k.e.a.d
    public OverrideCompatibilityInfo E(@k.e.a.d h.p2.b0.g.t.c.a aVar, @k.e.a.d h.p2.b0.g.t.c.a aVar2, @k.e.a.e h.p2.b0.g.t.c.d dVar) {
        if (aVar == null) {
            a(17);
        }
        if (aVar2 == null) {
            a(18);
        }
        OverrideCompatibilityInfo F = F(aVar, aVar2, dVar, false);
        if (F == null) {
            a(19);
        }
        return F;
    }

    @k.e.a.d
    public OverrideCompatibilityInfo F(@k.e.a.d h.p2.b0.g.t.c.a aVar, @k.e.a.d h.p2.b0.g.t.c.a aVar2, @k.e.a.e h.p2.b0.g.t.c.d dVar, boolean z) {
        if (aVar == null) {
            a(20);
        }
        if (aVar2 == null) {
            a(21);
        }
        OverrideCompatibilityInfo G = G(aVar, aVar2, z);
        boolean z2 = G.c() == OverrideCompatibilityInfo.Result.OVERRIDABLE;
        for (ExternalOverridabilityCondition externalOverridabilityCondition : f16770c) {
            if (externalOverridabilityCondition.a() != ExternalOverridabilityCondition.Contract.CONFLICTS_ONLY && (!z2 || externalOverridabilityCondition.a() != ExternalOverridabilityCondition.Contract.SUCCESS_ONLY)) {
                int i2 = h.a[externalOverridabilityCondition.b(aVar, aVar2, dVar).ordinal()];
                if (i2 == 1) {
                    z2 = true;
                } else if (i2 == 2) {
                    OverrideCompatibilityInfo b2 = OverrideCompatibilityInfo.b("External condition failed");
                    if (b2 == null) {
                        a(22);
                    }
                    return b2;
                } else if (i2 == 3) {
                    OverrideCompatibilityInfo d2 = OverrideCompatibilityInfo.d("External condition");
                    if (d2 == null) {
                        a(23);
                    }
                    return d2;
                }
            }
        }
        if (!z2) {
            if (G == null) {
                a(24);
            }
            return G;
        }
        for (ExternalOverridabilityCondition externalOverridabilityCondition2 : f16770c) {
            if (externalOverridabilityCondition2.a() == ExternalOverridabilityCondition.Contract.CONFLICTS_ONLY) {
                int i3 = h.a[externalOverridabilityCondition2.b(aVar, aVar2, dVar).ordinal()];
                if (i3 == 1) {
                    throw new IllegalStateException("Contract violation in " + externalOverridabilityCondition2.getClass().getName() + " condition. It's not supposed to end with success");
                } else if (i3 == 2) {
                    OverrideCompatibilityInfo b3 = OverrideCompatibilityInfo.b("External condition failed");
                    if (b3 == null) {
                        a(25);
                    }
                    return b3;
                } else if (i3 == 3) {
                    OverrideCompatibilityInfo d3 = OverrideCompatibilityInfo.d("External condition");
                    if (d3 == null) {
                        a(26);
                    }
                    return d3;
                }
            }
        }
        OverrideCompatibilityInfo e2 = OverrideCompatibilityInfo.e();
        if (e2 == null) {
            a(27);
        }
        return e2;
    }

    @k.e.a.d
    public OverrideCompatibilityInfo G(@k.e.a.d h.p2.b0.g.t.c.a aVar, @k.e.a.d h.p2.b0.g.t.c.a aVar2, boolean z) {
        if (aVar == null) {
            a(28);
        }
        if (aVar2 == null) {
            a(29);
        }
        OverrideCompatibilityInfo x = x(aVar, aVar2);
        if (x != null) {
            if (x == null) {
                a(30);
            }
            return x;
        }
        List<z> g2 = g(aVar);
        List<z> g3 = g(aVar2);
        List<t0> typeParameters = aVar.getTypeParameters();
        List<t0> typeParameters2 = aVar2.getTypeParameters();
        int i2 = 0;
        if (typeParameters.size() != typeParameters2.size()) {
            while (i2 < g2.size()) {
                if (!h.p2.b0.g.t.n.e1.f.a.b(g2.get(i2), g3.get(i2))) {
                    OverrideCompatibilityInfo d2 = OverrideCompatibilityInfo.d("Type parameter number mismatch");
                    if (d2 == null) {
                        a(31);
                    }
                    return d2;
                }
                i2++;
            }
            OverrideCompatibilityInfo b2 = OverrideCompatibilityInfo.b("Type parameter number mismatch");
            if (b2 == null) {
                a(32);
            }
            return b2;
        }
        Pair<m, h.p2.b0.g.t.n.e1.a> l2 = l(typeParameters, typeParameters2);
        for (int i3 = 0; i3 < typeParameters.size(); i3++) {
            if (!c(typeParameters.get(i3), typeParameters2.get(i3), l2)) {
                OverrideCompatibilityInfo d3 = OverrideCompatibilityInfo.d("Type parameter bounds mismatch");
                if (d3 == null) {
                    a(33);
                }
                return d3;
            }
        }
        for (int i4 = 0; i4 < g2.size(); i4++) {
            if (!d(g2.get(i4), g3.get(i4), l2)) {
                OverrideCompatibilityInfo d4 = OverrideCompatibilityInfo.d("Value parameter type mismatch");
                if (d4 == null) {
                    a(34);
                }
                return d4;
            }
        }
        if ((aVar instanceof v) && (aVar2 instanceof v) && ((v) aVar).isSuspend() != ((v) aVar2).isSuspend()) {
            OverrideCompatibilityInfo b3 = OverrideCompatibilityInfo.b("Incompatible suspendability");
            if (b3 == null) {
                a(35);
            }
            return b3;
        }
        if (z) {
            z returnType = aVar.getReturnType();
            z returnType2 = aVar2.getReturnType();
            if (returnType != null && returnType2 != null) {
                if (a0.a(returnType2) && a0.a(returnType)) {
                    i2 = 1;
                }
                if (i2 == 0 && !l2.getFirst().g(l2.getSecond(), returnType2.L0(), returnType.L0())) {
                    OverrideCompatibilityInfo b4 = OverrideCompatibilityInfo.b("Return type mismatch");
                    if (b4 == null) {
                        a(36);
                    }
                    return b4;
                }
            }
        }
        OverrideCompatibilityInfo e2 = OverrideCompatibilityInfo.e();
        if (e2 == null) {
            a(37);
        }
        return e2;
    }

    public void w(@k.e.a.d h.p2.b0.g.t.g.f fVar, @k.e.a.d Collection<? extends CallableMemberDescriptor> collection, @k.e.a.d Collection<? extends CallableMemberDescriptor> collection2, @k.e.a.d h.p2.b0.g.t.c.d dVar, @k.e.a.d h.p2.b0.g.t.k.g gVar) {
        if (fVar == null) {
            a(52);
        }
        if (collection == null) {
            a(53);
        }
        if (collection2 == null) {
            a(54);
        }
        if (dVar == null) {
            a(55);
        }
        if (gVar == null) {
            a(56);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(collection);
        for (CallableMemberDescriptor callableMemberDescriptor : collection2) {
            linkedHashSet.removeAll(p(callableMemberDescriptor, collection, dVar, gVar));
        }
        k(dVar, linkedHashSet, gVar);
    }
}
