package e.j.a.b.c.n.u;

import android.content.Context;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import e.j.a.b.c.n.a;
import e.j.a.b.c.n.u.d;
import e.j.a.b.c.r.f;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes2.dex */
public final class o3 implements s1 {

    /* renamed from: c  reason: collision with root package name */
    private final Map<e.j.a.b.c.n.a<?>, Boolean> f10300c;

    /* renamed from: d  reason: collision with root package name */
    private final g f10301d;

    /* renamed from: e  reason: collision with root package name */
    private final w0 f10302e;

    /* renamed from: f  reason: collision with root package name */
    private final Lock f10303f;

    /* renamed from: g  reason: collision with root package name */
    private final Looper f10304g;

    /* renamed from: h  reason: collision with root package name */
    private final e.j.a.b.c.f f10305h;

    /* renamed from: i  reason: collision with root package name */
    private final Condition f10306i;

    /* renamed from: j  reason: collision with root package name */
    private final e.j.a.b.c.r.f f10307j;

    /* renamed from: k  reason: collision with root package name */
    private final boolean f10308k;

    /* renamed from: l  reason: collision with root package name */
    private final boolean f10309l;
    @GuardedBy("mLock")
    private boolean n;
    @GuardedBy("mLock")
    private Map<z2<?>, ConnectionResult> o;
    @GuardedBy("mLock")
    private Map<z2<?>, ConnectionResult> p;
    @GuardedBy("mLock")
    private a0 q;
    @GuardedBy("mLock")
    private ConnectionResult r;
    private final Map<a.c<?>, n3<?>> a = new HashMap();
    private final Map<a.c<?>, n3<?>> b = new HashMap();

    /* renamed from: m  reason: collision with root package name */
    private final Queue<d.a<?, ?>> f10310m = new LinkedList();

    public o3(Context context, Lock lock, Looper looper, e.j.a.b.c.f fVar, Map<a.c<?>, a.f> map, e.j.a.b.c.r.f fVar2, Map<e.j.a.b.c.n.a<?>, Boolean> map2, a.AbstractC0333a<? extends e.j.a.b.h.f, e.j.a.b.h.a> abstractC0333a, ArrayList<h3> arrayList, w0 w0Var, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        this.f10303f = lock;
        this.f10304g = looper;
        this.f10306i = lock.newCondition();
        this.f10305h = fVar;
        this.f10302e = w0Var;
        this.f10300c = map2;
        this.f10307j = fVar2;
        this.f10308k = z;
        HashMap hashMap = new HashMap();
        for (e.j.a.b.c.n.a<?> aVar : map2.keySet()) {
            hashMap.put(aVar.a(), aVar);
        }
        HashMap hashMap2 = new HashMap();
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            h3 h3Var = arrayList.get(i2);
            i2++;
            h3 h3Var2 = h3Var;
            hashMap2.put(h3Var2.a, h3Var2);
        }
        boolean z5 = false;
        boolean z6 = true;
        boolean z7 = false;
        for (Map.Entry<a.c<?>, a.f> entry : map.entrySet()) {
            e.j.a.b.c.n.a aVar2 = (e.j.a.b.c.n.a) hashMap.get(entry.getKey());
            a.f value = entry.getValue();
            if (value.i()) {
                z4 = z6;
                if (this.f10300c.get(aVar2).booleanValue()) {
                    z3 = z7;
                    z2 = true;
                } else {
                    z2 = true;
                    z3 = true;
                }
            } else {
                z2 = z5;
                z3 = z7;
                z4 = false;
            }
            n3<?> n3Var = new n3<>(context, aVar2, looper, value, (h3) hashMap2.get(aVar2), fVar2, abstractC0333a);
            this.a.put(entry.getKey(), n3Var);
            if (value.j()) {
                this.b.put(entry.getKey(), n3Var);
            }
            z5 = z2;
            z6 = z4;
            z7 = z3;
        }
        this.f10309l = (!z5 || z6 || z7) ? false : true;
        this.f10301d = g.q();
    }

    @Nullable
    private final ConnectionResult a(@NonNull a.c<?> cVar) {
        this.f10303f.lock();
        try {
            n3<?> n3Var = this.a.get(cVar);
            Map<z2<?>, ConnectionResult> map = this.o;
            if (map != null && n3Var != null) {
                return map.get(n3Var.w());
            }
            this.f10303f.unlock();
            return null;
        } finally {
            this.f10303f.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean n(n3<?> n3Var, ConnectionResult connectionResult) {
        return !connectionResult.isSuccess() && !connectionResult.hasResolution() && this.f10300c.get(n3Var.m()).booleanValue() && n3Var.x().i() && this.f10305h.o(connectionResult.getErrorCode());
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001f A[Catch: all -> 0x0044, TryCatch #0 {all -> 0x0044, blocks: (B:3:0x0005, B:5:0x000a, B:8:0x000f, B:9:0x0019, B:11:0x001f, B:13:0x002b), top: B:24:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean q() {
        /*
            r3 = this;
            java.util.concurrent.locks.Lock r0 = r3.f10303f
            r0.lock()
            boolean r0 = r3.n     // Catch: java.lang.Throwable -> L44
            r1 = 0
            if (r0 == 0) goto L3e
            boolean r0 = r3.f10308k     // Catch: java.lang.Throwable -> L44
            if (r0 != 0) goto Lf
            goto L3e
        Lf:
            java.util.Map<e.j.a.b.c.n.a$c<?>, e.j.a.b.c.n.u.n3<?>> r0 = r3.b     // Catch: java.lang.Throwable -> L44
            java.util.Set r0 = r0.keySet()     // Catch: java.lang.Throwable -> L44
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L44
        L19:
            boolean r2 = r0.hasNext()     // Catch: java.lang.Throwable -> L44
            if (r2 == 0) goto L37
            java.lang.Object r2 = r0.next()     // Catch: java.lang.Throwable -> L44
            e.j.a.b.c.n.a$c r2 = (e.j.a.b.c.n.a.c) r2     // Catch: java.lang.Throwable -> L44
            com.google.android.gms.common.ConnectionResult r2 = r3.a(r2)     // Catch: java.lang.Throwable -> L44
            if (r2 == 0) goto L31
            boolean r2 = r2.isSuccess()     // Catch: java.lang.Throwable -> L44
            if (r2 != 0) goto L19
        L31:
            java.util.concurrent.locks.Lock r0 = r3.f10303f
            r0.unlock()
            return r1
        L37:
            java.util.concurrent.locks.Lock r0 = r3.f10303f
            r0.unlock()
            r0 = 1
            return r0
        L3e:
            java.util.concurrent.locks.Lock r0 = r3.f10303f
            r0.unlock()
            return r1
        L44:
            r0 = move-exception
            java.util.concurrent.locks.Lock r1 = r3.f10303f
            r1.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.j.a.b.c.n.u.o3.q():boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mLock")
    public final void r() {
        if (this.f10307j == null) {
            this.f10302e.t = Collections.emptySet();
            return;
        }
        HashSet hashSet = new HashSet(this.f10307j.l());
        Map<e.j.a.b.c.n.a<?>, f.b> i2 = this.f10307j.i();
        for (e.j.a.b.c.n.a<?> aVar : i2.keySet()) {
            ConnectionResult g2 = g(aVar);
            if (g2 != null && g2.isSuccess()) {
                hashSet.addAll(i2.get(aVar).a);
            }
        }
        this.f10302e.t = hashSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mLock")
    public final void s() {
        while (!this.f10310m.isEmpty()) {
            c(this.f10310m.remove());
        }
        this.f10302e.a(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    @GuardedBy("mLock")
    public final ConnectionResult t() {
        int i2 = 0;
        ConnectionResult connectionResult = null;
        ConnectionResult connectionResult2 = null;
        int i3 = 0;
        for (n3<?> n3Var : this.a.values()) {
            e.j.a.b.c.n.a<?> m2 = n3Var.m();
            ConnectionResult connectionResult3 = this.o.get(n3Var.w());
            if (!connectionResult3.isSuccess() && (!this.f10300c.get(m2).booleanValue() || connectionResult3.hasResolution() || this.f10305h.o(connectionResult3.getErrorCode()))) {
                if (connectionResult3.getErrorCode() == 4 && this.f10308k) {
                    int b = m2.c().b();
                    if (connectionResult2 == null || i3 > b) {
                        connectionResult2 = connectionResult3;
                        i3 = b;
                    }
                } else {
                    int b2 = m2.c().b();
                    if (connectionResult == null || i2 > b2) {
                        connectionResult = connectionResult3;
                        i2 = b2;
                    }
                }
            }
        }
        return (connectionResult == null || connectionResult2 == null || i2 <= i3) ? connectionResult : connectionResult2;
    }

    private final <T extends d.a<? extends e.j.a.b.c.n.p, ? extends a.b>> boolean v(@NonNull T t) {
        a.c<?> x = t.x();
        ConnectionResult a = a(x);
        if (a == null || a.getErrorCode() != 4) {
            return false;
        }
        t.a(new Status(4, null, this.f10301d.c(this.a.get(x).w(), System.identityHashCode(this.f10302e))));
        return true;
    }

    @Override // e.j.a.b.c.n.u.s1
    public final <A extends a.b, T extends d.a<? extends e.j.a.b.c.n.p, A>> T c(@NonNull T t) {
        a.c<A> x = t.x();
        if (this.f10308k && v(t)) {
            return t;
        }
        this.f10302e.B.b(t);
        return (T) this.a.get(x).k(t);
    }

    @Override // e.j.a.b.c.n.u.s1
    public final void connect() {
        this.f10303f.lock();
        try {
            if (this.n) {
                return;
            }
            this.n = true;
            this.o = null;
            this.p = null;
            this.q = null;
            this.r = null;
            this.f10301d.E();
            this.f10301d.g(this.a.values()).f(new e.j.a.b.c.x.f0.a(this.f10304g), new q3(this));
        } finally {
            this.f10303f.unlock();
        }
    }

    @Override // e.j.a.b.c.n.u.s1
    public final void d(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    @Override // e.j.a.b.c.n.u.s1
    public final void disconnect() {
        this.f10303f.lock();
        try {
            this.n = false;
            this.o = null;
            this.p = null;
            a0 a0Var = this.q;
            if (a0Var != null) {
                a0Var.a();
                this.q = null;
            }
            this.r = null;
            while (!this.f10310m.isEmpty()) {
                d.a<?, ?> remove = this.f10310m.remove();
                remove.q(null);
                remove.e();
            }
            this.f10306i.signalAll();
        } finally {
            this.f10303f.unlock();
        }
    }

    @Override // e.j.a.b.c.n.u.s1
    public final <A extends a.b, R extends e.j.a.b.c.n.p, T extends d.a<R, A>> T e(@NonNull T t) {
        if (this.f10308k && v(t)) {
            return t;
        }
        if (!isConnected()) {
            this.f10310m.add(t);
            return t;
        }
        this.f10302e.B.b(t);
        return (T) this.a.get(t.x()).f(t);
    }

    @Override // e.j.a.b.c.n.u.s1
    @GuardedBy("mLock")
    public final ConnectionResult f(long j2, TimeUnit timeUnit) {
        connect();
        long nanos = timeUnit.toNanos(j2);
        while (isConnecting()) {
            if (nanos <= 0) {
                disconnect();
                return new ConnectionResult(14, null);
            }
            try {
                nanos = this.f10306i.awaitNanos(nanos);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, null);
            }
            Thread.currentThread().interrupt();
            return new ConnectionResult(15, null);
        }
        if (isConnected()) {
            return ConnectionResult.RESULT_SUCCESS;
        }
        ConnectionResult connectionResult = this.r;
        return connectionResult != null ? connectionResult : new ConnectionResult(13, null);
    }

    @Override // e.j.a.b.c.n.u.s1
    @Nullable
    public final ConnectionResult g(@NonNull e.j.a.b.c.n.a<?> aVar) {
        return a(aVar.a());
    }

    @Override // e.j.a.b.c.n.u.s1
    public final boolean h(s sVar) {
        this.f10303f.lock();
        try {
            if (this.n && !q()) {
                this.f10301d.E();
                this.q = new a0(this, sVar);
                this.f10301d.g(this.b.values()).f(new e.j.a.b.c.x.f0.a(this.f10304g), this.q);
                this.f10303f.unlock();
                return true;
            }
            this.f10303f.unlock();
            return false;
        } catch (Throwable th) {
            this.f10303f.unlock();
            throw th;
        }
    }

    @Override // e.j.a.b.c.n.u.s1
    public final void i() {
    }

    @Override // e.j.a.b.c.n.u.s1
    public final boolean isConnected() {
        boolean z;
        this.f10303f.lock();
        try {
            if (this.o != null) {
                if (this.r == null) {
                    z = true;
                    return z;
                }
            }
            z = false;
            return z;
        } finally {
            this.f10303f.unlock();
        }
    }

    @Override // e.j.a.b.c.n.u.s1
    public final boolean isConnecting() {
        boolean z;
        this.f10303f.lock();
        try {
            if (this.o == null) {
                if (this.n) {
                    z = true;
                    return z;
                }
            }
            z = false;
            return z;
        } finally {
            this.f10303f.unlock();
        }
    }

    @Override // e.j.a.b.c.n.u.s1
    public final void j() {
        this.f10303f.lock();
        try {
            this.f10301d.a();
            a0 a0Var = this.q;
            if (a0Var != null) {
                a0Var.a();
                this.q = null;
            }
            if (this.p == null) {
                this.p = new ArrayMap(this.b.size());
            }
            ConnectionResult connectionResult = new ConnectionResult(4);
            for (n3<?> n3Var : this.b.values()) {
                this.p.put(n3Var.w(), connectionResult);
            }
            Map<z2<?>, ConnectionResult> map = this.o;
            if (map != null) {
                map.putAll(this.p);
            }
        } finally {
            this.f10303f.unlock();
        }
    }

    @Override // e.j.a.b.c.n.u.s1
    @GuardedBy("mLock")
    public final ConnectionResult k() {
        connect();
        while (isConnecting()) {
            try {
                this.f10306i.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, null);
            }
        }
        if (isConnected()) {
            return ConnectionResult.RESULT_SUCCESS;
        }
        ConnectionResult connectionResult = this.r;
        return connectionResult != null ? connectionResult : new ConnectionResult(13, null);
    }
}
