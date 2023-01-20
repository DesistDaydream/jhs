package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.push.e;
import com.qiniu.android.collect.ReportItem;
import e.j.a.b.c.f;
import h.e2.c;
import h.k2.u.p;
import i.b.b0;
import i.b.b2;
import i.b.x;
import i.b.z3.d;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0012\u0004\u0012\u00028\u00000\u0004B\u0011\u0012\b\u0010\"\u001a\u0004\u0018\u00010!¢\u0006\u0004\b#\u0010$J\u000f\u0010\u0005\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\u0007\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJJ\u0010\u0011\u001a\u00020\u0010\"\u0004\b\u0001\u0010\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\n2\"\u0010\u000f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\fH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u00148P@\u0010X\u0090\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006%"}, d2 = {"Lkotlinx/coroutines/CompletableDeferredImpl;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/JobSupport;", "Li/b/x;", "Li/b/z3/d;", "n", "()Ljava/lang/Object;", "r", "(Lh/e2/c;)Ljava/lang/Object;", "R", "Li/b/z3/f;", "select", "Lkotlin/Function2;", "Lh/e2/c;", "", ReportItem.LogTypeBlock, "Lh/t1;", e.a, "(Li/b/z3/f;Lh/k2/u/p;)V", "value", "", "complete", "(Ljava/lang/Object;)Z", "", "exception", f.f10128d, "(Ljava/lang/Throwable;)Z", "X", "()Li/b/z3/d;", "onAwait", "v0", "()Z", "onCancelComplete", "Li/b/b2;", "parent", "<init>", "(Li/b/b2;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class CompletableDeferredImpl<T> extends JobSupport implements x<T>, d<T> {
    public CompletableDeferredImpl(@k.e.a.e b2 b2Var) {
        super(true);
        C0(b2Var);
    }

    @Override // i.b.u0
    @k.e.a.d
    public d<T> X() {
        return this;
    }

    @Override // i.b.x
    public boolean complete(T t) {
        return K0(t);
    }

    @Override // i.b.x
    public boolean d(@k.e.a.d Throwable th) {
        return K0(new b0(th, false, 2, null));
    }

    @Override // i.b.z3.d
    public <R> void e(@k.e.a.d i.b.z3.f<? super R> fVar, @k.e.a.d p<? super T, ? super c<? super R>, ? extends Object> pVar) {
        X0(fVar, pVar);
    }

    @Override // i.b.u0
    public T n() {
        return (T) n0();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    @Override // i.b.u0
    @k.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object r(@k.e.a.d h.e2.c<? super T> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof kotlinx.coroutines.CompletableDeferredImpl$await$1
            if (r0 == 0) goto L13
            r0 = r5
            kotlinx.coroutines.CompletableDeferredImpl$await$1 r0 = (kotlinx.coroutines.CompletableDeferredImpl$await$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.CompletableDeferredImpl$await$1 r0 = new kotlinx.coroutines.CompletableDeferredImpl$await$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = h.e2.j.b.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.L$0
            kotlinx.coroutines.CompletableDeferredImpl r0 = (kotlinx.coroutines.CompletableDeferredImpl) r0
            h.r0.n(r5)
            goto L43
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
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
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.CompletableDeferredImpl.r(h.e2.c):java.lang.Object");
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean v0() {
        return true;
    }
}
