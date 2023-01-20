package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import h.e2.c;
import h.e2.k.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@d(c = "kotlinx.coroutines.DeferredCoroutine", f = "Builders.common.kt", i = {0}, l = {101}, m = "await$suspendImpl", n = {"this"}, s = {"L$0"})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0096@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lh/e2/c;", "continuation", "", "await", "(Lh/e2/c;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class DeferredCoroutine$await$1 extends ContinuationImpl {
    public Object L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ DeferredCoroutine this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeferredCoroutine$await$1(DeferredCoroutine deferredCoroutine, c cVar) {
        super(cVar);
        this.this$0 = deferredCoroutine;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @e
    public final Object invokeSuspend(@k.e.a.d Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return DeferredCoroutine.t1(this.this$0, this);
    }
}
