package e.b.a.p.j;

import androidx.annotation.NonNull;
import java.io.IOException;

/* loaded from: classes.dex */
public interface e<T> {

    /* loaded from: classes.dex */
    public interface a<T> {
        @NonNull
        e<T> a(@NonNull T t);

        @NonNull
        Class<T> getDataClass();
    }

    void a();

    @NonNull
    T b() throws IOException;
}
