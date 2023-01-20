package e.j.d.f;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import com.google.firebase.iid.zzad;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes2.dex */
public final class w0 implements ServiceConnection {
    @GuardedBy("this")
    public int a;
    public final Messenger b;

    /* renamed from: c  reason: collision with root package name */
    public h f11265c;
    @GuardedBy("this")

    /* renamed from: d  reason: collision with root package name */
    public final Queue<i<?>> f11266d;
    @GuardedBy("this")

    /* renamed from: e  reason: collision with root package name */
    public final SparseArray<i<?>> f11267e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ v0 f11268f;

    private w0(v0 v0Var) {
        this.f11268f = v0Var;
        this.a = 0;
        this.b = new Messenger(new e.j.a.b.f.c.e(Looper.getMainLooper(), new Handler.Callback(this) { // from class: e.j.d.f.z0
            private final w0 a;

            {
                this.a = this;
            }

            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return this.a.d(message);
            }
        }));
        this.f11266d = new ArrayDeque();
        this.f11267e = new SparseArray<>();
    }

    private final void g() {
        ScheduledExecutorService scheduledExecutorService;
        scheduledExecutorService = this.f11268f.b;
        scheduledExecutorService.execute(new Runnable(this) { // from class: e.j.d.f.f
            private final w0 a;

            {
                this.a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                i<?> poll;
                ScheduledExecutorService scheduledExecutorService2;
                Context context;
                w0 w0Var = this.a;
                while (true) {
                    synchronized (w0Var) {
                        if (w0Var.a != 2) {
                            return;
                        }
                        if (w0Var.f11266d.isEmpty()) {
                            w0Var.a();
                            return;
                        }
                        poll = w0Var.f11266d.poll();
                        w0Var.f11267e.put(poll.a, poll);
                        scheduledExecutorService2 = w0Var.f11268f.b;
                        scheduledExecutorService2.schedule(new Runnable(w0Var, poll) { // from class: e.j.d.f.a1
                            private final w0 a;
                            private final i b;

                            {
                                this.a = w0Var;
                                this.b = poll;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                this.a.b(this.b.a);
                            }
                        }, 30L, TimeUnit.SECONDS);
                    }
                    if (Log.isLoggable("MessengerIpcClient", 3)) {
                        String valueOf = String.valueOf(poll);
                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 8);
                        sb.append("Sending ");
                        sb.append(valueOf);
                        Log.d("MessengerIpcClient", sb.toString());
                    }
                    context = w0Var.f11268f.a;
                    Messenger messenger = w0Var.b;
                    Message obtain = Message.obtain();
                    obtain.what = poll.f11233c;
                    obtain.arg1 = poll.a;
                    obtain.replyTo = messenger;
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("oneWay", poll.d());
                    bundle.putString("pkg", context.getPackageName());
                    bundle.putBundle("data", poll.f11234d);
                    obtain.setData(bundle);
                    try {
                        w0Var.f11265c.a(obtain);
                    } catch (RemoteException e2) {
                        w0Var.c(2, e2.getMessage());
                    }
                }
            }
        });
    }

    public final synchronized void a() {
        Context context;
        if (this.a == 2 && this.f11266d.isEmpty() && this.f11267e.size() == 0) {
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Finished handling requests, unbinding");
            }
            this.a = 3;
            e.j.a.b.c.w.a a = e.j.a.b.c.w.a.a();
            context = this.f11268f.a;
            a.unbindService(context, this);
        }
    }

    public final synchronized void b(int i2) {
        i<?> iVar = this.f11267e.get(i2);
        if (iVar != null) {
            StringBuilder sb = new StringBuilder(31);
            sb.append("Timing out request: ");
            sb.append(i2);
            Log.w("MessengerIpcClient", sb.toString());
            this.f11267e.remove(i2);
            iVar.b(new zzad(3, "Timed out waiting for response"));
            a();
        }
    }

    public final synchronized void c(int i2, String str) {
        Context context;
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(str);
            Log.d("MessengerIpcClient", valueOf.length() != 0 ? "Disconnected: ".concat(valueOf) : new String("Disconnected: "));
        }
        int i3 = this.a;
        if (i3 == 0) {
            throw new IllegalStateException();
        }
        if (i3 != 1 && i3 != 2) {
            if (i3 == 3) {
                this.a = 4;
                return;
            } else if (i3 == 4) {
                return;
            } else {
                int i4 = this.a;
                StringBuilder sb = new StringBuilder(26);
                sb.append("Unknown state: ");
                sb.append(i4);
                throw new IllegalStateException(sb.toString());
            }
        }
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Unbinding service");
        }
        this.a = 4;
        e.j.a.b.c.w.a a = e.j.a.b.c.w.a.a();
        context = this.f11268f.a;
        a.unbindService(context, this);
        zzad zzadVar = new zzad(i2, str);
        for (i<?> iVar : this.f11266d) {
            iVar.b(zzadVar);
        }
        this.f11266d.clear();
        for (int i5 = 0; i5 < this.f11267e.size(); i5++) {
            this.f11267e.valueAt(i5).b(zzadVar);
        }
        this.f11267e.clear();
    }

    public final boolean d(Message message) {
        int i2 = message.arg1;
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            StringBuilder sb = new StringBuilder(41);
            sb.append("Received response to request: ");
            sb.append(i2);
            Log.d("MessengerIpcClient", sb.toString());
        }
        synchronized (this) {
            i<?> iVar = this.f11267e.get(i2);
            if (iVar == null) {
                StringBuilder sb2 = new StringBuilder(50);
                sb2.append("Received response for unknown request: ");
                sb2.append(i2);
                Log.w("MessengerIpcClient", sb2.toString());
                return true;
            }
            this.f11267e.remove(i2);
            a();
            Bundle data = message.getData();
            if (data.getBoolean("unsupported", false)) {
                iVar.b(new zzad(4, "Not supported by GmsCore"));
            } else {
                iVar.a(data);
            }
            return true;
        }
    }

    public final synchronized boolean e(i<?> iVar) {
        Context context;
        ScheduledExecutorService scheduledExecutorService;
        int i2 = this.a;
        if (i2 == 0) {
            this.f11266d.add(iVar);
            e.j.a.b.c.r.a0.q(this.a == 0);
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Starting bind to GmsCore");
            }
            this.a = 1;
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            e.j.a.b.c.w.a a = e.j.a.b.c.w.a.a();
            context = this.f11268f.a;
            if (a.bindService(context, intent, this, 1)) {
                scheduledExecutorService = this.f11268f.b;
                scheduledExecutorService.schedule(new Runnable(this) { // from class: e.j.d.f.y0
                    private final w0 a;

                    {
                        this.a = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.f();
                    }
                }, 30L, TimeUnit.SECONDS);
            } else {
                c(0, "Unable to bind to service");
            }
            return true;
        } else if (i2 == 1) {
            this.f11266d.add(iVar);
            return true;
        } else if (i2 == 2) {
            this.f11266d.add(iVar);
            g();
            return true;
        } else {
            if (i2 != 3 && i2 != 4) {
                int i3 = this.a;
                StringBuilder sb = new StringBuilder(26);
                sb.append("Unknown state: ");
                sb.append(i3);
                throw new IllegalStateException(sb.toString());
            }
            return false;
        }
    }

    public final synchronized void f() {
        if (this.a == 1) {
            c(1, "Timed out while binding");
        }
    }

    @Override // android.content.ServiceConnection
    public final synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service connected");
        }
        if (iBinder == null) {
            c(0, "Null service connection");
            return;
        }
        try {
            this.f11265c = new h(iBinder);
            this.a = 2;
            g();
        } catch (RemoteException e2) {
            c(0, e2.getMessage());
        }
    }

    @Override // android.content.ServiceConnection
    public final synchronized void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service disconnected");
        }
        c(2, "Service disconnected");
    }
}
