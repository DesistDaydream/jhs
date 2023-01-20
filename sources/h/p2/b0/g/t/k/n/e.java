package h.p2.b0.g.t.k.n;

import h.p2.b0.g.t.c.z;
import h.p2.b0.g.t.n.f0;
import java.util.Arrays;

/* loaded from: classes3.dex */
public final class e extends m<Character> {
    public e(char c2) {
        super(Character.valueOf(c2));
    }

    private final String b(char c2) {
        return c2 == '\b' ? "\\b" : c2 == '\t' ? "\\t" : c2 == '\n' ? "\\n" : c2 == '\f' ? "\\f" : c2 == '\r' ? "\\r" : c(c2) ? String.valueOf(c2) : "?";
    }

    private final boolean c(char c2) {
        byte type = (byte) Character.getType(c2);
        return (type == 0 || type == 13 || type == 14 || type == 15 || type == 16 || type == 18 || type == 19) ? false : true;
    }

    @Override // h.p2.b0.g.t.k.n.g
    @k.e.a.d
    public String toString() {
        return String.format("\\u%04X ('%s')", Arrays.copyOf(new Object[]{Integer.valueOf(a().charValue()), b(a().charValue())}, 2));
    }

    @Override // h.p2.b0.g.t.k.n.g
    @k.e.a.d
    public f0 getType(@k.e.a.d z zVar) {
        return zVar.k().u();
    }
}
