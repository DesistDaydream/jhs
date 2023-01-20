package i.b.t3;

import androidx.exifinterface.media.ExifInterface;
import com.qiniu.android.collect.ReportItem;
import com.tencent.android.tpush.common.MessageKey;
import com.umeng.analytics.pro.am;
import h.t1;
import i.b.i0;
import i.b.n0;
import i.b.q2;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.JobSupport;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u009e\u0001\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062-\b\u0002\u0010\u000f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bj\u0004\u0018\u0001`\u000e2-\u0010\u0015\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0010¢\u0006\u0002\b\u0014H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {ExifInterface.LONGITUDE_EAST, "Li/b/n0;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "capacity", "Lkotlinx/coroutines/CoroutineStart;", MessageKey.MSG_ACCEPT_TIME_START, "Lkotlin/Function1;", "", "Lh/k0;", "name", "cause", "Lh/t1;", "Lkotlinx/coroutines/CompletionHandler;", "onCompletion", "Lkotlin/Function2;", "Li/b/t3/e;", "Lh/e2/c;", "", "Lh/q;", ReportItem.LogTypeBlock, "Li/b/t3/c0;", am.av, "(Li/b/n0;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/CoroutineStart;Lh/k2/u/l;Lh/k2/u/p;)Li/b/t3/c0;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class d {
    @q2
    @k.e.a.d
    public static final <E> c0<E> a(@k.e.a.d n0 n0Var, @k.e.a.d CoroutineContext coroutineContext, int i2, @k.e.a.d CoroutineStart coroutineStart, @k.e.a.e h.k2.u.l<? super Throwable, t1> lVar, @k.e.a.d h.k2.u.p<? super e<E>, ? super h.e2.c<? super t1>, ? extends Object> pVar) {
        c cVar;
        CoroutineContext d2 = i0.d(n0Var, coroutineContext);
        l d3 = n.d(i2, null, null, 6, null);
        if (coroutineStart.isLazy()) {
            cVar = new s(d2, d3, pVar);
        } else {
            cVar = new c(d2, d3, true);
        }
        if (lVar != null) {
            ((JobSupport) cVar).H(lVar);
        }
        ((i.b.a) cVar).r1(coroutineStart, cVar, pVar);
        return cVar;
    }

    public static /* synthetic */ c0 b(n0 n0Var, CoroutineContext coroutineContext, int i2, CoroutineStart coroutineStart, h.k2.u.l lVar, h.k2.u.p pVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        CoroutineContext coroutineContext2 = coroutineContext;
        int i4 = (i3 & 2) != 0 ? 0 : i2;
        if ((i3 & 4) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        CoroutineStart coroutineStart2 = coroutineStart;
        if ((i3 & 8) != 0) {
            lVar = null;
        }
        return a(n0Var, coroutineContext2, i4, coroutineStart2, lVar, pVar);
    }
}
