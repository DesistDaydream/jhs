package e.j.a.b.j;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes2.dex */
public final class y<TResult> implements e0<TResult> {
    private final Executor a;
    private final Object b = new Object();
    @GuardedBy("mLock")

    /* renamed from: c  reason: collision with root package name */
    private f f10550c;

    public y(@NonNull Executor executor, @NonNull f fVar) {
        this.a = executor;
        this.f10550c = fVar;
    }

    @Override // e.j.a.b.j.e0
    public final void cancel() {
        synchronized (this.b) {
            this.f10550c = null;
        }
    }

    @Override // e.j.a.b.j.e0
    public final void onComplete(@NonNull k<TResult> kVar) {
        if (kVar.v() || kVar.t()) {
            return;
        }
        synchronized (this.b) {
            if (this.f10550c == null) {
                return;
            }
            this.a.execute(new z(this, kVar));
        }
    }
}
