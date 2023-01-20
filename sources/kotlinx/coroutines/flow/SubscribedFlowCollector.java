package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.analytics.pro.am;
import h.e2.c;
import h.k2.u.p;
import h.t1;
import i.b.v3.f;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002BG\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012-\u0010\u000f\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\t¢\u0006\u0002\b\fø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0004\u001a\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00028\u0000H\u0096Aø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bR@\u0010\u000f\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\t¢\u0006\u0002\b\f8\u0002@\u0002X\u0082\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/flow/SubscribedFlowCollector;", ExifInterface.GPS_DIRECTION_TRUE, "Li/b/v3/f;", "Lh/t1;", am.av, "(Lh/e2/c;)Ljava/lang/Object;", "value", "emit", "(Ljava/lang/Object;Lh/e2/c;)Ljava/lang/Object;", "Lkotlin/Function2;", "Lh/e2/c;", "", "Lh/q;", "b", "Lh/k2/u/p;", "action", "Li/b/v3/f;", "collector", "<init>", "(Li/b/v3/f;Lh/k2/u/p;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class SubscribedFlowCollector<T> implements f<T> {
    private final f<T> a;
    private final p<f<? super T>, c<? super t1>, Object> b;

    /* JADX WARN: Multi-variable type inference failed */
    public SubscribedFlowCollector(@d f<? super T> fVar, @d p<? super f<? super T>, ? super c<? super t1>, ? extends Object> pVar) {
        this.a = fVar;
        this.b = pVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0072  */
    @k.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(@k.e.a.d h.e2.c<? super h.t1> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof kotlinx.coroutines.flow.SubscribedFlowCollector$onSubscription$1
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.flow.SubscribedFlowCollector$onSubscription$1 r0 = (kotlinx.coroutines.flow.SubscribedFlowCollector$onSubscription$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.SubscribedFlowCollector$onSubscription$1 r0 = new kotlinx.coroutines.flow.SubscribedFlowCollector$onSubscription$1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = h.e2.j.b.h()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4a
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r1 = r0.L$1
            kotlinx.coroutines.flow.internal.SafeCollector r1 = (kotlinx.coroutines.flow.internal.SafeCollector) r1
            java.lang.Object r0 = r0.L$0
            kotlinx.coroutines.flow.SubscribedFlowCollector r0 = (kotlinx.coroutines.flow.SubscribedFlowCollector) r0
            h.r0.n(r7)
            goto L81
        L34:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L3c:
            java.lang.Object r2 = r0.L$1
            kotlinx.coroutines.flow.internal.SafeCollector r2 = (kotlinx.coroutines.flow.internal.SafeCollector) r2
            java.lang.Object r4 = r0.L$0
            kotlinx.coroutines.flow.SubscribedFlowCollector r4 = (kotlinx.coroutines.flow.SubscribedFlowCollector) r4
            h.r0.n(r7)     // Catch: java.lang.Throwable -> L48
            goto L69
        L48:
            r7 = move-exception
            goto L86
        L4a:
            h.r0.n(r7)
            i.b.v3.f<T> r7 = r6.a
            kotlin.coroutines.CoroutineContext r2 = r0.getContext()
            kotlinx.coroutines.flow.internal.SafeCollector r5 = new kotlinx.coroutines.flow.internal.SafeCollector
            r5.<init>(r7, r2)
            h.k2.u.p<i.b.v3.f<? super T>, h.e2.c<? super h.t1>, java.lang.Object> r7 = r6.b     // Catch: java.lang.Throwable -> L84
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L84
            r0.L$1 = r5     // Catch: java.lang.Throwable -> L84
            r0.label = r4     // Catch: java.lang.Throwable -> L84
            java.lang.Object r7 = r7.invoke(r5, r0)     // Catch: java.lang.Throwable -> L84
            if (r7 != r1) goto L67
            return r1
        L67:
            r4 = r6
            r2 = r5
        L69:
            r2.releaseIntercepted()
            i.b.v3.f<T> r7 = r4.a
            boolean r5 = r7 instanceof kotlinx.coroutines.flow.SubscribedFlowCollector
            if (r5 == 0) goto L81
            kotlinx.coroutines.flow.SubscribedFlowCollector r7 = (kotlinx.coroutines.flow.SubscribedFlowCollector) r7
            r0.L$0 = r4
            r0.L$1 = r2
            r0.label = r3
            java.lang.Object r7 = r7.a(r0)
            if (r7 != r1) goto L81
            return r1
        L81:
            h.t1 r7 = h.t1.a
            return r7
        L84:
            r7 = move-exception
            r2 = r5
        L86:
            r2.releaseIntercepted()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.SubscribedFlowCollector.a(h.e2.c):java.lang.Object");
    }

    @Override // i.b.v3.f
    @e
    public Object emit(T t, @d c<? super t1> cVar) {
        return this.a.emit(t, cVar);
    }
}
