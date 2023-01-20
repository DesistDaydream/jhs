package h.p2.b0.g.t.n.g1;

import kotlin.NoWhenBranchMatchedException;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;

/* loaded from: classes3.dex */
public final class q {

    /* loaded from: classes3.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Variance.values().length];
            iArr[Variance.INVARIANT.ordinal()] = 1;
            iArr[Variance.IN_VARIANCE.ordinal()] = 2;
            iArr[Variance.OUT_VARIANCE.ordinal()] = 3;
            a = iArr;
        }
    }

    @k.e.a.d
    public static final TypeVariance a(@k.e.a.d Variance variance) {
        int i2 = a.a[variance.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    return TypeVariance.OUT;
                }
                throw new NoWhenBranchMatchedException();
            }
            return TypeVariance.IN;
        }
        return TypeVariance.INV;
    }
}
