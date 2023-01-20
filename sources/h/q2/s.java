package h.q2;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.sequences.SequencesKt__SequencesKt;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010(\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B#\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\r\u001a\u00020\u0006H\u0016J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0096\u0002J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\r\u001a\u00020\u0006H\u0016R\u0014\u0010\t\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lkotlin/sequences/SubSequence;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/sequences/Sequence;", "Lkotlin/sequences/DropTakeSequence;", "sequence", "startIndex", "", "endIndex", "(Lkotlin/sequences/Sequence;II)V", "count", "getCount", "()I", "drop", "n", "iterator", "", "take", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes4.dex */
public final class s<T> implements m<T>, e<T> {
    private final m<T> a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final int f15665c;

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0010(\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u000b\u001a\u00020\fH\u0002J\t\u0010\r\u001a\u00020\u000eH\u0096\u0002J\u000e\u0010\u000f\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0010R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"kotlin/sequences/SubSequence$iterator$1", "", "iterator", "getIterator", "()Ljava/util/Iterator;", "position", "", "getPosition", "()I", "setPosition", "(I)V", "drop", "", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes4.dex */
    public static final class a implements Iterator<T>, h.k2.v.x0.a {
        @k.e.a.d
        private final Iterator<T> a;
        private int b;

        public a() {
            this.a = s.this.a.iterator();
        }

        private final void a() {
            while (this.b < s.this.b && this.a.hasNext()) {
                this.a.next();
                this.b++;
            }
        }

        @k.e.a.d
        public final Iterator<T> d() {
            return this.a;
        }

        public final int f() {
            return this.b;
        }

        public final void g(int i2) {
            this.b = i2;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            return this.b < s.this.f15665c && this.a.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            a();
            if (this.b < s.this.f15665c) {
                this.b++;
                return this.a.next();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public s(@k.e.a.d m<? extends T> mVar, int i2, int i3) {
        this.a = mVar;
        this.b = i2;
        this.f15665c = i3;
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("startIndex should be non-negative, but is " + i2).toString());
        }
        if (!(i3 >= 0)) {
            throw new IllegalArgumentException(("endIndex should be non-negative, but is " + i3).toString());
        }
        if (i3 >= i2) {
            return;
        }
        throw new IllegalArgumentException(("endIndex should be not less than startIndex, but was " + i3 + " < " + i2).toString());
    }

    private final int f() {
        return this.f15665c - this.b;
    }

    @Override // h.q2.e
    @k.e.a.d
    public m<T> a(int i2) {
        return i2 >= f() ? SequencesKt__SequencesKt.j() : new s(this.a, this.b + i2, this.f15665c);
    }

    @Override // h.q2.e
    @k.e.a.d
    public m<T> b(int i2) {
        if (i2 >= f()) {
            return this;
        }
        m<T> mVar = this.a;
        int i3 = this.b;
        return new s(mVar, i3, i2 + i3);
    }

    @Override // h.q2.m
    @k.e.a.d
    public Iterator<T> iterator() {
        return new a();
    }
}
