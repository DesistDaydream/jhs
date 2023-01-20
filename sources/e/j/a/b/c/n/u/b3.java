package e.j.a.b.c.n.u;

import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public final class b3 {

    /* renamed from: d  reason: collision with root package name */
    private int f10202d;
    private final ArrayMap<z2<?>, String> b = new ArrayMap<>();

    /* renamed from: c  reason: collision with root package name */
    private final e.j.a.b.j.l<Map<z2<?>, String>> f10201c = new e.j.a.b.j.l<>();

    /* renamed from: e  reason: collision with root package name */
    private boolean f10203e = false;
    private final ArrayMap<z2<?>, ConnectionResult> a = new ArrayMap<>();

    public b3(Iterable<? extends e.j.a.b.c.n.h<?>> iterable) {
        for (e.j.a.b.c.n.h<?> hVar : iterable) {
            this.a.put(hVar.w(), null);
        }
        this.f10202d = this.a.keySet().size();
    }

    public final e.j.a.b.j.k<Map<z2<?>, String>> a() {
        return this.f10201c.a();
    }

    public final void b(z2<?> z2Var, ConnectionResult connectionResult, @Nullable String str) {
        this.a.put(z2Var, connectionResult);
        this.b.put(z2Var, str);
        this.f10202d--;
        if (!connectionResult.isSuccess()) {
            this.f10203e = true;
        }
        if (this.f10202d == 0) {
            if (this.f10203e) {
                this.f10201c.b(new AvailabilityException(this.a));
                return;
            }
            this.f10201c.setResult(this.b);
        }
    }

    public final Set<z2<?>> c() {
        return this.a.keySet();
    }
}
