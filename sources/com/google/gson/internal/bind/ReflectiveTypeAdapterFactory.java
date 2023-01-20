package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.Excluder;
import com.google.gson.stream.JsonToken;
import e.j.e.c;
import e.j.e.q;
import e.j.e.s.f;
import e.j.e.s.h;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class ReflectiveTypeAdapterFactory implements q {
    private final e.j.e.s.b a;
    private final c b;

    /* renamed from: c  reason: collision with root package name */
    private final Excluder f3213c;

    /* renamed from: d  reason: collision with root package name */
    private final JsonAdapterAnnotationTypeAdapterFactory f3214d;

    /* loaded from: classes2.dex */
    public static final class Adapter<T> extends TypeAdapter<T> {
        private final f<T> a;
        private final Map<String, b> b;

        public Adapter(f<T> fVar, Map<String, b> map) {
            this.a = fVar;
            this.b = map;
        }

        @Override // com.google.gson.TypeAdapter
        public T e(e.j.e.u.a aVar) throws IOException {
            if (aVar.C0() == JsonToken.NULL) {
                aVar.x0();
                return null;
            }
            T a = this.a.a();
            try {
                aVar.k();
                while (aVar.H()) {
                    b bVar = this.b.get(aVar.o0());
                    if (bVar != null && bVar.f3222c) {
                        bVar.a(aVar, a);
                    }
                    aVar.M0();
                }
                aVar.r();
                return a;
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            } catch (IllegalStateException e3) {
                throw new JsonSyntaxException(e3);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void i(e.j.e.u.c cVar, T t) throws IOException {
            if (t == null) {
                cVar.Y();
                return;
            }
            cVar.n();
            try {
                for (b bVar : this.b.values()) {
                    if (bVar.c(t)) {
                        cVar.M(bVar.a);
                        bVar.b(cVar, t);
                    }
                }
                cVar.r();
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class a extends b {

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Field f3215d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f3216e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TypeAdapter f3217f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Gson f3218g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e.j.e.t.a f3219h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ boolean f3220i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, boolean z, boolean z2, Field field, boolean z3, TypeAdapter typeAdapter, Gson gson, e.j.e.t.a aVar, boolean z4) {
            super(str, z, z2);
            this.f3215d = field;
            this.f3216e = z3;
            this.f3217f = typeAdapter;
            this.f3218g = gson;
            this.f3219h = aVar;
            this.f3220i = z4;
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.b
        public void a(e.j.e.u.a aVar, Object obj) throws IOException, IllegalAccessException {
            Object e2 = this.f3217f.e(aVar);
            if (e2 == null && this.f3220i) {
                return;
            }
            this.f3215d.set(obj, e2);
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.b
        public void b(e.j.e.u.c cVar, Object obj) throws IOException, IllegalAccessException {
            (this.f3216e ? this.f3217f : new TypeAdapterRuntimeTypeWrapper(this.f3218g, this.f3217f, this.f3219h.getType())).i(cVar, this.f3215d.get(obj));
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.b
        public boolean c(Object obj) throws IOException, IllegalAccessException {
            return this.b && this.f3215d.get(obj) != obj;
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class b {
        public final String a;
        public final boolean b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f3222c;

        public b(String str, boolean z, boolean z2) {
            this.a = str;
            this.b = z;
            this.f3222c = z2;
        }

        public abstract void a(e.j.e.u.a aVar, Object obj) throws IOException, IllegalAccessException;

        public abstract void b(e.j.e.u.c cVar, Object obj) throws IOException, IllegalAccessException;

        public abstract boolean c(Object obj) throws IOException, IllegalAccessException;
    }

    public ReflectiveTypeAdapterFactory(e.j.e.s.b bVar, c cVar, Excluder excluder, JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory) {
        this.a = bVar;
        this.b = cVar;
        this.f3213c = excluder;
        this.f3214d = jsonAdapterAnnotationTypeAdapterFactory;
    }

    private b b(Gson gson, Field field, String str, e.j.e.t.a<?> aVar, boolean z, boolean z2) {
        boolean a2 = h.a(aVar.getRawType());
        e.j.e.r.b bVar = (e.j.e.r.b) field.getAnnotation(e.j.e.r.b.class);
        TypeAdapter<?> b2 = bVar != null ? this.f3214d.b(this.a, gson, aVar, bVar) : null;
        boolean z3 = b2 != null;
        if (b2 == null) {
            b2 = gson.p(aVar);
        }
        return new a(str, z, z2, field, z3, b2, gson, aVar, a2);
    }

    public static boolean d(Field field, boolean z, Excluder excluder) {
        return (excluder.e(field.getType(), z) || excluder.h(field, z)) ? false : true;
    }

    private Map<String, b> e(Gson gson, e.j.e.t.a<?> aVar, Class<?> cls) {
        b bVar;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type type = aVar.getType();
        e.j.e.t.a<?> aVar2 = aVar;
        Class<?> cls2 = cls;
        while (cls2 != Object.class) {
            Field[] declaredFields = cls2.getDeclaredFields();
            int length = declaredFields.length;
            boolean z = false;
            int i2 = 0;
            while (i2 < length) {
                Field field = declaredFields[i2];
                boolean c2 = c(field, true);
                boolean c3 = c(field, z);
                if (c2 || c3) {
                    e.j.e.s.l.a.b(field);
                    Type p = C$Gson$Types.p(aVar2.getType(), cls2, field.getGenericType());
                    List<String> f2 = f(field);
                    int size = f2.size();
                    b bVar2 = null;
                    int i3 = 0;
                    while (i3 < size) {
                        String str = f2.get(i3);
                        boolean z2 = i3 != 0 ? false : c2;
                        int i4 = i3;
                        b bVar3 = bVar2;
                        int i5 = size;
                        List<String> list = f2;
                        Field field2 = field;
                        bVar2 = bVar3 == null ? (b) linkedHashMap.put(str, b(gson, field, str, e.j.e.t.a.get(p), z2, c3)) : bVar3;
                        i3 = i4 + 1;
                        c2 = z2;
                        f2 = list;
                        size = i5;
                        field = field2;
                    }
                    if (bVar2 != null) {
                        throw new IllegalArgumentException(type + " declares multiple JSON fields named " + bVar.a);
                    }
                }
                i2++;
                z = false;
            }
            aVar2 = e.j.e.t.a.get(C$Gson$Types.p(aVar2.getType(), cls2, cls2.getGenericSuperclass()));
            cls2 = aVar2.getRawType();
        }
        return linkedHashMap;
    }

    private List<String> f(Field field) {
        e.j.e.r.c cVar = (e.j.e.r.c) field.getAnnotation(e.j.e.r.c.class);
        if (cVar == null) {
            return Collections.singletonList(this.b.translateName(field));
        }
        String value = cVar.value();
        String[] alternate = cVar.alternate();
        if (alternate.length == 0) {
            return Collections.singletonList(value);
        }
        ArrayList arrayList = new ArrayList(alternate.length + 1);
        arrayList.add(value);
        for (String str : alternate) {
            arrayList.add(str);
        }
        return arrayList;
    }

    @Override // e.j.e.q
    public <T> TypeAdapter<T> a(Gson gson, e.j.e.t.a<T> aVar) {
        Class<? super T> rawType = aVar.getRawType();
        if (Object.class.isAssignableFrom(rawType)) {
            return new Adapter(this.a.a(aVar), e(gson, aVar, rawType));
        }
        return null;
    }

    public boolean c(Field field, boolean z) {
        return d(field, z, this.f3213c);
    }
}
