package e.b.a;

import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class f {
    private final Map<Class<?>, b> a;

    /* loaded from: classes.dex */
    public static final class a {
        private final Map<Class<?>, b> a = new HashMap();

        public a b(b bVar) {
            this.a.put(bVar.getClass(), bVar);
            return this;
        }

        public f c() {
            return new f(this);
        }

        public a update(b bVar, boolean z) {
            if (z) {
                b(bVar);
            } else {
                this.a.remove(bVar.getClass());
            }
            return this;
        }
    }

    /* loaded from: classes.dex */
    public interface b {
    }

    public f(a aVar) {
        this.a = Collections.unmodifiableMap(new HashMap(aVar.a));
    }

    @Nullable
    public <T extends b> T a(Class<T> cls) {
        return (T) this.a.get(cls);
    }

    public boolean b(Class<? extends b> cls) {
        return this.a.containsKey(cls);
    }
}
