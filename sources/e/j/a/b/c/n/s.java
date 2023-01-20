package e.j.a.b.c.n;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.api.Status;
import e.j.a.b.c.n.p;
import e.j.a.b.c.n.u.e2;

/* loaded from: classes2.dex */
public abstract class s<R extends p, S extends p> {
    @NonNull
    public final k<S> a(@NonNull Status status) {
        return new e2(status);
    }

    @NonNull
    public Status b(@NonNull Status status) {
        return status;
    }

    @Nullable
    @WorkerThread
    public abstract k<S> c(@NonNull R r);
}
