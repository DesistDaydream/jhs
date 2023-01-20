package kotlin.jvm.internal;

import h.k2.v.f0;
import h.k2.v.n0;
import h.p2.c;
import h.p2.n;
import h.s0;

/* loaded from: classes3.dex */
public abstract class PropertyReference extends CallableReference implements n {
    public PropertyReference() {
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PropertyReference) {
            PropertyReference propertyReference = (PropertyReference) obj;
            return getOwner().equals(propertyReference.getOwner()) && getName().equals(propertyReference.getName()) && getSignature().equals(propertyReference.getSignature()) && f0.g(getBoundReceiver(), propertyReference.getBoundReceiver());
        } else if (obj instanceof n) {
            return obj.equals(compute());
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (((getOwner().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    @Override // h.p2.n
    @s0(version = "1.1")
    public boolean isConst() {
        return getReflected().isConst();
    }

    @Override // h.p2.n
    @s0(version = "1.1")
    public boolean isLateinit() {
        return getReflected().isLateinit();
    }

    public String toString() {
        c compute = compute();
        if (compute != this) {
            return compute.toString();
        }
        return "property " + getName() + n0.b;
    }

    @s0(version = "1.1")
    public PropertyReference(Object obj) {
        super(obj);
    }

    @Override // kotlin.jvm.internal.CallableReference
    @s0(version = "1.1")
    public n getReflected() {
        return (n) super.getReflected();
    }

    @s0(version = "1.4")
    public PropertyReference(Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, (i2 & 1) == 1);
    }
}
