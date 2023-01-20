package e.b.a.q;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class r {

    /* renamed from: d  reason: collision with root package name */
    private static final String f9859d = "RequestTracker";
    private final Set<e.b.a.t.e> a = Collections.newSetFromMap(new WeakHashMap());
    private final List<e.b.a.t.e> b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private boolean f9860c;

    @VisibleForTesting
    public void a(e.b.a.t.e eVar) {
        this.a.add(eVar);
    }

    public boolean b(@Nullable e.b.a.t.e eVar) {
        boolean z = true;
        if (eVar == null) {
            return true;
        }
        boolean remove = this.a.remove(eVar);
        if (!this.b.remove(eVar) && !remove) {
            z = false;
        }
        if (z) {
            eVar.clear();
        }
        return z;
    }

    public void c() {
        for (e.b.a.t.e eVar : e.b.a.v.n.k(this.a)) {
            b(eVar);
        }
        this.b.clear();
    }

    public boolean d() {
        return this.f9860c;
    }

    public void e() {
        this.f9860c = true;
        for (e.b.a.t.e eVar : e.b.a.v.n.k(this.a)) {
            if (eVar.isRunning() || eVar.isComplete()) {
                eVar.clear();
                this.b.add(eVar);
            }
        }
    }

    public void f() {
        this.f9860c = true;
        for (e.b.a.t.e eVar : e.b.a.v.n.k(this.a)) {
            if (eVar.isRunning()) {
                eVar.pause();
                this.b.add(eVar);
            }
        }
    }

    public void g() {
        for (e.b.a.t.e eVar : e.b.a.v.n.k(this.a)) {
            if (!eVar.isComplete() && !eVar.f()) {
                eVar.clear();
                if (!this.f9860c) {
                    eVar.d();
                } else {
                    this.b.add(eVar);
                }
            }
        }
    }

    public void h() {
        this.f9860c = false;
        for (e.b.a.t.e eVar : e.b.a.v.n.k(this.a)) {
            if (!eVar.isComplete() && !eVar.isRunning()) {
                eVar.d();
            }
        }
        this.b.clear();
    }

    public void i(@NonNull e.b.a.t.e eVar) {
        this.a.add(eVar);
        if (!this.f9860c) {
            eVar.d();
            return;
        }
        eVar.clear();
        if (Log.isLoggable(f9859d, 2)) {
            Log.v(f9859d, "Paused, delaying request");
        }
        this.b.add(eVar);
    }

    public String toString() {
        return super.toString() + "{numRequests=" + this.a.size() + ", isPaused=" + this.f9860c + "}";
    }
}
