package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.push.e;
import com.qiniu.android.collect.ReportItem;
import com.tencent.android.tpush.common.MessageKey;
import com.umeng.analytics.pro.am;
import e.j.a.b.c.f;
import h.b;
import h.e2.c;
import h.k2.u.a;
import h.k2.u.l;
import h.k2.u.p;
import h.t1;
import i.b.i0;
import i.b.n0;
import i.b.r1;
import i.b.t3.n;
import i.b.t3.v;
import i.b.t3.w;
import i.b.t3.y;
import i.b.x1;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.CoroutineStart;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a+\u0010\u0004\u001a\u00020\u0002*\u0006\u0012\u0002\b\u00030\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0087@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001ag\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010\"\u0004\b\u0000\u0010\u0006*\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2/\b\u0001\u0010\u0003\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\f¢\u0006\u0002\b\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a \u0001\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010\"\u0004\b\u0000\u0010\u0006*\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\u00132-\b\u0002\u0010\u001b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0016¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0015j\u0004\u0018\u0001`\u001a2/\b\u0001\u0010\u0003\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\f¢\u0006\u0002\b\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001aª\u0001\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u0010\"\u0004\b\u0000\u0010\u0006*\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010\u0014\u001a\u00020\u00132-\b\u0002\u0010\u001b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0016¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0015j\u0004\u0018\u0001`\u001a2/\b\u0001\u0010\u0003\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\f¢\u0006\u0002\b\u000fH\u0000ø\u0001\u0000¢\u0006\u0004\b \u0010!\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"Li/b/t3/w;", "Lkotlin/Function0;", "Lh/t1;", ReportItem.LogTypeBlock, am.av, "(Li/b/t3/w;Lh/k2/u/a;Lh/e2/c;)Ljava/lang/Object;", ExifInterface.LONGITUDE_EAST, "Li/b/n0;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "capacity", "Lkotlin/Function2;", "Lh/e2/c;", "", "Lh/q;", "Li/b/t3/y;", "c", "(Li/b/n0;Lkotlin/coroutines/CoroutineContext;ILh/k2/u/p;)Li/b/t3/y;", "Lkotlinx/coroutines/CoroutineStart;", MessageKey.MSG_ACCEPT_TIME_START, "Lkotlin/Function1;", "", "Lh/k0;", "name", "cause", "Lkotlinx/coroutines/CompletionHandler;", "onCompletion", f.f10128d, "(Li/b/n0;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/CoroutineStart;Lh/k2/u/l;Lh/k2/u/p;)Li/b/t3/y;", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", e.a, "(Li/b/n0;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;Lkotlinx/coroutines/CoroutineStart;Lh/k2/u/l;Lh/k2/u/p;)Li/b/t3/y;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class ProduceKt {
    /* JADX WARN: Removed duplicated region for block: B:45:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x003c  */
    @i.b.r1
    @k.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object a(@k.e.a.d i.b.t3.w<?> r4, @k.e.a.d h.k2.u.a<h.t1> r5, @k.e.a.d h.e2.c<? super h.t1> r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.channels.ProduceKt$awaitClose$1
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.channels.ProduceKt$awaitClose$1 r0 = (kotlinx.coroutines.channels.ProduceKt$awaitClose$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.ProduceKt$awaitClose$1 r0 = new kotlinx.coroutines.channels.ProduceKt$awaitClose$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = h.e2.j.b.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r4 = r0.L$1
            r5 = r4
            h.k2.u.a r5 = (h.k2.u.a) r5
            java.lang.Object r4 = r0.L$0
            i.b.t3.w r4 = (i.b.t3.w) r4
            h.r0.n(r6)     // Catch: java.lang.Throwable -> L32
            goto L7c
        L32:
            r4 = move-exception
            goto L82
        L34:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3c:
            h.r0.n(r6)
            kotlin.coroutines.CoroutineContext r6 = r0.getContext()
            i.b.b2$b r2 = i.b.b2.y0
            kotlin.coroutines.CoroutineContext$a r6 = r6.get(r2)
            i.b.b2 r6 = (i.b.b2) r6
            if (r6 != r4) goto L4f
            r6 = 1
            goto L50
        L4f:
            r6 = 0
        L50:
            if (r6 == 0) goto L86
            r0.L$0 = r4     // Catch: java.lang.Throwable -> L32
            r0.L$1 = r5     // Catch: java.lang.Throwable -> L32
            r0.label = r3     // Catch: java.lang.Throwable -> L32
            i.b.o r6 = new i.b.o     // Catch: java.lang.Throwable -> L32
            h.e2.c r2 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.d(r0)     // Catch: java.lang.Throwable -> L32
            r6.<init>(r2, r3)     // Catch: java.lang.Throwable -> L32
            r6.G()     // Catch: java.lang.Throwable -> L32
            kotlinx.coroutines.channels.ProduceKt$awaitClose$4$1 r2 = new kotlinx.coroutines.channels.ProduceKt$awaitClose$4$1     // Catch: java.lang.Throwable -> L32
            r2.<init>(r6)     // Catch: java.lang.Throwable -> L32
            r4.x(r2)     // Catch: java.lang.Throwable -> L32
            java.lang.Object r4 = r6.B()     // Catch: java.lang.Throwable -> L32
            java.lang.Object r6 = h.e2.j.b.h()     // Catch: java.lang.Throwable -> L32
            if (r4 != r6) goto L79
            h.e2.k.a.f.c(r0)     // Catch: java.lang.Throwable -> L32
        L79:
            if (r4 != r1) goto L7c
            return r1
        L7c:
            r5.invoke()
            h.t1 r4 = h.t1.a
            return r4
        L82:
            r5.invoke()
            throw r4
        L86:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "awaitClose() can only be invoked from the producer context"
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ProduceKt.a(i.b.t3.w, h.k2.u.a, h.e2.c):java.lang.Object");
    }

    public static /* synthetic */ Object b(w wVar, a aVar, c cVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            aVar = ProduceKt$awaitClose$2.INSTANCE;
        }
        return a(wVar, aVar, cVar);
    }

    @r1
    @d
    public static final <E> y<E> c(@d n0 n0Var, @d CoroutineContext coroutineContext, int i2, @b @d p<? super w<? super E>, ? super c<? super t1>, ? extends Object> pVar) {
        return e(n0Var, coroutineContext, i2, BufferOverflow.SUSPEND, CoroutineStart.DEFAULT, null, pVar);
    }

    @x1
    @d
    public static final <E> y<E> d(@d n0 n0Var, @d CoroutineContext coroutineContext, int i2, @d CoroutineStart coroutineStart, @k.e.a.e l<? super Throwable, t1> lVar, @b @d p<? super w<? super E>, ? super c<? super t1>, ? extends Object> pVar) {
        return e(n0Var, coroutineContext, i2, BufferOverflow.SUSPEND, coroutineStart, lVar, pVar);
    }

    @d
    public static final <E> y<E> e(@d n0 n0Var, @d CoroutineContext coroutineContext, int i2, @d BufferOverflow bufferOverflow, @d CoroutineStart coroutineStart, @k.e.a.e l<? super Throwable, t1> lVar, @b @d p<? super w<? super E>, ? super c<? super t1>, ? extends Object> pVar) {
        v vVar = new v(i0.d(n0Var, coroutineContext), n.d(i2, bufferOverflow, null, 4, null));
        if (lVar != null) {
            vVar.H(lVar);
        }
        vVar.r1(coroutineStart, vVar, pVar);
        return vVar;
    }

    public static /* synthetic */ y f(n0 n0Var, CoroutineContext coroutineContext, int i2, p pVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return c(n0Var, coroutineContext, i2, pVar);
    }

    public static /* synthetic */ y g(n0 n0Var, CoroutineContext coroutineContext, int i2, CoroutineStart coroutineStart, l lVar, p pVar, int i3, Object obj) {
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
        return d(n0Var, coroutineContext2, i4, coroutineStart2, lVar, pVar);
    }

    public static /* synthetic */ y h(n0 n0Var, CoroutineContext coroutineContext, int i2, BufferOverflow bufferOverflow, CoroutineStart coroutineStart, l lVar, p pVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        CoroutineContext coroutineContext2 = coroutineContext;
        int i4 = (i3 & 2) != 0 ? 0 : i2;
        if ((i3 & 4) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        BufferOverflow bufferOverflow2 = bufferOverflow;
        if ((i3 & 8) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        CoroutineStart coroutineStart2 = coroutineStart;
        if ((i3 & 16) != 0) {
            lVar = null;
        }
        return e(n0Var, coroutineContext2, i4, bufferOverflow2, coroutineStart2, lVar, pVar);
    }
}
