package com.yalantis.ucrop.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.yalantis.ucrop.callback.BitmapLoadCallback;
import com.yalantis.ucrop.task.BitmapLoadTask;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public class BitmapLoadUtils {
    private static final String TAG = "BitmapLoadUtils";

    public static int calculateInSampleSize(@NonNull BitmapFactory.Options options, int i2, int i3) {
        int i4 = options.outHeight;
        int i5 = options.outWidth;
        int i6 = 1;
        if (i4 > i3 || i5 > i2) {
            while (true) {
                if (i4 / i6 <= i3 && i5 / i6 <= i2) {
                    break;
                }
                i6 *= 2;
            }
        }
        return i6;
    }

    public static int calculateMaxBitmapSize(@NonNull Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Point point = new Point();
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getSize(point);
        }
        int sqrt = (int) Math.sqrt(Math.pow(point.x, 2.0d) + Math.pow(point.y, 2.0d));
        Canvas canvas = new Canvas();
        int min = Math.min(canvas.getMaximumBitmapWidth(), canvas.getMaximumBitmapHeight());
        if (min > 0) {
            sqrt = Math.min(sqrt, min);
        }
        int maxTextureSize = EglUtils.getMaxTextureSize();
        if (maxTextureSize > 0) {
            sqrt = Math.min(sqrt, maxTextureSize);
        }
        Log.d(TAG, "maxBitmapSize: " + sqrt);
        return sqrt;
    }

    public static void close(@Nullable Closeable closeable) {
        if (closeable == null || !(closeable instanceof Closeable)) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    public static void decodeBitmapInBackground(@NonNull Context context, @NonNull Uri uri, @Nullable Uri uri2, int i2, int i3, BitmapLoadCallback bitmapLoadCallback) {
        new BitmapLoadTask(context, uri, uri2, i2, i3, bitmapLoadCallback).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public static int exifToDegrees(int i2) {
        switch (i2) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    public static int exifToTranslation(int i2) {
        return (i2 == 2 || i2 == 7 || i2 == 4 || i2 == 5) ? -1 : 1;
    }

    public static int getExifOrientation(@NonNull Context context, @NonNull Uri uri) {
        int i2 = 0;
        try {
            InputStream openInputStream = context.getContentResolver().openInputStream(uri);
            if (openInputStream == null) {
                return 0;
            }
            i2 = new ImageHeaderParser(openInputStream).getOrientation();
            close(openInputStream);
            return i2;
        } catch (IOException e2) {
            Log.e(TAG, "getExifOrientation: " + uri.toString(), e2);
            return i2;
        }
    }

    public static Bitmap transformBitmap(@NonNull Bitmap bitmap, @NonNull Matrix matrix) {
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            return !bitmap.sameAs(createBitmap) ? createBitmap : bitmap;
        } catch (OutOfMemoryError e2) {
            Log.e(TAG, "transformBitmap: ", e2);
            return bitmap;
        }
    }
}
