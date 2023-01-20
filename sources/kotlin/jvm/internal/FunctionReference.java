package kotlin.jvm.internal;

import h.k2.v.b0;
import h.k2.v.f0;
import h.k2.v.n0;
import h.p2.c;
import h.p2.i;
import h.s0;

/* loaded from: classes3.dex */
public class FunctionReference extends CallableReference implements b0, i {
    private final int arity;
    @s0(version = "1.4")
    private final int flags;

    public FunctionReference(int i2) {
        this(i2, CallableReference.NO_RECEIVER, null, null, null, 0);
    }

    @Override // kotlin.jvm.internal.CallableReference
    @s0(version = "1.1")
    public c computeReflected() {
        return n0.c(this);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof FunctionReference) {
            FunctionReference functionReference = (FunctionReference) obj;
            return f0.g(getOwner(), functionReference.getOwner()) && getName().equals(functionReference.getName()) && getSignature().equals(functionReference.getSignature()) && this.flags == functionReference.flags && this.arity == functionReference.arity && f0.g(getBoundReceiver(), functionReference.getBoundReceiver());
        } else if (obj instanceof i) {
            return obj.equals(compute());
        } else {
            return false;
        }
    }

    @Override // h.k2.v.b0
    public int getArity() {
        return this.arity;
    }

    public int hashCode() {
        return (((getOwner() == null ? 0 : getOwner().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    @Override // h.p2.i
    @s0(version = "1.1")
    public boolean isExternal() {
        return getReflected().isExternal();
    }

    @Override // h.p2.i
    @s0(version = "1.1")
    public boolean isInfix() {
        return getReflected().isInfix();
    }

    @Override // h.p2.i
    @s0(version = "1.1")
    public boolean isInline() {
        return getReflected().isInline();
    }

    @Override // h.p2.i
    @s0(version = "1.1")
    public boolean isOperator() {
        return getReflected().isOperator();
    }

    @Override // kotlin.jvm.internal.CallableReference, h.p2.c
    @s0(version = "1.1")
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    public String toString() {
        c compute = compute();
        if (compute != this) {
            return compute.toString();
        }
        if ("<init>".equals(getName())) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + getName() + n0.b;
    }

    @s0(version = "1.1")
    public FunctionReference(int i2, Object obj) {
        this(i2, obj, null, null, null, 0);
    }

    @Override // kotlin.jvm.internal.CallableReference
    @s0(version = "1.1")
    public i getReflected() {
        return (i) super.getReflected();
    }

    @s0(version = "1.4")
    public FunctionReference(int i2, Object obj, Class cls, String str, String str2, int i3) {
        super(obj, cls, str, str2, (i3 & 1) == 1);
        this.arity = i2;
        this.flags = i3 >> 1;
    }
}
