package e.j.a.b.j;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes2.dex */
public final class a0<TResult> implements e0<TResult> {
    private final Executor a;
    private final Object b = new Object();
    @GuardedBy("mLock")

    /* renamed from: c  reason: collision with root package name */
    private g<? super TResult> f10533c;

    public a0(@NonNull Executor executor, @NonNull g<? super TResult> gVar) {
        this.a = executor;
        this.f10533c = gVar;
    }

    @Override // e.j.a.b.j.e0
    public final void cancel() {
        synchronized (this.b) {
            this.f10533c = null;
        }
    }

    @Override // e.j.a.b.j.e0
    public final void onComplete(@NonNull k<TResult> kVar) {
        if (kVar.v()) {
            synchronized (this.b) {
                if (this.f10533c == null) {
                    return;
                }
                this.a.execute(new b0(this, kVar));
            }
        }
    }
}
