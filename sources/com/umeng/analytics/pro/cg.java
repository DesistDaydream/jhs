package com.umeng.analytics.pro;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes3.dex */
public class cg extends ci {
    public InputStream a;
    public OutputStream b;

    public cg() {
        this.a = null;
        this.b = null;
    }

    @Override // com.umeng.analytics.pro.ci
    public int a(byte[] bArr, int i2, int i3) throws cj {
        InputStream inputStream = this.a;
        if (inputStream != null) {
            try {
                int read = inputStream.read(bArr, i2, i3);
                if (read >= 0) {
                    return read;
                }
                throw new cj(4);
            } catch (IOException e2) {
                throw new cj(0, e2);
            }
        }
        throw new cj(1, "Cannot read from null inputStream");
    }

    @Override // com.umeng.analytics.pro.ci
    public boolean a() {
        return true;
    }

    @Override // com.umeng.analytics.pro.ci
    public void b() throws cj {
    }

    @Override // com.umeng.analytics.pro.ci
    public void b(byte[] bArr, int i2, int i3) throws cj {
        OutputStream outputStream = this.b;
        if (outputStream != null) {
            try {
                outputStream.write(bArr, i2, i3);
                return;
            } catch (IOException e2) {
                throw new cj(0, e2);
            }
        }
        throw new cj(1, "Cannot write to null outputStream");
    }

    @Override // com.umeng.analytics.pro.ci
    public void c() {
        InputStream inputStream = this.a;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            this.a = null;
        }
        OutputStream outputStream = this.b;
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            this.b = null;
        }
    }

    @Override // com.umeng.analytics.pro.ci
    public void d() throws cj {
        OutputStream outputStream = this.b;
        if (outputStream != null) {
            try {
                outputStream.flush();
                return;
            } catch (IOException e2) {
                throw new cj(0, e2);
            }
        }
        throw new cj(1, "Cannot flush null outputStream");
    }

    public cg(InputStream inputStream) {
        this.a = null;
        this.b = null;
        this.a = inputStream;
    }

    public cg(OutputStream outputStream) {
        this.a = null;
        this.b = null;
        this.b = outputStream;
    }

    public cg(InputStream inputStream, OutputStream outputStream) {
        this.a = null;
        this.b = null;
        this.a = inputStream;
        this.b = outputStream;
    }
}
