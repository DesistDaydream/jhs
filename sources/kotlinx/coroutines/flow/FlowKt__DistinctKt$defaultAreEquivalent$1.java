package kotlinx.coroutines.flow;

import h.k2.u.p;
import h.k2.v.f0;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "old", "new", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class FlowKt__DistinctKt$defaultAreEquivalent$1 extends Lambda implements p<Object, Object, Boolean> {
    public static final FlowKt__DistinctKt$defaultAreEquivalent$1 INSTANCE = new FlowKt__DistinctKt$defaultAreEquivalent$1();

    public FlowKt__DistinctKt$defaultAreEquivalent$1() {
        super(2);
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ Boolean invoke(Object obj, Object obj2) {
        return Boolean.valueOf(invoke2(obj, obj2));
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [boolean, java.lang.Boolean] */
    @Override // h.k2.u.p
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Boolean invoke2(@e Object obj, @e Object obj2) {
        return f0.g(obj, obj2);
    }
}
