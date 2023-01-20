package h.p2.b0.g.t.j;

import h.a2.z;
import h.k2.v.f0;
import h.p2.b0.g.t.c.b0;
import h.p2.b0.g.t.c.f;
import h.p2.b0.g.t.c.k;
import h.p2.b0.g.t.c.t0;
import java.util.ArrayList;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;

/* loaded from: classes3.dex */
public interface a {

    /* renamed from: h.p2.b0.g.t.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0462a implements a {
        @k.e.a.d
        public static final C0462a a = new C0462a();

        private C0462a() {
        }

        @Override // h.p2.b0.g.t.j.a
        @k.e.a.d
        public String a(@k.e.a.d f fVar, @k.e.a.d DescriptorRenderer descriptorRenderer) {
            return fVar instanceof t0 ? descriptorRenderer.x(((t0) fVar).getName(), false) : descriptorRenderer.w(h.p2.b0.g.t.k.c.m(fVar));
        }
    }

    /* loaded from: classes3.dex */
    public static final class b implements a {
        @k.e.a.d
        public static final b a = new b();

        private b() {
        }

        @Override // h.p2.b0.g.t.j.a
        @k.e.a.d
        public String a(@k.e.a.d f fVar, @k.e.a.d DescriptorRenderer descriptorRenderer) {
            boolean z;
            if (fVar instanceof t0) {
                return descriptorRenderer.x(((t0) fVar).getName(), false);
            }
            ArrayList arrayList = new ArrayList();
            f fVar2 = fVar;
            do {
                arrayList.add(fVar2.getName());
                k b = fVar2.b();
                z = b instanceof h.p2.b0.g.t.c.d;
                fVar2 = b;
            } while (z);
            return e.c(z.Z0(arrayList));
        }
    }

    /* loaded from: classes3.dex */
    public static final class c implements a {
        @k.e.a.d
        public static final c a = new c();

        private c() {
        }

        private final String b(f fVar) {
            String c2;
            String b = e.b(fVar.getName());
            if ((fVar instanceof t0) || (c2 = c(fVar.b())) == null || f0.g(c2, "")) {
                return b;
            }
            return ((Object) c2) + '.' + b;
        }

        private final String c(k kVar) {
            if (kVar instanceof h.p2.b0.g.t.c.d) {
                return b((f) kVar);
            }
            if (kVar instanceof b0) {
                return e.a(((b0) kVar).e().j());
            }
            return null;
        }

        @Override // h.p2.b0.g.t.j.a
        @k.e.a.d
        public String a(@k.e.a.d f fVar, @k.e.a.d DescriptorRenderer descriptorRenderer) {
            return b(fVar);
        }
    }

    @k.e.a.d
    String a(@k.e.a.d f fVar, @k.e.a.d DescriptorRenderer descriptorRenderer);
}
