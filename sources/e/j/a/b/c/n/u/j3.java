package e.j.a.b.c.n.u;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.xiaomi.mipush.sdk.Constants;
import e.j.a.b.c.n.a;
import e.j.a.b.c.n.u.d;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes2.dex */
public final class j3 implements s1 {
    private final Context a;
    private final w0 b;

    /* renamed from: c  reason: collision with root package name */
    private final Looper f10262c;

    /* renamed from: d  reason: collision with root package name */
    private final f1 f10263d;

    /* renamed from: e  reason: collision with root package name */
    private final f1 f10264e;

    /* renamed from: f  reason: collision with root package name */
    private final Map<a.c<?>, f1> f10265f;

    /* renamed from: h  reason: collision with root package name */
    private final a.f f10267h;

    /* renamed from: i  reason: collision with root package name */
    private Bundle f10268i;

    /* renamed from: m  reason: collision with root package name */
    private final Lock f10272m;

    /* renamed from: g  reason: collision with root package name */
    private final Set<s> f10266g = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: j  reason: collision with root package name */
    private ConnectionResult f10269j = null;

    /* renamed from: k  reason: collision with root package name */
    private ConnectionResult f10270k = null;

    /* renamed from: l  reason: collision with root package name */
    private boolean f10271l = false;
    @GuardedBy("mLock")
    private int n = 0;

    private j3(Context context, w0 w0Var, Lock lock, Looper looper, e.j.a.b.c.f fVar, Map<a.c<?>, a.f> map, Map<a.c<?>, a.f> map2, e.j.a.b.c.r.f fVar2, a.AbstractC0333a<? extends e.j.a.b.h.f, e.j.a.b.h.a> abstractC0333a, a.f fVar3, ArrayList<h3> arrayList, ArrayList<h3> arrayList2, Map<e.j.a.b.c.n.a<?>, Boolean> map3, Map<e.j.a.b.c.n.a<?>, Boolean> map4) {
        this.a = context;
        this.b = w0Var;
        this.f10272m = lock;
        this.f10262c = looper;
        this.f10267h = fVar3;
        this.f10263d = new f1(context, w0Var, lock, looper, fVar, map2, null, map4, null, arrayList2, new l3(this, null));
        this.f10264e = new f1(context, w0Var, lock, looper, fVar, map, fVar2, map3, abstractC0333a, arrayList, new m3(this, null));
        ArrayMap arrayMap = new ArrayMap();
        for (a.c<?> cVar : map2.keySet()) {
            arrayMap.put(cVar, this.f10263d);
        }
        for (a.c<?> cVar2 : map.keySet()) {
            arrayMap.put(cVar2, this.f10264e);
        }
        this.f10265f = Collections.unmodifiableMap(arrayMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mLock")
    public final void B() {
        ConnectionResult connectionResult;
        if (w(this.f10269j)) {
            if (!w(this.f10270k) && !D()) {
                ConnectionResult connectionResult2 = this.f10270k;
                if (connectionResult2 != null) {
                    if (this.n == 1) {
                        C();
                        return;
                    }
                    o(connectionResult2);
                    this.f10263d.disconnect();
                    return;
                }
                return;
            }
            int i2 = this.n;
            if (i2 != 1) {
                if (i2 != 2) {
                    Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new AssertionError());
                    this.n = 0;
                }
                this.b.a(this.f10268i);
            }
            C();
            this.n = 0;
        } else if (this.f10269j != null && w(this.f10270k)) {
            this.f10264e.disconnect();
            o(this.f10269j);
        } else {
            ConnectionResult connectionResult3 = this.f10269j;
            if (connectionResult3 == null || (connectionResult = this.f10270k) == null) {
                return;
            }
            if (this.f10264e.f10222m < this.f10263d.f10222m) {
                connectionResult3 = connectionResult;
            }
            o(connectionResult3);
        }
    }

    @GuardedBy("mLock")
    private final void C() {
        for (s sVar : this.f10266g) {
            sVar.onComplete();
        }
        this.f10266g.clear();
    }

    @GuardedBy("mLock")
    private final boolean D() {
        ConnectionResult connectionResult = this.f10270k;
        return connectionResult != null && connectionResult.getErrorCode() == 4;
    }

    public static j3 b(Context context, w0 w0Var, Lock lock, Looper looper, e.j.a.b.c.f fVar, Map<a.c<?>, a.f> map, e.j.a.b.c.r.f fVar2, Map<e.j.a.b.c.n.a<?>, Boolean> map2, a.AbstractC0333a<? extends e.j.a.b.h.f, e.j.a.b.h.a> abstractC0333a, ArrayList<h3> arrayList) {
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        a.f fVar3 = null;
        for (Map.Entry<a.c<?>, a.f> entry : map.entrySet()) {
            a.f value = entry.getValue();
            if (value.f()) {
                fVar3 = value;
            }
            if (value.j()) {
                arrayMap.put(entry.getKey(), value);
            } else {
                arrayMap2.put(entry.getKey(), value);
            }
        }
        e.j.a.b.c.r.a0.r(!arrayMap.isEmpty(), "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
        ArrayMap arrayMap3 = new ArrayMap();
        ArrayMap arrayMap4 = new ArrayMap();
        for (e.j.a.b.c.n.a<?> aVar : map2.keySet()) {
            a.c<?> a = aVar.a();
            if (arrayMap.containsKey(a)) {
                arrayMap3.put(aVar, map2.get(aVar));
            } else if (arrayMap2.containsKey(a)) {
                arrayMap4.put(aVar, map2.get(aVar));
            } else {
                throw new IllegalStateException("Each API in the isOptionalMap must have a corresponding client in the clients map.");
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            h3 h3Var = arrayList.get(i2);
            i2++;
            h3 h3Var2 = h3Var;
            if (arrayMap3.containsKey(h3Var2.a)) {
                arrayList2.add(h3Var2);
            } else if (arrayMap4.containsKey(h3Var2.a)) {
                arrayList3.add(h3Var2);
            } else {
                throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the isOptionalMap");
            }
        }
        return new j3(context, w0Var, lock, looper, fVar, arrayMap, arrayMap2, fVar2, abstractC0333a, fVar3, arrayList2, arrayList3, arrayMap3, arrayMap4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mLock")
    public final void m(int i2, boolean z) {
        this.b.c(i2, z);
        this.f10270k = null;
        this.f10269j = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(Bundle bundle) {
        Bundle bundle2 = this.f10268i;
        if (bundle2 == null) {
            this.f10268i = bundle;
        } else if (bundle != null) {
            bundle2.putAll(bundle);
        }
    }

    @GuardedBy("mLock")
    private final void o(ConnectionResult connectionResult) {
        int i2 = this.n;
        if (i2 != 1) {
            if (i2 != 2) {
                Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                this.n = 0;
            }
            this.b.b(connectionResult);
        }
        C();
        this.n = 0;
    }

    private final boolean r(d.a<? extends e.j.a.b.c.n.p, ? extends a.b> aVar) {
        a.c<? extends a.b> x = aVar.x();
        e.j.a.b.c.r.a0.b(this.f10265f.containsKey(x), "GoogleApiClient is not configured to use the API required for this call.");
        return this.f10265f.get(x).equals(this.f10264e);
    }

    @Nullable
    private final PendingIntent t() {
        if (this.f10267h == null) {
            return null;
        }
        return PendingIntent.getActivity(this.a, System.identityHashCode(this.b), this.f10267h.v(), 134217728);
    }

    private static boolean w(ConnectionResult connectionResult) {
        return connectionResult != null && connectionResult.isSuccess();
    }

    @Override // e.j.a.b.c.n.u.s1
    @GuardedBy("mLock")
    public final <A extends a.b, T extends d.a<? extends e.j.a.b.c.n.p, A>> T c(@NonNull T t) {
        if (r(t)) {
            if (D()) {
                t.a(new Status(4, null, t()));
                return t;
            }
            return (T) this.f10264e.c(t);
        }
        return (T) this.f10263d.c(t);
    }

    @Override // e.j.a.b.c.n.u.s1
    @GuardedBy("mLock")
    public final void connect() {
        this.n = 2;
        this.f10271l = false;
        this.f10270k = null;
        this.f10269j = null;
        this.f10263d.connect();
        this.f10264e.connect();
    }

    @Override // e.j.a.b.c.n.u.s1
    public final void d(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append((CharSequence) str).append("authClient").println(Constants.COLON_SEPARATOR);
        this.f10264e.d(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
        printWriter.append((CharSequence) str).append("anonClient").println(Constants.COLON_SEPARATOR);
        this.f10263d.d(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
    }

    @Override // e.j.a.b.c.n.u.s1
    @GuardedBy("mLock")
    public final void disconnect() {
        this.f10270k = null;
        this.f10269j = null;
        this.n = 0;
        this.f10263d.disconnect();
        this.f10264e.disconnect();
        C();
    }

    @Override // e.j.a.b.c.n.u.s1
    @GuardedBy("mLock")
    public final <A extends a.b, R extends e.j.a.b.c.n.p, T extends d.a<R, A>> T e(@NonNull T t) {
        if (r(t)) {
            if (D()) {
                t.a(new Status(4, null, t()));
                return t;
            }
            return (T) this.f10264e.e(t);
        }
        return (T) this.f10263d.e(t);
    }

    @Override // e.j.a.b.c.n.u.s1
    @GuardedBy("mLock")
    public final ConnectionResult f(long j2, @NonNull TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    @Override // e.j.a.b.c.n.u.s1
    @Nullable
    @GuardedBy("mLock")
    public final ConnectionResult g(@NonNull e.j.a.b.c.n.a<?> aVar) {
        if (this.f10265f.get(aVar.a()).equals(this.f10264e)) {
            if (D()) {
                return new ConnectionResult(4, t());
            }
            return this.f10264e.g(aVar);
        }
        return this.f10263d.g(aVar);
    }

    @Override // e.j.a.b.c.n.u.s1
    public final boolean h(s sVar) {
        this.f10272m.lock();
        try {
            if ((isConnecting() || isConnected()) && !this.f10264e.isConnected()) {
                this.f10266g.add(sVar);
                if (this.n == 0) {
                    this.n = 1;
                }
                this.f10270k = null;
                this.f10264e.connect();
                return true;
            }
            this.f10272m.unlock();
            return false;
        } finally {
            this.f10272m.unlock();
        }
    }

    @Override // e.j.a.b.c.n.u.s1
    @GuardedBy("mLock")
    public final void i() {
        this.f10263d.i();
        this.f10264e.i();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001e, code lost:
        if (r2.n == 1) goto L12;
     */
    @Override // e.j.a.b.c.n.u.s1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean isConnected() {
        /*
            r2 = this;
            java.util.concurrent.locks.Lock r0 = r2.f10272m
            r0.lock()
            e.j.a.b.c.n.u.f1 r0 = r2.f10263d     // Catch: java.lang.Throwable -> L28
            boolean r0 = r0.isConnected()     // Catch: java.lang.Throwable -> L28
            r1 = 1
            if (r0 == 0) goto L21
            e.j.a.b.c.n.u.f1 r0 = r2.f10264e     // Catch: java.lang.Throwable -> L28
            boolean r0 = r0.isConnected()     // Catch: java.lang.Throwable -> L28
            if (r0 != 0) goto L22
            boolean r0 = r2.D()     // Catch: java.lang.Throwable -> L28
            if (r0 != 0) goto L22
            int r0 = r2.n     // Catch: java.lang.Throwable -> L28
            if (r0 != r1) goto L21
            goto L22
        L21:
            r1 = 0
        L22:
            java.util.concurrent.locks.Lock r0 = r2.f10272m
            r0.unlock()
            return r1
        L28:
            r0 = move-exception
            java.util.concurrent.locks.Lock r1 = r2.f10272m
            r1.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.j.a.b.c.n.u.j3.isConnected():boolean");
    }

    @Override // e.j.a.b.c.n.u.s1
    public final boolean isConnecting() {
        this.f10272m.lock();
        try {
            return this.n == 2;
        } finally {
            this.f10272m.unlock();
        }
    }

    @Override // e.j.a.b.c.n.u.s1
    public final void j() {
        this.f10272m.lock();
        try {
            boolean isConnecting = isConnecting();
            this.f10264e.disconnect();
            this.f10270k = new ConnectionResult(4);
            if (isConnecting) {
                new e.j.a.b.f.a.o(this.f10262c).post(new k3(this));
            } else {
                C();
            }
        } finally {
            this.f10272m.unlock();
        }
    }

    @Override // e.j.a.b.c.n.u.s1
    @GuardedBy("mLock")
    public final ConnectionResult k() {
        throw new UnsupportedOperationException();
    }
}
