package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.qiniu.android.collect.ReportItem;
import com.tencent.android.tpush.common.MessageKey;
import com.umeng.analytics.pro.am;
import h.b;
import h.e2.c;
import h.k2.u.l;
import h.k2.u.p;
import h.t1;
import i.b.b1;
import i.b.i0;
import i.b.n0;
import i.b.o0;
import i.b.t3.i;
import i.b.t3.j;
import i.b.t3.k;
import i.b.t3.t;
import i.b.t3.w;
import i.b.t3.y;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.JobSupport;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a7\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b\u001a\u009e\u0001\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u0000*\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042-\b\u0002\u0010\u0013\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\fj\u0004\u0018\u0001`\u00122/\b\u0001\u0010\u0019\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0014¢\u0006\u0002\b\u0018ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {ExifInterface.LONGITUDE_EAST, "Li/b/t3/y;", "", "capacity", "Lkotlinx/coroutines/CoroutineStart;", MessageKey.MSG_ACCEPT_TIME_START, "Li/b/t3/i;", "b", "(Li/b/t3/y;ILkotlinx/coroutines/CoroutineStart;)Li/b/t3/i;", "Li/b/n0;", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlin/Function1;", "", "Lh/k0;", "name", "cause", "Lh/t1;", "Lkotlinx/coroutines/CompletionHandler;", "onCompletion", "Lkotlin/Function2;", "Li/b/t3/w;", "Lh/e2/c;", "", "Lh/q;", ReportItem.LogTypeBlock, am.av, "(Li/b/n0;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/CoroutineStart;Lh/k2/u/l;Lh/k2/u/p;)Li/b/t3/i;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class BroadcastKt {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\n¸\u0006\u000b"}, d2 = {"kotlinx/coroutines/channels/BroadcastKt$a", "Lh/e2/a;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "exception", "Lh/t1;", "handleException", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Throwable;)V", "kotlinx-coroutines-core", "i/b/k0$a"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class a extends h.e2.a implements CoroutineExceptionHandler {
        public a(CoroutineContext.b bVar) {
            super(bVar);
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(@d CoroutineContext coroutineContext, @d Throwable th) {
        }
    }

    @d
    public static final <E> i<E> a(@d n0 n0Var, @d CoroutineContext coroutineContext, int i2, @d CoroutineStart coroutineStart, @e l<? super Throwable, t1> lVar, @b @d p<? super w<? super E>, ? super c<? super t1>, ? extends Object> pVar) {
        k kVar;
        CoroutineContext d2 = i0.d(n0Var, coroutineContext);
        i a2 = j.a(i2);
        if (coroutineStart.isLazy()) {
            kVar = new t(d2, a2, pVar);
        } else {
            kVar = new k(d2, a2, true);
        }
        if (lVar != null) {
            ((JobSupport) kVar).H(lVar);
        }
        ((i.b.a) kVar).r1(coroutineStart, kVar, pVar);
        return kVar;
    }

    @d
    public static final <E> i<E> b(@d y<? extends E> yVar, int i2, @d CoroutineStart coroutineStart) {
        return c(o0.m(o0.m(i.b.t1.a, b1.g()), new a(CoroutineExceptionHandler.x0)), null, i2, coroutineStart, new BroadcastKt$broadcast$1(yVar), new BroadcastKt$broadcast$2(yVar, null), 1, null);
    }

    public static /* synthetic */ i c(n0 n0Var, CoroutineContext coroutineContext, int i2, CoroutineStart coroutineStart, l lVar, p pVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        CoroutineContext coroutineContext2 = coroutineContext;
        int i4 = (i3 & 2) != 0 ? 1 : i2;
        if ((i3 & 4) != 0) {
            coroutineStart = CoroutineStart.LAZY;
        }
        CoroutineStart coroutineStart2 = coroutineStart;
        if ((i3 & 8) != 0) {
            lVar = null;
        }
        return a(n0Var, coroutineContext2, i4, coroutineStart2, lVar, pVar);
    }

    public static /* synthetic */ i d(y yVar, int i2, CoroutineStart coroutineStart, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 1;
        }
        if ((i3 & 2) != 0) {
            coroutineStart = CoroutineStart.LAZY;
        }
        return b(yVar, i2, coroutineStart);
    }
}
