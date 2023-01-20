package h.k2.v;

import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import h.z0;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.reflect.KVisibility;
import kotlin.text.StringsKt__StringsKt;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 O2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001OB\u0011\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010F\u001a\u00020\u00122\b\u0010G\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010H\u001a\u00020IH\u0002J\b\u0010J\u001a\u00020KH\u0016J\u0012\u0010L\u001a\u00020\u00122\b\u0010M\u001a\u0004\u0018\u00010\u0002H\u0017J\b\u0010N\u001a\u000201H\u0016R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR \u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000e0\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0016\u0010\u0015R\u001a\u0010\u0018\u001a\u00020\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u0018\u0010\u0015R\u001a\u0010\u001a\u001a\u00020\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u001a\u0010\u0015R\u001a\u0010\u001c\u001a\u00020\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u0014\u001a\u0004\b\u001c\u0010\u0015R\u001a\u0010\u001e\u001a\u00020\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0014\u001a\u0004\b\u001e\u0010\u0015R\u001a\u0010 \u001a\u00020\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\b!\u0010\u0014\u001a\u0004\b \u0010\u0015R\u001a\u0010\"\u001a\u00020\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\b#\u0010\u0014\u001a\u0004\b\"\u0010\u0015R\u001a\u0010$\u001a\u00020\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\b%\u0010\u0014\u001a\u0004\b$\u0010\u0015R\u0018\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u001e\u0010(\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030)0\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\u0010R\u001e\u0010+\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\u0010R\u0016\u0010-\u001a\u0004\u0018\u00010\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0016\u00100\u001a\u0004\u0018\u0001018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b2\u00103R(\u00104\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00010\b8VX\u0097\u0004¢\u0006\f\u0012\u0004\b5\u0010\u0014\u001a\u0004\b6\u0010\u000bR\u0016\u00107\u001a\u0004\u0018\u0001018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b8\u00103R \u00109\u001a\b\u0012\u0004\u0012\u00020:0\b8VX\u0097\u0004¢\u0006\f\u0012\u0004\b;\u0010\u0014\u001a\u0004\b<\u0010\u000bR \u0010=\u001a\b\u0012\u0004\u0012\u00020>0\b8VX\u0097\u0004¢\u0006\f\u0012\u0004\b?\u0010\u0014\u001a\u0004\b@\u0010\u000bR\u001c\u0010A\u001a\u0004\u0018\u00010B8VX\u0097\u0004¢\u0006\f\u0012\u0004\bC\u0010\u0014\u001a\u0004\bD\u0010E¨\u0006P"}, d2 = {"Lkotlin/jvm/internal/ClassReference;", "Lkotlin/reflect/KClass;", "", "Lkotlin/jvm/internal/ClassBasedDeclarationContainer;", "jClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "constructors", "", "Lkotlin/reflect/KFunction;", "getConstructors", "()Ljava/util/Collection;", "isAbstract", "", "isAbstract$annotations", "()V", "()Z", "isCompanion", "isCompanion$annotations", "isData", "isData$annotations", "isFinal", "isFinal$annotations", "isFun", "isFun$annotations", "isInner", "isInner$annotations", "isOpen", "isOpen$annotations", "isSealed", "isSealed$annotations", "isValue", "isValue$annotations", "getJClass", "()Ljava/lang/Class;", "members", "Lkotlin/reflect/KCallable;", "getMembers", "nestedClasses", "getNestedClasses", "objectInstance", "getObjectInstance", "()Ljava/lang/Object;", "qualifiedName", "", "getQualifiedName", "()Ljava/lang/String;", "sealedSubclasses", "getSealedSubclasses$annotations", "getSealedSubclasses", "simpleName", "getSimpleName", "supertypes", "Lkotlin/reflect/KType;", "getSupertypes$annotations", "getSupertypes", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters$annotations", "getTypeParameters", "visibility", "Lkotlin/reflect/KVisibility;", "getVisibility$annotations", "getVisibility", "()Lkotlin/reflect/KVisibility;", "equals", "other", com.umeng.analytics.pro.d.O, "", TTDownloadField.TT_HASHCODE, "", "isInstance", "value", "toString", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class s implements h.p2.d<Object>, r {
    private static final Map<Class<? extends h.r<?>>, Integer> b;

    /* renamed from: c  reason: collision with root package name */
    private static final HashMap<String, String> f14929c;

    /* renamed from: d  reason: collision with root package name */
    private static final HashMap<String, String> f14930d;

    /* renamed from: e  reason: collision with root package name */
    private static final HashMap<String, String> f14931e;

    /* renamed from: f  reason: collision with root package name */
    private static final Map<String, String> f14932f;
    @k.e.a.d

    /* renamed from: g  reason: collision with root package name */
    public static final a f14933g = new a(null);
    @k.e.a.d
    private final Class<?> a;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\n2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0005J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\n2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0005J\u001c\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00012\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0005R&\u0010\u0003\u001a\u001a\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lkotlin/jvm/internal/ClassReference$Companion;", "", "()V", "FUNCTION_CLASSES", "", "Ljava/lang/Class;", "Lkotlin/Function;", "", "classFqNames", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "primitiveFqNames", "primitiveWrapperFqNames", "simpleNames", "getClassQualifiedName", "jClass", "getClassSimpleName", "isInstance", "", "value", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        @k.e.a.e
        public final String a(@k.e.a.d Class<?> cls) {
            String str;
            String str2 = null;
            if (cls.isAnonymousClass() || cls.isLocalClass()) {
                return null;
            }
            if (!cls.isArray()) {
                String str3 = (String) s.f14931e.get(cls.getName());
                return str3 != null ? str3 : cls.getCanonicalName();
            }
            Class<?> componentType = cls.getComponentType();
            if (componentType.isPrimitive() && (str = (String) s.f14931e.get(componentType.getName())) != null) {
                str2 = str + "Array";
            }
            return str2 != null ? str2 : "kotlin.Array";
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0036, code lost:
            if (r1 != null) goto L12;
         */
        @k.e.a.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.String b(@k.e.a.d java.lang.Class<?> r7) {
            /*
                r6 = this;
                boolean r0 = r7.isAnonymousClass()
                java.lang.String r1 = "Array"
                r2 = 0
                if (r0 == 0) goto Lc
            L9:
                r1 = r2
                goto Lac
            Lc:
                boolean r0 = r7.isLocalClass()
                if (r0 == 0) goto L63
                java.lang.String r0 = r7.getSimpleName()
                java.lang.reflect.Method r1 = r7.getEnclosingMethod()
                java.lang.String r3 = "$"
                r4 = 2
                if (r1 == 0) goto L39
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.lang.String r1 = r1.getName()
                r5.append(r1)
                r5.append(r3)
                java.lang.String r1 = r5.toString()
                java.lang.String r1 = kotlin.text.StringsKt__StringsKt.m5(r0, r1, r2, r4, r2)
                if (r1 == 0) goto L39
                goto L59
            L39:
                java.lang.reflect.Constructor r7 = r7.getEnclosingConstructor()
                if (r7 == 0) goto L58
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r7 = r7.getName()
                r1.append(r7)
                r1.append(r3)
                java.lang.String r7 = r1.toString()
                java.lang.String r7 = kotlin.text.StringsKt__StringsKt.m5(r0, r7, r2, r4, r2)
                r1 = r7
                goto L59
            L58:
                r1 = r2
            L59:
                if (r1 == 0) goto L5c
                goto Lac
            L5c:
                r7 = 36
                java.lang.String r1 = kotlin.text.StringsKt__StringsKt.l5(r0, r7, r2, r4, r2)
                goto Lac
            L63:
                boolean r0 = r7.isArray()
                if (r0 == 0) goto L96
                java.lang.Class r7 = r7.getComponentType()
                boolean r0 = r7.isPrimitive()
                if (r0 == 0) goto L92
                java.util.Map r0 = h.k2.v.s.r()
                java.lang.String r7 = r7.getName()
                java.lang.Object r7 = r0.get(r7)
                java.lang.String r7 = (java.lang.String) r7
                if (r7 == 0) goto L92
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                r0.append(r7)
                r0.append(r1)
                java.lang.String r2 = r0.toString()
            L92:
                if (r2 == 0) goto Lac
                goto L9
            L96:
                java.util.Map r0 = h.k2.v.s.r()
                java.lang.String r1 = r7.getName()
                java.lang.Object r0 = r0.get(r1)
                r1 = r0
                java.lang.String r1 = (java.lang.String) r1
                if (r1 == 0) goto La8
                goto Lac
            La8:
                java.lang.String r1 = r7.getSimpleName()
            Lac:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: h.k2.v.s.a.b(java.lang.Class):java.lang.String");
        }

        public final boolean c(@k.e.a.e Object obj, @k.e.a.d Class<?> cls) {
            Map map = s.b;
            Objects.requireNonNull(map, "null cannot be cast to non-null type kotlin.collections.Map<K, V>");
            Integer num = (Integer) map.get(cls);
            if (num != null) {
                return t0.B(obj, num.intValue());
            }
            if (cls.isPrimitive()) {
                cls = h.k2.a.e(h.k2.a.g(cls));
            }
            return cls.isInstance(obj);
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        int i2 = 0;
        List L = CollectionsKt__CollectionsKt.L(h.k2.u.a.class, h.k2.u.l.class, h.k2.u.p.class, h.k2.u.q.class, h.k2.u.r.class, h.k2.u.s.class, h.k2.u.t.class, h.k2.u.u.class, h.k2.u.v.class, h.k2.u.w.class, h.k2.u.b.class, h.k2.u.c.class, h.k2.u.d.class, h.k2.u.e.class, h.k2.u.f.class, h.k2.u.g.class, h.k2.u.h.class, h.k2.u.i.class, h.k2.u.j.class, h.k2.u.k.class, h.k2.u.m.class, h.k2.u.n.class, h.k2.u.o.class);
        ArrayList arrayList = new ArrayList(h.a2.u.Y(L, 10));
        for (Object obj : L) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.W();
            }
            arrayList.add(z0.a((Class) obj, Integer.valueOf(i2)));
            i2 = i3;
        }
        b = h.a2.t0.B0(arrayList);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("boolean", "kotlin.Boolean");
        hashMap.put("char", "kotlin.Char");
        hashMap.put("byte", "kotlin.Byte");
        hashMap.put("short", "kotlin.Short");
        hashMap.put(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL, "kotlin.Int");
        hashMap.put("float", "kotlin.Float");
        hashMap.put("long", "kotlin.Long");
        hashMap.put("double", "kotlin.Double");
        f14929c = hashMap;
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put("java.lang.Boolean", "kotlin.Boolean");
        hashMap2.put("java.lang.Character", "kotlin.Char");
        hashMap2.put("java.lang.Byte", "kotlin.Byte");
        hashMap2.put("java.lang.Short", "kotlin.Short");
        hashMap2.put("java.lang.Integer", "kotlin.Int");
        hashMap2.put("java.lang.Float", "kotlin.Float");
        hashMap2.put("java.lang.Long", "kotlin.Long");
        hashMap2.put("java.lang.Double", "kotlin.Double");
        f14930d = hashMap2;
        HashMap<String, String> hashMap3 = new HashMap<>();
        hashMap3.put("java.lang.Object", "kotlin.Any");
        hashMap3.put("java.lang.String", "kotlin.String");
        hashMap3.put("java.lang.CharSequence", "kotlin.CharSequence");
        hashMap3.put("java.lang.Throwable", "kotlin.Throwable");
        hashMap3.put("java.lang.Cloneable", "kotlin.Cloneable");
        hashMap3.put("java.lang.Number", "kotlin.Number");
        hashMap3.put("java.lang.Comparable", "kotlin.Comparable");
        hashMap3.put("java.lang.Enum", "kotlin.Enum");
        hashMap3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        hashMap3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        hashMap3.put("java.util.Iterator", "kotlin.collections.Iterator");
        hashMap3.put("java.util.Collection", "kotlin.collections.Collection");
        hashMap3.put("java.util.List", "kotlin.collections.List");
        hashMap3.put("java.util.Set", "kotlin.collections.Set");
        hashMap3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        hashMap3.put("java.util.Map", "kotlin.collections.Map");
        hashMap3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        hashMap3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        hashMap3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        hashMap3.putAll(hashMap);
        hashMap3.putAll(hashMap2);
        for (String str : hashMap.values()) {
            Pair a2 = z0.a("kotlin.jvm.internal." + StringsKt__StringsKt.p5(str, '.', null, 2, null) + "CompanionObject", str + ".Companion");
            hashMap3.put(a2.getFirst(), a2.getSecond());
        }
        for (Map.Entry<Class<? extends h.r<?>>, Integer> entry : b.entrySet()) {
            hashMap3.put(entry.getKey().getName(), "kotlin.Function" + entry.getValue().intValue());
        }
        f14931e = hashMap3;
        LinkedHashMap linkedHashMap = new LinkedHashMap(h.a2.s0.j(hashMap3.size()));
        for (Map.Entry entry2 : hashMap3.entrySet()) {
            linkedHashMap.put(entry2.getKey(), StringsKt__StringsKt.p5((String) entry2.getValue(), '.', null, 2, null));
        }
        f14932f = linkedHashMap;
    }

    public s(@k.e.a.d Class<?> cls) {
        this.a = cls;
    }

    @h.s0(version = "1.1")
    public static /* synthetic */ void F() {
    }

    @h.s0(version = "1.1")
    public static /* synthetic */ void G() {
    }

    @h.s0(version = "1.1")
    public static /* synthetic */ void H() {
    }

    @h.s0(version = "1.1")
    public static /* synthetic */ void I() {
    }

    @h.s0(version = "1.1")
    public static /* synthetic */ void J() {
    }

    @h.s0(version = "1.1")
    public static /* synthetic */ void K() {
    }

    @h.s0(version = "1.1")
    public static /* synthetic */ void L() {
    }

    @h.s0(version = "1.4")
    public static /* synthetic */ void M() {
    }

    @h.s0(version = "1.1")
    public static /* synthetic */ void N() {
    }

    @h.s0(version = "1.1")
    public static /* synthetic */ void O() {
    }

    @h.s0(version = "1.1")
    public static /* synthetic */ void P() {
    }

    @h.s0(version = "1.5")
    public static /* synthetic */ void Q() {
    }

    private final Void t() {
        throw new KotlinReflectionNotSupportedError();
    }

    @h.s0(version = "1.3")
    public static /* synthetic */ void x() {
    }

    @Override // h.p2.d
    @k.e.a.e
    public Object A() {
        t();
        throw new KotlinNothingValueException();
    }

    @Override // h.p2.d
    public boolean B() {
        t();
        throw new KotlinNothingValueException();
    }

    @Override // h.p2.d
    @h.s0(version = "1.1")
    public boolean C(@k.e.a.e Object obj) {
        return f14933g.c(obj, d());
    }

    @Override // h.p2.d
    @k.e.a.e
    public String D() {
        return f14933g.a(d());
    }

    @Override // h.p2.d
    @k.e.a.e
    public String E() {
        return f14933g.b(d());
    }

    @Override // h.k2.v.r
    @k.e.a.d
    public Class<?> d() {
        return this.a;
    }

    @Override // h.p2.d
    public boolean equals(@k.e.a.e Object obj) {
        return (obj instanceof s) && f0.g(h.k2.a.e(this), h.k2.a.e((h.p2.d) obj));
    }

    @Override // h.p2.d
    @k.e.a.d
    public Collection<h.p2.i<Object>> g() {
        t();
        throw new KotlinNothingValueException();
    }

    @Override // h.p2.b
    @k.e.a.d
    public List<Annotation> getAnnotations() {
        t();
        throw new KotlinNothingValueException();
    }

    @Override // h.p2.d
    @k.e.a.d
    public List<h.p2.s> getTypeParameters() {
        t();
        throw new KotlinNothingValueException();
    }

    @Override // h.p2.d
    @k.e.a.e
    public KVisibility getVisibility() {
        t();
        throw new KotlinNothingValueException();
    }

    @Override // h.p2.d
    public int hashCode() {
        return h.k2.a.e(this).hashCode();
    }

    @Override // h.p2.d
    public boolean isAbstract() {
        t();
        throw new KotlinNothingValueException();
    }

    @Override // h.p2.d
    public boolean isFinal() {
        t();
        throw new KotlinNothingValueException();
    }

    @Override // h.p2.d
    public boolean isOpen() {
        t();
        throw new KotlinNothingValueException();
    }

    @Override // h.p2.d
    @k.e.a.d
    public List<h.p2.r> j() {
        t();
        throw new KotlinNothingValueException();
    }

    @Override // h.p2.d
    @k.e.a.d
    public List<h.p2.d<? extends Object>> m() {
        t();
        throw new KotlinNothingValueException();
    }

    @Override // h.p2.d
    public boolean n() {
        t();
        throw new KotlinNothingValueException();
    }

    @Override // h.p2.d
    public boolean p() {
        t();
        throw new KotlinNothingValueException();
    }

    @Override // h.p2.d, h.p2.h
    @k.e.a.d
    public Collection<h.p2.c<?>> q() {
        t();
        throw new KotlinNothingValueException();
    }

    @k.e.a.d
    public String toString() {
        return d().toString() + n0.b;
    }

    @Override // h.p2.d
    public boolean v() {
        t();
        throw new KotlinNothingValueException();
    }

    @Override // h.p2.d
    public boolean w() {
        t();
        throw new KotlinNothingValueException();
    }

    @Override // h.p2.d
    public boolean y() {
        t();
        throw new KotlinNothingValueException();
    }

    @Override // h.p2.d
    @k.e.a.d
    public Collection<h.p2.d<?>> z() {
        t();
        throw new KotlinNothingValueException();
    }
}
