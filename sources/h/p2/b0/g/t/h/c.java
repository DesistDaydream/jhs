package h.p2.b0.g.t.h;

import h.k2.v.f0;
import h.k2.v.t;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import k.e.a.e;

/* loaded from: classes3.dex */
public class c implements Collection<b>, h.k2.v.x0.a {
    @k.e.a.d
    private final Set<b> a;

    @Override // java.util.Collection
    /* renamed from: a */
    public boolean add(b bVar) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends b> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof b) {
            return d((b) obj);
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(@k.e.a.d Collection<? extends Object> collection) {
        return this.a.containsAll(collection);
    }

    public boolean d(@k.e.a.d b bVar) {
        return this.a.contains(bVar);
    }

    @Override // java.util.Collection
    public boolean equals(@e Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c) && f0.g(this.a, ((c) obj).a);
    }

    @k.e.a.d
    public final Set<b> f() {
        return this.a;
    }

    public int g() {
        return this.a.size();
    }

    @Override // java.util.Collection
    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable
    @k.e.a.d
    public Iterator<b> iterator() {
        return this.a.iterator();
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return g();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return t.a(this);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) t.b(this, tArr);
    }

    @k.e.a.d
    public String toString() {
        return a.a(this);
    }
}
