package androidx.core.database;

import android.database.CursorWindow;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public final class CursorWindowCompat {
    private CursorWindowCompat() {
    }

    @NonNull
    public static CursorWindow create(@Nullable String str, long j2) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            return new CursorWindow(str, j2);
        }
        if (i2 >= 15) {
            return new CursorWindow(str);
        }
        return new CursorWindow(false);
    }
}
