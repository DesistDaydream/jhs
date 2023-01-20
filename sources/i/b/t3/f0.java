package i.b.t3;

import kotlin.Metadata;
import kotlinx.coroutines.channels.TickerMode;

@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final /* synthetic */ class f0 {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[TickerMode.values().length];
        a = iArr;
        iArr[TickerMode.FIXED_PERIOD.ordinal()] = 1;
        iArr[TickerMode.FIXED_DELAY.ordinal()] = 2;
    }
}
