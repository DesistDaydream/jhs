package i.b;

import androidx.exifinterface.media.ExifInterface;
import com.qiniu.android.collect.ReportItem;
import com.umeng.analytics.pro.am;
import i.b.b2;
import java.util.concurrent.CancellationException;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.JobSupport;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\u001a\u0019\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001b\u0010\u0005\u001a\u00020\u00002\n\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a \u0010\u000b\u001a\u00020\n2\u000e\b\u0004\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0087\b¢\u0006\u0004\b\u000b\u0010\f\u001a\u001b\u0010\u000e\u001a\u00020\n*\u00020\u00002\u0006\u0010\r\u001a\u00020\nH\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0017\u0010\u0010\u001a\u00020\b*\u00020\u0000H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a#\u0010\u0015\u001a\u00020\b*\u00020\u00002\u0010\b\u0002\u0010\u0014\u001a\n\u0018\u00010\u0012j\u0004\u0018\u0001`\u0013¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0013\u0010\u0017\u001a\u00020\b*\u00020\u0000H\u0007¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u001f\u0010\u001a\u001a\u00020\b*\u00020\u00002\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0019H\u0007¢\u0006\u0004\b\u001a\u0010\u001b\u001a#\u0010\u001d\u001a\u00020\b*\u00020\u001c2\u0010\b\u0002\u0010\u0014\u001a\n\u0018\u00010\u0012j\u0004\u0018\u0001`\u0013¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u0013\u0010\u001f\u001a\u00020\b*\u00020\u001cH\u0007¢\u0006\u0004\b\u001f\u0010 \u001a\u0011\u0010!\u001a\u00020\b*\u00020\u0000¢\u0006\u0004\b!\u0010\u0018\u001a\u0011\u0010\"\u001a\u00020\b*\u00020\u001c¢\u0006\u0004\b\"\u0010 \u001a%\u0010%\u001a\u00020\b*\u00020\u00002\u0006\u0010$\u001a\u00020#2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b%\u0010&\u001a\u001f\u0010(\u001a\u00020'*\u00020\u001c2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0019H\u0007¢\u0006\u0004\b(\u0010)\u001a#\u0010*\u001a\u00020\b*\u00020\u001c2\u0010\b\u0002\u0010\u0014\u001a\n\u0018\u00010\u0012j\u0004\u0018\u0001`\u0013¢\u0006\u0004\b*\u0010\u001e\u001a\u0013\u0010+\u001a\u00020\b*\u00020\u001cH\u0007¢\u0006\u0004\b+\u0010 \u001a\u001f\u0010,\u001a\u00020\b*\u00020\u001c2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0019H\u0007¢\u0006\u0004\b,\u0010-\u001a\u001d\u0010/\u001a\u00020\u0019*\u0004\u0018\u00010\u00192\u0006\u0010.\u001a\u00020\u0000H\u0002¢\u0006\u0004\b/\u00100\"\u0017\u00103\u001a\u00020'*\u00020\u001c8F@\u0006¢\u0006\u0006\u001a\u0004\b1\u00102\"\u0017\u0010.\u001a\u00020\u0000*\u00020\u001c8F@\u0006¢\u0006\u0006\u001a\u0004\b4\u00105\u0082\u0002\u0004\n\u0002\b\u0019¨\u00066"}, d2 = {"Li/b/b2;", "parent", "Li/b/z;", "b", "(Li/b/b2;)Li/b/z;", "c", "(Li/b/b2;)Li/b/b2;", "Lkotlin/Function0;", "Lh/t1;", ReportItem.LogTypeBlock, "Li/b/e1;", am.av, "(Lh/k2/u/a;)Li/b/e1;", "handle", "x", "(Li/b/b2;Li/b/e1;)Li/b/e1;", "m", "(Li/b/b2;Lh/e2/c;)Ljava/lang/Object;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cause", "s", "(Li/b/b2;Ljava/util/concurrent/CancellationException;)V", "q", "(Li/b/b2;)V", "", "r", "(Li/b/b2;Ljava/lang/Throwable;)V", "Lkotlin/coroutines/CoroutineContext;", "g", "(Lkotlin/coroutines/CoroutineContext;Ljava/util/concurrent/CancellationException;)V", "f", "(Lkotlin/coroutines/CoroutineContext;)V", am.aD, "y", "", "message", "h", "(Li/b/b2;Ljava/lang/String;Ljava/lang/Throwable;)V", "", "i", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Throwable;)Z", am.ax, "n", "o", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Throwable;)V", "job", "C", "(Ljava/lang/Throwable;Li/b/b2;)Ljava/lang/Throwable;", "B", "(Lkotlin/coroutines/CoroutineContext;)Z", "isActive", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lkotlin/coroutines/CoroutineContext;)Li/b/b2;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 4, 0}, xs = "kotlinx/coroutines/JobKt")
/* loaded from: classes4.dex */
public final /* synthetic */ class g2 {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"i/b/g2$a", "Li/b/e1;", "Lh/t1;", "dispose", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class a implements e1 {
        public final /* synthetic */ h.k2.u.a a;

        public a(h.k2.u.a aVar) {
            this.a = aVar;
        }

        @Override // i.b.e1
        public void dispose() {
            this.a.invoke();
        }
    }

    @k.e.a.d
    public static final b2 A(@k.e.a.d CoroutineContext coroutineContext) {
        b2 b2Var = (b2) coroutineContext.get(b2.y0);
        if (b2Var != null) {
            return b2Var;
        }
        throw new IllegalStateException(("Current context doesn't contain Job in it: " + coroutineContext).toString());
    }

    public static final boolean B(@k.e.a.d CoroutineContext coroutineContext) {
        b2 b2Var = (b2) coroutineContext.get(b2.y0);
        return b2Var != null && b2Var.j();
    }

    private static final Throwable C(Throwable th, b2 b2Var) {
        return th != null ? th : new JobCancellationException("Job was cancelled", null, b2Var);
    }

    @x1
    @k.e.a.d
    public static final e1 a(@k.e.a.d h.k2.u.a<h.t1> aVar) {
        return new a(aVar);
    }

    @k.e.a.d
    public static final z b(@k.e.a.e b2 b2Var) {
        return new d2(b2Var);
    }

    @h.k2.g(name = "Job")
    @h.i(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    @k.e.a.d
    public static final /* synthetic */ b2 c(@k.e.a.e b2 b2Var) {
        return e2.b(b2Var);
    }

    public static /* synthetic */ z d(b2 b2Var, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            b2Var = null;
        }
        return e2.b(b2Var);
    }

    public static /* synthetic */ b2 e(b2 b2Var, int i2, Object obj) {
        b2 c2;
        if ((i2 & 1) != 0) {
            b2Var = null;
        }
        c2 = c(b2Var);
        return c2;
    }

    public static final void g(@k.e.a.d CoroutineContext coroutineContext, @k.e.a.e CancellationException cancellationException) {
        b2 b2Var = (b2) coroutineContext.get(b2.y0);
        if (b2Var != null) {
            b2Var.b(cancellationException);
        }
    }

    public static final void h(@k.e.a.d b2 b2Var, @k.e.a.d String str, @k.e.a.e Throwable th) {
        b2Var.b(n1.a(str, th));
    }

    @h.i(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ boolean i(@k.e.a.d CoroutineContext coroutineContext, @k.e.a.e Throwable th) {
        CoroutineContext.a aVar = coroutineContext.get(b2.y0);
        if (!(aVar instanceof JobSupport)) {
            aVar = null;
        }
        JobSupport jobSupport = (JobSupport) aVar;
        if (jobSupport != null) {
            jobSupport.b0(C(th, jobSupport));
            return true;
        }
        return false;
    }

    public static /* synthetic */ void j(CoroutineContext coroutineContext, CancellationException cancellationException, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            cancellationException = null;
        }
        e2.g(coroutineContext, cancellationException);
    }

    public static /* synthetic */ void k(b2 b2Var, String str, Throwable th, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            th = null;
        }
        e2.h(b2Var, str, th);
    }

    public static /* synthetic */ boolean l(CoroutineContext coroutineContext, Throwable th, int i2, Object obj) {
        boolean i3;
        if ((i2 & 1) != 0) {
            th = null;
        }
        i3 = i(coroutineContext, th);
        return i3;
    }

    @k.e.a.e
    public static final Object m(@k.e.a.d b2 b2Var, @k.e.a.d h.e2.c<? super h.t1> cVar) {
        b2.a.b(b2Var, null, 1, null);
        Object Y = b2Var.Y(cVar);
        return Y == h.e2.j.b.h() ? Y : h.t1.a;
    }

    @h.i(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ void o(@k.e.a.d CoroutineContext coroutineContext, @k.e.a.e Throwable th) {
        b2 b2Var = (b2) coroutineContext.get(b2.y0);
        if (b2Var != null) {
            for (b2 b2Var2 : b2Var.k()) {
                if (!(b2Var2 instanceof JobSupport)) {
                    b2Var2 = null;
                }
                JobSupport jobSupport = (JobSupport) b2Var2;
                if (jobSupport != null) {
                    jobSupport.b0(C(th, b2Var));
                }
            }
        }
    }

    public static final void p(@k.e.a.d CoroutineContext coroutineContext, @k.e.a.e CancellationException cancellationException) {
        h.q2.m<b2> k2;
        b2 b2Var = (b2) coroutineContext.get(b2.y0);
        if (b2Var == null || (k2 = b2Var.k()) == null) {
            return;
        }
        for (b2 b2Var2 : k2) {
            b2Var2.b(cancellationException);
        }
    }

    @h.i(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ void r(@k.e.a.d b2 b2Var, @k.e.a.e Throwable th) {
        for (b2 b2Var2 : b2Var.k()) {
            if (!(b2Var2 instanceof JobSupport)) {
                b2Var2 = null;
            }
            JobSupport jobSupport = (JobSupport) b2Var2;
            if (jobSupport != null) {
                jobSupport.b0(C(th, b2Var));
            }
        }
    }

    public static final void s(@k.e.a.d b2 b2Var, @k.e.a.e CancellationException cancellationException) {
        for (b2 b2Var2 : b2Var.k()) {
            b2Var2.b(cancellationException);
        }
    }

    public static /* synthetic */ void t(CoroutineContext coroutineContext, Throwable th, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            th = null;
        }
        o(coroutineContext, th);
    }

    public static /* synthetic */ void u(CoroutineContext coroutineContext, CancellationException cancellationException, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            cancellationException = null;
        }
        e2.p(coroutineContext, cancellationException);
    }

    public static /* synthetic */ void v(b2 b2Var, Throwable th, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            th = null;
        }
        r(b2Var, th);
    }

    public static /* synthetic */ void w(b2 b2Var, CancellationException cancellationException, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            cancellationException = null;
        }
        e2.s(b2Var, cancellationException);
    }

    @k.e.a.d
    public static final e1 x(@k.e.a.d b2 b2Var, @k.e.a.d e1 e1Var) {
        return b2Var.H(new g1(b2Var, e1Var));
    }

    public static final void y(@k.e.a.d CoroutineContext coroutineContext) {
        b2 b2Var = (b2) coroutineContext.get(b2.y0);
        if (b2Var != null) {
            e2.B(b2Var);
        }
    }

    public static final void z(@k.e.a.d b2 b2Var) {
        if (!b2Var.j()) {
            throw b2Var.q();
        }
    }
}
