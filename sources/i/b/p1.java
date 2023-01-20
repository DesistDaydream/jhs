package i.b;

import java.util.concurrent.Executor;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Li/b/p1;", "Li/b/o1;", "Ljava/util/concurrent/Executor;", "c", "Ljava/util/concurrent/Executor;", "z0", "()Ljava/util/concurrent/Executor;", "executor", "<init>", "(Ljava/util/concurrent/Executor;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class p1 extends o1 {
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private final Executor f15779c;

    public p1(@k.e.a.d Executor executor) {
        this.f15779c = executor;
        B0();
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    @k.e.a.d
    public Executor z0() {
        return this.f15779c;
    }
}
