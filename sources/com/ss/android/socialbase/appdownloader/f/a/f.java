package com.ss.android.socialbase.appdownloader.f.a;

import java.io.IOException;

/* loaded from: classes3.dex */
public class f {
    private int[] a;
    private int[] b;

    private f() {
    }

    public static f a(d dVar) throws IOException {
        b.a(dVar, 1835009);
        int b = dVar.b();
        int b2 = dVar.b();
        int b3 = dVar.b();
        dVar.b();
        int b4 = dVar.b();
        int b5 = dVar.b();
        f fVar = new f();
        fVar.a = dVar.b(b2);
        if (b3 != 0) {
            dVar.b(b3);
        }
        int i2 = (b5 == 0 ? b : b5) - b4;
        if (i2 % 4 == 0) {
            fVar.b = dVar.b(i2 / 4);
            if (b5 != 0) {
                int i3 = b - b5;
                if (i3 % 4 == 0) {
                    dVar.b(i3 / 4);
                } else {
                    throw new IOException("Style data size is not multiple of 4 (" + i3 + ").");
                }
            }
            return fVar;
        }
        throw new IOException("String data size is not multiple of 4 (" + i2 + ").");
    }

    public String a(int i2) {
        int[] iArr;
        if (i2 < 0 || (iArr = this.a) == null || i2 >= iArr.length) {
            return null;
        }
        int i3 = iArr[i2];
        int a = a(this.b, i3);
        StringBuilder sb = new StringBuilder(a);
        while (a != 0) {
            i3 += 2;
            sb.append((char) a(this.b, i3));
            a--;
        }
        return sb.toString();
    }

    private static final int a(int[] iArr, int i2) {
        int i3 = iArr[i2 / 4];
        return (i2 % 4) / 2 == 0 ? i3 & 65535 : i3 >>> 16;
    }
}
