package androidx.lifecycle;

import h.k2.u.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0004\n\u0002\b\u0004\u0010\u0003\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"R", "invoke", "()Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes.dex */
public final class WithLifecycleStateKt$withStateAtLeastUnchecked$2 extends Lambda implements a<R> {
    public final /* synthetic */ a $block;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WithLifecycleStateKt$withStateAtLeastUnchecked$2(a aVar) {
        super(0);
        this.$block = aVar;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [R, java.lang.Object] */
    @Override // h.k2.u.a
    public final R invoke() {
        return this.$block.invoke();
    }
}
