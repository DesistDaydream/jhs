package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19;

import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.w;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* loaded from: classes.dex */
public class c extends e {

    /* renamed from: c  reason: collision with root package name */
    private final Method f535c;

    /* renamed from: d  reason: collision with root package name */
    private final Method f536d;

    /* renamed from: e  reason: collision with root package name */
    private final Method f537e;

    /* renamed from: f  reason: collision with root package name */
    private final Class<?> f538f;

    /* renamed from: g  reason: collision with root package name */
    private final Class<?> f539g;

    /* loaded from: classes.dex */
    public static class a implements InvocationHandler {
        private final List<String> a;
        public boolean b;

        /* renamed from: c  reason: collision with root package name */
        public String f540c;

        public a(List<String> list) {
            this.a = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            Object obj2;
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.b;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return Boolean.TRUE;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.b = true;
                return null;
            } else if (name.equals("protocols") && objArr.length == 0) {
                return this.a;
            } else {
                if ((!name.equals("selectProtocol") && !name.equals("select")) || String.class != returnType || objArr.length != 1 || !(objArr[0] instanceof List)) {
                    if ((name.equals("protocolSelected") || name.equals("selected")) && objArr.length == 1) {
                        this.f540c = (String) objArr[0];
                        return null;
                    }
                    return method.invoke(this, objArr);
                }
                List list = (List) objArr[0];
                int size = list.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        obj2 = this.a.get(0);
                        break;
                    } else if (this.a.contains(list.get(i2))) {
                        obj2 = list.get(i2);
                        break;
                    } else {
                        i2++;
                    }
                }
                String str = (String) obj2;
                this.f540c = str;
                return str;
            }
        }
    }

    public c(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        this.f535c = method;
        this.f536d = method2;
        this.f537e = method3;
        this.f538f = cls;
        this.f539g = cls2;
    }

    public static e a() {
        try {
            Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN");
            Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider");
            Class<?> cls3 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider");
            return new c(cls.getMethod("put", SSLSocket.class, cls2), cls.getMethod("get", SSLSocket.class), cls.getMethod("remove", SSLSocket.class), cls3, Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider"));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return null;
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.e
    public void a(SSLSocket sSLSocket) {
        try {
            this.f537e.invoke(null, sSLSocket);
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a("unable to remove alpn", (Exception) e2);
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.e
    public void a(SSLSocket sSLSocket, String str, List<w> list) {
        List<String> a2 = e.a(list);
        try {
            this.f535c.invoke(null, sSLSocket, Proxy.newProxyInstance(e.class.getClassLoader(), new Class[]{this.f538f, this.f539g}, new a(a2)));
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a("unable to set alpn", (Exception) e2);
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.e
    public String b(SSLSocket sSLSocket) {
        try {
            a aVar = (a) Proxy.getInvocationHandler(this.f536d.invoke(null, sSLSocket));
            boolean z = aVar.b;
            if (!z && aVar.f540c == null) {
                e.b().a(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", (Throwable) null);
                return null;
            } else if (z) {
                return null;
            } else {
                return aVar.f540c;
            }
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a("unable to get selected protocol", (Exception) e2);
        }
    }
}
