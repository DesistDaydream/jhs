package e.j.f.o.e;

import com.j256.ormlite.stmt.query.SimpleComparison;
import h.t2.y;

/* loaded from: classes2.dex */
public final class b extends g {

    /* renamed from: c  reason: collision with root package name */
    private final short f11357c;

    /* renamed from: d  reason: collision with root package name */
    private final short f11358d;

    public b(g gVar, int i2, int i3) {
        super(gVar);
        this.f11357c = (short) i2;
        this.f11358d = (short) i3;
    }

    @Override // e.j.f.o.e.g
    public void c(e.j.f.q.a aVar, byte[] bArr) {
        int i2 = 0;
        while (true) {
            short s = this.f11358d;
            if (i2 >= s) {
                return;
            }
            if (i2 == 0 || (i2 == 31 && s <= 62)) {
                aVar.c(31, 5);
                short s2 = this.f11358d;
                if (s2 > 62) {
                    aVar.c(s2 - 31, 16);
                } else if (i2 == 0) {
                    aVar.c(Math.min((int) s2, 31), 5);
                } else {
                    aVar.c(s2 - 31, 5);
                }
            }
            aVar.c(bArr[this.f11357c + i2], 8);
            i2++;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(SimpleComparison.LESS_THAN_OPERATION);
        sb.append((int) this.f11357c);
        sb.append("::");
        sb.append((this.f11357c + this.f11358d) - 1);
        sb.append(y.f15692e);
        return sb.toString();
    }
}
