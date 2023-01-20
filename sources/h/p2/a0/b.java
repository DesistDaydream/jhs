package h.p2.a0;

import kotlin.Metadata;
import kotlin.reflect.KVariance;

@Metadata(k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final /* synthetic */ class b {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[KVariance.values().length];
        a = iArr;
        iArr[KVariance.INVARIANT.ordinal()] = 1;
        iArr[KVariance.IN.ordinal()] = 2;
        iArr[KVariance.OUT.ordinal()] = 3;
    }
}
