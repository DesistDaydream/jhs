package e.k.b.a.o;

import e.k.b.a.k;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class h<TResult> implements e.k.b.a.e<TResult> {
    private e.k.b.a.i<TResult> a;
    private Executor b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f11804c = new Object();

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public final /* synthetic */ k a;

        public a(k kVar) {
            this.a = kVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() {
            synchronized (h.this.f11804c) {
                if (h.this.a != null) {
                    h.this.a.onSuccess(this.a.r());
                }
            }
        }
    }

    public h(Executor executor, e.k.b.a.i<TResult> iVar) {
        this.a = iVar;
        this.b = executor;
    }

    @Override // e.k.b.a.e
    public final void cancel() {
        synchronized (this.f11804c) {
            this.a = null;
        }
    }

    @Override // e.k.b.a.e
    public final void onComplete(k<TResult> kVar) {
        if (!kVar.v() || kVar.t()) {
            return;
        }
        this.b.execute(new a(kVar));
    }
}
