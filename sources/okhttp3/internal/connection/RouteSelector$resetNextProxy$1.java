package okhttp3.internal.connection;

import h.a2.t;
import h.k2.u.a;
import java.net.Proxy;
import java.net.URI;
import java.util.List;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import okhttp3.Address;
import okhttp3.HttpUrl;
import okhttp3.internal.Util;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "Ljava/net/Proxy;", "invoke", "()Ljava/util/List;", "selectProxies"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class RouteSelector$resetNextProxy$1 extends Lambda implements a<List<? extends Proxy>> {
    public final /* synthetic */ Proxy $proxy;
    public final /* synthetic */ HttpUrl $url;
    public final /* synthetic */ RouteSelector this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RouteSelector$resetNextProxy$1(RouteSelector routeSelector, Proxy proxy, HttpUrl httpUrl) {
        super(0);
        this.this$0 = routeSelector;
        this.$proxy = proxy;
        this.$url = httpUrl;
    }

    @Override // h.k2.u.a
    @d
    public final List<? extends Proxy> invoke() {
        Address address;
        Proxy proxy = this.$proxy;
        if (proxy != null) {
            return t.k(proxy);
        }
        URI uri = this.$url.uri();
        if (uri.getHost() == null) {
            return Util.immutableListOf(Proxy.NO_PROXY);
        }
        address = this.this$0.address;
        List<Proxy> select = address.proxySelector().select(uri);
        return select == null || select.isEmpty() ? Util.immutableListOf(Proxy.NO_PROXY) : Util.toImmutableList(select);
    }
}
