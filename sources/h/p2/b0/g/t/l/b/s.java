package h.p2.b0.g.t.l.b;

import h.p2.b0.g.t.c.o0;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;

/* loaded from: classes3.dex */
public abstract class s {
    @k.e.a.d
    private final h.p2.b0.g.t.f.z.c a;
    @k.e.a.d
    private final h.p2.b0.g.t.f.z.g b;
    @k.e.a.e

    /* renamed from: c  reason: collision with root package name */
    private final o0 f15529c;

    /* loaded from: classes3.dex */
    public static final class a extends s {
        @k.e.a.d

        /* renamed from: d  reason: collision with root package name */
        private final ProtoBuf.Class f15530d;
        @k.e.a.e

        /* renamed from: e  reason: collision with root package name */
        private final a f15531e;
        @k.e.a.d

        /* renamed from: f  reason: collision with root package name */
        private final h.p2.b0.g.t.g.b f15532f;
        @k.e.a.d

        /* renamed from: g  reason: collision with root package name */
        private final ProtoBuf.Class.Kind f15533g;

        /* renamed from: h  reason: collision with root package name */
        private final boolean f15534h;

        public a(@k.e.a.d ProtoBuf.Class r2, @k.e.a.d h.p2.b0.g.t.f.z.c cVar, @k.e.a.d h.p2.b0.g.t.f.z.g gVar, @k.e.a.e o0 o0Var, @k.e.a.e a aVar) {
            super(cVar, gVar, o0Var, null);
            this.f15530d = r2;
            this.f15531e = aVar;
            this.f15532f = q.a(cVar, r2.getFqName());
            ProtoBuf.Class.Kind d2 = h.p2.b0.g.t.f.z.b.f15389f.d(r2.getFlags());
            this.f15533g = d2 == null ? ProtoBuf.Class.Kind.CLASS : d2;
            this.f15534h = h.p2.b0.g.t.f.z.b.f15390g.d(r2.getFlags()).booleanValue();
        }

        @Override // h.p2.b0.g.t.l.b.s
        @k.e.a.d
        public h.p2.b0.g.t.g.c a() {
            return this.f15532f.b();
        }

        @k.e.a.d
        public final h.p2.b0.g.t.g.b e() {
            return this.f15532f;
        }

        @k.e.a.d
        public final ProtoBuf.Class f() {
            return this.f15530d;
        }

        @k.e.a.d
        public final ProtoBuf.Class.Kind g() {
            return this.f15533g;
        }

        @k.e.a.e
        public final a h() {
            return this.f15531e;
        }

        public final boolean i() {
            return this.f15534h;
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends s {
        @k.e.a.d

        /* renamed from: d  reason: collision with root package name */
        private final h.p2.b0.g.t.g.c f15535d;

        public b(@k.e.a.d h.p2.b0.g.t.g.c cVar, @k.e.a.d h.p2.b0.g.t.f.z.c cVar2, @k.e.a.d h.p2.b0.g.t.f.z.g gVar, @k.e.a.e o0 o0Var) {
            super(cVar2, gVar, o0Var, null);
            this.f15535d = cVar;
        }

        @Override // h.p2.b0.g.t.l.b.s
        @k.e.a.d
        public h.p2.b0.g.t.g.c a() {
            return this.f15535d;
        }
    }

    private s(h.p2.b0.g.t.f.z.c cVar, h.p2.b0.g.t.f.z.g gVar, o0 o0Var) {
        this.a = cVar;
        this.b = gVar;
        this.f15529c = o0Var;
    }

    public /* synthetic */ s(h.p2.b0.g.t.f.z.c cVar, h.p2.b0.g.t.f.z.g gVar, o0 o0Var, h.k2.v.u uVar) {
        this(cVar, gVar, o0Var);
    }

    @k.e.a.d
    public abstract h.p2.b0.g.t.g.c a();

    @k.e.a.d
    public final h.p2.b0.g.t.f.z.c b() {
        return this.a;
    }

    @k.e.a.e
    public final o0 c() {
        return this.f15529c;
    }

    @k.e.a.d
    public final h.p2.b0.g.t.f.z.g d() {
        return this.b;
    }

    @k.e.a.d
    public String toString() {
        return ((Object) getClass().getSimpleName()) + ": " + a();
    }
}
