package l;

import h.t1;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import l.h;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/* loaded from: classes4.dex */
public final class c extends h.a {
    private boolean a = true;

    /* loaded from: classes4.dex */
    public static final class a implements h<ResponseBody, ResponseBody> {
        public static final a a = new a();

        @Override // l.h
        /* renamed from: a */
        public ResponseBody convert(ResponseBody responseBody) throws IOException {
            try {
                return w.a(responseBody);
            } finally {
                responseBody.close();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class b implements h<RequestBody, RequestBody> {
        public static final b a = new b();

        @Override // l.h
        /* renamed from: a */
        public RequestBody convert(RequestBody requestBody) {
            return requestBody;
        }
    }

    /* renamed from: l.c$c */
    /* loaded from: classes4.dex */
    public static final class C0504c implements h<ResponseBody, ResponseBody> {
        public static final C0504c a = new C0504c();

        @Override // l.h
        /* renamed from: a */
        public ResponseBody convert(ResponseBody responseBody) {
            return responseBody;
        }
    }

    /* loaded from: classes4.dex */
    public static final class d implements h<Object, String> {
        public static final d a = new d();

        @Override // l.h
        /* renamed from: a */
        public String convert(Object obj) {
            return obj.toString();
        }
    }

    /* loaded from: classes4.dex */
    public static final class e implements h<ResponseBody, t1> {
        public static final e a = new e();

        @Override // l.h
        /* renamed from: a */
        public t1 convert(ResponseBody responseBody) {
            responseBody.close();
            return t1.a;
        }
    }

    /* loaded from: classes4.dex */
    public static final class f implements h<ResponseBody, Void> {
        public static final f a = new f();

        @Override // l.h
        /* renamed from: a */
        public Void convert(ResponseBody responseBody) {
            responseBody.close();
            return null;
        }
    }

    @Override // l.h.a
    @Nullable
    public h<?, RequestBody> c(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, s sVar) {
        if (RequestBody.class.isAssignableFrom(w.h(type))) {
            return b.a;
        }
        return null;
    }

    @Override // l.h.a
    @Nullable
    public h<ResponseBody, ?> d(Type type, Annotation[] annotationArr, s sVar) {
        if (type == ResponseBody.class) {
            if (w.l(annotationArr, l.y.w.class)) {
                return C0504c.a;
            }
            return a.a;
        } else if (type == Void.class) {
            return f.a;
        } else {
            if (this.a && type == t1.class) {
                try {
                    return e.a;
                } catch (NoClassDefFoundError unused) {
                    this.a = false;
                    return null;
                }
            }
            return null;
        }
    }
}
