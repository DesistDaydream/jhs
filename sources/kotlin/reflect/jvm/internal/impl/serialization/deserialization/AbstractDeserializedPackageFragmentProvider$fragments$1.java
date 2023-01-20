package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import h.k2.u.l;
import h.p2.b0.g.t.c.b0;
import h.p2.b0.g.t.g.c;
import h.p2.b0.g.t.l.b.k;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class AbstractDeserializedPackageFragmentProvider$fragments$1 extends Lambda implements l<c, b0> {
    public final /* synthetic */ AbstractDeserializedPackageFragmentProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractDeserializedPackageFragmentProvider$fragments$1(AbstractDeserializedPackageFragmentProvider abstractDeserializedPackageFragmentProvider) {
        super(1);
        this.this$0 = abstractDeserializedPackageFragmentProvider;
    }

    @Override // h.k2.u.l
    @e
    public final b0 invoke(@d c cVar) {
        k d2 = this.this$0.d(cVar);
        if (d2 == null) {
            return null;
        }
        d2.H0(this.this$0.e());
        return d2;
    }
}
