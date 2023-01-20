package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import h.a2.u;
import h.k2.u.a;
import h.p2.b0.g.t.c.t0;
import h.p2.b0.g.t.e.a.x.y;
import java.util.ArrayList;
import java.util.List;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class LazyJavaClassDescriptor$declaredParameters$1 extends Lambda implements a<List<? extends t0>> {
    public final /* synthetic */ LazyJavaClassDescriptor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaClassDescriptor$declaredParameters$1(LazyJavaClassDescriptor lazyJavaClassDescriptor) {
        super(0);
        this.this$0 = lazyJavaClassDescriptor;
    }

    @Override // h.k2.u.a
    @d
    public final List<? extends t0> invoke() {
        List<y> typeParameters = this.this$0.L0().getTypeParameters();
        LazyJavaClassDescriptor lazyJavaClassDescriptor = this.this$0;
        ArrayList arrayList = new ArrayList(u.Y(typeParameters, 10));
        for (y yVar : typeParameters) {
            t0 a = lazyJavaClassDescriptor.f16525m.f().a(yVar);
            if (a == null) {
                throw new AssertionError("Parameter " + yVar + " surely belongs to class " + lazyJavaClassDescriptor.L0() + ", so it must be resolved");
            }
            arrayList.add(a);
        }
        return arrayList;
    }
}
