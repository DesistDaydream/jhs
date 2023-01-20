package kotlinx.coroutines.flow.internal;

import androidx.exifinterface.media.ExifInterface;
import com.qiniu.android.collect.ReportItem;
import com.umeng.analytics.pro.am;
import e.j.a.b.c.f;
import h.b;
import h.e2.c;
import h.k2.u.p;
import h.k2.u.q;
import h.t1;
import i.b.i0;
import i.b.n0;
import i.b.t3.n;
import i.b.t3.w;
import i.b.t3.y;
import i.b.v3.c0.h;
import i.b.v3.c0.j;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.Flow;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aD\u0010\u0007\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002)\b\u0001\u0010\u0006\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001¢\u0006\u0002\b\u0005H\u0080@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001aU\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f\"\u0004\b\u0000\u0010\u000025\b\u0001\u0010\u0006\u001a/\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\t¢\u0006\u0002\b\u0005H\u0000ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001ae\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015\"\u0004\b\u0000\u0010\u000f*\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00122/\b\u0001\u0010\u0006\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001¢\u0006\u0002\b\u0005H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"R", "Lkotlin/Function2;", "Li/b/n0;", "Lh/e2/c;", "", "Lh/q;", ReportItem.LogTypeBlock, "c", "(Lh/k2/u/p;Lh/e2/c;)Ljava/lang/Object;", "Lkotlin/Function3;", "Li/b/v3/f;", "Lh/t1;", "Lkotlinx/coroutines/flow/Flow;", f.f10128d, "(Lh/k2/u/q;)Lkotlinx/coroutines/flow/Flow;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/coroutines/CoroutineContext;", "context", "", "capacity", "Li/b/t3/w;", "Li/b/t3/y;", am.av, "(Li/b/n0;Lkotlin/coroutines/CoroutineContext;ILh/k2/u/p;)Li/b/t3/y;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class FlowCoroutineKt {
    @d
    public static final <T> y<T> a(@d n0 n0Var, @d CoroutineContext coroutineContext, int i2, @b @d p<? super w<? super T>, ? super c<? super t1>, ? extends Object> pVar) {
        j jVar = new j(i0.d(n0Var, coroutineContext), n.d(i2, null, null, 6, null));
        jVar.r1(CoroutineStart.ATOMIC, jVar, pVar);
        return jVar;
    }

    public static /* synthetic */ y b(n0 n0Var, CoroutineContext coroutineContext, int i2, p pVar, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return a(n0Var, coroutineContext, i2, pVar);
    }

    @e
    public static final <R> Object c(@b @d p<? super n0, ? super c<? super R>, ? extends Object> pVar, @d c<? super R> cVar) {
        h hVar = new h(cVar.getContext(), cVar);
        Object f2 = i.b.x3.b.f(hVar, hVar, pVar);
        if (f2 == h.e2.j.b.h()) {
            h.e2.k.a.f.c(cVar);
        }
        return f2;
    }

    @d
    public static final <R> Flow<R> d(@b @d q<? super n0, ? super i.b.v3.f<? super R>, ? super c<? super t1>, ? extends Object> qVar) {
        return new FlowCoroutineKt$scopedFlow$$inlined$unsafeFlow$1(qVar);
    }
}
