package e.j.a.b.f.a;

import androidx.annotation.NonNull;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes2.dex */
public final class n implements k {
    private n() {
    }

    @Override // e.j.a.b.f.a.k
    @NonNull
    public final ExecutorService a(int i2, ThreadFactory threadFactory, int i3) {
        return Executors.newFixedThreadPool(2, threadFactory);
    }
}
