package com.yalantis.ucrop.model;

/* loaded from: classes3.dex */
public class ExifInfo {
    private int mExifDegrees;
    private int mExifOrientation;
    private int mExifTranslation;

    public ExifInfo(int i2, int i3, int i4) {
        this.mExifOrientation = i2;
        this.mExifDegrees = i3;
        this.mExifTranslation = i4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ExifInfo exifInfo = (ExifInfo) obj;
        return this.mExifOrientation == exifInfo.mExifOrientation && this.mExifDegrees == exifInfo.mExifDegrees && this.mExifTranslation == exifInfo.mExifTranslation;
    }

    public int getExifDegrees() {
        return this.mExifDegrees;
    }

    public int getExifOrientation() {
        return this.mExifOrientation;
    }

    public int getExifTranslation() {
        return this.mExifTranslation;
    }

    public int hashCode() {
        return (((this.mExifOrientation * 31) + this.mExifDegrees) * 31) + this.mExifTranslation;
    }

    public void setExifDegrees(int i2) {
        this.mExifDegrees = i2;
    }

    public void setExifOrientation(int i2) {
        this.mExifOrientation = i2;
    }

    public void setExifTranslation(int i2) {
        this.mExifTranslation = i2;
    }
}
