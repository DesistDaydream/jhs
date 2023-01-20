package e.j.a.b.j;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class c0<TResult, TContinuationResult> implements d, f, g<TContinuationResult>, e0<TResult> {
    private final Executor a;
    private final j<TResult, TContinuationResult> b;

    /* renamed from: c  reason: collision with root package name */
    private final i0<TContinuationResult> f10534c;

    public c0(@NonNull Executor executor, @NonNull j<TResult, TContinuationResult> jVar, @NonNull i0<TContinuationResult> i0Var) {
        this.a = executor;
        this.b = jVar;
        this.f10534c = i0Var;
    }

    @Override // e.j.a.b.j.d
    public final void a() {
        this.f10534c.B();
    }

    @Override // e.j.a.b.j.e0
    public final void cancel() {
        throw new UnsupportedOperationException();
    }

    @Override // e.j.a.b.j.e0
    public final void onComplete(@NonNull k<TResult> kVar) {
        this.a.execute(new d0(this, kVar));
    }

    @Override // e.j.a.b.j.f
    public final void onFailure(@NonNull Exception exc) {
        this.f10534c.y(exc);
    }

    @Override // e.j.a.b.j.g
    public final void onSuccess(TContinuationResult tcontinuationresult) {
        this.f10534c.setResult(tcontinuationresult);
    }
}
