package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122;

import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.c0;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.p;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.s;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class f {
    private final bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a a;
    private final d b;

    /* renamed from: c  reason: collision with root package name */
    private final bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.e f381c;

    /* renamed from: d  reason: collision with root package name */
    private final p f382d;

    /* renamed from: f  reason: collision with root package name */
    private int f384f;

    /* renamed from: e  reason: collision with root package name */
    private List<Proxy> f383e = Collections.emptyList();

    /* renamed from: g  reason: collision with root package name */
    private List<InetSocketAddress> f385g = Collections.emptyList();

    /* renamed from: h  reason: collision with root package name */
    private final List<c0> f386h = new ArrayList();

    /* loaded from: classes.dex */
    public static final class a {
        private final List<c0> a;
        private int b = 0;

        public a(List<c0> list) {
            this.a = list;
        }

        public List<c0> a() {
            return new ArrayList(this.a);
        }

        public boolean b() {
            return this.b < this.a.size();
        }

        public c0 c() {
            if (b()) {
                List<c0> list = this.a;
                int i2 = this.b;
                this.b = i2 + 1;
                return list.get(i2);
            }
            throw new NoSuchElementException();
        }
    }

    public f(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a aVar, d dVar, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.e eVar, p pVar) throws IOException {
        this.a = aVar;
        this.b = dVar;
        this.f381c = eVar;
        this.f382d = pVar;
        a(aVar.k(), aVar.f());
    }

    public static String a(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        return address == null ? inetSocketAddress.getHostName() : address.getHostAddress();
    }

    private void a(s sVar, Proxy proxy) throws IOException {
        if (proxy != null) {
            this.f383e = Collections.singletonList(proxy);
        } else {
            try {
                List<Proxy> select = this.a.h().select(sVar.n());
                this.f383e = (select == null || select.isEmpty()) ? bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(Proxy.NO_PROXY) : bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(select);
            } catch (IllegalArgumentException unused) {
                throw new IOException();
            }
        }
        this.f384f = 0;
    }

    private void a(Proxy proxy) throws IOException {
        String g2;
        int j2;
        this.f385g = new ArrayList();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            g2 = this.a.k().g();
            j2 = this.a.k().j();
        } else {
            SocketAddress address = proxy.address();
            if (!(address instanceof InetSocketAddress)) {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + address.getClass());
            }
            InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
            g2 = a(inetSocketAddress);
            j2 = inetSocketAddress.getPort();
        }
        if (j2 < 1 || j2 > 65535) {
            throw new SocketException("No route to " + g2 + Constants.COLON_SEPARATOR + j2 + "; port is out of range");
        } else if (proxy.type() == Proxy.Type.SOCKS) {
            this.f385g.add(InetSocketAddress.createUnresolved(g2, j2));
        } else {
            this.f382d.a(this.f381c, g2);
            List<InetAddress> a2 = this.a.c().a(g2);
            if (a2.isEmpty()) {
                throw new UnknownHostException(this.a.c() + " returned no addresses for " + g2);
            }
            this.f382d.a(this.f381c, g2, a2);
            int size = a2.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f385g.add(new InetSocketAddress(a2.get(i2), j2));
            }
        }
    }

    private boolean c() {
        return this.f384f < this.f383e.size();
    }

    private Proxy d() throws IOException {
        if (c()) {
            List<Proxy> list = this.f383e;
            int i2 = this.f384f;
            this.f384f = i2 + 1;
            Proxy proxy = list.get(i2);
            a(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.a.k().g() + "; exhausted proxy configurations: " + this.f383e);
    }

    public void a(c0 c0Var, IOException iOException) {
        if (c0Var.b().type() != Proxy.Type.DIRECT && this.a.h() != null) {
            this.a.h().connectFailed(this.a.k().n(), c0Var.b().address(), iOException);
        }
        this.b.b(c0Var);
    }

    public boolean a() {
        return c() || !this.f386h.isEmpty();
    }

    public a b() throws IOException {
        if (a()) {
            ArrayList arrayList = new ArrayList();
            while (c()) {
                Proxy d2 = d();
                int size = this.f385g.size();
                for (int i2 = 0; i2 < size; i2++) {
                    c0 c0Var = new c0(this.a, d2, this.f385g.get(i2));
                    if (this.b.c(c0Var)) {
                        this.f386h.add(c0Var);
                    } else {
                        arrayList.add(c0Var);
                    }
                }
                if (!arrayList.isEmpty()) {
                    break;
                }
            }
            if (arrayList.isEmpty()) {
                arrayList.addAll(this.f386h);
                this.f386h.clear();
            }
            return new a(arrayList);
        }
        throw new NoSuchElementException();
    }
}
