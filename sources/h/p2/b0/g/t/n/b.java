package h.p2.b0.g.t.n;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor;

/* loaded from: classes3.dex */
public abstract class b extends AbstractTypeConstructor implements q0 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@k.e.a.d h.p2.b0.g.t.m.m mVar) {
        super(mVar);
        if (mVar == null) {
            u(0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static /* synthetic */ void u(int r9) {
        /*
            r0 = 4
            r1 = 3
            r2 = 1
            if (r9 == r2) goto Lc
            if (r9 == r1) goto Lc
            if (r9 == r0) goto Lc
            java.lang.String r3 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
            goto Le
        Lc:
            java.lang.String r3 = "@NotNull method %s.%s must not return null"
        Le:
            r4 = 2
            if (r9 == r2) goto L17
            if (r9 == r1) goto L17
            if (r9 == r0) goto L17
            r5 = 3
            goto L18
        L17:
            r5 = 2
        L18:
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.lang.String r6 = "kotlin/reflect/jvm/internal/impl/types/AbstractClassTypeConstructor"
            r7 = 0
            if (r9 == r2) goto L2f
            if (r9 == r4) goto L2a
            if (r9 == r1) goto L2f
            if (r9 == r0) goto L2f
            java.lang.String r8 = "storageManager"
            r5[r7] = r8
            goto L31
        L2a:
            java.lang.String r8 = "classifier"
            r5[r7] = r8
            goto L31
        L2f:
            r5[r7] = r6
        L31:
            if (r9 == r2) goto L3f
            if (r9 == r1) goto L3a
            if (r9 == r0) goto L3a
            r5[r2] = r6
            goto L43
        L3a:
            java.lang.String r6 = "getAdditionalNeighboursInSupertypeGraph"
            r5[r2] = r6
            goto L43
        L3f:
            java.lang.String r6 = "getBuiltIns"
            r5[r2] = r6
        L43:
            if (r9 == r2) goto L54
            if (r9 == r4) goto L50
            if (r9 == r1) goto L54
            if (r9 == r0) goto L54
            java.lang.String r6 = "<init>"
            r5[r4] = r6
            goto L54
        L50:
            java.lang.String r6 = "isSameClassifier"
            r5[r4] = r6
        L54:
            java.lang.String r3 = java.lang.String.format(r3, r5)
            if (r9 == r2) goto L64
            if (r9 == r1) goto L64
            if (r9 == r0) goto L64
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            r9.<init>(r3)
            goto L69
        L64:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            r9.<init>(r3)
        L69:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: h.p2.b0.g.t.n.b.u(int):void");
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
    @k.e.a.e
    public z i() {
        if (h.p2.b0.g.t.b.f.r0(c())) {
            return null;
        }
        return k().i();
    }

    @Override // h.p2.b0.g.t.n.q0
    @k.e.a.d
    public h.p2.b0.g.t.b.f k() {
        h.p2.b0.g.t.b.f g2 = DescriptorUtilsKt.g(c());
        if (g2 == null) {
            u(1);
        }
        return g2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
    @k.e.a.d
    public Collection<z> l(boolean z) {
        h.p2.b0.g.t.c.k b = c().b();
        if (!(b instanceof h.p2.b0.g.t.c.d)) {
            List emptyList = Collections.emptyList();
            if (emptyList == null) {
                u(3);
            }
            return emptyList;
        }
        h.p2.b0.g.t.p.d dVar = new h.p2.b0.g.t.p.d();
        h.p2.b0.g.t.c.d dVar2 = (h.p2.b0.g.t.c.d) b;
        dVar.add(dVar2.r());
        h.p2.b0.g.t.c.d l0 = dVar2.l0();
        if (z && l0 != null) {
            dVar.add(l0.r());
        }
        return dVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
    public boolean q(@k.e.a.d h.p2.b0.g.t.c.f fVar) {
        if (fVar == null) {
            u(2);
        }
        return (fVar instanceof h.p2.b0.g.t.c.d) && f(c(), fVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor, h.p2.b0.g.t.n.q0
    @k.e.a.d
    /* renamed from: v */
    public abstract h.p2.b0.g.t.c.d c();
}
