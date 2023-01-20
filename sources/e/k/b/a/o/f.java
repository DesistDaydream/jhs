package e.k.b.a.o;

import e.k.b.a.k;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class f<TResult> implements e.k.b.a.e<TResult> {
    private e.k.b.a.h a;
    private Executor b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f11803c = new Object();

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public final /* synthetic */ k a;

        public a(k kVar) {
            this.a = kVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            synchronized (f.this.f11803c) {
                if (f.this.a != null) {
                    f.this.a.onFailure(this.a.q());
                }
            }
        }
    }

    public f(Executor executor, e.k.b.a.h hVar) {
        this.a = hVar;
        this.b = executor;
    }

    @Override // e.k.b.a.e
    public final void cancel() {
        synchronized (this.f11803c) {
            this.a = null;
        }
    }

    @Override // e.k.b.a.e
    public final void onComplete(k<TResult> kVar) {
        if (kVar.v() || kVar.t()) {
            return;
        }
        this.b.execute(new a(kVar));
    }
}
