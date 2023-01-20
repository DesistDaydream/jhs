package i.b;

import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.tencent.android.tpush.common.MessageKey;
import com.umeng.analytics.pro.am;
import java.util.concurrent.CancellationException;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000 52\u00020\u0001:\u0001\u000bJ\u0013\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H'¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000b\u001a\u00020\n2\u0010\b\u0002\u0010\t\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003H&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0017¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0010\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u000fH'¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H'¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\nH¦@ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J8\u0010\u001f\u001a\u00020\u001e2'\u0010\u001d\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0019j\u0002`\u001cH&¢\u0006\u0004\b\u001f\u0010 JL\u0010#\u001a\u00020\u001e2\b\b\u0002\u0010!\u001a\u00020\u00062\b\b\u0002\u0010\"\u001a\u00020\u00062'\u0010\u001d\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0019j\u0002`\u001cH'¢\u0006\u0004\b#\u0010$J\u0018\u0010&\u001a\u00020\u00002\u0006\u0010%\u001a\u00020\u0000H\u0097\u0002¢\u0006\u0004\b&\u0010'R\u0016\u0010)\u001a\u00020\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\bR\u0016\u0010*\u001a\u00020\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\bR\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00000+8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0016\u00100\u001a\u00020\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b/\u0010\bR\u0016\u00104\u001a\u0002018&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b2\u00103\u0082\u0002\u0004\n\u0002\b\u0019¨\u00066"}, d2 = {"Li/b/b2;", "Lkotlin/coroutines/CoroutineContext$a;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "q", "()Ljava/util/concurrent/CancellationException;", "", MessageKey.MSG_ACCEPT_TIME_START, "()Z", "cause", "Lh/t1;", "b", "(Ljava/util/concurrent/CancellationException;)V", "cancel", "()V", "", am.av, "(Ljava/lang/Throwable;)Z", "Li/b/v;", "child", "Li/b/t;", "x0", "(Li/b/v;)Li/b/t;", "Y", "(Lh/e2/c;)Ljava/lang/Object;", "Lkotlin/Function1;", "Lh/k0;", "name", "Lkotlinx/coroutines/CompletionHandler;", "handler", "Li/b/e1;", "H", "(Lh/k2/u/l;)Li/b/e1;", "onCancelling", "invokeImmediately", "i", "(ZZLh/k2/u/l;)Li/b/e1;", "other", "F", "(Li/b/b2;)Li/b/b2;", "j", "isActive", "isCancelled", "Lh/q2/m;", "k", "()Lh/q2/m;", "children", NotifyType.LIGHTS, "isCompleted", "Li/b/z3/c;", "o0", "()Li/b/z3/c;", "onJoin", "y0", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public interface b2 extends CoroutineContext.a {
    public static final b y0 = b.a;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class a {
        public static /* synthetic */ void b(b2 b2Var, CancellationException cancellationException, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    cancellationException = null;
                }
                b2Var.b(cancellationException);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }

        public static /* synthetic */ boolean c(b2 b2Var, Throwable th, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    th = null;
                }
                return b2Var.a(th);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }

        public static <R> R d(@k.e.a.d b2 b2Var, R r, @k.e.a.d h.k2.u.p<? super R, ? super CoroutineContext.a, ? extends R> pVar) {
            return (R) CoroutineContext.a.C0492a.a(b2Var, r, pVar);
        }

        @k.e.a.e
        public static <E extends CoroutineContext.a> E e(@k.e.a.d b2 b2Var, @k.e.a.d CoroutineContext.b<E> bVar) {
            return (E) CoroutineContext.a.C0492a.b(b2Var, bVar);
        }

        public static /* synthetic */ e1 f(b2 b2Var, boolean z, boolean z2, h.k2.u.l lVar, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    z = false;
                }
                if ((i2 & 2) != 0) {
                    z2 = true;
                }
                return b2Var.i(z, z2, lVar);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
        }

        @k.e.a.d
        public static CoroutineContext g(@k.e.a.d b2 b2Var, @k.e.a.d CoroutineContext.b<?> bVar) {
            return CoroutineContext.a.C0492a.c(b2Var, bVar);
        }

        @k.e.a.d
        public static CoroutineContext h(@k.e.a.d b2 b2Var, @k.e.a.d CoroutineContext coroutineContext) {
            return CoroutineContext.a.C0492a.d(b2Var, coroutineContext);
        }

        @h.i(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        @k.e.a.d
        public static b2 i(@k.e.a.d b2 b2Var, @k.e.a.d b2 b2Var2) {
            return b2Var2;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"i/b/b2$b", "Lkotlin/coroutines/CoroutineContext$b;", "Li/b/b2;", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class b implements CoroutineContext.b<b2> {
        public static final /* synthetic */ b a = new b();

        static {
            CoroutineExceptionHandler.b bVar = CoroutineExceptionHandler.x0;
        }

        private b() {
        }
    }

    @h.i(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
    @k.e.a.d
    b2 F(@k.e.a.d b2 b2Var);

    @k.e.a.d
    e1 H(@k.e.a.d h.k2.u.l<? super Throwable, h.t1> lVar);

    @k.e.a.e
    Object Y(@k.e.a.d h.e2.c<? super h.t1> cVar);

    @h.i(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* synthetic */ boolean a(@k.e.a.e Throwable th);

    void b(@k.e.a.e CancellationException cancellationException);

    @h.i(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* synthetic */ void cancel();

    @x1
    @k.e.a.d
    e1 i(boolean z, boolean z2, @k.e.a.d h.k2.u.l<? super Throwable, h.t1> lVar);

    boolean isCancelled();

    boolean j();

    @k.e.a.d
    h.q2.m<b2> k();

    boolean l();

    @k.e.a.d
    i.b.z3.c o0();

    @x1
    @k.e.a.d
    CancellationException q();

    boolean start();

    @x1
    @k.e.a.d
    t x0(@k.e.a.d v vVar);
}
