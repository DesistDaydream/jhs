package l;

import com.qiniu.android.http.request.Request;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import l.w;
import okhttp3.Call;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.KotlinExtensions;

/* loaded from: classes4.dex */
public abstract class j<ResponseT, ReturnT> extends t<ReturnT> {
    private final q a;
    private final Call.Factory b;

    /* renamed from: c  reason: collision with root package name */
    private final h<ResponseBody, ResponseT> f17037c;

    /* loaded from: classes4.dex */
    public static final class a<ResponseT, ReturnT> extends j<ResponseT, ReturnT> {

        /* renamed from: d  reason: collision with root package name */
        private final e<ResponseT, ReturnT> f17038d;

        public a(q qVar, Call.Factory factory, h<ResponseBody, ResponseT> hVar, e<ResponseT, ReturnT> eVar) {
            super(qVar, factory, hVar);
            this.f17038d = eVar;
        }

        @Override // l.j
        public ReturnT c(d<ResponseT> dVar, Object[] objArr) {
            return this.f17038d.adapt(dVar);
        }
    }

    /* loaded from: classes4.dex */
    public static final class b<ResponseT> extends j<ResponseT, Object> {

        /* renamed from: d  reason: collision with root package name */
        private final e<ResponseT, d<ResponseT>> f17039d;

        /* renamed from: e  reason: collision with root package name */
        private final boolean f17040e;

        public b(q qVar, Call.Factory factory, h<ResponseBody, ResponseT> hVar, e<ResponseT, d<ResponseT>> eVar, boolean z) {
            super(qVar, factory, hVar);
            this.f17039d = eVar;
            this.f17040e = z;
        }

        @Override // l.j
        public Object c(d<ResponseT> dVar, Object[] objArr) {
            d<ResponseT> adapt = this.f17039d.adapt(dVar);
            h.e2.c cVar = (h.e2.c) objArr[objArr.length - 1];
            try {
                if (this.f17040e) {
                    return KotlinExtensions.b(adapt, cVar);
                }
                return KotlinExtensions.a(adapt, cVar);
            } catch (Exception e2) {
                return KotlinExtensions.e(e2, cVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class c<ResponseT> extends j<ResponseT, Object> {

        /* renamed from: d  reason: collision with root package name */
        private final e<ResponseT, d<ResponseT>> f17041d;

        public c(q qVar, Call.Factory factory, h<ResponseBody, ResponseT> hVar, e<ResponseT, d<ResponseT>> eVar) {
            super(qVar, factory, hVar);
            this.f17041d = eVar;
        }

        @Override // l.j
        public Object c(d<ResponseT> dVar, Object[] objArr) {
            d<ResponseT> adapt = this.f17041d.adapt(dVar);
            h.e2.c cVar = (h.e2.c) objArr[objArr.length - 1];
            try {
                return KotlinExtensions.c(adapt, cVar);
            } catch (Exception e2) {
                return KotlinExtensions.e(e2, cVar);
            }
        }
    }

    public j(q qVar, Call.Factory factory, h<ResponseBody, ResponseT> hVar) {
        this.a = qVar;
        this.b = factory;
        this.f17037c = hVar;
    }

    private static <ResponseT, ReturnT> e<ResponseT, ReturnT> d(s sVar, Method method, Type type, Annotation[] annotationArr) {
        try {
            return (e<ResponseT, ReturnT>) sVar.b(type, annotationArr);
        } catch (RuntimeException e2) {
            throw w.n(method, e2, "Unable to create call adapter for %s", type);
        }
    }

    private static <ResponseT> h<ResponseBody, ResponseT> e(s sVar, Method method, Type type) {
        try {
            return sVar.n(type, method.getAnnotations());
        } catch (RuntimeException e2) {
            throw w.n(method, e2, "Unable to create converter for %s", type);
        }
    }

    public static <ResponseT, ReturnT> j<ResponseT, ReturnT> f(s sVar, Method method, q qVar) {
        Type genericReturnType;
        boolean z;
        boolean z2 = qVar.f17084k;
        Annotation[] annotations = method.getAnnotations();
        if (z2) {
            Type[] genericParameterTypes = method.getGenericParameterTypes();
            Type f2 = w.f(0, (ParameterizedType) genericParameterTypes[genericParameterTypes.length - 1]);
            if (w.h(f2) == r.class && (f2 instanceof ParameterizedType)) {
                f2 = w.g(0, (ParameterizedType) f2);
                z = true;
            } else {
                z = false;
            }
            genericReturnType = new w.b(null, d.class, f2);
            annotations = v.a(annotations);
        } else {
            genericReturnType = method.getGenericReturnType();
            z = false;
        }
        e d2 = d(sVar, method, genericReturnType, annotations);
        Type responseType = d2.responseType();
        if (responseType != Response.class) {
            if (responseType != r.class) {
                if (qVar.f17076c.equals(Request.HttpMethodHEAD) && !Void.class.equals(responseType)) {
                    throw w.m(method, "HEAD method must use Void as response type.", new Object[0]);
                }
                h e2 = e(sVar, method, responseType);
                Call.Factory factory = sVar.b;
                if (z2) {
                    if (z) {
                        return new c(qVar, factory, e2, d2);
                    }
                    return new b(qVar, factory, e2, d2, false);
                }
                return new a(qVar, factory, e2, d2);
            }
            throw w.m(method, "Response must include generic type (e.g., Response<String>)", new Object[0]);
        }
        throw w.m(method, "'" + w.h(responseType).getName() + "' is not a valid response body type. Did you mean ResponseBody?", new Object[0]);
    }

    @Override // l.t
    @Nullable
    public final ReturnT a(Object[] objArr) {
        return c(new l(this.a, objArr, this.b, this.f17037c), objArr);
    }

    @Nullable
    public abstract ReturnT c(d<ResponseT> dVar, Object[] objArr);
}
