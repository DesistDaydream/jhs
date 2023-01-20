package androidx.camera.camera2.internal;

import android.graphics.Rect;
import android.hardware.camera2.CaptureResult;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraCaptureMetaData;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.impl.utils.ExifData;

@RequiresApi(21)
/* loaded from: classes.dex */
public class Camera2CameraCaptureResult implements CameraCaptureResult {
    private static final String TAG = "C2CameraCaptureResult";
    private final CaptureResult mCaptureResult;
    private final TagBundle mTagBundle;

    public Camera2CameraCaptureResult(@NonNull TagBundle tagBundle, @NonNull CaptureResult captureResult) {
        this.mTagBundle = tagBundle;
        this.mCaptureResult = captureResult;
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    @NonNull
    public CameraCaptureMetaData.AeState getAeState() {
        Integer num = (Integer) this.mCaptureResult.get(CaptureResult.CONTROL_AE_STATE);
        if (num == null) {
            return CameraCaptureMetaData.AeState.UNKNOWN;
        }
        int intValue = num.intValue();
        if (intValue != 0) {
            if (intValue != 1) {
                if (intValue == 2) {
                    return CameraCaptureMetaData.AeState.CONVERGED;
                }
                if (intValue == 3) {
                    return CameraCaptureMetaData.AeState.LOCKED;
                }
                if (intValue == 4) {
                    return CameraCaptureMetaData.AeState.FLASH_REQUIRED;
                }
                if (intValue != 5) {
                    Logger.e(TAG, "Undefined ae state: " + num);
                    return CameraCaptureMetaData.AeState.UNKNOWN;
                }
            }
            return CameraCaptureMetaData.AeState.SEARCHING;
        }
        return CameraCaptureMetaData.AeState.INACTIVE;
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    @NonNull
    public CameraCaptureMetaData.AfMode getAfMode() {
        Integer num = (Integer) this.mCaptureResult.get(CaptureResult.CONTROL_AF_MODE);
        if (num == null) {
            return CameraCaptureMetaData.AfMode.UNKNOWN;
        }
        int intValue = num.intValue();
        if (intValue != 0) {
            if (intValue == 1 || intValue == 2) {
                return CameraCaptureMetaData.AfMode.ON_MANUAL_AUTO;
            }
            if (intValue == 3 || intValue == 4) {
                return CameraCaptureMetaData.AfMode.ON_CONTINUOUS_AUTO;
            }
            if (intValue != 5) {
                Logger.e(TAG, "Undefined af mode: " + num);
                return CameraCaptureMetaData.AfMode.UNKNOWN;
            }
        }
        return CameraCaptureMetaData.AfMode.OFF;
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    @NonNull
    public CameraCaptureMetaData.AfState getAfState() {
        Integer num = (Integer) this.mCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
        if (num == null) {
            return CameraCaptureMetaData.AfState.UNKNOWN;
        }
        switch (num.intValue()) {
            case 0:
                return CameraCaptureMetaData.AfState.INACTIVE;
            case 1:
            case 3:
                return CameraCaptureMetaData.AfState.SCANNING;
            case 2:
                return CameraCaptureMetaData.AfState.PASSIVE_FOCUSED;
            case 4:
                return CameraCaptureMetaData.AfState.LOCKED_FOCUSED;
            case 5:
                return CameraCaptureMetaData.AfState.LOCKED_NOT_FOCUSED;
            case 6:
                return CameraCaptureMetaData.AfState.PASSIVE_NOT_FOCUSED;
            default:
                Logger.e(TAG, "Undefined af state: " + num);
                return CameraCaptureMetaData.AfState.UNKNOWN;
        }
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    @NonNull
    public CameraCaptureMetaData.AwbState getAwbState() {
        Integer num = (Integer) this.mCaptureResult.get(CaptureResult.CONTROL_AWB_STATE);
        if (num == null) {
            return CameraCaptureMetaData.AwbState.UNKNOWN;
        }
        int intValue = num.intValue();
        if (intValue != 0) {
            if (intValue != 1) {
                if (intValue != 2) {
                    if (intValue != 3) {
                        Logger.e(TAG, "Undefined awb state: " + num);
                        return CameraCaptureMetaData.AwbState.UNKNOWN;
                    }
                    return CameraCaptureMetaData.AwbState.LOCKED;
                }
                return CameraCaptureMetaData.AwbState.CONVERGED;
            }
            return CameraCaptureMetaData.AwbState.METERING;
        }
        return CameraCaptureMetaData.AwbState.INACTIVE;
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    @NonNull
    public CaptureResult getCaptureResult() {
        return this.mCaptureResult;
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    @NonNull
    public CameraCaptureMetaData.FlashState getFlashState() {
        Integer num = (Integer) this.mCaptureResult.get(CaptureResult.FLASH_STATE);
        if (num == null) {
            return CameraCaptureMetaData.FlashState.UNKNOWN;
        }
        int intValue = num.intValue();
        if (intValue == 0 || intValue == 1) {
            return CameraCaptureMetaData.FlashState.NONE;
        }
        if (intValue != 2) {
            if (intValue != 3 && intValue != 4) {
                Logger.e(TAG, "Undefined flash state: " + num);
                return CameraCaptureMetaData.FlashState.UNKNOWN;
            }
            return CameraCaptureMetaData.FlashState.FIRED;
        }
        return CameraCaptureMetaData.FlashState.READY;
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    @NonNull
    public TagBundle getTagBundle() {
        return this.mTagBundle;
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    public long getTimestamp() {
        Long l2 = (Long) this.mCaptureResult.get(CaptureResult.SENSOR_TIMESTAMP);
        if (l2 == null) {
            return -1L;
        }
        return l2.longValue();
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    public void populateExifData(@NonNull ExifData.Builder builder) {
        Integer num;
        builder.setFlashState(getFlashState());
        Rect rect = (Rect) this.mCaptureResult.get(CaptureResult.SCALER_CROP_REGION);
        if (rect != null) {
            builder.setImageWidth(rect.width()).setImageHeight(rect.height());
        }
        Integer num2 = (Integer) this.mCaptureResult.get(CaptureResult.JPEG_ORIENTATION);
        if (num2 != null) {
            builder.setOrientationDegrees(num2.intValue());
        }
        Long l2 = (Long) this.mCaptureResult.get(CaptureResult.SENSOR_EXPOSURE_TIME);
        if (l2 != null) {
            builder.setExposureTimeNanos(l2.longValue());
        }
        Float f2 = (Float) this.mCaptureResult.get(CaptureResult.LENS_APERTURE);
        if (f2 != null) {
            builder.setLensFNumber(f2.floatValue());
        }
        Integer num3 = (Integer) this.mCaptureResult.get(CaptureResult.SENSOR_SENSITIVITY);
        if (num3 != null) {
            if (Build.VERSION.SDK_INT >= 24 && (num = (Integer) this.mCaptureResult.get(CaptureResult.CONTROL_POST_RAW_SENSITIVITY_BOOST)) != null) {
                num3 = Integer.valueOf(num3.intValue() * ((int) (num.intValue() / 100.0f)));
            }
            builder.setIso(num3.intValue());
        }
        Float f3 = (Float) this.mCaptureResult.get(CaptureResult.LENS_FOCAL_LENGTH);
        if (f3 != null) {
            builder.setFocalLength(f3.floatValue());
        }
        Integer num4 = (Integer) this.mCaptureResult.get(CaptureResult.CONTROL_AWB_MODE);
        if (num4 != null) {
            ExifData.WhiteBalanceMode whiteBalanceMode = ExifData.WhiteBalanceMode.AUTO;
            if (num4.intValue() == 0) {
                whiteBalanceMode = ExifData.WhiteBalanceMode.MANUAL;
            }
            builder.setWhiteBalanceMode(whiteBalanceMode);
        }
    }

    public Camera2CameraCaptureResult(@NonNull CaptureResult captureResult) {
        this(TagBundle.emptyBundle(), captureResult);
    }
}
