package i.b;

import androidx.exifinterface.media.ExifInterface;
import com.qiniu.android.collect.ReportItem;
import com.umeng.analytics.pro.am;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.CoroutineStart;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aV\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012'\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003¢\u0006\u0002\b\u0007ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0004\b\t\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlin/Function2;", "Li/b/n0;", "Lh/e2/c;", "", "Lh/q;", ReportItem.LogTypeBlock, am.av, "(Lkotlin/coroutines/CoroutineContext;Lh/k2/u/p;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 4, 0}, xs = "kotlinx/coroutines/BuildersKt")
/* loaded from: classes4.dex */
public final /* synthetic */ class h {
    public static final <T> T a(@k.e.a.d CoroutineContext coroutineContext, @k.e.a.d h.k2.u.p<? super n0, ? super h.e2.c<? super T>, ? extends Object> pVar) throws InterruptedException {
        i1 a;
        CoroutineContext d2;
        Thread currentThread = Thread.currentThread();
        h.e2.d dVar = (h.e2.d) coroutineContext.get(h.e2.d.v0);
        if (dVar == null) {
            a = h3.b.b();
            d2 = i0.d(t1.a, coroutineContext.plus(a));
        } else {
            if (!(dVar instanceof i1)) {
                dVar = null;
            }
            i1 i1Var = (i1) dVar;
            if (i1Var != null) {
                i1 i1Var2 = i1Var.L0() ? i1Var : null;
                if (i1Var2 != null) {
                    a = i1Var2;
                    d2 = i0.d(t1.a, coroutineContext);
                }
            }
            a = h3.b.a();
            d2 = i0.d(t1.a, coroutineContext);
        }
        e eVar = new e(d2, currentThread, a);
        eVar.r1(CoroutineStart.DEFAULT, eVar, pVar);
        return (T) eVar.t1();
    }

    public static /* synthetic */ Object b(CoroutineContext coroutineContext, h.k2.u.p pVar, int i2, Object obj) throws InterruptedException {
        if ((i2 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return g.g(coroutineContext, pVar);
    }
}
