package androidx.camera.core.impl;

import android.util.Range;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Objects;

/* loaded from: classes.dex */
public final class AutoValue_AttachedSurfaceInfo extends AttachedSurfaceInfo {
    private final int imageFormat;
    private final Size size;
    private final SurfaceConfig surfaceConfig;
    private final Range<Integer> targetFrameRate;

    public AutoValue_AttachedSurfaceInfo(SurfaceConfig surfaceConfig, int i2, Size size, @Nullable Range<Integer> range) {
        Objects.requireNonNull(surfaceConfig, "Null surfaceConfig");
        this.surfaceConfig = surfaceConfig;
        this.imageFormat = i2;
        Objects.requireNonNull(size, "Null size");
        this.size = size;
        this.targetFrameRate = range;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AttachedSurfaceInfo) {
            AttachedSurfaceInfo attachedSurfaceInfo = (AttachedSurfaceInfo) obj;
            if (this.surfaceConfig.equals(attachedSurfaceInfo.getSurfaceConfig()) && this.imageFormat == attachedSurfaceInfo.getImageFormat() && this.size.equals(attachedSurfaceInfo.getSize())) {
                Range<Integer> range = this.targetFrameRate;
                if (range == null) {
                    if (attachedSurfaceInfo.getTargetFrameRate() == null) {
                        return true;
                    }
                } else if (range.equals(attachedSurfaceInfo.getTargetFrameRate())) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    @Override // androidx.camera.core.impl.AttachedSurfaceInfo
    public int getImageFormat() {
        return this.imageFormat;
    }

    @Override // androidx.camera.core.impl.AttachedSurfaceInfo
    @NonNull
    public Size getSize() {
        return this.size;
    }

    @Override // androidx.camera.core.impl.AttachedSurfaceInfo
    @NonNull
    public SurfaceConfig getSurfaceConfig() {
        return this.surfaceConfig;
    }

    @Override // androidx.camera.core.impl.AttachedSurfaceInfo
    @Nullable
    public Range<Integer> getTargetFrameRate() {
        return this.targetFrameRate;
    }

    public int hashCode() {
        int hashCode = (((((this.surfaceConfig.hashCode() ^ 1000003) * 1000003) ^ this.imageFormat) * 1000003) ^ this.size.hashCode()) * 1000003;
        Range<Integer> range = this.targetFrameRate;
        return hashCode ^ (range == null ? 0 : range.hashCode());
    }

    public String toString() {
        return "AttachedSurfaceInfo{surfaceConfig=" + this.surfaceConfig + ", imageFormat=" + this.imageFormat + ", size=" + this.size + ", targetFrameRate=" + this.targetFrameRate + "}";
    }
}
