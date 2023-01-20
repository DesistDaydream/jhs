package i.b;

import com.umeng.analytics.pro.am;
import java.util.concurrent.Future;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\b¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Li/b/d1;", "Li/b/e1;", "Lh/t1;", "dispose", "()V", "", "toString", "()Ljava/lang/String;", "Ljava/util/concurrent/Future;", am.av, "Ljava/util/concurrent/Future;", "future", "<init>", "(Ljava/util/concurrent/Future;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class d1 implements e1 {
    private final Future<?> a;

    public d1(@k.e.a.d Future<?> future) {
        this.a = future;
    }

    @Override // i.b.e1
    public void dispose() {
        this.a.cancel(false);
    }

    @k.e.a.d
    public String toString() {
        return "DisposableFutureHandle[" + this.a + ']';
    }
}
