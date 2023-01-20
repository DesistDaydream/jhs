package e.k.b.a.o;

import e.k.b.a.k;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class b<TResult> implements e.k.b.a.e<TResult> {
    private e.k.b.a.f a;
    private Executor b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f11796c = new Object();

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            synchronized (b.this.f11796c) {
                if (b.this.a != null) {
                    b.this.a.a();
                }
            }
        }
    }

    public b(Executor executor, e.k.b.a.f fVar) {
        this.a = fVar;
        this.b = executor;
    }

    @Override // e.k.b.a.e
    public final void cancel() {
        synchronized (this.f11796c) {
            this.a = null;
        }
    }

    @Override // e.k.b.a.e
    public final void onComplete(k<TResult> kVar) {
        if (kVar.t()) {
            this.b.execute(new a());
        }
    }
}
