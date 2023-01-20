package h.p2.b0.g.t.k.r.i;

import h.p2.b0.g.t.n.z;

/* loaded from: classes3.dex */
public class h extends a {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public h(@k.e.a.d z zVar) {
        this(zVar, null);
        if (zVar == null) {
            b(0);
        }
    }

    private static /* synthetic */ void b(int i2) {
        Object[] objArr = new Object[3];
        if (i2 != 2) {
            objArr[0] = "type";
        } else {
            objArr[0] = "newType";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/TransientReceiver";
        if (i2 != 2) {
            objArr[2] = "<init>";
        } else {
            objArr[2] = "replaceType";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public String toString() {
        return "{Transient} : " + getType();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private h(@k.e.a.d z zVar, @k.e.a.e e eVar) {
        super(zVar, eVar);
        if (zVar == null) {
            b(1);
        }
    }
}
