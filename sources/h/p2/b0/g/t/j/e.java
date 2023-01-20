package h.p2.b0.g.t.j;

import h.k2.v.f0;
import h.p2.b0.g.t.g.f;
import java.util.List;

/* loaded from: classes3.dex */
public final class e {
    @k.e.a.d
    public static final String a(@k.e.a.d h.p2.b0.g.t.g.d dVar) {
        return c(dVar.h());
    }

    @k.e.a.d
    public static final String b(@k.e.a.d f fVar) {
        if (d(fVar)) {
            String b = fVar.b();
            return f0.C(String.valueOf('`') + b, "`");
        }
        return fVar.b();
    }

    @k.e.a.d
    public static final String c(@k.e.a.d List<f> list) {
        StringBuilder sb = new StringBuilder();
        for (f fVar : list) {
            if (sb.length() > 0) {
                sb.append(".");
            }
            sb.append(b(fVar));
        }
        return sb.toString();
    }

    private static final boolean d(f fVar) {
        boolean z;
        if (fVar.g()) {
            return false;
        }
        String b = fVar.b();
        if (!d.a.contains(b)) {
            int i2 = 0;
            while (true) {
                if (i2 >= b.length()) {
                    z = false;
                    break;
                }
                char charAt = b.charAt(i2);
                if ((Character.isLetterOrDigit(charAt) || charAt == '_') ? false : true) {
                    z = true;
                    break;
                }
                i2++;
            }
            if (!z) {
                return false;
            }
        }
        return true;
    }
}
