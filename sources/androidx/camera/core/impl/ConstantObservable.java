package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.ConstantObservable;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.utils.futures.Futures;
import e.j.c.a.a.a;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class ConstantObservable<T> implements Observable<T> {
    private static final ConstantObservable<Object> NULL_OBSERVABLE = new ConstantObservable<>(null);
    private static final String TAG = "ConstantObservable";
    private final a<T> mValueFuture;

    private ConstantObservable(@Nullable T t) {
        this.mValueFuture = Futures.immediateFuture(t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void b(Observable.Observer observer) {
        try {
            observer.onNewData(this.mValueFuture.get());
        } catch (InterruptedException | ExecutionException e2) {
            observer.onError(e2);
        }
    }

    @NonNull
    public static <U> Observable<U> withValue(@Nullable U u) {
        if (u == null) {
            return NULL_OBSERVABLE;
        }
        return new ConstantObservable(u);
    }

    @Override // androidx.camera.core.impl.Observable
    public void addObserver(@NonNull Executor executor, @NonNull final Observable.Observer<? super T> observer) {
        this.mValueFuture.addListener(new Runnable() { // from class: c.b.b.b2.g
            @Override // java.lang.Runnable
            public final void run() {
                ConstantObservable.this.b(observer);
            }
        }, executor);
    }

    @Override // androidx.camera.core.impl.Observable
    @NonNull
    public a<T> fetchData() {
        return this.mValueFuture;
    }

    @Override // androidx.camera.core.impl.Observable
    public void removeObserver(@NonNull Observable.Observer<? super T> observer) {
    }
}
