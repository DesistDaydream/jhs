package e.j.f.u.b0.g;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class c {
    private final List<b> a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f11590c;

    public c(List<b> list, int i2, boolean z) {
        this.a = new ArrayList(list);
        this.b = i2;
        this.f11590c = z;
    }

    public List<b> a() {
        return this.a;
    }

    public int b() {
        return this.b;
    }

    public boolean c(List<b> list) {
        return this.a.equals(list);
    }

    public boolean d() {
        return this.f11590c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.a.equals(cVar.a()) && this.f11590c == cVar.f11590c;
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode() ^ Boolean.valueOf(this.f11590c).hashCode();
    }

    public String toString() {
        return "{ " + this.a + " }";
    }
}
