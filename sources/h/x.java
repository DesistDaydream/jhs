package h;

import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;

@Metadata(k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final /* synthetic */ class x {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[LazyThreadSafetyMode.values().length];
        a = iArr;
        iArr[LazyThreadSafetyMode.SYNCHRONIZED.ordinal()] = 1;
        iArr[LazyThreadSafetyMode.PUBLICATION.ordinal()] = 2;
        iArr[LazyThreadSafetyMode.NONE.ordinal()] = 3;
    }
}
