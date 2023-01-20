package k.c.a;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;
import org.greenrobot.eventbus.EventBusException;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes4.dex */
public class c {
    public static String s = "EventBus";
    public static volatile c t;
    private static final k.c.a.d u = new k.c.a.d();
    private static final Map<Class<?>, List<Class<?>>> v = new HashMap();
    private final Map<Class<?>, CopyOnWriteArrayList<p>> a;
    private final Map<Object, List<Class<?>>> b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<Class<?>, Object> f16247c;

    /* renamed from: d  reason: collision with root package name */
    private final ThreadLocal<d> f16248d;

    /* renamed from: e  reason: collision with root package name */
    private final g f16249e;

    /* renamed from: f  reason: collision with root package name */
    private final k f16250f;

    /* renamed from: g  reason: collision with root package name */
    private final k.c.a.b f16251g;

    /* renamed from: h  reason: collision with root package name */
    private final k.c.a.a f16252h;

    /* renamed from: i  reason: collision with root package name */
    private final o f16253i;

    /* renamed from: j  reason: collision with root package name */
    private final ExecutorService f16254j;

    /* renamed from: k  reason: collision with root package name */
    private final boolean f16255k;

    /* renamed from: l  reason: collision with root package name */
    private final boolean f16256l;

    /* renamed from: m  reason: collision with root package name */
    private final boolean f16257m;
    private final boolean n;
    private final boolean o;
    private final boolean p;
    private final int q;
    private final f r;

    /* loaded from: classes4.dex */
    public class a extends ThreadLocal<d> {
        public a() {
        }

        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public d initialValue() {
            return new d();
        }
    }

    /* loaded from: classes4.dex */
    public static /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ThreadMode.values().length];
            a = iArr;
            try {
                iArr[ThreadMode.POSTING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ThreadMode.MAIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ThreadMode.MAIN_ORDERED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ThreadMode.BACKGROUND.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[ThreadMode.ASYNC.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* renamed from: k.c.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0489c {
        void a(List<m> list);
    }

    /* loaded from: classes4.dex */
    public static final class d {
        public final List<Object> a = new ArrayList();
        public boolean b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f16258c;

        /* renamed from: d  reason: collision with root package name */
        public p f16259d;

        /* renamed from: e  reason: collision with root package name */
        public Object f16260e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f16261f;
    }

    public c() {
        this(u);
    }

    private void B(Object obj, Class<?> cls) {
        CopyOnWriteArrayList<p> copyOnWriteArrayList = this.a.get(cls);
        if (copyOnWriteArrayList != null) {
            int size = copyOnWriteArrayList.size();
            int i2 = 0;
            while (i2 < size) {
                p pVar = copyOnWriteArrayList.get(i2);
                if (pVar.a == obj) {
                    pVar.f16296c = false;
                    copyOnWriteArrayList.remove(i2);
                    i2--;
                    size--;
                }
                i2++;
            }
        }
    }

    public static void a(List<Class<?>> list, Class<?>[] clsArr) {
        for (Class<?> cls : clsArr) {
            if (!list.contains(cls)) {
                list.add(cls);
                a(list, cls.getInterfaces());
            }
        }
    }

    public static k.c.a.d b() {
        return new k.c.a.d();
    }

    private void d(p pVar, Object obj) {
        if (obj != null) {
            u(pVar, obj, n());
        }
    }

    public static void e() {
        o.a();
        v.clear();
    }

    public static c f() {
        c cVar = t;
        if (cVar == null) {
            synchronized (c.class) {
                cVar = t;
                if (cVar == null) {
                    cVar = new c();
                    t = cVar;
                }
            }
        }
        return cVar;
    }

    private void j(p pVar, Object obj, Throwable th) {
        if (obj instanceof m) {
            if (this.f16256l) {
                f fVar = this.r;
                Level level = Level.SEVERE;
                fVar.a(level, "SubscriberExceptionEvent subscriber " + pVar.a.getClass() + " threw an exception", th);
                m mVar = (m) obj;
                f fVar2 = this.r;
                fVar2.a(level, "Initial event " + mVar.f16277c + " caused exception in " + mVar.f16278d, mVar.b);
            }
        } else if (!this.f16255k) {
            if (this.f16256l) {
                f fVar3 = this.r;
                Level level2 = Level.SEVERE;
                fVar3.a(level2, "Could not dispatch event: " + obj.getClass() + " to subscribing class " + pVar.a.getClass(), th);
            }
            if (this.n) {
                q(new m(this, th, obj, pVar.a));
            }
        } else {
            throw new EventBusException("Invoking subscriber failed", th);
        }
    }

    private boolean n() {
        g gVar = this.f16249e;
        return gVar == null || gVar.b();
    }

    private static List<Class<?>> p(Class<?> cls) {
        List<Class<?>> list;
        Map<Class<?>, List<Class<?>>> map = v;
        synchronized (map) {
            list = map.get(cls);
            if (list == null) {
                list = new ArrayList<>();
                for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
                    list.add(cls2);
                    a(list, cls2.getInterfaces());
                }
                v.put(cls, list);
            }
        }
        return list;
    }

    private void r(Object obj, d dVar) throws Error {
        boolean s2;
        Class<?> cls = obj.getClass();
        if (this.p) {
            List<Class<?>> p = p(cls);
            int size = p.size();
            s2 = false;
            for (int i2 = 0; i2 < size; i2++) {
                s2 |= s(obj, dVar, p.get(i2));
            }
        } else {
            s2 = s(obj, dVar, cls);
        }
        if (s2) {
            return;
        }
        if (this.f16257m) {
            f fVar = this.r;
            Level level = Level.FINE;
            fVar.b(level, "No subscribers registered for event " + cls);
        }
        if (!this.o || cls == h.class || cls == m.class) {
            return;
        }
        q(new h(this, obj));
    }

    private boolean s(Object obj, d dVar, Class<?> cls) {
        CopyOnWriteArrayList<p> copyOnWriteArrayList;
        synchronized (this) {
            copyOnWriteArrayList = this.a.get(cls);
        }
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        Iterator<p> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            p next = it.next();
            dVar.f16260e = obj;
            dVar.f16259d = next;
            try {
                u(next, obj, dVar.f16258c);
                if (dVar.f16261f) {
                    return true;
                }
            } finally {
                dVar.f16260e = null;
                dVar.f16259d = null;
                dVar.f16261f = false;
            }
        }
        return true;
    }

    private void u(p pVar, Object obj, boolean z) {
        int i2 = b.a[pVar.b.b.ordinal()];
        if (i2 == 1) {
            m(pVar, obj);
        } else if (i2 == 2) {
            if (z) {
                m(pVar, obj);
            } else {
                this.f16250f.a(pVar, obj);
            }
        } else if (i2 == 3) {
            k kVar = this.f16250f;
            if (kVar != null) {
                kVar.a(pVar, obj);
            } else {
                m(pVar, obj);
            }
        } else if (i2 == 4) {
            if (z) {
                this.f16251g.a(pVar, obj);
            } else {
                m(pVar, obj);
            }
        } else if (i2 == 5) {
            this.f16252h.a(pVar, obj);
        } else {
            throw new IllegalStateException("Unknown thread mode: " + pVar.b.b);
        }
    }

    private void z(Object obj, n nVar) {
        Class<?> cls = nVar.f16279c;
        p pVar = new p(obj, nVar);
        CopyOnWriteArrayList<p> copyOnWriteArrayList = this.a.get(cls);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            this.a.put(cls, copyOnWriteArrayList);
        } else if (copyOnWriteArrayList.contains(pVar)) {
            throw new EventBusException("Subscriber " + obj.getClass() + " already registered to event " + cls);
        }
        int size = copyOnWriteArrayList.size();
        for (int i2 = 0; i2 <= size; i2++) {
            if (i2 == size || nVar.f16280d > copyOnWriteArrayList.get(i2).b.f16280d) {
                copyOnWriteArrayList.add(i2, pVar);
                break;
            }
        }
        List<Class<?>> list = this.b.get(obj);
        if (list == null) {
            list = new ArrayList<>();
            this.b.put(obj, list);
        }
        list.add(cls);
        if (nVar.f16281e) {
            if (this.p) {
                for (Map.Entry<Class<?>, Object> entry : this.f16247c.entrySet()) {
                    if (cls.isAssignableFrom(entry.getKey())) {
                        d(pVar, entry.getValue());
                    }
                }
                return;
            }
            d(pVar, this.f16247c.get(cls));
        }
    }

    public synchronized void A(Object obj) {
        List<Class<?>> list = this.b.get(obj);
        if (list != null) {
            for (Class<?> cls : list) {
                B(obj, cls);
            }
            this.b.remove(obj);
        } else {
            f fVar = this.r;
            Level level = Level.WARNING;
            fVar.b(level, "Subscriber to unregister was not registered before: " + obj.getClass());
        }
    }

    public void c(Object obj) {
        d dVar = this.f16248d.get();
        if (!dVar.b) {
            throw new EventBusException("This method may only be called from inside event handling methods on the posting thread");
        }
        if (obj != null) {
            if (dVar.f16260e == obj) {
                if (dVar.f16259d.b.b == ThreadMode.POSTING) {
                    dVar.f16261f = true;
                    return;
                }
                throw new EventBusException(" event handlers may only abort the incoming event");
            }
            throw new EventBusException("Only the currently handled event may be aborted");
        }
        throw new EventBusException("Event may not be null");
    }

    public ExecutorService g() {
        return this.f16254j;
    }

    public f h() {
        return this.r;
    }

    public <T> T i(Class<T> cls) {
        T cast;
        synchronized (this.f16247c) {
            cast = cls.cast(this.f16247c.get(cls));
        }
        return cast;
    }

    public boolean k(Class<?> cls) {
        CopyOnWriteArrayList<p> copyOnWriteArrayList;
        List<Class<?>> p = p(cls);
        if (p != null) {
            int size = p.size();
            for (int i2 = 0; i2 < size; i2++) {
                Class<?> cls2 = p.get(i2);
                synchronized (this) {
                    copyOnWriteArrayList = this.a.get(cls2);
                }
                if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void l(i iVar) {
        Object obj = iVar.a;
        p pVar = iVar.b;
        i.b(iVar);
        if (pVar.f16296c) {
            m(pVar, obj);
        }
    }

    public void m(p pVar, Object obj) {
        try {
            pVar.b.a.invoke(pVar.a, obj);
        } catch (IllegalAccessException e2) {
            throw new IllegalStateException("Unexpected exception", e2);
        } catch (InvocationTargetException e3) {
            j(pVar, obj, e3.getCause());
        }
    }

    public synchronized boolean o(Object obj) {
        return this.b.containsKey(obj);
    }

    public void q(Object obj) {
        d dVar = this.f16248d.get();
        List<Object> list = dVar.a;
        list.add(obj);
        if (dVar.b) {
            return;
        }
        dVar.f16258c = n();
        dVar.b = true;
        if (dVar.f16261f) {
            throw new EventBusException("Internal error. Abort state was not reset");
        }
        while (true) {
            try {
                if (list.isEmpty()) {
                    return;
                }
                r(list.remove(0), dVar);
            } finally {
                dVar.b = false;
                dVar.f16258c = false;
            }
        }
    }

    public void t(Object obj) {
        synchronized (this.f16247c) {
            this.f16247c.put(obj.getClass(), obj);
        }
        q(obj);
    }

    public String toString() {
        return "EventBus[indexCount=" + this.q + ", eventInheritance=" + this.p + "]";
    }

    public void v(Object obj) {
        List<n> b2 = this.f16253i.b(obj.getClass());
        synchronized (this) {
            for (n nVar : b2) {
                z(obj, nVar);
            }
        }
    }

    public void w() {
        synchronized (this.f16247c) {
            this.f16247c.clear();
        }
    }

    public <T> T x(Class<T> cls) {
        T cast;
        synchronized (this.f16247c) {
            cast = cls.cast(this.f16247c.remove(cls));
        }
        return cast;
    }

    public boolean y(Object obj) {
        synchronized (this.f16247c) {
            Class<?> cls = obj.getClass();
            if (obj.equals(this.f16247c.get(cls))) {
                this.f16247c.remove(cls);
                return true;
            }
            return false;
        }
    }

    public c(k.c.a.d dVar) {
        this.f16248d = new a();
        this.r = dVar.f();
        this.a = new HashMap();
        this.b = new HashMap();
        this.f16247c = new ConcurrentHashMap();
        g g2 = dVar.g();
        this.f16249e = g2;
        this.f16250f = g2 != null ? g2.a(this) : null;
        this.f16251g = new k.c.a.b(this);
        this.f16252h = new k.c.a.a(this);
        List<k.c.a.r.d> list = dVar.f16270k;
        this.q = list != null ? list.size() : 0;
        this.f16253i = new o(dVar.f16270k, dVar.f16267h, dVar.f16266g);
        this.f16256l = dVar.a;
        this.f16257m = dVar.b;
        this.n = dVar.f16262c;
        this.o = dVar.f16263d;
        this.f16255k = dVar.f16264e;
        this.p = dVar.f16265f;
        this.f16254j = dVar.f16268i;
    }
}
