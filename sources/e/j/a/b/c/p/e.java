package e.j.a.b.c.p;

import e.j.a.b.c.p.d;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes2.dex */
public final class e implements d, d.a {
    private HashSet<d> a = new HashSet<>();

    @Override // e.j.a.b.c.p.d.a
    public final void a(d dVar) {
        this.a.remove(dVar);
    }

    @Override // e.j.a.b.c.p.d.a
    public final void b(d dVar) {
        this.a.add(dVar);
    }

    public final void c() {
        this.a.clear();
    }

    public final boolean d() {
        return !this.a.isEmpty();
    }

    @Override // e.j.a.b.c.p.d
    public final void onDataChanged() {
        Iterator<d> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onDataChanged();
        }
    }

    @Override // e.j.a.b.c.p.d
    public final void onDataRangeChanged(int i2, int i3) {
        Iterator<d> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onDataRangeChanged(i2, i3);
        }
    }

    @Override // e.j.a.b.c.p.d
    public final void onDataRangeInserted(int i2, int i3) {
        Iterator<d> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onDataRangeInserted(i2, i3);
        }
    }

    @Override // e.j.a.b.c.p.d
    public final void onDataRangeMoved(int i2, int i3, int i4) {
        Iterator<d> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onDataRangeMoved(i2, i3, i4);
        }
    }

    @Override // e.j.a.b.c.p.d
    public final void onDataRangeRemoved(int i2, int i3) {
        Iterator<d> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onDataRangeRemoved(i2, i3);
        }
    }
}
