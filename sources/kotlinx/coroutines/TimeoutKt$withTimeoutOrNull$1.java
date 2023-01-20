package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.qiniu.android.collect.ReportItem;
import h.e2.c;
import h.e2.k.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@d(c = "kotlinx.coroutines.TimeoutKt", f = "Timeout.kt", i = {0, 0, 0}, l = {101}, m = "withTimeoutOrNull", n = {"timeMillis", ReportItem.LogTypeBlock, "coroutine"}, s = {"J$0", "L$0", "L$1"})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\n\u001a\u0004\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012'\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003¢\u0006\u0002\b\u00072\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0005H\u0086@¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "timeMillis", "Lkotlin/Function2;", "Li/b/n0;", "Lh/e2/c;", "", "Lh/q;", ReportItem.LogTypeBlock, "continuation", "withTimeoutOrNull", "(JLh/k2/u/p;Lh/e2/c;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class TimeoutKt$withTimeoutOrNull$1 extends ContinuationImpl {
    public long J$0;
    public Object L$0;
    public Object L$1;
    public int label;
    public /* synthetic */ Object result;

    public TimeoutKt$withTimeoutOrNull$1(c cVar) {
        super(cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @e
    public final Object invokeSuspend(@k.e.a.d Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return TimeoutKt.e(0L, null, this);
    }
}
