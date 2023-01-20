package kotlinx.coroutines.android;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.qiniu.android.collect.ReportItem;
import com.umeng.analytics.pro.am;
import e.j.a.b.c.f;
import h.k2.v.f0;
import h.k2.v.u;
import h.o2.q;
import h.t1;
import h.u2.e;
import i.b.e1;
import i.b.n;
import i.b.v0;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B#\b\u0002\u0012\u0006\u0010.\u001a\u00020+\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0017\u0012\u0006\u0010*\u001a\u00020\u0005¢\u0006\u0004\b0\u00101B\u001d\b\u0016\u0012\u0006\u0010.\u001a\u00020+\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b0\u00102J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\n\u0010\n\u001a\u00060\bj\u0002`\tH\u0016¢\u0006\u0004\b\f\u0010\rJ%\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J+\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u000e2\n\u0010\n\u001a\u00060\bj\u0002`\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0096\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\u001f\u0010 R\u001c\u0010%\u001a\u00020\u00008\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0018\u0010'\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010&R\u0016\u0010*\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0018\u0010/\u001a\u0004\u0018\u00010\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010\"¨\u00063"}, d2 = {"Lkotlinx/coroutines/android/HandlerContext;", "Li/b/s3/a;", "Li/b/v0;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "isDispatchNeeded", "(Lkotlin/coroutines/CoroutineContext;)Z", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", ReportItem.LogTypeBlock, "Lh/t1;", "dispatch", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "", "timeMillis", "Li/b/n;", "continuation", "c", "(JLi/b/n;)V", "Li/b/e1;", am.aI, "(JLjava/lang/Runnable;Lkotlin/coroutines/CoroutineContext;)Li/b/e1;", "", "toString", "()Ljava/lang/String;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", TTDownloadField.TT_HASHCODE, "()I", am.av, "Lkotlinx/coroutines/android/HandlerContext;", "D0", "()Lkotlinx/coroutines/android/HandlerContext;", "immediate", "Ljava/lang/String;", "name", f.f10128d, "Z", "invokeImmediately", "Landroid/os/Handler;", "b", "Landroid/os/Handler;", "handler", "_immediate", "<init>", "(Landroid/os/Handler;Ljava/lang/String;Z)V", "(Landroid/os/Handler;Ljava/lang/String;)V", "kotlinx-coroutines-android"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class HandlerContext extends i.b.s3.a implements v0 {
    private volatile HandlerContext _immediate;
    @d
    private final HandlerContext a;
    private final Handler b;

    /* renamed from: c  reason: collision with root package name */
    private final String f16911c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f16912d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"kotlinx/coroutines/android/HandlerContext$a", "Li/b/e1;", "Lh/t1;", "dispose", "()V", "kotlinx-coroutines-android"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class a implements e1 {
        public final /* synthetic */ Runnable b;

        public a(Runnable runnable) {
            this.b = runnable;
        }

        @Override // i.b.e1
        public void dispose() {
            HandlerContext.this.b.removeCallbacks(this.b);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"Lh/t1;", "run", "()V", "i/b/x2$a", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class b implements Runnable {
        public final /* synthetic */ n b;

        public b(n nVar) {
            this.b = nVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.b.E(HandlerContext.this, t1.a);
        }
    }

    private HandlerContext(Handler handler, String str, boolean z) {
        super(null);
        this.b = handler;
        this.f16911c = str;
        this.f16912d = z;
        this._immediate = z ? this : null;
        HandlerContext handlerContext = this._immediate;
        if (handlerContext == null) {
            handlerContext = new HandlerContext(handler, str, true);
            this._immediate = handlerContext;
            t1 t1Var = t1.a;
        }
        this.a = handlerContext;
    }

    @Override // i.b.l2
    @d
    /* renamed from: D0 */
    public HandlerContext z0() {
        return this.a;
    }

    @Override // i.b.v0
    public void c(long j2, @d n<? super t1> nVar) {
        b bVar = new b(nVar);
        this.b.postDelayed(bVar, q.v(j2, e.f15706c));
        nVar.p(new HandlerContext$scheduleResumeAfterDelay$1(this, bVar));
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(@d CoroutineContext coroutineContext, @d Runnable runnable) {
        this.b.post(runnable);
    }

    public boolean equals(@k.e.a.e Object obj) {
        return (obj instanceof HandlerContext) && ((HandlerContext) obj).b == this.b;
    }

    public int hashCode() {
        return System.identityHashCode(this.b);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean isDispatchNeeded(@d CoroutineContext coroutineContext) {
        return !this.f16912d || (f0.g(Looper.myLooper(), this.b.getLooper()) ^ true);
    }

    @Override // i.b.s3.a, i.b.v0
    @d
    public e1 t(long j2, @d Runnable runnable, @d CoroutineContext coroutineContext) {
        this.b.postDelayed(runnable, q.v(j2, e.f15706c));
        return new a(runnable);
    }

    @Override // i.b.l2, kotlinx.coroutines.CoroutineDispatcher
    @d
    public String toString() {
        String A0 = A0();
        if (A0 != null) {
            return A0;
        }
        String str = this.f16911c;
        if (str == null) {
            str = this.b.toString();
        }
        if (this.f16912d) {
            return str + ".immediate";
        }
        return str;
    }

    public /* synthetic */ HandlerContext(Handler handler, String str, int i2, u uVar) {
        this(handler, (i2 & 2) != 0 ? null : str);
    }

    public HandlerContext(@d Handler handler, @k.e.a.e String str) {
        this(handler, str, false);
    }
}
