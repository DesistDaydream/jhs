package com.tencent.qcloud.tuikit.tuichat.component.video.proxy;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import android.view.SurfaceHolder;
import java.io.IOException;

/* loaded from: classes3.dex */
public interface IPlayer {

    /* loaded from: classes3.dex */
    public interface OnCompletionListener {
        void onCompletion(IPlayer iPlayer);
    }

    /* loaded from: classes3.dex */
    public interface OnErrorListener {
        boolean onError(IPlayer iPlayer, int i2, int i3);
    }

    /* loaded from: classes3.dex */
    public interface OnInfoListener {
        void onInfo(IPlayer iPlayer, int i2, int i3);
    }

    /* loaded from: classes3.dex */
    public interface OnPreparedListener {
        void onPrepared(IPlayer iPlayer);
    }

    /* loaded from: classes3.dex */
    public interface OnSeekCompleteListener {
        void OnSeekComplete(IPlayer iPlayer);
    }

    /* loaded from: classes3.dex */
    public interface OnVideoSizeChangedListener {
        void onVideoSizeChanged(IPlayer iPlayer, int i2, int i3);
    }

    int getCurrentPosition();

    int getDuration();

    int getVideoHeight();

    int getVideoWidth();

    boolean isPlaying();

    void pause();

    void prepareAsync();

    void release();

    void seekTo(int i2);

    void setDataSource(Context context, Uri uri) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException;

    void setDisplay(SurfaceHolder surfaceHolder);

    void setOnCompletionListener(OnCompletionListener onCompletionListener);

    void setOnErrorListener(OnErrorListener onErrorListener);

    void setOnInfoListener(OnInfoListener onInfoListener);

    void setOnPreparedListener(OnPreparedListener onPreparedListener);

    void setOnSeekCompleteListener(OnSeekCompleteListener onSeekCompleteListener);

    void setOnVideoSizeChangedListener(OnVideoSizeChangedListener onVideoSizeChangedListener);

    void setSurface(Surface surface);

    void start();

    void stop();
}
