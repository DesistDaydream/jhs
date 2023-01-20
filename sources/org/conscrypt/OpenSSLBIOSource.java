package org.conscrypt;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public final class OpenSSLBIOSource {
    private OpenSSLBIOInputStream source;

    private OpenSSLBIOSource(OpenSSLBIOInputStream openSSLBIOInputStream) {
        this.source = openSSLBIOInputStream;
    }

    private synchronized void release() {
        OpenSSLBIOInputStream openSSLBIOInputStream = this.source;
        if (openSSLBIOInputStream != null) {
            NativeCrypto.BIO_free_all(openSSLBIOInputStream.getBioContext());
            this.source = null;
        }
    }

    public static OpenSSLBIOSource wrap(ByteBuffer byteBuffer) {
        return new OpenSSLBIOSource(new OpenSSLBIOInputStream(new ByteBufferInputStream(byteBuffer), false));
    }

    public void finalize() throws Throwable {
        try {
            release();
        } finally {
            super.finalize();
        }
    }

    public long getContext() {
        return this.source.getBioContext();
    }

    /* loaded from: classes4.dex */
    public static class ByteBufferInputStream extends InputStream {
        private final ByteBuffer source;

        public ByteBufferInputStream(ByteBuffer byteBuffer) {
            this.source = byteBuffer;
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return this.source.limit() - this.source.position();
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            if (this.source.remaining() > 0) {
                return this.source.get();
            }
            return -1;
        }

        @Override // java.io.InputStream
        public void reset() throws IOException {
            this.source.reset();
        }

        @Override // java.io.InputStream
        public long skip(long j2) throws IOException {
            long position = this.source.position();
            this.source.position((int) (j2 + position));
            return this.source.position() - position;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr) throws IOException {
            int position = this.source.position();
            this.source.get(bArr);
            return this.source.position() - position;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i2, int i3) throws IOException {
            int min = Math.min(this.source.remaining(), i3);
            int position = this.source.position();
            this.source.get(bArr, i2, min);
            return this.source.position() - position;
        }
    }
}
