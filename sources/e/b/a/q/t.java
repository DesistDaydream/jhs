package e.b.a.q;

import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class t implements m {
    private final Set<e.b.a.t.k.p<?>> a = Collections.newSetFromMap(new WeakHashMap());

    public void a() {
        this.a.clear();
    }

    @NonNull
    public List<e.b.a.t.k.p<?>> b() {
        return e.b.a.v.n.k(this.a);
    }

    public void c(@NonNull e.b.a.t.k.p<?> pVar) {
        this.a.add(pVar);
    }

    public void d(@NonNull e.b.a.t.k.p<?> pVar) {
        this.a.remove(pVar);
    }

    @Override // e.b.a.q.m
    public void onDestroy() {
        for (e.b.a.t.k.p pVar : e.b.a.v.n.k(this.a)) {
            pVar.onDestroy();
        }
    }

    @Override // e.b.a.q.m
    public void onStart() {
        for (e.b.a.t.k.p pVar : e.b.a.v.n.k(this.a)) {
            pVar.onStart();
        }
    }

    @Override // e.b.a.q.m
    public void onStop() {
        for (e.b.a.t.k.p pVar : e.b.a.v.n.k(this.a)) {
            pVar.onStop();
        }
    }
}
