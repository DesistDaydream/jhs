package com.yalantis.ucrop.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.callback.OverlayViewChangeListener;
import com.yalantis.ucrop.util.RectUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes3.dex */
public class OverlayView extends View {
    public static final boolean DEFAULT_CIRCLE_DIMMED_LAYER = false;
    public static final int DEFAULT_CROP_GRID_COLUMN_COUNT = 2;
    public static final int DEFAULT_CROP_GRID_ROW_COUNT = 2;
    public static final int DEFAULT_FREESTYLE_CROP_MODE = 0;
    public static final boolean DEFAULT_SHOW_CROP_FRAME = true;
    public static final boolean DEFAULT_SHOW_CROP_GRID = true;
    public static final int FREESTYLE_CROP_MODE_DISABLE = 0;
    public static final int FREESTYLE_CROP_MODE_ENABLE = 1;
    public static final int FREESTYLE_CROP_MODE_ENABLE_WITH_PASS_THROUGH = 2;
    private OverlayViewChangeListener mCallback;
    private boolean mCircleDimmedLayer;
    private Path mCircularPath;
    private Paint mCropFrameCornersPaint;
    private Paint mCropFramePaint;
    public float[] mCropGridCenter;
    private int mCropGridColumnCount;
    public float[] mCropGridCorners;
    private Paint mCropGridPaint;
    private int mCropGridRowCount;
    private int mCropRectCornerTouchAreaLineLength;
    private int mCropRectMinSize;
    private final RectF mCropViewRect;
    private int mCurrentTouchCornerIndex;
    private int mDimmedColor;
    private Paint mDimmedStrokePaint;
    private int mFreestyleCropMode;
    private float[] mGridPoints;
    private float mPreviousTouchX;
    private float mPreviousTouchY;
    private boolean mShouldSetupCropBounds;
    private boolean mShowCropFrame;
    private boolean mShowCropGrid;
    private float mTargetAspectRatio;
    private final RectF mTempRect;
    public int mThisHeight;
    public int mThisWidth;
    private int mTouchPointThreshold;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface FreestyleMode {
    }

    public OverlayView(Context context) {
        this(context, null);
    }

    private int getCurrentTouchIndex(float f2, float f3) {
        double d2 = this.mTouchPointThreshold;
        int i2 = -1;
        for (int i3 = 0; i3 < 8; i3 += 2) {
            double sqrt = Math.sqrt(Math.pow(f2 - this.mCropGridCorners[i3], 2.0d) + Math.pow(f3 - this.mCropGridCorners[i3 + 1], 2.0d));
            if (sqrt < d2) {
                i2 = i3 / 2;
                d2 = sqrt;
            }
        }
        if (this.mFreestyleCropMode == 1 && i2 < 0 && this.mCropViewRect.contains(f2, f3)) {
            return 4;
        }
        return i2;
    }

    private void initCropFrameStyle(@NonNull TypedArray typedArray) {
        int dimensionPixelSize = typedArray.getDimensionPixelSize(R.styleable.ucrop_UCropView_ucrop_frame_stroke_size, getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_frame_stoke_width));
        int color = typedArray.getColor(R.styleable.ucrop_UCropView_ucrop_frame_color, getResources().getColor(R.color.ucrop_color_default_crop_frame));
        this.mCropFramePaint.setStrokeWidth(dimensionPixelSize);
        this.mCropFramePaint.setColor(color);
        this.mCropFramePaint.setStyle(Paint.Style.STROKE);
        this.mCropFrameCornersPaint.setStrokeWidth(dimensionPixelSize * 3);
        this.mCropFrameCornersPaint.setColor(color);
        this.mCropFrameCornersPaint.setStyle(Paint.Style.STROKE);
    }

    private void initCropGridStyle(@NonNull TypedArray typedArray) {
        int dimensionPixelSize = typedArray.getDimensionPixelSize(R.styleable.ucrop_UCropView_ucrop_grid_stroke_size, getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_grid_stoke_width));
        int color = typedArray.getColor(R.styleable.ucrop_UCropView_ucrop_grid_color, getResources().getColor(R.color.ucrop_color_default_crop_grid));
        this.mCropGridPaint.setStrokeWidth(dimensionPixelSize);
        this.mCropGridPaint.setColor(color);
        this.mCropGridRowCount = typedArray.getInt(R.styleable.ucrop_UCropView_ucrop_grid_row_count, 2);
        this.mCropGridColumnCount = typedArray.getInt(R.styleable.ucrop_UCropView_ucrop_grid_column_count, 2);
    }

    private void updateCropViewRect(float f2, float f3) {
        this.mTempRect.set(this.mCropViewRect);
        int i2 = this.mCurrentTouchCornerIndex;
        if (i2 == 0) {
            RectF rectF = this.mTempRect;
            RectF rectF2 = this.mCropViewRect;
            rectF.set(f2, f3, rectF2.right, rectF2.bottom);
        } else if (i2 == 1) {
            RectF rectF3 = this.mTempRect;
            RectF rectF4 = this.mCropViewRect;
            rectF3.set(rectF4.left, f3, f2, rectF4.bottom);
        } else if (i2 == 2) {
            RectF rectF5 = this.mTempRect;
            RectF rectF6 = this.mCropViewRect;
            rectF5.set(rectF6.left, rectF6.top, f2, f3);
        } else if (i2 == 3) {
            RectF rectF7 = this.mTempRect;
            RectF rectF8 = this.mCropViewRect;
            rectF7.set(f2, rectF8.top, rectF8.right, f3);
        } else if (i2 == 4) {
            this.mTempRect.offset(f2 - this.mPreviousTouchX, f3 - this.mPreviousTouchY);
            if (this.mTempRect.left <= getLeft() || this.mTempRect.top <= getTop() || this.mTempRect.right >= getRight() || this.mTempRect.bottom >= getBottom()) {
                return;
            }
            this.mCropViewRect.set(this.mTempRect);
            updateGridPoints();
            postInvalidate();
            return;
        }
        boolean z = this.mTempRect.height() >= ((float) this.mCropRectMinSize);
        boolean z2 = this.mTempRect.width() >= ((float) this.mCropRectMinSize);
        RectF rectF9 = this.mCropViewRect;
        rectF9.set(z2 ? this.mTempRect.left : rectF9.left, z ? this.mTempRect.top : rectF9.top, z2 ? this.mTempRect.right : rectF9.right, z ? this.mTempRect.bottom : rectF9.bottom);
        if (z || z2) {
            updateGridPoints();
            postInvalidate();
        }
    }

    private void updateGridPoints() {
        this.mCropGridCorners = RectUtils.getCornersFromRect(this.mCropViewRect);
        this.mCropGridCenter = RectUtils.getCenterFromRect(this.mCropViewRect);
        this.mGridPoints = null;
        this.mCircularPath.reset();
        this.mCircularPath.addCircle(this.mCropViewRect.centerX(), this.mCropViewRect.centerY(), Math.min(this.mCropViewRect.width(), this.mCropViewRect.height()) / 2.0f, Path.Direction.CW);
    }

    public void drawCropGrid(@NonNull Canvas canvas) {
        if (this.mShowCropGrid) {
            if (this.mGridPoints == null && !this.mCropViewRect.isEmpty()) {
                this.mGridPoints = new float[(this.mCropGridRowCount * 4) + (this.mCropGridColumnCount * 4)];
                int i2 = 0;
                for (int i3 = 0; i3 < this.mCropGridRowCount; i3++) {
                    float[] fArr = this.mGridPoints;
                    int i4 = i2 + 1;
                    RectF rectF = this.mCropViewRect;
                    fArr[i2] = rectF.left;
                    int i5 = i4 + 1;
                    float f2 = i3 + 1.0f;
                    float height = rectF.height() * (f2 / (this.mCropGridRowCount + 1));
                    RectF rectF2 = this.mCropViewRect;
                    fArr[i4] = height + rectF2.top;
                    float[] fArr2 = this.mGridPoints;
                    int i6 = i5 + 1;
                    fArr2[i5] = rectF2.right;
                    i2 = i6 + 1;
                    fArr2[i6] = (rectF2.height() * (f2 / (this.mCropGridRowCount + 1))) + this.mCropViewRect.top;
                }
                for (int i7 = 0; i7 < this.mCropGridColumnCount; i7++) {
                    float[] fArr3 = this.mGridPoints;
                    int i8 = i2 + 1;
                    float f3 = i7 + 1.0f;
                    float width = this.mCropViewRect.width() * (f3 / (this.mCropGridColumnCount + 1));
                    RectF rectF3 = this.mCropViewRect;
                    fArr3[i2] = width + rectF3.left;
                    float[] fArr4 = this.mGridPoints;
                    int i9 = i8 + 1;
                    fArr4[i8] = rectF3.top;
                    int i10 = i9 + 1;
                    float width2 = rectF3.width() * (f3 / (this.mCropGridColumnCount + 1));
                    RectF rectF4 = this.mCropViewRect;
                    fArr4[i9] = width2 + rectF4.left;
                    i2 = i10 + 1;
                    this.mGridPoints[i10] = rectF4.bottom;
                }
            }
            float[] fArr5 = this.mGridPoints;
            if (fArr5 != null) {
                canvas.drawLines(fArr5, this.mCropGridPaint);
            }
        }
        if (this.mShowCropFrame) {
            canvas.drawRect(this.mCropViewRect, this.mCropFramePaint);
        }
        if (this.mFreestyleCropMode != 0) {
            canvas.save();
            this.mTempRect.set(this.mCropViewRect);
            RectF rectF5 = this.mTempRect;
            int i11 = this.mCropRectCornerTouchAreaLineLength;
            rectF5.inset(i11, -i11);
            canvas.clipRect(this.mTempRect, Region.Op.DIFFERENCE);
            this.mTempRect.set(this.mCropViewRect);
            RectF rectF6 = this.mTempRect;
            int i12 = this.mCropRectCornerTouchAreaLineLength;
            rectF6.inset(-i12, i12);
            canvas.clipRect(this.mTempRect, Region.Op.DIFFERENCE);
            canvas.drawRect(this.mCropViewRect, this.mCropFrameCornersPaint);
            canvas.restore();
        }
    }

    public void drawDimmedLayer(@NonNull Canvas canvas) {
        canvas.save();
        if (this.mCircleDimmedLayer) {
            canvas.clipPath(this.mCircularPath, Region.Op.DIFFERENCE);
        } else {
            canvas.clipRect(this.mCropViewRect, Region.Op.DIFFERENCE);
        }
        canvas.drawColor(this.mDimmedColor);
        canvas.restore();
        if (this.mCircleDimmedLayer) {
            canvas.drawCircle(this.mCropViewRect.centerX(), this.mCropViewRect.centerY(), Math.min(this.mCropViewRect.width(), this.mCropViewRect.height()) / 2.0f, this.mDimmedStrokePaint);
        }
    }

    @NonNull
    public RectF getCropViewRect() {
        return this.mCropViewRect;
    }

    public int getFreestyleCropMode() {
        return this.mFreestyleCropMode;
    }

    public OverlayViewChangeListener getOverlayViewChangeListener() {
        return this.mCallback;
    }

    public void init() {
        if (Build.VERSION.SDK_INT < 18) {
            setLayerType(1, null);
        }
    }

    @Deprecated
    public boolean isFreestyleCropEnabled() {
        return this.mFreestyleCropMode == 1;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawDimmedLayer(canvas);
        drawCropGrid(canvas);
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (z) {
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            this.mThisWidth = (getWidth() - getPaddingRight()) - paddingLeft;
            this.mThisHeight = (getHeight() - getPaddingBottom()) - paddingTop;
            if (this.mShouldSetupCropBounds) {
                this.mShouldSetupCropBounds = false;
                setTargetAspectRatio(this.mTargetAspectRatio);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mCropViewRect.isEmpty() && this.mFreestyleCropMode != 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if ((motionEvent.getAction() & 255) == 0) {
                int currentTouchIndex = getCurrentTouchIndex(x, y);
                this.mCurrentTouchCornerIndex = currentTouchIndex;
                boolean z = currentTouchIndex != -1;
                if (!z) {
                    this.mPreviousTouchX = -1.0f;
                    this.mPreviousTouchY = -1.0f;
                } else if (this.mPreviousTouchX < 0.0f) {
                    this.mPreviousTouchX = x;
                    this.mPreviousTouchY = y;
                }
                return z;
            } else if ((motionEvent.getAction() & 255) == 2 && motionEvent.getPointerCount() == 1 && this.mCurrentTouchCornerIndex != -1) {
                float min = Math.min(Math.max(x, getPaddingLeft()), getWidth() - getPaddingRight());
                float min2 = Math.min(Math.max(y, getPaddingTop()), getHeight() - getPaddingBottom());
                updateCropViewRect(min, min2);
                this.mPreviousTouchX = min;
                this.mPreviousTouchY = min2;
                return true;
            } else if ((motionEvent.getAction() & 255) == 1) {
                this.mPreviousTouchX = -1.0f;
                this.mPreviousTouchY = -1.0f;
                this.mCurrentTouchCornerIndex = -1;
                OverlayViewChangeListener overlayViewChangeListener = this.mCallback;
                if (overlayViewChangeListener != null) {
                    overlayViewChangeListener.onCropRectUpdated(this.mCropViewRect);
                }
            }
        }
        return false;
    }

    public void processStyledAttributes(@NonNull TypedArray typedArray) {
        this.mCircleDimmedLayer = typedArray.getBoolean(R.styleable.ucrop_UCropView_ucrop_circle_dimmed_layer, false);
        int color = typedArray.getColor(R.styleable.ucrop_UCropView_ucrop_dimmed_color, getResources().getColor(R.color.ucrop_color_default_dimmed));
        this.mDimmedColor = color;
        this.mDimmedStrokePaint.setColor(color);
        this.mDimmedStrokePaint.setStyle(Paint.Style.STROKE);
        this.mDimmedStrokePaint.setStrokeWidth(1.0f);
        initCropFrameStyle(typedArray);
        this.mShowCropFrame = typedArray.getBoolean(R.styleable.ucrop_UCropView_ucrop_show_frame, true);
        initCropGridStyle(typedArray);
        this.mShowCropGrid = typedArray.getBoolean(R.styleable.ucrop_UCropView_ucrop_show_grid, true);
    }

    public void setCircleDimmedLayer(boolean z) {
        this.mCircleDimmedLayer = z;
    }

    public void setCropFrameColor(@ColorInt int i2) {
        this.mCropFramePaint.setColor(i2);
    }

    public void setCropFrameStrokeWidth(@IntRange(from = 0) int i2) {
        this.mCropFramePaint.setStrokeWidth(i2);
    }

    public void setCropGridColor(@ColorInt int i2) {
        this.mCropGridPaint.setColor(i2);
    }

    public void setCropGridColumnCount(@IntRange(from = 0) int i2) {
        this.mCropGridColumnCount = i2;
        this.mGridPoints = null;
    }

    public void setCropGridRowCount(@IntRange(from = 0) int i2) {
        this.mCropGridRowCount = i2;
        this.mGridPoints = null;
    }

    public void setCropGridStrokeWidth(@IntRange(from = 0) int i2) {
        this.mCropGridPaint.setStrokeWidth(i2);
    }

    public void setDimmedColor(@ColorInt int i2) {
        this.mDimmedColor = i2;
    }

    @Deprecated
    public void setFreestyleCropEnabled(boolean z) {
        this.mFreestyleCropMode = z ? 1 : 0;
    }

    public void setFreestyleCropMode(int i2) {
        this.mFreestyleCropMode = i2;
        postInvalidate();
    }

    public void setOverlayViewChangeListener(OverlayViewChangeListener overlayViewChangeListener) {
        this.mCallback = overlayViewChangeListener;
    }

    public void setShowCropFrame(boolean z) {
        this.mShowCropFrame = z;
    }

    public void setShowCropGrid(boolean z) {
        this.mShowCropGrid = z;
    }

    public void setTargetAspectRatio(float f2) {
        this.mTargetAspectRatio = f2;
        if (this.mThisWidth > 0) {
            setupCropBounds();
            postInvalidate();
            return;
        }
        this.mShouldSetupCropBounds = true;
    }

    public void setupCropBounds() {
        int i2 = this.mThisWidth;
        float f2 = this.mTargetAspectRatio;
        int i3 = (int) (i2 / f2);
        int i4 = this.mThisHeight;
        if (i3 > i4) {
            int i5 = (int) (i4 * f2);
            int i6 = (i2 - i5) / 2;
            this.mCropViewRect.set(getPaddingLeft() + i6, getPaddingTop(), getPaddingLeft() + i5 + i6, getPaddingTop() + this.mThisHeight);
        } else {
            int i7 = (i4 - i3) / 2;
            this.mCropViewRect.set(getPaddingLeft(), getPaddingTop() + i7, getPaddingLeft() + this.mThisWidth, getPaddingTop() + i3 + i7);
        }
        OverlayViewChangeListener overlayViewChangeListener = this.mCallback;
        if (overlayViewChangeListener != null) {
            overlayViewChangeListener.onCropRectUpdated(this.mCropViewRect);
        }
        updateGridPoints();
    }

    public OverlayView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OverlayView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mCropViewRect = new RectF();
        this.mTempRect = new RectF();
        this.mGridPoints = null;
        this.mCircularPath = new Path();
        this.mDimmedStrokePaint = new Paint(1);
        this.mCropGridPaint = new Paint(1);
        this.mCropFramePaint = new Paint(1);
        this.mCropFrameCornersPaint = new Paint(1);
        this.mFreestyleCropMode = 0;
        this.mPreviousTouchX = -1.0f;
        this.mPreviousTouchY = -1.0f;
        this.mCurrentTouchCornerIndex = -1;
        this.mTouchPointThreshold = getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_rect_corner_touch_threshold);
        this.mCropRectMinSize = getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_rect_min_size);
        this.mCropRectCornerTouchAreaLineLength = getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_rect_corner_touch_area_line_length);
        init();
    }
}
