package i.b.v3;

import kotlin.Metadata;
import kotlinx.coroutines.flow.SharingCommand;

@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final /* synthetic */ class g {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[SharingCommand.values().length];
        a = iArr;
        iArr[SharingCommand.START.ordinal()] = 1;
        iArr[SharingCommand.STOP.ordinal()] = 2;
        iArr[SharingCommand.STOP_AND_RESET_REPLAY_CACHE.ordinal()] = 3;
    }
}
