package e.b.a.p.m;

import androidx.annotation.NonNull;
import e.b.a.p.k.s;
import e.b.a.v.l;

/* loaded from: classes.dex */
public class b<T> implements s<T> {
    public final T a;

    public b(@NonNull T t) {
        this.a = (T) l.d(t);
    }

    @Override // e.b.a.p.k.s
    @NonNull
    public Class<T> b() {
        return (Class<T>) this.a.getClass();
    }

    @Override // e.b.a.p.k.s
    @NonNull
    public final T get() {
        return this.a;
    }

    @Override // e.b.a.p.k.s
    public final int getSize() {
        return 1;
    }

    @Override // e.b.a.p.k.s
    public void recycle() {
    }
}
