package h.p2.b0.g.t.c.f1.a;

import com.moor.imkf.lib.jsoup.nodes.Attributes;
import h.k2.v.f0;
import h.k2.v.u;
import h.p2.b0.g.t.e.b.m;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;

/* loaded from: classes3.dex */
public final class f implements h.p2.b0.g.t.e.b.m {
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    public static final a f15191c = new a(null);
    @k.e.a.d
    private final Class<?> a;
    @k.e.a.d
    private final KotlinClassHeader b;

    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @k.e.a.e
        public final f a(@k.e.a.d Class<?> cls) {
            h.p2.b0.g.t.e.b.x.a aVar = new h.p2.b0.g.t.e.b.x.a();
            c.a.b(cls, aVar);
            KotlinClassHeader l2 = aVar.l();
            if (l2 == null) {
                return null;
            }
            return new f(cls, l2, null);
        }
    }

    private f(Class<?> cls, KotlinClassHeader kotlinClassHeader) {
        this.a = cls;
        this.b = kotlinClassHeader;
    }

    public /* synthetic */ f(Class cls, KotlinClassHeader kotlinClassHeader, u uVar) {
        this(cls, kotlinClassHeader);
    }

    @Override // h.p2.b0.g.t.e.b.m
    public void a(@k.e.a.d m.d dVar, @k.e.a.e byte[] bArr) {
        c.a.i(this.a, dVar);
    }

    @Override // h.p2.b0.g.t.e.b.m
    @k.e.a.d
    public h.p2.b0.g.t.g.b b() {
        return ReflectClassUtilKt.a(this.a);
    }

    @Override // h.p2.b0.g.t.e.b.m
    @k.e.a.d
    public KotlinClassHeader c() {
        return this.b;
    }

    @Override // h.p2.b0.g.t.e.b.m
    public void d(@k.e.a.d m.c cVar, @k.e.a.e byte[] bArr) {
        c.a.b(this.a, cVar);
    }

    @k.e.a.d
    public final Class<?> e() {
        return this.a;
    }

    public boolean equals(@k.e.a.e Object obj) {
        return (obj instanceof f) && f0.g(this.a, ((f) obj).a);
    }

    @Override // h.p2.b0.g.t.e.b.m
    @k.e.a.d
    public String getLocation() {
        return f0.C(h.t2.u.j2(this.a.getName(), '.', Attributes.InternalPrefix, false, 4, null), ".class");
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @k.e.a.d
    public String toString() {
        return f.class.getName() + ": " + this.a;
    }
}
