package androidx.camera.camera2.internal.compat.quirk;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.Quirk;
import java.util.ArrayList;
import java.util.List;

@RequiresApi(21)
/* loaded from: classes.dex */
public class DeviceQuirksLoader {
    private DeviceQuirksLoader() {
    }

    @NonNull
    public static List<Quirk> loadQuirks() {
        ArrayList arrayList = new ArrayList();
        if (ImageCapturePixelHDRPlusQuirk.load()) {
            arrayList.add(new ImageCapturePixelHDRPlusQuirk());
        }
        if (ExtraCroppingQuirk.load()) {
            arrayList.add(new ExtraCroppingQuirk());
        }
        if (Nexus4AndroidLTargetAspectRatioQuirk.load()) {
            arrayList.add(new Nexus4AndroidLTargetAspectRatioQuirk());
        }
        if (ExcludedSupportedSizesQuirk.load()) {
            arrayList.add(new ExcludedSupportedSizesQuirk());
        }
        if (CrashWhenTakingPhotoWithAutoFlashAEModeQuirk.load()) {
            arrayList.add(new CrashWhenTakingPhotoWithAutoFlashAEModeQuirk());
        }
        if (PreviewPixelHDRnetQuirk.load()) {
            arrayList.add(new PreviewPixelHDRnetQuirk());
        }
        if (StillCaptureFlashStopRepeatingQuirk.load()) {
            arrayList.add(new StillCaptureFlashStopRepeatingQuirk());
        }
        if (ExtraSupportedSurfaceCombinationsQuirk.load()) {
            arrayList.add(new ExtraSupportedSurfaceCombinationsQuirk());
        }
        if (FlashAvailabilityBufferUnderflowQuirk.load()) {
            arrayList.add(new FlashAvailabilityBufferUnderflowQuirk());
        }
        if (RepeatingStreamConstraintForVideoRecordingQuirk.load()) {
            arrayList.add(new RepeatingStreamConstraintForVideoRecordingQuirk());
        }
        if (TextureViewIsClosedQuirk.load()) {
            arrayList.add(new TextureViewIsClosedQuirk());
        }
        if (CaptureSessionOnClosedNotCalledQuirk.load()) {
            arrayList.add(new CaptureSessionOnClosedNotCalledQuirk());
        }
        return arrayList;
    }
}
