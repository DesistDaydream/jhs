package e.t.h.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import e.t.l.w;
import java.io.File;
import java.nio.charset.Charset;
import k.b.a.a.n.n.c;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0016J$\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0007\u001a\u00020\bH&J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH&J\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\u0018\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J \u0010\u0016\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\bH&J \u0010\u0016\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\bH&J(\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016¨\u0006\u001c"}, d2 = {"Lcom/vector/compat/file/FileOption;", "", "copyTo", "", "src", "Ljava/io/File;", "dest", "context", "Landroid/content/Context;", "srcPath", "", "destPath", "decodeToBitmap", "Landroid/graphics/Bitmap;", "file", "options", "Landroid/graphics/BitmapFactory$Options;", "exists", "path", "readBytes", "", "readString", "write", c.b, "bytes", "text", "charset", "Ljava/nio/charset/Charset;", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public interface a {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* renamed from: e.t.h.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0405a {
        public static boolean a(@d a aVar, @d String str, @d String str2, @d Context context) {
            return aVar.j(w.m(str), w.m(str2), context);
        }

        @d
        public static String b(@d a aVar, @d File file, @d Context context) {
            byte[] h2 = aVar.h(file, context);
            return h2 == null ? "" : w.t(new String(h2, h.t2.d.a));
        }

        public static boolean c(@d a aVar, @d File file, @d String str, @d Context context, @d Charset charset) {
            return aVar.a(file, str.getBytes(charset), context);
        }
    }

    boolean a(@d File file, @d byte[] bArr, @d Context context);

    boolean b(@d File file, @d String str, @d Context context, @d Charset charset);

    boolean c(@d File file, @d Object obj, @d Context context);

    boolean d(@d String str, @d Context context);

    @d
    String e(@d File file, @d Context context);

    @e
    Bitmap f(@d File file, @e BitmapFactory.Options options, @d Context context);

    boolean g(@d String str, @d String str2, @d Context context);

    @e
    byte[] h(@d File file, @d Context context);

    boolean i(@d File file, @d Context context);

    boolean j(@d File file, @d File file2, @d Context context);
}
