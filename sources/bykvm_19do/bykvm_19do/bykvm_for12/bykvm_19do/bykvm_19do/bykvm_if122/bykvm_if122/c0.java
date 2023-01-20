package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Objects;

/* loaded from: classes.dex */
public final class c0 {
    public final a a;
    public final Proxy b;

    /* renamed from: c  reason: collision with root package name */
    public final InetSocketAddress f553c;

    public c0(a aVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        Objects.requireNonNull(aVar, "address == null");
        Objects.requireNonNull(proxy, "proxy == null");
        Objects.requireNonNull(inetSocketAddress, "inetSocketAddress == null");
        this.a = aVar;
        this.b = proxy;
        this.f553c = inetSocketAddress;
    }

    public a a() {
        return this.a;
    }

    public Proxy b() {
        return this.b;
    }

    public boolean c() {
        return this.a.f304i != null && this.b.type() == Proxy.Type.HTTP;
    }

    public InetSocketAddress d() {
        return this.f553c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof c0) {
            c0 c0Var = (c0) obj;
            if (c0Var.a.equals(this.a) && c0Var.b.equals(this.b) && c0Var.f553c.equals(this.f553c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((this.a.hashCode() + 527) * 31) + this.b.hashCode()) * 31) + this.f553c.hashCode();
    }

    public String toString() {
        return "Route{" + this.f553c + "}";
    }
}
