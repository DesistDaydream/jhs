package com.tencent.qcloud.tuikit.tuichat.component.camera.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.VideoView;
import com.tencent.qcloud.tuicore.util.FileUtil;
import com.tencent.qcloud.tuicore.util.ScreenUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatService;
import com.tencent.qcloud.tuikit.tuichat.component.camera.listener.CaptureListener;
import com.tencent.qcloud.tuikit.tuichat.component.camera.listener.ClickListener;
import com.tencent.qcloud.tuikit.tuichat.component.camera.listener.ErrorListener;
import com.tencent.qcloud.tuikit.tuichat.component.camera.listener.JCameraListener;
import com.tencent.qcloud.tuikit.tuichat.component.camera.listener.TypeListener;
import com.tencent.qcloud.tuikit.tuichat.component.camera.state.CameraMachine;
import com.tencent.qcloud.tuikit.tuichat.component.camera.view.CameraInterface;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import i.b.q0;
import java.io.IOException;

/* loaded from: classes3.dex */
public class JCameraView extends FrameLayout implements CameraInterface.CameraOpenOverCallback, SurfaceHolder.Callback, CameraView {
    public static final int BUTTON_STATE_BOTH = 259;
    public static final int BUTTON_STATE_ONLY_CAPTURE = 257;
    public static final int BUTTON_STATE_ONLY_RECORDER = 258;
    public static final int MEDIA_QUALITY_DESPAIR = 200000;
    public static final int MEDIA_QUALITY_FUNNY = 400000;
    public static final int MEDIA_QUALITY_HIGH = 2000000;
    public static final int MEDIA_QUALITY_LOW = 1200000;
    public static final int MEDIA_QUALITY_MIDDLE = 1600000;
    public static final int MEDIA_QUALITY_POOR = 800000;
    public static final int MEDIA_QUALITY_SORRY = 80000;
    private static final String TAG = JCameraView.class.getSimpleName();
    public static final int TYPE_DEFAULT = 4;
    private static final int TYPE_FLASH_AUTO = 33;
    private static final int TYPE_FLASH_OFF = 35;
    private static final int TYPE_FLASH_ON = 34;
    public static final int TYPE_PICTURE = 1;
    public static final int TYPE_SHORT = 3;
    public static final int TYPE_VIDEO = 2;
    private Bitmap captureBitmap;
    private int duration;
    private ErrorListener errorLisenter;
    private Bitmap firstFrame;
    private boolean firstTouch;
    private float firstTouchLength;
    private int iconLeft;
    private int iconMargin;
    private int iconRight;
    private int iconSize;
    private int iconSrc;
    private JCameraListener jCameraLisenter;
    private int layout_width;
    private ClickListener leftClickListener;
    private CaptureLayout mCaptureLayout;
    private Context mContext;
    private FoucsView mFoucsView;
    private MediaPlayer mMediaPlayer;
    private ImageView mPhoto;
    private ImageView mSwitchCamera;
    private VideoView mVideoView;
    private CameraMachine machine;
    private long recordTime;
    private ClickListener rightClickListener;
    private float screenProp;
    private int type_flash;
    private String videoUrl;
    private int zoomGradient;

    public JCameraView(Context context) {
        this(context, null);
    }

    private void initData() {
        int screenWidth = ScreenUtil.getScreenWidth(this.mContext);
        this.layout_width = screenWidth;
        this.zoomGradient = (int) (screenWidth / 16.0f);
        String str = TAG;
        TUIChatLog.i(str, "zoom = " + this.zoomGradient);
        this.machine = new CameraMachine(getContext(), this, this);
    }

    private void initView() {
        setWillNotDraw(false);
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.chat_input_camera_view, this);
        this.mVideoView = (VideoView) inflate.findViewById(R.id.video_preview);
        this.mPhoto = (ImageView) inflate.findViewById(R.id.image_photo);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.image_switch);
        this.mSwitchCamera = imageView;
        imageView.setImageResource(this.iconSrc);
        setFlashRes();
        CaptureLayout captureLayout = (CaptureLayout) inflate.findViewById(R.id.capture_layout);
        this.mCaptureLayout = captureLayout;
        captureLayout.setDuration(this.duration);
        this.mCaptureLayout.setIconSrc(this.iconLeft, this.iconRight);
        this.mFoucsView = (FoucsView) inflate.findViewById(R.id.fouce_view);
        this.mVideoView.getHolder().addCallback(this);
        this.mSwitchCamera.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.component.camera.view.JCameraView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                JCameraView.this.machine.swtich(JCameraView.this.mVideoView.getHolder(), JCameraView.this.screenProp);
            }
        });
        this.mCaptureLayout.setCaptureLisenter(new CaptureListener() { // from class: com.tencent.qcloud.tuikit.tuichat.component.camera.view.JCameraView.2
            @Override // com.tencent.qcloud.tuikit.tuichat.component.camera.listener.CaptureListener
            public void recordEnd(long j2) {
                JCameraView.this.machine.stopRecord(false, j2);
                JCameraView.this.recordTime = j2;
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.component.camera.listener.CaptureListener
            public void recordError() {
                if (JCameraView.this.errorLisenter != null) {
                    JCameraView.this.errorLisenter.AudioPermissionError();
                }
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.component.camera.listener.CaptureListener
            public void recordShort(final long j2) {
                JCameraView.this.mCaptureLayout.setTextWithAnimation(TUIChatService.getAppContext().getString(R.string.record_time_tip));
                JCameraView.this.mSwitchCamera.setVisibility(0);
                JCameraView.this.postDelayed(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.component.camera.view.JCameraView.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        JCameraView.this.machine.stopRecord(true, j2);
                    }
                }, 1500 - j2);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.component.camera.listener.CaptureListener
            public void recordStart() {
                JCameraView.this.mSwitchCamera.setVisibility(4);
                JCameraView.this.machine.record(JCameraView.this.mVideoView.getHolder().getSurface(), JCameraView.this.screenProp);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.component.camera.listener.CaptureListener
            public void recordZoom(float f2) {
                TUIChatLog.i(JCameraView.TAG, "recordZoom");
                JCameraView.this.machine.zoom(f2, CameraInterface.TYPE_RECORDER);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.component.camera.listener.CaptureListener
            public void takePictures() {
                JCameraView.this.mSwitchCamera.setVisibility(4);
                JCameraView.this.machine.capture();
            }
        });
        this.mCaptureLayout.setTypeLisenter(new TypeListener() { // from class: com.tencent.qcloud.tuikit.tuichat.component.camera.view.JCameraView.3
            @Override // com.tencent.qcloud.tuikit.tuichat.component.camera.listener.TypeListener
            public void cancel() {
                JCameraView.this.machine.cancle(JCameraView.this.mVideoView.getHolder(), JCameraView.this.screenProp);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.component.camera.listener.TypeListener
            public void confirm() {
                JCameraView.this.machine.confirm();
            }
        });
        this.mCaptureLayout.setLeftClickListener(new ClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.component.camera.view.JCameraView.4
            @Override // com.tencent.qcloud.tuikit.tuichat.component.camera.listener.ClickListener
            public void onClick() {
                if (JCameraView.this.leftClickListener != null) {
                    JCameraView.this.leftClickListener.onClick();
                }
            }
        });
        this.mCaptureLayout.setRightClickListener(new ClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.component.camera.view.JCameraView.5
            @Override // com.tencent.qcloud.tuikit.tuichat.component.camera.listener.ClickListener
            public void onClick() {
                if (JCameraView.this.rightClickListener != null) {
                    JCameraView.this.rightClickListener.onClick();
                }
            }
        });
    }

    private void setFlashRes() {
        switch (this.type_flash) {
            case 33:
                this.machine.flash(q0.f15780c);
                return;
            case 34:
                this.machine.flash(q0.f15781d);
                return;
            case 35:
                this.machine.flash(q0.f15782e);
                return;
            default:
                return;
        }
    }

    private void setFocusViewWidthAnimation(float f2, float f3) {
        this.machine.foucs(f2, f3, new CameraInterface.FocusCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.component.camera.view.JCameraView.7
            @Override // com.tencent.qcloud.tuikit.tuichat.component.camera.view.CameraInterface.FocusCallback
            public void focusSuccess() {
                JCameraView.this.mFoucsView.setVisibility(4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateVideoViewSize(float f2, float f3) {
        if (f2 > f3) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) ((f3 / f2) * getWidth()));
            layoutParams.gravity = 17;
            this.mVideoView.setLayoutParams(layoutParams);
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.camera.view.CameraInterface.CameraOpenOverCallback
    public void cameraHasOpened() {
        CameraInterface.getInstance().doStartPreview(this.mVideoView.getHolder(), this.screenProp);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.camera.view.CameraView
    public void confirmState(int i2) {
        if (i2 == 1) {
            this.mPhoto.setVisibility(4);
            JCameraListener jCameraListener = this.jCameraLisenter;
            if (jCameraListener != null) {
                jCameraListener.captureSuccess(this.captureBitmap);
            }
        } else if (i2 == 2) {
            stopVideo();
            this.mVideoView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.machine.start(this.mVideoView.getHolder(), this.screenProp);
            JCameraListener jCameraListener2 = this.jCameraLisenter;
            if (jCameraListener2 != null) {
                jCameraListener2.recordSuccess(this.videoUrl, this.firstFrame, this.recordTime);
            }
        }
        this.mCaptureLayout.resetCaptureLayout();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.camera.view.CameraView
    public boolean handlerFoucs(float f2, float f3) {
        FoucsView foucsView;
        FoucsView foucsView2;
        if (f3 > this.mCaptureLayout.getTop()) {
            return false;
        }
        this.mFoucsView.setVisibility(0);
        if (f2 < this.mFoucsView.getWidth() / 2) {
            f2 = this.mFoucsView.getWidth() / 2;
        }
        if (f2 > this.layout_width - (this.mFoucsView.getWidth() / 2)) {
            f2 = this.layout_width - (this.mFoucsView.getWidth() / 2);
        }
        if (f3 < this.mFoucsView.getWidth() / 2) {
            f3 = this.mFoucsView.getWidth() / 2;
        }
        if (f3 > this.mCaptureLayout.getTop() - (this.mFoucsView.getWidth() / 2)) {
            f3 = this.mCaptureLayout.getTop() - (this.mFoucsView.getWidth() / 2);
        }
        this.mFoucsView.setX(f2 - (foucsView.getWidth() / 2));
        this.mFoucsView.setY(f3 - (foucsView2.getHeight() / 2));
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mFoucsView, "scaleX", 1.0f, 0.6f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mFoucsView, "scaleY", 1.0f, 0.6f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.mFoucsView, "alpha", 1.0f, 0.4f, 1.0f, 0.4f, 1.0f, 0.4f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2).before(ofFloat3);
        animatorSet.setDuration(400L);
        animatorSet.start();
        return true;
    }

    public void onDestroy() {
        stopVideo();
        resetState(1);
        CameraInterface.getInstance().isPreview(false);
        CameraInterface.getInstance().unregisterSensorManager(this.mContext);
        CameraInterface.destroyCameraInterface();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        float measuredWidth = this.mVideoView.getMeasuredWidth();
        float measuredHeight = this.mVideoView.getMeasuredHeight();
        if (this.screenProp == 0.0f) {
            this.screenProp = measuredHeight / measuredWidth;
        }
    }

    public void onPause() {
        TUIChatLog.i(TAG, "JCameraView onPause");
        this.machine.stop();
        CameraInterface.getInstance().unregisterSensorManager(this.mContext);
    }

    public void onResume() {
        TUIChatLog.i(TAG, "JCameraView onResume");
        resetState(4);
        CameraInterface.getInstance().registerSensorManager(this.mContext);
        this.machine.start(this.mVideoView.getHolder(), this.screenProp);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            if (motionEvent.getPointerCount() == 1) {
                setFocusViewWidthAnimation(motionEvent.getX(), motionEvent.getY());
            }
            if (motionEvent.getPointerCount() == 2) {
                TUIChatLog.i(TAG, "ACTION_DOWN = 2");
            }
        } else if (action == 1) {
            this.firstTouch = true;
        } else if (action == 2) {
            if (motionEvent.getPointerCount() == 1) {
                this.firstTouch = true;
            }
            if (motionEvent.getPointerCount() == 2) {
                float x = motionEvent.getX(0);
                float y = motionEvent.getY(0);
                float sqrt = (float) Math.sqrt(Math.pow(x - motionEvent.getX(1), 2.0d) + Math.pow(y - motionEvent.getY(1), 2.0d));
                if (this.firstTouch) {
                    this.firstTouchLength = sqrt;
                    this.firstTouch = false;
                }
                float f2 = this.firstTouchLength;
                if (((int) (sqrt - f2)) / this.zoomGradient != 0) {
                    this.firstTouch = true;
                    this.machine.zoom(sqrt - f2, CameraInterface.TYPE_CAPTURE);
                }
            }
        }
        return true;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.camera.view.CameraView
    public void playVideo(Bitmap bitmap, String str) {
        this.videoUrl = str;
        this.firstFrame = bitmap;
        try {
            MediaPlayer mediaPlayer = this.mMediaPlayer;
            if (mediaPlayer == null) {
                this.mMediaPlayer = new MediaPlayer();
            } else {
                mediaPlayer.reset();
            }
            this.mMediaPlayer.setDataSource(str);
            this.mMediaPlayer.setSurface(this.mVideoView.getHolder().getSurface());
            this.mMediaPlayer.setVideoScalingMode(1);
            this.mMediaPlayer.setAudioStreamType(3);
            this.mMediaPlayer.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.tencent.qcloud.tuikit.tuichat.component.camera.view.JCameraView.8
                @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
                public void onVideoSizeChanged(MediaPlayer mediaPlayer2, int i2, int i3) {
                    JCameraView jCameraView = JCameraView.this;
                    jCameraView.updateVideoViewSize(jCameraView.mMediaPlayer.getVideoWidth(), JCameraView.this.mMediaPlayer.getVideoHeight());
                }
            });
            this.mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.tencent.qcloud.tuikit.tuichat.component.camera.view.JCameraView.9
                @Override // android.media.MediaPlayer.OnPreparedListener
                public void onPrepared(MediaPlayer mediaPlayer2) {
                    JCameraView.this.mMediaPlayer.start();
                }
            });
            this.mMediaPlayer.setLooping(true);
            this.mMediaPlayer.prepareAsync();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.camera.view.CameraView
    public void resetState(int i2) {
        if (i2 == 1) {
            this.mPhoto.setVisibility(4);
        } else if (i2 == 2) {
            stopVideo();
            FileUtil.deleteFile(this.videoUrl);
            this.mVideoView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.machine.start(this.mVideoView.getHolder(), this.screenProp);
        } else if (i2 == 4) {
            this.mVideoView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }
        this.mSwitchCamera.setVisibility(0);
        this.mCaptureLayout.resetCaptureLayout();
    }

    public void setErrorLisenter(ErrorListener errorListener) {
        this.errorLisenter = errorListener;
        CameraInterface.getInstance().setErrorLinsenter(errorListener);
    }

    public void setFeatures(int i2) {
        this.mCaptureLayout.setButtonFeatures(i2);
    }

    public void setJCameraLisenter(JCameraListener jCameraListener) {
        this.jCameraLisenter = jCameraListener;
    }

    public void setLeftClickListener(ClickListener clickListener) {
        this.leftClickListener = clickListener;
    }

    public void setMediaQuality(int i2) {
        CameraInterface.getInstance().setMediaQuality(i2);
    }

    public void setRightClickListener(ClickListener clickListener) {
        this.rightClickListener = clickListener;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.camera.view.CameraView
    public void setTip(String str) {
        this.mCaptureLayout.setTip(str);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.camera.view.CameraView
    public void showPicture(Bitmap bitmap, boolean z) {
        if (z) {
            this.mPhoto.setScaleType(ImageView.ScaleType.FIT_XY);
        } else {
            this.mPhoto.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        this.captureBitmap = bitmap;
        this.mPhoto.setImageBitmap(bitmap);
        this.mPhoto.setVisibility(0);
        this.mCaptureLayout.startAlphaAnimation();
        this.mCaptureLayout.startTypeBtnAnimator();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.camera.view.CameraView
    public void startPreviewCallback() {
        TUIChatLog.i(TAG, "startPreviewCallback");
        handlerFoucs(this.mFoucsView.getWidth() / 2, this.mFoucsView.getHeight() / 2);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.camera.view.CameraView
    public void stopVideo() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
            return;
        }
        this.mMediaPlayer.stop();
        this.mMediaPlayer.release();
        this.mMediaPlayer = null;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        TUIChatLog.i(TAG, "JCameraView SurfaceCreated");
        new Thread() { // from class: com.tencent.qcloud.tuikit.tuichat.component.camera.view.JCameraView.6
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                CameraInterface.getInstance().doOpenCamera(JCameraView.this);
            }
        }.start();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        TUIChatLog.i(TAG, "JCameraView SurfaceDestroyed");
        CameraInterface.getInstance().doDestroyCamera();
    }

    public JCameraView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public JCameraView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.type_flash = 35;
        this.screenProp = 0.0f;
        this.iconSize = 0;
        this.iconMargin = 0;
        this.iconSrc = 0;
        this.iconLeft = 0;
        this.iconRight = 0;
        this.duration = 0;
        this.zoomGradient = 0;
        this.firstTouch = true;
        this.firstTouchLength = 0.0f;
        this.mContext = context;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.JCameraView, i2, 0);
        this.iconSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.JCameraView_iconSize, (int) TypedValue.applyDimension(2, 35.0f, getResources().getDisplayMetrics()));
        this.iconMargin = obtainStyledAttributes.getDimensionPixelSize(R.styleable.JCameraView_iconMargin, (int) TypedValue.applyDimension(2, 15.0f, getResources().getDisplayMetrics()));
        this.iconSrc = obtainStyledAttributes.getResourceId(R.styleable.JCameraView_iconSrc, R.drawable.ic_camera);
        this.iconLeft = obtainStyledAttributes.getResourceId(R.styleable.JCameraView_iconLeft, 0);
        this.iconRight = obtainStyledAttributes.getResourceId(R.styleable.JCameraView_iconRight, 0);
        this.duration = TUIChatService.getChatConfig().getGeneralConfig().getVideoRecordMaxTime() * 1000;
        obtainStyledAttributes.recycle();
        initData();
        initView();
    }
}
