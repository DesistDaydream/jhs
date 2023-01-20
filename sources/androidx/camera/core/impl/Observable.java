package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import e.j.c.a.a.a;
import java.util.concurrent.Executor;

@RequiresApi(21)
/* loaded from: classes.dex */
public interface Observable<T> {

    /* loaded from: classes.dex */
    public interface Observer<T> {
        void onError(@NonNull Throwable th);

        void onNewData(@Nullable T t);
    }

    void addObserver(@NonNull Executor executor, @NonNull Observer<? super T> observer);

    @NonNull
    a<T> fetchData();

    void removeObserver(@NonNull Observer<? super T> observer);
}
