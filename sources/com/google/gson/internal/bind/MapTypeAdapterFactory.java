package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.stream.JsonToken;
import e.j.e.h;
import e.j.e.l;
import e.j.e.q;
import e.j.e.s.b;
import e.j.e.s.e;
import e.j.e.s.f;
import e.j.e.s.i;
import e.j.e.u.a;
import e.j.e.u.c;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes2.dex */
public final class MapTypeAdapterFactory implements q {
    private final b a;
    public final boolean b;

    /* loaded from: classes2.dex */
    public final class Adapter<K, V> extends TypeAdapter<Map<K, V>> {
        private final TypeAdapter<K> a;
        private final TypeAdapter<V> b;

        /* renamed from: c  reason: collision with root package name */
        private final f<? extends Map<K, V>> f3210c;

        public Adapter(Gson gson, Type type, TypeAdapter<K> typeAdapter, Type type2, TypeAdapter<V> typeAdapter2, f<? extends Map<K, V>> fVar) {
            this.a = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, type);
            this.b = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter2, type2);
            this.f3210c = fVar;
        }

        private String j(h hVar) {
            if (hVar.A()) {
                l s = hVar.s();
                if (s.E()) {
                    return String.valueOf(s.u());
                }
                if (s.C()) {
                    return Boolean.toString(s.e());
                }
                if (s.F()) {
                    return s.w();
                }
                throw new AssertionError();
            } else if (hVar.y()) {
                return "null";
            } else {
                throw new AssertionError();
            }
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: k */
        public Map<K, V> e(a aVar) throws IOException {
            JsonToken C0 = aVar.C0();
            if (C0 == JsonToken.NULL) {
                aVar.x0();
                return null;
            }
            Map<K, V> a = this.f3210c.a();
            if (C0 == JsonToken.BEGIN_ARRAY) {
                aVar.j();
                while (aVar.H()) {
                    aVar.j();
                    K e2 = this.a.e(aVar);
                    if (a.put(e2, this.b.e(aVar)) == null) {
                        aVar.q();
                    } else {
                        throw new JsonSyntaxException("duplicate key: " + e2);
                    }
                }
                aVar.q();
            } else {
                aVar.k();
                while (aVar.H()) {
                    e.a.a(aVar);
                    K e3 = this.a.e(aVar);
                    if (a.put(e3, this.b.e(aVar)) != null) {
                        throw new JsonSyntaxException("duplicate key: " + e3);
                    }
                }
                aVar.r();
            }
            return a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: l */
        public void i(c cVar, Map<K, V> map) throws IOException {
            if (map == null) {
                cVar.Y();
            } else if (!MapTypeAdapterFactory.this.b) {
                cVar.n();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    cVar.M(String.valueOf(entry.getKey()));
                    this.b.i(cVar, entry.getValue());
                }
                cVar.r();
            } else {
                ArrayList arrayList = new ArrayList(map.size());
                ArrayList arrayList2 = new ArrayList(map.size());
                int i2 = 0;
                boolean z = false;
                for (Map.Entry<K, V> entry2 : map.entrySet()) {
                    h h2 = this.a.h(entry2.getKey());
                    arrayList.add(h2);
                    arrayList2.add(entry2.getValue());
                    z |= h2.x() || h2.z();
                }
                if (z) {
                    cVar.l();
                    int size = arrayList.size();
                    while (i2 < size) {
                        cVar.l();
                        i.b((h) arrayList.get(i2), cVar);
                        this.b.i(cVar, arrayList2.get(i2));
                        cVar.q();
                        i2++;
                    }
                    cVar.q();
                    return;
                }
                cVar.n();
                int size2 = arrayList.size();
                while (i2 < size2) {
                    cVar.M(j((h) arrayList.get(i2)));
                    this.b.i(cVar, arrayList2.get(i2));
                    i2++;
                }
                cVar.r();
            }
        }
    }

    public MapTypeAdapterFactory(b bVar, boolean z) {
        this.a = bVar;
        this.b = z;
    }

    private TypeAdapter<?> b(Gson gson, Type type) {
        if (type != Boolean.TYPE && type != Boolean.class) {
            return gson.p(e.j.e.t.a.get(type));
        }
        return TypeAdapters.f3235f;
    }

    @Override // e.j.e.q
    public <T> TypeAdapter<T> a(Gson gson, e.j.e.t.a<T> aVar) {
        Type type = aVar.getType();
        if (Map.class.isAssignableFrom(aVar.getRawType())) {
            Type[] j2 = C$Gson$Types.j(type, C$Gson$Types.k(type));
            return new Adapter(gson, j2[0], b(gson, j2[0]), j2[1], gson.p(e.j.e.t.a.get(j2[1])), this.a.a(aVar));
        }
        return null;
    }
}
