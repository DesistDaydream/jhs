package h.o2;

import h.a2.m1;
import h.j1;
import h.s0;
import h.v1;
import java.util.NoSuchElementException;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B \u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\t\u0010\n\u001a\u00020\u000bH\u0096\u0002J\u0015\u0010\r\u001a\u00020\u0003H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\b\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\u00020\u0003X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\u0005\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\t\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0010"}, d2 = {"Lkotlin/ranges/ULongProgressionIterator;", "Lkotlin/collections/ULongIterator;", "first", "Lkotlin/ULong;", "last", "step", "", "(JJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "finalElement", "J", "hasNext", "", "next", "nextULong", "nextULong-s-VKNKU", "()J", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
@s0(version = "1.3")
/* loaded from: classes3.dex */
public final class v extends m1 {
    private final long a;
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private final long f14985c;

    /* renamed from: d  reason: collision with root package name */
    private long f14986d;

    private v(long j2, long j3, long j4) {
        this.a = j3;
        boolean z = true;
        int i2 = (j4 > 0L ? 1 : (j4 == 0L ? 0 : -1));
        int g2 = v1.g(j2, j3);
        if (i2 <= 0 ? g2 < 0 : g2 > 0) {
            z = false;
        }
        this.b = z;
        this.f14985c = j1.i(j4);
        this.f14986d = this.b ? j2 : j3;
    }

    @Override // h.a2.m1
    public long d() {
        long j2 = this.f14986d;
        if (j2 == this.a) {
            if (this.b) {
                this.b = false;
            } else {
                throw new NoSuchElementException();
            }
        } else {
            this.f14986d = j1.i(this.f14985c + j2);
        }
        return j2;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.b;
    }

    public /* synthetic */ v(long j2, long j3, long j4, h.k2.v.u uVar) {
        this(j2, j3, j4);
    }
}
