package com.tencent.qcloud.tuikit.tuichat.component.video.proxy;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.qcloud.tuikit.tuichat.component.video.proxy.IPlayer;
import java.io.IOException;

/* loaded from: classes3.dex */
public class MediaPlayerProxy implements IPlayer {
    private static final String TAG = "MediaPlayerProxy";
    private IPlayer mMediaPlayer;

    public MediaPlayerProxy() {
        try {
            Class.forName("tv.danmaku.ijk.media.player.IjkMediaPlayer").newInstance();
            this.mMediaPlayer = new IjkMediaPlayerWrapper();
        } catch (Exception unused) {
            this.mMediaPlayer = new SystemMediaPlayerWrapper();
        }
        String str = TAG;
        Log.i(str, "use mMediaPlayer: " + this.mMediaPlayer);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.video.proxy.IPlayer
    public int getCurrentPosition() {
        return this.mMediaPlayer.getCurrentPosition();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.video.proxy.IPlayer
    public int getDuration() {
        return this.mMediaPlayer.getDuration();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.video.proxy.IPlayer
    public int getVideoHeight() {
        return this.mMediaPlayer.getVideoHeight();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.video.proxy.IPlayer
    public int getVideoWidth() {
        return this.mMediaPlayer.getVideoWidth();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.video.proxy.IPlayer
    public boolean isPlaying() {
        return this.mMediaPlayer.isPlaying();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.video.proxy.IPlayer
    public void pause() {
        this.mMediaPlayer.pause();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.video.proxy.IPlayer
    public void prepareAsync() {
        this.mMediaPlayer.prepareAsync();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.video.proxy.IPlayer
    public void release() {
        this.mMediaPlayer.release();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.video.proxy.IPlayer
    public void seekTo(int i2) {
        this.mMediaPlayer.seekTo(i2);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.video.proxy.IPlayer
    public void setDataSource(Context context, Uri uri) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        this.mMediaPlayer.setDataSource(context, uri);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.video.proxy.IPlayer
    public void setDisplay(SurfaceHolder surfaceHolder) {
        this.mMediaPlayer.setDisplay(surfaceHolder);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.video.proxy.IPlayer
    public void setOnCompletionListener(IPlayer.OnCompletionListener onCompletionListener) {
        this.mMediaPlayer.setOnCompletionListener(onCompletionListener);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.video.proxy.IPlayer
    public void setOnErrorListener(IPlayer.OnErrorListener onErrorListener) {
        this.mMediaPlayer.setOnErrorListener(onErrorListener);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.video.proxy.IPlayer
    public void setOnInfoListener(IPlayer.OnInfoListener onInfoListener) {
        this.mMediaPlayer.setOnInfoListener(onInfoListener);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.video.proxy.IPlayer
    public void setOnPreparedListener(IPlayer.OnPreparedListener onPreparedListener) {
        this.mMediaPlayer.setOnPreparedListener(onPreparedListener);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.video.proxy.IPlayer
    public void setOnSeekCompleteListener(IPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.mMediaPlayer.setOnSeekCompleteListener(onSeekCompleteListener);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.video.proxy.IPlayer
    public void setOnVideoSizeChangedListener(IPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.mMediaPlayer.setOnVideoSizeChangedListener(onVideoSizeChangedListener);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.video.proxy.IPlayer
    public void setSurface(Surface surface) {
        this.mMediaPlayer.setSurface(surface);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.video.proxy.IPlayer
    public void start() {
        this.mMediaPlayer.start();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.video.proxy.IPlayer
    public void stop() {
        this.mMediaPlayer.stop();
    }
}
