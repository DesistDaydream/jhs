package kotlin.reflect.jvm.internal.impl.resolve.constants;

import h.p2.b0.g.t.k.n.b;
import h.p2.b0.g.t.k.n.c;
import h.p2.b0.g.t.k.n.g;
import h.p2.b0.g.t.k.n.h;
import h.p2.b0.g.t.k.n.k;
import h.p2.b0.g.t.k.n.l;
import h.p2.b0.g.t.k.n.p;
import h.p2.b0.g.t.k.n.q;
import h.p2.b0.g.t.k.n.s;
import h.p2.b0.g.t.k.n.t;
import h.p2.b0.g.t.n.z;
import java.util.ArrayList;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;

/* loaded from: classes3.dex */
public final class ConstantValueFactory {
    @d
    public static final ConstantValueFactory a = new ConstantValueFactory();

    private ConstantValueFactory() {
    }

    private final b a(List<?> list, PrimitiveType primitiveType) {
        List<Object> I5 = CollectionsKt___CollectionsKt.I5(list);
        ArrayList arrayList = new ArrayList();
        for (Object obj : I5) {
            g<?> c2 = c(obj);
            if (c2 != null) {
                arrayList.add(c2);
            }
        }
        return new b(arrayList, new ConstantValueFactory$createArrayValue$3(primitiveType));
    }

    @d
    public final b b(@d List<? extends g<?>> list, @d z zVar) {
        return new b(list, new ConstantValueFactory$createArrayValue$1(zVar));
    }

    @e
    public final g<?> c(@e Object obj) {
        if (obj instanceof Byte) {
            return new h.p2.b0.g.t.k.n.d(((Number) obj).byteValue());
        }
        if (obj instanceof Short) {
            return new s(((Number) obj).shortValue());
        }
        if (obj instanceof Integer) {
            return new l(((Number) obj).intValue());
        }
        if (obj instanceof Long) {
            return new p(((Number) obj).longValue());
        }
        if (obj instanceof Character) {
            return new h.p2.b0.g.t.k.n.e(((Character) obj).charValue());
        }
        if (obj instanceof Float) {
            return new k(((Number) obj).floatValue());
        }
        if (obj instanceof Double) {
            return new h(((Number) obj).doubleValue());
        }
        if (obj instanceof Boolean) {
            return new c(((Boolean) obj).booleanValue());
        }
        if (obj instanceof String) {
            return new t((String) obj);
        }
        if (obj instanceof byte[]) {
            return a(ArraysKt___ArraysKt.Yx((byte[]) obj), PrimitiveType.BYTE);
        }
        if (obj instanceof short[]) {
            return a(ArraysKt___ArraysKt.fy((short[]) obj), PrimitiveType.SHORT);
        }
        if (obj instanceof int[]) {
            return a(ArraysKt___ArraysKt.cy((int[]) obj), PrimitiveType.INT);
        }
        if (obj instanceof long[]) {
            return a(ArraysKt___ArraysKt.dy((long[]) obj), PrimitiveType.LONG);
        }
        if (obj instanceof char[]) {
            return a(ArraysKt___ArraysKt.Zx((char[]) obj), PrimitiveType.CHAR);
        }
        if (obj instanceof float[]) {
            return a(ArraysKt___ArraysKt.by((float[]) obj), PrimitiveType.FLOAT);
        }
        if (obj instanceof double[]) {
            return a(ArraysKt___ArraysKt.ay((double[]) obj), PrimitiveType.DOUBLE);
        }
        if (obj instanceof boolean[]) {
            return a(ArraysKt___ArraysKt.gy((boolean[]) obj), PrimitiveType.BOOLEAN);
        }
        if (obj == null) {
            return new q();
        }
        return null;
    }
}
