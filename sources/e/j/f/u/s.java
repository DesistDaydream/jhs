package e.j.f.u;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import java.util.Map;

/* loaded from: classes2.dex */
public final class s extends x {

    /* renamed from: k  reason: collision with root package name */
    private final x f11652k = new h();

    private static e.j.f.k s(e.j.f.k kVar) throws FormatException {
        String g2 = kVar.g();
        if (g2.charAt(0) == '0') {
            e.j.f.k kVar2 = new e.j.f.k(g2.substring(1), null, kVar.f(), BarcodeFormat.UPC_A);
            if (kVar.e() != null) {
                kVar2.i(kVar.e());
            }
            return kVar2;
        }
        throw FormatException.getFormatInstance();
    }

    @Override // e.j.f.u.q, e.j.f.j
    public e.j.f.k a(e.j.f.b bVar, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        return s(this.f11652k.a(bVar, map));
    }

    @Override // e.j.f.u.x, e.j.f.u.q
    public e.j.f.k b(int i2, e.j.f.q.a aVar, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException, ChecksumException {
        return s(this.f11652k.b(i2, aVar, map));
    }

    @Override // e.j.f.u.q, e.j.f.j
    public e.j.f.k c(e.j.f.b bVar) throws NotFoundException, FormatException {
        return s(this.f11652k.c(bVar));
    }

    @Override // e.j.f.u.x
    public int l(e.j.f.q.a aVar, int[] iArr, StringBuilder sb) throws NotFoundException {
        return this.f11652k.l(aVar, iArr, sb);
    }

    @Override // e.j.f.u.x
    public e.j.f.k m(int i2, e.j.f.q.a aVar, int[] iArr, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException, ChecksumException {
        return s(this.f11652k.m(i2, aVar, iArr, map));
    }

    @Override // e.j.f.u.x
    public BarcodeFormat q() {
        return BarcodeFormat.UPC_A;
    }
}
