package okhttp3.internal.connection;

import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import h.a2.y;
import h.k2.v.u;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.Route;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 -2\u00020\u0001:\u0002-.B'\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\u0006\u0010&\u001a\u00020%\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b+\u0010,J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\tH\u0086\u0002¢\u0006\u0004\b\u0010\u0010\u000bJ\u0010\u0010\u0012\u001a\u00020\u0011H\u0086\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u0017R\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u0017R\u0016\u0010 \u001a\u00020\u001f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010&\u001a\u00020%8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010)\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*¨\u0006/"}, d2 = {"Lokhttp3/internal/connection/RouteSelector;", "", "Lokhttp3/HttpUrl;", "url", "Ljava/net/Proxy;", "proxy", "Lh/t1;", "resetNextProxy", "(Lokhttp3/HttpUrl;Ljava/net/Proxy;)V", "", "hasNextProxy", "()Z", "nextProxy", "()Ljava/net/Proxy;", "resetNextInetSocketAddress", "(Ljava/net/Proxy;)V", "hasNext", "Lokhttp3/internal/connection/RouteSelector$Selection;", "next", "()Lokhttp3/internal/connection/RouteSelector$Selection;", "", "Ljava/net/InetSocketAddress;", "inetSocketAddresses", "Ljava/util/List;", "Lokhttp3/Call;", "call", "Lokhttp3/Call;", "proxies", "", "Lokhttp3/Route;", "postponedRoutes", "Lokhttp3/Address;", "address", "Lokhttp3/Address;", "Lokhttp3/EventListener;", "eventListener", "Lokhttp3/EventListener;", "Lokhttp3/internal/connection/RouteDatabase;", "routeDatabase", "Lokhttp3/internal/connection/RouteDatabase;", "", "nextProxyIndex", ExpandableTextView.P, "<init>", "(Lokhttp3/Address;Lokhttp3/internal/connection/RouteDatabase;Lokhttp3/Call;Lokhttp3/EventListener;)V", "Companion", "Selection", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class RouteSelector {
    public static final Companion Companion = new Companion(null);
    private final Address address;
    private final Call call;
    private final EventListener eventListener;
    private int nextProxyIndex;
    private final RouteDatabase routeDatabase;
    private List<? extends Proxy> proxies = CollectionsKt__CollectionsKt.E();
    private List<? extends InetSocketAddress> inetSocketAddresses = CollectionsKt__CollectionsKt.E();
    private final List<Route> postponedRoutes = new ArrayList();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u0003*\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\t"}, d2 = {"Lokhttp3/internal/connection/RouteSelector$Companion;", "", "Ljava/net/InetSocketAddress;", "", "getSocketHost", "(Ljava/net/InetSocketAddress;)Ljava/lang/String;", "socketHost", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        @d
        public final String getSocketHost(@d InetSocketAddress inetSocketAddress) {
            InetAddress address = inetSocketAddress.getAddress();
            if (address != null) {
                return address.getHostAddress();
            }
            return inetSocketAddress.getHostName();
        }

        public /* synthetic */ Companion(u uVar) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0003\u001a\u00020\u0002H\u0086\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005H\u0086\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lokhttp3/internal/connection/RouteSelector$Selection;", "", "", "hasNext", "()Z", "Lokhttp3/Route;", "next", "()Lokhttp3/Route;", "", "nextRouteIndex", ExpandableTextView.P, "", "routes", "Ljava/util/List;", "getRoutes", "()Ljava/util/List;", "<init>", "(Ljava/util/List;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class Selection {
        private int nextRouteIndex;
        @d
        private final List<Route> routes;

        public Selection(@d List<Route> list) {
            this.routes = list;
        }

        @d
        public final List<Route> getRoutes() {
            return this.routes;
        }

        public final boolean hasNext() {
            return this.nextRouteIndex < this.routes.size();
        }

        @d
        public final Route next() {
            if (hasNext()) {
                List<Route> list = this.routes;
                int i2 = this.nextRouteIndex;
                this.nextRouteIndex = i2 + 1;
                return list.get(i2);
            }
            throw new NoSuchElementException();
        }
    }

    public RouteSelector(@d Address address, @d RouteDatabase routeDatabase, @d Call call, @d EventListener eventListener) {
        this.address = address;
        this.routeDatabase = routeDatabase;
        this.call = call;
        this.eventListener = eventListener;
        resetNextProxy(address.url(), address.proxy());
    }

    private final boolean hasNextProxy() {
        return this.nextProxyIndex < this.proxies.size();
    }

    private final Proxy nextProxy() throws IOException {
        if (hasNextProxy()) {
            List<? extends Proxy> list = this.proxies;
            int i2 = this.nextProxyIndex;
            this.nextProxyIndex = i2 + 1;
            Proxy proxy = list.get(i2);
            resetNextInetSocketAddress(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.address.url().host() + "; exhausted proxy configurations: " + this.proxies);
    }

    private final void resetNextInetSocketAddress(Proxy proxy) throws IOException {
        String host;
        int port;
        ArrayList arrayList = new ArrayList();
        this.inetSocketAddresses = arrayList;
        if (proxy.type() != Proxy.Type.DIRECT && proxy.type() != Proxy.Type.SOCKS) {
            SocketAddress address = proxy.address();
            if (address instanceof InetSocketAddress) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                host = Companion.getSocketHost(inetSocketAddress);
                port = inetSocketAddress.getPort();
            } else {
                throw new IllegalArgumentException(("Proxy.address() is not an InetSocketAddress: " + address.getClass()).toString());
            }
        } else {
            host = this.address.url().host();
            port = this.address.url().port();
        }
        if (1 <= port && 65535 >= port) {
            if (proxy.type() == Proxy.Type.SOCKS) {
                arrayList.add(InetSocketAddress.createUnresolved(host, port));
                return;
            }
            this.eventListener.dnsStart(this.call, host);
            List<InetAddress> lookup = this.address.dns().lookup(host);
            if (!lookup.isEmpty()) {
                this.eventListener.dnsEnd(this.call, host, lookup);
                for (InetAddress inetAddress : lookup) {
                    arrayList.add(new InetSocketAddress(inetAddress, port));
                }
                return;
            }
            throw new UnknownHostException(this.address.dns() + " returned no addresses for " + host);
        }
        throw new SocketException("No route to " + host + ':' + port + "; port is out of range");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void resetNextProxy(HttpUrl httpUrl, Proxy proxy) {
        RouteSelector$resetNextProxy$1 routeSelector$resetNextProxy$1 = new RouteSelector$resetNextProxy$1(this, proxy, httpUrl);
        this.eventListener.proxySelectStart(this.call, httpUrl);
        List<? extends Proxy> invoke2 = routeSelector$resetNextProxy$1.invoke2();
        this.proxies = invoke2;
        this.nextProxyIndex = 0;
        this.eventListener.proxySelectEnd(this.call, httpUrl, invoke2);
    }

    public final boolean hasNext() {
        return hasNextProxy() || (this.postponedRoutes.isEmpty() ^ true);
    }

    @d
    public final Selection next() throws IOException {
        if (hasNext()) {
            ArrayList arrayList = new ArrayList();
            while (hasNextProxy()) {
                Proxy nextProxy = nextProxy();
                for (InetSocketAddress inetSocketAddress : this.inetSocketAddresses) {
                    Route route = new Route(this.address, nextProxy, inetSocketAddress);
                    if (this.routeDatabase.shouldPostpone(route)) {
                        this.postponedRoutes.add(route);
                    } else {
                        arrayList.add(route);
                    }
                }
                if (!arrayList.isEmpty()) {
                    break;
                }
            }
            if (arrayList.isEmpty()) {
                y.q0(arrayList, this.postponedRoutes);
                this.postponedRoutes.clear();
            }
            return new Selection(arrayList);
        }
        throw new NoSuchElementException();
    }
}
