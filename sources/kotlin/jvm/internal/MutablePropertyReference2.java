package kotlin.jvm.internal;

import h.k2.v.n0;
import h.p2.c;
import h.p2.m;
import h.p2.q;
import h.s0;

/* loaded from: classes3.dex */
public abstract class MutablePropertyReference2 extends MutablePropertyReference implements m {
    public MutablePropertyReference2() {
    }

    @Override // kotlin.jvm.internal.CallableReference
    public c computeReflected() {
        return n0.k(this);
    }

    @Override // h.p2.q
    @s0(version = "1.1")
    public Object getDelegate(Object obj, Object obj2) {
        return ((m) getReflected()).getDelegate(obj, obj2);
    }

    @Override // h.k2.u.p
    public Object invoke(Object obj, Object obj2) {
        return get(obj, obj2);
    }

    @s0(version = "1.4")
    public MutablePropertyReference2(Class cls, String str, String str2, int i2) {
        super(CallableReference.NO_RECEIVER, cls, str, str2, i2);
    }

    @Override // h.p2.n
    public q.a getGetter() {
        return ((m) getReflected()).getGetter();
    }

    @Override // h.p2.j
    public m.a getSetter() {
        return ((m) getReflected()).getSetter();
    }
}
