package h.p2.b0.g.t.p;

import h.a2.d1;
import h.k2.k;
import h.k2.v.f0;
import h.k2.v.h;
import h.k2.v.t0;
import h.k2.v.u;
import h.t1;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import kotlin.collections.ArraysKt___ArraysKt;

/* loaded from: classes3.dex */
public final class e<T> extends AbstractSet<T> {
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    public static final b f15632c = new b(null);
    @k.e.a.e
    private Object a;
    private int b;

    /* loaded from: classes3.dex */
    public static final class a<T> implements Iterator<T>, h.k2.v.x0.d {
        @k.e.a.d
        private final Iterator<T> a;

        public a(@k.e.a.d T[] tArr) {
            this.a = h.a(tArr);
        }

        @Override // java.util.Iterator
        @k.e.a.d
        /* renamed from: a */
        public Void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            return this.a.next();
        }
    }

    /* loaded from: classes3.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(u uVar) {
            this();
        }

        @k
        @k.e.a.d
        public final <T> e<T> a() {
            return new e<>(null);
        }

        @k
        @k.e.a.d
        public final <T> e<T> b(@k.e.a.d Collection<? extends T> collection) {
            e<T> eVar = new e<>(null);
            eVar.addAll(collection);
            return eVar;
        }
    }

    /* loaded from: classes3.dex */
    public static final class c<T> implements Iterator<T>, h.k2.v.x0.d {
        private final T a;
        private boolean b = true;

        public c(T t) {
            this.a = t;
        }

        @Override // java.util.Iterator
        @k.e.a.d
        /* renamed from: a */
        public Void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.b;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.b) {
                this.b = false;
                return this.a;
            }
            throw new NoSuchElementException();
        }
    }

    private e() {
    }

    public /* synthetic */ e(u uVar) {
        this();
    }

    @k
    @k.e.a.d
    public static final <T> e<T> a() {
        return f15632c.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(T t) {
        Object[] objArr;
        if (size() == 0) {
            this.a = t;
        } else if (size() == 1) {
            if (f0.g(this.a, t)) {
                return false;
            }
            this.a = new Object[]{this.a, t};
        } else if (size() < 5) {
            Object obj = this.a;
            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
            Object[] objArr2 = (Object[]) obj;
            if (ArraysKt___ArraysKt.P7(objArr2, t)) {
                return false;
            }
            if (size() == 4) {
                Object[] objArr3 = new Object[objArr2.length];
                System.arraycopy(objArr2, 0, objArr3, 0, objArr2.length);
                LinkedHashSet o = d1.o(objArr3);
                o.add(t);
                t1 t1Var = t1.a;
                objArr = o;
            } else {
                Object[] copyOf = Arrays.copyOf(objArr2, size() + 1);
                copyOf[copyOf.length - 1] = t;
                t1 t1Var2 = t1.a;
                objArr = copyOf;
            }
            this.a = objArr;
        } else {
            Object obj2 = this.a;
            Objects.requireNonNull(obj2, "null cannot be cast to non-null type kotlin.collections.MutableSet<T of org.jetbrains.kotlin.utils.SmartSet>");
            if (!t0.o(obj2).add(t)) {
                return false;
            }
        }
        d(size() + 1);
        return true;
    }

    public int b() {
        return this.b;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.a = null;
        d(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        if (size() == 0) {
            return false;
        }
        if (size() == 1) {
            return f0.g(this.a, obj);
        }
        if (size() < 5) {
            Object obj2 = this.a;
            Objects.requireNonNull(obj2, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
            return ArraysKt___ArraysKt.P7((Object[]) obj2, obj);
        }
        Object obj3 = this.a;
        Objects.requireNonNull(obj3, "null cannot be cast to non-null type kotlin.collections.Set<T of org.jetbrains.kotlin.utils.SmartSet>");
        return ((Set) obj3).contains(obj);
    }

    public void d(int i2) {
        this.b = i2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    @k.e.a.d
    public Iterator<T> iterator() {
        if (size() == 0) {
            return Collections.emptySet().iterator();
        }
        if (size() == 1) {
            return new c(this.a);
        }
        if (size() < 5) {
            Object obj = this.a;
            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
            return new a((Object[]) obj);
        }
        Object obj2 = this.a;
        Objects.requireNonNull(obj2, "null cannot be cast to non-null type kotlin.collections.MutableSet<T of org.jetbrains.kotlin.utils.SmartSet>");
        return t0.o(obj2).iterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return b();
    }
}
