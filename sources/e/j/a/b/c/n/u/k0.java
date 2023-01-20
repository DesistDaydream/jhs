package e.j.a.b.c.n.u;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.signin.internal.zaj;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import e.j.a.b.c.n.a;
import e.j.a.b.c.n.u.d;
import e.j.a.b.c.r.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes2.dex */
public final class k0 implements e1 {
    private final f1 a;
    private final Lock b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f10273c;

    /* renamed from: d  reason: collision with root package name */
    private final e.j.a.b.c.f f10274d;

    /* renamed from: e  reason: collision with root package name */
    private ConnectionResult f10275e;

    /* renamed from: f  reason: collision with root package name */
    private int f10276f;

    /* renamed from: h  reason: collision with root package name */
    private int f10278h;

    /* renamed from: k  reason: collision with root package name */
    private e.j.a.b.h.f f10281k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f10282l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f10283m;
    private boolean n;
    private e.j.a.b.c.r.q o;
    private boolean p;
    private boolean q;
    private final e.j.a.b.c.r.f r;
    private final Map<e.j.a.b.c.n.a<?>, Boolean> s;
    private final a.AbstractC0333a<? extends e.j.a.b.h.f, e.j.a.b.h.a> t;

    /* renamed from: g  reason: collision with root package name */
    private int f10277g = 0;

    /* renamed from: i  reason: collision with root package name */
    private final Bundle f10279i = new Bundle();

    /* renamed from: j  reason: collision with root package name */
    private final Set<a.c> f10280j = new HashSet();
    private ArrayList<Future<?>> u = new ArrayList<>();

    public k0(f1 f1Var, e.j.a.b.c.r.f fVar, Map<e.j.a.b.c.n.a<?>, Boolean> map, e.j.a.b.c.f fVar2, a.AbstractC0333a<? extends e.j.a.b.h.f, e.j.a.b.h.a> abstractC0333a, Lock lock, Context context) {
        this.a = f1Var;
        this.r = fVar;
        this.s = map;
        this.f10274d = fVar2;
        this.t = abstractC0333a;
        this.b = lock;
        this.f10273c = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mLock")
    public final void A(ConnectionResult connectionResult) {
        p();
        t(!connectionResult.hasResolution());
        this.a.r(connectionResult);
        this.a.o.b(connectionResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mLock")
    public final void j(zaj zajVar) {
        if (w(0)) {
            ConnectionResult connectionResult = zajVar.getConnectionResult();
            if (connectionResult.isSuccess()) {
                ResolveAccountResponse zacx = zajVar.zacx();
                ConnectionResult connectionResult2 = zacx.getConnectionResult();
                if (!connectionResult2.isSuccess()) {
                    String valueOf = String.valueOf(connectionResult2);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 48);
                    sb.append("Sign-in succeeded with resolve account failure: ");
                    sb.append(valueOf);
                    Log.wtf("GoogleApiClientConnecting", sb.toString(), new Exception());
                    A(connectionResult2);
                    return;
                }
                this.n = true;
                this.o = zacx.getAccountAccessor();
                this.p = zacx.getSaveDefaultAccount();
                this.q = zacx.isFromCrossClientAuth();
                m();
            } else if (z(connectionResult)) {
                o();
                m();
            } else {
                A(connectionResult);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mLock")
    public final boolean l() {
        int i2 = this.f10278h - 1;
        this.f10278h = i2;
        if (i2 > 0) {
            return false;
        }
        if (i2 < 0) {
            Log.w("GoogleApiClientConnecting", this.a.n.S());
            Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
            A(new ConnectionResult(8, null));
            return false;
        }
        ConnectionResult connectionResult = this.f10275e;
        if (connectionResult != null) {
            this.a.f10222m = this.f10276f;
            A(connectionResult);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mLock")
    public final void m() {
        if (this.f10278h != 0) {
            return;
        }
        if (!this.f10283m || this.n) {
            ArrayList arrayList = new ArrayList();
            this.f10277g = 1;
            this.f10278h = this.a.f10215f.size();
            for (a.c<?> cVar : this.a.f10215f.keySet()) {
                if (this.a.f10216g.containsKey(cVar)) {
                    if (l()) {
                        n();
                    }
                } else {
                    arrayList.add(this.a.f10215f.get(cVar));
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            this.u.add(i1.a().submit(new q0(this, arrayList)));
        }
    }

    @GuardedBy("mLock")
    private final void n() {
        this.a.q();
        i1.a().execute(new l0(this));
        e.j.a.b.h.f fVar = this.f10281k;
        if (fVar != null) {
            if (this.p) {
                fVar.b(this.o, this.q);
            }
            t(false);
        }
        for (a.c<?> cVar : this.a.f10216g.keySet()) {
            this.a.f10215f.get(cVar).disconnect();
        }
        this.a.o.a(this.f10279i.isEmpty() ? null : this.f10279i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mLock")
    public final void o() {
        this.f10283m = false;
        this.a.n.t = Collections.emptySet();
        for (a.c<?> cVar : this.f10280j) {
            if (!this.a.f10216g.containsKey(cVar)) {
                this.a.f10216g.put(cVar, new ConnectionResult(17, null));
            }
        }
    }

    private final void p() {
        ArrayList<Future<?>> arrayList = this.u;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Future<?> future = arrayList.get(i2);
            i2++;
            future.cancel(true);
        }
        this.u.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Set<Scope> q() {
        if (this.r == null) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet(this.r.l());
        Map<e.j.a.b.c.n.a<?>, f.b> i2 = this.r.i();
        for (e.j.a.b.c.n.a<?> aVar : i2.keySet()) {
            if (!this.a.f10216g.containsKey(aVar.a())) {
                hashSet.addAll(i2.get(aVar).a);
            }
        }
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0022, code lost:
        if ((r5.hasResolution() || r4.f10274d.d(r5.getErrorCode()) != null) != false) goto L15;
     */
    @javax.annotation.concurrent.GuardedBy("mLock")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void s(com.google.android.gms.common.ConnectionResult r5, e.j.a.b.c.n.a<?> r6, boolean r7) {
        /*
            r4 = this;
            e.j.a.b.c.n.a$e r0 = r6.c()
            int r0 = r0.b()
            r1 = 0
            r2 = 1
            if (r7 == 0) goto L24
            boolean r7 = r5.hasResolution()
            if (r7 == 0) goto L14
        L12:
            r7 = 1
            goto L22
        L14:
            e.j.a.b.c.f r7 = r4.f10274d
            int r3 = r5.getErrorCode()
            android.content.Intent r7 = r7.d(r3)
            if (r7 == 0) goto L21
            goto L12
        L21:
            r7 = 0
        L22:
            if (r7 == 0) goto L2d
        L24:
            com.google.android.gms.common.ConnectionResult r7 = r4.f10275e
            if (r7 == 0) goto L2c
            int r7 = r4.f10276f
            if (r0 >= r7) goto L2d
        L2c:
            r1 = 1
        L2d:
            if (r1 == 0) goto L33
            r4.f10275e = r5
            r4.f10276f = r0
        L33:
            e.j.a.b.c.n.u.f1 r7 = r4.a
            java.util.Map<e.j.a.b.c.n.a$c<?>, com.google.android.gms.common.ConnectionResult> r7 = r7.f10216g
            e.j.a.b.c.n.a$c r6 = r6.a()
            r7.put(r6, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e.j.a.b.c.n.u.k0.s(com.google.android.gms.common.ConnectionResult, e.j.a.b.c.n.a, boolean):void");
    }

    @GuardedBy("mLock")
    private final void t(boolean z) {
        e.j.a.b.h.f fVar = this.f10281k;
        if (fVar != null) {
            if (fVar.isConnected() && z) {
                this.f10281k.n();
            }
            this.f10281k.disconnect();
            if (this.r.o()) {
                this.f10281k = null;
            }
            this.o = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mLock")
    public final boolean w(int i2) {
        if (this.f10277g != i2) {
            Log.w("GoogleApiClientConnecting", this.a.n.S());
            String valueOf = String.valueOf(this);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 23);
            sb.append("Unexpected callback in ");
            sb.append(valueOf);
            Log.w("GoogleApiClientConnecting", sb.toString());
            int i3 = this.f10278h;
            StringBuilder sb2 = new StringBuilder(33);
            sb2.append("mRemainingConnections=");
            sb2.append(i3);
            Log.w("GoogleApiClientConnecting", sb2.toString());
            String y = y(this.f10277g);
            String y2 = y(i2);
            StringBuilder sb3 = new StringBuilder(String.valueOf(y).length() + 70 + String.valueOf(y2).length());
            sb3.append("GoogleApiClient connecting is in step ");
            sb3.append(y);
            sb3.append(" but received callback for step ");
            sb3.append(y2);
            Log.wtf("GoogleApiClientConnecting", sb3.toString(), new Exception());
            A(new ConnectionResult(8, null));
            return false;
        }
        return true;
    }

    private static String y(int i2) {
        return i2 != 0 ? i2 != 1 ? GrsBaseInfo.CountryCodeSource.UNKNOWN : "STEP_GETTING_REMOTE_SERVICE" : "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mLock")
    public final boolean z(ConnectionResult connectionResult) {
        return this.f10282l && !connectionResult.hasResolution();
    }

    @Override // e.j.a.b.c.n.u.e1
    @GuardedBy("mLock")
    public final void a(Bundle bundle) {
        if (w(1)) {
            if (bundle != null) {
                this.f10279i.putAll(bundle);
            }
            if (l()) {
                n();
            }
        }
    }

    @Override // e.j.a.b.c.n.u.e1
    @GuardedBy("mLock")
    public final void b(ConnectionResult connectionResult, e.j.a.b.c.n.a<?> aVar, boolean z) {
        if (w(1)) {
            s(connectionResult, aVar, z);
            if (l()) {
                n();
            }
        }
    }

    @Override // e.j.a.b.c.n.u.e1
    public final <A extends a.b, T extends d.a<? extends e.j.a.b.c.n.p, A>> T c(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    @Override // e.j.a.b.c.n.u.e1
    public final void connect() {
    }

    @Override // e.j.a.b.c.n.u.e1
    @GuardedBy("mLock")
    public final void d() {
        this.a.f10216g.clear();
        this.f10283m = false;
        this.f10275e = null;
        this.f10277g = 0;
        this.f10282l = true;
        this.n = false;
        this.p = false;
        HashMap hashMap = new HashMap();
        boolean z = false;
        for (e.j.a.b.c.n.a<?> aVar : this.s.keySet()) {
            a.f fVar = this.a.f10215f.get(aVar.a());
            z |= aVar.c().b() == 1;
            boolean booleanValue = this.s.get(aVar).booleanValue();
            if (fVar.j()) {
                this.f10283m = true;
                if (booleanValue) {
                    this.f10280j.add(aVar.a());
                } else {
                    this.f10282l = false;
                }
            }
            hashMap.put(fVar, new m0(this, aVar, booleanValue));
        }
        if (z) {
            this.f10283m = false;
        }
        if (this.f10283m) {
            this.r.p(Integer.valueOf(System.identityHashCode(this.a.n)));
            t0 t0Var = new t0(this, null);
            a.AbstractC0333a<? extends e.j.a.b.h.f, e.j.a.b.h.a> abstractC0333a = this.t;
            Context context = this.f10273c;
            Looper q = this.a.n.q();
            e.j.a.b.c.r.f fVar2 = this.r;
            this.f10281k = abstractC0333a.c(context, q, fVar2, fVar2.m(), t0Var, t0Var);
        }
        this.f10278h = this.a.f10215f.size();
        this.u.add(i1.a().submit(new n0(this, hashMap)));
    }

    @Override // e.j.a.b.c.n.u.e1
    @GuardedBy("mLock")
    public final boolean disconnect() {
        p();
        t(true);
        this.a.r(null);
        return true;
    }

    @Override // e.j.a.b.c.n.u.e1
    public final <A extends a.b, R extends e.j.a.b.c.n.p, T extends d.a<R, A>> T e(T t) {
        this.a.n.f10338l.add(t);
        return t;
    }

    @Override // e.j.a.b.c.n.u.e1
    @GuardedBy("mLock")
    public final void onConnectionSuspended(int i2) {
        A(new ConnectionResult(8, null));
    }
}
