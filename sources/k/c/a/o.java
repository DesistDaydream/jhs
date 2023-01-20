package k.c.a;

import h.t2.y;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.greenrobot.eventbus.EventBusException;

/* loaded from: classes4.dex */
public class o {

    /* renamed from: d  reason: collision with root package name */
    private static final int f16283d = 64;

    /* renamed from: e  reason: collision with root package name */
    private static final int f16284e = 4096;

    /* renamed from: f  reason: collision with root package name */
    private static final int f16285f = 5192;

    /* renamed from: h  reason: collision with root package name */
    private static final int f16287h = 4;
    private List<k.c.a.r.d> a;
    private final boolean b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f16289c;

    /* renamed from: g  reason: collision with root package name */
    private static final Map<Class<?>, List<n>> f16286g = new ConcurrentHashMap();

    /* renamed from: i  reason: collision with root package name */
    private static final a[] f16288i = new a[4];

    /* loaded from: classes4.dex */
    public static class a {
        public final List<n> a = new ArrayList();
        public final Map<Class, Object> b = new HashMap();

        /* renamed from: c  reason: collision with root package name */
        public final Map<String, Class> f16290c = new HashMap();

        /* renamed from: d  reason: collision with root package name */
        public final StringBuilder f16291d = new StringBuilder(128);

        /* renamed from: e  reason: collision with root package name */
        public Class<?> f16292e;

        /* renamed from: f  reason: collision with root package name */
        public Class<?> f16293f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f16294g;

        /* renamed from: h  reason: collision with root package name */
        public k.c.a.r.c f16295h;

        private boolean b(Method method, Class<?> cls) {
            this.f16291d.setLength(0);
            this.f16291d.append(method.getName());
            StringBuilder sb = this.f16291d;
            sb.append(y.f15692e);
            sb.append(cls.getName());
            String sb2 = this.f16291d.toString();
            Class<?> declaringClass = method.getDeclaringClass();
            Class put = this.f16290c.put(sb2, declaringClass);
            if (put == null || put.isAssignableFrom(declaringClass)) {
                return true;
            }
            this.f16290c.put(sb2, put);
            return false;
        }

        public boolean a(Method method, Class<?> cls) {
            Object put = this.b.put(cls, method);
            if (put == null) {
                return true;
            }
            if (put instanceof Method) {
                if (b((Method) put, cls)) {
                    this.b.put(cls, this);
                } else {
                    throw new IllegalStateException();
                }
            }
            return b(method, cls);
        }

        public void c(Class<?> cls) {
            this.f16293f = cls;
            this.f16292e = cls;
            this.f16294g = false;
            this.f16295h = null;
        }

        public void d() {
            if (this.f16294g) {
                this.f16293f = null;
                return;
            }
            Class<? super Object> superclass = this.f16293f.getSuperclass();
            this.f16293f = superclass;
            String name = superclass.getName();
            if (name.startsWith("java.") || name.startsWith("javax.") || name.startsWith("android.") || name.startsWith("androidx.")) {
                this.f16293f = null;
            }
        }

        public void e() {
            this.a.clear();
            this.b.clear();
            this.f16290c.clear();
            this.f16291d.setLength(0);
            this.f16292e = null;
            this.f16293f = null;
            this.f16294g = false;
            this.f16295h = null;
        }
    }

    public o(List<k.c.a.r.d> list, boolean z, boolean z2) {
        this.a = list;
        this.b = z;
        this.f16289c = z2;
    }

    public static void a() {
        f16286g.clear();
    }

    private List<n> c(Class<?> cls) {
        n[] a2;
        a h2 = h();
        h2.c(cls);
        while (h2.f16293f != null) {
            k.c.a.r.c g2 = g(h2);
            h2.f16295h = g2;
            if (g2 != null) {
                for (n nVar : g2.a()) {
                    if (h2.a(nVar.a, nVar.f16279c)) {
                        h2.a.add(nVar);
                    }
                }
            } else {
                e(h2);
            }
            h2.d();
        }
        return f(h2);
    }

    private List<n> d(Class<?> cls) {
        a h2 = h();
        h2.c(cls);
        while (h2.f16293f != null) {
            e(h2);
            h2.d();
        }
        return f(h2);
    }

    private void e(a aVar) {
        Method[] methods;
        try {
            try {
                methods = aVar.f16293f.getDeclaredMethods();
            } catch (Throwable unused) {
                methods = aVar.f16293f.getMethods();
                aVar.f16294g = true;
            }
            for (Method method : methods) {
                int modifiers = method.getModifiers();
                if ((modifiers & 1) != 0 && (modifiers & f16285f) == 0) {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    if (parameterTypes.length == 1) {
                        l lVar = (l) method.getAnnotation(l.class);
                        if (lVar != null) {
                            Class<?> cls = parameterTypes[0];
                            if (aVar.a(method, cls)) {
                                aVar.a.add(new n(method, cls, lVar.threadMode(), lVar.priority(), lVar.sticky()));
                            }
                        }
                    } else if (this.b && method.isAnnotationPresent(l.class)) {
                        throw new EventBusException("@Subscribe method " + (method.getDeclaringClass().getName() + "." + method.getName()) + "must have exactly 1 parameter but has " + parameterTypes.length);
                    }
                } else if (this.b && method.isAnnotationPresent(l.class)) {
                    throw new EventBusException((method.getDeclaringClass().getName() + "." + method.getName()) + " is a illegal @Subscribe method: must be public, non-static, and non-abstract");
                }
            }
        } catch (LinkageError e2) {
            String str = "Could not inspect methods of " + aVar.f16293f.getName();
            throw new EventBusException(this.f16289c ? str + ". Please consider using EventBus annotation processor to avoid reflection." : str + ". Please make this class visible to EventBus annotation processor to avoid reflection.", e2);
        }
    }

    private List<n> f(a aVar) {
        ArrayList arrayList = new ArrayList(aVar.a);
        aVar.e();
        synchronized (f16288i) {
            int i2 = 0;
            while (true) {
                if (i2 >= 4) {
                    break;
                }
                a[] aVarArr = f16288i;
                if (aVarArr[i2] == null) {
                    aVarArr[i2] = aVar;
                    break;
                }
                i2++;
            }
        }
        return arrayList;
    }

    private k.c.a.r.c g(a aVar) {
        k.c.a.r.c cVar = aVar.f16295h;
        if (cVar != null && cVar.c() != null) {
            k.c.a.r.c c2 = aVar.f16295h.c();
            if (aVar.f16293f == c2.b()) {
                return c2;
            }
        }
        List<k.c.a.r.d> list = this.a;
        if (list != null) {
            for (k.c.a.r.d dVar : list) {
                k.c.a.r.c a2 = dVar.a(aVar.f16293f);
                if (a2 != null) {
                    return a2;
                }
            }
            return null;
        }
        return null;
    }

    private a h() {
        synchronized (f16288i) {
            for (int i2 = 0; i2 < 4; i2++) {
                a[] aVarArr = f16288i;
                a aVar = aVarArr[i2];
                if (aVar != null) {
                    aVarArr[i2] = null;
                    return aVar;
                }
            }
            return new a();
        }
    }

    public List<n> b(Class<?> cls) {
        List<n> c2;
        Map<Class<?>, List<n>> map = f16286g;
        List<n> list = map.get(cls);
        if (list != null) {
            return list;
        }
        if (this.f16289c) {
            c2 = d(cls);
        } else {
            c2 = c(cls);
        }
        if (!c2.isEmpty()) {
            map.put(cls, c2);
            return c2;
        }
        throw new EventBusException("Subscriber " + cls + " and its super classes have no public methods with the @Subscribe annotation");
    }
}
