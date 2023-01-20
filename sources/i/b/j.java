package i.b;

import com.umeng.analytics.pro.am;
import java.util.concurrent.Future;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\n¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\f\u001a\u0006\u0012\u0002\b\u00030\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000b¨\u0006\u000f"}, d2 = {"Li/b/j;", "Li/b/l;", "", "cause", "Lh/t1;", am.av, "(Ljava/lang/Throwable;)V", "", "toString", "()Ljava/lang/String;", "Ljava/util/concurrent/Future;", "Ljava/util/concurrent/Future;", "future", "<init>", "(Ljava/util/concurrent/Future;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class j extends l {
    private final Future<?> a;

    public j(@k.e.a.d Future<?> future) {
        this.a = future;
    }

    @Override // i.b.m
    public void a(@k.e.a.e Throwable th) {
        this.a.cancel(false);
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ h.t1 invoke(Throwable th) {
        a(th);
        return h.t1.a;
    }

    @k.e.a.d
    public String toString() {
        return "CancelFutureOnCancel[" + this.a + ']';
    }
}
