package e.j.f.o.e;

import com.j256.ormlite.stmt.query.SimpleComparison;
import h.t2.y;

/* loaded from: classes2.dex */
public final class e extends g {

    /* renamed from: c  reason: collision with root package name */
    private final short f11370c;

    /* renamed from: d  reason: collision with root package name */
    private final short f11371d;

    public e(g gVar, int i2, int i3) {
        super(gVar);
        this.f11370c = (short) i2;
        this.f11371d = (short) i3;
    }

    @Override // e.j.f.o.e.g
    public void c(e.j.f.q.a aVar, byte[] bArr) {
        aVar.c(this.f11370c, this.f11371d);
    }

    public String toString() {
        short s = this.f11370c;
        short s2 = this.f11371d;
        int i2 = (s & ((1 << s2) - 1)) | (1 << s2);
        return SimpleComparison.LESS_THAN_OPERATION + Integer.toBinaryString(i2 | (1 << this.f11371d)).substring(1) + y.f15692e;
    }
}
