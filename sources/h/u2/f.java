package h.u2;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

@Metadata(k = 3, mv = {1, 5, 1})
/* loaded from: classes4.dex */
public final /* synthetic */ class f {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[TimeUnit.values().length];
        a = iArr;
        iArr[TimeUnit.NANOSECONDS.ordinal()] = 1;
        iArr[TimeUnit.MICROSECONDS.ordinal()] = 2;
        iArr[TimeUnit.MILLISECONDS.ordinal()] = 3;
        iArr[TimeUnit.SECONDS.ordinal()] = 4;
        iArr[TimeUnit.MINUTES.ordinal()] = 5;
        iArr[TimeUnit.HOURS.ordinal()] = 6;
        iArr[TimeUnit.DAYS.ordinal()] = 7;
    }
}
