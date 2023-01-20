package h.k2.v;

import com.moor.imkf.lib.jsoup.nodes.Attributes;
import java.util.Arrays;
import kotlin.KotlinNullPointerException;
import kotlin.UninitializedPropertyAccessException;

/* loaded from: classes3.dex */
public class f0 {

    @h.s0(version = "1.4")
    /* loaded from: classes3.dex */
    public static class a {
        private a() {
        }
    }

    private f0() {
    }

    private static <T extends Throwable> T A(T t) {
        return (T) B(t, f0.class.getName());
    }

    public static <T extends Throwable> T B(T t, String str) {
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i2 = -1;
        for (int i3 = 0; i3 < length; i3++) {
            if (str.equals(stackTrace[i3].getClassName())) {
                i2 = i3;
            }
        }
        t.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i2 + 1, length));
        return t;
    }

    public static String C(String str, Object obj) {
        return str + obj;
    }

    public static void D() {
        throw ((AssertionError) A(new AssertionError()));
    }

    public static void E(String str) {
        throw ((AssertionError) A(new AssertionError(str)));
    }

    public static void F() {
        throw ((IllegalArgumentException) A(new IllegalArgumentException()));
    }

    public static void G(String str) {
        throw ((IllegalArgumentException) A(new IllegalArgumentException(str)));
    }

    public static void H() {
        throw ((IllegalStateException) A(new IllegalStateException()));
    }

    public static void I(String str) {
        throw ((IllegalStateException) A(new IllegalStateException(str)));
    }

    @h.s0(version = "1.4")
    public static void J() {
        throw ((NullPointerException) A(new NullPointerException()));
    }

    @h.s0(version = "1.4")
    public static void K(String str) {
        throw ((NullPointerException) A(new NullPointerException(str)));
    }

    public static void L() {
        throw ((KotlinNullPointerException) A(new KotlinNullPointerException()));
    }

    public static void M(String str) {
        throw ((KotlinNullPointerException) A(new KotlinNullPointerException(str)));
    }

    private static void N(String str) {
        throw ((IllegalArgumentException) A(new IllegalArgumentException(v(str))));
    }

    private static void O(String str) {
        throw ((NullPointerException) A(new NullPointerException(v(str))));
    }

    public static void P() {
        Q("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    public static void Q(String str) {
        throw new UnsupportedOperationException(str);
    }

    public static void R(String str) {
        throw ((UninitializedPropertyAccessException) A(new UninitializedPropertyAccessException(str)));
    }

    public static void S(String str) {
        R("lateinit property " + str + " has not been initialized");
    }

    @h.s0(version = "1.1")
    public static boolean a(double d2, Double d3) {
        return d3 != null && d2 == d3.doubleValue();
    }

    @h.s0(version = "1.1")
    public static boolean b(float f2, Float f3) {
        return f3 != null && f2 == f3.floatValue();
    }

    @h.s0(version = "1.1")
    public static boolean c(Double d2, double d3) {
        return d2 != null && d2.doubleValue() == d3;
    }

    @h.s0(version = "1.1")
    public static boolean d(Double d2, Double d3) {
        if (d2 == null) {
            if (d3 == null) {
                return true;
            }
        } else if (d3 != null && d2.doubleValue() == d3.doubleValue()) {
            return true;
        }
        return false;
    }

    @h.s0(version = "1.1")
    public static boolean e(Float f2, float f3) {
        return f2 != null && f2.floatValue() == f3;
    }

    @h.s0(version = "1.1")
    public static boolean f(Float f2, Float f3) {
        if (f2 == null) {
            if (f3 == null) {
                return true;
            }
        } else if (f3 != null && f2.floatValue() == f3.floatValue()) {
            return true;
        }
        return false;
    }

    public static boolean g(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static void h(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw ((IllegalStateException) A(new IllegalStateException(str + " must not be null")));
    }

    public static void i(Object obj, String str) {
        if (obj == null) {
            throw ((IllegalStateException) A(new IllegalStateException(str)));
        }
    }

    public static void j(Object obj, String str, String str2) {
        if (obj != null) {
            return;
        }
        throw ((IllegalStateException) A(new IllegalStateException("Field specified as non-null is null: " + str + "." + str2)));
    }

    public static void k(String str) throws ClassNotFoundException {
        String replace = str.replace(Attributes.InternalPrefix, '.');
        try {
            Class.forName(replace);
        } catch (ClassNotFoundException e2) {
            throw ((ClassNotFoundException) A(new ClassNotFoundException("Class " + replace + " is not found. Please update the Kotlin runtime to the latest version", e2)));
        }
    }

    public static void l(String str, String str2) throws ClassNotFoundException {
        String replace = str.replace(Attributes.InternalPrefix, '.');
        try {
            Class.forName(replace);
        } catch (ClassNotFoundException e2) {
            throw ((ClassNotFoundException) A(new ClassNotFoundException("Class " + replace + " is not found: this code requires the Kotlin runtime of version at least " + str2, e2)));
        }
    }

    public static void m(Object obj) {
        if (obj == null) {
            J();
        }
    }

    public static void n(Object obj, String str) {
        if (obj == null) {
            K(str);
        }
    }

    public static void o(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw ((NullPointerException) A(new NullPointerException(str + " must not be null")));
    }

    public static void p(Object obj, String str) {
        if (obj == null) {
            O(str);
        }
    }

    public static void q(Object obj, String str) {
        if (obj == null) {
            N(str);
        }
    }

    public static void r(Object obj, String str) {
        if (obj == null) {
            throw ((IllegalStateException) A(new IllegalStateException(str)));
        }
    }

    public static void s(Object obj, String str, String str2) {
        if (obj != null) {
            return;
        }
        throw ((IllegalStateException) A(new IllegalStateException("Method specified as non-null returned null: " + str + "." + str2)));
    }

    public static int t(int i2, int i3) {
        if (i2 < i3) {
            return -1;
        }
        return i2 == i3 ? 0 : 1;
    }

    public static int u(long j2, long j3) {
        int i2 = (j2 > j3 ? 1 : (j2 == j3 ? 0 : -1));
        if (i2 < 0) {
            return -1;
        }
        return i2 == 0 ? 0 : 1;
    }

    private static String v(String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[4];
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        return "Parameter specified as non-null is null: method " + className + "." + methodName + ", parameter " + str;
    }

    public static void w() {
        P();
    }

    public static void x(String str) {
        Q(str);
    }

    public static void y(int i2, String str) {
        P();
    }

    public static void z(int i2, String str, String str2) {
        Q(str2);
    }
}
