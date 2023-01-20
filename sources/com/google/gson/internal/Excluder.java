package com.google.gson.internal;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import e.j.e.a;
import e.j.e.b;
import e.j.e.q;
import e.j.e.r.d;
import e.j.e.r.e;
import e.j.e.u.c;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class Excluder implements q, Cloneable {

    /* renamed from: g  reason: collision with root package name */
    private static final double f3188g = -1.0d;

    /* renamed from: h  reason: collision with root package name */
    public static final Excluder f3189h = new Excluder();

    /* renamed from: d  reason: collision with root package name */
    private boolean f3191d;
    private double a = f3188g;
    private int b = 136;

    /* renamed from: c  reason: collision with root package name */
    private boolean f3190c = true;

    /* renamed from: e  reason: collision with root package name */
    private List<a> f3192e = Collections.emptyList();

    /* renamed from: f  reason: collision with root package name */
    private List<a> f3193f = Collections.emptyList();

    private boolean f(Class<?> cls) {
        if (this.a == f3188g || p((d) cls.getAnnotation(d.class), (e) cls.getAnnotation(e.class))) {
            return (!this.f3190c && l(cls)) || k(cls);
        }
        return true;
    }

    private boolean g(Class<?> cls, boolean z) {
        for (a aVar : z ? this.f3192e : this.f3193f) {
            if (aVar.b(cls)) {
                return true;
            }
        }
        return false;
    }

    private boolean k(Class<?> cls) {
        return (Enum.class.isAssignableFrom(cls) || m(cls) || (!cls.isAnonymousClass() && !cls.isLocalClass())) ? false : true;
    }

    private boolean l(Class<?> cls) {
        return cls.isMemberClass() && !m(cls);
    }

    private boolean m(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    private boolean n(d dVar) {
        return dVar == null || dVar.value() <= this.a;
    }

    private boolean o(e eVar) {
        return eVar == null || eVar.value() > this.a;
    }

    private boolean p(d dVar, e eVar) {
        return n(dVar) && o(eVar);
    }

    @Override // e.j.e.q
    public <T> TypeAdapter<T> a(final Gson gson, final e.j.e.t.a<T> aVar) {
        Class<? super T> rawType = aVar.getRawType();
        boolean f2 = f(rawType);
        final boolean z = f2 || g(rawType, true);
        final boolean z2 = f2 || g(rawType, false);
        if (z || z2) {
            return new TypeAdapter<T>() { // from class: com.google.gson.internal.Excluder.1
                private TypeAdapter<T> a;

                private TypeAdapter<T> j() {
                    TypeAdapter<T> typeAdapter = this.a;
                    if (typeAdapter != 0) {
                        return typeAdapter;
                    }
                    TypeAdapter<T> r = gson.r(Excluder.this, aVar);
                    this.a = r;
                    return r;
                }

                /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Object] */
                @Override // com.google.gson.TypeAdapter
                public T e(e.j.e.u.a aVar2) throws IOException {
                    if (z2) {
                        aVar2.M0();
                        return null;
                    }
                    return j().e(aVar2);
                }

                @Override // com.google.gson.TypeAdapter
                public void i(c cVar, T t) throws IOException {
                    if (z) {
                        cVar.Y();
                    } else {
                        j().i(cVar, t);
                    }
                }
            };
        }
        return null;
    }

    /* renamed from: b */
    public Excluder clone() {
        try {
            return (Excluder) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public Excluder c() {
        Excluder clone = clone();
        clone.f3190c = false;
        return clone;
    }

    public boolean e(Class<?> cls, boolean z) {
        return f(cls) || g(cls, z);
    }

    public boolean h(Field field, boolean z) {
        e.j.e.r.a aVar;
        if ((this.b & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.a == f3188g || p((d) field.getAnnotation(d.class), (e) field.getAnnotation(e.class))) && !field.isSynthetic()) {
            if (!this.f3191d || ((aVar = (e.j.e.r.a) field.getAnnotation(e.j.e.r.a.class)) != null && (!z ? !aVar.deserialize() : !aVar.serialize()))) {
                if ((this.f3190c || !l(field.getType())) && !k(field.getType())) {
                    List<a> list = z ? this.f3192e : this.f3193f;
                    if (list.isEmpty()) {
                        return false;
                    }
                    b bVar = new b(field);
                    for (a aVar2 : list) {
                        if (aVar2.a(bVar)) {
                            return true;
                        }
                    }
                    return false;
                }
                return true;
            }
            return true;
        }
        return true;
    }

    public Excluder j() {
        Excluder clone = clone();
        clone.f3191d = true;
        return clone;
    }

    public Excluder q(a aVar, boolean z, boolean z2) {
        Excluder clone = clone();
        if (z) {
            ArrayList arrayList = new ArrayList(this.f3192e);
            clone.f3192e = arrayList;
            arrayList.add(aVar);
        }
        if (z2) {
            ArrayList arrayList2 = new ArrayList(this.f3193f);
            clone.f3193f = arrayList2;
            arrayList2.add(aVar);
        }
        return clone;
    }

    public Excluder r(int... iArr) {
        Excluder clone = clone();
        clone.b = 0;
        for (int i2 : iArr) {
            clone.b = i2 | clone.b;
        }
        return clone;
    }

    public Excluder s(double d2) {
        Excluder clone = clone();
        clone.a = d2;
        return clone;
    }
}
