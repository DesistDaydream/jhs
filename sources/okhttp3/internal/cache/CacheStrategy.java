package okhttp3.internal.cache;

import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import h.k2.v.u;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u000e2\u00020\u0001:\u0002\u000e\u000fB\u001d\b\u0000\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lokhttp3/internal/cache/CacheStrategy;", "", "Lokhttp3/Request;", "networkRequest", "Lokhttp3/Request;", "getNetworkRequest", "()Lokhttp3/Request;", "Lokhttp3/Response;", "cacheResponse", "Lokhttp3/Response;", "getCacheResponse", "()Lokhttp3/Response;", "<init>", "(Lokhttp3/Request;Lokhttp3/Response;)V", "Companion", "Factory", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class CacheStrategy {
    public static final Companion Companion = new Companion(null);
    @e
    private final Response cacheResponse;
    @e
    private final Request networkRequest;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lokhttp3/internal/cache/CacheStrategy$Companion;", "", "Lokhttp3/Response;", "response", "Lokhttp3/Request;", "request", "", "isCacheable", "(Lokhttp3/Response;Lokhttp3/Request;)Z", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        public final boolean isCacheable(@d Response response, @d Request request) {
            int code = response.code();
            if (code != 200 && code != 410 && code != 414 && code != 501 && code != 203 && code != 204) {
                if (code != 307) {
                    if (code != 308 && code != 404 && code != 405) {
                        switch (code) {
                            case 300:
                            case 301:
                                break;
                            case 302:
                                break;
                            default:
                                return false;
                        }
                    }
                }
                if (Response.header$default(response, "Expires", null, 2, null) == null && response.cacheControl().maxAgeSeconds() == -1 && !response.cacheControl().isPublic() && !response.cacheControl().isPrivate()) {
                    return false;
                }
            }
            return (response.cacheControl().noStore() || request.cacheControl().noStore()) ? false : true;
        }

        public /* synthetic */ Companion(u uVar) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0014\u001a\u00020\b\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b(\u0010)J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u0005¢\u0006\u0004\b\u0010\u0010\u0007R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001dR\u0016\u0010 \u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010\"\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010\u0015R\u001c\u0010\r\u001a\u00020\f8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\r\u0010#\u001a\u0004\b$\u0010%R\u0018\u0010&\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010\u001dR\u0016\u0010'\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010\u0015¨\u0006*"}, d2 = {"Lokhttp3/internal/cache/CacheStrategy$Factory;", "", "", "isFreshnessLifetimeHeuristic", "()Z", "Lokhttp3/internal/cache/CacheStrategy;", "computeCandidate", "()Lokhttp3/internal/cache/CacheStrategy;", "", "computeFreshnessLifetime", "()J", "cacheResponseAge", "Lokhttp3/Request;", "request", "hasConditions", "(Lokhttp3/Request;)Z", "compute", "Lokhttp3/Response;", "cacheResponse", "Lokhttp3/Response;", "nowMillis", "J", "Ljava/util/Date;", "servedDate", "Ljava/util/Date;", "expires", "lastModified", "", "etag", "Ljava/lang/String;", "lastModifiedString", "", "ageSeconds", ExpandableTextView.P, "sentRequestMillis", "Lokhttp3/Request;", "getRequest$okhttp", "()Lokhttp3/Request;", "servedDateString", "receivedResponseMillis", "<init>", "(JLokhttp3/Request;Lokhttp3/Response;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class Factory {
        private int ageSeconds;
        private final Response cacheResponse;
        private String etag;
        private Date expires;
        private Date lastModified;
        private String lastModifiedString;
        private final long nowMillis;
        private long receivedResponseMillis;
        @d
        private final Request request;
        private long sentRequestMillis;
        private Date servedDate;
        private String servedDateString;

        public Factory(long j2, @d Request request, @e Response response) {
            this.nowMillis = j2;
            this.request = request;
            this.cacheResponse = response;
            this.ageSeconds = -1;
            if (response != null) {
                this.sentRequestMillis = response.sentRequestAtMillis();
                this.receivedResponseMillis = response.receivedResponseAtMillis();
                Headers headers = response.headers();
                int size = headers.size();
                for (int i2 = 0; i2 < size; i2++) {
                    String name = headers.name(i2);
                    String value = headers.value(i2);
                    if (h.t2.u.K1(name, "Date", true)) {
                        this.servedDate = DatesKt.toHttpDateOrNull(value);
                        this.servedDateString = value;
                    } else if (h.t2.u.K1(name, "Expires", true)) {
                        this.expires = DatesKt.toHttpDateOrNull(value);
                    } else if (h.t2.u.K1(name, "Last-Modified", true)) {
                        this.lastModified = DatesKt.toHttpDateOrNull(value);
                        this.lastModifiedString = value;
                    } else if (h.t2.u.K1(name, "ETag", true)) {
                        this.etag = value;
                    } else if (h.t2.u.K1(name, "Age", true)) {
                        this.ageSeconds = Util.toNonNegativeInt(value, -1);
                    }
                }
            }
        }

        private final long cacheResponseAge() {
            Date date = this.servedDate;
            long max = date != null ? Math.max(0L, this.receivedResponseMillis - date.getTime()) : 0L;
            int i2 = this.ageSeconds;
            if (i2 != -1) {
                max = Math.max(max, TimeUnit.SECONDS.toMillis(i2));
            }
            long j2 = this.receivedResponseMillis;
            return max + (j2 - this.sentRequestMillis) + (this.nowMillis - j2);
        }

        private final CacheStrategy computeCandidate() {
            if (this.cacheResponse == null) {
                return new CacheStrategy(this.request, null);
            }
            if (this.request.isHttps() && this.cacheResponse.handshake() == null) {
                return new CacheStrategy(this.request, null);
            }
            if (!CacheStrategy.Companion.isCacheable(this.cacheResponse, this.request)) {
                return new CacheStrategy(this.request, null);
            }
            CacheControl cacheControl = this.request.cacheControl();
            if (!cacheControl.noCache() && !hasConditions(this.request)) {
                CacheControl cacheControl2 = this.cacheResponse.cacheControl();
                long cacheResponseAge = cacheResponseAge();
                long computeFreshnessLifetime = computeFreshnessLifetime();
                if (cacheControl.maxAgeSeconds() != -1) {
                    computeFreshnessLifetime = Math.min(computeFreshnessLifetime, TimeUnit.SECONDS.toMillis(cacheControl.maxAgeSeconds()));
                }
                long j2 = 0;
                long millis = cacheControl.minFreshSeconds() != -1 ? TimeUnit.SECONDS.toMillis(cacheControl.minFreshSeconds()) : 0L;
                if (!cacheControl2.mustRevalidate() && cacheControl.maxStaleSeconds() != -1) {
                    j2 = TimeUnit.SECONDS.toMillis(cacheControl.maxStaleSeconds());
                }
                if (!cacheControl2.noCache()) {
                    long j3 = millis + cacheResponseAge;
                    if (j3 < j2 + computeFreshnessLifetime) {
                        Response.Builder newBuilder = this.cacheResponse.newBuilder();
                        if (j3 >= computeFreshnessLifetime) {
                            newBuilder.addHeader("Warning", "110 HttpURLConnection \"Response is stale\"");
                        }
                        if (cacheResponseAge > 86400000 && isFreshnessLifetimeHeuristic()) {
                            newBuilder.addHeader("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                        }
                        return new CacheStrategy(null, newBuilder.build());
                    }
                }
                String str = this.etag;
                String str2 = "If-Modified-Since";
                if (str != null) {
                    str2 = "If-None-Match";
                } else if (this.lastModified != null) {
                    str = this.lastModifiedString;
                } else if (this.servedDate != null) {
                    str = this.servedDateString;
                } else {
                    return new CacheStrategy(this.request, null);
                }
                Headers.Builder newBuilder2 = this.request.headers().newBuilder();
                newBuilder2.addLenient$okhttp(str2, str);
                return new CacheStrategy(this.request.newBuilder().headers(newBuilder2.build()).build(), this.cacheResponse);
            }
            return new CacheStrategy(this.request, null);
        }

        private final long computeFreshnessLifetime() {
            CacheControl cacheControl = this.cacheResponse.cacheControl();
            if (cacheControl.maxAgeSeconds() != -1) {
                return TimeUnit.SECONDS.toMillis(cacheControl.maxAgeSeconds());
            }
            Date date = this.expires;
            if (date != null) {
                Date date2 = this.servedDate;
                long time = date.getTime() - (date2 != null ? date2.getTime() : this.receivedResponseMillis);
                if (time > 0) {
                    return time;
                }
                return 0L;
            } else if (this.lastModified == null || this.cacheResponse.request().url().query() != null) {
                return 0L;
            } else {
                Date date3 = this.servedDate;
                long time2 = (date3 != null ? date3.getTime() : this.sentRequestMillis) - this.lastModified.getTime();
                if (time2 > 0) {
                    return time2 / 10;
                }
                return 0L;
            }
        }

        private final boolean hasConditions(Request request) {
            return (request.header("If-Modified-Since") == null && request.header("If-None-Match") == null) ? false : true;
        }

        private final boolean isFreshnessLifetimeHeuristic() {
            return this.cacheResponse.cacheControl().maxAgeSeconds() == -1 && this.expires == null;
        }

        @d
        public final CacheStrategy compute() {
            CacheStrategy computeCandidate = computeCandidate();
            return (computeCandidate.getNetworkRequest() == null || !this.request.cacheControl().onlyIfCached()) ? computeCandidate : new CacheStrategy(null, null);
        }

        @d
        public final Request getRequest$okhttp() {
            return this.request;
        }
    }

    public CacheStrategy(@e Request request, @e Response response) {
        this.networkRequest = request;
        this.cacheResponse = response;
    }

    @e
    public final Response getCacheResponse() {
        return this.cacheResponse;
    }

    @e
    public final Request getNetworkRequest() {
        return this.networkRequest;
    }
}
