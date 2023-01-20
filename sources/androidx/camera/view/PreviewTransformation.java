package androidx.camera.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;
import android.view.Display;
import android.view.TextureView;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.view.PreviewView;
import androidx.core.util.Preconditions;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class PreviewTransformation {
    private static final PreviewView.ScaleType DEFAULT_SCALE_TYPE = PreviewView.ScaleType.FILL_CENTER;
    private static final String TAG = "PreviewTransform";
    private boolean mIsFrontCamera;
    private int mPreviewRotationDegrees;
    private Size mResolution;
    private PreviewView.ScaleType mScaleType = DEFAULT_SCALE_TYPE;
    private Rect mSurfaceCropRect;
    private int mTargetRotation;

    /* renamed from: androidx.camera.view.PreviewTransformation$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$androidx$camera$view$PreviewView$ScaleType;

        static {
            int[] iArr = new int[PreviewView.ScaleType.values().length];
            $SwitchMap$androidx$camera$view$PreviewView$ScaleType = iArr;
            try {
                iArr[PreviewView.ScaleType.FIT_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$camera$view$PreviewView$ScaleType[PreviewView.ScaleType.FILL_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$camera$view$PreviewView$ScaleType[PreviewView.ScaleType.FIT_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$camera$view$PreviewView$ScaleType[PreviewView.ScaleType.FILL_END.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$camera$view$PreviewView$ScaleType[PreviewView.ScaleType.FIT_START.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$androidx$camera$view$PreviewView$ScaleType[PreviewView.ScaleType.FILL_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private static RectF flipHorizontally(RectF rectF, float f2) {
        float f3 = f2 + f2;
        return new RectF(f3 - rectF.right, rectF.top, f3 - rectF.left, rectF.bottom);
    }

    private Size getRotatedViewportSize() {
        if (TransformUtils.is90or270(this.mPreviewRotationDegrees)) {
            return new Size(this.mSurfaceCropRect.height(), this.mSurfaceCropRect.width());
        }
        return new Size(this.mSurfaceCropRect.width(), this.mSurfaceCropRect.height());
    }

    private RectF getTransformedSurfaceRect(Size size, int i2) {
        Preconditions.checkState(isTransformationInfoReady());
        Matrix surfaceToPreviewViewMatrix = getSurfaceToPreviewViewMatrix(size, i2);
        RectF rectF = new RectF(0.0f, 0.0f, this.mResolution.getWidth(), this.mResolution.getHeight());
        surfaceToPreviewViewMatrix.mapRect(rectF);
        return rectF;
    }

    private boolean isTransformationInfoReady() {
        return (this.mSurfaceCropRect == null || this.mResolution == null || this.mTargetRotation == -1) ? false : true;
    }

    private static void setMatrixRectToRect(Matrix matrix, RectF rectF, RectF rectF2, PreviewView.ScaleType scaleType) {
        Matrix.ScaleToFit scaleToFit;
        switch (AnonymousClass1.$SwitchMap$androidx$camera$view$PreviewView$ScaleType[scaleType.ordinal()]) {
            case 1:
            case 2:
                scaleToFit = Matrix.ScaleToFit.CENTER;
                break;
            case 3:
            case 4:
                scaleToFit = Matrix.ScaleToFit.END;
                break;
            case 5:
            case 6:
                scaleToFit = Matrix.ScaleToFit.START;
                break;
            default:
                Logger.e(TAG, "Unexpected crop rect: " + scaleType);
                scaleToFit = Matrix.ScaleToFit.FILL;
                break;
        }
        if (scaleType == PreviewView.ScaleType.FIT_CENTER || scaleType == PreviewView.ScaleType.FIT_START || scaleType == PreviewView.ScaleType.FIT_END) {
            matrix.setRectToRect(rectF, rectF2, scaleToFit);
            return;
        }
        matrix.setRectToRect(rectF2, rectF, scaleToFit);
        matrix.invert(matrix);
    }

    public Bitmap createTransformedBitmap(@NonNull Bitmap bitmap, Size size, int i2) {
        if (isTransformationInfoReady()) {
            Matrix textureViewCorrectionMatrix = getTextureViewCorrectionMatrix();
            RectF transformedSurfaceRect = getTransformedSurfaceRect(size, i2);
            Bitmap createBitmap = Bitmap.createBitmap(size.getWidth(), size.getHeight(), bitmap.getConfig());
            Canvas canvas = new Canvas(createBitmap);
            Matrix matrix = new Matrix();
            matrix.postConcat(textureViewCorrectionMatrix);
            matrix.postScale(transformedSurfaceRect.width() / this.mResolution.getWidth(), transformedSurfaceRect.height() / this.mResolution.getHeight());
            matrix.postTranslate(transformedSurfaceRect.left, transformedSurfaceRect.top);
            canvas.drawBitmap(bitmap, matrix, new Paint(7));
            return createBitmap;
        }
        return bitmap;
    }

    @Nullable
    public Matrix getPreviewViewToNormalizedSurfaceMatrix(Size size, int i2) {
        if (isTransformationInfoReady()) {
            Matrix matrix = new Matrix();
            getSurfaceToPreviewViewMatrix(size, i2).invert(matrix);
            Matrix matrix2 = new Matrix();
            matrix2.setRectToRect(new RectF(0.0f, 0.0f, this.mResolution.getWidth(), this.mResolution.getHeight()), new RectF(0.0f, 0.0f, 1.0f, 1.0f), Matrix.ScaleToFit.FILL);
            matrix.postConcat(matrix2);
            return matrix;
        }
        return null;
    }

    public RectF getPreviewViewViewportRectForMismatchedAspectRatios(Size size, int i2) {
        RectF rectF = new RectF(0.0f, 0.0f, size.getWidth(), size.getHeight());
        Size rotatedViewportSize = getRotatedViewportSize();
        RectF rectF2 = new RectF(0.0f, 0.0f, rotatedViewportSize.getWidth(), rotatedViewportSize.getHeight());
        Matrix matrix = new Matrix();
        setMatrixRectToRect(matrix, rectF2, rectF, this.mScaleType);
        matrix.mapRect(rectF2);
        return i2 == 1 ? flipHorizontally(rectF2, size.getWidth() / 2.0f) : rectF2;
    }

    public PreviewView.ScaleType getScaleType() {
        return this.mScaleType;
    }

    @Nullable
    public Rect getSurfaceCropRect() {
        return this.mSurfaceCropRect;
    }

    public Matrix getSurfaceToPreviewViewMatrix(Size size, int i2) {
        RectF previewViewViewportRectForMismatchedAspectRatios;
        Preconditions.checkState(isTransformationInfoReady());
        if (isViewportAspectRatioMatchPreviewView(size)) {
            previewViewViewportRectForMismatchedAspectRatios = new RectF(0.0f, 0.0f, size.getWidth(), size.getHeight());
        } else {
            previewViewViewportRectForMismatchedAspectRatios = getPreviewViewViewportRectForMismatchedAspectRatios(size, i2);
        }
        Matrix rectToRect = TransformUtils.getRectToRect(new RectF(this.mSurfaceCropRect), previewViewViewportRectForMismatchedAspectRatios, this.mPreviewRotationDegrees);
        if (this.mIsFrontCamera) {
            if (TransformUtils.is90or270(this.mPreviewRotationDegrees)) {
                rectToRect.preScale(1.0f, -1.0f, this.mSurfaceCropRect.centerX(), this.mSurfaceCropRect.centerY());
            } else {
                rectToRect.preScale(-1.0f, 1.0f, this.mSurfaceCropRect.centerX(), this.mSurfaceCropRect.centerY());
            }
        }
        return rectToRect;
    }

    @VisibleForTesting
    public Matrix getTextureViewCorrectionMatrix() {
        Preconditions.checkState(isTransformationInfoReady());
        RectF rectF = new RectF(0.0f, 0.0f, this.mResolution.getWidth(), this.mResolution.getHeight());
        return TransformUtils.getRectToRect(rectF, rectF, -TransformUtils.surfaceRotationToRotationDegrees(this.mTargetRotation));
    }

    @VisibleForTesting
    public boolean isViewportAspectRatioMatchPreviewView(Size size) {
        return TransformUtils.isAspectRatioMatchingWithRoundingError(size, true, getRotatedViewportSize(), false);
    }

    public void overrideWithDisplayRotation(int i2, int i3) {
        this.mPreviewRotationDegrees = i2;
        this.mTargetRotation = i3;
    }

    public void setScaleType(PreviewView.ScaleType scaleType) {
        this.mScaleType = scaleType;
    }

    public void setTransformationInfo(@NonNull SurfaceRequest.TransformationInfo transformationInfo, Size size, boolean z) {
        Logger.d(TAG, "Transformation info set: " + transformationInfo + ExpandableTextView.N + size + ExpandableTextView.N + z);
        this.mSurfaceCropRect = transformationInfo.getCropRect();
        this.mPreviewRotationDegrees = transformationInfo.getRotationDegrees();
        this.mTargetRotation = transformationInfo.getTargetRotation();
        this.mResolution = size;
        this.mIsFrontCamera = z;
    }

    public void transformView(Size size, int i2, @NonNull View view) {
        if (size.getHeight() != 0 && size.getWidth() != 0) {
            if (isTransformationInfoReady()) {
                if (view instanceof TextureView) {
                    ((TextureView) view).setTransform(getTextureViewCorrectionMatrix());
                } else {
                    Display display = view.getDisplay();
                    if (display != null && display.getRotation() != this.mTargetRotation) {
                        Logger.e(TAG, "Non-display rotation not supported with SurfaceView / PERFORMANCE mode.");
                    }
                }
                RectF transformedSurfaceRect = getTransformedSurfaceRect(size, i2);
                view.setPivotX(0.0f);
                view.setPivotY(0.0f);
                view.setScaleX(transformedSurfaceRect.width() / this.mResolution.getWidth());
                view.setScaleY(transformedSurfaceRect.height() / this.mResolution.getHeight());
                view.setTranslationX(transformedSurfaceRect.left - view.getLeft());
                view.setTranslationY(transformedSurfaceRect.top - view.getTop());
                return;
            }
            return;
        }
        Logger.w(TAG, "Transform not applied due to PreviewView size: " + size);
    }
}
