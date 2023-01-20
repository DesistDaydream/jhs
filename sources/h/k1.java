package h;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.tencent.android.tpush.common.MessageKey;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;

@p
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00012B\u0014\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006B\u0014\b\u0001\u0012\u0006\u0010\u0007\u001a\u00020\bø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\tJ\u001b\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J \u0010\u0013\u001a\u00020\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u001e\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0004H\u0086\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b!\u0010\u000bJ\u000f\u0010\"\u001a\u00020\u000fH\u0016¢\u0006\u0004\b#\u0010$J\u0019\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020&H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b'\u0010(J#\u0010)\u001a\u00020*2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0002H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b,\u0010-J\u0010\u0010.\u001a\u00020/HÖ\u0001¢\u0006\u0004\b0\u00101R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\b8\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\f\u0010\r\u0088\u0001\u0007\u0092\u0001\u00020\bø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u00063"}, d2 = {"Lkotlin/ULongArray;", "", "Lkotlin/ULong;", "size", "", "constructor-impl", "(I)[J", "storage", "", "([J)[J", "getSize-impl", "([J)I", "getStorage$annotations", "()V", "contains", "", "element", "contains-VKZWuLQ", "([JJ)Z", "containsAll", MessageKey.CUSTOM_LAYOUT_ELEMENTS, "containsAll-impl", "([JLjava/util/Collection;)Z", "equals", "other", "", "equals-impl", "([JLjava/lang/Object;)Z", "get", "index", "get-s-VKNKU", "([JI)J", TTDownloadField.TT_HASHCODE, "hashCode-impl", "isEmpty", "isEmpty-impl", "([J)Z", "iterator", "", "iterator-impl", "([J)Ljava/util/Iterator;", "set", "", "value", "set-k8EXiF4", "([JIJ)V", "toString", "", "toString-impl", "([J)Ljava/lang/String;", "Iterator", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
@h.k2.e
@s0(version = "1.3")
/* loaded from: classes3.dex */
public final class k1 implements Collection<j1>, h.k2.v.x0.a {
    @k.e.a.d
    private final long[] a;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\bH\u0096\u0002J\u0015\u0010\t\u001a\u00020\nH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\r"}, d2 = {"Lkotlin/ULongArray$Iterator;", "Lkotlin/collections/ULongIterator;", "array", "", "([J)V", "index", "", "hasNext", "", "nextULong", "Lkotlin/ULong;", "nextULong-s-VKNKU", "()J", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public static final class a extends h.a2.m1 {
        private int a;
        private final long[] b;

        public a(@k.e.a.d long[] jArr) {
            this.b = jArr;
        }

        @Override // h.a2.m1
        public long d() {
            int i2 = this.a;
            long[] jArr = this.b;
            if (i2 < jArr.length) {
                this.a = i2 + 1;
                return j1.i(jArr[i2]);
            }
            throw new NoSuchElementException(String.valueOf(this.a));
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a < this.b.length;
        }
    }

    @p0
    private /* synthetic */ k1(long[] jArr) {
        this.a = jArr;
    }

    public static final /* synthetic */ k1 d(long[] jArr) {
        return new k1(jArr);
    }

    @k.e.a.d
    public static long[] f(int i2) {
        return g(new long[i2]);
    }

    @p0
    @k.e.a.d
    public static long[] g(@k.e.a.d long[] jArr) {
        return jArr;
    }

    public static boolean i(long[] jArr, long j2) {
        return ArraysKt___ArraysKt.O7(jArr, j2);
    }

    public static boolean m(long[] jArr, @k.e.a.d Collection<j1> collection) {
        boolean z;
        if (!collection.isEmpty()) {
            for (Object obj : collection) {
                if ((obj instanceof j1) && ArraysKt___ArraysKt.O7(jArr, ((j1) obj).m0())) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (!z) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean p(long[] jArr, Object obj) {
        return (obj instanceof k1) && h.k2.v.f0.g(jArr, ((k1) obj).A());
    }

    public static final boolean q(long[] jArr, long[] jArr2) {
        return h.k2.v.f0.g(jArr, jArr2);
    }

    public static final long r(long[] jArr, int i2) {
        return j1.i(jArr[i2]);
    }

    public static int t(long[] jArr) {
        return jArr.length;
    }

    @p0
    public static /* synthetic */ void u() {
    }

    public static int v(long[] jArr) {
        if (jArr != null) {
            return Arrays.hashCode(jArr);
        }
        return 0;
    }

    public static boolean w(long[] jArr) {
        return jArr.length == 0;
    }

    @k.e.a.d
    public static Iterator<j1> x(long[] jArr) {
        return new a(jArr);
    }

    public static final void y(long[] jArr, int i2, long j2) {
        jArr[i2] = j2;
    }

    public static String z(long[] jArr) {
        return "ULongArray(storage=" + Arrays.toString(jArr) + ")";
    }

    public final /* synthetic */ long[] A() {
        return this.a;
    }

    public boolean a(long j2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public /* synthetic */ boolean add(j1 j1Var) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends j1> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof j1) {
            return h(((j1) obj).m0());
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(@k.e.a.d Collection<? extends Object> collection) {
        return m(this.a, collection);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return p(this.a, obj);
    }

    public boolean h(long j2) {
        return i(this.a, j2);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return v(this.a);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return w(this.a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    @k.e.a.d
    public Iterator<j1> iterator() {
        return x(this.a);
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

    public int s() {
        return t(this.a);
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return s();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return h.k2.v.t.a(this);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) h.k2.v.t.b(this, tArr);
    }

    public String toString() {
        return z(this.a);
    }
}
