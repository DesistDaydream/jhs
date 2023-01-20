package androidx.camera.core.impl;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.params.InputConfiguration;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.internal.compat.workaround.SurfaceSorter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class SessionConfig {
    private final List<CameraDevice.StateCallback> mDeviceStateCallbacks;
    private final List<ErrorListener> mErrorListeners;
    @Nullable
    private InputConfiguration mInputConfiguration;
    private final CaptureConfig mRepeatingCaptureConfig;
    private final List<CameraCaptureSession.StateCallback> mSessionStateCallbacks;
    private final List<CameraCaptureCallback> mSingleCameraCaptureCallbacks;
    private final List<DeferrableSurface> mSurfaces;

    /* loaded from: classes.dex */
    public static class BaseBuilder {
        @Nullable
        public InputConfiguration mInputConfiguration;
        public final Set<DeferrableSurface> mSurfaces = new LinkedHashSet();
        public final CaptureConfig.Builder mCaptureConfigBuilder = new CaptureConfig.Builder();
        public final List<CameraDevice.StateCallback> mDeviceStateCallbacks = new ArrayList();
        public final List<CameraCaptureSession.StateCallback> mSessionStateCallbacks = new ArrayList();
        public final List<ErrorListener> mErrorListeners = new ArrayList();
        public final List<CameraCaptureCallback> mSingleCameraCaptureCallbacks = new ArrayList();
    }

    /* loaded from: classes.dex */
    public static class Builder extends BaseBuilder {
        @NonNull
        public static Builder createFrom(@NonNull UseCaseConfig<?> useCaseConfig) {
            OptionUnpacker sessionOptionUnpacker = useCaseConfig.getSessionOptionUnpacker(null);
            if (sessionOptionUnpacker != null) {
                Builder builder = new Builder();
                sessionOptionUnpacker.unpack(useCaseConfig, builder);
                return builder;
            }
            throw new IllegalStateException("Implementation is missing option unpacker for " + useCaseConfig.getTargetName(useCaseConfig.toString()));
        }

        public void addAllCameraCaptureCallbacks(@NonNull Collection<CameraCaptureCallback> collection) {
            for (CameraCaptureCallback cameraCaptureCallback : collection) {
                this.mCaptureConfigBuilder.addCameraCaptureCallback(cameraCaptureCallback);
                if (!this.mSingleCameraCaptureCallbacks.contains(cameraCaptureCallback)) {
                    this.mSingleCameraCaptureCallbacks.add(cameraCaptureCallback);
                }
            }
        }

        public void addAllDeviceStateCallbacks(@NonNull Collection<CameraDevice.StateCallback> collection) {
            for (CameraDevice.StateCallback stateCallback : collection) {
                addDeviceStateCallback(stateCallback);
            }
        }

        public void addAllRepeatingCameraCaptureCallbacks(@NonNull Collection<CameraCaptureCallback> collection) {
            this.mCaptureConfigBuilder.addAllCameraCaptureCallbacks(collection);
        }

        public void addAllSessionStateCallbacks(@NonNull List<CameraCaptureSession.StateCallback> list) {
            for (CameraCaptureSession.StateCallback stateCallback : list) {
                addSessionStateCallback(stateCallback);
            }
        }

        public void addCameraCaptureCallback(@NonNull CameraCaptureCallback cameraCaptureCallback) {
            this.mCaptureConfigBuilder.addCameraCaptureCallback(cameraCaptureCallback);
            if (this.mSingleCameraCaptureCallbacks.contains(cameraCaptureCallback)) {
                return;
            }
            this.mSingleCameraCaptureCallbacks.add(cameraCaptureCallback);
        }

        public void addDeviceStateCallback(@NonNull CameraDevice.StateCallback stateCallback) {
            if (this.mDeviceStateCallbacks.contains(stateCallback)) {
                return;
            }
            this.mDeviceStateCallbacks.add(stateCallback);
        }

        public void addErrorListener(@NonNull ErrorListener errorListener) {
            this.mErrorListeners.add(errorListener);
        }

        public void addImplementationOptions(@NonNull Config config) {
            this.mCaptureConfigBuilder.addImplementationOptions(config);
        }

        public void addNonRepeatingSurface(@NonNull DeferrableSurface deferrableSurface) {
            this.mSurfaces.add(deferrableSurface);
        }

        public void addRepeatingCameraCaptureCallback(@NonNull CameraCaptureCallback cameraCaptureCallback) {
            this.mCaptureConfigBuilder.addCameraCaptureCallback(cameraCaptureCallback);
        }

        public void addSessionStateCallback(@NonNull CameraCaptureSession.StateCallback stateCallback) {
            if (this.mSessionStateCallbacks.contains(stateCallback)) {
                return;
            }
            this.mSessionStateCallbacks.add(stateCallback);
        }

        public void addSurface(@NonNull DeferrableSurface deferrableSurface) {
            this.mSurfaces.add(deferrableSurface);
            this.mCaptureConfigBuilder.addSurface(deferrableSurface);
        }

        public void addTag(@NonNull String str, @NonNull Object obj) {
            this.mCaptureConfigBuilder.addTag(str, obj);
        }

        @NonNull
        public SessionConfig build() {
            return new SessionConfig(new ArrayList(this.mSurfaces), this.mDeviceStateCallbacks, this.mSessionStateCallbacks, this.mSingleCameraCaptureCallbacks, this.mErrorListeners, this.mCaptureConfigBuilder.build(), this.mInputConfiguration);
        }

        public void clearSurfaces() {
            this.mSurfaces.clear();
            this.mCaptureConfigBuilder.clearSurfaces();
        }

        @NonNull
        public List<CameraCaptureCallback> getSingleCameraCaptureCallbacks() {
            return Collections.unmodifiableList(this.mSingleCameraCaptureCallbacks);
        }

        public boolean removeCameraCaptureCallback(@NonNull CameraCaptureCallback cameraCaptureCallback) {
            return this.mCaptureConfigBuilder.removeCameraCaptureCallback(cameraCaptureCallback) || this.mSingleCameraCaptureCallbacks.remove(cameraCaptureCallback);
        }

        public void removeSurface(@NonNull DeferrableSurface deferrableSurface) {
            this.mSurfaces.remove(deferrableSurface);
            this.mCaptureConfigBuilder.removeSurface(deferrableSurface);
        }

        public void setImplementationOptions(@NonNull Config config) {
            this.mCaptureConfigBuilder.setImplementationOptions(config);
        }

        public void setInputConfiguration(@Nullable InputConfiguration inputConfiguration) {
            this.mInputConfiguration = inputConfiguration;
        }

        public void setTemplateType(int i2) {
            this.mCaptureConfigBuilder.setTemplateType(i2);
        }
    }

    /* loaded from: classes.dex */
    public interface ErrorListener {
        void onError(@NonNull SessionConfig sessionConfig, @NonNull SessionError sessionError);
    }

    /* loaded from: classes.dex */
    public interface OptionUnpacker {
        void unpack(@NonNull UseCaseConfig<?> useCaseConfig, @NonNull Builder builder);
    }

    /* loaded from: classes.dex */
    public enum SessionError {
        SESSION_ERROR_SURFACE_NEEDS_RESET,
        SESSION_ERROR_UNKNOWN
    }

    /* loaded from: classes.dex */
    public static final class ValidatingBuilder extends BaseBuilder {
        private static final List<Integer> SUPPORTED_TEMPLATE_PRIORITY = Arrays.asList(1, 3);
        private static final String TAG = "ValidatingBuilder";
        private final SurfaceSorter mSurfaceSorter = new SurfaceSorter();
        private boolean mValid = true;
        private boolean mTemplateSet = false;

        private int selectTemplateType(int i2, int i3) {
            List<Integer> list = SUPPORTED_TEMPLATE_PRIORITY;
            return list.indexOf(Integer.valueOf(i2)) >= list.indexOf(Integer.valueOf(i3)) ? i2 : i3;
        }

        public void add(@NonNull SessionConfig sessionConfig) {
            CaptureConfig repeatingCaptureConfig = sessionConfig.getRepeatingCaptureConfig();
            if (repeatingCaptureConfig.getTemplateType() != -1) {
                this.mTemplateSet = true;
                this.mCaptureConfigBuilder.setTemplateType(selectTemplateType(repeatingCaptureConfig.getTemplateType(), this.mCaptureConfigBuilder.getTemplateType()));
            }
            this.mCaptureConfigBuilder.addAllTags(sessionConfig.getRepeatingCaptureConfig().getTagBundle());
            this.mDeviceStateCallbacks.addAll(sessionConfig.getDeviceStateCallbacks());
            this.mSessionStateCallbacks.addAll(sessionConfig.getSessionStateCallbacks());
            this.mCaptureConfigBuilder.addAllCameraCaptureCallbacks(sessionConfig.getRepeatingCameraCaptureCallbacks());
            this.mSingleCameraCaptureCallbacks.addAll(sessionConfig.getSingleCameraCaptureCallbacks());
            this.mErrorListeners.addAll(sessionConfig.getErrorListeners());
            if (sessionConfig.getInputConfiguration() != null) {
                this.mInputConfiguration = sessionConfig.getInputConfiguration();
            }
            this.mSurfaces.addAll(sessionConfig.getSurfaces());
            this.mCaptureConfigBuilder.getSurfaces().addAll(repeatingCaptureConfig.getSurfaces());
            if (!this.mSurfaces.containsAll(this.mCaptureConfigBuilder.getSurfaces())) {
                Logger.d(TAG, "Invalid configuration due to capture request surfaces are not a subset of surfaces");
                this.mValid = false;
            }
            this.mCaptureConfigBuilder.addImplementationOptions(repeatingCaptureConfig.getImplementationOptions());
        }

        @NonNull
        public SessionConfig build() {
            if (this.mValid) {
                ArrayList arrayList = new ArrayList(this.mSurfaces);
                this.mSurfaceSorter.sort(arrayList);
                return new SessionConfig(arrayList, this.mDeviceStateCallbacks, this.mSessionStateCallbacks, this.mSingleCameraCaptureCallbacks, this.mErrorListeners, this.mCaptureConfigBuilder.build(), this.mInputConfiguration);
            }
            throw new IllegalArgumentException("Unsupported session configuration combination");
        }

        public void clearSurfaces() {
            this.mSurfaces.clear();
            this.mCaptureConfigBuilder.clearSurfaces();
        }

        public boolean isValid() {
            return this.mTemplateSet && this.mValid;
        }
    }

    public SessionConfig(List<DeferrableSurface> list, List<CameraDevice.StateCallback> list2, List<CameraCaptureSession.StateCallback> list3, List<CameraCaptureCallback> list4, List<ErrorListener> list5, CaptureConfig captureConfig, @Nullable InputConfiguration inputConfiguration) {
        this.mSurfaces = list;
        this.mDeviceStateCallbacks = Collections.unmodifiableList(list2);
        this.mSessionStateCallbacks = Collections.unmodifiableList(list3);
        this.mSingleCameraCaptureCallbacks = Collections.unmodifiableList(list4);
        this.mErrorListeners = Collections.unmodifiableList(list5);
        this.mRepeatingCaptureConfig = captureConfig;
        this.mInputConfiguration = inputConfiguration;
    }

    @NonNull
    public static SessionConfig defaultEmptySessionConfig() {
        return new SessionConfig(new ArrayList(), new ArrayList(0), new ArrayList(0), new ArrayList(0), new ArrayList(0), new CaptureConfig.Builder().build(), null);
    }

    @NonNull
    public List<CameraDevice.StateCallback> getDeviceStateCallbacks() {
        return this.mDeviceStateCallbacks;
    }

    @NonNull
    public List<ErrorListener> getErrorListeners() {
        return this.mErrorListeners;
    }

    @NonNull
    public Config getImplementationOptions() {
        return this.mRepeatingCaptureConfig.getImplementationOptions();
    }

    @Nullable
    public InputConfiguration getInputConfiguration() {
        return this.mInputConfiguration;
    }

    @NonNull
    public List<CameraCaptureCallback> getRepeatingCameraCaptureCallbacks() {
        return this.mRepeatingCaptureConfig.getCameraCaptureCallbacks();
    }

    @NonNull
    public CaptureConfig getRepeatingCaptureConfig() {
        return this.mRepeatingCaptureConfig;
    }

    @NonNull
    public List<CameraCaptureSession.StateCallback> getSessionStateCallbacks() {
        return this.mSessionStateCallbacks;
    }

    @NonNull
    public List<CameraCaptureCallback> getSingleCameraCaptureCallbacks() {
        return this.mSingleCameraCaptureCallbacks;
    }

    @NonNull
    public List<DeferrableSurface> getSurfaces() {
        return Collections.unmodifiableList(this.mSurfaces);
    }

    public int getTemplateType() {
        return this.mRepeatingCaptureConfig.getTemplateType();
    }
}
