package e.k.b.a;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* loaded from: classes2.dex */
public final class m {

    /* renamed from: d  reason: collision with root package name */
    private static final m f11791d = new m();
    private final ExecutorService b = e.k.b.a.o.a.a();
    private final Executor a = new a();

    /* renamed from: c  reason: collision with root package name */
    private final Executor f11792c = e.k.b.a.o.a.b();

    /* loaded from: classes2.dex */
    public static final class a implements Executor {
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            runnable.run();
        }
    }

    private m() {
    }

    public static ExecutorService a() {
        return f11791d.b;
    }

    public static Executor b() {
        return f11791d.a;
    }

    public static Executor c() {
        return f11791d.f11792c;
    }
}
