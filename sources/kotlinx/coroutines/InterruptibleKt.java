package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.qiniu.android.collect.ReportItem;
import com.umeng.analytics.pro.am;
import e.j.a.b.c.f;
import h.e2.c;
import h.k2.u.a;
import i.b.e2;
import i.b.g;
import i.b.k3;
import java.util.concurrent.CancellationException;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\u001a1\u0010\u0005\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a+\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0007\u001a\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002¢\u0006\u0004\b\b\u0010\t\"\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\f\"\u0016\u0010\u000f\u001a\u00020\n8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\f\"\u0016\u0010\u0010\u001a\u00020\n8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\f\"\u0016\u0010\u0011\u001a\u00020\n8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlin/Function0;", ReportItem.LogTypeBlock, "b", "(Lkotlin/coroutines/CoroutineContext;Lh/k2/u/a;Lh/e2/c;)Ljava/lang/Object;", "coroutineContext", f.f10128d, "(Lkotlin/coroutines/CoroutineContext;Lh/k2/u/a;)Ljava/lang/Object;", "", am.av, ExpandableTextView.P, "WORKING", "c", "INTERRUPTING", "FINISHED", "INTERRUPTED", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class InterruptibleKt {
    private static final int a = 0;
    private static final int b = 1;

    /* renamed from: c  reason: collision with root package name */
    private static final int f16901c = 2;

    /* renamed from: d  reason: collision with root package name */
    private static final int f16902d = 3;

    @e
    public static final <T> Object b(@d CoroutineContext coroutineContext, @d a<? extends T> aVar, @d c<? super T> cVar) {
        return g.i(coroutineContext, new InterruptibleKt$runInterruptible$2(aVar, null), cVar);
    }

    public static /* synthetic */ Object c(CoroutineContext coroutineContext, a aVar, c cVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return b(coroutineContext, aVar, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> T d(CoroutineContext coroutineContext, a<? extends T> aVar) {
        try {
            k3 k3Var = new k3(e2.C(coroutineContext));
            k3Var.d();
            T invoke = aVar.invoke();
            k3Var.a();
            return invoke;
        } catch (InterruptedException e2) {
            throw new CancellationException("Blocking call was interrupted due to parent cancellation").initCause(e2);
        }
    }
}
