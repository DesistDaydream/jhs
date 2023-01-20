package e.j.d.f;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* loaded from: classes2.dex */
public final class c0 implements ServiceConnection {
    private final Context a;
    private final Intent b;

    /* renamed from: c  reason: collision with root package name */
    private final ScheduledExecutorService f11229c;

    /* renamed from: d  reason: collision with root package name */
    private final Queue<b0> f11230d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private x f11231e;
    @GuardedBy("this")

    /* renamed from: f  reason: collision with root package name */
    private boolean f11232f;

    public c0(Context context, String str) {
        this(context, str, new ScheduledThreadPoolExecutor(0, new e.j.a.b.c.x.f0.b("Firebase-FirebaseInstanceIdServiceConnection")));
    }

    private final synchronized void a() {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "flush queue called");
        }
        while (!this.f11230d.isEmpty()) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                Log.d("FirebaseInstanceId", "found intent to be delivered");
            }
            x xVar = this.f11231e;
            if (xVar != null && xVar.isBinderAlive()) {
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    Log.d("FirebaseInstanceId", "binder is alive, sending the intent.");
                }
                this.f11231e.a(this.f11230d.poll());
            } else {
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    boolean z = !this.f11232f;
                    StringBuilder sb = new StringBuilder(39);
                    sb.append("binder is dead. start connection? ");
                    sb.append(z);
                    Log.d("FirebaseInstanceId", sb.toString());
                }
                if (!this.f11232f) {
                    this.f11232f = true;
                    try {
                    } catch (SecurityException e2) {
                        Log.e("FirebaseInstanceId", "Exception while binding the service", e2);
                    }
                    if (e.j.a.b.c.w.a.a().bindService(this.a, this.b, this, 65)) {
                        return;
                    }
                    Log.e("FirebaseInstanceId", "binding to the service failed");
                    this.f11232f = false;
                    c();
                }
                return;
            }
        }
    }

    @GuardedBy("this")
    private final void c() {
        while (!this.f11230d.isEmpty()) {
            this.f11230d.poll().a();
        }
    }

    public final synchronized void b(Intent intent, BroadcastReceiver.PendingResult pendingResult) {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "new intent queued in the bind-strategy delivery");
        }
        this.f11230d.add(new b0(intent, pendingResult, this.f11229c));
        a();
    }

    @Override // android.content.ServiceConnection
    public final synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            String valueOf = String.valueOf(componentName);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 20);
            sb.append("onServiceConnected: ");
            sb.append(valueOf);
            Log.d("FirebaseInstanceId", sb.toString());
        }
        this.f11232f = false;
        if (!(iBinder instanceof x)) {
            String valueOf2 = String.valueOf(iBinder);
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 28);
            sb2.append("Invalid service connection: ");
            sb2.append(valueOf2);
            Log.e("FirebaseInstanceId", sb2.toString());
            c();
            return;
        }
        this.f11231e = (x) iBinder;
        a();
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            String valueOf = String.valueOf(componentName);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 23);
            sb.append("onServiceDisconnected: ");
            sb.append(valueOf);
            Log.d("FirebaseInstanceId", sb.toString());
        }
        a();
    }

    @VisibleForTesting
    private c0(Context context, String str, ScheduledExecutorService scheduledExecutorService) {
        this.f11230d = new ArrayDeque();
        this.f11232f = false;
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        this.b = new Intent(str).setPackage(applicationContext.getPackageName());
        this.f11229c = scheduledExecutorService;
    }
}
