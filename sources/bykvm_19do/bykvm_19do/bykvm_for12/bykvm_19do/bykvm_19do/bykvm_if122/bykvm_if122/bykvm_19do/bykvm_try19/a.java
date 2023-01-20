package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19;

import android.net.ssl.SSLSockets;
import android.os.Build;
import android.util.Log;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1.f;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.w;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SNIHostName;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes.dex */
public class a extends e {

    /* renamed from: c  reason: collision with root package name */
    private final d<Socket> f527c;

    /* renamed from: d  reason: collision with root package name */
    private final d<Socket> f528d;

    /* renamed from: e  reason: collision with root package name */
    private final d<Socket> f529e;

    /* renamed from: f  reason: collision with root package name */
    private final d<Socket> f530f;

    /* renamed from: g  reason: collision with root package name */
    private final c f531g = c.a();

    /* renamed from: bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0023a extends bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1.c {
        private final Object a;
        private final Method b;

        public C0023a(Object obj, Method method) {
            this.a = obj;
            this.b = method;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1.c
        public List<Certificate> a(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
            try {
                return (List) this.b.invoke(this.a, (X509Certificate[]) list.toArray(new X509Certificate[list.size()]), "RSA", str);
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            } catch (InvocationTargetException e3) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e3.getMessage());
                sSLPeerUnverifiedException.initCause(e3);
                throw sSLPeerUnverifiedException;
            }
        }

        public boolean equals(Object obj) {
            return obj instanceof C0023a;
        }

        public int hashCode() {
            return 0;
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements f {
        private final X509TrustManager a;
        private final Method b;

        public b(X509TrustManager x509TrustManager, Method method) {
            this.b = method;
            this.a = x509TrustManager;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1.f
        public X509Certificate a(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.b.invoke(this.a, x509Certificate);
                if (trustAnchor != null) {
                    return trustAnchor.getTrustedCert();
                }
                return null;
            } catch (IllegalAccessException e2) {
                throw bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a("unable to get issues and signature", (Exception) e2);
            } catch (InvocationTargetException unused) {
                return null;
            }
        }

        public boolean equals(Object obj) {
            if (obj != this) {
                if (!(obj instanceof b)) {
                    return false;
                }
                b bVar = (b) obj;
                if (!this.a.equals(bVar.a) || !this.b.equals(bVar.b)) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            return this.a.hashCode() + (this.b.hashCode() * 31);
        }
    }

    /* loaded from: classes.dex */
    public static final class c {
        private final Method a;
        private final Method b;

        /* renamed from: c  reason: collision with root package name */
        private final Method f532c;

        public c(Method method, Method method2, Method method3) {
            this.a = method;
            this.b = method2;
            this.f532c = method3;
        }

        public static c a() {
            Method method;
            Method method2;
            Method method3 = null;
            try {
                Class<?> cls = Class.forName("dalvik.system.CloseGuard");
                Method method4 = cls.getMethod("get", new Class[0]);
                method2 = cls.getMethod("open", String.class);
                method = cls.getMethod("warnIfOpen", new Class[0]);
                method3 = method4;
            } catch (Exception unused) {
                method = null;
                method2 = null;
            }
            return new c(method3, method2, method);
        }

        public Object a(String str) {
            Method method = this.a;
            if (method != null) {
                try {
                    Object invoke = method.invoke(null, new Object[0]);
                    this.b.invoke(invoke, str);
                    return invoke;
                } catch (Exception unused) {
                    return null;
                }
            }
            return null;
        }

        public boolean a(Object obj) {
            if (obj != null) {
                try {
                    this.f532c.invoke(obj, new Object[0]);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
            return false;
        }
    }

    public a(Class<?> cls, d<Socket> dVar, d<Socket> dVar2, d<Socket> dVar3, d<Socket> dVar4) {
        this.f527c = dVar;
        this.f528d = dVar2;
        this.f529e = dVar3;
        this.f530f = dVar4;
    }

    public static e a() {
        Class<?> cls;
        d dVar;
        d dVar2;
        try {
            try {
                cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
            } catch (ClassNotFoundException unused) {
                cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
            }
            Class<?> cls2 = cls;
            d dVar3 = new d(null, "setUseSessionTickets", Boolean.TYPE);
            d dVar4 = new d(null, "setHostname", String.class);
            if (c()) {
                d dVar5 = new d(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
                dVar2 = new d(null, "setAlpnProtocols", byte[].class);
                dVar = dVar5;
            } else {
                dVar = null;
                dVar2 = null;
            }
            return new a(cls2, dVar3, dVar4, dVar, dVar2);
        } catch (ClassNotFoundException unused2) {
            return null;
        }
    }

    private boolean a(String str, Class<?> cls, Object obj) throws InvocationTargetException, IllegalAccessException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[0]).invoke(obj, new Object[0])).booleanValue();
        } catch (NoSuchMethodException unused) {
            return super.b(str);
        }
    }

    private boolean b(String str, Class<?> cls, Object obj) throws InvocationTargetException, IllegalAccessException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", String.class).invoke(obj, str)).booleanValue();
        } catch (NoSuchMethodException unused) {
            return a(str, cls, obj);
        }
    }

    private static boolean c() {
        if (Security.getProvider("GMSCore_OpenSSL") == null) {
            try {
                Class.forName("android.net.Network");
            } catch (ClassNotFoundException unused) {
                return false;
            }
        }
        return true;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.e
    public bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1.c a(X509TrustManager x509TrustManager) {
        try {
            Class<?> cls = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new C0023a(cls.getConstructor(X509TrustManager.class).newInstance(x509TrustManager), cls.getMethod("checkServerTrusted", X509Certificate[].class, String.class, String.class));
        } catch (Exception unused) {
            return super.a(x509TrustManager);
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.e
    public Object a(String str) {
        return this.f531g.a(str);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.e
    public void a(int i2, String str, Throwable th) {
        int min;
        int i3 = i2 != 5 ? 3 : 5;
        if (th != null) {
            str = str + '\n' + Log.getStackTraceString(th);
        }
        int i4 = 0;
        int length = str.length();
        while (i4 < length) {
            int indexOf = str.indexOf(10, i4);
            if (indexOf == -1) {
                indexOf = length;
            }
            while (true) {
                min = Math.min(indexOf, i4 + 4000);
                Log.println(i3, "OkHttp", str.substring(i4, min));
                if (min >= indexOf) {
                    break;
                }
                i4 = min;
            }
            i4 = min + 1;
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.e
    public void a(String str, Object obj) {
        if (this.f531g.a(obj)) {
            return;
        }
        a(5, str, (Throwable) null);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.e
    public void a(Socket socket, InetSocketAddress inetSocketAddress, int i2) throws IOException {
        try {
            socket.connect(inetSocketAddress, i2);
        } catch (AssertionError e2) {
            if (!bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(e2)) {
                throw e2;
            }
            throw new IOException(e2);
        } catch (ClassCastException e3) {
            if (Build.VERSION.SDK_INT != 26) {
                throw e3;
            }
            IOException iOException = new IOException("Exception in connect");
            iOException.initCause(e3);
            throw iOException;
        } catch (SecurityException e4) {
            IOException iOException2 = new IOException("Exception in connect");
            iOException2.initCause(e4);
            throw iOException2;
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.e
    public void a(SSLSocket sSLSocket, String str, List<w> list) {
        if (str != null) {
            if (Build.VERSION.SDK_INT >= 30) {
                try {
                    SSLSockets.setUseSessionTickets(sSLSocket, true);
                    SNIHostName sNIHostName = new SNIHostName(str);
                    SSLParameters sSLParameters = sSLSocket.getSSLParameters();
                    sSLParameters.setServerNames(Collections.singletonList(sNIHostName));
                    sSLSocket.setSSLParameters(sSLParameters);
                } catch (Exception unused) {
                }
            } else {
                this.f527c.c(sSLSocket, Boolean.TRUE);
                this.f528d.c(sSLSocket, str);
            }
        }
        d<Socket> dVar = this.f530f;
        if (dVar == null || !dVar.a((d<Socket>) sSLSocket)) {
            return;
        }
        this.f530f.d(sSLSocket, e.b(list));
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.e
    public f b(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            declaredMethod.setAccessible(true);
            return new b(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.b(x509TrustManager);
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.e
    public String b(SSLSocket sSLSocket) {
        byte[] bArr;
        d<Socket> dVar = this.f529e;
        if (dVar == null || !dVar.a((d<Socket>) sSLSocket) || (bArr = (byte[]) this.f529e.d(sSLSocket, new Object[0])) == null) {
            return null;
        }
        return new String(bArr, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.f548i);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.e
    public boolean b(String str) {
        try {
            Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
            return b(str, cls, cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return super.b(str);
        } catch (IllegalAccessException e2) {
            e = e2;
            throw bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a("unable to determine cleartext support", e);
        } catch (IllegalArgumentException e3) {
            e = e3;
            throw bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a("unable to determine cleartext support", e);
        } catch (InvocationTargetException e4) {
            e = e4;
            throw bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a("unable to determine cleartext support", e);
        }
    }
}
