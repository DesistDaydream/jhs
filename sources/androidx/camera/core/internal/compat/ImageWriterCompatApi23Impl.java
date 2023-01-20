package androidx.camera.core.internal.compat;

import android.media.Image;
import android.media.ImageWriter;
import android.view.Surface;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

@RequiresApi(23)
/* loaded from: classes.dex */
public final class ImageWriterCompatApi23Impl {
    private ImageWriterCompatApi23Impl() {
    }

    public static void close(ImageWriter imageWriter) {
        imageWriter.close();
    }

    @NonNull
    public static Image dequeueInputImage(@NonNull ImageWriter imageWriter) {
        return imageWriter.dequeueInputImage();
    }

    @NonNull
    public static ImageWriter newInstance(@NonNull Surface surface, @IntRange(from = 1) int i2) {
        return ImageWriter.newInstance(surface, i2);
    }

    public static void queueInputImage(@NonNull ImageWriter imageWriter, @NonNull Image image) {
        imageWriter.queueInputImage(image);
    }
}
