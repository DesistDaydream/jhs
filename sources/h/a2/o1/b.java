package h.a2.o1;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.tencent.android.tpush.common.MessageKey;
import h.a2.j;
import h.a2.n;
import h.k2.v.f0;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.RandomAccess;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010+\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u00042\b\u0012\u0004\u0012\u0002H\u00010\u0005:\u0001QB\u0007\b\u0016¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tBM\b\u0002\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000\u0012\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000¢\u0006\u0002\u0010\u0012J\u0015\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0019J\u001d\u0010\u0017\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001cJ\u001e\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\u0016J\u0016\u0010\u001d\u001a\u00020\u000f2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\u0016J&\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001f2\u0006\u0010\"\u001a\u00020\bH\u0002J\u001d\u0010#\u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001cJ\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000%J\b\u0010&\u001a\u00020\u001aH\u0002J\b\u0010'\u001a\u00020\u001aH\u0016J\u0014\u0010(\u001a\u00020\u000f2\n\u0010)\u001a\u0006\u0012\u0002\b\u00030%H\u0002J\u0010\u0010*\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\bH\u0002J\u0010\u0010,\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\bH\u0002J\u0013\u0010-\u001a\u00020\u000f2\b\u0010)\u001a\u0004\u0018\u00010.H\u0096\u0002J\u0016\u0010/\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\bH\u0096\u0002¢\u0006\u0002\u00100J\b\u00101\u001a\u00020\bH\u0016J\u0015\u00102\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00103J\u0018\u00104\u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\bH\u0002J\b\u00105\u001a\u00020\u000fH\u0016J\u000f\u00106\u001a\b\u0012\u0004\u0012\u00028\u000007H\u0096\u0002J\u0015\u00108\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00103J\u000e\u00109\u001a\b\u0012\u0004\u0012\u00028\u00000:H\u0016J\u0016\u00109\u001a\b\u0012\u0004\u0012\u00028\u00000:2\u0006\u0010\u001b\u001a\u00020\bH\u0016J\u0015\u0010;\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0019J\u0016\u0010<\u001a\u00020\u000f2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\u0016J\u0015\u0010=\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\bH\u0016¢\u0006\u0002\u00100J\u0015\u0010>\u001a\u00028\u00002\u0006\u0010!\u001a\u00020\bH\u0002¢\u0006\u0002\u00100J\u0018\u0010?\u001a\u00020\u001a2\u0006\u0010@\u001a\u00020\b2\u0006\u0010A\u001a\u00020\bH\u0002J\u0016\u0010B\u001a\u00020\u000f2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\u0016J.\u0010C\u001a\u00020\b2\u0006\u0010@\u001a\u00020\b2\u0006\u0010A\u001a\u00020\b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001f2\u0006\u0010D\u001a\u00020\u000fH\u0002J\u001e\u0010E\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010FJ\u001e\u0010G\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010H\u001a\u00020\b2\u0006\u0010I\u001a\u00020\bH\u0016J\u0015\u0010J\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010.0\u000bH\u0016¢\u0006\u0002\u0010KJ'\u0010J\u001a\b\u0012\u0004\u0012\u0002HL0\u000b\"\u0004\b\u0001\u0010L2\f\u0010M\u001a\b\u0012\u0004\u0012\u0002HL0\u000bH\u0016¢\u0006\u0002\u0010NJ\b\u0010O\u001a\u00020PH\u0016R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006R"}, d2 = {"Lkotlin/collections/builders/ListBuilder;", ExifInterface.LONGITUDE_EAST, "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "Lkotlin/collections/AbstractMutableList;", "()V", "initialCapacity", "", "(I)V", "array", "", "offset", "length", "isReadOnly", "", "backing", "root", "([Ljava/lang/Object;IIZLkotlin/collections/builders/ListBuilder;Lkotlin/collections/builders/ListBuilder;)V", "[Ljava/lang/Object;", "size", "getSize", "()I", "add", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", MessageKey.CUSTOM_LAYOUT_ELEMENTS, "", "addAllInternal", "i", "n", "addAtInternal", "build", "", "checkIsMutable", "clear", "contentEquals", "other", "ensureCapacity", "minCapacity", "ensureExtraCapacity", "equals", "", "get", "(I)Ljava/lang/Object;", TTDownloadField.TT_HASHCODE, "indexOf", "(Ljava/lang/Object;)I", "insertAtInternal", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "remove", "removeAll", "removeAt", "removeAtInternal", "removeRangeInternal", "rangeOffset", "rangeLength", "retainAll", "retainOrRemoveAllInternal", "retain", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "fromIndex", "toIndex", "toArray", "()[Ljava/lang/Object;", ExifInterface.GPS_DIRECTION_TRUE, "destination", "([Ljava/lang/Object;)[Ljava/lang/Object;", "toString", "", "Itr", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class b<E> extends h.a2.e<E> implements List<E>, RandomAccess, h.k2.v.x0.e {
    private E[] a;
    private int b;

    /* renamed from: c */
    private int f14833c;

    /* renamed from: d */
    private boolean f14834d;

    /* renamed from: e */
    private final b<E> f14835e;

    /* renamed from: f */
    private final b<E> f14836f;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001d\b\u0016\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\fJ\t\u0010\r\u001a\u00020\u000eH\u0096\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u000e\u0010\u0010\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\r\u0010\u0013\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0011J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\b\u0010\u0015\u001a\u00020\nH\u0016J\u0015\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lkotlin/collections/builders/ListBuilder$Itr;", ExifInterface.LONGITUDE_EAST, "", "list", "Lkotlin/collections/builders/ListBuilder;", "index", "", "(Lkotlin/collections/builders/ListBuilder;I)V", "lastIndex", "add", "", "element", "(Ljava/lang/Object;)V", "hasNext", "", "hasPrevious", "next", "()Ljava/lang/Object;", "nextIndex", "previous", "previousIndex", "remove", "set", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public static final class a<E> implements ListIterator<E>, h.k2.v.x0.f {
        private final b<E> a;
        private int b;

        /* renamed from: c */
        private int f14837c = -1;

        public a(@k.e.a.d b<E> bVar, int i2) {
            this.a = bVar;
            this.b = i2;
        }

        @Override // java.util.ListIterator
        public void add(E e2) {
            b<E> bVar = this.a;
            int i2 = this.b;
            this.b = i2 + 1;
            bVar.add(i2, e2);
            this.f14837c = -1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.b < ((b) this.a).f14833c;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.b > 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public E next() {
            if (this.b < ((b) this.a).f14833c) {
                int i2 = this.b;
                this.b = i2 + 1;
                this.f14837c = i2;
                return (E) ((b) this.a).a[((b) this.a).b + this.f14837c];
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.b;
        }

        @Override // java.util.ListIterator
        public E previous() {
            int i2 = this.b;
            if (i2 > 0) {
                int i3 = i2 - 1;
                this.b = i3;
                this.f14837c = i3;
                return (E) ((b) this.a).a[((b) this.a).b + this.f14837c];
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.b - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            int i2 = this.f14837c;
            if (i2 != -1) {
                this.a.remove(i2);
                this.b = this.f14837c;
                this.f14837c = -1;
                return;
            }
            throw new IllegalStateException("Call next() or previous() before removing element from the iterator.".toString());
        }

        @Override // java.util.ListIterator
        public void set(E e2) {
            int i2 = this.f14837c;
            if (i2 != -1) {
                this.a.set(i2, e2);
                return;
            }
            throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.".toString());
        }
    }

    private b(E[] eArr, int i2, int i3, boolean z, b<E> bVar, b<E> bVar2) {
        this.a = eArr;
        this.b = i2;
        this.f14833c = i3;
        this.f14834d = z;
        this.f14835e = bVar;
        this.f14836f = bVar2;
    }

    private final int A(int i2, int i3, Collection<? extends E> collection, boolean z) {
        b<E> bVar = this.f14835e;
        if (bVar != null) {
            int A = bVar.A(i2, i3, collection, z);
            this.f14833c -= A;
            return A;
        }
        int i4 = 0;
        int i5 = 0;
        while (i4 < i3) {
            int i6 = i2 + i4;
            if (collection.contains(this.a[i6]) == z) {
                E[] eArr = this.a;
                i4++;
                eArr[i5 + i2] = eArr[i6];
                i5++;
            } else {
                i4++;
            }
        }
        int i7 = i3 - i5;
        E[] eArr2 = this.a;
        n.c1(eArr2, eArr2, i2 + i5, i3 + i2, this.f14833c);
        E[] eArr3 = this.a;
        int i8 = this.f14833c;
        c.g(eArr3, i8 - i7, i8);
        this.f14833c -= i7;
        return i7;
    }

    private final void q(int i2, Collection<? extends E> collection, int i3) {
        b<E> bVar = this.f14835e;
        if (bVar != null) {
            bVar.q(i2, collection, i3);
            this.a = this.f14835e.a;
            this.f14833c += i3;
            return;
        }
        x(i2, i3);
        Iterator<? extends E> it = collection.iterator();
        for (int i4 = 0; i4 < i3; i4++) {
            this.a[i2 + i4] = it.next();
        }
    }

    private final void r(int i2, E e2) {
        b<E> bVar = this.f14835e;
        if (bVar != null) {
            bVar.r(i2, e2);
            this.a = this.f14835e.a;
            this.f14833c++;
            return;
        }
        x(i2, 1);
        this.a[i2] = e2;
    }

    private final void t() {
        b<E> bVar;
        if (this.f14834d || ((bVar = this.f14836f) != null && bVar.f14834d)) {
            throw new UnsupportedOperationException();
        }
    }

    private final boolean u(List<?> list) {
        boolean h2;
        h2 = c.h(this.a, this.b, this.f14833c, list);
        return h2;
    }

    private final void v(int i2) {
        if (this.f14835e == null) {
            E[] eArr = this.a;
            if (i2 > eArr.length) {
                this.a = (E[]) c.e(this.a, j.f14831g.a(eArr.length, i2));
                return;
            }
            return;
        }
        throw new IllegalStateException();
    }

    private final void w(int i2) {
        v(this.f14833c + i2);
    }

    private final void x(int i2, int i3) {
        w(i3);
        E[] eArr = this.a;
        n.c1(eArr, eArr, i2 + i3, i2, this.b + this.f14833c);
        this.f14833c += i3;
    }

    private final E y(int i2) {
        b<E> bVar = this.f14835e;
        if (bVar != null) {
            this.f14833c--;
            return bVar.y(i2);
        }
        E[] eArr = this.a;
        E e2 = eArr[i2];
        n.c1(eArr, eArr, i2, i2 + 1, this.b + this.f14833c);
        c.f(this.a, (this.b + this.f14833c) - 1);
        this.f14833c--;
        return e2;
    }

    private final void z(int i2, int i3) {
        b<E> bVar = this.f14835e;
        if (bVar != null) {
            bVar.z(i2, i3);
        } else {
            E[] eArr = this.a;
            n.c1(eArr, eArr, i2, i2 + i3, this.f14833c);
            E[] eArr2 = this.a;
            int i4 = this.f14833c;
            c.g(eArr2, i4 - i3, i4);
        }
        this.f14833c -= i3;
    }

    @Override // h.a2.e
    public int a() {
        return this.f14833c;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e2) {
        t();
        r(this.b + this.f14833c, e2);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(@k.e.a.d Collection<? extends E> collection) {
        t();
        int size = collection.size();
        q(this.b + this.f14833c, collection, size);
        return size > 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        t();
        z(this.b, this.f14833c);
    }

    @Override // h.a2.e
    public E d(int i2) {
        t();
        h.a2.c.a.b(i2, this.f14833c);
        return y(this.b + i2);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(@k.e.a.e Object obj) {
        return obj == this || ((obj instanceof List) && u((List) obj));
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i2) {
        h.a2.c.a.b(i2, this.f14833c);
        return this.a[this.b + i2];
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i2;
        i2 = c.i(this.a, this.b, this.f14833c);
        return i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        for (int i2 = 0; i2 < this.f14833c; i2++) {
            if (f0.g(this.a[this.b + i2], obj)) {
                return i2;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return this.f14833c == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    @k.e.a.d
    public Iterator<E> iterator() {
        return new a(this, 0);
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        for (int i2 = this.f14833c - 1; i2 >= 0; i2--) {
            if (f0.g(this.a[this.b + i2], obj)) {
                return i2;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    @k.e.a.d
    public ListIterator<E> listIterator() {
        return new a(this, 0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        t();
        int indexOf = indexOf(obj);
        if (indexOf >= 0) {
            remove(indexOf);
        }
        return indexOf >= 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(@k.e.a.d Collection<? extends Object> collection) {
        t();
        return A(this.b, this.f14833c, collection, false) > 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(@k.e.a.d Collection<? extends Object> collection) {
        t();
        return A(this.b, this.f14833c, collection, true) > 0;
    }

    @k.e.a.d
    public final List<E> s() {
        if (this.f14835e == null) {
            t();
            this.f14834d = true;
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // h.a2.e, java.util.AbstractList, java.util.List
    public E set(int i2, E e2) {
        t();
        h.a2.c.a.b(i2, this.f14833c);
        E[] eArr = this.a;
        int i3 = this.b;
        E e3 = eArr[i3 + i2];
        eArr[i3 + i2] = e2;
        return e3;
    }

    @Override // java.util.AbstractList, java.util.List
    @k.e.a.d
    public List<E> subList(int i2, int i3) {
        h.a2.c.a.d(i2, i3, this.f14833c);
        E[] eArr = this.a;
        int i4 = this.b + i2;
        int i5 = i3 - i2;
        boolean z = this.f14834d;
        b<E> bVar = this.f14836f;
        return new b(eArr, i4, i5, z, this, bVar != null ? bVar : this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    @k.e.a.d
    public <T> T[] toArray(@k.e.a.d T[] tArr) {
        int length = tArr.length;
        int i2 = this.f14833c;
        if (length < i2) {
            E[] eArr = this.a;
            int i3 = this.b;
            return (T[]) Arrays.copyOfRange(eArr, i3, i2 + i3, tArr.getClass());
        }
        E[] eArr2 = this.a;
        Objects.requireNonNull(eArr2, "null cannot be cast to non-null type kotlin.Array<T>");
        int i4 = this.b;
        n.c1(eArr2, tArr, 0, i4, i2 + i4);
        int length2 = tArr.length;
        int i5 = this.f14833c;
        if (length2 > i5) {
            tArr[i5] = null;
        }
        return tArr;
    }

    @Override // java.util.AbstractCollection
    @k.e.a.d
    public String toString() {
        String j2;
        j2 = c.j(this.a, this.b, this.f14833c);
        return j2;
    }

    public b() {
        this(10);
    }

    @Override // java.util.AbstractList, java.util.List
    @k.e.a.d
    public ListIterator<E> listIterator(int i2) {
        h.a2.c.a.c(i2, this.f14833c);
        return new a(this, i2);
    }

    public b(int i2) {
        this(c.d(i2), 0, 0, false, null, null);
    }

    @Override // h.a2.e, java.util.AbstractList, java.util.List
    public void add(int i2, E e2) {
        t();
        h.a2.c.a.c(i2, this.f14833c);
        r(this.b + i2, e2);
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i2, @k.e.a.d Collection<? extends E> collection) {
        t();
        h.a2.c.a.c(i2, this.f14833c);
        int size = collection.size();
        q(this.b + i2, collection, size);
        return size > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    @k.e.a.d
    public Object[] toArray() {
        E[] eArr = this.a;
        int i2 = this.b;
        Object[] M1 = n.M1(eArr, i2, this.f14833c + i2);
        Objects.requireNonNull(M1, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        return M1;
    }
}
