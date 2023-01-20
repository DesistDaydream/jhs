package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1;

import java.io.IOException;

/* loaded from: classes.dex */
public final class e {
    public static final bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f a = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f.c("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
    private static final String[] b = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f439c = new String[64];

    /* renamed from: d  reason: collision with root package name */
    public static final String[] f440d = new String[256];

    static {
        String[] strArr;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            String[] strArr2 = f440d;
            if (i3 >= strArr2.length) {
                break;
            }
            strArr2[i3] = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a("%8s", Integer.toBinaryString(i3)).replace(' ', '0');
            i3++;
        }
        String[] strArr3 = f439c;
        strArr3[0] = "";
        strArr3[1] = "END_STREAM";
        int[] iArr = {1};
        strArr3[8] = "PADDED";
        for (int i4 = 0; i4 < 1; i4++) {
            int i5 = iArr[i4];
            f439c[i5 | 8] = strArr[i5] + "|PADDED";
        }
        String[] strArr4 = f439c;
        strArr4[4] = "END_HEADERS";
        strArr4[32] = "PRIORITY";
        strArr4[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i6 = 0; i6 < 3; i6++) {
            int i7 = iArr2[i6];
            for (int i8 = 0; i8 < 1; i8++) {
                int i9 = iArr[i8];
                String[] strArr5 = f439c;
                int i10 = i9 | i7;
                strArr5[i10] = strArr5[i9] + '|' + strArr5[i7];
                strArr5[i10 | 8] = strArr5[i9] + '|' + strArr5[i7] + "|PADDED";
            }
        }
        while (true) {
            String[] strArr6 = f439c;
            if (i2 >= strArr6.length) {
                return;
            }
            if (strArr6[i2] == null) {
                strArr6[i2] = f440d[i2];
            }
            i2++;
        }
    }

    private e() {
    }

    public static IllegalArgumentException a(String str, Object... objArr) {
        throw new IllegalArgumentException(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(str, objArr));
    }

    public static String a(byte b2, byte b3) {
        String str;
        String str2;
        if (b3 == 0) {
            return "";
        }
        if (b2 != 2 && b2 != 3) {
            if (b2 == 4 || b2 == 6) {
                return b3 == 1 ? "ACK" : f440d[b3];
            } else if (b2 != 7 && b2 != 8) {
                String[] strArr = f439c;
                String str3 = b3 < strArr.length ? strArr[b3] : f440d[b3];
                if (b2 == 5 && (b3 & 4) != 0) {
                    str = "HEADERS";
                    str2 = "PUSH_PROMISE";
                } else if (b2 != 0 || (b3 & 32) == 0) {
                    return str3;
                } else {
                    str = "PRIORITY";
                    str2 = "COMPRESSED";
                }
                return str3.replace(str, str2);
            }
        }
        return f440d[b3];
    }

    public static String a(boolean z, int i2, int i3, byte b2, byte b3) {
        String[] strArr = b;
        return bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a("%s 0x%08x %5d %-13s %s", z ? "<<" : ">>", Integer.valueOf(i2), Integer.valueOf(i3), b2 < strArr.length ? strArr[b2] : bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a("0x%02x", Byte.valueOf(b2)), a(b2, b3));
    }

    public static IOException b(String str, Object... objArr) throws IOException {
        throw new IOException(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(str, objArr));
    }
}
