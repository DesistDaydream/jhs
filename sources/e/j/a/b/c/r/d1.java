package e.j.a.b.c.r;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import e.j.a.b.c.r.m;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes2.dex */
public final class d1 implements ServiceConnection {
    private final Set<ServiceConnection> a = new HashSet();
    private int b = 2;

    /* renamed from: c  reason: collision with root package name */
    private boolean f10374c;

    /* renamed from: d  reason: collision with root package name */
    private IBinder f10375d;

    /* renamed from: e  reason: collision with root package name */
    private final m.a f10376e;

    /* renamed from: f  reason: collision with root package name */
    private ComponentName f10377f;

    /* renamed from: g  reason: collision with root package name */
    private final /* synthetic */ c1 f10378g;

    public d1(c1 c1Var, m.a aVar) {
        this.f10378g = c1Var;
        this.f10376e = aVar;
    }

    public final IBinder a() {
        return this.f10375d;
    }

    public final ComponentName b() {
        return this.f10377f;
    }

    public final int c() {
        return this.b;
    }

    public final boolean d() {
        return this.f10374c;
    }

    public final void e(ServiceConnection serviceConnection, String str) {
        Context context;
        e.j.a.b.c.w.a unused;
        Context unused2;
        unused = this.f10378g.f10371f;
        unused2 = this.f10378g.f10369d;
        m.a aVar = this.f10376e;
        context = this.f10378g.f10369d;
        aVar.c(context);
        this.a.add(serviceConnection);
    }

    public final boolean f(ServiceConnection serviceConnection) {
        return this.a.contains(serviceConnection);
    }

    public final void g(ServiceConnection serviceConnection, String str) {
        e.j.a.b.c.w.a unused;
        Context unused2;
        unused = this.f10378g.f10371f;
        unused2 = this.f10378g.f10369d;
        this.a.remove(serviceConnection);
    }

    public final void h(String str) {
        e.j.a.b.c.w.a aVar;
        Context context;
        Context context2;
        e.j.a.b.c.w.a aVar2;
        Context context3;
        Handler handler;
        Handler handler2;
        long j2;
        this.b = 3;
        aVar = this.f10378g.f10371f;
        context = this.f10378g.f10369d;
        m.a aVar3 = this.f10376e;
        context2 = this.f10378g.f10369d;
        boolean b = aVar.b(context, str, aVar3.c(context2), this, this.f10376e.d());
        this.f10374c = b;
        if (b) {
            handler = this.f10378g.f10370e;
            Message obtainMessage = handler.obtainMessage(1, this.f10376e);
            handler2 = this.f10378g.f10370e;
            j2 = this.f10378g.f10373h;
            handler2.sendMessageDelayed(obtainMessage, j2);
            return;
        }
        this.b = 2;
        try {
            aVar2 = this.f10378g.f10371f;
            context3 = this.f10378g.f10369d;
            aVar2.unbindService(context3, this);
        } catch (IllegalArgumentException unused) {
        }
    }

    public final void i(String str) {
        Handler handler;
        e.j.a.b.c.w.a aVar;
        Context context;
        handler = this.f10378g.f10370e;
        handler.removeMessages(1, this.f10376e);
        aVar = this.f10378g.f10371f;
        context = this.f10378g.f10369d;
        aVar.unbindService(context, this);
        this.f10374c = false;
        this.b = 2;
    }

    public final boolean j() {
        return this.a.isEmpty();
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        HashMap hashMap;
        Handler handler;
        hashMap = this.f10378g.f10368c;
        synchronized (hashMap) {
            handler = this.f10378g.f10370e;
            handler.removeMessages(1, this.f10376e);
            this.f10375d = iBinder;
            this.f10377f = componentName;
            for (ServiceConnection serviceConnection : this.a) {
                serviceConnection.onServiceConnected(componentName, iBinder);
            }
            this.b = 1;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        HashMap hashMap;
        Handler handler;
        hashMap = this.f10378g.f10368c;
        synchronized (hashMap) {
            handler = this.f10378g.f10370e;
            handler.removeMessages(1, this.f10376e);
            this.f10375d = null;
            this.f10377f = componentName;
            for (ServiceConnection serviceConnection : this.a) {
                serviceConnection.onServiceDisconnected(componentName);
            }
            this.b = 2;
        }
    }
}
