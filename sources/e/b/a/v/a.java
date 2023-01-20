package e.b.a.v;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class a {
    private static final int a = 16384;
    private static final AtomicReference<byte[]> b = new AtomicReference<>();

    /* loaded from: classes.dex */
    public static final class b {
        public final int a;
        public final int b;

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f9943c;

        public b(@NonNull byte[] bArr, int i2, int i3) {
            this.f9943c = bArr;
            this.a = i2;
            this.b = i3;
        }
    }

    private a() {
    }

    @NonNull
    public static ByteBuffer a(@NonNull File file) throws IOException {
        RandomAccessFile randomAccessFile;
        FileChannel fileChannel = null;
        try {
            long length = file.length();
            if (length <= 2147483647L) {
                if (length != 0) {
                    randomAccessFile = new RandomAccessFile(file, "r");
                    try {
                        fileChannel = randomAccessFile.getChannel();
                        MappedByteBuffer load = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0L, length).load();
                        if (fileChannel != null) {
                            try {
                                fileChannel.close();
                            } catch (IOException unused) {
                            }
                        }
                        try {
                            randomAccessFile.close();
                        } catch (IOException unused2) {
                        }
                        return load;
                    } catch (Throwable th) {
                        th = th;
                        if (fileChannel != null) {
                            try {
                                fileChannel.close();
                            } catch (IOException unused3) {
                            }
                        }
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (IOException unused4) {
                            }
                        }
                        throw th;
                    }
                }
                throw new IOException("File unsuitable for memory mapping");
            }
            throw new IOException("File too large to map into memory");
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile = null;
        }
    }

    @NonNull
    public static ByteBuffer b(@NonNull InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        byte[] andSet = b.getAndSet(null);
        if (andSet == null) {
            andSet = new byte[16384];
        }
        while (true) {
            int read = inputStream.read(andSet);
            if (read >= 0) {
                byteArrayOutputStream.write(andSet, 0, read);
            } else {
                b.set(andSet);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                return (ByteBuffer) ByteBuffer.allocateDirect(byteArray.length).put(byteArray).position(0);
            }
        }
    }

    @Nullable
    private static b c(@NonNull ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly() || !byteBuffer.hasArray()) {
            return null;
        }
        return new b(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit());
    }

    @NonNull
    public static byte[] d(@NonNull ByteBuffer byteBuffer) {
        b c2 = c(byteBuffer);
        if (c2 != null && c2.a == 0 && c2.b == c2.f9943c.length) {
            return byteBuffer.array();
        }
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        byte[] bArr = new byte[asReadOnlyBuffer.limit()];
        asReadOnlyBuffer.position(0);
        asReadOnlyBuffer.get(bArr);
        return bArr;
    }

    public static void e(@NonNull ByteBuffer byteBuffer, @NonNull File file) throws IOException {
        RandomAccessFile randomAccessFile;
        byteBuffer.position(0);
        FileChannel fileChannel = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
        } catch (Throwable th) {
            th = th;
            randomAccessFile = null;
        }
        try {
            fileChannel = randomAccessFile.getChannel();
            fileChannel.write(byteBuffer);
            fileChannel.force(false);
            fileChannel.close();
            randomAccessFile.close();
            if (fileChannel != null) {
                try {
                    fileChannel.close();
                } catch (IOException unused) {
                }
            }
            try {
                randomAccessFile.close();
            } catch (IOException unused2) {
            }
        } catch (Throwable th2) {
            th = th2;
            if (fileChannel != null) {
                try {
                    fileChannel.close();
                } catch (IOException unused3) {
                }
            }
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException unused4) {
                }
            }
            throw th;
        }
    }

    @NonNull
    public static InputStream f(@NonNull ByteBuffer byteBuffer) {
        return new C0325a(byteBuffer);
    }

    public static void g(@NonNull ByteBuffer byteBuffer, @NonNull OutputStream outputStream) throws IOException {
        b c2 = c(byteBuffer);
        if (c2 != null) {
            byte[] bArr = c2.f9943c;
            int i2 = c2.a;
            outputStream.write(bArr, i2, c2.b + i2);
            return;
        }
        byte[] andSet = b.getAndSet(null);
        if (andSet == null) {
            andSet = new byte[16384];
        }
        while (byteBuffer.remaining() > 0) {
            int min = Math.min(byteBuffer.remaining(), andSet.length);
            byteBuffer.get(andSet, 0, min);
            outputStream.write(andSet, 0, min);
        }
        b.set(andSet);
    }

    /* renamed from: e.b.a.v.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0325a extends InputStream {

        /* renamed from: c  reason: collision with root package name */
        private static final int f9942c = -1;
        @NonNull
        private final ByteBuffer a;
        private int b = -1;

        public C0325a(@NonNull ByteBuffer byteBuffer) {
            this.a = byteBuffer;
        }

        @Override // java.io.InputStream
        public int available() {
            return this.a.remaining();
        }

        @Override // java.io.InputStream
        public synchronized void mark(int i2) {
            this.b = this.a.position();
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public int read() {
            if (this.a.hasRemaining()) {
                return this.a.get() & 255;
            }
            return -1;
        }

        @Override // java.io.InputStream
        public synchronized void reset() throws IOException {
            int i2 = this.b;
            if (i2 != -1) {
                this.a.position(i2);
            } else {
                throw new IOException("Cannot reset to unset mark position");
            }
        }

        @Override // java.io.InputStream
        public long skip(long j2) throws IOException {
            if (this.a.hasRemaining()) {
                long min = Math.min(j2, available());
                ByteBuffer byteBuffer = this.a;
                byteBuffer.position((int) (byteBuffer.position() + min));
                return min;
            }
            return -1L;
        }

        @Override // java.io.InputStream
        public int read(@NonNull byte[] bArr, int i2, int i3) throws IOException {
            if (this.a.hasRemaining()) {
                int min = Math.min(i3, available());
                this.a.get(bArr, i2, min);
                return min;
            }
            return -1;
        }
    }
}
