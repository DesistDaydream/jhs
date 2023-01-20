package com.xiaomi.push.service;

import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.xiaomi.mipush.sdk.Constants;

/* loaded from: classes3.dex */
public class as {
    private static int a = 8;

    /* renamed from: e  reason: collision with root package name */
    private int f9106e = -666;
    private byte[] b = new byte[256];

    /* renamed from: d  reason: collision with root package name */
    private int f9105d = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f9104c = 0;

    public static int a(byte b) {
        return b >= 0 ? b : b + 256;
    }

    private void a(int i2, byte[] bArr, boolean z) {
        int length = bArr.length;
        for (int i3 = 0; i3 < 256; i3++) {
            this.b[i3] = (byte) i3;
        }
        this.f9105d = 0;
        this.f9104c = 0;
        while (true) {
            int i4 = this.f9104c;
            if (i4 >= i2) {
                break;
            }
            int a2 = ((this.f9105d + a(this.b[i4])) + a(bArr[this.f9104c % length])) % 256;
            this.f9105d = a2;
            a(this.b, this.f9104c, a2);
            this.f9104c++;
        }
        if (i2 != 256) {
            this.f9106e = ((this.f9105d + a(this.b[i2])) + a(bArr[i2 % length])) % 256;
        }
        if (z) {
            StringBuilder sb = new StringBuilder();
            sb.append("S_");
            int i5 = i2 - 1;
            sb.append(i5);
            sb.append(Constants.COLON_SEPARATOR);
            for (int i6 = 0; i6 <= i2; i6++) {
                sb.append(ExpandableTextView.N);
                sb.append(a(this.b[i6]));
            }
            sb.append("   j_");
            sb.append(i5);
            sb.append("=");
            sb.append(this.f9105d);
            sb.append("   j_");
            sb.append(i2);
            sb.append("=");
            sb.append(this.f9106e);
            sb.append("   S_");
            sb.append(i5);
            sb.append("[j_");
            sb.append(i5);
            sb.append("]=");
            sb.append(a(this.b[this.f9105d]));
            sb.append("   S_");
            sb.append(i5);
            sb.append("[j_");
            sb.append(i2);
            sb.append("]=");
            sb.append(a(this.b[this.f9106e]));
            if (this.b[1] != 0) {
                sb.append("   S[1]!=0");
            }
            com.xiaomi.a.a.a.c.a(sb.toString());
        }
    }

    private void a(byte[] bArr) {
        a(256, bArr, false);
    }

    private static void a(byte[] bArr, int i2, int i3) {
        byte b = bArr[i2];
        bArr[i2] = bArr[i3];
        bArr[i3] = b;
    }

    public static byte[] a(String str, String str2) {
        byte[] b = com.xiaomi.push.ao.b(str);
        byte[] bytes = str2.getBytes();
        byte[] bArr = new byte[b.length + 1 + bytes.length];
        for (int i2 = 0; i2 < b.length; i2++) {
            bArr[i2] = b[i2];
        }
        bArr[b.length] = 95;
        for (int i3 = 0; i3 < bytes.length; i3++) {
            bArr[b.length + 1 + i3] = bytes[i3];
        }
        return bArr;
    }

    public static byte[] a(byte[] bArr, String str) {
        return a(bArr, com.xiaomi.push.ao.b(str));
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr2.length];
        as asVar = new as();
        asVar.a(bArr);
        asVar.b();
        for (int i2 = 0; i2 < bArr2.length; i2++) {
            bArr3[i2] = (byte) (bArr2[i2] ^ asVar.a());
        }
        return bArr3;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, boolean z, int i2, int i3) {
        byte[] bArr3;
        int i4;
        if (i2 < 0 || i2 > bArr2.length || i2 + i3 > bArr2.length) {
            throw new IllegalArgumentException("start = " + i2 + " len = " + i3);
        }
        if (z) {
            bArr3 = bArr2;
            i4 = i2;
        } else {
            bArr3 = new byte[i3];
            i4 = 0;
        }
        as asVar = new as();
        asVar.a(bArr);
        asVar.b();
        for (int i5 = 0; i5 < i3; i5++) {
            bArr3[i4 + i5] = (byte) (bArr2[i2 + i5] ^ asVar.a());
        }
        return bArr3;
    }

    private void b() {
        this.f9105d = 0;
        this.f9104c = 0;
    }

    public byte a() {
        int i2 = (this.f9104c + 1) % 256;
        this.f9104c = i2;
        int a2 = (this.f9105d + a(this.b[i2])) % 256;
        this.f9105d = a2;
        a(this.b, this.f9104c, a2);
        byte[] bArr = this.b;
        return bArr[(a(bArr[this.f9104c]) + a(this.b[this.f9105d])) % 256];
    }
}
