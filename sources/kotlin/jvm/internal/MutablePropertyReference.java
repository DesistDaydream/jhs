package kotlin.jvm.internal;

import h.p2.j;
import h.s0;

/* loaded from: classes3.dex */
public abstract class MutablePropertyReference extends PropertyReference implements j {
    public MutablePropertyReference() {
    }

    @s0(version = "1.1")
    public MutablePropertyReference(Object obj) {
        super(obj);
    }

    @s0(version = "1.4")
    public MutablePropertyReference(Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, i2);
    }
}
