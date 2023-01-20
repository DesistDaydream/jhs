package androidx.camera.core.internal.utils;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.Logger;
import androidx.core.util.Preconditions;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class VideoUtil {
    private static final String TAG = "VideoUtil";

    private VideoUtil() {
    }

    @Nullable
    public static String getAbsolutePathFromUri(@NonNull ContentResolver contentResolver, @NonNull Uri uri) {
        Cursor cursor = null;
        try {
            try {
                cursor = contentResolver.query(uri, new String[]{"_data"}, null, null, null);
                Cursor cursor2 = (Cursor) Preconditions.checkNotNull(cursor);
                try {
                    int columnIndexOrThrow = cursor2.getColumnIndexOrThrow("_data");
                    cursor2.moveToFirst();
                    String string = cursor2.getString(columnIndexOrThrow);
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    return string;
                } catch (RuntimeException e2) {
                    e = e2;
                    cursor = cursor2;
                    Logger.e(TAG, String.format("Failed in getting absolute path for Uri %s with Exception %s", uri.toString(), e.toString()));
                    if (cursor != null) {
                        cursor.close();
                    }
                    return "";
                } catch (Throwable th) {
                    th = th;
                    cursor = cursor2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (RuntimeException e3) {
                e = e3;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
