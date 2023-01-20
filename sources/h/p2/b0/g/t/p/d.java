package h.p2.b0.g.t.p;

import com.tencent.android.tpush.common.MessageKey;
import com.umeng.analytics.pro.am;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
public class d<E> extends AbstractList<E> implements RandomAccess {
    private int a;
    private Object b;

    /* loaded from: classes3.dex */
    public static class b<T> implements Iterator<T> {
        private static final b a = new b();

        private b() {
        }

        public static <T> b<T> a() {
            return a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new IllegalStateException();
        }
    }

    /* loaded from: classes3.dex */
    public class c extends AbstractC0473d<E> {
        private final int b;

        public c() {
            super();
            this.b = ((AbstractList) d.this).modCount;
        }

        @Override // h.p2.b0.g.t.p.d.AbstractC0473d
        public void a() {
            if (((AbstractList) d.this).modCount == this.b) {
                return;
            }
            throw new ConcurrentModificationException("ModCount: " + ((AbstractList) d.this).modCount + "; expected: " + this.b);
        }

        @Override // h.p2.b0.g.t.p.d.AbstractC0473d
        public E b() {
            return (E) d.this.b;
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            d.this.clear();
        }
    }

    /* renamed from: h.p2.b0.g.t.p.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static abstract class AbstractC0473d<T> implements Iterator<T> {
        private boolean a;

        private AbstractC0473d() {
        }

        public abstract void a();

        public abstract T b();

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return !this.a;
        }

        @Override // java.util.Iterator
        public final T next() {
            if (!this.a) {
                this.a = true;
                a();
                return b();
            }
            throw new NoSuchElementException();
        }
    }

    private static /* synthetic */ void a(int i2) {
        String str = (i2 == 2 || i2 == 3 || i2 == 5 || i2 == 6 || i2 == 7) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 2 || i2 == 3 || i2 == 5 || i2 == 6 || i2 == 7) ? 2 : 3];
        switch (i2) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 7:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/utils/SmartList";
                break;
            case 4:
                objArr[0] = am.av;
                break;
            default:
                objArr[0] = MessageKey.CUSTOM_LAYOUT_ELEMENTS;
                break;
        }
        if (i2 == 2 || i2 == 3) {
            objArr[1] = "iterator";
        } else if (i2 == 5 || i2 == 6 || i2 == 7) {
            objArr[1] = "toArray";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/SmartList";
        }
        switch (i2) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 7:
                break;
            case 4:
                objArr[2] = "toArray";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        if (i2 != 2 && i2 != 3 && i2 != 5 && i2 != 6 && i2 != 7) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e2) {
        int i2 = this.a;
        if (i2 == 0) {
            this.b = e2;
        } else if (i2 == 1) {
            this.b = new Object[]{this.b, e2};
        } else {
            Object[] objArr = (Object[]) this.b;
            int length = objArr.length;
            if (i2 >= length) {
                int i3 = ((length * 3) / 2) + 1;
                int i4 = i2 + 1;
                if (i3 < i4) {
                    i3 = i4;
                }
                Object[] objArr2 = new Object[i3];
                this.b = objArr2;
                System.arraycopy(objArr, 0, objArr2, 0, length);
                objArr = objArr2;
            }
            objArr[this.a] = e2;
        }
        this.a++;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.b = null;
        this.a = 0;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i2) {
        int i3;
        if (i2 >= 0 && i2 < (i3 = this.a)) {
            if (i3 == 1) {
                return (E) this.b;
            }
            return (E) ((Object[]) this.b)[i2];
        }
        throw new IndexOutOfBoundsException("Index: " + i2 + ", Size: " + this.a);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    @k.e.a.d
    public Iterator<E> iterator() {
        int i2 = this.a;
        if (i2 == 0) {
            b a2 = b.a();
            if (a2 == null) {
                a(2);
            }
            return a2;
        } else if (i2 == 1) {
            return new c();
        } else {
            Iterator<E> it = super.iterator();
            if (it == null) {
                a(3);
            }
            return it;
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public E remove(int i2) {
        int i3;
        E e2;
        if (i2 >= 0 && i2 < (i3 = this.a)) {
            if (i3 == 1) {
                e2 = (E) this.b;
                this.b = null;
            } else {
                Object[] objArr = (Object[]) this.b;
                Object obj = objArr[i2];
                if (i3 == 2) {
                    this.b = objArr[1 - i2];
                } else {
                    int i4 = (i3 - i2) - 1;
                    if (i4 > 0) {
                        System.arraycopy(objArr, i2 + 1, objArr, i2, i4);
                    }
                    objArr[this.a - 1] = null;
                }
                e2 = (E) obj;
            }
            this.a--;
            ((AbstractList) this).modCount++;
            return e2;
        }
        throw new IndexOutOfBoundsException("Index: " + i2 + ", Size: " + this.a);
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int i2, E e2) {
        int i3;
        if (i2 < 0 || i2 >= (i3 = this.a)) {
            throw new IndexOutOfBoundsException("Index: " + i2 + ", Size: " + this.a);
        } else if (i3 == 1) {
            E e3 = (E) this.b;
            this.b = e2;
            return e3;
        } else {
            Object[] objArr = (Object[]) this.b;
            E e4 = (E) objArr[i2];
            objArr[i2] = e2;
            return e4;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    @k.e.a.d
    public <T> T[] toArray(@k.e.a.d T[] tArr) {
        if (tArr == 0) {
            a(4);
        }
        int length = tArr.length;
        int i2 = this.a;
        if (i2 == 1) {
            if (length != 0) {
                tArr[0] = this.b;
            } else {
                T[] tArr2 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), 1));
                tArr2[0] = this.b;
                if (tArr2 == 0) {
                    a(5);
                }
                return tArr2;
            }
        } else if (length < i2) {
            T[] tArr3 = (T[]) Arrays.copyOf((Object[]) this.b, i2, tArr.getClass());
            if (tArr3 == null) {
                a(6);
            }
            return tArr3;
        } else if (i2 != 0) {
            System.arraycopy(this.b, 0, tArr, 0, i2);
        }
        int i3 = this.a;
        if (length > i3) {
            tArr[i3] = 0;
        }
        if (tArr == 0) {
            a(7);
        }
        return tArr;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i2, E e2) {
        int i3;
        if (i2 >= 0 && i2 <= (i3 = this.a)) {
            if (i3 == 0) {
                this.b = e2;
            } else if (i3 == 1 && i2 == 0) {
                this.b = new Object[]{e2, this.b};
            } else {
                Object[] objArr = new Object[i3 + 1];
                if (i3 == 1) {
                    objArr[0] = this.b;
                } else {
                    Object[] objArr2 = (Object[]) this.b;
                    System.arraycopy(objArr2, 0, objArr, 0, i2);
                    System.arraycopy(objArr2, i2, objArr, i2 + 1, this.a - i2);
                }
                objArr[i2] = e2;
                this.b = objArr;
            }
            this.a++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("Index: " + i2 + ", Size: " + this.a);
    }
}
