package com.vector.gson;

import androidx.annotation.MainThread;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonToken;
import e.j.e.q;
import e.j.e.t.a;
import e.j.e.u.c;
import e.n.f;
import e.n.i;
import e.n.j;
import e.n.k;
import e.n.l;
import e.n.o;
import e.n.p;
import h.k2.v.f0;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\n\u0012\u0004\u0012\u0002H\u0005\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\tH\u0016J$\u0010\n\u001a\n\u0012\u0004\u0012\u0002H\u0005\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\tH\u0002J\u0018\u0010\u000b\u001a\u00020\f\"\u0004\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u0002H\u00050\rH\u0002¨\u0006\u000e"}, d2 = {"Lcom/vector/gson/LiveTypeAdapterFactory;", "Lcom/google/gson/TypeAdapterFactory;", "()V", "create", "Lcom/google/gson/TypeAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "gson", "Lcom/google/gson/Gson;", "type", "Lcom/google/gson/reflect/TypeToken;", "createAdapter", "isLiveData", "", "Ljava/lang/Class;", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class LiveTypeAdapterFactory implements q {
    private final <T> TypeAdapter<T> b(final a<T> aVar) {
        return new TypeAdapter<T>() { // from class: com.vector.gson.LiveTypeAdapterFactory$createAdapter$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.gson.TypeAdapter
            @e
            @MainThread
            public T e(@e e.j.e.u.a aVar2) {
                MutableLiveData mutableLiveData;
                if ((aVar2 == null ? null : aVar2.C0()) == JsonToken.NULL) {
                    aVar2.x0();
                    return null;
                }
                Class rawType = aVar.getRawType();
                if (f0.g(rawType, i.class)) {
                    mutableLiveData = new i(aVar2 != null ? Boolean.valueOf(aVar2.Y()) : null);
                } else if (f0.g(rawType, j.class)) {
                    mutableLiveData = new j(aVar2 != null ? Double.valueOf(aVar2.c0()) : null);
                } else if (f0.g(rawType, k.class)) {
                    mutableLiveData = new k(aVar2 != null ? Float.valueOf((float) aVar2.c0()) : null);
                } else if (f0.g(rawType, l.class)) {
                    mutableLiveData = new l(aVar2 != null ? Integer.valueOf(aVar2.f0()) : null);
                } else if (f0.g(rawType, o.class)) {
                    mutableLiveData = new o(aVar2 != null ? Long.valueOf(aVar2.m0()) : null);
                } else if (!f0.g(rawType, p.class)) {
                    return null;
                } else {
                    mutableLiveData = new p(aVar2 != null ? aVar2.A0() : null);
                }
                return mutableLiveData;
            }

            @Override // com.google.gson.TypeAdapter
            public void i(@e c cVar, @e T t) {
                f fVar = t instanceof f ? (f) t : null;
                Object value = fVar != null ? fVar.getValue() : null;
                if (value == null) {
                    if (cVar == null) {
                        return;
                    }
                    cVar.Y();
                } else if (value instanceof Byte) {
                    if (cVar == null) {
                        return;
                    }
                    cVar.F0((Number) value);
                } else if (value instanceof Short) {
                    if (cVar == null) {
                        return;
                    }
                    cVar.F0((Number) value);
                } else if (value instanceof Integer) {
                    if (cVar == null) {
                        return;
                    }
                    cVar.F0((Number) value);
                } else if (value instanceof Long) {
                    if (cVar == null) {
                        return;
                    }
                    cVar.D0(((Number) value).longValue());
                } else if (value instanceof Float) {
                    if (cVar == null) {
                        return;
                    }
                    cVar.F0((Number) value);
                } else if (value instanceof Double) {
                    if (cVar == null) {
                        return;
                    }
                    cVar.C0(((Number) value).doubleValue());
                } else if (value instanceof Number) {
                    if (cVar == null) {
                        return;
                    }
                    cVar.F0((Number) value);
                } else if (value instanceof Boolean) {
                    if (cVar == null) {
                        return;
                    }
                    cVar.H0(((Boolean) value).booleanValue());
                } else if (!(value instanceof String) || cVar == null) {
                } else {
                    cVar.G0((String) value);
                }
            }
        };
    }

    private final <T> boolean c(Class<T> cls) {
        if (f0.g(cls, f.class)) {
            return true;
        }
        Class<T> superclass = cls.getSuperclass();
        if (superclass == null) {
            return false;
        }
        if (f0.g(superclass, f.class)) {
            return true;
        }
        return c(superclass);
    }

    @Override // e.j.e.q
    @e
    public <T> TypeAdapter<T> a(@e Gson gson, @d a<T> aVar) {
        if (c(aVar.getRawType())) {
            return b(aVar);
        }
        return null;
    }
}
