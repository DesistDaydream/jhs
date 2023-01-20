package e.t.m;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Build;
import androidx.exifinterface.media.ExifInterface;
import e.t.l.z;
import java.io.FileDescriptor;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"compatExif", "Landroidx/exifinterface/media/ExifInterface;", "url", "", "vector_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class a {
    @k.e.a.d
    public static final ExifInterface a(@k.e.a.d String str) {
        ExifInterface exifInterface;
        if (Build.VERSION.SDK_INT >= 29) {
            if (z.j(str)) {
                AssetFileDescriptor o = z.o(Uri.parse(str), null, null, 3, null);
                FileDescriptor fileDescriptor = o != null ? o.getFileDescriptor() : null;
                if (fileDescriptor != null) {
                    return new ExifInterface(fileDescriptor);
                }
                exifInterface = new ExifInterface(str);
            } else {
                exifInterface = new ExifInterface(str);
            }
        } else {
            exifInterface = new ExifInterface(str);
        }
        return exifInterface;
    }
}
