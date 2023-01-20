package i.b.z3;

import com.umeng.analytics.pro.am;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Li/b/z3/i;", "", "", am.av, "()J", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class i {
    private static final AtomicLongFieldUpdater a = AtomicLongFieldUpdater.newUpdater(i.class, "number");
    private volatile long number = 1;

    public final long a() {
        return a.incrementAndGet(this);
    }
}
