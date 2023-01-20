package i.b.x3;

import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.push.e;
import com.qiniu.android.collect.ReportItem;
import com.umeng.analytics.pro.am;
import e.j.a.b.c.f;
import h.e2.c;
import h.k2.u.l;
import h.k2.u.p;
import h.k2.v.t0;
import h.r0;
import i.b.b0;
import i.b.i2;
import i.b.q0;
import i.b.w3.e0;
import i.b.w3.h0;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.internal.ThreadContextKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a@\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001aT\u0010\u000b\u001a\u00020\u0005\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\u0000*\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\t2\u0006\u0010\n\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002H\u0000ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a@\u0010\r\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0000ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u0007\u001aT\u0010\u000e\u001a\u00020\u0005\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\u0000*\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\t2\u0006\u0010\n\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002H\u0000ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\f\u001a@\u0010\u0010\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u001a\u0010\u000f\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001H\u0082\b¢\u0006\u0004\b\u0010\u0010\u0011\u001a[\u0010\u0014\u001a\u0004\u0018\u00010\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\b*\b\u0012\u0004\u0012\u00028\u00000\u00122\u0006\u0010\n\u001a\u00028\u00012'\u0010\u000f\u001a#\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\t¢\u0006\u0002\b\u0013H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a[\u0010\u0016\u001a\u0004\u0018\u00010\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\b*\b\u0012\u0004\u0012\u00028\u00000\u00122\u0006\u0010\n\u001a\u00028\u00012'\u0010\u000f\u001a#\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\t¢\u0006\u0002\b\u0013H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0015\u001aF\u0010\u001c\u001a\u0004\u0018\u00010\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00122\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00012\u000e\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u001aH\u0082\b¢\u0006\u0004\b\u001c\u0010\u001d\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function1;", "Lh/e2/c;", "", "completion", "Lh/t1;", "c", "(Lh/k2/u/l;Lh/e2/c;)V", "R", "Lkotlin/Function2;", "receiver", f.f10128d, "(Lh/k2/u/p;Ljava/lang/Object;Lh/e2/c;)V", am.av, "b", ReportItem.LogTypeBlock, e.a, "(Lh/e2/c;Lh/k2/u/l;)V", "Li/b/w3/e0;", "Lh/q;", "f", "(Li/b/w3/e0;Ljava/lang/Object;Lh/k2/u/p;)Ljava/lang/Object;", "g", "", "", "shouldThrow", "Lkotlin/Function0;", "startBlock", "h", "(Li/b/w3/e0;Lh/k2/u/l;Lh/k2/u/a;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class b {
    public static final <T> void a(@d l<? super c<? super T>, ? extends Object> lVar, @d c<? super T> cVar) {
        c a = h.e2.k.a.f.a(cVar);
        try {
            CoroutineContext context = cVar.getContext();
            Object c2 = ThreadContextKt.c(context, null);
            if (lVar != null) {
                Object invoke = ((l) t0.q(lVar, 1)).invoke(a);
                ThreadContextKt.a(context, c2);
                if (invoke != h.e2.j.b.h()) {
                    Result.a aVar = Result.Companion;
                    a.resumeWith(Result.m106constructorimpl(invoke));
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            a.resumeWith(Result.m106constructorimpl(r0.a(th)));
        }
    }

    public static final <R, T> void b(@d p<? super R, ? super c<? super T>, ? extends Object> pVar, R r, @d c<? super T> cVar) {
        c a = h.e2.k.a.f.a(cVar);
        try {
            CoroutineContext context = cVar.getContext();
            Object c2 = ThreadContextKt.c(context, null);
            if (pVar != null) {
                Object invoke = ((p) t0.q(pVar, 2)).invoke(r, a);
                ThreadContextKt.a(context, c2);
                if (invoke != h.e2.j.b.h()) {
                    Result.a aVar = Result.Companion;
                    a.resumeWith(Result.m106constructorimpl(invoke));
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            a.resumeWith(Result.m106constructorimpl(r0.a(th)));
        }
    }

    public static final <T> void c(@d l<? super c<? super T>, ? extends Object> lVar, @d c<? super T> cVar) {
        c a = h.e2.k.a.f.a(cVar);
        try {
            if (lVar != null) {
                Object invoke = ((l) t0.q(lVar, 1)).invoke(a);
                if (invoke != h.e2.j.b.h()) {
                    Result.a aVar = Result.Companion;
                    a.resumeWith(Result.m106constructorimpl(invoke));
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            a.resumeWith(Result.m106constructorimpl(r0.a(th)));
        }
    }

    public static final <R, T> void d(@d p<? super R, ? super c<? super T>, ? extends Object> pVar, R r, @d c<? super T> cVar) {
        c a = h.e2.k.a.f.a(cVar);
        try {
            if (pVar != null) {
                Object invoke = ((p) t0.q(pVar, 2)).invoke(r, a);
                if (invoke != h.e2.j.b.h()) {
                    Result.a aVar = Result.Companion;
                    a.resumeWith(Result.m106constructorimpl(invoke));
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            a.resumeWith(Result.m106constructorimpl(r0.a(th)));
        }
    }

    private static final <T> void e(c<? super T> cVar, l<? super c<? super T>, ? extends Object> lVar) {
        c a = h.e2.k.a.f.a(cVar);
        try {
            Object invoke = lVar.invoke(a);
            if (invoke != h.e2.j.b.h()) {
                Result.a aVar = Result.Companion;
                a.resumeWith(Result.m106constructorimpl(invoke));
            }
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            a.resumeWith(Result.m106constructorimpl(r0.a(th)));
        }
    }

    @k.e.a.e
    public static final <T, R> Object f(@d e0<? super T> e0Var, R r, @d p<? super R, ? super c<? super T>, ? extends Object> pVar) {
        Object b0Var;
        Object L0;
        e0Var.n1();
        try {
        } catch (Throwable th) {
            b0Var = new b0(th, false, 2, null);
        }
        if (pVar != null) {
            b0Var = ((p) t0.q(pVar, 2)).invoke(r, e0Var);
            if (b0Var != h.e2.j.b.h() && (L0 = e0Var.L0(b0Var)) != i2.b) {
                if (L0 instanceof b0) {
                    Throwable th2 = ((b0) L0).a;
                    c<? super T> cVar = e0Var.f15877d;
                    if (q0.e() && (cVar instanceof h.e2.k.a.c)) {
                        throw h0.c(th2, (h.e2.k.a.c) cVar);
                    }
                    throw th2;
                }
                return i2.o(L0);
            }
            return h.e2.j.b.h();
        }
        throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
    }

    @k.e.a.e
    public static final <T, R> Object g(@d e0<? super T> e0Var, R r, @d p<? super R, ? super c<? super T>, ? extends Object> pVar) {
        Object b0Var;
        Object L0;
        e0Var.n1();
        boolean z = false;
        try {
        } catch (Throwable th) {
            b0Var = new b0(th, false, 2, null);
        }
        if (pVar != null) {
            b0Var = ((p) t0.q(pVar, 2)).invoke(r, e0Var);
            if (b0Var != h.e2.j.b.h() && (L0 = e0Var.L0(b0Var)) != i2.b) {
                if (L0 instanceof b0) {
                    Throwable th2 = ((b0) L0).a;
                    if (((th2 instanceof TimeoutCancellationException) && ((TimeoutCancellationException) th2).coroutine == e0Var) ? true : true) {
                        c<? super T> cVar = e0Var.f15877d;
                        if (q0.e() && (cVar instanceof h.e2.k.a.c)) {
                            throw h0.c(th2, (h.e2.k.a.c) cVar);
                        }
                        throw th2;
                    } else if (b0Var instanceof b0) {
                        Throwable th3 = ((b0) b0Var).a;
                        c<? super T> cVar2 = e0Var.f15877d;
                        if (q0.e() && (cVar2 instanceof h.e2.k.a.c)) {
                            throw h0.c(th3, (h.e2.k.a.c) cVar2);
                        }
                        throw th3;
                    } else {
                        return b0Var;
                    }
                }
                return i2.o(L0);
            }
            return h.e2.j.b.h();
        }
        throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
    }

    private static final <T> Object h(e0<? super T> e0Var, l<? super Throwable, Boolean> lVar, h.k2.u.a<? extends Object> aVar) {
        Object b0Var;
        Object L0;
        try {
            b0Var = aVar.invoke();
        } catch (Throwable th) {
            b0Var = new b0(th, false, 2, null);
        }
        if (b0Var != h.e2.j.b.h() && (L0 = e0Var.L0(b0Var)) != i2.b) {
            if (L0 instanceof b0) {
                b0 b0Var2 = (b0) L0;
                if (lVar.invoke(b0Var2.a).booleanValue()) {
                    Throwable th2 = b0Var2.a;
                    c<? super T> cVar = e0Var.f15877d;
                    if (q0.e() && (cVar instanceof h.e2.k.a.c)) {
                        throw h0.c(th2, (h.e2.k.a.c) cVar);
                    }
                    throw th2;
                } else if (b0Var instanceof b0) {
                    Throwable th3 = ((b0) b0Var).a;
                    c<? super T> cVar2 = e0Var.f15877d;
                    if (q0.e() && (cVar2 instanceof h.e2.k.a.c)) {
                        throw h0.c(th3, (h.e2.k.a.c) cVar2);
                    }
                    throw th3;
                } else {
                    return b0Var;
                }
            }
            return i2.o(L0);
        }
        return h.e2.j.b.h();
    }
}
