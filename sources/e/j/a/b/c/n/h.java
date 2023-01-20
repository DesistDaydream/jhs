package e.j.a.b.c.n;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.Scope;
import e.j.a.b.c.n.a;
import e.j.a.b.c.n.a.d;
import e.j.a.b.c.n.u.d;
import e.j.a.b.c.n.u.e0;
import e.j.a.b.c.n.u.f2;
import e.j.a.b.c.n.u.g;
import e.j.a.b.c.n.u.l;
import e.j.a.b.c.n.u.q1;
import e.j.a.b.c.n.u.u;
import e.j.a.b.c.n.u.z2;
import e.j.a.b.c.r.a0;
import e.j.a.b.c.r.f;
import java.util.Collections;
import java.util.Set;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public class h<O extends a.d> {
    private final Context a;
    private final e.j.a.b.c.n.a<O> b;

    /* renamed from: c  reason: collision with root package name */
    private final O f10174c;

    /* renamed from: d  reason: collision with root package name */
    private final z2<O> f10175d;

    /* renamed from: e  reason: collision with root package name */
    private final Looper f10176e;

    /* renamed from: f  reason: collision with root package name */
    private final int f10177f;

    /* renamed from: g  reason: collision with root package name */
    private final i f10178g;

    /* renamed from: h  reason: collision with root package name */
    private final u f10179h;

    /* renamed from: i  reason: collision with root package name */
    public final e.j.a.b.c.n.u.g f10180i;

    @e.j.a.b.c.m.a
    /* loaded from: classes2.dex */
    public static class a {
        @e.j.a.b.c.m.a

        /* renamed from: c  reason: collision with root package name */
        public static final a f10181c = new C0336a().a();
        public final u a;
        public final Looper b;

        @e.j.a.b.c.m.a
        /* renamed from: e.j.a.b.c.n.h$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0336a {
            private u a;
            private Looper b;

            @e.j.a.b.c.m.a
            public a a() {
                if (this.a == null) {
                    this.a = new e.j.a.b.c.n.u.b();
                }
                if (this.b == null) {
                    this.b = Looper.getMainLooper();
                }
                return new a(this.a, this.b);
            }

            @e.j.a.b.c.m.a
            public C0336a b(Looper looper) {
                a0.l(looper, "Looper must not be null.");
                this.b = looper;
                return this;
            }

            @e.j.a.b.c.m.a
            public C0336a c(u uVar) {
                a0.l(uVar, "StatusExceptionMapper must not be null.");
                this.a = uVar;
                return this;
            }
        }

        @e.j.a.b.c.m.a
        private a(u uVar, Account account, Looper looper) {
            this.a = uVar;
            this.b = looper;
        }
    }

    @e.j.a.b.c.m.a
    public h(@NonNull Context context, e.j.a.b.c.n.a<O> aVar, Looper looper) {
        a0.l(context, "Null context is not permitted.");
        a0.l(aVar, "Api must not be null.");
        a0.l(looper, "Looper must not be null.");
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        this.b = aVar;
        this.f10174c = null;
        this.f10176e = looper;
        this.f10175d = z2.a(aVar);
        this.f10178g = new q1(this);
        e.j.a.b.c.n.u.g n = e.j.a.b.c.n.u.g.n(applicationContext);
        this.f10180i = n;
        this.f10177f = n.r();
        this.f10179h = new e.j.a.b.c.n.u.b();
    }

    private final <A extends a.b, T extends d.a<? extends p, A>> T t(int i2, @NonNull T t) {
        t.u();
        this.f10180i.j(this, i2, t);
        return t;
    }

    private final <TResult, A extends a.b> e.j.a.b.j.k<TResult> v(int i2, @NonNull e.j.a.b.c.n.u.w<A, TResult> wVar) {
        e.j.a.b.j.l lVar = new e.j.a.b.j.l();
        this.f10180i.k(this, i2, wVar, lVar, this.f10179h);
        return lVar.a();
    }

    @e.j.a.b.c.m.a
    public i a() {
        return this.f10178g;
    }

    @e.j.a.b.c.m.a
    public f.a b() {
        Account account;
        Set<Scope> emptySet;
        GoogleSignInAccount j2;
        GoogleSignInAccount j3;
        f.a aVar = new f.a();
        O o = this.f10174c;
        if ((o instanceof a.d.b) && (j3 = ((a.d.b) o).j()) != null) {
            account = j3.getAccount();
        } else {
            O o2 = this.f10174c;
            account = o2 instanceof a.d.InterfaceC0334a ? ((a.d.InterfaceC0334a) o2).getAccount() : null;
        }
        f.a e2 = aVar.e(account);
        O o3 = this.f10174c;
        if ((o3 instanceof a.d.b) && (j2 = ((a.d.b) o3).j()) != null) {
            emptySet = j2.getRequestedScopes();
        } else {
            emptySet = Collections.emptySet();
        }
        return e2.a(emptySet).h(this.a.getClass().getName()).i(this.a.getPackageName());
    }

    @e.j.a.b.c.m.a
    public e.j.a.b.j.k<Boolean> c() {
        return this.f10180i.v(this);
    }

    @e.j.a.b.c.m.a
    public <A extends a.b, T extends d.a<? extends p, A>> T d(@NonNull T t) {
        return (T) t(2, t);
    }

    @e.j.a.b.c.m.a
    public <TResult, A extends a.b> e.j.a.b.j.k<TResult> e(e.j.a.b.c.n.u.w<A, TResult> wVar) {
        return v(2, wVar);
    }

    @e.j.a.b.c.m.a
    public <A extends a.b, T extends d.a<? extends p, A>> T f(@NonNull T t) {
        return (T) t(0, t);
    }

    @e.j.a.b.c.m.a
    public <TResult, A extends a.b> e.j.a.b.j.k<TResult> g(e.j.a.b.c.n.u.w<A, TResult> wVar) {
        return v(0, wVar);
    }

    @e.j.a.b.c.m.a
    @Deprecated
    public <A extends a.b, T extends e.j.a.b.c.n.u.p<A, ?>, U extends e.j.a.b.c.n.u.y<A, ?>> e.j.a.b.j.k<Void> h(@NonNull T t, U u) {
        a0.k(t);
        a0.k(u);
        a0.l(t.b(), "Listener has already been released.");
        a0.l(u.a(), "Listener has already been released.");
        a0.b(t.b().equals(u.a()), "Listener registration and unregistration methods must be constructed with the same ListenerHolder.");
        return this.f10180i.f(this, t, u);
    }

    @e.j.a.b.c.m.a
    public <A extends a.b> e.j.a.b.j.k<Void> i(@NonNull e.j.a.b.c.n.u.q<A, ?> qVar) {
        a0.k(qVar);
        a0.l(qVar.a.b(), "Listener has already been released.");
        a0.l(qVar.b.a(), "Listener has already been released.");
        return this.f10180i.f(this, qVar.a, qVar.b);
    }

    @e.j.a.b.c.m.a
    public e.j.a.b.j.k<Boolean> j(@NonNull l.a<?> aVar) {
        a0.l(aVar, "Listener key cannot be null.");
        return this.f10180i.e(this, aVar);
    }

    @e.j.a.b.c.m.a
    public <A extends a.b, T extends d.a<? extends p, A>> T k(@NonNull T t) {
        return (T) t(1, t);
    }

    @e.j.a.b.c.m.a
    public <TResult, A extends a.b> e.j.a.b.j.k<TResult> l(e.j.a.b.c.n.u.w<A, TResult> wVar) {
        return v(1, wVar);
    }

    public final e.j.a.b.c.n.a<O> m() {
        return this.b;
    }

    @e.j.a.b.c.m.a
    public O n() {
        return this.f10174c;
    }

    @e.j.a.b.c.m.a
    public Context o() {
        return this.a;
    }

    public final int p() {
        return this.f10177f;
    }

    @e.j.a.b.c.m.a
    public Looper q() {
        return this.f10176e;
    }

    @e.j.a.b.c.m.a
    public <L> e.j.a.b.c.n.u.l<L> r(@NonNull L l2, String str) {
        return e.j.a.b.c.n.u.m.a(l2, this.f10176e, str);
    }

    /* JADX WARN: Type inference failed for: r9v1, types: [e.j.a.b.c.n.a$f] */
    @WorkerThread
    public a.f s(Looper looper, g.a<O> aVar) {
        return this.b.d().c(this.a, looper, b().c(), this.f10174c, aVar, aVar);
    }

    public f2 u(Context context, Handler handler) {
        return new f2(context, handler, b().c());
    }

    public final z2<O> w() {
        return this.f10175d;
    }

    @e.j.a.b.c.m.a
    @Deprecated
    public h(@NonNull Context context, e.j.a.b.c.n.a<O> aVar, @Nullable O o, Looper looper, u uVar) {
        this(context, aVar, o, new a.C0336a().b(looper).c(uVar).a());
    }

    @e.j.a.b.c.m.a
    @MainThread
    public h(@NonNull Activity activity, e.j.a.b.c.n.a<O> aVar, @Nullable O o, a aVar2) {
        a0.l(activity, "Null activity is not permitted.");
        a0.l(aVar, "Api must not be null.");
        a0.l(aVar2, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        Context applicationContext = activity.getApplicationContext();
        this.a = applicationContext;
        this.b = aVar;
        this.f10174c = o;
        this.f10176e = aVar2.b;
        z2<O> b = z2.b(aVar, o);
        this.f10175d = b;
        this.f10178g = new q1(this);
        e.j.a.b.c.n.u.g n = e.j.a.b.c.n.u.g.n(applicationContext);
        this.f10180i = n;
        this.f10177f = n.r();
        this.f10179h = aVar2.a;
        if (!(activity instanceof GoogleApiActivity)) {
            e0.q(activity, n, b);
        }
        n.i(this);
    }

    @e.j.a.b.c.m.a
    public h(@NonNull Context context, e.j.a.b.c.n.a<O> aVar, @Nullable O o, a aVar2) {
        a0.l(context, "Null context is not permitted.");
        a0.l(aVar, "Api must not be null.");
        a0.l(aVar2, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        this.b = aVar;
        this.f10174c = o;
        this.f10176e = aVar2.b;
        this.f10175d = z2.b(aVar, o);
        this.f10178g = new q1(this);
        e.j.a.b.c.n.u.g n = e.j.a.b.c.n.u.g.n(applicationContext);
        this.f10180i = n;
        this.f10177f = n.r();
        this.f10179h = aVar2.a;
        n.i(this);
    }

    @e.j.a.b.c.m.a
    @Deprecated
    public h(@NonNull Activity activity, e.j.a.b.c.n.a<O> aVar, @Nullable O o, u uVar) {
        this(activity, (e.j.a.b.c.n.a) aVar, (a.d) o, new a.C0336a().c(uVar).b(activity.getMainLooper()).a());
    }

    @e.j.a.b.c.m.a
    @Deprecated
    public h(@NonNull Context context, e.j.a.b.c.n.a<O> aVar, @Nullable O o, u uVar) {
        this(context, aVar, o, new a.C0336a().c(uVar).a());
    }
}
