package i.b.y3;

import com.umeng.analytics.pro.am;
import kotlin.Metadata;
import kotlinx.coroutines.scheduling.CoroutineScheduler;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0001¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0006"}, d2 = {"Ljava/lang/Thread;", "thread", "", am.av, "(Ljava/lang/Thread;)Z", "b", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class b {
    @h.k2.g(name = "isSchedulerWorker")
    public static final boolean a(@k.e.a.d Thread thread) {
        return thread instanceof CoroutineScheduler.b;
    }

    @h.k2.g(name = "mayNotBlock")
    public static final boolean b(@k.e.a.d Thread thread) {
        return (thread instanceof CoroutineScheduler.b) && ((CoroutineScheduler.b) thread).b == CoroutineScheduler.WorkerState.CPU_ACQUIRED;
    }
}
