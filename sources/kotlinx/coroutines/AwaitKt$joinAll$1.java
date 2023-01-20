package kotlinx.coroutines;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import h.e2.c;
import h.e2.k.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@d(c = "kotlinx.coroutines.AwaitKt", f = "Await.kt", i = {0, 0, 0, 0}, l = {55}, m = "joinAll", n = {"jobs", "$this$forEach$iv", "element$iv", AdvanceSetting.NETWORK_TYPE}, s = {"L$0", "L$1", "L$3", "L$4"})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0000\"\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0086@¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "Li/b/b2;", "jobs", "Lh/e2/c;", "Lh/t1;", "continuation", "", "joinAll", "(Lkotlin/Array;Lh/e2/c;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class AwaitKt$joinAll$1 extends ContinuationImpl {
    public int I$0;
    public int I$1;
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public Object L$4;
    public int label;
    public /* synthetic */ Object result;

    public AwaitKt$joinAll$1(c cVar) {
        super(cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @e
    public final Object invokeSuspend(@k.e.a.d Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return AwaitKt.d(null, this);
    }
}
