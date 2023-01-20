package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import h.k2.u.a;
import h.p2.b0.g.t.c.n0;
import h.p2.b0.g.t.k.b;
import java.util.List;
import k.e.a.d;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class StaticScopeForKotlinEnum$functions$2 extends Lambda implements a<List<? extends n0>> {
    public final /* synthetic */ StaticScopeForKotlinEnum this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StaticScopeForKotlinEnum$functions$2(StaticScopeForKotlinEnum staticScopeForKotlinEnum) {
        super(0);
        this.this$0 = staticScopeForKotlinEnum;
    }

    @Override // h.k2.u.a
    @d
    public final List<? extends n0> invoke() {
        h.p2.b0.g.t.c.d dVar;
        h.p2.b0.g.t.c.d dVar2;
        dVar = this.this$0.b;
        dVar2 = this.this$0.b;
        return CollectionsKt__CollectionsKt.L(b.d(dVar), b.e(dVar2));
    }
}
