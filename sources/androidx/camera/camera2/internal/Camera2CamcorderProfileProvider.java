package androidx.camera.camera2.internal;

import android.media.CamcorderProfile;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.quirk.CamcorderProfileResolutionQuirk;
import androidx.camera.camera2.internal.compat.quirk.CameraQuirks;
import androidx.camera.camera2.internal.compat.workaround.CamcorderProfileResolutionValidator;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CamcorderProfileProvider;
import androidx.camera.core.impl.CamcorderProfileProxy;

@RequiresApi(21)
/* loaded from: classes.dex */
public class Camera2CamcorderProfileProvider implements CamcorderProfileProvider {
    private static final String TAG = "Camera2CamcorderProfileProvider";
    private final CamcorderProfileResolutionValidator mCamcorderProfileResolutionValidator;
    private final int mCameraId;
    private final boolean mHasValidCameraId;

    public Camera2CamcorderProfileProvider(@NonNull String str, @NonNull CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        boolean z;
        int i2;
        try {
            i2 = Integer.parseInt(str);
            z = true;
        } catch (NumberFormatException unused) {
            Logger.w(TAG, "Camera id is not an integer: " + str + ", unable to create CamcorderProfileProvider");
            z = false;
            i2 = -1;
        }
        this.mHasValidCameraId = z;
        this.mCameraId = i2;
        this.mCamcorderProfileResolutionValidator = new CamcorderProfileResolutionValidator((CamcorderProfileResolutionQuirk) CameraQuirks.get(str, cameraCharacteristicsCompat).get(CamcorderProfileResolutionQuirk.class));
    }

    @Nullable
    private CamcorderProfileProxy getProfileInternal(int i2) {
        CamcorderProfile camcorderProfile;
        try {
            camcorderProfile = CamcorderProfile.get(this.mCameraId, i2);
        } catch (RuntimeException e2) {
            Logger.w(TAG, "Unable to get CamcorderProfile by quality: " + i2, e2);
            camcorderProfile = null;
        }
        if (camcorderProfile != null) {
            return CamcorderProfileProxy.fromCamcorderProfile(camcorderProfile);
        }
        return null;
    }

    @Override // androidx.camera.core.impl.CamcorderProfileProvider
    @Nullable
    public CamcorderProfileProxy get(int i2) {
        if (this.mHasValidCameraId && CamcorderProfile.hasProfile(this.mCameraId, i2)) {
            CamcorderProfileProxy profileInternal = getProfileInternal(i2);
            if (this.mCamcorderProfileResolutionValidator.hasValidVideoResolution(profileInternal)) {
                return profileInternal;
            }
            return null;
        }
        return null;
    }

    @Override // androidx.camera.core.impl.CamcorderProfileProvider
    public boolean hasProfile(int i2) {
        if (this.mHasValidCameraId && CamcorderProfile.hasProfile(this.mCameraId, i2)) {
            if (this.mCamcorderProfileResolutionValidator.hasQuirk()) {
                return this.mCamcorderProfileResolutionValidator.hasValidVideoResolution(getProfileInternal(i2));
            }
            return true;
        }
        return false;
    }
}
