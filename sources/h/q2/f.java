package h.q2;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B'\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0096\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lkotlin/sequences/DropWhileSequence;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/sequences/Sequence;", "sequence", "predicate", "Lkotlin/Function1;", "", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)V", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes4.dex */
public final class f<T> implements m<T> {
    private final m<T> a;
    private final h.k2.u.l<T, Boolean> b;

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\t\u0010\u0013\u001a\u00020\u0014H\u0096\u0002J\u000e\u0010\u0015\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u0004\u0018\u00018\u0000X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0016"}, d2 = {"kotlin/sequences/DropWhileSequence$iterator$1", "", "dropState", "", "getDropState", "()I", "setDropState", "(I)V", "iterator", "getIterator", "()Ljava/util/Iterator;", "nextItem", "getNextItem", "()Ljava/lang/Object;", "setNextItem", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "drop", "", "hasNext", "", "next", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes4.dex */
    public static final class a implements Iterator<T>, h.k2.v.x0.a {
        @k.e.a.d
        private final Iterator<T> a;
        private int b = -1;
        @k.e.a.e

        /* renamed from: c  reason: collision with root package name */
        private T f15648c;

        public a() {
            this.a = f.this.a.iterator();
        }

        private final void a() {
            while (this.a.hasNext()) {
                T next = this.a.next();
                if (!((Boolean) f.this.b.invoke(next)).booleanValue()) {
                    this.f15648c = next;
                    this.b = 1;
                    return;
                }
            }
            this.b = 0;
        }

        public final int d() {
            return this.b;
        }

        @k.e.a.d
        public final Iterator<T> f() {
            return this.a;
        }

        @k.e.a.e
        public final T g() {
            return this.f15648c;
        }

        public final void h(int i2) {
            this.b = i2;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.b == -1) {
                a();
            }
            return this.b == 1 || this.a.hasNext();
        }

        public final void i(@k.e.a.e T t) {
            this.f15648c = t;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.b == -1) {
                a();
            }
            if (this.b == 1) {
                T t = this.f15648c;
                this.f15648c = null;
                this.b = 0;
                return t;
            }
            return this.a.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(@k.e.a.d m<? extends T> mVar, @k.e.a.d h.k2.u.l<? super T, Boolean> lVar) {
        this.a = mVar;
        this.b = lVar;
    }

    @Override // h.q2.m
    @k.e.a.d
    public Iterator<T> iterator() {
        return new a();
    }
}
