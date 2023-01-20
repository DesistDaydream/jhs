package e.t.n;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import e.t.h.a.a;
import java.io.File;
import java.nio.charset.Charset;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J$\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\nH\u0016J\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u0015\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u0015\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/vector/filecompatnew/FileCompat;", "Lcom/vector/compat/file/FileOption;", "()V", "option", "copyTo", "", "src", "Ljava/io/File;", "dest", "context", "Landroid/content/Context;", "decodeToBitmap", "Landroid/graphics/Bitmap;", "file", "options", "Landroid/graphics/BitmapFactory$Options;", "exists", "path", "", "readBytes", "", "write", k.b.a.a.n.n.c.b, "", "bytes", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class a implements e.t.h.a.a {
    @d
    public static final a a = new a();
    @d
    private static final e.t.h.a.a b;

    static {
        e.t.h.a.a cVar;
        if (Build.VERSION.SDK_INT < 29) {
            cVar = new e.t.h.a.b();
        } else {
            cVar = new c();
        }
        b = cVar;
    }

    private a() {
    }

    @Override // e.t.h.a.a
    public boolean a(@d File file, @d byte[] bArr, @d Context context) {
        return b.a(file, bArr, context);
    }

    @Override // e.t.h.a.a
    public boolean b(@d File file, @d String str, @d Context context, @d Charset charset) {
        return a.C0405a.c(this, file, str, context, charset);
    }

    @Override // e.t.h.a.a
    public boolean c(@d File file, @d Object obj, @d Context context) {
        return b.c(file, obj, context);
    }

    @Override // e.t.h.a.a
    public boolean d(@d String str, @d Context context) {
        return b.d(str, context);
    }

    @Override // e.t.h.a.a
    @d
    public String e(@d File file, @d Context context) {
        return a.C0405a.b(this, file, context);
    }

    @Override // e.t.h.a.a
    @e
    public Bitmap f(@d File file, @e BitmapFactory.Options options, @d Context context) {
        return b.f(file, options, context);
    }

    @Override // e.t.h.a.a
    public boolean g(@d String str, @d String str2, @d Context context) {
        return a.C0405a.a(this, str, str2, context);
    }

    @Override // e.t.h.a.a
    @e
    public byte[] h(@d File file, @d Context context) {
        return b.h(file, context);
    }

    @Override // e.t.h.a.a
    public boolean i(@d File file, @d Context context) {
        return b.i(file, context);
    }

    @Override // e.t.h.a.a
    public boolean j(@d File file, @d File file2, @d Context context) {
        return b.j(file, file2, context);
    }
}
