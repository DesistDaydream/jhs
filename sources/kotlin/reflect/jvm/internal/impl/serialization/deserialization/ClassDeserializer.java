package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import h.a2.c1;
import h.k2.u.l;
import h.k2.v.f0;
import h.k2.v.u;
import h.p2.b0.g.t.b.g;
import h.p2.b0.g.t.c.b0;
import h.p2.b0.g.t.c.d0;
import h.p2.b0.g.t.c.o0;
import h.p2.b0.g.t.f.z.c;
import h.p2.b0.g.t.l.b.i;
import h.p2.b0.g.t.l.b.k;
import java.util.Iterator;
import java.util.Set;
import k.e.a.d;
import k.e.a.e;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;

/* loaded from: classes3.dex */
public final class ClassDeserializer {
    @d

    /* renamed from: c  reason: collision with root package name */
    public static final b f16794c = new b(null);
    @d

    /* renamed from: d  reason: collision with root package name */
    private static final Set<h.p2.b0.g.t.g.b> f16795d = c1.f(h.p2.b0.g.t.g.b.m(g.a.f15037d.l()));
    @d
    private final h.p2.b0.g.t.l.b.g a;
    @d
    private final l<a, h.p2.b0.g.t.c.d> b;

    /* loaded from: classes3.dex */
    public static final class a {
        @d
        private final h.p2.b0.g.t.g.b a;
        @e
        private final h.p2.b0.g.t.l.b.d b;

        public a(@d h.p2.b0.g.t.g.b bVar, @e h.p2.b0.g.t.l.b.d dVar) {
            this.a = bVar;
            this.b = dVar;
        }

        @e
        public final h.p2.b0.g.t.l.b.d a() {
            return this.b;
        }

        @d
        public final h.p2.b0.g.t.g.b b() {
            return this.a;
        }

        public boolean equals(@e Object obj) {
            return (obj instanceof a) && f0.g(this.a, ((a) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    /* loaded from: classes3.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(u uVar) {
            this();
        }

        @d
        public final Set<h.p2.b0.g.t.g.b> a() {
            return ClassDeserializer.f16795d;
        }
    }

    public ClassDeserializer(@d h.p2.b0.g.t.l.b.g gVar) {
        this.a = gVar;
        this.b = gVar.u().g(new ClassDeserializer$classes$1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final h.p2.b0.g.t.c.d c(a aVar) {
        Object obj;
        i a2;
        boolean z;
        h.p2.b0.g.t.g.b b2 = aVar.b();
        for (h.p2.b0.g.t.c.c1.b bVar : this.a.k()) {
            h.p2.b0.g.t.c.d c2 = bVar.c(b2);
            if (c2 != null) {
                return c2;
            }
        }
        if (f16795d.contains(b2)) {
            return null;
        }
        h.p2.b0.g.t.l.b.d a3 = aVar.a();
        if (a3 == null && (a3 = this.a.e().a(b2)) == null) {
            return null;
        }
        c a4 = a3.a();
        ProtoBuf.Class b3 = a3.b();
        h.p2.b0.g.t.f.z.a c3 = a3.c();
        o0 d2 = a3.d();
        h.p2.b0.g.t.g.b g2 = b2.g();
        if (g2 != null) {
            h.p2.b0.g.t.c.d e2 = e(this, g2, null, 2, null);
            DeserializedClassDescriptor deserializedClassDescriptor = e2 instanceof DeserializedClassDescriptor ? (DeserializedClassDescriptor) e2 : null;
            if (deserializedClassDescriptor == null || !deserializedClassDescriptor.Y0(b2.j())) {
                return null;
            }
            a2 = deserializedClassDescriptor.S0();
        } else {
            Iterator<T> it = d0.c(this.a.r(), b2.h()).iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                b0 b0Var = (b0) obj;
                if (!(b0Var instanceof k) || ((k) b0Var).G0(b2.j())) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    break;
                }
            }
            b0 b0Var2 = (b0) obj;
            if (b0Var2 == null) {
                return null;
            }
            a2 = this.a.a(b0Var2, a4, new h.p2.b0.g.t.f.z.g(b3.getTypeTable()), h.p2.b0.g.t.f.z.i.b.a(b3.getVersionRequirementTable()), c3, null);
        }
        return new DeserializedClassDescriptor(a2, b3, a4, c3, d2);
    }

    public static /* synthetic */ h.p2.b0.g.t.c.d e(ClassDeserializer classDeserializer, h.p2.b0.g.t.g.b bVar, h.p2.b0.g.t.l.b.d dVar, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            dVar = null;
        }
        return classDeserializer.d(bVar, dVar);
    }

    @e
    public final h.p2.b0.g.t.c.d d(@d h.p2.b0.g.t.g.b bVar, @e h.p2.b0.g.t.l.b.d dVar) {
        return this.b.invoke(new a(bVar, dVar));
    }
}
