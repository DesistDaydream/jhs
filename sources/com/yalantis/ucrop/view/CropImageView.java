package com.yalantis.ucrop.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.AttributeSet;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.callback.BitmapCropCallback;
import com.yalantis.ucrop.callback.CropBoundsChangeListener;
import com.yalantis.ucrop.model.CropParameters;
import com.yalantis.ucrop.model.ImageState;
import com.yalantis.ucrop.task.BitmapCropTask;
import com.yalantis.ucrop.util.CubicEasing;
import com.yalantis.ucrop.util.RectUtils;
import com.yalantis.ucrop.view.TransformImageView;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* loaded from: classes3.dex */
public class CropImageView extends TransformImageView {
    public static final float DEFAULT_ASPECT_RATIO = 0.0f;
    public static final int DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION = 500;
    public static final int DEFAULT_MAX_BITMAP_SIZE = 0;
    public static final float DEFAULT_MAX_SCALE_MULTIPLIER = 10.0f;
    public static final float SOURCE_IMAGE_ASPECT_RATIO = 0.0f;
    private CropBoundsChangeListener mCropBoundsChangeListener;
    private final RectF mCropRect;
    private long mImageToWrapCropBoundsAnimDuration;
    private int mMaxResultImageSizeX;
    private int mMaxResultImageSizeY;
    private float mMaxScale;
    private float mMaxScaleMultiplier;
    private float mMinScale;
    private float mTargetAspectRatio;
    private final Matrix mTempMatrix;
    private Runnable mWrapCropBoundsRunnable;
    private Runnable mZoomImageToPositionRunnable;

    /* loaded from: classes3.dex */
    public static class WrapCropBoundsRunnable implements Runnable {
        private final float mCenterDiffX;
        private final float mCenterDiffY;
        private final WeakReference<CropImageView> mCropImageView;
        private final float mDeltaScale;
        private final long mDurationMs;
        private final float mOldScale;
        private final float mOldX;
        private final float mOldY;
        private final long mStartTime = System.currentTimeMillis();
        private final boolean mWillBeImageInBoundsAfterTranslate;

        public WrapCropBoundsRunnable(CropImageView cropImageView, long j2, float f2, float f3, float f4, float f5, float f6, float f7, boolean z) {
            this.mCropImageView = new WeakReference<>(cropImageView);
            this.mDurationMs = j2;
            this.mOldX = f2;
            this.mOldY = f3;
            this.mCenterDiffX = f4;
            this.mCenterDiffY = f5;
            this.mOldScale = f6;
            this.mDeltaScale = f7;
            this.mWillBeImageInBoundsAfterTranslate = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            CropImageView cropImageView = this.mCropImageView.get();
            if (cropImageView == null) {
                return;
            }
            float min = (float) Math.min(this.mDurationMs, System.currentTimeMillis() - this.mStartTime);
            float easeOut = CubicEasing.easeOut(min, 0.0f, this.mCenterDiffX, (float) this.mDurationMs);
            float easeOut2 = CubicEasing.easeOut(min, 0.0f, this.mCenterDiffY, (float) this.mDurationMs);
            float easeInOut = CubicEasing.easeInOut(min, 0.0f, this.mDeltaScale, (float) this.mDurationMs);
            if (min < ((float) this.mDurationMs)) {
                float[] fArr = cropImageView.mCurrentImageCenter;
                cropImageView.postTranslate(easeOut - (fArr[0] - this.mOldX), easeOut2 - (fArr[1] - this.mOldY));
                if (!this.mWillBeImageInBoundsAfterTranslate) {
                    cropImageView.zoomInImage(this.mOldScale + easeInOut, cropImageView.mCropRect.centerX(), cropImageView.mCropRect.centerY());
                }
                if (cropImageView.isImageWrapCropBounds()) {
                    return;
                }
                cropImageView.post(this);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class ZoomImageToPosition implements Runnable {
        private final WeakReference<CropImageView> mCropImageView;
        private final float mDeltaScale;
        private final float mDestX;
        private final float mDestY;
        private final long mDurationMs;
        private final float mOldScale;
        private final long mStartTime = System.currentTimeMillis();

        public ZoomImageToPosition(CropImageView cropImageView, long j2, float f2, float f3, float f4, float f5) {
            this.mCropImageView = new WeakReference<>(cropImageView);
            this.mDurationMs = j2;
            this.mOldScale = f2;
            this.mDeltaScale = f3;
            this.mDestX = f4;
            this.mDestY = f5;
        }

        @Override // java.lang.Runnable
        public void run() {
            CropImageView cropImageView = this.mCropImageView.get();
            if (cropImageView == null) {
                return;
            }
            float min = (float) Math.min(this.mDurationMs, System.currentTimeMillis() - this.mStartTime);
            float easeInOut = CubicEasing.easeInOut(min, 0.0f, this.mDeltaScale, (float) this.mDurationMs);
            if (min < ((float) this.mDurationMs)) {
                cropImageView.zoomInImage(this.mOldScale + easeInOut, this.mDestX, this.mDestY);
                cropImageView.post(this);
                return;
            }
            cropImageView.setImageToWrapCropBounds();
        }
    }

    public CropImageView(Context context) {
        this(context, null);
    }

    private float[] calculateImageIndents() {
        this.mTempMatrix.reset();
        this.mTempMatrix.setRotate(-getCurrentAngle());
        float[] fArr = this.mCurrentImageCorners;
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        float[] cornersFromRect = RectUtils.getCornersFromRect(this.mCropRect);
        this.mTempMatrix.mapPoints(copyOf);
        this.mTempMatrix.mapPoints(cornersFromRect);
        RectF trapToRect = RectUtils.trapToRect(copyOf);
        RectF trapToRect2 = RectUtils.trapToRect(cornersFromRect);
        float f2 = trapToRect.left - trapToRect2.left;
        float f3 = trapToRect.top - trapToRect2.top;
        float f4 = trapToRect.right - trapToRect2.right;
        float f5 = trapToRect.bottom - trapToRect2.bottom;
        float[] fArr2 = new float[4];
        if (f2 <= 0.0f) {
            f2 = 0.0f;
        }
        fArr2[0] = f2;
        if (f3 <= 0.0f) {
            f3 = 0.0f;
        }
        fArr2[1] = f3;
        if (f4 >= 0.0f) {
            f4 = 0.0f;
        }
        fArr2[2] = f4;
        if (f5 >= 0.0f) {
            f5 = 0.0f;
        }
        fArr2[3] = f5;
        this.mTempMatrix.reset();
        this.mTempMatrix.setRotate(getCurrentAngle());
        this.mTempMatrix.mapPoints(fArr2);
        return fArr2;
    }

    private void calculateImageScaleBounds() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        calculateImageScaleBounds(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
    }

    private void setupInitialImagePosition(float f2, float f3) {
        float width = this.mCropRect.width();
        float height = this.mCropRect.height();
        float max = Math.max(this.mCropRect.width() / f2, this.mCropRect.height() / f3);
        RectF rectF = this.mCropRect;
        float f4 = ((height - (f3 * max)) / 2.0f) + rectF.top;
        this.mCurrentImageMatrix.reset();
        this.mCurrentImageMatrix.postScale(max, max);
        this.mCurrentImageMatrix.postTranslate(((width - (f2 * max)) / 2.0f) + rectF.left, f4);
        setImageMatrix(this.mCurrentImageMatrix);
    }

    public void cancelAllAnimations() {
        removeCallbacks(this.mWrapCropBoundsRunnable);
        removeCallbacks(this.mZoomImageToPositionRunnable);
    }

    public void cropAndSaveImage(@NonNull Bitmap.CompressFormat compressFormat, int i2, @Nullable BitmapCropCallback bitmapCropCallback) {
        cancelAllAnimations();
        setImageToWrapCropBounds(false);
        new BitmapCropTask(getContext(), getViewBitmap(), new ImageState(this.mCropRect, RectUtils.trapToRect(this.mCurrentImageCorners), getCurrentScale(), getCurrentAngle()), new CropParameters(this.mMaxResultImageSizeX, this.mMaxResultImageSizeY, compressFormat, i2, getImageInputPath(), getImageOutputPath(), getExifInfo()), bitmapCropCallback).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    @Nullable
    public CropBoundsChangeListener getCropBoundsChangeListener() {
        return this.mCropBoundsChangeListener;
    }

    public float getMaxScale() {
        return this.mMaxScale;
    }

    public float getMinScale() {
        return this.mMinScale;
    }

    public float getTargetAspectRatio() {
        return this.mTargetAspectRatio;
    }

    public boolean isImageWrapCropBounds() {
        return isImageWrapCropBounds(this.mCurrentImageCorners);
    }

    @Override // com.yalantis.ucrop.view.TransformImageView
    public void onImageLaidOut() {
        int i2;
        int i3;
        int i4;
        super.onImageLaidOut();
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        float intrinsicWidth = drawable.getIntrinsicWidth();
        float intrinsicHeight = drawable.getIntrinsicHeight();
        if (this.mTargetAspectRatio == 0.0f) {
            this.mTargetAspectRatio = intrinsicWidth / intrinsicHeight;
        }
        int i5 = this.mThisWidth;
        float f2 = this.mTargetAspectRatio;
        int i6 = (int) (i5 / f2);
        int i7 = this.mThisHeight;
        if (i6 > i7) {
            this.mCropRect.set((i5 - ((int) (i7 * f2))) / 2, 0.0f, i3 + i4, i7);
        } else {
            this.mCropRect.set(0.0f, (i7 - i6) / 2, i5, i6 + i2);
        }
        calculateImageScaleBounds(intrinsicWidth, intrinsicHeight);
        setupInitialImagePosition(intrinsicWidth, intrinsicHeight);
        CropBoundsChangeListener cropBoundsChangeListener = this.mCropBoundsChangeListener;
        if (cropBoundsChangeListener != null) {
            cropBoundsChangeListener.onCropAspectRatioChanged(this.mTargetAspectRatio);
        }
        TransformImageView.TransformImageListener transformImageListener = this.mTransformImageListener;
        if (transformImageListener != null) {
            transformImageListener.onScale(getCurrentScale());
            this.mTransformImageListener.onRotate(getCurrentAngle());
        }
    }

    public void postRotate(float f2) {
        postRotate(f2, this.mCropRect.centerX(), this.mCropRect.centerY());
    }

    @Override // com.yalantis.ucrop.view.TransformImageView
    public void postScale(float f2, float f3, float f4) {
        if (f2 > 1.0f && getCurrentScale() * f2 <= getMaxScale()) {
            super.postScale(f2, f3, f4);
        } else if (f2 >= 1.0f || getCurrentScale() * f2 < getMinScale()) {
        } else {
            super.postScale(f2, f3, f4);
        }
    }

    public void processStyledAttributes(@NonNull TypedArray typedArray) {
        float abs = Math.abs(typedArray.getFloat(R.styleable.ucrop_UCropView_ucrop_aspect_ratio_x, 0.0f));
        float abs2 = Math.abs(typedArray.getFloat(R.styleable.ucrop_UCropView_ucrop_aspect_ratio_y, 0.0f));
        if (abs != 0.0f && abs2 != 0.0f) {
            this.mTargetAspectRatio = abs / abs2;
        } else {
            this.mTargetAspectRatio = 0.0f;
        }
    }

    public void setCropBoundsChangeListener(@Nullable CropBoundsChangeListener cropBoundsChangeListener) {
        this.mCropBoundsChangeListener = cropBoundsChangeListener;
    }

    public void setCropRect(RectF rectF) {
        this.mTargetAspectRatio = rectF.width() / rectF.height();
        this.mCropRect.set(rectF.left - getPaddingLeft(), rectF.top - getPaddingTop(), rectF.right - getPaddingRight(), rectF.bottom - getPaddingBottom());
        calculateImageScaleBounds();
        setImageToWrapCropBounds();
    }

    public void setImageToWrapCropBounds() {
        setImageToWrapCropBounds(true);
    }

    public void setImageToWrapCropBoundsAnimDuration(@IntRange(from = 100) long j2) {
        if (j2 > 0) {
            this.mImageToWrapCropBoundsAnimDuration = j2;
            return;
        }
        throw new IllegalArgumentException("Animation duration cannot be negative value.");
    }

    public void setMaxResultImageSizeX(@IntRange(from = 10) int i2) {
        this.mMaxResultImageSizeX = i2;
    }

    public void setMaxResultImageSizeY(@IntRange(from = 10) int i2) {
        this.mMaxResultImageSizeY = i2;
    }

    public void setMaxScaleMultiplier(float f2) {
        this.mMaxScaleMultiplier = f2;
    }

    public void setTargetAspectRatio(float f2) {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            this.mTargetAspectRatio = f2;
            return;
        }
        if (f2 == 0.0f) {
            this.mTargetAspectRatio = drawable.getIntrinsicWidth() / drawable.getIntrinsicHeight();
        } else {
            this.mTargetAspectRatio = f2;
        }
        CropBoundsChangeListener cropBoundsChangeListener = this.mCropBoundsChangeListener;
        if (cropBoundsChangeListener != null) {
            cropBoundsChangeListener.onCropAspectRatioChanged(this.mTargetAspectRatio);
        }
    }

    public void zoomImageToPosition(float f2, float f3, float f4, long j2) {
        if (f2 > getMaxScale()) {
            f2 = getMaxScale();
        }
        float currentScale = getCurrentScale();
        ZoomImageToPosition zoomImageToPosition = new ZoomImageToPosition(this, j2, currentScale, f2 - currentScale, f3, f4);
        this.mZoomImageToPositionRunnable = zoomImageToPosition;
        post(zoomImageToPosition);
    }

    public void zoomInImage(float f2) {
        zoomInImage(f2, this.mCropRect.centerX(), this.mCropRect.centerY());
    }

    public void zoomOutImage(float f2) {
        zoomOutImage(f2, this.mCropRect.centerX(), this.mCropRect.centerY());
    }

    public CropImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public boolean isImageWrapCropBounds(float[] fArr) {
        this.mTempMatrix.reset();
        this.mTempMatrix.setRotate(-getCurrentAngle());
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        this.mTempMatrix.mapPoints(copyOf);
        float[] cornersFromRect = RectUtils.getCornersFromRect(this.mCropRect);
        this.mTempMatrix.mapPoints(cornersFromRect);
        return RectUtils.trapToRect(copyOf).contains(RectUtils.trapToRect(cornersFromRect));
    }

    public void setImageToWrapCropBounds(boolean z) {
        float f2;
        float max;
        float f3;
        if (!this.mBitmapLaidOut || isImageWrapCropBounds()) {
            return;
        }
        float[] fArr = this.mCurrentImageCenter;
        float f4 = fArr[0];
        float f5 = fArr[1];
        float currentScale = getCurrentScale();
        float centerX = this.mCropRect.centerX() - f4;
        float centerY = this.mCropRect.centerY() - f5;
        this.mTempMatrix.reset();
        this.mTempMatrix.setTranslate(centerX, centerY);
        float[] fArr2 = this.mCurrentImageCorners;
        float[] copyOf = Arrays.copyOf(fArr2, fArr2.length);
        this.mTempMatrix.mapPoints(copyOf);
        boolean isImageWrapCropBounds = isImageWrapCropBounds(copyOf);
        if (isImageWrapCropBounds) {
            float[] calculateImageIndents = calculateImageIndents();
            f3 = -(calculateImageIndents[1] + calculateImageIndents[3]);
            f2 = -(calculateImageIndents[0] + calculateImageIndents[2]);
            max = 0.0f;
        } else {
            RectF rectF = new RectF(this.mCropRect);
            this.mTempMatrix.reset();
            this.mTempMatrix.setRotate(getCurrentAngle());
            this.mTempMatrix.mapRect(rectF);
            float[] rectSidesFromCorners = RectUtils.getRectSidesFromCorners(this.mCurrentImageCorners);
            f2 = centerX;
            max = (Math.max(rectF.width() / rectSidesFromCorners[0], rectF.height() / rectSidesFromCorners[1]) * currentScale) - currentScale;
            f3 = centerY;
        }
        if (z) {
            WrapCropBoundsRunnable wrapCropBoundsRunnable = new WrapCropBoundsRunnable(this, this.mImageToWrapCropBoundsAnimDuration, f4, f5, f2, f3, currentScale, max, isImageWrapCropBounds);
            this.mWrapCropBoundsRunnable = wrapCropBoundsRunnable;
            post(wrapCropBoundsRunnable);
            return;
        }
        postTranslate(f2, f3);
        if (isImageWrapCropBounds) {
            return;
        }
        zoomInImage(currentScale + max, this.mCropRect.centerX(), this.mCropRect.centerY());
    }

    public void zoomInImage(float f2, float f3, float f4) {
        if (f2 <= getMaxScale()) {
            postScale(f2 / getCurrentScale(), f3, f4);
        }
    }

    public void zoomOutImage(float f2, float f3, float f4) {
        if (f2 >= getMinScale()) {
            postScale(f2 / getCurrentScale(), f3, f4);
        }
    }

    public CropImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mCropRect = new RectF();
        this.mTempMatrix = new Matrix();
        this.mMaxScaleMultiplier = 10.0f;
        this.mZoomImageToPositionRunnable = null;
        this.mMaxResultImageSizeX = 0;
        this.mMaxResultImageSizeY = 0;
        this.mImageToWrapCropBoundsAnimDuration = 500L;
    }

    private void calculateImageScaleBounds(float f2, float f3) {
        float min = Math.min(Math.min(this.mCropRect.width() / f2, this.mCropRect.width() / f3), Math.min(this.mCropRect.height() / f3, this.mCropRect.height() / f2));
        this.mMinScale = min;
        this.mMaxScale = min * this.mMaxScaleMultiplier;
    }
}
