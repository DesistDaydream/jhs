package h.p2.b0.g;

import kotlin.Metadata;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;

@Metadata(k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final /* synthetic */ class f {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[KotlinClassHeader.Kind.values().length];
        a = iArr;
        iArr[KotlinClassHeader.Kind.FILE_FACADE.ordinal()] = 1;
        iArr[KotlinClassHeader.Kind.MULTIFILE_CLASS.ordinal()] = 2;
        iArr[KotlinClassHeader.Kind.MULTIFILE_CLASS_PART.ordinal()] = 3;
        iArr[KotlinClassHeader.Kind.SYNTHETIC_CLASS.ordinal()] = 4;
        iArr[KotlinClassHeader.Kind.UNKNOWN.ordinal()] = 5;
        iArr[KotlinClassHeader.Kind.CLASS.ordinal()] = 6;
    }
}
