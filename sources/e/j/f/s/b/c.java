package e.j.f.s.b;

import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import com.umeng.analytics.pro.cb;
import e.j.f.q.d;
import java.util.Map;

/* loaded from: classes2.dex */
public final class c {
    private static final int b = 0;

    /* renamed from: c  reason: collision with root package name */
    private static final int f11560c = 1;

    /* renamed from: d  reason: collision with root package name */
    private static final int f11561d = 2;
    private final e.j.f.q.m.c a = new e.j.f.q.m.c(e.j.f.q.m.a.o);

    private void a(byte[] bArr, int i2, int i3, int i4, int i5) throws ChecksumException {
        int i6 = i3 + i4;
        int i7 = i5 == 0 ? 1 : 2;
        int[] iArr = new int[i6 / i7];
        for (int i8 = 0; i8 < i6; i8++) {
            if (i5 == 0 || i8 % 2 == i5 - 1) {
                iArr[i8 / i7] = bArr[i8 + i2] & 255;
            }
        }
        try {
            this.a.a(iArr, i4 / i7);
            for (int i9 = 0; i9 < i3; i9++) {
                if (i5 == 0 || i9 % 2 == i5 - 1) {
                    bArr[i9 + i2] = (byte) iArr[i9 / i7];
                }
            }
        } catch (ReedSolomonException unused) {
            throw ChecksumException.getChecksumInstance();
        }
    }

    public d b(e.j.f.q.b bVar) throws ChecksumException, FormatException {
        return c(bVar, null);
    }

    public d c(e.j.f.q.b bVar, Map<DecodeHintType, ?> map) throws FormatException, ChecksumException {
        byte[] bArr;
        byte[] a = new a(bVar).a();
        a(a, 0, 10, 10, 0);
        int i2 = a[0] & cb.f7124m;
        if (i2 == 2 || i2 == 3 || i2 == 4) {
            a(a, 20, 84, 40, 1);
            a(a, 20, 84, 40, 2);
            bArr = new byte[94];
        } else if (i2 == 5) {
            a(a, 20, 68, 56, 1);
            a(a, 20, 68, 56, 2);
            bArr = new byte[78];
        } else {
            throw FormatException.getFormatInstance();
        }
        System.arraycopy(a, 0, bArr, 0, 10);
        System.arraycopy(a, 20, bArr, 10, bArr.length - 10);
        return b.a(bArr, i2);
    }
}
