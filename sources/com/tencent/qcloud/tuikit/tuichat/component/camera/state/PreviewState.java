package com.tencent.qcloud.tuikit.tuichat.component.camera.state;

import android.graphics.Bitmap;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatService;
import com.tencent.qcloud.tuikit.tuichat.component.camera.view.CameraInterface;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;

/* loaded from: classes3.dex */
public class PreviewState implements State {
    public static final String TAG = "PreviewState";
    private CameraMachine machine;

    public PreviewState(CameraMachine cameraMachine) {
        this.machine = cameraMachine;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.camera.state.State
    public void cancle(SurfaceHolder surfaceHolder, float f2) {
        TUIChatLog.i(TAG, TUIChatService.getAppContext().getString(R.string.no_event_cancle_tip));
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.camera.state.State
    public void capture() {
        CameraInterface.getInstance().takePicture(new CameraInterface.TakePictureCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.component.camera.state.PreviewState.1
            {
                PreviewState.this = this;
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.component.camera.view.CameraInterface.TakePictureCallback
            public void captureResult(Bitmap bitmap, boolean z) {
                PreviewState.this.machine.getView().showPicture(bitmap, z);
                PreviewState.this.machine.setState(PreviewState.this.machine.getBorrowPictureState());
                TUIChatLog.i(PreviewState.TAG, "capture");
            }
        });
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.camera.state.State
    public void confirm() {
        TUIChatLog.i(TAG, TUIChatService.getAppContext().getString(R.string.no_event_confirm_tip));
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.camera.state.State
    public void flash(String str) {
        CameraInterface.getInstance().setFlashMode(str);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.camera.state.State
    public void foucs(float f2, float f3, CameraInterface.FocusCallback focusCallback) {
        TUIChatLog.i(TAG, "preview state foucs");
        if (this.machine.getView().handlerFoucs(f2, f3)) {
            CameraInterface.getInstance().handleFocus(this.machine.getContext(), f2, f3, focusCallback);
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.camera.state.State
    public void record(Surface surface, float f2) {
        CameraInterface.getInstance().startRecord(surface, f2, null);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.camera.state.State
    public void restart() {
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.camera.state.State
    public void start(SurfaceHolder surfaceHolder, float f2) {
        CameraInterface.getInstance().doStartPreview(surfaceHolder, f2);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.camera.state.State
    public void stop() {
        CameraInterface.getInstance().doStopPreview();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.camera.state.State
    public void stopRecord(final boolean z, long j2) {
        CameraInterface.getInstance().stopRecord(z, new CameraInterface.StopRecordCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.component.camera.state.PreviewState.2
            {
                PreviewState.this = this;
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.component.camera.view.CameraInterface.StopRecordCallback
            public void recordResult(String str, Bitmap bitmap) {
                if (z) {
                    PreviewState.this.machine.getView().resetState(3);
                    return;
                }
                PreviewState.this.machine.getView().playVideo(bitmap, str);
                PreviewState.this.machine.setState(PreviewState.this.machine.getBorrowVideoState());
            }
        });
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.camera.state.State
    public void swtich(SurfaceHolder surfaceHolder, float f2) {
        CameraInterface.getInstance().switchCamera(surfaceHolder, f2);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.camera.state.State
    public void zoom(float f2, int i2) {
        TUIChatLog.i(TAG, "zoom");
        CameraInterface.getInstance().setZoom(f2, i2);
    }
}
