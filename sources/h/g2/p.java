package h.g2;

import com.tencent.android.tpush.common.MessageKey;
import com.umeng.analytics.pro.am;
import h.f1;
import h.j1;
import h.p0;
import h.s0;
import h.v1;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a*\u0010\u0000\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0007H\u0002ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a*\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000eH\u0001ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0006\u001a*\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0010H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"differenceModulo", "Lkotlin/UInt;", am.av, "b", "c", "differenceModulo-WZ9TVnA", "(III)I", "Lkotlin/ULong;", "differenceModulo-sambcqE", "(JJJ)J", "getProgressionLastElement", MessageKey.MSG_ACCEPT_TIME_START, MessageKey.MSG_ACCEPT_TIME_END, "step", "", "getProgressionLastElement-Nkh28Cs", "", "getProgressionLastElement-7ftBX0g", "kotlin-stdlib"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class p {
    private static final int a(int i2, int i3, int i4) {
        int e2 = v1.e(i2, i4);
        int e3 = v1.e(i3, i4);
        int c2 = v1.c(e2, e3);
        int i5 = f1.i(e2 - e3);
        return c2 >= 0 ? i5 : f1.i(i5 + i4);
    }

    private static final long b(long j2, long j3, long j4) {
        long i2 = v1.i(j2, j4);
        long i3 = v1.i(j3, j4);
        int g2 = v1.g(i2, i3);
        long i4 = j1.i(i2 - i3);
        return g2 >= 0 ? i4 : j1.i(i4 + j4);
    }

    @p0
    @s0(version = "1.3")
    public static final long c(long j2, long j3, long j4) {
        int i2 = (j4 > 0L ? 1 : (j4 == 0L ? 0 : -1));
        if (i2 > 0) {
            return v1.g(j2, j3) >= 0 ? j3 : j1.i(j3 - b(j3, j2, j1.i(j4)));
        } else if (i2 < 0) {
            return v1.g(j2, j3) <= 0 ? j3 : j1.i(j3 + b(j2, j3, j1.i(-j4)));
        } else {
            throw new IllegalArgumentException("Step is zero.");
        }
    }

    @p0
    @s0(version = "1.3")
    public static final int d(int i2, int i3, int i4) {
        if (i4 > 0) {
            return v1.c(i2, i3) >= 0 ? i3 : f1.i(i3 - a(i3, i2, f1.i(i4)));
        } else if (i4 < 0) {
            return v1.c(i2, i3) <= 0 ? i3 : f1.i(i3 + a(i2, i3, f1.i(-i4)));
        } else {
            throw new IllegalArgumentException("Step is zero.");
        }
    }
}
