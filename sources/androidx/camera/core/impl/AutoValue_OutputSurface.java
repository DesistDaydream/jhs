package androidx.camera.core.impl;

import android.util.Size;
import android.view.Surface;
import androidx.annotation.NonNull;
import java.util.Objects;

/* loaded from: classes.dex */
public final class AutoValue_OutputSurface extends OutputSurface {
    private final int imageFormat;
    private final Size size;
    private final Surface surface;

    public AutoValue_OutputSurface(Surface surface, Size size, int i2) {
        Objects.requireNonNull(surface, "Null surface");
        this.surface = surface;
        Objects.requireNonNull(size, "Null size");
        this.size = size;
        this.imageFormat = i2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof OutputSurface) {
            OutputSurface outputSurface = (OutputSurface) obj;
            return this.surface.equals(outputSurface.getSurface()) && this.size.equals(outputSurface.getSize()) && this.imageFormat == outputSurface.getImageFormat();
        }
        return false;
    }

    @Override // androidx.camera.core.impl.OutputSurface
    public int getImageFormat() {
        return this.imageFormat;
    }

    @Override // androidx.camera.core.impl.OutputSurface
    @NonNull
    public Size getSize() {
        return this.size;
    }

    @Override // androidx.camera.core.impl.OutputSurface
    @NonNull
    public Surface getSurface() {
        return this.surface;
    }

    public int hashCode() {
        return ((((this.surface.hashCode() ^ 1000003) * 1000003) ^ this.size.hashCode()) * 1000003) ^ this.imageFormat;
    }

    public String toString() {
        return "OutputSurface{surface=" + this.surface + ", size=" + this.size + ", imageFormat=" + this.imageFormat + "}";
    }
}
