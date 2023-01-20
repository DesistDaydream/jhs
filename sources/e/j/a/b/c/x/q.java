package e.j.a.b.c.x;

import android.os.ParcelFileDescriptor;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.annotation.Nullable;

@e.j.a.b.c.m.a
@e.j.a.b.c.r.d0
@Deprecated
/* loaded from: classes2.dex */
public final class q {
    private q() {
    }

    @e.j.a.b.c.m.a
    public static void a(@Nullable ParcelFileDescriptor parcelFileDescriptor) {
        if (parcelFileDescriptor != null) {
            try {
                parcelFileDescriptor.close();
            } catch (IOException unused) {
            }
        }
    }

    @e.j.a.b.c.m.a
    public static void b(@Nullable Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    @e.j.a.b.c.m.a
    @Deprecated
    public static long c(InputStream inputStream, OutputStream outputStream) throws IOException {
        return i(inputStream, outputStream, false);
    }

    @e.j.a.b.c.m.a
    @Deprecated
    public static long d(InputStream inputStream, OutputStream outputStream, boolean z, int i2) throws IOException {
        byte[] bArr = new byte[i2];
        long j2 = 0;
        while (true) {
            try {
                int read = inputStream.read(bArr, 0, i2);
                if (read == -1) {
                    break;
                }
                j2 += read;
                outputStream.write(bArr, 0, read);
            } finally {
                if (z) {
                    b(inputStream);
                    b(outputStream);
                }
            }
        }
        return j2;
    }

    @e.j.a.b.c.m.a
    public static boolean e(byte[] bArr) {
        if (bArr.length > 1) {
            if ((((bArr[1] & 255) << 8) | (bArr[0] & 255)) == 35615) {
                return true;
            }
        }
        return false;
    }

    @e.j.a.b.c.m.a
    @Deprecated
    public static byte[] f(InputStream inputStream) throws IOException {
        return g(inputStream, true);
    }

    @e.j.a.b.c.m.a
    @Deprecated
    public static byte[] g(InputStream inputStream, boolean z) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        i(inputStream, byteArrayOutputStream, z);
        return byteArrayOutputStream.toByteArray();
    }

    @e.j.a.b.c.m.a
    @Deprecated
    public static byte[] h(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        e.j.a.b.c.r.a0.k(inputStream);
        e.j.a.b.c.r.a0.k(byteArrayOutputStream);
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    @Deprecated
    private static long i(InputStream inputStream, OutputStream outputStream, boolean z) throws IOException {
        return d(inputStream, outputStream, z, 1024);
    }
}
