package kotlin.reflect.jvm.internal.impl.load.java;

import h.a2.d1;
import h.a2.e1;
import h.a2.s0;
import h.a2.t0;
import h.k2.v.f0;
import h.k2.v.u;
import h.p2.b0.g.t.g.f;
import h.z0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import k.e.a.d;
import k.e.a.e;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* loaded from: classes3.dex */
public class SpecialGenericSignatures {
    @d
    public static final a a = new a(null);
    @d
    private static final List<a.C0494a> b;
    @d

    /* renamed from: c */
    private static final List<String> f16480c;
    @d

    /* renamed from: d */
    private static final List<String> f16481d;
    @d

    /* renamed from: e */
    private static final Map<a.C0494a, TypeSafeBarrierDescription> f16482e;
    @d

    /* renamed from: f */
    private static final Map<String, TypeSafeBarrierDescription> f16483f;
    @d

    /* renamed from: g */
    private static final Set<f> f16484g;
    @d

    /* renamed from: h */
    private static final Set<String> f16485h;
    @d

    /* renamed from: i */
    private static final a.C0494a f16486i;
    @d

    /* renamed from: j */
    private static final Map<a.C0494a, f> f16487j;
    @d

    /* renamed from: k */
    private static final Map<String, f> f16488k;
    @d

    /* renamed from: l */
    private static final List<f> f16489l;
    @d

    /* renamed from: m */
    private static final Map<f, List<f>> f16490m;

    /* loaded from: classes3.dex */
    public enum SpecialSignatureInfo {
        ONE_COLLECTION_PARAMETER("Ljava/util/Collection<+Ljava/lang/Object;>;", false),
        OBJECT_PARAMETER_NON_GENERIC(null, true),
        OBJECT_PARAMETER_GENERIC("Ljava/lang/Object;", true);
        
        private final boolean isObjectReplacedWithTypeParameter;
        @e
        private final String valueParametersSignature;

        SpecialSignatureInfo(String str, boolean z) {
            this.valueParametersSignature = str;
            this.isObjectReplacedWithTypeParameter = z;
        }
    }

    /* loaded from: classes3.dex */
    public static final class TypeSafeBarrierDescription {
        @e
        private final Object defaultValue;
        public static final TypeSafeBarrierDescription NULL = new TypeSafeBarrierDescription("NULL", 0, null);
        public static final TypeSafeBarrierDescription INDEX = new TypeSafeBarrierDescription("INDEX", 1, -1);
        public static final TypeSafeBarrierDescription FALSE = new TypeSafeBarrierDescription("FALSE", 2, Boolean.FALSE);
        public static final TypeSafeBarrierDescription MAP_GET_OR_DEFAULT = new MAP_GET_OR_DEFAULT("MAP_GET_OR_DEFAULT", 3);
        private static final /* synthetic */ TypeSafeBarrierDescription[] $VALUES = $values();

        /* loaded from: classes3.dex */
        public static final class MAP_GET_OR_DEFAULT extends TypeSafeBarrierDescription {
            public MAP_GET_OR_DEFAULT(String str, int i2) {
                super(str, i2, null, null);
            }
        }

        private static final /* synthetic */ TypeSafeBarrierDescription[] $values() {
            return new TypeSafeBarrierDescription[]{NULL, INDEX, FALSE, MAP_GET_OR_DEFAULT};
        }

        private TypeSafeBarrierDescription(String str, int i2, Object obj) {
            super(str, i2);
            this.defaultValue = obj;
        }

        public /* synthetic */ TypeSafeBarrierDescription(String str, int i2, Object obj, u uVar) {
            this(str, i2, obj);
        }

        public static TypeSafeBarrierDescription valueOf(String str) {
            return (TypeSafeBarrierDescription) Enum.valueOf(TypeSafeBarrierDescription.class, str);
        }

        public static TypeSafeBarrierDescription[] values() {
            return (TypeSafeBarrierDescription[]) $VALUES.clone();
        }
    }

    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures$a$a */
        /* loaded from: classes3.dex */
        public static final class C0494a {
            @d
            private final f a;
            @d
            private final String b;

            public C0494a(@d f fVar, @d String str) {
                this.a = fVar;
                this.b = str;
            }

            @d
            public final f a() {
                return this.a;
            }

            @d
            public final String b() {
                return this.b;
            }

            public boolean equals(@e Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof C0494a) {
                    C0494a c0494a = (C0494a) obj;
                    return f0.g(this.a, c0494a.a) && f0.g(this.b, c0494a.b);
                }
                return false;
            }

            public int hashCode() {
                return (this.a.hashCode() * 31) + this.b.hashCode();
            }

            @d
            public String toString() {
                return "NameAndSignature(name=" + this.a + ", signature=" + this.b + ')';
            }
        }

        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        public final C0494a m(String str, String str2, String str3, String str4) {
            f f2 = f.f(str2);
            SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.a;
            return new C0494a(f2, signatureBuildingComponents.k(str, str2 + '(' + str3 + ')' + str4));
        }

        @d
        public final List<f> b(@d f fVar) {
            List<f> list = f().get(fVar);
            return list == null ? CollectionsKt__CollectionsKt.E() : list;
        }

        @d
        public final List<String> c() {
            return SpecialGenericSignatures.f16480c;
        }

        @d
        public final Set<f> d() {
            return SpecialGenericSignatures.f16484g;
        }

        @d
        public final Set<String> e() {
            return SpecialGenericSignatures.f16485h;
        }

        @d
        public final Map<f, List<f>> f() {
            return SpecialGenericSignatures.f16490m;
        }

        @d
        public final List<f> g() {
            return SpecialGenericSignatures.f16489l;
        }

        @d
        public final C0494a h() {
            return SpecialGenericSignatures.f16486i;
        }

        @d
        public final Map<String, TypeSafeBarrierDescription> i() {
            return SpecialGenericSignatures.f16483f;
        }

        @d
        public final Map<String, f> j() {
            return SpecialGenericSignatures.f16488k;
        }

        public final boolean k(@d f fVar) {
            return g().contains(fVar);
        }

        @d
        public final SpecialSignatureInfo l(@d String str) {
            if (c().contains(str)) {
                return SpecialSignatureInfo.ONE_COLLECTION_PARAMETER;
            }
            if (((TypeSafeBarrierDescription) t0.K(i(), str)) == TypeSafeBarrierDescription.NULL) {
                return SpecialSignatureInfo.OBJECT_PARAMETER_GENERIC;
            }
            return SpecialSignatureInfo.OBJECT_PARAMETER_NON_GENERIC;
        }
    }

    static {
        Set<String> u = d1.u("containsAll", "removeAll", "retainAll");
        ArrayList<a.C0494a> arrayList = new ArrayList(h.a2.u.Y(u, 10));
        for (String str : u) {
            arrayList.add(a.m("java/util/Collection", str, "Ljava/util/Collection;", JvmPrimitiveType.BOOLEAN.getDesc()));
        }
        b = arrayList;
        ArrayList arrayList2 = new ArrayList(h.a2.u.Y(arrayList, 10));
        for (a.C0494a c0494a : arrayList) {
            arrayList2.add(c0494a.b());
        }
        f16480c = arrayList2;
        List<a.C0494a> list = b;
        ArrayList arrayList3 = new ArrayList(h.a2.u.Y(list, 10));
        for (a.C0494a c0494a2 : list) {
            arrayList3.add(c0494a2.a().b());
        }
        f16481d = arrayList3;
        SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.a;
        a aVar = a;
        String i2 = signatureBuildingComponents.i("Collection");
        JvmPrimitiveType jvmPrimitiveType = JvmPrimitiveType.BOOLEAN;
        a.C0494a m2 = aVar.m(i2, "contains", "Ljava/lang/Object;", jvmPrimitiveType.getDesc());
        TypeSafeBarrierDescription typeSafeBarrierDescription = TypeSafeBarrierDescription.FALSE;
        a.C0494a m3 = aVar.m(signatureBuildingComponents.i("Map"), "get", "Ljava/lang/Object;", "Ljava/lang/Object;");
        TypeSafeBarrierDescription typeSafeBarrierDescription2 = TypeSafeBarrierDescription.NULL;
        String i3 = signatureBuildingComponents.i("List");
        JvmPrimitiveType jvmPrimitiveType2 = JvmPrimitiveType.INT;
        a.C0494a m4 = aVar.m(i3, "indexOf", "Ljava/lang/Object;", jvmPrimitiveType2.getDesc());
        TypeSafeBarrierDescription typeSafeBarrierDescription3 = TypeSafeBarrierDescription.INDEX;
        Map<a.C0494a, TypeSafeBarrierDescription> W = t0.W(z0.a(m2, typeSafeBarrierDescription), z0.a(aVar.m(signatureBuildingComponents.i("Collection"), "remove", "Ljava/lang/Object;", jvmPrimitiveType.getDesc()), typeSafeBarrierDescription), z0.a(aVar.m(signatureBuildingComponents.i("Map"), "containsKey", "Ljava/lang/Object;", jvmPrimitiveType.getDesc()), typeSafeBarrierDescription), z0.a(aVar.m(signatureBuildingComponents.i("Map"), "containsValue", "Ljava/lang/Object;", jvmPrimitiveType.getDesc()), typeSafeBarrierDescription), z0.a(aVar.m(signatureBuildingComponents.i("Map"), "remove", "Ljava/lang/Object;Ljava/lang/Object;", jvmPrimitiveType.getDesc()), typeSafeBarrierDescription), z0.a(aVar.m(signatureBuildingComponents.i("Map"), "getOrDefault", "Ljava/lang/Object;Ljava/lang/Object;", "Ljava/lang/Object;"), TypeSafeBarrierDescription.MAP_GET_OR_DEFAULT), z0.a(m3, typeSafeBarrierDescription2), z0.a(aVar.m(signatureBuildingComponents.i("Map"), "remove", "Ljava/lang/Object;", "Ljava/lang/Object;"), typeSafeBarrierDescription2), z0.a(m4, typeSafeBarrierDescription3), z0.a(aVar.m(signatureBuildingComponents.i("List"), "lastIndexOf", "Ljava/lang/Object;", jvmPrimitiveType2.getDesc()), typeSafeBarrierDescription3));
        f16482e = W;
        LinkedHashMap linkedHashMap = new LinkedHashMap(s0.j(W.size()));
        Iterator<T> it = W.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(((a.C0494a) entry.getKey()).b(), entry.getValue());
        }
        f16483f = linkedHashMap;
        Set<a.C0494a> C = e1.C(f16482e.keySet(), b);
        ArrayList arrayList4 = new ArrayList(h.a2.u.Y(C, 10));
        for (a.C0494a c0494a3 : C) {
            arrayList4.add(c0494a3.a());
        }
        f16484g = CollectionsKt___CollectionsKt.N5(arrayList4);
        ArrayList arrayList5 = new ArrayList(h.a2.u.Y(C, 10));
        for (a.C0494a c0494a4 : C) {
            arrayList5.add(c0494a4.b());
        }
        f16485h = CollectionsKt___CollectionsKt.N5(arrayList5);
        a aVar2 = a;
        JvmPrimitiveType jvmPrimitiveType3 = JvmPrimitiveType.INT;
        a.C0494a m5 = aVar2.m("java/util/List", "removeAt", jvmPrimitiveType3.getDesc(), "Ljava/lang/Object;");
        f16486i = m5;
        SignatureBuildingComponents signatureBuildingComponents2 = SignatureBuildingComponents.a;
        Map<a.C0494a, f> W2 = t0.W(z0.a(aVar2.m(signatureBuildingComponents2.h("Number"), "toByte", "", JvmPrimitiveType.BYTE.getDesc()), f.f("byteValue")), z0.a(aVar2.m(signatureBuildingComponents2.h("Number"), "toShort", "", JvmPrimitiveType.SHORT.getDesc()), f.f("shortValue")), z0.a(aVar2.m(signatureBuildingComponents2.h("Number"), "toInt", "", jvmPrimitiveType3.getDesc()), f.f("intValue")), z0.a(aVar2.m(signatureBuildingComponents2.h("Number"), "toLong", "", JvmPrimitiveType.LONG.getDesc()), f.f("longValue")), z0.a(aVar2.m(signatureBuildingComponents2.h("Number"), "toFloat", "", JvmPrimitiveType.FLOAT.getDesc()), f.f("floatValue")), z0.a(aVar2.m(signatureBuildingComponents2.h("Number"), "toDouble", "", JvmPrimitiveType.DOUBLE.getDesc()), f.f("doubleValue")), z0.a(m5, f.f("remove")), z0.a(aVar2.m(signatureBuildingComponents2.h("CharSequence"), "get", jvmPrimitiveType3.getDesc(), JvmPrimitiveType.CHAR.getDesc()), f.f("charAt")));
        f16487j = W2;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(s0.j(W2.size()));
        Iterator<T> it2 = W2.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it2.next();
            linkedHashMap2.put(((a.C0494a) entry2.getKey()).b(), entry2.getValue());
        }
        f16488k = linkedHashMap2;
        Set<a.C0494a> keySet = f16487j.keySet();
        ArrayList arrayList6 = new ArrayList(h.a2.u.Y(keySet, 10));
        for (a.C0494a c0494a5 : keySet) {
            arrayList6.add(c0494a5.a());
        }
        f16489l = arrayList6;
        Set<Map.Entry<a.C0494a, f>> entrySet = f16487j.entrySet();
        ArrayList<Pair> arrayList7 = new ArrayList(h.a2.u.Y(entrySet, 10));
        Iterator<T> it3 = entrySet.iterator();
        while (it3.hasNext()) {
            Map.Entry entry3 = (Map.Entry) it3.next();
            arrayList7.add(new Pair(((a.C0494a) entry3.getKey()).a(), entry3.getValue()));
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        for (Pair pair : arrayList7) {
            f fVar = (f) pair.getSecond();
            Object obj = linkedHashMap3.get(fVar);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap3.put(fVar, obj);
            }
            ((List) obj).add((f) pair.getFirst());
        }
        f16490m = linkedHashMap3;
    }
}
