package kotlin.jvm.internal;

import h.k2.v.b0;
import h.k2.v.f0;
import h.k2.v.n0;
import h.p2.h;
import h.s0;
import java.io.Serializable;

@s0(version = "1.4")
/* loaded from: classes3.dex */
public class AdaptedFunctionReference implements b0, Serializable {
    private final int arity;
    private final int flags;
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    public final Object receiver;
    private final String signature;

    public AdaptedFunctionReference(int i2, Class cls, String str, String str2, int i3) {
        this(i2, CallableReference.NO_RECEIVER, cls, str, str2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdaptedFunctionReference) {
            AdaptedFunctionReference adaptedFunctionReference = (AdaptedFunctionReference) obj;
            return this.isTopLevel == adaptedFunctionReference.isTopLevel && this.arity == adaptedFunctionReference.arity && this.flags == adaptedFunctionReference.flags && f0.g(this.receiver, adaptedFunctionReference.receiver) && f0.g(this.owner, adaptedFunctionReference.owner) && this.name.equals(adaptedFunctionReference.name) && this.signature.equals(adaptedFunctionReference.signature);
        }
        return false;
    }

    @Override // h.k2.v.b0
    public int getArity() {
        return this.arity;
    }

    public h getOwner() {
        Class cls = this.owner;
        if (cls == null) {
            return null;
        }
        return this.isTopLevel ? n0.g(cls) : n0.d(cls);
    }

    public int hashCode() {
        Object obj = this.receiver;
        int hashCode = (obj != null ? obj.hashCode() : 0) * 31;
        Class cls = this.owner;
        return ((((((((((hashCode + (cls != null ? cls.hashCode() : 0)) * 31) + this.name.hashCode()) * 31) + this.signature.hashCode()) * 31) + (this.isTopLevel ? 1231 : 1237)) * 31) + this.arity) * 31) + this.flags;
    }

    public String toString() {
        return n0.t(this);
    }

    public AdaptedFunctionReference(int i2, Object obj, Class cls, String str, String str2, int i3) {
        this.receiver = obj;
        this.owner = cls;
        this.name = str;
        this.signature = str2;
        this.isTopLevel = (i3 & 1) == 1;
        this.arity = i2;
        this.flags = i3 >> 1;
    }
}
