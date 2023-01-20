package androidx.camera.camera2.internal.compat.params;

import android.hardware.camera2.params.OutputConfiguration;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@RequiresApi(24)
/* loaded from: classes.dex */
public class OutputConfigurationCompatApi24Impl extends OutputConfigurationCompatBaseImpl {

    @RequiresApi(21)
    /* loaded from: classes.dex */
    public static final class OutputConfigurationParamsApi24 {
        public boolean mIsShared;
        public final OutputConfiguration mOutputConfiguration;
        @Nullable
        public String mPhysicalCameraId;

        public OutputConfigurationParamsApi24(@NonNull OutputConfiguration outputConfiguration) {
            this.mOutputConfiguration = outputConfiguration;
        }

        public boolean equals(Object obj) {
            if (obj instanceof OutputConfigurationParamsApi24) {
                OutputConfigurationParamsApi24 outputConfigurationParamsApi24 = (OutputConfigurationParamsApi24) obj;
                return Objects.equals(this.mOutputConfiguration, outputConfigurationParamsApi24.mOutputConfiguration) && this.mIsShared == outputConfigurationParamsApi24.mIsShared && Objects.equals(this.mPhysicalCameraId, outputConfigurationParamsApi24.mPhysicalCameraId);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.mOutputConfiguration.hashCode() ^ 31;
            int i2 = (this.mIsShared ? 1 : 0) ^ ((hashCode << 5) - hashCode);
            int i3 = (i2 << 5) - i2;
            String str = this.mPhysicalCameraId;
            return (str == null ? 0 : str.hashCode()) ^ i3;
        }
    }

    public OutputConfigurationCompatApi24Impl(@NonNull Surface surface) {
        this(new OutputConfigurationParamsApi24(new OutputConfiguration(surface)));
    }

    @RequiresApi(24)
    public static OutputConfigurationCompatApi24Impl wrap(@NonNull OutputConfiguration outputConfiguration) {
        return new OutputConfigurationCompatApi24Impl(new OutputConfigurationParamsApi24(outputConfiguration));
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public void enableSurfaceSharing() {
        ((OutputConfigurationParamsApi24) this.mObject).mIsShared = true;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public Object getOutputConfiguration() {
        Preconditions.checkArgument(this.mObject instanceof OutputConfigurationParamsApi24);
        return ((OutputConfigurationParamsApi24) this.mObject).mOutputConfiguration;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    @Nullable
    public String getPhysicalCameraId() {
        return ((OutputConfigurationParamsApi24) this.mObject).mPhysicalCameraId;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    @Nullable
    public Surface getSurface() {
        return ((OutputConfiguration) getOutputConfiguration()).getSurface();
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public int getSurfaceGroupId() {
        return ((OutputConfiguration) getOutputConfiguration()).getSurfaceGroupId();
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    @NonNull
    public List<Surface> getSurfaces() {
        return Collections.singletonList(getSurface());
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl
    public boolean isSurfaceSharingEnabled() {
        return ((OutputConfigurationParamsApi24) this.mObject).mIsShared;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public void setPhysicalCameraId(@Nullable String str) {
        ((OutputConfigurationParamsApi24) this.mObject).mPhysicalCameraId = str;
    }

    public OutputConfigurationCompatApi24Impl(@NonNull Object obj) {
        super(obj);
    }
}
