package e.b.a.p.j;

import androidx.annotation.NonNull;
import e.b.a.p.j.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class f {
    private static final e.a<?> b = new a();
    private final Map<Class<?>, e.a<?>> a = new HashMap();

    /* loaded from: classes.dex */
    public class a implements e.a<Object> {
        @Override // e.b.a.p.j.e.a
        @NonNull
        public e<Object> a(@NonNull Object obj) {
            return new b(obj);
        }

        @Override // e.b.a.p.j.e.a
        @NonNull
        public Class<Object> getDataClass() {
            throw new UnsupportedOperationException("Not implemented");
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements e<Object> {
        private final Object a;

        public b(@NonNull Object obj) {
            this.a = obj;
        }

        @Override // e.b.a.p.j.e
        public void a() {
        }

        @Override // e.b.a.p.j.e
        @NonNull
        public Object b() {
            return this.a;
        }
    }

    @NonNull
    public synchronized <T> e<T> a(@NonNull T t) {
        e.a<?> aVar;
        e.b.a.v.l.d(t);
        aVar = this.a.get(t.getClass());
        if (aVar == null) {
            Iterator<e.a<?>> it = this.a.values().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                e.a<?> next = it.next();
                if (next.getDataClass().isAssignableFrom(t.getClass())) {
                    aVar = next;
                    break;
                }
            }
        }
        if (aVar == null) {
            aVar = b;
        }
        return (e<T>) aVar.a(t);
    }

    public synchronized void b(@NonNull e.a<?> aVar) {
        this.a.put(aVar.getDataClass(), aVar);
    }
}
