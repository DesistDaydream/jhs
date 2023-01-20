package androidx.camera.core;

import androidx.camera.core.ImageReaderFormatRecommender;

/* loaded from: classes.dex */
public final class AutoValue_ImageReaderFormatRecommender_FormatCombo extends ImageReaderFormatRecommender.FormatCombo {
    private final int imageAnalysisFormat;
    private final int imageCaptureFormat;

    public AutoValue_ImageReaderFormatRecommender_FormatCombo(int i2, int i3) {
        this.imageCaptureFormat = i2;
        this.imageAnalysisFormat = i3;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ImageReaderFormatRecommender.FormatCombo) {
            ImageReaderFormatRecommender.FormatCombo formatCombo = (ImageReaderFormatRecommender.FormatCombo) obj;
            return this.imageCaptureFormat == formatCombo.imageCaptureFormat() && this.imageAnalysisFormat == formatCombo.imageAnalysisFormat();
        }
        return false;
    }

    public int hashCode() {
        return ((this.imageCaptureFormat ^ 1000003) * 1000003) ^ this.imageAnalysisFormat;
    }

    @Override // androidx.camera.core.ImageReaderFormatRecommender.FormatCombo
    public int imageAnalysisFormat() {
        return this.imageAnalysisFormat;
    }

    @Override // androidx.camera.core.ImageReaderFormatRecommender.FormatCombo
    public int imageCaptureFormat() {
        return this.imageCaptureFormat;
    }

    public String toString() {
        return "FormatCombo{imageCaptureFormat=" + this.imageCaptureFormat + ", imageAnalysisFormat=" + this.imageAnalysisFormat + "}";
    }
}
