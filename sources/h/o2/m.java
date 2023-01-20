package h.o2;

import h.a2.m0;
import java.util.NoSuchElementException;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\b\u001a\u00020\tH\u0096\u0002J\b\u0010\r\u001a\u00020\u0003H\u0016R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lkotlin/ranges/LongProgressionIterator;", "Lkotlin/collections/LongIterator;", "first", "", "last", "step", "(JJJ)V", "finalElement", "hasNext", "", "next", "getStep", "()J", "nextLong", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class m extends m0 {
    private final long a;
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private long f14973c;

    /* renamed from: d  reason: collision with root package name */
    private final long f14974d;

    public m(long j2, long j3, long j4) {
        this.f14974d = j4;
        this.a = j3;
        boolean z = true;
        int i2 = (j4 > 0L ? 1 : (j4 == 0L ? 0 : -1));
        int i3 = (j2 > j3 ? 1 : (j2 == j3 ? 0 : -1));
        if (i2 <= 0 ? i3 < 0 : i3 > 0) {
            z = false;
        }
        this.b = z;
        this.f14973c = z ? j2 : j3;
    }

    public final long a() {
        return this.f14974d;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.b;
    }

    @Override // h.a2.m0
    public long nextLong() {
        long j2 = this.f14973c;
        if (j2 == this.a) {
            if (this.b) {
                this.b = false;
            } else {
                throw new NoSuchElementException();
            }
        } else {
            this.f14973c = this.f14974d + j2;
        }
        return j2;
    }
}
