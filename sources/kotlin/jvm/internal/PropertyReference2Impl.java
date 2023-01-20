package kotlin.jvm.internal;

import h.k2.v.r;
import h.p2.d;
import h.p2.h;
import h.s0;

/* loaded from: classes3.dex */
public class PropertyReference2Impl extends PropertyReference2 {
    public PropertyReference2Impl(h hVar, String str, String str2) {
        super(((r) hVar).d(), str, str2, !(hVar instanceof d) ? 1 : 0);
    }

    @Override // h.p2.q
    public Object get(Object obj, Object obj2) {
        return getGetter().call(obj, obj2);
    }

    @s0(version = "1.4")
    public PropertyReference2Impl(Class cls, String str, String str2, int i2) {
        super(cls, str, str2, i2);
    }
}
