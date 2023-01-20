package e.j.a.b.j;

import androidx.annotation.NonNull;
import java.util.ArrayDeque;
import java.util.Queue;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes2.dex */
public final class f0<TResult> {
    private final Object a = new Object();
    @GuardedBy("mLock")
    private Queue<e0<TResult>> b;
    @GuardedBy("mLock")

    /* renamed from: c  reason: collision with root package name */
    private boolean f10535c;

    public final void a(@NonNull k<TResult> kVar) {
        e0<TResult> poll;
        synchronized (this.a) {
            if (this.b != null && !this.f10535c) {
                this.f10535c = true;
                while (true) {
                    synchronized (this.a) {
                        poll = this.b.poll();
                        if (poll == null) {
                            this.f10535c = false;
                            return;
                        }
                    }
                    poll.onComplete(kVar);
                }
            }
        }
    }

    public final void b(@NonNull e0<TResult> e0Var) {
        synchronized (this.a) {
            if (this.b == null) {
                this.b = new ArrayDeque();
            }
            this.b.add(e0Var);
        }
    }
}
