package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import android.util.Range;
import android.util.Rational;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.ExposureState;

@RequiresApi(21)
/* loaded from: classes.dex */
public class ExposureStateImpl implements ExposureState {
    private final CameraCharacteristicsCompat mCameraCharacteristics;
    @GuardedBy("mLock")
    private int mExposureCompensation;
    private final Object mLock = new Object();

    public ExposureStateImpl(CameraCharacteristicsCompat cameraCharacteristicsCompat, int i2) {
        this.mCameraCharacteristics = cameraCharacteristicsCompat;
        this.mExposureCompensation = i2;
    }

    @Override // androidx.camera.core.ExposureState
    public int getExposureCompensationIndex() {
        int i2;
        synchronized (this.mLock) {
            i2 = this.mExposureCompensation;
        }
        return i2;
    }

    @Override // androidx.camera.core.ExposureState
    @NonNull
    public Range<Integer> getExposureCompensationRange() {
        return (Range) this.mCameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_COMPENSATION_RANGE);
    }

    @Override // androidx.camera.core.ExposureState
    @NonNull
    public Rational getExposureCompensationStep() {
        if (!isExposureCompensationSupported()) {
            return Rational.ZERO;
        }
        return (Rational) this.mCameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_COMPENSATION_STEP);
    }

    @Override // androidx.camera.core.ExposureState
    public boolean isExposureCompensationSupported() {
        Range range = (Range) this.mCameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_COMPENSATION_RANGE);
        return (range == null || ((Integer) range.getLower()).intValue() == 0 || ((Integer) range.getUpper()).intValue() == 0) ? false : true;
    }

    public void setExposureCompensationIndex(int i2) {
        synchronized (this.mLock) {
            this.mExposureCompensation = i2;
        }
    }
}
