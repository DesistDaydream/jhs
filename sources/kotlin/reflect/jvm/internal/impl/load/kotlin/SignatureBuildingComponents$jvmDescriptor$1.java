package kotlin.reflect.jvm.internal.impl.load.kotlin;

import h.k2.u.l;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class SignatureBuildingComponents$jvmDescriptor$1 extends Lambda implements l<String, CharSequence> {
    public static final SignatureBuildingComponents$jvmDescriptor$1 INSTANCE = new SignatureBuildingComponents$jvmDescriptor$1();

    public SignatureBuildingComponents$jvmDescriptor$1() {
        super(1);
    }

    @Override // h.k2.u.l
    @d
    public final CharSequence invoke(@d String str) {
        String c2;
        c2 = SignatureBuildingComponents.a.c(str);
        return c2;
    }
}
