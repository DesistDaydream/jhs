package l;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import l.c;
import l.e;
import l.h;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/* loaded from: classes4.dex */
public final class s {
    private final Map<Method, t<?>> a = new ConcurrentHashMap();
    public final Call.Factory b;

    /* renamed from: c  reason: collision with root package name */
    public final HttpUrl f17097c;

    /* renamed from: d  reason: collision with root package name */
    public final List<h.a> f17098d;

    /* renamed from: e  reason: collision with root package name */
    public final List<e.a> f17099e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public final Executor f17100f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f17101g;

    /* loaded from: classes4.dex */
    public class a implements InvocationHandler {
        private final o a = o.g();
        private final Object[] b = new Object[0];

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Class f17102c;

        public a(Class cls) {
            this.f17102c = cls;
        }

        @Override // java.lang.reflect.InvocationHandler
        @Nullable
        public Object invoke(Object obj, Method method, @Nullable Object[] objArr) throws Throwable {
            if (method.getDeclaringClass() == Object.class) {
                return method.invoke(this, objArr);
            }
            if (objArr == null) {
                objArr = this.b;
            }
            if (this.a.i(method)) {
                return this.a.h(method, this.f17102c, obj, objArr);
            }
            return s.this.h(method).a(objArr);
        }
    }

    public s(Call.Factory factory, HttpUrl httpUrl, List<h.a> list, List<e.a> list2, @Nullable Executor executor, boolean z) {
        this.b = factory;
        this.f17097c = httpUrl;
        this.f17098d = list;
        this.f17099e = list2;
        this.f17100f = executor;
        this.f17101g = z;
    }

    private void p(Class<?> cls) {
        Method[] declaredMethods;
        if (cls.isInterface()) {
            ArrayDeque arrayDeque = new ArrayDeque(1);
            arrayDeque.add(cls);
            while (!arrayDeque.isEmpty()) {
                Class<?> cls2 = (Class) arrayDeque.removeFirst();
                if (cls2.getTypeParameters().length != 0) {
                    StringBuilder sb = new StringBuilder("Type parameters are unsupported on ");
                    sb.append(cls2.getName());
                    if (cls2 != cls) {
                        sb.append(" which is an interface of ");
                        sb.append(cls.getName());
                    }
                    throw new IllegalArgumentException(sb.toString());
                }
                Collections.addAll(arrayDeque, cls2.getInterfaces());
            }
            if (this.f17101g) {
                o g2 = o.g();
                for (Method method : cls.getDeclaredMethods()) {
                    if (!g2.i(method) && !Modifier.isStatic(method.getModifiers())) {
                        h(method);
                    }
                }
                return;
            }
            return;
        }
        throw new IllegalArgumentException("API declarations must be interfaces.");
    }

    public HttpUrl a() {
        return this.f17097c;
    }

    public e<?, ?> b(Type type, Annotation[] annotationArr) {
        return j(null, type, annotationArr);
    }

    public List<e.a> c() {
        return this.f17099e;
    }

    public Call.Factory d() {
        return this.b;
    }

    @Nullable
    public Executor e() {
        return this.f17100f;
    }

    public List<h.a> f() {
        return this.f17098d;
    }

    public <T> T g(Class<T> cls) {
        p(cls);
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new a(cls));
    }

    public t<?> h(Method method) {
        t<?> tVar;
        t<?> tVar2 = this.a.get(method);
        if (tVar2 != null) {
            return tVar2;
        }
        synchronized (this.a) {
            tVar = this.a.get(method);
            if (tVar == null) {
                tVar = t.b(this, method);
                this.a.put(method, tVar);
            }
        }
        return tVar;
    }

    public b i() {
        return new b(this);
    }

    public e<?, ?> j(@Nullable e.a aVar, Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "returnType == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        int indexOf = this.f17099e.indexOf(aVar) + 1;
        int size = this.f17099e.size();
        for (int i2 = indexOf; i2 < size; i2++) {
            e<?, ?> eVar = this.f17099e.get(i2).get(type, annotationArr, this);
            if (eVar != null) {
                return eVar;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate call adapter for ");
        sb.append(type);
        sb.append(".\n");
        if (aVar != null) {
            sb.append("  Skipped:");
            for (int i3 = 0; i3 < indexOf; i3++) {
                sb.append("\n   * ");
                sb.append(this.f17099e.get(i3).getClass().getName());
            }
            sb.append('\n');
        }
        sb.append("  Tried:");
        int size2 = this.f17099e.size();
        while (indexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.f17099e.get(indexOf).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public <T> h<T, RequestBody> k(@Nullable h.a aVar, Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "parameterAnnotations == null");
        Objects.requireNonNull(annotationArr2, "methodAnnotations == null");
        int indexOf = this.f17098d.indexOf(aVar) + 1;
        int size = this.f17098d.size();
        for (int i2 = indexOf; i2 < size; i2++) {
            h<T, RequestBody> hVar = (h<T, RequestBody>) this.f17098d.get(i2).c(type, annotationArr, annotationArr2, this);
            if (hVar != null) {
                return hVar;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate RequestBody converter for ");
        sb.append(type);
        sb.append(".\n");
        if (aVar != null) {
            sb.append("  Skipped:");
            for (int i3 = 0; i3 < indexOf; i3++) {
                sb.append("\n   * ");
                sb.append(this.f17098d.get(i3).getClass().getName());
            }
            sb.append('\n');
        }
        sb.append("  Tried:");
        int size2 = this.f17098d.size();
        while (indexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.f17098d.get(indexOf).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public <T> h<ResponseBody, T> l(@Nullable h.a aVar, Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        int indexOf = this.f17098d.indexOf(aVar) + 1;
        int size = this.f17098d.size();
        for (int i2 = indexOf; i2 < size; i2++) {
            h<ResponseBody, T> hVar = (h<ResponseBody, T>) this.f17098d.get(i2).d(type, annotationArr, this);
            if (hVar != null) {
                return hVar;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate ResponseBody converter for ");
        sb.append(type);
        sb.append(".\n");
        if (aVar != null) {
            sb.append("  Skipped:");
            for (int i3 = 0; i3 < indexOf; i3++) {
                sb.append("\n   * ");
                sb.append(this.f17098d.get(i3).getClass().getName());
            }
            sb.append('\n');
        }
        sb.append("  Tried:");
        int size2 = this.f17098d.size();
        while (indexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.f17098d.get(indexOf).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public <T> h<T, RequestBody> m(Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        return k(null, type, annotationArr, annotationArr2);
    }

    public <T> h<ResponseBody, T> n(Type type, Annotation[] annotationArr) {
        return l(null, type, annotationArr);
    }

    public <T> h<T, String> o(Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        int size = this.f17098d.size();
        for (int i2 = 0; i2 < size; i2++) {
            h<T, String> hVar = (h<T, String>) this.f17098d.get(i2).e(type, annotationArr, this);
            if (hVar != null) {
                return hVar;
            }
        }
        return c.d.a;
    }

    /* loaded from: classes4.dex */
    public static final class b {
        private final o a;
        @Nullable
        private Call.Factory b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        private HttpUrl f17104c;

        /* renamed from: d  reason: collision with root package name */
        private final List<h.a> f17105d;

        /* renamed from: e  reason: collision with root package name */
        private final List<e.a> f17106e;
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        private Executor f17107f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f17108g;

        public b(o oVar) {
            this.f17105d = new ArrayList();
            this.f17106e = new ArrayList();
            this.a = oVar;
        }

        public b a(e.a aVar) {
            List<e.a> list = this.f17106e;
            Objects.requireNonNull(aVar, "factory == null");
            list.add(aVar);
            return this;
        }

        public b b(h.a aVar) {
            List<h.a> list = this.f17105d;
            Objects.requireNonNull(aVar, "factory == null");
            list.add(aVar);
            return this;
        }

        public b c(String str) {
            Objects.requireNonNull(str, "baseUrl == null");
            return e(HttpUrl.get(str));
        }

        public b d(URL url) {
            Objects.requireNonNull(url, "baseUrl == null");
            return e(HttpUrl.get(url.toString()));
        }

        public b e(HttpUrl httpUrl) {
            Objects.requireNonNull(httpUrl, "baseUrl == null");
            List<String> pathSegments = httpUrl.pathSegments();
            if ("".equals(pathSegments.get(pathSegments.size() - 1))) {
                this.f17104c = httpUrl;
                return this;
            }
            throw new IllegalArgumentException("baseUrl must end in /: " + httpUrl);
        }

        public s f() {
            if (this.f17104c != null) {
                Call.Factory factory = this.b;
                if (factory == null) {
                    factory = new OkHttpClient();
                }
                Call.Factory factory2 = factory;
                Executor executor = this.f17107f;
                if (executor == null) {
                    executor = this.a.c();
                }
                Executor executor2 = executor;
                ArrayList arrayList = new ArrayList(this.f17106e);
                arrayList.addAll(this.a.a(executor2));
                ArrayList arrayList2 = new ArrayList(this.f17105d.size() + 1 + this.a.e());
                arrayList2.add(new c());
                arrayList2.addAll(this.f17105d);
                arrayList2.addAll(this.a.d());
                return new s(factory2, this.f17104c, Collections.unmodifiableList(arrayList2), Collections.unmodifiableList(arrayList), executor2, this.f17108g);
            }
            throw new IllegalStateException("Base URL required.");
        }

        public List<e.a> g() {
            return this.f17106e;
        }

        public b h(Call.Factory factory) {
            Objects.requireNonNull(factory, "factory == null");
            this.b = factory;
            return this;
        }

        public b i(Executor executor) {
            Objects.requireNonNull(executor, "executor == null");
            this.f17107f = executor;
            return this;
        }

        public b j(OkHttpClient okHttpClient) {
            Objects.requireNonNull(okHttpClient, "client == null");
            return h(okHttpClient);
        }

        public List<h.a> k() {
            return this.f17105d;
        }

        public b l(boolean z) {
            this.f17108g = z;
            return this;
        }

        public b() {
            this(o.g());
        }

        public b(s sVar) {
            this.f17105d = new ArrayList();
            this.f17106e = new ArrayList();
            o g2 = o.g();
            this.a = g2;
            this.b = sVar.b;
            this.f17104c = sVar.f17097c;
            int size = sVar.f17098d.size() - g2.e();
            for (int i2 = 1; i2 < size; i2++) {
                this.f17105d.add(sVar.f17098d.get(i2));
            }
            int size2 = sVar.f17099e.size() - this.a.b();
            for (int i3 = 0; i3 < size2; i3++) {
                this.f17106e.add(sVar.f17099e.get(i3));
            }
            this.f17107f = sVar.f17100f;
            this.f17108g = sVar.f17101g;
        }
    }
}
