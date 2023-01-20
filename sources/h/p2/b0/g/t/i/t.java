package h.p2.b0.g.t.i;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
public class t extends AbstractList<String> implements RandomAccess, l {
    private final l a;

    /* loaded from: classes3.dex */
    public class a implements ListIterator<String> {
        public ListIterator<String> a;
        public final /* synthetic */ int b;

        public a(int i2) {
            this.b = i2;
            this.a = t.this.a.listIterator(i2);
        }

        @Override // java.util.ListIterator
        /* renamed from: a */
        public void add(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        /* renamed from: b */
        public String next() {
            return this.a.next();
        }

        @Override // java.util.ListIterator
        /* renamed from: c */
        public String previous() {
            return this.a.previous();
        }

        @Override // java.util.ListIterator
        /* renamed from: d */
        public void set(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.a.hasNext();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.a.hasPrevious();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.a.nextIndex();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.a.previousIndex();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Iterator<String> {
        public Iterator<String> a;

        public b() {
            this.a = t.this.a.iterator();
        }

        @Override // java.util.Iterator
        /* renamed from: a */
        public String next() {
            return this.a.next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public t(l lVar) {
        this.a = lVar;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: b */
    public String get(int i2) {
        return this.a.get(i2);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<String> iterator() {
        return new b();
    }

    @Override // h.p2.b0.g.t.i.l
    public List<?> j() {
        return this.a.j();
    }

    @Override // h.p2.b0.g.t.i.l
    public d k(int i2) {
        return this.a.k(i2);
    }

    @Override // h.p2.b0.g.t.i.l
    public void l(d dVar) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<String> listIterator(int i2) {
        return new a(i2);
    }

    @Override // h.p2.b0.g.t.i.l
    public l o() {
        return this;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.a.size();
    }
}
