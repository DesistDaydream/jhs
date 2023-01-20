package h.p2.b0.g.t.l.b;

import h.a2.l0;
import h.a2.s0;
import h.a2.t0;
import h.k2.v.f0;
import h.p2.b0.g.t.c.o0;
import h.p2.b0.g.t.c.v0;
import h.p2.b0.g.t.c.z;
import h.p2.b0.g.t.k.n.j;
import h.p2.b0.g.t.k.n.w;
import h.p2.b0.g.t.k.n.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory;

/* loaded from: classes3.dex */
public final class c {
    @k.e.a.d
    private final z a;
    @k.e.a.d
    private final NotFoundClasses b;

    /* loaded from: classes3.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ProtoBuf.Annotation.Argument.Value.Type.values().length];
            iArr[ProtoBuf.Annotation.Argument.Value.Type.BYTE.ordinal()] = 1;
            iArr[ProtoBuf.Annotation.Argument.Value.Type.CHAR.ordinal()] = 2;
            iArr[ProtoBuf.Annotation.Argument.Value.Type.SHORT.ordinal()] = 3;
            iArr[ProtoBuf.Annotation.Argument.Value.Type.INT.ordinal()] = 4;
            iArr[ProtoBuf.Annotation.Argument.Value.Type.LONG.ordinal()] = 5;
            iArr[ProtoBuf.Annotation.Argument.Value.Type.FLOAT.ordinal()] = 6;
            iArr[ProtoBuf.Annotation.Argument.Value.Type.DOUBLE.ordinal()] = 7;
            iArr[ProtoBuf.Annotation.Argument.Value.Type.BOOLEAN.ordinal()] = 8;
            iArr[ProtoBuf.Annotation.Argument.Value.Type.STRING.ordinal()] = 9;
            iArr[ProtoBuf.Annotation.Argument.Value.Type.CLASS.ordinal()] = 10;
            iArr[ProtoBuf.Annotation.Argument.Value.Type.ENUM.ordinal()] = 11;
            iArr[ProtoBuf.Annotation.Argument.Value.Type.ANNOTATION.ordinal()] = 12;
            iArr[ProtoBuf.Annotation.Argument.Value.Type.ARRAY.ordinal()] = 13;
            a = iArr;
        }
    }

    public c(@k.e.a.d z zVar, @k.e.a.d NotFoundClasses notFoundClasses) {
        this.a = zVar;
        this.b = notFoundClasses;
    }

    private final boolean b(h.p2.b0.g.t.k.n.g<?> gVar, h.p2.b0.g.t.n.z zVar, ProtoBuf.Annotation.Argument.Value value) {
        ProtoBuf.Annotation.Argument.Value.Type type = value.getType();
        int i2 = type == null ? -1 : a.a[type.ordinal()];
        if (i2 == 10) {
            h.p2.b0.g.t.c.f c2 = zVar.I0().c();
            h.p2.b0.g.t.c.d dVar = c2 instanceof h.p2.b0.g.t.c.d ? (h.p2.b0.g.t.c.d) c2 : null;
            if (dVar != null && !h.p2.b0.g.t.b.f.i0(dVar)) {
                return false;
            }
        } else if (i2 != 13) {
            return f0.g(gVar.getType(this.a), zVar);
        } else {
            if ((gVar instanceof h.p2.b0.g.t.k.n.b) && ((h.p2.b0.g.t.k.n.b) gVar).a().size() == value.getArrayElementList().size()) {
                h.p2.b0.g.t.n.z k2 = c().k(zVar);
                h.p2.b0.g.t.k.n.b bVar = (h.p2.b0.g.t.k.n.b) gVar;
                h.o2.k F = CollectionsKt__CollectionsKt.F(bVar.a());
                if (!(F instanceof Collection) || !((Collection) F).isEmpty()) {
                    Iterator<Integer> it = F.iterator();
                    while (it.hasNext()) {
                        int nextInt = ((l0) it).nextInt();
                        if (!b(bVar.a().get(nextInt), k2, value.getArrayElement(nextInt))) {
                            return false;
                        }
                    }
                }
            } else {
                throw new IllegalStateException(f0.C("Deserialized ArrayValue should have the same number of elements as the original array value: ", gVar).toString());
            }
        }
        return true;
    }

    private final h.p2.b0.g.t.b.f c() {
        return this.a.k();
    }

    private final Pair<h.p2.b0.g.t.g.f, h.p2.b0.g.t.k.n.g<?>> d(ProtoBuf.Annotation.Argument argument, Map<h.p2.b0.g.t.g.f, ? extends v0> map, h.p2.b0.g.t.f.z.c cVar) {
        v0 v0Var = map.get(q.b(cVar, argument.getNameId()));
        if (v0Var == null) {
            return null;
        }
        return new Pair<>(q.b(cVar, argument.getNameId()), g(v0Var.getType(), argument.getValue(), cVar));
    }

    private final h.p2.b0.g.t.c.d e(h.p2.b0.g.t.g.b bVar) {
        return FindClassInModuleKt.c(this.a, bVar, this.b);
    }

    private final h.p2.b0.g.t.k.n.g<?> g(h.p2.b0.g.t.n.z zVar, ProtoBuf.Annotation.Argument.Value value, h.p2.b0.g.t.f.z.c cVar) {
        h.p2.b0.g.t.k.n.g<?> f2 = f(zVar, value, cVar);
        if (!b(f2, zVar, value)) {
            f2 = null;
        }
        if (f2 == null) {
            j.a aVar = h.p2.b0.g.t.k.n.j.b;
            return aVar.a("Unexpected argument value: actual type " + value.getType() + " != expected type " + zVar);
        }
        return f2;
    }

    @k.e.a.d
    public final h.p2.b0.g.t.c.b1.c a(@k.e.a.d ProtoBuf.Annotation annotation, @k.e.a.d h.p2.b0.g.t.f.z.c cVar) {
        h.p2.b0.g.t.c.c cVar2;
        h.p2.b0.g.t.c.d e2 = e(q.a(cVar, annotation.getId()));
        Map z = t0.z();
        if (annotation.getArgumentCount() != 0 && !h.p2.b0.g.t.n.s.r(e2) && h.p2.b0.g.t.k.c.t(e2) && (cVar2 = (h.p2.b0.g.t.c.c) CollectionsKt___CollectionsKt.V4(e2.g())) != null) {
            List<v0> h2 = cVar2.h();
            LinkedHashMap linkedHashMap = new LinkedHashMap(h.o2.q.n(s0.j(h.a2.u.Y(h2, 10)), 16));
            for (Object obj : h2) {
                linkedHashMap.put(((v0) obj).getName(), obj);
            }
            List<ProtoBuf.Annotation.Argument> argumentList = annotation.getArgumentList();
            ArrayList arrayList = new ArrayList();
            for (ProtoBuf.Annotation.Argument argument : argumentList) {
                Pair<h.p2.b0.g.t.g.f, h.p2.b0.g.t.k.n.g<?>> d2 = d(argument, linkedHashMap, cVar);
                if (d2 != null) {
                    arrayList.add(d2);
                }
            }
            z = t0.B0(arrayList);
        }
        return new h.p2.b0.g.t.c.b1.d(e2.r(), z, o0.a);
    }

    @k.e.a.d
    public final h.p2.b0.g.t.k.n.g<?> f(@k.e.a.d h.p2.b0.g.t.n.z zVar, @k.e.a.d ProtoBuf.Annotation.Argument.Value value, @k.e.a.d h.p2.b0.g.t.f.z.c cVar) {
        h.p2.b0.g.t.k.n.g<?> dVar;
        boolean booleanValue = h.p2.b0.g.t.f.z.b.O.d(value.getFlags()).booleanValue();
        ProtoBuf.Annotation.Argument.Value.Type type = value.getType();
        switch (type == null ? -1 : a.a[type.ordinal()]) {
            case 1:
                byte intValue = (byte) value.getIntValue();
                if (booleanValue) {
                    dVar = new h.p2.b0.g.t.k.n.u(intValue);
                    break;
                } else {
                    dVar = new h.p2.b0.g.t.k.n.d(intValue);
                    break;
                }
            case 2:
                return new h.p2.b0.g.t.k.n.e((char) value.getIntValue());
            case 3:
                short intValue2 = (short) value.getIntValue();
                if (booleanValue) {
                    dVar = new x(intValue2);
                    break;
                } else {
                    dVar = new h.p2.b0.g.t.k.n.s(intValue2);
                    break;
                }
            case 4:
                int intValue3 = (int) value.getIntValue();
                return booleanValue ? new h.p2.b0.g.t.k.n.v(intValue3) : new h.p2.b0.g.t.k.n.l(intValue3);
            case 5:
                long intValue4 = value.getIntValue();
                return booleanValue ? new w(intValue4) : new h.p2.b0.g.t.k.n.p(intValue4);
            case 6:
                return new h.p2.b0.g.t.k.n.k(value.getFloatValue());
            case 7:
                return new h.p2.b0.g.t.k.n.h(value.getDoubleValue());
            case 8:
                return new h.p2.b0.g.t.k.n.c(value.getIntValue() != 0);
            case 9:
                return new h.p2.b0.g.t.k.n.t(cVar.getString(value.getStringValue()));
            case 10:
                return new h.p2.b0.g.t.k.n.o(q.a(cVar, value.getClassId()), value.getArrayDimensionCount());
            case 11:
                return new h.p2.b0.g.t.k.n.i(q.a(cVar, value.getClassId()), q.b(cVar, value.getEnumValueId()));
            case 12:
                return new h.p2.b0.g.t.k.n.a(a(value.getAnnotation(), cVar));
            case 13:
                ConstantValueFactory constantValueFactory = ConstantValueFactory.a;
                List<ProtoBuf.Annotation.Argument.Value> arrayElementList = value.getArrayElementList();
                ArrayList arrayList = new ArrayList(h.a2.u.Y(arrayElementList, 10));
                for (ProtoBuf.Annotation.Argument.Value value2 : arrayElementList) {
                    arrayList.add(f(c().i(), value2, cVar));
                }
                return constantValueFactory.b(arrayList, zVar);
            default:
                throw new IllegalStateException(("Unsupported annotation argument type: " + value.getType() + " (expected " + zVar + ')').toString());
        }
        return dVar;
    }
}
