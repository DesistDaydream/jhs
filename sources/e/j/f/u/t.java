package e.j.f.u;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import java.util.Map;

/* loaded from: classes2.dex */
public final class t implements e.j.f.n {
    private final i a = new i();

    @Override // e.j.f.n
    public e.j.f.q.b a(String str, BarcodeFormat barcodeFormat, int i2, int i3, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.UPC_A) {
            return this.a.a("0".concat(String.valueOf(str)), BarcodeFormat.EAN_13, i2, i3, map);
        }
        throw new IllegalArgumentException("Can only encode UPC-A, but got ".concat(String.valueOf(barcodeFormat)));
    }

    @Override // e.j.f.n
    public e.j.f.q.b b(String str, BarcodeFormat barcodeFormat, int i2, int i3) throws WriterException {
        return a(str, barcodeFormat, i2, i3, null);
    }
}
