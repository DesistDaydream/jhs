package e.j.a.b.j;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes2.dex */
public final class u<TResult> implements e0<TResult> {
    private final Executor a;
    private final Object b = new Object();
    @GuardedBy("mLock")

    /* renamed from: c  reason: collision with root package name */
    private d f10548c;

    public u(@NonNull Executor executor, @NonNull d dVar) {
        this.a = executor;
        this.f10548c = dVar;
    }

    @Override // e.j.a.b.j.e0
    public final void cancel() {
        synchronized (this.b) {
            this.f10548c = null;
        }
    }

    @Override // e.j.a.b.j.e0
    public final void onComplete(@NonNull k kVar) {
        if (kVar.t()) {
            synchronized (this.b) {
                if (this.f10548c == null) {
                    return;
                }
                this.a.execute(new v(this));
            }
        }
    }
}
