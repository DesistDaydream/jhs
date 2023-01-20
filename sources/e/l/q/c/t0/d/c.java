package e.l.q.c.t0.d;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;
import e.l.q.c.t0.d.d;

/* loaded from: classes2.dex */
public interface c {
    public static final float r0 = 3.0f;
    public static final float s0 = 1.75f;
    public static final float t0 = 1.0f;
    public static final int u0 = 200;

    boolean b();

    void getDisplayMatrix(Matrix matrix);

    RectF getDisplayRect();

    c getIPhotoViewImplementation();

    float getMaximumScale();

    float getMediumScale();

    float getMinimumScale();

    float getScale();

    ImageView.ScaleType getScaleType();

    Bitmap getVisibleRectangleBitmap();

    void setAllowParentInterceptOnEdge(boolean z);

    boolean setDisplayMatrix(Matrix matrix);

    void setMaximumScale(float f2);

    void setMediumScale(float f2);

    void setMinimumScale(float f2);

    void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener);

    void setOnLongClickListener(View.OnLongClickListener onLongClickListener);

    void setOnMatrixChangeListener(d.e eVar);

    void setOnPhotoTapListener(d.f fVar);

    void setOnScaleChangeListener(d.g gVar);

    void setOnSingleFlingListener(d.h hVar);

    void setOnViewTapListener(d.i iVar);

    void setRotationBy(float f2);

    void setRotationTo(float f2);

    void setScale(float f2);

    void setScale(float f2, float f3, float f4, boolean z);

    void setScale(float f2, boolean z);

    void setScaleLevels(float f2, float f3, float f4);

    void setScaleType(ImageView.ScaleType scaleType);

    void setZoomTransitionDuration(int i2);

    void setZoomable(boolean z);
}
