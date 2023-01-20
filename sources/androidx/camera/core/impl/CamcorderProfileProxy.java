package androidx.camera.core.impl;

import android.media.CamcorderProfile;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import e.j.b.a.c;

@c
@RequiresApi(21)
/* loaded from: classes.dex */
public abstract class CamcorderProfileProxy {
    public static int CODEC_PROFILE_NONE = -1;

    @NonNull
    public static CamcorderProfileProxy create(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13) {
        return new AutoValue_CamcorderProfileProxy(i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13);
    }

    @NonNull
    public static CamcorderProfileProxy fromCamcorderProfile(@NonNull CamcorderProfile camcorderProfile) {
        return new AutoValue_CamcorderProfileProxy(camcorderProfile.duration, camcorderProfile.quality, camcorderProfile.fileFormat, camcorderProfile.videoCodec, camcorderProfile.videoBitRate, camcorderProfile.videoFrameRate, camcorderProfile.videoFrameWidth, camcorderProfile.videoFrameHeight, camcorderProfile.audioCodec, camcorderProfile.audioBitRate, camcorderProfile.audioSampleRate, camcorderProfile.audioChannels);
    }

    public abstract int getAudioBitRate();

    public abstract int getAudioChannels();

    public abstract int getAudioCodec();

    @Nullable
    public String getAudioCodecMimeType() {
        switch (getAudioCodec()) {
            case 1:
                return "audio/3gpp";
            case 2:
                return "audio/amr-wb";
            case 3:
            case 4:
            case 5:
                return "audio/mp4a-latm";
            case 6:
                return "audio/vorbis";
            case 7:
                return "audio/opus";
            default:
                return null;
        }
    }

    public abstract int getAudioSampleRate();

    public abstract int getDuration();

    public abstract int getFileFormat();

    public abstract int getQuality();

    public int getRequiredAudioProfile() {
        int audioCodec = getAudioCodec();
        if (audioCodec != 3) {
            if (audioCodec != 4) {
                if (audioCodec != 5) {
                    return CODEC_PROFILE_NONE;
                }
                return 39;
            }
            return 5;
        }
        return 2;
    }

    public abstract int getVideoBitRate();

    public abstract int getVideoCodec();

    @Nullable
    public String getVideoCodecMimeType() {
        int videoCodec = getVideoCodec();
        if (videoCodec != 1) {
            if (videoCodec != 2) {
                if (videoCodec != 3) {
                    if (videoCodec != 4) {
                        if (videoCodec != 5) {
                            return null;
                        }
                        return "video/hevc";
                    }
                    return "video/x-vnd.on2.vp8";
                }
                return "video/mp4v-es";
            }
            return "video/avc";
        }
        return "video/3gpp";
    }

    public abstract int getVideoFrameHeight();

    public abstract int getVideoFrameRate();

    public abstract int getVideoFrameWidth();
}
