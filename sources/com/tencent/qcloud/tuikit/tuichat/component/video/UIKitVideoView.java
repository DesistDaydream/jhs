package com.tencent.qcloud.tuikit.tuichat.component.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.android.tpns.mqtt.MqttTopic;
import com.tencent.qcloud.tuikit.tuichat.component.video.proxy.IPlayer;
import com.tencent.qcloud.tuikit.tuichat.component.video.proxy.MediaPlayerProxy;

/* loaded from: classes3.dex */
public class UIKitVideoView extends TextureView {
    private Context mContext;
    private int mCurrentState;
    private MediaPlayerProxy mMediaPlayer;
    private IPlayer.OnCompletionListener mOnCompletionListener;
    private IPlayer.OnErrorListener mOnErrorListener;
    private IPlayer.OnInfoListener mOnInfoListener;
    private IPlayer.OnPreparedListener mOnPreparedListener;
    private IPlayer.OnSeekCompleteListener mOnSeekCompleteListener;
    private IPlayer.OnVideoSizeChangedListener mOnVideoSizeChangedListener;
    private IPlayer.OnCompletionListener mOutOnCompletionListener;
    private IPlayer.OnErrorListener mOutOnErrorListener;
    private IPlayer.OnPreparedListener mOutOnPreparedListener;
    private Surface mSurface;
    private TextureView.SurfaceTextureListener mSurfaceTextureListener;
    private Uri mUri;
    private int mVideoHeight;
    private int mVideoRotationDegree;
    private int mVideoWidth;
    private IPlayer.OnSeekCompleteListener onSeekCompleteListener;
    private static final String TAG = UIKitVideoView.class.getSimpleName();
    private static int STATE_ERROR = -1;
    private static int STATE_IDLE = 0;
    private static int STATE_PREPARING = 1;
    private static int STATE_PREPARED = 2;
    private static int STATE_PLAYING = 3;
    private static int STATE_PAUSED = 4;
    private static int STATE_PLAYBACK_COMPLETED = 5;
    private static int STATE_STOPPED = 6;

    public UIKitVideoView(Context context) {
        super(context);
        this.mCurrentState = STATE_IDLE;
        this.mOnPreparedListener = new IPlayer.OnPreparedListener() { // from class: com.tencent.qcloud.tuikit.tuichat.component.video.UIKitVideoView.1
            @Override // com.tencent.qcloud.tuikit.tuichat.component.video.proxy.IPlayer.OnPreparedListener
            public void onPrepared(IPlayer iPlayer) {
                UIKitVideoView.this.mCurrentState = UIKitVideoView.STATE_PREPARED;
                UIKitVideoView.this.mVideoHeight = iPlayer.getVideoHeight();
                UIKitVideoView.this.mVideoWidth = iPlayer.getVideoWidth();
                String str = UIKitVideoView.TAG;
                Log.i(str, "onPrepared mVideoWidth: " + UIKitVideoView.this.mVideoWidth + " mVideoHeight: " + UIKitVideoView.this.mVideoHeight + " mVideoRotationDegree: " + UIKitVideoView.this.mVideoRotationDegree);
                if (UIKitVideoView.this.mOutOnPreparedListener != null) {
                    UIKitVideoView.this.mOutOnPreparedListener.onPrepared(iPlayer);
                }
            }
        };
        this.mOnErrorListener = new IPlayer.OnErrorListener() { // from class: com.tencent.qcloud.tuikit.tuichat.component.video.UIKitVideoView.2
            @Override // com.tencent.qcloud.tuikit.tuichat.component.video.proxy.IPlayer.OnErrorListener
            public boolean onError(IPlayer iPlayer, int i2, int i3) {
                String str = UIKitVideoView.TAG;
                Log.w(str, "onError: what/extra: " + i2 + MqttTopic.TOPIC_LEVEL_SEPARATOR + i3);
                UIKitVideoView.this.mCurrentState = UIKitVideoView.STATE_ERROR;
                UIKitVideoView.this.stop_l();
                if (UIKitVideoView.this.mOutOnErrorListener != null) {
                    UIKitVideoView.this.mOutOnErrorListener.onError(iPlayer, i2, i3);
                    return true;
                }
                return true;
            }
        };
        this.mOnInfoListener = new IPlayer.OnInfoListener() { // from class: com.tencent.qcloud.tuikit.tuichat.component.video.UIKitVideoView.3
            @Override // com.tencent.qcloud.tuikit.tuichat.component.video.proxy.IPlayer.OnInfoListener
            public void onInfo(IPlayer iPlayer, int i2, int i3) {
                String str = UIKitVideoView.TAG;
                Log.w(str, "onInfo: what/extra: " + i2 + MqttTopic.TOPIC_LEVEL_SEPARATOR + i3);
                if (i2 == 10001) {
                    UIKitVideoView.this.mVideoRotationDegree = i3;
                    UIKitVideoView uIKitVideoView = UIKitVideoView.this;
                    uIKitVideoView.setRotation(uIKitVideoView.mVideoRotationDegree);
                    UIKitVideoView.this.requestLayout();
                }
            }
        };
        this.mOnCompletionListener = new IPlayer.OnCompletionListener() { // from class: com.tencent.qcloud.tuikit.tuichat.component.video.UIKitVideoView.4
            @Override // com.tencent.qcloud.tuikit.tuichat.component.video.proxy.IPlayer.OnCompletionListener
            public void onCompletion(IPlayer iPlayer) {
                Log.i(UIKitVideoView.TAG, "onCompletion");
                UIKitVideoView.this.mCurrentState = UIKitVideoView.STATE_PLAYBACK_COMPLETED;
                if (UIKitVideoView.this.mOutOnCompletionListener != null) {
                    UIKitVideoView.this.mOutOnCompletionListener.onCompletion(iPlayer);
                }
            }
        };
        this.mOnVideoSizeChangedListener = new IPlayer.OnVideoSizeChangedListener() { // from class: com.tencent.qcloud.tuikit.tuichat.component.video.UIKitVideoView.5
            @Override // com.tencent.qcloud.tuikit.tuichat.component.video.proxy.IPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(IPlayer iPlayer, int i2, int i3) {
            }
        };
        this.onSeekCompleteListener = new IPlayer.OnSeekCompleteListener() { // from class: com.tencent.qcloud.tuikit.tuichat.component.video.UIKitVideoView.6
            @Override // com.tencent.qcloud.tuikit.tuichat.component.video.proxy.IPlayer.OnSeekCompleteListener
            public void OnSeekComplete(IPlayer iPlayer) {
                if (UIKitVideoView.this.mOnSeekCompleteListener != null) {
                    UIKitVideoView.this.mOnSeekCompleteListener.OnSeekComplete(iPlayer);
                }
            }
        };
        this.mSurfaceTextureListener = new TextureView.SurfaceTextureListener() { // from class: com.tencent.qcloud.tuikit.tuichat.component.video.UIKitVideoView.7
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
                Log.i(UIKitVideoView.TAG, "onSurfaceTextureAvailable");
                UIKitVideoView.this.mSurface = new Surface(surfaceTexture);
                UIKitVideoView.this.openVideo();
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                Log.i(UIKitVideoView.TAG, "onSurfaceTextureDestroyed");
                return true;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
                Log.i(UIKitVideoView.TAG, "onSurfaceTextureSizeChanged");
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        initVideoView(context);
    }

    private void initVideoView(Context context) {
        Log.i(TAG, "initVideoView");
        this.mContext = context;
        setSurfaceTextureListener(this.mSurfaceTextureListener);
        this.mCurrentState = STATE_IDLE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openVideo() {
        if (this.mUri == null) {
            Log.e(TAG, "openVideo: mUri is null ");
            return;
        }
        String str = TAG;
        Log.i(str, "openVideo: mUri: " + this.mUri.getPath() + " mSurface: " + this.mSurface);
        if (this.mSurface == null) {
            Log.e(str, "openVideo: mSurface is null ");
            return;
        }
        stop_l();
        try {
            MediaPlayerProxy mediaPlayerProxy = new MediaPlayerProxy();
            this.mMediaPlayer = mediaPlayerProxy;
            mediaPlayerProxy.setOnPreparedListener(this.mOnPreparedListener);
            this.mMediaPlayer.setOnCompletionListener(this.mOnCompletionListener);
            this.mMediaPlayer.setOnErrorListener(this.mOnErrorListener);
            this.mMediaPlayer.setOnInfoListener(this.mOnInfoListener);
            this.mMediaPlayer.setOnVideoSizeChangedListener(this.mOnVideoSizeChangedListener);
            this.mMediaPlayer.setOnSeekCompleteListener(this.mOnSeekCompleteListener);
            this.mMediaPlayer.setSurface(this.mSurface);
            this.mMediaPlayer.setDataSource(getContext(), this.mUri);
            this.mMediaPlayer.prepareAsync();
            this.mCurrentState = STATE_PREPARING;
        } catch (Exception e2) {
            String str2 = TAG;
            Log.w(str2, "ex = " + e2.getMessage());
            this.mCurrentState = STATE_ERROR;
        }
    }

    public int getCurrentPosition() {
        MediaPlayerProxy mediaPlayerProxy = this.mMediaPlayer;
        if (mediaPlayerProxy != null) {
            return mediaPlayerProxy.getCurrentPosition();
        }
        return 0;
    }

    public int getDuration() {
        MediaPlayerProxy mediaPlayerProxy = this.mMediaPlayer;
        if (mediaPlayerProxy != null) {
            return mediaPlayerProxy.getDuration();
        }
        return 0;
    }

    public boolean isPlaying() {
        MediaPlayerProxy mediaPlayerProxy = this.mMediaPlayer;
        if (mediaPlayerProxy != null) {
            return mediaPlayerProxy.isPlaying();
        }
        return false;
    }

    public boolean isPrepared() {
        if (this.mUri == null) {
            Log.e(TAG, "isPrepared: mUri is null ");
            return false;
        }
        String str = TAG;
        Log.i(str, "isPrepared: mUri: " + this.mUri.getPath() + " mSurface: " + this.mSurface);
        if (this.mSurface == null) {
            Log.e(str, "isPrepared: mSurface is null ");
            return false;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0058, code lost:
        if (r0 > r7) goto L16;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r7, int r8) {
        /*
            Method dump skipped, instructions count: 218
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qcloud.tuikit.tuichat.component.video.UIKitVideoView.onMeasure(int, int):void");
    }

    public boolean pause() {
        String str = TAG;
        Log.i(str, "pause mCurrentState:" + this.mCurrentState);
        MediaPlayerProxy mediaPlayerProxy = this.mMediaPlayer;
        if (mediaPlayerProxy != null) {
            mediaPlayerProxy.pause();
            this.mCurrentState = STATE_PAUSED;
            return true;
        }
        return true;
    }

    public void resetVideo() {
        openVideo();
    }

    public void seekTo(int i2) {
        MediaPlayerProxy mediaPlayerProxy = this.mMediaPlayer;
        if (mediaPlayerProxy != null) {
            mediaPlayerProxy.seekTo(i2);
        }
    }

    @Override // android.view.TextureView, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 24 || drawable == null) {
            return;
        }
        super.setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
    }

    public void setOnCompletionListener(IPlayer.OnCompletionListener onCompletionListener) {
        this.mOutOnCompletionListener = onCompletionListener;
    }

    public void setOnErrorListener(IPlayer.OnErrorListener onErrorListener) {
        this.mOutOnErrorListener = onErrorListener;
    }

    public void setOnPreparedListener(IPlayer.OnPreparedListener onPreparedListener) {
        this.mOutOnPreparedListener = onPreparedListener;
    }

    public void setOnSeekCompleteListener(IPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.mOnSeekCompleteListener = onSeekCompleteListener;
    }

    public void setVideoURI(Uri uri) {
        this.mUri = uri;
        openVideo();
    }

    public boolean start() {
        String str = TAG;
        Log.i(str, "start mCurrentState:" + this.mCurrentState);
        MediaPlayerProxy mediaPlayerProxy = this.mMediaPlayer;
        if (mediaPlayerProxy != null) {
            mediaPlayerProxy.start();
            this.mCurrentState = STATE_PLAYING;
            return true;
        }
        return true;
    }

    public boolean stop() {
        String str = TAG;
        Log.i(str, "stop mCurrentState:" + this.mCurrentState);
        stop_l();
        return true;
    }

    public void stop_l() {
        MediaPlayerProxy mediaPlayerProxy = this.mMediaPlayer;
        if (mediaPlayerProxy != null) {
            mediaPlayerProxy.stop();
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
            this.mCurrentState = STATE_IDLE;
        }
    }

    public UIKitVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentState = STATE_IDLE;
        this.mOnPreparedListener = new IPlayer.OnPreparedListener() { // from class: com.tencent.qcloud.tuikit.tuichat.component.video.UIKitVideoView.1
            @Override // com.tencent.qcloud.tuikit.tuichat.component.video.proxy.IPlayer.OnPreparedListener
            public void onPrepared(IPlayer iPlayer) {
                UIKitVideoView.this.mCurrentState = UIKitVideoView.STATE_PREPARED;
                UIKitVideoView.this.mVideoHeight = iPlayer.getVideoHeight();
                UIKitVideoView.this.mVideoWidth = iPlayer.getVideoWidth();
                String str = UIKitVideoView.TAG;
                Log.i(str, "onPrepared mVideoWidth: " + UIKitVideoView.this.mVideoWidth + " mVideoHeight: " + UIKitVideoView.this.mVideoHeight + " mVideoRotationDegree: " + UIKitVideoView.this.mVideoRotationDegree);
                if (UIKitVideoView.this.mOutOnPreparedListener != null) {
                    UIKitVideoView.this.mOutOnPreparedListener.onPrepared(iPlayer);
                }
            }
        };
        this.mOnErrorListener = new IPlayer.OnErrorListener() { // from class: com.tencent.qcloud.tuikit.tuichat.component.video.UIKitVideoView.2
            @Override // com.tencent.qcloud.tuikit.tuichat.component.video.proxy.IPlayer.OnErrorListener
            public boolean onError(IPlayer iPlayer, int i2, int i3) {
                String str = UIKitVideoView.TAG;
                Log.w(str, "onError: what/extra: " + i2 + MqttTopic.TOPIC_LEVEL_SEPARATOR + i3);
                UIKitVideoView.this.mCurrentState = UIKitVideoView.STATE_ERROR;
                UIKitVideoView.this.stop_l();
                if (UIKitVideoView.this.mOutOnErrorListener != null) {
                    UIKitVideoView.this.mOutOnErrorListener.onError(iPlayer, i2, i3);
                    return true;
                }
                return true;
            }
        };
        this.mOnInfoListener = new IPlayer.OnInfoListener() { // from class: com.tencent.qcloud.tuikit.tuichat.component.video.UIKitVideoView.3
            @Override // com.tencent.qcloud.tuikit.tuichat.component.video.proxy.IPlayer.OnInfoListener
            public void onInfo(IPlayer iPlayer, int i2, int i3) {
                String str = UIKitVideoView.TAG;
                Log.w(str, "onInfo: what/extra: " + i2 + MqttTopic.TOPIC_LEVEL_SEPARATOR + i3);
                if (i2 == 10001) {
                    UIKitVideoView.this.mVideoRotationDegree = i3;
                    UIKitVideoView uIKitVideoView = UIKitVideoView.this;
                    uIKitVideoView.setRotation(uIKitVideoView.mVideoRotationDegree);
                    UIKitVideoView.this.requestLayout();
                }
            }
        };
        this.mOnCompletionListener = new IPlayer.OnCompletionListener() { // from class: com.tencent.qcloud.tuikit.tuichat.component.video.UIKitVideoView.4
            @Override // com.tencent.qcloud.tuikit.tuichat.component.video.proxy.IPlayer.OnCompletionListener
            public void onCompletion(IPlayer iPlayer) {
                Log.i(UIKitVideoView.TAG, "onCompletion");
                UIKitVideoView.this.mCurrentState = UIKitVideoView.STATE_PLAYBACK_COMPLETED;
                if (UIKitVideoView.this.mOutOnCompletionListener != null) {
                    UIKitVideoView.this.mOutOnCompletionListener.onCompletion(iPlayer);
                }
            }
        };
        this.mOnVideoSizeChangedListener = new IPlayer.OnVideoSizeChangedListener() { // from class: com.tencent.qcloud.tuikit.tuichat.component.video.UIKitVideoView.5
            @Override // com.tencent.qcloud.tuikit.tuichat.component.video.proxy.IPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(IPlayer iPlayer, int i2, int i3) {
            }
        };
        this.onSeekCompleteListener = new IPlayer.OnSeekCompleteListener() { // from class: com.tencent.qcloud.tuikit.tuichat.component.video.UIKitVideoView.6
            @Override // com.tencent.qcloud.tuikit.tuichat.component.video.proxy.IPlayer.OnSeekCompleteListener
            public void OnSeekComplete(IPlayer iPlayer) {
                if (UIKitVideoView.this.mOnSeekCompleteListener != null) {
                    UIKitVideoView.this.mOnSeekCompleteListener.OnSeekComplete(iPlayer);
                }
            }
        };
        this.mSurfaceTextureListener = new TextureView.SurfaceTextureListener() { // from class: com.tencent.qcloud.tuikit.tuichat.component.video.UIKitVideoView.7
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
                Log.i(UIKitVideoView.TAG, "onSurfaceTextureAvailable");
                UIKitVideoView.this.mSurface = new Surface(surfaceTexture);
                UIKitVideoView.this.openVideo();
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                Log.i(UIKitVideoView.TAG, "onSurfaceTextureDestroyed");
                return true;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
                Log.i(UIKitVideoView.TAG, "onSurfaceTextureSizeChanged");
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        initVideoView(context);
    }

    public UIKitVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mCurrentState = STATE_IDLE;
        this.mOnPreparedListener = new IPlayer.OnPreparedListener() { // from class: com.tencent.qcloud.tuikit.tuichat.component.video.UIKitVideoView.1
            @Override // com.tencent.qcloud.tuikit.tuichat.component.video.proxy.IPlayer.OnPreparedListener
            public void onPrepared(IPlayer iPlayer) {
                UIKitVideoView.this.mCurrentState = UIKitVideoView.STATE_PREPARED;
                UIKitVideoView.this.mVideoHeight = iPlayer.getVideoHeight();
                UIKitVideoView.this.mVideoWidth = iPlayer.getVideoWidth();
                String str = UIKitVideoView.TAG;
                Log.i(str, "onPrepared mVideoWidth: " + UIKitVideoView.this.mVideoWidth + " mVideoHeight: " + UIKitVideoView.this.mVideoHeight + " mVideoRotationDegree: " + UIKitVideoView.this.mVideoRotationDegree);
                if (UIKitVideoView.this.mOutOnPreparedListener != null) {
                    UIKitVideoView.this.mOutOnPreparedListener.onPrepared(iPlayer);
                }
            }
        };
        this.mOnErrorListener = new IPlayer.OnErrorListener() { // from class: com.tencent.qcloud.tuikit.tuichat.component.video.UIKitVideoView.2
            @Override // com.tencent.qcloud.tuikit.tuichat.component.video.proxy.IPlayer.OnErrorListener
            public boolean onError(IPlayer iPlayer, int i22, int i3) {
                String str = UIKitVideoView.TAG;
                Log.w(str, "onError: what/extra: " + i22 + MqttTopic.TOPIC_LEVEL_SEPARATOR + i3);
                UIKitVideoView.this.mCurrentState = UIKitVideoView.STATE_ERROR;
                UIKitVideoView.this.stop_l();
                if (UIKitVideoView.this.mOutOnErrorListener != null) {
                    UIKitVideoView.this.mOutOnErrorListener.onError(iPlayer, i22, i3);
                    return true;
                }
                return true;
            }
        };
        this.mOnInfoListener = new IPlayer.OnInfoListener() { // from class: com.tencent.qcloud.tuikit.tuichat.component.video.UIKitVideoView.3
            @Override // com.tencent.qcloud.tuikit.tuichat.component.video.proxy.IPlayer.OnInfoListener
            public void onInfo(IPlayer iPlayer, int i22, int i3) {
                String str = UIKitVideoView.TAG;
                Log.w(str, "onInfo: what/extra: " + i22 + MqttTopic.TOPIC_LEVEL_SEPARATOR + i3);
                if (i22 == 10001) {
                    UIKitVideoView.this.mVideoRotationDegree = i3;
                    UIKitVideoView uIKitVideoView = UIKitVideoView.this;
                    uIKitVideoView.setRotation(uIKitVideoView.mVideoRotationDegree);
                    UIKitVideoView.this.requestLayout();
                }
            }
        };
        this.mOnCompletionListener = new IPlayer.OnCompletionListener() { // from class: com.tencent.qcloud.tuikit.tuichat.component.video.UIKitVideoView.4
            @Override // com.tencent.qcloud.tuikit.tuichat.component.video.proxy.IPlayer.OnCompletionListener
            public void onCompletion(IPlayer iPlayer) {
                Log.i(UIKitVideoView.TAG, "onCompletion");
                UIKitVideoView.this.mCurrentState = UIKitVideoView.STATE_PLAYBACK_COMPLETED;
                if (UIKitVideoView.this.mOutOnCompletionListener != null) {
                    UIKitVideoView.this.mOutOnCompletionListener.onCompletion(iPlayer);
                }
            }
        };
        this.mOnVideoSizeChangedListener = new IPlayer.OnVideoSizeChangedListener() { // from class: com.tencent.qcloud.tuikit.tuichat.component.video.UIKitVideoView.5
            @Override // com.tencent.qcloud.tuikit.tuichat.component.video.proxy.IPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(IPlayer iPlayer, int i22, int i3) {
            }
        };
        this.onSeekCompleteListener = new IPlayer.OnSeekCompleteListener() { // from class: com.tencent.qcloud.tuikit.tuichat.component.video.UIKitVideoView.6
            @Override // com.tencent.qcloud.tuikit.tuichat.component.video.proxy.IPlayer.OnSeekCompleteListener
            public void OnSeekComplete(IPlayer iPlayer) {
                if (UIKitVideoView.this.mOnSeekCompleteListener != null) {
                    UIKitVideoView.this.mOnSeekCompleteListener.OnSeekComplete(iPlayer);
                }
            }
        };
        this.mSurfaceTextureListener = new TextureView.SurfaceTextureListener() { // from class: com.tencent.qcloud.tuikit.tuichat.component.video.UIKitVideoView.7
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i22, int i3) {
                Log.i(UIKitVideoView.TAG, "onSurfaceTextureAvailable");
                UIKitVideoView.this.mSurface = new Surface(surfaceTexture);
                UIKitVideoView.this.openVideo();
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                Log.i(UIKitVideoView.TAG, "onSurfaceTextureDestroyed");
                return true;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i22, int i3) {
                Log.i(UIKitVideoView.TAG, "onSurfaceTextureSizeChanged");
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        initVideoView(context);
    }
}
