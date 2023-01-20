package e.j.a.b.c.n.u;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.UnsupportedApiCallException;
import e.j.a.b.c.n.a;
import e.j.a.b.c.n.i;
import e.j.a.b.c.n.u.d;
import e.j.a.b.c.n.u.l;
import e.j.a.b.c.r.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.GuardedBy;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public class g implements Handler.Callback {
    public static final Status n = new Status(4, "Sign-out occurred while this API call was in progress.");
    private static final Status o = new Status(4, "The user must be signed in to make this API call.");
    private static final Object p = new Object();
    @GuardedBy("lock")
    private static g q;

    /* renamed from: d */
    private final Context f10231d;

    /* renamed from: e */
    private final e.j.a.b.c.e f10232e;

    /* renamed from: f */
    private final e.j.a.b.c.r.o f10233f;

    /* renamed from: m */
    private final Handler f10240m;
    private long a = 5000;
    private long b = 120000;

    /* renamed from: c */
    private long f10230c = com.heytap.mcssdk.constant.a.q;

    /* renamed from: g */
    private final AtomicInteger f10234g = new AtomicInteger(1);

    /* renamed from: h */
    private final AtomicInteger f10235h = new AtomicInteger(0);

    /* renamed from: i */
    private final Map<z2<?>, a<?>> f10236i = new ConcurrentHashMap(5, 0.75f, 1);
    @GuardedBy("lock")

    /* renamed from: j */
    private e0 f10237j = null;
    @GuardedBy("lock")

    /* renamed from: k */
    private final Set<z2<?>> f10238k = new ArraySet();

    /* renamed from: l */
    private final Set<z2<?>> f10239l = new ArraySet();

    /* loaded from: classes2.dex */
    public class a<O extends a.d> implements i.b, i.c, i3 {
        private final a.f b;

        /* renamed from: c */
        private final a.b f10241c;

        /* renamed from: d */
        private final z2<O> f10242d;

        /* renamed from: e */
        private final b0 f10243e;

        /* renamed from: h */
        private final int f10246h;

        /* renamed from: i */
        private final f2 f10247i;

        /* renamed from: j */
        private boolean f10248j;
        private final Queue<a1> a = new LinkedList();

        /* renamed from: f */
        private final Set<b3> f10244f = new HashSet();

        /* renamed from: g */
        private final Map<l.a<?>, w1> f10245g = new HashMap();

        /* renamed from: k */
        private final List<b> f10249k = new ArrayList();

        /* renamed from: l */
        private ConnectionResult f10250l = null;

        @WorkerThread
        public a(e.j.a.b.c.n.h<O> hVar) {
            g.this = r4;
            a.f s = hVar.s(r4.f10240m.getLooper(), this);
            this.b = s;
            if (s instanceof e.j.a.b.c.r.e0) {
                this.f10241c = ((e.j.a.b.c.r.e0) s).o0();
            } else {
                this.f10241c = s;
            }
            this.f10242d = hVar.w();
            this.f10243e = new b0();
            this.f10246h = hVar.p();
            if (s.j()) {
                this.f10247i = hVar.u(r4.f10231d, r4.f10240m);
            } else {
                this.f10247i = null;
            }
        }

        @WorkerThread
        private final void A() {
            if (this.f10248j) {
                g.this.f10240m.removeMessages(11, this.f10242d);
                g.this.f10240m.removeMessages(9, this.f10242d);
                this.f10248j = false;
            }
        }

        private final void B() {
            g.this.f10240m.removeMessages(12, this.f10242d);
            g.this.f10240m.sendMessageDelayed(g.this.f10240m.obtainMessage(12, this.f10242d), g.this.f10230c);
        }

        @WorkerThread
        private final void F(a1 a1Var) {
            a1Var.d(this.f10243e, g());
            try {
                a1Var.c(this);
            } catch (DeadObjectException unused) {
                onConnectionSuspended(1);
                this.b.disconnect();
            }
        }

        @WorkerThread
        public final boolean G(boolean z) {
            e.j.a.b.c.r.a0.d(g.this.f10240m);
            if (this.b.isConnected() && this.f10245g.size() == 0) {
                if (!this.f10243e.e()) {
                    this.b.disconnect();
                    return true;
                }
                if (z) {
                    B();
                }
                return false;
            }
            return false;
        }

        @WorkerThread
        private final boolean L(@NonNull ConnectionResult connectionResult) {
            synchronized (g.p) {
                if (g.this.f10237j == null || !g.this.f10238k.contains(this.f10242d)) {
                    return false;
                }
                g.this.f10237j.n(connectionResult, this.f10246h);
                return true;
            }
        }

        @WorkerThread
        private final void M(ConnectionResult connectionResult) {
            for (b3 b3Var : this.f10244f) {
                String str = null;
                if (e.j.a.b.c.r.y.a(connectionResult, ConnectionResult.RESULT_SUCCESS)) {
                    str = this.b.g();
                }
                b3Var.b(this.f10242d, connectionResult, str);
            }
            this.f10244f.clear();
        }

        @Nullable
        @WorkerThread
        private final Feature i(@Nullable Feature[] featureArr) {
            if (featureArr != null && featureArr.length != 0) {
                Feature[] u = this.b.u();
                if (u == null) {
                    u = new Feature[0];
                }
                ArrayMap arrayMap = new ArrayMap(u.length);
                for (Feature feature : u) {
                    arrayMap.put(feature.getName(), Long.valueOf(feature.getVersion()));
                }
                for (Feature feature2 : featureArr) {
                    if (!arrayMap.containsKey(feature2.getName()) || ((Long) arrayMap.get(feature2.getName())).longValue() < feature2.getVersion()) {
                        return feature2;
                    }
                }
            }
            return null;
        }

        @WorkerThread
        public final void k(b bVar) {
            if (this.f10249k.contains(bVar) && !this.f10248j) {
                if (!this.b.isConnected()) {
                    d();
                } else {
                    v();
                }
            }
        }

        @WorkerThread
        public final void r(b bVar) {
            Feature[] g2;
            if (this.f10249k.remove(bVar)) {
                g.this.f10240m.removeMessages(15, bVar);
                g.this.f10240m.removeMessages(16, bVar);
                Feature feature = bVar.b;
                ArrayList arrayList = new ArrayList(this.a.size());
                for (a1 a1Var : this.a) {
                    if ((a1Var instanceof a2) && (g2 = ((a2) a1Var).g(this)) != null && e.j.a.b.c.x.b.e(g2, feature)) {
                        arrayList.add(a1Var);
                    }
                }
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj = arrayList.get(i2);
                    i2++;
                    a1 a1Var2 = (a1) obj;
                    this.a.remove(a1Var2);
                    a1Var2.e(new UnsupportedApiCallException(feature));
                }
            }
        }

        @WorkerThread
        private final boolean s(a1 a1Var) {
            if (!(a1Var instanceof a2)) {
                F(a1Var);
                return true;
            }
            a2 a2Var = (a2) a1Var;
            Feature i2 = i(a2Var.g(this));
            if (i2 == null) {
                F(a1Var);
                return true;
            } else if (a2Var.h(this)) {
                b bVar = new b(this.f10242d, i2, null);
                int indexOf = this.f10249k.indexOf(bVar);
                if (indexOf >= 0) {
                    b bVar2 = this.f10249k.get(indexOf);
                    g.this.f10240m.removeMessages(15, bVar2);
                    g.this.f10240m.sendMessageDelayed(Message.obtain(g.this.f10240m, 15, bVar2), g.this.a);
                    return false;
                }
                this.f10249k.add(bVar);
                g.this.f10240m.sendMessageDelayed(Message.obtain(g.this.f10240m, 15, bVar), g.this.a);
                g.this.f10240m.sendMessageDelayed(Message.obtain(g.this.f10240m, 16, bVar), g.this.b);
                ConnectionResult connectionResult = new ConnectionResult(2, null);
                if (L(connectionResult)) {
                    return false;
                }
                g.this.w(connectionResult, this.f10246h);
                return false;
            } else {
                a2Var.e(new UnsupportedApiCallException(i2));
                return false;
            }
        }

        @WorkerThread
        public final void t() {
            y();
            M(ConnectionResult.RESULT_SUCCESS);
            A();
            Iterator<w1> it = this.f10245g.values().iterator();
            while (it.hasNext()) {
                w1 next = it.next();
                if (i(next.a.c()) != null) {
                    it.remove();
                } else {
                    try {
                        next.a.d(this.f10241c, new e.j.a.b.j.l<>());
                    } catch (DeadObjectException unused) {
                        onConnectionSuspended(1);
                        this.b.disconnect();
                    } catch (RemoteException unused2) {
                        it.remove();
                    }
                }
            }
            v();
            B();
        }

        @WorkerThread
        public final void u() {
            y();
            this.f10248j = true;
            this.f10243e.g();
            g.this.f10240m.sendMessageDelayed(Message.obtain(g.this.f10240m, 9, this.f10242d), g.this.a);
            g.this.f10240m.sendMessageDelayed(Message.obtain(g.this.f10240m, 11, this.f10242d), g.this.b);
            g.this.f10233f.a();
        }

        @WorkerThread
        private final void v() {
            ArrayList arrayList = new ArrayList(this.a);
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                a1 a1Var = (a1) obj;
                if (!this.b.isConnected()) {
                    return;
                }
                if (s(a1Var)) {
                    this.a.remove(a1Var);
                }
            }
        }

        @WorkerThread
        public final boolean C() {
            return G(true);
        }

        public final e.j.a.b.h.f D() {
            f2 f2Var = this.f10247i;
            if (f2Var == null) {
                return null;
            }
            return f2Var.f0();
        }

        @WorkerThread
        public final void E(Status status) {
            e.j.a.b.c.r.a0.d(g.this.f10240m);
            for (a1 a1Var : this.a) {
                a1Var.b(status);
            }
            this.a.clear();
        }

        @WorkerThread
        public final void K(@NonNull ConnectionResult connectionResult) {
            e.j.a.b.c.r.a0.d(g.this.f10240m);
            this.b.disconnect();
            c(connectionResult);
        }

        @Override // e.j.a.b.c.n.i.b
        public final void a(@Nullable Bundle bundle) {
            if (Looper.myLooper() != g.this.f10240m.getLooper()) {
                g.this.f10240m.post(new k1(this));
            } else {
                t();
            }
        }

        @Override // e.j.a.b.c.n.u.i3
        public final void b(ConnectionResult connectionResult, e.j.a.b.c.n.a<?> aVar, boolean z) {
            if (Looper.myLooper() != g.this.f10240m.getLooper()) {
                g.this.f10240m.post(new m1(this, connectionResult));
            } else {
                c(connectionResult);
            }
        }

        @Override // e.j.a.b.c.n.i.c
        @WorkerThread
        public final void c(@NonNull ConnectionResult connectionResult) {
            e.j.a.b.c.r.a0.d(g.this.f10240m);
            f2 f2Var = this.f10247i;
            if (f2Var != null) {
                f2Var.g0();
            }
            y();
            g.this.f10233f.a();
            M(connectionResult);
            if (connectionResult.getErrorCode() == 4) {
                E(g.o);
            } else if (this.a.isEmpty()) {
                this.f10250l = connectionResult;
            } else if (L(connectionResult) || g.this.w(connectionResult, this.f10246h)) {
            } else {
                if (connectionResult.getErrorCode() == 18) {
                    this.f10248j = true;
                }
                if (this.f10248j) {
                    g.this.f10240m.sendMessageDelayed(Message.obtain(g.this.f10240m, 9, this.f10242d), g.this.a);
                    return;
                }
                String c2 = this.f10242d.c();
                StringBuilder sb = new StringBuilder(String.valueOf(c2).length() + 38);
                sb.append("API: ");
                sb.append(c2);
                sb.append(" is not available on this device.");
                E(new Status(17, sb.toString()));
            }
        }

        @WorkerThread
        public final void d() {
            e.j.a.b.c.r.a0.d(g.this.f10240m);
            if (this.b.isConnected() || this.b.isConnecting()) {
                return;
            }
            int b = g.this.f10233f.b(g.this.f10231d, this.b);
            if (b != 0) {
                c(new ConnectionResult(b, null));
                return;
            }
            c cVar = new c(this.b, this.f10242d);
            if (this.b.j()) {
                this.f10247i.e0(cVar);
            }
            this.b.h(cVar);
        }

        public final int e() {
            return this.f10246h;
        }

        public final boolean f() {
            return this.b.isConnected();
        }

        public final boolean g() {
            return this.b.j();
        }

        @WorkerThread
        public final void h() {
            e.j.a.b.c.r.a0.d(g.this.f10240m);
            if (this.f10248j) {
                d();
            }
        }

        @WorkerThread
        public final void l(a1 a1Var) {
            e.j.a.b.c.r.a0.d(g.this.f10240m);
            if (this.b.isConnected()) {
                if (s(a1Var)) {
                    B();
                    return;
                } else {
                    this.a.add(a1Var);
                    return;
                }
            }
            this.a.add(a1Var);
            ConnectionResult connectionResult = this.f10250l;
            if (connectionResult != null && connectionResult.hasResolution()) {
                c(this.f10250l);
            } else {
                d();
            }
        }

        @WorkerThread
        public final void m(b3 b3Var) {
            e.j.a.b.c.r.a0.d(g.this.f10240m);
            this.f10244f.add(b3Var);
        }

        public final a.f o() {
            return this.b;
        }

        @Override // e.j.a.b.c.n.i.b
        public final void onConnectionSuspended(int i2) {
            if (Looper.myLooper() != g.this.f10240m.getLooper()) {
                g.this.f10240m.post(new l1(this));
            } else {
                u();
            }
        }

        @WorkerThread
        public final void p() {
            Status status;
            e.j.a.b.c.r.a0.d(g.this.f10240m);
            if (this.f10248j) {
                A();
                if (g.this.f10232e.j(g.this.f10231d) == 18) {
                    status = new Status(8, "Connection timed out while waiting for Google Play services update to complete.");
                } else {
                    status = new Status(8, "API failed to connect while resuming due to an unknown error.");
                }
                E(status);
                this.b.disconnect();
            }
        }

        @WorkerThread
        public final void w() {
            e.j.a.b.c.r.a0.d(g.this.f10240m);
            E(g.n);
            this.f10243e.f();
            for (l.a aVar : (l.a[]) this.f10245g.keySet().toArray(new l.a[this.f10245g.size()])) {
                l(new y2(aVar, new e.j.a.b.j.l()));
            }
            M(new ConnectionResult(4));
            if (this.b.isConnected()) {
                this.b.p(new n1(this));
            }
        }

        public final Map<l.a<?>, w1> x() {
            return this.f10245g;
        }

        @WorkerThread
        public final void y() {
            e.j.a.b.c.r.a0.d(g.this.f10240m);
            this.f10250l = null;
        }

        @WorkerThread
        public final ConnectionResult z() {
            e.j.a.b.c.r.a0.d(g.this.f10240m);
            return this.f10250l;
        }
    }

    /* loaded from: classes2.dex */
    public class c implements i2, e.c {
        private final a.f a;
        private final z2<?> b;

        /* renamed from: c */
        private e.j.a.b.c.r.q f10252c = null;

        /* renamed from: d */
        private Set<Scope> f10253d = null;

        /* renamed from: e */
        private boolean f10254e = false;

        public c(a.f fVar, z2<?> z2Var) {
            g.this = r1;
            this.a = fVar;
            this.b = z2Var;
        }

        @WorkerThread
        public final void g() {
            e.j.a.b.c.r.q qVar;
            if (!this.f10254e || (qVar = this.f10252c) == null) {
                return;
            }
            this.a.m(qVar, this.f10253d);
        }

        @Override // e.j.a.b.c.r.e.c
        public final void a(@NonNull ConnectionResult connectionResult) {
            g.this.f10240m.post(new p1(this, connectionResult));
        }

        @Override // e.j.a.b.c.n.u.i2
        @WorkerThread
        public final void b(ConnectionResult connectionResult) {
            ((a) g.this.f10236i.get(this.b)).K(connectionResult);
        }

        @Override // e.j.a.b.c.n.u.i2
        @WorkerThread
        public final void c(e.j.a.b.c.r.q qVar, Set<Scope> set) {
            if (qVar != null && set != null) {
                this.f10252c = qVar;
                this.f10253d = set;
                g();
                return;
            }
            Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
            b(new ConnectionResult(4));
        }
    }

    @e.j.a.b.c.m.a
    private g(Context context, Looper looper, e.j.a.b.c.e eVar) {
        this.f10231d = context;
        e.j.a.b.f.a.o oVar = new e.j.a.b.f.a.o(looper, this);
        this.f10240m = oVar;
        this.f10232e = eVar;
        this.f10233f = new e.j.a.b.c.r.o(eVar);
        oVar.sendMessage(oVar.obtainMessage(6));
    }

    @e.j.a.b.c.m.a
    public static void b() {
        synchronized (p) {
            g gVar = q;
            if (gVar != null) {
                gVar.f10235h.incrementAndGet();
                Handler handler = gVar.f10240m;
                handler.sendMessageAtFrontOfQueue(handler.obtainMessage(10));
            }
        }
    }

    public static g n(Context context) {
        g gVar;
        synchronized (p) {
            if (q == null) {
                HandlerThread handlerThread = new HandlerThread("GoogleApiHandler", 9);
                handlerThread.start();
                q = new g(context.getApplicationContext(), handlerThread.getLooper(), e.j.a.b.c.e.v());
            }
            gVar = q;
        }
        return gVar;
    }

    @WorkerThread
    private final void o(e.j.a.b.c.n.h<?> hVar) {
        z2<?> w = hVar.w();
        a<?> aVar = this.f10236i.get(w);
        if (aVar == null) {
            aVar = new a<>(hVar);
            this.f10236i.put(w, aVar);
        }
        if (aVar.g()) {
            this.f10239l.add(w);
        }
        aVar.d();
    }

    public static g q() {
        g gVar;
        synchronized (p) {
            e.j.a.b.c.r.a0.l(q, "Must guarantee manager is non-null before using getInstance");
            gVar = q;
        }
        return gVar;
    }

    public final void E() {
        Handler handler = this.f10240m;
        handler.sendMessage(handler.obtainMessage(3));
    }

    public final void a() {
        this.f10235h.incrementAndGet();
        Handler handler = this.f10240m;
        handler.sendMessage(handler.obtainMessage(10));
    }

    public final PendingIntent c(z2<?> z2Var, int i2) {
        e.j.a.b.h.f D;
        a<?> aVar = this.f10236i.get(z2Var);
        if (aVar == null || (D = aVar.D()) == null) {
            return null;
        }
        return PendingIntent.getActivity(this.f10231d, i2, D.v(), 134217728);
    }

    public final <O extends a.d> e.j.a.b.j.k<Boolean> e(@NonNull e.j.a.b.c.n.h<O> hVar, @NonNull l.a<?> aVar) {
        e.j.a.b.j.l lVar = new e.j.a.b.j.l();
        y2 y2Var = new y2(aVar, lVar);
        Handler handler = this.f10240m;
        handler.sendMessage(handler.obtainMessage(13, new v1(y2Var, this.f10235h.get(), hVar)));
        return lVar.a();
    }

    public final <O extends a.d> e.j.a.b.j.k<Void> f(@NonNull e.j.a.b.c.n.h<O> hVar, @NonNull p<a.b, ?> pVar, @NonNull y<a.b, ?> yVar) {
        e.j.a.b.j.l lVar = new e.j.a.b.j.l();
        w2 w2Var = new w2(new w1(pVar, yVar), lVar);
        Handler handler = this.f10240m;
        handler.sendMessage(handler.obtainMessage(8, new v1(w2Var, this.f10235h.get(), hVar)));
        return lVar.a();
    }

    public final e.j.a.b.j.k<Map<z2<?>, String>> g(Iterable<? extends e.j.a.b.c.n.h<?>> iterable) {
        b3 b3Var = new b3(iterable);
        Handler handler = this.f10240m;
        handler.sendMessage(handler.obtainMessage(2, b3Var));
        return b3Var.a();
    }

    public final void h(ConnectionResult connectionResult, int i2) {
        if (w(connectionResult, i2)) {
            return;
        }
        Handler handler = this.f10240m;
        handler.sendMessage(handler.obtainMessage(5, i2, 0, connectionResult));
    }

    @Override // android.os.Handler.Callback
    @WorkerThread
    public boolean handleMessage(Message message) {
        a<?> aVar;
        int i2 = message.what;
        switch (i2) {
            case 1:
                this.f10230c = ((Boolean) message.obj).booleanValue() ? com.heytap.mcssdk.constant.a.q : 300000L;
                this.f10240m.removeMessages(12);
                for (z2<?> z2Var : this.f10236i.keySet()) {
                    Handler handler = this.f10240m;
                    handler.sendMessageDelayed(handler.obtainMessage(12, z2Var), this.f10230c);
                }
                break;
            case 2:
                b3 b3Var = (b3) message.obj;
                Iterator<z2<?>> it = b3Var.c().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else {
                        z2<?> next = it.next();
                        a<?> aVar2 = this.f10236i.get(next);
                        if (aVar2 == null) {
                            b3Var.b(next, new ConnectionResult(13), null);
                            break;
                        } else if (aVar2.f()) {
                            b3Var.b(next, ConnectionResult.RESULT_SUCCESS, aVar2.o().g());
                        } else if (aVar2.z() != null) {
                            b3Var.b(next, aVar2.z(), null);
                        } else {
                            aVar2.m(b3Var);
                            aVar2.d();
                        }
                    }
                }
            case 3:
                for (a<?> aVar3 : this.f10236i.values()) {
                    aVar3.y();
                    aVar3.d();
                }
                break;
            case 4:
            case 8:
            case 13:
                v1 v1Var = (v1) message.obj;
                a<?> aVar4 = this.f10236i.get(v1Var.f10329c.w());
                if (aVar4 == null) {
                    o(v1Var.f10329c);
                    aVar4 = this.f10236i.get(v1Var.f10329c.w());
                }
                if (aVar4.g() && this.f10235h.get() != v1Var.b) {
                    v1Var.a.b(n);
                    aVar4.w();
                    break;
                } else {
                    aVar4.l(v1Var.a);
                    break;
                }
                break;
            case 5:
                int i3 = message.arg1;
                ConnectionResult connectionResult = (ConnectionResult) message.obj;
                Iterator<a<?>> it2 = this.f10236i.values().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        a<?> next2 = it2.next();
                        aVar = next2.e() == i3 ? next2 : null;
                    }
                }
                if (aVar != null) {
                    String h2 = this.f10232e.h(connectionResult.getErrorCode());
                    String errorMessage = connectionResult.getErrorMessage();
                    StringBuilder sb = new StringBuilder(String.valueOf(h2).length() + 69 + String.valueOf(errorMessage).length());
                    sb.append("Error resolution was canceled by the user, original error message: ");
                    sb.append(h2);
                    sb.append(": ");
                    sb.append(errorMessage);
                    aVar.E(new Status(17, sb.toString()));
                    break;
                } else {
                    StringBuilder sb2 = new StringBuilder(76);
                    sb2.append("Could not find API instance ");
                    sb2.append(i3);
                    sb2.append(" while trying to fail enqueued calls.");
                    Log.wtf("GoogleApiManager", sb2.toString(), new Exception());
                    break;
                }
            case 6:
                if (e.j.a.b.c.x.v.c() && (this.f10231d.getApplicationContext() instanceof Application)) {
                    e.j.a.b.c.n.u.c.c((Application) this.f10231d.getApplicationContext());
                    e.j.a.b.c.n.u.c.b().a(new j1(this));
                    if (!e.j.a.b.c.n.u.c.b().f(true)) {
                        this.f10230c = 300000L;
                        break;
                    }
                }
                break;
            case 7:
                o((e.j.a.b.c.n.h) message.obj);
                break;
            case 9:
                if (this.f10236i.containsKey(message.obj)) {
                    this.f10236i.get(message.obj).h();
                    break;
                }
                break;
            case 10:
                for (z2<?> z2Var2 : this.f10239l) {
                    this.f10236i.remove(z2Var2).w();
                }
                this.f10239l.clear();
                break;
            case 11:
                if (this.f10236i.containsKey(message.obj)) {
                    this.f10236i.get(message.obj).p();
                    break;
                }
                break;
            case 12:
                if (this.f10236i.containsKey(message.obj)) {
                    this.f10236i.get(message.obj).C();
                    break;
                }
                break;
            case 14:
                f0 f0Var = (f0) message.obj;
                z2<?> b2 = f0Var.b();
                if (!this.f10236i.containsKey(b2)) {
                    f0Var.a().setResult(Boolean.FALSE);
                    break;
                } else {
                    f0Var.a().setResult(Boolean.valueOf(this.f10236i.get(b2).G(false)));
                    break;
                }
            case 15:
                b bVar = (b) message.obj;
                if (this.f10236i.containsKey(bVar.a)) {
                    this.f10236i.get(bVar.a).k(bVar);
                    break;
                }
                break;
            case 16:
                b bVar2 = (b) message.obj;
                if (this.f10236i.containsKey(bVar2.a)) {
                    this.f10236i.get(bVar2.a).r(bVar2);
                    break;
                }
                break;
            default:
                StringBuilder sb3 = new StringBuilder(31);
                sb3.append("Unknown message id: ");
                sb3.append(i2);
                Log.w("GoogleApiManager", sb3.toString());
                return false;
        }
        return true;
    }

    public final void i(e.j.a.b.c.n.h<?> hVar) {
        Handler handler = this.f10240m;
        handler.sendMessage(handler.obtainMessage(7, hVar));
    }

    public final <O extends a.d> void j(e.j.a.b.c.n.h<O> hVar, int i2, d.a<? extends e.j.a.b.c.n.p, a.b> aVar) {
        v2 v2Var = new v2(i2, aVar);
        Handler handler = this.f10240m;
        handler.sendMessage(handler.obtainMessage(4, new v1(v2Var, this.f10235h.get(), hVar)));
    }

    public final <O extends a.d, ResultT> void k(e.j.a.b.c.n.h<O> hVar, int i2, w<a.b, ResultT> wVar, e.j.a.b.j.l<ResultT> lVar, u uVar) {
        x2 x2Var = new x2(i2, wVar, lVar, uVar);
        Handler handler = this.f10240m;
        handler.sendMessage(handler.obtainMessage(4, new v1(x2Var, this.f10235h.get(), hVar)));
    }

    public final void l(@NonNull e0 e0Var) {
        synchronized (p) {
            if (this.f10237j != e0Var) {
                this.f10237j = e0Var;
                this.f10238k.clear();
            }
            this.f10238k.addAll(e0Var.r());
        }
    }

    public final void p(@NonNull e0 e0Var) {
        synchronized (p) {
            if (this.f10237j == e0Var) {
                this.f10237j = null;
                this.f10238k.clear();
            }
        }
    }

    public final int r() {
        return this.f10234g.getAndIncrement();
    }

    public final e.j.a.b.j.k<Boolean> v(e.j.a.b.c.n.h<?> hVar) {
        f0 f0Var = new f0(hVar.w());
        Handler handler = this.f10240m;
        handler.sendMessage(handler.obtainMessage(14, f0Var));
        return f0Var.a().a();
    }

    public final boolean w(ConnectionResult connectionResult, int i2) {
        return this.f10232e.J(this.f10231d, connectionResult, i2);
    }

    /* loaded from: classes2.dex */
    public static class b {
        private final z2<?> a;
        private final Feature b;

        private b(z2<?> z2Var, Feature feature) {
            this.a = z2Var;
            this.b = feature;
        }

        public final boolean equals(Object obj) {
            if (obj != null && (obj instanceof b)) {
                b bVar = (b) obj;
                if (e.j.a.b.c.r.y.a(this.a, bVar.a) && e.j.a.b.c.r.y.a(this.b, bVar.b)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return e.j.a.b.c.r.y.b(this.a, this.b);
        }

        public final String toString() {
            return e.j.a.b.c.r.y.c(this).a("key", this.a).a("feature", this.b).toString();
        }

        public /* synthetic */ b(z2 z2Var, Feature feature, j1 j1Var) {
            this(z2Var, feature);
        }
    }
}
