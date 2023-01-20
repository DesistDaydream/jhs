package h.p2.b0.g.t.n.e1;

import com.umeng.analytics.pro.am;
import h.p2.b0.g.t.n.q0;

/* loaded from: classes3.dex */
public class t implements v {
    private static /* synthetic */ void b(int i2) {
        Object[] objArr = new Object[3];
        switch (i2) {
            case 1:
            case 4:
                objArr[0] = "b";
                break;
            case 2:
            case 7:
                objArr[0] = "typeCheckingProcedure";
                break;
            case 3:
            default:
                objArr[0] = am.av;
                break;
            case 5:
            case 10:
                objArr[0] = "subtype";
                break;
            case 6:
            case 11:
                objArr[0] = "supertype";
                break;
            case 8:
                objArr[0] = "type";
                break;
            case 9:
                objArr[0] = "typeProjection";
                break;
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckerProcedureCallbacksImpl";
        switch (i2) {
            case 3:
            case 4:
                objArr[2] = "assertEqualTypeConstructors";
                break;
            case 5:
            case 6:
            case 7:
                objArr[2] = "assertSubtype";
                break;
            case 8:
            case 9:
                objArr[2] = "capture";
                break;
            case 10:
            case 11:
                objArr[2] = "noCorrespondingSupertype";
                break;
            default:
                objArr[2] = "assertEqualTypes";
                break;
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    @Override // h.p2.b0.g.t.n.e1.v
    public boolean a(@k.e.a.d q0 q0Var, @k.e.a.d q0 q0Var2) {
        if (q0Var == null) {
            b(3);
        }
        if (q0Var2 == null) {
            b(4);
        }
        return q0Var.equals(q0Var2);
    }
}
