package com.m7.imkfsdk.view.imageviewer.photoview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.OverScroller;

/* loaded from: classes2.dex */
public class PhotoViewAttacher implements View.OnTouchListener, View.OnLayoutChangeListener {
    private static final float DEFAULT_MAX_SCALE = 3.0f;
    private static final float DEFAULT_MID_SCALE = 1.75f;
    private static final float DEFAULT_MIN_SCALE = 1.0f;
    private static final int DEFAULT_ZOOM_DURATION = 200;
    private static final int HORIZONTAL_EDGE_BOTH = 2;
    private static final int HORIZONTAL_EDGE_LEFT = 0;
    private static final int HORIZONTAL_EDGE_NONE = -1;
    private static final int HORIZONTAL_EDGE_RIGHT = 1;
    private static final int SINGLE_TOUCH = 1;
    private static final int VERTICAL_EDGE_BOTH = 2;
    private static final int VERTICAL_EDGE_BOTTOM = 1;
    private static final int VERTICAL_EDGE_NONE = -1;
    private static final int VERTICAL_EDGE_TOP = 0;
    private float mBaseRotation;
    private FlingRunnable mCurrentFlingRunnable;
    private GestureDetector mGestureDetector;
    private final ImageView mImageView;
    private View.OnLongClickListener mLongClickListener;
    private OnMatrixChangedListener mMatrixChangeListener;
    private View.OnClickListener mOnClickListener;
    private OnViewDragListener mOnViewDragListener;
    private OnOutsidePhotoTapListener mOutsidePhotoTapListener;
    private OnPhotoTapListener mPhotoTapListener;
    private OnScaleChangedListener mScaleChangeListener;
    private CustomGestureDetector mScaleDragDetector;
    private OnSingleFlingListener mSingleFlingListener;
    private OnViewTapListener mViewTapListener;
    private final OnGestureListener onGestureListener;
    private final Matrix mBaseMatrix = new Matrix();
    private final Matrix mDrawMatrix = new Matrix();
    private final Matrix mSuppMatrix = new Matrix();
    private final RectF mDisplayRect = new RectF();
    private final float[] mMatrixValues = new float[9];
    private Interpolator mInterpolator = new AccelerateDecelerateInterpolator();
    private int mZoomDuration = 200;
    private float mMinScale = 1.0f;
    private float mMidScale = 1.75f;
    private float mMaxScale = 3.0f;
    private boolean mAllowParentInterceptOnEdge = true;
    private boolean mBlockParentIntercept = false;
    private int mHorizontalScrollEdge = 2;
    private int mVerticalScrollEdge = 2;
    private boolean mZoomEnabled = true;
    private ImageView.ScaleType mScaleType = ImageView.ScaleType.FIT_CENTER;

    /* renamed from: com.m7.imkfsdk.view.imageviewer.photoview.PhotoViewAttacher$4  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass4 {
        public static final /* synthetic */ int[] $SwitchMap$android$widget$ImageView$ScaleType;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            $SwitchMap$android$widget$ImageView$ScaleType = iArr;
            try {
                iArr[ImageView.ScaleType.FIT_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_XY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public class AnimatedZoomRunnable implements Runnable {
        private final float mFocalX;
        private final float mFocalY;
        private final long mStartTime = System.currentTimeMillis();
        private final float mZoomEnd;
        private final float mZoomStart;

        public AnimatedZoomRunnable(float f2, float f3, float f4, float f5) {
            this.mFocalX = f4;
            this.mFocalY = f5;
            this.mZoomStart = f2;
            this.mZoomEnd = f3;
        }

        private float interpolate() {
            return PhotoViewAttacher.this.mInterpolator.getInterpolation(Math.min(1.0f, (((float) (System.currentTimeMillis() - this.mStartTime)) * 1.0f) / PhotoViewAttacher.this.mZoomDuration));
        }

        @Override // java.lang.Runnable
        public void run() {
            float interpolate = interpolate();
            float f2 = this.mZoomStart;
            PhotoViewAttacher.this.onGestureListener.onScale((f2 + ((this.mZoomEnd - f2) * interpolate)) / PhotoViewAttacher.this.getScale(), this.mFocalX, this.mFocalY);
            if (interpolate < 1.0f) {
                Compat.postOnAnimation(PhotoViewAttacher.this.mImageView, this);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class FlingRunnable implements Runnable {
        private int mCurrentX;
        private int mCurrentY;
        private final OverScroller mScroller;

        public FlingRunnable(Context context) {
            this.mScroller = new OverScroller(context);
        }

        public void cancelFling() {
            this.mScroller.forceFinished(true);
        }

        public void fling(int i2, int i3, int i4, int i5) {
            int i6;
            int i7;
            int i8;
            int i9;
            RectF displayRect = PhotoViewAttacher.this.getDisplayRect();
            if (displayRect == null) {
                return;
            }
            int round = Math.round(-displayRect.left);
            float f2 = i2;
            if (f2 < displayRect.width()) {
                i7 = Math.round(displayRect.width() - f2);
                i6 = 0;
            } else {
                i6 = round;
                i7 = i6;
            }
            int round2 = Math.round(-displayRect.top);
            float f3 = i3;
            if (f3 < displayRect.height()) {
                i9 = Math.round(displayRect.height() - f3);
                i8 = 0;
            } else {
                i8 = round2;
                i9 = i8;
            }
            this.mCurrentX = round;
            this.mCurrentY = round2;
            if (round == i7 && round2 == i9) {
                return;
            }
            this.mScroller.fling(round, round2, i4, i5, i6, i7, i8, i9, 0, 0);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.mScroller.isFinished() && this.mScroller.computeScrollOffset()) {
                int currX = this.mScroller.getCurrX();
                int currY = this.mScroller.getCurrY();
                PhotoViewAttacher.this.mSuppMatrix.postTranslate(this.mCurrentX - currX, this.mCurrentY - currY);
                PhotoViewAttacher.this.checkAndDisplayMatrix();
                this.mCurrentX = currX;
                this.mCurrentY = currY;
                Compat.postOnAnimation(PhotoViewAttacher.this.mImageView, this);
            }
        }
    }

    public PhotoViewAttacher(ImageView imageView) {
        OnGestureListener onGestureListener = new OnGestureListener() { // from class: com.m7.imkfsdk.view.imageviewer.photoview.PhotoViewAttacher.1
            @Override // com.m7.imkfsdk.view.imageviewer.photoview.OnGestureListener
            public void onDrag(float f2, float f3) {
                if (PhotoViewAttacher.this.mScaleDragDetector.isScaling()) {
                    return;
                }
                if (PhotoViewAttacher.this.mOnViewDragListener != null) {
                    PhotoViewAttacher.this.mOnViewDragListener.onDrag(f2, f3);
                }
                PhotoViewAttacher.this.mSuppMatrix.postTranslate(f2, f3);
                PhotoViewAttacher.this.checkAndDisplayMatrix();
                ViewParent parent = PhotoViewAttacher.this.mImageView.getParent();
                if (!PhotoViewAttacher.this.mAllowParentInterceptOnEdge || PhotoViewAttacher.this.mScaleDragDetector.isScaling() || PhotoViewAttacher.this.mBlockParentIntercept) {
                    if (parent != null) {
                        parent.requestDisallowInterceptTouchEvent(true);
                    }
                } else if ((PhotoViewAttacher.this.mHorizontalScrollEdge == 2 || ((PhotoViewAttacher.this.mHorizontalScrollEdge == 0 && f2 >= 1.0f) || ((PhotoViewAttacher.this.mHorizontalScrollEdge == 1 && f2 <= -1.0f) || ((PhotoViewAttacher.this.mVerticalScrollEdge == 0 && f3 >= 1.0f) || (PhotoViewAttacher.this.mVerticalScrollEdge == 1 && f3 <= -1.0f))))) && parent != null) {
                    parent.requestDisallowInterceptTouchEvent(false);
                }
            }

            @Override // com.m7.imkfsdk.view.imageviewer.photoview.OnGestureListener
            public void onFling(float f2, float f3, float f4, float f5) {
                PhotoViewAttacher photoViewAttacher = PhotoViewAttacher.this;
                photoViewAttacher.mCurrentFlingRunnable = new FlingRunnable(photoViewAttacher.mImageView.getContext());
                FlingRunnable flingRunnable = PhotoViewAttacher.this.mCurrentFlingRunnable;
                PhotoViewAttacher photoViewAttacher2 = PhotoViewAttacher.this;
                int imageViewWidth = photoViewAttacher2.getImageViewWidth(photoViewAttacher2.mImageView);
                PhotoViewAttacher photoViewAttacher3 = PhotoViewAttacher.this;
                flingRunnable.fling(imageViewWidth, photoViewAttacher3.getImageViewHeight(photoViewAttacher3.mImageView), (int) f4, (int) f5);
                PhotoViewAttacher.this.mImageView.post(PhotoViewAttacher.this.mCurrentFlingRunnable);
            }

            @Override // com.m7.imkfsdk.view.imageviewer.photoview.OnGestureListener
            public void onScale(float f2, float f3, float f4) {
                if (PhotoViewAttacher.this.getScale() < PhotoViewAttacher.this.mMaxScale || f2 < 1.0f) {
                    if (PhotoViewAttacher.this.mScaleChangeListener != null) {
                        PhotoViewAttacher.this.mScaleChangeListener.onScaleChange(f2, f3, f4);
                    }
                    PhotoViewAttacher.this.mSuppMatrix.postScale(f2, f2, f3, f4);
                    PhotoViewAttacher.this.checkAndDisplayMatrix();
                }
            }
        };
        this.onGestureListener = onGestureListener;
        this.mImageView = imageView;
        imageView.setOnTouchListener(this);
        imageView.addOnLayoutChangeListener(this);
        if (imageView.isInEditMode()) {
            return;
        }
        this.mBaseRotation = 0.0f;
        this.mScaleDragDetector = new CustomGestureDetector(imageView.getContext(), onGestureListener);
        GestureDetector gestureDetector = new GestureDetector(imageView.getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.m7.imkfsdk.view.imageviewer.photoview.PhotoViewAttacher.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                if (PhotoViewAttacher.this.mSingleFlingListener == null || PhotoViewAttacher.this.getScale() > 1.0f || motionEvent.getPointerCount() > 1 || motionEvent2.getPointerCount() > 1) {
                    return false;
                }
                return PhotoViewAttacher.this.mSingleFlingListener.onFling(motionEvent, motionEvent2, f2, f3);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                if (PhotoViewAttacher.this.mLongClickListener != null) {
                    PhotoViewAttacher.this.mLongClickListener.onLongClick(PhotoViewAttacher.this.mImageView);
                }
            }
        });
        this.mGestureDetector = gestureDetector;
        gestureDetector.setOnDoubleTapListener(new GestureDetector.OnDoubleTapListener() { // from class: com.m7.imkfsdk.view.imageviewer.photoview.PhotoViewAttacher.3
            @Override // android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                try {
                    float scale = PhotoViewAttacher.this.getScale();
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    if (scale < PhotoViewAttacher.this.getMediumScale()) {
                        PhotoViewAttacher photoViewAttacher = PhotoViewAttacher.this;
                        photoViewAttacher.setScale(photoViewAttacher.getMediumScale(), x, y, true);
                    } else if (scale >= PhotoViewAttacher.this.getMediumScale() && scale < PhotoViewAttacher.this.getMaximumScale()) {
                        PhotoViewAttacher photoViewAttacher2 = PhotoViewAttacher.this;
                        photoViewAttacher2.setScale(photoViewAttacher2.getMaximumScale(), x, y, true);
                    } else {
                        PhotoViewAttacher photoViewAttacher3 = PhotoViewAttacher.this;
                        photoViewAttacher3.setScale(photoViewAttacher3.getMinimumScale(), x, y, true);
                    }
                } catch (ArrayIndexOutOfBoundsException unused) {
                }
                return true;
            }

            @Override // android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTapEvent(MotionEvent motionEvent) {
                return false;
            }

            @Override // android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                if (PhotoViewAttacher.this.mOnClickListener != null) {
                    PhotoViewAttacher.this.mOnClickListener.onClick(PhotoViewAttacher.this.mImageView);
                }
                RectF displayRect = PhotoViewAttacher.this.getDisplayRect();
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (PhotoViewAttacher.this.mViewTapListener != null) {
                    PhotoViewAttacher.this.mViewTapListener.onViewTap(PhotoViewAttacher.this.mImageView, x, y);
                }
                if (displayRect != null) {
                    if (!displayRect.contains(x, y)) {
                        if (PhotoViewAttacher.this.mOutsidePhotoTapListener != null) {
                            PhotoViewAttacher.this.mOutsidePhotoTapListener.onOutsidePhotoTap(PhotoViewAttacher.this.mImageView);
                            return false;
                        }
                        return false;
                    }
                    float width = (x - displayRect.left) / displayRect.width();
                    float height = (y - displayRect.top) / displayRect.height();
                    if (PhotoViewAttacher.this.mPhotoTapListener != null) {
                        PhotoViewAttacher.this.mPhotoTapListener.onPhotoTap(PhotoViewAttacher.this.mImageView, width, height);
                        return true;
                    }
                    return true;
                }
                return false;
            }
        });
    }

    private void cancelFling() {
        FlingRunnable flingRunnable = this.mCurrentFlingRunnable;
        if (flingRunnable != null) {
            flingRunnable.cancelFling();
            this.mCurrentFlingRunnable = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkAndDisplayMatrix() {
        if (checkMatrixBounds()) {
            setImageViewMatrix(getDrawMatrix());
        }
    }

    private boolean checkMatrixBounds() {
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        RectF displayRect = getDisplayRect(getDrawMatrix());
        if (displayRect == null) {
            return false;
        }
        float height = displayRect.height();
        float width = displayRect.width();
        float imageViewHeight = getImageViewHeight(this.mImageView);
        float f7 = 0.0f;
        if (height <= imageViewHeight) {
            int i2 = AnonymousClass4.$SwitchMap$android$widget$ImageView$ScaleType[this.mScaleType.ordinal()];
            if (i2 != 2) {
                if (i2 != 3) {
                    f5 = (imageViewHeight - height) / 2.0f;
                    f6 = displayRect.top;
                } else {
                    f5 = imageViewHeight - height;
                    f6 = displayRect.top;
                }
                f2 = f5 - f6;
            } else {
                f2 = -displayRect.top;
            }
            this.mVerticalScrollEdge = 2;
        } else {
            float f8 = displayRect.top;
            if (f8 > 0.0f) {
                this.mVerticalScrollEdge = 0;
                f2 = -f8;
            } else {
                float f9 = displayRect.bottom;
                if (f9 < imageViewHeight) {
                    this.mVerticalScrollEdge = 1;
                    f2 = imageViewHeight - f9;
                } else {
                    this.mVerticalScrollEdge = -1;
                    f2 = 0.0f;
                }
            }
        }
        float imageViewWidth = getImageViewWidth(this.mImageView);
        if (width <= imageViewWidth) {
            int i3 = AnonymousClass4.$SwitchMap$android$widget$ImageView$ScaleType[this.mScaleType.ordinal()];
            if (i3 != 2) {
                if (i3 != 3) {
                    f3 = (imageViewWidth - width) / 2.0f;
                    f4 = displayRect.left;
                } else {
                    f3 = imageViewWidth - width;
                    f4 = displayRect.left;
                }
                f7 = f3 - f4;
            } else {
                f7 = -displayRect.left;
            }
            this.mHorizontalScrollEdge = 2;
        } else {
            float f10 = displayRect.left;
            if (f10 > 0.0f) {
                this.mHorizontalScrollEdge = 0;
                f7 = -f10;
            } else {
                float f11 = displayRect.right;
                if (f11 < imageViewWidth) {
                    f7 = imageViewWidth - f11;
                    this.mHorizontalScrollEdge = 1;
                } else {
                    this.mHorizontalScrollEdge = -1;
                }
            }
        }
        this.mSuppMatrix.postTranslate(f7, f2);
        return true;
    }

    private Matrix getDrawMatrix() {
        this.mDrawMatrix.set(this.mBaseMatrix);
        this.mDrawMatrix.postConcat(this.mSuppMatrix);
        return this.mDrawMatrix;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getImageViewHeight(ImageView imageView) {
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getImageViewWidth(ImageView imageView) {
        return (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
    }

    private float getValue(Matrix matrix, int i2) {
        matrix.getValues(this.mMatrixValues);
        return this.mMatrixValues[i2];
    }

    private void resetMatrix() {
        this.mSuppMatrix.reset();
        setRotationBy(this.mBaseRotation);
        setImageViewMatrix(getDrawMatrix());
        checkMatrixBounds();
    }

    private void setImageViewMatrix(Matrix matrix) {
        RectF displayRect;
        this.mImageView.setImageMatrix(matrix);
        if (this.mMatrixChangeListener == null || (displayRect = getDisplayRect(matrix)) == null) {
            return;
        }
        this.mMatrixChangeListener.onMatrixChanged(displayRect);
    }

    private void updateBaseMatrix(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        float imageViewWidth = getImageViewWidth(this.mImageView);
        float imageViewHeight = getImageViewHeight(this.mImageView);
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        this.mBaseMatrix.reset();
        float f2 = intrinsicWidth;
        float f3 = imageViewWidth / f2;
        float f4 = intrinsicHeight;
        float f5 = imageViewHeight / f4;
        ImageView.ScaleType scaleType = this.mScaleType;
        if (scaleType == ImageView.ScaleType.CENTER) {
            this.mBaseMatrix.postTranslate((imageViewWidth - f2) / 2.0f, (imageViewHeight - f4) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            float max = Math.max(f3, f5);
            this.mBaseMatrix.postScale(max, max);
            this.mBaseMatrix.postTranslate((imageViewWidth - (f2 * max)) / 2.0f, (imageViewHeight - (f4 * max)) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_INSIDE) {
            float min = Math.min(1.0f, Math.min(f3, f5));
            this.mBaseMatrix.postScale(min, min);
            this.mBaseMatrix.postTranslate((imageViewWidth - (f2 * min)) / 2.0f, (imageViewHeight - (f4 * min)) / 2.0f);
        } else {
            RectF rectF = new RectF(0.0f, 0.0f, f2, f4);
            RectF rectF2 = new RectF(0.0f, 0.0f, imageViewWidth, imageViewHeight);
            if (((int) this.mBaseRotation) % 180 != 0) {
                rectF = new RectF(0.0f, 0.0f, f4, f2);
            }
            int i2 = AnonymousClass4.$SwitchMap$android$widget$ImageView$ScaleType[this.mScaleType.ordinal()];
            if (i2 == 1) {
                this.mBaseMatrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            } else if (i2 == 2) {
                this.mBaseMatrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
            } else if (i2 == 3) {
                this.mBaseMatrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
            } else if (i2 == 4) {
                this.mBaseMatrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
            }
        }
        resetMatrix();
    }

    public void getDisplayMatrix(Matrix matrix) {
        matrix.set(getDrawMatrix());
    }

    public RectF getDisplayRect() {
        checkMatrixBounds();
        return getDisplayRect(getDrawMatrix());
    }

    public Matrix getImageMatrix() {
        return this.mDrawMatrix;
    }

    public float getMaximumScale() {
        return this.mMaxScale;
    }

    public float getMediumScale() {
        return this.mMidScale;
    }

    public float getMinimumScale() {
        return this.mMinScale;
    }

    public float getScale() {
        return (float) Math.sqrt(((float) Math.pow(getValue(this.mSuppMatrix, 0), 2.0d)) + ((float) Math.pow(getValue(this.mSuppMatrix, 3), 2.0d)));
    }

    public ImageView.ScaleType getScaleType() {
        return this.mScaleType;
    }

    public void getSuppMatrix(Matrix matrix) {
        matrix.set(this.mSuppMatrix);
    }

    @Deprecated
    public boolean isZoomEnabled() {
        return this.mZoomEnabled;
    }

    public boolean isZoomable() {
        return this.mZoomEnabled;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        if (i2 == i6 && i3 == i7 && i4 == i8 && i5 == i9) {
            return;
        }
        updateBaseMatrix(this.mImageView.getDrawable());
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b2  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r11, android.view.MotionEvent r12) {
        /*
            r10 = this;
            boolean r0 = r10.mZoomEnabled
            r1 = 0
            r2 = 1
            if (r0 == 0) goto Lbe
            r0 = r11
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            boolean r0 = com.m7.imkfsdk.view.imageviewer.photoview.Util.hasDrawable(r0)
            if (r0 == 0) goto Lbe
            int r0 = r12.getAction()
            if (r0 == 0) goto L6e
            if (r0 == r2) goto L1b
            r3 = 3
            if (r0 == r3) goto L1b
            goto L7a
        L1b:
            float r0 = r10.getScale()
            float r3 = r10.mMinScale
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 >= 0) goto L44
            android.graphics.RectF r0 = r10.getDisplayRect()
            if (r0 == 0) goto L7a
            com.m7.imkfsdk.view.imageviewer.photoview.PhotoViewAttacher$AnimatedZoomRunnable r9 = new com.m7.imkfsdk.view.imageviewer.photoview.PhotoViewAttacher$AnimatedZoomRunnable
            float r5 = r10.getScale()
            float r6 = r10.mMinScale
            float r7 = r0.centerX()
            float r8 = r0.centerY()
            r3 = r9
            r4 = r10
            r3.<init>(r5, r6, r7, r8)
            r11.post(r9)
            goto L6c
        L44:
            float r0 = r10.getScale()
            float r3 = r10.mMaxScale
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 <= 0) goto L7a
            android.graphics.RectF r0 = r10.getDisplayRect()
            if (r0 == 0) goto L7a
            com.m7.imkfsdk.view.imageviewer.photoview.PhotoViewAttacher$AnimatedZoomRunnable r9 = new com.m7.imkfsdk.view.imageviewer.photoview.PhotoViewAttacher$AnimatedZoomRunnable
            float r5 = r10.getScale()
            float r6 = r10.mMaxScale
            float r7 = r0.centerX()
            float r8 = r0.centerY()
            r3 = r9
            r4 = r10
            r3.<init>(r5, r6, r7, r8)
            r11.post(r9)
        L6c:
            r11 = 1
            goto L7b
        L6e:
            android.view.ViewParent r11 = r11.getParent()
            if (r11 == 0) goto L77
            r11.requestDisallowInterceptTouchEvent(r2)
        L77:
            r10.cancelFling()
        L7a:
            r11 = 0
        L7b:
            com.m7.imkfsdk.view.imageviewer.photoview.CustomGestureDetector r0 = r10.mScaleDragDetector
            if (r0 == 0) goto Lb2
            boolean r11 = r0.isScaling()
            com.m7.imkfsdk.view.imageviewer.photoview.CustomGestureDetector r0 = r10.mScaleDragDetector
            boolean r0 = r0.isDragging()
            com.m7.imkfsdk.view.imageviewer.photoview.CustomGestureDetector r3 = r10.mScaleDragDetector
            boolean r3 = r3.onTouchEvent(r12)
            if (r11 != 0) goto L9b
            com.m7.imkfsdk.view.imageviewer.photoview.CustomGestureDetector r11 = r10.mScaleDragDetector
            boolean r11 = r11.isScaling()
            if (r11 != 0) goto L9b
            r11 = 1
            goto L9c
        L9b:
            r11 = 0
        L9c:
            if (r0 != 0) goto La8
            com.m7.imkfsdk.view.imageviewer.photoview.CustomGestureDetector r0 = r10.mScaleDragDetector
            boolean r0 = r0.isDragging()
            if (r0 != 0) goto La8
            r0 = 1
            goto La9
        La8:
            r0 = 0
        La9:
            if (r11 == 0) goto Lae
            if (r0 == 0) goto Lae
            r1 = 1
        Lae:
            r10.mBlockParentIntercept = r1
            r1 = r3
            goto Lb3
        Lb2:
            r1 = r11
        Lb3:
            android.view.GestureDetector r11 = r10.mGestureDetector
            if (r11 == 0) goto Lbe
            boolean r11 = r11.onTouchEvent(r12)
            if (r11 == 0) goto Lbe
            r1 = 1
        Lbe:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m7.imkfsdk.view.imageviewer.photoview.PhotoViewAttacher.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        this.mAllowParentInterceptOnEdge = z;
    }

    public void setBaseRotation(float f2) {
        this.mBaseRotation = f2 % 360.0f;
        update();
        setRotationBy(this.mBaseRotation);
        checkAndDisplayMatrix();
    }

    public boolean setDisplayMatrix(Matrix matrix) {
        if (matrix != null) {
            if (this.mImageView.getDrawable() == null) {
                return false;
            }
            this.mSuppMatrix.set(matrix);
            checkAndDisplayMatrix();
            return true;
        }
        throw new IllegalArgumentException("Matrix cannot be null");
    }

    public void setMaximumScale(float f2) {
        Util.checkZoomLevels(this.mMinScale, this.mMidScale, f2);
        this.mMaxScale = f2;
    }

    public void setMediumScale(float f2) {
        Util.checkZoomLevels(this.mMinScale, f2, this.mMaxScale);
        this.mMidScale = f2;
    }

    public void setMinimumScale(float f2) {
        Util.checkZoomLevels(f2, this.mMidScale, this.mMaxScale);
        this.mMinScale = f2;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.mGestureDetector.setOnDoubleTapListener(onDoubleTapListener);
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mLongClickListener = onLongClickListener;
    }

    public void setOnMatrixChangeListener(OnMatrixChangedListener onMatrixChangedListener) {
        this.mMatrixChangeListener = onMatrixChangedListener;
    }

    public void setOnOutsidePhotoTapListener(OnOutsidePhotoTapListener onOutsidePhotoTapListener) {
        this.mOutsidePhotoTapListener = onOutsidePhotoTapListener;
    }

    public void setOnPhotoTapListener(OnPhotoTapListener onPhotoTapListener) {
        this.mPhotoTapListener = onPhotoTapListener;
    }

    public void setOnScaleChangeListener(OnScaleChangedListener onScaleChangedListener) {
        this.mScaleChangeListener = onScaleChangedListener;
    }

    public void setOnSingleFlingListener(OnSingleFlingListener onSingleFlingListener) {
        this.mSingleFlingListener = onSingleFlingListener;
    }

    public void setOnViewDragListener(OnViewDragListener onViewDragListener) {
        this.mOnViewDragListener = onViewDragListener;
    }

    public void setOnViewTapListener(OnViewTapListener onViewTapListener) {
        this.mViewTapListener = onViewTapListener;
    }

    public void setRotationBy(float f2) {
        this.mSuppMatrix.postRotate(f2 % 360.0f);
        checkAndDisplayMatrix();
    }

    public void setRotationTo(float f2) {
        this.mSuppMatrix.setRotate(f2 % 360.0f);
        checkAndDisplayMatrix();
    }

    public void setScale(float f2) {
        setScale(f2, false);
    }

    public void setScaleLevels(float f2, float f3, float f4) {
        Util.checkZoomLevels(f2, f3, f4);
        this.mMinScale = f2;
        this.mMidScale = f3;
        this.mMaxScale = f4;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        if (!Util.isSupportedScaleType(scaleType) || scaleType == this.mScaleType) {
            return;
        }
        this.mScaleType = scaleType;
        update();
    }

    public void setZoomInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public void setZoomTransitionDuration(int i2) {
        this.mZoomDuration = i2;
    }

    public void setZoomable(boolean z) {
        this.mZoomEnabled = z;
        update();
    }

    public void update() {
        if (this.mZoomEnabled) {
            updateBaseMatrix(this.mImageView.getDrawable());
        } else {
            resetMatrix();
        }
    }

    public void setScale(float f2, boolean z) {
        setScale(f2, this.mImageView.getRight() / 2, this.mImageView.getBottom() / 2, z);
    }

    private RectF getDisplayRect(Matrix matrix) {
        Drawable drawable = this.mImageView.getDrawable();
        if (drawable != null) {
            this.mDisplayRect.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            matrix.mapRect(this.mDisplayRect);
            return this.mDisplayRect;
        }
        return null;
    }

    public void setScale(float f2, float f3, float f4, boolean z) {
        if (f2 < this.mMinScale || f2 > this.mMaxScale) {
            throw new IllegalArgumentException("Scale must be within the range of minScale and maxScale");
        }
        if (z) {
            this.mImageView.post(new AnimatedZoomRunnable(getScale(), f2, f3, f4));
            return;
        }
        this.mSuppMatrix.setScale(f2, f2, f3, f4);
        checkAndDisplayMatrix();
    }
}
