package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapter;
import e.j.e.f;
import e.j.e.g;
import e.j.e.h;
import e.j.e.m;
import e.j.e.n;
import e.j.e.q;
import e.j.e.s.i;
import e.j.e.u.c;
import java.io.IOException;
import java.lang.reflect.Type;

/* loaded from: classes2.dex */
public final class TreeTypeAdapter<T> extends TypeAdapter<T> {
    private final n<T> a;
    private final g<T> b;

    /* renamed from: c  reason: collision with root package name */
    public final Gson f3223c;

    /* renamed from: d  reason: collision with root package name */
    private final e.j.e.t.a<T> f3224d;

    /* renamed from: e  reason: collision with root package name */
    private final q f3225e;

    /* renamed from: f  reason: collision with root package name */
    private final TreeTypeAdapter<T>.b f3226f = new b();

    /* renamed from: g  reason: collision with root package name */
    private volatile TypeAdapter<T> f3227g;

    /* loaded from: classes2.dex */
    public static final class SingleTypeFactory implements q {
        private final e.j.e.t.a<?> a;
        private final boolean b;

        /* renamed from: c  reason: collision with root package name */
        private final Class<?> f3228c;

        /* renamed from: d  reason: collision with root package name */
        private final n<?> f3229d;

        /* renamed from: e  reason: collision with root package name */
        private final g<?> f3230e;

        public SingleTypeFactory(Object obj, e.j.e.t.a<?> aVar, boolean z, Class<?> cls) {
            n<?> nVar = obj instanceof n ? (n) obj : null;
            this.f3229d = nVar;
            g<?> gVar = obj instanceof g ? (g) obj : null;
            this.f3230e = gVar;
            e.j.e.s.a.a((nVar == null && gVar == null) ? false : true);
            this.a = aVar;
            this.b = z;
            this.f3228c = cls;
        }

        @Override // e.j.e.q
        public <T> TypeAdapter<T> a(Gson gson, e.j.e.t.a<T> aVar) {
            boolean isAssignableFrom;
            e.j.e.t.a<?> aVar2 = this.a;
            if (aVar2 != null) {
                isAssignableFrom = aVar2.equals(aVar) || (this.b && this.a.getType() == aVar.getRawType());
            } else {
                isAssignableFrom = this.f3228c.isAssignableFrom(aVar.getRawType());
            }
            if (isAssignableFrom) {
                return new TreeTypeAdapter(this.f3229d, this.f3230e, gson, aVar, this);
            }
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public final class b implements m, f {
        private b() {
        }

        @Override // e.j.e.m
        public h a(Object obj, Type type) {
            return TreeTypeAdapter.this.f3223c.H(obj, type);
        }

        @Override // e.j.e.f
        public <R> R b(h hVar, Type type) throws JsonParseException {
            return (R) TreeTypeAdapter.this.f3223c.j(hVar, type);
        }

        @Override // e.j.e.m
        public h serialize(Object obj) {
            return TreeTypeAdapter.this.f3223c.G(obj);
        }
    }

    public TreeTypeAdapter(n<T> nVar, g<T> gVar, Gson gson, e.j.e.t.a<T> aVar, q qVar) {
        this.a = nVar;
        this.b = gVar;
        this.f3223c = gson;
        this.f3224d = aVar;
        this.f3225e = qVar;
    }

    private TypeAdapter<T> j() {
        TypeAdapter<T> typeAdapter = this.f3227g;
        if (typeAdapter != null) {
            return typeAdapter;
        }
        TypeAdapter<T> r = this.f3223c.r(this.f3225e, this.f3224d);
        this.f3227g = r;
        return r;
    }

    public static q k(e.j.e.t.a<?> aVar, Object obj) {
        return new SingleTypeFactory(obj, aVar, false, null);
    }

    public static q l(e.j.e.t.a<?> aVar, Object obj) {
        return new SingleTypeFactory(obj, aVar, aVar.getType() == aVar.getRawType(), null);
    }

    public static q m(Class<?> cls, Object obj) {
        return new SingleTypeFactory(obj, null, false, cls);
    }

    @Override // com.google.gson.TypeAdapter
    public T e(e.j.e.u.a aVar) throws IOException {
        if (this.b == null) {
            return j().e(aVar);
        }
        h a2 = i.a(aVar);
        if (a2.y()) {
            return null;
        }
        return this.b.a(a2, this.f3224d.getType(), this.f3226f);
    }

    @Override // com.google.gson.TypeAdapter
    public void i(c cVar, T t) throws IOException {
        n<T> nVar = this.a;
        if (nVar == null) {
            j().i(cVar, t);
        } else if (t == null) {
            cVar.Y();
        } else {
            i.b(nVar.a(t, this.f3224d.getType(), this.f3226f), cVar);
        }
    }
}
