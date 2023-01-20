package androidx.camera.core.impl;

/* loaded from: classes.dex */
public final class AutoValue_CamcorderProfileProxy extends CamcorderProfileProxy {
    private final int audioBitRate;
    private final int audioChannels;
    private final int audioCodec;
    private final int audioSampleRate;
    private final int duration;
    private final int fileFormat;
    private final int quality;
    private final int videoBitRate;
    private final int videoCodec;
    private final int videoFrameHeight;
    private final int videoFrameRate;
    private final int videoFrameWidth;

    public AutoValue_CamcorderProfileProxy(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13) {
        this.duration = i2;
        this.quality = i3;
        this.fileFormat = i4;
        this.videoCodec = i5;
        this.videoBitRate = i6;
        this.videoFrameRate = i7;
        this.videoFrameWidth = i8;
        this.videoFrameHeight = i9;
        this.audioCodec = i10;
        this.audioBitRate = i11;
        this.audioSampleRate = i12;
        this.audioChannels = i13;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CamcorderProfileProxy) {
            CamcorderProfileProxy camcorderProfileProxy = (CamcorderProfileProxy) obj;
            return this.duration == camcorderProfileProxy.getDuration() && this.quality == camcorderProfileProxy.getQuality() && this.fileFormat == camcorderProfileProxy.getFileFormat() && this.videoCodec == camcorderProfileProxy.getVideoCodec() && this.videoBitRate == camcorderProfileProxy.getVideoBitRate() && this.videoFrameRate == camcorderProfileProxy.getVideoFrameRate() && this.videoFrameWidth == camcorderProfileProxy.getVideoFrameWidth() && this.videoFrameHeight == camcorderProfileProxy.getVideoFrameHeight() && this.audioCodec == camcorderProfileProxy.getAudioCodec() && this.audioBitRate == camcorderProfileProxy.getAudioBitRate() && this.audioSampleRate == camcorderProfileProxy.getAudioSampleRate() && this.audioChannels == camcorderProfileProxy.getAudioChannels();
        }
        return false;
    }

    @Override // androidx.camera.core.impl.CamcorderProfileProxy
    public int getAudioBitRate() {
        return this.audioBitRate;
    }

    @Override // androidx.camera.core.impl.CamcorderProfileProxy
    public int getAudioChannels() {
        return this.audioChannels;
    }

    @Override // androidx.camera.core.impl.CamcorderProfileProxy
    public int getAudioCodec() {
        return this.audioCodec;
    }

    @Override // androidx.camera.core.impl.CamcorderProfileProxy
    public int getAudioSampleRate() {
        return this.audioSampleRate;
    }

    @Override // androidx.camera.core.impl.CamcorderProfileProxy
    public int getDuration() {
        return this.duration;
    }

    @Override // androidx.camera.core.impl.CamcorderProfileProxy
    public int getFileFormat() {
        return this.fileFormat;
    }

    @Override // androidx.camera.core.impl.CamcorderProfileProxy
    public int getQuality() {
        return this.quality;
    }

    @Override // androidx.camera.core.impl.CamcorderProfileProxy
    public int getVideoBitRate() {
        return this.videoBitRate;
    }

    @Override // androidx.camera.core.impl.CamcorderProfileProxy
    public int getVideoCodec() {
        return this.videoCodec;
    }

    @Override // androidx.camera.core.impl.CamcorderProfileProxy
    public int getVideoFrameHeight() {
        return this.videoFrameHeight;
    }

    @Override // androidx.camera.core.impl.CamcorderProfileProxy
    public int getVideoFrameRate() {
        return this.videoFrameRate;
    }

    @Override // androidx.camera.core.impl.CamcorderProfileProxy
    public int getVideoFrameWidth() {
        return this.videoFrameWidth;
    }

    public int hashCode() {
        return ((((((((((((((((((((((this.duration ^ 1000003) * 1000003) ^ this.quality) * 1000003) ^ this.fileFormat) * 1000003) ^ this.videoCodec) * 1000003) ^ this.videoBitRate) * 1000003) ^ this.videoFrameRate) * 1000003) ^ this.videoFrameWidth) * 1000003) ^ this.videoFrameHeight) * 1000003) ^ this.audioCodec) * 1000003) ^ this.audioBitRate) * 1000003) ^ this.audioSampleRate) * 1000003) ^ this.audioChannels;
    }

    public String toString() {
        return "CamcorderProfileProxy{duration=" + this.duration + ", quality=" + this.quality + ", fileFormat=" + this.fileFormat + ", videoCodec=" + this.videoCodec + ", videoBitRate=" + this.videoBitRate + ", videoFrameRate=" + this.videoFrameRate + ", videoFrameWidth=" + this.videoFrameWidth + ", videoFrameHeight=" + this.videoFrameHeight + ", audioCodec=" + this.audioCodec + ", audioBitRate=" + this.audioBitRate + ", audioSampleRate=" + this.audioSampleRate + ", audioChannels=" + this.audioChannels + "}";
    }
}
