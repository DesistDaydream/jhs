package kotlinx.coroutines.sync;

import androidx.exifinterface.media.ExifInterface;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.huawei.hms.push.e;
import com.umeng.analytics.pro.am;
import e.j.a.b.c.f;
import h.e2.c;
import h.k2.u.a;
import h.k2.v.c0;
import i.b.w3.i0;
import i.b.w3.m0;
import k.e.a.d;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\u001a\u001f\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a8\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0006*\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0086Hø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\t\u0010\n\u001a!\u0010\u000f\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010\"\u001c\u0010\u0016\u001a\u00020\u00118\u0002@\u0003X\u0083\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u0012\u0004\b\u0014\u0010\u0015\"\u001c\u0010\u0019\u001a\u00020\u00118\u0002@\u0003X\u0083\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0013\u0012\u0004\b\u0018\u0010\u0015\"\u001c\u0010\u001d\u001a\u00020\u00008\u0002@\u0003X\u0083\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u0012\u0004\b\u001c\u0010\u0015\"\u001c\u0010\u001f\u001a\u00020\u00008\u0002@\u0003X\u0083\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u001b\u0012\u0004\b\u001e\u0010\u0015\"\u001c\u0010\"\u001a\u00020\u00118\u0002@\u0003X\u0083\u0004¢\u0006\f\n\u0004\b \u0010\u0013\u0012\u0004\b!\u0010\u0015\"\u001c\u0010%\u001a\u00020\u00118\u0002@\u0003X\u0083\u0004¢\u0006\f\n\u0004\b#\u0010\u0013\u0012\u0004\b$\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006&"}, d2 = {"", "permits", "acquiredPermits", "Li/b/a4/d;", am.av, "(II)Li/b/a4/d;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function0;", "action", "q", "(Li/b/a4/d;Lh/k2/u/a;Lh/e2/c;)Ljava/lang/Object;", "", "id", "Li/b/a4/e;", "prev", "j", "(JLi/b/a4/e;)Li/b/a4/e;", "Li/b/w3/i0;", "c", "Li/b/w3/i0;", "getTAKEN$annotations", "()V", "TAKEN", e.a, "getCANCELLED$annotations", "CANCELLED", "f", ExpandableTextView.P, "getSEGMENT_SIZE$annotations", "SEGMENT_SIZE", "getMAX_SPIN_CYCLES$annotations", "MAX_SPIN_CYCLES", f.f10128d, "getBROKEN$annotations", "BROKEN", "b", "getPERMIT$annotations", "PERMIT", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class SemaphoreKt {
    private static final int a;
    private static final i0 b;

    /* renamed from: c  reason: collision with root package name */
    private static final i0 f17030c;

    /* renamed from: d  reason: collision with root package name */
    private static final i0 f17031d;

    /* renamed from: e  reason: collision with root package name */
    private static final i0 f17032e;

    /* renamed from: f  reason: collision with root package name */
    private static final int f17033f;

    static {
        int d2;
        int d3;
        d2 = m0.d("kotlinx.coroutines.semaphore.maxSpinCycles", 100, 0, 0, 12, null);
        a = d2;
        b = new i0("PERMIT");
        f17030c = new i0("TAKEN");
        f17031d = new i0("BROKEN");
        f17032e = new i0("CANCELLED");
        d3 = m0.d("kotlinx.coroutines.semaphore.segmentSize", 16, 0, 0, 12, null);
        f17033f = d3;
    }

    @d
    public static final i.b.a4.d a(int i2, int i3) {
        return new SemaphoreImpl(i2, i3);
    }

    public static /* synthetic */ i.b.a4.d b(int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i3 = 0;
        }
        return a(i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final i.b.a4.e j(long j2, i.b.a4.e eVar) {
        return new i.b.a4.e(j2, eVar, 0);
    }

    private static /* synthetic */ void k() {
    }

    private static /* synthetic */ void l() {
    }

    private static /* synthetic */ void m() {
    }

    private static /* synthetic */ void n() {
    }

    private static /* synthetic */ void o() {
    }

    private static /* synthetic */ void p() {
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    @k.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object q(@k.e.a.d i.b.a4.d r4, @k.e.a.d h.k2.u.a<? extends T> r5, @k.e.a.d h.e2.c<? super T> r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.sync.SemaphoreKt$withPermit$1
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.sync.SemaphoreKt$withPermit$1 r0 = (kotlinx.coroutines.sync.SemaphoreKt$withPermit$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.sync.SemaphoreKt$withPermit$1 r0 = new kotlinx.coroutines.sync.SemaphoreKt$withPermit$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = h.e2.j.b.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r4 = r0.L$1
            r5 = r4
            h.k2.u.a r5 = (h.k2.u.a) r5
            java.lang.Object r4 = r0.L$0
            i.b.a4.d r4 = (i.b.a4.d) r4
            h.r0.n(r6)
            goto L4a
        L32:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3a:
            h.r0.n(r6)
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r6 = r4.c(r0)
            if (r6 != r1) goto L4a
            return r1
        L4a:
            java.lang.Object r5 = r5.invoke()     // Catch: java.lang.Throwable -> L58
            h.k2.v.c0.d(r3)
            r4.release()
            h.k2.v.c0.c(r3)
            return r5
        L58:
            r5 = move-exception
            h.k2.v.c0.d(r3)
            r4.release()
            h.k2.v.c0.c(r3)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.SemaphoreKt.q(i.b.a4.d, h.k2.u.a, h.e2.c):java.lang.Object");
    }

    @k.e.a.e
    private static final Object r(@d i.b.a4.d dVar, @d a aVar, @d c cVar) {
        c0.e(0);
        dVar.c(cVar);
        c0.e(2);
        c0.e(1);
        try {
            return aVar.invoke();
        } finally {
            c0.d(1);
            dVar.release();
            c0.c(1);
        }
    }
}
