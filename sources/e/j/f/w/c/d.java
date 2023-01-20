package e.j.f.w.c;

import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.util.Map;

/* loaded from: classes2.dex */
public final class d {
    private final e.j.f.q.m.c a = new e.j.f.q.m.c(e.j.f.q.m.a.f11502l);

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

    private e.j.f.q.d d(a aVar, Map<DecodeHintType, ?> map) throws FormatException, ChecksumException {
        g e2 = aVar.e();
        ErrorCorrectionLevel d2 = aVar.d().d();
        b[] b = b.b(aVar.c(), e2, d2);
        int i2 = 0;
        for (b bVar : b) {
            i2 += bVar.c();
        }
        byte[] bArr = new byte[i2];
        int i3 = 0;
        for (b bVar2 : b) {
            byte[] a = bVar2.a();
            int c2 = bVar2.c();
            a(a, c2);
            int i4 = 0;
            while (i4 < c2) {
                bArr[i3] = a[i4];
                i4++;
                i3++;
            }
        }
        return c.a(bArr, e2, d2, map);
    }

    public e.j.f.q.d b(e.j.f.q.b bVar) throws ChecksumException, FormatException {
        return c(bVar, null);
    }

    public e.j.f.q.d c(e.j.f.q.b bVar, Map<DecodeHintType, ?> map) throws FormatException, ChecksumException {
        ChecksumException e2;
        a aVar = new a(bVar);
        FormatException formatException = null;
        try {
            return d(aVar, map);
        } catch (ChecksumException e3) {
            e2 = e3;
            try {
                aVar.f();
                aVar.g(true);
                aVar.e();
                aVar.d();
                aVar.b();
                e.j.f.q.d d2 = d(aVar, map);
                d2.o(new f(true));
                return d2;
            } catch (ChecksumException | FormatException unused) {
                if (formatException != null) {
                    throw formatException;
                }
                throw e2;
            }
        } catch (FormatException e4) {
            e2 = null;
            formatException = e4;
            aVar.f();
            aVar.g(true);
            aVar.e();
            aVar.d();
            aVar.b();
            e.j.f.q.d d22 = d(aVar, map);
            d22.o(new f(true));
            return d22;
        }
    }

    public e.j.f.q.d e(boolean[][] zArr) throws ChecksumException, FormatException {
        return f(zArr, null);
    }

    public e.j.f.q.d f(boolean[][] zArr, Map<DecodeHintType, ?> map) throws ChecksumException, FormatException {
        return c(e.j.f.q.b.p(zArr), map);
    }
}
