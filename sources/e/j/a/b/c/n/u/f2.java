package e.j.a.b.c.n.u;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.BinderThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.signin.internal.zaj;
import e.j.a.b.c.n.a;
import e.j.a.b.c.n.i;
import java.util.Set;

/* loaded from: classes2.dex */
public final class f2 extends e.j.a.b.h.b.c implements i.b, i.c {

    /* renamed from: i  reason: collision with root package name */
    private static a.AbstractC0333a<? extends e.j.a.b.h.f, e.j.a.b.h.a> f10223i = e.j.a.b.h.c.f10516c;
    private final Context b;

    /* renamed from: c  reason: collision with root package name */
    private final Handler f10224c;

    /* renamed from: d  reason: collision with root package name */
    private final a.AbstractC0333a<? extends e.j.a.b.h.f, e.j.a.b.h.a> f10225d;

    /* renamed from: e  reason: collision with root package name */
    private Set<Scope> f10226e;

    /* renamed from: f  reason: collision with root package name */
    private e.j.a.b.c.r.f f10227f;

    /* renamed from: g  reason: collision with root package name */
    private e.j.a.b.h.f f10228g;

    /* renamed from: h  reason: collision with root package name */
    private i2 f10229h;

    @WorkerThread
    public f2(Context context, Handler handler, @NonNull e.j.a.b.c.r.f fVar) {
        this(context, handler, fVar, f10223i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final void h0(zaj zajVar) {
        ConnectionResult connectionResult = zajVar.getConnectionResult();
        if (connectionResult.isSuccess()) {
            ResolveAccountResponse zacx = zajVar.zacx();
            ConnectionResult connectionResult2 = zacx.getConnectionResult();
            if (!connectionResult2.isSuccess()) {
                String valueOf = String.valueOf(connectionResult2);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 48);
                sb.append("Sign-in succeeded with resolve account failure: ");
                sb.append(valueOf);
                Log.wtf("SignInCoordinator", sb.toString(), new Exception());
                this.f10229h.b(connectionResult2);
                this.f10228g.disconnect();
                return;
            }
            this.f10229h.c(zacx.getAccountAccessor(), this.f10226e);
        } else {
            this.f10229h.b(connectionResult);
        }
        this.f10228g.disconnect();
    }

    @Override // e.j.a.b.c.n.i.b
    @WorkerThread
    public final void a(@Nullable Bundle bundle) {
        this.f10228g.t(this);
    }

    @Override // e.j.a.b.c.n.i.c
    @WorkerThread
    public final void c(@NonNull ConnectionResult connectionResult) {
        this.f10229h.b(connectionResult);
    }

    @Override // e.j.a.b.h.b.c, e.j.a.b.h.b.d
    @BinderThread
    public final void e(zaj zajVar) {
        this.f10224c.post(new h2(this, zajVar));
    }

    @WorkerThread
    public final void e0(i2 i2Var) {
        e.j.a.b.h.f fVar = this.f10228g;
        if (fVar != null) {
            fVar.disconnect();
        }
        this.f10227f.p(Integer.valueOf(System.identityHashCode(this)));
        a.AbstractC0333a<? extends e.j.a.b.h.f, e.j.a.b.h.a> abstractC0333a = this.f10225d;
        Context context = this.b;
        Looper looper = this.f10224c.getLooper();
        e.j.a.b.c.r.f fVar2 = this.f10227f;
        this.f10228g = abstractC0333a.c(context, looper, fVar2, fVar2.m(), this, this);
        this.f10229h = i2Var;
        Set<Scope> set = this.f10226e;
        if (set != null && !set.isEmpty()) {
            this.f10228g.connect();
        } else {
            this.f10224c.post(new g2(this));
        }
    }

    public final e.j.a.b.h.f f0() {
        return this.f10228g;
    }

    public final void g0() {
        e.j.a.b.h.f fVar = this.f10228g;
        if (fVar != null) {
            fVar.disconnect();
        }
    }

    @Override // e.j.a.b.c.n.i.b
    @WorkerThread
    public final void onConnectionSuspended(int i2) {
        this.f10228g.disconnect();
    }

    @WorkerThread
    public f2(Context context, Handler handler, @NonNull e.j.a.b.c.r.f fVar, a.AbstractC0333a<? extends e.j.a.b.h.f, e.j.a.b.h.a> abstractC0333a) {
        this.b = context;
        this.f10224c = handler;
        this.f10227f = (e.j.a.b.c.r.f) e.j.a.b.c.r.a0.l(fVar, "ClientSettings must not be null");
        this.f10226e = fVar.l();
        this.f10225d = abstractC0333a;
    }
}
