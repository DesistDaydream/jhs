package com.xiaomi.push;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes3.dex */
public class iv extends iy {
    public InputStream a;
    public OutputStream b;

    public iv() {
        this.a = null;
        this.b = null;
    }

    public iv(OutputStream outputStream) {
        this.a = null;
        this.b = null;
        this.b = outputStream;
    }

    @Override // com.xiaomi.push.iy
    public int a(byte[] bArr, int i2, int i3) {
        InputStream inputStream = this.a;
        if (inputStream != null) {
            try {
                int read = inputStream.read(bArr, i2, i3);
                if (read >= 0) {
                    return read;
                }
                throw new iz(4);
            } catch (IOException e2) {
                throw new iz(0, e2);
            }
        }
        throw new iz(1, "Cannot read from null inputStream");
    }

    @Override // com.xiaomi.push.iy
    public void b(byte[] bArr, int i2, int i3) {
        OutputStream outputStream = this.b;
        if (outputStream == null) {
            throw new iz(1, "Cannot write to null outputStream");
        }
        try {
            outputStream.write(bArr, i2, i3);
        } catch (IOException e2) {
            throw new iz(0, e2);
        }
    }
}
