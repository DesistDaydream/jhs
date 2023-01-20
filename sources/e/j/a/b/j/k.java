package e.j.a.b.j;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public abstract class k<TResult> {
    @NonNull
    public k<TResult> a(@NonNull Activity activity, @NonNull d dVar) {
        throw new UnsupportedOperationException("addOnCanceledListener is not implemented.");
    }

    @NonNull
    public k<TResult> b(@NonNull d dVar) {
        throw new UnsupportedOperationException("addOnCanceledListener is not implemented.");
    }

    @NonNull
    public k<TResult> c(@NonNull Executor executor, @NonNull d dVar) {
        throw new UnsupportedOperationException("addOnCanceledListener is not implemented");
    }

    @NonNull
    public k<TResult> d(@NonNull Activity activity, @NonNull e<TResult> eVar) {
        throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
    }

    @NonNull
    public k<TResult> e(@NonNull e<TResult> eVar) {
        throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
    }

    @NonNull
    public k<TResult> f(@NonNull Executor executor, @NonNull e<TResult> eVar) {
        throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
    }

    @NonNull
    public abstract k<TResult> g(@NonNull Activity activity, @NonNull f fVar);

    @NonNull
    public abstract k<TResult> h(@NonNull f fVar);

    @NonNull
    public abstract k<TResult> i(@NonNull Executor executor, @NonNull f fVar);

    @NonNull
    public abstract k<TResult> j(@NonNull Activity activity, @NonNull g<? super TResult> gVar);

    @NonNull
    public abstract k<TResult> k(@NonNull g<? super TResult> gVar);

    @NonNull
    public abstract k<TResult> l(@NonNull Executor executor, @NonNull g<? super TResult> gVar);

    @NonNull
    public <TContinuationResult> k<TContinuationResult> m(@NonNull c<TResult, TContinuationResult> cVar) {
        throw new UnsupportedOperationException("continueWith is not implemented");
    }

    @NonNull
    public <TContinuationResult> k<TContinuationResult> n(@NonNull Executor executor, @NonNull c<TResult, TContinuationResult> cVar) {
        throw new UnsupportedOperationException("continueWith is not implemented");
    }

    @NonNull
    public <TContinuationResult> k<TContinuationResult> o(@NonNull c<TResult, k<TContinuationResult>> cVar) {
        throw new UnsupportedOperationException("continueWithTask is not implemented");
    }

    @NonNull
    public <TContinuationResult> k<TContinuationResult> p(@NonNull Executor executor, @NonNull c<TResult, k<TContinuationResult>> cVar) {
        throw new UnsupportedOperationException("continueWithTask is not implemented");
    }

    @Nullable
    public abstract Exception q();

    @Nullable
    public abstract TResult r();

    @Nullable
    public abstract <X extends Throwable> TResult s(@NonNull Class<X> cls) throws Throwable;

    public abstract boolean t();

    public abstract boolean u();

    public abstract boolean v();

    @NonNull
    public <TContinuationResult> k<TContinuationResult> w(@NonNull j<TResult, TContinuationResult> jVar) {
        throw new UnsupportedOperationException("onSuccessTask is not implemented");
    }

    @NonNull
    public <TContinuationResult> k<TContinuationResult> x(@NonNull Executor executor, @NonNull j<TResult, TContinuationResult> jVar) {
        throw new UnsupportedOperationException("onSuccessTask is not implemented");
    }
}
