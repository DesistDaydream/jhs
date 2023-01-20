package e.b.a.v;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* loaded from: classes.dex */
public final class e extends InputStream {
    @GuardedBy("POOL")

    /* renamed from: c  reason: collision with root package name */
    private static final Queue<e> f9947c = n.f(0);
    private InputStream a;
    private IOException b;

    public static void j() {
        synchronized (f9947c) {
            while (true) {
                Queue<e> queue = f9947c;
                if (!queue.isEmpty()) {
                    queue.remove();
                }
            }
        }
    }

    @NonNull
    public static e l(@NonNull InputStream inputStream) {
        e poll;
        Queue<e> queue = f9947c;
        synchronized (queue) {
            poll = queue.poll();
        }
        if (poll == null) {
            poll = new e();
        }
        poll.o(inputStream);
        return poll;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.a.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.a.close();
    }

    @Nullable
    public IOException k() {
        return this.b;
    }

    @Override // java.io.InputStream
    public void mark(int i2) {
        this.a.mark(i2);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.a.markSupported();
    }

    public void n() {
        this.b = null;
        this.a = null;
        Queue<e> queue = f9947c;
        synchronized (queue) {
            queue.offer(this);
        }
    }

    public void o(@NonNull InputStream inputStream) {
        this.a = inputStream;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        try {
            return this.a.read();
        } catch (IOException e2) {
            this.b = e2;
            throw e2;
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        this.a.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j2) throws IOException {
        try {
            return this.a.skip(j2);
        } catch (IOException e2) {
            this.b = e2;
            throw e2;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        try {
            return this.a.read(bArr);
        } catch (IOException e2) {
            this.b = e2;
            throw e2;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        try {
            return this.a.read(bArr, i2, i3);
        } catch (IOException e2) {
            this.b = e2;
            throw e2;
        }
    }
}
