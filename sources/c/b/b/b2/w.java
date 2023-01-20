package c.b.b.b2;

import android.hardware.camera2.CaptureResult;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.utils.ExifData;

/* compiled from: CameraCaptureResult.java */
/* loaded from: classes.dex */
public final /* synthetic */ class w {
    @NonNull
    public static CaptureResult $default$getCaptureResult(CameraCaptureResult _this) {
        return CameraCaptureResult.EmptyCameraCaptureResult.create().getCaptureResult();
    }

    public static void $default$populateExifData(@NonNull CameraCaptureResult _this, ExifData.Builder builder) {
        builder.setFlashState(_this.getFlashState());
    }
}
