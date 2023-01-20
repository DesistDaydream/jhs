package l;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/* loaded from: classes4.dex */
public abstract class n<T> {

    /* loaded from: classes4.dex */
    public class a extends n<Iterable<T>> {
        public a() {
        }

        @Override // l.n
        /* renamed from: d */
        public void a(l.p pVar, @Nullable Iterable<T> iterable) throws IOException {
            if (iterable == null) {
                return;
            }
            for (T t : iterable) {
                n.this.a(pVar, t);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends n<Object> {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // l.n
        public void a(l.p pVar, @Nullable Object obj) throws IOException {
            if (obj == null) {
                return;
            }
            int length = Array.getLength(obj);
            for (int i2 = 0; i2 < length; i2++) {
                n.this.a(pVar, Array.get(obj, i2));
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class c<T> extends n<T> {
        private final Method a;
        private final int b;

        /* renamed from: c  reason: collision with root package name */
        private final l.h<T, RequestBody> f17049c;

        public c(Method method, int i2, l.h<T, RequestBody> hVar) {
            this.a = method;
            this.b = i2;
            this.f17049c = hVar;
        }

        @Override // l.n
        public void a(l.p pVar, @Nullable T t) {
            if (t != null) {
                try {
                    pVar.l(this.f17049c.convert(t));
                    return;
                } catch (IOException e2) {
                    Method method = this.a;
                    int i2 = this.b;
                    throw w.p(method, e2, i2, "Unable to convert " + t + " to RequestBody", new Object[0]);
                }
            }
            throw w.o(this.a, this.b, "Body parameter value must not be null.", new Object[0]);
        }
    }

    /* loaded from: classes4.dex */
    public static final class d<T> extends n<T> {
        private final String a;
        private final l.h<T, String> b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f17050c;

        public d(String str, l.h<T, String> hVar, boolean z) {
            Objects.requireNonNull(str, "name == null");
            this.a = str;
            this.b = hVar;
            this.f17050c = z;
        }

        @Override // l.n
        public void a(l.p pVar, @Nullable T t) throws IOException {
            String convert;
            if (t == null || (convert = this.b.convert(t)) == null) {
                return;
            }
            pVar.a(this.a, convert, this.f17050c);
        }
    }

    /* loaded from: classes4.dex */
    public static final class e<T> extends n<Map<String, T>> {
        private final Method a;
        private final int b;

        /* renamed from: c  reason: collision with root package name */
        private final l.h<T, String> f17051c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f17052d;

        public e(Method method, int i2, l.h<T, String> hVar, boolean z) {
            this.a = method;
            this.b = i2;
            this.f17051c = hVar;
            this.f17052d = z;
        }

        @Override // l.n
        /* renamed from: d */
        public void a(l.p pVar, @Nullable Map<String, T> map) throws IOException {
            if (map != null) {
                for (Map.Entry<String, T> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (key != null) {
                        T value = entry.getValue();
                        if (value != null) {
                            String convert = this.f17051c.convert(value);
                            if (convert != null) {
                                pVar.a(key, convert, this.f17052d);
                            } else {
                                Method method = this.a;
                                int i2 = this.b;
                                throw w.o(method, i2, "Field map value '" + value + "' converted to null by " + this.f17051c.getClass().getName() + " for key '" + key + "'.", new Object[0]);
                            }
                        } else {
                            Method method2 = this.a;
                            int i3 = this.b;
                            throw w.o(method2, i3, "Field map contained null value for key '" + key + "'.", new Object[0]);
                        }
                    } else {
                        throw w.o(this.a, this.b, "Field map contained null key.", new Object[0]);
                    }
                }
                return;
            }
            throw w.o(this.a, this.b, "Field map was null.", new Object[0]);
        }
    }

    /* loaded from: classes4.dex */
    public static final class f<T> extends n<T> {
        private final String a;
        private final l.h<T, String> b;

        public f(String str, l.h<T, String> hVar) {
            Objects.requireNonNull(str, "name == null");
            this.a = str;
            this.b = hVar;
        }

        @Override // l.n
        public void a(l.p pVar, @Nullable T t) throws IOException {
            String convert;
            if (t == null || (convert = this.b.convert(t)) == null) {
                return;
            }
            pVar.b(this.a, convert);
        }
    }

    /* loaded from: classes4.dex */
    public static final class g<T> extends n<Map<String, T>> {
        private final Method a;
        private final int b;

        /* renamed from: c  reason: collision with root package name */
        private final l.h<T, String> f17053c;

        public g(Method method, int i2, l.h<T, String> hVar) {
            this.a = method;
            this.b = i2;
            this.f17053c = hVar;
        }

        @Override // l.n
        /* renamed from: d */
        public void a(l.p pVar, @Nullable Map<String, T> map) throws IOException {
            if (map != null) {
                for (Map.Entry<String, T> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (key != null) {
                        T value = entry.getValue();
                        if (value != null) {
                            pVar.b(key, this.f17053c.convert(value));
                        } else {
                            Method method = this.a;
                            int i2 = this.b;
                            throw w.o(method, i2, "Header map contained null value for key '" + key + "'.", new Object[0]);
                        }
                    } else {
                        throw w.o(this.a, this.b, "Header map contained null key.", new Object[0]);
                    }
                }
                return;
            }
            throw w.o(this.a, this.b, "Header map was null.", new Object[0]);
        }
    }

    /* loaded from: classes4.dex */
    public static final class h extends n<Headers> {
        private final Method a;
        private final int b;

        public h(Method method, int i2) {
            this.a = method;
            this.b = i2;
        }

        @Override // l.n
        /* renamed from: d */
        public void a(l.p pVar, @Nullable Headers headers) {
            if (headers != null) {
                pVar.c(headers);
                return;
            }
            throw w.o(this.a, this.b, "Headers parameter must not be null.", new Object[0]);
        }
    }

    /* loaded from: classes4.dex */
    public static final class i<T> extends n<T> {
        private final Method a;
        private final int b;

        /* renamed from: c  reason: collision with root package name */
        private final Headers f17054c;

        /* renamed from: d  reason: collision with root package name */
        private final l.h<T, RequestBody> f17055d;

        public i(Method method, int i2, Headers headers, l.h<T, RequestBody> hVar) {
            this.a = method;
            this.b = i2;
            this.f17054c = headers;
            this.f17055d = hVar;
        }

        @Override // l.n
        public void a(l.p pVar, @Nullable T t) {
            if (t == null) {
                return;
            }
            try {
                pVar.d(this.f17054c, this.f17055d.convert(t));
            } catch (IOException e2) {
                Method method = this.a;
                int i2 = this.b;
                throw w.o(method, i2, "Unable to convert " + t + " to RequestBody", e2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class j<T> extends n<Map<String, T>> {
        private final Method a;
        private final int b;

        /* renamed from: c  reason: collision with root package name */
        private final l.h<T, RequestBody> f17056c;

        /* renamed from: d  reason: collision with root package name */
        private final String f17057d;

        public j(Method method, int i2, l.h<T, RequestBody> hVar, String str) {
            this.a = method;
            this.b = i2;
            this.f17056c = hVar;
            this.f17057d = str;
        }

        @Override // l.n
        /* renamed from: d */
        public void a(l.p pVar, @Nullable Map<String, T> map) throws IOException {
            if (map != null) {
                for (Map.Entry<String, T> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (key != null) {
                        T value = entry.getValue();
                        if (value != null) {
                            pVar.d(Headers.of("Content-Disposition", "form-data; name=\"" + key + "\"", "Content-Transfer-Encoding", this.f17057d), this.f17056c.convert(value));
                        } else {
                            Method method = this.a;
                            int i2 = this.b;
                            throw w.o(method, i2, "Part map contained null value for key '" + key + "'.", new Object[0]);
                        }
                    } else {
                        throw w.o(this.a, this.b, "Part map contained null key.", new Object[0]);
                    }
                }
                return;
            }
            throw w.o(this.a, this.b, "Part map was null.", new Object[0]);
        }
    }

    /* loaded from: classes4.dex */
    public static final class k<T> extends n<T> {
        private final Method a;
        private final int b;

        /* renamed from: c  reason: collision with root package name */
        private final String f17058c;

        /* renamed from: d  reason: collision with root package name */
        private final l.h<T, String> f17059d;

        /* renamed from: e  reason: collision with root package name */
        private final boolean f17060e;

        public k(Method method, int i2, String str, l.h<T, String> hVar, boolean z) {
            this.a = method;
            this.b = i2;
            Objects.requireNonNull(str, "name == null");
            this.f17058c = str;
            this.f17059d = hVar;
            this.f17060e = z;
        }

        @Override // l.n
        public void a(l.p pVar, @Nullable T t) throws IOException {
            if (t != null) {
                pVar.f(this.f17058c, this.f17059d.convert(t), this.f17060e);
                return;
            }
            Method method = this.a;
            int i2 = this.b;
            throw w.o(method, i2, "Path parameter \"" + this.f17058c + "\" value must not be null.", new Object[0]);
        }
    }

    /* loaded from: classes4.dex */
    public static final class l<T> extends n<T> {
        private final String a;
        private final l.h<T, String> b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f17061c;

        public l(String str, l.h<T, String> hVar, boolean z) {
            Objects.requireNonNull(str, "name == null");
            this.a = str;
            this.b = hVar;
            this.f17061c = z;
        }

        @Override // l.n
        public void a(l.p pVar, @Nullable T t) throws IOException {
            String convert;
            if (t == null || (convert = this.b.convert(t)) == null) {
                return;
            }
            pVar.g(this.a, convert, this.f17061c);
        }
    }

    /* loaded from: classes4.dex */
    public static final class m<T> extends n<Map<String, T>> {
        private final Method a;
        private final int b;

        /* renamed from: c  reason: collision with root package name */
        private final l.h<T, String> f17062c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f17063d;

        public m(Method method, int i2, l.h<T, String> hVar, boolean z) {
            this.a = method;
            this.b = i2;
            this.f17062c = hVar;
            this.f17063d = z;
        }

        @Override // l.n
        /* renamed from: d */
        public void a(l.p pVar, @Nullable Map<String, T> map) throws IOException {
            if (map != null) {
                for (Map.Entry<String, T> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (key != null) {
                        T value = entry.getValue();
                        if (value != null) {
                            String convert = this.f17062c.convert(value);
                            if (convert != null) {
                                pVar.g(key, convert, this.f17063d);
                            } else {
                                Method method = this.a;
                                int i2 = this.b;
                                throw w.o(method, i2, "Query map value '" + value + "' converted to null by " + this.f17062c.getClass().getName() + " for key '" + key + "'.", new Object[0]);
                            }
                        } else {
                            Method method2 = this.a;
                            int i3 = this.b;
                            throw w.o(method2, i3, "Query map contained null value for key '" + key + "'.", new Object[0]);
                        }
                    } else {
                        throw w.o(this.a, this.b, "Query map contained null key.", new Object[0]);
                    }
                }
                return;
            }
            throw w.o(this.a, this.b, "Query map was null", new Object[0]);
        }
    }

    /* renamed from: l.n$n  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C0506n<T> extends n<T> {
        private final l.h<T, String> a;
        private final boolean b;

        public C0506n(l.h<T, String> hVar, boolean z) {
            this.a = hVar;
            this.b = z;
        }

        @Override // l.n
        public void a(l.p pVar, @Nullable T t) throws IOException {
            if (t == null) {
                return;
            }
            pVar.g(this.a.convert(t), null, this.b);
        }
    }

    /* loaded from: classes4.dex */
    public static final class o extends n<MultipartBody.Part> {
        public static final o a = new o();

        private o() {
        }

        @Override // l.n
        /* renamed from: d */
        public void a(l.p pVar, @Nullable MultipartBody.Part part) {
            if (part != null) {
                pVar.e(part);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class p extends n<Object> {
        private final Method a;
        private final int b;

        public p(Method method, int i2) {
            this.a = method;
            this.b = i2;
        }

        @Override // l.n
        public void a(l.p pVar, @Nullable Object obj) {
            if (obj != null) {
                pVar.m(obj);
                return;
            }
            throw w.o(this.a, this.b, "@Url parameter is null.", new Object[0]);
        }
    }

    /* loaded from: classes4.dex */
    public static final class q<T> extends n<T> {
        public final Class<T> a;

        public q(Class<T> cls) {
            this.a = cls;
        }

        @Override // l.n
        public void a(l.p pVar, @Nullable T t) {
            pVar.h(this.a, t);
        }
    }

    public abstract void a(l.p pVar, @Nullable T t) throws IOException;

    public final n<Object> b() {
        return new b();
    }

    public final n<Iterable<T>> c() {
        return new a();
    }
}
