package e.t.n;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Log;
import e.t.h.a.a;
import e.t.l.w;
import e.t.l.z;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.Charset;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0016J$\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0002J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\tH\u0002J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0016J \u0010\u0016\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\tH\u0016J \u0010\u0016\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\u001a"}, d2 = {"Lcom/vector/filecompatnew/FileOptionImpl29;", "Lcom/vector/compat/file/FileOption;", "()V", "copyTo", "", "src", "Ljava/io/File;", "dest", "context", "Landroid/content/Context;", "decodeToBitmap", "Landroid/graphics/Bitmap;", "file", "options", "Landroid/graphics/BitmapFactory$Options;", "exists", "path", "", "getDescriptor", "Landroid/content/res/AssetFileDescriptor;", "readBytes", "", "write", k.b.a.a.n.n.c.b, "", "bytes", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class c implements e.t.h.a.a {
    private final AssetFileDescriptor k(File file, Context context) {
        return l(file.getAbsolutePath(), context);
    }

    private final AssetFileDescriptor l(String str, Context context) {
        return context.getContentResolver().openAssetFileDescriptor(Uri.parse(str), "r");
    }

    @Override // e.t.h.a.a
    public boolean a(@d File file, @d byte[] bArr, @d Context context) {
        AssetFileDescriptor k2 = k(file, context);
        if (k2 == null) {
            return false;
        }
        FileOutputStream r = b.r(k2.getFileDescriptor());
        Boolean bool = null;
        try {
            r.write(bArr);
            Boolean bool2 = Boolean.TRUE;
            h.h2.b.a(r, null);
            bool = bool2;
        } catch (Throwable th) {
            Log.e("safeUse", String.valueOf(th.getMessage()));
        }
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    @Override // e.t.h.a.a
    public boolean b(@d File file, @d String str, @d Context context, @d Charset charset) {
        return a.C0405a.c(this, file, str, context, charset);
    }

    @Override // e.t.h.a.a
    public boolean c(@d File file, @d Object obj, @d Context context) {
        AssetFileDescriptor k2 = k(file, context);
        if (k2 == null) {
            return false;
        }
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(b.r(k2.getFileDescriptor()));
        Boolean bool = null;
        try {
            objectOutputStream.writeObject(obj);
            Boolean bool2 = Boolean.TRUE;
            h.h2.b.a(objectOutputStream, null);
            bool = bool2;
        } catch (Throwable th) {
            Log.e("safeUse", String.valueOf(th.getMessage()));
        }
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    @Override // e.t.h.a.a
    public boolean d(@d String str, @d Context context) {
        if (z.j(str)) {
            return z.e(Uri.parse(str), context);
        }
        File m2 = w.m(str);
        if (m2.canRead()) {
            return m2.exists();
        }
        return z.e(Uri.fromFile(w.m(str)), context);
    }

    @Override // e.t.h.a.a
    @d
    public String e(@d File file, @d Context context) {
        return a.C0405a.b(this, file, context);
    }

    @Override // e.t.h.a.a
    @e
    public Bitmap f(@d File file, @e BitmapFactory.Options options, @d Context context) {
        AssetFileDescriptor k2 = k(file, context);
        if (k2 == null) {
            return null;
        }
        return BitmapFactory.decodeFileDescriptor(k2.getFileDescriptor(), null, options);
    }

    @Override // e.t.h.a.a
    public boolean g(@d String str, @d String str2, @d Context context) {
        return a.C0405a.a(this, str, str2, context);
    }

    @Override // e.t.h.a.a
    @e
    public byte[] h(@d File file, @d Context context) {
        AssetFileDescriptor k2 = k(file, context);
        if (k2 == null) {
            return null;
        }
        FileInputStream q = b.q(k2.getFileDescriptor());
        try {
            byte[] p = h.h2.a.p(q);
            h.h2.b.a(q, null);
            return p;
        } catch (Throwable th) {
            Log.e("safeUse", String.valueOf(th.getMessage()));
            return null;
        }
    }

    @Override // e.t.h.a.a
    public boolean i(@d File file, @d Context context) {
        String absolutePath = file.getAbsolutePath();
        if (z.j(absolutePath)) {
            return z.e(Uri.parse(absolutePath), context);
        }
        if (file.canRead()) {
            return file.exists();
        }
        return z.e(Uri.fromFile(file), context);
    }

    @Override // e.t.h.a.a
    public boolean j(@d File file, @d File file2, @d Context context) {
        return z.c(Uri.parse(file.getAbsolutePath()), file2, null, 2, null);
    }
}
