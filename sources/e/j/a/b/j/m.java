package e.j.a.b.j;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class m {
    public static final Executor a = new a();
    public static final Executor b = new h0();

    /* loaded from: classes2.dex */
    public static final class a implements Executor {
        private final Handler a = new Handler(Looper.getMainLooper());

        @Override // java.util.concurrent.Executor
        public final void execute(@NonNull Runnable runnable) {
            this.a.post(runnable);
        }
    }

    private m() {
    }
}
