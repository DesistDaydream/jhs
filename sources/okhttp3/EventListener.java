package okhttp3;

import h.k2.d;
import h.k2.v.u;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\b&\u0018\u0000 N2\u00020\u0001:\u0002NOB\u0007¢\u0006\u0004\bL\u0010MJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ2\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0011\u0010\u000e\u001a\r\u0012\t\u0012\u00070\f¢\u0006\u0002\b\r0\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J2\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0011\u0010\u0016\u001a\r\u0012\t\u0012\u00070\u0015¢\u0006\u0002\b\r0\u000bH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001e\u0010\u0006J!\u0010!\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016¢\u0006\u0004\b!\u0010\"J1\u0010%\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\f2\b\u0010$\u001a\u0004\u0018\u00010#H\u0016¢\u0006\u0004\b%\u0010&J9\u0010)\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\f2\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b)\u0010*J\u001f\u0010-\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010,\u001a\u00020+H\u0016¢\u0006\u0004\b-\u0010.J\u001f\u0010/\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010,\u001a\u00020+H\u0016¢\u0006\u0004\b/\u0010.J\u0017\u00100\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b0\u0010\u0006J\u001f\u00103\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u00102\u001a\u000201H\u0016¢\u0006\u0004\b3\u00104J\u0017\u00105\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b5\u0010\u0006J\u001f\u00108\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u00107\u001a\u000206H\u0016¢\u0006\u0004\b8\u00109J\u001f\u0010:\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b:\u0010;J\u0017\u0010<\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b<\u0010\u0006J\u001f\u0010?\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010>\u001a\u00020=H\u0016¢\u0006\u0004\b?\u0010@J\u0017\u0010A\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\bA\u0010\u0006J\u001f\u0010B\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u00107\u001a\u000206H\u0016¢\u0006\u0004\bB\u00109J\u001f\u0010C\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\bC\u0010;J\u0017\u0010D\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\bD\u0010\u0006J\u001f\u0010E\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\bE\u0010;J\u0017\u0010F\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\bF\u0010\u0006J\u001f\u0010G\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010>\u001a\u00020=H\u0016¢\u0006\u0004\bG\u0010@J\u001f\u0010H\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010>\u001a\u00020=H\u0016¢\u0006\u0004\bH\u0010@J\u0017\u0010I\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\bI\u0010\u0006J\u001f\u0010K\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010J\u001a\u00020=H\u0016¢\u0006\u0004\bK\u0010@¨\u0006P"}, d2 = {"Lokhttp3/EventListener;", "", "Lokhttp3/Call;", "call", "Lh/t1;", "callStart", "(Lokhttp3/Call;)V", "Lokhttp3/HttpUrl;", "url", "proxySelectStart", "(Lokhttp3/Call;Lokhttp3/HttpUrl;)V", "", "Ljava/net/Proxy;", "Lh/k2/l;", "proxies", "proxySelectEnd", "(Lokhttp3/Call;Lokhttp3/HttpUrl;Ljava/util/List;)V", "", "domainName", "dnsStart", "(Lokhttp3/Call;Ljava/lang/String;)V", "Ljava/net/InetAddress;", "inetAddressList", "dnsEnd", "(Lokhttp3/Call;Ljava/lang/String;Ljava/util/List;)V", "Ljava/net/InetSocketAddress;", "inetSocketAddress", "proxy", "connectStart", "(Lokhttp3/Call;Ljava/net/InetSocketAddress;Ljava/net/Proxy;)V", "secureConnectStart", "Lokhttp3/Handshake;", "handshake", "secureConnectEnd", "(Lokhttp3/Call;Lokhttp3/Handshake;)V", "Lokhttp3/Protocol;", "protocol", "connectEnd", "(Lokhttp3/Call;Ljava/net/InetSocketAddress;Ljava/net/Proxy;Lokhttp3/Protocol;)V", "Ljava/io/IOException;", "ioe", "connectFailed", "(Lokhttp3/Call;Ljava/net/InetSocketAddress;Ljava/net/Proxy;Lokhttp3/Protocol;Ljava/io/IOException;)V", "Lokhttp3/Connection;", "connection", "connectionAcquired", "(Lokhttp3/Call;Lokhttp3/Connection;)V", "connectionReleased", "requestHeadersStart", "Lokhttp3/Request;", "request", "requestHeadersEnd", "(Lokhttp3/Call;Lokhttp3/Request;)V", "requestBodyStart", "", "byteCount", "requestBodyEnd", "(Lokhttp3/Call;J)V", "requestFailed", "(Lokhttp3/Call;Ljava/io/IOException;)V", "responseHeadersStart", "Lokhttp3/Response;", "response", "responseHeadersEnd", "(Lokhttp3/Call;Lokhttp3/Response;)V", "responseBodyStart", "responseBodyEnd", "responseFailed", "callEnd", "callFailed", "canceled", "satisfactionFailure", "cacheHit", "cacheMiss", "cachedResponse", "cacheConditionalHit", "<init>", "()V", "Companion", "Factory", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public abstract class EventListener {
    public static final Companion Companion = new Companion(null);
    @d
    @k.e.a.d
    public static final EventListener NONE = new EventListener() { // from class: okhttp3.EventListener$Companion$NONE$1
    };

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lokhttp3/EventListener$Companion;", "", "Lokhttp3/EventListener;", "NONE", "Lokhttp3/EventListener;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(u uVar) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lokhttp3/EventListener$Factory;", "", "Lokhttp3/Call;", "call", "Lokhttp3/EventListener;", "create", "(Lokhttp3/Call;)Lokhttp3/EventListener;", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public interface Factory {
        @k.e.a.d
        EventListener create(@k.e.a.d Call call);
    }

    public void cacheConditionalHit(@k.e.a.d Call call, @k.e.a.d Response response) {
    }

    public void cacheHit(@k.e.a.d Call call, @k.e.a.d Response response) {
    }

    public void cacheMiss(@k.e.a.d Call call) {
    }

    public void callEnd(@k.e.a.d Call call) {
    }

    public void callFailed(@k.e.a.d Call call, @k.e.a.d IOException iOException) {
    }

    public void callStart(@k.e.a.d Call call) {
    }

    public void canceled(@k.e.a.d Call call) {
    }

    public void connectEnd(@k.e.a.d Call call, @k.e.a.d InetSocketAddress inetSocketAddress, @k.e.a.d Proxy proxy, @e Protocol protocol) {
    }

    public void connectFailed(@k.e.a.d Call call, @k.e.a.d InetSocketAddress inetSocketAddress, @k.e.a.d Proxy proxy, @e Protocol protocol, @k.e.a.d IOException iOException) {
    }

    public void connectStart(@k.e.a.d Call call, @k.e.a.d InetSocketAddress inetSocketAddress, @k.e.a.d Proxy proxy) {
    }

    public void connectionAcquired(@k.e.a.d Call call, @k.e.a.d Connection connection) {
    }

    public void connectionReleased(@k.e.a.d Call call, @k.e.a.d Connection connection) {
    }

    public void dnsEnd(@k.e.a.d Call call, @k.e.a.d String str, @k.e.a.d List<InetAddress> list) {
    }

    public void dnsStart(@k.e.a.d Call call, @k.e.a.d String str) {
    }

    public void proxySelectEnd(@k.e.a.d Call call, @k.e.a.d HttpUrl httpUrl, @k.e.a.d List<Proxy> list) {
    }

    public void proxySelectStart(@k.e.a.d Call call, @k.e.a.d HttpUrl httpUrl) {
    }

    public void requestBodyEnd(@k.e.a.d Call call, long j2) {
    }

    public void requestBodyStart(@k.e.a.d Call call) {
    }

    public void requestFailed(@k.e.a.d Call call, @k.e.a.d IOException iOException) {
    }

    public void requestHeadersEnd(@k.e.a.d Call call, @k.e.a.d Request request) {
    }

    public void requestHeadersStart(@k.e.a.d Call call) {
    }

    public void responseBodyEnd(@k.e.a.d Call call, long j2) {
    }

    public void responseBodyStart(@k.e.a.d Call call) {
    }

    public void responseFailed(@k.e.a.d Call call, @k.e.a.d IOException iOException) {
    }

    public void responseHeadersEnd(@k.e.a.d Call call, @k.e.a.d Response response) {
    }

    public void responseHeadersStart(@k.e.a.d Call call) {
    }

    public void satisfactionFailure(@k.e.a.d Call call, @k.e.a.d Response response) {
    }

    public void secureConnectEnd(@k.e.a.d Call call, @e Handshake handshake) {
    }

    public void secureConnectStart(@k.e.a.d Call call) {
    }
}
