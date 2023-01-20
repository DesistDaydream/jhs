package e.j.d.d;

import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes2.dex */
public class r<T> implements e.j.d.g.a<T> {

    /* renamed from: c  reason: collision with root package name */
    private static final Object f11222c = new Object();
    private volatile Object a;
    private volatile e.j.d.g.a<T> b;

    public r(T t) {
        this.a = f11222c;
        this.a = t;
    }

    @VisibleForTesting
    public boolean a() {
        return this.a != f11222c;
    }

    @Override // e.j.d.g.a
    public T get() {
        T t = (T) this.a;
        Object obj = f11222c;
        if (t == obj) {
            synchronized (this) {
                t = this.a;
                if (t == obj) {
                    t = this.b.get();
                    this.a = t;
                    this.b = null;
                }
            }
        }
        return t;
    }

    public r(e.j.d.g.a<T> aVar) {
        this.a = f11222c;
        this.b = aVar;
    }
}
