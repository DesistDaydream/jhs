package androidx.camera.core.internal.compat;

import android.media.Image;
import android.media.ImageWriter;
import android.os.Build;
import android.view.Surface;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

@RequiresApi(23)
/* loaded from: classes.dex */
public final class ImageWriterCompat {
    private ImageWriterCompat() {
    }

    public static void close(@NonNull ImageWriter imageWriter) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            ImageWriterCompatApi23Impl.close(imageWriter);
            return;
        }
        throw new RuntimeException("Unable to call close() on API " + i2 + ". Version 23 or higher required.");
    }

    @NonNull
    public static Image dequeueInputImage(@NonNull ImageWriter imageWriter) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            return ImageWriterCompatApi23Impl.dequeueInputImage(imageWriter);
        }
        throw new RuntimeException("Unable to call dequeueInputImage() on API " + i2 + ". Version 23 or higher required.");
    }

    @NonNull
    public static ImageWriter newInstance(@NonNull Surface surface, @IntRange(from = 1) int i2, int i3) {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 29) {
            return ImageWriterCompatApi29Impl.newInstance(surface, i2, i3);
        }
        if (i4 >= 26) {
            return ImageWriterCompatApi26Impl.newInstance(surface, i2, i3);
        }
        throw new RuntimeException("Unable to call newInstance(Surface, int, int) on API " + i4 + ". Version 26 or higher required.");
    }

    public static void queueInputImage(@NonNull ImageWriter imageWriter, @NonNull Image image) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            ImageWriterCompatApi23Impl.queueInputImage(imageWriter, image);
            return;
        }
        throw new RuntimeException("Unable to call queueInputImage() on API " + i2 + ". Version 23 or higher required.");
    }

    @NonNull
    public static ImageWriter newInstance(@NonNull Surface surface, @IntRange(from = 1) int i2) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 23) {
            return ImageWriterCompatApi23Impl.newInstance(surface, i2);
        }
        throw new RuntimeException("Unable to call newInstance(Surface, int) on API " + i3 + ". Version 23 or higher required.");
    }
}
