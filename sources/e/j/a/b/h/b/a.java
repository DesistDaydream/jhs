package e.j.a.b.h.b;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.signin.internal.zah;
import com.google.android.gms.signin.internal.zaj;
import e.j.a.b.c.n.i;
import e.j.a.b.c.r.a0;
import e.j.a.b.c.r.e;
import e.j.a.b.c.r.k;
import e.j.a.b.c.r.q;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public class a extends k<f> implements e.j.a.b.h.f {
    private final boolean L;
    private final e.j.a.b.c.r.f M;
    private final Bundle N;
    private Integer O;

    private a(Context context, Looper looper, boolean z, e.j.a.b.c.r.f fVar, Bundle bundle, i.b bVar, i.c cVar) {
        super(context, looper, 44, fVar, bVar, cVar);
        this.L = true;
        this.M = fVar;
        this.N = bundle;
        this.O = fVar.g();
    }

    @e.j.a.b.c.m.a
    public static Bundle o0(e.j.a.b.c.r.f fVar) {
        e.j.a.b.h.a m2 = fVar.m();
        Integer g2 = fVar.g();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", fVar.b());
        if (g2 != null) {
            bundle.putInt(e.j.a.b.c.r.f.f10398l, g2.intValue());
        }
        if (m2 != null) {
            bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", m2.g());
            bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", m2.f());
            bundle.putString("com.google.android.gms.signin.internal.serverClientId", m2.d());
            bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
            bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", m2.e());
            bundle.putString("com.google.android.gms.signin.internal.hostedDomain", m2.b());
            bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", m2.h());
            if (m2.a() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.authApiSignInModuleVersion", m2.a().longValue());
            }
            if (m2.c() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.realClientLibraryVersion", m2.c().longValue());
            }
        }
        return bundle;
    }

    @Override // e.j.a.b.c.r.e
    public Bundle B() {
        if (!getContext().getPackageName().equals(this.M.k())) {
            this.N.putString("com.google.android.gms.signin.internal.realClientPackageName", this.M.k());
        }
        return this.N;
    }

    @Override // e.j.a.b.h.f
    public final void b(q qVar, boolean z) {
        try {
            ((f) F()).E(qVar, this.O.intValue(), z);
        } catch (RemoteException unused) {
            Log.w("SignInClientImpl", "Remote service probably died when saveDefaultAccount is called");
        }
    }

    @Override // e.j.a.b.c.r.e
    public String c() {
        return "com.google.android.gms.signin.service.START";
    }

    @Override // e.j.a.b.h.f
    public final void connect() {
        h(new e.d());
    }

    @Override // e.j.a.b.c.r.e, e.j.a.b.c.n.a.f
    public boolean j() {
        return this.L;
    }

    @Override // e.j.a.b.h.f
    public final void n() {
        try {
            ((f) F()).t(this.O.intValue());
        } catch (RemoteException unused) {
            Log.w("SignInClientImpl", "Remote service probably died when clearAccountFromSessionStore is called");
        }
    }

    @Override // e.j.a.b.c.r.e
    public String q() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    @Override // e.j.a.b.c.r.e
    public /* synthetic */ IInterface r(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        if (queryLocalInterface instanceof f) {
            return (f) queryLocalInterface;
        }
        return new g(iBinder);
    }

    @Override // e.j.a.b.c.r.k, e.j.a.b.c.r.e, e.j.a.b.c.n.a.f
    public int s() {
        return e.j.a.b.c.h.a;
    }

    @Override // e.j.a.b.h.f
    public final void t(d dVar) {
        a0.l(dVar, "Expecting a valid ISignInCallbacks");
        try {
            Account d2 = this.M.d();
            ((f) F()).R(new zah(new ResolveAccountRequest(d2, this.O.intValue(), "<<default account>>".equals(d2.name) ? e.j.a.b.b.a.a.b.b.b(getContext()).c() : null)), dVar);
        } catch (RemoteException e2) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                dVar.e(new zaj(8));
            } catch (RemoteException unused) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e2);
            }
        }
    }

    public a(Context context, Looper looper, boolean z, e.j.a.b.c.r.f fVar, e.j.a.b.h.a aVar, i.b bVar, i.c cVar) {
        this(context, looper, true, fVar, o0(fVar), bVar, cVar);
    }
}
