package kotlin.jvm.internal;

import h.k2.v.r;
import h.p2.d;
import h.p2.h;
import h.s0;

/* loaded from: classes3.dex */
public class PropertyReference1Impl extends PropertyReference1 {
    public PropertyReference1Impl(h hVar, String str, String str2) {
        super(CallableReference.NO_RECEIVER, ((r) hVar).d(), str, str2, !(hVar instanceof d) ? 1 : 0);
    }

    @Override // h.p2.p
    public Object get(Object obj) {
        return getGetter().call(obj);
    }

    @s0(version = "1.4")
    public PropertyReference1Impl(Class cls, String str, String str2, int i2) {
        super(CallableReference.NO_RECEIVER, cls, str, str2, i2);
    }

    @s0(version = "1.4")
    public PropertyReference1Impl(Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, i2);
    }
}
