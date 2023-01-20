package kotlinx.coroutines.sync;

import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.push.e;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.umeng.analytics.pro.am;
import e.j.a.b.c.f;
import h.k2.u.a;
import h.k2.v.c0;
import i.b.a4.b;
import i.b.a4.c;
import i.b.w3.i0;
import k.e.a.d;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\u001a\u0017\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001aD\u0010\n\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0005*\u00020\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0086Hø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0004\b\n\u0010\u000b\"\u001c\u0010\u0011\u001a\u00020\f8\u0002@\u0003X\u0083\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u0012\u0004\b\u000f\u0010\u0010\"\u001c\u0010\u0016\u001a\u00020\u00128\u0002@\u0003X\u0083\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u0012\u0004\b\u0015\u0010\u0010\"\u001c\u0010\u0018\u001a\u00020\u00128\u0002@\u0003X\u0083\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u0012\u0004\b\u0017\u0010\u0010\"\u001c\u0010\u001b\u001a\u00020\u00128\u0002@\u0003X\u0083\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0014\u0012\u0004\b\u001a\u0010\u0010\"\u001c\u0010\u001e\u001a\u00020\f8\u0002@\u0003X\u0083\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u000e\u0012\u0004\b\u001d\u0010\u0010\"\u001c\u0010!\u001a\u00020\u00128\u0002@\u0003X\u0083\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0014\u0012\u0004\b \u0010\u0010\"\u001c\u0010$\u001a\u00020\u00128\u0002@\u0003X\u0083\u0004¢\u0006\f\n\u0004\b\"\u0010\u0014\u0012\u0004\b#\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006%"}, d2 = {"", "locked", "Li/b/a4/c;", am.av, "(Z)Li/b/a4/c;", ExifInterface.GPS_DIRECTION_TRUE, "", TUIConstants.TUIChat.OWNER, "Lkotlin/Function0;", "action", "q", "(Li/b/a4/c;Ljava/lang/Object;Lh/k2/u/a;Lh/e2/c;)Ljava/lang/Object;", "Li/b/a4/b;", "g", "Li/b/a4/b;", "getEMPTY_UNLOCKED$annotations", "()V", "EMPTY_UNLOCKED", "Li/b/w3/i0;", f.f10128d, "Li/b/w3/i0;", "getLOCKED$annotations", "LOCKED", "getLOCK_FAIL$annotations", "LOCK_FAIL", e.a, "getUNLOCKED$annotations", "UNLOCKED", "f", "getEMPTY_LOCKED$annotations", "EMPTY_LOCKED", "c", "getSELECT_SUCCESS$annotations", "SELECT_SUCCESS", "b", "getUNLOCK_FAIL$annotations", "UNLOCK_FAIL", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class MutexKt {
    private static final i0 a = new i0("LOCK_FAIL");
    private static final i0 b = new i0("UNLOCK_FAIL");

    /* renamed from: c  reason: collision with root package name */
    private static final i0 f17020c = new i0("SELECT_SUCCESS");

    /* renamed from: d  reason: collision with root package name */
    private static final i0 f17021d;

    /* renamed from: e  reason: collision with root package name */
    private static final i0 f17022e;

    /* renamed from: f  reason: collision with root package name */
    private static final b f17023f;

    /* renamed from: g  reason: collision with root package name */
    private static final b f17024g;

    static {
        i0 i0Var = new i0("LOCKED");
        f17021d = i0Var;
        i0 i0Var2 = new i0("UNLOCKED");
        f17022e = i0Var2;
        f17023f = new b(i0Var);
        f17024g = new b(i0Var2);
    }

    @d
    public static final c a(boolean z) {
        return new MutexImpl(z);
    }

    public static /* synthetic */ c b(boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        return a(z);
    }

    private static /* synthetic */ void j() {
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
    /* JADX WARN: Removed duplicated region for block: B:14:0x003c  */
    @k.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object q(@k.e.a.d i.b.a4.c r4, @k.e.a.e java.lang.Object r5, @k.e.a.d h.k2.u.a<? extends T> r6, @k.e.a.d h.e2.c<? super T> r7) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.sync.MutexKt$withLock$1
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.sync.MutexKt$withLock$1 r0 = (kotlinx.coroutines.sync.MutexKt$withLock$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.sync.MutexKt$withLock$1 r0 = new kotlinx.coroutines.sync.MutexKt$withLock$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = h.e2.j.b.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r4 = r0.L$2
            r6 = r4
            h.k2.u.a r6 = (h.k2.u.a) r6
            java.lang.Object r5 = r0.L$1
            java.lang.Object r4 = r0.L$0
            i.b.a4.c r4 = (i.b.a4.c) r4
            h.r0.n(r7)
            goto L4e
        L34:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3c:
            h.r0.n(r7)
            r0.L$0 = r4
            r0.L$1 = r5
            r0.L$2 = r6
            r0.label = r3
            java.lang.Object r7 = r4.c(r5, r0)
            if (r7 != r1) goto L4e
            return r1
        L4e:
            java.lang.Object r6 = r6.invoke()     // Catch: java.lang.Throwable -> L5c
            h.k2.v.c0.d(r3)
            r4.d(r5)
            h.k2.v.c0.c(r3)
            return r6
        L5c:
            r6 = move-exception
            h.k2.v.c0.d(r3)
            r4.d(r5)
            h.k2.v.c0.c(r3)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.MutexKt.q(i.b.a4.c, java.lang.Object, h.k2.u.a, h.e2.c):java.lang.Object");
    }

    @k.e.a.e
    private static final Object r(@d c cVar, @k.e.a.e Object obj, @d a aVar, @d h.e2.c cVar2) {
        c0.e(0);
        cVar.c(obj, cVar2);
        c0.e(2);
        c0.e(1);
        try {
            return aVar.invoke();
        } finally {
            c0.d(1);
            cVar.d(obj);
            c0.c(1);
        }
    }

    public static /* synthetic */ Object s(c cVar, Object obj, a aVar, h.e2.c cVar2, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            obj = null;
        }
        c0.e(0);
        cVar.c(obj, cVar2);
        c0.e(2);
        c0.e(1);
        try {
            return aVar.invoke();
        } finally {
            c0.d(1);
            cVar.d(obj);
            c0.c(1);
        }
    }
}
