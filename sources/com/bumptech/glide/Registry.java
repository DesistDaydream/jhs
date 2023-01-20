package com.bumptech.glide;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.bumptech.glide.load.ImageHeaderParser;
import e.b.a.p.h;
import e.b.a.p.j.e;
import e.b.a.p.k.g;
import e.b.a.p.k.q;
import e.b.a.p.k.s;
import e.b.a.p.l.n;
import e.b.a.p.l.o;
import e.b.a.p.l.p;
import e.b.a.s.a;
import e.b.a.s.b;
import e.b.a.s.c;
import e.b.a.s.d;
import e.b.a.s.e;
import e.b.a.s.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class Registry {

    /* renamed from: k */
    public static final String f1675k = "Gif";

    /* renamed from: l */
    public static final String f1676l = "Bitmap";

    /* renamed from: m */
    public static final String f1677m = "BitmapDrawable";
    private static final String n = "legacy_prepend_all";
    private static final String o = "legacy_append";
    private final p a;
    private final a b;

    /* renamed from: c */
    private final e f1678c;

    /* renamed from: d */
    private final f f1679d;

    /* renamed from: e */
    private final e.b.a.p.j.f f1680e;

    /* renamed from: f */
    private final e.b.a.p.m.i.f f1681f;

    /* renamed from: g */
    private final b f1682g;

    /* renamed from: h */
    private final d f1683h = new d();

    /* renamed from: i */
    private final c f1684i = new c();

    /* renamed from: j */
    private final Pools.Pool<List<Throwable>> f1685j;

    /* loaded from: classes.dex */
    public static class MissingComponentException extends RuntimeException {
        public MissingComponentException(@NonNull String str) {
            super(str);
        }
    }

    /* loaded from: classes.dex */
    public static final class NoImageHeaderParserException extends MissingComponentException {
        public NoImageHeaderParserException() {
            super("Failed to find image header parser.");
        }
    }

    /* loaded from: classes.dex */
    public static class NoModelLoaderAvailableException extends MissingComponentException {
        public NoModelLoaderAvailableException(@NonNull Object obj) {
            super("Failed to find any ModelLoaders registered for model class: " + obj.getClass());
        }

        public <M> NoModelLoaderAvailableException(@NonNull M m2, @NonNull List<n<M, ?>> list) {
            super("Found ModelLoaders for model class: " + list + ", but none that handle this specific model instance: " + m2);
        }

        public NoModelLoaderAvailableException(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            super("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        }
    }

    /* loaded from: classes.dex */
    public static class NoResultEncoderAvailableException extends MissingComponentException {
        public NoResultEncoderAvailableException(@NonNull Class<?> cls) {
            super("Failed to find result encoder for resource class: " + cls + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
        }
    }

    /* loaded from: classes.dex */
    public static class NoSourceEncoderAvailableException extends MissingComponentException {
        public NoSourceEncoderAvailableException(@NonNull Class<?> cls) {
            super("Failed to find source encoder for data class: " + cls);
        }
    }

    public Registry() {
        Pools.Pool<List<Throwable>> f2 = e.b.a.v.p.a.f();
        this.f1685j = f2;
        this.a = new p(f2);
        this.b = new a();
        this.f1678c = new e();
        this.f1679d = new f();
        this.f1680e = new e.b.a.p.j.f();
        this.f1681f = new e.b.a.p.m.i.f();
        this.f1682g = new b();
        z(Arrays.asList(f1675k, f1676l, f1677m));
    }

    @NonNull
    private <Data, TResource, Transcode> List<g<Data, TResource, Transcode>> f(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        ArrayList arrayList = new ArrayList();
        for (Class cls4 : this.f1678c.d(cls, cls2)) {
            for (Class cls5 : this.f1681f.b(cls4, cls3)) {
                arrayList.add(new g(cls, cls4, cls5, this.f1678c.b(cls, cls4), this.f1681f.a(cls4, cls5), this.f1685j));
            }
        }
        return arrayList;
    }

    @NonNull
    public <Data> Registry a(@NonNull Class<Data> cls, @NonNull e.b.a.p.a<Data> aVar) {
        this.b.a(cls, aVar);
        return this;
    }

    @NonNull
    public <TResource> Registry b(@NonNull Class<TResource> cls, @NonNull h<TResource> hVar) {
        this.f1679d.a(cls, hVar);
        return this;
    }

    @NonNull
    public <Data, TResource> Registry c(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull e.b.a.p.g<Data, TResource> gVar) {
        e(o, cls, cls2, gVar);
        return this;
    }

    @NonNull
    public <Model, Data> Registry d(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<Model, Data> oVar) {
        this.a.a(cls, cls2, oVar);
        return this;
    }

    @NonNull
    public <Data, TResource> Registry e(@NonNull String str, @NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull e.b.a.p.g<Data, TResource> gVar) {
        this.f1678c.a(str, gVar, cls, cls2);
        return this;
    }

    @NonNull
    public List<ImageHeaderParser> g() {
        List<ImageHeaderParser> b = this.f1682g.b();
        if (b.isEmpty()) {
            throw new NoImageHeaderParserException();
        }
        return b;
    }

    @Nullable
    public <Data, TResource, Transcode> q<Data, TResource, Transcode> h(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        q<Data, TResource, Transcode> a = this.f1684i.a(cls, cls2, cls3);
        if (this.f1684i.c(a)) {
            return null;
        }
        if (a == null) {
            List<g<Data, TResource, Transcode>> f2 = f(cls, cls2, cls3);
            a = f2.isEmpty() ? null : new q<>(cls, cls2, cls3, f2, this.f1685j);
            this.f1684i.d(cls, cls2, cls3, a);
        }
        return a;
    }

    @NonNull
    public <Model> List<n<Model, ?>> i(@NonNull Model model) {
        return this.a.e(model);
    }

    @NonNull
    public <Model, TResource, Transcode> List<Class<?>> j(@NonNull Class<Model> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        List<Class<?>> b = this.f1683h.b(cls, cls2, cls3);
        if (b == null) {
            b = new ArrayList<>();
            for (Class<?> cls4 : this.a.d(cls)) {
                for (Class<?> cls5 : this.f1678c.d(cls4, cls2)) {
                    if (!this.f1681f.b(cls5, cls3).isEmpty() && !b.contains(cls5)) {
                        b.add(cls5);
                    }
                }
            }
            this.f1683h.c(cls, cls2, cls3, Collections.unmodifiableList(b));
        }
        return b;
    }

    @NonNull
    public <X> h<X> k(@NonNull s<X> sVar) throws NoResultEncoderAvailableException {
        h<X> b = this.f1679d.b(sVar.b());
        if (b != null) {
            return b;
        }
        throw new NoResultEncoderAvailableException(sVar.b());
    }

    @NonNull
    public <X> e.b.a.p.j.e<X> l(@NonNull X x) {
        return this.f1680e.a(x);
    }

    @NonNull
    public <X> e.b.a.p.a<X> m(@NonNull X x) throws NoSourceEncoderAvailableException {
        e.b.a.p.a<X> b = this.b.b(x.getClass());
        if (b != null) {
            return b;
        }
        throw new NoSourceEncoderAvailableException(x.getClass());
    }

    public boolean n(@NonNull s<?> sVar) {
        return this.f1679d.b(sVar.b()) != null;
    }

    @NonNull
    public <Data> Registry o(@NonNull Class<Data> cls, @NonNull e.b.a.p.a<Data> aVar) {
        this.b.c(cls, aVar);
        return this;
    }

    @NonNull
    public <TResource> Registry p(@NonNull Class<TResource> cls, @NonNull h<TResource> hVar) {
        this.f1679d.c(cls, hVar);
        return this;
    }

    @NonNull
    public <Data, TResource> Registry q(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull e.b.a.p.g<Data, TResource> gVar) {
        s(n, cls, cls2, gVar);
        return this;
    }

    @NonNull
    public <Model, Data> Registry r(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<Model, Data> oVar) {
        this.a.g(cls, cls2, oVar);
        return this;
    }

    @NonNull
    public <Data, TResource> Registry s(@NonNull String str, @NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull e.b.a.p.g<Data, TResource> gVar) {
        this.f1678c.e(str, gVar, cls, cls2);
        return this;
    }

    @NonNull
    public Registry t(@NonNull ImageHeaderParser imageHeaderParser) {
        this.f1682g.a(imageHeaderParser);
        return this;
    }

    @NonNull
    public Registry u(@NonNull e.a<?> aVar) {
        this.f1680e.b(aVar);
        return this;
    }

    @NonNull
    @Deprecated
    public <Data> Registry v(@NonNull Class<Data> cls, @NonNull e.b.a.p.a<Data> aVar) {
        return a(cls, aVar);
    }

    @NonNull
    @Deprecated
    public <TResource> Registry w(@NonNull Class<TResource> cls, @NonNull h<TResource> hVar) {
        return b(cls, hVar);
    }

    @NonNull
    public <TResource, Transcode> Registry x(@NonNull Class<TResource> cls, @NonNull Class<Transcode> cls2, @NonNull e.b.a.p.m.i.e<TResource, Transcode> eVar) {
        this.f1681f.c(cls, cls2, eVar);
        return this;
    }

    @NonNull
    public <Model, Data> Registry y(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
        this.a.i(cls, cls2, oVar);
        return this;
    }

    @NonNull
    public final Registry z(@NonNull List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.add(n);
        for (String str : list) {
            arrayList.add(str);
        }
        arrayList.add(o);
        this.f1678c.f(arrayList);
        return this;
    }
}
