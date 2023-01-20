package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import h.e2.c;
import h.e2.k.a.d;
import i.b.v3.h;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@d(c = "kotlinx.coroutines.flow.FlowKt__CollectionKt", f = "Collection.kt", i = {0, 0, 0}, l = {32}, m = "toCollection", n = {"$this$toCollection", "destination", "$this$collect$iv"}, s = {"L$0", "L$1", "L$2"})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\b\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0000\"\u0010\b\u0001\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0004\u001a\u00028\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005H\u0086@"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "C", "Lkotlinx/coroutines/flow/Flow;", "destination", "Lh/e2/c;", "continuation", "", "toCollection"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class FlowKt__CollectionKt$toCollection$1 extends ContinuationImpl {
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;
    public /* synthetic */ Object result;

    public FlowKt__CollectionKt$toCollection$1(c cVar) {
        super(cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @e
    public final Object invokeSuspend(@k.e.a.d Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return h.g2(null, null, this);
    }
}
