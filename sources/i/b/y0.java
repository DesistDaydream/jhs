package i.b;

import androidx.exifinterface.media.ExifInterface;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutinesInternalError;
import kotlinx.coroutines.internal.ThreadContextKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00060\u0002j\u0002`\u0003B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u001c¢\u0006\u0004\b\u001f\u0010 J\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0004H ¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\u000b\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\bH\u0010¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000e\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0010¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0010\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0010¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\n¢\u0006\u0004\b\u0012\u0010\u0013J#\u0010\u0016\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\bH\u0000¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00188 @ X \u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u001d¨\u0006!"}, d2 = {"Li/b/y0;", ExifInterface.GPS_DIRECTION_TRUE, "Li/b/y3/i;", "Lkotlinx/coroutines/SchedulerTask;", "", "h", "()Ljava/lang/Object;", "takenState", "", "cause", "Lh/t1;", "c", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "state", "f", "(Ljava/lang/Object;)Ljava/lang/Object;", com.huawei.hms.push.e.a, "(Ljava/lang/Object;)Ljava/lang/Throwable;", "run", "()V", "exception", "finallyException", "g", "(Ljava/lang/Throwable;Ljava/lang/Throwable;)V", "Lh/e2/c;", e.j.a.b.c.f.f10128d, "()Lh/e2/c;", "delegate", "", ExpandableTextView.P, "resumeMode", "<init>", "(I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public abstract class y0<T> extends i.b.y3.i {
    @h.k2.d

    /* renamed from: c */
    public int f15915c;

    public y0(int i2) {
        this.f15915c = i2;
    }

    public void c(@k.e.a.e Object obj, @k.e.a.d Throwable th) {
    }

    @k.e.a.d
    public abstract h.e2.c<T> d();

    @k.e.a.e
    public Throwable e(@k.e.a.e Object obj) {
        if (!(obj instanceof b0)) {
            obj = null;
        }
        b0 b0Var = (b0) obj;
        if (b0Var != null) {
            return b0Var.a;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T f(@k.e.a.e Object obj) {
        return obj;
    }

    public final void g(@k.e.a.e Throwable th, @k.e.a.e Throwable th2) {
        if (th == null && th2 == null) {
            return;
        }
        if (th != null && th2 != null) {
            h.m.a(th, th2);
        }
        if (th == null) {
            th = th2;
        }
        k0.b(d().getContext(), new CoroutinesInternalError("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    @k.e.a.e
    public abstract Object h();

    @Override // java.lang.Runnable
    public final void run() {
        Object m106constructorimpl;
        Object m106constructorimpl2;
        if (q0.b()) {
            if (!(this.f15915c != -1)) {
                throw new AssertionError();
            }
        }
        i.b.y3.j jVar = this.b;
        try {
            h.e2.c<T> d2 = d();
            if (d2 != null) {
                i.b.w3.j jVar2 = (i.b.w3.j) d2;
                h.e2.c<T> cVar = jVar2.f15887h;
                CoroutineContext context = cVar.getContext();
                Object h2 = h();
                Object c2 = ThreadContextKt.c(context, jVar2.f15885f);
                Throwable e2 = e(h2);
                b2 b2Var = (e2 == null && z0.c(this.f15915c)) ? (b2) context.get(b2.y0) : null;
                if (b2Var != null && !b2Var.j()) {
                    Throwable q = b2Var.q();
                    c(h2, q);
                    Result.a aVar = Result.Companion;
                    if (q0.e() && (cVar instanceof h.e2.k.a.c)) {
                        q = i.b.w3.h0.o(q, (h.e2.k.a.c) cVar);
                    }
                    cVar.resumeWith(Result.m106constructorimpl(h.r0.a(q)));
                } else if (e2 != null) {
                    Result.a aVar2 = Result.Companion;
                    cVar.resumeWith(Result.m106constructorimpl(h.r0.a(e2)));
                } else {
                    T f2 = f(h2);
                    Result.a aVar3 = Result.Companion;
                    cVar.resumeWith(Result.m106constructorimpl(f2));
                }
                h.t1 t1Var = h.t1.a;
                ThreadContextKt.a(context, c2);
                try {
                    Result.a aVar4 = Result.Companion;
                    jVar.c0();
                    m106constructorimpl2 = Result.m106constructorimpl(t1Var);
                } catch (Throwable th) {
                    Result.a aVar5 = Result.Companion;
                    m106constructorimpl2 = Result.m106constructorimpl(h.r0.a(th));
                }
                g(null, Result.m109exceptionOrNullimpl(m106constructorimpl2));
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T>");
        } catch (Throwable th2) {
            try {
                Result.a aVar6 = Result.Companion;
                jVar.c0();
                m106constructorimpl = Result.m106constructorimpl(h.t1.a);
            } catch (Throwable th3) {
                Result.a aVar7 = Result.Companion;
                m106constructorimpl = Result.m106constructorimpl(h.r0.a(th3));
            }
            g(th2, Result.m109exceptionOrNullimpl(m106constructorimpl));
        }
    }
}
