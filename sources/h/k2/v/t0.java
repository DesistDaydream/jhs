package h.k2.v;

import h.k2.v.x0.g;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public class t0 {
    public static int A(Object obj) {
        if (obj instanceof b0) {
            return ((b0) obj).getArity();
        }
        if (obj instanceof h.k2.u.a) {
            return 0;
        }
        if (obj instanceof h.k2.u.l) {
            return 1;
        }
        if (obj instanceof h.k2.u.p) {
            return 2;
        }
        if (obj instanceof h.k2.u.q) {
            return 3;
        }
        if (obj instanceof h.k2.u.r) {
            return 4;
        }
        if (obj instanceof h.k2.u.s) {
            return 5;
        }
        if (obj instanceof h.k2.u.t) {
            return 6;
        }
        if (obj instanceof h.k2.u.u) {
            return 7;
        }
        if (obj instanceof h.k2.u.v) {
            return 8;
        }
        if (obj instanceof h.k2.u.w) {
            return 9;
        }
        if (obj instanceof h.k2.u.b) {
            return 10;
        }
        if (obj instanceof h.k2.u.c) {
            return 11;
        }
        if (obj instanceof h.k2.u.d) {
            return 12;
        }
        if (obj instanceof h.k2.u.e) {
            return 13;
        }
        if (obj instanceof h.k2.u.f) {
            return 14;
        }
        if (obj instanceof h.k2.u.g) {
            return 15;
        }
        if (obj instanceof h.k2.u.h) {
            return 16;
        }
        if (obj instanceof h.k2.u.i) {
            return 17;
        }
        if (obj instanceof h.k2.u.j) {
            return 18;
        }
        if (obj instanceof h.k2.u.k) {
            return 19;
        }
        if (obj instanceof h.k2.u.m) {
            return 20;
        }
        if (obj instanceof h.k2.u.n) {
            return 21;
        }
        return obj instanceof h.k2.u.o ? 22 : -1;
    }

    public static boolean B(Object obj, int i2) {
        return (obj instanceof h.r) && A(obj) == i2;
    }

    public static boolean C(Object obj) {
        return (obj instanceof Collection) && (!(obj instanceof h.k2.v.x0.a) || (obj instanceof h.k2.v.x0.b));
    }

    public static boolean D(Object obj) {
        return (obj instanceof Iterable) && (!(obj instanceof h.k2.v.x0.a) || (obj instanceof h.k2.v.x0.c));
    }

    public static boolean E(Object obj) {
        return (obj instanceof Iterator) && (!(obj instanceof h.k2.v.x0.a) || (obj instanceof h.k2.v.x0.d));
    }

    public static boolean F(Object obj) {
        return (obj instanceof List) && (!(obj instanceof h.k2.v.x0.a) || (obj instanceof h.k2.v.x0.e));
    }

    public static boolean G(Object obj) {
        return (obj instanceof ListIterator) && (!(obj instanceof h.k2.v.x0.a) || (obj instanceof h.k2.v.x0.f));
    }

    public static boolean H(Object obj) {
        return (obj instanceof Map) && (!(obj instanceof h.k2.v.x0.a) || (obj instanceof h.k2.v.x0.g));
    }

    public static boolean I(Object obj) {
        return (obj instanceof Map.Entry) && (!(obj instanceof h.k2.v.x0.a) || (obj instanceof g.a));
    }

    public static boolean J(Object obj) {
        return (obj instanceof Set) && (!(obj instanceof h.k2.v.x0.a) || (obj instanceof h.k2.v.x0.h));
    }

    private static <T extends Throwable> T K(T t) {
        return (T) f0.B(t, t0.class.getName());
    }

    public static ClassCastException L(ClassCastException classCastException) {
        throw ((ClassCastException) K(classCastException));
    }

    public static void M(Object obj, String str) {
        String name = obj == null ? "null" : obj.getClass().getName();
        N(name + " cannot be cast to " + str);
    }

    public static void N(String str) {
        throw L(new ClassCastException(str));
    }

    public static Collection a(Object obj) {
        if ((obj instanceof h.k2.v.x0.a) && !(obj instanceof h.k2.v.x0.b)) {
            M(obj, "kotlin.collections.MutableCollection");
        }
        return s(obj);
    }

    public static Collection b(Object obj, String str) {
        if ((obj instanceof h.k2.v.x0.a) && !(obj instanceof h.k2.v.x0.b)) {
            N(str);
        }
        return s(obj);
    }

    public static Iterable c(Object obj) {
        if ((obj instanceof h.k2.v.x0.a) && !(obj instanceof h.k2.v.x0.c)) {
            M(obj, "kotlin.collections.MutableIterable");
        }
        return t(obj);
    }

    public static Iterable d(Object obj, String str) {
        if ((obj instanceof h.k2.v.x0.a) && !(obj instanceof h.k2.v.x0.c)) {
            N(str);
        }
        return t(obj);
    }

    public static Iterator e(Object obj) {
        if ((obj instanceof h.k2.v.x0.a) && !(obj instanceof h.k2.v.x0.d)) {
            M(obj, "kotlin.collections.MutableIterator");
        }
        return u(obj);
    }

    public static Iterator f(Object obj, String str) {
        if ((obj instanceof h.k2.v.x0.a) && !(obj instanceof h.k2.v.x0.d)) {
            N(str);
        }
        return u(obj);
    }

    public static List g(Object obj) {
        if ((obj instanceof h.k2.v.x0.a) && !(obj instanceof h.k2.v.x0.e)) {
            M(obj, "kotlin.collections.MutableList");
        }
        return v(obj);
    }

    public static List h(Object obj, String str) {
        if ((obj instanceof h.k2.v.x0.a) && !(obj instanceof h.k2.v.x0.e)) {
            N(str);
        }
        return v(obj);
    }

    public static ListIterator i(Object obj) {
        if ((obj instanceof h.k2.v.x0.a) && !(obj instanceof h.k2.v.x0.f)) {
            M(obj, "kotlin.collections.MutableListIterator");
        }
        return w(obj);
    }

    public static ListIterator j(Object obj, String str) {
        if ((obj instanceof h.k2.v.x0.a) && !(obj instanceof h.k2.v.x0.f)) {
            N(str);
        }
        return w(obj);
    }

    public static Map k(Object obj) {
        if ((obj instanceof h.k2.v.x0.a) && !(obj instanceof h.k2.v.x0.g)) {
            M(obj, "kotlin.collections.MutableMap");
        }
        return x(obj);
    }

    public static Map l(Object obj, String str) {
        if ((obj instanceof h.k2.v.x0.a) && !(obj instanceof h.k2.v.x0.g)) {
            N(str);
        }
        return x(obj);
    }

    public static Map.Entry m(Object obj) {
        if ((obj instanceof h.k2.v.x0.a) && !(obj instanceof g.a)) {
            M(obj, "kotlin.collections.MutableMap.MutableEntry");
        }
        return y(obj);
    }

    public static Map.Entry n(Object obj, String str) {
        if ((obj instanceof h.k2.v.x0.a) && !(obj instanceof g.a)) {
            N(str);
        }
        return y(obj);
    }

    public static Set o(Object obj) {
        if ((obj instanceof h.k2.v.x0.a) && !(obj instanceof h.k2.v.x0.h)) {
            M(obj, "kotlin.collections.MutableSet");
        }
        return z(obj);
    }

    public static Set p(Object obj, String str) {
        if ((obj instanceof h.k2.v.x0.a) && !(obj instanceof h.k2.v.x0.h)) {
            N(str);
        }
        return z(obj);
    }

    public static Object q(Object obj, int i2) {
        if (obj != null && !B(obj, i2)) {
            M(obj, "kotlin.jvm.functions.Function" + i2);
        }
        return obj;
    }

    public static Object r(Object obj, int i2, String str) {
        if (obj != null && !B(obj, i2)) {
            N(str);
        }
        return obj;
    }

    public static Collection s(Object obj) {
        try {
            return (Collection) obj;
        } catch (ClassCastException e2) {
            throw L(e2);
        }
    }

    public static Iterable t(Object obj) {
        try {
            return (Iterable) obj;
        } catch (ClassCastException e2) {
            throw L(e2);
        }
    }

    public static Iterator u(Object obj) {
        try {
            return (Iterator) obj;
        } catch (ClassCastException e2) {
            throw L(e2);
        }
    }

    public static List v(Object obj) {
        try {
            return (List) obj;
        } catch (ClassCastException e2) {
            throw L(e2);
        }
    }

    public static ListIterator w(Object obj) {
        try {
            return (ListIterator) obj;
        } catch (ClassCastException e2) {
            throw L(e2);
        }
    }

    public static Map x(Object obj) {
        try {
            return (Map) obj;
        } catch (ClassCastException e2) {
            throw L(e2);
        }
    }

    public static Map.Entry y(Object obj) {
        try {
            return (Map.Entry) obj;
        } catch (ClassCastException e2) {
            throw L(e2);
        }
    }

    public static Set z(Object obj) {
        try {
            return (Set) obj;
        } catch (ClassCastException e2) {
            throw L(e2);
        }
    }
}
