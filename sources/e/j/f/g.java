package e.j.f;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.oned.Code128Writer;
import e.j.f.u.a0;
import e.j.f.u.t;
import java.util.Map;

/* loaded from: classes2.dex */
public final class g implements n {

    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[BarcodeFormat.values().length];
            a = iArr;
            try {
                iArr[BarcodeFormat.EAN_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[BarcodeFormat.UPC_E.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[BarcodeFormat.EAN_13.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[BarcodeFormat.UPC_A.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[BarcodeFormat.QR_CODE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[BarcodeFormat.CODE_39.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[BarcodeFormat.CODE_93.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[BarcodeFormat.CODE_128.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[BarcodeFormat.ITF.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[BarcodeFormat.PDF_417.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[BarcodeFormat.CODABAR.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[BarcodeFormat.DATA_MATRIX.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[BarcodeFormat.AZTEC.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    @Override // e.j.f.n
    public e.j.f.q.b a(String str, BarcodeFormat barcodeFormat, int i2, int i3, Map<EncodeHintType, ?> map) throws WriterException {
        n kVar;
        switch (a.a[barcodeFormat.ordinal()]) {
            case 1:
                kVar = new e.j.f.u.k();
                break;
            case 2:
                kVar = new a0();
                break;
            case 3:
                kVar = new e.j.f.u.i();
                break;
            case 4:
                kVar = new t();
                break;
            case 5:
                kVar = new e.j.f.w.b();
                break;
            case 6:
                kVar = new e.j.f.u.e();
                break;
            case 7:
                kVar = new e.j.f.u.g();
                break;
            case 8:
                kVar = new Code128Writer();
                break;
            case 9:
                kVar = new e.j.f.u.n();
                break;
            case 10:
                kVar = new e.j.f.v.d();
                break;
            case 11:
                kVar = new e.j.f.u.b();
                break;
            case 12:
                kVar = new e.j.f.r.b();
                break;
            case 13:
                kVar = new e.j.f.o.c();
                break;
            default:
                throw new IllegalArgumentException("No encoder available for format ".concat(String.valueOf(barcodeFormat)));
        }
        return kVar.a(str, barcodeFormat, i2, i3, map);
    }

    @Override // e.j.f.n
    public e.j.f.q.b b(String str, BarcodeFormat barcodeFormat, int i2, int i3) throws WriterException {
        return a(str, barcodeFormat, i2, i3, null);
    }
}
