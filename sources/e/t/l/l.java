package e.t.l;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayDeque;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u001a\u0014\u0010\u0003\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u00020\u00072\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u001a\u0014\u0010\b\u001a\u00020\u0001*\u00020\u00072\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u001a\n\u0010\t\u001a\u00020\n*\u00020\u0002\u001a\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u0007*\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u001a\u0012\u0010\f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e\u001a\u0012\u0010\f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0007\u001a\"\u0010\f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e\u001a\u0014\u0010\u0012\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u001a\u001c\u0010\u0013\u001a\u00020\u0014*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0004\u001a\u00020\u0005¨\u0006\u0017"}, d2 = {"deleteAll", "", "Ljava/io/File;", "ensureExist", "context", "Landroid/content/Context;", "ensureFileExist", "", "fileExist", "getSize", "", "readString", "save", "bytes", "", "text", "filePath", "fileName", "saveToAlbum", "write", "", k.b.a.a.n.n.c.b, "", "vector_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class l {
    public static final boolean a(@k.e.a.e File file) {
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

    public static final boolean b(@k.e.a.d File file, @k.e.a.d Context context) {
        if (e.t.m.d.a.a(file, context)) {
            return true;
        }
        return file.mkdirs();
    }

    public static /* synthetic */ boolean c(File file, Context context, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            context = e.t.a.b();
        }
        return b(file, context);
    }

    public static final boolean d(@k.e.a.d String str, @k.e.a.d Context context) {
        return b(new File(str), context);
    }

    public static /* synthetic */ boolean e(String str, Context context, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            context = e.t.a.b();
        }
        return d(str, context);
    }

    public static final boolean f(@k.e.a.d String str, @k.e.a.d Context context) {
        return e.t.m.d.a.b(str, context);
    }

    public static /* synthetic */ boolean g(String str, Context context, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            context = e.t.a.b();
        }
        return f(str, context);
    }

    public static final long h(@k.e.a.d File file) {
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

    @k.e.a.e
    public static final String i(@k.e.a.d File file, @k.e.a.d Context context) {
        return e.t.m.d.a.e(file, context);
    }

    public static /* synthetic */ String j(File file, Context context, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            context = e.t.a.b();
        }
        return i(file, context);
    }

    public static final boolean k(@k.e.a.d File file, @k.e.a.d String str) {
        return m(file, str.getBytes(h.t2.d.a));
    }

    public static final boolean l(@k.e.a.d File file, @k.e.a.d String str, @k.e.a.d String str2, @k.e.a.d byte[] bArr) {
        return m(new File(str, str2), bArr);
    }

    public static final boolean m(@k.e.a.d File file, @k.e.a.d byte[] bArr) {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        Boolean bool = null;
        try {
            e(file.getAbsolutePath(), null, 1, null);
            fileOutputStream.write(bArr);
            Boolean bool2 = Boolean.TRUE;
            h.h2.b.a(fileOutputStream, null);
            bool = bool2;
        } catch (Throwable th) {
            Log.e("safeUse", String.valueOf(th.getMessage()));
        }
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public static final boolean n(@k.e.a.d File file, @k.e.a.d Context context) {
        return e.t.m.d.a.g(file, context);
    }

    public static /* synthetic */ boolean o(File file, Context context, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            context = e.t.a.b();
        }
        return n(file, context);
    }

    public static final void p(@k.e.a.d File file, @k.e.a.d Object obj, @k.e.a.d Context context) {
        e.t.m.d.a.h(file, obj, context);
    }

    public static /* synthetic */ void q(File file, Object obj, Context context, int i2, Object obj2) {
        if ((i2 & 2) != 0) {
            context = e.t.a.b();
        }
        p(file, obj, context);
    }
}
