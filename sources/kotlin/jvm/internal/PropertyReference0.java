package kotlin.jvm.internal;

import h.k2.v.n0;
import h.p2.c;
import h.p2.o;
import h.s0;

/* loaded from: classes3.dex */
public abstract class PropertyReference0 extends PropertyReference implements o {
    public PropertyReference0() {
    }

    @Override // kotlin.jvm.internal.CallableReference
    public c computeReflected() {
        return n0.q(this);
    }

    @Override // h.p2.o
    @s0(version = "1.1")
    public Object getDelegate() {
        return ((o) getReflected()).getDelegate();
    }

    @Override // h.k2.u.a
    public Object invoke() {
        return get();
    }

    @s0(version = "1.1")
    public PropertyReference0(Object obj) {
        super(obj);
    }

    @Override // h.p2.n
    public o.a getGetter() {
        return ((o) getReflected()).getGetter();
    }

    @s0(version = "1.4")
    public PropertyReference0(Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, i2);
    }
}
