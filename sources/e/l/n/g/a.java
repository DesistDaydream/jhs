package e.l.n.g;

import e.l.r.c0;
import h.k2.v.f0;
import h.k2.v.u;
import okhttp3.Interceptor;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;
import org.json.JSONTokener;

/* loaded from: classes2.dex */
public final class a implements Interceptor {
    @k.e.a.d
    public static final C0393a b = new C0393a(null);
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private static final String f14116c = "DecodeResponseInterceptor";
    @k.e.a.d
    private final c0 a;

    /* renamed from: e.l.n.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0393a {
        private C0393a() {
        }

        public /* synthetic */ C0393a(u uVar) {
            this();
        }
    }

    public a(@k.e.a.d c0 c0Var) {
        this.a = c0Var;
    }

    @k.e.a.d
    public final c0 a() {
        return this.a;
    }

    @Override // okhttp3.Interceptor
    @k.e.a.d
    public Response intercept(@k.e.a.d Interceptor.Chain chain) {
        Response proceed = chain.proceed(chain.request());
        ResponseBody body = proceed.body();
        if (!proceed.isSuccessful() || body == null) {
            return proceed;
        }
        String string = body.string();
        try {
            JSONObject jSONObject = new JSONObject(string);
            String optString = jSONObject.optString("data", "");
            if (!h.t2.u.U1(optString)) {
                String d2 = this.a.d(optString);
                jSONObject.putOpt("data", h.t2.u.U1(d2) ^ true ? new JSONTokener(d2).nextValue() : "");
            }
            String jSONObject2 = jSONObject.toString();
            e.l.h.k.b.a.a(f14116c, f0.C("receive raw data: ", jSONObject2));
            ResponseBody.Companion companion = ResponseBody.Companion;
            ResponseBody body2 = proceed.body();
            return proceed.newBuilder().body(companion.create(jSONObject2, body2 == null ? null : body2.contentType())).build();
        } catch (Exception e2) {
            e.l.h.k.b.a.b(f14116c, f0.C("phase raw data: failed ", e2.getMessage()));
            ResponseBody.Companion companion2 = ResponseBody.Companion;
            ResponseBody body3 = proceed.body();
            return proceed.newBuilder().body(companion2.create(string, body3 != null ? body3.contentType() : null)).build();
        }
    }
}
