package okhttp3;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.internal.bc;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import h.a2.t0;
import h.i;
import h.k2.g;
import h.k2.h;
import h.q0;
import h.t2.u;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k.e.a.d;
import k.e.a.e;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import okhttp3.Headers;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpMethod;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\b\u0018\u00002\u00020\u0001:\u00015BC\b\u0000\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0019\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001c\u0012\u0016\u0010/\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f\u0012\u0004\u0012\u00020\u00010.¢\u0006\u0004\b3\u00104J\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\t\u0010\nJ%\u0010\t\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u000b2\u000e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\f¢\u0006\u0004\b\t\u0010\u000eJ\r\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0015\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0018\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0007\u001a\u00020\u0019H\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0011\u0010\u001f\u001a\u0004\u0018\u00010\u001cH\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010#\u001a\u00020 H\u0007¢\u0006\u0004\b!\u0010\"J\u000f\u0010$\u001a\u00020\u0002H\u0016¢\u0006\u0004\b$\u0010\u0017R\u0013\u0010&\u001a\u00020%8F@\u0006¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0018\u0010(\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0019\u0010\u0007\u001a\u00020\u00198\u0007@\u0006¢\u0006\f\n\u0004\b\u0007\u0010*\u001a\u0004\b\u0007\u0010\u001bR\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0007@\u0006¢\u0006\f\n\u0004\b\u001f\u0010+\u001a\u0004\b\u001f\u0010\u001eR\u0019\u0010\u0015\u001a\u00020\u00128\u0007@\u0006¢\u0006\f\n\u0004\b\u0015\u0010,\u001a\u0004\b\u0015\u0010\u0014R\u0019\u0010\u0018\u001a\u00020\u00028\u0007@\u0006¢\u0006\f\n\u0004\b\u0018\u0010-\u001a\u0004\b\u0018\u0010\u0017R,\u0010/\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f\u0012\u0004\u0012\u00020\u00010.8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u0013\u0010#\u001a\u00020 8G@\u0006¢\u0006\u0006\u001a\u0004\b#\u0010\"¨\u00066"}, d2 = {"Lokhttp3/Request;", "", "", "name", "header", "(Ljava/lang/String;)Ljava/lang/String;", "", "headers", "(Ljava/lang/String;)Ljava/util/List;", RemoteMessageConst.Notification.TAG, "()Ljava/lang/Object;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", "type", "(Ljava/lang/Class;)Ljava/lang/Object;", "Lokhttp3/Request$Builder;", "newBuilder", "()Lokhttp3/Request$Builder;", "Lokhttp3/HttpUrl;", "-deprecated_url", "()Lokhttp3/HttpUrl;", "url", "-deprecated_method", "()Ljava/lang/String;", PushConstants.MZ_PUSH_MESSAGE_METHOD, "Lokhttp3/Headers;", "-deprecated_headers", "()Lokhttp3/Headers;", "Lokhttp3/RequestBody;", "-deprecated_body", "()Lokhttp3/RequestBody;", "body", "Lokhttp3/CacheControl;", "-deprecated_cacheControl", "()Lokhttp3/CacheControl;", "cacheControl", "toString", "", "isHttps", "()Z", "lazyCacheControl", "Lokhttp3/CacheControl;", "Lokhttp3/Headers;", "Lokhttp3/RequestBody;", "Lokhttp3/HttpUrl;", "Ljava/lang/String;", "", bc.f1477l, "Ljava/util/Map;", "getTags$okhttp", "()Ljava/util/Map;", "<init>", "(Lokhttp3/HttpUrl;Ljava/lang/String;Lokhttp3/Headers;Lokhttp3/RequestBody;Ljava/util/Map;)V", "Builder", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class Request {
    @e
    private final RequestBody body;
    @d
    private final Headers headers;
    private CacheControl lazyCacheControl;
    @d
    private final String method;
    @d
    private final Map<Class<?>, Object> tags;
    @d
    private final HttpUrl url;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010%\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\bF\u0010GB\u0011\b\u0010\u0012\u0006\u0010H\u001a\u00020'¢\u0006\u0004\bF\u0010IJ\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0003\u0010\u0006J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0003\u0010\bJ\u001f\u0010\u000b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\r\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u0006J\u0017\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u0017\u0010\u0016J\u0017\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u001b\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0017¢\u0006\u0004\b\u001c\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001d\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001e\u0010\u001bJ!\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010!\u001a\u00020\u00002\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u0016¢\u0006\u0004\b!\u0010\"J/\u0010!\u001a\u00020\u0000\"\u0004\b\u0000\u0010#2\u000e\u0010%\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000$2\b\u0010!\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0004\b!\u0010&J\u000f\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b(\u0010)R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R2\u00105\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030$\u0012\u0004\u0012\u00020\u0001048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\"\u0010\u001f\u001a\u00020\u00058\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\"\u0010\u0010\u001a\u00020@8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010E¨\u0006J"}, d2 = {"Lokhttp3/Request$Builder;", "", "Lokhttp3/HttpUrl;", "url", "(Lokhttp3/HttpUrl;)Lokhttp3/Request$Builder;", "", "(Ljava/lang/String;)Lokhttp3/Request$Builder;", "Ljava/net/URL;", "(Ljava/net/URL;)Lokhttp3/Request$Builder;", "name", "value", "header", "(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Request$Builder;", "addHeader", "removeHeader", "Lokhttp3/Headers;", "headers", "(Lokhttp3/Headers;)Lokhttp3/Request$Builder;", "Lokhttp3/CacheControl;", "cacheControl", "(Lokhttp3/CacheControl;)Lokhttp3/Request$Builder;", "get", "()Lokhttp3/Request$Builder;", "head", "Lokhttp3/RequestBody;", "body", "post", "(Lokhttp3/RequestBody;)Lokhttp3/Request$Builder;", "delete", "put", "patch", PushConstants.MZ_PUSH_MESSAGE_METHOD, "(Ljava/lang/String;Lokhttp3/RequestBody;)Lokhttp3/Request$Builder;", RemoteMessageConst.Notification.TAG, "(Ljava/lang/Object;)Lokhttp3/Request$Builder;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", "type", "(Ljava/lang/Class;Ljava/lang/Object;)Lokhttp3/Request$Builder;", "Lokhttp3/Request;", "build", "()Lokhttp3/Request;", "Lokhttp3/HttpUrl;", "getUrl$okhttp", "()Lokhttp3/HttpUrl;", "setUrl$okhttp", "(Lokhttp3/HttpUrl;)V", "Lokhttp3/RequestBody;", "getBody$okhttp", "()Lokhttp3/RequestBody;", "setBody$okhttp", "(Lokhttp3/RequestBody;)V", "", bc.f1477l, "Ljava/util/Map;", "getTags$okhttp", "()Ljava/util/Map;", "setTags$okhttp", "(Ljava/util/Map;)V", "Ljava/lang/String;", "getMethod$okhttp", "()Ljava/lang/String;", "setMethod$okhttp", "(Ljava/lang/String;)V", "Lokhttp3/Headers$Builder;", "Lokhttp3/Headers$Builder;", "getHeaders$okhttp", "()Lokhttp3/Headers$Builder;", "setHeaders$okhttp", "(Lokhttp3/Headers$Builder;)V", "<init>", "()V", "request", "(Lokhttp3/Request;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static class Builder {
        @e
        private RequestBody body;
        @d
        private Headers.Builder headers;
        @d
        private String method;
        @d
        private Map<Class<?>, Object> tags;
        @e
        private HttpUrl url;

        public Builder() {
            this.tags = new LinkedHashMap();
            this.method = "GET";
            this.headers = new Headers.Builder();
        }

        public static /* synthetic */ Builder delete$default(Builder builder, RequestBody requestBody, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    requestBody = Util.EMPTY_REQUEST;
                }
                return builder.delete(requestBody);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: delete");
        }

        @d
        public Builder addHeader(@d String str, @d String str2) {
            this.headers.add(str, str2);
            return this;
        }

        @d
        public Request build() {
            HttpUrl httpUrl = this.url;
            if (httpUrl != null) {
                return new Request(httpUrl, this.method, this.headers.build(), this.body, Util.toImmutableMap(this.tags));
            }
            throw new IllegalStateException("url == null".toString());
        }

        @d
        public Builder cacheControl(@d CacheControl cacheControl) {
            String cacheControl2 = cacheControl.toString();
            return cacheControl2.length() == 0 ? removeHeader("Cache-Control") : header("Cache-Control", cacheControl2);
        }

        @h
        @d
        public final Builder delete() {
            return delete$default(this, null, 1, null);
        }

        @h
        @d
        public Builder delete(@e RequestBody requestBody) {
            return method("DELETE", requestBody);
        }

        @d
        public Builder get() {
            return method("GET", null);
        }

        @e
        public final RequestBody getBody$okhttp() {
            return this.body;
        }

        @d
        public final Headers.Builder getHeaders$okhttp() {
            return this.headers;
        }

        @d
        public final String getMethod$okhttp() {
            return this.method;
        }

        @d
        public final Map<Class<?>, Object> getTags$okhttp() {
            return this.tags;
        }

        @e
        public final HttpUrl getUrl$okhttp() {
            return this.url;
        }

        @d
        public Builder head() {
            return method(com.qiniu.android.http.request.Request.HttpMethodHEAD, null);
        }

        @d
        public Builder header(@d String str, @d String str2) {
            this.headers.set(str, str2);
            return this;
        }

        @d
        public Builder headers(@d Headers headers) {
            this.headers = headers.newBuilder();
            return this;
        }

        @d
        public Builder method(@d String str, @e RequestBody requestBody) {
            if (str.length() > 0) {
                if (requestBody == null) {
                    if (!(true ^ HttpMethod.requiresRequestBody(str))) {
                        throw new IllegalArgumentException(("method " + str + " must have a request body.").toString());
                    }
                } else if (!HttpMethod.permitsRequestBody(str)) {
                    throw new IllegalArgumentException(("method " + str + " must not have a request body.").toString());
                }
                this.method = str;
                this.body = requestBody;
                return this;
            }
            throw new IllegalArgumentException("method.isEmpty() == true".toString());
        }

        @d
        public Builder patch(@d RequestBody requestBody) {
            return method("PATCH", requestBody);
        }

        @d
        public Builder post(@d RequestBody requestBody) {
            return method("POST", requestBody);
        }

        @d
        public Builder put(@d RequestBody requestBody) {
            return method(com.qiniu.android.http.request.Request.HttpMethodPUT, requestBody);
        }

        @d
        public Builder removeHeader(@d String str) {
            this.headers.removeAll(str);
            return this;
        }

        public final void setBody$okhttp(@e RequestBody requestBody) {
            this.body = requestBody;
        }

        public final void setHeaders$okhttp(@d Headers.Builder builder) {
            this.headers = builder;
        }

        public final void setMethod$okhttp(@d String str) {
            this.method = str;
        }

        public final void setTags$okhttp(@d Map<Class<?>, Object> map) {
            this.tags = map;
        }

        public final void setUrl$okhttp(@e HttpUrl httpUrl) {
            this.url = httpUrl;
        }

        @d
        public Builder tag(@e Object obj) {
            return tag(Object.class, obj);
        }

        @d
        public Builder url(@d HttpUrl httpUrl) {
            this.url = httpUrl;
            return this;
        }

        @d
        public <T> Builder tag(@d Class<? super T> cls, @e T t) {
            if (t == null) {
                this.tags.remove(cls);
            } else {
                if (this.tags.isEmpty()) {
                    this.tags = new LinkedHashMap();
                }
                this.tags.put(cls, cls.cast(t));
            }
            return this;
        }

        @d
        public Builder url(@d String str) {
            if (u.s2(str, "ws:", true)) {
                str = "http:" + str.substring(3);
            } else if (u.s2(str, "wss:", true)) {
                str = "https:" + str.substring(4);
            }
            return url(HttpUrl.Companion.get(str));
        }

        public Builder(@d Request request) {
            Map<Class<?>, Object> J0;
            this.tags = new LinkedHashMap();
            this.url = request.url();
            this.method = request.method();
            this.body = request.body();
            if (request.getTags$okhttp().isEmpty()) {
                J0 = new LinkedHashMap<>();
            } else {
                J0 = t0.J0(request.getTags$okhttp());
            }
            this.tags = J0;
            this.headers = request.headers().newBuilder();
        }

        @d
        public Builder url(@d URL url) {
            return url(HttpUrl.Companion.get(url.toString()));
        }
    }

    public Request(@d HttpUrl httpUrl, @d String str, @d Headers headers, @e RequestBody requestBody, @d Map<Class<?>, ? extends Object> map) {
        this.url = httpUrl;
        this.method = str;
        this.headers = headers;
        this.body = requestBody;
        this.tags = map;
    }

    @g(name = "-deprecated_body")
    @e
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "body", imports = {}))
    /* renamed from: -deprecated_body  reason: not valid java name */
    public final RequestBody m230deprecated_body() {
        return this.body;
    }

    @g(name = "-deprecated_cacheControl")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "cacheControl", imports = {}))
    @d
    /* renamed from: -deprecated_cacheControl  reason: not valid java name */
    public final CacheControl m231deprecated_cacheControl() {
        return cacheControl();
    }

    @g(name = "-deprecated_headers")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "headers", imports = {}))
    @d
    /* renamed from: -deprecated_headers  reason: not valid java name */
    public final Headers m232deprecated_headers() {
        return this.headers;
    }

    @g(name = "-deprecated_method")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = PushConstants.MZ_PUSH_MESSAGE_METHOD, imports = {}))
    @d
    /* renamed from: -deprecated_method  reason: not valid java name */
    public final String m233deprecated_method() {
        return this.method;
    }

    @g(name = "-deprecated_url")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "url", imports = {}))
    @d
    /* renamed from: -deprecated_url  reason: not valid java name */
    public final HttpUrl m234deprecated_url() {
        return this.url;
    }

    @g(name = "body")
    @e
    public final RequestBody body() {
        return this.body;
    }

    @g(name = "cacheControl")
    @d
    public final CacheControl cacheControl() {
        CacheControl cacheControl = this.lazyCacheControl;
        if (cacheControl == null) {
            CacheControl parse = CacheControl.Companion.parse(this.headers);
            this.lazyCacheControl = parse;
            return parse;
        }
        return cacheControl;
    }

    @d
    public final Map<Class<?>, Object> getTags$okhttp() {
        return this.tags;
    }

    @e
    public final String header(@d String str) {
        return this.headers.get(str);
    }

    @g(name = "headers")
    @d
    public final Headers headers() {
        return this.headers;
    }

    public final boolean isHttps() {
        return this.url.isHttps();
    }

    @g(name = PushConstants.MZ_PUSH_MESSAGE_METHOD)
    @d
    public final String method() {
        return this.method;
    }

    @d
    public final Builder newBuilder() {
        return new Builder(this);
    }

    @e
    public final Object tag() {
        return tag(Object.class);
    }

    @d
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request{method=");
        sb.append(this.method);
        sb.append(", url=");
        sb.append(this.url);
        if (this.headers.size() != 0) {
            sb.append(", headers=[");
            int i2 = 0;
            for (Pair<? extends String, ? extends String> pair : this.headers) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt__CollectionsKt.W();
                }
                Pair<? extends String, ? extends String> pair2 = pair;
                String component1 = pair2.component1();
                String component2 = pair2.component2();
                if (i2 > 0) {
                    sb.append(", ");
                }
                sb.append(component1);
                sb.append(':');
                sb.append(component2);
                i2 = i3;
            }
            sb.append(']');
        }
        if (!this.tags.isEmpty()) {
            sb.append(", tags=");
            sb.append(this.tags);
        }
        sb.append('}');
        return sb.toString();
    }

    @g(name = "url")
    @d
    public final HttpUrl url() {
        return this.url;
    }

    @d
    public final List<String> headers(@d String str) {
        return this.headers.values(str);
    }

    @e
    public final <T> T tag(@d Class<? extends T> cls) {
        return cls.cast(this.tags.get(cls));
    }
}
