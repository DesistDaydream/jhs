package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.qq.e.comm.adevent.AdEventType;
import h.e2.c;
import h.e2.k.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@d(c = "kotlinx.coroutines.flow.FlowKt__EmittersKt", f = "Emitters.kt", i = {0, 0, 0}, l = {AdEventType.VIDEO_CLICKED}, m = "invokeSafely$FlowKt__EmittersKt", n = {"$this$invokeSafely", "action", "cause"}, s = {"L$0", "L$1", "L$2"})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\r\u001a\u0004\u0018\u00010\t\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012D\u0010\u000b\u001a@\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0001\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0002¢\u0006\u0002\b\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0082@¢\u0006\u0004\b\r\u0010\u000e"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Li/b/v3/f;", "Lkotlin/Function3;", "", "Lh/k0;", "name", "cause", "Lh/e2/c;", "Lh/t1;", "", "Lh/q;", "action", "continuation", "invokeSafely", "(Li/b/v3/f;Lh/k2/u/q;Ljava/lang/Throwable;Lh/e2/c;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class FlowKt__EmittersKt$invokeSafely$1 extends ContinuationImpl {
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;
    public /* synthetic */ Object result;

    public FlowKt__EmittersKt$invokeSafely$1(c cVar) {
        super(cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @e
    public final Object invokeSuspend(@k.e.a.d Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return FlowKt__EmittersKt.a(null, null, null, this);
    }
}
