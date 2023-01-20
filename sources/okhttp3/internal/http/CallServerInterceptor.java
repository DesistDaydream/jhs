package okhttp3.internal.http;

import h.t2.u;
import j.n;
import j.z;
import java.io.IOException;
import java.net.ProtocolException;
import k.e.a.d;
import kotlin.Metadata;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lokhttp3/internal/http/CallServerInterceptor;", "Lokhttp3/Interceptor;", "Lokhttp3/Interceptor$Chain;", "chain", "Lokhttp3/Response;", "intercept", "(Lokhttp3/Interceptor$Chain;)Lokhttp3/Response;", "", "forWebSocket", "Z", "<init>", "(Z)V", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class CallServerInterceptor implements Interceptor {
    private final boolean forWebSocket;

    public CallServerInterceptor(boolean z) {
        this.forWebSocket = z;
    }

    @Override // okhttp3.Interceptor
    @d
    public Response intercept(@d Interceptor.Chain chain) throws IOException {
        Response.Builder builder;
        boolean z;
        Response build;
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        Exchange exchange$okhttp = realInterceptorChain.getExchange$okhttp();
        Request request$okhttp = realInterceptorChain.getRequest$okhttp();
        RequestBody body = request$okhttp.body();
        long currentTimeMillis = System.currentTimeMillis();
        exchange$okhttp.writeRequestHeaders(request$okhttp);
        if (HttpMethod.permitsRequestBody(request$okhttp.method()) && body != null) {
            if (u.K1("100-continue", request$okhttp.header("Expect"), true)) {
                exchange$okhttp.flushRequest();
                builder = exchange$okhttp.readResponseHeaders(true);
                exchange$okhttp.responseHeadersStart();
                z = false;
            } else {
                builder = null;
                z = true;
            }
            if (builder == null) {
                if (body.isDuplex()) {
                    exchange$okhttp.flushRequest();
                    body.writeTo(z.c(exchange$okhttp.createRequestBody(request$okhttp, true)));
                } else {
                    n c2 = z.c(exchange$okhttp.createRequestBody(request$okhttp, false));
                    body.writeTo(c2);
                    c2.close();
                }
            } else {
                exchange$okhttp.noRequestBody();
                if (!exchange$okhttp.getConnection$okhttp().isMultiplexed$okhttp()) {
                    exchange$okhttp.noNewExchangesOnConnection();
                }
            }
        } else {
            exchange$okhttp.noRequestBody();
            builder = null;
            z = true;
        }
        if (body == null || !body.isDuplex()) {
            exchange$okhttp.finishRequest();
        }
        if (builder == null) {
            builder = exchange$okhttp.readResponseHeaders(false);
            if (z) {
                exchange$okhttp.responseHeadersStart();
                z = false;
            }
        }
        Response build2 = builder.request(request$okhttp).handshake(exchange$okhttp.getConnection$okhttp().handshake()).sentRequestAtMillis(currentTimeMillis).receivedResponseAtMillis(System.currentTimeMillis()).build();
        int code = build2.code();
        if (code == 100) {
            Response.Builder readResponseHeaders = exchange$okhttp.readResponseHeaders(false);
            if (z) {
                exchange$okhttp.responseHeadersStart();
            }
            build2 = readResponseHeaders.request(request$okhttp).handshake(exchange$okhttp.getConnection$okhttp().handshake()).sentRequestAtMillis(currentTimeMillis).receivedResponseAtMillis(System.currentTimeMillis()).build();
            code = build2.code();
        }
        exchange$okhttp.responseHeadersEnd(build2);
        if (this.forWebSocket && code == 101) {
            build = build2.newBuilder().body(Util.EMPTY_RESPONSE).build();
        } else {
            build = build2.newBuilder().body(exchange$okhttp.openResponseBody(build2)).build();
        }
        if (u.K1("close", build.request().header("Connection"), true) || u.K1("close", Response.header$default(build, "Connection", null, 2, null), true)) {
            exchange$okhttp.noNewExchangesOnConnection();
        }
        if (code == 204 || code == 205) {
            ResponseBody body2 = build.body();
            if ((body2 != null ? body2.contentLength() : -1L) > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("HTTP ");
                sb.append(code);
                sb.append(" had non-zero Content-Length: ");
                ResponseBody body3 = build.body();
                sb.append(body3 != null ? Long.valueOf(body3.contentLength()) : null);
                throw new ProtocolException(sb.toString());
            }
        }
        return build;
    }
}
