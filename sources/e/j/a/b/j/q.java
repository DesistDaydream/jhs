package e.j.a.b.j;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class q<TResult, TContinuationResult> implements e0<TResult> {
    private final Executor a;
    private final c<TResult, TContinuationResult> b;

    /* renamed from: c */
    private final i0<TContinuationResult> f10546c;

    public q(@NonNull Executor executor, @NonNull c<TResult, TContinuationResult> cVar, @NonNull i0<TContinuationResult> i0Var) {
        this.a = executor;
        this.b = cVar;
        this.f10546c = i0Var;
    }

    @Override // e.j.a.b.j.e0
    public final void cancel() {
        throw new UnsupportedOperationException();
    }

    @Override // e.j.a.b.j.e0
    public final void onComplete(@NonNull k<TResult> kVar) {
        this.a.execute(new r(this, kVar));
    }
}
