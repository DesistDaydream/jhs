package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import h.k2.u.a;
import h.k2.u.l;
import h.t1;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineDispatcher;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"R", "", AdvanceSetting.NETWORK_TYPE, "Lh/t1;", "invoke", "(Ljava/lang/Throwable;)V", "androidx/lifecycle/WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$2", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes.dex */
public final class WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$3 extends Lambda implements l<Throwable, t1> {
    public final /* synthetic */ a $block$inlined;
    public final /* synthetic */ boolean $dispatchNeeded$inlined;
    public final /* synthetic */ CoroutineDispatcher $lifecycleDispatcher$inlined;
    public final /* synthetic */ WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$1 $observer;
    public final /* synthetic */ Lifecycle.State $state$inlined;
    public final /* synthetic */ Lifecycle $this_suspendWithStateAtLeastUnchecked$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$3(WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$1 withLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$1, Lifecycle lifecycle, Lifecycle.State state, a aVar, boolean z, CoroutineDispatcher coroutineDispatcher) {
        super(1);
        this.$observer = withLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$1;
        this.$this_suspendWithStateAtLeastUnchecked$inlined = lifecycle;
        this.$state$inlined = state;
        this.$block$inlined = aVar;
        this.$dispatchNeeded$inlined = z;
        this.$lifecycleDispatcher$inlined = coroutineDispatcher;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Throwable th) {
        invoke2(th);
        return t1.a;
    }

    /* renamed from: invoke */
    public final void invoke2(@e Throwable th) {
        CoroutineDispatcher coroutineDispatcher = this.$lifecycleDispatcher$inlined;
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
        if (coroutineDispatcher.isDispatchNeeded(emptyCoroutineContext)) {
            this.$lifecycleDispatcher$inlined.dispatch(emptyCoroutineContext, new Runnable() { // from class: androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$3.1
                {
                    WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$3.this = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$3 withLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$3 = WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$3.this;
                    withLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$3.$this_suspendWithStateAtLeastUnchecked$inlined.removeObserver(withLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$3.$observer);
                }
            });
        } else {
            this.$this_suspendWithStateAtLeastUnchecked$inlined.removeObserver(this.$observer);
        }
    }
}
