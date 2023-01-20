package com.jihuanshe.ui.widget.imagepreview.photoview2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import e.l.q.c.t0.d.c;
import e.l.q.c.t0.d.d;

/* loaded from: classes2.dex */
public class PhotoView extends AppCompatImageView implements c {
    private d a;
    private ImageView.ScaleType b;

    public PhotoView(Context context) {
        this(context, null);
    }

    @Override // e.l.q.c.t0.d.c
    public boolean b() {
        return this.a.b();
    }

    @Override // e.l.q.c.t0.d.c
    public void getDisplayMatrix(Matrix matrix) {
        this.a.getDisplayMatrix(matrix);
    }

    @Override // e.l.q.c.t0.d.c
    public RectF getDisplayRect() {
        return this.a.getDisplayRect();
    }

    @Override // e.l.q.c.t0.d.c
    public c getIPhotoViewImplementation() {
        return this.a;
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return this.a.q();
    }

    @Override // e.l.q.c.t0.d.c
    public float getMaximumScale() {
        return this.a.getMaximumScale();
    }

    @Override // e.l.q.c.t0.d.c
    public float getMediumScale() {
        return this.a.getMediumScale();
    }

    @Override // e.l.q.c.t0.d.c
    public float getMinimumScale() {
        return this.a.getMinimumScale();
    }

    @Override // e.l.q.c.t0.d.c
    public float getScale() {
        return this.a.getScale();
    }

    @Override // android.widget.ImageView, e.l.q.c.t0.d.c
    public ImageView.ScaleType getScaleType() {
        return this.a.getScaleType();
    }

    @Override // e.l.q.c.t0.d.c
    public Bitmap getVisibleRectangleBitmap() {
        return this.a.getVisibleRectangleBitmap();
    }

    public void init() {
        d dVar = this.a;
        if (dVar == null || dVar.r() == null) {
            this.a = new d(this);
        }
        ImageView.ScaleType scaleType = this.b;
        if (scaleType != null) {
            setScaleType(scaleType);
            this.b = null;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        init();
        super.onAttachedToWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        this.a.n();
        this.a.A();
        this.a = null;
        super.onDetachedFromWindow();
    }

    @Override // e.l.q.c.t0.d.c
    public void setAllowParentInterceptOnEdge(boolean z) {
        this.a.setAllowParentInterceptOnEdge(z);
    }

    @Override // e.l.q.c.t0.d.c
    public boolean setDisplayMatrix(Matrix matrix) {
        return this.a.setDisplayMatrix(matrix);
    }

    @Override // android.widget.ImageView
    public boolean setFrame(int i2, int i3, int i4, int i5) {
        boolean frame = super.setFrame(i2, i3, i4, i5);
        d dVar = this.a;
        if (dVar != null) {
            dVar.update();
        }
        return frame;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        d dVar = this.a;
        if (dVar != null) {
            dVar.update();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i2) {
        super.setImageResource(i2);
        d dVar = this.a;
        if (dVar != null) {
            dVar.update();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        d dVar = this.a;
        if (dVar != null) {
            dVar.update();
        }
    }

    @Override // e.l.q.c.t0.d.c
    public void setMaximumScale(float f2) {
        this.a.setMaximumScale(f2);
    }

    @Override // e.l.q.c.t0.d.c
    public void setMediumScale(float f2) {
        this.a.setMediumScale(f2);
    }

    @Override // e.l.q.c.t0.d.c
    public void setMinimumScale(float f2) {
        this.a.setMinimumScale(f2);
    }

    @Override // e.l.q.c.t0.d.c
    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.a.setOnDoubleTapListener(onDoubleTapListener);
    }

    @Override // android.view.View, e.l.q.c.t0.d.c
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.a.setOnLongClickListener(onLongClickListener);
    }

    @Override // e.l.q.c.t0.d.c
    public void setOnMatrixChangeListener(d.e eVar) {
        this.a.setOnMatrixChangeListener(eVar);
    }

    @Override // e.l.q.c.t0.d.c
    public void setOnPhotoTapListener(d.f fVar) {
        this.a.setOnPhotoTapListener(fVar);
    }

    @Override // e.l.q.c.t0.d.c
    public void setOnScaleChangeListener(d.g gVar) {
        this.a.setOnScaleChangeListener(gVar);
    }

    @Override // e.l.q.c.t0.d.c
    public void setOnSingleFlingListener(d.h hVar) {
        this.a.setOnSingleFlingListener(hVar);
    }

    @Override // e.l.q.c.t0.d.c
    public void setOnViewTapListener(d.i iVar) {
        this.a.setOnViewTapListener(iVar);
    }

    @Override // e.l.q.c.t0.d.c
    public void setRotationBy(float f2) {
        this.a.setRotationBy(f2);
    }

    @Override // e.l.q.c.t0.d.c
    public void setRotationTo(float f2) {
        this.a.setRotationTo(f2);
    }

    @Override // e.l.q.c.t0.d.c
    public void setScale(float f2) {
        this.a.setScale(f2);
    }

    @Override // e.l.q.c.t0.d.c
    public void setScaleLevels(float f2, float f3, float f4) {
        this.a.setScaleLevels(f2, f3, f4);
    }

    @Override // android.widget.ImageView, e.l.q.c.t0.d.c
    public void setScaleType(ImageView.ScaleType scaleType) {
        d dVar = this.a;
        if (dVar != null) {
            dVar.setScaleType(scaleType);
        } else {
            this.b = scaleType;
        }
    }

    @Override // e.l.q.c.t0.d.c
    public void setZoomTransitionDuration(int i2) {
        this.a.setZoomTransitionDuration(i2);
    }

    @Override // e.l.q.c.t0.d.c
    public void setZoomable(boolean z) {
        this.a.setZoomable(z);
    }

    public void z() {
        d dVar = this.a;
        if (dVar != null) {
            dVar.n();
            this.a.A();
        }
    }

    public PhotoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // e.l.q.c.t0.d.c
    public void setScale(float f2, boolean z) {
        this.a.setScale(f2, z);
    }

    public PhotoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        init();
    }

    @Override // e.l.q.c.t0.d.c
    public void setScale(float f2, float f3, float f4, boolean z) {
        this.a.setScale(f2, f3, f4, z);
    }
}
