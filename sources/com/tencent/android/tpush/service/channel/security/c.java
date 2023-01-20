package com.tencent.android.tpush.service.channel.security;

import com.moor.imkf.lib.jsoup.nodes.Attributes;
import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes3.dex */
public class c extends FilterOutputStream {
    private static final char[] a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', Attributes.InternalPrefix};
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f6274c;

    public c(OutputStream outputStream) {
        super(outputStream);
    }

    public static String a(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((int) (bArr.length * 1.37d));
        c cVar = new c(byteArrayOutputStream);
        try {
            cVar.write(bArr);
            cVar.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toString("UTF-8");
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        int i2 = this.b;
        if (i2 % 3 == 1) {
            ((FilterOutputStream) this).out.write(a[(this.f6274c << 4) & 63]);
            ((FilterOutputStream) this).out.write(61);
            ((FilterOutputStream) this).out.write(61);
        } else if (i2 % 3 == 2) {
            ((FilterOutputStream) this).out.write(a[(this.f6274c << 2) & 63]);
            ((FilterOutputStream) this).out.write(61);
        }
        super.close();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i2) {
        if (i2 < 0) {
            i2 += 256;
        }
        int i3 = this.b;
        if (i3 % 3 == 0) {
            this.f6274c = i2 & 3;
            ((FilterOutputStream) this).out.write(a[i2 >> 2]);
        } else if (i3 % 3 == 1) {
            this.f6274c = i2 & 15;
            ((FilterOutputStream) this).out.write(a[((this.f6274c << 4) + (i2 >> 4)) & 63]);
        } else if (i3 % 3 == 2) {
            OutputStream outputStream = ((FilterOutputStream) this).out;
            char[] cArr = a;
            outputStream.write(cArr[((this.f6274c << 2) + (i2 >> 6)) & 63]);
            ((FilterOutputStream) this).out.write(cArr[i2 & 63]);
            this.f6274c = 0;
        }
        int i4 = this.b + 1;
        this.b = i4;
        if (i4 % 57 == 0) {
            ((FilterOutputStream) this).out.write(10);
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            write(bArr[i2 + i4]);
        }
    }
}
