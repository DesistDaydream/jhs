package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import h.k2.u.l;
import h.p2.b0.g.t.c.k;
import h.p2.b0.g.t.e.a.v.i.d;
import h.p2.b0.g.t.e.a.x.y;
import java.util.Map;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class LazyJavaTypeParameterResolver$resolve$1 extends Lambda implements l<y, d> {
    public final /* synthetic */ LazyJavaTypeParameterResolver this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaTypeParameterResolver$resolve$1(LazyJavaTypeParameterResolver lazyJavaTypeParameterResolver) {
        super(1);
        this.this$0 = lazyJavaTypeParameterResolver;
    }

    @Override // h.k2.u.l
    @e
    public final d invoke(@k.e.a.d y yVar) {
        Map map;
        h.p2.b0.g.t.e.a.v.e eVar;
        k kVar;
        int i2;
        k kVar2;
        map = this.this$0.f16505d;
        Integer num = (Integer) map.get(yVar);
        if (num == null) {
            return null;
        }
        LazyJavaTypeParameterResolver lazyJavaTypeParameterResolver = this.this$0;
        int intValue = num.intValue();
        eVar = lazyJavaTypeParameterResolver.a;
        h.p2.b0.g.t.e.a.v.e b = ContextKt.b(eVar, lazyJavaTypeParameterResolver);
        kVar = lazyJavaTypeParameterResolver.b;
        h.p2.b0.g.t.e.a.v.e h2 = ContextKt.h(b, kVar.getAnnotations());
        i2 = lazyJavaTypeParameterResolver.f16504c;
        int i3 = i2 + intValue;
        kVar2 = lazyJavaTypeParameterResolver.b;
        return new d(h2, yVar, i3, kVar2);
    }
}
