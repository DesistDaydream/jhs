package h.p2.b0.g.u;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes3.dex */
public final class a<E> implements Iterable<E> {

    /* renamed from: d  reason: collision with root package name */
    private static final a<Object> f15633d = new a<>();
    public final E a;
    public final a<E> b;

    /* renamed from: c  reason: collision with root package name */
    private final int f15634c;

    /* renamed from: h.p2.b0.g.u.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0474a<E> implements Iterator<E> {
        private a<E> a;

        public C0474a(a<E> aVar) {
            this.a = aVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return ((a) this.a).f15634c > 0;
        }

        @Override // java.util.Iterator
        public E next() {
            a<E> aVar = this.a;
            E e2 = aVar.a;
            this.a = aVar.b;
            return e2;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private a() {
        this.f15634c = 0;
        this.a = null;
        this.b = null;
    }

    public static <E> a<E> b() {
        return (a<E>) f15633d;
    }

    private Iterator<E> d(int i2) {
        return new C0474a(h(i2));
    }

    private a<E> f(Object obj) {
        if (this.f15634c == 0) {
            return this;
        }
        if (this.a.equals(obj)) {
            return this.b;
        }
        a<E> f2 = this.b.f(obj);
        return f2 == this.b ? this : new a<>(this.a, f2);
    }

    private a<E> h(int i2) {
        if (i2 < 0 || i2 > this.f15634c) {
            throw new IndexOutOfBoundsException();
        }
        return i2 == 0 ? this : this.b.h(i2 - 1);
    }

    public a<E> e(int i2) {
        return f(get(i2));
    }

    public a<E> g(E e2) {
        return new a<>(e2, this);
    }

    public E get(int i2) {
        if (i2 >= 0 && i2 <= this.f15634c) {
            try {
                return d(i2).next();
            } catch (NoSuchElementException unused) {
                throw new IndexOutOfBoundsException("Index: " + i2);
            }
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        return d(0);
    }

    public int size() {
        return this.f15634c;
    }

    private a(E e2, a<E> aVar) {
        this.a = e2;
        this.b = aVar;
        this.f15634c = aVar.f15634c + 1;
    }
}
