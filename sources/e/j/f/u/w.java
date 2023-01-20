package e.j.f.u;

import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;

/* loaded from: classes2.dex */
public final class w {

    /* renamed from: c */
    private static final int[] f11654c = {1, 1, 2};
    private final u a = new u();
    private final v b = new v();

    public e.j.f.k a(int i2, e.j.f.q.a aVar, int i3) throws NotFoundException {
        int[] n = x.n(aVar, i3, false, f11654c);
        try {
            return this.b.b(i2, aVar, n);
        } catch (ReaderException unused) {
            return this.a.b(i2, aVar, n);
        }
    }
}
