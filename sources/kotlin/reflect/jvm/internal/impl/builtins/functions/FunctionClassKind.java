package kotlin.reflect.jvm.internal.impl.builtins.functions;

import h.k2.k;
import h.k2.v.f0;
import h.k2.v.u;
import h.p2.b0.g.t.b.g;
import h.p2.b0.g.t.g.c;
import h.p2.b0.g.t.g.f;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes3.dex */
public final class FunctionClassKind {
    private static final /* synthetic */ FunctionClassKind[] $VALUES;
    @d
    public static final a Companion;
    public static final FunctionClassKind KFunction;
    public static final FunctionClassKind KSuspendFunction;
    @d
    private final String classNamePrefix;
    private final boolean isReflectType;
    private final boolean isSuspendType;
    @d
    private final c packageFqName;
    public static final FunctionClassKind Function = new FunctionClassKind("Function", 0, g.n, "Function", false, false);
    public static final FunctionClassKind SuspendFunction = new FunctionClassKind("SuspendFunction", 1, g.f15027e, "SuspendFunction", true, false);

    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind$a$a */
        /* loaded from: classes3.dex */
        public static final class C0493a {
            @d
            private final FunctionClassKind a;
            private final int b;

            public C0493a(@d FunctionClassKind functionClassKind, int i2) {
                this.a = functionClassKind;
                this.b = i2;
            }

            @d
            public final FunctionClassKind a() {
                return this.a;
            }

            public final int b() {
                return this.b;
            }

            @d
            public final FunctionClassKind c() {
                return this.a;
            }

            public boolean equals(@e Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof C0493a) {
                    C0493a c0493a = (C0493a) obj;
                    return this.a == c0493a.a && this.b == c0493a.b;
                }
                return false;
            }

            public int hashCode() {
                return (this.a.hashCode() * 31) + this.b;
            }

            @d
            public String toString() {
                return "KindWithArity(kind=" + this.a + ", arity=" + this.b + ')';
            }
        }

        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        private final Integer d(String str) {
            if (str.length() == 0) {
                return null;
            }
            int length = str.length();
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                char charAt = str.charAt(i2);
                i2++;
                int i4 = charAt - '0';
                if (!(i4 >= 0 && i4 <= 9)) {
                    return null;
                }
                i3 = (i3 * 10) + i4;
            }
            return Integer.valueOf(i3);
        }

        @e
        public final FunctionClassKind a(@d c cVar, @d String str) {
            FunctionClassKind[] values;
            for (FunctionClassKind functionClassKind : FunctionClassKind.values()) {
                if (f0.g(functionClassKind.getPackageFqName(), cVar) && h.t2.u.u2(str, functionClassKind.getClassNamePrefix(), false, 2, null)) {
                    return functionClassKind;
                }
            }
            return null;
        }

        @k
        @e
        public final FunctionClassKind b(@d String str, @d c cVar) {
            C0493a c2 = c(str, cVar);
            if (c2 == null) {
                return null;
            }
            return c2.c();
        }

        @e
        public final C0493a c(@d String str, @d c cVar) {
            Integer d2;
            FunctionClassKind a = a(cVar, str);
            if (a == null || (d2 = d(str.substring(a.getClassNamePrefix().length()))) == null) {
                return null;
            }
            return new C0493a(a, d2.intValue());
        }
    }

    private static final /* synthetic */ FunctionClassKind[] $values() {
        return new FunctionClassKind[]{Function, SuspendFunction, KFunction, KSuspendFunction};
    }

    static {
        c cVar = g.f15033k;
        KFunction = new FunctionClassKind("KFunction", 2, cVar, "KFunction", false, true);
        KSuspendFunction = new FunctionClassKind("KSuspendFunction", 3, cVar, "KSuspendFunction", true, true);
        $VALUES = $values();
        Companion = new a(null);
    }

    private FunctionClassKind(String str, int i2, c cVar, String str2, boolean z, boolean z2) {
        super(str, i2);
        this.packageFqName = cVar;
        this.classNamePrefix = str2;
        this.isSuspendType = z;
        this.isReflectType = z2;
    }

    public static FunctionClassKind valueOf(String str) {
        return (FunctionClassKind) Enum.valueOf(FunctionClassKind.class, str);
    }

    public static FunctionClassKind[] values() {
        return (FunctionClassKind[]) $VALUES.clone();
    }

    @d
    public final String getClassNamePrefix() {
        return this.classNamePrefix;
    }

    @d
    public final c getPackageFqName() {
        return this.packageFqName;
    }

    @d
    public final f numberedClassName(int i2) {
        return f.f(f0.C(this.classNamePrefix, Integer.valueOf(i2)));
    }
}
