package e.b.a.q;

import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class a implements l {
    private final Set<m> a = Collections.newSetFromMap(new WeakHashMap());
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f9838c;

    @Override // e.b.a.q.l
    public void a(@NonNull m mVar) {
        this.a.remove(mVar);
    }

    @Override // e.b.a.q.l
    public void b(@NonNull m mVar) {
        this.a.add(mVar);
        if (this.f9838c) {
            mVar.onDestroy();
        } else if (this.b) {
            mVar.onStart();
        } else {
            mVar.onStop();
        }
    }

    public void c() {
        this.f9838c = true;
        for (m mVar : e.b.a.v.n.k(this.a)) {
            mVar.onDestroy();
        }
    }

    public void d() {
        this.b = true;
        for (m mVar : e.b.a.v.n.k(this.a)) {
            mVar.onStart();
        }
    }

    public void e() {
        this.b = false;
        for (m mVar : e.b.a.v.n.k(this.a)) {
            mVar.onStop();
        }
    }
}
