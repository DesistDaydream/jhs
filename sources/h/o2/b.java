package h.o2;

import h.k2.v.f0;
import java.util.NoSuchElementException;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\t\u001a\u00020\nH\u0096\u0002J\b\u0010\u000e\u001a\u00020\u0003H\u0016R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lkotlin/ranges/CharProgressionIterator;", "Lkotlin/collections/CharIterator;", "first", "", "last", "step", "", "(CCI)V", "finalElement", "hasNext", "", "next", "getStep", "()I", "nextChar", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class b extends h.a2.r {
    private final int a;
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private int f14961c;

    /* renamed from: d  reason: collision with root package name */
    private final int f14962d;

    public b(char c2, char c3, int i2) {
        this.f14962d = i2;
        this.a = c3;
        boolean z = true;
        if (i2 <= 0 ? f0.t(c2, c3) < 0 : f0.t(c2, c3) > 0) {
            z = false;
        }
        this.b = z;
        this.f14961c = z ? c2 : c3;
    }

    @Override // h.a2.r
    public char d() {
        int i2 = this.f14961c;
        if (i2 == this.a) {
            if (this.b) {
                this.b = false;
            } else {
                throw new NoSuchElementException();
            }
        } else {
            this.f14961c = this.f14962d + i2;
        }
        return (char) i2;
    }

    public final int f() {
        return this.f14962d;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.b;
    }
}
