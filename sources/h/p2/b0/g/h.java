package h.p2.b0.g;

import kotlin.Metadata;
import kotlin.reflect.jvm.internal.impl.types.Variance;

@Metadata(k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final /* synthetic */ class h {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[Variance.values().length];
        a = iArr;
        iArr[Variance.INVARIANT.ordinal()] = 1;
        iArr[Variance.IN_VARIANCE.ordinal()] = 2;
        iArr[Variance.OUT_VARIANCE.ordinal()] = 3;
    }
}
