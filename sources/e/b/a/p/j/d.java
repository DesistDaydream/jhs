package e.b.a.p.j;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;

/* loaded from: classes.dex */
public interface d<T> {

    /* loaded from: classes.dex */
    public interface a<T> {
        void b(@NonNull Exception exc);

        void d(@Nullable T t);
    }

    void a();

    void c(@NonNull Priority priority, @NonNull a<? super T> aVar);

    void cancel();

    @NonNull
    Class<T> getDataClass();

    @NonNull
    DataSource getDataSource();
}
