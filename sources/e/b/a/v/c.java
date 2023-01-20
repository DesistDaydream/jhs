package e.b.a.v;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class c extends FilterInputStream {

    /* renamed from: c  reason: collision with root package name */
    private static final String f9944c = "ContentLengthStream";

    /* renamed from: d  reason: collision with root package name */
    private static final int f9945d = -1;
    private final long a;
    private int b;

    private c(@NonNull InputStream inputStream, long j2) {
        super(inputStream);
        this.a = j2;
    }

    private int a(int i2) throws IOException {
        if (i2 >= 0) {
            this.b += i2;
        } else if (this.a - this.b > 0) {
            throw new IOException("Failed to read all expected data, expected: " + this.a + ", but read: " + this.b);
        }
        return i2;
    }

    @NonNull
    public static InputStream b(@NonNull InputStream inputStream, long j2) {
        return new c(inputStream, j2);
    }

    @NonNull
    public static InputStream c(@NonNull InputStream inputStream, @Nullable String str) {
        return b(inputStream, d(str));
    }

    private static int d(@Nullable String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e2) {
                if (Log.isLoggable(f9944c, 3)) {
                    Log.d(f9944c, "failed to parse content length header: " + str, e2);
                }
            }
        }
        return -1;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        return (int) Math.max(this.a - this.b, ((FilterInputStream) this).in.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        int read;
        read = super.read();
        a(read >= 0 ? 1 : -1);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i2, int i3) throws IOException {
        return a(super.read(bArr, i2, i3));
    }
}
