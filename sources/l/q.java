package l;

import com.qiniu.android.http.request.Request;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import l.n;
import l.y.x;
import l.y.y;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;

/* loaded from: classes4.dex */
public final class q {
    private final Method a;
    private final HttpUrl b;

    /* renamed from: c  reason: collision with root package name */
    public final String f17076c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final String f17077d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private final Headers f17078e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private final MediaType f17079f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f17080g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f17081h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f17082i;

    /* renamed from: j  reason: collision with root package name */
    private final n<?>[] f17083j;

    /* renamed from: k  reason: collision with root package name */
    public final boolean f17084k;

    /* loaded from: classes4.dex */
    public static final class a {
        public final s a;
        public final Method b;

        /* renamed from: c  reason: collision with root package name */
        public final Annotation[] f17085c;

        /* renamed from: d  reason: collision with root package name */
        public final Annotation[][] f17086d;

        /* renamed from: e  reason: collision with root package name */
        public final Type[] f17087e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f17088f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f17089g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f17090h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f17091i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f17092j;

        /* renamed from: k  reason: collision with root package name */
        public boolean f17093k;

        /* renamed from: l  reason: collision with root package name */
        public boolean f17094l;

        /* renamed from: m  reason: collision with root package name */
        public boolean f17095m;
        @Nullable
        public String n;
        public boolean o;
        public boolean p;
        public boolean q;
        @Nullable
        public String r;
        @Nullable
        public Headers s;
        @Nullable
        public MediaType t;
        @Nullable
        public Set<String> u;
        @Nullable
        public n<?>[] v;
        public boolean w;
        private static final Pattern y = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");
        private static final String x = "[a-zA-Z][a-zA-Z0-9_-]*";
        private static final Pattern z = Pattern.compile(x);

        public a(s sVar, Method method) {
            this.a = sVar;
            this.b = method;
            this.f17085c = method.getAnnotations();
            this.f17087e = method.getGenericParameterTypes();
            this.f17086d = method.getParameterAnnotations();
        }

        private static Class<?> a(Class<?> cls) {
            return Boolean.TYPE == cls ? Boolean.class : Byte.TYPE == cls ? Byte.class : Character.TYPE == cls ? Character.class : Double.TYPE == cls ? Double.class : Float.TYPE == cls ? Float.class : Integer.TYPE == cls ? Integer.class : Long.TYPE == cls ? Long.class : Short.TYPE == cls ? Short.class : cls;
        }

        private Headers c(String[] strArr) {
            Headers.Builder builder = new Headers.Builder();
            for (String str : strArr) {
                int indexOf = str.indexOf(58);
                if (indexOf == -1 || indexOf == 0 || indexOf == str.length() - 1) {
                    throw w.m(this.b, "@Headers value must be in the form \"Name: Value\". Found: \"%s\"", str);
                }
                String substring = str.substring(0, indexOf);
                String trim = str.substring(indexOf + 1).trim();
                if ("Content-Type".equalsIgnoreCase(substring)) {
                    try {
                        this.t = MediaType.get(trim);
                    } catch (IllegalArgumentException e2) {
                        throw w.n(this.b, e2, "Malformed content type: %s", trim);
                    }
                } else {
                    builder.add(substring, trim);
                }
            }
            return builder.build();
        }

        private void d(String str, String str2, boolean z2) {
            String str3 = this.n;
            if (str3 != null) {
                throw w.m(this.b, "Only one HTTP method is allowed. Found: %s and %s.", str3, str);
            }
            this.n = str;
            this.o = z2;
            if (str2.isEmpty()) {
                return;
            }
            int indexOf = str2.indexOf(63);
            if (indexOf != -1 && indexOf < str2.length() - 1) {
                String substring = str2.substring(indexOf + 1);
                if (y.matcher(substring).find()) {
                    throw w.m(this.b, "URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", substring);
                }
            }
            this.r = str2;
            this.u = h(str2);
        }

        private void e(Annotation annotation) {
            if (annotation instanceof l.y.b) {
                d("DELETE", ((l.y.b) annotation).value(), false);
            } else if (annotation instanceof l.y.f) {
                d("GET", ((l.y.f) annotation).value(), false);
            } else if (annotation instanceof l.y.g) {
                d(Request.HttpMethodHEAD, ((l.y.g) annotation).value(), false);
            } else if (annotation instanceof l.y.n) {
                d("PATCH", ((l.y.n) annotation).value(), true);
            } else if (annotation instanceof l.y.o) {
                d("POST", ((l.y.o) annotation).value(), true);
            } else if (annotation instanceof l.y.p) {
                d(Request.HttpMethodPUT, ((l.y.p) annotation).value(), true);
            } else if (annotation instanceof l.y.m) {
                d("OPTIONS", ((l.y.m) annotation).value(), false);
            } else if (annotation instanceof l.y.h) {
                l.y.h hVar = (l.y.h) annotation;
                d(hVar.method(), hVar.path(), hVar.hasBody());
            } else if (annotation instanceof l.y.k) {
                String[] value = ((l.y.k) annotation).value();
                if (value.length != 0) {
                    this.s = c(value);
                    return;
                }
                throw w.m(this.b, "@Headers annotation is empty.", new Object[0]);
            } else if (annotation instanceof l.y.l) {
                if (!this.p) {
                    this.q = true;
                    return;
                }
                throw w.m(this.b, "Only one encoding annotation is allowed.", new Object[0]);
            } else if (annotation instanceof l.y.e) {
                if (!this.q) {
                    this.p = true;
                    return;
                }
                throw w.m(this.b, "Only one encoding annotation is allowed.", new Object[0]);
            }
        }

        @Nullable
        private n<?> f(int i2, Type type, @Nullable Annotation[] annotationArr, boolean z2) {
            n<?> nVar;
            if (annotationArr != null) {
                nVar = null;
                for (Annotation annotation : annotationArr) {
                    n<?> g2 = g(i2, type, annotationArr, annotation);
                    if (g2 != null) {
                        if (nVar != null) {
                            throw w.o(this.b, i2, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
                        }
                        nVar = g2;
                    }
                }
            } else {
                nVar = null;
            }
            if (nVar == null) {
                if (z2) {
                    try {
                        if (w.h(type) == h.e2.c.class) {
                            this.w = true;
                            return null;
                        }
                    } catch (NoClassDefFoundError unused) {
                    }
                }
                throw w.o(this.b, i2, "No Retrofit annotation found.", new Object[0]);
            }
            return nVar;
        }

        @Nullable
        private n<?> g(int i2, Type type, Annotation[] annotationArr, Annotation annotation) {
            if (annotation instanceof y) {
                j(i2, type);
                if (!this.f17095m) {
                    if (!this.f17091i) {
                        if (!this.f17092j) {
                            if (!this.f17093k) {
                                if (!this.f17094l) {
                                    if (this.r == null) {
                                        this.f17095m = true;
                                        if (type != HttpUrl.class && type != String.class && type != URI.class && (!(type instanceof Class) || !"android.net.Uri".equals(((Class) type).getName()))) {
                                            throw w.o(this.b, i2, "@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type.", new Object[0]);
                                        }
                                        return new n.p(this.b, i2);
                                    }
                                    throw w.o(this.b, i2, "@Url cannot be used with @%s URL", this.n);
                                }
                                throw w.o(this.b, i2, "A @Url parameter must not come after a @QueryMap.", new Object[0]);
                            }
                            throw w.o(this.b, i2, "A @Url parameter must not come after a @QueryName.", new Object[0]);
                        }
                        throw w.o(this.b, i2, "A @Url parameter must not come after a @Query.", new Object[0]);
                    }
                    throw w.o(this.b, i2, "@Path parameters may not be used with @Url.", new Object[0]);
                }
                throw w.o(this.b, i2, "Multiple @Url method annotations found.", new Object[0]);
            } else if (annotation instanceof l.y.s) {
                j(i2, type);
                if (!this.f17092j) {
                    if (!this.f17093k) {
                        if (!this.f17094l) {
                            if (!this.f17095m) {
                                if (this.r != null) {
                                    this.f17091i = true;
                                    l.y.s sVar = (l.y.s) annotation;
                                    String value = sVar.value();
                                    i(i2, value);
                                    return new n.k(this.b, i2, value, this.a.o(type, annotationArr), sVar.encoded());
                                }
                                throw w.o(this.b, i2, "@Path can only be used with relative url on @%s", this.n);
                            }
                            throw w.o(this.b, i2, "@Path parameters may not be used with @Url.", new Object[0]);
                        }
                        throw w.o(this.b, i2, "A @Path parameter must not come after a @QueryMap.", new Object[0]);
                    }
                    throw w.o(this.b, i2, "A @Path parameter must not come after a @QueryName.", new Object[0]);
                }
                throw w.o(this.b, i2, "A @Path parameter must not come after a @Query.", new Object[0]);
            } else if (annotation instanceof l.y.t) {
                j(i2, type);
                l.y.t tVar = (l.y.t) annotation;
                String value2 = tVar.value();
                boolean encoded = tVar.encoded();
                Class<?> h2 = w.h(type);
                this.f17092j = true;
                if (Iterable.class.isAssignableFrom(h2)) {
                    if (type instanceof ParameterizedType) {
                        return new n.l(value2, this.a.o(w.g(0, (ParameterizedType) type), annotationArr), encoded).c();
                    }
                    throw w.o(this.b, i2, h2.getSimpleName() + " must include generic type (e.g., " + h2.getSimpleName() + "<String>)", new Object[0]);
                } else if (h2.isArray()) {
                    return new n.l(value2, this.a.o(a(h2.getComponentType()), annotationArr), encoded).b();
                } else {
                    return new n.l(value2, this.a.o(type, annotationArr), encoded);
                }
            } else if (annotation instanceof l.y.v) {
                j(i2, type);
                boolean encoded2 = ((l.y.v) annotation).encoded();
                Class<?> h3 = w.h(type);
                this.f17093k = true;
                if (Iterable.class.isAssignableFrom(h3)) {
                    if (type instanceof ParameterizedType) {
                        return new n.C0506n(this.a.o(w.g(0, (ParameterizedType) type), annotationArr), encoded2).c();
                    }
                    throw w.o(this.b, i2, h3.getSimpleName() + " must include generic type (e.g., " + h3.getSimpleName() + "<String>)", new Object[0]);
                } else if (h3.isArray()) {
                    return new n.C0506n(this.a.o(a(h3.getComponentType()), annotationArr), encoded2).b();
                } else {
                    return new n.C0506n(this.a.o(type, annotationArr), encoded2);
                }
            } else if (annotation instanceof l.y.u) {
                j(i2, type);
                Class<?> h4 = w.h(type);
                this.f17094l = true;
                if (Map.class.isAssignableFrom(h4)) {
                    Type i3 = w.i(type, h4, Map.class);
                    if (i3 instanceof ParameterizedType) {
                        ParameterizedType parameterizedType = (ParameterizedType) i3;
                        Type g2 = w.g(0, parameterizedType);
                        if (String.class == g2) {
                            return new n.m(this.b, i2, this.a.o(w.g(1, parameterizedType), annotationArr), ((l.y.u) annotation).encoded());
                        }
                        throw w.o(this.b, i2, "@QueryMap keys must be of type String: " + g2, new Object[0]);
                    }
                    throw w.o(this.b, i2, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                throw w.o(this.b, i2, "@QueryMap parameter type must be Map.", new Object[0]);
            } else if (annotation instanceof l.y.i) {
                j(i2, type);
                String value3 = ((l.y.i) annotation).value();
                Class<?> h5 = w.h(type);
                if (Iterable.class.isAssignableFrom(h5)) {
                    if (type instanceof ParameterizedType) {
                        return new n.f(value3, this.a.o(w.g(0, (ParameterizedType) type), annotationArr)).c();
                    }
                    throw w.o(this.b, i2, h5.getSimpleName() + " must include generic type (e.g., " + h5.getSimpleName() + "<String>)", new Object[0]);
                } else if (h5.isArray()) {
                    return new n.f(value3, this.a.o(a(h5.getComponentType()), annotationArr)).b();
                } else {
                    return new n.f(value3, this.a.o(type, annotationArr));
                }
            } else if (annotation instanceof l.y.j) {
                if (type == Headers.class) {
                    return new n.h(this.b, i2);
                }
                j(i2, type);
                Class<?> h6 = w.h(type);
                if (Map.class.isAssignableFrom(h6)) {
                    Type i4 = w.i(type, h6, Map.class);
                    if (i4 instanceof ParameterizedType) {
                        ParameterizedType parameterizedType2 = (ParameterizedType) i4;
                        Type g3 = w.g(0, parameterizedType2);
                        if (String.class == g3) {
                            return new n.g(this.b, i2, this.a.o(w.g(1, parameterizedType2), annotationArr));
                        }
                        throw w.o(this.b, i2, "@HeaderMap keys must be of type String: " + g3, new Object[0]);
                    }
                    throw w.o(this.b, i2, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                throw w.o(this.b, i2, "@HeaderMap parameter type must be Map.", new Object[0]);
            } else if (annotation instanceof l.y.c) {
                j(i2, type);
                if (this.p) {
                    l.y.c cVar = (l.y.c) annotation;
                    String value4 = cVar.value();
                    boolean encoded3 = cVar.encoded();
                    this.f17088f = true;
                    Class<?> h7 = w.h(type);
                    if (Iterable.class.isAssignableFrom(h7)) {
                        if (type instanceof ParameterizedType) {
                            return new n.d(value4, this.a.o(w.g(0, (ParameterizedType) type), annotationArr), encoded3).c();
                        }
                        throw w.o(this.b, i2, h7.getSimpleName() + " must include generic type (e.g., " + h7.getSimpleName() + "<String>)", new Object[0]);
                    } else if (h7.isArray()) {
                        return new n.d(value4, this.a.o(a(h7.getComponentType()), annotationArr), encoded3).b();
                    } else {
                        return new n.d(value4, this.a.o(type, annotationArr), encoded3);
                    }
                }
                throw w.o(this.b, i2, "@Field parameters can only be used with form encoding.", new Object[0]);
            } else if (annotation instanceof l.y.d) {
                j(i2, type);
                if (this.p) {
                    Class<?> h8 = w.h(type);
                    if (Map.class.isAssignableFrom(h8)) {
                        Type i5 = w.i(type, h8, Map.class);
                        if (i5 instanceof ParameterizedType) {
                            ParameterizedType parameterizedType3 = (ParameterizedType) i5;
                            Type g4 = w.g(0, parameterizedType3);
                            if (String.class == g4) {
                                h o = this.a.o(w.g(1, parameterizedType3), annotationArr);
                                this.f17088f = true;
                                return new n.e(this.b, i2, o, ((l.y.d) annotation).encoded());
                            }
                            throw w.o(this.b, i2, "@FieldMap keys must be of type String: " + g4, new Object[0]);
                        }
                        throw w.o(this.b, i2, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                    }
                    throw w.o(this.b, i2, "@FieldMap parameter type must be Map.", new Object[0]);
                }
                throw w.o(this.b, i2, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
            } else if (annotation instanceof l.y.q) {
                j(i2, type);
                if (this.q) {
                    l.y.q qVar = (l.y.q) annotation;
                    this.f17089g = true;
                    String value5 = qVar.value();
                    Class<?> h9 = w.h(type);
                    if (value5.isEmpty()) {
                        if (Iterable.class.isAssignableFrom(h9)) {
                            if (type instanceof ParameterizedType) {
                                if (MultipartBody.Part.class.isAssignableFrom(w.h(w.g(0, (ParameterizedType) type)))) {
                                    return n.o.a.c();
                                }
                                throw w.o(this.b, i2, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                            }
                            throw w.o(this.b, i2, h9.getSimpleName() + " must include generic type (e.g., " + h9.getSimpleName() + "<String>)", new Object[0]);
                        } else if (h9.isArray()) {
                            if (MultipartBody.Part.class.isAssignableFrom(h9.getComponentType())) {
                                return n.o.a.b();
                            }
                            throw w.o(this.b, i2, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                        } else if (MultipartBody.Part.class.isAssignableFrom(h9)) {
                            return n.o.a;
                        } else {
                            throw w.o(this.b, i2, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                        }
                    }
                    Headers of = Headers.of("Content-Disposition", "form-data; name=\"" + value5 + "\"", "Content-Transfer-Encoding", qVar.encoding());
                    if (Iterable.class.isAssignableFrom(h9)) {
                        if (type instanceof ParameterizedType) {
                            Type g5 = w.g(0, (ParameterizedType) type);
                            if (!MultipartBody.Part.class.isAssignableFrom(w.h(g5))) {
                                return new n.i(this.b, i2, of, this.a.m(g5, annotationArr, this.f17085c)).c();
                            }
                            throw w.o(this.b, i2, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                        }
                        throw w.o(this.b, i2, h9.getSimpleName() + " must include generic type (e.g., " + h9.getSimpleName() + "<String>)", new Object[0]);
                    } else if (h9.isArray()) {
                        Class<?> a = a(h9.getComponentType());
                        if (!MultipartBody.Part.class.isAssignableFrom(a)) {
                            return new n.i(this.b, i2, of, this.a.m(a, annotationArr, this.f17085c)).b();
                        }
                        throw w.o(this.b, i2, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                    } else if (!MultipartBody.Part.class.isAssignableFrom(h9)) {
                        return new n.i(this.b, i2, of, this.a.m(type, annotationArr, this.f17085c));
                    } else {
                        throw w.o(this.b, i2, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                    }
                }
                throw w.o(this.b, i2, "@Part parameters can only be used with multipart encoding.", new Object[0]);
            } else if (annotation instanceof l.y.r) {
                j(i2, type);
                if (this.q) {
                    this.f17089g = true;
                    Class<?> h10 = w.h(type);
                    if (Map.class.isAssignableFrom(h10)) {
                        Type i6 = w.i(type, h10, Map.class);
                        if (i6 instanceof ParameterizedType) {
                            ParameterizedType parameterizedType4 = (ParameterizedType) i6;
                            Type g6 = w.g(0, parameterizedType4);
                            if (String.class == g6) {
                                Type g7 = w.g(1, parameterizedType4);
                                if (!MultipartBody.Part.class.isAssignableFrom(w.h(g7))) {
                                    return new n.j(this.b, i2, this.a.m(g7, annotationArr, this.f17085c), ((l.y.r) annotation).encoding());
                                }
                                throw w.o(this.b, i2, "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead.", new Object[0]);
                            }
                            throw w.o(this.b, i2, "@PartMap keys must be of type String: " + g6, new Object[0]);
                        }
                        throw w.o(this.b, i2, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                    }
                    throw w.o(this.b, i2, "@PartMap parameter type must be Map.", new Object[0]);
                }
                throw w.o(this.b, i2, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
            } else if (annotation instanceof l.y.a) {
                j(i2, type);
                if (!this.p && !this.q) {
                    if (!this.f17090h) {
                        try {
                            h m2 = this.a.m(type, annotationArr, this.f17085c);
                            this.f17090h = true;
                            return new n.c(this.b, i2, m2);
                        } catch (RuntimeException e2) {
                            throw w.p(this.b, e2, i2, "Unable to create @Body converter for %s", type);
                        }
                    }
                    throw w.o(this.b, i2, "Multiple @Body method annotations found.", new Object[0]);
                }
                throw w.o(this.b, i2, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
            } else if (annotation instanceof x) {
                j(i2, type);
                Class<?> h11 = w.h(type);
                for (int i7 = i2 - 1; i7 >= 0; i7--) {
                    n<?> nVar = this.v[i7];
                    if ((nVar instanceof n.q) && ((n.q) nVar).a.equals(h11)) {
                        throw w.o(this.b, i2, "@Tag type " + h11.getName() + " is duplicate of parameter #" + (i7 + 1) + " and would always overwrite its value.", new Object[0]);
                    }
                }
                return new n.q(h11);
            } else {
                return null;
            }
        }

        public static Set<String> h(String str) {
            Matcher matcher = y.matcher(str);
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            while (matcher.find()) {
                linkedHashSet.add(matcher.group(1));
            }
            return linkedHashSet;
        }

        private void i(int i2, String str) {
            if (z.matcher(str).matches()) {
                if (!this.u.contains(str)) {
                    throw w.o(this.b, i2, "URL \"%s\" does not contain \"{%s}\".", this.r, str);
                }
                return;
            }
            throw w.o(this.b, i2, "@Path parameter name must match %s. Found: %s", y.pattern(), str);
        }

        private void j(int i2, Type type) {
            if (w.j(type)) {
                throw w.o(this.b, i2, "Parameter type must not include a type variable or wildcard: %s", type);
            }
        }

        public q b() {
            for (Annotation annotation : this.f17085c) {
                e(annotation);
            }
            if (this.n != null) {
                if (!this.o) {
                    if (!this.q) {
                        if (this.p) {
                            throw w.m(this.b, "FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                        }
                    } else {
                        throw w.m(this.b, "Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                    }
                }
                int length = this.f17086d.length;
                this.v = new n[length];
                int i2 = length - 1;
                int i3 = 0;
                while (true) {
                    boolean z2 = true;
                    if (i3 >= length) {
                        break;
                    }
                    n<?>[] nVarArr = this.v;
                    Type type = this.f17087e[i3];
                    Annotation[] annotationArr = this.f17086d[i3];
                    if (i3 != i2) {
                        z2 = false;
                    }
                    nVarArr[i3] = f(i3, type, annotationArr, z2);
                    i3++;
                }
                if (this.r != null || this.f17095m) {
                    boolean z3 = this.p;
                    if (!z3 && !this.q && !this.o && this.f17090h) {
                        throw w.m(this.b, "Non-body HTTP method cannot contain @Body.", new Object[0]);
                    }
                    if (z3 && !this.f17088f) {
                        throw w.m(this.b, "Form-encoded method must contain at least one @Field.", new Object[0]);
                    }
                    if (this.q && !this.f17089g) {
                        throw w.m(this.b, "Multipart method must contain at least one @Part.", new Object[0]);
                    }
                    return new q(this);
                }
                throw w.m(this.b, "Missing either @%s URL or @Url parameter.", this.n);
            }
            throw w.m(this.b, "HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
        }
    }

    public q(a aVar) {
        this.a = aVar.b;
        this.b = aVar.a.f17097c;
        this.f17076c = aVar.n;
        this.f17077d = aVar.r;
        this.f17078e = aVar.s;
        this.f17079f = aVar.t;
        this.f17080g = aVar.o;
        this.f17081h = aVar.p;
        this.f17082i = aVar.q;
        this.f17083j = aVar.v;
        this.f17084k = aVar.w;
    }

    public static q b(s sVar, Method method) {
        return new a(sVar, method).b();
    }

    public okhttp3.Request a(Object[] objArr) throws IOException {
        n<?>[] nVarArr = this.f17083j;
        int length = objArr.length;
        if (length == nVarArr.length) {
            p pVar = new p(this.f17076c, this.b, this.f17077d, this.f17078e, this.f17079f, this.f17080g, this.f17081h, this.f17082i);
            if (this.f17084k) {
                length--;
            }
            ArrayList arrayList = new ArrayList(length);
            for (int i2 = 0; i2 < length; i2++) {
                arrayList.add(objArr[i2]);
                nVarArr[i2].a(pVar, objArr[i2]);
            }
            return pVar.k().tag(k.class, new k(this.a, arrayList)).build();
        }
        throw new IllegalArgumentException("Argument count (" + length + ") doesn't match expected count (" + nVarArr.length + ")");
    }
}
