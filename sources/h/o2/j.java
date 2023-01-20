package h.o2;

import h.a2.l0;
import java.util.NoSuchElementException;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\b\u001a\u00020\tH\u0096\u0002J\b\u0010\r\u001a\u00020\u0003H\u0016R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lkotlin/ranges/IntProgressionIterator;", "Lkotlin/collections/IntIterator;", "first", "", "last", "step", "(III)V", "finalElement", "hasNext", "", "next", "getStep", "()I", "nextInt", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class j extends l0 {
    private final int a;
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private int f14967c;

    /* renamed from: d  reason: collision with root package name */
    private final int f14968d;

    public j(int i2, int i3, int i4) {
        this.f14968d = i4;
        this.a = i3;
        boolean z = true;
        if (i4 <= 0 ? i2 < i3 : i2 > i3) {
            z = false;
        }
        this.b = z;
        this.f14967c = z ? i2 : i3;
    }

    public final int a() {
        return this.f14968d;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.b;
    }

    @Override // h.a2.l0
    public int nextInt() {
        int i2 = this.f14967c;
        if (i2 == this.a) {
            if (this.b) {
                this.b = false;
            } else {
                throw new NoSuchElementException();
            }
        } else {
            this.f14967c = this.f14968d + i2;
        }
        return i2;
    }
}
