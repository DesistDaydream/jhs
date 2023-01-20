package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import e.j.e.g;
import e.j.e.n;
import e.j.e.q;
import e.j.e.s.b;
import e.j.e.t.a;

/* loaded from: classes2.dex */
public final class JsonAdapterAnnotationTypeAdapterFactory implements q {
    private final b a;

    public JsonAdapterAnnotationTypeAdapterFactory(b bVar) {
        this.a = bVar;
    }

    @Override // e.j.e.q
    public <T> TypeAdapter<T> a(Gson gson, a<T> aVar) {
        e.j.e.r.b bVar = (e.j.e.r.b) aVar.getRawType().getAnnotation(e.j.e.r.b.class);
        if (bVar == null) {
            return null;
        }
        return (TypeAdapter<T>) b(this.a, gson, aVar, bVar);
    }

    public TypeAdapter<?> b(b bVar, Gson gson, a<?> aVar, e.j.e.r.b bVar2) {
        TypeAdapter<?> treeTypeAdapter;
        Object a = bVar.a(a.get((Class) bVar2.value())).a();
        if (a instanceof TypeAdapter) {
            treeTypeAdapter = (TypeAdapter) a;
        } else if (a instanceof q) {
            treeTypeAdapter = ((q) a).a(gson, aVar);
        } else {
            boolean z = a instanceof n;
            if (!z && !(a instanceof g)) {
                throw new IllegalArgumentException("Invalid attempt to bind an instance of " + a.getClass().getName() + " as a @JsonAdapter for " + aVar.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
            }
            treeTypeAdapter = new TreeTypeAdapter<>(z ? (n) a : null, a instanceof g ? (g) a : null, gson, aVar, null);
        }
        return (treeTypeAdapter == null || !bVar2.nullSafe()) ? treeTypeAdapter : treeTypeAdapter.d();
    }
}
