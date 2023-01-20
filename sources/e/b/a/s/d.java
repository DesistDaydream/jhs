package e.b.a.s;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import e.b.a.v.k;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public class d {
    private final AtomicReference<k> a = new AtomicReference<>();
    private final ArrayMap<k, List<Class<?>>> b = new ArrayMap<>();

    public void a() {
        synchronized (this.b) {
            this.b.clear();
        }
    }

    @Nullable
    public List<Class<?>> b(@NonNull Class<?> cls, @NonNull Class<?> cls2, @NonNull Class<?> cls3) {
        List<Class<?>> list;
        k andSet = this.a.getAndSet(null);
        if (andSet == null) {
            andSet = new k(cls, cls2, cls3);
        } else {
            andSet.b(cls, cls2, cls3);
        }
        synchronized (this.b) {
            list = this.b.get(andSet);
        }
        this.a.set(andSet);
        return list;
    }

    public void c(@NonNull Class<?> cls, @NonNull Class<?> cls2, @NonNull Class<?> cls3, @NonNull List<Class<?>> list) {
        synchronized (this.b) {
            this.b.put(new k(cls, cls2, cls3), list);
        }
    }
}
