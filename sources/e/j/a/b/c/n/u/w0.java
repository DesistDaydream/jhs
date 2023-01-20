package e.j.a.b.c.n.u;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zabq;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import e.j.a.b.c.n.a;
import e.j.a.b.c.n.i;
import e.j.a.b.c.n.u.d;
import e.j.a.b.c.r.l;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes2.dex */
public final class w0 extends e.j.a.b.c.n.i implements t1 {
    public Set<n2> A;
    public final q2 B;
    private final l.a C;

    /* renamed from: e */
    private final Lock f10331e;

    /* renamed from: f */
    private boolean f10332f;

    /* renamed from: g */
    private final e.j.a.b.c.r.l f10333g;

    /* renamed from: i */
    private final int f10335i;

    /* renamed from: j */
    private final Context f10336j;

    /* renamed from: k */
    private final Looper f10337k;

    /* renamed from: m */
    private volatile boolean f10339m;
    private long n;
    private long o;
    private final c1 p;
    private final e.j.a.b.c.e q;
    @e.j.a.b.c.x.d0
    private zabq r;
    public final Map<a.c<?>, a.f> s;
    public Set<Scope> t;
    private final e.j.a.b.c.r.f u;
    private final Map<e.j.a.b.c.n.a<?>, Boolean> v;
    private final a.AbstractC0333a<? extends e.j.a.b.h.f, e.j.a.b.h.a> w;
    private final m x;
    private final ArrayList<h3> y;
    private Integer z;

    /* renamed from: h */
    private s1 f10334h = null;
    @e.j.a.b.c.x.d0

    /* renamed from: l */
    public final Queue<d.a<?, ?>> f10338l = new LinkedList();

    public w0(Context context, Lock lock, Looper looper, e.j.a.b.c.r.f fVar, e.j.a.b.c.e eVar, a.AbstractC0333a<? extends e.j.a.b.h.f, e.j.a.b.h.a> abstractC0333a, Map<e.j.a.b.c.n.a<?>, Boolean> map, List<i.b> list, List<i.c> list2, Map<a.c<?>, a.f> map2, int i2, int i3, ArrayList<h3> arrayList, boolean z) {
        this.n = e.j.a.b.c.x.e.b() ? com.heytap.mcssdk.constant.a.q : 120000L;
        this.o = 5000L;
        this.t = new HashSet();
        this.x = new m();
        this.z = null;
        this.A = null;
        x0 x0Var = new x0(this);
        this.C = x0Var;
        this.f10336j = context;
        this.f10331e = lock;
        this.f10332f = false;
        this.f10333g = new e.j.a.b.c.r.l(looper, x0Var);
        this.f10337k = looper;
        this.p = new c1(this, looper);
        this.q = eVar;
        this.f10335i = i2;
        if (i2 >= 0) {
            this.z = Integer.valueOf(i3);
        }
        this.v = map;
        this.s = map2;
        this.y = arrayList;
        this.B = new q2(map2);
        for (i.b bVar : list) {
            this.f10333g.j(bVar);
        }
        for (i.c cVar : list2) {
            this.f10333g.k(cVar);
        }
        this.u = fVar;
        this.w = abstractC0333a;
    }

    public final void J() {
        this.f10331e.lock();
        try {
            if (this.f10339m) {
                O();
            }
        } finally {
            this.f10331e.unlock();
        }
    }

    public static int K(Iterable<a.f> iterable, boolean z) {
        boolean z2 = false;
        boolean z3 = false;
        for (a.f fVar : iterable) {
            if (fVar.j()) {
                z2 = true;
            }
            if (fVar.f()) {
                z3 = true;
            }
        }
        if (z2) {
            return (z3 && z) ? 2 : 1;
        }
        return 3;
    }

    public final void L(e.j.a.b.c.n.i iVar, v vVar, boolean z) {
        e.j.a.b.c.r.j0.a.f10423d.a(iVar).g(new b1(this, vVar, z, iVar));
    }

    @GuardedBy("mLock")
    private final void O() {
        this.f10333g.c();
        this.f10334h.connect();
    }

    public final void P() {
        this.f10331e.lock();
        try {
            if (Q()) {
                O();
            }
        } finally {
            this.f10331e.unlock();
        }
    }

    private final void V(int i2) {
        Integer num = this.z;
        if (num == null) {
            this.z = Integer.valueOf(i2);
        } else if (num.intValue() != i2) {
            String W = W(i2);
            String W2 = W(this.z.intValue());
            StringBuilder sb = new StringBuilder(String.valueOf(W).length() + 51 + String.valueOf(W2).length());
            sb.append("Cannot use sign-in mode: ");
            sb.append(W);
            sb.append(". Mode was already set to ");
            sb.append(W2);
            throw new IllegalStateException(sb.toString());
        }
        if (this.f10334h != null) {
            return;
        }
        boolean z = false;
        boolean z2 = false;
        for (a.f fVar : this.s.values()) {
            if (fVar.j()) {
                z = true;
            }
            if (fVar.f()) {
                z2 = true;
            }
        }
        int intValue = this.z.intValue();
        if (intValue != 1) {
            if (intValue == 2 && z) {
                if (this.f10332f) {
                    this.f10334h = new o3(this.f10336j, this.f10331e, this.f10337k, this.q, this.s, this.u, this.v, this.w, this.y, this, true);
                    return;
                } else {
                    this.f10334h = j3.b(this.f10336j, this, this.f10331e, this.f10337k, this.q, this.s, this.u, this.v, this.w, this.y);
                    return;
                }
            }
        } else if (!z) {
            throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
        } else {
            if (z2) {
                throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
        }
        if (this.f10332f && !z2) {
            this.f10334h = new o3(this.f10336j, this.f10331e, this.f10337k, this.q, this.s, this.u, this.v, this.w, this.y, this, false);
        } else {
            this.f10334h = new f1(this.f10336j, this, this.f10331e, this.f10337k, this.q, this.s, this.u, this.v, this.w, this.y, this);
        }
    }

    private static String W(int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? GrsBaseInfo.CountryCodeSource.UNKNOWN : "SIGN_IN_MODE_NONE" : "SIGN_IN_MODE_OPTIONAL" : "SIGN_IN_MODE_REQUIRED";
    }

    @Override // e.j.a.b.c.n.i
    public final void A(@NonNull i.b bVar) {
        this.f10333g.j(bVar);
    }

    @Override // e.j.a.b.c.n.i
    public final void B(@NonNull i.c cVar) {
        this.f10333g.k(cVar);
    }

    @Override // e.j.a.b.c.n.i
    public final <L> l<L> C(@NonNull L l2) {
        this.f10331e.lock();
        try {
            return this.x.d(l2, this.f10337k, "NO_TYPE");
        } finally {
            this.f10331e.unlock();
        }
    }

    @Override // e.j.a.b.c.n.i
    public final void D(@NonNull FragmentActivity fragmentActivity) {
        j jVar = new j((Activity) fragmentActivity);
        if (this.f10335i >= 0) {
            a3.q(jVar).r(this.f10335i);
            return;
        }
        throw new IllegalStateException("Called stopAutoManage but automatic lifecycle management is not enabled.");
    }

    @Override // e.j.a.b.c.n.i
    public final void E(@NonNull i.b bVar) {
        this.f10333g.l(bVar);
    }

    @Override // e.j.a.b.c.n.i
    public final void F(@NonNull i.c cVar) {
        this.f10333g.m(cVar);
    }

    @Override // e.j.a.b.c.n.i
    public final void G(n2 n2Var) {
        this.f10331e.lock();
        try {
            if (this.A == null) {
                this.A = new HashSet();
            }
            this.A.add(n2Var);
        } finally {
            this.f10331e.unlock();
        }
    }

    @Override // e.j.a.b.c.n.i
    public final void H(n2 n2Var) {
        this.f10331e.lock();
        try {
            Set<n2> set = this.A;
            if (set == null) {
                Log.wtf("GoogleApiClientImpl", "Attempted to remove pending transform when no transforms are registered.", new Exception());
            } else if (!set.remove(n2Var)) {
                Log.wtf("GoogleApiClientImpl", "Failed to remove pending transform - this may lead to memory leaks!", new Exception());
            } else if (!R()) {
                this.f10334h.i();
            }
        } finally {
            this.f10331e.unlock();
        }
    }

    @GuardedBy("mLock")
    public final boolean Q() {
        if (this.f10339m) {
            this.f10339m = false;
            this.p.removeMessages(2);
            this.p.removeMessages(1);
            zabq zabqVar = this.r;
            if (zabqVar != null) {
                zabqVar.a();
                this.r = null;
            }
            return true;
        }
        return false;
    }

    public final boolean R() {
        this.f10331e.lock();
        try {
            Set<n2> set = this.A;
            if (set == null) {
                this.f10331e.unlock();
                return false;
            }
            return !set.isEmpty();
        } finally {
            this.f10331e.unlock();
        }
    }

    public final String S() {
        StringWriter stringWriter = new StringWriter();
        j("", null, new PrintWriter(stringWriter), null);
        return stringWriter.toString();
    }

    @Override // e.j.a.b.c.n.u.t1
    @GuardedBy("mLock")
    public final void a(Bundle bundle) {
        while (!this.f10338l.isEmpty()) {
            m(this.f10338l.remove());
        }
        this.f10333g.h(bundle);
    }

    @Override // e.j.a.b.c.n.u.t1
    @GuardedBy("mLock")
    public final void b(ConnectionResult connectionResult) {
        if (!this.q.l(this.f10336j, connectionResult.getErrorCode())) {
            Q();
        }
        if (this.f10339m) {
            return;
        }
        this.f10333g.f(connectionResult);
        this.f10333g.b();
    }

    @Override // e.j.a.b.c.n.u.t1
    @GuardedBy("mLock")
    public final void c(int i2, boolean z) {
        if (i2 == 1 && !z && !this.f10339m) {
            this.f10339m = true;
            if (this.r == null && !e.j.a.b.c.x.e.b()) {
                this.r = this.q.E(this.f10336j.getApplicationContext(), new d1(this));
            }
            c1 c1Var = this.p;
            c1Var.sendMessageDelayed(c1Var.obtainMessage(1), this.n);
            c1 c1Var2 = this.p;
            c1Var2.sendMessageDelayed(c1Var2.obtainMessage(2), this.o);
        }
        this.B.c();
        this.f10333g.i(i2);
        this.f10333g.b();
        if (i2 == 2) {
            O();
        }
    }

    @Override // e.j.a.b.c.n.i
    public final ConnectionResult d() {
        boolean z = true;
        e.j.a.b.c.r.a0.r(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        this.f10331e.lock();
        try {
            if (this.f10335i >= 0) {
                if (this.z == null) {
                    z = false;
                }
                e.j.a.b.c.r.a0.r(z, "Sign-in mode should have been set explicitly by auto-manage.");
            } else {
                Integer num = this.z;
                if (num == null) {
                    this.z = Integer.valueOf(K(this.s.values(), false));
                } else if (num.intValue() == 2) {
                    throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
                }
            }
            V(this.z.intValue());
            this.f10333g.c();
            return this.f10334h.k();
        } finally {
            this.f10331e.unlock();
        }
    }

    @Override // e.j.a.b.c.n.i
    public final ConnectionResult e(long j2, @NonNull TimeUnit timeUnit) {
        e.j.a.b.c.r.a0.r(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        e.j.a.b.c.r.a0.l(timeUnit, "TimeUnit must not be null");
        this.f10331e.lock();
        try {
            Integer num = this.z;
            if (num == null) {
                this.z = Integer.valueOf(K(this.s.values(), false));
            } else if (num.intValue() == 2) {
                throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            V(this.z.intValue());
            this.f10333g.c();
            return this.f10334h.f(j2, timeUnit);
        } finally {
            this.f10331e.unlock();
        }
    }

    @Override // e.j.a.b.c.n.i
    public final e.j.a.b.c.n.k<Status> f() {
        e.j.a.b.c.r.a0.r(t(), "GoogleApiClient is not connected yet.");
        e.j.a.b.c.r.a0.r(this.z.intValue() != 2, "Cannot use clearDefaultAccountAndReconnect with GOOGLE_SIGN_IN_API");
        v vVar = new v(this);
        if (this.s.containsKey(e.j.a.b.c.r.j0.a.a)) {
            L(this, vVar, false);
        } else {
            AtomicReference atomicReference = new AtomicReference();
            e.j.a.b.c.n.i i2 = new i.a(this.f10336j).a(e.j.a.b.c.r.j0.a.f10422c).e(new y0(this, atomicReference, vVar)).f(new z0(this, vVar)).o(this.p).i();
            atomicReference.set(i2);
            i2.g();
        }
        return vVar;
    }

    @Override // e.j.a.b.c.n.i
    public final void g() {
        this.f10331e.lock();
        try {
            if (this.f10335i >= 0) {
                e.j.a.b.c.r.a0.r(this.z != null, "Sign-in mode should have been set explicitly by auto-manage.");
            } else {
                Integer num = this.z;
                if (num == null) {
                    this.z = Integer.valueOf(K(this.s.values(), false));
                } else if (num.intValue() == 2) {
                    throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
                }
            }
            h(this.z.intValue());
        } finally {
            this.f10331e.unlock();
        }
    }

    @Override // e.j.a.b.c.n.i
    public final Context getContext() {
        return this.f10336j;
    }

    @Override // e.j.a.b.c.n.i
    public final void h(int i2) {
        this.f10331e.lock();
        boolean z = true;
        if (i2 != 3 && i2 != 1 && i2 != 2) {
            z = false;
        }
        try {
            StringBuilder sb = new StringBuilder(33);
            sb.append("Illegal sign-in mode: ");
            sb.append(i2);
            e.j.a.b.c.r.a0.b(z, sb.toString());
            V(i2);
            O();
        } finally {
            this.f10331e.unlock();
        }
    }

    @Override // e.j.a.b.c.n.i
    public final void i() {
        this.f10331e.lock();
        try {
            this.B.a();
            s1 s1Var = this.f10334h;
            if (s1Var != null) {
                s1Var.disconnect();
            }
            this.x.c();
            for (d.a<?, ?> aVar : this.f10338l) {
                aVar.q(null);
                aVar.e();
            }
            this.f10338l.clear();
            if (this.f10334h == null) {
                return;
            }
            Q();
            this.f10333g.b();
        } finally {
            this.f10331e.unlock();
        }
    }

    @Override // e.j.a.b.c.n.i
    public final void j(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append((CharSequence) str).append("mContext=").println(this.f10336j);
        printWriter.append((CharSequence) str).append("mResuming=").print(this.f10339m);
        printWriter.append(" mWorkQueue.size()=").print(this.f10338l.size());
        printWriter.append(" mUnconsumedApiCalls.size()=").println(this.B.a.size());
        s1 s1Var = this.f10334h;
        if (s1Var != null) {
            s1Var.d(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // e.j.a.b.c.n.i
    public final <A extends a.b, R extends e.j.a.b.c.n.p, T extends d.a<R, A>> T l(@NonNull T t) {
        e.j.a.b.c.r.a0.b(t.x() != null, "This task can not be enqueued (it's probably a Batch or malformed)");
        boolean containsKey = this.s.containsKey(t.x());
        String b = t.w() != null ? t.w().b() : "the API";
        StringBuilder sb = new StringBuilder(String.valueOf(b).length() + 65);
        sb.append("GoogleApiClient is not configured to use ");
        sb.append(b);
        sb.append(" required for this call.");
        e.j.a.b.c.r.a0.b(containsKey, sb.toString());
        this.f10331e.lock();
        try {
            s1 s1Var = this.f10334h;
            if (s1Var == null) {
                this.f10338l.add(t);
                return t;
            }
            return (T) s1Var.e(t);
        } finally {
            this.f10331e.unlock();
        }
    }

    @Override // e.j.a.b.c.n.i
    public final <A extends a.b, T extends d.a<? extends e.j.a.b.c.n.p, A>> T m(@NonNull T t) {
        e.j.a.b.c.r.a0.b(t.x() != null, "This task can not be executed (it's probably a Batch or malformed)");
        boolean containsKey = this.s.containsKey(t.x());
        String b = t.w() != null ? t.w().b() : "the API";
        StringBuilder sb = new StringBuilder(String.valueOf(b).length() + 65);
        sb.append("GoogleApiClient is not configured to use ");
        sb.append(b);
        sb.append(" required for this call.");
        e.j.a.b.c.r.a0.b(containsKey, sb.toString());
        this.f10331e.lock();
        try {
            if (this.f10334h != null) {
                if (this.f10339m) {
                    this.f10338l.add(t);
                    while (!this.f10338l.isEmpty()) {
                        d.a<?, ?> remove = this.f10338l.remove();
                        this.B.b(remove);
                        remove.a(Status.RESULT_INTERNAL_ERROR);
                    }
                    return t;
                }
                return (T) this.f10334h.c(t);
            }
            throw new IllegalStateException("GoogleApiClient is not connected yet.");
        } finally {
            this.f10331e.unlock();
        }
    }

    @Override // e.j.a.b.c.n.i
    @NonNull
    public final <C extends a.f> C o(@NonNull a.c<C> cVar) {
        C c2 = (C) this.s.get(cVar);
        e.j.a.b.c.r.a0.l(c2, "Appropriate Api was not requested.");
        return c2;
    }

    @Override // e.j.a.b.c.n.i
    @NonNull
    public final ConnectionResult p(@NonNull e.j.a.b.c.n.a<?> aVar) {
        this.f10331e.lock();
        try {
            if (!t() && !this.f10339m) {
                throw new IllegalStateException("Cannot invoke getConnectionResult unless GoogleApiClient is connected");
            }
            if (this.s.containsKey(aVar.a())) {
                ConnectionResult g2 = this.f10334h.g(aVar);
                if (g2 == null) {
                    if (this.f10339m) {
                        return ConnectionResult.RESULT_SUCCESS;
                    }
                    Log.w("GoogleApiClientImpl", S());
                    Log.wtf("GoogleApiClientImpl", String.valueOf(aVar.b()).concat(" requested in getConnectionResult is not connected but is not present in the failed  connections map"), new Exception());
                    return new ConnectionResult(8, null);
                }
                return g2;
            }
            throw new IllegalArgumentException(String.valueOf(aVar.b()).concat(" was never registered with GoogleApiClient"));
        } finally {
            this.f10331e.unlock();
        }
    }

    @Override // e.j.a.b.c.n.i
    public final Looper q() {
        return this.f10337k;
    }

    @Override // e.j.a.b.c.n.i
    public final boolean r(@NonNull e.j.a.b.c.n.a<?> aVar) {
        return this.s.containsKey(aVar.a());
    }

    @Override // e.j.a.b.c.n.i
    public final boolean s(@NonNull e.j.a.b.c.n.a<?> aVar) {
        a.f fVar;
        return t() && (fVar = this.s.get(aVar.a())) != null && fVar.isConnected();
    }

    @Override // e.j.a.b.c.n.i
    public final boolean t() {
        s1 s1Var = this.f10334h;
        return s1Var != null && s1Var.isConnected();
    }

    @Override // e.j.a.b.c.n.i
    public final boolean u() {
        s1 s1Var = this.f10334h;
        return s1Var != null && s1Var.isConnecting();
    }

    @Override // e.j.a.b.c.n.i
    public final boolean v(@NonNull i.b bVar) {
        return this.f10333g.d(bVar);
    }

    @Override // e.j.a.b.c.n.i
    public final boolean w(@NonNull i.c cVar) {
        return this.f10333g.e(cVar);
    }

    @Override // e.j.a.b.c.n.i
    public final boolean x(s sVar) {
        s1 s1Var = this.f10334h;
        return s1Var != null && s1Var.h(sVar);
    }

    @Override // e.j.a.b.c.n.i
    public final void y() {
        s1 s1Var = this.f10334h;
        if (s1Var != null) {
            s1Var.j();
        }
    }

    @Override // e.j.a.b.c.n.i
    public final void z() {
        i();
        g();
    }
}
