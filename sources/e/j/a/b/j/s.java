package e.j.a.b.j;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class s<TResult, TContinuationResult> implements d, f, g<TContinuationResult>, e0<TResult> {
    private final Executor a;
    private final c<TResult, k<TContinuationResult>> b;

    /* renamed from: c */
    private final i0<TContinuationResult> f10547c;

    public s(@NonNull Executor executor, @NonNull c<TResult, k<TContinuationResult>> cVar, @NonNull i0<TContinuationResult> i0Var) {
        this.a = executor;
        this.b = cVar;
        this.f10547c = i0Var;
    }

    @Override // e.j.a.b.j.d
    public final void a() {
        this.f10547c.B();
    }

    @Override // e.j.a.b.j.e0
    public final void cancel() {
        throw new UnsupportedOperationException();
    }

    @Override // e.j.a.b.j.e0
    public final void onComplete(@NonNull k<TResult> kVar) {
        this.a.execute(new t(this, kVar));
    }

    @Override // e.j.a.b.j.f
    public final void onFailure(@NonNull Exception exc) {
        this.f10547c.y(exc);
    }

    @Override // e.j.a.b.j.g
    public final void onSuccess(TContinuationResult tcontinuationresult) {
        this.f10547c.setResult(tcontinuationresult);
    }
}
