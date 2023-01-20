package androidx.camera.core;

import android.util.Range;
import android.util.Rational;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

@RequiresApi(21)
/* loaded from: classes.dex */
public interface ExposureState {
    int getExposureCompensationIndex();

    @NonNull
    Range<Integer> getExposureCompensationRange();

    @NonNull
    Rational getExposureCompensationStep();

    boolean isExposureCompensationSupported();
}
