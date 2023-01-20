package androidx.camera.core;

import android.util.Rational;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class ViewPort {
    public static final int FILL_CENTER = 1;
    public static final int FILL_END = 2;
    public static final int FILL_START = 0;
    public static final int FIT = 3;
    @NonNull
    private Rational mAspectRatio;
    private int mLayoutDirection;
    private int mRotation;
    private int mScaleType;

    /* loaded from: classes.dex */
    public static final class Builder {
        private static final int DEFAULT_LAYOUT_DIRECTION = 0;
        private static final int DEFAULT_SCALE_TYPE = 1;
        private final Rational mAspectRatio;
        private final int mRotation;
        private int mScaleType = 1;
        private int mLayoutDirection = 0;

        public Builder(@NonNull Rational rational, int i2) {
            this.mAspectRatio = rational;
            this.mRotation = i2;
        }

        @NonNull
        public ViewPort build() {
            Preconditions.checkNotNull(this.mAspectRatio, "The crop aspect ratio must be set.");
            return new ViewPort(this.mScaleType, this.mAspectRatio, this.mRotation, this.mLayoutDirection);
        }

        @NonNull
        public Builder setLayoutDirection(int i2) {
            this.mLayoutDirection = i2;
            return this;
        }

        @NonNull
        public Builder setScaleType(int i2) {
            this.mScaleType = i2;
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes.dex */
    public @interface LayoutDirection {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes.dex */
    public @interface ScaleType {
    }

    public ViewPort(int i2, @NonNull Rational rational, int i3, int i4) {
        this.mScaleType = i2;
        this.mAspectRatio = rational;
        this.mRotation = i3;
        this.mLayoutDirection = i4;
    }

    @NonNull
    public Rational getAspectRatio() {
        return this.mAspectRatio;
    }

    public int getLayoutDirection() {
        return this.mLayoutDirection;
    }

    public int getRotation() {
        return this.mRotation;
    }

    public int getScaleType() {
        return this.mScaleType;
    }
}
