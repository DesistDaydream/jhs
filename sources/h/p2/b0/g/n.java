package h.p2.b0.g;

import kotlin.Metadata;
import kotlin.reflect.KParameter;

@Metadata(k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final /* synthetic */ class n {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[KParameter.Kind.values().length];
        a = iArr;
        iArr[KParameter.Kind.EXTENSION_RECEIVER.ordinal()] = 1;
        iArr[KParameter.Kind.INSTANCE.ordinal()] = 2;
        iArr[KParameter.Kind.VALUE.ordinal()] = 3;
    }
}
