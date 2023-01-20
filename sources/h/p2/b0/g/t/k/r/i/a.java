package h.p2.b0.g.t.k.r.i;

import h.p2.b0.g.t.n.z;

/* loaded from: classes3.dex */
public abstract class a implements e {
    public final z a;
    private final e b;

    public a(@k.e.a.d z zVar, @k.e.a.e e eVar) {
        if (zVar == null) {
            b(0);
        }
        this.a = zVar;
        this.b = eVar == null ? this : eVar;
    }

    private static /* synthetic */ void b(int i2) {
        String str = (i2 == 1 || i2 == 2) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 1 || i2 == 2) ? 2 : 3];
        if (i2 == 1 || i2 == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/AbstractReceiverValue";
        } else {
            objArr[0] = "receiverType";
        }
        if (i2 == 1) {
            objArr[1] = "getType";
        } else if (i2 != 2) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/AbstractReceiverValue";
        } else {
            objArr[1] = "getOriginal";
        }
        if (i2 != 1 && i2 != 2) {
            objArr[2] = "<init>";
        }
        String format = String.format(str, objArr);
        if (i2 != 1 && i2 != 2) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @Override // h.p2.b0.g.t.k.r.i.e
    @k.e.a.d
    public z getType() {
        z zVar = this.a;
        if (zVar == null) {
            b(1);
        }
        return zVar;
    }
}
