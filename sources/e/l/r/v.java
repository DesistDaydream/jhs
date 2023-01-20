package e.l.r;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import androidx.core.content.FileProvider;
import java.io.File;

/* loaded from: classes2.dex */
public final class v {
    @k.e.a.e
    public static final Uri a(@k.e.a.d Context context, @k.e.a.d File file) {
        if (Build.VERSION.SDK_INT >= 24) {
            return FileProvider.getUriForFile(context, e.t.m.e.a(), file);
        }
        return Uri.fromFile(file);
    }
}
