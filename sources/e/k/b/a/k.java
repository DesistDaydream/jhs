package e.k.b.a;

import android.app.Activity;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public abstract class k<TResult> {
    public k<TResult> a(Activity activity, f fVar) {
        throw new UnsupportedOperationException("addOnCanceledListener is not implemented.");
    }

    public k<TResult> b(f fVar) {
        throw new UnsupportedOperationException("addOnCanceledListener is not implemented.");
    }

    public k<TResult> c(Executor executor, f fVar) {
        throw new UnsupportedOperationException("addOnCanceledListener is not implemented.");
    }

    public k<TResult> d(Activity activity, g<TResult> gVar) {
        throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
    }

    public k<TResult> e(g<TResult> gVar) {
        throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
    }

    public k<TResult> f(Executor executor, g<TResult> gVar) {
        throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
    }

    public abstract k<TResult> g(Activity activity, h hVar);

    public abstract k<TResult> h(h hVar);

    public abstract k<TResult> i(Executor executor, h hVar);

    public abstract k<TResult> j(Activity activity, i<TResult> iVar);

    public abstract k<TResult> k(i<TResult> iVar);

    public abstract k<TResult> l(Executor executor, i<TResult> iVar);

    public <TContinuationResult> k<TContinuationResult> m(d<TResult, TContinuationResult> dVar) {
        throw new UnsupportedOperationException("continueWith is not implemented");
    }

    public <TContinuationResult> k<TContinuationResult> n(Executor executor, d<TResult, TContinuationResult> dVar) {
        throw new UnsupportedOperationException("continueWith is not implemented");
    }

    public <TContinuationResult> k<TContinuationResult> o(d<TResult, k<TContinuationResult>> dVar) {
        throw new UnsupportedOperationException("continueWithTask is not implemented");
    }

    public <TContinuationResult> k<TContinuationResult> p(Executor executor, d<TResult, k<TContinuationResult>> dVar) {
        throw new UnsupportedOperationException("continueWithTask is not implemented");
    }

    public abstract Exception q();

    public abstract TResult r();

    public abstract <E extends Throwable> TResult s(Class<E> cls) throws Throwable;

    public abstract boolean t();

    public abstract boolean u();

    public abstract boolean v();

    public <TContinuationResult> k<TContinuationResult> w(j<TResult, TContinuationResult> jVar) {
        throw new UnsupportedOperationException("onSuccessTask is not implemented");
    }

    public <TContinuationResult> k<TContinuationResult> x(Executor executor, j<TResult, TContinuationResult> jVar) {
        throw new UnsupportedOperationException("onSuccessTask is not implemented");
    }
}
