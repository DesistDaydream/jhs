package e.t.n;

import android.content.Context;
import android.net.Uri;
import e.t.l.i;
import h.t2.d;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.util.ArrayDeque;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u001a\f\u0010\n\u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u001a\u0014\u0010\u000b\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u001a\u0014\u0010\f\u001a\u00020\u0001*\u00020\t2\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u001a\u0014\u0010\r\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u001a\u0014\u0010\u000e\u001a\u00020\u0001*\u00020\t2\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u001a\n\u0010\u000f\u001a\u00020\u0010*\u00020\u0002\u001a\n\u0010\u0011\u001a\u00020\u0012*\u00020\u0013\u001a\n\u0010\u0014\u001a\u00020\u0015*\u00020\u0013\u001a\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u0017*\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u001a\u0014\u0010\u0018\u001a\u00020\t*\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u001a\u001c\u0010\u0019\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u001a\u001c\u0010\u0019\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u00172\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u001a&\u0010\u0019\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u001d\u001a\u00020\t2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010\u0005\u001a\u00020\u0006¨\u0006 "}, d2 = {"copyTo", "", "Ljava/io/File;", "uri", "Landroid/net/Uri;", "context", "Landroid/content/Context;", "dest", "destPath", "", "deleteAll", "ensureExist", "ensureFileExist", "exist", "fileExist", "getSize", "", "inputStream", "Ljava/io/FileInputStream;", "Ljava/io/FileDescriptor;", "outputStream", "Ljava/io/FileOutputStream;", "readBytes", "", "readString", "write", k.b.a.a.n.n.c.b, "", "bytes", "text", "charset", "Ljava/nio/charset/Charset;", "vector_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class b {
    public static /* synthetic */ boolean A(File file, String str, Charset charset, Context context, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            charset = d.a;
        }
        if ((i2 & 4) != 0) {
            context = e.t.a.b();
        }
        return x(file, str, charset, context);
    }

    public static /* synthetic */ boolean B(File file, byte[] bArr, Context context, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            context = e.t.a.b();
        }
        return y(file, bArr, context);
    }

    public static final boolean a(@k.e.a.d File file, @k.e.a.d Uri uri, @k.e.a.d Context context) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            h.h2.a.l(fileInputStream, fileOutputStream, 0, 2, null);
            i.a(fileInputStream);
            i.a(fileOutputStream);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static final boolean b(@k.e.a.d File file, @k.e.a.d File file2, @k.e.a.d Context context) {
        return a.a.j(file, file2, context);
    }

    public static final boolean c(@k.e.a.d File file, @k.e.a.d String str, @k.e.a.d Context context) {
        return a.a.g(file.getAbsolutePath(), str, context);
    }

    public static /* synthetic */ boolean d(File file, Uri uri, Context context, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            context = e.t.a.b();
        }
        return a(file, uri, context);
    }

    public static /* synthetic */ boolean e(File file, File file2, Context context, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            context = e.t.a.b();
        }
        return b(file, file2, context);
    }

    public static /* synthetic */ boolean f(File file, String str, Context context, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            context = e.t.a.b();
        }
        return c(file, str, context);
    }

    public static final boolean g(@e File file) {
        if (file == null || !file.exists()) {
            return false;
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.addLast(file);
        boolean z = true;
        while (!arrayDeque.isEmpty()) {
            File file2 = (File) arrayDeque.getLast();
            if (file2.isFile()) {
                arrayDeque.pollLast();
                z = file2.delete();
            } else {
                File[] listFiles = file2.listFiles();
                if (listFiles != null) {
                    if (!(listFiles.length == 0)) {
                        for (File file3 : listFiles) {
                            arrayDeque.addLast(file3);
                        }
                    }
                }
                arrayDeque.pollLast();
                z = file2.delete();
            }
        }
        return z;
    }

    public static final boolean h(@k.e.a.d File file, @k.e.a.d Context context) {
        if (a.a.i(file, context)) {
            return true;
        }
        return file.mkdirs();
    }

    public static /* synthetic */ boolean i(File file, Context context, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            context = e.t.a.b();
        }
        return h(file, context);
    }

    public static final boolean j(@k.e.a.d String str, @k.e.a.d Context context) {
        return h(new File(str), context);
    }

    public static /* synthetic */ boolean k(String str, Context context, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            context = e.t.a.b();
        }
        return j(str, context);
    }

    public static final boolean l(@k.e.a.d File file, @k.e.a.d Context context) {
        return a.a.i(file, context);
    }

    public static /* synthetic */ boolean m(File file, Context context, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            context = e.t.a.b();
        }
        return l(file, context);
    }

    public static final boolean n(@k.e.a.d String str, @k.e.a.d Context context) {
        return a.a.d(str, context);
    }

    public static /* synthetic */ boolean o(String str, Context context, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            context = e.t.a.b();
        }
        return n(str, context);
    }

    public static final long p(@k.e.a.d File file) {
        long j2 = 0;
        if (file.exists()) {
            if (file.isFile()) {
                return file.length();
            }
            ArrayDeque arrayDeque = new ArrayDeque();
            arrayDeque.addLast(file);
            while (!arrayDeque.isEmpty()) {
                File file2 = (File) arrayDeque.getFirst();
                if (file2.isFile()) {
                    j2 += file2.length();
                } else {
                    File[] listFiles = file2.listFiles();
                    if (listFiles != null) {
                        for (File file3 : listFiles) {
                            arrayDeque.addLast(file3);
                        }
                    }
                }
                arrayDeque.pollFirst();
            }
        }
        return j2;
    }

    @k.e.a.d
    public static final FileInputStream q(@k.e.a.d FileDescriptor fileDescriptor) {
        return new FileInputStream(fileDescriptor);
    }

    @k.e.a.d
    public static final FileOutputStream r(@k.e.a.d FileDescriptor fileDescriptor) {
        return new FileOutputStream(fileDescriptor);
    }

    @e
    public static final byte[] s(@k.e.a.d File file, @k.e.a.d Context context) {
        return a.a.h(file, context);
    }

    public static /* synthetic */ byte[] t(File file, Context context, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            context = e.t.a.b();
        }
        return s(file, context);
    }

    @k.e.a.d
    public static final String u(@k.e.a.d File file, @k.e.a.d Context context) {
        return a.a.e(file, context);
    }

    public static /* synthetic */ String v(File file, Context context, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            context = e.t.a.b();
        }
        return u(file, context);
    }

    public static final boolean w(@k.e.a.d File file, @k.e.a.d Object obj, @k.e.a.d Context context) {
        return a.a.c(file, obj, context);
    }

    public static final boolean x(@k.e.a.d File file, @k.e.a.d String str, @k.e.a.d Charset charset, @k.e.a.d Context context) {
        return a.a.b(file, str, context, charset);
    }

    public static final boolean y(@k.e.a.d File file, @k.e.a.d byte[] bArr, @k.e.a.d Context context) {
        return a.a.a(file, bArr, context);
    }

    public static /* synthetic */ boolean z(File file, Object obj, Context context, int i2, Object obj2) {
        if ((i2 & 2) != 0) {
            context = e.t.a.b();
        }
        return w(file, obj, context);
    }
}
