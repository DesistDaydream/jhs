package i.b.y3;

import kotlin.Metadata;
import kotlinx.coroutines.scheduling.CoroutineScheduler;

@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final /* synthetic */ class a {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[CoroutineScheduler.WorkerState.values().length];
        a = iArr;
        iArr[CoroutineScheduler.WorkerState.PARKING.ordinal()] = 1;
        iArr[CoroutineScheduler.WorkerState.BLOCKING.ordinal()] = 2;
        iArr[CoroutineScheduler.WorkerState.CPU_ACQUIRED.ordinal()] = 3;
        iArr[CoroutineScheduler.WorkerState.DORMANT.ordinal()] = 4;
        iArr[CoroutineScheduler.WorkerState.TERMINATED.ordinal()] = 5;
    }
}
