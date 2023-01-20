package i.b;

import androidx.exifinterface.media.ExifInterface;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.qiniu.android.collect.ReportItem;
import com.umeng.analytics.pro.am;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.internal.ThreadContextKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0012\u001a'\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a5\u0010\u000b\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u0017\u0010\r\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\u0001H\u0002¢\u0006\u0004\b\r\u0010\u000e\u001a.\u0010\u0013\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011H\u0080\b¢\u0006\u0004\b\u0013\u0010\u0014\u001a \u0010\u0017\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\u0016\u001a\u00020\u0015H\u0080\b¢\u0006\u0004\b\u0017\u0010\u0018\"\u001a\u0010\u001b\u001a\u00020\t*\u00020\u00028@@\u0000X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a\"\u0016\u0010\u001d\u001a\u00020\u00028\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u000b\u0010\u001c\"\u0016\u0010\u001e\u001a\u00020\u00028\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0019\u0010\u001c\"\u001a\u0010 \u001a\u00020\t*\u00020\u00028@@\u0000X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001a\"\u0016\u0010!\u001a\u00020\u00028\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0005\u0010\u001c\"\u001c\u0010%\u001a\u00020\u00028\u0000@\u0001X\u0081T¢\u0006\f\n\u0004\b\"\u0010\u001c\u0012\u0004\b#\u0010$\"\u0016\u0010&\u001a\u00020\u00028\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u001f\u0010\u001c¨\u0006'"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Li/b/y0;", "", "mode", "Lh/t1;", am.av, "(Li/b/y0;I)V", "Lh/e2/c;", "delegate", "", "undispatched", com.huawei.hms.push.e.a, "(Li/b/y0;Lh/e2/c;Z)V", "f", "(Li/b/y0;)V", "Li/b/i1;", "eventLoop", "Lkotlin/Function0;", ReportItem.LogTypeBlock, "h", "(Li/b/y0;Li/b/i1;Lh/k2/u/a;)V", "", "exception", "g", "(Lh/e2/c;Ljava/lang/Throwable;)V", e.j.a.b.c.f.f10128d, "(I)Z", "isReusableMode", ExpandableTextView.P, "MODE_UNINITIALIZED", "MODE_UNDISPATCHED", "c", "isCancellableMode", "MODE_ATOMIC", "b", "getMODE_CANCELLABLE$annotations", "()V", "MODE_CANCELLABLE", "MODE_CANCELLABLE_REUSABLE", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class z0 {
    public static final int a = 0;
    public static final int b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f15942c = 2;

    /* renamed from: d  reason: collision with root package name */
    public static final int f15943d = 4;

    /* renamed from: e  reason: collision with root package name */
    public static final int f15944e = -1;

    public static final <T> void a(@k.e.a.d y0<? super T> y0Var, int i2) {
        if (q0.b()) {
            if (!(i2 != -1)) {
                throw new AssertionError();
            }
        }
        h.e2.c<? super T> d2 = y0Var.d();
        boolean z = i2 == 4;
        if (!z && (d2 instanceof i.b.w3.j) && c(i2) == c(y0Var.f15915c)) {
            CoroutineDispatcher coroutineDispatcher = ((i.b.w3.j) d2).f15886g;
            CoroutineContext context = d2.getContext();
            if (coroutineDispatcher.isDispatchNeeded(context)) {
                coroutineDispatcher.dispatch(context, y0Var);
                return;
            } else {
                f(y0Var);
                return;
            }
        }
        e(y0Var, d2, z);
    }

    @h.p0
    public static /* synthetic */ void b() {
    }

    public static final boolean c(int i2) {
        return i2 == 1 || i2 == 2;
    }

    public static final boolean d(int i2) {
        return i2 == 2;
    }

    public static final <T> void e(@k.e.a.d y0<? super T> y0Var, @k.e.a.d h.e2.c<? super T> cVar, boolean z) {
        Object f2;
        Object h2 = y0Var.h();
        Throwable e2 = y0Var.e(h2);
        if (e2 != null) {
            Result.a aVar = Result.Companion;
            f2 = h.r0.a(e2);
        } else {
            Result.a aVar2 = Result.Companion;
            f2 = y0Var.f(h2);
        }
        Object m106constructorimpl = Result.m106constructorimpl(f2);
        if (z) {
            Objects.requireNonNull(cVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T>");
            i.b.w3.j jVar = (i.b.w3.j) cVar;
            CoroutineContext context = jVar.getContext();
            Object c2 = ThreadContextKt.c(context, jVar.f15885f);
            try {
                jVar.f15887h.resumeWith(m106constructorimpl);
                h.t1 t1Var = h.t1.a;
                return;
            } finally {
                ThreadContextKt.a(context, c2);
            }
        }
        cVar.resumeWith(m106constructorimpl);
    }

    private static final void f(y0<?> y0Var) {
        i1 b2 = h3.b.b();
        if (b2.H0()) {
            b2.C0(y0Var);
            return;
        }
        b2.E0(true);
        try {
            e(y0Var, y0Var.d(), true);
            do {
            } while (b2.K0());
        } finally {
            try {
            } finally {
            }
        }
    }

    public static final void g(@k.e.a.d h.e2.c<?> cVar, @k.e.a.d Throwable th) {
        Result.a aVar = Result.Companion;
        if (q0.e() && (cVar instanceof h.e2.k.a.c)) {
            th = i.b.w3.h0.o(th, (h.e2.k.a.c) cVar);
        }
        cVar.resumeWith(Result.m106constructorimpl(h.r0.a(th)));
    }

    public static final void h(@k.e.a.d y0<?> y0Var, @k.e.a.d i1 i1Var, @k.e.a.d h.k2.u.a<h.t1> aVar) {
        i1Var.E0(true);
        try {
            aVar.invoke();
            do {
            } while (i1Var.K0());
            h.k2.v.c0.d(1);
        } catch (Throwable th) {
            try {
                y0Var.g(th, null);
                h.k2.v.c0.d(1);
            } catch (Throwable th2) {
                h.k2.v.c0.d(1);
                i1Var.z0(true);
                h.k2.v.c0.c(1);
                throw th2;
            }
        }
        i1Var.z0(true);
        h.k2.v.c0.c(1);
    }
}
