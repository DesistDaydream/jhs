package androidx.core.net;

import android.net.Uri;
import h.k2.v.f0;
import java.io.File;
import k.e.a.d;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\r\u0010\u0003\u001a\u00020\u0002*\u00020\u0001H\u0086\b\u001a\r\u0010\u0003\u001a\u00020\u0002*\u00020\u0004H\u0086\b¨\u0006\u0005"}, d2 = {"toFile", "Ljava/io/File;", "Landroid/net/Uri;", "toUri", "", "core-ktx_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class UriKt {
    @d
    public static final File toFile(@d Uri uri) {
        if (f0.g(uri.getScheme(), "file")) {
            String path = uri.getPath();
            if (path != null) {
                return new File(path);
            }
            throw new IllegalArgumentException(f0.C("Uri path is null: ", uri).toString());
        }
        throw new IllegalArgumentException(f0.C("Uri lacks 'file' scheme: ", uri).toString());
    }

    @d
    public static final Uri toUri(@d String str) {
        return Uri.parse(str);
    }

    @d
    public static final Uri toUri(@d File file) {
        return Uri.fromFile(file);
    }
}
