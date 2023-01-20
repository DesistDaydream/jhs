package e.k.c.a.a.k;

import android.database.Cursor;
import android.text.TextUtils;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

/* loaded from: classes2.dex */
public class d {
    private static final String a = "IOUtil";
    private static final int b = 4096;

    public static void a(Cursor cursor) {
        if (cursor != null) {
            cursor.close();
        }
    }

    public static void b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                Log.e(a, "closeSecure IOException");
            }
        }
    }

    public static void c(InputStream inputStream) {
        b(inputStream);
    }

    public static void d(OutputStream outputStream) {
        b(outputStream);
    }

    public static void e(Reader reader) {
        b(reader);
    }

    public static void f(Writer writer) {
        b(writer);
    }

    public static long g(InputStream inputStream, OutputStream outputStream) throws IOException {
        return h(inputStream, outputStream, new byte[4096]);
    }

    public static long h(InputStream inputStream, OutputStream outputStream, byte[] bArr) throws IOException {
        long j2 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return j2;
            }
            outputStream.write(bArr, 0, read);
            j2 += read;
        }
    }

    public static void i(File file) {
        if (file == null || !file.exists() || file.delete()) {
            return;
        }
        Log.e(a, "deleteSecure exception");
    }

    public static void j(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        i(new File(str));
    }

    public static byte[] k(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        g(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static InputStream l(byte[] bArr) throws IOException {
        return new ByteArrayInputStream(bArr);
    }
}
