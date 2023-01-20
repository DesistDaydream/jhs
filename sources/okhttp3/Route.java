package okhttp3;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import h.i;
import h.k2.g;
import h.k2.v.f0;
import h.q0;
import java.net.InetSocketAddress;
import java.net.Proxy;
import k.e.a.d;
import k.e.a.e;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\u0005\u001a\u00020\u00028\u0007@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u0005\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00068\u0007@\u0006¢\u0006\f\n\u0004\b\t\u0010\u001b\u001a\u0004\b\t\u0010\bR\u0019\u0010\r\u001a\u00020\n8\u0007@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\r\u0010\f¨\u0006\u001f"}, d2 = {"Lokhttp3/Route;", "", "Lokhttp3/Address;", "-deprecated_address", "()Lokhttp3/Address;", "address", "Ljava/net/Proxy;", "-deprecated_proxy", "()Ljava/net/Proxy;", "proxy", "Ljava/net/InetSocketAddress;", "-deprecated_socketAddress", "()Ljava/net/InetSocketAddress;", "socketAddress", "", "requiresTunnel", "()Z", "other", "equals", "(Ljava/lang/Object;)Z", "", TTDownloadField.TT_HASHCODE, "()I", "", "toString", "()Ljava/lang/String;", "Lokhttp3/Address;", "Ljava/net/Proxy;", "Ljava/net/InetSocketAddress;", "<init>", "(Lokhttp3/Address;Ljava/net/Proxy;Ljava/net/InetSocketAddress;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class Route {
    @d
    private final Address address;
    @d
    private final Proxy proxy;
    @d
    private final InetSocketAddress socketAddress;

    public Route(@d Address address, @d Proxy proxy, @d InetSocketAddress inetSocketAddress) {
        this.address = address;
        this.proxy = proxy;
        this.socketAddress = inetSocketAddress;
    }

    @g(name = "-deprecated_address")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "address", imports = {}))
    @d
    /* renamed from: -deprecated_address  reason: not valid java name */
    public final Address m248deprecated_address() {
        return this.address;
    }

    @g(name = "-deprecated_proxy")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "proxy", imports = {}))
    @d
    /* renamed from: -deprecated_proxy  reason: not valid java name */
    public final Proxy m249deprecated_proxy() {
        return this.proxy;
    }

    @g(name = "-deprecated_socketAddress")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "socketAddress", imports = {}))
    @d
    /* renamed from: -deprecated_socketAddress  reason: not valid java name */
    public final InetSocketAddress m250deprecated_socketAddress() {
        return this.socketAddress;
    }

    @g(name = "address")
    @d
    public final Address address() {
        return this.address;
    }

    public boolean equals(@e Object obj) {
        if (obj instanceof Route) {
            Route route = (Route) obj;
            if (f0.g(route.address, this.address) && f0.g(route.proxy, this.proxy) && f0.g(route.socketAddress, this.socketAddress)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((527 + this.address.hashCode()) * 31) + this.proxy.hashCode()) * 31) + this.socketAddress.hashCode();
    }

    @g(name = "proxy")
    @d
    public final Proxy proxy() {
        return this.proxy;
    }

    public final boolean requiresTunnel() {
        return this.address.sslSocketFactory() != null && this.proxy.type() == Proxy.Type.HTTP;
    }

    @g(name = "socketAddress")
    @d
    public final InetSocketAddress socketAddress() {
        return this.socketAddress;
    }

    @d
    public String toString() {
        return "Route{" + this.socketAddress + '}';
    }
}
