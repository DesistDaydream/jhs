package androidx.camera.camera2.internal.compat.params;

import android.annotation.SuppressLint;
import android.os.Build;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat;
import androidx.camera.core.Logger;
import androidx.core.util.Preconditions;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@RequiresApi(21)
/* loaded from: classes.dex */
public class OutputConfigurationCompatBaseImpl implements OutputConfigurationCompat.OutputConfigurationCompatImpl {
    public static final String TAG = "OutputConfigCompat";
    public final Object mObject;

    @RequiresApi(21)
    /* loaded from: classes.dex */
    public static final class OutputConfigurationParamsApi21 {
        private static final String DETECT_SURFACE_TYPE_METHOD = "detectSurfaceType";
        private static final String GET_GENERATION_ID_METHOD = "getGenerationId";
        private static final String GET_SURFACE_SIZE_METHOD = "getSurfaceSize";
        private static final String LEGACY_CAMERA_DEVICE_CLASS = "android.hardware.camera2.legacy.LegacyCameraDevice";
        public static final int MAX_SURFACES_COUNT = 1;
        public final int mConfiguredFormat;
        public final int mConfiguredGenerationId;
        public final Size mConfiguredSize;
        public boolean mIsShared = false;
        @Nullable
        public String mPhysicalCameraId;
        public final List<Surface> mSurfaces;

        public OutputConfigurationParamsApi21(@NonNull Surface surface) {
            Preconditions.checkNotNull(surface, "Surface must not be null");
            this.mSurfaces = Collections.singletonList(surface);
            this.mConfiguredSize = getSurfaceSize(surface);
            this.mConfiguredFormat = getSurfaceFormat(surface);
            this.mConfiguredGenerationId = getSurfaceGenerationId(surface);
        }

        @SuppressLint({"BlockedPrivateApi"})
        private static int getSurfaceFormat(@NonNull Surface surface) {
            try {
                Method declaredMethod = Class.forName(LEGACY_CAMERA_DEVICE_CLASS).getDeclaredMethod(DETECT_SURFACE_TYPE_METHOD, Surface.class);
                if (Build.VERSION.SDK_INT < 22) {
                    declaredMethod.setAccessible(true);
                }
                return ((Integer) declaredMethod.invoke(null, surface)).intValue();
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e2) {
                Logger.e(OutputConfigurationCompatBaseImpl.TAG, "Unable to retrieve surface format.", e2);
                return 0;
            }
        }

        @SuppressLint({"SoonBlockedPrivateApi"})
        private static int getSurfaceGenerationId(@NonNull Surface surface) {
            try {
                return ((Integer) Surface.class.getDeclaredMethod(GET_GENERATION_ID_METHOD, new Class[0]).invoke(surface, new Object[0])).intValue();
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e2) {
                Logger.e(OutputConfigurationCompatBaseImpl.TAG, "Unable to retrieve surface generation id.", e2);
                return -1;
            }
        }

        @SuppressLint({"BlockedPrivateApi"})
        private static Size getSurfaceSize(@NonNull Surface surface) {
            try {
                Method declaredMethod = Class.forName(LEGACY_CAMERA_DEVICE_CLASS).getDeclaredMethod(GET_SURFACE_SIZE_METHOD, Surface.class);
                declaredMethod.setAccessible(true);
                return (Size) declaredMethod.invoke(null, surface);
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e2) {
                Logger.e(OutputConfigurationCompatBaseImpl.TAG, "Unable to retrieve surface size.", e2);
                return null;
            }
        }

        public boolean equals(Object obj) {
            if (obj instanceof OutputConfigurationParamsApi21) {
                OutputConfigurationParamsApi21 outputConfigurationParamsApi21 = (OutputConfigurationParamsApi21) obj;
                if (this.mConfiguredSize.equals(outputConfigurationParamsApi21.mConfiguredSize) && this.mConfiguredFormat == outputConfigurationParamsApi21.mConfiguredFormat && this.mConfiguredGenerationId == outputConfigurationParamsApi21.mConfiguredGenerationId && this.mIsShared == outputConfigurationParamsApi21.mIsShared && Objects.equals(this.mPhysicalCameraId, outputConfigurationParamsApi21.mPhysicalCameraId)) {
                    int min = Math.min(this.mSurfaces.size(), outputConfigurationParamsApi21.mSurfaces.size());
                    for (int i2 = 0; i2 < min; i2++) {
                        if (this.mSurfaces.get(i2) != outputConfigurationParamsApi21.mSurfaces.get(i2)) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.mSurfaces.hashCode() ^ 31;
            int i2 = this.mConfiguredGenerationId ^ ((hashCode << 5) - hashCode);
            int hashCode2 = this.mConfiguredSize.hashCode() ^ ((i2 << 5) - i2);
            int i3 = this.mConfiguredFormat ^ ((hashCode2 << 5) - hashCode2);
            int i4 = (this.mIsShared ? 1 : 0) ^ ((i3 << 5) - i3);
            int i5 = (i4 << 5) - i4;
            String str = this.mPhysicalCameraId;
            return (str == null ? 0 : str.hashCode()) ^ i5;
        }
    }

    public OutputConfigurationCompatBaseImpl(@NonNull Surface surface) {
        this.mObject = new OutputConfigurationParamsApi21(surface);
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public void addSurface(@NonNull Surface surface) {
        Preconditions.checkNotNull(surface, "Surface must not be null");
        if (getSurface() != surface) {
            if (!isSurfaceSharingEnabled()) {
                throw new IllegalStateException("Cannot have 2 surfaces for a non-sharing configuration");
            }
            throw new IllegalArgumentException("Exceeds maximum number of surfaces");
        }
        throw new IllegalStateException("Surface is already added!");
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public void enableSurfaceSharing() {
        ((OutputConfigurationParamsApi21) this.mObject).mIsShared = true;
    }

    public boolean equals(Object obj) {
        if (obj instanceof OutputConfigurationCompatBaseImpl) {
            return Objects.equals(this.mObject, ((OutputConfigurationCompatBaseImpl) obj).mObject);
        }
        return false;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public int getMaxSharedSurfaceCount() {
        return 1;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    @Nullable
    public Object getOutputConfiguration() {
        return null;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    @Nullable
    public String getPhysicalCameraId() {
        return ((OutputConfigurationParamsApi21) this.mObject).mPhysicalCameraId;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    @Nullable
    public Surface getSurface() {
        List<Surface> list = ((OutputConfigurationParamsApi21) this.mObject).mSurfaces;
        if (list.size() == 0) {
            return null;
        }
        return list.get(0);
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public int getSurfaceGroupId() {
        return -1;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    @NonNull
    public List<Surface> getSurfaces() {
        return ((OutputConfigurationParamsApi21) this.mObject).mSurfaces;
    }

    public int hashCode() {
        return this.mObject.hashCode();
    }

    public boolean isSurfaceSharingEnabled() {
        return ((OutputConfigurationParamsApi21) this.mObject).mIsShared;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public void removeSurface(@NonNull Surface surface) {
        if (getSurface() == surface) {
            throw new IllegalArgumentException("Cannot remove surface associated with this output configuration");
        }
        throw new IllegalArgumentException("Surface is not part of this output configuration");
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public void setPhysicalCameraId(@Nullable String str) {
        ((OutputConfigurationParamsApi21) this.mObject).mPhysicalCameraId = str;
    }

    public OutputConfigurationCompatBaseImpl(@NonNull Object obj) {
        this.mObject = obj;
    }
}
