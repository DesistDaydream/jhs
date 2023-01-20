package h.p2.b0.g.t.f.a0.f;

/* loaded from: classes3.dex */
public final class h {
    @k.e.a.d
    public static final byte[] a(@k.e.a.d String[] strArr) {
        int i2;
        int i3 = 0;
        for (String str : strArr) {
            i3 += str.length();
        }
        byte[] bArr = new byte[i3];
        int length = strArr.length;
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            String str2 = strArr[i4];
            i4++;
            int length2 = str2.length() - 1;
            if (length2 >= 0) {
                int i6 = 0;
                while (true) {
                    int i7 = i6 + 1;
                    i2 = i5 + 1;
                    bArr[i5] = (byte) str2.charAt(i6);
                    if (i6 == length2) {
                        break;
                    }
                    i6 = i7;
                    i5 = i2;
                }
                i5 = i2;
            }
        }
        return bArr;
    }
}
