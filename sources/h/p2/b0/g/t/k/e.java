package h.p2.b0.g.t.k;

import h.p2.b0.g.t.c.j0;
import h.p2.b0.g.t.c.m0;
import h.p2.b0.g.t.c.s0;
import h.p2.b0.g.t.c.t0;
import h.p2.b0.g.t.c.v;
import h.p2.b0.g.t.c.v0;
import h.p2.b0.g.t.n.z;
import h.t1;
import java.util.Comparator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.renderer.AnnotationArgumentsRenderingPolicy;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererModifier;

/* loaded from: classes3.dex */
public class e implements Comparator<h.p2.b0.g.t.c.k> {
    public static final e a = new e();
    private static final DescriptorRenderer b = DescriptorRenderer.a.b(new a());

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ boolean f15470c = false;

    /* loaded from: classes3.dex */
    public static class a implements h.k2.u.l<h.p2.b0.g.t.j.b, t1> {
        @Override // h.k2.u.l
        /* renamed from: a */
        public t1 invoke(h.p2.b0.g.t.j.b bVar) {
            bVar.c(false);
            bVar.n(true);
            bVar.h(AnnotationArgumentsRenderingPolicy.UNLESS_EMPTY);
            bVar.m(DescriptorRendererModifier.ALL);
            return t1.a;
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements Comparator<h.p2.b0.g.t.c.k> {
        public static final b a = new b();

        private b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        @k.e.a.e
        public static Integer c(h.p2.b0.g.t.c.k kVar, h.p2.b0.g.t.c.k kVar2) {
            int d2 = d(kVar2) - d(kVar);
            if (d2 != 0) {
                return Integer.valueOf(d2);
            }
            if (c.B(kVar) && c.B(kVar2)) {
                return 0;
            }
            int compareTo = kVar.getName().compareTo(kVar2.getName());
            if (compareTo != 0) {
                return Integer.valueOf(compareTo);
            }
            return null;
        }

        private static int d(h.p2.b0.g.t.c.k kVar) {
            if (c.B(kVar)) {
                return 8;
            }
            if (kVar instanceof h.p2.b0.g.t.c.j) {
                return 7;
            }
            if (kVar instanceof j0) {
                return ((j0) kVar).Q() == null ? 6 : 5;
            } else if (kVar instanceof v) {
                return ((v) kVar).Q() == null ? 4 : 3;
            } else if (kVar instanceof h.p2.b0.g.t.c.d) {
                return 2;
            } else {
                return kVar instanceof s0 ? 1 : 0;
            }
        }

        @Override // java.util.Comparator
        /* renamed from: b */
        public int compare(h.p2.b0.g.t.c.k kVar, h.p2.b0.g.t.c.k kVar2) {
            Integer c2 = c(kVar, kVar2);
            if (c2 != null) {
                return c2.intValue();
            }
            return 0;
        }
    }

    private e() {
    }

    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(h.p2.b0.g.t.c.k kVar, h.p2.b0.g.t.c.k kVar2) {
        int ordinal;
        Integer c2 = b.c(kVar, kVar2);
        if (c2 != null) {
            return c2.intValue();
        }
        if ((kVar instanceof s0) && (kVar2 instanceof s0)) {
            DescriptorRenderer descriptorRenderer = b;
            int compareTo = descriptorRenderer.y(((s0) kVar).r0()).compareTo(descriptorRenderer.y(((s0) kVar2).r0()));
            if (compareTo != 0) {
                return compareTo;
            }
        } else if ((kVar instanceof h.p2.b0.g.t.c.a) && (kVar2 instanceof h.p2.b0.g.t.c.a)) {
            h.p2.b0.g.t.c.a aVar = (h.p2.b0.g.t.c.a) kVar;
            h.p2.b0.g.t.c.a aVar2 = (h.p2.b0.g.t.c.a) kVar2;
            m0 Q = aVar.Q();
            m0 Q2 = aVar2.Q();
            if (Q != null) {
                DescriptorRenderer descriptorRenderer2 = b;
                int compareTo2 = descriptorRenderer2.y(Q.getType()).compareTo(descriptorRenderer2.y(Q2.getType()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
            }
            List<v0> h2 = aVar.h();
            List<v0> h3 = aVar2.h();
            for (int i2 = 0; i2 < Math.min(h2.size(), h3.size()); i2++) {
                DescriptorRenderer descriptorRenderer3 = b;
                int compareTo3 = descriptorRenderer3.y(h2.get(i2).getType()).compareTo(descriptorRenderer3.y(h3.get(i2).getType()));
                if (compareTo3 != 0) {
                    return compareTo3;
                }
            }
            int size = h2.size() - h3.size();
            if (size != 0) {
                return size;
            }
            List<t0> typeParameters = aVar.getTypeParameters();
            List<t0> typeParameters2 = aVar2.getTypeParameters();
            for (int i3 = 0; i3 < Math.min(typeParameters.size(), typeParameters2.size()); i3++) {
                List<z> upperBounds = typeParameters.get(i3).getUpperBounds();
                List<z> upperBounds2 = typeParameters2.get(i3).getUpperBounds();
                int size2 = upperBounds.size() - upperBounds2.size();
                if (size2 != 0) {
                    return size2;
                }
                for (int i4 = 0; i4 < upperBounds.size(); i4++) {
                    DescriptorRenderer descriptorRenderer4 = b;
                    int compareTo4 = descriptorRenderer4.y(upperBounds.get(i4)).compareTo(descriptorRenderer4.y(upperBounds2.get(i4)));
                    if (compareTo4 != 0) {
                        return compareTo4;
                    }
                }
            }
            int size3 = typeParameters.size() - typeParameters2.size();
            if (size3 != 0) {
                return size3;
            }
            if ((aVar instanceof CallableMemberDescriptor) && (aVar2 instanceof CallableMemberDescriptor) && (ordinal = ((CallableMemberDescriptor) aVar).i().ordinal() - ((CallableMemberDescriptor) aVar2).i().ordinal()) != 0) {
                return ordinal;
            }
        } else if ((kVar instanceof h.p2.b0.g.t.c.d) && (kVar2 instanceof h.p2.b0.g.t.c.d)) {
            h.p2.b0.g.t.c.d dVar = (h.p2.b0.g.t.c.d) kVar;
            h.p2.b0.g.t.c.d dVar2 = (h.p2.b0.g.t.c.d) kVar2;
            if (dVar.i().ordinal() != dVar2.i().ordinal()) {
                return dVar.i().ordinal() - dVar2.i().ordinal();
            }
            if (dVar.a0() != dVar2.a0()) {
                return dVar.a0() ? 1 : -1;
            }
        } else {
            throw new AssertionError(String.format("Unsupported pair of descriptors:\n'%s' Class: %s\n%s' Class: %s", kVar, kVar.getClass(), kVar2, kVar2.getClass()));
        }
        DescriptorRenderer descriptorRenderer5 = b;
        int compareTo5 = descriptorRenderer5.s(kVar).compareTo(descriptorRenderer5.s(kVar2));
        return compareTo5 != 0 ? compareTo5 : c.g(kVar).getName().compareTo(c.g(kVar2).getName());
    }
}
