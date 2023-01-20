package kotlin.jvm.internal;

import h.k2.v.n0;
import h.p2.c;
import h.p2.p;
import h.s0;

/* loaded from: classes3.dex */
public abstract class PropertyReference1 extends PropertyReference implements p {
    public PropertyReference1() {
    }

    @Override // kotlin.jvm.internal.CallableReference
    public c computeReflected() {
        return n0.r(this);
    }

    @Override // h.p2.p
    @s0(version = "1.1")
    public Object getDelegate(Object obj) {
        return ((p) getReflected()).getDelegate(obj);
    }

    @Override // h.k2.u.l
    public Object invoke(Object obj) {
        return get(obj);
    }

    @s0(version = "1.1")
    public PropertyReference1(Object obj) {
        super(obj);
    }

    @Override // h.p2.n
    public p.a getGetter() {
        return ((p) getReflected()).getGetter();
    }

    @s0(version = "1.4")
    public PropertyReference1(Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, i2);
    }
}
