package h.p2.b0.g.t.e.b;

import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* loaded from: classes3.dex */
public abstract class h {
    @k.e.a.d
    public static final b a = new b(null);
    @k.e.a.d
    private static final d b = new d(JvmPrimitiveType.BOOLEAN);
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private static final d f15324c = new d(JvmPrimitiveType.CHAR);
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private static final d f15325d = new d(JvmPrimitiveType.BYTE);
    @k.e.a.d

    /* renamed from: e  reason: collision with root package name */
    private static final d f15326e = new d(JvmPrimitiveType.SHORT);
    @k.e.a.d

    /* renamed from: f  reason: collision with root package name */
    private static final d f15327f = new d(JvmPrimitiveType.INT);
    @k.e.a.d

    /* renamed from: g  reason: collision with root package name */
    private static final d f15328g = new d(JvmPrimitiveType.FLOAT);
    @k.e.a.d

    /* renamed from: h  reason: collision with root package name */
    private static final d f15329h = new d(JvmPrimitiveType.LONG);
    @k.e.a.d

    /* renamed from: i  reason: collision with root package name */
    private static final d f15330i = new d(JvmPrimitiveType.DOUBLE);

    /* loaded from: classes3.dex */
    public static final class a extends h {
        @k.e.a.d

        /* renamed from: j  reason: collision with root package name */
        private final h f15331j;

        public a(@k.e.a.d h hVar) {
            super(null);
            this.f15331j = hVar;
        }

        @k.e.a.d
        public final h i() {
            return this.f15331j;
        }
    }

    /* loaded from: classes3.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(h.k2.v.u uVar) {
            this();
        }

        @k.e.a.d
        public final d a() {
            return h.b;
        }

        @k.e.a.d
        public final d b() {
            return h.f15325d;
        }

        @k.e.a.d
        public final d c() {
            return h.f15324c;
        }

        @k.e.a.d
        public final d d() {
            return h.f15330i;
        }

        @k.e.a.d
        public final d e() {
            return h.f15328g;
        }

        @k.e.a.d
        public final d f() {
            return h.f15327f;
        }

        @k.e.a.d
        public final d g() {
            return h.f15329h;
        }

        @k.e.a.d
        public final d h() {
            return h.f15326e;
        }
    }

    /* loaded from: classes3.dex */
    public static final class c extends h {
        @k.e.a.d

        /* renamed from: j  reason: collision with root package name */
        private final String f15332j;

        public c(@k.e.a.d String str) {
            super(null);
            this.f15332j = str;
        }

        @k.e.a.d
        public final String i() {
            return this.f15332j;
        }
    }

    /* loaded from: classes3.dex */
    public static final class d extends h {
        @k.e.a.e

        /* renamed from: j  reason: collision with root package name */
        private final JvmPrimitiveType f15333j;

        public d(@k.e.a.e JvmPrimitiveType jvmPrimitiveType) {
            super(null);
            this.f15333j = jvmPrimitiveType;
        }

        @k.e.a.e
        public final JvmPrimitiveType i() {
            return this.f15333j;
        }
    }

    private h() {
    }

    public /* synthetic */ h(h.k2.v.u uVar) {
        this();
    }

    @k.e.a.d
    public String toString() {
        return j.a.d(this);
    }
}
