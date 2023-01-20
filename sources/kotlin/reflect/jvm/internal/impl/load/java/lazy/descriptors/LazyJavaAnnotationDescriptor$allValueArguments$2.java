package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import h.a2.t0;
import h.k2.u.a;
import h.p2.b0.g.t.e.a.p;
import h.p2.b0.g.t.e.a.x.b;
import h.p2.b0.g.t.g.f;
import h.p2.b0.g.t.k.n.g;
import h.z0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import k.e.a.d;
import kotlin.Pair;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class LazyJavaAnnotationDescriptor$allValueArguments$2 extends Lambda implements a<Map<f, ? extends g<?>>> {
    public final /* synthetic */ LazyJavaAnnotationDescriptor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaAnnotationDescriptor$allValueArguments$2(LazyJavaAnnotationDescriptor lazyJavaAnnotationDescriptor) {
        super(0);
        this.this$0 = lazyJavaAnnotationDescriptor;
    }

    @Override // h.k2.u.a
    @d
    public final Map<f, ? extends g<?>> invoke() {
        h.p2.b0.g.t.e.a.x.a aVar;
        g k2;
        aVar = this.this$0.b;
        Collection<b> u = aVar.u();
        LazyJavaAnnotationDescriptor lazyJavaAnnotationDescriptor = this.this$0;
        ArrayList arrayList = new ArrayList();
        for (b bVar : u) {
            f name = bVar.getName();
            if (name == null) {
                name = p.f15244c;
            }
            k2 = lazyJavaAnnotationDescriptor.k(bVar);
            Pair a = k2 == null ? null : z0.a(name, k2);
            if (a != null) {
                arrayList.add(a);
            }
        }
        return t0.B0(arrayList);
    }
}
