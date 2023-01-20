package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.stream.JsonToken;
import e.j.e.q;
import e.j.e.t.a;
import e.j.e.u.c;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class ArrayTypeAdapter<E> extends TypeAdapter<Object> {

    /* renamed from: c  reason: collision with root package name */
    public static final q f3208c = new q() { // from class: com.google.gson.internal.bind.ArrayTypeAdapter.1
        @Override // e.j.e.q
        public <T> TypeAdapter<T> a(Gson gson, a<T> aVar) {
            Type type = aVar.getType();
            if ((type instanceof GenericArrayType) || ((type instanceof Class) && ((Class) type).isArray())) {
                Type g2 = C$Gson$Types.g(type);
                return new ArrayTypeAdapter(gson, gson.p(a.get(g2)), C$Gson$Types.k(g2));
            }
            return null;
        }
    };
    private final Class<E> a;
    private final TypeAdapter<E> b;

    public ArrayTypeAdapter(Gson gson, TypeAdapter<E> typeAdapter, Class<E> cls) {
        this.b = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, cls);
        this.a = cls;
    }

    @Override // com.google.gson.TypeAdapter
    public Object e(e.j.e.u.a aVar) throws IOException {
        if (aVar.C0() == JsonToken.NULL) {
            aVar.x0();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        aVar.j();
        while (aVar.H()) {
            arrayList.add(this.b.e(aVar));
        }
        aVar.q();
        int size = arrayList.size();
        Object newInstance = Array.newInstance((Class<?>) this.a, size);
        for (int i2 = 0; i2 < size; i2++) {
            Array.set(newInstance, i2, arrayList.get(i2));
        }
        return newInstance;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.gson.TypeAdapter
    public void i(c cVar, Object obj) throws IOException {
        if (obj == null) {
            cVar.Y();
            return;
        }
        cVar.l();
        int length = Array.getLength(obj);
        for (int i2 = 0; i2 < length; i2++) {
            this.b.i(cVar, Array.get(obj, i2));
        }
        cVar.q();
    }
}
