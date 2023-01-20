package h.a2;

import androidx.exifinterface.media.ExifInterface;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.RandomAccess;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010(\n\u0002\b\b\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001d\u0012\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0002\u0010\fJ\u0013\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0000¢\u0006\u0002\u0010\u0016J\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0018\u001a\u00020\u0006J\u0016\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00020\u0006H\u0096\u0002¢\u0006\u0002\u0010\u001bJ\u0006\u0010\u001c\u001a\u00020\u001dJ\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\u0096\u0002J\u000e\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u0006J\u0015\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tH\u0014¢\u0006\u0002\u0010#J'\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u00010\t\"\u0004\b\u0001\u0010\u00012\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H\u00010\tH\u0014¢\u0006\u0002\u0010%J\u0015\u0010&\u001a\u00020\u0006*\u00020\u00062\u0006\u0010!\u001a\u00020\u0006H\u0082\bR\u0018\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lkotlin/collections/RingBuffer;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/collections/AbstractList;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "capacity", "", "(I)V", "buffer", "", "", "filledSize", "([Ljava/lang/Object;I)V", "[Ljava/lang/Object;", "<set-?>", "size", "getSize", "()I", "startIndex", "add", "", "element", "(Ljava/lang/Object;)V", "expanded", "maxCapacity", "get", "index", "(I)Ljava/lang/Object;", "isFull", "", "iterator", "", "removeFirst", "n", "toArray", "()[Ljava/lang/Object;", "array", "([Ljava/lang/Object;)[Ljava/lang/Object;", "forward", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class a1<T> extends c<T> implements RandomAccess {
    private final int b;

    /* renamed from: c */
    private int f14819c;

    /* renamed from: d */
    private int f14820d;

    /* renamed from: e */
    private final Object[] f14821e;

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u0005\u001a\u00020\u0006H\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"kotlin/collections/RingBuffer$iterator$1", "Lkotlin/collections/AbstractIterator;", "count", "", "index", "computeNext", "", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public static final class a extends b<T> {

        /* renamed from: c */
        private int f14822c;

        /* renamed from: d */
        private int f14823d;

        public a() {
            a1.this = r2;
            this.f14822c = r2.size();
            this.f14823d = r2.f14819c;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // h.a2.b
        public void a() {
            if (this.f14822c != 0) {
                f(a1.this.f14821e[this.f14823d]);
                this.f14823d = (this.f14823d + 1) % a1.this.b;
                this.f14822c--;
                return;
            }
            d();
        }
    }

    public a1(@k.e.a.d Object[] objArr, int i2) {
        this.f14821e = objArr;
        if (i2 >= 0) {
            if (i2 <= objArr.length) {
                this.b = objArr.length;
                this.f14820d = i2;
                return;
            }
            throw new IllegalArgumentException(("ring buffer filled size: " + i2 + " cannot be larger than the buffer size: " + objArr.length).toString());
        }
        throw new IllegalArgumentException(("ring buffer filled size should not be negative but it is " + i2).toString());
    }

    public final int s(int i2, int i3) {
        return (i2 + i3) % this.b;
    }

    @Override // h.a2.c, kotlin.collections.AbstractCollection
    public int a() {
        return this.f14820d;
    }

    @Override // h.a2.c, java.util.List
    public T get(int i2) {
        c.a.b(i2, size());
        return (T) this.f14821e[(this.f14819c + i2) % this.b];
    }

    @Override // h.a2.c, kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    @k.e.a.d
    public Iterator<T> iterator() {
        return new a();
    }

    public final void q(T t) {
        if (!t()) {
            this.f14821e[(this.f14819c + size()) % this.b] = t;
            this.f14820d = size() + 1;
            return;
        }
        throw new IllegalStateException("ring buffer is full");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @k.e.a.d
    public final a1<T> r(int i2) {
        int i3 = this.b;
        int u = h.o2.q.u(i3 + (i3 >> 1) + 1, i2);
        return new a1<>(this.f14819c == 0 ? Arrays.copyOf(this.f14821e, u) : toArray(new Object[u]), size());
    }

    public final boolean t() {
        return size() == this.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    @k.e.a.d
    public <T> T[] toArray(@k.e.a.d T[] tArr) {
        if (tArr.length < size()) {
            tArr = (T[]) Arrays.copyOf(tArr, size());
        }
        int size = size();
        int i2 = 0;
        int i3 = 0;
        for (int i4 = this.f14819c; i3 < size && i4 < this.b; i4++) {
            tArr[i3] = this.f14821e[i4];
            i3++;
        }
        while (i3 < size) {
            tArr[i3] = this.f14821e[i2];
            i3++;
            i2++;
        }
        if (tArr.length > size()) {
            tArr[size()] = null;
        }
        Objects.requireNonNull(tArr, "null cannot be cast to non-null type kotlin.Array<T>");
        return tArr;
    }

    public final void u(int i2) {
        if (i2 >= 0) {
            if (!(i2 <= size())) {
                throw new IllegalArgumentException(("n shouldn't be greater than the buffer size: n = " + i2 + ", size = " + size()).toString());
            } else if (i2 > 0) {
                int i3 = this.f14819c;
                int i4 = (i3 + i2) % this.b;
                if (i3 > i4) {
                    n.n2(this.f14821e, null, i3, this.b);
                    n.n2(this.f14821e, null, 0, i4);
                } else {
                    n.n2(this.f14821e, null, i3, i4);
                }
                this.f14819c = i4;
                this.f14820d = size() - i2;
                return;
            } else {
                return;
            }
        }
        throw new IllegalArgumentException(("n shouldn't be negative but it is " + i2).toString());
    }

    public a1(int i2) {
        this(new Object[i2], 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    @k.e.a.d
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
