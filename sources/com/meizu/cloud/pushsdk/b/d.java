package com.meizu.cloud.pushsdk.b;

import com.moor.imkf.lib.jsoup.nodes.Attributes;

/* loaded from: classes2.dex */
public class d {
    private static final char[] a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', Attributes.InternalPrefix};
    private static final char b = (char) Integer.parseInt("00000011", 2);

    /* renamed from: c  reason: collision with root package name */
    private static final char f4652c = (char) Integer.parseInt("00001111", 2);

    /* renamed from: d  reason: collision with root package name */
    private static final char f4653d = (char) Integer.parseInt("00111111", 2);

    /* renamed from: e  reason: collision with root package name */
    private final String f4654e;

    /* renamed from: f  reason: collision with root package name */
    private char[] f4655f;

    /* renamed from: g  reason: collision with root package name */
    private int f4656g = 0;

    public d(String str) {
        this.f4654e = str;
        a();
    }

    private void a() {
        char[] cArr = new char[a.length];
        int i2 = 0;
        this.f4656g = this.f4654e.charAt(0) % '\r';
        while (true) {
            char[] cArr2 = a;
            if (i2 >= cArr2.length) {
                this.f4655f = cArr;
                return;
            } else {
                cArr[i2] = cArr2[(this.f4656g + i2) % cArr2.length];
                i2++;
            }
        }
    }

    public String a(byte[] bArr) {
        String str;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder(((bArr.length + 2) / 3) * 4);
        int i2 = 0;
        int length = bArr.length;
        while (i2 < length) {
            int i3 = i2 + 1;
            int i4 = bArr[i2] & 255;
            if (i3 == length) {
                sb.append(this.f4655f[i4 >>> 2]);
                sb.append(this.f4655f[(i4 & b) << 4]);
                str = "==";
            } else {
                int i5 = i3 + 1;
                int i6 = bArr[i3] & 255;
                if (i5 == length) {
                    sb.append(this.f4655f[i4 >>> 2]);
                    sb.append(this.f4655f[((i4 & b) << 4) | (i6 >>> 4)]);
                    sb.append(this.f4655f[(f4652c & i6) << 2]);
                    str = "=";
                } else {
                    int i7 = i5 + 1;
                    int i8 = bArr[i5] & 255;
                    sb.append(this.f4655f[i4 >>> 2]);
                    sb.append(this.f4655f[((i4 & b) << 4) | (i6 >>> 4)]);
                    sb.append(this.f4655f[((i6 & f4652c) << 2) | (i8 >>> 6)]);
                    sb.append(this.f4655f[f4653d & i8]);
                    i2 = i7;
                }
            }
            sb.append(str);
            break;
        }
        return sb.toString();
    }
}
