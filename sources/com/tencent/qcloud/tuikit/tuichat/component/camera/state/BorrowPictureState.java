package com.tencent.qcloud.tuikit.tuichat.component.camera.state;

import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.qcloud.tuikit.tuichat.component.camera.view.CameraInterface;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;

/* loaded from: classes3.dex */
public class BorrowPictureState implements State {
    private static final String TAG = "BorrowPictureState";
    private CameraMachine machine;

    public BorrowPictureState(CameraMachine cameraMachine) {
        this.machine = cameraMachine;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.camera.state.State
    public void cancle(SurfaceHolder surfaceHolder, float f2) {
        CameraInterface.getInstance().doStartPreview(surfaceHolder, f2);
        this.machine.getView().resetState(1);
        CameraMachine cameraMachine = this.machine;
        cameraMachine.setState(cameraMachine.getPreviewState());
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.camera.state.State
    public void capture() {
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.camera.state.State
    public void confirm() {
        this.machine.getView().confirmState(1);
        CameraMachine cameraMachine = this.machine;
        cameraMachine.setState(cameraMachine.getPreviewState());
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.camera.state.State
    public void flash(String str) {
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.camera.state.State
    public void foucs(float f2, float f3, CameraInterface.FocusCallback focusCallback) {
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.camera.state.State
    public void record(Surface surface, float f2) {
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.camera.state.State
    public void restart() {
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.camera.state.State
    public void start(SurfaceHolder surfaceHolder, float f2) {
        CameraInterface.getInstance().doStartPreview(surfaceHolder, f2);
        CameraMachine cameraMachine = this.machine;
        cameraMachine.setState(cameraMachine.getPreviewState());
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.camera.state.State
    public void stop() {
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.camera.state.State
    public void stopRecord(boolean z, long j2) {
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.camera.state.State
    public void swtich(SurfaceHolder surfaceHolder, float f2) {
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.camera.state.State
    public void zoom(float f2, int i2) {
        TUIChatLog.i(TAG, "zoom");
    }
}
