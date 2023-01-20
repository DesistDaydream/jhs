package kotlin.reflect.jvm.internal.impl.descriptors;

import androidx.exifinterface.media.ExifInterface;
import h.a2.c1;
import h.a2.d1;
import h.a2.l0;
import h.a2.u;
import h.k2.v.f0;
import h.o2.q;
import h.p2.b0.g.t.c.b0;
import h.p2.b0.g.t.c.d1.g0;
import h.p2.b0.g.t.c.k;
import h.p2.b0.g.t.c.o0;
import h.p2.b0.g.t.c.r;
import h.p2.b0.g.t.c.s;
import h.p2.b0.g.t.c.t0;
import h.p2.b0.g.t.c.z;
import h.p2.b0.g.t.g.c;
import h.p2.b0.g.t.m.f;
import h.p2.b0.g.t.m.m;
import h.p2.b0.g.t.n.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* loaded from: classes3.dex */
public final class NotFoundClasses {
    @d
    private final m a;
    @d
    private final z b;
    @d

    /* renamed from: c  reason: collision with root package name */
    private final f<c, b0> f16437c;
    @d

    /* renamed from: d  reason: collision with root package name */
    private final f<a, h.p2.b0.g.t.c.d> f16438d;

    /* loaded from: classes3.dex */
    public static final class a {
        @d
        private final h.p2.b0.g.t.g.b a;
        @d
        private final List<Integer> b;

        public a(@d h.p2.b0.g.t.g.b bVar, @d List<Integer> list) {
            this.a = bVar;
            this.b = list;
        }

        @d
        public final h.p2.b0.g.t.g.b a() {
            return this.a;
        }

        @d
        public final List<Integer> b() {
            return this.b;
        }

        public boolean equals(@e Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return f0.g(this.a, aVar.a) && f0.g(this.b, aVar.b);
            }
            return false;
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        @d
        public String toString() {
            return "ClassRequest(classId=" + this.a + ", typeParametersCount=" + this.b + ')';
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends h.p2.b0.g.t.c.d1.f {

        /* renamed from: j  reason: collision with root package name */
        private final boolean f16439j;
        @d

        /* renamed from: k  reason: collision with root package name */
        private final List<t0> f16440k;
        @d

        /* renamed from: l  reason: collision with root package name */
        private final h f16441l;

        public b(@d m mVar, @d k kVar, @d h.p2.b0.g.t.g.f fVar, boolean z, int i2) {
            super(mVar, kVar, fVar, o0.a, false);
            this.f16439j = z;
            h.o2.k n1 = q.n1(0, i2);
            ArrayList arrayList = new ArrayList(u.Y(n1, 10));
            Iterator<Integer> it = n1.iterator();
            while (it.hasNext()) {
                int nextInt = ((l0) it).nextInt();
                arrayList.add(g0.N0(this, h.p2.b0.g.t.c.b1.e.w0.b(), false, Variance.INVARIANT, h.p2.b0.g.t.g.f.f(f0.C(ExifInterface.GPS_DIRECTION_TRUE, Integer.valueOf(nextInt))), nextInt, mVar));
            }
            this.f16440k = arrayList;
            this.f16441l = new h(this, TypeParameterUtilsKt.d(this), c1.f(DescriptorUtilsKt.l(this).k().i()), mVar);
        }

        @Override // h.p2.b0.g.t.c.d
        @e
        public h.p2.b0.g.t.c.c E() {
            return null;
        }

        @Override // h.p2.b0.g.t.c.d
        @d
        /* renamed from: G0 */
        public MemberScope.b k0() {
            return MemberScope.b.b;
        }

        @Override // h.p2.b0.g.t.c.f
        @d
        /* renamed from: H0 */
        public h j() {
            return this.f16441l;
        }

        @Override // h.p2.b0.g.t.c.d1.r
        @d
        /* renamed from: I0 */
        public MemberScope.b f0(@d h.p2.b0.g.t.n.e1.h hVar) {
            return MemberScope.b.b;
        }

        @Override // h.p2.b0.g.t.c.w
        public boolean X() {
            return false;
        }

        @Override // h.p2.b0.g.t.c.d
        public boolean a0() {
            return false;
        }

        @Override // h.p2.b0.g.t.c.d
        @d
        public Collection<h.p2.b0.g.t.c.c> g() {
            return d1.k();
        }

        @Override // h.p2.b0.g.t.c.b1.a
        @d
        public h.p2.b0.g.t.c.b1.e getAnnotations() {
            return h.p2.b0.g.t.c.b1.e.w0.b();
        }

        @Override // h.p2.b0.g.t.c.d, h.p2.b0.g.t.c.o, h.p2.b0.g.t.c.w
        @d
        public s getVisibility() {
            return r.f15211e;
        }

        @Override // h.p2.b0.g.t.c.d
        @d
        public ClassKind i() {
            return ClassKind.CLASS;
        }

        @Override // h.p2.b0.g.t.c.w
        public boolean i0() {
            return false;
        }

        @Override // h.p2.b0.g.t.c.d1.f, h.p2.b0.g.t.c.w
        public boolean isExternal() {
            return false;
        }

        @Override // h.p2.b0.g.t.c.d
        public boolean isInline() {
            return false;
        }

        @Override // h.p2.b0.g.t.c.d
        @e
        public h.p2.b0.g.t.c.d l0() {
            return null;
        }

        @Override // h.p2.b0.g.t.c.d
        @d
        public Collection<h.p2.b0.g.t.c.d> m() {
            return CollectionsKt__CollectionsKt.E();
        }

        @Override // h.p2.b0.g.t.c.g
        public boolean n() {
            return this.f16439j;
        }

        @Override // h.p2.b0.g.t.c.d, h.p2.b0.g.t.c.g
        @d
        public List<t0> s() {
            return this.f16440k;
        }

        @Override // h.p2.b0.g.t.c.d, h.p2.b0.g.t.c.w
        @d
        public Modality t() {
            return Modality.FINAL;
        }

        @d
        public String toString() {
            return "class " + getName() + " (not found)";
        }

        @Override // h.p2.b0.g.t.c.d
        public boolean v() {
            return false;
        }

        @Override // h.p2.b0.g.t.c.d
        public boolean w() {
            return false;
        }

        @Override // h.p2.b0.g.t.c.d
        public boolean y() {
            return false;
        }
    }

    public NotFoundClasses(@d m mVar, @d z zVar) {
        this.a = mVar;
        this.b = zVar;
        this.f16437c = mVar.i(new NotFoundClasses$packageFragments$1(this));
        this.f16438d = mVar.i(new NotFoundClasses$classes$1(this));
    }

    @d
    public final h.p2.b0.g.t.c.d d(@d h.p2.b0.g.t.g.b bVar, @d List<Integer> list) {
        return this.f16438d.invoke(new a(bVar, list));
    }
}
