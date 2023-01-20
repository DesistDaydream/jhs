package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Build;
import android.view.Surface;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.interop.CaptureRequestOptions;
import androidx.camera.camera2.interop.ExperimentalCamera2Interop;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequiresApi(21)
/* loaded from: classes.dex */
public class Camera2CaptureRequestBuilder {
    private static final String TAG = "CaptureRequestBuilder";

    @RequiresApi(23)
    /* loaded from: classes.dex */
    public static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        public static CaptureRequest.Builder createReprocessCaptureRequest(@NonNull CameraDevice cameraDevice, @NonNull TotalCaptureResult totalCaptureResult) throws CameraAccessException {
            return cameraDevice.createReprocessCaptureRequest(totalCaptureResult);
        }
    }

    private Camera2CaptureRequestBuilder() {
    }

    @OptIn(markerClass = {ExperimentalCamera2Interop.class})
    private static void applyImplementationOptionToCaptureBuilder(CaptureRequest.Builder builder, Config config) {
        CaptureRequestOptions build = CaptureRequestOptions.Builder.from(config).build();
        for (Config.Option<?> option : build.listOptions()) {
            CaptureRequest.Key key = (CaptureRequest.Key) option.getToken();
            try {
                builder.set(key, build.retrieveOption(option));
            } catch (IllegalArgumentException unused) {
                Logger.e(TAG, "CaptureRequest.Key is not supported: " + key);
            }
        }
    }

    @Nullable
    public static CaptureRequest build(@NonNull CaptureConfig captureConfig, @Nullable CameraDevice cameraDevice, @NonNull Map<DeferrableSurface, Surface> map) throws CameraAccessException {
        CaptureRequest.Builder createCaptureRequest;
        if (cameraDevice == null) {
            return null;
        }
        List<Surface> configuredSurfaces = getConfiguredSurfaces(captureConfig.getSurfaces(), map);
        if (configuredSurfaces.isEmpty()) {
            return null;
        }
        CameraCaptureResult cameraCaptureResult = captureConfig.getCameraCaptureResult();
        if (Build.VERSION.SDK_INT >= 23 && captureConfig.getTemplateType() == 5 && cameraCaptureResult != null && (cameraCaptureResult.getCaptureResult() instanceof TotalCaptureResult)) {
            createCaptureRequest = Api23Impl.createReprocessCaptureRequest(cameraDevice, (TotalCaptureResult) cameraCaptureResult.getCaptureResult());
        } else {
            createCaptureRequest = cameraDevice.createCaptureRequest(captureConfig.getTemplateType());
        }
        applyImplementationOptionToCaptureBuilder(createCaptureRequest, captureConfig.getImplementationOptions());
        Config implementationOptions = captureConfig.getImplementationOptions();
        Config.Option<Integer> option = CaptureConfig.OPTION_ROTATION;
        if (implementationOptions.containsOption(option)) {
            createCaptureRequest.set(CaptureRequest.JPEG_ORIENTATION, (Integer) captureConfig.getImplementationOptions().retrieveOption(option));
        }
        Config implementationOptions2 = captureConfig.getImplementationOptions();
        Config.Option<Integer> option2 = CaptureConfig.OPTION_JPEG_QUALITY;
        if (implementationOptions2.containsOption(option2)) {
            createCaptureRequest.set(CaptureRequest.JPEG_QUALITY, Byte.valueOf(((Integer) captureConfig.getImplementationOptions().retrieveOption(option2)).byteValue()));
        }
        for (Surface surface : configuredSurfaces) {
            createCaptureRequest.addTarget(surface);
        }
        createCaptureRequest.setTag(captureConfig.getTagBundle());
        return createCaptureRequest.build();
    }

    @Nullable
    public static CaptureRequest buildWithoutTarget(@NonNull CaptureConfig captureConfig, @Nullable CameraDevice cameraDevice) throws CameraAccessException {
        if (cameraDevice == null) {
            return null;
        }
        CaptureRequest.Builder createCaptureRequest = cameraDevice.createCaptureRequest(captureConfig.getTemplateType());
        applyImplementationOptionToCaptureBuilder(createCaptureRequest, captureConfig.getImplementationOptions());
        return createCaptureRequest.build();
    }

    @NonNull
    private static List<Surface> getConfiguredSurfaces(List<DeferrableSurface> list, Map<DeferrableSurface, Surface> map) {
        ArrayList arrayList = new ArrayList();
        for (DeferrableSurface deferrableSurface : list) {
            Surface surface = map.get(deferrableSurface);
            if (surface != null) {
                arrayList.add(surface);
            } else {
                throw new IllegalArgumentException("DeferrableSurface not in configuredSurfaceMap");
            }
        }
        return arrayList;
    }
}
