package h.k2.v;

import kotlin.Metadata;
import kotlin.reflect.KVariance;

@Metadata(k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final /* synthetic */ class u0 {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[KVariance.values().length];
        a = iArr;
        iArr[KVariance.INVARIANT.ordinal()] = 1;
        iArr[KVariance.IN.ordinal()] = 2;
        iArr[KVariance.OUT.ordinal()] = 3;
    }
}
