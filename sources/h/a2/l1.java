package h.a2;

import java.util.Iterator;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0007\b'\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u0002H\u0086\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u0002H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\u0006ø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\t"}, d2 = {"Lkotlin/collections/UIntIterator;", "", "Lkotlin/UInt;", "()V", "next", "next-pVg5ArA", "()I", "nextUInt", "nextUInt-pVg5ArA", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
@h.i(level = DeprecationLevel.ERROR, message = "This class is not going to be stabilized and is to be removed soon.")
@h.s0(version = "1.3")
/* loaded from: classes3.dex */
public abstract class l1 implements Iterator<h.f1>, h.k2.v.x0.a {
    public final int a() {
        return d();
    }

    public abstract int d();

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ h.f1 next() {
        return h.f1.b(a());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
