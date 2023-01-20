package com.m7.imkfsdk.recordbutton;

import com.moor.imkf.mp3recorder.MP3Recorder;
import java.io.File;
import java.util.UUID;

/* loaded from: classes2.dex */
public class AudioManager {
    private static AudioManager instance;
    private boolean isPrepared;
    private AudioStateListener listener;
    private String mCurrentFilePath;
    private String mDir;
    private String mPCMFilePath;
    public MP3Recorder mp3Recorder;

    /* loaded from: classes2.dex */
    public interface AudioStateListener {
        void wellPrepared();
    }

    private AudioManager() {
    }

    private String generateFileName() {
        return UUID.randomUUID().toString() + ".mp3";
    }

    private String generatePCMFileName() {
        return UUID.randomUUID().toString() + ".pcm";
    }

    public static AudioManager getInstance(String str) {
        if (instance == null) {
            synchronized (AudioManager.class) {
                instance = new AudioManager(str);
            }
        }
        return instance;
    }

    public void cancel() {
        release();
        if (this.mCurrentFilePath != null) {
            new File(this.mCurrentFilePath).delete();
            this.mCurrentFilePath = null;
        }
        if (this.mPCMFilePath != null) {
            new File(this.mPCMFilePath).delete();
            this.mPCMFilePath = null;
        }
    }

    public String getCurrentFilePath() {
        return this.mCurrentFilePath;
    }

    public MP3Recorder getMp3Recorder() {
        return this.mp3Recorder;
    }

    public String getPCMFilePath() {
        return this.mPCMFilePath;
    }

    public int getVoiceLevel(int i2) {
        MP3Recorder mP3Recorder;
        if (!this.isPrepared || (mP3Recorder = this.mp3Recorder) == null) {
            return 1;
        }
        int volume = (((i2 * mP3Recorder.getVolume()) * this.mp3Recorder.getVolume()) / 5000) + 1;
        if (volume > 7) {
            return 7;
        }
        return volume;
    }

    public void prepareAudio() {
        try {
            this.isPrepared = false;
            File file = new File(this.mDir);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, generateFileName());
            this.mCurrentFilePath = file2.getAbsolutePath();
            File file3 = new File(file, generatePCMFileName());
            this.mPCMFilePath = file3.getAbsolutePath();
            MP3Recorder mP3Recorder = new MP3Recorder(file2, file3);
            this.mp3Recorder = mP3Recorder;
            mP3Recorder.start();
            AudioStateListener audioStateListener = this.listener;
            if (audioStateListener != null) {
                audioStateListener.wellPrepared();
            }
            this.isPrepared = true;
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public void release() {
        MP3Recorder mP3Recorder = this.mp3Recorder;
        if (mP3Recorder != null) {
            mP3Recorder.stop();
            this.mp3Recorder = null;
        }
    }

    public void setAudioStateListener(AudioStateListener audioStateListener) {
        this.listener = audioStateListener;
    }

    private AudioManager(String str) {
        this.mDir = str;
    }
}
