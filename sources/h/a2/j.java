package h.a2;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.android.tpush.common.MessageKey;
import h.t1;
import h.x1;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0007\u0018\u0000 P*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001PB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0007\b\u0016¢\u0006\u0002\u0010\u0006B\u0015\b\u0016\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0002\u0010\tJ\u0015\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016J\u001d\u0010\u0013\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0019J\u001e\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016J\u0016\u0010\u001a\u001a\u00020\u00142\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016J\u0013\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00028\u0000¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00028\u0000¢\u0006\u0002\u0010\u001cJ\b\u0010\u001e\u001a\u00020\u0017H\u0016J\u0016\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0016J\u001e\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0002J\u0010\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u0004H\u0002J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0010\u0010%\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u0004H\u0002J\u001d\u0010'\u001a\u00020\u00142\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00140)H\u0082\bJ\u000b\u0010*\u001a\u00028\u0000¢\u0006\u0002\u0010+J\r\u0010,\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010+J\u0016\u0010-\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u0004H\u0096\u0002¢\u0006\u0002\u0010.J\u0010\u0010/\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0015\u00100\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00101J\u0016\u00102\u001a\u00028\u00002\u0006\u0010!\u001a\u00020\u0004H\u0083\b¢\u0006\u0002\u0010.J\u0011\u0010!\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0083\bJM\u00103\u001a\u00020\u00172>\u00104\u001a:\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(\u000e\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b¢\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u001705H\u0000¢\u0006\u0002\b8J\b\u00109\u001a\u00020\u0014H\u0016J\u000b\u0010:\u001a\u00028\u0000¢\u0006\u0002\u0010+J\u0015\u0010;\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00101J\r\u0010<\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010+J\u0010\u0010=\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0010\u0010>\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0015\u0010?\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016J\u0016\u0010@\u001a\u00020\u00142\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016J\u0015\u0010A\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0002\u0010.J\u000b\u0010B\u001a\u00028\u0000¢\u0006\u0002\u0010+J\r\u0010C\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010+J\u000b\u0010D\u001a\u00028\u0000¢\u0006\u0002\u0010+J\r\u0010E\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010+J\u0016\u0010F\u001a\u00020\u00142\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016J\u001e\u0010G\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010HJ\u0017\u0010I\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bH\u0000¢\u0006\u0004\bJ\u0010KJ)\u0010I\u001a\b\u0012\u0004\u0012\u0002HL0\u000b\"\u0004\b\u0001\u0010L2\f\u0010M\u001a\b\u0012\u0004\u0012\u0002HL0\u000bH\u0000¢\u0006\u0004\bJ\u0010NJ\u0015\u0010O\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bH\u0016¢\u0006\u0002\u0010KJ'\u0010O\u001a\b\u0012\u0004\u0012\u0002HL0\u000b\"\u0004\b\u0001\u0010L2\f\u0010M\u001a\b\u0012\u0004\u0012\u0002HL0\u000bH\u0016¢\u0006\u0002\u0010NR\u0018\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006Q"}, d2 = {"Lkotlin/collections/ArrayDeque;", ExifInterface.LONGITUDE_EAST, "Lkotlin/collections/AbstractMutableList;", "initialCapacity", "", "(I)V", "()V", MessageKey.CUSTOM_LAYOUT_ELEMENTS, "", "(Ljava/util/Collection;)V", "elementData", "", "", "[Ljava/lang/Object;", "head", "<set-?>", "size", "getSize", "()I", "add", "", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "addFirst", "(Ljava/lang/Object;)V", "addLast", "clear", "contains", "copyCollectionElements", "internalIndex", "copyElements", "newCapacity", "decremented", "ensureCapacity", "minCapacity", "filterInPlace", "predicate", "Lkotlin/Function1;", "first", "()Ljava/lang/Object;", "firstOrNull", "get", "(I)Ljava/lang/Object;", "incremented", "indexOf", "(Ljava/lang/Object;)I", "internalGet", "internalStructure", "structure", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "internalStructure$kotlin_stdlib", "isEmpty", "last", "lastIndexOf", "lastOrNull", "negativeMod", "positiveMod", "remove", "removeAll", "removeAt", "removeFirst", "removeFirstOrNull", "removeLast", "removeLastOrNull", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "testToArray", "testToArray$kotlin_stdlib", "()[Ljava/lang/Object;", ExifInterface.GPS_DIRECTION_TRUE, "array", "([Ljava/lang/Object;)[Ljava/lang/Object;", "toArray", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
@h.s0(version = "1.4")
@x1(markerClass = {h.o.class})
/* loaded from: classes3.dex */
public final class j<E> extends e<E> {

    /* renamed from: e  reason: collision with root package name */
    private static final int f14829e = 2147483639;

    /* renamed from: f  reason: collision with root package name */
    private static final int f14830f = 10;
    private int a;
    private Object[] b;

    /* renamed from: c  reason: collision with root package name */
    private int f14832c;
    @k.e.a.d

    /* renamed from: g  reason: collision with root package name */
    public static final a f14831g = new a(null);

    /* renamed from: d  reason: collision with root package name */
    private static final Object[] f14828d = new Object[0];

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0007\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0018\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkotlin/collections/ArrayDeque$Companion;", "", "()V", "defaultMinCapacity", "", "emptyElementData", "", "[Ljava/lang/Object;", "maxArraySize", "newCapacity", "oldCapacity", "minCapacity", "newCapacity$kotlin_stdlib", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public final int a(int i2, int i3) {
            int i4 = i2 + (i2 >> 1);
            if (i4 - i3 < 0) {
                i4 = i3;
            }
            if (i4 - j.f14829e > 0) {
                if (i3 > j.f14829e) {
                    return Integer.MAX_VALUE;
                }
                return j.f14829e;
            }
            return i4;
        }

        public /* synthetic */ a(h.k2.v.u uVar) {
            this();
        }
    }

    public j(int i2) {
        Object[] objArr;
        if (i2 == 0) {
            objArr = f14828d;
        } else if (i2 > 0) {
            objArr = new Object[i2];
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + i2);
        }
        this.b = objArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int C(int i2) {
        if (i2 == ArraysKt___ArraysKt.Td(this.b)) {
            return 0;
        }
        return i2 + 1;
    }

    @h.g2.f
    private final E D(int i2) {
        return (E) this.b[i2];
    }

    @h.g2.f
    private final int E(int i2) {
        return J(this.a + i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int I(int i2) {
        return i2 < 0 ? i2 + this.b.length : i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int J(int i2) {
        Object[] objArr = this.b;
        return i2 >= objArr.length ? i2 - objArr.length : i2;
    }

    private final void v(int i2, Collection<? extends E> collection) {
        Iterator<? extends E> it = collection.iterator();
        int length = this.b.length;
        while (i2 < length && it.hasNext()) {
            this.b[i2] = it.next();
            i2++;
        }
        int i3 = this.a;
        for (int i4 = 0; i4 < i3 && it.hasNext(); i4++) {
            this.b[i4] = it.next();
        }
        this.f14832c = size() + collection.size();
    }

    private final void w(int i2) {
        Object[] objArr = new Object[i2];
        Object[] objArr2 = this.b;
        n.c1(objArr2, objArr, 0, this.a, objArr2.length);
        Object[] objArr3 = this.b;
        int length = objArr3.length;
        int i3 = this.a;
        n.c1(objArr3, objArr, length - i3, 0, i3);
        this.a = 0;
        this.b = objArr;
    }

    private final int x(int i2) {
        return i2 == 0 ? ArraysKt___ArraysKt.Td(this.b) : i2 - 1;
    }

    private final void y(int i2) {
        if (i2 >= 0) {
            Object[] objArr = this.b;
            if (i2 <= objArr.length) {
                return;
            }
            if (objArr == f14828d) {
                this.b = new Object[h.o2.q.n(i2, 10)];
                return;
            } else {
                w(f14831g.a(objArr.length, i2));
                return;
            }
        }
        throw new IllegalStateException("Deque is too big.");
    }

    private final boolean z(h.k2.u.l<? super E, Boolean> lVar) {
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty()) {
            if (!(this.b.length == 0)) {
                int J = J(this.a + size());
                int i2 = this.a;
                if (this.a < J) {
                    for (int i3 = this.a; i3 < J; i3++) {
                        Object obj = this.b[i3];
                        if (lVar.invoke(obj).booleanValue()) {
                            this.b[i2] = obj;
                            i2++;
                        } else {
                            z = true;
                        }
                    }
                    n.n2(this.b, null, i2, J);
                } else {
                    int length = this.b.length;
                    boolean z2 = false;
                    for (int i4 = this.a; i4 < length; i4++) {
                        Object obj2 = this.b[i4];
                        this.b[i4] = null;
                        if (lVar.invoke(obj2).booleanValue()) {
                            this.b[i2] = obj2;
                            i2++;
                        } else {
                            z2 = true;
                        }
                    }
                    i2 = J(i2);
                    for (int i5 = 0; i5 < J; i5++) {
                        Object obj3 = this.b[i5];
                        this.b[i5] = null;
                        if (lVar.invoke(obj3).booleanValue()) {
                            this.b[i2] = obj3;
                            i2 = C(i2);
                        } else {
                            z2 = true;
                        }
                    }
                    z = z2;
                }
                if (z) {
                    this.f14832c = I(i2 - this.a);
                }
            }
        }
        return z;
    }

    public final E A() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        return (E) this.b[this.a];
    }

    @k.e.a.e
    public final E B() {
        if (isEmpty()) {
            return null;
        }
        return (E) this.b[this.a];
    }

    public final void F(@k.e.a.d h.k2.u.p<? super Integer, ? super Object[], t1> pVar) {
        int i2;
        pVar.invoke(Integer.valueOf((isEmpty() || (i2 = this.a) < J(this.a + size())) ? this.a : i2 - this.b.length), toArray());
    }

    public final E G() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        return (E) this.b[J(this.a + CollectionsKt__CollectionsKt.G(this))];
    }

    @k.e.a.e
    public final E H() {
        if (isEmpty()) {
            return null;
        }
        return (E) this.b[J(this.a + CollectionsKt__CollectionsKt.G(this))];
    }

    public final E K() {
        if (!isEmpty()) {
            E e2 = (E) this.b[this.a];
            Object[] objArr = this.b;
            int i2 = this.a;
            objArr[i2] = null;
            this.a = C(i2);
            this.f14832c = size() - 1;
            return e2;
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    @k.e.a.e
    public final E L() {
        if (isEmpty()) {
            return null;
        }
        return K();
    }

    public final E M() {
        if (!isEmpty()) {
            int J = J(this.a + CollectionsKt__CollectionsKt.G(this));
            E e2 = (E) this.b[J];
            this.b[J] = null;
            this.f14832c = size() - 1;
            return e2;
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    @k.e.a.e
    public final E N() {
        if (isEmpty()) {
            return null;
        }
        return M();
    }

    @k.e.a.d
    public final Object[] O() {
        return toArray();
    }

    @k.e.a.d
    public final <T> T[] P(@k.e.a.d T[] tArr) {
        return (T[]) toArray(tArr);
    }

    @Override // h.a2.e
    public int a() {
        return this.f14832c;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e2) {
        u(e2);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(@k.e.a.d Collection<? extends E> collection) {
        if (collection.isEmpty()) {
            return false;
        }
        y(size() + collection.size());
        v(J(this.a + size()), collection);
        return true;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        int J = J(this.a + size());
        int i2 = this.a;
        if (i2 < J) {
            n.n2(this.b, null, i2, J);
        } else if (!isEmpty()) {
            Object[] objArr = this.b;
            n.n2(objArr, null, this.a, objArr.length);
            n.n2(this.b, null, 0, J);
        }
        this.a = 0;
        this.f14832c = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // h.a2.e
    public E d(int i2) {
        c.a.b(i2, size());
        if (i2 == CollectionsKt__CollectionsKt.G(this)) {
            return M();
        }
        if (i2 != 0) {
            int J = J(this.a + i2);
            E e2 = (E) this.b[J];
            if (i2 < (size() >> 1)) {
                int i3 = this.a;
                if (J >= i3) {
                    Object[] objArr = this.b;
                    n.c1(objArr, objArr, i3 + 1, i3, J);
                } else {
                    Object[] objArr2 = this.b;
                    n.c1(objArr2, objArr2, 1, 0, J);
                    Object[] objArr3 = this.b;
                    objArr3[0] = objArr3[objArr3.length - 1];
                    int i4 = this.a;
                    n.c1(objArr3, objArr3, i4 + 1, i4, objArr3.length - 1);
                }
                Object[] objArr4 = this.b;
                int i5 = this.a;
                objArr4[i5] = null;
                this.a = C(i5);
            } else {
                int J2 = J(this.a + CollectionsKt__CollectionsKt.G(this));
                if (J <= J2) {
                    Object[] objArr5 = this.b;
                    n.c1(objArr5, objArr5, J, J + 1, J2 + 1);
                } else {
                    Object[] objArr6 = this.b;
                    n.c1(objArr6, objArr6, J, J + 1, objArr6.length);
                    Object[] objArr7 = this.b;
                    objArr7[objArr7.length - 1] = objArr7[0];
                    n.c1(objArr7, objArr7, 0, 1, J2 + 1);
                }
                this.b[J2] = null;
            }
            this.f14832c = size() - 1;
            return e2;
        }
        return K();
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i2) {
        c.a.b(i2, size());
        return (E) this.b[J(this.a + i2)];
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        int i2;
        int J = J(this.a + size());
        int i3 = this.a;
        if (i3 < J) {
            while (i3 < J) {
                if (h.k2.v.f0.g(obj, this.b[i3])) {
                    i2 = this.a;
                } else {
                    i3++;
                }
            }
            return -1;
        } else if (i3 < J) {
            return -1;
        } else {
            int length = this.b.length;
            while (true) {
                if (i3 >= length) {
                    for (int i4 = 0; i4 < J; i4++) {
                        if (h.k2.v.f0.g(obj, this.b[i4])) {
                            i3 = i4 + this.b.length;
                            i2 = this.a;
                        }
                    }
                    return -1;
                } else if (h.k2.v.f0.g(obj, this.b[i3])) {
                    i2 = this.a;
                    break;
                } else {
                    i3++;
                }
            }
        }
        return i3 - i2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        int Td;
        int i2;
        int J = J(this.a + size());
        int i3 = this.a;
        if (i3 < J) {
            Td = J - 1;
            if (Td < i3) {
                return -1;
            }
            while (!h.k2.v.f0.g(obj, this.b[Td])) {
                if (Td == i3) {
                    return -1;
                }
                Td--;
            }
            i2 = this.a;
        } else if (i3 <= J) {
            return -1;
        } else {
            int i4 = J - 1;
            while (true) {
                if (i4 >= 0) {
                    if (h.k2.v.f0.g(obj, this.b[i4])) {
                        Td = i4 + this.b.length;
                        i2 = this.a;
                        break;
                    }
                    i4--;
                } else {
                    Td = ArraysKt___ArraysKt.Td(this.b);
                    int i5 = this.a;
                    if (Td < i5) {
                        return -1;
                    }
                    while (!h.k2.v.f0.g(obj, this.b[Td])) {
                        if (Td == i5) {
                            return -1;
                        }
                        Td--;
                    }
                    i2 = this.a;
                }
            }
        }
        return Td - i2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return false;
        }
        remove(indexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(@k.e.a.d Collection<? extends Object> collection) {
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty()) {
            if (!(this.b.length == 0)) {
                int J = J(this.a + size());
                int i2 = this.a;
                if (this.a < J) {
                    for (int i3 = this.a; i3 < J; i3++) {
                        Object obj = this.b[i3];
                        if (!collection.contains(obj)) {
                            this.b[i2] = obj;
                            i2++;
                        } else {
                            z = true;
                        }
                    }
                    n.n2(this.b, null, i2, J);
                } else {
                    int length = this.b.length;
                    boolean z2 = false;
                    for (int i4 = this.a; i4 < length; i4++) {
                        Object obj2 = this.b[i4];
                        this.b[i4] = null;
                        if (!collection.contains(obj2)) {
                            this.b[i2] = obj2;
                            i2++;
                        } else {
                            z2 = true;
                        }
                    }
                    i2 = J(i2);
                    for (int i5 = 0; i5 < J; i5++) {
                        Object obj3 = this.b[i5];
                        this.b[i5] = null;
                        if (!collection.contains(obj3)) {
                            this.b[i2] = obj3;
                            i2 = C(i2);
                        } else {
                            z2 = true;
                        }
                    }
                    z = z2;
                }
                if (z) {
                    this.f14832c = I(i2 - this.a);
                }
            }
        }
        return z;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(@k.e.a.d Collection<? extends Object> collection) {
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty()) {
            if (!(this.b.length == 0)) {
                int J = J(this.a + size());
                int i2 = this.a;
                if (this.a < J) {
                    for (int i3 = this.a; i3 < J; i3++) {
                        Object obj = this.b[i3];
                        if (collection.contains(obj)) {
                            this.b[i2] = obj;
                            i2++;
                        } else {
                            z = true;
                        }
                    }
                    n.n2(this.b, null, i2, J);
                } else {
                    int length = this.b.length;
                    boolean z2 = false;
                    for (int i4 = this.a; i4 < length; i4++) {
                        Object obj2 = this.b[i4];
                        this.b[i4] = null;
                        if (collection.contains(obj2)) {
                            this.b[i2] = obj2;
                            i2++;
                        } else {
                            z2 = true;
                        }
                    }
                    i2 = J(i2);
                    for (int i5 = 0; i5 < J; i5++) {
                        Object obj3 = this.b[i5];
                        this.b[i5] = null;
                        if (collection.contains(obj3)) {
                            this.b[i2] = obj3;
                            i2 = C(i2);
                        } else {
                            z2 = true;
                        }
                    }
                    z = z2;
                }
                if (z) {
                    this.f14832c = I(i2 - this.a);
                }
            }
        }
        return z;
    }

    @Override // h.a2.e, java.util.AbstractList, java.util.List
    public E set(int i2, E e2) {
        c.a.b(i2, size());
        int J = J(this.a + i2);
        E e3 = (E) this.b[J];
        this.b[J] = e2;
        return e3;
    }

    public final void t(E e2) {
        y(size() + 1);
        int x = x(this.a);
        this.a = x;
        this.b[x] = e2;
        this.f14832c = size() + 1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    @k.e.a.d
    public <T> T[] toArray(@k.e.a.d T[] tArr) {
        if (tArr.length < size()) {
            tArr = (T[]) l.a(tArr, size());
        }
        Objects.requireNonNull(tArr, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        int J = J(this.a + size());
        int i2 = this.a;
        if (i2 < J) {
            n.l1(this.b, tArr, 0, i2, J, 2, null);
        } else if (!isEmpty()) {
            Object[] objArr = this.b;
            n.c1(objArr, tArr, 0, this.a, objArr.length);
            Object[] objArr2 = this.b;
            n.c1(objArr2, tArr, objArr2.length - this.a, 0, J);
        }
        if (tArr.length > size()) {
            tArr[size()] = null;
        }
        Objects.requireNonNull(tArr, "null cannot be cast to non-null type kotlin.Array<T>");
        return tArr;
    }

    public final void u(E e2) {
        y(size() + 1);
        this.b[J(this.a + size())] = e2;
        this.f14832c = size() + 1;
    }

    @Override // h.a2.e, java.util.AbstractList, java.util.List
    public void add(int i2, E e2) {
        c.a.c(i2, size());
        if (i2 == size()) {
            u(e2);
        } else if (i2 == 0) {
            t(e2);
        } else {
            y(size() + 1);
            int J = J(this.a + i2);
            if (i2 < ((size() + 1) >> 1)) {
                int x = x(J);
                int x2 = x(this.a);
                int i3 = this.a;
                if (x >= i3) {
                    Object[] objArr = this.b;
                    objArr[x2] = objArr[i3];
                    n.c1(objArr, objArr, i3, i3 + 1, x + 1);
                } else {
                    Object[] objArr2 = this.b;
                    n.c1(objArr2, objArr2, i3 - 1, i3, objArr2.length);
                    Object[] objArr3 = this.b;
                    objArr3[objArr3.length - 1] = objArr3[0];
                    n.c1(objArr3, objArr3, 0, 1, x + 1);
                }
                this.b[x] = e2;
                this.a = x2;
            } else {
                int J2 = J(this.a + size());
                if (J < J2) {
                    Object[] objArr4 = this.b;
                    n.c1(objArr4, objArr4, J + 1, J, J2);
                } else {
                    Object[] objArr5 = this.b;
                    n.c1(objArr5, objArr5, 1, 0, J2);
                    Object[] objArr6 = this.b;
                    objArr6[0] = objArr6[objArr6.length - 1];
                    n.c1(objArr6, objArr6, J + 1, J, objArr6.length - 1);
                }
                this.b[J] = e2;
            }
            this.f14832c = size() + 1;
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i2, @k.e.a.d Collection<? extends E> collection) {
        c.a.c(i2, size());
        if (collection.isEmpty()) {
            return false;
        }
        if (i2 == size()) {
            return addAll(collection);
        }
        y(size() + collection.size());
        int J = J(this.a + size());
        int J2 = J(this.a + i2);
        int size = collection.size();
        if (i2 < ((size() + 1) >> 1)) {
            int i3 = this.a;
            int i4 = i3 - size;
            if (J2 < i3) {
                Object[] objArr = this.b;
                n.c1(objArr, objArr, i4, i3, objArr.length);
                if (size >= J2) {
                    Object[] objArr2 = this.b;
                    n.c1(objArr2, objArr2, objArr2.length - size, 0, J2);
                } else {
                    Object[] objArr3 = this.b;
                    n.c1(objArr3, objArr3, objArr3.length - size, 0, size);
                    Object[] objArr4 = this.b;
                    n.c1(objArr4, objArr4, 0, size, J2);
                }
            } else if (i4 >= 0) {
                Object[] objArr5 = this.b;
                n.c1(objArr5, objArr5, i4, i3, J2);
            } else {
                Object[] objArr6 = this.b;
                i4 += objArr6.length;
                int i5 = J2 - i3;
                int length = objArr6.length - i4;
                if (length >= i5) {
                    n.c1(objArr6, objArr6, i4, i3, J2);
                } else {
                    n.c1(objArr6, objArr6, i4, i3, i3 + length);
                    Object[] objArr7 = this.b;
                    n.c1(objArr7, objArr7, 0, this.a + length, J2);
                }
            }
            this.a = i4;
            v(I(J2 - size), collection);
        } else {
            int i6 = J2 + size;
            if (J2 < J) {
                int i7 = size + J;
                Object[] objArr8 = this.b;
                if (i7 <= objArr8.length) {
                    n.c1(objArr8, objArr8, i6, J2, J);
                } else if (i6 >= objArr8.length) {
                    n.c1(objArr8, objArr8, i6 - objArr8.length, J2, J);
                } else {
                    int length2 = J - (i7 - objArr8.length);
                    n.c1(objArr8, objArr8, 0, length2, J);
                    Object[] objArr9 = this.b;
                    n.c1(objArr9, objArr9, i6, J2, length2);
                }
            } else {
                Object[] objArr10 = this.b;
                n.c1(objArr10, objArr10, size, 0, J);
                Object[] objArr11 = this.b;
                if (i6 >= objArr11.length) {
                    n.c1(objArr11, objArr11, i6 - objArr11.length, J2, objArr11.length);
                } else {
                    n.c1(objArr11, objArr11, 0, objArr11.length - size, objArr11.length);
                    Object[] objArr12 = this.b;
                    n.c1(objArr12, objArr12, i6, J2, objArr12.length - size);
                }
            }
            v(J2, collection);
        }
        return true;
    }

    public j() {
        this.b = f14828d;
    }

    public j(@k.e.a.d Collection<? extends E> collection) {
        Object[] array = collection.toArray(new Object[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        this.b = array;
        this.f14832c = array.length;
        if (array.length == 0) {
            this.b = f14828d;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    @k.e.a.d
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
