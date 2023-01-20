package e.j.f;

/* loaded from: classes2.dex */
public class l {
    private final float a;
    private final float b;

    public l(float f2, float f3) {
        this.a = f2;
        this.b = f3;
    }

    private static float a(l lVar, l lVar2, l lVar3) {
        float f2 = lVar2.a;
        float f3 = lVar2.b;
        return ((lVar3.a - f2) * (lVar.b - f3)) - ((lVar3.b - f3) * (lVar.a - f2));
    }

    public static float b(l lVar, l lVar2) {
        return e.j.f.q.l.a.a(lVar.a, lVar.b, lVar2.a, lVar2.b);
    }

    public static void e(l[] lVarArr) {
        l lVar;
        l lVar2;
        l lVar3;
        float b = b(lVarArr[0], lVarArr[1]);
        float b2 = b(lVarArr[1], lVarArr[2]);
        float b3 = b(lVarArr[0], lVarArr[2]);
        if (b2 >= b && b2 >= b3) {
            lVar = lVarArr[0];
            lVar2 = lVarArr[1];
            lVar3 = lVarArr[2];
        } else if (b3 >= b2 && b3 >= b) {
            lVar = lVarArr[1];
            lVar2 = lVarArr[0];
            lVar3 = lVarArr[2];
        } else {
            lVar = lVarArr[2];
            lVar2 = lVarArr[0];
            lVar3 = lVarArr[1];
        }
        if (a(lVar2, lVar, lVar3) < 0.0f) {
            l lVar4 = lVar3;
            lVar3 = lVar2;
            lVar2 = lVar4;
        }
        lVarArr[0] = lVar2;
        lVarArr[1] = lVar;
        lVarArr[2] = lVar3;
    }

    public final float c() {
        return this.a;
    }

    public final float d() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof l) {
            l lVar = (l) obj;
            if (this.a == lVar.a && this.b == lVar.b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.a) * 31) + Float.floatToIntBits(this.b);
    }

    public final String toString() {
        return "(" + this.a + ',' + this.b + ')';
    }
}
