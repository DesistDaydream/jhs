package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import h.k2.u.l;
import h.p2.b0.g.t.c.b1.c;
import h.p2.b0.g.t.e.a.t.b;
import h.p2.b0.g.t.e.a.x.a;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class LazyJavaAnnotations$annotationDescriptors$1 extends Lambda implements l<a, c> {
    public final /* synthetic */ LazyJavaAnnotations this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaAnnotations$annotationDescriptors$1(LazyJavaAnnotations lazyJavaAnnotations) {
        super(1);
        this.this$0 = lazyJavaAnnotations;
    }

    @Override // h.k2.u.l
    @e
    public final c invoke(@d a aVar) {
        h.p2.b0.g.t.e.a.v.e eVar;
        boolean z;
        b bVar = b.a;
        eVar = this.this$0.a;
        z = this.this$0.f16502c;
        return bVar.e(aVar, eVar, z);
    }
}
