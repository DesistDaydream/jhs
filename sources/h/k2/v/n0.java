package h.k2.v;

import java.util.Arrays;
import java.util.Collections;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference2;
import kotlin.jvm.internal.PropertyReference0;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference2;
import kotlin.reflect.KVariance;

/* loaded from: classes3.dex */
public class n0 {
    private static final o0 a;
    public static final String b = " (Kotlin reflection is not available)";

    /* renamed from: c */
    private static final h.p2.d[] f14913c;

    static {
        o0 o0Var = null;
        try {
            o0Var = (o0) Class.forName("h.p2.b0.g.m").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (o0Var == null) {
            o0Var = new o0();
        }
        a = o0Var;
        f14913c = new h.p2.d[0];
    }

    @h.s0(version = "1.4")
    public static h.p2.r A(Class cls, h.p2.t... tVarArr) {
        return a.p(d(cls), ArraysKt___ArraysKt.ey(tVarArr), false);
    }

    @h.s0(version = "1.4")
    public static h.p2.r B(h.p2.g gVar) {
        return a.p(gVar, Collections.emptyList(), false);
    }

    @h.s0(version = "1.4")
    public static h.p2.s C(Object obj, String str, KVariance kVariance, boolean z) {
        return a.q(obj, str, kVariance, z);
    }

    public static h.p2.d a(Class cls) {
        return a.a(cls);
    }

    public static h.p2.d b(Class cls, String str) {
        return a.b(cls, str);
    }

    public static h.p2.i c(FunctionReference functionReference) {
        return a.c(functionReference);
    }

    public static h.p2.d d(Class cls) {
        return a.d(cls);
    }

    public static h.p2.d e(Class cls, String str) {
        return a.e(cls, str);
    }

    public static h.p2.d[] f(Class[] clsArr) {
        int length = clsArr.length;
        if (length == 0) {
            return f14913c;
        }
        h.p2.d[] dVarArr = new h.p2.d[length];
        for (int i2 = 0; i2 < length; i2++) {
            dVarArr[i2] = d(clsArr[i2]);
        }
        return dVarArr;
    }

    @h.s0(version = "1.4")
    public static h.p2.h g(Class cls) {
        return a.f(cls, "");
    }

    public static h.p2.h h(Class cls, String str) {
        return a.f(cls, str);
    }

    public static h.p2.k i(MutablePropertyReference0 mutablePropertyReference0) {
        return a.g(mutablePropertyReference0);
    }

    public static h.p2.l j(MutablePropertyReference1 mutablePropertyReference1) {
        return a.h(mutablePropertyReference1);
    }

    public static h.p2.m k(MutablePropertyReference2 mutablePropertyReference2) {
        return a.i(mutablePropertyReference2);
    }

    @h.s0(version = "1.4")
    public static h.p2.r l(Class cls) {
        return a.p(d(cls), Collections.emptyList(), true);
    }

    @h.s0(version = "1.4")
    public static h.p2.r m(Class cls, h.p2.t tVar) {
        return a.p(d(cls), Collections.singletonList(tVar), true);
    }

    @h.s0(version = "1.4")
    public static h.p2.r n(Class cls, h.p2.t tVar, h.p2.t tVar2) {
        return a.p(d(cls), Arrays.asList(tVar, tVar2), true);
    }

    @h.s0(version = "1.4")
    public static h.p2.r o(Class cls, h.p2.t... tVarArr) {
        return a.p(d(cls), ArraysKt___ArraysKt.ey(tVarArr), true);
    }

    @h.s0(version = "1.4")
    public static h.p2.r p(h.p2.g gVar) {
        return a.p(gVar, Collections.emptyList(), true);
    }

    public static h.p2.o q(PropertyReference0 propertyReference0) {
        return a.j(propertyReference0);
    }

    public static h.p2.p r(PropertyReference1 propertyReference1) {
        return a.k(propertyReference1);
    }

    public static h.p2.q s(PropertyReference2 propertyReference2) {
        return a.l(propertyReference2);
    }

    @h.s0(version = "1.3")
    public static String t(b0 b0Var) {
        return a.m(b0Var);
    }

    @h.s0(version = "1.1")
    public static String u(Lambda lambda) {
        return a.n(lambda);
    }

    @h.s0(version = "1.4")
    public static void v(h.p2.s sVar, h.p2.r rVar) {
        a.o(sVar, Collections.singletonList(rVar));
    }

    @h.s0(version = "1.4")
    public static void w(h.p2.s sVar, h.p2.r... rVarArr) {
        a.o(sVar, ArraysKt___ArraysKt.ey(rVarArr));
    }

    @h.s0(version = "1.4")
    public static h.p2.r x(Class cls) {
        return a.p(d(cls), Collections.emptyList(), false);
    }

    @h.s0(version = "1.4")
    public static h.p2.r y(Class cls, h.p2.t tVar) {
        return a.p(d(cls), Collections.singletonList(tVar), false);
    }

    @h.s0(version = "1.4")
    public static h.p2.r z(Class cls, h.p2.t tVar, h.p2.t tVar2) {
        return a.p(d(cls), Arrays.asList(tVar, tVar2), false);
    }
}
