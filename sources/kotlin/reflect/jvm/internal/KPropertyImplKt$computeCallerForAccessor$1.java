package kotlin.reflect.jvm.internal;

import h.k2.u.a;
import h.p2.b0.g.q;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KPropertyImpl;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"isJvmStaticProperty", "", "invoke"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class KPropertyImplKt$computeCallerForAccessor$1 extends Lambda implements a<Boolean> {
    public final /* synthetic */ KPropertyImpl.a $this_computeCallerForAccessor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KPropertyImplKt$computeCallerForAccessor$1(KPropertyImpl.a aVar) {
        super(0);
        this.$this_computeCallerForAccessor = aVar;
    }

    @Override // h.k2.u.a
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return Boolean.valueOf(invoke2());
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [boolean, java.lang.Boolean] */
    @Override // h.k2.u.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Boolean invoke2() {
        return this.$this_computeCallerForAccessor.N().J().getAnnotations().n(q.i());
    }
}
