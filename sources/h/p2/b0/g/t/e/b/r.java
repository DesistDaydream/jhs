package h.p2.b0.g.t.e.b;

import androidx.exifinterface.media.ExifInterface;
import h.k2.v.f0;
import h.p2.b0.g.t.b.g;
import h.p2.b0.g.t.c.m0;
import h.p2.b0.g.t.c.n0;
import h.p2.b0.g.t.c.v0;
import h.p2.b0.g.t.e.b.h;
import h.p2.b0.g.t.n.z;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* loaded from: classes3.dex */
public final class r {
    private static final void a(StringBuilder sb, z zVar) {
        sb.append(g(zVar));
    }

    @k.e.a.d
    public static final String b(@k.e.a.d h.p2.b0.g.t.c.v vVar, boolean z, boolean z2) {
        StringBuilder sb = new StringBuilder();
        if (z2) {
            sb.append(vVar instanceof h.p2.b0.g.t.c.j ? "<init>" : vVar.getName().b());
        }
        sb.append("(");
        m0 Q = vVar.Q();
        if (Q != null) {
            a(sb, Q.getType());
        }
        for (v0 v0Var : vVar.h()) {
            a(sb, v0Var.getType());
        }
        sb.append(")");
        if (z) {
            if (b.c(vVar)) {
                sb.append(ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
            } else {
                a(sb, vVar.getReturnType());
            }
        }
        return sb.toString();
    }

    public static /* synthetic */ String c(h.p2.b0.g.t.c.v vVar, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        if ((i2 & 2) != 0) {
            z2 = true;
        }
        return b(vVar, z, z2);
    }

    @k.e.a.e
    public static final String d(@k.e.a.d h.p2.b0.g.t.c.a aVar) {
        SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.a;
        if (h.p2.b0.g.t.k.c.E(aVar)) {
            return null;
        }
        h.p2.b0.g.t.c.k b = aVar.b();
        h.p2.b0.g.t.c.d dVar = b instanceof h.p2.b0.g.t.c.d ? (h.p2.b0.g.t.c.d) b : null;
        if (dVar == null || dVar.getName().g()) {
            return null;
        }
        h.p2.b0.g.t.c.a a = aVar.a();
        n0 n0Var = a instanceof n0 ? (n0) a : null;
        if (n0Var == null) {
            return null;
        }
        return q.a(signatureBuildingComponents, dVar, c(n0Var, false, false, 3, null));
    }

    public static final boolean e(@k.e.a.d h.p2.b0.g.t.c.a aVar) {
        if (aVar instanceof h.p2.b0.g.t.c.v) {
            h.p2.b0.g.t.c.v vVar = (h.p2.b0.g.t.c.v) aVar;
            if (f0.g(vVar.getName().b(), "remove") && vVar.h().size() == 1 && !SpecialBuiltinMembers.h((CallableMemberDescriptor) aVar)) {
                h g2 = g(((v0) CollectionsKt___CollectionsKt.U4(vVar.a().h())).getType());
                h.d dVar = g2 instanceof h.d ? (h.d) g2 : null;
                if ((dVar != null ? dVar.i() : null) != JvmPrimitiveType.INT) {
                    return false;
                }
                BuiltinMethodsWithSpecialGenericSignature builtinMethodsWithSpecialGenericSignature = BuiltinMethodsWithSpecialGenericSignature.n;
                h.p2.b0.g.t.c.v k2 = BuiltinMethodsWithSpecialGenericSignature.k(vVar);
                if (k2 == null) {
                    return false;
                }
                h g3 = g(((v0) CollectionsKt___CollectionsKt.U4(k2.a().h())).getType());
                return f0.g(DescriptorUtilsKt.j(k2.b()), g.a.X.j()) && (g3 instanceof h.c) && f0.g(((h.c) g3).i(), "java/lang/Object");
            }
            return false;
        }
        return false;
    }

    @k.e.a.d
    public static final String f(@k.e.a.d h.p2.b0.g.t.c.d dVar) {
        h.p2.b0.g.t.g.b o = h.p2.b0.g.t.b.k.c.a.o(DescriptorUtilsKt.i(dVar).j());
        if (o == null) {
            return b.b(dVar, null, 2, null);
        }
        return h.p2.b0.g.t.k.p.d.b(o).f();
    }

    @k.e.a.d
    public static final h g(@k.e.a.d z zVar) {
        return (h) b.e(zVar, j.a, v.o, u.a, null, null, 32, null);
    }
}
