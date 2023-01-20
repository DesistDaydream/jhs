package h.a2;

import kotlin.Metadata;
import kotlin.collections.State;

@Metadata(k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final /* synthetic */ class a {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[State.values().length];
        a = iArr;
        iArr[State.Done.ordinal()] = 1;
        iArr[State.Ready.ordinal()] = 2;
    }
}
