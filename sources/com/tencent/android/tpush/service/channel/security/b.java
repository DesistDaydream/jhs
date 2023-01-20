package com.tencent.android.tpush.service.channel.security;

import com.moor.imkf.lib.jsoup.nodes.Attributes;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public class b extends FilterInputStream {
    private static final char[] a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', Attributes.InternalPrefix};
    private static final int[] b = new int[128];

    /* renamed from: c  reason: collision with root package name */
    private int f6272c;

    /* renamed from: d  reason: collision with root package name */
    private int f6273d;

    static {
        for (int i2 = 0; i2 < 64; i2++) {
            b[a[i2]] = i2;
        }
    }

    public b(InputStream inputStream) {
        super(inputStream);
    }

    public static byte[] a(String str) {
        byte[] bArr = new byte[0];
        try {
            bArr = str.getBytes("UTF-8");
        } catch (Throwable unused) {
        }
        b bVar = new b(new ByteArrayInputStream(bArr));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((int) (bArr.length * 0.67d));
        try {
            byte[] bArr2 = new byte[4096];
            while (true) {
                int read = bVar.read(bArr2);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                } else {
                    bVar.close();
                    byteArrayOutputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException unused2) {
            return null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        int read;
        do {
            read = ((FilterInputStream) this).in.read();
            if (read == -1) {
                return -1;
            }
        } while (Character.isWhitespace((char) read));
        int i2 = this.f6272c + 1;
        this.f6272c = i2;
        if (read == 61) {
            return -1;
        }
        int i3 = b[read];
        int i4 = (i2 - 1) % 4;
        if (i4 == 0) {
            this.f6273d = i3 & 63;
            return read();
        } else if (i4 == 1) {
            int i5 = ((this.f6273d << 2) + (i3 >> 4)) & 255;
            this.f6273d = i3 & 15;
            return i5;
        } else if (i4 == 2) {
            int i6 = ((this.f6273d << 4) + (i3 >> 2)) & 255;
            this.f6273d = i3 & 3;
            return i6;
        } else if (i4 == 3) {
            return ((this.f6273d << 6) + i3) & 255;
        } else {
            return -1;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) {
        if (bArr.length < (i3 + i2) - 1) {
            throw new IOException("The input buffer is too small: " + i3 + " bytes requested starting at offset " + i2 + " while the buffer  is only " + bArr.length + " bytes long.");
        }
        int i4 = 0;
        while (i4 < i3) {
            int read = read();
            if (read == -1 && i4 == 0) {
                return -1;
            }
            if (read == -1) {
                break;
            }
            bArr[i2 + i4] = (byte) read;
            i4++;
        }
        return i4;
    }
}
