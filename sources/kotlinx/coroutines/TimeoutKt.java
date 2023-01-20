package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.push.e;
import com.qiniu.android.collect.ReportItem;
import com.umeng.analytics.pro.am;
import e.j.a.b.c.f;
import h.e2.c;
import h.k2.u.p;
import h.u2.j;
import i.b.b2;
import i.b.e2;
import i.b.n0;
import i.b.n3;
import i.b.w0;
import i.b.x3.b;
import k.e.a.d;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aW\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012'\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003¢\u0006\u0002\b\u0007H\u0086@ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0004\b\t\u0010\n\u001aZ\u0010\r\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\f\u001a\u00020\u000b2'\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003¢\u0006\u0002\b\u0007H\u0087@ø\u0001\u0000ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0004\b\r\u0010\u000e\u001aL\u0010\u000f\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012'\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003¢\u0006\u0002\b\u0007H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\n\u001aO\u0010\u0010\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\f\u001a\u00020\u000b2'\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003¢\u0006\u0002\b\u0007H\u0087@ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u000e\u001aa\u0010\u0014\u001a\u0004\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u0011\"\b\b\u0001\u0010\u0000*\u00028\u00002\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00122'\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003¢\u0006\u0002\b\u0007H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001f\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0017H\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "timeMillis", "Lkotlin/Function2;", "Li/b/n0;", "Lh/e2/c;", "", "Lh/q;", ReportItem.LogTypeBlock, "c", "(JLh/k2/u/p;Lh/e2/c;)Ljava/lang/Object;", "Lh/u2/d;", "timeout", f.f10128d, "(DLh/k2/u/p;Lh/e2/c;)Ljava/lang/Object;", e.a, "f", "U", "Li/b/n3;", "coroutine", "b", "(Li/b/n3;Lh/k2/u/p;)Ljava/lang/Object;", "time", "Li/b/b2;", "Lkotlinx/coroutines/TimeoutCancellationException;", am.av, "(JLi/b/b2;)Lkotlinx/coroutines/TimeoutCancellationException;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class TimeoutKt {
    @d
    public static final TimeoutCancellationException a(long j2, @d b2 b2Var) {
        return new TimeoutCancellationException("Timed out waiting for " + j2 + " ms", b2Var);
    }

    private static final <U, T extends U> Object b(n3<U, ? super T> n3Var, p<? super n0, ? super c<? super T>, ? extends Object> pVar) {
        e2.z(n3Var, w0.d(n3Var.f15877d.getContext()).t(n3Var.f15772e, n3Var, n3Var.getContext()));
        return b.g(n3Var, n3Var, pVar);
    }

    @k.e.a.e
    public static final <T> Object c(long j2, @d p<? super n0, ? super c<? super T>, ? extends Object> pVar, @d c<? super T> cVar) {
        if (j2 > 0) {
            Object b = b(new n3(j2, cVar), pVar);
            if (b == h.e2.j.b.h()) {
                h.e2.k.a.f.c(cVar);
            }
            return b;
        }
        throw new TimeoutCancellationException("Timed out immediately");
    }

    @j
    @k.e.a.e
    public static final <T> Object d(double d2, @d p<? super n0, ? super c<? super T>, ? extends Object> pVar, @d c<? super T> cVar) {
        return c(w0.e(d2), pVar, cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x007b  */
    /* JADX WARN: Type inference failed for: r2v1, types: [i.b.n3, T] */
    @k.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object e(long r7, @k.e.a.d h.k2.u.p<? super i.b.n0, ? super h.e2.c<? super T>, ? extends java.lang.Object> r9, @k.e.a.d h.e2.c<? super T> r10) {
        /*
            boolean r0 = r10 instanceof kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1
            if (r0 == 0) goto L13
            r0 = r10
            kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1 r0 = (kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1 r0 = new kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = h.e2.j.b.h()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3e
            if (r2 != r3) goto L36
            java.lang.Object r7 = r0.L$1
            kotlin.jvm.internal.Ref$ObjectRef r7 = (kotlin.jvm.internal.Ref.ObjectRef) r7
            java.lang.Object r8 = r0.L$0
            h.k2.u.p r8 = (h.k2.u.p) r8
            long r8 = r0.J$0
            h.r0.n(r10)     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L34
            goto L6f
        L34:
            r8 = move-exception
            goto L72
        L36:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3e:
            h.r0.n(r10)
            r5 = 0
            int r10 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r10 > 0) goto L48
            return r4
        L48:
            kotlin.jvm.internal.Ref$ObjectRef r10 = new kotlin.jvm.internal.Ref$ObjectRef
            r10.<init>()
            r10.element = r4
            r0.J$0 = r7     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L70
            r0.L$0 = r9     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L70
            r0.L$1 = r10     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L70
            r0.label = r3     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L70
            i.b.n3 r2 = new i.b.n3     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L70
            r2.<init>(r7, r0)     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L70
            r10.element = r2     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L70
            java.lang.Object r7 = b(r2, r9)     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L70
            java.lang.Object r8 = h.e2.j.b.h()     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L70
            if (r7 != r8) goto L6b
            h.e2.k.a.f.c(r0)     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L70
        L6b:
            if (r7 != r1) goto L6e
            return r1
        L6e:
            r10 = r7
        L6f:
            return r10
        L70:
            r8 = move-exception
            r7 = r10
        L72:
            i.b.b2 r9 = r8.coroutine
            T r7 = r7.element
            i.b.n3 r7 = (i.b.n3) r7
            if (r9 != r7) goto L7b
            return r4
        L7b:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.TimeoutKt.e(long, h.k2.u.p, h.e2.c):java.lang.Object");
    }

    @j
    @k.e.a.e
    public static final <T> Object f(double d2, @d p<? super n0, ? super c<? super T>, ? extends Object> pVar, @d c<? super T> cVar) {
        return e(w0.e(d2), pVar, cVar);
    }
}
