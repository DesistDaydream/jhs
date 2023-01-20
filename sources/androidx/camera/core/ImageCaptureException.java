package androidx.camera.core;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

@RequiresApi(21)
/* loaded from: classes.dex */
public class ImageCaptureException extends Exception {
    private final int mImageCaptureError;

    public ImageCaptureException(int i2, @NonNull String str, @Nullable Throwable th) {
        super(str, th);
        this.mImageCaptureError = i2;
    }

    public int getImageCaptureError() {
        return this.mImageCaptureError;
    }
}
