package e.t.m;

import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import com.vector.filecompat.executor.DescriptorFileExecutor;
import e.t.l.z;
import e.t.u.g;
import java.io.File;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u0016\u0010\b\u001a\u0004\u0018\u00010\t*\u00020\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¨\u0006\f"}, d2 = {"compatFile", "Lcom/vector/filecompat/CompatFile;", "uri", "Landroid/net/Uri;", "file", "Ljava/io/File;", "path", "", "toBitMap", "Landroid/graphics/Bitmap;", "option", "Landroid/graphics/BitmapFactory$Options;", "vector_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class c {
    @k.e.a.d
    public static final b a(@k.e.a.d Uri uri) {
        return new DescriptorFileExecutor(uri);
    }

    @k.e.a.e
    public static final b b(@k.e.a.d File file) {
        if (g.a.p()) {
            return new DescriptorFileExecutor(Uri.fromFile(file));
        }
        return new e.t.m.f.a(file);
    }

    @k.e.a.d
    public static final b c(@k.e.a.d String str) {
        if (g.a.p()) {
            if (z.j(str)) {
                return new DescriptorFileExecutor(Uri.parse(str));
            }
            File file = new File(str);
            Uri fromFile = Uri.fromFile(file);
            if (file.canRead()) {
                return new e.t.m.f.a(file);
            }
            return new DescriptorFileExecutor(fromFile);
        }
        return new e.t.m.f.a(new File(str));
    }

    @k.e.a.e
    public static final Bitmap d(@k.e.a.d b bVar, @k.e.a.e BitmapFactory.Options options) {
        if (bVar instanceof e.t.m.f.a) {
            return BitmapFactory.decodeFile(bVar.g(""), options);
        }
        if (bVar instanceof DescriptorFileExecutor) {
            AssetFileDescriptor o = z.o(((DescriptorFileExecutor) bVar).j(), null, null, 3, null);
            return BitmapFactory.decodeFileDescriptor(o == null ? null : o.getFileDescriptor(), null, options);
        }
        return null;
    }
}
