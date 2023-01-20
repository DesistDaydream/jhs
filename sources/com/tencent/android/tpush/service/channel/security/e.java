package com.tencent.android.tpush.service.channel.security;

/* loaded from: classes3.dex */
public class e {
    public static final /* synthetic */ boolean a = true;
    private int[] b = new int[4];

    public e(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length < 16) {
                throw new RuntimeException("Invalid key: Length was less than 16 bytes");
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < 4) {
                int[] iArr = this.b;
                int i4 = i3 + 1;
                int i5 = i4 + 1;
                int i6 = (bArr[i3] & 255) | ((bArr[i4] & 255) << 8);
                int i7 = i5 + 1;
                int i8 = i6 | ((bArr[i5] & 255) << 16);
                iArr[i2] = i8 | ((bArr[i7] & 255) << 24);
                i2++;
                i3 = i7 + 1;
            }
            return;
        }
        throw new RuntimeException("Invalid key: Key was null");
    }
}
