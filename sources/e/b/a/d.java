package e.b.a;

import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import e.b.a.c;
import e.b.a.f;
import e.b.a.p.k.y.a;
import e.b.a.p.k.y.l;
import e.b.a.q.p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: c  reason: collision with root package name */
    private e.b.a.p.k.i f9324c;

    /* renamed from: d  reason: collision with root package name */
    private e.b.a.p.k.x.e f9325d;

    /* renamed from: e  reason: collision with root package name */
    private e.b.a.p.k.x.b f9326e;

    /* renamed from: f  reason: collision with root package name */
    private e.b.a.p.k.y.j f9327f;

    /* renamed from: g  reason: collision with root package name */
    private e.b.a.p.k.z.a f9328g;

    /* renamed from: h  reason: collision with root package name */
    private e.b.a.p.k.z.a f9329h;

    /* renamed from: i  reason: collision with root package name */
    private a.InterfaceC0310a f9330i;

    /* renamed from: j  reason: collision with root package name */
    private l f9331j;

    /* renamed from: k  reason: collision with root package name */
    private e.b.a.q.d f9332k;
    @Nullable
    private p.b n;
    private e.b.a.p.k.z.a o;
    private boolean p;
    @Nullable
    private List<e.b.a.t.g<Object>> q;
    private final Map<Class<?>, k<?, ?>> a = new ArrayMap();
    private final f.a b = new f.a();

    /* renamed from: l  reason: collision with root package name */
    private int f9333l = 4;

    /* renamed from: m  reason: collision with root package name */
    private c.a f9334m = new a();

    /* loaded from: classes.dex */
    public class a implements c.a {
        public a() {
        }

        @Override // e.b.a.c.a
        @NonNull
        public e.b.a.t.h build() {
            return new e.b.a.t.h();
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a {
        public final /* synthetic */ e.b.a.t.h a;

        public b(e.b.a.t.h hVar) {
            this.a = hVar;
        }

        @Override // e.b.a.c.a
        @NonNull
        public e.b.a.t.h build() {
            e.b.a.t.h hVar = this.a;
            return hVar != null ? hVar : new e.b.a.t.h();
        }
    }

    /* loaded from: classes.dex */
    public static final class c implements f.b {
    }

    /* renamed from: e.b.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0302d implements f.b {
    }

    /* loaded from: classes.dex */
    public static final class e implements f.b {
        public final int a;

        public e(int i2) {
            this.a = i2;
        }
    }

    /* loaded from: classes.dex */
    public static final class f implements f.b {
        private f() {
        }
    }

    @NonNull
    public d a(@NonNull e.b.a.t.g<Object> gVar) {
        if (this.q == null) {
            this.q = new ArrayList();
        }
        this.q.add(gVar);
        return this;
    }

    @NonNull
    public e.b.a.c b(@NonNull Context context) {
        if (this.f9328g == null) {
            this.f9328g = e.b.a.p.k.z.a.j();
        }
        if (this.f9329h == null) {
            this.f9329h = e.b.a.p.k.z.a.f();
        }
        if (this.o == null) {
            this.o = e.b.a.p.k.z.a.c();
        }
        if (this.f9331j == null) {
            this.f9331j = new l.a(context).a();
        }
        if (this.f9332k == null) {
            this.f9332k = new e.b.a.q.f();
        }
        if (this.f9325d == null) {
            int b2 = this.f9331j.b();
            if (b2 > 0) {
                this.f9325d = new e.b.a.p.k.x.k(b2);
            } else {
                this.f9325d = new e.b.a.p.k.x.f();
            }
        }
        if (this.f9326e == null) {
            this.f9326e = new e.b.a.p.k.x.j(this.f9331j.a());
        }
        if (this.f9327f == null) {
            this.f9327f = new e.b.a.p.k.y.i(this.f9331j.d());
        }
        if (this.f9330i == null) {
            this.f9330i = new e.b.a.p.k.y.h(context);
        }
        if (this.f9324c == null) {
            this.f9324c = new e.b.a.p.k.i(this.f9327f, this.f9330i, this.f9329h, this.f9328g, e.b.a.p.k.z.a.m(), this.o, this.p);
        }
        List<e.b.a.t.g<Object>> list = this.q;
        if (list == null) {
            this.q = Collections.emptyList();
        } else {
            this.q = Collections.unmodifiableList(list);
        }
        e.b.a.f c2 = this.b.c();
        return new e.b.a.c(context, this.f9324c, this.f9327f, this.f9325d, this.f9326e, new p(this.n, c2), this.f9332k, this.f9333l, this.f9334m, this.a, this.q, c2);
    }

    @NonNull
    public d c(@Nullable e.b.a.p.k.z.a aVar) {
        this.o = aVar;
        return this;
    }

    @NonNull
    public d d(@Nullable e.b.a.p.k.x.b bVar) {
        this.f9326e = bVar;
        return this;
    }

    @NonNull
    public d e(@Nullable e.b.a.p.k.x.e eVar) {
        this.f9325d = eVar;
        return this;
    }

    @NonNull
    public d f(@Nullable e.b.a.q.d dVar) {
        this.f9332k = dVar;
        return this;
    }

    @NonNull
    public d g(@NonNull c.a aVar) {
        this.f9334m = (c.a) e.b.a.v.l.d(aVar);
        return this;
    }

    @NonNull
    public d h(@Nullable e.b.a.t.h hVar) {
        return g(new b(hVar));
    }

    @NonNull
    public <T> d i(@NonNull Class<T> cls, @Nullable k<?, T> kVar) {
        this.a.put(cls, kVar);
        return this;
    }

    @NonNull
    public d j(@Nullable a.InterfaceC0310a interfaceC0310a) {
        this.f9330i = interfaceC0310a;
        return this;
    }

    @NonNull
    public d k(@Nullable e.b.a.p.k.z.a aVar) {
        this.f9329h = aVar;
        return this;
    }

    public d l(e.b.a.p.k.i iVar) {
        this.f9324c = iVar;
        return this;
    }

    public d m(boolean z) {
        this.b.update(new c(), z && Build.VERSION.SDK_INT >= 29);
        return this;
    }

    @NonNull
    public d n(boolean z) {
        this.p = z;
        return this;
    }

    @NonNull
    public d o(int i2) {
        if (i2 >= 2 && i2 <= 6) {
            this.f9333l = i2;
            return this;
        }
        throw new IllegalArgumentException("Log level must be one of Log.VERBOSE, Log.DEBUG, Log.INFO, Log.WARN, or Log.ERROR");
    }

    public d p(boolean z) {
        this.b.update(new C0302d(), z);
        return this;
    }

    @NonNull
    public d q(@Nullable e.b.a.p.k.y.j jVar) {
        this.f9327f = jVar;
        return this;
    }

    @NonNull
    public d r(@NonNull l.a aVar) {
        return s(aVar.a());
    }

    @NonNull
    public d s(@Nullable l lVar) {
        this.f9331j = lVar;
        return this;
    }

    public void t(@Nullable p.b bVar) {
        this.n = bVar;
    }

    @Deprecated
    public d u(@Nullable e.b.a.p.k.z.a aVar) {
        return v(aVar);
    }

    @NonNull
    public d v(@Nullable e.b.a.p.k.z.a aVar) {
        this.f9328g = aVar;
        return this;
    }
}
