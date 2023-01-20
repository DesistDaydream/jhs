package e.b.a;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import com.bumptech.glide.Priority;
import e.b.a.q.c;
import e.b.a.q.l;
import e.b.a.q.m;
import e.b.a.q.q;
import e.b.a.q.r;
import e.b.a.q.t;
import e.b.a.t.k.p;
import e.b.a.v.n;
import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class j implements ComponentCallbacks2, m, h<i<Drawable>> {

    /* renamed from: l  reason: collision with root package name */
    private static final e.b.a.t.h f9353l = e.b.a.t.h.Y0(Bitmap.class).m0();

    /* renamed from: m  reason: collision with root package name */
    private static final e.b.a.t.h f9354m = e.b.a.t.h.Y0(e.b.a.p.m.h.c.class).m0();
    private static final e.b.a.t.h n = e.b.a.t.h.Z0(e.b.a.p.k.h.f9533c).A0(Priority.LOW).I0(true);
    public final e.b.a.c a;
    public final Context b;

    /* renamed from: c  reason: collision with root package name */
    public final l f9355c;
    @GuardedBy("this")

    /* renamed from: d  reason: collision with root package name */
    private final r f9356d;
    @GuardedBy("this")

    /* renamed from: e  reason: collision with root package name */
    private final q f9357e;
    @GuardedBy("this")

    /* renamed from: f  reason: collision with root package name */
    private final t f9358f;

    /* renamed from: g  reason: collision with root package name */
    private final Runnable f9359g;

    /* renamed from: h  reason: collision with root package name */
    private final e.b.a.q.c f9360h;

    /* renamed from: i  reason: collision with root package name */
    private final CopyOnWriteArrayList<e.b.a.t.g<Object>> f9361i;
    @GuardedBy("this")

    /* renamed from: j  reason: collision with root package name */
    private e.b.a.t.h f9362j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f9363k;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j jVar = j.this;
            jVar.f9355c.b(jVar);
        }
    }

    /* loaded from: classes.dex */
    public static class b extends e.b.a.t.k.f<View, Object> {
        public b(@NonNull View view) {
            super(view);
        }

        @Override // e.b.a.t.k.f
        public void f(@Nullable Drawable drawable) {
        }

        @Override // e.b.a.t.k.p
        public void onLoadFailed(@Nullable Drawable drawable) {
        }

        @Override // e.b.a.t.k.p
        public void onResourceReady(@NonNull Object obj, @Nullable e.b.a.t.l.f<? super Object> fVar) {
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.a {
        @GuardedBy("RequestManager.this")
        private final r a;

        public c(@NonNull r rVar) {
            this.a = rVar;
        }

        @Override // e.b.a.q.c.a
        public void a(boolean z) {
            if (z) {
                synchronized (j.this) {
                    this.a.g();
                }
            }
        }
    }

    public j(@NonNull e.b.a.c cVar, @NonNull l lVar, @NonNull q qVar, @NonNull Context context) {
        this(cVar, lVar, qVar, new r(), cVar.i(), context);
    }

    private void S(@NonNull p<?> pVar) {
        boolean R = R(pVar);
        e.b.a.t.e request = pVar.getRequest();
        if (R || this.a.v(pVar) || request == null) {
            return;
        }
        pVar.setRequest(null);
        request.clear();
    }

    private synchronized void T(@NonNull e.b.a.t.h hVar) {
        this.f9362j = this.f9362j.l(hVar);
    }

    @Override // e.b.a.h
    @NonNull
    @CheckResult
    /* renamed from: A */
    public i<Drawable> b(@Nullable Uri uri) {
        return n().b(uri);
    }

    @Override // e.b.a.h
    @NonNull
    @CheckResult
    /* renamed from: B */
    public i<Drawable> e(@Nullable File file) {
        return n().e(file);
    }

    @Override // e.b.a.h
    @NonNull
    @CheckResult
    /* renamed from: C */
    public i<Drawable> j(@Nullable @DrawableRes @RawRes Integer num) {
        return n().j(num);
    }

    @Override // e.b.a.h
    @NonNull
    @CheckResult
    /* renamed from: D */
    public i<Drawable> h(@Nullable Object obj) {
        return n().h(obj);
    }

    @Override // e.b.a.h
    @NonNull
    @CheckResult
    /* renamed from: E */
    public i<Drawable> k(@Nullable String str) {
        return n().k(str);
    }

    @Override // e.b.a.h
    @CheckResult
    @Deprecated
    /* renamed from: F */
    public i<Drawable> a(@Nullable URL url) {
        return n().a(url);
    }

    @Override // e.b.a.h
    @NonNull
    @CheckResult
    /* renamed from: G */
    public i<Drawable> c(@Nullable byte[] bArr) {
        return n().c(bArr);
    }

    public synchronized void H() {
        this.f9356d.e();
    }

    public synchronized void I() {
        H();
        for (j jVar : this.f9357e.a()) {
            jVar.H();
        }
    }

    public synchronized void J() {
        this.f9356d.f();
    }

    public synchronized void K() {
        J();
        for (j jVar : this.f9357e.a()) {
            jVar.J();
        }
    }

    public synchronized void L() {
        this.f9356d.h();
    }

    public synchronized void M() {
        n.b();
        L();
        for (j jVar : this.f9357e.a()) {
            jVar.L();
        }
    }

    @NonNull
    public synchronized j N(@NonNull e.b.a.t.h hVar) {
        P(hVar);
        return this;
    }

    public void O(boolean z) {
        this.f9363k = z;
    }

    public synchronized void P(@NonNull e.b.a.t.h hVar) {
        this.f9362j = hVar.clone().m();
    }

    public synchronized void Q(@NonNull p<?> pVar, @NonNull e.b.a.t.e eVar) {
        this.f9358f.c(pVar);
        this.f9356d.i(eVar);
    }

    public synchronized boolean R(@NonNull p<?> pVar) {
        e.b.a.t.e request = pVar.getRequest();
        if (request == null) {
            return true;
        }
        if (this.f9356d.b(request)) {
            this.f9358f.d(pVar);
            pVar.setRequest(null);
            return true;
        }
        return false;
    }

    public j d(e.b.a.t.g<Object> gVar) {
        this.f9361i.add(gVar);
        return this;
    }

    @NonNull
    public synchronized j i(@NonNull e.b.a.t.h hVar) {
        T(hVar);
        return this;
    }

    @NonNull
    @CheckResult
    public <ResourceType> i<ResourceType> l(@NonNull Class<ResourceType> cls) {
        return new i<>(this.a, this, cls, this.b);
    }

    @NonNull
    @CheckResult
    public i<Bitmap> m() {
        return l(Bitmap.class).l(f9353l);
    }

    @NonNull
    @CheckResult
    public i<Drawable> n() {
        return l(Drawable.class);
    }

    @NonNull
    @CheckResult
    public i<File> o() {
        return l(File.class).l(e.b.a.t.h.s1(true));
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // e.b.a.q.m
    public synchronized void onDestroy() {
        this.f9358f.onDestroy();
        for (p<?> pVar : this.f9358f.b()) {
            r(pVar);
        }
        this.f9358f.a();
        this.f9356d.c();
        this.f9355c.a(this);
        this.f9355c.a(this.f9360h);
        n.y(this.f9359g);
        this.a.A(this);
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    @Override // e.b.a.q.m
    public synchronized void onStart() {
        L();
        this.f9358f.onStart();
    }

    @Override // e.b.a.q.m
    public synchronized void onStop() {
        J();
        this.f9358f.onStop();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i2) {
        if (i2 == 60 && this.f9363k) {
            I();
        }
    }

    @NonNull
    @CheckResult
    public i<e.b.a.p.m.h.c> p() {
        return l(e.b.a.p.m.h.c.class).l(f9354m);
    }

    public void q(@NonNull View view) {
        r(new b(view));
    }

    public void r(@Nullable p<?> pVar) {
        if (pVar == null) {
            return;
        }
        S(pVar);
    }

    @NonNull
    @CheckResult
    public i<File> s(@Nullable Object obj) {
        return t().h(obj);
    }

    @NonNull
    @CheckResult
    public i<File> t() {
        return l(File.class).l(n);
    }

    public synchronized String toString() {
        return super.toString() + "{tracker=" + this.f9356d + ", treeNode=" + this.f9357e + "}";
    }

    public List<e.b.a.t.g<Object>> u() {
        return this.f9361i;
    }

    public synchronized e.b.a.t.h v() {
        return this.f9362j;
    }

    @NonNull
    public <T> k<?, T> w(Class<T> cls) {
        return this.a.j().e(cls);
    }

    public synchronized boolean x() {
        return this.f9356d.d();
    }

    @Override // e.b.a.h
    @NonNull
    @CheckResult
    /* renamed from: y */
    public i<Drawable> g(@Nullable Bitmap bitmap) {
        return n().g(bitmap);
    }

    @Override // e.b.a.h
    @NonNull
    @CheckResult
    /* renamed from: z */
    public i<Drawable> f(@Nullable Drawable drawable) {
        return n().f(drawable);
    }

    public j(e.b.a.c cVar, l lVar, q qVar, r rVar, e.b.a.q.d dVar, Context context) {
        this.f9358f = new t();
        a aVar = new a();
        this.f9359g = aVar;
        this.a = cVar;
        this.f9355c = lVar;
        this.f9357e = qVar;
        this.f9356d = rVar;
        this.b = context;
        e.b.a.q.c a2 = dVar.a(context.getApplicationContext(), new c(rVar));
        this.f9360h = a2;
        if (n.t()) {
            n.x(aVar);
        } else {
            lVar.b(this);
        }
        lVar.b(a2);
        this.f9361i = new CopyOnWriteArrayList<>(cVar.j().c());
        P(cVar.j().d());
        cVar.u(this);
    }
}
