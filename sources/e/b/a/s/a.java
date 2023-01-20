package e.b.a.s;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class a {
    private final List<C0323a<?>> a = new ArrayList();

    /* renamed from: e.b.a.s.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0323a<T> {
        private final Class<T> a;
        public final e.b.a.p.a<T> b;

        public C0323a(@NonNull Class<T> cls, @NonNull e.b.a.p.a<T> aVar) {
            this.a = cls;
            this.b = aVar;
        }

        public boolean a(@NonNull Class<?> cls) {
            return this.a.isAssignableFrom(cls);
        }
    }

    public synchronized <T> void a(@NonNull Class<T> cls, @NonNull e.b.a.p.a<T> aVar) {
        this.a.add(new C0323a<>(cls, aVar));
    }

    @Nullable
    public synchronized <T> e.b.a.p.a<T> b(@NonNull Class<T> cls) {
        for (C0323a<?> c0323a : this.a) {
            if (c0323a.a(cls)) {
                return (e.b.a.p.a<T>) c0323a.b;
            }
        }
        return null;
    }

    public synchronized <T> void c(@NonNull Class<T> cls, @NonNull e.b.a.p.a<T> aVar) {
        this.a.add(0, new C0323a<>(cls, aVar));
    }
}
