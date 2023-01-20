package i.b.s3;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import androidx.annotation.VisibleForTesting;
import com.umeng.analytics.pro.am;
import e.j.a.b.c.f;
import h.e2.c;
import h.i;
import h.k2.d;
import h.k2.g;
import h.k2.h;
import h.r0;
import i.b.b1;
import i.b.n;
import i.b.o;
import java.util.Objects;
import k.e.a.e;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlinx.coroutines.android.HandlerContext;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u001a\u001f\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001b\u0010\t\u001a\u00020\u0000*\u00020\u00062\u0006\u0010\b\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\t\u0010\n\u001a\u0013\u0010\f\u001a\u00020\u000bH\u0086@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u001d\u0010\u0011\u001a\u00020\u00102\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012\u001a%\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00132\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000eH\u0002¢\u0006\u0004\b\u0015\u0010\u0016\"\u0016\u0010\u0019\u001a\u00020\u000b8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018\"\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u001a\"\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u00038\u0000@\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u0012\u0004\b\u001d\u0010\u001e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, d2 = {"Landroid/os/Handler;", "", "name", "Li/b/s3/a;", "f", "(Landroid/os/Handler;Ljava/lang/String;)Li/b/s3/a;", "Landroid/os/Looper;", "", "async", "c", "(Landroid/os/Looper;Z)Landroid/os/Handler;", "", f.f10128d, "(Lh/e2/c;)Ljava/lang/Object;", "Li/b/n;", "cont", "Lh/t1;", "j", "(Li/b/n;)V", "Landroid/view/Choreographer;", "choreographer", "i", "(Landroid/view/Choreographer;Li/b/n;)V", am.av, "J", "MAX_DELAY", "Landroid/view/Choreographer;", "b", "Li/b/s3/a;", "getMain$annotations", "()V", "Main", "kotlinx-coroutines-android"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class b {
    private static final long a = 4611686018427387903L;
    @d
    @e
    public static final i.b.s3.a b;
    private static volatile Choreographer choreographer;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"Lh/t1;", "run", "()V", "i/b/x2$a", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class a implements Runnable {
        public final /* synthetic */ n a;

        public a(n nVar) {
            this.a = nVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            b.j(this.a);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "nanos", "Lh/t1;", "doFrame", "(J)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    /* renamed from: i.b.s3.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class Choreographer$FrameCallbackC0480b implements Choreographer.FrameCallback {
        public final /* synthetic */ n a;

        public Choreographer$FrameCallbackC0480b(n nVar) {
            this.a = nVar;
        }

        @Override // android.view.Choreographer.FrameCallback
        public final void doFrame(long j2) {
            this.a.E(b1.e(), Long.valueOf(j2));
        }
    }

    static {
        Object m106constructorimpl;
        try {
            Result.a aVar = Result.Companion;
            m106constructorimpl = Result.m106constructorimpl(new HandlerContext(c(Looper.getMainLooper(), true), null, 2, null));
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            m106constructorimpl = Result.m106constructorimpl(r0.a(th));
        }
        b = Result.m112isFailureimpl(m106constructorimpl) ? null : m106constructorimpl;
    }

    @VisibleForTesting
    @k.e.a.d
    public static final Handler c(@k.e.a.d Looper looper, boolean z) {
        int i2;
        if (!z || (i2 = Build.VERSION.SDK_INT) < 16) {
            return new Handler(looper);
        }
        if (i2 >= 28) {
            Object invoke = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke(null, looper);
            Objects.requireNonNull(invoke, "null cannot be cast to non-null type android.os.Handler");
            return (Handler) invoke;
        }
        try {
            return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
        } catch (NoSuchMethodException unused) {
            return new Handler(looper);
        }
    }

    @e
    public static final Object d(@k.e.a.d c<? super Long> cVar) {
        Choreographer choreographer2 = choreographer;
        if (choreographer2 != null) {
            o oVar = new o(IntrinsicsKt__IntrinsicsJvmKt.d(cVar), 1);
            oVar.G();
            i(choreographer2, oVar);
            Object B = oVar.B();
            if (B == h.e2.j.b.h()) {
                h.e2.k.a.f.c(cVar);
            }
            return B;
        }
        o oVar2 = new o(IntrinsicsKt__IntrinsicsJvmKt.d(cVar), 1);
        oVar2.G();
        b1.e().dispatch(EmptyCoroutineContext.INSTANCE, new a(oVar2));
        Object B2 = oVar2.B();
        if (B2 == h.e2.j.b.h()) {
            h.e2.k.a.f.c(cVar);
        }
        return B2;
    }

    @h
    @g(name = "from")
    @k.e.a.d
    public static final i.b.s3.a e(@k.e.a.d Handler handler) {
        return g(handler, null, 1, null);
    }

    @h
    @g(name = "from")
    @k.e.a.d
    public static final i.b.s3.a f(@k.e.a.d Handler handler, @e String str) {
        return new HandlerContext(handler, str);
    }

    public static /* synthetic */ i.b.s3.a g(Handler handler, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        return f(handler, str);
    }

    @i(level = DeprecationLevel.HIDDEN, message = "Use Dispatchers.Main instead")
    public static /* synthetic */ void h() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Choreographer choreographer2, n<? super Long> nVar) {
        choreographer2.postFrameCallback(new Choreographer$FrameCallbackC0480b(nVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(n<? super Long> nVar) {
        Choreographer choreographer2 = choreographer;
        if (choreographer2 == null) {
            choreographer2 = Choreographer.getInstance();
            choreographer = choreographer2;
        }
        i(choreographer2, nVar);
    }
}
