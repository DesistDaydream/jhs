package e.b.a.s;

import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import e.b.a.p.k.g;
import e.b.a.p.k.q;
import e.b.a.v.k;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private static final q<?, ?, ?> f9867c = new q<>(Object.class, Object.class, Object.class, Collections.singletonList(new g(Object.class, Object.class, Object.class, Collections.emptyList(), new e.b.a.p.m.i.g(), null)), null);
    private final ArrayMap<k, q<?, ?, ?>> a = new ArrayMap<>();
    private final AtomicReference<k> b = new AtomicReference<>();

    private k b(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        k andSet = this.b.getAndSet(null);
        if (andSet == null) {
            andSet = new k();
        }
        andSet.b(cls, cls2, cls3);
        return andSet;
    }

    @Nullable
    public <Data, TResource, Transcode> q<Data, TResource, Transcode> a(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        q<Data, TResource, Transcode> qVar;
        k b = b(cls, cls2, cls3);
        synchronized (this.a) {
            qVar = (q<Data, TResource, Transcode>) this.a.get(b);
        }
        this.b.set(b);
        return qVar;
    }

    public boolean c(@Nullable q<?, ?, ?> qVar) {
        return f9867c.equals(qVar);
    }

    public void d(Class<?> cls, Class<?> cls2, Class<?> cls3, @Nullable q<?, ?, ?> qVar) {
        synchronized (this.a) {
            ArrayMap<k, q<?, ?, ?>> arrayMap = this.a;
            k kVar = new k(cls, cls2, cls3);
            if (qVar == null) {
                qVar = f9867c;
            }
            arrayMap.put(kVar, qVar);
        }
    }
}
