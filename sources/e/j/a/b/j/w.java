package e.j.a.b.j;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes2.dex */
public final class w<TResult> implements e0<TResult> {
    private final Executor a;
    private final Object b = new Object();
    @GuardedBy("mLock")

    /* renamed from: c  reason: collision with root package name */
    private e<TResult> f10549c;

    public w(@NonNull Executor executor, @NonNull e<TResult> eVar) {
        this.a = executor;
        this.f10549c = eVar;
    }

    @Override // e.j.a.b.j.e0
    public final void cancel() {
        synchronized (this.b) {
            this.f10549c = null;
        }
    }

    @Override // e.j.a.b.j.e0
    public final void onComplete(@NonNull k<TResult> kVar) {
        synchronized (this.b) {
            if (this.f10549c == null) {
                return;
            }
            this.a.execute(new x(this, kVar));
        }
    }
}
