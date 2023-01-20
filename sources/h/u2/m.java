package h.u2;

import h.s0;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

@j
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\bÁ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0014J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lkotlin/time/MonotonicTimeSource;", "Lkotlin/time/AbstractLongTimeSource;", "Lkotlin/time/TimeSource;", "()V", "read", "", "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
@s0(version = "1.3")
/* loaded from: classes4.dex */
public final class m extends b implements p {
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    public static final m f15710c = new m();

    private m() {
        super(TimeUnit.NANOSECONDS);
    }

    @Override // h.u2.b
    public long c() {
        return System.nanoTime();
    }

    @k.e.a.d
    public String toString() {
        return "TimeSource(System.nanoTime())";
    }
}
