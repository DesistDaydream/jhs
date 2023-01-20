package e.j.a.b.c.r;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import e.j.a.b.c.n.i;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class l implements Handler.Callback {
    private final a a;

    /* renamed from: h  reason: collision with root package name */
    private final Handler f10429h;
    private final ArrayList<i.b> b = new ArrayList<>();
    @e.j.a.b.c.x.d0

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<i.b> f10424c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private final ArrayList<i.c> f10425d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    private volatile boolean f10426e = false;

    /* renamed from: f  reason: collision with root package name */
    private final AtomicInteger f10427f = new AtomicInteger(0);

    /* renamed from: g  reason: collision with root package name */
    private boolean f10428g = false;

    /* renamed from: i  reason: collision with root package name */
    private final Object f10430i = new Object();

    @e.j.a.b.c.x.d0
    /* loaded from: classes2.dex */
    public interface a {
        boolean isConnected();

        Bundle l();
    }

    public l(Looper looper, a aVar) {
        this.a = aVar;
        this.f10429h = new e.j.a.b.f.a.o(looper, this);
    }

    public final boolean a() {
        return this.f10426e;
    }

    public final void b() {
        this.f10426e = false;
        this.f10427f.incrementAndGet();
    }

    public final void c() {
        this.f10426e = true;
    }

    public final boolean d(i.b bVar) {
        boolean contains;
        a0.k(bVar);
        synchronized (this.f10430i) {
            contains = this.b.contains(bVar);
        }
        return contains;
    }

    public final boolean e(i.c cVar) {
        boolean contains;
        a0.k(cVar);
        synchronized (this.f10430i) {
            contains = this.f10425d.contains(cVar);
        }
        return contains;
    }

    @e.j.a.b.c.x.d0
    public final void f(ConnectionResult connectionResult) {
        a0.e(this.f10429h, "onConnectionFailure must only be called on the Handler thread");
        this.f10429h.removeMessages(1);
        synchronized (this.f10430i) {
            ArrayList arrayList = new ArrayList(this.f10425d);
            int i2 = this.f10427f.get();
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                i.c cVar = (i.c) obj;
                if (this.f10426e && this.f10427f.get() == i2) {
                    if (this.f10425d.contains(cVar)) {
                        cVar.c(connectionResult);
                    }
                }
                return;
            }
        }
    }

    @e.j.a.b.c.x.d0
    public final void g() {
        synchronized (this.f10430i) {
            h(this.a.l());
        }
    }

    @e.j.a.b.c.x.d0
    public final void h(Bundle bundle) {
        a0.e(this.f10429h, "onConnectionSuccess must only be called on the Handler thread");
        synchronized (this.f10430i) {
            boolean z = true;
            a0.q(!this.f10428g);
            this.f10429h.removeMessages(1);
            this.f10428g = true;
            if (this.f10424c.size() != 0) {
                z = false;
            }
            a0.q(z);
            ArrayList arrayList = new ArrayList(this.b);
            int i2 = this.f10427f.get();
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                i.b bVar = (i.b) obj;
                if (!this.f10426e || !this.a.isConnected() || this.f10427f.get() != i2) {
                    break;
                } else if (!this.f10424c.contains(bVar)) {
                    bVar.a(bundle);
                }
            }
            this.f10424c.clear();
            this.f10428g = false;
        }
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == 1) {
            i.b bVar = (i.b) message.obj;
            synchronized (this.f10430i) {
                if (this.f10426e && this.a.isConnected() && this.b.contains(bVar)) {
                    bVar.a(this.a.l());
                }
            }
            return true;
        }
        StringBuilder sb = new StringBuilder(45);
        sb.append("Don't know how to handle message: ");
        sb.append(i2);
        Log.wtf("GmsClientEvents", sb.toString(), new Exception());
        return false;
    }

    @e.j.a.b.c.x.d0
    public final void i(int i2) {
        a0.e(this.f10429h, "onUnintentionalDisconnection must only be called on the Handler thread");
        this.f10429h.removeMessages(1);
        synchronized (this.f10430i) {
            this.f10428g = true;
            ArrayList arrayList = new ArrayList(this.b);
            int i3 = this.f10427f.get();
            int size = arrayList.size();
            int i4 = 0;
            while (i4 < size) {
                Object obj = arrayList.get(i4);
                i4++;
                i.b bVar = (i.b) obj;
                if (!this.f10426e || this.f10427f.get() != i3) {
                    break;
                } else if (this.b.contains(bVar)) {
                    bVar.onConnectionSuspended(i2);
                }
            }
            this.f10424c.clear();
            this.f10428g = false;
        }
    }

    public final void j(i.b bVar) {
        a0.k(bVar);
        synchronized (this.f10430i) {
            if (this.b.contains(bVar)) {
                String valueOf = String.valueOf(bVar);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 62);
                sb.append("registerConnectionCallbacks(): listener ");
                sb.append(valueOf);
                sb.append(" is already registered");
                Log.w("GmsClientEvents", sb.toString());
            } else {
                this.b.add(bVar);
            }
        }
        if (this.a.isConnected()) {
            Handler handler = this.f10429h;
            handler.sendMessage(handler.obtainMessage(1, bVar));
        }
    }

    public final void k(i.c cVar) {
        a0.k(cVar);
        synchronized (this.f10430i) {
            if (this.f10425d.contains(cVar)) {
                String valueOf = String.valueOf(cVar);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 67);
                sb.append("registerConnectionFailedListener(): listener ");
                sb.append(valueOf);
                sb.append(" is already registered");
                Log.w("GmsClientEvents", sb.toString());
            } else {
                this.f10425d.add(cVar);
            }
        }
    }

    public final void l(i.b bVar) {
        a0.k(bVar);
        synchronized (this.f10430i) {
            if (!this.b.remove(bVar)) {
                String valueOf = String.valueOf(bVar);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 52);
                sb.append("unregisterConnectionCallbacks(): listener ");
                sb.append(valueOf);
                sb.append(" not found");
                Log.w("GmsClientEvents", sb.toString());
            } else if (this.f10428g) {
                this.f10424c.add(bVar);
            }
        }
    }

    public final void m(i.c cVar) {
        a0.k(cVar);
        synchronized (this.f10430i) {
            if (!this.f10425d.remove(cVar)) {
                String valueOf = String.valueOf(cVar);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 57);
                sb.append("unregisterConnectionFailedListener(): listener ");
                sb.append(valueOf);
                sb.append(" not found");
                Log.w("GmsClientEvents", sb.toString());
            }
        }
    }
}
