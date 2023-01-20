package e.j.a.b.c.n.u;

import android.os.Looper;
import androidx.annotation.NonNull;
import e.j.a.b.c.n.u.l;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public class m {
    private final Set<l<?>> a = Collections.newSetFromMap(new WeakHashMap());

    @e.j.a.b.c.m.a
    public static <L> l<L> a(@NonNull L l2, @NonNull Looper looper, @NonNull String str) {
        e.j.a.b.c.r.a0.l(l2, "Listener must not be null");
        e.j.a.b.c.r.a0.l(looper, "Looper must not be null");
        e.j.a.b.c.r.a0.l(str, "Listener type must not be null");
        return new l<>(looper, l2, str);
    }

    @e.j.a.b.c.m.a
    public static <L> l.a<L> b(@NonNull L l2, @NonNull String str) {
        e.j.a.b.c.r.a0.l(l2, "Listener must not be null");
        e.j.a.b.c.r.a0.l(str, "Listener type must not be null");
        e.j.a.b.c.r.a0.h(str, "Listener type must not be empty");
        return new l.a<>(l2, str);
    }

    public final void c() {
        for (l<?> lVar : this.a) {
            lVar.a();
        }
        this.a.clear();
    }

    public final <L> l<L> d(@NonNull L l2, @NonNull Looper looper, @NonNull String str) {
        l<L> a = a(l2, looper, str);
        this.a.add(a);
        return a;
    }
}
