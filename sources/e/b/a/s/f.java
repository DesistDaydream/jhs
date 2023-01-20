package e.b.a.s;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import e.b.a.p.h;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class f {
    private final List<a<?>> a = new ArrayList();

    /* loaded from: classes.dex */
    public static final class a<T> {
        private final Class<T> a;
        public final h<T> b;

        public a(@NonNull Class<T> cls, @NonNull h<T> hVar) {
            this.a = cls;
            this.b = hVar;
        }

        public boolean a(@NonNull Class<?> cls) {
            return this.a.isAssignableFrom(cls);
        }
    }

    public synchronized <Z> void a(@NonNull Class<Z> cls, @NonNull h<Z> hVar) {
        this.a.add(new a<>(cls, hVar));
    }

    @Nullable
    public synchronized <Z> h<Z> b(@NonNull Class<Z> cls) {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            a<?> aVar = this.a.get(i2);
            if (aVar.a(cls)) {
                return (h<Z>) aVar.b;
            }
        }
        return null;
    }

    public synchronized <Z> void c(@NonNull Class<Z> cls, @NonNull h<Z> hVar) {
        this.a.add(0, new a<>(cls, hVar));
    }
}
