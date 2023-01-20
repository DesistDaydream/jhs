package com.m7.imkfsdk.utils;

import android.media.MediaPlayer;
import android.text.TextUtils;
import java.io.File;

/* loaded from: classes2.dex */
public class MediaPlayTools {
    private static final int STATUS_ERROR = -1;
    private static final int STATUS_PAUSE = 2;
    private static final int STATUS_PLAYING = 1;
    private static final int STATUS_STOP = 0;
    private static final String TAG = "MediaPlayTools";
    private static MediaPlayTools mInstance;
    private OnVoicePlayCompletionListener mListener;
    private MediaPlayer mediaPlayer = new MediaPlayer();
    private String urlPath = "";
    private int status = 0;
    private boolean calling = false;

    /* loaded from: classes2.dex */
    public interface OnVoicePlayCompletionListener {
        void OnVoicePlayCompletion();
    }

    public MediaPlayTools() {
        setOnCompletionListener();
        setOnErrorListener();
    }

    public static synchronized MediaPlayTools getInstance() {
        MediaPlayTools mediaPlayTools;
        synchronized (MediaPlayTools.class) {
            if (mInstance == null) {
                mInstance = new MediaPlayTools();
            }
            mediaPlayTools = mInstance;
        }
        return mediaPlayTools;
    }

    private void play(boolean z, int i2) {
        if (TextUtils.isEmpty(this.urlPath) || !new File(this.urlPath).exists()) {
            return;
        }
        int i3 = z ? 0 : 3;
        if (this.mediaPlayer == null) {
            this.mediaPlayer = new MediaPlayer();
            setOnCompletionListener();
            setOnErrorListener();
        }
        try {
            this.mediaPlayer.reset();
            this.mediaPlayer.setAudioStreamType(i3);
            this.mediaPlayer.setDataSource(this.urlPath);
            this.mediaPlayer.prepare();
            if (i2 > 0) {
                this.mediaPlayer.seekTo(i2);
            }
            this.mediaPlayer.start();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void setOnCompletionListener() {
        this.mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.m7.imkfsdk.utils.MediaPlayTools.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                MediaPlayTools.this.status = 0;
                if (MediaPlayTools.this.mListener != null) {
                    MediaPlayTools.this.mListener.OnVoicePlayCompletion();
                }
            }
        });
    }

    private void setOnErrorListener() {
        this.mediaPlayer.setOnErrorListener(null);
    }

    public int getStatus() {
        return this.status;
    }

    public boolean isPlaying() {
        return this.status == 1;
    }

    public boolean pause() {
        if (this.status != 1) {
            return false;
        }
        try {
            this.mediaPlayer.pause();
            this.status = 2;
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            this.status = -1;
            return false;
        }
    }

    public boolean playVoice(String str, boolean z) {
        return play(str, z, 0);
    }

    public boolean resume() {
        if (this.status != 2) {
            return false;
        }
        try {
            this.mediaPlayer.start();
            this.status = 1;
            return true;
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
            this.status = -1;
            return false;
        }
    }

    public void setOnVoicePlayCompletionListener(OnVoicePlayCompletionListener onVoicePlayCompletionListener) {
        this.mListener = onVoicePlayCompletionListener;
    }

    public void setSpeakerOn(boolean z) {
        if (this.mediaPlayer == null) {
            this.mediaPlayer = new MediaPlayer();
        }
        if (this.calling) {
            return;
        }
        int currentPosition = this.mediaPlayer.getCurrentPosition();
        stop();
        setOnCompletionListener();
        setOnErrorListener();
        play(this.urlPath, !z, currentPosition);
    }

    public boolean stop() {
        int i2 = this.status;
        if (i2 == 1 || i2 == 2) {
            try {
                MediaPlayer mediaPlayer = this.mediaPlayer;
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                    this.mediaPlayer.release();
                    this.mediaPlayer = null;
                }
                this.status = 0;
                return true;
            } catch (IllegalStateException e2) {
                e2.printStackTrace();
                this.status = -1;
                return false;
            }
        }
        return false;
    }

    private boolean play(String str, boolean z, int i2) {
        if (this.status != 0) {
            return false;
        }
        this.urlPath = str;
        try {
            play(z, i2);
            this.status = 1;
        } catch (Exception e2) {
            e2.printStackTrace();
            try {
                play(true, i2);
            } catch (Exception e3) {
                e3.printStackTrace();
                return false;
            }
        }
        return true;
    }
}
