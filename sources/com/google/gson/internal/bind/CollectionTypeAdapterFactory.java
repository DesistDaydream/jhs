package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.stream.JsonToken;
import e.j.e.q;
import e.j.e.s.b;
import e.j.e.s.f;
import e.j.e.u.a;
import e.j.e.u.c;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;

/* loaded from: classes2.dex */
public final class CollectionTypeAdapterFactory implements q {
    private final b a;

    /* loaded from: classes2.dex */
    public static final class Adapter<E> extends TypeAdapter<Collection<E>> {
        private final TypeAdapter<E> a;
        private final f<? extends Collection<E>> b;

        public Adapter(Gson gson, Type type, TypeAdapter<E> typeAdapter, f<? extends Collection<E>> fVar) {
            this.a = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, type);
            this.b = fVar;
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: j */
        public Collection<E> e(a aVar) throws IOException {
            if (aVar.C0() == JsonToken.NULL) {
                aVar.x0();
                return null;
            }
            Collection<E> a = this.b.a();
            aVar.j();
            while (aVar.H()) {
                a.add(this.a.e(aVar));
            }
            aVar.q();
            return a;
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: k */
        public void i(c cVar, Collection<E> collection) throws IOException {
            if (collection == null) {
                cVar.Y();
                return;
            }
            cVar.l();
            for (E e2 : collection) {
                this.a.i(cVar, e2);
            }
            cVar.q();
        }
    }

    public CollectionTypeAdapterFactory(b bVar) {
        this.a = bVar;
    }

    @Override // e.j.e.q
    public <T> TypeAdapter<T> a(Gson gson, e.j.e.t.a<T> aVar) {
        Type type = aVar.getType();
        Class<? super T> rawType = aVar.getRawType();
        if (Collection.class.isAssignableFrom(rawType)) {
            Type h2 = C$Gson$Types.h(type, rawType);
            return new Adapter(gson, h2, gson.p(e.j.e.t.a.get(h2)), this.a.a(aVar));
        }
        return null;
    }
}
