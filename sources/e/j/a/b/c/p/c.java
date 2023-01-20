package e.j.a.b.c.p;

import e.j.a.b.c.r.a0;
import java.util.Iterator;
import java.util.NoSuchElementException;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public class c<T> implements Iterator<T> {
    public final b<T> a;
    public int b = -1;

    public c(b<T> bVar) {
        this.a = (b) a0.k(bVar);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.b < this.a.getCount() - 1;
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            b<T> bVar = this.a;
            int i2 = this.b + 1;
            this.b = i2;
            return bVar.get(i2);
        }
        int i3 = this.b;
        StringBuilder sb = new StringBuilder(46);
        sb.append("Cannot advance the iterator beyond ");
        sb.append(i3);
        throw new NoSuchElementException(sb.toString());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    }
}
