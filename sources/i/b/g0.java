package i.b;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.analytics.pro.am;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aK\u0010\n\u001a\u0004\u0018\u00010\t\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012%\b\u0002\u0010\b\u001a\u001f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0002H\u0000ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a0\u0010\u000e\u001a\u0004\u0018\u00010\t\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\fH\u0000ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a6\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\t2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Result;", "Lkotlin/Function1;", "", "Lh/k0;", "name", "cause", "Lh/t1;", "onCancellation", "", "b", "(Ljava/lang/Object;Lh/k2/u/l;)Ljava/lang/Object;", "Li/b/n;", "caller", "c", "(Ljava/lang/Object;Li/b/n;)Ljava/lang/Object;", "state", "Lh/e2/c;", "uCont", am.av, "(Ljava/lang/Object;Lh/e2/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class g0 {
    @k.e.a.d
    public static final <T> Object a(@k.e.a.e Object obj, @k.e.a.d h.e2.c<? super T> cVar) {
        if (obj instanceof b0) {
            Result.a aVar = Result.Companion;
            Throwable th = ((b0) obj).a;
            if (q0.e() && (cVar instanceof h.e2.k.a.c)) {
                th = i.b.w3.h0.o(th, (h.e2.k.a.c) cVar);
            }
            return Result.m106constructorimpl(h.r0.a(th));
        }
        Result.a aVar2 = Result.Companion;
        return Result.m106constructorimpl(obj);
    }

    @k.e.a.e
    public static final <T> Object b(@k.e.a.d Object obj, @k.e.a.e h.k2.u.l<? super Throwable, h.t1> lVar) {
        Throwable m109exceptionOrNullimpl = Result.m109exceptionOrNullimpl(obj);
        if (m109exceptionOrNullimpl == null) {
            return lVar != null ? new c0(obj, lVar) : obj;
        }
        return new b0(m109exceptionOrNullimpl, false, 2, null);
    }

    @k.e.a.e
    public static final <T> Object c(@k.e.a.d Object obj, @k.e.a.d n<?> nVar) {
        Throwable m109exceptionOrNullimpl = Result.m109exceptionOrNullimpl(obj);
        if (m109exceptionOrNullimpl != null) {
            if (q0.e() && (nVar instanceof h.e2.k.a.c)) {
                m109exceptionOrNullimpl = i.b.w3.h0.o(m109exceptionOrNullimpl, (h.e2.k.a.c) nVar);
            }
            obj = new b0(m109exceptionOrNullimpl, false, 2, null);
        }
        return obj;
    }

    public static /* synthetic */ Object d(Object obj, h.k2.u.l lVar, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            lVar = null;
        }
        return b(obj, lVar);
    }
}
