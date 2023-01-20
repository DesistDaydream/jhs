package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.internal.compat.ApiCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiresApi(21)
/* loaded from: classes.dex */
public class CameraBurstCaptureCallback extends CameraCaptureSession.CaptureCallback {
    public CaptureSequenceCallback mCaptureSequenceCallback = null;
    public final Map<CaptureRequest, List<CameraCaptureSession.CaptureCallback>> mCallbackMap = new HashMap();

    /* loaded from: classes.dex */
    public interface CaptureSequenceCallback {
        void onCaptureSequenceCompletedOrAborted(@NonNull CameraCaptureSession cameraCaptureSession, int i2, boolean z);
    }

    private List<CameraCaptureSession.CaptureCallback> getCallbacks(CaptureRequest captureRequest) {
        List<CameraCaptureSession.CaptureCallback> list = this.mCallbackMap.get(captureRequest);
        return list != null ? list : Collections.emptyList();
    }

    public void addCamera2Callbacks(CaptureRequest captureRequest, List<CameraCaptureSession.CaptureCallback> list) {
        List<CameraCaptureSession.CaptureCallback> list2 = this.mCallbackMap.get(captureRequest);
        if (list2 != null) {
            ArrayList arrayList = new ArrayList(list.size() + list2.size());
            arrayList.addAll(list);
            arrayList.addAll(list2);
            this.mCallbackMap.put(captureRequest, arrayList);
            return;
        }
        this.mCallbackMap.put(captureRequest, list);
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    @RequiresApi(api = 24)
    public void onCaptureBufferLost(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull Surface surface, long j2) {
        for (CameraCaptureSession.CaptureCallback captureCallback : getCallbacks(captureRequest)) {
            ApiCompat.Api24Impl.onCaptureBufferLost(captureCallback, cameraCaptureSession, captureRequest, surface, j2);
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureCompleted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        for (CameraCaptureSession.CaptureCallback captureCallback : getCallbacks(captureRequest)) {
            captureCallback.onCaptureCompleted(cameraCaptureSession, captureRequest, totalCaptureResult);
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureFailed(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull CaptureFailure captureFailure) {
        for (CameraCaptureSession.CaptureCallback captureCallback : getCallbacks(captureRequest)) {
            captureCallback.onCaptureFailed(cameraCaptureSession, captureRequest, captureFailure);
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureProgressed(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull CaptureResult captureResult) {
        for (CameraCaptureSession.CaptureCallback captureCallback : getCallbacks(captureRequest)) {
            captureCallback.onCaptureProgressed(cameraCaptureSession, captureRequest, captureResult);
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureSequenceAborted(@NonNull CameraCaptureSession cameraCaptureSession, int i2) {
        for (List<CameraCaptureSession.CaptureCallback> list : this.mCallbackMap.values()) {
            for (CameraCaptureSession.CaptureCallback captureCallback : list) {
                captureCallback.onCaptureSequenceAborted(cameraCaptureSession, i2);
            }
        }
        CaptureSequenceCallback captureSequenceCallback = this.mCaptureSequenceCallback;
        if (captureSequenceCallback != null) {
            captureSequenceCallback.onCaptureSequenceCompletedOrAborted(cameraCaptureSession, i2, true);
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureSequenceCompleted(@NonNull CameraCaptureSession cameraCaptureSession, int i2, long j2) {
        for (List<CameraCaptureSession.CaptureCallback> list : this.mCallbackMap.values()) {
            for (CameraCaptureSession.CaptureCallback captureCallback : list) {
                captureCallback.onCaptureSequenceCompleted(cameraCaptureSession, i2, j2);
            }
        }
        CaptureSequenceCallback captureSequenceCallback = this.mCaptureSequenceCallback;
        if (captureSequenceCallback != null) {
            captureSequenceCallback.onCaptureSequenceCompletedOrAborted(cameraCaptureSession, i2, false);
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureStarted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, long j2, long j3) {
        for (CameraCaptureSession.CaptureCallback captureCallback : getCallbacks(captureRequest)) {
            captureCallback.onCaptureStarted(cameraCaptureSession, captureRequest, j2, j3);
        }
    }

    public void setCaptureSequenceCallback(@NonNull CaptureSequenceCallback captureSequenceCallback) {
        this.mCaptureSequenceCallback = captureSequenceCallback;
    }
}
