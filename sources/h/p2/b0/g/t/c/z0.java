package h.p2.b0.g.t.c;

import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.util.Map;

/* loaded from: classes3.dex */
public final class z0 {
    @k.e.a.d
    public static final z0 a = new z0();
    @k.e.a.d
    private static final Map<a1, Integer> b;
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private static final h f15220c;

    /* loaded from: classes3.dex */
    public static final class a extends a1 {
        @k.e.a.d

        /* renamed from: c  reason: collision with root package name */
        public static final a f15221c = new a();

        private a() {
            super("inherited", false);
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends a1 {
        @k.e.a.d

        /* renamed from: c  reason: collision with root package name */
        public static final b f15222c = new b();

        private b() {
            super(UMModuleRegister.INNER, false);
        }
    }

    /* loaded from: classes3.dex */
    public static final class c extends a1 {
        @k.e.a.d

        /* renamed from: c  reason: collision with root package name */
        public static final c f15223c = new c();

        private c() {
            super("invisible_fake", false);
        }
    }

    /* loaded from: classes3.dex */
    public static final class d extends a1 {
        @k.e.a.d

        /* renamed from: c  reason: collision with root package name */
        public static final d f15224c = new d();

        private d() {
            super(e.j.a.b.c.r.v.b, false);
        }
    }

    /* loaded from: classes3.dex */
    public static final class e extends a1 {
        @k.e.a.d

        /* renamed from: c  reason: collision with root package name */
        public static final e f15225c = new e();

        private e() {
            super(PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE, false);
        }
    }

    /* loaded from: classes3.dex */
    public static final class f extends a1 {
        @k.e.a.d

        /* renamed from: c  reason: collision with root package name */
        public static final f f15226c = new f();

        private f() {
            super("private_to_this", false);
        }

        @Override // h.p2.b0.g.t.c.a1
        @k.e.a.d
        public String b() {
            return "private/*private to this*/";
        }
    }

    /* loaded from: classes3.dex */
    public static final class g extends a1 {
        @k.e.a.d

        /* renamed from: c  reason: collision with root package name */
        public static final g f15227c = new g();

        private g() {
            super("protected", true);
        }
    }

    /* loaded from: classes3.dex */
    public static final class h extends a1 {
        @k.e.a.d

        /* renamed from: c  reason: collision with root package name */
        public static final h f15228c = new h();

        private h() {
            super("public", true);
        }
    }

    /* loaded from: classes3.dex */
    public static final class i extends a1 {
        @k.e.a.d

        /* renamed from: c  reason: collision with root package name */
        public static final i f15229c = new i();

        private i() {
            super("unknown", false);
        }
    }

    static {
        Map g2 = h.a2.s0.g();
        g2.put(f.f15226c, 0);
        g2.put(e.f15225c, 0);
        g2.put(b.f15222c, 1);
        g2.put(g.f15227c, 1);
        h hVar = h.f15228c;
        g2.put(hVar, 2);
        b = h.a2.s0.d(g2);
        f15220c = hVar;
    }

    private z0() {
    }

    @k.e.a.e
    public final Integer a(@k.e.a.d a1 a1Var, @k.e.a.d a1 a1Var2) {
        if (a1Var == a1Var2) {
            return 0;
        }
        Map<a1, Integer> map = b;
        Integer num = map.get(a1Var);
        Integer num2 = map.get(a1Var2);
        if (num == null || num2 == null || h.k2.v.f0.g(num, num2)) {
            return null;
        }
        return Integer.valueOf(num.intValue() - num2.intValue());
    }

    public final boolean b(@k.e.a.d a1 a1Var) {
        return a1Var == e.f15225c || a1Var == f.f15226c;
    }
}
