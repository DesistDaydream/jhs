package e.j.d.f;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes2.dex */
public final class v0 {
    @GuardedBy("MessengerIpcClient.class")

    /* renamed from: e  reason: collision with root package name */
    private static v0 f11260e;
    private final Context a;
    private final ScheduledExecutorService b;
    @GuardedBy("this")

    /* renamed from: c  reason: collision with root package name */
    private w0 f11261c = new w0(this);
    @GuardedBy("this")

    /* renamed from: d  reason: collision with root package name */
    private int f11262d = 1;

    @VisibleForTesting
    private v0(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.b = scheduledExecutorService;
        this.a = context.getApplicationContext();
    }

    private final synchronized int a() {
        int i2;
        i2 = this.f11262d;
        this.f11262d = i2 + 1;
        return i2;
    }

    private final synchronized <T> e.j.a.b.j.k<T> d(i<T> iVar) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(iVar);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 9);
            sb.append("Queueing ");
            sb.append(valueOf);
            Log.d("MessengerIpcClient", sb.toString());
        }
        if (!this.f11261c.e(iVar)) {
            w0 w0Var = new w0(this);
            this.f11261c = w0Var;
            w0Var.e(iVar);
        }
        return iVar.b.a();
    }

    public static synchronized v0 e(Context context) {
        v0 v0Var;
        synchronized (v0.class) {
            if (f11260e == null) {
                f11260e = new v0(context, e.j.a.b.f.c.a.a().b(1, new e.j.a.b.c.x.f0.b("MessengerIpcClient"), e.j.a.b.f.c.f.b));
            }
            v0Var = f11260e;
        }
        return v0Var;
    }

    public final e.j.a.b.j.k<Void> c(int i2, Bundle bundle) {
        return d(new g(a(), 2, bundle));
    }

    public final e.j.a.b.j.k<Bundle> f(int i2, Bundle bundle) {
        return d(new k(a(), 1, bundle));
    }
}
