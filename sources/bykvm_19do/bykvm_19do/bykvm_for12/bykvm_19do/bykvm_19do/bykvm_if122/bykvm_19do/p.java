package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do;

import com.caverock.androidsvg.SVG;

/* loaded from: classes.dex */
public final class p {
    public static o a;
    public static long b;

    private p() {
    }

    public static o a() {
        synchronized (p.class) {
            o oVar = a;
            if (oVar != null) {
                a = oVar.f292f;
                oVar.f292f = null;
                b -= SVG.A;
                return oVar;
            }
            return new o();
        }
    }

    public static void a(o oVar) {
        if (oVar.f292f != null || oVar.f293g != null) {
            throw new IllegalArgumentException();
        }
        if (oVar.f290d) {
            return;
        }
        synchronized (p.class) {
            long j2 = b;
            if (j2 + SVG.A <= SVG.D) {
                b = j2 + SVG.A;
                oVar.f292f = a;
                oVar.f289c = 0;
                oVar.b = 0;
                a = oVar;
            }
        }
    }
}
