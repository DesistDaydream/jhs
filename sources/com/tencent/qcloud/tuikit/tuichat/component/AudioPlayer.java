package com.tencent.qcloud.tuikit.tuichat.component;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Handler;
import com.tencent.qcloud.tuicore.TUIConfig;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatService;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;

/* loaded from: classes3.dex */
public class AudioPlayer {
    private static final String TAG = "AudioPlayer";
    private String mAudioRecordPath;
    private Handler mHandler = new Handler();
    private Callback mPlayCallback;
    private MediaPlayer mPlayer;
    private Callback mRecordCallback;
    private MediaRecorder mRecorder;
    private static AudioPlayer sInstance = new AudioPlayer();
    private static String CURRENT_RECORD_FILE = TUIConfig.getRecordDir() + "auto_";
    private static int MAGIC_NUMBER = 500;
    private static int MIN_RECORD_DURATION = 1000;

    /* loaded from: classes3.dex */
    public interface Callback {
        void onCompletion(Boolean bool);
    }

    private AudioPlayer() {
    }

    public static AudioPlayer getInstance() {
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPlayCompleted(boolean z) {
        Callback callback = this.mPlayCallback;
        if (callback != null) {
            callback.onCompletion(Boolean.valueOf(z));
        }
        this.mPlayer = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRecordCompleted(boolean z) {
        Callback callback = this.mRecordCallback;
        if (callback != null) {
            callback.onCompletion(Boolean.valueOf(z));
        }
        this.mRecorder = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopInternalPlay() {
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer == null) {
            return;
        }
        mediaPlayer.release();
        this.mPlayer = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopInternalRecord() {
        this.mHandler.removeCallbacksAndMessages(null);
        MediaRecorder mediaRecorder = this.mRecorder;
        if (mediaRecorder == null) {
            return;
        }
        mediaRecorder.release();
        this.mRecorder = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int getDuration() {
        /*
            r5 = this;
            java.lang.String r0 = r5.mAudioRecordPath
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r1 = 0
            if (r0 == 0) goto La
            return r1
        La:
            android.media.MediaPlayer r0 = new android.media.MediaPlayer     // Catch: java.lang.Exception -> L27
            r0.<init>()     // Catch: java.lang.Exception -> L27
            java.lang.String r2 = r5.mAudioRecordPath     // Catch: java.lang.Exception -> L27
            r0.setDataSource(r2)     // Catch: java.lang.Exception -> L27
            r0.prepare()     // Catch: java.lang.Exception -> L27
            int r0 = r0.getDuration()     // Catch: java.lang.Exception -> L27
            int r2 = com.tencent.qcloud.tuikit.tuichat.component.AudioPlayer.MIN_RECORD_DURATION     // Catch: java.lang.Exception -> L25
            if (r0 >= r2) goto L21
            r0 = 0
            goto L30
        L21:
            int r2 = com.tencent.qcloud.tuikit.tuichat.component.AudioPlayer.MAGIC_NUMBER     // Catch: java.lang.Exception -> L25
            int r0 = r0 + r2
            goto L30
        L25:
            r2 = move-exception
            goto L29
        L27:
            r2 = move-exception
            r0 = 0
        L29:
            java.lang.String r3 = com.tencent.qcloud.tuikit.tuichat.component.AudioPlayer.TAG
            java.lang.String r4 = "getDuration failed"
            com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog.w(r3, r4, r2)
        L30:
            if (r0 >= 0) goto L33
            goto L34
        L33:
            r1 = r0
        L34:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qcloud.tuikit.tuichat.component.AudioPlayer.getDuration():int");
    }

    public String getPath() {
        return this.mAudioRecordPath;
    }

    public boolean isPlaying() {
        MediaPlayer mediaPlayer = this.mPlayer;
        return mediaPlayer != null && mediaPlayer.isPlaying();
    }

    public void startPlay(String str, Callback callback) {
        this.mAudioRecordPath = str;
        this.mPlayCallback = callback;
        try {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.mPlayer = mediaPlayer;
            mediaPlayer.setDataSource(str);
            this.mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.tencent.qcloud.tuikit.tuichat.component.AudioPlayer.2
                @Override // android.media.MediaPlayer.OnCompletionListener
                public void onCompletion(MediaPlayer mediaPlayer2) {
                    AudioPlayer.this.stopInternalPlay();
                    AudioPlayer.this.onPlayCompleted(true);
                }
            });
            this.mPlayer.prepare();
            this.mPlayer.start();
        } catch (Exception e2) {
            TUIChatLog.w(TAG, "startPlay failed", e2);
            ToastUtil.toastLongMessage(TUIChatService.getAppContext().getString(R.string.play_error_tip));
            stopInternalPlay();
            onPlayCompleted(false);
        }
    }

    public void startRecord(Callback callback) {
        this.mRecordCallback = callback;
        try {
            this.mAudioRecordPath = CURRENT_RECORD_FILE + System.currentTimeMillis() + ".m4a";
            MediaRecorder mediaRecorder = new MediaRecorder();
            this.mRecorder = mediaRecorder;
            mediaRecorder.setAudioSource(1);
            this.mRecorder.setOutputFormat(2);
            this.mRecorder.setOutputFile(this.mAudioRecordPath);
            this.mRecorder.setAudioEncoder(3);
            this.mRecorder.prepare();
            this.mRecorder.start();
            this.mHandler.removeCallbacksAndMessages(null);
            this.mHandler.postDelayed(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.component.AudioPlayer.1
                @Override // java.lang.Runnable
                public void run() {
                    AudioPlayer.this.stopInternalRecord();
                    AudioPlayer.this.onRecordCompleted(true);
                    AudioPlayer.this.mRecordCallback = null;
                    ToastUtil.toastShortMessage(TUIChatService.getAppContext().getString(R.string.record_limit_tips));
                }
            }, TUIChatService.getChatConfig().getGeneralConfig().getAudioRecordMaxTime() * 1000);
        } catch (Exception e2) {
            TUIChatLog.w(TAG, "startRecord failed", e2);
            stopInternalRecord();
            onRecordCompleted(false);
        }
    }

    public void stopPlay() {
        stopInternalPlay();
        onPlayCompleted(false);
        this.mPlayCallback = null;
    }

    public void stopRecord() {
        stopInternalRecord();
        onRecordCompleted(true);
        this.mRecordCallback = null;
    }
}
