package e.j.a.b.c.n;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import e.j.a.b.c.n.p;
import java.util.concurrent.TimeUnit;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public abstract class k<R extends p> {

    @e.j.a.b.c.m.a
    /* loaded from: classes2.dex */
    public interface a {
        @e.j.a.b.c.m.a
        void a(Status status);
    }

    @e.j.a.b.c.m.a
    public void b(@NonNull a aVar) {
        throw new UnsupportedOperationException();
    }

    @NonNull
    public abstract R c();

    @NonNull
    public abstract R d(long j2, @NonNull TimeUnit timeUnit);

    public abstract void e();

    public abstract boolean f();

    public abstract void g(@NonNull q<? super R> qVar);

    public abstract void h(@NonNull q<? super R> qVar, long j2, @NonNull TimeUnit timeUnit);

    @NonNull
    public <S extends p> t<S> i(@NonNull s<? super R, ? extends S> sVar) {
        throw new UnsupportedOperationException();
    }

    @Nullable
    public Integer j() {
        throw new UnsupportedOperationException();
    }
}
