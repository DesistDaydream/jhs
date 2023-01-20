package e.b.a.v;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class i<T, Y> {
    private final Map<T, a<Y>> a = new LinkedHashMap(100, 0.75f, true);
    private final long b;

    /* renamed from: c  reason: collision with root package name */
    private long f9948c;

    /* renamed from: d  reason: collision with root package name */
    private long f9949d;

    /* loaded from: classes.dex */
    public static final class a<Y> {
        public final Y a;
        public final int b;

        public a(Y y, int i2) {
            this.a = y;
            this.b = i2;
        }
    }

    public i(long j2) {
        this.b = j2;
        this.f9948c = j2;
    }

    private void i() {
        p(this.f9948c);
    }

    public void b() {
        p(0L);
    }

    public synchronized void c(float f2) {
        if (f2 >= 0.0f) {
            this.f9948c = Math.round(((float) this.b) * f2);
            i();
        } else {
            throw new IllegalArgumentException("Multiplier must be >= 0");
        }
    }

    public synchronized long e() {
        return this.f9948c;
    }

    public synchronized long getCurrentSize() {
        return this.f9949d;
    }

    public synchronized boolean h(@NonNull T t) {
        return this.a.containsKey(t);
    }

    @Nullable
    public synchronized Y j(@NonNull T t) {
        a<Y> aVar;
        aVar = this.a.get(t);
        return aVar != null ? aVar.a : null;
    }

    public synchronized int k() {
        return this.a.size();
    }

    public int l(@Nullable Y y) {
        return 1;
    }

    public void m(@NonNull T t, @Nullable Y y) {
    }

    @Nullable
    public synchronized Y n(@NonNull T t, @Nullable Y y) {
        int l2 = l(y);
        long j2 = l2;
        if (j2 >= this.f9948c) {
            m(t, y);
            return null;
        }
        if (y != null) {
            this.f9949d += j2;
        }
        a<Y> put = this.a.put(t, y == null ? null : new a<>(y, l2));
        if (put != null) {
            this.f9949d -= put.b;
            if (!put.a.equals(y)) {
                m(t, put.a);
            }
        }
        i();
        return put != null ? put.a : null;
    }

    @Nullable
    public synchronized Y o(@NonNull T t) {
        a<Y> remove = this.a.remove(t);
        if (remove == null) {
            return null;
        }
        this.f9949d -= remove.b;
        return remove.a;
    }

    public synchronized void p(long j2) {
        while (this.f9949d > j2) {
            Iterator<Map.Entry<T, a<Y>>> it = this.a.entrySet().iterator();
            Map.Entry<T, a<Y>> next = it.next();
            a<Y> value = next.getValue();
            this.f9949d -= value.b;
            T key = next.getKey();
            it.remove();
            m(key, value.a);
        }
    }
}
