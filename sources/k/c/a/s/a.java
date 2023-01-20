package k.c.a.s;

import java.lang.reflect.Constructor;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.logging.Level;

/* loaded from: classes4.dex */
public class a {
    private final Executor a;
    private final Constructor<?> b;

    /* renamed from: c  reason: collision with root package name */
    private final k.c.a.c f16302c;

    /* renamed from: d  reason: collision with root package name */
    private final Object f16303d;

    /* renamed from: k.c.a.s.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC0490a implements Runnable {
        public final /* synthetic */ c a;

        public RunnableC0490a(c cVar) {
            this.a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.a.run();
            } catch (Exception e2) {
                try {
                    Object newInstance = a.this.b.newInstance(e2);
                    if (newInstance instanceof g) {
                        ((g) newInstance).b(a.this.f16303d);
                    }
                    a.this.f16302c.q(newInstance);
                } catch (Exception e3) {
                    a.this.f16302c.h().a(Level.SEVERE, "Original exception:", e2);
                    throw new RuntimeException("Could not create failure event", e3);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b {
        private Executor a;
        private Class<?> b;

        /* renamed from: c  reason: collision with root package name */
        private k.c.a.c f16304c;

        public /* synthetic */ b(RunnableC0490a runnableC0490a) {
            this();
        }

        public a a() {
            return b(null);
        }

        public a b(Object obj) {
            if (this.f16304c == null) {
                this.f16304c = k.c.a.c.f();
            }
            if (this.a == null) {
                this.a = Executors.newCachedThreadPool();
            }
            if (this.b == null) {
                this.b = h.class;
            }
            return new a(this.a, this.f16304c, this.b, obj, null);
        }

        public b c(k.c.a.c cVar) {
            this.f16304c = cVar;
            return this;
        }

        public b d(Class<?> cls) {
            this.b = cls;
            return this;
        }

        public b e(Executor executor) {
            this.a = executor;
            return this;
        }

        private b() {
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void run() throws Exception;
    }

    public /* synthetic */ a(Executor executor, k.c.a.c cVar, Class cls, Object obj, RunnableC0490a runnableC0490a) {
        this(executor, cVar, cls, obj);
    }

    public static b d() {
        return new b(null);
    }

    public static a e() {
        return new b(null).a();
    }

    public void f(c cVar) {
        this.a.execute(new RunnableC0490a(cVar));
    }

    private a(Executor executor, k.c.a.c cVar, Class<?> cls, Object obj) {
        this.a = executor;
        this.f16302c = cVar;
        this.f16303d = obj;
        try {
            this.b = cls.getConstructor(Throwable.class);
        } catch (NoSuchMethodException e2) {
            throw new RuntimeException("Failure event class must have a constructor with one parameter of type Throwable", e2);
        }
    }
}
