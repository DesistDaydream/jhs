package androidx.lifecycle;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import h.e2.c;
import h.e2.j.b;
import h.e2.k.a.d;
import h.k2.u.p;
import h.r0;
import h.t1;
import i.b.b2;
import i.b.g;
import i.b.n0;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@d(c = "androidx.lifecycle.PausingDispatcherKt$whenStateAtLeast$2", f = "PausingDispatcher.kt", i = {0}, l = {162}, m = "invokeSuspend", n = {"controller"}, s = {"L$0"})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Li/b/n0;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes.dex */
public final class PausingDispatcherKt$whenStateAtLeast$2 extends SuspendLambda implements p<n0, c<? super T>, Object> {
    public final /* synthetic */ p $block;
    public final /* synthetic */ Lifecycle.State $minState;
    public final /* synthetic */ Lifecycle $this_whenStateAtLeast;
    private /* synthetic */ Object L$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PausingDispatcherKt$whenStateAtLeast$2(Lifecycle lifecycle, Lifecycle.State state, p pVar, c cVar) {
        super(2, cVar);
        this.$this_whenStateAtLeast = lifecycle;
        this.$minState = state;
        this.$block = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k.e.a.d
    public final c<t1> create(@e Object obj, @k.e.a.d c<?> cVar) {
        PausingDispatcherKt$whenStateAtLeast$2 pausingDispatcherKt$whenStateAtLeast$2 = new PausingDispatcherKt$whenStateAtLeast$2(this.$this_whenStateAtLeast, this.$minState, this.$block, cVar);
        pausingDispatcherKt$whenStateAtLeast$2.L$0 = obj;
        return pausingDispatcherKt$whenStateAtLeast$2;
    }

    @Override // h.k2.u.p
    public final Object invoke(n0 n0Var, Object obj) {
        return ((PausingDispatcherKt$whenStateAtLeast$2) create(n0Var, (c) obj)).invokeSuspend(t1.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @e
    public final Object invokeSuspend(@k.e.a.d Object obj) {
        LifecycleController lifecycleController;
        Object h2 = b.h();
        int i2 = this.label;
        if (i2 == 0) {
            r0.n(obj);
            b2 b2Var = (b2) ((n0) this.L$0).getCoroutineContext().get(b2.y0);
            if (b2Var != null) {
                PausingDispatcher pausingDispatcher = new PausingDispatcher();
                LifecycleController lifecycleController2 = new LifecycleController(this.$this_whenStateAtLeast, this.$minState, pausingDispatcher.dispatchQueue, b2Var);
                try {
                    p pVar = this.$block;
                    this.L$0 = lifecycleController2;
                    this.label = 1;
                    obj = g.i(pausingDispatcher, pVar, this);
                    if (obj == h2) {
                        return h2;
                    }
                    lifecycleController = lifecycleController2;
                } catch (Throwable th) {
                    th = th;
                    lifecycleController = lifecycleController2;
                    lifecycleController.finish();
                    throw th;
                }
            } else {
                throw new IllegalStateException("when[State] methods should have a parent job".toString());
            }
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            lifecycleController = (LifecycleController) this.L$0;
            try {
                r0.n(obj);
            } catch (Throwable th2) {
                th = th2;
                lifecycleController.finish();
                throw th;
            }
        }
        lifecycleController.finish();
        return obj;
    }
}
