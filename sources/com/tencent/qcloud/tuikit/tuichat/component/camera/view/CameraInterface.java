package com.tencent.qcloud.tuikit.tuichat.component.camera.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaRecorder;
import android.os.Build;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.widget.ImageView;
import androidx.constraintlayout.motion.widget.Key;
import com.tencent.qcloud.tuicore.TUIConfig;
import com.tencent.qcloud.tuicore.util.ScreenUtil;
import com.tencent.qcloud.tuikit.tuichat.component.camera.listener.ErrorListener;
import com.tencent.qcloud.tuikit.tuichat.util.AngleUtil;
import com.tencent.qcloud.tuikit.tuichat.util.CameraParamUtil;
import com.tencent.qcloud.tuikit.tuichat.util.CheckPermission;
import com.tencent.qcloud.tuikit.tuichat.util.DeviceUtil;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import com.umeng.analytics.pro.am;
import i.b.q0;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes3.dex */
public class CameraInterface implements Camera.PreviewCallback {
    private static final String TAG = CameraInterface.class.getSimpleName();
    public static final int TYPE_CAPTURE = 145;
    public static final int TYPE_RECORDER = 144;
    private static volatile CameraInterface mCameraInterface;
    private int SELECTED_CAMERA;
    private ErrorListener errorLisenter;
    private byte[] firstFrame_data;
    private Camera mCamera;
    private ImageView mFlashLamp;
    private Camera.Parameters mParams;
    private ImageView mSwitchView;
    private MediaRecorder mediaRecorder;
    private int nowAngle;
    private int preview_height;
    private int preview_width;
    private String videoFileAbsPath;
    private String videoFileName;
    public int handlerTime = 0;
    private boolean isPreviewing = false;
    private int CAMERA_POST_POSITION = -1;
    private int CAMERA_FRONT_POSITION = -1;
    private SurfaceHolder mHolder = null;
    private float screenProp = -1.0f;
    private boolean isRecorder = false;
    private String saveVideoPath = TUIConfig.getMediaDir();
    private Bitmap videoFirstFrame = null;
    private int angle = 0;
    private int cameraAngle = 90;
    private int rotation = 0;
    private int nowScaleRate = 0;
    private int recordScleRate = 0;
    private int mediaQuality = JCameraView.MEDIA_QUALITY_MIDDLE;
    private SensorManager sm = null;
    private SensorEventListener sensorEventListener = new SensorEventListener() { // from class: com.tencent.qcloud.tuikit.tuichat.component.camera.view.CameraInterface.1
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i2) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (1 != sensorEvent.sensor.getType()) {
                return;
            }
            float[] fArr = sensorEvent.values;
            CameraInterface.this.angle = AngleUtil.getSensorAngle(fArr[0], fArr[1]);
            CameraInterface.this.rotationAnimation();
        }
    };

    /* loaded from: classes3.dex */
    public interface CameraOpenOverCallback {
        void cameraHasOpened();
    }

    /* loaded from: classes3.dex */
    public interface ErrorCallback {
        void onError();
    }

    /* loaded from: classes3.dex */
    public interface FocusCallback {
        void focusSuccess();
    }

    /* loaded from: classes3.dex */
    public interface StopRecordCallback {
        void recordResult(String str, Bitmap bitmap);
    }

    /* loaded from: classes3.dex */
    public interface TakePictureCallback {
        void captureResult(Bitmap bitmap, boolean z);
    }

    private CameraInterface() {
        this.SELECTED_CAMERA = -1;
        findAvailableCameras();
        this.SELECTED_CAMERA = this.CAMERA_POST_POSITION;
    }

    private static Rect calculateTapArea(float f2, float f3, float f4, Context context) {
        int intValue = Float.valueOf(f4 * 300.0f).intValue();
        int i2 = intValue / 2;
        int clamp = clamp(((int) (((f2 / ScreenUtil.getScreenWidth(context)) * 2000.0f) - 1000.0f)) - i2, -1000, 1000);
        int clamp2 = clamp(((int) (((f3 / ScreenUtil.getScreenHeight(context)) * 2000.0f) - 1000.0f)) - i2, -1000, 1000);
        RectF rectF = new RectF(clamp, clamp2, clamp + intValue, clamp2 + intValue);
        return new Rect(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }

    private static int clamp(int i2, int i3, int i4) {
        return i2 > i4 ? i4 : i2 < i3 ? i3 : i2;
    }

    public static void destroyCameraInterface() {
        if (mCameraInterface != null) {
            mCameraInterface.doDestroyCamera();
            mCameraInterface = null;
        }
    }

    private void findAvailableCameras() {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i2 = 0; i2 < numberOfCameras; i2++) {
            Camera.getCameraInfo(i2, cameraInfo);
            int i3 = cameraInfo.facing;
            if (i3 == 0) {
                this.CAMERA_POST_POSITION = i3;
            } else if (i3 == 1) {
                this.CAMERA_FRONT_POSITION = i3;
            }
        }
    }

    public static synchronized CameraInterface getInstance() {
        CameraInterface cameraInterface;
        synchronized (CameraInterface.class) {
            if (mCameraInterface == null) {
                synchronized (CameraInterface.class) {
                    if (mCameraInterface == null) {
                        mCameraInterface = new CameraInterface();
                    }
                }
            }
            cameraInterface = mCameraInterface;
        }
        return cameraInterface;
    }

    private synchronized void openCamera(int i2) {
        Camera camera;
        try {
            this.mCamera = Camera.open(i2);
        } catch (Exception e2) {
            e2.printStackTrace();
            ErrorListener errorListener = this.errorLisenter;
            if (errorListener != null) {
                errorListener.onError();
            }
        }
        if (Build.VERSION.SDK_INT > 17 && (camera = this.mCamera) != null) {
            try {
                camera.enableShutterSound(false);
            } catch (Exception e3) {
                e3.printStackTrace();
                TUIChatLog.e(TAG, "enable shutter sound faild");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rotationAnimation() {
        int i2;
        int i3;
        ImageView imageView = this.mSwitchView;
        if (imageView == null || (i2 = this.rotation) == (i3 = this.angle)) {
            return;
        }
        int i4 = 180;
        if (i2 == 0) {
            i4 = i3 != 90 ? i3 != 270 ? 0 : 90 : -90;
            r3 = 0;
        } else if (i2 == 90) {
            if (i3 != 0 && i3 == 180) {
                i4 = -180;
            }
            i4 = 0;
        } else if (i2 != 180) {
            if (i2 != 270) {
                r3 = 0;
            } else if (i3 == 0 || i3 != 180) {
                r3 = 90;
            } else {
                r3 = 90;
            }
            i4 = 0;
        } else {
            i4 = i3 != 90 ? i3 != 270 ? 0 : 90 : 270;
            r3 = 180;
        }
        float f2 = r3;
        float f3 = i4;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, Key.ROTATION, f2, f3);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mFlashLamp, Key.ROTATION, f2, f3);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.setDuration(500L);
        animatorSet.start();
        this.rotation = this.angle;
    }

    private void setFlashModel() {
        Camera.Parameters parameters = this.mCamera.getParameters();
        this.mParams = parameters;
        parameters.setFlashMode("torch");
        this.mCamera.setParameters(this.mParams);
    }

    public void doDestroyCamera() {
        this.errorLisenter = null;
        Camera camera = this.mCamera;
        if (camera != null) {
            try {
                camera.setPreviewCallback(null);
                this.mSwitchView = null;
                this.mFlashLamp = null;
                this.mCamera.stopPreview();
                this.mCamera.setPreviewDisplay(null);
                this.mHolder = null;
                this.isPreviewing = false;
                this.mCamera.release();
                this.mCamera = null;
                TUIChatLog.i(TAG, "=== Destroy Camera ===");
                return;
            } catch (IOException e2) {
                e2.printStackTrace();
                return;
            }
        }
        TUIChatLog.i(TAG, "=== Camera  Null===");
    }

    public void doOpenCamera(CameraOpenOverCallback cameraOpenOverCallback) {
        ErrorListener errorListener;
        if (Build.VERSION.SDK_INT < 23 && !CheckPermission.isCameraUseable(this.SELECTED_CAMERA) && (errorListener = this.errorLisenter) != null) {
            errorListener.onError();
            return;
        }
        if (this.mCamera == null) {
            openCamera(this.SELECTED_CAMERA);
        }
        cameraOpenOverCallback.cameraHasOpened();
    }

    public void doStartPreview(SurfaceHolder surfaceHolder, float f2) {
        if (this.isPreviewing) {
            TUIChatLog.i(TAG, "doStartPreview isPreviewing");
        }
        if (this.screenProp < 0.0f) {
            this.screenProp = f2;
        }
        if (surfaceHolder == null) {
            return;
        }
        this.mHolder = surfaceHolder;
        if (this.mCamera != null) {
            try {
                if (DeviceUtil.isVivoX21()) {
                    Camera camera = this.mCamera;
                    if (camera != null) {
                        camera.release();
                        this.mCamera = null;
                    }
                    openCamera(this.SELECTED_CAMERA);
                }
                this.mParams = this.mCamera.getParameters();
                Camera.Size previewSize = CameraParamUtil.getInstance().getPreviewSize(this.mParams.getSupportedPreviewSizes(), 1000, f2);
                Camera.Size pictureSize = CameraParamUtil.getInstance().getPictureSize(this.mParams.getSupportedPictureSizes(), 1200, f2);
                this.mParams.setPreviewSize(previewSize.width, previewSize.height);
                this.preview_width = previewSize.width;
                this.preview_height = previewSize.height;
                this.mParams.setPictureSize(pictureSize.width, pictureSize.height);
                if (CameraParamUtil.getInstance().isSupportedFocusMode(this.mParams.getSupportedFocusModes(), q0.f15780c)) {
                    this.mParams.setFocusMode(q0.f15780c);
                }
                if (CameraParamUtil.getInstance().isSupportedPictureFormats(this.mParams.getSupportedPictureFormats(), 256)) {
                    this.mParams.setPictureFormat(256);
                    this.mParams.setJpegQuality(100);
                }
                this.mCamera.setParameters(this.mParams);
                this.mParams = this.mCamera.getParameters();
                this.mCamera.setPreviewDisplay(surfaceHolder);
                this.mCamera.setDisplayOrientation(this.cameraAngle);
                this.mCamera.setPreviewCallback(this);
                this.mCamera.startPreview();
                this.isPreviewing = true;
                TUIChatLog.i(TAG, "=== Start Preview ===");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void doStopPreview() {
        Camera camera = this.mCamera;
        if (camera != null) {
            try {
                camera.setPreviewCallback(null);
                this.mCamera.stopPreview();
                this.mCamera.setPreviewDisplay(null);
                this.isPreviewing = false;
                TUIChatLog.i(TAG, "=== Stop Preview ===");
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void handleFocus(final Context context, final float f2, final float f3, final FocusCallback focusCallback) {
        Camera camera = this.mCamera;
        if (camera == null) {
            return;
        }
        Camera.Parameters parameters = camera.getParameters();
        Rect calculateTapArea = calculateTapArea(f2, f3, 1.0f, context);
        this.mCamera.cancelAutoFocus();
        if (parameters.getMaxNumFocusAreas() > 0) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new Camera.Area(calculateTapArea, 800));
            parameters.setFocusAreas(arrayList);
            final String focusMode = parameters.getFocusMode();
            try {
                parameters.setFocusMode(q0.f15780c);
                this.mCamera.setParameters(parameters);
                this.mCamera.autoFocus(new Camera.AutoFocusCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.component.camera.view.CameraInterface.3
                    @Override // android.hardware.Camera.AutoFocusCallback
                    public void onAutoFocus(boolean z, Camera camera2) {
                        CameraInterface cameraInterface;
                        int i2;
                        if (!z && (i2 = (cameraInterface = CameraInterface.this).handlerTime) <= 10) {
                            cameraInterface.handlerTime = i2 + 1;
                            cameraInterface.handleFocus(context, f2, f3, focusCallback);
                            return;
                        }
                        Camera.Parameters parameters2 = camera2.getParameters();
                        parameters2.setFocusMode(focusMode);
                        camera2.setParameters(parameters2);
                        CameraInterface.this.handlerTime = 0;
                        focusCallback.focusSuccess();
                    }
                });
                return;
            } catch (Exception unused) {
                TUIChatLog.e(TAG, "autoFocus failer");
                return;
            }
        }
        TUIChatLog.i(TAG, "focus areas not supported");
        focusCallback.focusSuccess();
    }

    public void isPreview(boolean z) {
        this.isPreviewing = z;
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        this.firstFrame_data = bArr;
    }

    public void registerSensorManager(Context context) {
        if (this.sm == null) {
            this.sm = (SensorManager) context.getSystemService(am.ac);
        }
        SensorManager sensorManager = this.sm;
        sensorManager.registerListener(this.sensorEventListener, sensorManager.getDefaultSensor(1), 3);
    }

    public void setErrorLinsenter(ErrorListener errorListener) {
        this.errorLisenter = errorListener;
    }

    public void setFlashMode(String str) {
        Camera camera = this.mCamera;
        if (camera == null) {
            return;
        }
        Camera.Parameters parameters = camera.getParameters();
        parameters.setFlashMode(str);
        this.mCamera.setParameters(parameters);
    }

    public void setMediaQuality(int i2) {
        this.mediaQuality = i2;
    }

    public void setSwitchView(ImageView imageView, ImageView imageView2) {
        this.mSwitchView = imageView;
        this.mFlashLamp = imageView2;
        if (imageView != null) {
            this.cameraAngle = CameraParamUtil.getInstance().getCameraDisplayOrientation(imageView.getContext(), this.SELECTED_CAMERA);
        }
    }

    public void setZoom(float f2, int i2) {
        int i3;
        Camera camera = this.mCamera;
        if (camera == null) {
            return;
        }
        if (this.mParams == null) {
            this.mParams = camera.getParameters();
        }
        if (this.mParams.isZoomSupported() && this.mParams.isSmoothZoomSupported()) {
            if (i2 != 144) {
                if (i2 == 145 && !this.isRecorder) {
                    int i4 = (int) (f2 / 50.0f);
                    if (i4 < this.mParams.getMaxZoom()) {
                        int i5 = this.nowScaleRate + i4;
                        this.nowScaleRate = i5;
                        if (i5 < 0) {
                            this.nowScaleRate = 0;
                        } else if (i5 > this.mParams.getMaxZoom()) {
                            this.nowScaleRate = this.mParams.getMaxZoom();
                        }
                        this.mParams.setZoom(this.nowScaleRate);
                        this.mCamera.setParameters(this.mParams);
                    }
                    String str = TAG;
                    TUIChatLog.i(str, "setZoom = " + this.nowScaleRate);
                }
            } else if (this.isRecorder && f2 >= 0.0f && (i3 = (int) (f2 / 40.0f)) <= this.mParams.getMaxZoom() && i3 >= this.nowScaleRate && this.recordScleRate != i3) {
                this.mParams.setZoom(i3);
                this.mCamera.setParameters(this.mParams);
                this.recordScleRate = i3;
            }
        }
    }

    public void startRecord(Surface surface, float f2, ErrorCallback errorCallback) {
        Camera.Size previewSize;
        this.mCamera.setPreviewCallback(null);
        int i2 = (this.angle + 90) % 360;
        Camera.Parameters parameters = this.mCamera.getParameters();
        int i3 = parameters.getPreviewSize().width;
        int i4 = parameters.getPreviewSize().height;
        YuvImage yuvImage = new YuvImage(this.firstFrame_data, parameters.getPreviewFormat(), i3, i4, null);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        yuvImage.compressToJpeg(new Rect(0, 0, i3, i4), 50, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        this.videoFirstFrame = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        Matrix matrix = new Matrix();
        int i5 = this.SELECTED_CAMERA;
        if (i5 == this.CAMERA_POST_POSITION) {
            matrix.setRotate(i2);
        } else if (i5 == this.CAMERA_FRONT_POSITION) {
            matrix.setRotate(270.0f);
        }
        Bitmap bitmap = this.videoFirstFrame;
        this.videoFirstFrame = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), this.videoFirstFrame.getHeight(), matrix, true);
        if (this.isRecorder) {
            return;
        }
        if (this.mCamera == null) {
            openCamera(this.SELECTED_CAMERA);
        }
        if (this.mediaRecorder == null) {
            this.mediaRecorder = new MediaRecorder();
        }
        if (this.mParams == null) {
            this.mParams = this.mCamera.getParameters();
        }
        if (this.mParams.getSupportedFocusModes().contains("continuous-video")) {
            this.mParams.setFocusMode("continuous-video");
        }
        this.mCamera.setParameters(this.mParams);
        this.mCamera.unlock();
        this.mediaRecorder.reset();
        if (DeviceUtil.isVivoX21()) {
            this.mCamera.release();
            this.mCamera = null;
            openCamera(this.SELECTED_CAMERA);
            this.mCamera.setDisplayOrientation(90);
            this.mCamera.unlock();
        }
        this.mediaRecorder.setCamera(this.mCamera);
        this.mediaRecorder.setVideoSource(1);
        this.mediaRecorder.setAudioSource(1);
        this.mediaRecorder.setOutputFormat(2);
        this.mediaRecorder.setVideoEncoder(2);
        this.mediaRecorder.setAudioEncoder(3);
        if (this.mParams.getSupportedVideoSizes() == null) {
            previewSize = CameraParamUtil.getInstance().getPreviewSize(this.mParams.getSupportedPreviewSizes(), 600, f2);
        } else {
            previewSize = CameraParamUtil.getInstance().getPreviewSize(this.mParams.getSupportedVideoSizes(), 600, f2);
        }
        String str = TAG;
        TUIChatLog.i(str, "setVideoSize    width = " + previewSize.width + "height = " + previewSize.height);
        int i6 = previewSize.width;
        int i7 = previewSize.height;
        if (i6 == i7) {
            this.mediaRecorder.setVideoSize(this.preview_width, this.preview_height);
        } else {
            this.mediaRecorder.setVideoSize(i6, i7);
        }
        if (this.SELECTED_CAMERA == this.CAMERA_FRONT_POSITION) {
            if (this.cameraAngle == 270) {
                if (i2 == 0) {
                    this.mediaRecorder.setOrientationHint(180);
                } else if (i2 == 270) {
                    this.mediaRecorder.setOrientationHint(270);
                } else {
                    this.mediaRecorder.setOrientationHint(90);
                }
            } else if (i2 == 90) {
                this.mediaRecorder.setOrientationHint(270);
            } else if (i2 == 270) {
                this.mediaRecorder.setOrientationHint(90);
            } else {
                this.mediaRecorder.setOrientationHint(i2);
            }
        } else {
            this.mediaRecorder.setOrientationHint(i2);
        }
        if (DeviceUtil.isHuaWeiOrHonor()) {
            this.mediaRecorder.setVideoEncodingBitRate(JCameraView.MEDIA_QUALITY_FUNNY);
        } else {
            this.mediaRecorder.setVideoEncodingBitRate(this.mediaQuality);
        }
        this.mediaRecorder.setPreviewDisplay(surface);
        this.videoFileName = "video_" + new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date()) + ".mp4";
        StringBuilder sb = new StringBuilder();
        sb.append(this.saveVideoPath);
        sb.append(this.videoFileName);
        String sb2 = sb.toString();
        this.videoFileAbsPath = sb2;
        this.mediaRecorder.setOutputFile(sb2);
        try {
            this.mediaRecorder.prepare();
            this.mediaRecorder.start();
            this.isRecorder = true;
        } catch (IOException e2) {
            e2.printStackTrace();
            TUIChatLog.i(TAG, "startRecord IOException");
            ErrorListener errorListener = this.errorLisenter;
            if (errorListener != null) {
                errorListener.onError();
            }
        } catch (IllegalStateException e3) {
            e3.printStackTrace();
            TUIChatLog.i(TAG, "startRecord IllegalStateException");
            ErrorListener errorListener2 = this.errorLisenter;
            if (errorListener2 != null) {
                errorListener2.onError();
            }
        } catch (RuntimeException unused) {
            TUIChatLog.i(TAG, "startRecord RuntimeException");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0038, code lost:
        if (r2 == null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003b, code lost:
        if (r4 == false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0043, code lost:
        if (com.tencent.qcloud.tuicore.util.FileUtil.deleteFile(r3.videoFileAbsPath) == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0045, code lost:
        r5.recordResult(null, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0048, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0049, code lost:
        doStopPreview();
        r5.recordResult(r3.saveVideoPath + r3.videoFileName, r3.videoFirstFrame);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:?, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void stopRecord(boolean r4, com.tencent.qcloud.tuikit.tuichat.component.camera.view.CameraInterface.StopRecordCallback r5) {
        /*
            r3 = this;
            boolean r0 = r3.isRecorder
            if (r0 != 0) goto L5
            return
        L5:
            android.media.MediaRecorder r0 = r3.mediaRecorder
            if (r0 == 0) goto L71
            r1 = 0
            r0.setOnErrorListener(r1)
            android.media.MediaRecorder r0 = r3.mediaRecorder
            r0.setOnInfoListener(r1)
            android.media.MediaRecorder r0 = r3.mediaRecorder
            r0.setPreviewDisplay(r1)
            r0 = 0
            android.media.MediaRecorder r2 = r3.mediaRecorder     // Catch: java.lang.Throwable -> L29 java.lang.RuntimeException -> L2b
            r2.stop()     // Catch: java.lang.Throwable -> L29 java.lang.RuntimeException -> L2b
            android.media.MediaRecorder r2 = r3.mediaRecorder
            if (r2 == 0) goto L24
        L21:
            r2.release()
        L24:
            r3.mediaRecorder = r1
            r3.isRecorder = r0
            goto L3b
        L29:
            r4 = move-exception
            goto L65
        L2b:
            r2 = move-exception
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L29
            r3.mediaRecorder = r1     // Catch: java.lang.Throwable -> L29
            android.media.MediaRecorder r2 = new android.media.MediaRecorder     // Catch: java.lang.Throwable -> L29
            r2.<init>()     // Catch: java.lang.Throwable -> L29
            r3.mediaRecorder = r2     // Catch: java.lang.Throwable -> L29
            if (r2 == 0) goto L24
            goto L21
        L3b:
            if (r4 == 0) goto L49
            java.lang.String r4 = r3.videoFileAbsPath
            boolean r4 = com.tencent.qcloud.tuicore.util.FileUtil.deleteFile(r4)
            if (r4 == 0) goto L48
            r5.recordResult(r1, r1)
        L48:
            return
        L49:
            r3.doStopPreview()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r0 = r3.saveVideoPath
            r4.append(r0)
            java.lang.String r0 = r3.videoFileName
            r4.append(r0)
            java.lang.String r4 = r4.toString()
            android.graphics.Bitmap r0 = r3.videoFirstFrame
            r5.recordResult(r4, r0)
            goto L71
        L65:
            android.media.MediaRecorder r5 = r3.mediaRecorder
            if (r5 == 0) goto L6c
            r5.release()
        L6c:
            r3.mediaRecorder = r1
            r3.isRecorder = r0
            throw r4
        L71:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qcloud.tuikit.tuichat.component.camera.view.CameraInterface.stopRecord(boolean, com.tencent.qcloud.tuikit.tuichat.component.camera.view.CameraInterface$StopRecordCallback):void");
    }

    public synchronized void switchCamera(SurfaceHolder surfaceHolder, float f2) {
        Camera camera;
        int i2 = this.SELECTED_CAMERA;
        int i3 = this.CAMERA_POST_POSITION;
        if (i2 == i3) {
            this.SELECTED_CAMERA = this.CAMERA_FRONT_POSITION;
        } else {
            this.SELECTED_CAMERA = i3;
        }
        doDestroyCamera();
        TUIChatLog.i(TAG, "open start");
        openCamera(this.SELECTED_CAMERA);
        if (Build.VERSION.SDK_INT > 17 && (camera = this.mCamera) != null) {
            try {
                camera.enableShutterSound(false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        TUIChatLog.i(TAG, "open end");
        doStartPreview(surfaceHolder, f2);
    }

    public void takePicture(final TakePictureCallback takePictureCallback) {
        if (this.mCamera == null) {
            return;
        }
        int i2 = this.cameraAngle;
        if (i2 == 90) {
            this.nowAngle = Math.abs(this.angle + i2) % 360;
        } else if (i2 == 270) {
            this.nowAngle = Math.abs(i2 - this.angle);
        }
        String str = TAG;
        TUIChatLog.i(str, this.angle + " = " + this.cameraAngle + " = " + this.nowAngle);
        this.mCamera.takePicture(null, null, new Camera.PictureCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.component.camera.view.CameraInterface.2
            @Override // android.hardware.Camera.PictureCallback
            public void onPictureTaken(byte[] bArr, Camera camera) {
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                Matrix matrix = new Matrix();
                if (CameraInterface.this.SELECTED_CAMERA == CameraInterface.this.CAMERA_POST_POSITION) {
                    matrix.setRotate(CameraInterface.this.nowAngle);
                } else if (CameraInterface.this.SELECTED_CAMERA == CameraInterface.this.CAMERA_FRONT_POSITION) {
                    matrix.setRotate(360 - CameraInterface.this.nowAngle);
                    matrix.postScale(-1.0f, 1.0f);
                }
                Bitmap createBitmap = Bitmap.createBitmap(decodeByteArray, 0, 0, decodeByteArray.getWidth(), decodeByteArray.getHeight(), matrix, true);
                if (takePictureCallback != null) {
                    if (CameraInterface.this.nowAngle != 90 && CameraInterface.this.nowAngle != 270) {
                        takePictureCallback.captureResult(createBitmap, false);
                    } else {
                        takePictureCallback.captureResult(createBitmap, true);
                    }
                }
            }
        });
    }

    public void unregisterSensorManager(Context context) {
        if (this.sm == null) {
            this.sm = (SensorManager) context.getSystemService(am.ac);
        }
        this.sm.unregisterListener(this.sensorEventListener);
    }
}
