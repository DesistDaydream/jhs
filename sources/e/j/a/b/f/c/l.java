package e.j.a.b.f.c;

import com.caverock.androidsvg.SVG;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public final class l extends FilterInputStream {
    private long a;
    private long b;

    public l(InputStream inputStream, long j2) {
        super(inputStream);
        this.b = -1L;
        g.a(inputStream);
        this.a = SVG.H;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int available() throws IOException {
        return (int) Math.min(((FilterInputStream) this).in.available(), this.a);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void mark(int i2) {
        ((FilterInputStream) this).in.mark(i2);
        this.b = this.a;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        if (this.a == 0) {
            return -1;
        }
        int read = ((FilterInputStream) this).in.read();
        if (read != -1) {
            this.a--;
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void reset() throws IOException {
        if (((FilterInputStream) this).in.markSupported()) {
            if (this.b != -1) {
                ((FilterInputStream) this).in.reset();
                this.a = this.b;
            } else {
                throw new IOException("Mark not set");
            }
        } else {
            throw new IOException("Mark not supported");
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j2) throws IOException {
        long skip = ((FilterInputStream) this).in.skip(Math.min(j2, this.a));
        this.a -= skip;
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i2, int i3) throws IOException {
        long j2 = this.a;
        if (j2 == 0) {
            return -1;
        }
        int read = ((FilterInputStream) this).in.read(bArr, i2, (int) Math.min(i3, j2));
        if (read != -1) {
            this.a -= read;
        }
        return read;
    }
}
