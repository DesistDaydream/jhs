package kotlin.reflect.jvm.internal.impl.utils;

import h.p2.b0.g.t.p.c;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes3.dex */
public class WrappedValues {
    private static final Object a = new a();
    public static volatile boolean b = false;

    /* loaded from: classes3.dex */
    public static class WrappedProcessCanceledException extends RuntimeException {
        public WrappedProcessCanceledException(Throwable th) {
            super("Rethrow stored exception", th);
        }
    }

    /* loaded from: classes3.dex */
    public static class a {
        public String toString() {
            return "NULL_VALUE";
        }
    }

    /* loaded from: classes3.dex */
    public static final class b {
        private final Throwable a;

        public /* synthetic */ b(Throwable th, a aVar) {
            this(th);
        }

        private static /* synthetic */ void a(int i2) {
            String str = i2 != 1 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i2 != 1 ? 3 : 2];
            if (i2 != 1) {
                objArr[0] = "throwable";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues$ThrowableWrapper";
            }
            if (i2 != 1) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues$ThrowableWrapper";
            } else {
                objArr[1] = "getThrowable";
            }
            if (i2 != 1) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i2 == 1) {
                throw new IllegalStateException(format);
            }
        }

        @d
        public Throwable b() {
            Throwable th = this.a;
            if (th == null) {
                a(1);
            }
            return th;
        }

        public String toString() {
            return this.a.toString();
        }

        private b(@d Throwable th) {
            if (th == null) {
                a(0);
            }
            this.a = th;
        }
    }

    private static /* synthetic */ void a(int i2) {
        String str = (i2 == 1 || i2 == 2) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 1 || i2 == 2) ? 2 : 3];
        if (i2 == 1 || i2 == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues";
        } else if (i2 != 3) {
            objArr[0] = "value";
        } else {
            objArr[0] = "throwable";
        }
        if (i2 == 1 || i2 == 2) {
            objArr[1] = "escapeNull";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues";
        }
        if (i2 != 1 && i2 != 2) {
            if (i2 == 3) {
                objArr[2] = "escapeThrowable";
            } else if (i2 != 4) {
                objArr[2] = "unescapeNull";
            } else {
                objArr[2] = "unescapeExceptionOrNull";
            }
        }
        String format = String.format(str, objArr);
        if (i2 != 1 && i2 != 2) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @d
    public static <V> Object b(@e V v) {
        if (v != null) {
            if (v == null) {
                a(2);
            }
            return v;
        }
        Object obj = a;
        if (obj == null) {
            a(1);
        }
        return obj;
    }

    @d
    public static Object c(@d Throwable th) {
        if (th == null) {
            a(3);
        }
        return new b(th, null);
    }

    @e
    public static <V> V d(@d Object obj) {
        if (obj == null) {
            a(4);
        }
        return (V) e(f(obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @e
    public static <V> V e(@d Object obj) {
        if (obj == 0) {
            a(0);
        }
        if (obj == a) {
            return null;
        }
        return obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @e
    public static <V> V f(@e Object obj) {
        if (obj instanceof b) {
            Throwable b2 = ((b) obj).b();
            if (b && c.a(b2)) {
                throw new WrappedProcessCanceledException(b2);
            }
            throw c.b(b2);
        }
        return obj;
    }
}
