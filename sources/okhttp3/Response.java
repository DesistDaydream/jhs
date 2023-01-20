package okhttp3;

import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import h.i;
import h.k2.g;
import h.k2.h;
import h.q0;
import j.m;
import j.o;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import okhttp3.Headers;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.http.HttpHeaders;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001XB}\b\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\r\u001a\u00020\n\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0018\u001a\u00020\u001d\u0012\b\u0010(\u001a\u0004\u0018\u00010#\u0012\b\u0010.\u001a\u0004\u0018\u00010\u0000\u0012\b\u00100\u001a\u0004\u0018\u00010\u0000\u0012\b\u00102\u001a\u0004\u0018\u00010\u0000\u0012\u0006\u0010<\u001a\u00020!\u0012\u0006\u0010>\u001a\u00020!\u0012\b\u0010D\u001a\u0004\u0018\u00010C¢\u0006\u0004\bV\u0010WJ\u000f\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0011\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010\u0015\u001a\u0004\u0018\u00010\u0012H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00172\u0006\u0010\u0016\u001a\u00020\u000e¢\u0006\u0004\b\u0018\u0010\u0019J%\u0010\u001b\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0016\u001a\u00020\u000e2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u0018\u001a\u00020\u001dH\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010 \u001a\u00020\u001d¢\u0006\u0004\b \u0010\u001fJ\u0015\u0010$\u001a\u00020#2\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b$\u0010%J\u0011\u0010(\u001a\u0004\u0018\u00010#H\u0007¢\u0006\u0004\b&\u0010'J\r\u0010*\u001a\u00020)¢\u0006\u0004\b*\u0010+J\u0011\u0010.\u001a\u0004\u0018\u00010\u0000H\u0007¢\u0006\u0004\b,\u0010-J\u0011\u00100\u001a\u0004\u0018\u00010\u0000H\u0007¢\u0006\u0004\b/\u0010-J\u0011\u00102\u001a\u0004\u0018\u00010\u0000H\u0007¢\u0006\u0004\b1\u0010-J\u0013\u00104\u001a\b\u0012\u0004\u0012\u0002030\u0017¢\u0006\u0004\b4\u00105J\u000f\u00109\u001a\u000206H\u0007¢\u0006\u0004\b7\u00108J\u000f\u0010<\u001a\u00020!H\u0007¢\u0006\u0004\b:\u0010;J\u000f\u0010>\u001a\u00020!H\u0007¢\u0006\u0004\b=\u0010;J\u000f\u0010@\u001a\u00020?H\u0016¢\u0006\u0004\b@\u0010AJ\u000f\u0010B\u001a\u00020\u000eH\u0016¢\u0006\u0004\bB\u0010\u0010R\u001e\u0010D\u001a\u0004\u0018\u00010C8\u0001@\u0000X\u0080\u0004¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bD\u0010FR\u0019\u0010\t\u001a\u00020\u00068\u0007@\u0006¢\u0006\f\n\u0004\b\t\u0010G\u001a\u0004\b\t\u0010\bR\u0019\u0010<\u001a\u00020!8\u0007@\u0006¢\u0006\f\n\u0004\b<\u0010H\u001a\u0004\b<\u0010;R\u001b\u0010(\u001a\u0004\u0018\u00010#8\u0007@\u0006¢\u0006\f\n\u0004\b(\u0010I\u001a\u0004\b(\u0010'R\u0019\u0010\u0018\u001a\u00020\u001d8\u0007@\u0006¢\u0006\f\n\u0004\b\u0018\u0010J\u001a\u0004\b\u0018\u0010\u001fR\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0007@\u0006¢\u0006\f\n\u0004\b\u0015\u0010K\u001a\u0004\b\u0015\u0010\u0014R\u001b\u0010.\u001a\u0004\u0018\u00010\u00008\u0007@\u0006¢\u0006\f\n\u0004\b.\u0010L\u001a\u0004\b.\u0010-R\u0019\u0010\u0005\u001a\u00020\u00028\u0007@\u0006¢\u0006\f\n\u0004\b\u0005\u0010M\u001a\u0004\b\u0005\u0010\u0004R\u0019\u0010\u0011\u001a\u00020\u000e8\u0007@\u0006¢\u0006\f\n\u0004\b\u0011\u0010N\u001a\u0004\b\u0011\u0010\u0010R\u001b\u00100\u001a\u0004\u0018\u00010\u00008\u0007@\u0006¢\u0006\f\n\u0004\b0\u0010L\u001a\u0004\b0\u0010-R\u001b\u00102\u001a\u0004\u0018\u00010\u00008\u0007@\u0006¢\u0006\f\n\u0004\b2\u0010L\u001a\u0004\b2\u0010-R\u0013\u0010P\u001a\u00020O8F@\u0006¢\u0006\u0006\u001a\u0004\bP\u0010QR\u0013\u00109\u001a\u0002068G@\u0006¢\u0006\u0006\u001a\u0004\b9\u00108R\u0018\u0010R\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010SR\u0013\u0010T\u001a\u00020O8F@\u0006¢\u0006\u0006\u001a\u0004\bT\u0010QR\u0019\u0010\r\u001a\u00020\n8\u0007@\u0006¢\u0006\f\n\u0004\b\r\u0010U\u001a\u0004\b\r\u0010\fR\u0019\u0010>\u001a\u00020!8\u0007@\u0006¢\u0006\f\n\u0004\b>\u0010H\u001a\u0004\b>\u0010;¨\u0006Y"}, d2 = {"Lokhttp3/Response;", "Ljava/io/Closeable;", "Lokhttp3/Request;", "-deprecated_request", "()Lokhttp3/Request;", "request", "Lokhttp3/Protocol;", "-deprecated_protocol", "()Lokhttp3/Protocol;", "protocol", "", "-deprecated_code", "()I", "code", "", "-deprecated_message", "()Ljava/lang/String;", "message", "Lokhttp3/Handshake;", "-deprecated_handshake", "()Lokhttp3/Handshake;", "handshake", "name", "", "headers", "(Ljava/lang/String;)Ljava/util/List;", "defaultValue", "header", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "Lokhttp3/Headers;", "-deprecated_headers", "()Lokhttp3/Headers;", "trailers", "", "byteCount", "Lokhttp3/ResponseBody;", "peekBody", "(J)Lokhttp3/ResponseBody;", "-deprecated_body", "()Lokhttp3/ResponseBody;", "body", "Lokhttp3/Response$Builder;", "newBuilder", "()Lokhttp3/Response$Builder;", "-deprecated_networkResponse", "()Lokhttp3/Response;", "networkResponse", "-deprecated_cacheResponse", "cacheResponse", "-deprecated_priorResponse", "priorResponse", "Lokhttp3/Challenge;", "challenges", "()Ljava/util/List;", "Lokhttp3/CacheControl;", "-deprecated_cacheControl", "()Lokhttp3/CacheControl;", "cacheControl", "-deprecated_sentRequestAtMillis", "()J", "sentRequestAtMillis", "-deprecated_receivedResponseAtMillis", "receivedResponseAtMillis", "Lh/t1;", "close", "()V", "toString", "Lokhttp3/internal/connection/Exchange;", "exchange", "Lokhttp3/internal/connection/Exchange;", "()Lokhttp3/internal/connection/Exchange;", "Lokhttp3/Protocol;", "J", "Lokhttp3/ResponseBody;", "Lokhttp3/Headers;", "Lokhttp3/Handshake;", "Lokhttp3/Response;", "Lokhttp3/Request;", "Ljava/lang/String;", "", "isSuccessful", "()Z", "lazyCacheControl", "Lokhttp3/CacheControl;", "isRedirect", ExpandableTextView.P, "<init>", "(Lokhttp3/Request;Lokhttp3/Protocol;Ljava/lang/String;ILokhttp3/Handshake;Lokhttp3/Headers;Lokhttp3/ResponseBody;Lokhttp3/Response;Lokhttp3/Response;Lokhttp3/Response;JJLokhttp3/internal/connection/Exchange;)V", "Builder", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class Response implements Closeable {
    @e
    private final ResponseBody body;
    @e
    private final Response cacheResponse;
    private final int code;
    @e
    private final Exchange exchange;
    @e
    private final Handshake handshake;
    @d
    private final Headers headers;
    private CacheControl lazyCacheControl;
    @d
    private final String message;
    @e
    private final Response networkResponse;
    @e
    private final Response priorResponse;
    @d
    private final Protocol protocol;
    private final long receivedResponseAtMillis;
    @d
    private final Request request;
    private final long sentRequestAtMillis;

    public Response(@d Request request, @d Protocol protocol, @d String str, int i2, @e Handshake handshake, @d Headers headers, @e ResponseBody responseBody, @e Response response, @e Response response2, @e Response response3, long j2, long j3, @e Exchange exchange) {
        this.request = request;
        this.protocol = protocol;
        this.message = str;
        this.code = i2;
        this.handshake = handshake;
        this.headers = headers;
        this.body = responseBody;
        this.networkResponse = response;
        this.cacheResponse = response2;
        this.priorResponse = response3;
        this.sentRequestAtMillis = j2;
        this.receivedResponseAtMillis = j3;
        this.exchange = exchange;
    }

    public static /* synthetic */ String header$default(Response response, String str, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        return response.header(str, str2);
    }

    @g(name = "-deprecated_body")
    @e
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "body", imports = {}))
    /* renamed from: -deprecated_body  reason: not valid java name */
    public final ResponseBody m235deprecated_body() {
        return this.body;
    }

    @g(name = "-deprecated_cacheControl")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "cacheControl", imports = {}))
    @d
    /* renamed from: -deprecated_cacheControl  reason: not valid java name */
    public final CacheControl m236deprecated_cacheControl() {
        return cacheControl();
    }

    @g(name = "-deprecated_cacheResponse")
    @e
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "cacheResponse", imports = {}))
    /* renamed from: -deprecated_cacheResponse  reason: not valid java name */
    public final Response m237deprecated_cacheResponse() {
        return this.cacheResponse;
    }

    @g(name = "-deprecated_code")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "code", imports = {}))
    /* renamed from: -deprecated_code  reason: not valid java name */
    public final int m238deprecated_code() {
        return this.code;
    }

    @g(name = "-deprecated_handshake")
    @e
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "handshake", imports = {}))
    /* renamed from: -deprecated_handshake  reason: not valid java name */
    public final Handshake m239deprecated_handshake() {
        return this.handshake;
    }

    @g(name = "-deprecated_headers")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "headers", imports = {}))
    @d
    /* renamed from: -deprecated_headers  reason: not valid java name */
    public final Headers m240deprecated_headers() {
        return this.headers;
    }

    @g(name = "-deprecated_message")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "message", imports = {}))
    @d
    /* renamed from: -deprecated_message  reason: not valid java name */
    public final String m241deprecated_message() {
        return this.message;
    }

    @g(name = "-deprecated_networkResponse")
    @e
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "networkResponse", imports = {}))
    /* renamed from: -deprecated_networkResponse  reason: not valid java name */
    public final Response m242deprecated_networkResponse() {
        return this.networkResponse;
    }

    @g(name = "-deprecated_priorResponse")
    @e
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "priorResponse", imports = {}))
    /* renamed from: -deprecated_priorResponse  reason: not valid java name */
    public final Response m243deprecated_priorResponse() {
        return this.priorResponse;
    }

    @g(name = "-deprecated_protocol")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "protocol", imports = {}))
    @d
    /* renamed from: -deprecated_protocol  reason: not valid java name */
    public final Protocol m244deprecated_protocol() {
        return this.protocol;
    }

    @g(name = "-deprecated_receivedResponseAtMillis")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "receivedResponseAtMillis", imports = {}))
    /* renamed from: -deprecated_receivedResponseAtMillis  reason: not valid java name */
    public final long m245deprecated_receivedResponseAtMillis() {
        return this.receivedResponseAtMillis;
    }

    @g(name = "-deprecated_request")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "request", imports = {}))
    @d
    /* renamed from: -deprecated_request  reason: not valid java name */
    public final Request m246deprecated_request() {
        return this.request;
    }

    @g(name = "-deprecated_sentRequestAtMillis")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "sentRequestAtMillis", imports = {}))
    /* renamed from: -deprecated_sentRequestAtMillis  reason: not valid java name */
    public final long m247deprecated_sentRequestAtMillis() {
        return this.sentRequestAtMillis;
    }

    @g(name = "body")
    @e
    public final ResponseBody body() {
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

    @g(name = "cacheResponse")
    @e
    public final Response cacheResponse() {
        return this.cacheResponse;
    }

    @d
    public final List<Challenge> challenges() {
        String str;
        Headers headers = this.headers;
        int i2 = this.code;
        if (i2 == 401) {
            str = "WWW-Authenticate";
        } else if (i2 != 407) {
            return CollectionsKt__CollectionsKt.E();
        } else {
            str = "Proxy-Authenticate";
        }
        return HttpHeaders.parseChallenges(headers, str);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ResponseBody responseBody = this.body;
        if (responseBody == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed".toString());
        }
        responseBody.close();
    }

    @g(name = "code")
    public final int code() {
        return this.code;
    }

    @g(name = "exchange")
    @e
    public final Exchange exchange() {
        return this.exchange;
    }

    @g(name = "handshake")
    @e
    public final Handshake handshake() {
        return this.handshake;
    }

    @h
    @e
    public final String header(@d String str) {
        return header$default(this, str, null, 2, null);
    }

    @h
    @e
    public final String header(@d String str, @e String str2) {
        String str3 = this.headers.get(str);
        return str3 != null ? str3 : str2;
    }

    @g(name = "headers")
    @d
    public final Headers headers() {
        return this.headers;
    }

    public final boolean isRedirect() {
        int i2 = this.code;
        if (i2 != 307 && i2 != 308) {
            switch (i2) {
                case 300:
                case 301:
                case 302:
                case 303:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    public final boolean isSuccessful() {
        int i2 = this.code;
        return 200 <= i2 && 299 >= i2;
    }

    @g(name = "message")
    @d
    public final String message() {
        return this.message;
    }

    @g(name = "networkResponse")
    @e
    public final Response networkResponse() {
        return this.networkResponse;
    }

    @d
    public final Builder newBuilder() {
        return new Builder(this);
    }

    @d
    public final ResponseBody peekBody(long j2) throws IOException {
        o peek = this.body.source().peek();
        m mVar = new m();
        peek.G(j2);
        mVar.l0(peek, Math.min(j2, peek.getBuffer().O0()));
        return ResponseBody.Companion.create(mVar, this.body.contentType(), mVar.O0());
    }

    @g(name = "priorResponse")
    @e
    public final Response priorResponse() {
        return this.priorResponse;
    }

    @g(name = "protocol")
    @d
    public final Protocol protocol() {
        return this.protocol;
    }

    @g(name = "receivedResponseAtMillis")
    public final long receivedResponseAtMillis() {
        return this.receivedResponseAtMillis;
    }

    @g(name = "request")
    @d
    public final Request request() {
        return this.request;
    }

    @g(name = "sentRequestAtMillis")
    public final long sentRequestAtMillis() {
        return this.sentRequestAtMillis;
    }

    @d
    public String toString() {
        return "Response{protocol=" + this.protocol + ", code=" + this.code + ", message=" + this.message + ", url=" + this.request.url() + '}';
    }

    @d
    public final Headers trailers() throws IOException {
        Exchange exchange = this.exchange;
        if (exchange != null) {
            return exchange.trailers();
        }
        throw new IllegalStateException("trailers not available".toString());
    }

    @d
    public final List<String> headers(@d String str) {
        return this.headers.values(str);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b \b\u0016\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\bj\u0010kB\u0011\b\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\bj\u0010\nJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\t\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0017\u001a\u00020\u00002\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001c\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001d\u0010\u0015J\u0017\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010\"\u001a\u00020\u00002\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\b\"\u0010#J\u0019\u0010$\u001a\u00020\u00002\b\u0010$\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b$\u0010%J\u0019\u0010&\u001a\u00020\u00002\b\u0010&\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b&\u0010%J\u0019\u0010'\u001a\u00020\u00002\b\u0010'\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b'\u0010%J\u0017\u0010)\u001a\u00020\u00002\u0006\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b)\u0010*J\u0017\u0010+\u001a\u00020\u00002\u0006\u0010+\u001a\u00020(H\u0016¢\u0006\u0004\b+\u0010*J\u0017\u00100\u001a\u00020\u00062\u0006\u0010-\u001a\u00020,H\u0000¢\u0006\u0004\b.\u0010/J\u000f\u00101\u001a\u00020\u0004H\u0016¢\u0006\u0004\b1\u00102R$\u0010$\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b$\u00103\u001a\u0004\b4\u00102\"\u0004\b5\u0010\nR$\u0010&\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b&\u00103\u001a\u0004\b6\u00102\"\u0004\b7\u0010\nR\"\u0010+\u001a\u00020(8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b+\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR$\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\f\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR$\u0010\"\u001a\u0004\u0018\u00010!8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\"\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\"\u0010\u001f\u001a\u00020L8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR$\u0010R\u001a\u0004\u0018\u00010,8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010/R\"\u0010)\u001a\u00020(8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b)\u00108\u001a\u0004\bW\u0010:\"\u0004\bX\u0010<R$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\"\u0010\u0012\u001a\u00020\u00118\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR$\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010c\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR$\u0010'\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b'\u00103\u001a\u0004\bh\u00102\"\u0004\bi\u0010\n¨\u0006l"}, d2 = {"Lokhttp3/Response$Builder;", "", "", "name", "Lokhttp3/Response;", "response", "Lh/t1;", "checkSupportResponse", "(Ljava/lang/String;Lokhttp3/Response;)V", "checkPriorResponse", "(Lokhttp3/Response;)V", "Lokhttp3/Request;", "request", "(Lokhttp3/Request;)Lokhttp3/Response$Builder;", "Lokhttp3/Protocol;", "protocol", "(Lokhttp3/Protocol;)Lokhttp3/Response$Builder;", "", "code", "(I)Lokhttp3/Response$Builder;", "message", "(Ljava/lang/String;)Lokhttp3/Response$Builder;", "Lokhttp3/Handshake;", "handshake", "(Lokhttp3/Handshake;)Lokhttp3/Response$Builder;", "value", "header", "(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Response$Builder;", "addHeader", "removeHeader", "Lokhttp3/Headers;", "headers", "(Lokhttp3/Headers;)Lokhttp3/Response$Builder;", "Lokhttp3/ResponseBody;", "body", "(Lokhttp3/ResponseBody;)Lokhttp3/Response$Builder;", "networkResponse", "(Lokhttp3/Response;)Lokhttp3/Response$Builder;", "cacheResponse", "priorResponse", "", "sentRequestAtMillis", "(J)Lokhttp3/Response$Builder;", "receivedResponseAtMillis", "Lokhttp3/internal/connection/Exchange;", "deferredTrailers", "initExchange$okhttp", "(Lokhttp3/internal/connection/Exchange;)V", "initExchange", "build", "()Lokhttp3/Response;", "Lokhttp3/Response;", "getNetworkResponse$okhttp", "setNetworkResponse$okhttp", "getCacheResponse$okhttp", "setCacheResponse$okhttp", "J", "getReceivedResponseAtMillis$okhttp", "()J", "setReceivedResponseAtMillis$okhttp", "(J)V", "Lokhttp3/Protocol;", "getProtocol$okhttp", "()Lokhttp3/Protocol;", "setProtocol$okhttp", "(Lokhttp3/Protocol;)V", "Lokhttp3/Request;", "getRequest$okhttp", "()Lokhttp3/Request;", "setRequest$okhttp", "(Lokhttp3/Request;)V", "Lokhttp3/ResponseBody;", "getBody$okhttp", "()Lokhttp3/ResponseBody;", "setBody$okhttp", "(Lokhttp3/ResponseBody;)V", "Lokhttp3/Headers$Builder;", "Lokhttp3/Headers$Builder;", "getHeaders$okhttp", "()Lokhttp3/Headers$Builder;", "setHeaders$okhttp", "(Lokhttp3/Headers$Builder;)V", "exchange", "Lokhttp3/internal/connection/Exchange;", "getExchange$okhttp", "()Lokhttp3/internal/connection/Exchange;", "setExchange$okhttp", "getSentRequestAtMillis$okhttp", "setSentRequestAtMillis$okhttp", "Lokhttp3/Handshake;", "getHandshake$okhttp", "()Lokhttp3/Handshake;", "setHandshake$okhttp", "(Lokhttp3/Handshake;)V", ExpandableTextView.P, "getCode$okhttp", "()I", "setCode$okhttp", "(I)V", "Ljava/lang/String;", "getMessage$okhttp", "()Ljava/lang/String;", "setMessage$okhttp", "(Ljava/lang/String;)V", "getPriorResponse$okhttp", "setPriorResponse$okhttp", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static class Builder {
        @e
        private ResponseBody body;
        @e
        private Response cacheResponse;
        private int code;
        @e
        private Exchange exchange;
        @e
        private Handshake handshake;
        @d
        private Headers.Builder headers;
        @e
        private String message;
        @e
        private Response networkResponse;
        @e
        private Response priorResponse;
        @e
        private Protocol protocol;
        private long receivedResponseAtMillis;
        @e
        private Request request;
        private long sentRequestAtMillis;

        public Builder() {
            this.code = -1;
            this.headers = new Headers.Builder();
        }

        private final void checkPriorResponse(Response response) {
            if (response != null) {
                if (!(response.body() == null)) {
                    throw new IllegalArgumentException("priorResponse.body != null".toString());
                }
            }
        }

        private final void checkSupportResponse(String str, Response response) {
            if (response != null) {
                if (response.body() == null) {
                    if (response.networkResponse() == null) {
                        if (response.cacheResponse() == null) {
                            if (response.priorResponse() == null) {
                                return;
                            }
                            throw new IllegalArgumentException((str + ".priorResponse != null").toString());
                        }
                        throw new IllegalArgumentException((str + ".cacheResponse != null").toString());
                    }
                    throw new IllegalArgumentException((str + ".networkResponse != null").toString());
                }
                throw new IllegalArgumentException((str + ".body != null").toString());
            }
        }

        @d
        public Builder addHeader(@d String str, @d String str2) {
            this.headers.add(str, str2);
            return this;
        }

        @d
        public Builder body(@e ResponseBody responseBody) {
            this.body = responseBody;
            return this;
        }

        @d
        public Response build() {
            int i2 = this.code;
            if (i2 >= 0) {
                Request request = this.request;
                if (request != null) {
                    Protocol protocol = this.protocol;
                    if (protocol != null) {
                        String str = this.message;
                        if (str != null) {
                            return new Response(request, protocol, str, i2, this.handshake, this.headers.build(), this.body, this.networkResponse, this.cacheResponse, this.priorResponse, this.sentRequestAtMillis, this.receivedResponseAtMillis, this.exchange);
                        }
                        throw new IllegalStateException("message == null".toString());
                    }
                    throw new IllegalStateException("protocol == null".toString());
                }
                throw new IllegalStateException("request == null".toString());
            }
            throw new IllegalStateException(("code < 0: " + this.code).toString());
        }

        @d
        public Builder cacheResponse(@e Response response) {
            checkSupportResponse("cacheResponse", response);
            this.cacheResponse = response;
            return this;
        }

        @d
        public Builder code(int i2) {
            this.code = i2;
            return this;
        }

        @e
        public final ResponseBody getBody$okhttp() {
            return this.body;
        }

        @e
        public final Response getCacheResponse$okhttp() {
            return this.cacheResponse;
        }

        public final int getCode$okhttp() {
            return this.code;
        }

        @e
        public final Exchange getExchange$okhttp() {
            return this.exchange;
        }

        @e
        public final Handshake getHandshake$okhttp() {
            return this.handshake;
        }

        @d
        public final Headers.Builder getHeaders$okhttp() {
            return this.headers;
        }

        @e
        public final String getMessage$okhttp() {
            return this.message;
        }

        @e
        public final Response getNetworkResponse$okhttp() {
            return this.networkResponse;
        }

        @e
        public final Response getPriorResponse$okhttp() {
            return this.priorResponse;
        }

        @e
        public final Protocol getProtocol$okhttp() {
            return this.protocol;
        }

        public final long getReceivedResponseAtMillis$okhttp() {
            return this.receivedResponseAtMillis;
        }

        @e
        public final Request getRequest$okhttp() {
            return this.request;
        }

        public final long getSentRequestAtMillis$okhttp() {
            return this.sentRequestAtMillis;
        }

        @d
        public Builder handshake(@e Handshake handshake) {
            this.handshake = handshake;
            return this;
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

        public final void initExchange$okhttp(@d Exchange exchange) {
            this.exchange = exchange;
        }

        @d
        public Builder message(@d String str) {
            this.message = str;
            return this;
        }

        @d
        public Builder networkResponse(@e Response response) {
            checkSupportResponse("networkResponse", response);
            this.networkResponse = response;
            return this;
        }

        @d
        public Builder priorResponse(@e Response response) {
            checkPriorResponse(response);
            this.priorResponse = response;
            return this;
        }

        @d
        public Builder protocol(@d Protocol protocol) {
            this.protocol = protocol;
            return this;
        }

        @d
        public Builder receivedResponseAtMillis(long j2) {
            this.receivedResponseAtMillis = j2;
            return this;
        }

        @d
        public Builder removeHeader(@d String str) {
            this.headers.removeAll(str);
            return this;
        }

        @d
        public Builder request(@d Request request) {
            this.request = request;
            return this;
        }

        @d
        public Builder sentRequestAtMillis(long j2) {
            this.sentRequestAtMillis = j2;
            return this;
        }

        public final void setBody$okhttp(@e ResponseBody responseBody) {
            this.body = responseBody;
        }

        public final void setCacheResponse$okhttp(@e Response response) {
            this.cacheResponse = response;
        }

        public final void setCode$okhttp(int i2) {
            this.code = i2;
        }

        public final void setExchange$okhttp(@e Exchange exchange) {
            this.exchange = exchange;
        }

        public final void setHandshake$okhttp(@e Handshake handshake) {
            this.handshake = handshake;
        }

        public final void setHeaders$okhttp(@d Headers.Builder builder) {
            this.headers = builder;
        }

        public final void setMessage$okhttp(@e String str) {
            this.message = str;
        }

        public final void setNetworkResponse$okhttp(@e Response response) {
            this.networkResponse = response;
        }

        public final void setPriorResponse$okhttp(@e Response response) {
            this.priorResponse = response;
        }

        public final void setProtocol$okhttp(@e Protocol protocol) {
            this.protocol = protocol;
        }

        public final void setReceivedResponseAtMillis$okhttp(long j2) {
            this.receivedResponseAtMillis = j2;
        }

        public final void setRequest$okhttp(@e Request request) {
            this.request = request;
        }

        public final void setSentRequestAtMillis$okhttp(long j2) {
            this.sentRequestAtMillis = j2;
        }

        public Builder(@d Response response) {
            this.code = -1;
            this.request = response.request();
            this.protocol = response.protocol();
            this.code = response.code();
            this.message = response.message();
            this.handshake = response.handshake();
            this.headers = response.headers().newBuilder();
            this.body = response.body();
            this.networkResponse = response.networkResponse();
            this.cacheResponse = response.cacheResponse();
            this.priorResponse = response.priorResponse();
            this.sentRequestAtMillis = response.sentRequestAtMillis();
            this.receivedResponseAtMillis = response.receivedResponseAtMillis();
            this.exchange = response.exchange();
        }
    }
}
