package com.moor.imkf.lib.jsoup.internal;

import com.moor.imkf.lib.jsoup.helper.Validate;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class ConstrainableInputStream extends BufferedInputStream {
    private static final int DefaultSize = 32768;
    private final boolean capped;
    private boolean interrupted;
    private final int maxSize;
    private int remaining;
    private long startTime;
    private long timeout;

    private ConstrainableInputStream(InputStream inputStream, int i2, int i3) {
        super(inputStream, i2);
        this.timeout = 0L;
        Validate.isTrue(i3 >= 0);
        this.maxSize = i3;
        this.remaining = i3;
        this.capped = i3 != 0;
        this.startTime = System.nanoTime();
    }

    private boolean expired() {
        return this.timeout != 0 && System.nanoTime() - this.startTime > this.timeout;
    }

    public static ConstrainableInputStream wrap(InputStream inputStream, int i2, int i3) {
        return inputStream instanceof ConstrainableInputStream ? (ConstrainableInputStream) inputStream : new ConstrainableInputStream(inputStream, i2, i3);
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int i4;
        if (this.interrupted || (this.capped && this.remaining <= 0)) {
            return -1;
        }
        if (Thread.interrupted()) {
            this.interrupted = true;
            return -1;
        } else if (!expired()) {
            if (this.capped && i3 > (i4 = this.remaining)) {
                i3 = i4;
            }
            try {
                int read = super.read(bArr, i2, i3);
                this.remaining -= read;
                return read;
            } catch (SocketTimeoutException unused) {
                return 0;
            }
        } else {
            throw new SocketTimeoutException("Read timeout");
        }
    }

    public ByteBuffer readToByteBuffer(int i2) throws IOException {
        Validate.isTrue(i2 >= 0, "maxSize must be 0 (unlimited) or larger");
        boolean z = i2 > 0;
        int i3 = 32768;
        if (z && i2 < 32768) {
            i3 = i2;
        }
        byte[] bArr = new byte[i3];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i3);
        while (true) {
            int read = read(bArr);
            if (read == -1) {
                break;
            }
            if (z) {
                if (read >= i2) {
                    byteArrayOutputStream.write(bArr, 0, i2);
                    break;
                }
                i2 -= read;
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
        return ByteBuffer.wrap(byteArrayOutputStream.toByteArray());
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        super.reset();
        this.remaining = this.maxSize - ((BufferedInputStream) this).markpos;
    }

    public ConstrainableInputStream timeout(long j2, long j3) {
        this.startTime = j2;
        this.timeout = j3 * 1000000;
        return this;
    }
}
