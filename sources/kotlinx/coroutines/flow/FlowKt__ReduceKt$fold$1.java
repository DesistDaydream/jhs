package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import h.e2.c;
import h.e2.k.a.d;
import i.b.v3.h;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@d(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0, 0, 0, 0, 0}, l = {151}, m = "fold", n = {"$this$fold", "initial", "operation", "accumulator", "$this$collect$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\r\u001a\u0004\u0018\u00010\n\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0003\u001a\u00028\u00012H\b\u0004\u0010\u000b\u001aB\b\u0001\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\tH\u0086H"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlinx/coroutines/flow/Flow;", "initial", "Lkotlin/Function3;", "Lh/k0;", "name", "acc", "value", "Lh/e2/c;", "", "operation", "continuation", "fold"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class FlowKt__ReduceKt$fold$1 extends ContinuationImpl {
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public Object L$4;
    public int label;
    public /* synthetic */ Object result;

    public FlowKt__ReduceKt$fold$1(c cVar) {
        super(cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @e
    public final Object invokeSuspend(@k.e.a.d Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return h.X0(null, null, null, this);
    }
}
