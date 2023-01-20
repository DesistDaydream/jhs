package h.p2.b0.g.t.n;

import kotlin.reflect.jvm.internal.impl.types.Variance;

/* loaded from: classes3.dex */
public class u0 extends t0 {
    private final Variance a;
    private final z b;

    public u0(@k.e.a.d Variance variance, @k.e.a.d z zVar) {
        if (variance == null) {
            d(0);
        }
        if (zVar == null) {
            d(1);
        }
        this.a = variance;
        this.b = zVar;
    }

    private static /* synthetic */ void d(int i2) {
        String str = (i2 == 4 || i2 == 5) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 4 || i2 == 5) ? 2 : 3];
        switch (i2) {
            case 1:
            case 2:
            case 3:
                objArr[0] = "type";
                break;
            case 4:
            case 5:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl";
                break;
            case 6:
                objArr[0] = "kotlinTypeRefiner";
                break;
            default:
                objArr[0] = "projection";
                break;
        }
        if (i2 == 4) {
            objArr[1] = "getProjectionKind";
        } else if (i2 != 5) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl";
        } else {
            objArr[1] = "getType";
        }
        if (i2 == 3) {
            objArr[2] = "replaceType";
        } else if (i2 != 4 && i2 != 5) {
            if (i2 != 6) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "refine";
            }
        }
        String format = String.format(str, objArr);
        if (i2 != 4 && i2 != 5) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @Override // h.p2.b0.g.t.n.s0
    @k.e.a.d
    public s0 a(@k.e.a.d h.p2.b0.g.t.n.e1.h hVar) {
        if (hVar == null) {
            d(6);
        }
        return new u0(this.a, hVar.g(this.b));
    }

    @Override // h.p2.b0.g.t.n.s0
    public boolean b() {
        return false;
    }

    @Override // h.p2.b0.g.t.n.s0
    @k.e.a.d
    public Variance c() {
        Variance variance = this.a;
        if (variance == null) {
            d(4);
        }
        return variance;
    }

    @Override // h.p2.b0.g.t.n.s0
    @k.e.a.d
    public z getType() {
        z zVar = this.b;
        if (zVar == null) {
            d(5);
        }
        return zVar;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public u0(@k.e.a.d z zVar) {
        this(Variance.INVARIANT, zVar);
        if (zVar == null) {
            d(2);
        }
    }
}
