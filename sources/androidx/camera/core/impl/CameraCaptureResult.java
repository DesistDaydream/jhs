package androidx.camera.core.impl;

import android.hardware.camera2.CaptureResult;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.CameraCaptureMetaData;
import androidx.camera.core.impl.utils.ExifData;
import c.b.b.b2.w;

@RequiresApi(21)
/* loaded from: classes.dex */
public interface CameraCaptureResult {

    /* loaded from: classes.dex */
    public static final class EmptyCameraCaptureResult implements CameraCaptureResult {
        @NonNull
        public static CameraCaptureResult create() {
            return new EmptyCameraCaptureResult();
        }

        @Override // androidx.camera.core.impl.CameraCaptureResult
        @NonNull
        public CameraCaptureMetaData.AeState getAeState() {
            return CameraCaptureMetaData.AeState.UNKNOWN;
        }

        @Override // androidx.camera.core.impl.CameraCaptureResult
        @NonNull
        public CameraCaptureMetaData.AfMode getAfMode() {
            return CameraCaptureMetaData.AfMode.UNKNOWN;
        }

        @Override // androidx.camera.core.impl.CameraCaptureResult
        @NonNull
        public CameraCaptureMetaData.AfState getAfState() {
            return CameraCaptureMetaData.AfState.UNKNOWN;
        }

        @Override // androidx.camera.core.impl.CameraCaptureResult
        @NonNull
        public CameraCaptureMetaData.AwbState getAwbState() {
            return CameraCaptureMetaData.AwbState.UNKNOWN;
        }

        @Override // androidx.camera.core.impl.CameraCaptureResult
        public /* synthetic */ CaptureResult getCaptureResult() {
            return w.$default$getCaptureResult(this);
        }

        @Override // androidx.camera.core.impl.CameraCaptureResult
        @NonNull
        public CameraCaptureMetaData.FlashState getFlashState() {
            return CameraCaptureMetaData.FlashState.UNKNOWN;
        }

        @Override // androidx.camera.core.impl.CameraCaptureResult
        @NonNull
        public TagBundle getTagBundle() {
            return TagBundle.emptyBundle();
        }

        @Override // androidx.camera.core.impl.CameraCaptureResult
        public long getTimestamp() {
            return -1L;
        }

        @Override // androidx.camera.core.impl.CameraCaptureResult
        public /* synthetic */ void populateExifData(ExifData.Builder builder) {
            w.$default$populateExifData(this, builder);
        }
    }

    @NonNull
    CameraCaptureMetaData.AeState getAeState();

    @NonNull
    CameraCaptureMetaData.AfMode getAfMode();

    @NonNull
    CameraCaptureMetaData.AfState getAfState();

    @NonNull
    CameraCaptureMetaData.AwbState getAwbState();

    @NonNull
    CaptureResult getCaptureResult();

    @NonNull
    CameraCaptureMetaData.FlashState getFlashState();

    @NonNull
    TagBundle getTagBundle();

    long getTimestamp();

    void populateExifData(@NonNull ExifData.Builder builder);
}
