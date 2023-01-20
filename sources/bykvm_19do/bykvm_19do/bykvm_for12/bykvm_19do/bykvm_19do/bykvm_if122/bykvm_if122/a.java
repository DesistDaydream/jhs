package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.s;
import com.xiaomi.mipush.sdk.Constants;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes.dex */
public final class a {
    public final s a;
    public final o b;

    /* renamed from: c  reason: collision with root package name */
    public final SocketFactory f298c;

    /* renamed from: d  reason: collision with root package name */
    public final b f299d;

    /* renamed from: e  reason: collision with root package name */
    public final List<w> f300e;

    /* renamed from: f  reason: collision with root package name */
    public final List<k> f301f;

    /* renamed from: g  reason: collision with root package name */
    public final ProxySelector f302g;

    /* renamed from: h  reason: collision with root package name */
    public final Proxy f303h;

    /* renamed from: i  reason: collision with root package name */
    public final SSLSocketFactory f304i;

    /* renamed from: j  reason: collision with root package name */
    public final HostnameVerifier f305j;

    /* renamed from: k  reason: collision with root package name */
    public final g f306k;

    public a(String str, int i2, o oVar, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, g gVar, b bVar, Proxy proxy, List<w> list, List<k> list2, ProxySelector proxySelector) {
        this.a = new s.a().e(sSLSocketFactory != null ? "https" : "http").c(str).a(i2).a();
        Objects.requireNonNull(oVar, "dns == null");
        this.b = oVar;
        Objects.requireNonNull(socketFactory, "socketFactory == null");
        this.f298c = socketFactory;
        Objects.requireNonNull(bVar, "proxyAuthenticator == null");
        this.f299d = bVar;
        Objects.requireNonNull(list, "protocols == null");
        this.f300e = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(list);
        Objects.requireNonNull(list2, "connectionSpecs == null");
        this.f301f = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(list2);
        Objects.requireNonNull(proxySelector, "proxySelector == null");
        this.f302g = proxySelector;
        this.f303h = proxy;
        this.f304i = sSLSocketFactory;
        this.f305j = hostnameVerifier;
        this.f306k = gVar;
    }

    public g a() {
        return this.f306k;
    }

    public boolean a(a aVar) {
        return this.b.equals(aVar.b) && this.f299d.equals(aVar.f299d) && this.f300e.equals(aVar.f300e) && this.f301f.equals(aVar.f301f) && this.f302g.equals(aVar.f302g) && bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(this.f303h, aVar.f303h) && bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(this.f304i, aVar.f304i) && bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(this.f305j, aVar.f305j) && bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(this.f306k, aVar.f306k) && k().j() == aVar.k().j();
    }

    public List<k> b() {
        return this.f301f;
    }

    public o c() {
        return this.b;
    }

    public HostnameVerifier d() {
        return this.f305j;
    }

    public List<w> e() {
        return this.f300e;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.a.equals(aVar.a) && a(aVar)) {
                return true;
            }
        }
        return false;
    }

    public Proxy f() {
        return this.f303h;
    }

    public b g() {
        return this.f299d;
    }

    public ProxySelector h() {
        return this.f302g;
    }

    public int hashCode() {
        int hashCode = this.a.hashCode();
        int hashCode2 = this.b.hashCode();
        int hashCode3 = this.f299d.hashCode();
        int hashCode4 = this.f300e.hashCode();
        int hashCode5 = this.f301f.hashCode();
        int hashCode6 = this.f302g.hashCode();
        Proxy proxy = this.f303h;
        int hashCode7 = proxy != null ? proxy.hashCode() : 0;
        SSLSocketFactory sSLSocketFactory = this.f304i;
        int hashCode8 = sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0;
        HostnameVerifier hostnameVerifier = this.f305j;
        int hashCode9 = hostnameVerifier != null ? hostnameVerifier.hashCode() : 0;
        g gVar = this.f306k;
        return ((hashCode9 + ((hashCode8 + ((hashCode7 + ((((((((((((hashCode + 527) * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31)) * 31)) * 31)) * 31) + (gVar != null ? gVar.hashCode() : 0);
    }

    public SocketFactory i() {
        return this.f298c;
    }

    public SSLSocketFactory j() {
        return this.f304i;
    }

    public s k() {
        return this.a;
    }

    public String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder();
        sb.append("Address{");
        sb.append(this.a.g());
        sb.append(Constants.COLON_SEPARATOR);
        sb.append(this.a.j());
        if (this.f303h != null) {
            sb.append(", proxy=");
            obj = this.f303h;
        } else {
            sb.append(", proxySelector=");
            obj = this.f302g;
        }
        sb.append(obj);
        sb.append("}");
        return sb.toString();
    }
}
