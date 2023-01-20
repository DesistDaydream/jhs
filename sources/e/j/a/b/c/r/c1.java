package e.j.a.b.c.r;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import e.j.a.b.c.r.m;
import java.util.HashMap;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes2.dex */
public final class c1 extends m implements Handler.Callback {

    /* renamed from: d  reason: collision with root package name */
    private final Context f10369d;

    /* renamed from: e  reason: collision with root package name */
    private final Handler f10370e;
    @GuardedBy("mConnectionStatus")

    /* renamed from: c  reason: collision with root package name */
    private final HashMap<m.a, d1> f10368c = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    private final e.j.a.b.c.w.a f10371f = e.j.a.b.c.w.a.a();

    /* renamed from: g  reason: collision with root package name */
    private final long f10372g = 5000;

    /* renamed from: h  reason: collision with root package name */
    private final long f10373h = 300000;

    public c1(Context context) {
        this.f10369d = context.getApplicationContext();
        this.f10370e = new e.j.a.b.f.b.e(context.getMainLooper(), this);
    }

    @Override // e.j.a.b.c.r.m
    public final boolean c(m.a aVar, ServiceConnection serviceConnection, String str) {
        boolean d2;
        a0.l(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f10368c) {
            d1 d1Var = this.f10368c.get(aVar);
            if (d1Var == null) {
                d1Var = new d1(this, aVar);
                d1Var.e(serviceConnection, str);
                d1Var.h(str);
                this.f10368c.put(aVar, d1Var);
            } else {
                this.f10370e.removeMessages(0, aVar);
                if (!d1Var.f(serviceConnection)) {
                    d1Var.e(serviceConnection, str);
                    int c2 = d1Var.c();
                    if (c2 == 1) {
                        serviceConnection.onServiceConnected(d1Var.b(), d1Var.a());
                    } else if (c2 == 2) {
                        d1Var.h(str);
                    }
                } else {
                    String valueOf = String.valueOf(aVar);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 81);
                    sb.append("Trying to bind a GmsServiceConnection that was already connected before.  config=");
                    sb.append(valueOf);
                    throw new IllegalStateException(sb.toString());
                }
            }
            d2 = d1Var.d();
        }
        return d2;
    }

    @Override // e.j.a.b.c.r.m
    public final void d(m.a aVar, ServiceConnection serviceConnection, String str) {
        a0.l(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f10368c) {
            d1 d1Var = this.f10368c.get(aVar);
            if (d1Var != null) {
                if (d1Var.f(serviceConnection)) {
                    d1Var.g(serviceConnection, str);
                    if (d1Var.j()) {
                        this.f10370e.sendMessageDelayed(this.f10370e.obtainMessage(0, aVar), this.f10372g);
                    }
                } else {
                    String valueOf = String.valueOf(aVar);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 76);
                    sb.append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=");
                    sb.append(valueOf);
                    throw new IllegalStateException(sb.toString());
                }
            } else {
                String valueOf2 = String.valueOf(aVar);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 50);
                sb2.append("Nonexistent connection status for service config: ");
                sb2.append(valueOf2);
                throw new IllegalStateException(sb2.toString());
            }
        }
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == 0) {
            synchronized (this.f10368c) {
                m.a aVar = (m.a) message.obj;
                d1 d1Var = this.f10368c.get(aVar);
                if (d1Var != null && d1Var.j()) {
                    if (d1Var.d()) {
                        d1Var.i("GmsClientSupervisor");
                    }
                    this.f10368c.remove(aVar);
                }
            }
            return true;
        } else if (i2 != 1) {
            return false;
        } else {
            synchronized (this.f10368c) {
                m.a aVar2 = (m.a) message.obj;
                d1 d1Var2 = this.f10368c.get(aVar2);
                if (d1Var2 != null && d1Var2.c() == 3) {
                    String valueOf = String.valueOf(aVar2);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
                    sb.append("Timeout waiting for ServiceConnection callback ");
                    sb.append(valueOf);
                    Log.e("GmsClientSupervisor", sb.toString(), new Exception());
                    ComponentName b = d1Var2.b();
                    if (b == null) {
                        b = aVar2.a();
                    }
                    if (b == null) {
                        b = new ComponentName(aVar2.b(), "unknown");
                    }
                    d1Var2.onServiceDisconnected(b);
                }
            }
            return true;
        }
    }
}
