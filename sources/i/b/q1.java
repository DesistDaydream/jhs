package i.b;

import com.umeng.analytics.pro.am;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0011\u0010\b\u001a\u00020\u0004*\u00020\u0005¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Ljava/util/concurrent/ExecutorService;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "c", "(Ljava/util/concurrent/ExecutorService;)Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Ljava/util/concurrent/Executor;", "Lkotlinx/coroutines/CoroutineDispatcher;", "b", "(Ljava/util/concurrent/Executor;)Lkotlinx/coroutines/CoroutineDispatcher;", am.av, "(Lkotlinx/coroutines/CoroutineDispatcher;)Ljava/util/concurrent/Executor;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class q1 {
    @k.e.a.d
    public static final Executor a(@k.e.a.d CoroutineDispatcher coroutineDispatcher) {
        Executor z0;
        ExecutorCoroutineDispatcher executorCoroutineDispatcher = (ExecutorCoroutineDispatcher) (!(coroutineDispatcher instanceof ExecutorCoroutineDispatcher) ? null : coroutineDispatcher);
        return (executorCoroutineDispatcher == null || (z0 = executorCoroutineDispatcher.z0()) == null) ? new a1(coroutineDispatcher) : z0;
    }

    @h.k2.g(name = "from")
    @k.e.a.d
    public static final CoroutineDispatcher b(@k.e.a.d Executor executor) {
        CoroutineDispatcher coroutineDispatcher;
        a1 a1Var = (a1) (!(executor instanceof a1) ? null : executor);
        return (a1Var == null || (coroutineDispatcher = a1Var.a) == null) ? new p1(executor) : coroutineDispatcher;
    }

    @h.k2.g(name = "from")
    @k.e.a.d
    public static final ExecutorCoroutineDispatcher c(@k.e.a.d ExecutorService executorService) {
        return new p1(executorService);
    }
}
