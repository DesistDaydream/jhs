package h.p2.b0.g.t.f.a0.f;

import h.a2.u;
import h.k2.k;
import h.k2.v.f0;
import h.p2.b0.g.t.f.a0.f.d;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;

/* loaded from: classes3.dex */
public final class g {
    @k.e.a.d
    public static final g a = new g();
    @k.e.a.d
    private static final h.p2.b0.g.t.i.f b;

    static {
        h.p2.b0.g.t.i.f d2 = h.p2.b0.g.t.i.f.d();
        JvmProtoBuf.a(d2);
        b = d2;
    }

    private g() {
    }

    public static /* synthetic */ d.a d(g gVar, ProtoBuf.Property property, h.p2.b0.g.t.f.z.c cVar, h.p2.b0.g.t.f.z.g gVar2, boolean z, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            z = true;
        }
        return gVar.c(property, cVar, gVar2, z);
    }

    @k
    public static final boolean f(@k.e.a.d ProtoBuf.Property property) {
        return c.a.a().d(((Number) property.getExtension(JvmProtoBuf.f16706e)).intValue()).booleanValue();
    }

    private final String g(ProtoBuf.Type type, h.p2.b0.g.t.f.z.c cVar) {
        if (type.hasClassName()) {
            b bVar = b.a;
            return b.b(cVar.b(type.getClassName()));
        }
        return null;
    }

    @k
    @k.e.a.d
    public static final Pair<f, ProtoBuf.Class> h(@k.e.a.d byte[] bArr, @k.e.a.d String[] strArr) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        return new Pair<>(a.k(byteArrayInputStream, strArr), ProtoBuf.Class.parseFrom(byteArrayInputStream, b));
    }

    @k
    @k.e.a.d
    public static final Pair<f, ProtoBuf.Class> i(@k.e.a.d String[] strArr, @k.e.a.d String[] strArr2) {
        return h(a.e(strArr), strArr2);
    }

    @k
    @k.e.a.d
    public static final Pair<f, ProtoBuf.Function> j(@k.e.a.d String[] strArr, @k.e.a.d String[] strArr2) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(a.e(strArr));
        return new Pair<>(a.k(byteArrayInputStream, strArr2), ProtoBuf.Function.parseFrom(byteArrayInputStream, b));
    }

    private final f k(InputStream inputStream, String[] strArr) {
        return new f(JvmProtoBuf.StringTableTypes.parseDelimitedFrom(inputStream, b), strArr);
    }

    @k
    @k.e.a.d
    public static final Pair<f, ProtoBuf.Package> l(@k.e.a.d byte[] bArr, @k.e.a.d String[] strArr) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        return new Pair<>(a.k(byteArrayInputStream, strArr), ProtoBuf.Package.parseFrom(byteArrayInputStream, b));
    }

    @k
    @k.e.a.d
    public static final Pair<f, ProtoBuf.Package> m(@k.e.a.d String[] strArr, @k.e.a.d String[] strArr2) {
        return l(a.e(strArr), strArr2);
    }

    @k.e.a.d
    public final h.p2.b0.g.t.i.f a() {
        return b;
    }

    @k.e.a.e
    public final d.b b(@k.e.a.d ProtoBuf.Constructor constructor, @k.e.a.d h.p2.b0.g.t.f.z.c cVar, @k.e.a.d h.p2.b0.g.t.f.z.g gVar) {
        String Z2;
        JvmProtoBuf.JvmMethodSignature jvmMethodSignature = (JvmProtoBuf.JvmMethodSignature) h.p2.b0.g.t.f.z.e.a(constructor, JvmProtoBuf.a);
        String string = (jvmMethodSignature == null || !jvmMethodSignature.hasName()) ? "<init>" : cVar.getString(jvmMethodSignature.getName());
        if (jvmMethodSignature != null && jvmMethodSignature.hasDesc()) {
            Z2 = cVar.getString(jvmMethodSignature.getDesc());
        } else {
            List<ProtoBuf.ValueParameter> valueParameterList = constructor.getValueParameterList();
            ArrayList arrayList = new ArrayList(u.Y(valueParameterList, 10));
            for (ProtoBuf.ValueParameter valueParameter : valueParameterList) {
                String g2 = a.g(h.p2.b0.g.t.f.z.f.m(valueParameter, gVar), cVar);
                if (g2 == null) {
                    return null;
                }
                arrayList.add(g2);
            }
            Z2 = CollectionsKt___CollectionsKt.Z2(arrayList, "", "(", ")V", 0, null, null, 56, null);
        }
        return new d.b(string, Z2);
    }

    @k.e.a.e
    public final d.a c(@k.e.a.d ProtoBuf.Property property, @k.e.a.d h.p2.b0.g.t.f.z.c cVar, @k.e.a.d h.p2.b0.g.t.f.z.g gVar, boolean z) {
        String g2;
        JvmProtoBuf.JvmPropertySignature jvmPropertySignature = (JvmProtoBuf.JvmPropertySignature) h.p2.b0.g.t.f.z.e.a(property, JvmProtoBuf.f16705d);
        if (jvmPropertySignature == null) {
            return null;
        }
        JvmProtoBuf.JvmFieldSignature field = jvmPropertySignature.hasField() ? jvmPropertySignature.getField() : null;
        if (field == null && z) {
            return null;
        }
        int name = (field == null || !field.hasName()) ? property.getName() : field.getName();
        if (field == null || !field.hasDesc()) {
            g2 = g(h.p2.b0.g.t.f.z.f.j(property, gVar), cVar);
            if (g2 == null) {
                return null;
            }
        } else {
            g2 = cVar.getString(field.getDesc());
        }
        return new d.a(cVar.getString(name), g2);
    }

    @k.e.a.e
    public final d.b e(@k.e.a.d ProtoBuf.Function function, @k.e.a.d h.p2.b0.g.t.f.z.c cVar, @k.e.a.d h.p2.b0.g.t.f.z.g gVar) {
        String C;
        JvmProtoBuf.JvmMethodSignature jvmMethodSignature = (JvmProtoBuf.JvmMethodSignature) h.p2.b0.g.t.f.z.e.a(function, JvmProtoBuf.b);
        int name = (jvmMethodSignature == null || !jvmMethodSignature.hasName()) ? function.getName() : jvmMethodSignature.getName();
        if (jvmMethodSignature != null && jvmMethodSignature.hasDesc()) {
            C = cVar.getString(jvmMethodSignature.getDesc());
        } else {
            List M = CollectionsKt__CollectionsKt.M(h.p2.b0.g.t.f.z.f.g(function, gVar));
            List<ProtoBuf.ValueParameter> valueParameterList = function.getValueParameterList();
            ArrayList arrayList = new ArrayList(u.Y(valueParameterList, 10));
            for (ProtoBuf.ValueParameter valueParameter : valueParameterList) {
                arrayList.add(h.p2.b0.g.t.f.z.f.m(valueParameter, gVar));
            }
            List<ProtoBuf.Type> q4 = CollectionsKt___CollectionsKt.q4(M, arrayList);
            ArrayList arrayList2 = new ArrayList(u.Y(q4, 10));
            for (ProtoBuf.Type type : q4) {
                String g2 = a.g(type, cVar);
                if (g2 == null) {
                    return null;
                }
                arrayList2.add(g2);
            }
            String g3 = g(h.p2.b0.g.t.f.z.f.i(function, gVar), cVar);
            if (g3 == null) {
                return null;
            }
            C = f0.C(CollectionsKt___CollectionsKt.Z2(arrayList2, "", "(", ")", 0, null, null, 56, null), g3);
        }
        return new d.b(cVar.getString(name), C);
    }
}
