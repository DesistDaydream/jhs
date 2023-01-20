package l;

import com.baidu.mobads.sdk.internal.bp;
import java.util.Objects;
import javax.annotation.Nullable;
import l.l;
import okhttp3.Headers;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* loaded from: classes4.dex */
public final class r<T> {
    private final Response a;
    @Nullable
    private final T b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final ResponseBody f17096c;

    private r(Response response, @Nullable T t, @Nullable ResponseBody responseBody) {
        this.a = response;
        this.b = t;
        this.f17096c = responseBody;
    }

    public static <T> r<T> c(int i2, ResponseBody responseBody) {
        Objects.requireNonNull(responseBody, "body == null");
        if (i2 >= 400) {
            return d(responseBody, new Response.Builder().body(new l.c(responseBody.contentType(), responseBody.contentLength())).code(i2).message("Response.error()").protocol(Protocol.HTTP_1_1).request(new Request.Builder().url("http://localhost/").build()).build());
        }
        throw new IllegalArgumentException("code < 400: " + i2);
    }

    public static <T> r<T> d(ResponseBody responseBody, Response response) {
        Objects.requireNonNull(responseBody, "body == null");
        Objects.requireNonNull(response, "rawResponse == null");
        if (!response.isSuccessful()) {
            return new r<>(response, null, responseBody);
        }
        throw new IllegalArgumentException("rawResponse should not be successful response");
    }

    public static <T> r<T> j(int i2, @Nullable T t) {
        if (i2 >= 200 && i2 < 300) {
            return m(t, new Response.Builder().code(i2).message("Response.success()").protocol(Protocol.HTTP_1_1).request(new Request.Builder().url("http://localhost/").build()).build());
        }
        throw new IllegalArgumentException("code < 200 or >= 300: " + i2);
    }

    public static <T> r<T> k(@Nullable T t) {
        return m(t, new Response.Builder().code(200).message(bp.f1532k).protocol(Protocol.HTTP_1_1).request(new Request.Builder().url("http://localhost/").build()).build());
    }

    public static <T> r<T> l(@Nullable T t, Headers headers) {
        Objects.requireNonNull(headers, "headers == null");
        return m(t, new Response.Builder().code(200).message(bp.f1532k).protocol(Protocol.HTTP_1_1).headers(headers).request(new Request.Builder().url("http://localhost/").build()).build());
    }

    public static <T> r<T> m(@Nullable T t, Response response) {
        Objects.requireNonNull(response, "rawResponse == null");
        if (response.isSuccessful()) {
            return new r<>(response, t, null);
        }
        throw new IllegalArgumentException("rawResponse must be successful response");
    }

    @Nullable
    public T a() {
        return this.b;
    }

    public int b() {
        return this.a.code();
    }

    @Nullable
    public ResponseBody e() {
        return this.f17096c;
    }

    public Headers f() {
        return this.a.headers();
    }

    public boolean g() {
        return this.a.isSuccessful();
    }

    public String h() {
        return this.a.message();
    }

    public Response i() {
        return this.a;
    }

    public String toString() {
        return this.a.toString();
    }
}
