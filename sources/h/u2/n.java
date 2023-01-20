package h.u2;

import h.s0;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

@j
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\f\u0010\nJ\b\u0010\r\u001a\u00020\u0004H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lkotlin/time/TestTimeSource;", "Lkotlin/time/AbstractLongTimeSource;", "()V", "reading", "", "overflow", "", "duration", "Lkotlin/time/Duration;", "overflow-LRDsOJo", "(J)V", "plusAssign", "plusAssign-LRDsOJo", "read", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
@s0(version = "1.3")
/* loaded from: classes4.dex */
public final class n extends b {

    /* renamed from: c  reason: collision with root package name */
    private long f15711c;

    public n() {
        super(TimeUnit.NANOSECONDS);
    }

    private final void d(long j2) {
        throw new IllegalStateException("TestTimeSource will overflow if its reading " + this.f15711c + "ns is advanced by " + d.D0(j2) + '.');
    }

    @Override // h.u2.b
    public long c() {
        return this.f15711c;
    }

    public final void e(long j2) {
        long j3;
        long A0 = d.A0(j2, b());
        if (A0 != Long.MIN_VALUE && A0 != Long.MAX_VALUE) {
            long j4 = this.f15711c;
            j3 = j4 + A0;
            if ((A0 ^ j4) >= 0 && (j4 ^ j3) < 0) {
                d(j2);
            }
        } else {
            double x0 = this.f15711c + d.x0(j2, b());
            if (x0 > Long.MAX_VALUE || x0 < Long.MIN_VALUE) {
                d(j2);
            }
            j3 = (long) x0;
        }
        this.f15711c = j3;
    }
}
