package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import e.j.e.u.a;
import e.j.e.u.c;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* loaded from: classes2.dex */
public final class TypeAdapterRuntimeTypeWrapper<T> extends TypeAdapter<T> {
    private final Gson a;
    private final TypeAdapter<T> b;

    /* renamed from: c  reason: collision with root package name */
    private final Type f3231c;

    public TypeAdapterRuntimeTypeWrapper(Gson gson, TypeAdapter<T> typeAdapter, Type type) {
        this.a = gson;
        this.b = typeAdapter;
        this.f3231c = type;
    }

    private Type j(Type type, Object obj) {
        return obj != null ? (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class)) ? obj.getClass() : type : type;
    }

    @Override // com.google.gson.TypeAdapter
    public T e(a aVar) throws IOException {
        return this.b.e(aVar);
    }

    @Override // com.google.gson.TypeAdapter
    public void i(c cVar, T t) throws IOException {
        TypeAdapter<T> typeAdapter = this.b;
        Type j2 = j(this.f3231c, t);
        if (j2 != this.f3231c) {
            typeAdapter = this.a.p(e.j.e.t.a.get(j2));
            if (typeAdapter instanceof ReflectiveTypeAdapterFactory.Adapter) {
                TypeAdapter<T> typeAdapter2 = this.b;
                if (!(typeAdapter2 instanceof ReflectiveTypeAdapterFactory.Adapter)) {
                    typeAdapter = typeAdapter2;
                }
            }
        }
        typeAdapter.i(cVar, t);
    }
}
