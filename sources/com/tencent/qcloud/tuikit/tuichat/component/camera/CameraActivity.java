package com.tencent.qcloud.tuikit.tuichat.component.camera;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuicore.util.FileUtil;
import com.tencent.qcloud.tuicore.util.TUIBuild;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.component.camera.listener.ClickListener;
import com.tencent.qcloud.tuikit.tuichat.component.camera.listener.ErrorListener;
import com.tencent.qcloud.tuikit.tuichat.component.camera.listener.JCameraListener;
import com.tencent.qcloud.tuikit.tuichat.component.camera.view.JCameraView;
import com.tencent.qcloud.tuikit.tuichat.util.PermissionHelper;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;

/* loaded from: classes3.dex */
public class CameraActivity extends Activity {
    private static final int REQUEST_CODE_PHOTO_AND_VIDEO = 1000;
    private static final String TAG = CameraActivity.class.getSimpleName();
    public static IUIKitCallback mCallBack;
    private JCameraView jCameraView;

    /* JADX INFO: Access modifiers changed from: private */
    public void startSendPhoto() {
        TUIChatLog.i(TAG, "startSendPhoto");
        PermissionHelper.requestPermission(3, new PermissionHelper.PermissionCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.component.camera.CameraActivity.5
            @Override // com.tencent.qcloud.tuikit.tuichat.util.PermissionHelper.PermissionCallback
            public void onDenied() {
                TUIChatLog.i(CameraActivity.TAG, "startSendPhoto checkPermission failed");
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.util.PermissionHelper.PermissionCallback
            public void onGranted() {
                Intent intent = new Intent("android.intent.action.GET_CONTENT");
                intent.addCategory("android.intent.category.OPENABLE");
                intent.setType("*/*");
                intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*"});
                CameraActivity.this.startActivityForResult(intent, 1000);
            }
        });
    }

    @Override // android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1000 && i3 == -1) {
            setResult(-1, intent);
            finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        String str = TAG;
        TUIChatLog.i(str, "onCreate");
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setRequestedOrientation(1);
        setContentView(R.layout.activity_camera);
        this.jCameraView = (JCameraView) findViewById(R.id.jcameraview);
        int intExtra = getIntent().getIntExtra(TUIChatConstants.CAMERA_TYPE, 259);
        this.jCameraView.setFeatures(intExtra);
        if (intExtra == 257) {
            this.jCameraView.setTip(getString(R.string.tap_capture));
        } else if (intExtra == 258) {
            this.jCameraView.setTip(getString(R.string.tap_video));
        }
        this.jCameraView.setMediaQuality(JCameraView.MEDIA_QUALITY_MIDDLE);
        this.jCameraView.setErrorLisenter(new ErrorListener() { // from class: com.tencent.qcloud.tuikit.tuichat.component.camera.CameraActivity.1
            @Override // com.tencent.qcloud.tuikit.tuichat.component.camera.listener.ErrorListener
            public void AudioPermissionError() {
                ToastUtil.toastShortMessage(CameraActivity.this.getString(R.string.audio_permission_error));
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.component.camera.listener.ErrorListener
            public void onError() {
                TUIChatLog.i(CameraActivity.TAG, "camera error");
                CameraActivity.this.setResult(103, new Intent());
                CameraActivity.this.finish();
            }
        });
        this.jCameraView.setJCameraLisenter(new JCameraListener() { // from class: com.tencent.qcloud.tuikit.tuichat.component.camera.CameraActivity.2
            @Override // com.tencent.qcloud.tuikit.tuichat.component.camera.listener.JCameraListener
            public void captureSuccess(Bitmap bitmap) {
                String saveBitmap = FileUtil.saveBitmap("JCamera", bitmap);
                IUIKitCallback iUIKitCallback = CameraActivity.mCallBack;
                if (iUIKitCallback != null) {
                    iUIKitCallback.onSuccess(saveBitmap);
                }
                CameraActivity.this.finish();
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.component.camera.listener.JCameraListener
            public void recordSuccess(String str2, Bitmap bitmap, long j2) {
                String saveBitmap = FileUtil.saveBitmap("JCamera", bitmap);
                Intent intent = new Intent();
                intent.putExtra(TUIChatConstants.IMAGE_WIDTH, bitmap.getWidth());
                intent.putExtra(TUIChatConstants.IMAGE_HEIGHT, bitmap.getHeight());
                intent.putExtra(TUIChatConstants.VIDEO_TIME, j2);
                intent.putExtra(TUIChatConstants.CAMERA_IMAGE_PATH, saveBitmap);
                intent.putExtra(TUIChatConstants.CAMERA_VIDEO_PATH, str2);
                bitmap.getWidth();
                IUIKitCallback iUIKitCallback = CameraActivity.mCallBack;
                if (iUIKitCallback != null) {
                    iUIKitCallback.onSuccess(intent);
                }
                CameraActivity.this.finish();
            }
        });
        this.jCameraView.setLeftClickListener(new ClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.component.camera.CameraActivity.3
            @Override // com.tencent.qcloud.tuikit.tuichat.component.camera.listener.ClickListener
            public void onClick() {
                CameraActivity.this.finish();
            }
        });
        this.jCameraView.setRightClickListener(new ClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.component.camera.CameraActivity.4
            @Override // com.tencent.qcloud.tuikit.tuichat.component.camera.listener.ClickListener
            public void onClick() {
                CameraActivity.this.startSendPhoto();
            }
        });
        TUIChatLog.i(str, TUIBuild.getDevice());
    }

    @Override // android.app.Activity
    public void onDestroy() {
        TUIChatLog.i(TAG, "onDestroy");
        super.onDestroy();
        this.jCameraView.onDestroy();
        mCallBack = null;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.app.Activity
    public void onPause() {
        TUIChatLog.i(TAG, "onPause");
        super.onPause();
        this.jCameraView.onPause();
    }

    @Override // android.app.Activity
    public void onResume() {
        TUIChatLog.i(TAG, "onResume");
        super.onResume();
        this.jCameraView.onResume();
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().getDecorView().setSystemUiVisibility(5894);
        } else {
            getWindow().getDecorView().setSystemUiVisibility(4);
        }
    }
}
