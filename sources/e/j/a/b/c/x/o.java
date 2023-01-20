package e.j.a.b.c.x;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public final class o {
    @e.j.a.b.c.m.a
    public static String a(byte[] bArr, int i2, int i3, boolean z) {
        if (bArr == null || bArr.length == 0 || i2 < 0 || i3 <= 0 || i2 + i3 > bArr.length) {
            return null;
        }
        StringBuilder sb = new StringBuilder((z ? 75 : 57) * (((i3 + 16) - 1) / 16));
        int i4 = i3;
        int i5 = 0;
        int i6 = 0;
        while (i4 > 0) {
            if (i5 == 0) {
                if (i3 < 65536) {
                    sb.append(String.format("%04X:", Integer.valueOf(i2)));
                } else {
                    sb.append(String.format("%08X:", Integer.valueOf(i2)));
                }
                i6 = i2;
            } else if (i5 == 8) {
                sb.append(" -");
            }
            sb.append(String.format(" %02X", Integer.valueOf(bArr[i2] & 255)));
            i4--;
            i5++;
            if (z && (i5 == 16 || i4 == 0)) {
                int i7 = 16 - i5;
                if (i7 > 0) {
                    for (int i8 = 0; i8 < i7; i8++) {
                        sb.append("   ");
                    }
                }
                if (i7 >= 8) {
                    sb.append("  ");
                }
                sb.append("  ");
                for (int i9 = 0; i9 < i5; i9++) {
                    char c2 = (char) bArr[i6 + i9];
                    if (c2 < ' ' || c2 > '~') {
                        c2 = '.';
                    }
                    sb.append(c2);
                }
            }
            if (i5 == 16 || i4 == 0) {
                sb.append('\n');
                i5 = 0;
            }
            i2++;
        }
        return sb.toString();
    }
}
