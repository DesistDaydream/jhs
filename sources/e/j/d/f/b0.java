package e.j.d.f;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.util.Log;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class b0 {
    public final Intent a;
    private final BroadcastReceiver.PendingResult b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f11227c = false;

    /* renamed from: d  reason: collision with root package name */
    private final ScheduledFuture<?> f11228d;

    public b0(final Intent intent, BroadcastReceiver.PendingResult pendingResult, ScheduledExecutorService scheduledExecutorService) {
        this.a = intent;
        this.b = pendingResult;
        this.f11228d = scheduledExecutorService.schedule(new Runnable(this, intent) { // from class: e.j.d.f.d0
            private final b0 a;
            private final Intent b;

            {
                this.a = this;
                this.b = intent;
            }

            @Override // java.lang.Runnable
            public final void run() {
                b0 b0Var = this.a;
                String action = this.b.getAction();
                StringBuilder sb = new StringBuilder(String.valueOf(action).length() + 61);
                sb.append("Service took too long to process intent: ");
                sb.append(action);
                sb.append(" App may get closed.");
                Log.w("FirebaseInstanceId", sb.toString());
                b0Var.a();
            }
        }, 9000L, TimeUnit.MILLISECONDS);
    }

    public final synchronized void a() {
        if (!this.f11227c) {
            this.b.finish();
            this.f11228d.cancel(false);
            this.f11227c = true;
        }
    }
}
