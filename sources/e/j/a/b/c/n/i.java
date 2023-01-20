package e.j.a.b.c.n;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import e.j.a.b.c.n.a;
import e.j.a.b.c.n.u.a3;
import e.j.a.b.c.n.u.d;
import e.j.a.b.c.n.u.h3;
import e.j.a.b.c.n.u.n2;
import e.j.a.b.c.n.u.w0;
import e.j.a.b.c.r.a0;
import e.j.a.b.c.r.f;
import e.j.a.b.c.x.d0;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.concurrent.GuardedBy;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public abstract class i {
    @e.j.a.b.c.m.a
    public static final String a = "<<default account>>";
    @GuardedBy("sAllClients")
    private static final Set<i> b = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: c */
    public static final int f10182c = 1;

    /* renamed from: d */
    public static final int f10183d = 2;

    /* loaded from: classes2.dex */
    public interface b {
        public static final int p0 = 1;
        public static final int q0 = 2;

        void a(@Nullable Bundle bundle);

        void onConnectionSuspended(int i2);
    }

    /* loaded from: classes2.dex */
    public interface c {
        void c(@NonNull ConnectionResult connectionResult);
    }

    public static void k(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        Set<i> set = b;
        synchronized (set) {
            int i2 = 0;
            String concat = String.valueOf(str).concat("  ");
            for (i iVar : set) {
                printWriter.append((CharSequence) str).append("GoogleApiClient#").println(i2);
                iVar.j(concat, fileDescriptor, printWriter, strArr);
                i2++;
            }
        }
    }

    @e.j.a.b.c.m.a
    public static Set<i> n() {
        Set<i> set = b;
        synchronized (set) {
        }
        return set;
    }

    public abstract void A(@NonNull b bVar);

    public abstract void B(@NonNull c cVar);

    @e.j.a.b.c.m.a
    public <L> e.j.a.b.c.n.u.l<L> C(@NonNull L l2) {
        throw new UnsupportedOperationException();
    }

    public abstract void D(@NonNull FragmentActivity fragmentActivity);

    public abstract void E(@NonNull b bVar);

    public abstract void F(@NonNull c cVar);

    public void G(n2 n2Var) {
        throw new UnsupportedOperationException();
    }

    public void H(n2 n2Var) {
        throw new UnsupportedOperationException();
    }

    public abstract ConnectionResult d();

    public abstract ConnectionResult e(long j2, @NonNull TimeUnit timeUnit);

    public abstract k<Status> f();

    public abstract void g();

    @e.j.a.b.c.m.a
    public Context getContext() {
        throw new UnsupportedOperationException();
    }

    public void h(int i2) {
        throw new UnsupportedOperationException();
    }

    public abstract void i();

    public abstract void j(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    @e.j.a.b.c.m.a
    public <A extends a.b, R extends p, T extends d.a<R, A>> T l(@NonNull T t) {
        throw new UnsupportedOperationException();
    }

    @e.j.a.b.c.m.a
    public <A extends a.b, T extends d.a<? extends p, A>> T m(@NonNull T t) {
        throw new UnsupportedOperationException();
    }

    @NonNull
    @e.j.a.b.c.m.a
    public <C extends a.f> C o(@NonNull a.c<C> cVar) {
        throw new UnsupportedOperationException();
    }

    @NonNull
    public abstract ConnectionResult p(@NonNull e.j.a.b.c.n.a<?> aVar);

    @e.j.a.b.c.m.a
    public Looper q() {
        throw new UnsupportedOperationException();
    }

    @e.j.a.b.c.m.a
    public boolean r(@NonNull e.j.a.b.c.n.a<?> aVar) {
        throw new UnsupportedOperationException();
    }

    public abstract boolean s(@NonNull e.j.a.b.c.n.a<?> aVar);

    public abstract boolean t();

    public abstract boolean u();

    public abstract boolean v(@NonNull b bVar);

    public abstract boolean w(@NonNull c cVar);

    @e.j.a.b.c.m.a
    public boolean x(e.j.a.b.c.n.u.s sVar) {
        throw new UnsupportedOperationException();
    }

    @e.j.a.b.c.m.a
    public void y() {
        throw new UnsupportedOperationException();
    }

    public abstract void z();

    @e.j.a.b.c.m.a
    /* loaded from: classes2.dex */
    public static final class a {
        private Account a;
        private final Set<Scope> b;

        /* renamed from: c */
        private final Set<Scope> f10184c;

        /* renamed from: d */
        private int f10185d;

        /* renamed from: e */
        private View f10186e;

        /* renamed from: f */
        private String f10187f;

        /* renamed from: g */
        private String f10188g;

        /* renamed from: h */
        private final Map<e.j.a.b.c.n.a<?>, f.b> f10189h;

        /* renamed from: i */
        private boolean f10190i;

        /* renamed from: j */
        private final Context f10191j;

        /* renamed from: k */
        private final Map<e.j.a.b.c.n.a<?>, a.d> f10192k;

        /* renamed from: l */
        private e.j.a.b.c.n.u.j f10193l;

        /* renamed from: m */
        private int f10194m;
        private c n;
        private Looper o;
        private e.j.a.b.c.e p;
        private a.AbstractC0333a<? extends e.j.a.b.h.f, e.j.a.b.h.a> q;
        private final ArrayList<b> r;
        private final ArrayList<c> s;
        private boolean t;

        @e.j.a.b.c.m.a
        public a(@NonNull Context context) {
            this.b = new HashSet();
            this.f10184c = new HashSet();
            this.f10189h = new ArrayMap();
            this.f10190i = false;
            this.f10192k = new ArrayMap();
            this.f10194m = -1;
            this.p = e.j.a.b.c.e.v();
            this.q = e.j.a.b.h.c.f10516c;
            this.r = new ArrayList<>();
            this.s = new ArrayList<>();
            this.t = false;
            this.f10191j = context;
            this.o = context.getMainLooper();
            this.f10187f = context.getPackageName();
            this.f10188g = context.getClass().getName();
        }

        private final <O extends a.d> void r(e.j.a.b.c.n.a<O> aVar, O o, Scope... scopeArr) {
            HashSet hashSet = new HashSet(aVar.c().a(o));
            for (Scope scope : scopeArr) {
                hashSet.add(scope);
            }
            this.f10189h.put(aVar, new f.b(hashSet));
        }

        public final a a(@NonNull e.j.a.b.c.n.a<? extends a.d.e> aVar) {
            a0.l(aVar, "Api must not be null");
            this.f10192k.put(aVar, null);
            List<Scope> a = aVar.c().a(null);
            this.f10184c.addAll(a);
            this.b.addAll(a);
            return this;
        }

        public final <O extends a.d.c> a b(@NonNull e.j.a.b.c.n.a<O> aVar, @NonNull O o) {
            a0.l(aVar, "Api must not be null");
            a0.l(o, "Null options are not permitted for this Api");
            this.f10192k.put(aVar, o);
            List<Scope> a = aVar.c().a(o);
            this.f10184c.addAll(a);
            this.b.addAll(a);
            return this;
        }

        public final <O extends a.d.c> a c(@NonNull e.j.a.b.c.n.a<O> aVar, @NonNull O o, Scope... scopeArr) {
            a0.l(aVar, "Api must not be null");
            a0.l(o, "Null options are not permitted for this Api");
            this.f10192k.put(aVar, o);
            r(aVar, o, scopeArr);
            return this;
        }

        public final a d(@NonNull e.j.a.b.c.n.a<? extends a.d.e> aVar, Scope... scopeArr) {
            a0.l(aVar, "Api must not be null");
            this.f10192k.put(aVar, null);
            r(aVar, null, scopeArr);
            return this;
        }

        public final a e(@NonNull b bVar) {
            a0.l(bVar, "Listener must not be null");
            this.r.add(bVar);
            return this;
        }

        public final a f(@NonNull c cVar) {
            a0.l(cVar, "Listener must not be null");
            this.s.add(cVar);
            return this;
        }

        public final a g(@NonNull Scope scope) {
            a0.l(scope, "Scope must not be null");
            this.b.add(scope);
            return this;
        }

        @e.j.a.b.c.m.a
        public final a h(String[] strArr) {
            for (String str : strArr) {
                this.b.add(new Scope(str));
            }
            return this;
        }

        /* JADX WARN: Type inference failed for: r4v18, types: [e.j.a.b.c.n.a$f, java.lang.Object] */
        public final i i() {
            a0.b(!this.f10192k.isEmpty(), "must call addApi() to add at least one API");
            e.j.a.b.c.r.f j2 = j();
            e.j.a.b.c.n.a<?> aVar = null;
            Map<e.j.a.b.c.n.a<?>, f.b> i2 = j2.i();
            ArrayMap arrayMap = new ArrayMap();
            ArrayMap arrayMap2 = new ArrayMap();
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            for (e.j.a.b.c.n.a<?> aVar2 : this.f10192k.keySet()) {
                a.d dVar = this.f10192k.get(aVar2);
                boolean z2 = i2.get(aVar2) != null;
                arrayMap.put(aVar2, Boolean.valueOf(z2));
                h3 h3Var = new h3(aVar2, z2);
                arrayList.add(h3Var);
                a.AbstractC0333a<?, ?> d2 = aVar2.d();
                ?? c2 = d2.c(this.f10191j, this.o, j2, dVar, h3Var, h3Var);
                arrayMap2.put(aVar2.a(), c2);
                if (d2.b() == 1) {
                    z = dVar != null;
                }
                if (c2.f()) {
                    if (aVar != null) {
                        String b = aVar2.b();
                        String b2 = aVar.b();
                        StringBuilder sb = new StringBuilder(String.valueOf(b).length() + 21 + String.valueOf(b2).length());
                        sb.append(b);
                        sb.append(" cannot be used with ");
                        sb.append(b2);
                        throw new IllegalStateException(sb.toString());
                    }
                    aVar = aVar2;
                }
            }
            if (aVar != null) {
                if (!z) {
                    a0.s(this.a == null, "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead", aVar.b());
                    a0.s(this.b.equals(this.f10184c), "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.", aVar.b());
                } else {
                    String b3 = aVar.b();
                    StringBuilder sb2 = new StringBuilder(String.valueOf(b3).length() + 82);
                    sb2.append("With using ");
                    sb2.append(b3);
                    sb2.append(", GamesOptions can only be specified within GoogleSignInOptions.Builder");
                    throw new IllegalStateException(sb2.toString());
                }
            }
            w0 w0Var = new w0(this.f10191j, new ReentrantLock(), this.o, j2, this.p, this.q, arrayMap, this.r, this.s, arrayMap2, this.f10194m, w0.K(arrayMap2.values(), true), arrayList, false);
            synchronized (i.b) {
                i.b.add(w0Var);
            }
            if (this.f10194m >= 0) {
                a3.q(this.f10193l).s(this.f10194m, w0Var, this.n);
            }
            return w0Var;
        }

        @e.j.a.b.c.m.a
        @d0
        public final e.j.a.b.c.r.f j() {
            e.j.a.b.h.a aVar = e.j.a.b.h.a.f10509i;
            Map<e.j.a.b.c.n.a<?>, a.d> map = this.f10192k;
            e.j.a.b.c.n.a<e.j.a.b.h.a> aVar2 = e.j.a.b.h.c.f10520g;
            if (map.containsKey(aVar2)) {
                aVar = (e.j.a.b.h.a) this.f10192k.get(aVar2);
            }
            return new e.j.a.b.c.r.f(this.a, this.b, this.f10189h, this.f10185d, this.f10186e, this.f10187f, this.f10188g, aVar, false);
        }

        public final a k(@NonNull FragmentActivity fragmentActivity, int i2, @Nullable c cVar) {
            e.j.a.b.c.n.u.j jVar = new e.j.a.b.c.n.u.j((Activity) fragmentActivity);
            a0.b(i2 >= 0, "clientId must be non-negative");
            this.f10194m = i2;
            this.n = cVar;
            this.f10193l = jVar;
            return this;
        }

        public final a l(@NonNull FragmentActivity fragmentActivity, @Nullable c cVar) {
            return k(fragmentActivity, 0, cVar);
        }

        public final a m(String str) {
            this.a = str == null ? null : new Account(str, e.j.a.b.c.r.b.a);
            return this;
        }

        public final a n(int i2) {
            this.f10185d = i2;
            return this;
        }

        public final a o(@NonNull Handler handler) {
            a0.l(handler, "Handler must not be null");
            this.o = handler.getLooper();
            return this;
        }

        public final a p(@NonNull View view) {
            a0.l(view, "View must not be null");
            this.f10186e = view;
            return this;
        }

        public final a q() {
            return m("<<default account>>");
        }

        @e.j.a.b.c.m.a
        public a(@NonNull Context context, @NonNull b bVar, @NonNull c cVar) {
            this(context);
            a0.l(bVar, "Must provide a connected listener");
            this.r.add(bVar);
            a0.l(cVar, "Must provide a connection failed listener");
            this.s.add(cVar);
        }
    }
}
