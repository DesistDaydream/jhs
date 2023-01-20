package h.p2.b0.g.t.n.e1;

import h.p2.b0.g.t.n.z;

/* loaded from: classes3.dex */
public class u {
    public static final /* synthetic */ boolean a = false;

    private static /* synthetic */ void a(int i2) {
        String str = (i2 == 7 || i2 == 10) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 7 || i2 == 10) ? 2 : 3];
        switch (i2) {
            case 1:
            case 3:
            case 16:
            case 18:
                objArr[0] = "supertype";
                break;
            case 2:
            case 15:
            case 17:
            default:
                objArr[0] = "subtype";
                break;
            case 4:
                objArr[0] = "typeCheckingProcedureCallbacks";
                break;
            case 5:
            case 8:
            case 21:
                objArr[0] = "parameter";
                break;
            case 6:
            case 9:
                objArr[0] = "argument";
                break;
            case 7:
            case 10:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure";
                break;
            case 11:
                objArr[0] = "type1";
                break;
            case 12:
                objArr[0] = "type2";
                break;
            case 13:
                objArr[0] = "typeParameter";
                break;
            case 14:
                objArr[0] = "typeArgument";
                break;
            case 19:
                objArr[0] = "subtypeArgumentProjection";
                break;
            case 20:
                objArr[0] = "supertypeArgumentProjection";
                break;
        }
        if (i2 == 7) {
            objArr[1] = "getOutType";
        } else if (i2 != 10) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure";
        } else {
            objArr[1] = "getInType";
        }
        switch (i2) {
            case 5:
            case 6:
                objArr[2] = "getOutType";
                break;
            case 7:
            case 10:
                break;
            case 8:
            case 9:
                objArr[2] = "getInType";
                break;
            case 11:
            case 12:
                objArr[2] = "equalTypes";
                break;
            case 13:
            case 14:
                objArr[2] = "getEffectiveProjectionKind";
                break;
            case 15:
            case 16:
                objArr[2] = "isSubtypeOf";
                break;
            case 17:
            case 18:
                objArr[2] = "checkSubtypeForTheSameConstructor";
                break;
            case 19:
            case 20:
            case 21:
                objArr[2] = "capture";
                break;
            default:
                objArr[2] = "findCorrespondingSupertype";
                break;
        }
        String format = String.format(str, objArr);
        if (i2 != 7 && i2 != 10) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @k.e.a.e
    public static z b(@k.e.a.d z zVar, @k.e.a.d z zVar2) {
        if (zVar == null) {
            a(0);
        }
        if (zVar2 == null) {
            a(1);
        }
        return c(zVar, zVar2, new t());
    }

    @k.e.a.e
    public static z c(@k.e.a.d z zVar, @k.e.a.d z zVar2, @k.e.a.d v vVar) {
        if (zVar == null) {
            a(2);
        }
        if (zVar2 == null) {
            a(3);
        }
        if (vVar == null) {
            a(4);
        }
        return w.d(zVar, zVar2, vVar);
    }
}
