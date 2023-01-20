package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.push.e;
import com.qiniu.android.collect.ReportItem;
import h.e2.c;
import h.k2.u.p;
import i.b.a;
import i.b.u0;
import i.b.z3.d;
import i.b.z3.f;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0012\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0012\u0004\u0012\u00028\u00000\u0004B\u0017\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u0005\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\u0007\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJJ\u0010\u0011\u001a\u00020\u0010\"\u0004\b\u0001\u0010\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\n2\"\u0010\u000f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\fH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Lkotlinx/coroutines/DeferredCoroutine;", ExifInterface.GPS_DIRECTION_TRUE, "Li/b/a;", "Li/b/u0;", "Li/b/z3/d;", "n", "()Ljava/lang/Object;", "r", "(Lh/e2/c;)Ljava/lang/Object;", "R", "Li/b/z3/f;", "select", "Lkotlin/Function2;", "Lh/e2/c;", "", ReportItem.LogTypeBlock, "Lh/t1;", e.a, "(Li/b/z3/f;Lh/k2/u/p;)V", "X", "()Li/b/z3/d;", "onAwait", "Lkotlin/coroutines/CoroutineContext;", "parentContext", "", "active", "<init>", "(Lkotlin/coroutines/CoroutineContext;Z)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public class DeferredCoroutine<T> extends a<T> implements u0<T>, d<T> {
    public DeferredCoroutine(@k.e.a.d CoroutineContext coroutineContext, boolean z) {
        super(coroutineContext, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ java.lang.Object t1(kotlinx.coroutines.DeferredCoroutine r4, h.e2.c r5) {
        /*
            boolean r0 = r5 instanceof kotlinx.coroutines.DeferredCoroutine$await$1
            if (r0 == 0) goto L13
            r0 = r5
            kotlinx.coroutines.DeferredCoroutine$await$1 r0 = (kotlinx.coroutines.DeferredCoroutine$await$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.DeferredCoroutine$await$1 r0 = new kotlinx.coroutines.DeferredCoroutine$await$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = h.e2.j.b.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.L$0
            kotlinx.coroutines.DeferredCoroutine r4 = (kotlinx.coroutines.DeferredCoroutine) r4
            h.r0.n(r5)
            goto L43
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            h.r0.n(r5)
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r4.V(r0)
            if (r5 != r1) goto L43
            return r1
        L43:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.DeferredCoroutine.t1(kotlinx.coroutines.DeferredCoroutine, h.e2.c):java.lang.Object");
    }

    @Override // i.b.u0
    @k.e.a.d
    public d<T> X() {
        return this;
    }

    @Override // i.b.z3.d
    public <R> void e(@k.e.a.d f<? super R> fVar, @k.e.a.d p<? super T, ? super c<? super R>, ? extends Object> pVar) {
        X0(fVar, pVar);
    }

    @Override // i.b.u0
    public T n() {
        return (T) n0();
    }

    @Override // i.b.u0
    @k.e.a.e
    public Object r(@k.e.a.d c<? super T> cVar) {
        return t1(this, cVar);
    }
}
