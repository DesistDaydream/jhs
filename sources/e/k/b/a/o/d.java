package e.k.b.a.o;

import e.k.b.a.k;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class d<TResult> implements e.k.b.a.e<TResult> {
    private e.k.b.a.g<TResult> a;
    public Executor b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f11798c = new Object();

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public final /* synthetic */ k a;

        public a(k kVar) {
            this.a = kVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            synchronized (d.this.f11798c) {
                if (d.this.a != null) {
                    d.this.a.onComplete(this.a);
                }
            }
        }
    }

    public d(Executor executor, e.k.b.a.g<TResult> gVar) {
        this.a = gVar;
        this.b = executor;
    }

    @Override // e.k.b.a.e
    public final void cancel() {
        synchronized (this.f11798c) {
            this.a = null;
        }
    }

    @Override // e.k.b.a.e
    public final void onComplete(k<TResult> kVar) {
        this.b.execute(new a(kVar));
    }
}
