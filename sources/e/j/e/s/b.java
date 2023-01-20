package e.j.e.s;

import com.google.gson.InstanceCreator;
import com.google.gson.JsonIOException;
import com.google.gson.internal.LinkedTreeMap;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/* loaded from: classes2.dex */
public final class b {
    private final Map<Type, InstanceCreator<?>> a;
    private final boolean b;

    /* loaded from: classes2.dex */
    public class a implements e.j.e.s.f<T> {
        public final /* synthetic */ Type a;

        public a(Type type) {
            this.a = type;
        }

        /* JADX WARN: Type inference failed for: r1v7, types: [T, java.util.EnumMap] */
        @Override // e.j.e.s.f
        public T a() {
            Type type = this.a;
            if (type instanceof ParameterizedType) {
                Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                if (type2 instanceof Class) {
                    return new EnumMap((Class) type2);
                }
                throw new JsonIOException("Invalid EnumMap type: " + this.a.toString());
            }
            throw new JsonIOException("Invalid EnumMap type: " + this.a.toString());
        }
    }

    /* renamed from: e.j.e.s.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0376b implements e.j.e.s.f<T> {
        public C0376b() {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.util.concurrent.ConcurrentSkipListMap, T] */
        @Override // e.j.e.s.f
        public T a() {
            return new ConcurrentSkipListMap();
        }
    }

    /* loaded from: classes2.dex */
    public class c implements e.j.e.s.f<T> {
        public c() {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [T, java.util.concurrent.ConcurrentHashMap] */
        @Override // e.j.e.s.f
        public T a() {
            return new ConcurrentHashMap();
        }
    }

    /* loaded from: classes2.dex */
    public class d implements e.j.e.s.f<T> {
        public d() {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.util.TreeMap, T] */
        @Override // e.j.e.s.f
        public T a() {
            return new TreeMap();
        }
    }

    /* loaded from: classes2.dex */
    public class e implements e.j.e.s.f<T> {
        public e() {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.util.LinkedHashMap, T] */
        @Override // e.j.e.s.f
        public T a() {
            return new LinkedHashMap();
        }
    }

    /* loaded from: classes2.dex */
    public class f implements e.j.e.s.f<T> {
        public f() {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [T, com.google.gson.internal.LinkedTreeMap] */
        @Override // e.j.e.s.f
        public T a() {
            return new LinkedTreeMap();
        }
    }

    /* loaded from: classes2.dex */
    public class g implements e.j.e.s.f<T> {
        private final e.j.e.s.j a = e.j.e.s.j.b();
        public final /* synthetic */ Class b;

        public g(Class cls) {
            this.b = cls;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.Object] */
        @Override // e.j.e.s.f
        public T a() {
            try {
                return this.a.c(this.b);
            } catch (Exception e2) {
                throw new RuntimeException("Unable to create instance of " + this.b + ". Registering an InstanceCreator or a TypeAdapter for this type, or adding a no-args constructor may fix this problem.", e2);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class h implements e.j.e.s.f<T> {
        public final /* synthetic */ String a;

        public h(String str) {
            this.a = str;
        }

        @Override // e.j.e.s.f
        public T a() {
            throw new JsonIOException(this.a);
        }
    }

    /* loaded from: classes2.dex */
    public class i implements e.j.e.s.f<T> {
        public final /* synthetic */ InstanceCreator a;
        public final /* synthetic */ Type b;

        public i(InstanceCreator instanceCreator, Type type) {
            this.a = instanceCreator;
            this.b = type;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
        @Override // e.j.e.s.f
        public T a() {
            return this.a.createInstance(this.b);
        }
    }

    /* loaded from: classes2.dex */
    public class j implements e.j.e.s.f<T> {
        public final /* synthetic */ InstanceCreator a;
        public final /* synthetic */ Type b;

        public j(InstanceCreator instanceCreator, Type type) {
            this.a = instanceCreator;
            this.b = type;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
        @Override // e.j.e.s.f
        public T a() {
            return this.a.createInstance(this.b);
        }
    }

    /* loaded from: classes2.dex */
    public class k implements e.j.e.s.f<T> {
        public final /* synthetic */ String a;

        public k(String str) {
            this.a = str;
        }

        @Override // e.j.e.s.f
        public T a() {
            throw new JsonIOException(this.a);
        }
    }

    /* loaded from: classes2.dex */
    public class l implements e.j.e.s.f<T> {
        public final /* synthetic */ Constructor a;

        public l(Constructor constructor) {
            this.a = constructor;
        }

        /* JADX WARN: Type inference failed for: r0v6, types: [T, java.lang.Object] */
        @Override // e.j.e.s.f
        public T a() {
            try {
                return this.a.newInstance(new Object[0]);
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException("Failed to invoke " + this.a + " with no args", e3);
            } catch (InvocationTargetException e4) {
                throw new RuntimeException("Failed to invoke " + this.a + " with no args", e4.getTargetException());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class m implements e.j.e.s.f<T> {
        public m() {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [T, java.util.TreeSet] */
        @Override // e.j.e.s.f
        public T a() {
            return new TreeSet();
        }
    }

    /* loaded from: classes2.dex */
    public class n implements e.j.e.s.f<T> {
        public final /* synthetic */ Type a;

        public n(Type type) {
            this.a = type;
        }

        /* JADX WARN: Type inference failed for: r0v7, types: [T, java.util.EnumSet] */
        @Override // e.j.e.s.f
        public T a() {
            Type type = this.a;
            if (type instanceof ParameterizedType) {
                Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                if (type2 instanceof Class) {
                    return EnumSet.noneOf((Class) type2);
                }
                throw new JsonIOException("Invalid EnumSet type: " + this.a.toString());
            }
            throw new JsonIOException("Invalid EnumSet type: " + this.a.toString());
        }
    }

    /* loaded from: classes2.dex */
    public class o implements e.j.e.s.f<T> {
        public o() {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [T, java.util.LinkedHashSet] */
        @Override // e.j.e.s.f
        public T a() {
            return new LinkedHashSet();
        }
    }

    /* loaded from: classes2.dex */
    public class p implements e.j.e.s.f<T> {
        public p() {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [T, java.util.ArrayDeque] */
        @Override // e.j.e.s.f
        public T a() {
            return new ArrayDeque();
        }
    }

    /* loaded from: classes2.dex */
    public class q implements e.j.e.s.f<T> {
        public q() {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [T, java.util.ArrayList] */
        @Override // e.j.e.s.f
        public T a() {
            return new ArrayList();
        }
    }

    public b(Map<Type, InstanceCreator<?>> map, boolean z) {
        this.a = map;
        this.b = z;
    }

    private <T> e.j.e.s.f<T> b(Class<? super T> cls) {
        if (Modifier.isAbstract(cls.getModifiers())) {
            return null;
        }
        try {
            Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            String c2 = e.j.e.s.l.a.c(declaredConstructor);
            if (c2 != null) {
                return new k(c2);
            }
            return new l(declaredConstructor);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private <T> e.j.e.s.f<T> c(Type type, Class<? super T> cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            if (SortedSet.class.isAssignableFrom(cls)) {
                return new m();
            }
            if (EnumSet.class.isAssignableFrom(cls)) {
                return new n(type);
            }
            if (Set.class.isAssignableFrom(cls)) {
                return new o();
            }
            if (Queue.class.isAssignableFrom(cls)) {
                return new p();
            }
            return new q();
        } else if (Map.class.isAssignableFrom(cls)) {
            if (cls == EnumMap.class) {
                return new a(type);
            }
            if (ConcurrentNavigableMap.class.isAssignableFrom(cls)) {
                return new C0376b();
            }
            if (ConcurrentMap.class.isAssignableFrom(cls)) {
                return new c();
            }
            if (SortedMap.class.isAssignableFrom(cls)) {
                return new d();
            }
            if ((type instanceof ParameterizedType) && !String.class.isAssignableFrom(e.j.e.t.a.get(((ParameterizedType) type).getActualTypeArguments()[0]).getRawType())) {
                return new e();
            }
            return new f();
        } else {
            return null;
        }
    }

    private <T> e.j.e.s.f<T> d(Class<? super T> cls) {
        if (this.b) {
            return new g(cls);
        }
        return new h("Unable to create instance of " + cls + "; usage of JDK Unsafe is disabled. Registering an InstanceCreator or a TypeAdapter for this type, adding a no-args constructor, or enabling usage of JDK Unsafe may fix this problem.");
    }

    public <T> e.j.e.s.f<T> a(e.j.e.t.a<T> aVar) {
        Type type = aVar.getType();
        Class<? super T> rawType = aVar.getRawType();
        InstanceCreator<?> instanceCreator = this.a.get(type);
        if (instanceCreator != null) {
            return new i(instanceCreator, type);
        }
        InstanceCreator<?> instanceCreator2 = this.a.get(rawType);
        if (instanceCreator2 != null) {
            return new j(instanceCreator2, type);
        }
        e.j.e.s.f<T> b = b(rawType);
        if (b != null) {
            return b;
        }
        e.j.e.s.f<T> c2 = c(type, rawType);
        return c2 != null ? c2 : d(rawType);
    }

    public String toString() {
        return this.a.toString();
    }
}
