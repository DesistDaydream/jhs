package i.b;

import com.umeng.analytics.pro.am;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007\b\u0010\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0013\u0010\f\u001a\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b\t\u0010\u0004¨\u0006\u000f"}, d2 = {"Li/b/b0;", "", "", "b", "()Z", "", "toString", "()Ljava/lang/String;", "", am.av, "Ljava/lang/Throwable;", "cause", "handled", "<init>", "(Ljava/lang/Throwable;Z)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public class b0 {
    private static final AtomicIntegerFieldUpdater b = AtomicIntegerFieldUpdater.newUpdater(b0.class, "_handled");
    private volatile int _handled;
    @h.k2.d
    @k.e.a.d
    public final Throwable a;

    public b0(@k.e.a.d Throwable th, boolean z) {
        this.a = th;
        this._handled = z ? 1 : 0;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public final boolean a() {
        return this._handled;
    }

    public final boolean b() {
        return b.compareAndSet(this, 0, 1);
    }

    @k.e.a.d
    public String toString() {
        return r0.a(this) + '[' + this.a + ']';
    }

    public /* synthetic */ b0(Throwable th, boolean z, int i2, h.k2.v.u uVar) {
        this(th, (i2 & 2) != 0 ? false : z);
    }
}
