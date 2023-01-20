package e.j.a.b.c.x.f0;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import e.j.a.b.f.b.e;
import java.util.concurrent.Executor;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public class a implements Executor {
    private final Handler a;

    @e.j.a.b.c.m.a
    public a(Looper looper) {
        this.a = new e(looper);
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NonNull Runnable runnable) {
        this.a.post(runnable);
    }
}
