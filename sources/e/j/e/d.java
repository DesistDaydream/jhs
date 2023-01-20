package e.j.e;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.InstanceCreator;
import com.google.gson.LongSerializationPolicy;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.bind.DefaultDateTypeAdapter;
import com.google.gson.internal.bind.TreeTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class d {
    private Excluder a;
    private LongSerializationPolicy b;

    /* renamed from: c  reason: collision with root package name */
    private c f11283c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<Type, InstanceCreator<?>> f11284d;

    /* renamed from: e  reason: collision with root package name */
    private final List<q> f11285e;

    /* renamed from: f  reason: collision with root package name */
    private final List<q> f11286f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f11287g;

    /* renamed from: h  reason: collision with root package name */
    private String f11288h;

    /* renamed from: i  reason: collision with root package name */
    private int f11289i;

    /* renamed from: j  reason: collision with root package name */
    private int f11290j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f11291k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f11292l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f11293m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private p r;
    private p s;

    public d() {
        this.a = Excluder.f3189h;
        this.b = LongSerializationPolicy.DEFAULT;
        this.f11283c = FieldNamingPolicy.IDENTITY;
        this.f11284d = new HashMap();
        this.f11285e = new ArrayList();
        this.f11286f = new ArrayList();
        this.f11287g = false;
        this.f11288h = Gson.G;
        this.f11289i = 2;
        this.f11290j = 2;
        this.f11291k = false;
        this.f11292l = false;
        this.f11293m = true;
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = true;
        this.r = Gson.I;
        this.s = Gson.J;
    }

    private void c(String str, int i2, int i3, List<q> list) {
        q qVar;
        q qVar2;
        boolean z = e.j.e.s.m.a.a;
        q qVar3 = null;
        if (str != null && !str.trim().isEmpty()) {
            qVar = DefaultDateTypeAdapter.b.b.c(str);
            if (z) {
                qVar3 = e.j.e.s.m.a.f11298c.c(str);
                qVar2 = e.j.e.s.m.a.b.c(str);
            }
            qVar2 = null;
        } else if (i2 == 2 || i3 == 2) {
            return;
        } else {
            q b = DefaultDateTypeAdapter.b.b.b(i2, i3);
            if (z) {
                qVar3 = e.j.e.s.m.a.f11298c.b(i2, i3);
                q b2 = e.j.e.s.m.a.b.b(i2, i3);
                qVar = b;
                qVar2 = b2;
            } else {
                qVar = b;
                qVar2 = null;
            }
        }
        list.add(qVar);
        if (z) {
            list.add(qVar3);
            list.add(qVar2);
        }
    }

    public d A() {
        this.n = true;
        return this;
    }

    public d B(double d2) {
        this.a = this.a.s(d2);
        return this;
    }

    public d a(a aVar) {
        this.a = this.a.q(aVar, false, true);
        return this;
    }

    public d b(a aVar) {
        this.a = this.a.q(aVar, true, false);
        return this;
    }

    public Gson d() {
        List<q> arrayList = new ArrayList<>(this.f11285e.size() + this.f11286f.size() + 3);
        arrayList.addAll(this.f11285e);
        Collections.reverse(arrayList);
        ArrayList arrayList2 = new ArrayList(this.f11286f);
        Collections.reverse(arrayList2);
        arrayList.addAll(arrayList2);
        c(this.f11288h, this.f11289i, this.f11290j, arrayList);
        return new Gson(this.a, this.f11283c, this.f11284d, this.f11287g, this.f11291k, this.o, this.f11293m, this.n, this.p, this.f11292l, this.q, this.b, this.f11288h, this.f11289i, this.f11290j, this.f11285e, this.f11286f, arrayList, this.r, this.s);
    }

    public d e() {
        this.f11293m = false;
        return this;
    }

    public d f() {
        this.a = this.a.c();
        return this;
    }

    public d g() {
        this.q = false;
        return this;
    }

    public d h() {
        this.f11291k = true;
        return this;
    }

    public d i(int... iArr) {
        this.a = this.a.r(iArr);
        return this;
    }

    public d j() {
        this.a = this.a.j();
        return this;
    }

    public d k() {
        this.o = true;
        return this;
    }

    public d l(Type type, Object obj) {
        boolean z = obj instanceof n;
        e.j.e.s.a.a(z || (obj instanceof g) || (obj instanceof InstanceCreator) || (obj instanceof TypeAdapter));
        if (obj instanceof InstanceCreator) {
            this.f11284d.put(type, (InstanceCreator) obj);
        }
        if (z || (obj instanceof g)) {
            this.f11285e.add(TreeTypeAdapter.l(e.j.e.t.a.get(type), obj));
        }
        if (obj instanceof TypeAdapter) {
            this.f11285e.add(TypeAdapters.a(e.j.e.t.a.get(type), (TypeAdapter) obj));
        }
        return this;
    }

    public d m(q qVar) {
        this.f11285e.add(qVar);
        return this;
    }

    public d n(Class<?> cls, Object obj) {
        boolean z = obj instanceof n;
        e.j.e.s.a.a(z || (obj instanceof g) || (obj instanceof TypeAdapter));
        if ((obj instanceof g) || z) {
            this.f11286f.add(TreeTypeAdapter.m(cls, obj));
        }
        if (obj instanceof TypeAdapter) {
            this.f11285e.add(TypeAdapters.e(cls, (TypeAdapter) obj));
        }
        return this;
    }

    public d o() {
        this.f11287g = true;
        return this;
    }

    public d p() {
        this.f11292l = true;
        return this;
    }

    public d q(int i2) {
        this.f11289i = i2;
        this.f11288h = null;
        return this;
    }

    public d r(int i2, int i3) {
        this.f11289i = i2;
        this.f11290j = i3;
        this.f11288h = null;
        return this;
    }

    public d s(String str) {
        this.f11288h = str;
        return this;
    }

    public d t(a... aVarArr) {
        for (a aVar : aVarArr) {
            this.a = this.a.q(aVar, true, true);
        }
        return this;
    }

    public d u(FieldNamingPolicy fieldNamingPolicy) {
        this.f11283c = fieldNamingPolicy;
        return this;
    }

    public d v(c cVar) {
        this.f11283c = cVar;
        return this;
    }

    public d w() {
        this.p = true;
        return this;
    }

    public d x(LongSerializationPolicy longSerializationPolicy) {
        this.b = longSerializationPolicy;
        return this;
    }

    public d y(p pVar) {
        this.s = pVar;
        return this;
    }

    public d z(p pVar) {
        this.r = pVar;
        return this;
    }

    public d(Gson gson) {
        this.a = Excluder.f3189h;
        this.b = LongSerializationPolicy.DEFAULT;
        this.f11283c = FieldNamingPolicy.IDENTITY;
        HashMap hashMap = new HashMap();
        this.f11284d = hashMap;
        ArrayList arrayList = new ArrayList();
        this.f11285e = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.f11286f = arrayList2;
        this.f11287g = false;
        this.f11288h = Gson.G;
        this.f11289i = 2;
        this.f11290j = 2;
        this.f11291k = false;
        this.f11292l = false;
        this.f11293m = true;
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = true;
        this.r = Gson.I;
        this.s = Gson.J;
        this.a = gson.f3180f;
        this.f11283c = gson.f3181g;
        hashMap.putAll(gson.f3182h);
        this.f11287g = gson.f3183i;
        this.f11291k = gson.f3184j;
        this.o = gson.f3185k;
        this.f11293m = gson.f3186l;
        this.n = gson.f3187m;
        this.p = gson.n;
        this.f11292l = gson.o;
        this.b = gson.t;
        this.f11288h = gson.q;
        this.f11289i = gson.r;
        this.f11290j = gson.s;
        arrayList.addAll(gson.u);
        arrayList2.addAll(gson.v);
        this.q = gson.p;
        this.r = gson.w;
        this.s = gson.x;
    }
}
