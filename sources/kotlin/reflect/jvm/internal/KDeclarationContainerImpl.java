package kotlin.reflect.jvm.internal;

import com.moor.imkf.lib.jsoup.nodes.Attributes;
import com.tencent.android.tpush.common.MessageKey;
import h.a2.s0;
import h.k2.v.f0;
import h.k2.v.n0;
import h.k2.v.r;
import h.k2.v.u;
import h.p2.b0.g.l;
import h.p2.b0.g.o;
import h.p2.b0.g.q;
import h.p2.b0.g.t.c.f1.a.e;
import h.p2.b0.g.t.c.f1.a.k;
import h.p2.b0.g.t.c.j;
import h.p2.b0.g.t.c.j0;
import h.p2.b0.g.t.c.s;
import h.p2.b0.g.t.c.v;
import h.p2.b0.g.t.g.f;
import h.p2.n;
import h.t1;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\n\b \u0018\u0000 <2\u00020\u0001:\u0003<=>B\u0005¢\u0006\u0002\u0010\u0002J*\u0010\f\u001a\u00020\r2\u0010\u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0014\u0010\u0014\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00152\u0006\u0010\u0010\u001a\u00020\u0011J\u0014\u0010\u0016\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00152\u0006\u0010\u0010\u001a\u00020\u0011J \u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0013J\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u0011J\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u0011J\u0016\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00042\u0006\u0010\u0019\u001a\u00020\"H&J\u0012\u0010#\u001a\u0004\u0018\u00010 2\u0006\u0010$\u001a\u00020%H&J\"\u0010&\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030'0\u00042\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0004J\u0016\u0010,\u001a\b\u0012\u0004\u0012\u00020 0\u00042\u0006\u0010\u0019\u001a\u00020\"H&J\u001a\u0010-\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0.2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0014\u0010/\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J$\u00100\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u00101\u001a\u00020%2\u0006\u00102\u001a\u00020%H\u0002JE\u00103\u001a\u0004\u0018\u00010\u0018*\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u0019\u001a\u00020\u00112\u0010\u00104\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t052\n\u00106\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u00107\u001a\u00020\u0013H\u0002¢\u0006\u0002\u00108J(\u00109\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0015*\u0006\u0012\u0002\b\u00030\t2\u0010\u00104\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0.H\u0002J=\u0010:\u001a\u0004\u0018\u00010\u0018*\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u0019\u001a\u00020\u00112\u0010\u00104\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t052\n\u00106\u001a\u0006\u0012\u0002\b\u00030\tH\u0002¢\u0006\u0002\u0010;R\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0006\u0012\u0002\b\u00030\t8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006?"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Lkotlin/jvm/internal/ClassBasedDeclarationContainer;", "()V", "constructorDescriptors", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "()Ljava/util/Collection;", "methodOwner", "Ljava/lang/Class;", "getMethodOwner", "()Ljava/lang/Class;", "addParametersAndMasks", "", "result", "", "desc", "", "isConstructor", "", "findConstructorBySignature", "Ljava/lang/reflect/Constructor;", "findDefaultConstructor", "findDefaultMethod", "Ljava/lang/reflect/Method;", "name", "isMember", "findFunctionDescriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "signature", "findMethodBySignature", "findPropertyDescriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "getFunctions", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "getLocalProperty", "index", "", "getMembers", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "scope", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "belonginess", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$MemberBelonginess;", "getProperties", "loadParameterTypes", "", "loadReturnType", "parseType", "begin", MessageKey.MSG_ACCEPT_TIME_END, "lookupMethod", "parameterTypes", "", "returnType", "isStaticDefault", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;Ljava/lang/Class;Z)Ljava/lang/reflect/Method;", "tryGetConstructor", "tryGetMethod", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;Ljava/lang/Class;)Ljava/lang/reflect/Method;", "Companion", "Data", "MemberBelonginess", "kotlin-reflection"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public abstract class KDeclarationContainerImpl implements r {
    @d

    /* renamed from: c */
    public static final a f16349c = new a(null);
    private static final Class<?> a = Class.forName("h.k2.v.u");
    @d
    private static final Regex b = new Regex("<v#(\\d+)>");

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b¦\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Data;", "", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;)V", "moduleData", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/RuntimeModuleData;", "getModuleData", "()Lorg/jetbrains/kotlin/descriptors/runtime/components/RuntimeModuleData;", "moduleData$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "kotlin-reflection"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public abstract class Data {

        /* renamed from: c */
        public static final /* synthetic */ n[] f16350c = {n0.r(new PropertyReference1Impl(n0.d(Data.class), "moduleData", "getModuleData()Lorg/jetbrains/kotlin/descriptors/runtime/components/RuntimeModuleData;"))};
        @d
        private final l.a a = l.d(new KDeclarationContainerImpl$Data$moduleData$2(this));

        public Data() {
            KDeclarationContainerImpl.this = r1;
        }

        @d
        public final k a() {
            return (k) this.a.b(this, f16350c[0]);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0084\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$MemberBelonginess;", "", "(Ljava/lang/String;I)V", "accept", "", "member", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "DECLARED", "INHERITED", "kotlin-reflection"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public enum MemberBelonginess {
        DECLARED,
        INHERITED;

        public final boolean accept(@d CallableMemberDescriptor callableMemberDescriptor) {
            return callableMemberDescriptor.i().isReal() == (this == DECLARED);
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0012\u0012\u0002\b\u0003 \u0005*\b\u0012\u0002\b\u0003\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Companion;", "", "()V", "DEFAULT_CONSTRUCTOR_MARKER", "Ljava/lang/Class;", "kotlin.jvm.PlatformType", "LOCAL_PROPERTY_SIGNATURE", "Lkotlin/text/Regex;", "getLOCAL_PROPERTY_SIGNATURE$kotlin_reflection", "()Lkotlin/text/Regex;", "kotlin-reflection"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        @d
        public final Regex a() {
            return KDeclarationContainerImpl.b;
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "first", "Lkotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibility;", "kotlin.jvm.PlatformType", "second", "compare"}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public static final class b<T> implements Comparator<s> {
        public static final b a = new b();

        @Override // java.util.Comparator
        /* renamed from: a */
        public final int compare(s sVar, s sVar2) {
            Integer d2 = h.p2.b0.g.t.c.r.d(sVar, sVar2);
            if (d2 != null) {
                return d2.intValue();
            }
            return 0;
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"kotlin/reflect/jvm/internal/KDeclarationContainerImpl$getMembers$visitor$1", "Lkotlin/reflect/jvm/internal/CreateKCallableVisitor;", "visitConstructorDescriptor", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "data", "", "(Lorg/jetbrains/kotlin/descriptors/ConstructorDescriptor;Lkotlin/Unit;)Lkotlin/reflect/jvm/internal/KCallableImpl;", "kotlin-reflection"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public static final class c extends h.p2.b0.g.a {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(KDeclarationContainerImpl kDeclarationContainerImpl) {
            super(kDeclarationContainerImpl);
            KDeclarationContainerImpl.this = r1;
        }

        @Override // h.p2.b0.g.t.c.d1.k, h.p2.b0.g.t.c.m
        @d
        /* renamed from: r */
        public KCallableImpl<?> j(@d j jVar, @d t1 t1Var) {
            throw new IllegalStateException("No constructors should appear here: " + jVar);
        }
    }

    private final List<Class<?>> P(String str) {
        int q3;
        ArrayList arrayList = new ArrayList();
        int i2 = 1;
        while (str.charAt(i2) != ')') {
            int i3 = i2;
            while (str.charAt(i3) == '[') {
                i3++;
            }
            char charAt = str.charAt(i3);
            if (StringsKt__StringsKt.U2("VZCBSIFJD", charAt, false, 2, null)) {
                q3 = i3 + 1;
            } else if (charAt == 'L') {
                q3 = StringsKt__StringsKt.q3(str, ';', i2, false, 4, null) + 1;
            } else {
                throw new KotlinReflectionInternalError("Unknown type prefix in the method signature: " + str);
            }
            arrayList.add(S(str, i2, q3));
            i2 = q3;
        }
        return arrayList;
    }

    private final Class<?> Q(String str) {
        return S(str, StringsKt__StringsKt.q3(str, ')', 0, false, 6, null) + 1, str.length());
    }

    private final Method R(Class<?> cls, String str, Class<?>[] clsArr, Class<?> cls2, boolean z) {
        Class<?>[] interfaces;
        Method R;
        if (z) {
            clsArr[0] = cls;
        }
        Method U = U(cls, str, clsArr, cls2);
        if (U != null) {
            return U;
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass == null || (R = R(superclass, str, clsArr, cls2, z)) == null) {
            for (Class<?> cls3 : cls.getInterfaces()) {
                Method R2 = R(cls3, str, clsArr, cls2, z);
                if (R2 != null) {
                    return R2;
                }
                if (z) {
                    Class<?> a2 = e.a(ReflectClassUtilKt.f(cls3), cls3.getName() + "$DefaultImpls");
                    if (a2 != null) {
                        clsArr[0] = cls3;
                        Method U2 = U(a2, str, clsArr, cls2);
                        if (U2 != null) {
                            return U2;
                        }
                    } else {
                        continue;
                    }
                }
            }
            return null;
        }
        return R;
    }

    private final Class<?> S(String str, int i2, int i3) {
        char charAt = str.charAt(i2);
        if (charAt != 'F') {
            if (charAt == 'L') {
                ClassLoader f2 = ReflectClassUtilKt.f(d());
                Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
                return f2.loadClass(h.t2.u.j2(str.substring(i2 + 1, i3 - 1), Attributes.InternalPrefix, '.', false, 4, null));
            } else if (charAt != 'S') {
                if (charAt != 'V') {
                    if (charAt != 'I') {
                        if (charAt != 'J') {
                            if (charAt != 'Z') {
                                if (charAt != '[') {
                                    switch (charAt) {
                                        case 'B':
                                            return Byte.TYPE;
                                        case 'C':
                                            return Character.TYPE;
                                        case 'D':
                                            return Double.TYPE;
                                        default:
                                            throw new KotlinReflectionInternalError("Unknown type prefix in the method signature: " + str);
                                    }
                                }
                                return q.e(S(str, i2 + 1, i3));
                            }
                            return Boolean.TYPE;
                        }
                        return Long.TYPE;
                    }
                    return Integer.TYPE;
                }
                return Void.TYPE;
            } else {
                return Short.TYPE;
            }
        }
        return Float.TYPE;
    }

    private final Constructor<?> T(Class<?> cls, List<? extends Class<?>> list) {
        try {
            Object[] array = list.toArray(new Class[0]);
            if (array != null) {
                Class[] clsArr = (Class[]) array;
                return cls.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr, clsArr.length));
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private final Method U(Class<?> cls, String str, Class<?>[] clsArr, Class<?> cls2) {
        Method[] declaredMethods;
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
            if (f0.g(declaredMethod.getReturnType(), cls2)) {
                return declaredMethod;
            }
            for (Method method : cls.getDeclaredMethods()) {
                if (f0.g(method.getName(), str) && f0.g(method.getReturnType(), cls2) && Arrays.equals(method.getParameterTypes(), clsArr)) {
                    return method;
                }
            }
            return null;
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private final void r(List<Class<?>> list, String str, boolean z) {
        List<Class<?>> P = P(str);
        list.addAll(P);
        int size = ((P.size() + 32) - 1) / 32;
        for (int i2 = 0; i2 < size; i2++) {
            list.add(Integer.TYPE);
        }
        list.add(z ? a : Object.class);
    }

    @k.e.a.e
    public final Method F(@d String str, @d String str2, boolean z) {
        if (f0.g(str, "<init>")) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (z) {
            arrayList.add(d());
        }
        r(arrayList, str2, false);
        Class<?> N = N();
        String str3 = str + "$default";
        Object[] array = arrayList.toArray(new Class[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        return R(N, str3, (Class[]) array, Q(str2), z);
    }

    @d
    public final v G(@d String str, @d String str2) {
        Collection<v> I5 = f0.g(str, "<init>") ? CollectionsKt___CollectionsKt.I5(J()) : K(f.f(str));
        ArrayList arrayList = new ArrayList();
        for (Object obj : I5) {
            if (f0.g(o.b.g((v) obj).a(), str2)) {
                arrayList.add(obj);
            }
        }
        if (arrayList.size() != 1) {
            String Z2 = CollectionsKt___CollectionsKt.Z2(I5, "\n", null, null, 0, null, KDeclarationContainerImpl$findFunctionDescriptor$allMembers$1.INSTANCE, 30, null);
            StringBuilder sb = new StringBuilder();
            sb.append("Function '");
            sb.append(str);
            sb.append("' (JVM signature: ");
            sb.append(str2);
            sb.append(") not resolved in ");
            sb.append(this);
            sb.append(':');
            sb.append(Z2.length() == 0 ? " no members found" : '\n' + Z2);
            throw new KotlinReflectionInternalError(sb.toString());
        }
        return (v) CollectionsKt___CollectionsKt.U4(arrayList);
    }

    @k.e.a.e
    public final Method H(@d String str, @d String str2) {
        Method R;
        if (f0.g(str, "<init>")) {
            return null;
        }
        Object[] array = P(str2).toArray(new Class[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        Class<?>[] clsArr = (Class[]) array;
        Class<?> Q = Q(str2);
        Method R2 = R(N(), str, clsArr, Q, false);
        if (R2 != null) {
            return R2;
        }
        if (!N().isInterface() || (R = R(Object.class, str, clsArr, Q, false)) == null) {
            return null;
        }
        return R;
    }

    @d
    public final j0 I(@d String str, @d String str2) {
        h.t2.k matchEntire = b.matchEntire(str2);
        if (matchEntire != null) {
            String str3 = matchEntire.a().k().b().get(1);
            j0 L = L(Integer.parseInt(str3));
            if (L != null) {
                return L;
            }
            throw new KotlinReflectionInternalError("Local property #" + str3 + " not found in " + d());
        }
        Collection<j0> O = O(f.f(str));
        ArrayList arrayList = new ArrayList();
        for (Object obj : O) {
            if (f0.g(o.b.f((j0) obj).a(), str2)) {
                arrayList.add(obj);
            }
        }
        if (!arrayList.isEmpty()) {
            if (arrayList.size() != 1) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Object obj2 : arrayList) {
                    s visibility = ((j0) obj2).getVisibility();
                    Object obj3 = linkedHashMap.get(visibility);
                    if (obj3 == null) {
                        obj3 = new ArrayList();
                        linkedHashMap.put(visibility, obj3);
                    }
                    ((List) obj3).add(obj2);
                }
                List list = (List) CollectionsKt___CollectionsKt.a3(s0.r(linkedHashMap, b.a).values());
                if (list.size() == 1) {
                    return (j0) CollectionsKt___CollectionsKt.o2(list);
                }
                String Z2 = CollectionsKt___CollectionsKt.Z2(O(f.f(str)), "\n", null, null, 0, null, KDeclarationContainerImpl$findPropertyDescriptor$allMembers$1.INSTANCE, 30, null);
                StringBuilder sb = new StringBuilder();
                sb.append("Property '");
                sb.append(str);
                sb.append("' (JVM signature: ");
                sb.append(str2);
                sb.append(") not resolved in ");
                sb.append(this);
                sb.append(':');
                sb.append(Z2.length() == 0 ? " no members found" : '\n' + Z2);
                throw new KotlinReflectionInternalError(sb.toString());
            }
            return (j0) CollectionsKt___CollectionsKt.U4(arrayList);
        }
        throw new KotlinReflectionInternalError("Property '" + str + "' (JVM signature: " + str2 + ") not resolved in " + this);
    }

    @d
    public abstract Collection<j> J();

    @d
    public abstract Collection<v> K(@d f fVar);

    @k.e.a.e
    public abstract j0 L(int i2);

    /* JADX WARN: Removed duplicated region for block: B:39:0x0047 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0014 A[SYNTHETIC] */
    @k.e.a.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.Collection<kotlin.reflect.jvm.internal.KCallableImpl<?>> M(@k.e.a.d kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope r8, @k.e.a.d kotlin.reflect.jvm.internal.KDeclarationContainerImpl.MemberBelonginess r9) {
        /*
            r7 = this;
            kotlin.reflect.jvm.internal.KDeclarationContainerImpl$c r0 = new kotlin.reflect.jvm.internal.KDeclarationContainerImpl$c
            r0.<init>(r7)
            r1 = 0
            r2 = 3
            java.util.Collection r8 = h.p2.b0.g.t.k.r.h.a.a(r8, r1, r1, r2, r1)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r8 = r8.iterator()
        L14:
            boolean r3 = r8.hasNext()
            if (r3 == 0) goto L4b
            java.lang.Object r3 = r8.next()
            h.p2.b0.g.t.c.k r3 = (h.p2.b0.g.t.c.k) r3
            boolean r4 = r3 instanceof kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
            if (r4 == 0) goto L44
            r4 = r3
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) r4
            h.p2.b0.g.t.c.s r5 = r4.getVisibility()
            h.p2.b0.g.t.c.s r6 = h.p2.b0.g.t.c.r.f15214h
            boolean r5 = h.k2.v.f0.g(r5, r6)
            r5 = r5 ^ 1
            if (r5 == 0) goto L44
            boolean r4 = r9.accept(r4)
            if (r4 == 0) goto L44
            h.t1 r4 = h.t1.a
            java.lang.Object r3 = r3.B(r0, r4)
            kotlin.reflect.jvm.internal.KCallableImpl r3 = (kotlin.reflect.jvm.internal.KCallableImpl) r3
            goto L45
        L44:
            r3 = r1
        L45:
            if (r3 == 0) goto L14
            r2.add(r3)
            goto L14
        L4b:
            java.util.List r8 = kotlin.collections.CollectionsKt___CollectionsKt.I5(r2)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.KDeclarationContainerImpl.M(kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.KDeclarationContainerImpl$MemberBelonginess):java.util.Collection");
    }

    @d
    public Class<?> N() {
        Class<?> g2 = ReflectClassUtilKt.g(d());
        return g2 != null ? g2 : d();
    }

    @d
    public abstract Collection<j0> O(@d f fVar);

    @k.e.a.e
    public final Constructor<?> t(@d String str) {
        return T(d(), P(str));
    }

    @k.e.a.e
    public final Constructor<?> x(@d String str) {
        Class<?> d2 = d();
        ArrayList arrayList = new ArrayList();
        r(arrayList, str, true);
        t1 t1Var = t1.a;
        return T(d2, arrayList);
    }
}
