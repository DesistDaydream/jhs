package e.j.a.b.c.n.u;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.xiaomi.mipush.sdk.Constants;
import e.j.a.b.c.n.a;
import e.j.a.b.c.n.u.d;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes2.dex */
public final class f1 implements s1, i3 {
    private final Lock a;
    private final Condition b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f10212c;

    /* renamed from: d  reason: collision with root package name */
    private final e.j.a.b.c.f f10213d;

    /* renamed from: e  reason: collision with root package name */
    private final h1 f10214e;

    /* renamed from: f  reason: collision with root package name */
    public final Map<a.c<?>, a.f> f10215f;

    /* renamed from: h  reason: collision with root package name */
    private final e.j.a.b.c.r.f f10217h;

    /* renamed from: i  reason: collision with root package name */
    private final Map<e.j.a.b.c.n.a<?>, Boolean> f10218i;

    /* renamed from: j  reason: collision with root package name */
    private final a.AbstractC0333a<? extends e.j.a.b.h.f, e.j.a.b.h.a> f10219j;

    /* renamed from: k  reason: collision with root package name */
    private volatile e1 f10220k;

    /* renamed from: m  reason: collision with root package name */
    public int f10222m;
    public final w0 n;
    public final t1 o;

    /* renamed from: g  reason: collision with root package name */
    public final Map<a.c<?>, ConnectionResult> f10216g = new HashMap();

    /* renamed from: l  reason: collision with root package name */
    private ConnectionResult f10221l = null;

    public f1(Context context, w0 w0Var, Lock lock, Looper looper, e.j.a.b.c.f fVar, Map<a.c<?>, a.f> map, e.j.a.b.c.r.f fVar2, Map<e.j.a.b.c.n.a<?>, Boolean> map2, a.AbstractC0333a<? extends e.j.a.b.h.f, e.j.a.b.h.a> abstractC0333a, ArrayList<h3> arrayList, t1 t1Var) {
        this.f10212c = context;
        this.a = lock;
        this.f10213d = fVar;
        this.f10215f = map;
        this.f10217h = fVar2;
        this.f10218i = map2;
        this.f10219j = abstractC0333a;
        this.n = w0Var;
        this.o = t1Var;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            h3 h3Var = arrayList.get(i2);
            i2++;
            h3Var.d(this);
        }
        this.f10214e = new h1(this, looper);
        this.b = lock.newCondition();
        this.f10220k = new v0(this);
    }

    @Override // e.j.a.b.c.n.i.b
    public final void a(@Nullable Bundle bundle) {
        this.a.lock();
        try {
            this.f10220k.a(bundle);
        } finally {
            this.a.unlock();
        }
    }

    @Override // e.j.a.b.c.n.u.i3
    public final void b(@NonNull ConnectionResult connectionResult, @NonNull e.j.a.b.c.n.a<?> aVar, boolean z) {
        this.a.lock();
        try {
            this.f10220k.b(connectionResult, aVar, z);
        } finally {
            this.a.unlock();
        }
    }

    @Override // e.j.a.b.c.n.u.s1
    @GuardedBy("mLock")
    public final <A extends a.b, T extends d.a<? extends e.j.a.b.c.n.p, A>> T c(@NonNull T t) {
        t.u();
        return (T) this.f10220k.c(t);
    }

    @Override // e.j.a.b.c.n.u.s1
    @GuardedBy("mLock")
    public final void connect() {
        this.f10220k.connect();
    }

    @Override // e.j.a.b.c.n.u.s1
    public final void d(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String concat = String.valueOf(str).concat("  ");
        printWriter.append((CharSequence) str).append("mState=").println(this.f10220k);
        for (e.j.a.b.c.n.a<?> aVar : this.f10218i.keySet()) {
            printWriter.append((CharSequence) str).append((CharSequence) aVar.b()).println(Constants.COLON_SEPARATOR);
            this.f10215f.get(aVar.a()).d(concat, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // e.j.a.b.c.n.u.s1
    @GuardedBy("mLock")
    public final void disconnect() {
        if (this.f10220k.disconnect()) {
            this.f10216g.clear();
        }
    }

    @Override // e.j.a.b.c.n.u.s1
    @GuardedBy("mLock")
    public final <A extends a.b, R extends e.j.a.b.c.n.p, T extends d.a<R, A>> T e(@NonNull T t) {
        t.u();
        return (T) this.f10220k.e(t);
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
                nanos = this.b.awaitNanos(nanos);
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
        ConnectionResult connectionResult = this.f10221l;
        return connectionResult != null ? connectionResult : new ConnectionResult(13, null);
    }

    @Override // e.j.a.b.c.n.u.s1
    @Nullable
    @GuardedBy("mLock")
    public final ConnectionResult g(@NonNull e.j.a.b.c.n.a<?> aVar) {
        a.c<?> a = aVar.a();
        if (this.f10215f.containsKey(a)) {
            if (this.f10215f.get(a).isConnected()) {
                return ConnectionResult.RESULT_SUCCESS;
            }
            if (this.f10216g.containsKey(a)) {
                return this.f10216g.get(a);
            }
            return null;
        }
        return null;
    }

    @Override // e.j.a.b.c.n.u.s1
    public final boolean h(s sVar) {
        return false;
    }

    @Override // e.j.a.b.c.n.u.s1
    @GuardedBy("mLock")
    public final void i() {
        if (isConnected()) {
            ((h0) this.f10220k).g();
        }
    }

    @Override // e.j.a.b.c.n.u.s1
    public final boolean isConnected() {
        return this.f10220k instanceof h0;
    }

    @Override // e.j.a.b.c.n.u.s1
    public final boolean isConnecting() {
        return this.f10220k instanceof k0;
    }

    @Override // e.j.a.b.c.n.u.s1
    public final void j() {
    }

    @Override // e.j.a.b.c.n.u.s1
    @GuardedBy("mLock")
    public final ConnectionResult k() {
        connect();
        while (isConnecting()) {
            try {
                this.b.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, null);
            }
        }
        if (isConnected()) {
            return ConnectionResult.RESULT_SUCCESS;
        }
        ConnectionResult connectionResult = this.f10221l;
        return connectionResult != null ? connectionResult : new ConnectionResult(13, null);
    }

    public final void m(g1 g1Var) {
        this.f10214e.sendMessage(this.f10214e.obtainMessage(1, g1Var));
    }

    public final void n() {
        this.a.lock();
        try {
            this.f10220k = new k0(this, this.f10217h, this.f10218i, this.f10213d, this.f10219j, this.a, this.f10212c);
            this.f10220k.d();
            this.b.signalAll();
        } finally {
            this.a.unlock();
        }
    }

    @Override // e.j.a.b.c.n.i.b
    public final void onConnectionSuspended(int i2) {
        this.a.lock();
        try {
            this.f10220k.onConnectionSuspended(i2);
        } finally {
            this.a.unlock();
        }
    }

    public final void p(RuntimeException runtimeException) {
        this.f10214e.sendMessage(this.f10214e.obtainMessage(2, runtimeException));
    }

    public final void q() {
        this.a.lock();
        try {
            this.n.Q();
            this.f10220k = new h0(this);
            this.f10220k.d();
            this.b.signalAll();
        } finally {
            this.a.unlock();
        }
    }

    public final void r(ConnectionResult connectionResult) {
        this.a.lock();
        try {
            this.f10221l = connectionResult;
            this.f10220k = new v0(this);
            this.f10220k.d();
            this.b.signalAll();
        } finally {
            this.a.unlock();
        }
    }
}
