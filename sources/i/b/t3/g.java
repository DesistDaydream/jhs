package i.b.t3;

import kotlin.Metadata;
import kotlinx.coroutines.channels.BufferOverflow;

@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final /* synthetic */ class g {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[BufferOverflow.values().length];
        a = iArr;
        iArr[BufferOverflow.SUSPEND.ordinal()] = 1;
        iArr[BufferOverflow.DROP_LATEST.ordinal()] = 2;
        iArr[BufferOverflow.DROP_OLDEST.ordinal()] = 3;
    }
}
