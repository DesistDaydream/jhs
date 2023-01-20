package e.l.n.g;

import android.util.Log;
import e.l.r.c0;
import e.l.r.m0;
import e.l.r.r;
import h.k2.v.f0;
import h.k2.v.u;
import java.util.HashMap;
import java.util.Set;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class b implements Interceptor {
    @k.e.a.d
    public static final a b = new a(null);
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private static final String f14117c = "data";
    @k.e.a.d
    private final c0 a;

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    public b(@k.e.a.d c0 c0Var) {
        this.a = c0Var;
    }

    private final Response b(Request request, Interceptor.Chain chain) {
        try {
            HttpUrl url = request.url();
            e.l.h.k.b.a.a("LogPrintInterceptor", f0.C("url: ", url));
            Set<String> queryParameterNames = url.queryParameterNames();
            JSONObject jSONObject = new JSONObject();
            for (String str : queryParameterNames) {
                String queryParameter = url.queryParameter(str);
                if (queryParameter != null) {
                    jSONObject.put(str, queryParameter);
                }
            }
            String f2 = this.a.f(jSONObject.toString());
            m0 m0Var = m0.a;
            Headers build = request.headers().newBuilder().add("key", m0Var.d(this.a.n(), m0Var.h(e.l.m.c.f14093c.q()))).build();
            HttpUrl.Builder newBuilder = url.newBuilder();
            for (String str2 : queryParameterNames) {
                newBuilder.removeAllQueryParameters(str2);
            }
            return chain.proceed(request.newBuilder().url(newBuilder.addQueryParameter("data", f2).addQueryParameter("token", url.queryParameter("token")).build()).headers(build).build());
        } catch (Exception e2) {
            e2.printStackTrace();
            r.a.f(Log.getStackTraceString(e2));
            return chain.proceed(request);
        }
    }

    private final Response c(Request request, Interceptor.Chain chain) {
        FormBody formBody = (FormBody) request.body();
        if (formBody == null) {
            return chain.proceed(request);
        }
        if (formBody.size() == 0) {
            return chain.proceed(request);
        }
        try {
            HashMap hashMap = new HashMap();
            int i2 = 0;
            int size = formBody.size();
            if (size > 0) {
                while (true) {
                    int i3 = i2 + 1;
                    hashMap.put(formBody.name(i2), formBody.value(i2));
                    if (i3 >= size) {
                        break;
                    }
                    i2 = i3;
                }
            }
            FormBody.Builder builder = new FormBody.Builder(MediaType.charset$default(formBody.contentType(), null, 1, null));
            builder.add("data", this.a.f(e.l.r.f0.a.a().z(hashMap)));
            String str = (String) hashMap.get("token");
            if (str == null) {
                str = "";
            }
            builder.add("token", str);
            Request.Builder method = request.newBuilder().method(request.method(), builder.build());
            m0 m0Var = m0.a;
            return chain.proceed(method.header("key", m0Var.d(this.a.n(), m0Var.h(e.l.m.c.f14093c.q()))).build());
        } catch (Exception e2) {
            e2.printStackTrace();
            return chain.proceed(request);
        }
    }

    @k.e.a.d
    public final c0 a() {
        return this.a;
    }

    @Override // okhttp3.Interceptor
    @k.e.a.d
    public Response intercept(@k.e.a.d Interceptor.Chain chain) {
        Request request = chain.request();
        if (!f0.g(request.method(), "POST") && !(request.body() instanceof FormBody)) {
            if (f0.g(request.method(), "GET")) {
                return b(request, chain);
            }
            return chain.proceed(request);
        }
        return c(request, chain);
    }
}
