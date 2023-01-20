package kotlin.jvm.internal;

import h.k2.v.n0;
import h.p2.c;
import h.p2.l;
import h.p2.p;
import h.s0;

/* loaded from: classes3.dex */
public abstract class MutablePropertyReference1 extends MutablePropertyReference implements l {
    public MutablePropertyReference1() {
    }

    @Override // kotlin.jvm.internal.CallableReference
    public c computeReflected() {
        return n0.j(this);
    }

    @Override // h.p2.p
    @s0(version = "1.1")
    public Object getDelegate(Object obj) {
        return ((l) getReflected()).getDelegate(obj);
    }

    @Override // h.k2.u.l
    public Object invoke(Object obj) {
        return get(obj);
    }

    @s0(version = "1.1")
    public MutablePropertyReference1(Object obj) {
        super(obj);
    }

    @Override // h.p2.n
    public p.a getGetter() {
        return ((l) getReflected()).getGetter();
    }

    @Override // h.p2.j
    public l.a getSetter() {
        return ((l) getReflected()).getSetter();
    }

    @s0(version = "1.4")
    public MutablePropertyReference1(Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, i2);
    }
}
