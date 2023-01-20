package kotlin.jvm.internal;

import h.k2.v.r;
import h.p2.d;
import h.p2.h;
import h.s0;

/* loaded from: classes3.dex */
public class FunctionReferenceImpl extends FunctionReference {
    public FunctionReferenceImpl(int i2, h hVar, String str, String str2) {
        super(i2, CallableReference.NO_RECEIVER, ((r) hVar).d(), str, str2, !(hVar instanceof d) ? 1 : 0);
    }

    @s0(version = "1.4")
    public FunctionReferenceImpl(int i2, Class cls, String str, String str2, int i3) {
        super(i2, CallableReference.NO_RECEIVER, cls, str, str2, i3);
    }

    @s0(version = "1.4")
    public FunctionReferenceImpl(int i2, Object obj, Class cls, String str, String str2, int i3) {
        super(i2, obj, cls, str, str2, i3);
    }
}
