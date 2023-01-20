package kotlinx.coroutines;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import h.e2.c;
import h.e2.k.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@d(c = "kotlinx.coroutines.AwaitKt", f = "Await.kt", i = {0, 0, 0, 0}, l = {67}, m = "joinAll", n = {"$this$joinAll", "$this$forEach$iv", "element$iv", AdvanceSetting.NETWORK_TYPE}, s = {"L$0", "L$1", "L$3", "L$4"})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005*\b\u0012\u0004\u0012\u00020\u00010\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0086@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Li/b/b2;", "Lh/e2/c;", "Lh/t1;", "continuation", "", "joinAll", "(Ljava/util/Collection;Lh/e2/c;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class AwaitKt$joinAll$3 extends ContinuationImpl {
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public Object L$4;
    public int label;
    public /* synthetic */ Object result;

    public AwaitKt$joinAll$3(c cVar) {
        super(cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @e
    public final Object invokeSuspend(@k.e.a.d Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return AwaitKt.c(null, this);
    }
}
