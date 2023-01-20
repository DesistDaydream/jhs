package h.p2.b0.g.t.b.j;

import androidx.exifinterface.media.ExifInterface;
import h.a2.i0;
import h.k2.v.f0;
import h.k2.v.u;
import h.p2.b0.g.t.c.b1.e;
import h.p2.b0.g.t.c.d1.d0;
import h.p2.b0.g.t.c.d1.o;
import h.p2.b0.g.t.c.k;
import h.p2.b0.g.t.c.m0;
import h.p2.b0.g.t.c.o0;
import h.p2.b0.g.t.c.r;
import h.p2.b0.g.t.c.t0;
import h.p2.b0.g.t.c.v;
import h.p2.b0.g.t.c.v0;
import h.p2.b0.g.t.g.f;
import h.p2.b0.g.t.o.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* loaded from: classes3.dex */
public final class d extends d0 {
    @k.e.a.d
    public static final a D = new a(null);

    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        private final v0 b(d dVar, int i2, t0 t0Var) {
            String lowerCase;
            String b = t0Var.getName().b();
            if (f0.g(b, ExifInterface.GPS_DIRECTION_TRUE)) {
                lowerCase = "instance";
            } else {
                lowerCase = f0.g(b, ExifInterface.LONGITUDE_EAST) ? "receiver" : b.toLowerCase(Locale.ROOT);
            }
            return new ValueParameterDescriptorImpl(dVar, null, i2, e.w0.b(), f.f(lowerCase), t0Var.r(), false, false, false, null, o0.a);
        }

        @k.e.a.d
        public final d a(@k.e.a.d b bVar, boolean z) {
            List<t0> s = bVar.s();
            d dVar = new d(bVar, null, CallableMemberDescriptor.Kind.DECLARATION, z, null);
            m0 F0 = bVar.F0();
            List<? extends t0> E = CollectionsKt__CollectionsKt.E();
            ArrayList arrayList = new ArrayList();
            for (Object obj : s) {
                if (!(((t0) obj).o() == Variance.IN_VARIANCE)) {
                    break;
                }
                arrayList.add(obj);
            }
            Iterable<i0> U5 = CollectionsKt___CollectionsKt.U5(arrayList);
            ArrayList arrayList2 = new ArrayList(h.a2.u.Y(U5, 10));
            for (i0 i0Var : U5) {
                arrayList2.add(d.D.b(dVar, i0Var.e(), (t0) i0Var.f()));
            }
            dVar.N0(null, F0, E, arrayList2, ((t0) CollectionsKt___CollectionsKt.c3(s)).r(), Modality.ABSTRACT, r.f15211e);
            dVar.V0(true);
            return dVar;
        }
    }

    private d(k kVar, d dVar, CallableMemberDescriptor.Kind kind, boolean z) {
        super(kVar, dVar, e.w0.b(), h.f15625h, kind, o0.a);
        b1(true);
        d1(z);
        U0(false);
    }

    public /* synthetic */ d(k kVar, d dVar, CallableMemberDescriptor.Kind kind, boolean z, u uVar) {
        this(kVar, dVar, kind, z);
    }

    private final v l1(List<f> list) {
        boolean z;
        f fVar;
        int size = h().size() - list.size();
        boolean z2 = true;
        List<v0> h2 = h();
        ArrayList arrayList = new ArrayList(h.a2.u.Y(h2, 10));
        for (v0 v0Var : h2) {
            f name = v0Var.getName();
            int f2 = v0Var.f();
            int i2 = f2 - size;
            if (i2 >= 0 && (fVar = list.get(i2)) != null) {
                name = fVar;
            }
            arrayList.add(v0Var.Y(this, name, f2));
        }
        o.c O0 = O0(TypeSubstitutor.b);
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (f fVar2 : list) {
                if (fVar2 == null) {
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
        }
        z2 = false;
        return super.I0(O0.F(z2).b(arrayList).m(h0()));
    }

    @Override // h.p2.b0.g.t.c.d1.o, h.p2.b0.g.t.c.v
    public boolean D() {
        return false;
    }

    @Override // h.p2.b0.g.t.c.d1.d0, h.p2.b0.g.t.c.d1.o
    @k.e.a.d
    public o H0(@k.e.a.d k kVar, @k.e.a.e v vVar, @k.e.a.d CallableMemberDescriptor.Kind kind, @k.e.a.e f fVar, @k.e.a.d e eVar, @k.e.a.d o0 o0Var) {
        return new d(kVar, (d) vVar, kind, isSuspend());
    }

    @Override // h.p2.b0.g.t.c.d1.o
    @k.e.a.e
    public v I0(@k.e.a.d o.c cVar) {
        boolean z;
        d dVar = (d) super.I0(cVar);
        if (dVar == null) {
            return null;
        }
        List<v0> h2 = dVar.h();
        boolean z2 = false;
        if (!(h2 instanceof Collection) || !h2.isEmpty()) {
            for (v0 v0Var : h2) {
                if (h.p2.b0.g.t.b.e.c(v0Var.getType()) != null) {
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
        }
        z2 = true;
        if (z2) {
            return dVar;
        }
        List<v0> h3 = dVar.h();
        ArrayList arrayList = new ArrayList(h.a2.u.Y(h3, 10));
        for (v0 v0Var2 : h3) {
            arrayList.add(h.p2.b0.g.t.b.e.c(v0Var2.getType()));
        }
        return dVar.l1(arrayList);
    }

    @Override // h.p2.b0.g.t.c.d1.o, h.p2.b0.g.t.c.w
    public boolean isExternal() {
        return false;
    }

    @Override // h.p2.b0.g.t.c.d1.o, h.p2.b0.g.t.c.v
    public boolean isInline() {
        return false;
    }
}
