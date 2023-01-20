package com.google.gson;

import com.google.gson.internal.Excluder;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.internal.bind.ArrayTypeAdapter;
import com.google.gson.internal.bind.CollectionTypeAdapterFactory;
import com.google.gson.internal.bind.DateTypeAdapter;
import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import com.google.gson.internal.bind.MapTypeAdapterFactory;
import com.google.gson.internal.bind.NumberTypeAdapter;
import com.google.gson.internal.bind.ObjectTypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import e.j.e.c;
import e.j.e.d;
import e.j.e.h;
import e.j.e.p;
import e.j.e.q;
import e.j.e.s.b;
import e.j.e.s.i;
import e.j.e.t.a;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* loaded from: classes2.dex */
public final class Gson {
    public static final boolean A = false;
    public static final boolean B = true;
    public static final boolean C = false;
    public static final boolean D = false;
    public static final boolean E = false;
    public static final boolean F = true;
    public static final String G = null;
    public static final c H = FieldNamingPolicy.IDENTITY;
    public static final p I = ToNumberPolicy.DOUBLE;
    public static final p J = ToNumberPolicy.LAZILY_PARSED_NUMBER;
    private static final a<?> K = a.get(Object.class);
    private static final String L = ")]}'\n";
    public static final boolean y = false;
    public static final boolean z = false;
    private final ThreadLocal<Map<a<?>, FutureTypeAdapter<?>>> a;
    private final Map<a<?>, TypeAdapter<?>> b;

    /* renamed from: c */
    private final b f3177c;

    /* renamed from: d */
    private final JsonAdapterAnnotationTypeAdapterFactory f3178d;

    /* renamed from: e */
    public final List<q> f3179e;

    /* renamed from: f */
    public final Excluder f3180f;

    /* renamed from: g */
    public final c f3181g;

    /* renamed from: h */
    public final Map<Type, InstanceCreator<?>> f3182h;

    /* renamed from: i */
    public final boolean f3183i;

    /* renamed from: j */
    public final boolean f3184j;

    /* renamed from: k */
    public final boolean f3185k;

    /* renamed from: l */
    public final boolean f3186l;

    /* renamed from: m */
    public final boolean f3187m;
    public final boolean n;
    public final boolean o;
    public final boolean p;
    public final String q;
    public final int r;
    public final int s;
    public final LongSerializationPolicy t;
    public final List<q> u;
    public final List<q> v;
    public final p w;
    public final p x;

    /* loaded from: classes2.dex */
    public static class FutureTypeAdapter<T> extends TypeAdapter<T> {
        private TypeAdapter<T> a;

        @Override // com.google.gson.TypeAdapter
        public T e(e.j.e.u.a aVar) throws IOException {
            TypeAdapter<T> typeAdapter = this.a;
            if (typeAdapter != null) {
                return typeAdapter.e(aVar);
            }
            throw new IllegalStateException();
        }

        @Override // com.google.gson.TypeAdapter
        public void i(e.j.e.u.c cVar, T t) throws IOException {
            TypeAdapter<T> typeAdapter = this.a;
            if (typeAdapter != null) {
                typeAdapter.i(cVar, t);
                return;
            }
            throw new IllegalStateException();
        }

        public void j(TypeAdapter<T> typeAdapter) {
            if (this.a == null) {
                this.a = typeAdapter;
                return;
            }
            throw new AssertionError();
        }
    }

    public Gson() {
        this(Excluder.f3189h, H, Collections.emptyMap(), false, false, false, true, false, false, false, true, LongSerializationPolicy.DEFAULT, G, 2, 2, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), I, J);
    }

    private static void a(Object obj, e.j.e.u.a aVar) {
        if (obj != null) {
            try {
                if (aVar.C0() == JsonToken.END_DOCUMENT) {
                    return;
                }
                throw new JsonIOException("JSON document was not fully consumed.");
            } catch (MalformedJsonException e2) {
                throw new JsonSyntaxException(e2);
            } catch (IOException e3) {
                throw new JsonIOException(e3);
            }
        }
    }

    private static TypeAdapter<AtomicLong> b(final TypeAdapter<Number> typeAdapter) {
        return new TypeAdapter<AtomicLong>() { // from class: com.google.gson.Gson.4
            @Override // com.google.gson.TypeAdapter
            /* renamed from: j */
            public AtomicLong e(e.j.e.u.a aVar) throws IOException {
                return new AtomicLong(((Number) typeAdapter.e(aVar)).longValue());
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: k */
            public void i(e.j.e.u.c cVar, AtomicLong atomicLong) throws IOException {
                typeAdapter.i(cVar, Long.valueOf(atomicLong.get()));
            }
        }.d();
    }

    private static TypeAdapter<AtomicLongArray> c(final TypeAdapter<Number> typeAdapter) {
        return new TypeAdapter<AtomicLongArray>() { // from class: com.google.gson.Gson.5
            @Override // com.google.gson.TypeAdapter
            /* renamed from: j */
            public AtomicLongArray e(e.j.e.u.a aVar) throws IOException {
                ArrayList arrayList = new ArrayList();
                aVar.j();
                while (aVar.H()) {
                    arrayList.add(Long.valueOf(((Number) typeAdapter.e(aVar)).longValue()));
                }
                aVar.q();
                int size = arrayList.size();
                AtomicLongArray atomicLongArray = new AtomicLongArray(size);
                for (int i2 = 0; i2 < size; i2++) {
                    atomicLongArray.set(i2, ((Long) arrayList.get(i2)).longValue());
                }
                return atomicLongArray;
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: k */
            public void i(e.j.e.u.c cVar, AtomicLongArray atomicLongArray) throws IOException {
                cVar.l();
                int length = atomicLongArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    typeAdapter.i(cVar, Long.valueOf(atomicLongArray.get(i2)));
                }
                cVar.q();
            }
        }.d();
    }

    public static void d(double d2) {
        if (Double.isNaN(d2) || Double.isInfinite(d2)) {
            throw new IllegalArgumentException(d2 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private TypeAdapter<Number> e(boolean z2) {
        if (z2) {
            return TypeAdapters.v;
        }
        return new TypeAdapter<Number>() { // from class: com.google.gson.Gson.1
            {
                Gson.this = this;
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: j */
            public Double e(e.j.e.u.a aVar) throws IOException {
                if (aVar.C0() == JsonToken.NULL) {
                    aVar.x0();
                    return null;
                }
                return Double.valueOf(aVar.c0());
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: k */
            public void i(e.j.e.u.c cVar, Number number) throws IOException {
                if (number == null) {
                    cVar.Y();
                    return;
                }
                Gson.d(number.doubleValue());
                cVar.F0(number);
            }
        };
    }

    private TypeAdapter<Number> h(boolean z2) {
        if (z2) {
            return TypeAdapters.u;
        }
        return new TypeAdapter<Number>() { // from class: com.google.gson.Gson.2
            {
                Gson.this = this;
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: j */
            public Float e(e.j.e.u.a aVar) throws IOException {
                if (aVar.C0() == JsonToken.NULL) {
                    aVar.x0();
                    return null;
                }
                return Float.valueOf((float) aVar.c0());
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: k */
            public void i(e.j.e.u.c cVar, Number number) throws IOException {
                if (number == null) {
                    cVar.Y();
                    return;
                }
                Gson.d(number.floatValue());
                cVar.F0(number);
            }
        };
    }

    private static TypeAdapter<Number> t(LongSerializationPolicy longSerializationPolicy) {
        if (longSerializationPolicy == LongSerializationPolicy.DEFAULT) {
            return TypeAdapters.t;
        }
        return new TypeAdapter<Number>() { // from class: com.google.gson.Gson.3
            @Override // com.google.gson.TypeAdapter
            /* renamed from: j */
            public Number e(e.j.e.u.a aVar) throws IOException {
                if (aVar.C0() == JsonToken.NULL) {
                    aVar.x0();
                    return null;
                }
                return Long.valueOf(aVar.m0());
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: k */
            public void i(e.j.e.u.c cVar, Number number) throws IOException {
                if (number == null) {
                    cVar.Y();
                } else {
                    cVar.G0(number.toString());
                }
            }
        };
    }

    public String A(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        F(obj, type, stringWriter);
        return stringWriter.toString();
    }

    public void B(h hVar, e.j.e.u.c cVar) throws JsonIOException {
        boolean F2 = cVar.F();
        cVar.z0(true);
        boolean t = cVar.t();
        cVar.u0(this.f3186l);
        boolean s = cVar.s();
        cVar.A0(this.f3183i);
        try {
            try {
                i.b(hVar, cVar);
            } catch (IOException e2) {
                throw new JsonIOException(e2);
            } catch (AssertionError e3) {
                AssertionError assertionError = new AssertionError("AssertionError (GSON 2.9.0): " + e3.getMessage());
                assertionError.initCause(e3);
                throw assertionError;
            }
        } finally {
            cVar.z0(F2);
            cVar.u0(t);
            cVar.A0(s);
        }
    }

    public void C(h hVar, Appendable appendable) throws JsonIOException {
        try {
            B(hVar, w(i.c(appendable)));
        } catch (IOException e2) {
            throw new JsonIOException(e2);
        }
    }

    public void D(Object obj, Appendable appendable) throws JsonIOException {
        if (obj != null) {
            F(obj, obj.getClass(), appendable);
        } else {
            C(e.j.e.i.a, appendable);
        }
    }

    public void E(Object obj, Type type, e.j.e.u.c cVar) throws JsonIOException {
        TypeAdapter p = p(a.get(type));
        boolean F2 = cVar.F();
        cVar.z0(true);
        boolean t = cVar.t();
        cVar.u0(this.f3186l);
        boolean s = cVar.s();
        cVar.A0(this.f3183i);
        try {
            try {
                p.i(cVar, obj);
            } catch (IOException e2) {
                throw new JsonIOException(e2);
            } catch (AssertionError e3) {
                AssertionError assertionError = new AssertionError("AssertionError (GSON 2.9.0): " + e3.getMessage());
                assertionError.initCause(e3);
                throw assertionError;
            }
        } finally {
            cVar.z0(F2);
            cVar.u0(t);
            cVar.A0(s);
        }
    }

    public void F(Object obj, Type type, Appendable appendable) throws JsonIOException {
        try {
            E(obj, type, w(i.c(appendable)));
        } catch (IOException e2) {
            throw new JsonIOException(e2);
        }
    }

    public h G(Object obj) {
        if (obj == null) {
            return e.j.e.i.a;
        }
        return H(obj, obj.getClass());
    }

    public h H(Object obj, Type type) {
        e.j.e.s.k.b bVar = new e.j.e.s.k.b();
        E(obj, type, bVar);
        return bVar.J0();
    }

    @Deprecated
    public Excluder f() {
        return this.f3180f;
    }

    public c g() {
        return this.f3181g;
    }

    public <T> T i(h hVar, Class<T> cls) throws JsonSyntaxException {
        return (T) e.j.e.s.h.d(cls).cast(j(hVar, cls));
    }

    public <T> T j(h hVar, Type type) throws JsonSyntaxException {
        if (hVar == null) {
            return null;
        }
        return (T) k(new e.j.e.s.k.a(hVar), type);
    }

    public <T> T k(e.j.e.u.a aVar, Type type) throws JsonIOException, JsonSyntaxException {
        boolean J2 = aVar.J();
        boolean z2 = true;
        aVar.H0(true);
        try {
            try {
                try {
                    aVar.C0();
                    z2 = false;
                    T e2 = p(a.get(type)).e(aVar);
                    aVar.H0(J2);
                    return e2;
                } catch (EOFException e3) {
                    if (z2) {
                        aVar.H0(J2);
                        return null;
                    }
                    throw new JsonSyntaxException(e3);
                } catch (IOException e4) {
                    throw new JsonSyntaxException(e4);
                }
            } catch (AssertionError e5) {
                AssertionError assertionError = new AssertionError("AssertionError (GSON 2.9.0): " + e5.getMessage());
                assertionError.initCause(e5);
                throw assertionError;
            } catch (IllegalStateException e6) {
                throw new JsonSyntaxException(e6);
            }
        } catch (Throwable th) {
            aVar.H0(J2);
            throw th;
        }
    }

    public <T> T l(Reader reader, Class<T> cls) throws JsonSyntaxException, JsonIOException {
        e.j.e.u.a v = v(reader);
        Object k2 = k(v, cls);
        a(k2, v);
        return (T) e.j.e.s.h.d(cls).cast(k2);
    }

    public <T> T m(Reader reader, Type type) throws JsonIOException, JsonSyntaxException {
        e.j.e.u.a v = v(reader);
        T t = (T) k(v, type);
        a(t, v);
        return t;
    }

    public <T> T n(String str, Class<T> cls) throws JsonSyntaxException {
        return (T) e.j.e.s.h.d(cls).cast(o(str, cls));
    }

    public <T> T o(String str, Type type) throws JsonSyntaxException {
        if (str == null) {
            return null;
        }
        return (T) m(new StringReader(str), type);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> TypeAdapter<T> p(a<T> aVar) {
        TypeAdapter<T> typeAdapter = (TypeAdapter<T>) this.b.get(aVar == null ? K : aVar);
        if (typeAdapter != null) {
            return typeAdapter;
        }
        Map<a<?>, FutureTypeAdapter<?>> map = this.a.get();
        boolean z2 = false;
        if (map == null) {
            map = new HashMap<>();
            this.a.set(map);
            z2 = true;
        }
        FutureTypeAdapter<?> futureTypeAdapter = map.get(aVar);
        if (futureTypeAdapter != null) {
            return futureTypeAdapter;
        }
        try {
            FutureTypeAdapter<?> futureTypeAdapter2 = new FutureTypeAdapter<>();
            map.put(aVar, futureTypeAdapter2);
            for (q qVar : this.f3179e) {
                TypeAdapter typeAdapter2 = (TypeAdapter<T>) qVar.a(this, aVar);
                if (typeAdapter2 != null) {
                    futureTypeAdapter2.j(typeAdapter2);
                    this.b.put(aVar, typeAdapter2);
                    return typeAdapter2;
                }
            }
            throw new IllegalArgumentException("GSON (2.9.0) cannot handle " + aVar);
        } finally {
            map.remove(aVar);
            if (z2) {
                this.a.remove();
            }
        }
    }

    public <T> TypeAdapter<T> q(Class<T> cls) {
        return p(a.get((Class) cls));
    }

    public <T> TypeAdapter<T> r(q qVar, a<T> aVar) {
        if (!this.f3179e.contains(qVar)) {
            qVar = this.f3178d;
        }
        boolean z2 = false;
        for (q qVar2 : this.f3179e) {
            if (z2) {
                TypeAdapter<T> a = qVar2.a(this, aVar);
                if (a != null) {
                    return a;
                }
            } else if (qVar2 == qVar) {
                z2 = true;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + aVar);
    }

    public boolean s() {
        return this.f3186l;
    }

    public String toString() {
        return "{serializeNulls:" + this.f3183i + ",factories:" + this.f3179e + ",instanceCreators:" + this.f3177c + "}";
    }

    public d u() {
        return new d(this);
    }

    public e.j.e.u.a v(Reader reader) {
        e.j.e.u.a aVar = new e.j.e.u.a(reader);
        aVar.H0(this.n);
        return aVar;
    }

    public e.j.e.u.c w(Writer writer) throws IOException {
        if (this.f3185k) {
            writer.write(L);
        }
        e.j.e.u.c cVar = new e.j.e.u.c(writer);
        if (this.f3187m) {
            cVar.x0("  ");
        }
        cVar.u0(this.f3186l);
        cVar.z0(this.n);
        cVar.A0(this.f3183i);
        return cVar;
    }

    public boolean x() {
        return this.f3183i;
    }

    public String y(h hVar) {
        StringWriter stringWriter = new StringWriter();
        C(hVar, stringWriter);
        return stringWriter.toString();
    }

    public String z(Object obj) {
        if (obj == null) {
            return y(e.j.e.i.a);
        }
        return A(obj, obj.getClass());
    }

    public Gson(Excluder excluder, c cVar, Map<Type, InstanceCreator<?>> map, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, LongSerializationPolicy longSerializationPolicy, String str, int i2, int i3, List<q> list, List<q> list2, List<q> list3, p pVar, p pVar2) {
        this.a = new ThreadLocal<>();
        this.b = new ConcurrentHashMap();
        this.f3180f = excluder;
        this.f3181g = cVar;
        this.f3182h = map;
        b bVar = new b(map, z9);
        this.f3177c = bVar;
        this.f3183i = z2;
        this.f3184j = z3;
        this.f3185k = z4;
        this.f3186l = z5;
        this.f3187m = z6;
        this.n = z7;
        this.o = z8;
        this.p = z9;
        this.t = longSerializationPolicy;
        this.q = str;
        this.r = i2;
        this.s = i3;
        this.u = list;
        this.v = list2;
        this.w = pVar;
        this.x = pVar2;
        ArrayList arrayList = new ArrayList();
        arrayList.add(TypeAdapters.W);
        arrayList.add(ObjectTypeAdapter.j(pVar));
        arrayList.add(excluder);
        arrayList.addAll(list3);
        arrayList.add(TypeAdapters.C);
        arrayList.add(TypeAdapters.f3242m);
        arrayList.add(TypeAdapters.f3236g);
        arrayList.add(TypeAdapters.f3238i);
        arrayList.add(TypeAdapters.f3240k);
        TypeAdapter<Number> t = t(longSerializationPolicy);
        arrayList.add(TypeAdapters.c(Long.TYPE, Long.class, t));
        arrayList.add(TypeAdapters.c(Double.TYPE, Double.class, e(z8)));
        arrayList.add(TypeAdapters.c(Float.TYPE, Float.class, h(z8)));
        arrayList.add(NumberTypeAdapter.j(pVar2));
        arrayList.add(TypeAdapters.o);
        arrayList.add(TypeAdapters.q);
        arrayList.add(TypeAdapters.b(AtomicLong.class, b(t)));
        arrayList.add(TypeAdapters.b(AtomicLongArray.class, c(t)));
        arrayList.add(TypeAdapters.s);
        arrayList.add(TypeAdapters.x);
        arrayList.add(TypeAdapters.E);
        arrayList.add(TypeAdapters.G);
        arrayList.add(TypeAdapters.b(BigDecimal.class, TypeAdapters.z));
        arrayList.add(TypeAdapters.b(BigInteger.class, TypeAdapters.A));
        arrayList.add(TypeAdapters.b(LazilyParsedNumber.class, TypeAdapters.B));
        arrayList.add(TypeAdapters.I);
        arrayList.add(TypeAdapters.K);
        arrayList.add(TypeAdapters.O);
        arrayList.add(TypeAdapters.Q);
        arrayList.add(TypeAdapters.U);
        arrayList.add(TypeAdapters.M);
        arrayList.add(TypeAdapters.f3233d);
        arrayList.add(DateTypeAdapter.b);
        arrayList.add(TypeAdapters.S);
        if (e.j.e.s.m.a.a) {
            arrayList.add(e.j.e.s.m.a.f11300e);
            arrayList.add(e.j.e.s.m.a.f11299d);
            arrayList.add(e.j.e.s.m.a.f11301f);
        }
        arrayList.add(ArrayTypeAdapter.f3208c);
        arrayList.add(TypeAdapters.b);
        arrayList.add(new CollectionTypeAdapterFactory(bVar));
        arrayList.add(new MapTypeAdapterFactory(bVar, z3));
        JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory = new JsonAdapterAnnotationTypeAdapterFactory(bVar);
        this.f3178d = jsonAdapterAnnotationTypeAdapterFactory;
        arrayList.add(jsonAdapterAnnotationTypeAdapterFactory);
        arrayList.add(TypeAdapters.X);
        arrayList.add(new ReflectiveTypeAdapterFactory(bVar, cVar, excluder, jsonAdapterAnnotationTypeAdapterFactory));
        this.f3179e = Collections.unmodifiableList(arrayList);
    }
}
