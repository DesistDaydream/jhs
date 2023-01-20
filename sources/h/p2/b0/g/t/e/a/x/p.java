package h.p2.b0.g.t.e.a.x;

import h.k2.v.f0;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* loaded from: classes3.dex */
public final class p {
    private static final boolean a(r rVar) {
        h.p2.b0.g.t.g.c e2;
        a0 a0Var = (a0) CollectionsKt___CollectionsKt.X4(rVar.h());
        x type = a0Var == null ? null : a0Var.getType();
        j jVar = type instanceof j ? (j) type : null;
        if (jVar == null) {
            return false;
        }
        i a = jVar.a();
        return (a instanceof g) && (e2 = ((g) a).e()) != null && f0.g(e2.b(), "java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0022, code lost:
        if (r0.equals(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_HASHCODE) == false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0039, code lost:
        if (r0.equals("toString") == false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0045, code lost:
        return r3.h().isEmpty();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final boolean b(h.p2.b0.g.t.e.a.x.r r3) {
        /*
            h.p2.b0.g.t.g.f r0 = r3.getName()
            java.lang.String r0 = r0.b()
            int r1 = r0.hashCode()
            r2 = -1776922004(0xffffffff9616526c, float:-1.2142911E-25)
            if (r1 == r2) goto L33
            r2 = -1295482945(0xffffffffb2c87fbf, float:-2.3341157E-8)
            if (r1 == r2) goto L25
            r2 = 147696667(0x8cdac1b, float:1.23784505E-33)
            if (r1 == r2) goto L1c
            goto L3b
        L1c:
            java.lang.String r1 = "hashCode"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L3d
            goto L3b
        L25:
            java.lang.String r1 = "equals"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L2e
            goto L3b
        L2e:
            boolean r3 = a(r3)
            goto L45
        L33:
            java.lang.String r1 = "toString"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L3d
        L3b:
            r3 = 0
            goto L45
        L3d:
            java.util.List r3 = r3.h()
            boolean r3 = r3.isEmpty()
        L45:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: h.p2.b0.g.t.e.a.x.p.b(h.p2.b0.g.t.e.a.x.r):boolean");
    }

    public static final boolean c(@k.e.a.d q qVar) {
        return qVar.P().K() && (qVar instanceof r) && b((r) qVar);
    }
}
