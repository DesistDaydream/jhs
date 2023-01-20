package e.b.a.v;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

@Deprecated
/* loaded from: classes.dex */
public class d extends InputStream {

    /* renamed from: c  reason: collision with root package name */
    private static final Queue<d> f9946c = n.f(0);
    private InputStream a;
    private IOException b;

    public static void j() {
        while (true) {
            Queue<d> queue = f9946c;
            if (queue.isEmpty()) {
                return;
            }
            queue.remove();
        }
    }

    @NonNull
    public static d l(@NonNull InputStream inputStream) {
        d poll;
        Queue<d> queue = f9946c;
        synchronized (queue) {
            poll = queue.poll();
        }
        if (poll == null) {
            poll = new d();
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
        Queue<d> queue = f9946c;
        synchronized (queue) {
            queue.offer(this);
        }
    }

    public void o(@NonNull InputStream inputStream) {
        this.a = inputStream;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        try {
            return this.a.read(bArr);
        } catch (IOException e2) {
            this.b = e2;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        this.a.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j2) {
        try {
            return this.a.skip(j2);
        } catch (IOException e2) {
            this.b = e2;
            return 0L;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) {
        try {
            return this.a.read(bArr, i2, i3);
        } catch (IOException e2) {
            this.b = e2;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public int read() {
        try {
            return this.a.read();
        } catch (IOException e2) {
            this.b = e2;
            return -1;
        }
    }
}
