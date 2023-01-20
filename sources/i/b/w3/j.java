package i.b.w3;

import androidx.exifinterface.media.ExifInterface;
import h.t1;
import i.b.b2;
import i.b.h3;
import i.b.i1;
import i.b.y0;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.internal.ThreadContextKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0003j\u0002`\u00042\b\u0012\u0004\u0012\u00028\u00000\u0005B\u001d\u0012\u0006\u0010B\u001a\u00020?\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\bM\u0010NJ\u0017\u0010\b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001a\u00020\f2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\n¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\n¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0011¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0013¢\u0006\u0004\b\u0017\u0010\u0018J\u0011\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0010¢\u0006\u0004\b\u001a\u0010\u001bJ \u0010\u001f\u001a\u00020\u001e2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0016ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 JH\u0010%\u001a\u00020\u001e2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c2%\b\b\u0010$\u001a\u001f\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u001e\u0018\u00010!H\u0086\bø\u0001\u0000¢\u0006\u0004\b%\u0010&J!\u0010(\u001a\u00020\u001e2\b\u0010'\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0016\u001a\u00020\u0013H\u0010¢\u0006\u0004\b(\u0010)J\u001a\u0010+\u001a\u00020\f2\b\u0010*\u001a\u0004\u0018\u00010\u0019H\u0086\b¢\u0006\u0004\b+\u0010,J!\u0010-\u001a\u00020\u001e2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0086\bø\u0001\u0000¢\u0006\u0004\b-\u0010 J\u001f\u00101\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00028\u0000H\u0000¢\u0006\u0004\b1\u00102J\u000f\u00104\u001a\u000203H\u0016¢\u0006\u0004\b4\u00105R\u001e\u0010:\u001a\u0004\u0018\u00010\u00198\u0000@\u0000X\u0081\u000e¢\u0006\f\n\u0004\b6\u00107\u0012\u0004\b8\u00109R\u001c\u0010<\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058P@\u0010X\u0090\u0004¢\u0006\u0006\u001a\u0004\b6\u0010;R\u0016\u0010>\u001a\u00020\u00198\u0000@\u0001X\u0081\u0004¢\u0006\u0006\n\u0004\b=\u00107R\u0016\u0010B\u001a\u00020?8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010/\u001a\u00020.8\u0016@\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bC\u0010DR\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010ER\u0019\u0010G\u001a\b\u0012\u0002\b\u0003\u0018\u00010\n8F@\u0006¢\u0006\u0006\u001a\u0004\bF\u0010\u0010R$\u0010L\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00048\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006O"}, d2 = {"Li/b/w3/j;", ExifInterface.GPS_DIRECTION_TRUE, "Li/b/y0;", "Lh/e2/k/a/c;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "Lh/e2/c;", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "Li/b/o;", "requester", "", "r", "(Li/b/o;)Z", "k", "()Li/b/o;", "Li/b/n;", "continuation", "", "i", "(Li/b/n;)Ljava/lang/Throwable;", "cause", "s", "(Ljava/lang/Throwable;)Z", "", "h", "()Ljava/lang/Object;", "Lkotlin/Result;", "result", "Lh/t1;", "resumeWith", "(Ljava/lang/Object;)V", "Lkotlin/Function1;", "Lh/k0;", "name", "onCancellation", "v", "(Ljava/lang/Object;Lh/k2/u/l;)V", "takenState", "c", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "state", "x", "(Ljava/lang/Object;)Z", "y", "Lkotlin/coroutines/CoroutineContext;", "context", "value", "n", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V", "", "toString", "()Ljava/lang/String;", e.j.a.b.c.f.f10128d, "Ljava/lang/Object;", "get_state$kotlinx_coroutines_core$annotations", "()V", "_state", "()Lh/e2/c;", "delegate", "f", "countOrElement", "Lkotlinx/coroutines/CoroutineDispatcher;", "g", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "Lh/e2/c;", "o", "reusableCancellableContinuation", com.huawei.hms.push.e.a, "Lh/e2/k/a/c;", "getCallerFrame", "()Lh/e2/k/a/c;", "callerFrame", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;Lh/e2/c;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class j<T> extends y0<T> implements h.e2.k.a.c, h.e2.c<T> {

    /* renamed from: i */
    private static final AtomicReferenceFieldUpdater f15882i = AtomicReferenceFieldUpdater.newUpdater(j.class, Object.class, "_reusableCancellableContinuation");
    private volatile Object _reusableCancellableContinuation;
    @h.k2.d
    @k.e.a.e

    /* renamed from: d */
    public Object f15883d;
    @k.e.a.e

    /* renamed from: e */
    private final h.e2.k.a.c f15884e;
    @h.k2.d
    @k.e.a.d

    /* renamed from: f */
    public final Object f15885f;
    @h.k2.d
    @k.e.a.d

    /* renamed from: g */
    public final CoroutineDispatcher f15886g;
    @h.k2.d
    @k.e.a.d

    /* renamed from: h */
    public final h.e2.c<T> f15887h;

    /* JADX WARN: Multi-variable type inference failed */
    public j(@k.e.a.d CoroutineDispatcher coroutineDispatcher, @k.e.a.d h.e2.c<? super T> cVar) {
        super(-1);
        i0 i0Var;
        this.f15886g = coroutineDispatcher;
        this.f15887h = cVar;
        i0Var = k.a;
        this.f15883d = i0Var;
        this.f15884e = (h.e2.k.a.c) (cVar instanceof h.e2.k.a.c ? cVar : null);
        this.f15885f = ThreadContextKt.b(getContext());
        this._reusableCancellableContinuation = null;
    }

    public static /* synthetic */ void q() {
    }

    @Override // i.b.y0
    public void c(@k.e.a.e Object obj, @k.e.a.d Throwable th) {
        if (obj instanceof i.b.c0) {
            ((i.b.c0) obj).b.invoke(th);
        }
    }

    @Override // i.b.y0
    @k.e.a.d
    public h.e2.c<T> d() {
        return this;
    }

    @Override // h.e2.k.a.c
    @k.e.a.e
    public h.e2.k.a.c getCallerFrame() {
        return this.f15884e;
    }

    @Override // h.e2.c
    @k.e.a.d
    public CoroutineContext getContext() {
        return this.f15887h.getContext();
    }

    @Override // h.e2.k.a.c
    @k.e.a.e
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // i.b.y0
    @k.e.a.e
    public Object h() {
        i0 i0Var;
        i0 i0Var2;
        Object obj = this.f15883d;
        if (i.b.q0.b()) {
            i0Var2 = k.a;
            if (!(obj != i0Var2)) {
                throw new AssertionError();
            }
        }
        i0Var = k.a;
        this.f15883d = i0Var;
        return obj;
    }

    @k.e.a.e
    public final Throwable i(@k.e.a.d i.b.n<?> nVar) {
        i0 i0Var;
        do {
            Object obj = this._reusableCancellableContinuation;
            i0Var = k.b;
            if (obj != i0Var) {
                if (obj == null) {
                    return null;
                }
                if (obj instanceof Throwable) {
                    if (f15882i.compareAndSet(this, obj, null)) {
                        return (Throwable) obj;
                    }
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        } while (!f15882i.compareAndSet(this, i0Var, nVar));
        return null;
    }

    @k.e.a.e
    public final i.b.o<T> k() {
        Object obj;
        do {
            obj = this._reusableCancellableContinuation;
            if (obj == null) {
                this._reusableCancellableContinuation = k.b;
                return null;
            } else if (!(obj instanceof i.b.o)) {
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        } while (!f15882i.compareAndSet(this, obj, k.b));
        return (i.b.o) obj;
    }

    public final void n(@k.e.a.d CoroutineContext coroutineContext, T t) {
        this.f15883d = t;
        this.f15915c = 1;
        this.f15886g.dispatchYield(coroutineContext, this);
    }

    @k.e.a.e
    public final i.b.o<?> o() {
        Object obj = this._reusableCancellableContinuation;
        if (!(obj instanceof i.b.o)) {
            obj = null;
        }
        return (i.b.o) obj;
    }

    public final boolean r(@k.e.a.d i.b.o<?> oVar) {
        Object obj = this._reusableCancellableContinuation;
        if (obj != null) {
            return !(obj instanceof i.b.o) || obj == oVar;
        }
        return false;
    }

    @Override // h.e2.c
    public void resumeWith(@k.e.a.d Object obj) {
        CoroutineContext context = this.f15887h.getContext();
        Object d2 = i.b.g0.d(obj, null, 1, null);
        if (this.f15886g.isDispatchNeeded(context)) {
            this.f15883d = d2;
            this.f15915c = 0;
            this.f15886g.dispatch(context, this);
            return;
        }
        i.b.q0.b();
        i1 b = h3.b.b();
        if (b.H0()) {
            this.f15883d = d2;
            this.f15915c = 0;
            b.C0(this);
            return;
        }
        b.E0(true);
        try {
            CoroutineContext context2 = getContext();
            Object c2 = ThreadContextKt.c(context2, this.f15885f);
            this.f15887h.resumeWith(obj);
            t1 t1Var = t1.a;
            ThreadContextKt.a(context2, c2);
            do {
            } while (b.K0());
        } finally {
            try {
            } finally {
            }
        }
    }

    public final boolean s(@k.e.a.d Throwable th) {
        while (true) {
            Object obj = this._reusableCancellableContinuation;
            i0 i0Var = k.b;
            if (h.k2.v.f0.g(obj, i0Var)) {
                if (f15882i.compareAndSet(this, i0Var, th)) {
                    return true;
                }
            } else if (obj instanceof Throwable) {
                return true;
            } else {
                if (f15882i.compareAndSet(this, obj, null)) {
                    return false;
                }
            }
        }
    }

    @k.e.a.d
    public String toString() {
        return "DispatchedContinuation[" + this.f15886g + ", " + i.b.r0.c(this.f15887h) + ']';
    }

    public final void v(@k.e.a.d Object obj, @k.e.a.e h.k2.u.l<? super Throwable, t1> lVar) {
        boolean z;
        Object b = i.b.g0.b(obj, lVar);
        if (this.f15886g.isDispatchNeeded(getContext())) {
            this.f15883d = b;
            this.f15915c = 1;
            this.f15886g.dispatch(getContext(), this);
            return;
        }
        i.b.q0.b();
        i1 b2 = h3.b.b();
        if (b2.H0()) {
            this.f15883d = b;
            this.f15915c = 1;
            b2.C0(this);
            return;
        }
        b2.E0(true);
        try {
            b2 b2Var = (b2) getContext().get(b2.y0);
            if (b2Var == null || b2Var.j()) {
                z = false;
            } else {
                CancellationException q = b2Var.q();
                c(b, q);
                Result.a aVar = Result.Companion;
                resumeWith(Result.m106constructorimpl(h.r0.a(q)));
                z = true;
            }
            if (!z) {
                CoroutineContext context = getContext();
                Object c2 = ThreadContextKt.c(context, this.f15885f);
                this.f15887h.resumeWith(obj);
                t1 t1Var = t1.a;
                h.k2.v.c0.d(1);
                ThreadContextKt.a(context, c2);
                h.k2.v.c0.c(1);
            }
            do {
            } while (b2.K0());
            h.k2.v.c0.d(1);
        } catch (Throwable th) {
            try {
                g(th, null);
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
    }

    public final boolean x(@k.e.a.e Object obj) {
        b2 b2Var = (b2) getContext().get(b2.y0);
        if (b2Var == null || b2Var.j()) {
            return false;
        }
        CancellationException q = b2Var.q();
        c(obj, q);
        Result.a aVar = Result.Companion;
        resumeWith(Result.m106constructorimpl(h.r0.a(q)));
        return true;
    }

    public final void y(@k.e.a.d Object obj) {
        CoroutineContext context = getContext();
        Object c2 = ThreadContextKt.c(context, this.f15885f);
        try {
            this.f15887h.resumeWith(obj);
            t1 t1Var = t1.a;
        } finally {
            h.k2.v.c0.d(1);
            ThreadContextKt.a(context, c2);
            h.k2.v.c0.c(1);
        }
    }
}
