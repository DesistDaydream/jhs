package okhttp3;

import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.qiniu.android.collect.ReportItem;
import com.qiniu.android.http.dns.DnsSource;
import com.umeng.analytics.pro.am;
import e.j.a.b.c.r.c0;
import h.a2.y;
import h.i;
import h.k2.g;
import h.k2.u.l;
import h.k2.v.f0;
import h.k2.v.u;
import h.q0;
import java.net.Proxy;
import java.net.ProxySelector;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import k.e.a.d;
import k.e.a.e;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.WebSocket;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RouteDatabase;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.proxy.NullProxySelector;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.OkHostnameVerifier;
import okhttp3.internal.ws.RealWebSocket;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ð\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0016\u0018\u0000 \u0090\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0004\u0091\u0001\u0090\u0001B\u0014\b\u0000\u0012\u0007\u0010\u008d\u0001\u001a\u00020\u0011¢\u0006\u0006\b\u008e\u0001\u0010\u008f\u0001B\n\b\u0016¢\u0006\u0005\b\u008e\u0001\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0017\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u001b\u001a\u00020\u0018H\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0007¢\u0006\u0004\b!\u0010\u001fJ\u000f\u0010&\u001a\u00020#H\u0007¢\u0006\u0004\b$\u0010%J\u000f\u0010*\u001a\u00020'H\u0007¢\u0006\u0004\b(\u0010)J\u000f\u0010.\u001a\u00020+H\u0007¢\u0006\u0004\b,\u0010-J\u000f\u00100\u001a\u00020'H\u0007¢\u0006\u0004\b/\u0010)J\u000f\u00102\u001a\u00020'H\u0007¢\u0006\u0004\b1\u0010)J\u000f\u00106\u001a\u000203H\u0007¢\u0006\u0004\b4\u00105J\u0011\u0010:\u001a\u0004\u0018\u000107H\u0007¢\u0006\u0004\b8\u00109J\u000f\u0010>\u001a\u00020;H\u0007¢\u0006\u0004\b<\u0010=J\u0011\u0010B\u001a\u0004\u0018\u00010?H\u0007¢\u0006\u0004\b@\u0010AJ\u000f\u0010F\u001a\u00020CH\u0007¢\u0006\u0004\bD\u0010EJ\u000f\u0010H\u001a\u00020+H\u0007¢\u0006\u0004\bG\u0010-J\u000f\u0010L\u001a\u00020IH\u0007¢\u0006\u0004\bJ\u0010KJ\u000f\u0010P\u001a\u00020MH\u0007¢\u0006\u0004\bN\u0010OJ\u0015\u0010S\u001a\b\u0012\u0004\u0012\u00020Q0\u001cH\u0007¢\u0006\u0004\bR\u0010\u001fJ\u0015\u0010V\u001a\b\u0012\u0004\u0012\u00020T0\u001cH\u0007¢\u0006\u0004\bU\u0010\u001fJ\u000f\u0010Z\u001a\u00020WH\u0007¢\u0006\u0004\bX\u0010YJ\u000f\u0010^\u001a\u00020[H\u0007¢\u0006\u0004\b\\\u0010]J\u000f\u0010b\u001a\u00020_H\u0007¢\u0006\u0004\b`\u0010aJ\u000f\u0010d\u001a\u00020_H\u0007¢\u0006\u0004\bc\u0010aJ\u000f\u0010f\u001a\u00020_H\u0007¢\u0006\u0004\be\u0010aJ\u000f\u0010h\u001a\u00020_H\u0007¢\u0006\u0004\bg\u0010aJ\u000f\u0010j\u001a\u00020_H\u0007¢\u0006\u0004\bi\u0010aR\u0019\u0010&\u001a\u00020#8G@\u0006¢\u0006\f\n\u0004\b&\u0010k\u001a\u0004\b&\u0010%R\u0019\u00102\u001a\u00020'8G@\u0006¢\u0006\f\n\u0004\b2\u0010l\u001a\u0004\b2\u0010)R\u0013\u0010P\u001a\u00020M8G@\u0006¢\u0006\u0006\u001a\u0004\bP\u0010OR\u0019\u0010f\u001a\u00020_8G@\u0006¢\u0006\f\n\u0004\bf\u0010m\u001a\u0004\bf\u0010aR\u001b\u0010o\u001a\u0004\u0018\u00010n8G@\u0006¢\u0006\f\n\u0004\bo\u0010p\u001a\u0004\bo\u0010qR\u0019\u0010*\u001a\u00020'8G@\u0006¢\u0006\f\n\u0004\b*\u0010l\u001a\u0004\b*\u0010)R\u001f\u0010V\u001a\b\u0012\u0004\u0012\u00020T0\u001c8G@\u0006¢\u0006\f\n\u0004\bV\u0010r\u001a\u0004\bV\u0010\u001fR\u0019\u0010t\u001a\u00020s8G@\u0006¢\u0006\f\n\u0004\bt\u0010u\u001a\u0004\bt\u0010vR\u001f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8G@\u0006¢\u0006\f\n\u0004\b \u0010r\u001a\u0004\b \u0010\u001fR\u001f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8G@\u0006¢\u0006\f\n\u0004\b\"\u0010r\u001a\u0004\b\"\u0010\u001fR\u0019\u0010.\u001a\u00020+8G@\u0006¢\u0006\f\n\u0004\b.\u0010w\u001a\u0004\b.\u0010-R\u001b\u0010B\u001a\u0004\u0018\u00010?8G@\u0006¢\u0006\f\n\u0004\bB\u0010x\u001a\u0004\bB\u0010AR\u0018\u0010y\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\by\u0010zR\u0019\u0010h\u001a\u00020_8G@\u0006¢\u0006\f\n\u0004\bh\u0010m\u001a\u0004\bh\u0010aR\u0019\u00106\u001a\u0002038G@\u0006¢\u0006\f\n\u0004\b6\u0010{\u001a\u0004\b6\u00105R\u0019\u0010j\u001a\u00020_8G@\u0006¢\u0006\f\n\u0004\bj\u0010m\u001a\u0004\bj\u0010aR\u001b\u0010:\u001a\u0004\u0018\u0001078G@\u0006¢\u0006\f\n\u0004\b:\u0010|\u001a\u0004\b:\u00109R\u001c\u0010~\u001a\u0004\u0018\u00010}8G@\u0006¢\u0006\r\n\u0004\b~\u0010\u007f\u001a\u0005\b~\u0010\u0080\u0001R\u0019\u00100\u001a\u00020'8G@\u0006¢\u0006\f\n\u0004\b0\u0010l\u001a\u0004\b0\u0010)R\u001f\u0010\u0082\u0001\u001a\u00030\u0081\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\b\u0082\u0001\u0010\u0083\u0001\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001R\u001a\u0010^\u001a\u00020[8G@\u0006¢\u0006\r\n\u0005\b^\u0010\u0086\u0001\u001a\u0004\b^\u0010]R\u001a\u0010F\u001a\u00020C8G@\u0006¢\u0006\r\n\u0005\bF\u0010\u0087\u0001\u001a\u0004\bF\u0010ER\u001a\u0010\u0017\u001a\u00020\u00148G@\u0006¢\u0006\r\n\u0005\b\u0017\u0010\u0088\u0001\u001a\u0004\b\u0017\u0010\u0016R\u0019\u0010b\u001a\u00020_8G@\u0006¢\u0006\f\n\u0004\bb\u0010m\u001a\u0004\bb\u0010aR\u001a\u0010>\u001a\u00020;8G@\u0006¢\u0006\r\n\u0005\b>\u0010\u0089\u0001\u001a\u0004\b>\u0010=R\u001a\u0010\u001b\u001a\u00020\u00188G@\u0006¢\u0006\r\n\u0005\b\u001b\u0010\u008a\u0001\u001a\u0004\b\u001b\u0010\u001aR\u0019\u0010H\u001a\u00020+8G@\u0006¢\u0006\f\n\u0004\bH\u0010w\u001a\u0004\bH\u0010-R\u001a\u0010L\u001a\u00020I8G@\u0006¢\u0006\r\n\u0005\bL\u0010\u008b\u0001\u001a\u0004\bL\u0010KR\u001f\u0010S\u001a\b\u0012\u0004\u0012\u00020Q0\u001c8G@\u0006¢\u0006\f\n\u0004\bS\u0010r\u001a\u0004\bS\u0010\u001fR\u001a\u0010Z\u001a\u00020W8G@\u0006¢\u0006\r\n\u0005\bZ\u0010\u008c\u0001\u001a\u0004\bZ\u0010YR\u0019\u0010d\u001a\u00020_8G@\u0006¢\u0006\f\n\u0004\bd\u0010m\u001a\u0004\bd\u0010a¨\u0006\u0092\u0001"}, d2 = {"Lokhttp3/OkHttpClient;", "", "Lokhttp3/Call$Factory;", "Lokhttp3/WebSocket$Factory;", "Lh/t1;", "verifyClientState", "()V", "Lokhttp3/Request;", "request", "Lokhttp3/Call;", "newCall", "(Lokhttp3/Request;)Lokhttp3/Call;", "Lokhttp3/WebSocketListener;", c0.a.a, "Lokhttp3/WebSocket;", "newWebSocket", "(Lokhttp3/Request;Lokhttp3/WebSocketListener;)Lokhttp3/WebSocket;", "Lokhttp3/OkHttpClient$Builder;", "newBuilder", "()Lokhttp3/OkHttpClient$Builder;", "Lokhttp3/Dispatcher;", "-deprecated_dispatcher", "()Lokhttp3/Dispatcher;", "dispatcher", "Lokhttp3/ConnectionPool;", "-deprecated_connectionPool", "()Lokhttp3/ConnectionPool;", "connectionPool", "", "Lokhttp3/Interceptor;", "-deprecated_interceptors", "()Ljava/util/List;", "interceptors", "-deprecated_networkInterceptors", "networkInterceptors", "Lokhttp3/EventListener$Factory;", "-deprecated_eventListenerFactory", "()Lokhttp3/EventListener$Factory;", "eventListenerFactory", "", "-deprecated_retryOnConnectionFailure", "()Z", "retryOnConnectionFailure", "Lokhttp3/Authenticator;", "-deprecated_authenticator", "()Lokhttp3/Authenticator;", "authenticator", "-deprecated_followRedirects", "followRedirects", "-deprecated_followSslRedirects", "followSslRedirects", "Lokhttp3/CookieJar;", "-deprecated_cookieJar", "()Lokhttp3/CookieJar;", "cookieJar", "Lokhttp3/Cache;", "-deprecated_cache", "()Lokhttp3/Cache;", "cache", "Lokhttp3/Dns;", "-deprecated_dns", "()Lokhttp3/Dns;", DnsSource.Udp, "Ljava/net/Proxy;", "-deprecated_proxy", "()Ljava/net/Proxy;", "proxy", "Ljava/net/ProxySelector;", "-deprecated_proxySelector", "()Ljava/net/ProxySelector;", "proxySelector", "-deprecated_proxyAuthenticator", "proxyAuthenticator", "Ljavax/net/SocketFactory;", "-deprecated_socketFactory", "()Ljavax/net/SocketFactory;", "socketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "-deprecated_sslSocketFactory", "()Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactory", "Lokhttp3/ConnectionSpec;", "-deprecated_connectionSpecs", "connectionSpecs", "Lokhttp3/Protocol;", "-deprecated_protocols", "protocols", "Ljavax/net/ssl/HostnameVerifier;", "-deprecated_hostnameVerifier", "()Ljavax/net/ssl/HostnameVerifier;", "hostnameVerifier", "Lokhttp3/CertificatePinner;", "-deprecated_certificatePinner", "()Lokhttp3/CertificatePinner;", "certificatePinner", "", "-deprecated_callTimeoutMillis", "()I", "callTimeoutMillis", "-deprecated_connectTimeoutMillis", "connectTimeoutMillis", "-deprecated_readTimeoutMillis", "readTimeoutMillis", "-deprecated_writeTimeoutMillis", "writeTimeoutMillis", "-deprecated_pingIntervalMillis", "pingIntervalMillis", "Lokhttp3/EventListener$Factory;", "Z", ExpandableTextView.P, "Lokhttp3/internal/tls/CertificateChainCleaner;", "certificateChainCleaner", "Lokhttp3/internal/tls/CertificateChainCleaner;", "()Lokhttp3/internal/tls/CertificateChainCleaner;", "Ljava/util/List;", "", "minWebSocketMessageToCompress", "J", "()J", "Lokhttp3/Authenticator;", "Ljava/net/Proxy;", "sslSocketFactoryOrNull", "Ljavax/net/ssl/SSLSocketFactory;", "Lokhttp3/CookieJar;", "Lokhttp3/Cache;", "Ljavax/net/ssl/X509TrustManager;", "x509TrustManager", "Ljavax/net/ssl/X509TrustManager;", "()Ljavax/net/ssl/X509TrustManager;", "Lokhttp3/internal/connection/RouteDatabase;", "routeDatabase", "Lokhttp3/internal/connection/RouteDatabase;", "getRouteDatabase", "()Lokhttp3/internal/connection/RouteDatabase;", "Lokhttp3/CertificatePinner;", "Ljava/net/ProxySelector;", "Lokhttp3/Dispatcher;", "Lokhttp3/Dns;", "Lokhttp3/ConnectionPool;", "Ljavax/net/SocketFactory;", "Ljavax/net/ssl/HostnameVerifier;", "builder", "<init>", "(Lokhttp3/OkHttpClient$Builder;)V", "Companion", "Builder", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public class OkHttpClient implements Cloneable, Call.Factory, WebSocket.Factory {
    @d
    private final Authenticator authenticator;
    @e
    private final Cache cache;
    private final int callTimeoutMillis;
    @e
    private final CertificateChainCleaner certificateChainCleaner;
    @d
    private final CertificatePinner certificatePinner;
    private final int connectTimeoutMillis;
    @d
    private final ConnectionPool connectionPool;
    @d
    private final List<ConnectionSpec> connectionSpecs;
    @d
    private final CookieJar cookieJar;
    @d
    private final Dispatcher dispatcher;
    @d
    private final Dns dns;
    @d
    private final EventListener.Factory eventListenerFactory;
    private final boolean followRedirects;
    private final boolean followSslRedirects;
    @d
    private final HostnameVerifier hostnameVerifier;
    @d
    private final List<Interceptor> interceptors;
    private final long minWebSocketMessageToCompress;
    @d
    private final List<Interceptor> networkInterceptors;
    private final int pingIntervalMillis;
    @d
    private final List<Protocol> protocols;
    @e
    private final Proxy proxy;
    @d
    private final Authenticator proxyAuthenticator;
    @d
    private final ProxySelector proxySelector;
    private final int readTimeoutMillis;
    private final boolean retryOnConnectionFailure;
    @d
    private final RouteDatabase routeDatabase;
    @d
    private final SocketFactory socketFactory;
    private final SSLSocketFactory sslSocketFactoryOrNull;
    private final int writeTimeoutMillis;
    @e
    private final X509TrustManager x509TrustManager;
    public static final Companion Companion = new Companion(null);
    @d
    private static final List<Protocol> DEFAULT_PROTOCOLS = Util.immutableListOf(Protocol.HTTP_2, Protocol.HTTP_1_1);
    @d
    private static final List<ConnectionSpec> DEFAULT_CONNECTION_SPECS = Util.immutableListOf(ConnectionSpec.MODERN_TLS, ConnectionSpec.CLEARTEXT);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000ô\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b7\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b7\u0018\u00002\u00020\u0001B\t¢\u0006\u0006\bß\u0001\u0010à\u0001B\u0014\b\u0010\u0012\u0007\u0010á\u0001\u001a\u00020`¢\u0006\u0006\bß\u0001\u0010â\u0001J\u0015\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ8\u0010\r\u001a\u00020\u00002#\b\u0004\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\u000fH\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u0013\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u0018\u0010\u000bJ\u0015\u0010\u0019\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u0019\u0010\u000eJ8\u0010\u0019\u001a\u00020\u00002#\b\u0004\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\u000fH\u0087\bø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0017J\u0015\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010\"\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b\"\u0010#J\u0015\u0010%\u001a\u00020\u00002\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b%\u0010&J\u0015\u0010'\u001a\u00020\u00002\u0006\u0010'\u001a\u00020!¢\u0006\u0004\b'\u0010#J\u0015\u0010)\u001a\u00020\u00002\u0006\u0010(\u001a\u00020!¢\u0006\u0004\b)\u0010#J\u0015\u0010+\u001a\u00020\u00002\u0006\u0010+\u001a\u00020*¢\u0006\u0004\b+\u0010,J\u0017\u0010.\u001a\u00020\u00002\b\u0010.\u001a\u0004\u0018\u00010-¢\u0006\u0004\b.\u0010/J\u0015\u00101\u001a\u00020\u00002\u0006\u00101\u001a\u000200¢\u0006\u0004\b1\u00102J\u0017\u00104\u001a\u00020\u00002\b\u00104\u001a\u0004\u0018\u000103¢\u0006\u0004\b4\u00105J\u0015\u00107\u001a\u00020\u00002\u0006\u00107\u001a\u000206¢\u0006\u0004\b7\u00108J\u0015\u00109\u001a\u00020\u00002\u0006\u00109\u001a\u00020$¢\u0006\u0004\b9\u0010&J\u0015\u0010;\u001a\u00020\u00002\u0006\u0010;\u001a\u00020:¢\u0006\u0004\b;\u0010<J\u0017\u0010>\u001a\u00020\u00002\u0006\u0010>\u001a\u00020=H\u0007¢\u0006\u0004\b>\u0010?J\u001d\u0010>\u001a\u00020\u00002\u0006\u0010>\u001a\u00020=2\u0006\u0010A\u001a\u00020@¢\u0006\u0004\b>\u0010BJ\u001b\u0010E\u001a\u00020\u00002\f\u0010E\u001a\b\u0012\u0004\u0012\u00020D0C¢\u0006\u0004\bE\u0010FJ\u001b\u0010H\u001a\u00020\u00002\f\u0010H\u001a\b\u0012\u0004\u0012\u00020G0C¢\u0006\u0004\bH\u0010FJ\u0015\u0010J\u001a\u00020\u00002\u0006\u0010J\u001a\u00020I¢\u0006\u0004\bJ\u0010KJ\u0015\u0010M\u001a\u00020\u00002\u0006\u0010M\u001a\u00020L¢\u0006\u0004\bM\u0010NJ\u001d\u0010S\u001a\u00020\u00002\u0006\u0010P\u001a\u00020O2\u0006\u0010R\u001a\u00020Q¢\u0006\u0004\bS\u0010TJ\u0017\u0010S\u001a\u00020\u00002\u0006\u0010V\u001a\u00020UH\u0007¢\u0006\u0004\bS\u0010WJ\u001d\u0010X\u001a\u00020\u00002\u0006\u0010P\u001a\u00020O2\u0006\u0010R\u001a\u00020Q¢\u0006\u0004\bX\u0010TJ\u0017\u0010X\u001a\u00020\u00002\u0006\u0010V\u001a\u00020UH\u0007¢\u0006\u0004\bX\u0010WJ\u001d\u0010Y\u001a\u00020\u00002\u0006\u0010P\u001a\u00020O2\u0006\u0010R\u001a\u00020Q¢\u0006\u0004\bY\u0010TJ\u0017\u0010Y\u001a\u00020\u00002\u0006\u0010V\u001a\u00020UH\u0007¢\u0006\u0004\bY\u0010WJ\u001d\u0010Z\u001a\u00020\u00002\u0006\u0010P\u001a\u00020O2\u0006\u0010R\u001a\u00020Q¢\u0006\u0004\bZ\u0010TJ\u0017\u0010Z\u001a\u00020\u00002\u0006\u0010V\u001a\u00020UH\u0007¢\u0006\u0004\bZ\u0010WJ\u001d\u0010\\\u001a\u00020\u00002\u0006\u0010[\u001a\u00020O2\u0006\u0010R\u001a\u00020Q¢\u0006\u0004\b\\\u0010TJ\u0017\u0010\\\u001a\u00020\u00002\u0006\u0010V\u001a\u00020UH\u0007¢\u0006\u0004\b\\\u0010WJ\u0015\u0010^\u001a\u00020\u00002\u0006\u0010]\u001a\u00020O¢\u0006\u0004\b^\u0010_J\r\u0010a\u001a\u00020`¢\u0006\u0004\ba\u0010bR\"\u0010\u0006\u001a\u00020\u00058\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010c\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR\"\u0010X\u001a\u00020h8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bX\u0010i\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR\"\u0010S\u001a\u00020h8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bS\u0010i\u001a\u0004\bn\u0010k\"\u0004\bo\u0010mR\"\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0018\u0010p\u001a\u0004\bq\u0010\u000bR\"\u0010^\u001a\u00020O8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b^\u0010r\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR\"\u00101\u001a\u0002008\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b1\u0010w\u001a\u0004\bx\u0010y\"\u0004\bz\u0010{R(\u0010H\u001a\b\u0012\u0004\u0012\u00020G0C8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bH\u0010p\u001a\u0004\b|\u0010\u000b\"\u0004\b}\u0010~R&\u0010)\u001a\u00020!8\u0000@\u0000X\u0080\u000e¢\u0006\u0016\n\u0004\b)\u0010\u007f\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001\"\u0006\b\u0082\u0001\u0010\u0083\u0001R'\u00109\u001a\u00020$8\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\b9\u0010\u0084\u0001\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001\"\u0006\b\u0087\u0001\u0010\u0088\u0001R&\u0010'\u001a\u00020!8\u0000@\u0000X\u0080\u000e¢\u0006\u0016\n\u0004\b'\u0010\u007f\u001a\u0006\b\u0089\u0001\u0010\u0081\u0001\"\u0006\b\u008a\u0001\u0010\u0083\u0001R*\u0010E\u001a\b\u0012\u0004\u0012\u00020D0C8\u0000@\u0000X\u0080\u000e¢\u0006\u0014\n\u0004\bE\u0010p\u001a\u0005\b\u008b\u0001\u0010\u000b\"\u0005\b\u008c\u0001\u0010~R#\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0000@\u0000X\u0080\u0004¢\u0006\r\n\u0004\b\n\u0010p\u001a\u0005\b\u008d\u0001\u0010\u000bR)\u0010.\u001a\u0004\u0018\u00010-8\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\b.\u0010\u008e\u0001\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001\"\u0006\b\u0091\u0001\u0010\u0092\u0001R'\u0010M\u001a\u00020L8\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\bM\u0010\u0093\u0001\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001\"\u0006\b\u0096\u0001\u0010\u0097\u0001R$\u0010Y\u001a\u00020h8\u0000@\u0000X\u0080\u000e¢\u0006\u0014\n\u0004\bY\u0010i\u001a\u0005\b\u0098\u0001\u0010k\"\u0005\b\u0099\u0001\u0010mR+\u0010\u009a\u0001\u001a\u0004\u0018\u00010@8\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b\u009a\u0001\u0010\u009b\u0001\u001a\u0006\b\u009c\u0001\u0010\u009d\u0001\"\u0006\b\u009e\u0001\u0010\u009f\u0001R,\u0010¡\u0001\u001a\u0005\u0018\u00010 \u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b¡\u0001\u0010¢\u0001\u001a\u0006\b£\u0001\u0010¤\u0001\"\u0006\b¥\u0001\u0010¦\u0001R'\u0010;\u001a\u00020:8\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\b;\u0010§\u0001\u001a\u0006\b¨\u0001\u0010©\u0001\"\u0006\bª\u0001\u0010«\u0001R,\u0010\u00ad\u0001\u001a\u0005\u0018\u00010¬\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b\u00ad\u0001\u0010®\u0001\u001a\u0006\b¯\u0001\u0010°\u0001\"\u0006\b±\u0001\u0010²\u0001R'\u0010\u0003\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\b\u0003\u0010³\u0001\u001a\u0006\b´\u0001\u0010µ\u0001\"\u0006\b¶\u0001\u0010·\u0001R'\u0010J\u001a\u00020I8\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\bJ\u0010¸\u0001\u001a\u0006\b¹\u0001\u0010º\u0001\"\u0006\b»\u0001\u0010¼\u0001R'\u0010+\u001a\u00020*8\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\b+\u0010½\u0001\u001a\u0006\b¾\u0001\u0010¿\u0001\"\u0006\bÀ\u0001\u0010Á\u0001R+\u0010Â\u0001\u001a\u0004\u0018\u00010=8\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\bÂ\u0001\u0010Ã\u0001\u001a\u0006\bÄ\u0001\u0010Å\u0001\"\u0006\bÆ\u0001\u0010Ç\u0001R)\u00107\u001a\u0004\u0018\u0001068\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\b7\u0010È\u0001\u001a\u0006\bÉ\u0001\u0010Ê\u0001\"\u0006\bË\u0001\u0010Ì\u0001R$\u0010\\\u001a\u00020h8\u0000@\u0000X\u0080\u000e¢\u0006\u0014\n\u0004\b\\\u0010i\u001a\u0005\bÍ\u0001\u0010k\"\u0005\bÎ\u0001\u0010mR'\u0010\u001f\u001a\u00020\u001e8\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\b\u001f\u0010Ï\u0001\u001a\u0006\bÐ\u0001\u0010Ñ\u0001\"\u0006\bÒ\u0001\u0010Ó\u0001R&\u0010\"\u001a\u00020!8\u0000@\u0000X\u0080\u000e¢\u0006\u0016\n\u0004\b\"\u0010\u007f\u001a\u0006\bÔ\u0001\u0010\u0081\u0001\"\u0006\bÕ\u0001\u0010\u0083\u0001R$\u0010Z\u001a\u00020h8\u0000@\u0000X\u0080\u000e¢\u0006\u0014\n\u0004\bZ\u0010i\u001a\u0005\bÖ\u0001\u0010k\"\u0005\b×\u0001\u0010mR'\u0010%\u001a\u00020$8\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\b%\u0010\u0084\u0001\u001a\u0006\bØ\u0001\u0010\u0086\u0001\"\u0006\bÙ\u0001\u0010\u0088\u0001R)\u00104\u001a\u0004\u0018\u0001038\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\b4\u0010Ú\u0001\u001a\u0006\bÛ\u0001\u0010Ü\u0001\"\u0006\bÝ\u0001\u0010Þ\u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006ã\u0001"}, d2 = {"Lokhttp3/OkHttpClient$Builder;", "", "Lokhttp3/Dispatcher;", "dispatcher", "(Lokhttp3/Dispatcher;)Lokhttp3/OkHttpClient$Builder;", "Lokhttp3/ConnectionPool;", "connectionPool", "(Lokhttp3/ConnectionPool;)Lokhttp3/OkHttpClient$Builder;", "", "Lokhttp3/Interceptor;", "interceptors", "()Ljava/util/List;", "interceptor", "addInterceptor", "(Lokhttp3/Interceptor;)Lokhttp3/OkHttpClient$Builder;", "Lkotlin/Function1;", "Lokhttp3/Interceptor$Chain;", "Lh/k0;", "name", "chain", "Lokhttp3/Response;", ReportItem.LogTypeBlock, "-addInterceptor", "(Lh/k2/u/l;)Lokhttp3/OkHttpClient$Builder;", "networkInterceptors", "addNetworkInterceptor", "-addNetworkInterceptor", "Lokhttp3/EventListener;", "eventListener", "(Lokhttp3/EventListener;)Lokhttp3/OkHttpClient$Builder;", "Lokhttp3/EventListener$Factory;", "eventListenerFactory", "(Lokhttp3/EventListener$Factory;)Lokhttp3/OkHttpClient$Builder;", "", "retryOnConnectionFailure", "(Z)Lokhttp3/OkHttpClient$Builder;", "Lokhttp3/Authenticator;", "authenticator", "(Lokhttp3/Authenticator;)Lokhttp3/OkHttpClient$Builder;", "followRedirects", "followProtocolRedirects", "followSslRedirects", "Lokhttp3/CookieJar;", "cookieJar", "(Lokhttp3/CookieJar;)Lokhttp3/OkHttpClient$Builder;", "Lokhttp3/Cache;", "cache", "(Lokhttp3/Cache;)Lokhttp3/OkHttpClient$Builder;", "Lokhttp3/Dns;", DnsSource.Udp, "(Lokhttp3/Dns;)Lokhttp3/OkHttpClient$Builder;", "Ljava/net/Proxy;", "proxy", "(Ljava/net/Proxy;)Lokhttp3/OkHttpClient$Builder;", "Ljava/net/ProxySelector;", "proxySelector", "(Ljava/net/ProxySelector;)Lokhttp3/OkHttpClient$Builder;", "proxyAuthenticator", "Ljavax/net/SocketFactory;", "socketFactory", "(Ljavax/net/SocketFactory;)Lokhttp3/OkHttpClient$Builder;", "Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactory", "(Ljavax/net/ssl/SSLSocketFactory;)Lokhttp3/OkHttpClient$Builder;", "Ljavax/net/ssl/X509TrustManager;", "trustManager", "(Ljavax/net/ssl/SSLSocketFactory;Ljavax/net/ssl/X509TrustManager;)Lokhttp3/OkHttpClient$Builder;", "", "Lokhttp3/ConnectionSpec;", "connectionSpecs", "(Ljava/util/List;)Lokhttp3/OkHttpClient$Builder;", "Lokhttp3/Protocol;", "protocols", "Ljavax/net/ssl/HostnameVerifier;", "hostnameVerifier", "(Ljavax/net/ssl/HostnameVerifier;)Lokhttp3/OkHttpClient$Builder;", "Lokhttp3/CertificatePinner;", "certificatePinner", "(Lokhttp3/CertificatePinner;)Lokhttp3/OkHttpClient$Builder;", "", "timeout", "Ljava/util/concurrent/TimeUnit;", "unit", "callTimeout", "(JLjava/util/concurrent/TimeUnit;)Lokhttp3/OkHttpClient$Builder;", "Ljava/time/Duration;", "duration", "(Ljava/time/Duration;)Lokhttp3/OkHttpClient$Builder;", "connectTimeout", "readTimeout", "writeTimeout", am.aU, "pingInterval", "bytes", "minWebSocketMessageToCompress", "(J)Lokhttp3/OkHttpClient$Builder;", "Lokhttp3/OkHttpClient;", "build", "()Lokhttp3/OkHttpClient;", "Lokhttp3/ConnectionPool;", "getConnectionPool$okhttp", "()Lokhttp3/ConnectionPool;", "setConnectionPool$okhttp", "(Lokhttp3/ConnectionPool;)V", "", ExpandableTextView.P, "getConnectTimeout$okhttp", "()I", "setConnectTimeout$okhttp", "(I)V", "getCallTimeout$okhttp", "setCallTimeout$okhttp", "Ljava/util/List;", "getNetworkInterceptors$okhttp", "J", "getMinWebSocketMessageToCompress$okhttp", "()J", "setMinWebSocketMessageToCompress$okhttp", "(J)V", "Lokhttp3/Dns;", "getDns$okhttp", "()Lokhttp3/Dns;", "setDns$okhttp", "(Lokhttp3/Dns;)V", "getProtocols$okhttp", "setProtocols$okhttp", "(Ljava/util/List;)V", "Z", "getFollowSslRedirects$okhttp", "()Z", "setFollowSslRedirects$okhttp", "(Z)V", "Lokhttp3/Authenticator;", "getProxyAuthenticator$okhttp", "()Lokhttp3/Authenticator;", "setProxyAuthenticator$okhttp", "(Lokhttp3/Authenticator;)V", "getFollowRedirects$okhttp", "setFollowRedirects$okhttp", "getConnectionSpecs$okhttp", "setConnectionSpecs$okhttp", "getInterceptors$okhttp", "Lokhttp3/Cache;", "getCache$okhttp", "()Lokhttp3/Cache;", "setCache$okhttp", "(Lokhttp3/Cache;)V", "Lokhttp3/CertificatePinner;", "getCertificatePinner$okhttp", "()Lokhttp3/CertificatePinner;", "setCertificatePinner$okhttp", "(Lokhttp3/CertificatePinner;)V", "getReadTimeout$okhttp", "setReadTimeout$okhttp", "x509TrustManagerOrNull", "Ljavax/net/ssl/X509TrustManager;", "getX509TrustManagerOrNull$okhttp", "()Ljavax/net/ssl/X509TrustManager;", "setX509TrustManagerOrNull$okhttp", "(Ljavax/net/ssl/X509TrustManager;)V", "Lokhttp3/internal/connection/RouteDatabase;", "routeDatabase", "Lokhttp3/internal/connection/RouteDatabase;", "getRouteDatabase$okhttp", "()Lokhttp3/internal/connection/RouteDatabase;", "setRouteDatabase$okhttp", "(Lokhttp3/internal/connection/RouteDatabase;)V", "Ljavax/net/SocketFactory;", "getSocketFactory$okhttp", "()Ljavax/net/SocketFactory;", "setSocketFactory$okhttp", "(Ljavax/net/SocketFactory;)V", "Lokhttp3/internal/tls/CertificateChainCleaner;", "certificateChainCleaner", "Lokhttp3/internal/tls/CertificateChainCleaner;", "getCertificateChainCleaner$okhttp", "()Lokhttp3/internal/tls/CertificateChainCleaner;", "setCertificateChainCleaner$okhttp", "(Lokhttp3/internal/tls/CertificateChainCleaner;)V", "Lokhttp3/Dispatcher;", "getDispatcher$okhttp", "()Lokhttp3/Dispatcher;", "setDispatcher$okhttp", "(Lokhttp3/Dispatcher;)V", "Ljavax/net/ssl/HostnameVerifier;", "getHostnameVerifier$okhttp", "()Ljavax/net/ssl/HostnameVerifier;", "setHostnameVerifier$okhttp", "(Ljavax/net/ssl/HostnameVerifier;)V", "Lokhttp3/CookieJar;", "getCookieJar$okhttp", "()Lokhttp3/CookieJar;", "setCookieJar$okhttp", "(Lokhttp3/CookieJar;)V", "sslSocketFactoryOrNull", "Ljavax/net/ssl/SSLSocketFactory;", "getSslSocketFactoryOrNull$okhttp", "()Ljavax/net/ssl/SSLSocketFactory;", "setSslSocketFactoryOrNull$okhttp", "(Ljavax/net/ssl/SSLSocketFactory;)V", "Ljava/net/ProxySelector;", "getProxySelector$okhttp", "()Ljava/net/ProxySelector;", "setProxySelector$okhttp", "(Ljava/net/ProxySelector;)V", "getPingInterval$okhttp", "setPingInterval$okhttp", "Lokhttp3/EventListener$Factory;", "getEventListenerFactory$okhttp", "()Lokhttp3/EventListener$Factory;", "setEventListenerFactory$okhttp", "(Lokhttp3/EventListener$Factory;)V", "getRetryOnConnectionFailure$okhttp", "setRetryOnConnectionFailure$okhttp", "getWriteTimeout$okhttp", "setWriteTimeout$okhttp", "getAuthenticator$okhttp", "setAuthenticator$okhttp", "Ljava/net/Proxy;", "getProxy$okhttp", "()Ljava/net/Proxy;", "setProxy$okhttp", "(Ljava/net/Proxy;)V", "<init>", "()V", "okHttpClient", "(Lokhttp3/OkHttpClient;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class Builder {
        @d
        private Authenticator authenticator;
        @e
        private Cache cache;
        private int callTimeout;
        @e
        private CertificateChainCleaner certificateChainCleaner;
        @d
        private CertificatePinner certificatePinner;
        private int connectTimeout;
        @d
        private ConnectionPool connectionPool;
        @d
        private List<ConnectionSpec> connectionSpecs;
        @d
        private CookieJar cookieJar;
        @d
        private Dispatcher dispatcher;
        @d
        private Dns dns;
        @d
        private EventListener.Factory eventListenerFactory;
        private boolean followRedirects;
        private boolean followSslRedirects;
        @d
        private HostnameVerifier hostnameVerifier;
        @d
        private final List<Interceptor> interceptors;
        private long minWebSocketMessageToCompress;
        @d
        private final List<Interceptor> networkInterceptors;
        private int pingInterval;
        @d
        private List<? extends Protocol> protocols;
        @e
        private Proxy proxy;
        @d
        private Authenticator proxyAuthenticator;
        @e
        private ProxySelector proxySelector;
        private int readTimeout;
        private boolean retryOnConnectionFailure;
        @e
        private RouteDatabase routeDatabase;
        @d
        private SocketFactory socketFactory;
        @e
        private SSLSocketFactory sslSocketFactoryOrNull;
        private int writeTimeout;
        @e
        private X509TrustManager x509TrustManagerOrNull;

        public Builder() {
            this.dispatcher = new Dispatcher();
            this.connectionPool = new ConnectionPool();
            this.interceptors = new ArrayList();
            this.networkInterceptors = new ArrayList();
            this.eventListenerFactory = Util.asFactory(EventListener.NONE);
            this.retryOnConnectionFailure = true;
            Authenticator authenticator = Authenticator.NONE;
            this.authenticator = authenticator;
            this.followRedirects = true;
            this.followSslRedirects = true;
            this.cookieJar = CookieJar.NO_COOKIES;
            this.dns = Dns.SYSTEM;
            this.proxyAuthenticator = authenticator;
            this.socketFactory = SocketFactory.getDefault();
            Companion companion = OkHttpClient.Companion;
            this.connectionSpecs = companion.getDEFAULT_CONNECTION_SPECS$okhttp();
            this.protocols = companion.getDEFAULT_PROTOCOLS$okhttp();
            this.hostnameVerifier = OkHostnameVerifier.INSTANCE;
            this.certificatePinner = CertificatePinner.DEFAULT;
            this.connectTimeout = 10000;
            this.readTimeout = 10000;
            this.writeTimeout = 10000;
            this.minWebSocketMessageToCompress = 1024L;
        }

        @g(name = "-addInterceptor")
        @d
        /* renamed from: -addInterceptor */
        public final Builder m228addInterceptor(@d final l<? super Interceptor.Chain, Response> lVar) {
            return addInterceptor(new Interceptor() { // from class: okhttp3.OkHttpClient$Builder$addInterceptor$2
                @Override // okhttp3.Interceptor
                @d
                public final Response intercept(@d Interceptor.Chain chain) {
                    return (Response) lVar.invoke(chain);
                }
            });
        }

        @g(name = "-addNetworkInterceptor")
        @d
        /* renamed from: -addNetworkInterceptor */
        public final Builder m229addNetworkInterceptor(@d final l<? super Interceptor.Chain, Response> lVar) {
            return addNetworkInterceptor(new Interceptor() { // from class: okhttp3.OkHttpClient$Builder$addNetworkInterceptor$2
                @Override // okhttp3.Interceptor
                @d
                public final Response intercept(@d Interceptor.Chain chain) {
                    return (Response) lVar.invoke(chain);
                }
            });
        }

        @d
        public final Builder addInterceptor(@d Interceptor interceptor) {
            this.interceptors.add(interceptor);
            return this;
        }

        @d
        public final Builder addNetworkInterceptor(@d Interceptor interceptor) {
            this.networkInterceptors.add(interceptor);
            return this;
        }

        @d
        public final Builder authenticator(@d Authenticator authenticator) {
            this.authenticator = authenticator;
            return this;
        }

        @d
        public final OkHttpClient build() {
            return new OkHttpClient(this);
        }

        @d
        public final Builder cache(@e Cache cache) {
            this.cache = cache;
            return this;
        }

        @d
        public final Builder callTimeout(long j2, @d TimeUnit timeUnit) {
            this.callTimeout = Util.checkDuration("timeout", j2, timeUnit);
            return this;
        }

        @d
        public final Builder certificatePinner(@d CertificatePinner certificatePinner) {
            if (!f0.g(certificatePinner, this.certificatePinner)) {
                this.routeDatabase = null;
            }
            this.certificatePinner = certificatePinner;
            return this;
        }

        @d
        public final Builder connectTimeout(long j2, @d TimeUnit timeUnit) {
            this.connectTimeout = Util.checkDuration("timeout", j2, timeUnit);
            return this;
        }

        @d
        public final Builder connectionPool(@d ConnectionPool connectionPool) {
            this.connectionPool = connectionPool;
            return this;
        }

        @d
        public final Builder connectionSpecs(@d List<ConnectionSpec> list) {
            if (!f0.g(list, this.connectionSpecs)) {
                this.routeDatabase = null;
            }
            this.connectionSpecs = Util.toImmutableList(list);
            return this;
        }

        @d
        public final Builder cookieJar(@d CookieJar cookieJar) {
            this.cookieJar = cookieJar;
            return this;
        }

        @d
        public final Builder dispatcher(@d Dispatcher dispatcher) {
            this.dispatcher = dispatcher;
            return this;
        }

        @d
        public final Builder dns(@d Dns dns) {
            if (!f0.g(dns, this.dns)) {
                this.routeDatabase = null;
            }
            this.dns = dns;
            return this;
        }

        @d
        public final Builder eventListener(@d EventListener eventListener) {
            this.eventListenerFactory = Util.asFactory(eventListener);
            return this;
        }

        @d
        public final Builder eventListenerFactory(@d EventListener.Factory factory) {
            this.eventListenerFactory = factory;
            return this;
        }

        @d
        public final Builder followRedirects(boolean z) {
            this.followRedirects = z;
            return this;
        }

        @d
        public final Builder followSslRedirects(boolean z) {
            this.followSslRedirects = z;
            return this;
        }

        @d
        public final Authenticator getAuthenticator$okhttp() {
            return this.authenticator;
        }

        @e
        public final Cache getCache$okhttp() {
            return this.cache;
        }

        public final int getCallTimeout$okhttp() {
            return this.callTimeout;
        }

        @e
        public final CertificateChainCleaner getCertificateChainCleaner$okhttp() {
            return this.certificateChainCleaner;
        }

        @d
        public final CertificatePinner getCertificatePinner$okhttp() {
            return this.certificatePinner;
        }

        public final int getConnectTimeout$okhttp() {
            return this.connectTimeout;
        }

        @d
        public final ConnectionPool getConnectionPool$okhttp() {
            return this.connectionPool;
        }

        @d
        public final List<ConnectionSpec> getConnectionSpecs$okhttp() {
            return this.connectionSpecs;
        }

        @d
        public final CookieJar getCookieJar$okhttp() {
            return this.cookieJar;
        }

        @d
        public final Dispatcher getDispatcher$okhttp() {
            return this.dispatcher;
        }

        @d
        public final Dns getDns$okhttp() {
            return this.dns;
        }

        @d
        public final EventListener.Factory getEventListenerFactory$okhttp() {
            return this.eventListenerFactory;
        }

        public final boolean getFollowRedirects$okhttp() {
            return this.followRedirects;
        }

        public final boolean getFollowSslRedirects$okhttp() {
            return this.followSslRedirects;
        }

        @d
        public final HostnameVerifier getHostnameVerifier$okhttp() {
            return this.hostnameVerifier;
        }

        @d
        public final List<Interceptor> getInterceptors$okhttp() {
            return this.interceptors;
        }

        public final long getMinWebSocketMessageToCompress$okhttp() {
            return this.minWebSocketMessageToCompress;
        }

        @d
        public final List<Interceptor> getNetworkInterceptors$okhttp() {
            return this.networkInterceptors;
        }

        public final int getPingInterval$okhttp() {
            return this.pingInterval;
        }

        @d
        public final List<Protocol> getProtocols$okhttp() {
            return this.protocols;
        }

        @e
        public final Proxy getProxy$okhttp() {
            return this.proxy;
        }

        @d
        public final Authenticator getProxyAuthenticator$okhttp() {
            return this.proxyAuthenticator;
        }

        @e
        public final ProxySelector getProxySelector$okhttp() {
            return this.proxySelector;
        }

        public final int getReadTimeout$okhttp() {
            return this.readTimeout;
        }

        public final boolean getRetryOnConnectionFailure$okhttp() {
            return this.retryOnConnectionFailure;
        }

        @e
        public final RouteDatabase getRouteDatabase$okhttp() {
            return this.routeDatabase;
        }

        @d
        public final SocketFactory getSocketFactory$okhttp() {
            return this.socketFactory;
        }

        @e
        public final SSLSocketFactory getSslSocketFactoryOrNull$okhttp() {
            return this.sslSocketFactoryOrNull;
        }

        public final int getWriteTimeout$okhttp() {
            return this.writeTimeout;
        }

        @e
        public final X509TrustManager getX509TrustManagerOrNull$okhttp() {
            return this.x509TrustManagerOrNull;
        }

        @d
        public final Builder hostnameVerifier(@d HostnameVerifier hostnameVerifier) {
            if (!f0.g(hostnameVerifier, this.hostnameVerifier)) {
                this.routeDatabase = null;
            }
            this.hostnameVerifier = hostnameVerifier;
            return this;
        }

        @d
        public final List<Interceptor> interceptors() {
            return this.interceptors;
        }

        @d
        public final Builder minWebSocketMessageToCompress(long j2) {
            if (j2 >= 0) {
                this.minWebSocketMessageToCompress = j2;
                return this;
            }
            throw new IllegalArgumentException(("minWebSocketMessageToCompress must be positive: " + j2).toString());
        }

        @d
        public final List<Interceptor> networkInterceptors() {
            return this.networkInterceptors;
        }

        @d
        public final Builder pingInterval(long j2, @d TimeUnit timeUnit) {
            this.pingInterval = Util.checkDuration(am.aU, j2, timeUnit);
            return this;
        }

        @d
        public final Builder protocols(@d List<? extends Protocol> list) {
            List L5 = CollectionsKt___CollectionsKt.L5(list);
            Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
            boolean z = false;
            if (L5.contains(protocol) || L5.contains(Protocol.HTTP_1_1)) {
                if ((!L5.contains(protocol) || L5.size() <= 1) ? true : true) {
                    if (!L5.contains(Protocol.HTTP_1_0)) {
                        Objects.requireNonNull(L5, "null cannot be cast to non-null type kotlin.collections.List<okhttp3.Protocol?>");
                        if (!L5.contains(null)) {
                            L5.remove(Protocol.SPDY_3);
                            if (!f0.g(L5, this.protocols)) {
                                this.routeDatabase = null;
                            }
                            this.protocols = Collections.unmodifiableList(L5);
                            return this;
                        }
                        throw new IllegalArgumentException("protocols must not contain null".toString());
                    }
                    throw new IllegalArgumentException(("protocols must not contain http/1.0: " + L5).toString());
                }
                throw new IllegalArgumentException(("protocols containing h2_prior_knowledge cannot use other protocols: " + L5).toString());
            }
            throw new IllegalArgumentException(("protocols must contain h2_prior_knowledge or http/1.1: " + L5).toString());
        }

        @d
        public final Builder proxy(@e Proxy proxy) {
            if (!f0.g(proxy, this.proxy)) {
                this.routeDatabase = null;
            }
            this.proxy = proxy;
            return this;
        }

        @d
        public final Builder proxyAuthenticator(@d Authenticator authenticator) {
            if (!f0.g(authenticator, this.proxyAuthenticator)) {
                this.routeDatabase = null;
            }
            this.proxyAuthenticator = authenticator;
            return this;
        }

        @d
        public final Builder proxySelector(@d ProxySelector proxySelector) {
            if (!f0.g(proxySelector, this.proxySelector)) {
                this.routeDatabase = null;
            }
            this.proxySelector = proxySelector;
            return this;
        }

        @d
        public final Builder readTimeout(long j2, @d TimeUnit timeUnit) {
            this.readTimeout = Util.checkDuration("timeout", j2, timeUnit);
            return this;
        }

        @d
        public final Builder retryOnConnectionFailure(boolean z) {
            this.retryOnConnectionFailure = z;
            return this;
        }

        public final void setAuthenticator$okhttp(@d Authenticator authenticator) {
            this.authenticator = authenticator;
        }

        public final void setCache$okhttp(@e Cache cache) {
            this.cache = cache;
        }

        public final void setCallTimeout$okhttp(int i2) {
            this.callTimeout = i2;
        }

        public final void setCertificateChainCleaner$okhttp(@e CertificateChainCleaner certificateChainCleaner) {
            this.certificateChainCleaner = certificateChainCleaner;
        }

        public final void setCertificatePinner$okhttp(@d CertificatePinner certificatePinner) {
            this.certificatePinner = certificatePinner;
        }

        public final void setConnectTimeout$okhttp(int i2) {
            this.connectTimeout = i2;
        }

        public final void setConnectionPool$okhttp(@d ConnectionPool connectionPool) {
            this.connectionPool = connectionPool;
        }

        public final void setConnectionSpecs$okhttp(@d List<ConnectionSpec> list) {
            this.connectionSpecs = list;
        }

        public final void setCookieJar$okhttp(@d CookieJar cookieJar) {
            this.cookieJar = cookieJar;
        }

        public final void setDispatcher$okhttp(@d Dispatcher dispatcher) {
            this.dispatcher = dispatcher;
        }

        public final void setDns$okhttp(@d Dns dns) {
            this.dns = dns;
        }

        public final void setEventListenerFactory$okhttp(@d EventListener.Factory factory) {
            this.eventListenerFactory = factory;
        }

        public final void setFollowRedirects$okhttp(boolean z) {
            this.followRedirects = z;
        }

        public final void setFollowSslRedirects$okhttp(boolean z) {
            this.followSslRedirects = z;
        }

        public final void setHostnameVerifier$okhttp(@d HostnameVerifier hostnameVerifier) {
            this.hostnameVerifier = hostnameVerifier;
        }

        public final void setMinWebSocketMessageToCompress$okhttp(long j2) {
            this.minWebSocketMessageToCompress = j2;
        }

        public final void setPingInterval$okhttp(int i2) {
            this.pingInterval = i2;
        }

        public final void setProtocols$okhttp(@d List<? extends Protocol> list) {
            this.protocols = list;
        }

        public final void setProxy$okhttp(@e Proxy proxy) {
            this.proxy = proxy;
        }

        public final void setProxyAuthenticator$okhttp(@d Authenticator authenticator) {
            this.proxyAuthenticator = authenticator;
        }

        public final void setProxySelector$okhttp(@e ProxySelector proxySelector) {
            this.proxySelector = proxySelector;
        }

        public final void setReadTimeout$okhttp(int i2) {
            this.readTimeout = i2;
        }

        public final void setRetryOnConnectionFailure$okhttp(boolean z) {
            this.retryOnConnectionFailure = z;
        }

        public final void setRouteDatabase$okhttp(@e RouteDatabase routeDatabase) {
            this.routeDatabase = routeDatabase;
        }

        public final void setSocketFactory$okhttp(@d SocketFactory socketFactory) {
            this.socketFactory = socketFactory;
        }

        public final void setSslSocketFactoryOrNull$okhttp(@e SSLSocketFactory sSLSocketFactory) {
            this.sslSocketFactoryOrNull = sSLSocketFactory;
        }

        public final void setWriteTimeout$okhttp(int i2) {
            this.writeTimeout = i2;
        }

        public final void setX509TrustManagerOrNull$okhttp(@e X509TrustManager x509TrustManager) {
            this.x509TrustManagerOrNull = x509TrustManager;
        }

        @d
        public final Builder socketFactory(@d SocketFactory socketFactory) {
            if (!(socketFactory instanceof SSLSocketFactory)) {
                if (!f0.g(socketFactory, this.socketFactory)) {
                    this.routeDatabase = null;
                }
                this.socketFactory = socketFactory;
                return this;
            }
            throw new IllegalArgumentException("socketFactory instanceof SSLSocketFactory".toString());
        }

        @i(level = DeprecationLevel.ERROR, message = "Use the sslSocketFactory overload that accepts a X509TrustManager.")
        @d
        public final Builder sslSocketFactory(@d SSLSocketFactory sSLSocketFactory) {
            if (!f0.g(sSLSocketFactory, this.sslSocketFactoryOrNull)) {
                this.routeDatabase = null;
            }
            this.sslSocketFactoryOrNull = sSLSocketFactory;
            Platform.Companion companion = Platform.Companion;
            X509TrustManager trustManager = companion.get().trustManager(sSLSocketFactory);
            if (trustManager != null) {
                this.x509TrustManagerOrNull = trustManager;
                this.certificateChainCleaner = companion.get().buildCertificateChainCleaner(this.x509TrustManagerOrNull);
                return this;
            }
            throw new IllegalStateException("Unable to extract the trust manager on " + companion.get() + ", sslSocketFactory is " + sSLSocketFactory.getClass());
        }

        @d
        public final Builder writeTimeout(long j2, @d TimeUnit timeUnit) {
            this.writeTimeout = Util.checkDuration("timeout", j2, timeUnit);
            return this;
        }

        @d
        @IgnoreJRERequirement
        public final Builder callTimeout(@d Duration duration) {
            callTimeout(duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        @d
        @IgnoreJRERequirement
        public final Builder connectTimeout(@d Duration duration) {
            connectTimeout(duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        @d
        @IgnoreJRERequirement
        public final Builder pingInterval(@d Duration duration) {
            pingInterval(duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        @d
        @IgnoreJRERequirement
        public final Builder readTimeout(@d Duration duration) {
            readTimeout(duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        @d
        @IgnoreJRERequirement
        public final Builder writeTimeout(@d Duration duration) {
            writeTimeout(duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        @d
        public final Builder sslSocketFactory(@d SSLSocketFactory sSLSocketFactory, @d X509TrustManager x509TrustManager) {
            if ((!f0.g(sSLSocketFactory, this.sslSocketFactoryOrNull)) || (!f0.g(x509TrustManager, this.x509TrustManagerOrNull))) {
                this.routeDatabase = null;
            }
            this.sslSocketFactoryOrNull = sSLSocketFactory;
            this.certificateChainCleaner = CertificateChainCleaner.Companion.get(x509TrustManager);
            this.x509TrustManagerOrNull = x509TrustManager;
            return this;
        }

        public Builder(@d OkHttpClient okHttpClient) {
            this();
            this.dispatcher = okHttpClient.dispatcher();
            this.connectionPool = okHttpClient.connectionPool();
            y.q0(this.interceptors, okHttpClient.interceptors());
            y.q0(this.networkInterceptors, okHttpClient.networkInterceptors());
            this.eventListenerFactory = okHttpClient.eventListenerFactory();
            this.retryOnConnectionFailure = okHttpClient.retryOnConnectionFailure();
            this.authenticator = okHttpClient.authenticator();
            this.followRedirects = okHttpClient.followRedirects();
            this.followSslRedirects = okHttpClient.followSslRedirects();
            this.cookieJar = okHttpClient.cookieJar();
            this.cache = okHttpClient.cache();
            this.dns = okHttpClient.dns();
            this.proxy = okHttpClient.proxy();
            this.proxySelector = okHttpClient.proxySelector();
            this.proxyAuthenticator = okHttpClient.proxyAuthenticator();
            this.socketFactory = okHttpClient.socketFactory();
            this.sslSocketFactoryOrNull = okHttpClient.sslSocketFactoryOrNull;
            this.x509TrustManagerOrNull = okHttpClient.x509TrustManager();
            this.connectionSpecs = okHttpClient.connectionSpecs();
            this.protocols = okHttpClient.protocols();
            this.hostnameVerifier = okHttpClient.hostnameVerifier();
            this.certificatePinner = okHttpClient.certificatePinner();
            this.certificateChainCleaner = okHttpClient.certificateChainCleaner();
            this.callTimeout = okHttpClient.callTimeoutMillis();
            this.connectTimeout = okHttpClient.connectTimeoutMillis();
            this.readTimeout = okHttpClient.readTimeoutMillis();
            this.writeTimeout = okHttpClient.writeTimeoutMillis();
            this.pingInterval = okHttpClient.pingIntervalMillis();
            this.minWebSocketMessageToCompress = okHttpClient.minWebSocketMessageToCompress();
            this.routeDatabase = okHttpClient.getRouteDatabase();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00028\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007¨\u0006\r"}, d2 = {"Lokhttp3/OkHttpClient$Companion;", "", "", "Lokhttp3/Protocol;", "DEFAULT_PROTOCOLS", "Ljava/util/List;", "getDEFAULT_PROTOCOLS$okhttp", "()Ljava/util/List;", "Lokhttp3/ConnectionSpec;", "DEFAULT_CONNECTION_SPECS", "getDEFAULT_CONNECTION_SPECS$okhttp", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        @d
        public final List<ConnectionSpec> getDEFAULT_CONNECTION_SPECS$okhttp() {
            return OkHttpClient.DEFAULT_CONNECTION_SPECS;
        }

        @d
        public final List<Protocol> getDEFAULT_PROTOCOLS$okhttp() {
            return OkHttpClient.DEFAULT_PROTOCOLS;
        }

        public /* synthetic */ Companion(u uVar) {
            this();
        }
    }

    public OkHttpClient(@d Builder builder) {
        ProxySelector proxySelector$okhttp;
        this.dispatcher = builder.getDispatcher$okhttp();
        this.connectionPool = builder.getConnectionPool$okhttp();
        this.interceptors = Util.toImmutableList(builder.getInterceptors$okhttp());
        this.networkInterceptors = Util.toImmutableList(builder.getNetworkInterceptors$okhttp());
        this.eventListenerFactory = builder.getEventListenerFactory$okhttp();
        this.retryOnConnectionFailure = builder.getRetryOnConnectionFailure$okhttp();
        this.authenticator = builder.getAuthenticator$okhttp();
        this.followRedirects = builder.getFollowRedirects$okhttp();
        this.followSslRedirects = builder.getFollowSslRedirects$okhttp();
        this.cookieJar = builder.getCookieJar$okhttp();
        this.cache = builder.getCache$okhttp();
        this.dns = builder.getDns$okhttp();
        this.proxy = builder.getProxy$okhttp();
        if (builder.getProxy$okhttp() != null) {
            proxySelector$okhttp = NullProxySelector.INSTANCE;
        } else {
            proxySelector$okhttp = builder.getProxySelector$okhttp();
            proxySelector$okhttp = proxySelector$okhttp == null ? ProxySelector.getDefault() : proxySelector$okhttp;
            if (proxySelector$okhttp == null) {
                proxySelector$okhttp = NullProxySelector.INSTANCE;
            }
        }
        this.proxySelector = proxySelector$okhttp;
        this.proxyAuthenticator = builder.getProxyAuthenticator$okhttp();
        this.socketFactory = builder.getSocketFactory$okhttp();
        List<ConnectionSpec> connectionSpecs$okhttp = builder.getConnectionSpecs$okhttp();
        this.connectionSpecs = connectionSpecs$okhttp;
        this.protocols = builder.getProtocols$okhttp();
        this.hostnameVerifier = builder.getHostnameVerifier$okhttp();
        this.callTimeoutMillis = builder.getCallTimeout$okhttp();
        this.connectTimeoutMillis = builder.getConnectTimeout$okhttp();
        this.readTimeoutMillis = builder.getReadTimeout$okhttp();
        this.writeTimeoutMillis = builder.getWriteTimeout$okhttp();
        this.pingIntervalMillis = builder.getPingInterval$okhttp();
        this.minWebSocketMessageToCompress = builder.getMinWebSocketMessageToCompress$okhttp();
        RouteDatabase routeDatabase$okhttp = builder.getRouteDatabase$okhttp();
        this.routeDatabase = routeDatabase$okhttp == null ? new RouteDatabase() : routeDatabase$okhttp;
        boolean z = true;
        if (!(connectionSpecs$okhttp instanceof Collection) || !connectionSpecs$okhttp.isEmpty()) {
            Iterator<T> it = connectionSpecs$okhttp.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (((ConnectionSpec) it.next()).isTls()) {
                    z = false;
                    break;
                }
            }
        }
        if (z) {
            this.sslSocketFactoryOrNull = null;
            this.certificateChainCleaner = null;
            this.x509TrustManager = null;
            this.certificatePinner = CertificatePinner.DEFAULT;
        } else if (builder.getSslSocketFactoryOrNull$okhttp() != null) {
            this.sslSocketFactoryOrNull = builder.getSslSocketFactoryOrNull$okhttp();
            CertificateChainCleaner certificateChainCleaner$okhttp = builder.getCertificateChainCleaner$okhttp();
            this.certificateChainCleaner = certificateChainCleaner$okhttp;
            this.x509TrustManager = builder.getX509TrustManagerOrNull$okhttp();
            this.certificatePinner = builder.getCertificatePinner$okhttp().withCertificateChainCleaner$okhttp(certificateChainCleaner$okhttp);
        } else {
            Platform.Companion companion = Platform.Companion;
            X509TrustManager platformTrustManager = companion.get().platformTrustManager();
            this.x509TrustManager = platformTrustManager;
            this.sslSocketFactoryOrNull = companion.get().newSslSocketFactory(platformTrustManager);
            CertificateChainCleaner certificateChainCleaner = CertificateChainCleaner.Companion.get(platformTrustManager);
            this.certificateChainCleaner = certificateChainCleaner;
            this.certificatePinner = builder.getCertificatePinner$okhttp().withCertificateChainCleaner$okhttp(certificateChainCleaner);
        }
        verifyClientState();
    }

    private final void verifyClientState() {
        boolean z;
        List<Interceptor> list = this.interceptors;
        Objects.requireNonNull(list, "null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
        if (!list.contains(null)) {
            List<Interceptor> list2 = this.networkInterceptors;
            Objects.requireNonNull(list2, "null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
            if (!list2.contains(null)) {
                List<ConnectionSpec> list3 = this.connectionSpecs;
                if (!(list3 instanceof Collection) || !list3.isEmpty()) {
                    for (ConnectionSpec connectionSpec : list3) {
                        if (connectionSpec.isTls()) {
                            z = false;
                            break;
                        }
                    }
                }
                z = true;
                if (z) {
                    if (this.sslSocketFactoryOrNull == null) {
                        if (this.certificateChainCleaner == null) {
                            if (this.x509TrustManager == null) {
                                if (!f0.g(this.certificatePinner, CertificatePinner.DEFAULT)) {
                                    throw new IllegalStateException("Check failed.".toString());
                                }
                                return;
                            }
                            throw new IllegalStateException("Check failed.".toString());
                        }
                        throw new IllegalStateException("Check failed.".toString());
                    }
                    throw new IllegalStateException("Check failed.".toString());
                } else if (this.sslSocketFactoryOrNull != null) {
                    if (this.certificateChainCleaner != null) {
                        if (this.x509TrustManager == null) {
                            throw new IllegalStateException("x509TrustManager == null".toString());
                        }
                        return;
                    }
                    throw new IllegalStateException("certificateChainCleaner == null".toString());
                } else {
                    throw new IllegalStateException("sslSocketFactory == null".toString());
                }
            }
            throw new IllegalStateException(("Null network interceptor: " + this.networkInterceptors).toString());
        }
        throw new IllegalStateException(("Null interceptor: " + this.interceptors).toString());
    }

    @g(name = "-deprecated_authenticator")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "authenticator", imports = {}))
    @d
    /* renamed from: -deprecated_authenticator */
    public final Authenticator m202deprecated_authenticator() {
        return this.authenticator;
    }

    @g(name = "-deprecated_cache")
    @e
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "cache", imports = {}))
    /* renamed from: -deprecated_cache */
    public final Cache m203deprecated_cache() {
        return this.cache;
    }

    @g(name = "-deprecated_callTimeoutMillis")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "callTimeoutMillis", imports = {}))
    /* renamed from: -deprecated_callTimeoutMillis */
    public final int m204deprecated_callTimeoutMillis() {
        return this.callTimeoutMillis;
    }

    @g(name = "-deprecated_certificatePinner")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "certificatePinner", imports = {}))
    @d
    /* renamed from: -deprecated_certificatePinner */
    public final CertificatePinner m205deprecated_certificatePinner() {
        return this.certificatePinner;
    }

    @g(name = "-deprecated_connectTimeoutMillis")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "connectTimeoutMillis", imports = {}))
    /* renamed from: -deprecated_connectTimeoutMillis */
    public final int m206deprecated_connectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    @g(name = "-deprecated_connectionPool")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "connectionPool", imports = {}))
    @d
    /* renamed from: -deprecated_connectionPool */
    public final ConnectionPool m207deprecated_connectionPool() {
        return this.connectionPool;
    }

    @g(name = "-deprecated_connectionSpecs")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "connectionSpecs", imports = {}))
    @d
    /* renamed from: -deprecated_connectionSpecs */
    public final List<ConnectionSpec> m208deprecated_connectionSpecs() {
        return this.connectionSpecs;
    }

    @g(name = "-deprecated_cookieJar")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "cookieJar", imports = {}))
    @d
    /* renamed from: -deprecated_cookieJar */
    public final CookieJar m209deprecated_cookieJar() {
        return this.cookieJar;
    }

    @g(name = "-deprecated_dispatcher")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "dispatcher", imports = {}))
    @d
    /* renamed from: -deprecated_dispatcher */
    public final Dispatcher m210deprecated_dispatcher() {
        return this.dispatcher;
    }

    @g(name = "-deprecated_dns")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = DnsSource.Udp, imports = {}))
    @d
    /* renamed from: -deprecated_dns */
    public final Dns m211deprecated_dns() {
        return this.dns;
    }

    @g(name = "-deprecated_eventListenerFactory")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "eventListenerFactory", imports = {}))
    @d
    /* renamed from: -deprecated_eventListenerFactory */
    public final EventListener.Factory m212deprecated_eventListenerFactory() {
        return this.eventListenerFactory;
    }

    @g(name = "-deprecated_followRedirects")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "followRedirects", imports = {}))
    /* renamed from: -deprecated_followRedirects */
    public final boolean m213deprecated_followRedirects() {
        return this.followRedirects;
    }

    @g(name = "-deprecated_followSslRedirects")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "followSslRedirects", imports = {}))
    /* renamed from: -deprecated_followSslRedirects */
    public final boolean m214deprecated_followSslRedirects() {
        return this.followSslRedirects;
    }

    @g(name = "-deprecated_hostnameVerifier")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "hostnameVerifier", imports = {}))
    @d
    /* renamed from: -deprecated_hostnameVerifier */
    public final HostnameVerifier m215deprecated_hostnameVerifier() {
        return this.hostnameVerifier;
    }

    @g(name = "-deprecated_interceptors")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "interceptors", imports = {}))
    @d
    /* renamed from: -deprecated_interceptors */
    public final List<Interceptor> m216deprecated_interceptors() {
        return this.interceptors;
    }

    @g(name = "-deprecated_networkInterceptors")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "networkInterceptors", imports = {}))
    @d
    /* renamed from: -deprecated_networkInterceptors */
    public final List<Interceptor> m217deprecated_networkInterceptors() {
        return this.networkInterceptors;
    }

    @g(name = "-deprecated_pingIntervalMillis")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "pingIntervalMillis", imports = {}))
    /* renamed from: -deprecated_pingIntervalMillis */
    public final int m218deprecated_pingIntervalMillis() {
        return this.pingIntervalMillis;
    }

    @g(name = "-deprecated_protocols")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "protocols", imports = {}))
    @d
    /* renamed from: -deprecated_protocols */
    public final List<Protocol> m219deprecated_protocols() {
        return this.protocols;
    }

    @g(name = "-deprecated_proxy")
    @e
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "proxy", imports = {}))
    /* renamed from: -deprecated_proxy */
    public final Proxy m220deprecated_proxy() {
        return this.proxy;
    }

    @g(name = "-deprecated_proxyAuthenticator")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "proxyAuthenticator", imports = {}))
    @d
    /* renamed from: -deprecated_proxyAuthenticator */
    public final Authenticator m221deprecated_proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    @g(name = "-deprecated_proxySelector")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "proxySelector", imports = {}))
    @d
    /* renamed from: -deprecated_proxySelector */
    public final ProxySelector m222deprecated_proxySelector() {
        return this.proxySelector;
    }

    @g(name = "-deprecated_readTimeoutMillis")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "readTimeoutMillis", imports = {}))
    /* renamed from: -deprecated_readTimeoutMillis */
    public final int m223deprecated_readTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    @g(name = "-deprecated_retryOnConnectionFailure")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "retryOnConnectionFailure", imports = {}))
    /* renamed from: -deprecated_retryOnConnectionFailure */
    public final boolean m224deprecated_retryOnConnectionFailure() {
        return this.retryOnConnectionFailure;
    }

    @g(name = "-deprecated_socketFactory")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "socketFactory", imports = {}))
    @d
    /* renamed from: -deprecated_socketFactory */
    public final SocketFactory m225deprecated_socketFactory() {
        return this.socketFactory;
    }

    @g(name = "-deprecated_sslSocketFactory")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "sslSocketFactory", imports = {}))
    @d
    /* renamed from: -deprecated_sslSocketFactory */
    public final SSLSocketFactory m226deprecated_sslSocketFactory() {
        return sslSocketFactory();
    }

    @g(name = "-deprecated_writeTimeoutMillis")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "writeTimeoutMillis", imports = {}))
    /* renamed from: -deprecated_writeTimeoutMillis */
    public final int m227deprecated_writeTimeoutMillis() {
        return this.writeTimeoutMillis;
    }

    @g(name = "authenticator")
    @d
    public final Authenticator authenticator() {
        return this.authenticator;
    }

    @g(name = "cache")
    @e
    public final Cache cache() {
        return this.cache;
    }

    @g(name = "callTimeoutMillis")
    public final int callTimeoutMillis() {
        return this.callTimeoutMillis;
    }

    @g(name = "certificateChainCleaner")
    @e
    public final CertificateChainCleaner certificateChainCleaner() {
        return this.certificateChainCleaner;
    }

    @g(name = "certificatePinner")
    @d
    public final CertificatePinner certificatePinner() {
        return this.certificatePinner;
    }

    @d
    public Object clone() {
        return super.clone();
    }

    @g(name = "connectTimeoutMillis")
    public final int connectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    @g(name = "connectionPool")
    @d
    public final ConnectionPool connectionPool() {
        return this.connectionPool;
    }

    @g(name = "connectionSpecs")
    @d
    public final List<ConnectionSpec> connectionSpecs() {
        return this.connectionSpecs;
    }

    @g(name = "cookieJar")
    @d
    public final CookieJar cookieJar() {
        return this.cookieJar;
    }

    @g(name = "dispatcher")
    @d
    public final Dispatcher dispatcher() {
        return this.dispatcher;
    }

    @g(name = DnsSource.Udp)
    @d
    public final Dns dns() {
        return this.dns;
    }

    @g(name = "eventListenerFactory")
    @d
    public final EventListener.Factory eventListenerFactory() {
        return this.eventListenerFactory;
    }

    @g(name = "followRedirects")
    public final boolean followRedirects() {
        return this.followRedirects;
    }

    @g(name = "followSslRedirects")
    public final boolean followSslRedirects() {
        return this.followSslRedirects;
    }

    @d
    public final RouteDatabase getRouteDatabase() {
        return this.routeDatabase;
    }

    @g(name = "hostnameVerifier")
    @d
    public final HostnameVerifier hostnameVerifier() {
        return this.hostnameVerifier;
    }

    @g(name = "interceptors")
    @d
    public final List<Interceptor> interceptors() {
        return this.interceptors;
    }

    @g(name = "minWebSocketMessageToCompress")
    public final long minWebSocketMessageToCompress() {
        return this.minWebSocketMessageToCompress;
    }

    @g(name = "networkInterceptors")
    @d
    public final List<Interceptor> networkInterceptors() {
        return this.networkInterceptors;
    }

    @d
    public Builder newBuilder() {
        return new Builder(this);
    }

    @Override // okhttp3.Call.Factory
    @d
    public Call newCall(@d Request request) {
        return new RealCall(this, request, false);
    }

    @Override // okhttp3.WebSocket.Factory
    @d
    public WebSocket newWebSocket(@d Request request, @d WebSocketListener webSocketListener) {
        RealWebSocket realWebSocket = new RealWebSocket(TaskRunner.INSTANCE, request, webSocketListener, new Random(), this.pingIntervalMillis, null, this.minWebSocketMessageToCompress);
        realWebSocket.connect(this);
        return realWebSocket;
    }

    @g(name = "pingIntervalMillis")
    public final int pingIntervalMillis() {
        return this.pingIntervalMillis;
    }

    @g(name = "protocols")
    @d
    public final List<Protocol> protocols() {
        return this.protocols;
    }

    @g(name = "proxy")
    @e
    public final Proxy proxy() {
        return this.proxy;
    }

    @g(name = "proxyAuthenticator")
    @d
    public final Authenticator proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    @g(name = "proxySelector")
    @d
    public final ProxySelector proxySelector() {
        return this.proxySelector;
    }

    @g(name = "readTimeoutMillis")
    public final int readTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    @g(name = "retryOnConnectionFailure")
    public final boolean retryOnConnectionFailure() {
        return this.retryOnConnectionFailure;
    }

    @g(name = "socketFactory")
    @d
    public final SocketFactory socketFactory() {
        return this.socketFactory;
    }

    @g(name = "sslSocketFactory")
    @d
    public final SSLSocketFactory sslSocketFactory() {
        SSLSocketFactory sSLSocketFactory = this.sslSocketFactoryOrNull;
        if (sSLSocketFactory != null) {
            return sSLSocketFactory;
        }
        throw new IllegalStateException("CLEARTEXT-only client");
    }

    @g(name = "writeTimeoutMillis")
    public final int writeTimeoutMillis() {
        return this.writeTimeoutMillis;
    }

    @g(name = "x509TrustManager")
    @e
    public final X509TrustManager x509TrustManager() {
        return this.x509TrustManager;
    }

    public OkHttpClient() {
        this(new Builder());
    }
}
