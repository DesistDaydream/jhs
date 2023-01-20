package i.b.w3;

import androidx.exifinterface.media.ExifInterface;
import com.qiniu.android.collect.ReportItem;
import com.umeng.analytics.pro.am;
import h.t1;
import i.b.b2;
import i.b.h3;
import i.b.i1;
import i.b.x1;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.ThreadContextKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u001aW\u0010\u000b\u001a\u00020\t\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022%\b\u0002\u0010\n\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u0019\u0010\u000f\u001a\u00020\u000e*\b\u0012\u0004\u0012\u00020\t0\rH\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001aB\u0010\u0018\u001a\u00020\u000e*\u0006\u0012\u0002\b\u00030\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u000e2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\u0016H\u0082\b¢\u0006\u0004\b\u0018\u0010\u0019\"\u001c\u0010\u001f\u001a\u00020\u001a8\u0002@\u0003X\u0083\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u0012\u0004\b\u001d\u0010\u001e\"\u001c\u0010!\u001a\u00020\u001a8\u0000@\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u001c\u0012\u0004\b \u0010\u001e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lh/e2/c;", "Lkotlin/Result;", "result", "Lkotlin/Function1;", "", "Lh/k0;", "name", "cause", "Lh/t1;", "onCancellation", "f", "(Lh/e2/c;Ljava/lang/Object;Lh/k2/u/l;)V", "Li/b/w3/j;", "", "h", "(Li/b/w3/j;)Z", "", "contState", "", "mode", "doYield", "Lkotlin/Function0;", ReportItem.LogTypeBlock, "b", "(Li/b/w3/j;Ljava/lang/Object;IZLh/k2/u/a;)Z", "Li/b/w3/i0;", am.av, "Li/b/w3/i0;", "getUNDEFINED$annotations", "()V", "UNDEFINED", "getREUSABLE_CLAIMED$annotations", "REUSABLE_CLAIMED", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class k {
    private static final i0 a = new i0("UNDEFINED");
    @h.k2.d
    @k.e.a.d
    public static final i0 b = new i0("REUSABLE_CLAIMED");

    private static final boolean b(j<?> jVar, Object obj, int i2, boolean z, h.k2.u.a<t1> aVar) {
        if (i.b.q0.b()) {
            if (!(i2 != -1)) {
                throw new AssertionError();
            }
        }
        i1 b2 = h3.b.b();
        if (z && b2.I0()) {
            return false;
        }
        if (b2.H0()) {
            jVar.f15883d = obj;
            jVar.f15915c = i2;
            b2.C0(jVar);
            return true;
        }
        b2.E0(true);
        try {
            aVar.invoke();
            do {
            } while (b2.K0());
            h.k2.v.c0.d(1);
        } catch (Throwable th) {
            try {
                jVar.g(th, null);
                h.k2.v.c0.d(1);
            } catch (Throwable th2) {
                h.k2.v.c0.d(1);
                b2.z0(true);
                h.k2.v.c0.c(1);
                throw th2;
            }
        }
        b2.z0(true);
        h.k2.v.c0.c(1);
        return false;
    }

    public static /* synthetic */ boolean c(j jVar, Object obj, int i2, boolean z, h.k2.u.a aVar, int i3, Object obj2) {
        if ((i3 & 4) != 0) {
            z = false;
        }
        if (i.b.q0.b()) {
            if (!(i2 != -1)) {
                throw new AssertionError();
            }
        }
        i1 b2 = h3.b.b();
        if (z && b2.I0()) {
            return false;
        }
        if (b2.H0()) {
            jVar.f15883d = obj;
            jVar.f15915c = i2;
            b2.C0(jVar);
            return true;
        }
        b2.E0(true);
        try {
            aVar.invoke();
            do {
            } while (b2.K0());
            h.k2.v.c0.d(1);
        } catch (Throwable th) {
            try {
                jVar.g(th, null);
                h.k2.v.c0.d(1);
            } catch (Throwable th2) {
                h.k2.v.c0.d(1);
                b2.z0(true);
                h.k2.v.c0.c(1);
                throw th2;
            }
        }
        b2.z0(true);
        h.k2.v.c0.c(1);
        return false;
    }

    public static /* synthetic */ void d() {
    }

    private static /* synthetic */ void e() {
    }

    @x1
    public static final <T> void f(@k.e.a.d h.e2.c<? super T> cVar, @k.e.a.d Object obj, @k.e.a.e h.k2.u.l<? super Throwable, t1> lVar) {
        boolean z;
        if (cVar instanceof j) {
            j jVar = (j) cVar;
            Object b2 = i.b.g0.b(obj, lVar);
            if (jVar.f15886g.isDispatchNeeded(jVar.getContext())) {
                jVar.f15883d = b2;
                jVar.f15915c = 1;
                jVar.f15886g.dispatch(jVar.getContext(), jVar);
                return;
            }
            i.b.q0.b();
            i1 b3 = h3.b.b();
            if (b3.H0()) {
                jVar.f15883d = b2;
                jVar.f15915c = 1;
                b3.C0(jVar);
                return;
            }
            b3.E0(true);
            try {
                b2 b2Var = (b2) jVar.getContext().get(b2.y0);
                if (b2Var == null || b2Var.j()) {
                    z = false;
                } else {
                    CancellationException q = b2Var.q();
                    jVar.c(b2, q);
                    Result.a aVar = Result.Companion;
                    jVar.resumeWith(Result.m106constructorimpl(h.r0.a(q)));
                    z = true;
                }
                if (!z) {
                    CoroutineContext context = jVar.getContext();
                    Object c2 = ThreadContextKt.c(context, jVar.f15885f);
                    jVar.f15887h.resumeWith(obj);
                    t1 t1Var = t1.a;
                    ThreadContextKt.a(context, c2);
                }
                do {
                } while (b3.K0());
            } finally {
                try {
                    return;
                } finally {
                }
            }
            return;
        }
        cVar.resumeWith(obj);
    }

    public static /* synthetic */ void g(h.e2.c cVar, Object obj, h.k2.u.l lVar, int i2, Object obj2) {
        if ((i2 & 2) != 0) {
            lVar = null;
        }
        f(cVar, obj, lVar);
    }

    public static final boolean h(@k.e.a.d j<? super t1> jVar) {
        t1 t1Var = t1.a;
        i.b.q0.b();
        i1 b2 = h3.b.b();
        if (b2.I0()) {
            return false;
        }
        if (b2.H0()) {
            jVar.f15883d = t1Var;
            jVar.f15915c = 1;
            b2.C0(jVar);
            return true;
        }
        b2.E0(true);
        try {
            jVar.run();
            do {
            } while (b2.K0());
        } finally {
            try {
                return false;
            } finally {
            }
        }
        return false;
    }
}
