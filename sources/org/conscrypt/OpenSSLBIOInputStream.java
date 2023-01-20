package org.conscrypt;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes4.dex */
public class OpenSSLBIOInputStream extends FilterInputStream {
    private long ctx;

    public OpenSSLBIOInputStream(InputStream inputStream, boolean z) {
        super(inputStream);
        this.ctx = NativeCrypto.create_BIO_InputStream(this, z);
    }

    public long getBioContext() {
        return this.ctx;
    }

    public int gets(byte[] bArr) throws IOException {
        int read;
        int i2 = 0;
        if (bArr != null && bArr.length != 0) {
            while (i2 < bArr.length && (read = read()) != -1) {
                if (read != 10) {
                    bArr[i2] = (byte) read;
                    i2++;
                } else if (i2 != 0) {
                    break;
                }
            }
        }
        return i2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public void release() {
        NativeCrypto.BIO_free_all(this.ctx);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        if (i2 < 0 || i3 < 0 || i3 > bArr.length - i2) {
            throw new IndexOutOfBoundsException("Invalid bounds");
        }
        int i4 = 0;
        if (i3 == 0) {
            return 0;
        }
        do {
            int read = super.read(bArr, i2 + i4, (i3 - i4) - i2);
            if (read == -1) {
                break;
            }
            i4 += read;
        } while (i2 + i4 < i3);
        if (i4 == 0) {
            return -1;
        }
        return i4;
    }
}
