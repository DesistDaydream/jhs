package e.j.f.u.b0.g.e;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;

/* loaded from: classes2.dex */
public abstract class j {
    private final e.j.f.q.a a;
    private final r b;

    public j(e.j.f.q.a aVar) {
        this.a = aVar;
        this.b = new r(aVar);
    }

    public static j a(e.j.f.q.a aVar) {
        if (aVar.j(1)) {
            return new g(aVar);
        }
        if (!aVar.j(2)) {
            return new k(aVar);
        }
        int g2 = r.g(aVar, 1, 4);
        if (g2 != 4) {
            if (g2 != 5) {
                int g3 = r.g(aVar, 1, 5);
                if (g3 != 12) {
                    if (g3 != 13) {
                        switch (r.g(aVar, 1, 7)) {
                            case 56:
                                return new e(aVar, "310", "11");
                            case 57:
                                return new e(aVar, "320", "11");
                            case 58:
                                return new e(aVar, "310", "13");
                            case 59:
                                return new e(aVar, "320", "13");
                            case 60:
                                return new e(aVar, "310", "15");
                            case 61:
                                return new e(aVar, "320", "15");
                            case 62:
                                return new e(aVar, "310", "17");
                            case 63:
                                return new e(aVar, "320", "17");
                            default:
                                throw new IllegalStateException("unknown decoder: ".concat(String.valueOf(aVar)));
                        }
                    }
                    return new d(aVar);
                }
                return new c(aVar);
            }
            return new b(aVar);
        }
        return new a(aVar);
    }

    public final r b() {
        return this.b;
    }

    public final e.j.f.q.a c() {
        return this.a;
    }

    public abstract String d() throws NotFoundException, FormatException;
}
