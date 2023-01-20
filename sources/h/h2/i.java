package h.h2;

import kotlin.Metadata;
import kotlin.io.FileWalkDirection;

@Metadata(k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final /* synthetic */ class i {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[FileWalkDirection.values().length];
        a = iArr;
        iArr[FileWalkDirection.TOP_DOWN.ordinal()] = 1;
        iArr[FileWalkDirection.BOTTOM_UP.ordinal()] = 2;
    }
}
