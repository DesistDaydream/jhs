package e.l.n.g;

import android.os.Build;
import com.jihuanshe.mmkv.UserKV;
import e.t.u.g;
import e.t.u.t;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/* loaded from: classes2.dex */
public final class d implements Interceptor {
    @Override // okhttp3.Interceptor
    @k.e.a.d
    public Response intercept(@k.e.a.d Interceptor.Chain chain) throws Exception {
        Request request = chain.request();
        RequestBody body = request.body();
        HttpUrl.Builder host = request.url().newBuilder().scheme(request.url().scheme()).host(request.url().host());
        String queryParameter = request.url().queryParameter("token");
        if (queryParameter == null || queryParameter.length() == 0) {
            host.addQueryParameter("token", UserKV.f3913c.u());
        }
        Request.Builder removeHeader = request.newBuilder().removeHeader("User-Agent");
        StringBuilder sb = new StringBuilder();
        sb.append("Model/");
        g gVar = g.a;
        sb.append(gVar.c());
        sb.append(',');
        sb.append(gVar.h());
        sb.append(" OS/");
        sb.append(Build.VERSION.SDK_INT);
        sb.append(" Version/");
        sb.append(t.a.e());
        Response proceed = chain.proceed(removeHeader.addHeader("User-Agent", sb.toString()).method(request.method(), body).url(host.build()).build());
        return proceed.newBuilder().body(new c(proceed.headers(), proceed.body())).build();
    }
}
