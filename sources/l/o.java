package l;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import l.e;
import l.h;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* loaded from: classes4.dex */
public class o {

    /* renamed from: c */
    private static final o f17064c = f();
    private final boolean a;
    @Nullable
    private final Constructor<MethodHandles.Lookup> b;

    /* loaded from: classes4.dex */
    public static final class a extends o {

        /* renamed from: l.o$a$a */
        /* loaded from: classes4.dex */
        public static final class ExecutorC0507a implements Executor {
            private final Handler a = new Handler(Looper.getMainLooper());

            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                this.a.post(runnable);
            }
        }

        public a() {
            super(Build.VERSION.SDK_INT >= 24);
        }

        @Override // l.o
        public Executor c() {
            return new ExecutorC0507a();
        }

        @Override // l.o
        @Nullable
        public Object h(Method method, Class<?> cls, Object obj, Object... objArr) throws Throwable {
            if (Build.VERSION.SDK_INT >= 26) {
                return super.h(method, cls, obj, objArr);
            }
            throw new UnsupportedOperationException("Calling default methods on API 24 and 25 is not supported");
        }
    }

    public o(boolean z) {
        this.a = z;
        Constructor<MethodHandles.Lookup> constructor = null;
        if (z) {
            try {
                constructor = MethodHandles.Lookup.class.getDeclaredConstructor(Class.class, Integer.TYPE);
                constructor.setAccessible(true);
            } catch (NoClassDefFoundError | NoSuchMethodException unused) {
            }
        }
        this.b = constructor;
    }

    private static o f() {
        if ("Dalvik".equals(System.getProperty("java.vm.name"))) {
            return new a();
        }
        return new o(true);
    }

    public static o g() {
        return f17064c;
    }

    public List<? extends e.a> a(@Nullable Executor executor) {
        i iVar = new i(executor);
        return this.a ? Arrays.asList(g.a, iVar) : Collections.singletonList(iVar);
    }

    public int b() {
        return this.a ? 2 : 1;
    }

    @Nullable
    public Executor c() {
        return null;
    }

    public List<? extends h.a> d() {
        return this.a ? Collections.singletonList(m.a) : Collections.emptyList();
    }

    public int e() {
        return this.a ? 1 : 0;
    }

    @Nullable
    @IgnoreJRERequirement
    public Object h(Method method, Class<?> cls, Object obj, Object... objArr) throws Throwable {
        Constructor<MethodHandles.Lookup> constructor = this.b;
        return (constructor != null ? constructor.newInstance(cls, -1) : MethodHandles.lookup()).unreflectSpecial(method, cls).bindTo(obj).invokeWithArguments(objArr);
    }

    @IgnoreJRERequirement
    public boolean i(Method method) {
        return this.a && method.isDefault();
    }
}
