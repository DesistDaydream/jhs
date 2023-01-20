package e.j.f.r.c;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import com.google.zxing.datamatrix.decoder.DecodedBitStreamParser;

/* loaded from: classes2.dex */
public final class c {
    private final e.j.f.q.m.c a = new e.j.f.q.m.c(e.j.f.q.m.a.f11503m);

    private void a(byte[] bArr, int i2) throws ChecksumException {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = bArr[i3] & 255;
        }
        try {
            this.a.a(iArr, bArr.length - i2);
            for (int i4 = 0; i4 < i2; i4++) {
                bArr[i4] = (byte) iArr[i4];
            }
        } catch (ReedSolomonException unused) {
            throw ChecksumException.getChecksumInstance();
        }
    }

    public e.j.f.q.d b(e.j.f.q.b bVar) throws FormatException, ChecksumException {
        a aVar = new a(bVar);
        b[] b = b.b(aVar.c(), aVar.b());
        int i2 = 0;
        for (b bVar2 : b) {
            i2 += bVar2.c();
        }
        byte[] bArr = new byte[i2];
        int length = b.length;
        for (int i3 = 0; i3 < length; i3++) {
            b bVar3 = b[i3];
            byte[] a = bVar3.a();
            int c2 = bVar3.c();
            a(a, c2);
            for (int i4 = 0; i4 < c2; i4++) {
                bArr[(i4 * length) + i3] = a[i4];
            }
        }
        return DecodedBitStreamParser.a(bArr);
    }

    public e.j.f.q.d c(boolean[][] zArr) throws FormatException, ChecksumException {
        return b(e.j.f.q.b.p(zArr));
    }
}
