package e.k.b.a.o;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class c extends e.k.b.a.b {
    public final List<Runnable> a = new ArrayList();
    public final Object b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public boolean f11797c = false;

    @Override // e.k.b.a.b
    public final boolean a() {
        return this.f11797c;
    }

    @Override // e.k.b.a.b
    public final e.k.b.a.b b(Runnable runnable) {
        synchronized (this.b) {
            if (this.f11797c) {
                runnable.run();
            } else {
                this.a.add(runnable);
            }
        }
        return this;
    }
}
