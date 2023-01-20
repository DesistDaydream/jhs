package kotlin.reflect.jvm.internal;

import h.k2.u.a;
import h.p2.g;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lkotlin/reflect/KClassifier;", "invoke"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class KTypeImpl$classifier$2 extends Lambda implements a<g> {
    public final /* synthetic */ KTypeImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KTypeImpl$classifier$2(KTypeImpl kTypeImpl) {
        super(0);
        this.this$0 = kTypeImpl;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @e
    public final g invoke() {
        g e2;
        KTypeImpl kTypeImpl = this.this$0;
        e2 = kTypeImpl.e(kTypeImpl.getType());
        return e2;
    }
}
