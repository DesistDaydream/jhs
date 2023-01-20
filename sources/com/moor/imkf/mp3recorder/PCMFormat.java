package com.moor.imkf.mp3recorder;

/* loaded from: classes2.dex */
public enum PCMFormat {
    PCM_8BIT(1, 3),
    PCM_16BIT(2, 2);
    
    private int audioFormat;
    private int bytesPerFrame;

    PCMFormat(int i2, int i3) {
        this.bytesPerFrame = i2;
        this.audioFormat = i3;
    }

    public int getAudioFormat() {
        return this.audioFormat;
    }

    public int getBytesPerFrame() {
        return this.bytesPerFrame;
    }
}
