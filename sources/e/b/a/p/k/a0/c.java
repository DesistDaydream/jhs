package e.b.a.p.k.a0;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class c {
    private final Map<d, Integer> a;
    private final List<d> b;

    /* renamed from: c  reason: collision with root package name */
    private int f9501c;

    /* renamed from: d  reason: collision with root package name */
    private int f9502d;

    public c(Map<d, Integer> map) {
        this.a = map;
        this.b = new ArrayList(map.keySet());
        for (Integer num : map.values()) {
            this.f9501c += num.intValue();
        }
    }

    public int a() {
        return this.f9501c;
    }

    public boolean b() {
        return this.f9501c == 0;
    }

    public d c() {
        d dVar = this.b.get(this.f9502d);
        Integer num = this.a.get(dVar);
        if (num.intValue() == 1) {
            this.a.remove(dVar);
            this.b.remove(this.f9502d);
        } else {
            this.a.put(dVar, Integer.valueOf(num.intValue() - 1));
        }
        this.f9501c--;
        this.f9502d = this.b.isEmpty() ? 0 : (this.f9502d + 1) % this.b.size();
        return dVar;
    }
}
