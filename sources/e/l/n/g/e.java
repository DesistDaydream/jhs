package e.l.n.g;

import e.l.r.i0;
import h.k2.v.f0;
import h.k2.v.s0;
import h.k2.v.u;
import j.m;
import j.o;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* loaded from: classes2.dex */
public final class e implements Interceptor {
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    public static final a f14118c = new a(null);
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private static final String f14119d = "application/json;charset=utf-8";
    @k.e.a.d
    private final String a = "LogPrintInterceptor";
    private final Charset b = Charset.forName("UTF-8");

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    private final StringBuilder a(StringBuilder sb, Headers headers) {
        Map<String, List<String>> multimap;
        Set<Map.Entry<String, List<String>>> entrySet;
        if (headers != null && (multimap = headers.toMultimap()) != null && (entrySet = multimap.entrySet()) != null) {
            Iterator<T> it = entrySet.iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                sb.append('\n' + ((String) entry.getKey()) + " = " + ((String) ((List) entry.getValue()).get(0)));
            }
        }
        return sb;
    }

    private final StringBuilder b(StringBuilder sb, RequestBody requestBody) {
        if (requestBody != null) {
            m mVar = new m();
            requestBody.writeTo(mVar);
            Charset charset = this.b;
            MediaType contentType = requestBody.contentType();
            if (contentType != null) {
                try {
                    charset = contentType.charset(this.b);
                } catch (UnsupportedCharsetException e2) {
                    e2.printStackTrace();
                }
            }
            sb.append(mVar.g0(charset));
        }
        return sb;
    }

    private final Response c(Exception exc, Interceptor.Chain chain, Request request) {
        ResponseBody create = ResponseBody.Companion.create(MediaType.Companion.parse(f14119d), f0.C("", exc.getMessage()));
        Response.Builder code = new Response.Builder().code(400);
        s0 s0Var = s0.a;
        return code.message(String.format("%s==>Exception:%s", Arrays.copyOf(new Object[]{chain.request().url().host(), exc.getMessage()}, 2))).request(request).body(create).protocol(Protocol.HTTP_1_1).build();
    }

    private final boolean d(String str) {
        try {
            Object nextValue = new JSONTokener(str).nextValue();
            if (nextValue instanceof JSONObject) {
                return true;
            }
            return nextValue instanceof JSONArray;
        } catch (JSONException unused) {
            return false;
        }
    }

    private final String e(String str) {
        try {
            if (h.t2.u.u2(str, "{", false, 2, null)) {
                str = new JSONObject(str).toString(4);
            } else if (h.t2.u.u2(str, "[", false, 2, null)) {
                str = new JSONArray(str).toString(4);
            }
        } catch (JSONException unused) {
        }
        return str;
    }

    private final e f(ResponseBody responseBody) {
        if (responseBody != null) {
            o source = responseBody.source();
            source.G(Long.MAX_VALUE);
            m buffer = source.getBuffer();
            Charset charset = this.b;
            MediaType contentType = responseBody.contentType();
            if (contentType != null) {
                try {
                    charset = contentType.charset(this.b);
                } catch (UnsupportedCharsetException e2) {
                    e2.printStackTrace();
                }
            }
            String g2 = g(buffer.clone().g0(charset));
            int length = 2001 - this.a.length();
            while (g2.length() > length) {
                e.l.h.k.b bVar = e.l.h.k.b.a;
                String str = this.a;
                Objects.requireNonNull(g2, "null cannot be cast to non-null type java.lang.String");
                bVar.a(str, g2.substring(0, length));
                Objects.requireNonNull(g2, "null cannot be cast to non-null type java.lang.String");
                g2 = g2.substring(length);
            }
            e.l.h.k.b.a.a(this.a, g2);
        }
        return this;
    }

    private final String g(String str) {
        return d(str) ? e(str) : str;
    }

    @Override // okhttp3.Interceptor
    @k.e.a.d
    public Response intercept(@k.e.a.d Interceptor.Chain chain) throws Exception {
        if (!i0.a.e(e.t.a.b())) {
            Request request = chain.request();
            try {
                return chain.proceed(request);
            } catch (Exception e2) {
                return c(e2, chain, request);
            }
        }
        Request request2 = chain.request();
        e.l.h.k.b bVar = e.l.h.k.b.a;
        if (bVar.e()) {
            StringBuilder sb = new StringBuilder();
            sb.append(f0.C(request2.method(), " request"));
            sb.append(f0.C("url = ", request2.url()));
            sb.append("\n header");
            StringBuilder a2 = a(sb, request2.headers());
            a2.append("\n body");
            bVar.a(this.a, b(a2, request2.body()).toString());
            Response proceed = chain.proceed(request2);
            f(proceed.body());
            return proceed;
        }
        try {
            return chain.proceed(request2);
        } catch (Exception e3) {
            return c(e3, chain, request2);
        }
    }
}
