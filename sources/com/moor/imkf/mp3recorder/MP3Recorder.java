package com.moor.imkf.mp3recorder;

import android.media.AudioRecord;
import android.os.Message;
import android.os.Process;
import com.moor.imkf.lib.utils.MoorLogUtils;
import com.moor.imkf.mp3recorder.util.LameUtil;
import java.io.File;
import java.io.IOException;

/* loaded from: classes2.dex */
public class MP3Recorder {
    private static final PCMFormat DEFAULT_AUDIO_FORMAT = PCMFormat.PCM_16BIT;
    private static final int DEFAULT_AUDIO_SOURCE = 1;
    private static final int DEFAULT_CHANNEL_CONFIG = 16;
    private static final int DEFAULT_LAME_IN_CHANNEL = 2;
    private static final int DEFAULT_LAME_MP3_BIT_RATE = 32;
    private static final int DEFAULT_LAME_MP3_QUALITY = 7;
    private static final int DEFAULT_SAMPLING_RATE = 44100;
    private static final int FRAME_COUNT = 160;
    private static final int MAX_VOLUME = 2000;
    private int mBufferSize;
    private DataEncodeThread mEncodeThread;
    private short[] mPCMBuffer;
    private File mPCMFile;
    private File mRecordFile;
    private int mVolume;
    private AudioRecord mAudioRecord = null;
    private boolean mIsRecording = false;

    public MP3Recorder(File file) {
        this.mRecordFile = file;
    }

    private void initAudioRecorder() throws IOException {
        PCMFormat pCMFormat = DEFAULT_AUDIO_FORMAT;
        this.mBufferSize = AudioRecord.getMinBufferSize(DEFAULT_SAMPLING_RATE, 16, pCMFormat.getAudioFormat());
        pCMFormat.getBytesPerFrame();
        this.mAudioRecord = new AudioRecord(1, DEFAULT_SAMPLING_RATE, 16, pCMFormat.getAudioFormat(), this.mBufferSize);
        this.mPCMBuffer = new short[this.mBufferSize];
        LameUtil.init(DEFAULT_SAMPLING_RATE, 2, DEFAULT_SAMPLING_RATE, 32, 7);
        DataEncodeThread dataEncodeThread = new DataEncodeThread(this.mRecordFile, this.mBufferSize, this.mPCMFile);
        this.mEncodeThread = dataEncodeThread;
        dataEncodeThread.start();
        AudioRecord audioRecord = this.mAudioRecord;
        DataEncodeThread dataEncodeThread2 = this.mEncodeThread;
        audioRecord.setRecordPositionUpdateListener(dataEncodeThread2, dataEncodeThread2.getHandler());
        this.mAudioRecord.setPositionNotificationPeriod(FRAME_COUNT);
        MoorLogUtils.d("录音的采样率是：" + this.mAudioRecord.getSampleRate());
    }

    public int getMaxVolume() {
        return 2000;
    }

    public int getVolume() {
        return this.mVolume;
    }

    public AudioRecord getmAudioRecord() {
        return this.mAudioRecord;
    }

    public boolean isRecording() {
        return this.mIsRecording;
    }

    public void start() throws IOException {
        if (this.mIsRecording) {
            return;
        }
        initAudioRecorder();
        this.mAudioRecord.startRecording();
        new Thread() { // from class: com.moor.imkf.mp3recorder.MP3Recorder.1
            private void calculateRealVolume(short[] sArr, int i2) {
                long j2 = 0;
                for (short s : sArr) {
                    j2 += s * s;
                }
                MP3Recorder.this.mVolume = (int) (Math.log10(j2 / i2) * 10.0d);
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(-19);
                MP3Recorder.this.mIsRecording = true;
                while (MP3Recorder.this.mIsRecording) {
                    int read = MP3Recorder.this.mAudioRecord.read(MP3Recorder.this.mPCMBuffer, 0, MP3Recorder.this.mBufferSize);
                    if (read > 0) {
                        MP3Recorder.this.mEncodeThread.addTask(MP3Recorder.this.mPCMBuffer, read);
                        calculateRealVolume(MP3Recorder.this.mPCMBuffer, read);
                    }
                }
                MP3Recorder.this.mAudioRecord.stop();
                MP3Recorder.this.mAudioRecord.release();
                MP3Recorder.this.mAudioRecord = null;
                Message.obtain(MP3Recorder.this.mEncodeThread.getHandler(), 1).sendToTarget();
            }
        }.start();
    }

    public void stop() {
        this.mIsRecording = false;
    }

    public MP3Recorder(File file, File file2) {
        this.mRecordFile = file;
        this.mPCMFile = file2;
    }
}
