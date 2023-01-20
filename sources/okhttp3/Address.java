package okhttp3;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.qiniu.android.http.dns.DnsSource;
import h.i;
import h.k2.g;
import h.k2.v.f0;
import h.q0;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import k.e.a.d;
import k.e.a.e;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import okhttp3.HttpUrl;
import okhttp3.internal.Util;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0011\u0018\u00002\u00020\u0001B{\u0012\u0006\u0010F\u001a\u000209\u0012\u0006\u0010G\u001a\u000202\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\n\u0012\b\u0010%\u001a\u0004\u0018\u00010\"\u0012\b\u0010)\u001a\u0004\u0018\u00010&\u0012\b\u0010-\u001a\u0004\u0018\u00010*\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\b\u0010!\u001a\u0004\u0018\u00010\u001e\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00170\u0012\u0012\u0006\u0010\u001d\u001a\u00020\u001a¢\u0006\u0004\bH\u0010IJ\u000f\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0011\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00170\u0012H\u0007¢\u0006\u0004\b\u0018\u0010\u0015J\u000f\u0010\u001d\u001a\u00020\u001aH\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u0011\u0010!\u001a\u0004\u0018\u00010\u001eH\u0007¢\u0006\u0004\b\u001f\u0010 J\u0011\u0010%\u001a\u0004\u0018\u00010\"H\u0007¢\u0006\u0004\b#\u0010$J\u0011\u0010)\u001a\u0004\u0018\u00010&H\u0007¢\u0006\u0004\b'\u0010(J\u0011\u0010-\u001a\u0004\u0018\u00010*H\u0007¢\u0006\u0004\b+\u0010,J\u001a\u00100\u001a\u00020/2\b\u0010.\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b0\u00101J\u000f\u00103\u001a\u000202H\u0016¢\u0006\u0004\b3\u00104J\u0017\u00108\u001a\u00020/2\u0006\u00105\u001a\u00020\u0000H\u0000¢\u0006\u0004\b6\u00107J\u000f\u0010:\u001a\u000209H\u0016¢\u0006\u0004\b:\u0010;R\u001b\u0010!\u001a\u0004\u0018\u00010\u001e8\u0007@\u0006¢\u0006\f\n\u0004\b!\u0010<\u001a\u0004\b!\u0010 R\u001b\u0010%\u001a\u0004\u0018\u00010\"8\u0007@\u0006¢\u0006\f\n\u0004\b%\u0010=\u001a\u0004\b%\u0010$R\u0019\u0010\t\u001a\u00020\u00068\u0007@\u0006¢\u0006\f\n\u0004\b\t\u0010>\u001a\u0004\b\t\u0010\bR\u0019\u0010\u0011\u001a\u00020\u000e8\u0007@\u0006¢\u0006\f\n\u0004\b\u0011\u0010?\u001a\u0004\b\u0011\u0010\u0010R\u0019\u0010\r\u001a\u00020\n8\u0007@\u0006¢\u0006\f\n\u0004\b\r\u0010@\u001a\u0004\b\r\u0010\fR\u0019\u0010\u0005\u001a\u00020\u00028G@\u0006¢\u0006\f\n\u0004\b\u0005\u0010A\u001a\u0004\b\u0005\u0010\u0004R\u001f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00170\u00128G@\u0006¢\u0006\f\n\u0004\b\u0019\u0010B\u001a\u0004\b\u0019\u0010\u0015R\u0019\u0010\u001d\u001a\u00020\u001a8\u0007@\u0006¢\u0006\f\n\u0004\b\u001d\u0010C\u001a\u0004\b\u001d\u0010\u001cR\u001f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128G@\u0006¢\u0006\f\n\u0004\b\u0016\u0010B\u001a\u0004\b\u0016\u0010\u0015R\u001b\u0010)\u001a\u0004\u0018\u00010&8\u0007@\u0006¢\u0006\f\n\u0004\b)\u0010D\u001a\u0004\b)\u0010(R\u001b\u0010-\u001a\u0004\u0018\u00010*8\u0007@\u0006¢\u0006\f\n\u0004\b-\u0010E\u001a\u0004\b-\u0010,¨\u0006J"}, d2 = {"Lokhttp3/Address;", "", "Lokhttp3/HttpUrl;", "-deprecated_url", "()Lokhttp3/HttpUrl;", "url", "Lokhttp3/Dns;", "-deprecated_dns", "()Lokhttp3/Dns;", DnsSource.Udp, "Ljavax/net/SocketFactory;", "-deprecated_socketFactory", "()Ljavax/net/SocketFactory;", "socketFactory", "Lokhttp3/Authenticator;", "-deprecated_proxyAuthenticator", "()Lokhttp3/Authenticator;", "proxyAuthenticator", "", "Lokhttp3/Protocol;", "-deprecated_protocols", "()Ljava/util/List;", "protocols", "Lokhttp3/ConnectionSpec;", "-deprecated_connectionSpecs", "connectionSpecs", "Ljava/net/ProxySelector;", "-deprecated_proxySelector", "()Ljava/net/ProxySelector;", "proxySelector", "Ljava/net/Proxy;", "-deprecated_proxy", "()Ljava/net/Proxy;", "proxy", "Ljavax/net/ssl/SSLSocketFactory;", "-deprecated_sslSocketFactory", "()Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactory", "Ljavax/net/ssl/HostnameVerifier;", "-deprecated_hostnameVerifier", "()Ljavax/net/ssl/HostnameVerifier;", "hostnameVerifier", "Lokhttp3/CertificatePinner;", "-deprecated_certificatePinner", "()Lokhttp3/CertificatePinner;", "certificatePinner", "other", "", "equals", "(Ljava/lang/Object;)Z", "", TTDownloadField.TT_HASHCODE, "()I", "that", "equalsNonHost$okhttp", "(Lokhttp3/Address;)Z", "equalsNonHost", "", "toString", "()Ljava/lang/String;", "Ljava/net/Proxy;", "Ljavax/net/ssl/SSLSocketFactory;", "Lokhttp3/Dns;", "Lokhttp3/Authenticator;", "Ljavax/net/SocketFactory;", "Lokhttp3/HttpUrl;", "Ljava/util/List;", "Ljava/net/ProxySelector;", "Ljavax/net/ssl/HostnameVerifier;", "Lokhttp3/CertificatePinner;", "uriHost", "uriPort", "<init>", "(Ljava/lang/String;ILokhttp3/Dns;Ljavax/net/SocketFactory;Ljavax/net/ssl/SSLSocketFactory;Ljavax/net/ssl/HostnameVerifier;Lokhttp3/CertificatePinner;Lokhttp3/Authenticator;Ljava/net/Proxy;Ljava/util/List;Ljava/util/List;Ljava/net/ProxySelector;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class Address {
    @e
    private final CertificatePinner certificatePinner;
    @d
    private final List<ConnectionSpec> connectionSpecs;
    @d
    private final Dns dns;
    @e
    private final HostnameVerifier hostnameVerifier;
    @d
    private final List<Protocol> protocols;
    @e
    private final Proxy proxy;
    @d
    private final Authenticator proxyAuthenticator;
    @d
    private final ProxySelector proxySelector;
    @d
    private final SocketFactory socketFactory;
    @e
    private final SSLSocketFactory sslSocketFactory;
    @d
    private final HttpUrl url;

    public Address(@d String str, int i2, @d Dns dns, @d SocketFactory socketFactory, @e SSLSocketFactory sSLSocketFactory, @e HostnameVerifier hostnameVerifier, @e CertificatePinner certificatePinner, @d Authenticator authenticator, @e Proxy proxy, @d List<? extends Protocol> list, @d List<ConnectionSpec> list2, @d ProxySelector proxySelector) {
        this.dns = dns;
        this.socketFactory = socketFactory;
        this.sslSocketFactory = sSLSocketFactory;
        this.hostnameVerifier = hostnameVerifier;
        this.certificatePinner = certificatePinner;
        this.proxyAuthenticator = authenticator;
        this.proxy = proxy;
        this.proxySelector = proxySelector;
        this.url = new HttpUrl.Builder().scheme(sSLSocketFactory != null ? "https" : "http").host(str).port(i2).build();
        this.protocols = Util.toImmutableList(list);
        this.connectionSpecs = Util.toImmutableList(list2);
    }

    @g(name = "-deprecated_certificatePinner")
    @e
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "certificatePinner", imports = {}))
    /* renamed from: -deprecated_certificatePinner */
    public final CertificatePinner m118deprecated_certificatePinner() {
        return this.certificatePinner;
    }

    @g(name = "-deprecated_connectionSpecs")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "connectionSpecs", imports = {}))
    @d
    /* renamed from: -deprecated_connectionSpecs */
    public final List<ConnectionSpec> m119deprecated_connectionSpecs() {
        return this.connectionSpecs;
    }

    @g(name = "-deprecated_dns")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = DnsSource.Udp, imports = {}))
    @d
    /* renamed from: -deprecated_dns */
    public final Dns m120deprecated_dns() {
        return this.dns;
    }

    @g(name = "-deprecated_hostnameVerifier")
    @e
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "hostnameVerifier", imports = {}))
    /* renamed from: -deprecated_hostnameVerifier */
    public final HostnameVerifier m121deprecated_hostnameVerifier() {
        return this.hostnameVerifier;
    }

    @g(name = "-deprecated_protocols")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "protocols", imports = {}))
    @d
    /* renamed from: -deprecated_protocols */
    public final List<Protocol> m122deprecated_protocols() {
        return this.protocols;
    }

    @g(name = "-deprecated_proxy")
    @e
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "proxy", imports = {}))
    /* renamed from: -deprecated_proxy */
    public final Proxy m123deprecated_proxy() {
        return this.proxy;
    }

    @g(name = "-deprecated_proxyAuthenticator")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "proxyAuthenticator", imports = {}))
    @d
    /* renamed from: -deprecated_proxyAuthenticator */
    public final Authenticator m124deprecated_proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    @g(name = "-deprecated_proxySelector")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "proxySelector", imports = {}))
    @d
    /* renamed from: -deprecated_proxySelector */
    public final ProxySelector m125deprecated_proxySelector() {
        return this.proxySelector;
    }

    @g(name = "-deprecated_socketFactory")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "socketFactory", imports = {}))
    @d
    /* renamed from: -deprecated_socketFactory */
    public final SocketFactory m126deprecated_socketFactory() {
        return this.socketFactory;
    }

    @g(name = "-deprecated_sslSocketFactory")
    @e
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "sslSocketFactory", imports = {}))
    /* renamed from: -deprecated_sslSocketFactory */
    public final SSLSocketFactory m127deprecated_sslSocketFactory() {
        return this.sslSocketFactory;
    }

    @g(name = "-deprecated_url")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "url", imports = {}))
    @d
    /* renamed from: -deprecated_url */
    public final HttpUrl m128deprecated_url() {
        return this.url;
    }

    @g(name = "certificatePinner")
    @e
    public final CertificatePinner certificatePinner() {
        return this.certificatePinner;
    }

    @g(name = "connectionSpecs")
    @d
    public final List<ConnectionSpec> connectionSpecs() {
        return this.connectionSpecs;
    }

    @g(name = DnsSource.Udp)
    @d
    public final Dns dns() {
        return this.dns;
    }

    public boolean equals(@e Object obj) {
        if (obj instanceof Address) {
            Address address = (Address) obj;
            if (f0.g(this.url, address.url) && equalsNonHost$okhttp(address)) {
                return true;
            }
        }
        return false;
    }

    public final boolean equalsNonHost$okhttp(@d Address address) {
        return f0.g(this.dns, address.dns) && f0.g(this.proxyAuthenticator, address.proxyAuthenticator) && f0.g(this.protocols, address.protocols) && f0.g(this.connectionSpecs, address.connectionSpecs) && f0.g(this.proxySelector, address.proxySelector) && f0.g(this.proxy, address.proxy) && f0.g(this.sslSocketFactory, address.sslSocketFactory) && f0.g(this.hostnameVerifier, address.hostnameVerifier) && f0.g(this.certificatePinner, address.certificatePinner) && this.url.port() == address.url.port();
    }

    public int hashCode() {
        return ((((((((((((((((((527 + this.url.hashCode()) * 31) + this.dns.hashCode()) * 31) + this.proxyAuthenticator.hashCode()) * 31) + this.protocols.hashCode()) * 31) + this.connectionSpecs.hashCode()) * 31) + this.proxySelector.hashCode()) * 31) + Objects.hashCode(this.proxy)) * 31) + Objects.hashCode(this.sslSocketFactory)) * 31) + Objects.hashCode(this.hostnameVerifier)) * 31) + Objects.hashCode(this.certificatePinner);
    }

    @g(name = "hostnameVerifier")
    @e
    public final HostnameVerifier hostnameVerifier() {
        return this.hostnameVerifier;
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

    @g(name = "socketFactory")
    @d
    public final SocketFactory socketFactory() {
        return this.socketFactory;
    }

    @g(name = "sslSocketFactory")
    @e
    public final SSLSocketFactory sslSocketFactory() {
        return this.sslSocketFactory;
    }

    @d
    public String toString() {
        StringBuilder sb;
        Object obj;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Address{");
        sb2.append(this.url.host());
        sb2.append(':');
        sb2.append(this.url.port());
        sb2.append(", ");
        if (this.proxy != null) {
            sb = new StringBuilder();
            sb.append("proxy=");
            obj = this.proxy;
        } else {
            sb = new StringBuilder();
            sb.append("proxySelector=");
            obj = this.proxySelector;
        }
        sb.append(obj);
        sb2.append(sb.toString());
        sb2.append("}");
        return sb2.toString();
    }

    @g(name = "url")
    @d
    public final HttpUrl url() {
        return this.url;
    }
}
