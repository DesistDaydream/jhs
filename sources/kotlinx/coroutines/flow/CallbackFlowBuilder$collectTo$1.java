package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import h.e2.c;
import h.e2.k.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@d(c = "kotlinx.coroutines.flow.CallbackFlowBuilder", f = "Builders.kt", i = {0, 0}, l = {358}, m = "collectTo", n = {"this", "scope"}, s = {"L$0", "L$1"})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0094@¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Li/b/t3/w;", "scope", "Lh/e2/c;", "Lh/t1;", "continuation", "", "collectTo", "(Li/b/t3/w;Lh/e2/c;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class CallbackFlowBuilder$collectTo$1 extends ContinuationImpl {
    public Object L$0;
    public Object L$1;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ CallbackFlowBuilder this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallbackFlowBuilder$collectTo$1(CallbackFlowBuilder callbackFlowBuilder, c cVar) {
        super(cVar);
        this.this$0 = callbackFlowBuilder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @e
    public final Object invokeSuspend(@k.e.a.d Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.k(null, this);
    }
}
