package e.j.a.b.f.c;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class o extends WeakReference<Throwable> {
    private final int a;

    public o(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        Objects.requireNonNull(th, "The referent cannot be null");
        this.a = System.identityHashCode(th);
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == o.class) {
            if (this == obj) {
                return true;
            }
            o oVar = (o) obj;
            if (this.a == oVar.a && get() == oVar.get()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.a;
    }
}
